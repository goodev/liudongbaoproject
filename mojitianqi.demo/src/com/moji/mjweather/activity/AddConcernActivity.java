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

public class AddConcernActivity extends Activity
{
    private class LifeInfo
    {

        String id;
        boolean isAttention;
        List mItemList;
        String name;
        final AddConcernActivity this$0;
        String type;

        private LifeInfo()
        {
            this$0 = AddConcernActivity.this;
            super();
        }

    }

    private class WeatherLifeInfo
    {

        List lifeList;
        final AddConcernActivity this$0;

        private WeatherLifeInfo()
        {
            this$0 = AddConcernActivity.this;
            super();
        }

    }

    private class ParseWeatherLife
    {

        private boolean parse(InputStream inputstream, boolean flag)
        {
            XmlPullParser xmlpullparser;
            int i;
            LifeInfo lifeinfo;
            ArrayList arraylist;
            ArrayList arraylist1;
            boolean flag2;
            xmlpullparser = Xml.newPullParser();
            xmlpullparser.setInput(inputstream, "utf-8");
            i = xmlpullparser.getEventType();
            lifeinfo = null;
            arraylist = new ArrayList();
            arraylist1 = null;
            flag2 = false;
            if(!flag) goto _L2; else goto _L1
_L1:
            String s = "cl";
            WeatherLifeInfo weatherlifeinfo = null;
_L36:
            if(i == 1) goto _L4; else goto _L3
_L3:
            String s1 = xmlpullparser.getName();
            i;
            JVM INSTR tableswitch 0 3: default 100
        //                       0 130
        //                       1 100
        //                       2 137
        //                       3 704;
               goto _L5 _L6 _L5 _L7 _L8
_L5:
            WeatherLifeInfo weatherlifeinfo1 = weatherlifeinfo;
_L9:
            i = xmlpullparser.next();
            weatherlifeinfo = weatherlifeinfo1;
            continue; /* Loop/switch isn't completed */
_L2:
            s = "ol";
            weatherlifeinfo = null;
            continue; /* Loop/switch isn't completed */
_L6:
            weatherlifeinfo1 = weatherlifeinfo;
              goto _L9
_L7:
            if(!s.equals(s1)) goto _L11; else goto _L10
_L10:
            weatherlifeinfo1 = new WeatherLifeInfo();
              goto _L9
_L11:
            if(!"cate".equals(s1)) goto _L13; else goto _L12
_L12:
            lifeinfo = new LifeInfo();
            String s2 = xmlpullparser.getAttributeValue(null, "id");
            lifeinfo.id = s2;
            String s3 = xmlpullparser.getAttributeValue(null, "name");
            lifeinfo.name = s3;
            lifeinfo.type = "category";
            arraylist.add(lifeinfo);
            weatherlifeinfo1 = weatherlifeinfo;
              goto _L9
_L13:
            if(!"folder".equals(s1)) goto _L15; else goto _L14
_L14:
            flag2 = true;
            lifeinfo = new LifeInfo();
            arraylist1 = new ArrayList();
            String s4 = xmlpullparser.getAttributeValue(null, "id");
            lifeinfo.id = s4;
            String s5 = xmlpullparser.getAttributeValue(null, "name");
            lifeinfo.name = s5;
            lifeinfo.type = "folder";
            weatherlifeinfo1 = weatherlifeinfo;
              goto _L9
_L15:
            if(!"item".equals(s1)) goto _L5; else goto _L16
_L16:
            LifeInfo lifeinfo1;
            int j;
            lifeinfo1 = new LifeInfo();
            lifeinfo1.id = xmlpullparser.getAttributeValue(null, "id");
            lifeinfo1.name = xmlpullparser.getAttributeValue(null, "name");
            lifeinfo1.type = "content";
            j = 0;
_L32:
            if(mOrderLifeInfo == null || j >= mOrderLifeInfo.lifeList.size()) goto _L18; else goto _L17
_L17:
            if(((LifeInfo)mOrderLifeInfo.lifeList.get(j)).type.equals("content") && lifeinfo1.id.equals(((LifeInfo)mOrderLifeInfo.lifeList.get(j)).id))
                lifeinfo1.isAttention = true;
              goto _L19
_L31:
            int k;
            if(((LifeInfo)mOrderLifeInfo.lifeList.get(j)).mItemList == null || k >= ((LifeInfo)mOrderLifeInfo.lifeList.get(j)).mItemList.size()) goto _L21; else goto _L20
_L20:
            if(((LifeInfo)((LifeInfo)mOrderLifeInfo.lifeList.get(j)).mItemList.get(k)).type.equals("content") && lifeinfo1.id.equals(((LifeInfo)((LifeInfo)mOrderLifeInfo.lifeList.get(j)).mItemList.get(k)).id))
                lifeinfo1.isAttention = true;
              goto _L22
_L18:
            if(flag2)
            {
                arraylist1.add(lifeinfo1);
                weatherlifeinfo1 = weatherlifeinfo;
            } else
            {
                arraylist.add(lifeinfo1);
                weatherlifeinfo1 = weatherlifeinfo;
            }
              goto _L9
_L8:
            if(!s.equals(s1)) goto _L24; else goto _L23
_L23:
            weatherlifeinfo.lifeList = arraylist;
            weatherlifeinfo1 = weatherlifeinfo;
              goto _L9
_L24:
            if(!"cate".equals(s1)) goto _L26; else goto _L25
_L25:
            weatherlifeinfo1 = weatherlifeinfo;
              goto _L9
_L26:
            if(!"folder".equals(s1)) goto _L28; else goto _L27
_L27:
            flag2 = false;
            lifeinfo.mItemList = arraylist1;
            arraylist.add(lifeinfo);
            weatherlifeinfo1 = weatherlifeinfo;
              goto _L9
_L28:
            if(!"item".equals(s1));
              goto _L5
_L4:
            boolean flag1;
            if(weatherlifeinfo == null)
            {
                flag1 = false;
                MojiLog.d("AddConcernActivity", "\u89E3\u6790\u5931\u8D25~~");
            } else
            {
                if(flag)
                    mOrderLifeInfo = weatherlifeinfo;
                else
                    mEntryLifeInfo = weatherlifeinfo;
                flag1 = true;
                MojiLog.d("AddConcernActivity", "\u89E3\u6790\u6210\u529F~~");
            }
              goto _L29
            Exception exception;
            exception;
              goto _L30
_L19:
            k = 0;
              goto _L31
_L22:
            k++;
              goto _L31
_L21:
            j++;
              goto _L32
_L29:
            weatherlifeinfo;
_L34:
            return flag1;
            Exception exception1;
            exception1;
            weatherlifeinfo;
_L30:
            flag1 = false;
            if(true) goto _L34; else goto _L33
_L33:
            if(true) goto _L36; else goto _L35
_L35:
        }

