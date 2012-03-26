// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DownloadManager.java

package com.moji.mjweather.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.*;
import com.moji.mjweather.common.MojiLog;
import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.moji.mjweather.util:
//            FileUtil, PlayerUtil, Util

public final class DownloadManager {
	private class DownloadThread extends Thread {

		private boolean checkCancel(String s) {
			boolean flag;
			if (getStateCancel()) {
				MojiLog.d("DownLoadManager.DownloadThread", s);
				FileUtil.delAllFile(mDownloadSavePath);
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		}

		private void deleteDownLoadFile() {
			FileUtil.delFile((new StringBuilder()).append(mDownloadSavePath)
					.append(mSaveName).toString());
		}

		private void downLoad() {
			if (checkCancel("canceled before downloading"))
				return;
			InputStream inputstream;
			FileOutputStream fileoutputstream;
			File file = new File(mDownloadSavePath);
			if (!file.exists())
				file.mkdirs();
			inputstream = null;
			fileoutputstream = null;
			mHttpClient = new DefaultHttpClient();
			mHttpClient.getParams().setParameter("http.connection.timeout",
					Integer.valueOf(30000));
			mHttpClient.getParams().setParameter("http.socket.timeout",
					Integer.valueOf(30000));
			if (!mIsUsingWap) {
				HttpResponse httpresponse1 = null;
				try {
					httpresponse1 = mHttpClient.execute(new HttpGet(
							(new StringBuilder()).append("http://")
									.append(mWebsite).append(mFileUrl)
									.toString()));
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int i = 0;
				i = httpresponse1.getStatusLine().getStatusCode();
				MojiLog.d("DownLoadManager.DownloadThread",
						(new StringBuilder()).append("statusCode = ").append(i)
								.toString());
				if (i != 200) {
					mHandler.sendMessage(mHandler.obtainMessage(5));

				} else {
					FileOutputStream fileoutputstream1;
					int j = Integer.parseInt(httpresponse1.getFirstHeader(
							"Content-Length").getValue());
					Message message = mHandler.obtainMessage(1);
					message.arg1 = 0;
					message.arg2 = j / 1024;
					mHandler.sendMessage(message);
					try {
						inputstream = httpresponse1.getEntity().getContent();
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fileoutputstream1 = new FileOutputStream(
								(new StringBuilder()).append(mDownloadSavePath)
										.append(mSaveName).toString());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					byte abyte0[];
					int k;
					abyte0 = new byte[8192];
					k = 0;
				}

			} else {
				HttpResponse httpresponse1;
				mHttpClient.getParams().setParameter(
						"http.route.default-proxy", Util.GetAPNProxy());
				try {
					httpresponse1 = mHttpClient.execute(new HttpHost(mWebsite,
							80, "http"), new HttpGet(mFileUrl));
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		/**
		 * @deprecated Method getStateCancel is deprecated
		 */

		private boolean getStateCancel() {

			boolean flag = mCanceled;

			return flag;

		}

		/**
		 * @deprecated Method setStateCancel is deprecated
		 */

		private void setStateCancel(boolean flag) {

			mCanceled = flag;

		}

		private void unZipFile() {

		}

		public void cancelDownload() {
			setStateCancel(true);
			if (mHttpClient != null)
				mHttpClient.getConnectionManager().shutdown();
		}

		public void run() {
			Looper.prepare();
			Handler handler = new Handler() {

				public void handleMessage(Message message1) {
					super.handleMessage(message1);
					MojiLog.d(
							"DownLoadManager.DownloadThread",
							(new StringBuilder()).append("msg = ")
									.append(message1.what).toString());

					Looper.myLooper().quit();

				}

			};
			Message message = mHandler.obtainMessage(0);
			message.obj = handler;
			mHandler.sendMessage(message);
			Looper.loop();
			MojiLog.v("DownLoadManager.DownloadThread",
					"download thread returns");
		}

		private static final String TAG = "DownLoadManager.DownloadThread";
		private boolean mCanceled;
		private HttpClient mHttpClient;

	}

	public DownloadManager(Context context, String s, String s1, String s2) {
		mDownloadSavePath = (new StringBuilder())
				.append(Environment.getExternalStorageDirectory().getPath())
				.append("/moji/tempdata/").toString();
		mHandler = new Handler() {

			public void handleMessage(Message message) {
				super.handleMessage(message);
				if (message.what != 1 && message.what != 3)
					MojiLog.d(
							"DownLoadManager",
							(new StringBuilder()).append("msg = ")
									.append(message.what).toString());

			}

		};
		mContext = context;
		mWebsite = s;
		mFileUrl = s1;
		mSaveName = s2;
	}

	private void cancelDownload() {
		if (mDownloadThread != null) {
			mDownloadThread.cancelDownload();
			closeDownloadThread();
		}
	}

	private void closeDownloadThread() {
		MojiLog.v("DownLoadManager", "closeDownloadThread");
		if (mDownloadThread != null) {
			mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(12));
			try {
				mDownloadThread.join(1000L);
			} catch (Exception exception) {
			}
			if (mDownloadThread.isAlive()) {
				MojiLog.d("DownLoadManager",
						"downLoadThread is still alive, kill it now");
				try {
					mDownloadThread.interrupt();
				} catch (Exception exception1) {
				}
				FileUtil.delAllFile(mDownloadSavePath);
			}
			mDownloadThread = null;
		}
	}

	private void generateVersionFile() {
		if (mFileUrl.equals("/download/tts_bg_music.zip")
				|| mFileUrl.equals("/download/tts_data_snda.zip"))
			FileUtil.newFile(PlayerUtil.TTS_DATA_VERSION_PATH, "20003");
	}

	private void showDownloadDialog(int i) {

		mDownloadDialog = new ProgressDialog(mContext);
		mDownloadDialog.setProgressStyle(1);
		mDownloadDialog.setTitle(0x7f0b002f);
		mDownloadDialog.setMessage(mContext.getResources()
				.getString(0x7f0b00b6));
		mDownloadDialog.setIndeterminate(false);
		mDownloadDialog.setCancelable(true);
		mDownloadDialog
				.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

					public void onCancel(DialogInterface dialoginterface) {
						cancelDownload();
					}

				});
		mDownloadDialog.setButton(
				mContext.getResources().getString(0x7f0b00af),
				new android.content.DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialoginterface, int j) {
						cancelDownload();
						dialoginterface.dismiss();
					}

				});
		mDownloadDialog.show();

		mDownloadDialog = new ProgressDialog(mContext);
		mDownloadDialog.setProgressStyle(0);
		mDownloadDialog.setTitle(0x7f0b01af);
		mDownloadDialog.setIndeterminate(false);
		mDownloadDialog.setCancelable(false);
		mDownloadDialog.show();

		(new android.app.AlertDialog.Builder(mContext))
				.setTitle(0x7f0b002f)
				.setIcon(0x7f0200c5)
				.setMessage(0x7f0b01b1)
				.setPositiveButton(0x7f0b0017,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int j) {
								dialoginterface.dismiss();
							}

						})
				.setOnCancelListener(
						new android.content.DialogInterface.OnCancelListener() {

							public void onCancel(DialogInterface dialoginterface) {
							}

						}).show();

