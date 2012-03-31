// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AddConcernActivity.java

package com.moji.mjweather.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.*;
import android.util.Xml;
import android.view.*;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.*;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.util.HttpUtil;
import com.moji.mjweather.util.UiUtil;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AddConcernActivity extends Activity {
	private class LifeInfo {

		String id;
		boolean isAttention;
		List mItemList;
		String name;

		String type;

	}

	private class WeatherLifeInfo {

		List lifeList;

	}

	private class ParseWeatherLife {

		private boolean parse(InputStream inputstream, boolean flag) {
			XmlPullParser xmlpullparser;
			int i = 0;
			LifeInfo lifeinfo;
			ArrayList arraylist;
			ArrayList arraylist1;
			boolean flag2;
			xmlpullparser = Xml.newPullParser();
			try {
				xmlpullparser.setInput(inputstream, "utf-8");
				i = xmlpullparser.getEventType();
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			lifeinfo = null;
			arraylist = new ArrayList();
			arraylist1 = null;
			flag2 = false;
			WeatherLifeInfo weatherlifeinfo = null;
			String s = null;
			if (!flag) {
				s = "ol";
			} else {

				s = "cl";
			}
			do {
				if (i == 1) {
					boolean flag1;
					if (weatherlifeinfo == null) {
						flag1 = false;
						MojiLog.d("AddConcernActivity",
								"\u89E3\u6790\u5931\u8D25~~");
					} else {
						if (flag)
							mOrderLifeInfo = weatherlifeinfo;
						else
							mEntryLifeInfo = weatherlifeinfo;
						flag1 = true;
						MojiLog.d("AddConcernActivity",
								"\u89E3\u6790\u6210\u529F~~");
					}
					return flag1;
				}

				String s1 = xmlpullparser.getName();
				if (!"cate".equals(s1)) {
					if (!"folder".equals(s1)) {
						if (!"item".equals(s1)) {
						} else {

							LifeInfo lifeinfo1;
							int j;
							lifeinfo1 = new LifeInfo();
							lifeinfo1.id = xmlpullparser.getAttributeValue(
									null, "id");
							lifeinfo1.name = xmlpullparser.getAttributeValue(
									null, "name");
							lifeinfo1.type = "content";
							j = 0;
						}
					} else

					{

						flag2 = true;
						lifeinfo = new LifeInfo();
						arraylist1 = new ArrayList();
						String s4 = xmlpullparser.getAttributeValue(null, "id");
						lifeinfo.id = s4;
						String s5 = xmlpullparser.getAttributeValue(null,
								"name");
						lifeinfo.name = s5;
						lifeinfo.type = "folder";

					}

					{
						lifeinfo = new LifeInfo();
						String s2 = xmlpullparser.getAttributeValue(null, "id");
						lifeinfo.id = s2;
						String s3 = xmlpullparser.getAttributeValue(null,
								"name");
						lifeinfo.name = s3;
						lifeinfo.type = "category";
						arraylist.add(lifeinfo);
					}

				}
			} while (true);

		}

	}

	private class DownloadThread extends Thread {

		public void doCancel() {
			mIsCancel = true;
		}

		public void run() {
			Looper.prepare();
			Handler handler = new Handler() {

				public void handleMessage(Message message) {
					boolean flag;
					flag = false;
					super.handleMessage(message);
					switch (message.what) {
					case 602:
						break;
					case 603:
						if (!mIsCancel && isXmlOK(true) && isXmlOK(flag))
							mMainHandler.sendMessage(mMainHandler
									.obtainMessage(604));
						else if (!mIsCancel)
							mMainHandler.sendMessage(mMainHandler
									.obtainMessage(605, Boolean.valueOf(flag)));
						break;
					case 604:
						return;
					case 605:
						return;
					case 606:
						int i;
						boolean flag1;
						i = message.arg1;
						int j = message.arg2;
						int k;
						LifeInfo lifeinfo1;
						if (j > -1) {
							flag1 = ((LifeInfo) ((LifeInfo) mEntryLifeInfo.lifeList
									.get(j)).mItemList.get(i)).isAttention;
							k = Integer
									.parseInt(((LifeInfo) ((LifeInfo) mEntryLifeInfo.lifeList
											.get(j)).mItemList.get(i)).id);
						} else {
							flag1 = ((LifeInfo) mEntryLifeInfo.lifeList.get(i)).isAttention;
							k = Integer
									.parseInt(((LifeInfo) mEntryLifeInfo.lifeList
											.get(i)).id);
						}
						if (mIsCancel || !sendAttention(flag1, k)) {
							if (!mIsCancel)
								mMainHandler.sendMessage(mMainHandler
										.obtainMessage(608,
												Boolean.valueOf(flag)));
							mClickable = true;
						} else {
							Gl.setLifeInfoDate(mCityID, "LifeOrder",
									"2000/01/01");
							if (j > -1) {
								lifeinfo1 = (LifeInfo) ((LifeInfo) mEntryLifeInfo.lifeList
										.get(j)).mItemList.get(i);
								if (!flag1)
									flag = true;
								lifeinfo1.isAttention = flag;
							} else {
								LifeInfo lifeinfo = (LifeInfo) mEntryLifeInfo.lifeList
										.get(i);
								if (!flag1)
									flag = true;
								lifeinfo.isAttention = flag;
							}
							mMainHandler
									.sendMessage(mMainHandler.obtainMessage(
											607, Boolean.valueOf(flag1)));
						}

						break;
					default:
						return;

					}

					Looper.myLooper().quit();

				}

			};
			if (mDownloadHandler == null) {
				mMainHandler.sendMessage(mMainHandler.obtainMessage(601,
						handler));
				Looper.loop();
			}
		}

		private boolean mIsCancel;
		private Handler mMainHandler;

		DownloadThread(Handler handler) {

			super("AddConcernActivity:DownloadThread");
			mMainHandler = handler;
			mIsCancel = false;
		}
	}

	private class WeatherLifeAdapter extends BaseAdapter {
		private class ConcernButtonListener implements
				android.view.View.OnClickListener {

			public void onClick(View view) {
				if (view.getId() == mIvForeard.getId() && mClickable) {
					mClickable = false;
					LinearLayout linearlayout = (LinearLayout) mLayoutInflater
							.inflate(0x7f030051, null);
					linearlayout.setBackgroundResource(0x7f080004);
					((TextView) linearlayout.findViewById(0x7f0d01e0))
							.setText(attStr);
					mProgressDialog = (new android.app.AlertDialog.Builder(
							AddConcernActivity.this.getApplicationContext()))
							.setView(linearlayout).create();
					mProgressDialog.show();
					mDownloadHandler.sendMessage(mDownloadHandler
							.obtainMessage(606, position, newPage, null));
				}
			}

			private String attStr;
			private boolean isAttention;
			private int newPage;
			private int position;

			public ConcernButtonListener(int i, int j) {

				super();
				position = i;
				newPage = j;
				String s;
				if (j > -1)
					isAttention = ((LifeInfo) ((LifeInfo) mEntryLifeInfo.lifeList
							.get(j)).mItemList.get(i)).isAttention;
				else
					isAttention = ((LifeInfo) mEntryLifeInfo.lifeList.get(i)).isAttention;
				if (isAttention)
					s = mCancleConcernLoading;
				else
					s = mAddConcernLoading;
				attStr = s;
			}
		}

		public int getCount() {
			return mTotalListLine;
		}

		public Object getItem(int i) {
			return Integer.valueOf(i);
		}

		public long getItemId(int i) {
			return (long) i;
		}

		public View getView(int i, View view, ViewGroup viewgroup) {
			String s;
			s = null;
			if (mNewPage == -1)
				s = ((LifeInfo) mEntryLifeInfo.lifeList.get(i)).type;
			if (mNewPage != -1 || s == null || !s.equals("category")) {
				TextView textview1;
				if (mNewPage != -1 || s == null || !s.equals("content")
						&& !s.equals("folder"))
					return null;
				mIsAttetion = ((LifeInfo) mEntryLifeInfo.lifeList.get(i)).isAttention;
				mRelativeLayout = (RelativeLayout) mLayoutInflater.inflate(
						0x7f030001, null);
				textview1 = (TextView) mRelativeLayout.findViewById(0x7f0d0002);
				mIvForeard = (ImageButton) mRelativeLayout
						.findViewById(0x7f0d0001);
				if (((LifeInfo) mEntryLifeInfo.lifeList.get(i)).mItemList == null) {

					mRelativeLayout.setBackgroundResource(0x7f0200e8);
					mIvForeard.setVisibility(0);
					ImageButton imagebutton1 = mIvForeard;
					int i1;
					String as1[];
					int j1;
					int k1;
					if (mIsAttetion)
						i1 = 0x7f02003a;
					else
						i1 = 0x7f020004;
					imagebutton1.setBackgroundResource(i1);
					as1 = mDdefaultID;
					j1 = as1.length;
					k1 = 0;
					do {

						{
							if (k1 < j1) {

								mIvForeard.setVisibility(8);
							}
							mIvForeard
									.setOnClickListener(new ConcernButtonListener(
											i, mNewPage));
						}
						if (true)
							break;
						k1++;
					} while (as1[k1].equals(((LifeInfo) mEntryLifeInfo.lifeList
							.get(i)).id));

				} else {
					mRelativeLayout.setBackgroundResource(0x7f020005);
					mIvForeard.setBackgroundResource(0x7f02011f);
				}
			}

			else {

				mRelativeLayout = (RelativeLayout) mLayoutInflater.inflate(
						0x7f030037, null);
				((TextView) mRelativeLayout.findViewById(0x7f0d00e7))
						.setText(((LifeInfo) mEntryLifeInfo.lifeList.get(i)).name);

			}
			return mRelativeLayout;

		}

		boolean mIsAttetion;
		ImageButton mIvForeard;
		LayoutInflater mLayoutInflater;
		RelativeLayout mRelativeLayout;

		public WeatherLifeAdapter() {

			super();
			mLayoutInflater = (LayoutInflater) getSystemService("layout_inflater");
		}
	}

	private class ItemClickListener implements
			android.widget.AdapterView.OnItemClickListener {

		public void onItemClick(AdapterView adapterview, View view, int i,
				long l) {
			if (mNewPage == -1
					&& ((LifeInfo) mEntryLifeInfo.lifeList.get(i)).mItemList != null) {
				mNewPage = i;
				mTotalListLine = ((LifeInfo) mEntryLifeInfo.lifeList
						.get(mNewPage)).mItemList.size();
				mHandler.sendMessage(mHandler.obtainMessage(609));
			}
		}

	}

	public AddConcernActivity() {
		mNewPage = -1;
		mClickable = true;
		String as[] = new String[5];
		as[0] = "1";
		as[1] = "4";
		as[2] = "5";
		as[3] = "20";
		as[4] = "21";
		mDdefaultID = as;
		mHandler = new Handler() {

			public void handleMessage(Message message) {
				super.handleMessage(message);
				switch (message.what) {
				case 601:
					mDownloadHandler = (Handler) message.obj;
					mDownloadHandler.sendMessage(mDownloadHandler
							.obtainMessage(603));
					break;
				case 602:
					return;
				case 603:
					return;
				case 604:
					mDataState = true;
					mWeatherLifeAdapter.notifyDataSetChanged();
					break;
				case 605:
					mDataState = true;
					if (((Boolean) message.obj).booleanValue())
						Toast.makeText(Gl.Ct(), 0x7f0b0018, 0).show();
					mEmptyText.setText(getResources().getString(0x7f0b021c));
					mWeatherLifeAdapter.notifyDataSetChanged();
					break;
				case 606:
					return;
				case 607:
					dismissDialog();
					String s1;
					if (((Boolean) message.obj).booleanValue())
						s1 = mCancleConcernOK;
					else
						s1 = mAddConcernOK;
					Toast.makeText(Gl.Ct(), s1, 0).show();
					mWeatherLifeAdapter.notifyDataSetChanged();
					break;
				case 608:
					dismissDialog();
					String s;
					if (((Boolean) message.obj).booleanValue())
						s = mCancleConcernFail;
					else
						s = mAddConcernFail;
					Toast.makeText(Gl.Ct(), s, 0).show();
					break;
				case 609:
					mListView.removeAllViewsInLayout();
					mWeatherLifeAdapter.notifyDataSetChanged();
					break;
				default:
					return;
				}

			}

		};
	}

	private void dismissDialog() {
		if (mProgressDialog != null)
			mProgressDialog.dismiss();
	}

	private String getMakeURL(int i) {
		return (new StringBuilder())
				.append("/weather/MakeContentOrder?UserID=")
				.append(Gl.getRegCode()).append("&Platform=Android")
				.append("&Device=phone").append("&Version=")
				.append(Gl.getVersion()).append("&BaseOSVer=")
				.append(android.os.Build.VERSION.SDK).append("&Model=")
				.append(URLEncoder.encode(Build.MODEL)).append("&PartnerKey=")
				.append(Gl.getPartnerID()).append("&CityID=").append(mCityID)
				.append("&ContentID=").append(i).append("&VersionType=")
				.append(Gl.getVersionType()).toString();
	}

	private String getRemoveURL(int i) {
		return (new StringBuilder())
				.append("/weather/RemoveContentOrder?UserID=")
				.append(Gl.getRegCode()).append("&Platform=Android")
				.append("&Device=phone").append("&Version=")
				.append(Gl.getVersion()).append("&BaseOSVer=")
				.append(android.os.Build.VERSION.SDK).append("&Model=")
				.append(URLEncoder.encode(Build.MODEL)).append("&PartnerKey=")
				.append(Gl.getPartnerID()).append("&CityID=").append(mCityID)
				.append("&ContentID=").append(i).append("&VersionType=")
				.append(Gl.getVersionType()).toString();
	}

	private void initLifeInfo() {
		mAddConcernOK = getResources().getString(0x7f0b027b);
		mAddConcernFail = getResources().getString(0x7f0b027c);
		mCancleConcernOK = getResources().getString(0x7f0b027d);
		mCancleConcernFail = getResources().getString(0x7f0b027e);
		mAddConcernLoading = getResources().getString(0x7f0b027f);
		mCancleConcernLoading = getResources().getString(0x7f0b0280);
		mCityID = getIntent().getExtras().getInt("bundle_key_city_id");
		mParseWeatherLife = new ParseWeatherLife();
		mDownloadThread = new DownloadThread(mHandler);
		mDownloadThread.start();
	}

	private void initListView() {
		mListView = (ListView) findViewById(0x7f0d0008);
		LinearLayout linearlayout = (LinearLayout) ((LayoutInflater) getSystemService("layout_inflater"))
				.inflate(0x7f030051, null);
		linearlayout.setBackgroundResource(0x7f080004);
		mEmptyText = (TextView) linearlayout.findViewById(0x7f0d01e0);
		mEmptyPro = (ProgressBar) linearlayout.findViewById(0x7f0d01df);
		mEmptyPro.setVisibility(8);
		linearlayout.startAnimation(AnimationUtils.loadAnimation(this,
				0x7f040008));
		((ViewGroup) mListView.getParent()).addView(linearlayout);
		mListView.setEmptyView(linearlayout);
		LayoutAnimationController layoutanimationcontroller = new LayoutAnimationController(
				AnimationUtils.loadAnimation(this, 0x7f040059), 1F);
		mListView.setLayoutAnimation(layoutanimationcontroller);
		mListView.setOnItemClickListener(new ItemClickListener());
		mWeatherLifeAdapter = new WeatherLifeAdapter();
		mListView.setAdapter(mWeatherLifeAdapter);
	}

	private boolean isXmlOK(boolean flag) {
		boolean flag1 = false;
		File file;
		FileInputStream fileinputstream;
		FileInputStream fileinputstream1;
		if (flag)
			file = new File((new StringBuilder()).append(Gl.Ct().getFilesDir())
					.append("/").append("LifeOrder").append("_")
					.append(mCityID).append(".xml").toString());
		else
			file = new File((new StringBuilder()).append(Gl.Ct().getFilesDir())
					.append("/").append("LifeEntry").append("_")
					.append(mCityID).append(".xml").toString());
		if (!file.exists())
			return false;
		MojiLog.d("AddConcernActivity",
				(new StringBuilder()).append("listFile:").append(file)
						.toString());
		fileinputstream = null;
		try {
			fileinputstream = new FileInputStream(file);

			if (mParseWeatherLife.parse(fileinputstream, flag)) {
				if (!flag)
					mTotalListLine = mEntryLifeInfo.lifeList.size();
				flag1 = true;
			} else {
				flag1 = false;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag1;

	}

	private void onBack() {
		if (mDownloadHandler == null)
			return;
		mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(602));
		if (mDownloadThread != null && mDownloadThread.isAlive()) {
			mDownloadThread.doCancel();
			mDownloadThread.interrupt();
		}

	}

	private boolean sendAttention(boolean flag, int i) {
		String s;

		String s1;
		boolean flag2 = false;
		if (flag)
			s = getRemoveURL(i);
		else
			s = getMakeURL(i);
		MojiLog.d("AddConcernActivity",
				(new StringBuilder()).append("sendAttention:c.moji001.com")
						.append(s).toString());
		try {
			s1 = (new BufferedReader(new InputStreamReader(HttpUtil.doGet(
					"c.moji001.com", s, 0L).mInputStream))).readLine();
			if (s1 == null)
				return false;
			flag2 = s1.equals("0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag2;
	}

	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		MojiLog.v("AddConcernActivity", "onCreate()");
		requestWindowFeature(1);
		setContentView(0x7f030002);
		((LinearLayout) findViewById(0x7f0d0004)).setBackgroundDrawable(UiUtil
				.getBgBitmapDrawable());
		initLifeInfo();
		initListView();
	}

	protected void onDestroy() {
		super.onDestroy();
		MojiLog.v("AddConcernActivity", "onDestroy");
		onBack();
	}

	public boolean onKeyDown(int i, KeyEvent keyevent) {
		boolean flag = true;
		if (i != 4)
			return super.onKeyDown(i, keyevent);

		if (mNewPage == -1) {
			if (!mDataState && mNewPage == -1) {
				onBack();
				mHandler.sendMessage(mHandler.obtainMessage(605,
						Boolean.valueOf(flag)));

			}
		}

		else {
			mNewPage = -1;
			mTotalListLine = mEntryLifeInfo.lifeList.size();
			mHandler.sendMessage(mHandler.obtainMessage(609));
		}
		return flag;

	}

	private static final int CONCERN_FIRST_APGE = -1;
	private static final int FOLDER_PAGE = 609;
	protected static final String KEY_VALUE_DEFAULT_DATE = "2000/01/01";
	private static final int LOAD_XML_FAIL = 605;
	private static final int LOAD_XML_OK = 604;
	private static final int NETWORK_HANDLER_BASE = 600;
	private static final int NETWORK_THREAD_OK = 601;
	private static final int NETWORK_THREAD_QUIT_LOOPER = 602;
	private static final int SATRT_LOAD_XML = 603;
	private static final int SEND_ATTENTION = 606;
	private static final int SEND_ATTENTION_FAIL = 608;
	private static final int SEND_ATTENTION_OK = 607;
	private static final String TAG = "AddConcernActivity";
	private static final String TAG_CATE = "cate";
	private static final String TAG_CATEGORY = "category";
	private static final String TAG_CL = "cl";
	private static final String TAG_CONTENT = "content";
	private static final String TAG_FOLDER = "folder";
	private static final String TAG_ID = "id";
	private static final String TAG_ITEM = "item";
	private static final String TAG_NAME = "name";
	private static final String TAG_OL = "ol";
	private String mAddConcernFail;
	private String mAddConcernLoading;
	private String mAddConcernOK;
	private String mCancleConcernFail;
	private String mCancleConcernLoading;
	private String mCancleConcernOK;
	private int mCityID;
	private boolean mClickable;
	private boolean mDataState;
	private String mDdefaultID[];
	private Handler mDownloadHandler;
	private DownloadThread mDownloadThread;
	private ProgressBar mEmptyPro;
	private TextView mEmptyText;
	private WeatherLifeInfo mEntryLifeInfo;
	Handler mHandler;
	private ListView mListView;
	private int mNewPage;
	private WeatherLifeInfo mOrderLifeInfo;
	private ParseWeatherLife mParseWeatherLife;
	private Dialog mProgressDialog;
	private int mTotalListLine;
	private WeatherLifeAdapter mWeatherLifeAdapter;

	/*
	 * static Handler access$002(AddConcernActivity addconcernactivity, Handler
	 * handler) { addconcernactivity.mDownloadHandler = handler; return handler;
	 * }
	 */

	/*
	 * static int access$1002(AddConcernActivity addconcernactivity, int i) {
	 * addconcernactivity.mNewPage = i; return i; }
	 */

	/*
	 * static boolean access$102(AddConcernActivity addconcernactivity, boolean
	 * flag) { addconcernactivity.mDataState = flag; return flag; }
	 */

	/*
	 * static WeatherLifeInfo access$1102(AddConcernActivity addconcernactivity,
	 * WeatherLifeInfo weatherlifeinfo) { addconcernactivity.mEntryLifeInfo =
	 * weatherlifeinfo; return weatherlifeinfo; }
	 */

	/*
	 * static int access$1202(AddConcernActivity addconcernactivity, int i) {
	 * addconcernactivity.mTotalListLine = i; return i; }
	 */

	/*
	 * static boolean access$1802(AddConcernActivity addconcernactivity, boolean
	 * flag) { addconcernactivity.mClickable = flag; return flag; }
	 */

	/*
	 * static Dialog access$1902(AddConcernActivity addconcernactivity, Dialog
	 * dialog) { addconcernactivity.mProgressDialog = dialog; return dialog; }
	 */

	/*
	 * static WeatherLifeInfo access$2802(AddConcernActivity addconcernactivity,
	 * WeatherLifeInfo weatherlifeinfo) { addconcernactivity.mOrderLifeInfo =
	 * weatherlifeinfo; return weatherlifeinfo; }
	 */

}