        final AddConcernActivity this$0;


        private ParseWeatherLife()
        {
            this$0 = AddConcernActivity.this;
            super();
        }

    }

    private class DownloadThread extends Thread
    {

        public void doCancel()
        {
            mIsCancel = true;
        }

        public void run()
        {
            Looper.prepare();
            Handler handler = new Handler() {

                public void handleMessage(Message message)
                {
                    boolean flag;
                    flag = false;
                    super.handleMessage(message);
                    message.what;
                    JVM INSTR tableswitch 602 606: default 44
                //                               602 538
                //                               603 45
                //                               604 44
                //                               605 44
                //                               606 151;
                       goto _L1 _L2 _L3 _L1 _L1 _L4
_L1:
                    return;
_L3:
                    if(!mIsCancel && isXmlOK(true) && isXmlOK(flag))
                        mMainHandler.sendMessage(mMainHandler.obtainMessage(604));
                    else
                    if(!mIsCancel)
                        mMainHandler.sendMessage(mMainHandler.obtainMessage(605, Boolean.valueOf(flag)));
                    continue; /* Loop/switch isn't completed */
_L4:
                    int i;
                    boolean flag1;
                    i = message.arg1;
                    int j = message.arg2;
                    int k;
                    LifeInfo lifeinfo1;
                    if(j > -1)
                    {
                        flag1 = ((LifeInfo)((LifeInfo)mEntryLifeInfo.lifeList.get(j)).mItemList.get(i)).isAttention;
                        k = Integer.parseInt(((LifeInfo)((LifeInfo)mEntryLifeInfo.lifeList.get(j)).mItemList.get(i)).id);
                    } else
                    {
                        flag1 = ((LifeInfo)mEntryLifeInfo.lifeList.get(i)).isAttention;
                        k = Integer.parseInt(((LifeInfo)mEntryLifeInfo.lifeList.get(i)).id);
                    }
                    if(mIsCancel || !sendAttention(flag1, k)) goto _L6; else goto _L5
_L5:
                    Gl.setLifeInfoDate(mCityID, "LifeOrder", "2000/01/01");
                    if(j > -1)
                    {
                        lifeinfo1 = (LifeInfo)((LifeInfo)mEntryLifeInfo.lifeList.get(j)).mItemList.get(i);
                        if(!flag1)
                            flag = true;
                        lifeinfo1.isAttention = flag;
                    } else
                    {
                        LifeInfo lifeinfo = (LifeInfo)mEntryLifeInfo.lifeList.get(i);
                        if(!flag1)
                            flag = true;
                        lifeinfo.isAttention = flag;
                    }
                    mMainHandler.sendMessage(mMainHandler.obtainMessage(607, Boolean.valueOf(flag1)));
_L7:
                    mClickable = true;
                    continue; /* Loop/switch isn't completed */
_L6:
                    if(!mIsCancel)
                        mMainHandler.sendMessage(mMainHandler.obtainMessage(608, Boolean.valueOf(flag)));
                    if(true) goto _L7; else goto _L2
_L2:
                    Looper.myLooper().quit();
                    if(true) goto _L1; else goto _L8
_L8:
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
                mMainHandler.sendMessage(mMainHandler.obtainMessage(601, handler));
                Looper.loop();
            }
        }

        private boolean mIsCancel;
        private Handler mMainHandler;
        final AddConcernActivity this$0;



        DownloadThread(Handler handler)
        {
            this$0 = AddConcernActivity.this;
            super("AddConcernActivity:DownloadThread");
            mMainHandler = handler;
            mIsCancel = false;
        }
    }

