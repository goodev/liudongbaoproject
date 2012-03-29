// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherIndexActivity.java

package com.moji.mjweather.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.*;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.*;
import android.view.animation.*;
import android.widget.*;
import com.moji.mjweather.CDialogManager;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.*;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.data.WeatherMainInfo;
import com.moji.mjweather.recommend.RecommendListActivity;
import com.moji.mjweather.util.*;
import com.moji.mjweather.view.CityWeatherBgSwitcher;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package com.moji.mjweather.activity:
//            AddConcernActivity, CityManagerActivity, WebViewActivity

public class WeatherIndexActivity extends Activity
    implements android.view.View.OnClickListener, android.view.GestureDetector.OnGestureListener, android.view.View.OnTouchListener
{
    private class LifeInfo
    {

        String category;
        String digest;
        String entry;
        String favorites;
        String icon;
        String id;
        String name;
        final WeatherIndexActivity this$0;
        String type;

        private LifeInfo()
        {
            this$0 = WeatherIndexActivity.this;
            super();
        }

    }

    private class WeatherLifeInfo
    {

        List lifeList;
        final WeatherIndexActivity this$0;

        private WeatherLifeInfo()
        {
            this$0 = WeatherIndexActivity.this;
            super();
        }

    }

    private class ParseWeatherLife
    {

        private boolean mergeXML()
        {
            List list = mOrderInfo.lifeList;
            List list1 = mEntryInfo.lifeList;
            int i = 0;
label0:
            do
            {
                if(i < list.size())
                {
                    int j = 0;
                    do
                    {
label1:
                        {
                            if(j < list1.size())
                            {
                                if(!((LifeInfo)list.get(i)).id.equals(((LifeInfo)list1.get(j)).id) || !((LifeInfo)list.get(i)).type.equals("content") || !((LifeInfo)list1.get(j)).type.equals("content"))
                                    break label1;
                                ((LifeInfo)mOrderInfo.lifeList.get(i)).name = ((LifeInfo)mEntryInfo.lifeList.get(j)).name;
                                ((LifeInfo)mOrderInfo.lifeList.get(i)).icon = ((LifeInfo)mEntryInfo.lifeList.get(j)).icon;
                                ((LifeInfo)mOrderInfo.lifeList.get(i)).digest = ((LifeInfo)mEntryInfo.lifeList.get(j)).digest;
                                ((LifeInfo)mOrderInfo.lifeList.get(i)).entry = ((LifeInfo)mEntryInfo.lifeList.get(j)).entry;
                            }
                            i++;
                            continue label0;
                        }
                        j++;
                    } while(true);
                }
                boolean flag;
                if(mOrderInfo != null && mEntryInfo != null)
                    flag = true;
                else
                    flag = false;
                return flag;
            } while(true);
        }

        private boolean parse(InputStream inputstream, boolean flag)
        {
            XmlPullParser xmlpullparser;
            int i;
            LifeInfo lifeinfo;
            ArrayList arraylist;
            WeatherLifeInfo weatherlifeinfo;
            String s;
            String s1;
            xmlpullparser = Xml.newPullParser();
            xmlpullparser.setInput(inputstream, "utf-8");
            i = xmlpullparser.getEventType();
            lifeinfo = null;
            arraylist = new ArrayList();
            weatherlifeinfo = null;
            s = "";
            if(!flag)
                break MISSING_BLOCK_LABEL_464;
            s1 = "cl";
_L6:
            if(i == 1) goto _L2; else goto _L1
_L1:
            String s2 = xmlpullparser.getName();
            i;
            JVM INSTR tableswitch 0 3: default 100
        //                       0 100
        //                       1 100
        //                       2 112
        //                       3 351;
               goto _L3 _L3 _L3 _L4 _L5
_L3:
            i = xmlpullparser.next();
              goto _L6
_L4:
            if(s1.equals(s2))
                weatherlifeinfo = new WeatherLifeInfo();
            else
            if("cate".equals(s2))
            {
                lifeinfo = new LifeInfo();
                lifeinfo.id = xmlpullparser.getAttributeValue(null, "id");
                lifeinfo.name = xmlpullparser.getAttributeValue(null, "name");
                lifeinfo.type = "category";
                s = lifeinfo.name;
                arraylist.add(lifeinfo);
            } else
            if("item".equals(s2))
            {
                lifeinfo = new LifeInfo();
                lifeinfo.id = xmlpullparser.getAttributeValue(null, "id");
                lifeinfo.name = xmlpullparser.getAttributeValue(null, "name");
                lifeinfo.icon = xmlpullparser.getAttributeValue(null, "icon");
                lifeinfo.type = "content";
                lifeinfo.digest = xmlpullparser.getAttributeValue(null, "digest");
                lifeinfo.entry = xmlpullparser.getAttributeValue(null, "entry");
                lifeinfo.favorites = xmlpullparser.getAttributeValue(null, "favorites");
                lifeinfo.category = s;
            }
              goto _L3
_L5:
            if(s1.equals(s2))
                weatherlifeinfo.lifeList = arraylist;
            else
            if(!"cate".equals(s2) && "item".equals(s2))
                arraylist.add(lifeinfo);
              goto _L3
_L2:
            boolean flag1;
            if(weatherlifeinfo == null)
            {
                flag1 = false;
                MojiLog.d("WeatherIndexActivity", "\u89E3\u6790\u5931\u8D25~~");
            } else
            {
                if(flag)
                    mOrderInfo = weatherlifeinfo;
                else
                    mEntryInfo = weatherlifeinfo;
                flag1 = true;
                MojiLog.d("WeatherIndexActivity", "\u89E3\u6790\u6210\u529F~~");
            }
            break MISSING_BLOCK_LABEL_475;
            s1 = "ol";
              goto _L6
            Exception exception;
            exception;
            flag1 = false;
            return flag1;
        }

        final WeatherIndexActivity this$0;



        private ParseWeatherLife()
        {
            this$0 = WeatherIndexActivity.this;
            super();
        }

    }

    private class DownloadThread extends Thread
    {

        public void doCancel()
        {
            isCancel = true;
        }

        public void run()
        {
            Looper.prepare();
            Handler handler = new Handler() {

                public void handleMessage(Message message)
                {
                    super.handleMessage(message);
                    message.what;
                    JVM INSTR tableswitch 502 510: default 60
                //                               502 500
                //                               503 61
                //                               504 60
                //                               505 60
                //                               506 153
                //                               507 60
                //                               508 60
                //                               509 60
                //                               510 233;
                       goto _L1 _L2 _L3 _L1 _L1 _L4 _L1 _L1 _L1 _L5
_L1:
                    return;
_L3:
                    if(!isCancel && isXmlOK(true) && isXmlOK(false))
                        mainHandler.sendMessage(mainHandler.obtainMessage(504));
                    else
                        mainHandler.sendMessage(mainHandler.obtainMessage(505));
                    continue; /* Loop/switch isn't completed */
_L4:
                    if(!isCancel && mParseWeatherLife.mergeXML())
                        mainHandler.sendMessage(mainHandler.obtainMessage(507));
                    else
                        mainHandler.sendMessage(mainHandler.obtainMessage(508));
                    continue; /* Loop/switch isn't completed */
_L5:
                    mPreviewFile = (new StringBuilder()).append(message.arg1).append("lifePreview.jpg").toString();
                    File file = new File((new StringBuilder()).append(mPreviewPath).append(mPreviewFile).toString());
                    if(isDownloadIMG() && FileUtil.delAllFile(mPreviewPath) && download((String)message.obj, mPreviewPath, mPreviewFile, _fld0))
                    {
                        Gl.setLifeImgDate(WeatherIndexActivity.getCurrentDate());
                        mainHandler.sendMessage(mainHandler.obtainMessage(511));
                    } else
                    if(!file.exists() && download((String)message.obj, mPreviewPath, mPreviewFile, _fld0))
                        mainHandler.sendMessage(mainHandler.obtainMessage(511));
                    continue; /* Loop/switch isn't completed */
_L2:
                    Looper.myLooper().quit();
                    if(true) goto _L1; else goto _L6
_L6:
                }

                final DownloadThread this$1;

                
                {
                    this$1 = DownloadThread.this;
                    super();
                }
            }
;
            if(mDownloadHandler == null)
            {
                mainHandler.sendMessage(mainHandler.obtainMessage(501, handler));
                Looper.loop();
            }
        }

        private boolean isCancel;
        Handler mainHandler;
        final WeatherIndexActivity this$0;


        DownloadThread(Handler handler)
        {
            this$0 = WeatherIndexActivity.this;
            super("WeatherIndexActivity:DownloadThread");
            mainHandler = handler;
            isCancel = false;
        }
    }

    private class WeatherLifeAdapter extends BaseAdapter
    {

        public int getCount()
        {
            return mTotalListLine;
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            String s = "";
            ImageView imageview;
            TextView textview;
            TextView textview1;
            TextView textview2;
            ImageView imageview1;
            File file;
            try
            {
                s = ((LifeInfo)mOrderInfo.lifeList.get(i)).type;
            }
            catch(Exception exception) { }
            if(s == null || !s.equals("category")) goto _L2; else goto _L1
_L1:
            relativeLayout = (RelativeLayout)mLayoutInflater.inflate(0x7f030037, null);
            ((TextView)relativeLayout.findViewById(0x7f0d00e7)).setText(((LifeInfo)mOrderInfo.lifeList.get(i)).name);
_L4:
            return relativeLayout;
_L2:
            if(s != null && s.equals("content"))
            {
                relativeLayout = (RelativeLayout)mLayoutInflater.inflate(0x7f030036, null);
                imageview = (ImageView)relativeLayout.findViewById(0x7f0d00e2);
                textview = (TextView)relativeLayout.findViewById(0x7f0d0002);
                textview1 = (TextView)relativeLayout.findViewById(0x7f0d00e3);
                textview2 = (TextView)relativeLayout.findViewById(0x7f0d00e6);
                imageview1 = (ImageView)relativeLayout.findViewById(0x7f0d00e5);
                try
                {
                    file = new File((new StringBuilder()).append(mPreviewPath).append(((LifeInfo)mOrderInfo.lifeList.get(i)).id).append("lifePreview.jpg").toString());
                    if(file.exists())
                    {
                        imageview.setImageBitmap(BitmapFactory.decodeFile(file.toString()));
                        MojiLog.d("WeatherIndexActivity", (new StringBuilder()).append("imgFile:").append(file.toString()).toString());
                    } else
                    {
                        imageview.setImageResource(0x7f0200c6);
                    }
                    if(((LifeInfo)mOrderInfo.lifeList.get(i)).id.equals("20"))
                    {
                        textview2.setVisibility(8);
                        imageview1.setVisibility(8);
                    } else
                    {
                        textview2.setVisibility(0);
                        imageview1.setVisibility(0);
                    }
                    textview.setText(((LifeInfo)mOrderInfo.lifeList.get(i)).name);
                    textview1.setText(((LifeInfo)mOrderInfo.lifeList.get(i)).digest);
                    textview2.setText(((LifeInfo)mOrderInfo.lifeList.get(i)).favorites);
                    mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(510, Integer.parseInt(((LifeInfo)mOrderInfo.lifeList.get(i)).id), 0, ((LifeInfo)mOrderInfo.lifeList.get(i)).icon));
                }
                catch(Exception exception1) { }
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        LayoutInflater mLayoutInflater;
        RelativeLayout relativeLayout;
        final WeatherIndexActivity this$0;

        public WeatherLifeAdapter()
        {
            this$0 = WeatherIndexActivity.this;
            super();
            mLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
        }
    }

    private class UpdateCallbackImpl
        implements WeatherSubscriber
    {

        public void doCallback(com.moji.mjweather.common.WeatherUpdater.Result result)
        {
            mHandler.sendMessage(mHandler.obtainMessage(512, result));
        }

        final WeatherIndexActivity this$0;

        private UpdateCallbackImpl()
        {
            this$0 = WeatherIndexActivity.this;
            super();
        }

    }

    private class ItemClickListener
        implements android.widget.AdapterView.OnItemClickListener
    {

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            try
            {
                LifeInfo lifeinfo = (LifeInfo)mOrderInfo.lifeList.get(i);
                if(lifeinfo != null)
                    if(lifeinfo.type.equals("content") && lifeinfo.entry != null && lifeinfo.entry.contains("http://"))
                    {
                        String s = lifeinfo.entry.replace("${CityID}", String.valueOf(mCityID));
                        MojiLog.d("WeatherIndexActivity", s);
                        Intent intent1 = new Intent(WeatherIndexActivity.this, com/moji/mjweather/activity/WebViewActivity);
                        Bundle bundle = new Bundle();
                        bundle.putString("bundle_key_category", ((LifeInfo)mOrderInfo.lifeList.get(i)).category);
                        bundle.putString("bundle_key_name", ((LifeInfo)mOrderInfo.lifeList.get(i)).name);
                        bundle.putString("bundle_key_entry", s);
                        bundle.putString("bundle_key_digest", ((LifeInfo)mOrderInfo.lifeList.get(i)).digest);
                        bundle.putInt("bundle_key_id", Integer.parseInt(((LifeInfo)mOrderInfo.lifeList.get(i)).id));
                        bundle.putInt("bundle_key_city_id", mCityID);
                        intent1.putExtras(bundle);
                        startActivityForResult(intent1, 515);
                    } else
                    if(lifeinfo.type.equals("content") && lifeinfo.entry != null && lifeinfo.entry.contains("moji://"))
                    {
                        Intent intent = new Intent(WeatherIndexActivity.this, com/moji/mjweather/recommend/RecommendListActivity);
                        intent.putExtra("place", 2);
                        startActivity(intent);
                    }
            }
            catch(Exception exception) { }
        }

        final WeatherIndexActivity this$0;

        private ItemClickListener()
        {
            this$0 = WeatherIndexActivity.this;
            super();
        }

    }


    public WeatherIndexActivity()
    {
        mHandler = new Handler() {

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                message.what;
                JVM INSTR tableswitch 501 512: default 72
            //                           501 73
            //                           502 72
            //                           503 72
            //                           504 124
            //                           505 151
            //                           506 72
            //                           507 161
            //                           508 282
            //                           509 292
            //                           510 72
            //                           511 406
            //                           512 302;
                   goto _L1 _L2 _L1 _L1 _L3 _L4 _L1 _L5 _L6 _L7 _L1 _L8 _L9
_L1:
                return;
_L2:
                mNotUpdating = true;
                mDownloadHandler = (Handler)message.obj;
                mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(503));
                continue; /* Loop/switch isn't completed */
_L3:
                mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(506));
                continue; /* Loop/switch isn't completed */
_L4:
                setFailState();
                continue; /* Loop/switch isn't completed */
_L5:
                dismissDialog();
                if(mOrderInfo != null && mOrderInfo.lifeList != null)
                    mTotalListLine = mOrderInfo.lifeList.size();
                if(mOrderInfo != null && mOrderInfo.lifeList != null)
                    mTotalListLine = mOrderInfo.lifeList.size();
                mWeatherLifeAdapter.notifyDataSetChanged();
                mNotUpdating = false;
                continue; /* Loop/switch isn't completed */
_L6:
                setFailState();
                continue; /* Loop/switch isn't completed */
_L7:
                setFailState();
                continue; /* Loop/switch isn't completed */
_L9:
                if(AbstractWeatherUpdater.isSucceed((com.moji.mjweather.common.WeatherUpdater.Result)message.obj))
                {
                    mCityID = WeatherData.getCityInfo(mCurrentCityIndex).mWeatherMainInfo.mCityId;
                    initLifeData();
                }
                if(mDownloadHandler != null)
                    mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(503));
                if(mUpdateCallbackImpl != null)
                    WeatherPublisher.getInstance().unSubscribe(mUpdateCallbackImpl);
                continue; /* Loop/switch isn't completed */
