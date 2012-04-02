// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SkinListBaseActivity.java

package com.moji.mjweather.widgetskin;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.moji.mjweather.CDialogManager;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.util.SkinUtil;
import com.moji.mjweather.util.UiUtil;

// Referenced classes of package com.moji.mjweather.widgetskin:
//            SkinPullParser, SkinSelector, BitmapCacheManager, SkinHashStatus, 
//            SkinSDInfo

public class SkinListBaseActivity extends ListActivity
{
    private class SkinListAdapter extends BaseAdapter
    {

        public int getCount()
        {
            return mSkinNewInfos.size();
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
            String s="";
            ImageView imageview;
            android.graphics.Bitmap bitmap;
             String s1 = (new StringBuilder()).append(SkinUtil.getImgCacheDir()).append(s).append("preview.jpg").toString();
            File file = new File(s1);
            View view1 = mInflater.inflate(0x7f030061, null);
            imageview = (ImageView)view1.findViewById(0x7f0d021a);
            TextView textview = (TextView)view1.findViewById(0x7f0d021b);
            TextView textview1 = (TextView)view1.findViewById(0x7f0d021c);
            TextView textview2 = (TextView)view1.findViewById(0x7f0d021d);
            RatingBar ratingbar = (RatingBar)view1.findViewById(0x7f0d005d);
            ImageView imageview1 = (ImageView)view1.findViewById(0x7f0d021e);
            String s2 = "";
            if(Gl.getCurrentSkinDir().startsWith("skin"))
                s2 = Gl.getCurrentSkinDir().substring("skin".length());
            android.graphics.Bitmap bitmap1;
            if(s.equals(s2))
                imageview1.setImageResource(0x7f02012d);
            else
            if(SkinUtil.existsSkin(SkinListBaseActivity.this, s, mInstalledSkinList))
                imageview1.setImageResource(0x7f020125);
            else
                imageview1.setVisibility(4);
           
            if(i > m_currentTopItemIndex + m_currentShowItemCount)
                m_currentShowItemCount = i - m_currentTopItemIndex;
            if(m_currentTopItemIndex > i)
                m_currentTopItemIndex = i;
          
            bitmap1 = BitmapFactory.decodeFile(s1);
            bitmap = bitmap1;
 
            if(bitmap != null)
            {
                
                imageview.setImageBitmap(bitmap);
            }
            imageview.setImageBitmap(bitmap);
 
            return view1;
 
            
 
        }

        public void notifyChanged()
        {
            notifyDataSetChanged();
        }

          private List mSkinNewInfos;
        private final int m_SKINDOWNLOAD_NO = -1;
        public final int m_SKINDOWNLOAD_OK = 1;
        private final int m_SKINDOWNLOAD_WAITING = 0;
          
        public SkinListAdapter(Context context, List list)
        {
              super();
               mSkinNewInfos = list;
        }
    }

    private class NetWorkThread extends Thread
    {

        public void run()
        {
            Looper.prepare();
            Handler handler = new Handler() {

                public void handleMessage(Message message)
                {
                    super.handleMessage(message);
                    switch(message.what)
                    {
                    case 401: break;
                    case 402:   break;
                    case 403: Looper.myLooper().quit();break;
                    default:return;
                    }
                     
                }

                
            }
;
            if(mNetWorkHandler == null)
            {
                mainHandler.sendMessage(mainHandler.obtainMessage(407, handler));
                Looper.loop();
            }
        }

        public void setCancel()
        {
            isCancel = true;
        }

        private boolean isCancel;
        private Context mainContext;
        private Handler mainHandler;
      


        public NetWorkThread(Context context, Handler handler)
        {
             super();
            mainHandler = handler;
            mainContext = context;
            isCancel = false;
        }
    }


    protected SkinListBaseActivity(String s)
    {
        mFrom = "1";
        mTo = "10";
        mOrder = "2";
        m_currentTopItemIndex = -1;
        m_currentShowItemCount = -1;
        mSkinXmlList = new ArrayList();
        mInstalledSkinList = null;
       
    }

    private boolean download(String s, String s1, String s2, Context context)
    {
        return SkinUtil.download(context, "c.moji001.com", s, s1, SkinUtil.getImgNotDeleteCacheDir(), s2);
    }

    private String getXmlUrl(String s, String s1, String s2)
    {
        Display display = getWindowManager().getDefaultDisplay();
        String s3 = (new StringBuilder()).append("/skin/SkinList?Platform=1&Version=").append(Gl.getVersion()).append("&Width=").append(display.getWidth()).append("&Height=").append(display.getHeight()).append("&From=").append(s).append("&To=").append(s1).append("&Order=").append(s2).toString();
        MojiLog.d("SkinListBaseActivity", (new StringBuilder()).append("getXmlUrl  skinListXml:").append(s3).toString());
        return s3;
    }