    private class WeatherLifeAdapter extends BaseAdapter
    {
        private class ConcernButtonListener
            implements android.view.View.OnClickListener
        {

            public void onClick(View view)
            {
                if(view.getId() == mIvForeard.getId() && mClickable)
                {
                    mClickable = false;
                    LinearLayout linearlayout = (LinearLayout)mLayoutInflater.inflate(0x7f030051, null);
                    linearlayout.setBackgroundResource(0x7f080004);
                    ((TextView)linearlayout.findViewById(0x7f0d01e0)).setText(attStr);
                    mProgressDialog = (new android.app.AlertDialog.Builder(_fld0)).setView(linearlayout).create();
                    mProgressDialog.show();
                    mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(606, position, newPage, null));
                }
            }

            private String attStr;
            private boolean isAttention;
            private int newPage;
            private int position;
            final WeatherLifeAdapter this$1;

            public ConcernButtonListener(int i, int j)
            {
                this$1 = WeatherLifeAdapter.this;
                super();
                position = i;
                newPage = j;
                String s;
                if(j > -1)
                    isAttention = ((LifeInfo)((LifeInfo)mEntryLifeInfo.lifeList.get(j)).mItemList.get(i)).isAttention;
                else
                    isAttention = ((LifeInfo)mEntryLifeInfo.lifeList.get(i)).isAttention;
                if(isAttention)
                    s = mCancleConcernLoading;
                else
                    s = mAddConcernLoading;
                attStr = s;
            }
        }


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
            String s;
            s = null;
            if(mNewPage == -1)
                s = ((LifeInfo)mEntryLifeInfo.lifeList.get(i)).type;
            if(mNewPage != -1 || s == null || !s.equals("category")) goto _L2; else goto _L1
_L1:
            mRelativeLayout = (RelativeLayout)mLayoutInflater.inflate(0x7f030037, null);
            ((TextView)mRelativeLayout.findViewById(0x7f0d00e7)).setText(((LifeInfo)mEntryLifeInfo.lifeList.get(i)).name);
_L8:
            return mRelativeLayout;
_L2:
            TextView textview1;
            if(mNewPage != -1 || s == null || !s.equals("content") && !s.equals("folder"))
                break MISSING_BLOCK_LABEL_454;
            mIsAttetion = ((LifeInfo)mEntryLifeInfo.lifeList.get(i)).isAttention;
            mRelativeLayout = (RelativeLayout)mLayoutInflater.inflate(0x7f030001, null);
            textview1 = (TextView)mRelativeLayout.findViewById(0x7f0d0002);
            mIvForeard = (ImageButton)mRelativeLayout.findViewById(0x7f0d0001);
            if(((LifeInfo)mEntryLifeInfo.lifeList.get(i)).mItemList == null) goto _L4; else goto _L3
_L3:
            mRelativeLayout.setBackgroundResource(0x7f020005);
            mIvForeard.setBackgroundResource(0x7f02011f);
_L6:
            textview1.setText(((LifeInfo)mEntryLifeInfo.lifeList.get(i)).name);
            continue; /* Loop/switch isn't completed */
_L4:
            mRelativeLayout.setBackgroundResource(0x7f0200e8);
            mIvForeard.setVisibility(0);
            ImageButton imagebutton1 = mIvForeard;
            int i1;
            String as1[];
            int j1;
            int k1;
            if(mIsAttetion)
                i1 = 0x7f02003a;
            else
                i1 = 0x7f020004;
            imagebutton1.setBackgroundResource(i1);
            as1 = mDdefaultID;
            j1 = as1.length;
            k1 = 0;
            do
            {
label0:
                {
                    if(k1 < j1)
                    {
                        if(!as1[k1].equals(((LifeInfo)mEntryLifeInfo.lifeList.get(i)).id))
                            break label0;
                        mIvForeard.setVisibility(8);
                    }
                    mIvForeard.setOnClickListener(new ConcernButtonListener(i, mNewPage));
                }
                if(true)
                    break;
                k1++;
            } while(true);
            if(true) goto _L6; else goto _L5
_L5:
            int l;
            if(mNewPage == -1 || ((LifeInfo)mEntryLifeInfo.lifeList.get(mNewPage)).mItemList == null)
                continue; /* Loop/switch isn't completed */
            mIsAttetion = ((LifeInfo)((LifeInfo)mEntryLifeInfo.lifeList.get(mNewPage)).mItemList.get(i)).isAttention;
            mRelativeLayout = (RelativeLayout)mLayoutInflater.inflate(0x7f030001, null);
            TextView textview = (TextView)mRelativeLayout.findViewById(0x7f0d0002);
            mIvForeard = (ImageButton)mRelativeLayout.findViewById(0x7f0d0001);
            mRelativeLayout.setBackgroundResource(0x7f0200e8);
            mIvForeard.setVisibility(0);
            ImageButton imagebutton = mIvForeard;
            int j;
            String as[];
            int k;
            if(mIsAttetion)
                j = 0x7f02003a;
            else
                j = 0x7f020004;
            imagebutton.setBackgroundResource(j);
            as = mDdefaultID;
            k = as.length;
            l = 0;
_L9:
label1:
            {
                if(l < k)
                {
                    if(!as[l].equals(((LifeInfo)((LifeInfo)mEntryLifeInfo.lifeList.get(mNewPage)).mItemList.get(i)).id))
                        break label1;
                    mIvForeard.setVisibility(8);
                }
                textview.setText(((LifeInfo)((LifeInfo)mEntryLifeInfo.lifeList.get(mNewPage)).mItemList.get(i)).name);
                mIvForeard.setOnClickListener(new ConcernButtonListener(i, mNewPage));
            }
            if(true) goto _L8; else goto _L7
_L7:
            l++;
              goto _L9
            if(true) goto _L8; else goto _L10
_L10:
        }