		(new android.app.AlertDialog.Builder(mContext))
				.setTitle(0x7f0b002f)
				.setIcon(0x7f0200c5)
				.setMessage(0x7f0b01b2)
				.setPositiveButton(0x7f0b0017,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int j) {
								dialoginterface.dismiss();
							}

						}).show();

		(new android.app.AlertDialog.Builder(mContext))
				.setTitle(0x7f0b002f)
				.setIcon(0x7f0200c5)
				.setMessage(0x7f0b0169)
				.setPositiveButton(0x7f0b0017,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int j) {
								dialoginterface.dismiss();
							}

						})
				.setOnCancelListener(
						new android.content.DialogInterface.OnCancelListener() {

							public void onCancel(DialogInterface dialoginterface) {
								dialoginterface.dismiss();
							}

						}).show();

	}

	public void startDownLoad() {
		mIsUsingWap = Util.isUsingWap(mContext);
		if (!Environment.getExternalStorageState().equals("mounted")) {
			showDownloadDialog(5);
		} else {
			mDownloadThread = new DownloadThread();
			mDownloadThread.start();
		}
	}

	private static final int DIALOG_DOWNLOAD_PROGRESS = 1;
	private static final int DIALOG_INTERNET_ERROR = 3;
	private static final int DIALOG_NO_SDCARD = 5;
	private static final int DIALOG_UNZIP_ERROR = 4;
	private static final int DIALOG_UNZIP_PROGRESS = 2;
	private static final int DOWNLOAD_FINISHED = 2;
	private static final int DOWNLOAD_INTERNET_ERROR = 5;
	private static final int DOWNLOAD_START = 10;
	private static final int DOWNLOAD_THREAD_OK = 0;
	private static final int DOWNLOAD_THREAD_QUIT = 12;
	private static final int DOWNLOAD_UNZIP = 11;
	private static final int DOWNLOAD_UNZIP_ERROR = 6;
	private static final int DOWNLOAD_UNZIP_FINISHED = 4;
	private static final int DOWNLOAD_UPDATE_PROGRESS = 1;
	private static final int DOWNLOAD_UPDATE_UNZIP_PROGRESS = 3;
	private static final String TAG = "DownLoadManager";
	private Context mContext;
	private ProgressDialog mDownloadDialog;
	private Handler mDownloadHandler;
	private String mDownloadSavePath;
	private DownloadThread mDownloadThread;
	private String mFileUrl;
	private Handler mHandler;
	private boolean mIsUsingWap;
	private String mSaveName;
	private String mWebsite;

	/*
	 * static Handler access$002(DownloadManager downloadmanager, Handler
	 * handler) { downloadmanager.mDownloadHandler = handler; return handler; }
	 */

}
