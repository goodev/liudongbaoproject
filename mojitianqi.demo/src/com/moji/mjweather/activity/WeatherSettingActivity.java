// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherSettingActivity.java

package com.moji.mjweather.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.*;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import com.moji.mjweather.CDialogManager;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.settings.*;
import com.moji.mjweather.util.*;
import java.util.Map;

public class WeatherSettingActivity extends Activity
    implements android.view.View.OnClickListener
{

    public WeatherSettingActivity()
    {
        mHandler = new Handler() {

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                message.what;
                JVM INSTR tableswitch 106 107: default 32
            //                           106 33
            //                           107 185;
                   goto _L1 _L2 _L3
_L1:
                return;
_L2:
                if(message.obj.toString().length() > 1)
                {
                    if(!Util.isConnectInternet(WeatherSettingActivity.this))
                    {
                        mDialogMgr.CancelCurrentDialog();
                        mDialogMgr.ShowMsgOKDialog(0x7f0b0160);
                    } else
                    {
                        getNetworkThreadHandler();
                        Message message1 = mWorkerThreadHandler.obtainMessage(5);
                        message1.obj = message.obj;
                        mWorkerThreadHandler.sendMessage(message1);
                        mDialogMgr.CancelCurrentDialog();
                        mDialogMgr.ShowMsgOKDialog(0x7f0b0162);
                    }
                } else
                {
                    mDialogMgr.CancelCurrentDialog();
                    mDialogMgr.ShowSendSuggestDialog();
                    Toast.makeText(WeatherSettingActivity.this, 0x7f0b0163, 0).show();
                }
                continue; /* Loop/switch isn't completed */
_L3:
                Map map = (Map)message.obj;
                mDialogMgr.CancelCurrentDialog();
                if(map != null)
                {
                    String s = (String)map.get("info");
                    if(s != null && !s.equals(""))
                        mDialogMgr.showNewVersionDialog((String)map.get("info"), 0x7f0b001d, map);
                    else
                        mDialogMgr.showNewVersionDialog(getResources().getString(0x7f0b0056), 0x7f0b0024, null);
                } else
                {
                    mDialogMgr.showNewVersionDialog(getResources().getString(0x7f0b0057), 0, null);
                }
                if(true) goto _L1; else goto _L4
_L4:
            }

            final WeatherSettingActivity this$0;

            
            {
                this$0 = WeatherSettingActivity.this;
                super();
            }
        }
;
    }

    private void getNetworkThreadHandler()
    {
        if(mWorkerThreadHandler == null)
            mWorkerThreadHandler = mNetworkThread.GetMsgQueueHandler();
    }

    private void initViews()
    {
        mDesktopSetting = (RelativeLayout)findViewById(0x7f0d0063);
        mShareSetting = (RelativeLayout)findViewById(0x7f0d0066);
        mNoticeSetting = (RelativeLayout)findViewById(0x7f0d0068);
        mAutoVoiceSetting = (RelativeLayout)findViewById(0x7f0d006b);
        mAutoUpdateSetting = (RelativeLayout)findViewById(0x7f0d019a);
        mGPSSetting = (RelativeLayout)findViewById(0x7f0d019e);
        mCheckVersion = (RelativeLayout)findViewById(0x7f0d01a2);
        mSendSuggest = (RelativeLayout)findViewById(0x7f0d01a5);
        mMojiHelp = (RelativeLayout)findViewById(0x7f0d01a7);
        mMojiAbout = (RelativeLayout)findViewById(0x7f0d01a9);
        mScrollView = (ScrollView)findViewById(0x7f0d0195);
        mDesktopSetting.setOnClickListener(this);
        mShareSetting.setOnClickListener(this);
        mNoticeSetting.setOnClickListener(this);
        mAutoVoiceSetting.setOnClickListener(this);
        mAutoUpdateSetting.setOnClickListener(this);
        mGPSSetting.setOnClickListener(this);
        mCheckVersion.setOnClickListener(this);
        mSendSuggest.setOnClickListener(this);
        mMojiHelp.setOnClickListener(this);
        mMojiAbout.setOnClickListener(this);
        mSettingLayout = (LinearLayout)findViewById(0x7f0d0192);
        mSettingLayout.setBackgroundDrawable(UiUtil.getBgBitmapDrawable());
        fade = AnimationUtils.loadAnimation(this, 0x7f040009);
        mScrollView.startAnimation(fade);
    }

    public void onClick(View view)
    {
        if(view != mDesktopSetting) goto _L2; else goto _L1
_L1:
        startActivity(new Intent(this, com/moji/mjweather/settings/DesktopSettingActivity));
_L4:
        return;
_L2:
        if(view == mShareSetting)
            startActivity(new Intent(this, com/moji/mjweather/settings/ShareSettingActivity));
        else
        if(view == mNoticeSetting)
            startActivity(new Intent(this, com/moji/mjweather/settings/NoticeSettingActivity));
        else
        if(view == mAutoVoiceSetting)
            startActivity(new Intent(this, com/moji/mjweather/settings/AutoVoiceSettingActivity));
        else
        if(view == mAutoUpdateSetting)
            startActivity(new Intent(this, com/moji/mjweather/settings/AutoUpdateSettingActivity));
        else
        if(view == mGPSSetting)
            startActivity(new Intent(this, com/moji/mjweather/settings/GPSSettingActivity));
        else
        if(view == mCheckVersion)
        {
            if(!Util.isConnectInternet(this))
            {
                mDialogMgr.CancelCurrentDialog();
                mDialogMgr.ShowMsgOKDialog(0x7f0b0160);
            } else
            {
                getNetworkThreadHandler();
                Message message = mWorkerThreadHandler.obtainMessage(6);
                mWorkerThreadHandler.sendMessage(message);
                mDialogMgr.CancelCurrentDialog();
                mDialogMgr.ShowMsgOKDialog(0x7f0b0161);
            }
        } else
        if(view == mSendSuggest)
        {
            if(!Util.isConnectInternet(this))
            {
                mDialogMgr.CancelCurrentDialog();
                mDialogMgr.ShowMsgOKDialog(0x7f0b0160);
            } else
            {
                mDialogMgr.ShowSendSuggestDialog();
            }
        } else
        if(view == mMojiHelp)
            startActivity(new Intent(this, com/moji/mjweather/settings/MojiHelpActivity));
        else
        if(view == mMojiAbout)
            startActivity(new Intent(this, com/moji/mjweather/settings/MojiAboutActivity));
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        MojiLog.v("WeatherSettingActivity", "onCreate");
        requestWindowFeature(1);
        setContentView(0x7f03004a);
        initViews();
        mDialogMgr = new CDialogManager(this, mHandler);
        mNetworkThread = new AsyncNetworkThread(mHandler, this);
        mNetworkThread.start();
    }

    protected void onResume()
    {
        mScrollView.startAnimation(fade);
        super.onResume();
    }

    private static final String TAG = "WeatherSettingActivity";
    private static final int TYPE_STRING_SIZE = 1;
    private Animation fade;
    private RelativeLayout mAutoUpdateSetting;
    private RelativeLayout mAutoVoiceSetting;
    private RelativeLayout mCheckVersion;
    private RelativeLayout mDesktopSetting;
    private CDialogManager mDialogMgr;
    private RelativeLayout mGPSSetting;
    private Handler mHandler;
    private RelativeLayout mMojiAbout;
    private RelativeLayout mMojiHelp;
    private AsyncNetworkThread mNetworkThread;
    private RelativeLayout mNoticeSetting;
    private ScrollView mScrollView;
    private RelativeLayout mSendSuggest;
    private LinearLayout mSettingLayout;
    private RelativeLayout mShareSetting;
    private Handler mWorkerThreadHandler;



}