        boolean mIsAttetion;
        ImageButton mIvForeard;
        LayoutInflater mLayoutInflater;
        RelativeLayout mRelativeLayout;
        final AddConcernActivity this$0;

        public WeatherLifeAdapter()
        {
            this$0 = AddConcernActivity.this;
            super();
            mLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
        }
    }

    private class ItemClickListener
        implements android.widget.AdapterView.OnItemClickListener
    {

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if(mNewPage == -1 && ((LifeInfo)mEntryLifeInfo.lifeList.get(i)).mItemList != null)
            {
                mNewPage = i;
                mTotalListLine = ((LifeInfo)mEntryLifeInfo.lifeList.get(mNewPage)).mItemList.size();
                mHandler.sendMessage(mHandler.obtainMessage(609));
            }
        }

        final AddConcernActivity this$0;

        private ItemClickListener()
        {
            this$0 = AddConcernActivity.this;
            super();
        }

    }


    public AddConcernActivity()
    {
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

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                message.what;
                JVM INSTR tableswitch 601 609: default 60
            //                           601 61
            //                           602 60
            //                           603 60
            //                           604 103
            //                           605 125
            //                           606 60
            //                           607 194
            //                           608 257
            //                           609 310;
                   goto _L1 _L2 _L1 _L1 _L3 _L4 _L1 _L5 _L6 _L7
_L1:
                return;
_L2:
                mDownloadHandler = (Handler)message.obj;
                mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(603));
                continue; /* Loop/switch isn't completed */