_L8:
                if(mDownloadHandler != null)
                    mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(503));
                if(true) goto _L1; else goto _L10
_L10:
            }

            final WeatherIndexActivity this$0;

            
            {
                this$0 = WeatherIndexActivity.this;
                super();
            }
        }
;
    }

    private void clearList()
    {
        if(mOrderInfo != null && mOrderInfo.lifeList != null)
        {
            mOrderInfo.lifeList.clear();
            mEntryInfo.lifeList.clear();
        }
        mTotalListLine = 0;
    }

    public static int dip2px(float f)
    {
        return (int)(0.5F + f * Gl.Ct().getResources().getDisplayMetrics().density);
    }

    private void dismissDialog()
    {
        if(mProgressDialog != null)
            mProgressDialog.dismiss();
    }

    private boolean download(String s, String s1, String s2, Context context)
    {
        String s3;
        String s4;
        s3 = "";
        s4 = "";
        if(s == null) goto _L2; else goto _L1
_L1:
        URL url = new URL(s);
        String s5;
        s3 = url.getHost();
        s5 = url.getPath();
        s4 = s5;
_L3:
        boolean flag;
        MojiLog.d("WeatherIndexActivity", (new StringBuilder()).append("getHost:").append(s3).append(" **getPath:").append(s4).toString());
        flag = SkinUtil.download(context, s3, s4, s1, SkinUtil.getImgNotDeleteCacheDir(), s2);
_L4:
        return flag;
        MalformedURLException malformedurlexception;
        malformedurlexception;
_L5:
        malformedurlexception.printStackTrace();
          goto _L3
_L2:
        flag = false;
          goto _L4
        malformedurlexception;
          goto _L5
    }

    protected static String getCurrentDate()
    {
        return (new SimpleDateFormat("yyyy/MM/dd")).format(new Date());
    }

    private String getUrlEntry()
    {
        return (new StringBuilder()).append("/data/xml/content/entrylist/100/ContentEntryList_").append(mCityID).append(".xml?").append("UserID=").append(Gl.getRegCode()).append("&Platform=Android").append("&Device=phone").append("&Version=").append(Gl.getVersion()).append("&BaseOSVer=").append(android.os.Build.VERSION.SDK).append("&Model=").append(URLEncoder.encode(Build.MODEL)).append("&PartnerID=").append(Gl.getPartnerID()).append("&CityID=").append(mCityID).append("&DV=").append(100).append("&VersionType=").append(Gl.getVersionType()).toString();
    }

    private String getUrlOrder()
    {
        return (new StringBuilder()).append("/weather/GetContentOrderListByUser?UserID=").append(Gl.getRegCode()).append("&Platform=Android").append("&Device=phone").append("&Version=").append(Gl.getVersion()).append("&BaseOSVer=").append(android.os.Build.VERSION.SDK).append("&Model=").append(URLEncoder.encode(Build.MODEL)).append("&PartnerKey=").append(Gl.getPartnerID()).append("&CityID=").append(mCityID).append("&DV=").append(100).append("&VersionType=").append(Gl.getVersionType()).toString();
    }

    private void initLifeData()
    {
        MojiLog.d("WeatherIndexActivity", "initLifeData()");
        mCurrentCityIndex = Gl.getCurrentCityIndex();
        CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(mCurrentCityIndex);
        mTvLifeCityName.setText(cityweatherinfo.mCityName);
        mTvLifeDate.setText((new SimpleDateFormat("MM-dd EEE")).format(new Date()));
        if(cityweatherinfo.mWeatherMainInfo.mCityId > 0)
            mCityID = cityweatherinfo.mWeatherMainInfo.mCityId;
        else
            mCityID = cityweatherinfo.m_cityID;
        mCityWeatherBgSwitcher.setBgImageFromTrend(cityweatherinfo.mWeatherMainInfo.mWeatherId);
    }

    private void initLifeInfo()
    {
        MojiLog.d("WeatherIndexActivity", "initLifeInfo()");
        mTvLifeCityName = (TextView)findViewById(0x7f0d00f2);
        mTvLifeDate = (TextView)findViewById(0x7f0d00f3);
        mIvCityManagerImg = (ImageView)findViewById(0x7f0d00ee);
        mIvIndexADDImg = (ImageView)findViewById(0x7f0d00f0);
        mIvCityManagerImg.setOnClickListener(this);
        mIvIndexADDImg.setOnClickListener(this);
        mParseWeatherLife = new ParseWeatherLife();
        new CDialogManager(this, null);
        mPreviewPath = SkinUtil.getLifeImgCacheDir();
        File file = new File(mPreviewPath);
        if(!file.exists())
            file.mkdirs();
    }

    private void initListView()
    {
        MojiLog.d("WeatherIndexActivity", "initListView()");
        mListView = (ListView)findViewById(0x7f0d00f5);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030051, null);
        mEmptyText = (TextView)linearlayout.findViewById(0x7f0d01e0);
        mEmptyPro = (ProgressBar)linearlayout.findViewById(0x7f0d01df);
        mAnim = AnimationUtils.loadAnimation(this, 0x7f040008);
        linearlayout.startAnimation(mAnim);
        ((ViewGroup)mListView.getParent()).addView(linearlayout);
        mListView.setEmptyView(linearlayout);
        LayoutAnimationController layoutanimationcontroller = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 0x7f040059), 1F);
        mListView.setLayoutAnimation(layoutanimationcontroller);
        mListView.setOnItemClickListener(new ItemClickListener());
        mWeatherLifeAdapter = new WeatherLifeAdapter();
    }

    private boolean isDownloadIMG()
    {
        boolean flag = false;
        long l;
        long l1;
        MojiLog.d("WeatherIndexActivity", (new StringBuilder()).append("IMG====").append(getCurrentDate()).append("--").append(Gl.getLifeImgDate()).toString());
        l = Date.parse(getCurrentDate());
        l1 = Date.parse(Gl.getLifeImgDate());
        if(l > l1 + 5L * 0x5265c00L)
            flag = true;
_L2:
        return flag;
        Exception exception;
        exception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private boolean isDownloadXML(String s)
    {
        boolean flag = false;
        long l;
        long l1;
        MojiLog.d("WeatherIndexActivity", (new StringBuilder()).append("cityID:").append(mCityID).append("---").append(getCurrentDate()).append("--").append(Gl.getLifeInfoDate(mCityID, s)).toString());
        l = Date.parse(getCurrentDate());
        l1 = Date.parse(Gl.getLifeInfoDate(mCityID, s));
        if(l > l1)
            flag = true;
_L2:
        return flag;
        Exception exception;
        exception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private boolean isXmlOK(boolean flag)
    {
        String s1;
        boolean flag1;
        String s = null;
        s1 = "";
        String s2 = null;
        String s3 = null;
        File file1;
        FileInputStream fileinputstream2;
        FileInputStream fileinputstream3;
        if(flag && mCityID > 0)
        {
            s = "c.moji001.com";
            s1 = (new StringBuilder()).append(Gl.Ct().getFilesDir()).append("/").append("LifeOrder").append("_").append(mCityID).append(".xml").toString();
            s2 = getUrlOrder();
            s3 = "LifeOrder";
        } else
        if(mCityID > 0)
        {
            s = "cdn.moji002.com";
            s1 = (new StringBuilder()).append(Gl.Ct().getFilesDir()).append("/").append("LifeEntry").append("_").append(mCityID).append(".xml").toString();
            s2 = getUrlEntry();
            s3 = "LifeEntry";
        }
        if(mCityID <= 0 || !isDownloadXML(s3) || !FileUtil.delFile(s1) || !SkinUtil.download(Gl.Ct(), s, s2, s1)) goto _L2; else goto _L1
_L1:
        file1 = new File(s1);
        if(!file1.exists()) goto _L4; else goto _L3
_L3:
        MojiLog.d("WeatherIndexActivity", (new StringBuilder()).append("listFilePath:OK").append(file1).toString());
        fileinputstream2 = null;
        fileinputstream3 = new FileInputStream(file1);
        fileinputstream2 = fileinputstream3;
_L5:
        FileNotFoundException filenotfoundexception1;
        if(mParseWeatherLife.parse(fileinputstream2, flag))
        {
            Gl.setLifeInfoDate(mCityID, s3, getCurrentDate());
            flag1 = true;
        } else
        {
            flag1 = false;
        }
_L6:
        return flag1;
        filenotfoundexception1;
        filenotfoundexception1.printStackTrace();
          goto _L5
_L4:
        flag1 = false;
          goto _L6
_L2:
        File file;
        FileInputStream fileinputstream;
        file = new File(s1);
        if(!file.exists())
            break MISSING_BLOCK_LABEL_415;
        MojiLog.d("WeatherIndexActivity", (new StringBuilder()).append("listFilePath:FAIL").append(file).toString());
        fileinputstream = null;
        FileInputStream fileinputstream1 = new FileInputStream(file);
        fileinputstream = fileinputstream1;
_L7:
        FileNotFoundException filenotfoundexception;
        if(mParseWeatherLife.parse(fileinputstream, flag))
            flag1 = true;
        else
            flag1 = false;
          goto _L6
        filenotfoundexception;
        filenotfoundexception.printStackTrace();
          goto _L7
        flag1 = false;
          goto _L6
    }

    private void onBack()
    {
        if(mDownloadHandler == null)
            break MISSING_BLOCK_LABEL_56;
        mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(502));
        if(mDownloadThread != null && mDownloadThread.isAlive())
        {
            mDownloadThread.doCancel();
            mDownloadThread.interrupt();
        }
_L1:
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L1
    }

    private void setFailState()
    {
        dismissDialog();
        mEmptyPro.setVisibility(8);
        mEmptyText.setText(getResources().getString(0x7f0b021c));
        mWeatherLifeAdapter.notifyDataSetChanged();
        mNotUpdating = false;
    }

    private void showProDialog()
    {
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030051, null);
        linearlayout.setBackgroundResource(0x7f080004);
        mProgressDialog = (new android.app.AlertDialog.Builder(this)).setView(linearlayout).create();
        mProgressDialog.show();
    }

    private void updateCityInfo(String s)
    {
        int i = 0;
        boolean flag = false;
        String s1 = "";
        CityWeatherInfo cityweatherinfo = null;
        if(s.equals("left"))
        {
            i = 1 + mCurrentCityIndex;
            if(i < 9)
                flag = true;
            else
                flag = false;
            cityweatherinfo = WeatherData.getCityInfo(i);
            s1 = getResources().getString(0x7f0b003c);
        } else
        if(s.equals("right"))
        {
            i = -1 + mCurrentCityIndex;
            if(i >= 0)
                flag = true;
            else
                flag = false;
            cityweatherinfo = WeatherData.getCityInfo(i);
            s1 = getResources().getString(0x7f0b003b);
        }
        if(cityweatherinfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE && flag)
        {
            mCurrentCityIndex = i;
            Gl.saveCurrentCityIndex(mCurrentCityIndex);
            showProDialog();
            initLifeData();
            clearList();
            updateWeather(i);
        } else
        if(cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET && flag)
        {
            mCurrentCityIndex = i;
            Gl.saveCurrentCityIndex(mCurrentCityIndex);
            initLifeData();
            if(mDownloadHandler != null)
                mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(503));
        } else
        {
            Toast.makeText(this, s1, 0).show();
        }
    }

    private void updateWeather(int i)
    {
        if(mUpdateCallbackImpl == null)
            mUpdateCallbackImpl = new UpdateCallbackImpl();
        WeatherPublisher.getInstance().subscribe(mUpdateCallbackImpl);
        WeatherData.getCityInfo(i).mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING;
        if(mWeatherUpdater == null)
            mWeatherUpdater = AbstractWeatherUpdater.createInstance();
        mWeatherUpdater.update(i);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if(i != 513 || WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE) goto _L2; else goto _L1
_L1:
        initLifeData();
        clearList();
        if(mCityID > 0 || mCityID == -99)
        {
            showProDialog();
            mEmptyText.setText(getResources().getString(0x7f0b017f));
            updateWeather(Gl.getCurrentCityIndex());
        }
_L4:
        return;
_L2:
        if(i == 513 && WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK)
        {
            if(mCurrentCityIndex != Gl.getCurrentCityIndex())
            {
                initLifeData();
                showProDialog();
                if(mDownloadHandler != null)
                    mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(503));
            }
        } else
        if(i == 513 && WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
        {
            initLifeData();
            clearList();
            if(mDownloadHandler != null)
                mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(503));
        } else
        if(i == 514 && WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK)
        {
            showProDialog();
            if(mDownloadHandler != null)
                mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(503));
        } else
        if(i == 515 && WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK)
        {
            showProDialog();
            if(mDownloadHandler != null)
                mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(503));
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onClick(View view)
    {
        if(view != mIvIndexADDImg) goto _L2; else goto _L1
_L1:
        Intent intent = new Intent(this, com/moji/mjweather/activity/AddConcernActivity);
        Bundle bundle = new Bundle();
        bundle.putInt("bundle_key_city_id", mCityID);
        intent.putExtras(bundle);
        startActivityForResult(intent, 514);
_L4:
        return;
_L2:
        if(view == mIvCityManagerImg)
            startActivityForResult(new Intent(this, com/moji/mjweather/activity/CityManagerActivity), 513);
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        MojiLog.v("WeatherIndexActivity", "onCreate()");
        requestWindowFeature(1);
        setContentView(0x7f03003a);
        mGestureDetector = new GestureDetector(this);
        mCityWeatherBgSwitcher = (CityWeatherBgSwitcher)getParent().findViewById(0x7f0d01ad);
        ((LinearLayout)findViewById(0x7f0d00ed)).setOnTouchListener(this);
        initLifeInfo();
        initLifeData();
        mDownloadThread = new DownloadThread(mHandler);
        mDownloadThread.start();
        initListView();
        mListView.setAdapter(mWeatherLifeAdapter);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        MojiLog.v("WeatherIndexActivity", "onDestroy");
        onBack();
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if(motionevent.getX() - motionevent1.getX() <= 50F || Math.abs(f) <= 0F) goto _L2; else goto _L1
_L1:
        updateCityInfo("left");
_L4:
        return false;
_L2:
        if(motionevent1.getX() - motionevent.getX() > 50F && Math.abs(f) > 0F)
            updateCityInfo("right");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag;
        if(mNotUpdating && i == 4)
        {
            mHandler.sendMessage(mHandler.obtainMessage(509));
            flag = true;
        } else
        {
            flag = super.onKeyDown(i, keyevent);
        }
        return flag;
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    protected void onPause()
    {
        super.onPause();
        MojiLog.v("WeatherIndexActivity", "onPause()");
        if(mUpdateCallbackImpl != null)
            WeatherPublisher.getInstance().unSubscribe(mUpdateCallbackImpl);
    }

    protected void onResume()
    {
        super.onResume();
        MojiLog.v("WeatherIndexActivity", "onResume()");
        if(mCurrentCityIndex != Gl.getCurrentCityIndex())
        {
            initLifeData();
            showProDialog();
            if(mDownloadHandler != null)
                mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(503));
        } else
        {
            mListView.startAnimation(mAnim);
        }
        StatsUtil.updateStatsPv(com.moji.mjweather.util.StatsUtil.StatsPv.PV_LF);
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return false;
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        return false;
    }

    protected void onStart()
    {
        super.onStart();
        MojiLog.v("WeatherIndexActivity", "onStart()");
    }

    protected void onStop()
    {
        super.onStop();
        MojiLog.v("WeatherIndexActivity", "onStop()");
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return mGestureDetector.onTouchEvent(motionevent);
    }

    private static final int ACTIVITY_RESULT_CODE_ADD_CONCERN = 514;
    private static final int ACTIVITY_RESULT_CODE_CITY_MRG = 513;
    private static final int ACTIVITY_RESULT_CODE_WEBVIEW = 515;
    protected static final String BUNDLE_KEY_CATEGORY = "bundle_key_category";
    protected static final String BUNDLE_KEY_CITY_ID = "bundle_key_city_id";
    protected static final String BUNDLE_KEY_DIGEST = "bundle_key_digest";
    protected static final String BUNDLE_KEY_ENTRY = "bundle_key_entry";
    protected static final String BUNDLE_KEY_ID = "bundle_key_id";
    protected static final String BUNDLE_KEY_NAME = "bundle_key_name";
    private static final int DOWNLOAD_CANCLE_XML = 509;
    private static final int DOWNLOAD_IMG_OK = 511;
    private static final int DOWNLOAD_XML_FAIL = 505;
    private static final int DOWNLOAD_XML_OK = 504;
    private static final int DV = 100;
    private static final int FLING_MIN_DISTANCE = 50;
    private static final int FLING_MIN_VELOCITY = 0;
    private static final String FLING_TAG_LEFT = "left";
    private static final String FLING_TAG_RIGHT = "right";
    private static final int MERGE_XML_FAIL = 508;
    private static final int MERGE_XML_OK = 507;
    private static final int NETWORK_HANDLER_BASE = 500;
    private static final int NETWORK_THREAD_OK = 501;
    private static final int NETWORK_THREAD_QUIT_LOOPER = 502;
    private static final int SATRT_DOWNLOAD_XML = 503;
    private static final int START_DOWNLOAD_IMG = 510;
    private static final int START_MERGE_XML = 506;
    private static final String TAG = "WeatherIndexActivity";
    private static final String TAG_CATE = "cate";
    private static final String TAG_CATEGORY = "category";
    private static final String TAG_CL = "cl";
    private static final String TAG_CONTENT = "content";
    private static final String TAG_DIGEST = "digest";
    private static final String TAG_ENTRY = "entry";
    private static final String TAG_FAVORITES = "favorites";
    private static final String TAG_HTTP = "http://";
    private static final String TAG_ICON = "icon";
    private static final String TAG_ID = "id";
    private static final String TAG_ITEM = "item";
    private static final String TAG_MOJI = "moji://";
    private static final String TAG_NAME = "name";
    private static final String TAG_OL = "ol";
    private static final int UPDATE_WEATHER_RESULT = 512;
    private Animation mAnim;
    private int mCityID;
    private CityWeatherBgSwitcher mCityWeatherBgSwitcher;
    private int mCurrentCityIndex;
    private Handler mDownloadHandler;
    private DownloadThread mDownloadThread;
    private ProgressBar mEmptyPro;
    private TextView mEmptyText;
    private WeatherLifeInfo mEntryInfo;
    private GestureDetector mGestureDetector;
    Handler mHandler;
    private ImageView mIvCityManagerImg;
    private ImageView mIvIndexADDImg;
    private ListView mListView;
    private boolean mNotUpdating;
    private WeatherLifeInfo mOrderInfo;
    private ParseWeatherLife mParseWeatherLife;
    private String mPreviewFile;
    private String mPreviewPath;
    private Dialog mProgressDialog;
    private int mTotalListLine;
    private TextView mTvLifeCityName;
    private TextView mTvLifeDate;
    private UpdateCallbackImpl mUpdateCallbackImpl;
    private WeatherLifeAdapter mWeatherLifeAdapter;
    private WeatherUpdater mWeatherUpdater;