    private void init()
    {
        MojiLog.v("SkinListBaseActivity", "init");
        mCDialogManager = new CDialogManager(this, null);
        SkinUtil.createDirs();
          mInflater = (LayoutInflater)getSystemService("layout_inflater");
        banner = (FrameLayout)mInflater.inflate(0x7f030058, null);
        rc = (ImageView)banner.findViewById(0x7f0d01f7);
        rCancel = (ImageView)banner.findViewById(0x7f0d01f8);
        mListView = getListView();
        if(mOrder.equals("2"))
        {
            mListView.addHeaderView(banner);
            banner.setVisibility(8);
        }
        mListView.setCacheColorHint(0);
        emptylinearLayout = (LinearLayout)mInflater.inflate(0x7f03001d, null);
        mListView.setDividerHeight(2);
        BitmapDrawable bitmapdrawable = new BitmapDrawable(BitmapFactory.decodeResource(Gl.Ct().getResources(), 0x7f020126));
        mListView.setDivider(bitmapdrawable);
        mListView.addFooterView(emptylinearLayout);
        mListView.setBackgroundDrawable(UiUtil.getBgBitmapDrawable());
   
        mNetWorkThread = new NetWorkThread(this, mHandler);
        mNetWorkThread.start();
    }

    private List xmlAdapter(InputStream inputstream)
    {
        
        return null;
         
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        MojiLog.v("SkinListBaseActivity", "onCreate");
        setContentView(0x7f030068);
        init();
        mInstalledSkinList = SkinUtil.getSkinDirList(this);
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("com.moji.mjchina.recommend.soft_item");
        registerReceiver(receiver, intentfilter);
       
       
    }

    protected void onDestroy()
    {
        super.onDestroy();
        MojiLog.v("SkinListBaseActivity", "onDestroy");
        if(mNetWorkHandler != null)
        {
            mNetWorkHandler.sendMessage(mNetWorkHandler.obtainMessage(409));
            try
            {
                if(mNetWorkThread != null && mNetWorkThread.isAlive())
                {
                    mNetWorkThread.setCancel();
                    mNetWorkThread.interrupt();
                }
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        if(mInstalledSkinList != null)
            mInstalledSkinList.clear();
    }

    protected void onPause()
    {
        super.onPause();
        MojiLog.v("SkinListBaseActivity", "onPause");
    }

    protected void onResume()
    {
        super.onResume();
        MojiLog.v("SkinListBaseActivity", "onResume");
        if(mInstalledSkinList != null)
            mInstalledSkinList.clear();
        mInstalledSkinList = SkinUtil.getSkinDirList(this);
        if(mSkinListAdapter != null)
            mSkinListAdapter.notifyChanged();
    }

    private static final int BASE_VALUE = 400;
    private static final int DOWNLOAD_IMAGE_FAIL = 406;
    private static final int DOWNLOAD_IMAGE_OK = 405;
    private static final int DOWNLOAD_IMAGE_START = 402;
    private static final int DOWNLOAD_XML_ADD = 410;
    private static final int DOWNLOAD_XML_FAIL = 404;
    private static final int DOWNLOAD_XML_OK = 403;
    private static final int DOWNLOAD_XML_WRONG = 411;
    private static final int NETWORK_THREAD_OK = 407;
    private static final int NETWORK_THREAD_QUIT_LOOPER = 409;
    private static final int START_DOWNLOAD_XML = 401;
    private static final String TAG = "SkinListBaseActivity";
    private FrameLayout banner;
    private LinearLayout emptylinearLayout;
    private CDialogManager mCDialogManager;
    private String mFrom;
    Handler mHandler;
    private LayoutInflater mInflater;
    private List mInstalledSkinList;
    private boolean mIsLoadNewSkin;
    private ListView mListView;
    private Handler mNetWorkHandler;
    private NetWorkThread mNetWorkThread;
    private String mOrder;
    private SkinListAdapter mSkinListAdapter;
    private List mSkinXmlList;
    private String mTo;
    private int m_currentShowItemCount;
    private int m_currentTopItemIndex;
    private ImageView rCancel;
    private ImageView rc;
    private BroadcastReceiver receiver;
 



/*
    static Handler access$002(SkinListBaseActivity skinlistbaseactivity, Handler handler)
    {
        skinlistbaseactivity.mNetWorkHandler = handler;
        return handler;
    }

*/




/*
    static int access$1002(SkinListBaseActivity skinlistbaseactivity, int i)
    {
        skinlistbaseactivity.m_currentShowItemCount = i;
        return i;
    }

*/


/*
    static SkinListAdapter access$102(SkinListBaseActivity skinlistbaseactivity, SkinListAdapter skinlistadapter)
    {
        skinlistbaseactivity.mSkinListAdapter = skinlistadapter;
        return skinlistadapter;
    }

*/



/*
    static boolean access$1102(SkinListBaseActivity skinlistbaseactivity, boolean flag)
    {
        skinlistbaseactivity.mIsLoadNewSkin = flag;
        return flag;
    }

*/



/*
    static String access$1202(SkinListBaseActivity skinlistbaseactivity, String s)
    {
        skinlistbaseactivity.mFrom = s;
        return s;
    }

*/



/*
    static String access$1302(SkinListBaseActivity skinlistbaseactivity, String s)
    {
        skinlistbaseactivity.mTo = s;
        return s;
    }

*/













/*
    static SoftWare access$502(SkinListBaseActivity skinlistbaseactivity, SoftWare software)
    {
        skinlistbaseactivity.soft = software;
        return software;
    }

*/






/*
    static int access$902(SkinListBaseActivity skinlistbaseactivity, int i)
    {
        skinlistbaseactivity.m_currentTopItemIndex = i;
        return i;
    }

*/
}
