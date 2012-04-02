// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WebViewActivity.java

package com.moji.mjweather.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.*;
import android.view.*;
import android.webkit.*;
import android.widget.*;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.util.HttpUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Date;

// Referenced classes of package com.moji.mjweather.activity:
//            WeatherIndexActivity

public class WebViewActivity extends Activity
    implements android.view.View.OnClickListener
{
    private class FavouriteThread extends Thread
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
                    case 602: if(!isCancel && sendFavourite())
                    {
                        MojiLog.d("WebViewActivity", (new StringBuilder()).append("SEND_FAVORITE:").append(mCityID).toString());
                        Gl.setLifeInfoDate(mCityID, "LifeOrder", "2000/01/01");
                        mainHandler.sendMessage(mainHandler.obtainMessage(605));
                    } else
                    {
                        mainHandler.sendMessage(mainHandler.obtainMessage(606));
                    }break;
                    case 603:return;
                    case 604: Looper.myLooper().quit();break;
                   default:return;
                    
                    }
                 
            }}
;
            if(mFavouriteHandler == null)
            {
                mainHandler.sendMessage(mainHandler.obtainMessage(601, handler));
                Looper.loop();
            }
        }

        public void setCancel()
        {
            isCancel = true;
        }

        private boolean isCancel;
        Handler mainHandler;
     

        FavouriteThread(Handler handler)
        {
            
            super("WebViewActivity:DownloadThread");
            mainHandler = handler;
            isCancel = false;
        }
    }


    public WebViewActivity()
    {
        mHandler = new Handler() {

            public void handleMessage(Message message)
            {
                if(!Thread.currentThread().isInterrupted()) return;
 
                switch(message.what)
                {
                
                case 0: if(mProgressDialog != null && !isFinishing())
                    mProgressDialog.show();break;
                case 1:if(mProgressDialog != null && !isFinishing())
                    mProgressDialog.hide();break;
                case 601:favouriteBtn.setClickable(true);
                favouriteBtn.setBackgroundResource(0x7f0200af);
                Toast.makeText(WebViewActivity.this, 0x7f0b0277, 0).show();break;
                case 605: favouriteBtn.setClickable(true);break;
                case 606: mFavouriteHandler = (Handler)message.obj;break;
                default:super.handleMessage(message);
                return;
                }
               
            }

            
        }
;
    }

    private String getURL()
    {
        return (new StringBuilder()).append("/weather/UpdateContentFavorites?UserID=").append(Gl.getRegCode()).append("&Platform=Android").append("&Device=phone").append("&Version=").append(Gl.getVersion()).append("&BaseOSVer=").append(android.os.Build.VERSION.SDK).append("&Model=").append(URLEncoder.encode(Build.MODEL)).append("&PartnerKey=").append(Gl.getPartnerID()).append("&CityID=").append(WeatherData.getCityInfo(Gl.getCurrentCityIndex()).m_cityID).append("&ContentID=").append(mContentID).append("&VersionType=").append(Gl.getVersionType()).toString();
    }

    private boolean isClickable()
    {
        boolean flag = false;
        long l;
        long l1;
        MojiLog.d("WebViewActivity", (new StringBuilder()).append(WeatherIndexActivity.getCurrentDate()).append("--").append(Gl.getFavoriteDate(mCityID, mContentID)).toString());
        l = Date.parse(WeatherIndexActivity.getCurrentDate());
        l1 = Date.parse(Gl.getFavoriteDate(mCityID, mContentID));
        if(l > l1)
            flag = true;
 
        return flag;
 
    }

    private void lifeTextShare(String s)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", s);
        startActivity(Intent.createChooser(intent, getResources().getString(0x7f0b0124)));
    }

    private boolean sendFavourite()
    {
        MojiLog.d("WebViewActivity", (new StringBuilder()).append("c.moji001.com").append(getURL()).toString());
        String s;
		try {
			s = (new BufferedReader(new InputStreamReader(HttpUtil.doGet("c.moji001.com", getURL(), 0L).mInputStream))).readLine();
			 if(s != null && s.equals("0"))
		            Gl.setFavoriteDate(mCityID, mContentID, WeatherIndexActivity.getCurrentDate());
			 return true;
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}  
       
        
 
    }

    public void init()
    {
        mLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
        Bundle bundle = getIntent().getExtras();
        mCategory = bundle.getString("bundle_key_category");
        mName = bundle.getString("bundle_key_name");
        mEntry = bundle.getString("bundle_key_entry");
        mContentID = bundle.getInt("bundle_key_id");
        mCityID = bundle.getInt("bundle_key_city_id");
        mWebView = (WebView)findViewById(0x7f0d0247);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setScrollBarStyle(0);
        mWebView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(final WebView view, int i, String s, final String failingUrl)
            {
                super.onReceivedError(view, i, s, failingUrl);
                if(!isFinishing())
                {
                    if(mDialog == null)
                        mDialog = (new android.app.AlertDialog.Builder(WebViewActivity.this)).setTitle(0x7f0b002f).setIcon(0x7f0200c5).setMessage(0x7f0b00a1).setPositiveButton(0x7f0b002e, new android.content.DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                loadUrl(view, failingUrl);
                            }
 
 
                        }
).setNegativeButton(0x7f0b0018, new android.content.DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                finish();
                            }

                             

                    
                    
                        }
).create();
                    mDialog.show();
                }
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                loadUrl(webview, s);
                return true;
            }

             
        }
);
        mWebView.setWebChromeClient(new WebChromeClient() {

            public void onProgressChanged(WebView webview, int i)
            {
                if(i == 100)
                    mHandler.sendEmptyMessage(1);
                super.onProgressChanged(webview, i);
            }
 
        }
);
        mWebView.setDownloadListener(new DownloadListener() {

            public void onDownloadStart(String s, String s1, String s2, String s3, long l)
            {
                Uri uri = Uri.parse(s);
                startActivity(new Intent("android.intent.action.VIEW", uri));
            }

            
        }
);
        LinearLayout linearlayout = (LinearLayout)mLayoutInflater.inflate(0x7f030051, null);
        ((TextView)linearlayout.findViewById(0x7f0d01e0)).setTextColor(0xff000000);
        mProgressDialog = new Dialog(this, 0x7f0c0016);
        mProgressDialog.setContentView(linearlayout);
        mProgressDialog.show();
        TextView textview = (TextView)findViewById(0x7f0d0245);
        favouriteBtn = (ImageButton)findViewById(0x7f0d0244);
        shareBtn = (ImageButton)findViewById(0x7f0d0246);
        textview.setText(mCategory);
        if(!isClickable())
            favouriteBtn.setBackgroundResource(0x7f0200af);
        favouriteBtn.setOnClickListener(this);
        shareBtn.setOnClickListener(this);
        mFavouriteThread = new FavouriteThread(mHandler);
        mFavouriteThread.start();
    }

    public void loadUrl(final WebView view, final String url)
    {
        (new Thread() {

            public void run()
            {
                mHandler.sendEmptyMessage(0);
                MojiLog.d("WebViewActivity", (new StringBuilder()).append("loadUrl:").append(url).toString());
                view.loadUrl(url);
            }

             
        }
).start();
    }

    public void onClick(View view)
    {
        if(view != favouriteBtn) 
        {
        	if(view == shareBtn)
            {
                String s = (new StringBuilder()).append("#").append(mCategory).append("#").toString();
                String s1 = getResources().getString(0x7f0b0279);
                String s2 = mName;
                String s3 = getResources().getString(0x7f0b027a);
                String s4 = mEntry;
                lifeTextShare((new StringBuilder()).append(s).append(s1).append(s2).append(s3).append(s4).toString());
            }
        }
        	
        	else {
        if(!isClickable())
        {
            Toast.makeText(this, 0x7f0b0278, 0).show();
        } else
        {
            favouriteBtn.setClickable(false);
            mFavouriteHandler.sendMessage(mFavouriteHandler.obtainMessage(602));
        }
        	}
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(0x7f030073);
        init();
        loadUrl(mWebView, mEntry);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if(mProgressDialog != null)
            mProgressDialog.dismiss();
        if(mFavouriteHandler != null)
            mFavouriteHandler.sendMessage(mFavouriteHandler.obtainMessage(604));
        if(mFavouriteThread != null && mFavouriteThread.isAlive())
        {
            mFavouriteThread.setCancel();
            mFavouriteThread.interrupt();
        }
 
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag = true;
        if(i == 4 && mWebView.canGoBack())
            mWebView.goBack();
        else
        if(i == 4)
            finish();
        else
            flag = super.onKeyDown(i, keyevent);
        return flag;
    }

    private static final int HANDLER_KEY_HIDE_DIALOG = 1;
    private static final int HANDLER_KEY_SHOW_DIALOG = 0;
    private static final int NETWORK_HANDLER_BASE = 600;
    private static final int NETWORK_THREAD_OK = 601;
    private static final int NETWORK_THREAD_QUIT_LOOPER = 604;
    private static final int SEND_FAVORITE = 602;
    private static final int SEND_FAVORITE_FAIL = 606;
    private static final int SEND_FAVORITE_OK = 605;
    private static final String TAG = "WebViewActivity";
    private static final String TEXT_SHARE_TPYE = "text/plain";
    private ImageButton favouriteBtn;
    private String mCategory;
    private int mCityID;
    private int mContentID;
    private Dialog mDialog;
    private String mEntry;
    private Handler mFavouriteHandler;
    private FavouriteThread mFavouriteThread;
    Handler mHandler;
    private LayoutInflater mLayoutInflater;
    private String mName;
    Dialog mProgressDialog;
    WebView mWebView;
    private ImageButton shareBtn;




/*
    static Handler access$102(WebViewActivity webviewactivity, Handler handler)
    {
        webviewactivity.mFavouriteHandler = handler;
        return handler;
    }

*/



/*
    static Dialog access$202(WebViewActivity webviewactivity, Dialog dialog)
    {
        webviewactivity.mDialog = dialog;
        return dialog;
    }

*/


}