/*
    static boolean access$002(WeatherIndexActivity weatherindexactivity, boolean flag)
    {
        weatherindexactivity.mNotUpdating = flag;
        return flag;
    }

*/




/*
    static Handler access$102(WeatherIndexActivity weatherindexactivity, Handler handler)
    {
        weatherindexactivity.mDownloadHandler = handler;
        return handler;
    }

*/






/*
    static String access$1902(WeatherIndexActivity weatherindexactivity, String s)
    {
        weatherindexactivity.mPreviewFile = s;
        return s;
    }

*/






/*
    static WeatherLifeInfo access$2502(WeatherIndexActivity weatherindexactivity, WeatherLifeInfo weatherlifeinfo)
    {
        weatherindexactivity.mEntryInfo = weatherlifeinfo;
        return weatherlifeinfo;
    }

*/




/*
    static WeatherLifeInfo access$402(WeatherIndexActivity weatherindexactivity, WeatherLifeInfo weatherlifeinfo)
    {
        weatherindexactivity.mOrderInfo = weatherlifeinfo;
        return weatherlifeinfo;
    }

*/



/*
    static int access$502(WeatherIndexActivity weatherindexactivity, int i)
    {
        weatherindexactivity.mTotalListLine = i;
        return i;
    }

*/




/*
    static int access$702(WeatherIndexActivity weatherindexactivity, int i)
    {
        weatherindexactivity.mCityID = i;
        return i;
    }

*/


}
