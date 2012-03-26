// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AsyncNetworkThread.java

package com.moji.mjweather.util;

import android.content.Context;
import android.os.*;
import com.moji.mjweather.common.MojiLog;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.moji.mjweather.util:
//            AndroidHttpClient, Util, UrlUtil

public class AsyncNetworkThread extends Thread {
	private class HttpProxy {

		public void cancelOrRelease() {
			try {
				mHttpClient.close();
				MojiLog.d("AsyncNetworkThread", "cancelOrRelease");
			} catch (Exception e) {
				MojiLog.e("AsyncNetworkThread", "HttpClient close: ", e);
			}

		}

		public boolean doGet() {
			boolean flag = false;
			if (!Util.isConnectInternet(mContext))
				return false;
			BufferedReader bufferedreader;
			StringBuilder stringbuilder;
			HttpHost httphost = Util.GetAPNProxy();
			mHttpClient = AndroidHttpClient
					.newInstance("Apache-HttpClient/UNAVAILABLE (java 1.4)");
			mHttpClient.getParams().setParameter("http.connection.timeout",
					Integer.valueOf(30000));
			mHttpClient.getParams().setParameter("http.socket.timeout",
					Integer.valueOf(30000));
			bufferedreader = null;
			stringbuilder = new StringBuilder();
			try {
				if (Util.isUsingWap(mContext)) {
					stringbuilder.append(mUrl);
					mHttpClient.getParams().setParameter(
							"http.route.default-proxy", httphost);
					HttpResponse httpresponse = mHttpClient.execute(
							new HttpHost(mWebsite, 80, "http"), new HttpGet(
									stringbuilder.toString()));

					MojiLog.d("AsyncNetworkThread", (new StringBuilder())
							.append("url = ").append(stringbuilder.toString())
							.toString());
					MojiLog.d(
							"AsyncNetworkThread",
							(new StringBuilder())
									.append("response code = ")
									.append(httpresponse.getStatusLine()
											.getStatusCode()).toString());
					if (httpresponse.getStatusLine().getStatusCode() != 200) {

						try {
							if (bufferedreader != null)
								bufferedreader.close();
						} catch (IOException ioexception2) {
						}
						return flag;
					}

					java.io.InputStream inputstream = httpresponse.getEntity()
							.getContent();
					if (!mIsCheckNewVersion) {
						BufferedReader bufferedreader1 = new BufferedReader(
								new InputStreamReader(inputstream));

						do {
							String s = bufferedreader1.readLine();
							if (s == null)
								break;
							mResponse.add(s);
							MojiLog.d("AsyncNetworkThread",
									(new StringBuilder()).append("http get = ")
											.append(s).toString());
						} while (true);
						bufferedreader = bufferedreader1;
						setStatus(4);
						flag = true;

						bufferedreader = bufferedreader1;
					} else {
						mHashMap = Util.parseNewVersionOrPushInfo(inputstream);
					}
				} else {
					HttpResponse httpresponse;
					stringbuilder.append("http://").append(mWebsite)
							.append(mUrl);

					httpresponse = mHttpClient.execute(new HttpGet(
							stringbuilder.toString()));

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return flag;
		}

		public Map getHashMap() {
			return mHashMap;
		}

		/**
		 * @deprecated Method getStatus is deprecated
		 */

		public int getStatus() {

			return mStatus;

		}

		public void release() {
			if (mResponse != null) {
				mResponse.clear();
				mResponse = null;
			}
		}

		/**
		 * @deprecated Method setStatus is deprecated
		 */

		public void setStatus(int i) {
			this.mStatus = i;
		}

		private Map mHashMap;
		private AndroidHttpClient mHttpClient;
		private boolean mIsCheckNewVersion;
		private ArrayList mResponse;
		private int mStatus;
		private String mUrl;
		private String mWebsite;
 

		public HttpProxy(String s, boolean flag, String s1) {
			super();
			mStatus = 0;
			mWebsite = null;
			mUrl = s;
			mResponse = new ArrayList();
			mIsCheckNewVersion = flag;
			mWebsite = s1;
		}
	}

	public AsyncNetworkThread(Handler handler, Context context) {
		mWaitingCityIndex = 0;
		mMainThreadHandler = handler;
		mContext = context;
	}

	public Handler GetMsgQueueHandler() {
		return mWorkerThreadHandler;
	}

	public boolean cancelNetworkOperation() {
		if (mHttpProxy != null) {
			mHttpProxy.setStatus(3);
			mHttpProxy.cancelOrRelease();
		}
		return true;
	}

	public void run() {
		Looper.prepare();
		mWorkerThreadHandler = new Handler() {

			public void handleMessage(Message message) {
				if (message.what != 5000) {
					MojiLog.d("AsyncNetworkThread", (new StringBuilder())
							.append("handleMessage id = ").append(message.what)
							.append(", msg.arg2 = ").append(message.arg2)
							.toString());
					if (mHttpProxy != null)
						mHttpProxy.release();

					super.handleMessage(message);
					return;
				}

				String s1 = (String) message.obj;
				String s2 = "";
				String s3 = "";
				if (s1 != null) {
					s2 = s1.substring(0, s1.indexOf("$"));
					s3 = s1.substring(1 + s1.indexOf("$"), s1.length());
				}
				String s4 = (new StringBuilder())
						.append("/weather/SubmitSuggestion!submit.action?")
						.append(UrlUtil.getCommonPart()).append("&Content=")
						.append(URLEncoder.encode(s2)).append("&Contact=")
						.append(URLEncoder.encode(s3)).toString();
				mHttpProxy = new HttpProxy(s4, false, "proposal.moji001.com");
				mHttpProxy.setStatus(2);
				if (!mHttpProxy.doGet())
					if (mHttpProxy.getStatus() == 3)
						;
				if (mHttpProxy.getStatus() == 4)
					return;
				;

				String s = (new StringBuilder())
						.append("/weather/CheckUpdate.action?")
						.append(UrlUtil.getCommonPart()).toString();
				mHttpProxy = new HttpProxy(s, true, "update.moji001.com");
				mHttpProxy.setStatus(2);
				boolean flag = mHttpProxy.doGet();
				if (!flag && mHttpProxy.getStatus() != 3) {
					Message message2 = mMainThreadHandler.obtainMessage(107);
					message2.obj = mHttpProxy.getHashMap();
					message2.arg1 = mWaitingCityIndex;
					message2.arg2 = 4;
					mMainThreadHandler.sendMessage(message2);
				} else if (flag && mHttpProxy.getStatus() == 4) {
					Message message1 = mMainThreadHandler.obtainMessage(107);
					message1.arg1 = mWaitingCityIndex;
					message1.arg2 = 1;
					message1.obj = mHttpProxy.getHashMap();
					mMainThreadHandler.sendMessage(message1);
					mHttpProxy.cancelOrRelease();
					mHttpProxy.setStatus(1);
				}

				Looper.myLooper().quit();
				mWorkerThreadHandler = null;
				mMainThreadHandler = null;
				mContext = null;

			}

		};
		mMainThreadHandler.sendMessageDelayed(
				mMainThreadHandler.obtainMessage(1), 100L);
		Looper.loop();
		MojiLog.d("AsyncNetworkThread", "network thread is stop");
	}

	private static final int MSG_TYPE_NETWORK_THREAD_OWN_LOOP = 5000;
	private static final int ST_DOWNLOADING = 2;
	private static final int ST_DOWNLOADING_OK = 4;
	private static final int ST_INIT = 0;
	private static final int ST_NEED_CANCEL = 3;
	private static final int ST_WAITTING = 1;
	private static final String TAG = "AsyncNetworkThread";
	private Context mContext;
	private HttpProxy mHttpProxy;
	private Handler mMainThreadHandler;
	private int mWaitingCityIndex;
	private Handler mWorkerThreadHandler;

	/*
	 * static HttpProxy access$002(AsyncNetworkThread asyncnetworkthread,
	 * HttpProxy httpproxy) { asyncnetworkthread.mHttpProxy = httpproxy; return
	 * httpproxy; }
	 */

	/*
	 * static Handler access$102(AsyncNetworkThread asyncnetworkthread, Handler
	 * handler) { asyncnetworkthread.mMainThreadHandler = handler; return
	 * handler; }
	 */

	/*
	 * static Handler access$302(AsyncNetworkThread asyncnetworkthread, Handler
	 * handler) { asyncnetworkthread.mWorkerThreadHandler = handler; return
	 * handler; }
	 */

	/*
	 * static Context access$402(AsyncNetworkThread asyncnetworkthread, Context
	 * context) { asyncnetworkthread.mContext = context; return context; }
	 */
}