_L3:
                mDataState = true;
                mWeatherLifeAdapter.notifyDataSetChanged();
                continue; /* Loop/switch isn't completed */
_L4:
                mDataState = true;
                if(((Boolean)message.obj).booleanValue())
                    Toast.makeText(Gl.Ct(), 0x7f0b0018, 0).show();
                mEmptyText.setText(getResources().getString(0x7f0b021c));
                mWeatherLifeAdapter.notifyDataSetChanged();
                continue; /* Loop/switch isn't completed */
_L5:
                dismissDialog();
                String s1;
                if(((Boolean)message.obj).booleanValue())
                    s1 = mCancleConcernOK;
                else
                    s1 = mAddConcernOK;
                Toast.makeText(Gl.Ct(), s1, 0).show();
                mWeatherLifeAdapter.notifyDataSetChanged();
                continue; /* Loop/switch isn't completed */
_L6:
                dismissDialog();
                String s;
                if(((Boolean)message.obj).booleanValue())
                    s = mCancleConcernFail;
                else
                    s = mAddConcernFail;
                Toast.makeText(Gl.Ct(), s, 0).show();
                continue; /* Loop/switch isn't completed */
_L7:
                mListView.removeAllViewsInLayout();
                mWeatherLifeAdapter.notifyDataSetChanged();
                if(true) goto _L1; else goto _L8
_L8:
            }

            final AddConcernActivity this$0;

            
            {
                this$0 = AddConcernActivity.this;
                super();
            }
        }
