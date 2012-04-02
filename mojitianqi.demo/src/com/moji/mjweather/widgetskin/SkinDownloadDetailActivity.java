// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SkinDownloadDetailActivity.java

package com.moji.mjweather.widgetskin;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.*;
import android.view.*;
import android.widget.*;

import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.util.*;
import java.io.*;
import java.util.List;

// Referenced classes of package com.moji.mjweather.widgetskin:
//            SkinSDInfo, SkinPullParser, ListScrollBar

public class SkinDownloadDetailActivity extends ListActivity {
	private class ButtonListener implements android.view.View.OnClickListener {

		public void onClick(View view) {
			mOldSkinDirName = Gl.getCurrentSkinDir();
			view.getId();

		}

	}

	/* member class not found */
	class DownloadRating {
	}

	/* member class not found */
	class DownloadImageThread {
	}

	/* member class not found */
	class GetMyCommentsThread {
	}

	/* member class not found */
	class SendCommentsThread {
	}

	/* member class not found */
	class CSkinDeleteThread {
	}

	/* member class not found */
	class RatingAdapter implements ListAdapter {

		@Override
		public void registerDataSetObserver(DataSetObserver observer) {
			// TODO Auto-generated method stub

		}

		@Override
		public void unregisterDataSetObserver(DataSetObserver observer) {
			// TODO Auto-generated method stub

		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean hasStableIds() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getItemViewType(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getViewTypeCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean areAllItemsEnabled() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isEnabled(int position) {
			// TODO Auto-generated method stub
			return false;
		}

		public void notifyDataSetChanged() {
			// TODO Auto-generated method stub

		}
	}

	public SkinDownloadDetailActivity() {
		m_eventHandler = new Handler() {

			public void handleMessage(Message message) {
				switch (message.what) {
				case 100:
					mProgressDialog = new ProgressDialog(
							SkinDownloadDetailActivity.this);
					mProgressDialog.setMessage((String) message.obj);
					mProgressDialog.setIndeterminate(true);
					mProgressDialog.setCancelable(false);
					mProgressDialog.show();
					break;
				case 101:
					if (mProgressDialog != null)
						mProgressDialog.dismiss();
					(new android.app.AlertDialog.Builder(
							SkinDownloadDetailActivity.this))
							.setCancelable(false).setIcon(0x7f0200c5)
							.setTitle(0x7f0b002f)
							.setMessage(getResources().getString(0x7f0b00b3))
							.create().show();
					break;
				case 102:
					if (mProgressDialog != null)
						mProgressDialog.dismiss();
					(new android.app.AlertDialog.Builder(
							SkinDownloadDetailActivity.this))
							.setCancelable(false).setIcon(0x7f0200c5)
							.setTitle(0x7f0b002f)
							.setMessage(getResources().getString(0x7f0b00b4))
							.create().show();
					break;
				case 103:
					(new android.app.AlertDialog.Builder(
							SkinDownloadDetailActivity.this))
							.setCancelable(false).setIcon(0x7f0200c5)
							.setTitle(0x7f0b002f)
							.setMessage((String) message.obj).create().show();
					break;
				case 104:

					Toast.makeText(SkinDownloadDetailActivity.this, 0x7f0b00ad,
							0).show();
					break;
				case 105:
					break;
				case 106:
					saveComments(
							(new StringBuilder()).append(mSaveRating)
									.append("|").append(mSaveComments)
									.toString(),
							(new StringBuilder()).append(mSkinDirPath)
									.append("/").append(mDirPathName)
									.append(".txt").toString());
					mCommentsRating = mSaveRating;
					mCommentsContent = mSaveComments;
					Toast.makeText(
							SkinDownloadDetailActivity.this,
							(new StringBuilder())
									.append(getResources()
											.getString(0x7f0b00c3))
									.append(message.obj).toString(), 1).show();
					if (message.arg1 == 0)
						mRatingAdapter.notifyDataSetChanged();
					break;
				case 107:
					break;
				case 108:
					if (mProgressDialog != null)
						mProgressDialog.dismiss();
					(new android.app.AlertDialog.Builder(
							SkinDownloadDetailActivity.this))
							.setCancelable(false).setIcon(0x7f0200c5)
							.setTitle(0x7f0b002f)
							.setMessage(getResources().getText(0x7f0b017e))
							.create().show();
					break;
				case 109:
					if (mProgressDialog != null)
						mProgressDialog.dismiss();
					(new android.app.AlertDialog.Builder(
							SkinDownloadDetailActivity.this))
							.setCancelable(false).setTitle(0x7f0b002f)
							.setMessage(0x7f0b01ad).create().show();
					break;
				case 110:
					if (mDirPathName.equals("ORG"))
						createResourceImageView(message.arg1);
					else
						createBitmapImageView(message.arg1,
								(String) message.obj);
					break;
				case 111:
					if ((String) message.obj != null
							&& !((String) message.obj).equals("")) {
						mSRating = (new StringBuilder())
								.append((String) message.obj)
								.append(getString(0x7f0b00c1)).toString();
						mRatingAdapter.notifyDataSetChanged();
					}
					break;
				default:
					return;

				}

			}

		};
		mMojiFilePath = SkinUtil.getMojiDir();
		mImgCachePath = (new StringBuilder()).append(SkinUtil.getSdCardDir())
				.append("/moji/imgCache").toString();
	}

	private void createBitmapImageView(int i, String s) {
		if (i == 1) {
			ImageView imageview = new ImageView(this);
			imageview.setPadding(0, 8, 0, 0);
			imageview.setImageBitmap(BitmapFactory.decodeFile(s));
			mImageLinearLayout.addView(imageview,
					new android.widget.LinearLayout.LayoutParams(
							(int) (0.9F * (float) mScreenWidth),
							(int) (0.33F * (0.9F * (float) mScreenWidth))));
		}
		if (i == 2) {
			ImageView imageview1 = new ImageView(this);
			imageview1.setPadding(0, 8, 0, 0);
			imageview1.setImageBitmap(BitmapFactory.decodeFile(s));
			mImageLinearLayout.addView(imageview1,
					new android.widget.LinearLayout.LayoutParams(
							(int) (0.9F * (float) mScreenWidth),
							(int) (0.67F * (0.9F * (float) mScreenWidth))));
		}
	}

	private void createResourceImageView(int i) {
		if (i == 1) {
			ImageView imageview = new ImageView(this);
			imageview.setPadding(0, 8, 0, 0);
			imageview.setImageResource(0x7f020058);
			mImageLinearLayout.addView(imageview,
					new android.widget.LinearLayout.LayoutParams(
							(int) (0.9F * (float) mScreenWidth),
							(int) (0.33F * (0.9F * (float) mScreenWidth))));
		}
		if (i == 2) {
			ImageView imageview1 = new ImageView(this);
			imageview1.setPadding(0, 8, 0, 0);
			imageview1.setImageResource(0x7f020059);
			mImageLinearLayout.addView(imageview1,
					new android.widget.LinearLayout.LayoutParams(
							(int) (0.9F * (float) mScreenWidth),
							(int) (0.67F * (0.9F * (float) mScreenWidth))));
		}
	}

	private void getSkinImage() {
		if (mSkinFilePack4x1 != null && mSkinFilePack4x1.exists()) {
			Message message5 = m_eventHandler.obtainMessage(108);
			message5.obj = mSavePackPath4X1;
			message5.arg1 = 1;
			m_eventHandler.sendMessage(message5);
		} else if (mSkinFile4x1 != null && mSkinFile4x1.exists()) {
			Message message4 = m_eventHandler.obtainMessage(108);
			message4.obj = mSavePath4X1;
			message4.arg1 = 1;
			m_eventHandler.sendMessage(message4);
		} else

		if (mSkinFilePack4x2 != null && mSkinFilePack4x2.exists()) {
			Message message3 = m_eventHandler.obtainMessage(108);
			message3.obj = mSavePackPath4X2;
			message3.arg1 = 2;
			m_eventHandler.sendMessage(message3);
		} else if (mSkinFile4x2 != null && mSkinFile4x2.exists()) {
			Message message2 = m_eventHandler.obtainMessage(108);
			message2.obj = mSavePath4X2;
			message2.arg1 = 2;
			m_eventHandler.sendMessage(message2);
		} else

		if (mDirPathName.equals("ORG")) {
			Message message = m_eventHandler.obtainMessage(108);
			message.arg1 = 1;
			m_eventHandler.sendMessage(message);
			Message message1 = m_eventHandler.obtainMessage(108);
			message1.arg1 = 2;
			m_eventHandler.sendMessage(message1);
		}
	}

	private boolean isSkinApk(String s) {
		return false;
	}

	private boolean parseCommentsText(String s, String s1) {
		boolean flag = false;
		File file = new File((new StringBuilder()).append(s).append("/")
				.append(s1).toString());
		if (!file.exists())
			return false;
		String s2 = null;
		FileInputStream fileinputstream;
		try {
			fileinputstream = new FileInputStream(file);
			BufferedReader bufferedreader = new BufferedReader(
					new InputStreamReader(fileinputstream));
			do {
				String s3 = bufferedreader.readLine();
				if (s3 == null)
					break;
				s2 = s3;
			} while (true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mCommentsRating = s2.substring(0, s2.indexOf("|"));
		mCommentsContent = s2.substring(1 + s2.indexOf("|"));
		flag = true;

		return flag;

	}

	private void saveComments(String s, String s1) {
		FileOutputStream fileoutputstream;
		try {
			fileoutputstream = new FileOutputStream(s1, false);
			OutputStreamWriter outputstreamwriter = new OutputStreamWriter(
					fileoutputstream, "utf-8");
			outputstreamwriter.write(s);
			outputstreamwriter.write("\n");
			outputstreamwriter.flush();
			outputstreamwriter.close();
			fileoutputstream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private List sendAndGetComments(String s) {
		List list = null;

		return list;

	}

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		MojiLog.v("SkinDownloadDetailActivity", "onCreate ");
		requestWindowFeature(1);
		ListView listview = getListView();
		listview.setBackgroundDrawable(UiUtil.getBgBitmapDrawable());
		mDirPathName = getIntent().getStringExtra("dirPathName");
		mOldSkinDirName = Gl.getCurrentSkinDir();
		Display display = getWindowManager().getDefaultDisplay();
		mScreenWidth = display.getWidth();
		mScreenHeight = display.getHeight();
		mLayoutInflater = (LayoutInflater) getSystemService("layout_inflater");
		LinearLayout linearlayout;
		if (mDirPathName.startsWith("ORGF")) {
			mSkinDirPath = new File((new StringBuilder())
					.append(SkinUtil.getInternalSkinDir(this)).append("/")
					.append(mDirPathName).toString());
			mSavePackPath4X1 = (new StringBuilder())
					.append(SkinUtil.getInternalSkinDir(this))
					.append(mDirPathName).append("/").append("skin4x1.jpg")
					.toString();
			mSavePackPath4X2 = (new StringBuilder())
					.append(SkinUtil.getInternalSkinDir(this))
					.append(mDirPathName).append("/").append("skin4x2.jpg")
					.toString();
		} else {
			mSkinDirPath = new File((new StringBuilder()).append(mMojiFilePath)
					.append(mDirPathName).toString());
			mSavePackPath4X1 = (new StringBuilder()).append(mMojiFilePath)
					.append("/").append(mDirPathName).append("/")
					.append("skin4x1.jpg").toString();
			mSavePackPath4X2 = (new StringBuilder()).append(mMojiFilePath)
					.append("/").append(mDirPathName).append("/")
					.append("skin4x2.jpg").toString();
		}
		mSRating = getString(0x7f0b01a8);

		if (!parseCommentsText(mSkinDirPath.toString(), (new StringBuilder())
				.append(mDirPathName).append(".txt").toString())
				&& mIsHaveSkinInfo) {
			Message message = m_eventHandler.obtainMessage(106);
			m_eventHandler.sendMessage(message);
		}
		linearlayout = (LinearLayout) mLayoutInflater.inflate(0x7f03001d, null);
		((ViewGroup) listview.getParent()).addView(linearlayout);
		listview.setEmptyView(linearlayout);
		listview.setDividerHeight(0);
		listview.setDivider(new BitmapDrawable(BitmapFactory.decodeResource(Gl
				.Ct().getResources(), 0x7f020126)));
		listview.setCacheColorHint(0);
		listview.setSelector(0x7f080004);
		mRatingAdapter = new RatingAdapter();
		listview.setAdapter(mRatingAdapter);
		return;
	}

	protected void onDestroy() {
		MojiLog.v("SkinDownloadDetailActivity", "onDestroy ");
		if (mSkinLogoBitmap != null && mSkinLogoBitmap.isRecycled()) {
			mSkinLogoBitmap.recycle();
			mSkinLogoBitmap = null;
		}

		super.onDestroy();
	}

	protected void onListItemClick(ListView listview, View view, int i, long l) {

	}

	protected void onStop() {
		MojiLog.v("SkinDownloadDetailActivity", "onStop ");
		System.gc();
		super.onStop();
		finish();
	}

	private static final String DEFAULT_PUBLISH_DATE = "2011-5-1";
	private static final int MSG_DIALOG_DEFAULT = 107;
	private static final int MSG_DIALOG_DELETE = 102;
	private static final int MSG_DIALOG_DELETE_CONFIRMATION = 104;
	private static final int MSG_DIALOG_DELETE_ERROR_USED = 103;
	private static final int MSG_DIALOG_PROGRESS_DIALOG = 100;
	private static final int MSG_DIALOG_SWITCH_OK = 101;
	private static final int MSG_GET_COMMENTS_MYSELF_RESULT = 111;
	private static final int MSG_GET_COMMENT_MYSELF = 106;
	private static final int MSG_GET_RATING = 109;
	private static final int MSG_HANDLER_BASE = 100;
	private static final int MSG_IMAGE_DOWNLOAD_OK = 108;
	private static final int MSG_SEND_COMMENT = 105;
	private static final int MSG_SEND_COMMENTS_RESULT = 110;
	private static final int SKIN4x1 = 1;
	private static final int SKIN4x2 = 2;
	private static final String TAG = "SkinDownloadDetailActivity";
	private String URLString;

	private String mCommentsContent;
	private String mCommentsRating;
	private String mDirPathName;
	private DownloadImageThread mDownloadImageThread4x1;
	private DownloadImageThread mDownloadImageThread4x2;
	private DownloadRating mDownloadRating;
	private GetMyCommentsThread mGetMyCommentsThread;
	private LinearLayout mImageLinearLayout;
	private String mImgCachePath;
	private boolean mIsHaveSkinInfo;
	private LayoutInflater mLayoutInflater;
	private String mMojiFilePath;
	private String mOldSkinDirName;
	private ProgressDialog mProgressDialog;
	private RatingAdapter mRatingAdapter;
	private String mSRating;
	private String mSaveComments;
	private String mSavePackPath4X1;
	private String mSavePackPath4X2;
	private String mSavePath4X1;
	private String mSavePath4X2;
	private String mSaveRating;
	private int mScreenHeight;
	private int mScreenWidth;
	private CSkinDeleteThread mSkinDeleteThread;
	private File mSkinDirPath;
	private File mSkinFile4x1;
	private File mSkinFile4x2;
	private File mSkinFilePack4x1;
	private File mSkinFilePack4x2;
	private Bitmap mSkinLogoBitmap;
	Handler m_eventHandler;

	/*
	 * static ProgressDialog access$002(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, ProgressDialog progressdialog) {
	 * skindownloaddetailactivity.mProgressDialog = progressdialog; return
	 * progressdialog; }
	 */

	/*
	 * static String access$1002(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, String s) {
	 * skindownloaddetailactivity.mCommentsContent = s; return s; }
	 */

	/*
	 * static String access$102(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, String s) {
	 * skindownloaddetailactivity.URLString = s; return s; }
	 */

	/*
	 * static String access$1202(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, String s) {
	 * skindownloaddetailactivity.mOldSkinDirName = s; return s; }
	 */

	/*
	 * static CSkinDeleteThread access$1302(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, CSkinDeleteThread cskindeletethread) {
	 * skindownloaddetailactivity.mSkinDeleteThread = cskindeletethread; return
	 * cskindeletethread; }
	 */

	/*
	 * static String access$1602(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, String s) {
	 * skindownloaddetailactivity.mSRating = s; return s; }
	 */

	/*
	 * static File access$1802(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, File file) {
	 * skindownloaddetailactivity.mSkinFile4x1 = file; return file; }
	 */

	/*
	 * static File access$2002(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, File file) {
	 * skindownloaddetailactivity.mSkinFile4x2 = file; return file; }
	 */

	/*
	 * static File access$2102(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, File file) {
	 * skindownloaddetailactivity.mSkinFilePack4x1 = file; return file; }
	 */

	/*
	 * static File access$2202(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, File file) {
	 * skindownloaddetailactivity.mSkinFilePack4x2 = file; return file; }
	 */

	/*
	 * static DownloadRating access$2802(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, DownloadRating downloadrating) {
	 * skindownloaddetailactivity.mDownloadRating = downloadrating; return
	 * downloadrating; }
	 */

	/*
	 * static Bitmap access$2902(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, Bitmap bitmap) {
	 * skindownloaddetailactivity.mSkinLogoBitmap = bitmap; return bitmap; }
	 */

	/*
	 * static LinearLayout access$3002(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, LinearLayout linearlayout) {
	 * skindownloaddetailactivity.mImageLinearLayout = linearlayout; return
	 * linearlayout; }
	 */

	/*
	 * static String access$302(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, String s) {
	 * skindownloaddetailactivity.mSaveRating = s; return s; }
	 */

	/*
	 * static String access$402(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, String s) {
	 * skindownloaddetailactivity.mSaveComments = s; return s; }
	 */

	/*
	 * static GetMyCommentsThread access$502(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, GetMyCommentsThread getmycommentsthread) {
	 * skindownloaddetailactivity.mGetMyCommentsThread = getmycommentsthread;
	 * return getmycommentsthread; }
	 */

	/*
	 * static String access$902(SkinDownloadDetailActivity
	 * skindownloaddetailactivity, String s) {
	 * skindownloaddetailactivity.mCommentsRating = s; return s; }
	 */
}