;
    }

    private void dismissDialog()
    {
        if(mProgressDialog != null)
            mProgressDialog.dismiss();
    }

    private String getMakeURL(int i)
    {
        return (new StringBuilder()).append("/weather/MakeContentOrder?UserID=").append(Gl.getRegCode()).append("&Platform=Android").append("&Device=phone").append("&Version=").append(Gl.getVersion()).append("&BaseOSVer=").append(android.os.Build.VERSION.SDK).append("&Model=").append(URLEncoder.encode(Build.MODEL)).append("&PartnerKey=").append(Gl.getPartnerID()).append("&CityID=").append(mCityID).append("&ContentID=").append(i).append("&VersionType=").append(Gl.getVersionType()).toString();
    }

    private String getRemoveURL(int i)
    {
        return (new StringBuilder()).append("/weather/RemoveContentOrder?UserID=").append(Gl.getRegCode()).append("&Platform=Android").append("&Device=phone").append("&Version=").append(Gl.getVersion()).append("&BaseOSVer=").append(android.os.Build.VERSION.SDK).append("&Model=").append(URLEncoder.encode(Build.MODEL)).append("&PartnerKey=").append(Gl.getPartnerID()).append("&CityID=").append(mCityID).append("&ContentID=").append(i).append("&VersionType=").append(Gl.getVersionType()).toString();
    }

    private void initLifeInfo()
    {
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

    private void initListView()
    {
        mListView = (ListView)findViewById(0x7f0d0008);
        LinearLayout linearlayout = (LinearLayout)((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030051, null);
        linearlayout.setBackgroundResource(0x7f080004);
        mEmptyText = (TextView)linearlayout.findViewById(0x7f0d01e0);
        mEmptyPro = (ProgressBar)linearlayout.findViewById(0x7f0d01df);
        mEmptyPro.setVisibility(8);
        linearlayout.startAnimation(AnimationUtils.loadAnimation(this, 0x7f040008));
        ((ViewGroup)mListView.getParent()).addView(linearlayout);
        mListView.setEmptyView(linearlayout);
        LayoutAnimationController layoutanimationcontroller = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 0x7f040059), 1F);
        mListView.setLayoutAnimation(layoutanimationcontroller);
        mListView.setOnItemClickListener(new ItemClickListener());
        mWeatherLifeAdapter = new WeatherLifeAdapter();
        mListView.setAdapter(mWeatherLifeAdapter);
    }

    private boolean isXmlOK(boolean flag)
    {
        boolean flag1;
        File file;
        FileInputStream fileinputstream;
        FileInputStream fileinputstream1;
        if(flag)
            file = new File((new StringBuilder()).append(Gl.Ct().getFilesDir()).append("/").append("LifeOrder").append("_").append(mCityID).append(".xml").toString());
        else
            file = new File((new StringBuilder()).append(Gl.Ct().getFilesDir()).append("/").append("LifeEntry").append("_").append(mCityID).append(".xml").toString());
        if(!file.exists())
            break MISSING_BLOCK_LABEL_225;
        MojiLog.d("AddConcernActivity", (new StringBuilder()).append("listFile:").append(file).toString());
        fileinputstream = null;
        fileinputstream1 = new FileInputStream(file);
        fileinputstream = fileinputstream1;
_L1:
        FileNotFoundException filenotfoundexception;
        if(mParseWeatherLife.parse(fileinputstream, flag))
        {
            if(!flag)
                mTotalListLine = mEntryLifeInfo.lifeList.size();
            flag1 = true;
        } else
        {
            flag1 = false;
        }
_L2:
        return flag1;
        filenotfoundexception;
        filenotfoundexception.printStackTrace();
          goto _L1
        flag1 = false;
          goto _L2
    }

    private void onBack()
    {
        if(mDownloadHandler == null)
            break MISSING_BLOCK_LABEL_56;
        mDownloadHandler.sendMessage(mDownloadHandler.obtainMessage(602));
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

    private boolean sendAttention(boolean flag, int i)
    {
        String s;
        boolean flag1;
        String s1;
        boolean flag2;
        if(flag)
            s = getRemoveURL(i);
        else
            s = getMakeURL(i);
        MojiLog.d("AddConcernActivity", (new StringBuilder()).append("sendAttention:c.moji001.com").append(s).toString());
        s1 = (new BufferedReader(new InputStreamReader(HttpUtil.doGet("c.moji001.com", s, 0L).mInputStream))).readLine();
        if(s1 == null) goto _L2; else goto _L1
_L1:
        flag2 = s1.equals("0");
        if(!flag2) goto _L2; else goto _L3
_L3:
        flag1 = true;
_L5:
        return flag1;
_L2:
        flag1 = false;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        flag1 = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        MojiLog.v("AddConcernActivity", "onCreate()");
        requestWindowFeature(1);
        setContentView(0x7f030002);
        ((LinearLayout)findViewById(0x7f0d0004)).setBackgroundDrawable(UiUtil.getBgBitmapDrawable());
        initLifeInfo();
        initListView();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        MojiLog.v("AddConcernActivity", "onDestroy");
        onBack();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag = true;
        if(i != 4) goto _L2; else goto _L1
_L1:
        if(mNewPage == -1) goto _L4; else goto _L3
_L3:
        mNewPage = -1;
        mTotalListLine = mEntryLifeInfo.lifeList.size();
        mHandler.sendMessage(mHandler.obtainMessage(609));
_L6:
        return flag;
_L4:
        if(!mDataState && mNewPage == -1)
        {
            onBack();
            mHandler.sendMessage(mHandler.obtainMessage(605, Boolean.valueOf(flag)));
            continue; /* Loop/switch isn't completed */
        }
_L2:
        flag = super.onKeyDown(i, keyevent);
        if(true) goto _L6; else goto _L5
_L5:
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
    static Handler access$002(AddConcernActivity addconcernactivity, Handler handler)
    {
        addconcernactivity.mDownloadHandler = handler;
        return handler;
    }

*/



/*
    static int access$1002(AddConcernActivity addconcernactivity, int i)
    {
        addconcernactivity.mNewPage = i;
        return i;
    }

*/


/*
    static boolean access$102(AddConcernActivity addconcernactivity, boolean flag)
    {
        addconcernactivity.mDataState = flag;
        return flag;
    }

*/



/*
    static WeatherLifeInfo access$1102(AddConcernActivity addconcernactivity, WeatherLifeInfo weatherlifeinfo)
    {
        addconcernactivity.mEntryLifeInfo = weatherlifeinfo;
        return weatherlifeinfo;
    }

*/



/*
    static int access$1202(AddConcernActivity addconcernactivity, int i)
    {
        addconcernactivity.mTotalListLine = i;
        return i;
    }

*/






/*
    static boolean access$1802(AddConcernActivity addconcernactivity, boolean flag)
    {
        addconcernactivity.mClickable = flag;
        return flag;
    }

*/



/*
    static Dialog access$1902(AddConcernActivity addconcernactivity, Dialog dialog)
    {
        addconcernactivity.mProgressDialog = dialog;
        return dialog;
    }

*/







/*
    static WeatherLifeInfo access$2802(AddConcernActivity addconcernactivity, WeatherLifeInfo weatherlifeinfo)
    {
        addconcernactivity.mOrderLifeInfo = weatherlifeinfo;
        return weatherlifeinfo;
    }

*/







}
