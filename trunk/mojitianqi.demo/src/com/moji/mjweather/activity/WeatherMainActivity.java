// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherMainActivity.java

package com.moji.mjweather.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.*;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import com.adm.common.ExchangeConstants;
import com.adm.controller.ReportThread;
import com.adm.view.ExchangeViewManager;
import com.moji.mjweather.CDialogManager;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.*;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.data.WeatherMainInfo;
import com.moji.mjweather.service.StatsService;
import com.moji.mjweather.util.*;
import com.moji.mjweather.view.*;
import java.util.*;

// Referenced classes of package com.moji.mjweather.activity:
//            AddCityActivity, TutorialActivity, CityManagerActivity

public class WeatherMainActivity extends Activity
    implements android.view.View.OnClickListener
{
    class WeathearTabCheckedCallBackImpl
        implements WeatherTabCheckedCallback
    {

        public void doCallback()
        {
            if(Gl.isChangedCity())
            {
                Gl.setChangedCity(false);
                mWorkSpace.loadCityView();
            }
            mWorkSpace.setToScreen(Gl.getCurrentCityIndex());
        }

        final WeatherMainActivity this$0;

        WeathearTabCheckedCallBackImpl()
        {
            this$0 = WeatherMainActivity.this;
            super();
        }
    }

    class UpdateCallbackImpl
        implements WeatherSubscriber
    {

        public void doCallback(com.moji.mjweather.common.WeatherUpdater.Result result)
        {
            Message message = new Message();
            message.what = 0;
            message.obj = result;
            MainHandler.sendMessage(message);
        }

        final WeatherMainActivity this$0;

        UpdateCallbackImpl()
        {
            this$0 = WeatherMainActivity.this;
            super();
        }
    }


    public WeatherMainActivity()
    {
        mCurrentCityIdx = 0;
        mFadeAnim = null;
        mIsFromCityView = false;
        MainHandler = new Handler() {

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                message.what;
                JVM INSTR tableswitch 0 4: default 44
            //                           0 45
            //                           1 62
            //                           2 77
            //                           3 110
            //                           4 127;
                   goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
                return;
_L2:
                doUpdateResult((com.moji.mjweather.common.WeatherUpdater.Result)message.obj);
                continue; /* Loop/switch isn't completed */
_L3:
                mBroadcast.setImageResource(0x7f02014a);
                continue; /* Loop/switch isn't completed */
_L4:
                doAddCityResult(message);
                mWorkSpace.addCity(message.arg1);
                doUpdateCityWeather(true);
                continue; /* Loop/switch isn't completed */
_L5:
                mWorkSpace.removeCity(message.arg1);
                continue; /* Loop/switch isn't completed */
_L6:
                mWorkSpace.addCity(message.arg1);
                if(true) goto _L1; else goto _L7
_L7:
            }

            final WeatherMainActivity this$0;

            
            {
                this$0 = WeatherMainActivity.this;
                super();
            }
        }
;
    }

    private void addUmengAd()
    {
        mExchangeViewManager = new ExchangeViewManager(this);
        if(sReportListner == null)
            sReportListner = new com.adm.controller.ReportThread.ReportListener() {

                public void onReportEnd(int i)
                {
                    MojiLog.d("WeatherMainActivity", "onReportEnd");
                }

                public void onReportStart(Map map)
                {
                    StringBuffer stringbuffer = new StringBuffer();
                    Iterator iterator = map.keySet().iterator();
                    do
                    {
                        if(!iterator.hasNext())
                            break;
                        String s = (String)iterator.next();
                        MojiLog.d("exchange_demo", stringbuffer.toString());
                        stringbuffer.append((new StringBuilder()).append(s).append(": ").append(map.get(s).toString()).toString());
                        if(stringbuffer.toString().equals("action_type: 3") || stringbuffer.toString().equals("action_type: 7"))
                        {
                            StatsUtil.updateStatsAdDown();
                            MojiLog.d("WeatherMainActivity", "AdDown + 1");
                        } else
                        if(stringbuffer.toString().equals("action_type: 0"))
                        {
                            StatsUtil.updateStatsAdView();
                            MojiLog.d("WeatherMainActivity", "AdArea + 1");
                        }
                    } while(true);
                }

                final WeatherMainActivity this$0;

            
            {
                this$0 = WeatherMainActivity.this;
                super();
            }
            }
;
        ReportThread.unregisterReportListener(sReportListner);
        ReportThread.registerReportListener(sReportListner);
        ExchangeConstants.ONLY_CHINESE = false;
        MojiLog.d("WeatherMainActivity", (new StringBuilder()).append("AdOn = ").append(Gl.getAdON()).toString());
        if(Gl.getAdON())
        {
            mAdUmeng.setVisibility(0);
            Drawable drawable = getResources().getDrawable(0x7f02016d);
            ExchangeViewManager exchangeviewmanager = mExchangeViewManager;
            ImageView imageview = mAdUmeng;
            Drawable adrawable[] = new Drawable[1];
            adrawable[0] = drawable;
            exchangeviewmanager.addView(7, imageview, adrawable);
        } else
        {
            mAdUmeng.setVisibility(8);
        }
    }

    private void bindCheckNeedUpdate(Workspace workspace)
    {
        doUpdateCityWeather(true);
        workspace.setCheckNeedUpdateListener(new com.moji.mjweather.view.Workspace.OnCheckNeedUpdateListener() {

            public void onCheckNeedUpdate(int i)
            {
                doUpdateCityWeather(true);
            }

            final WeatherMainActivity this$0;

            
            {
                this$0 = WeatherMainActivity.this;
                super();
            }
        }
);
    }

    private void cancelUpdateWeather(CityWeatherInfo cityweatherinfo, boolean flag)
    {
        if(cityweatherinfo == null)
            cityweatherinfo = WeatherData.getCityInfo(Gl.getCurrentCityIndex());
        mUpdateWeather.setImageResource(0x7f02014e);
        isUpdating = false;
        Gl.setIsLocationbyGPS(false);
        if(mWeatherUpdater != null)
            mWeatherUpdater.cancel();
        if(mUpdateCallbackImpl != null)
            WeatherPublisher.getInstance().unSubscribe(mUpdateCallbackImpl);
        mUpdateLayout.setVisibility(8);
        if(mPublicTextView != null)
            mPublicTextView.setVisibility(0);
        if(cityweatherinfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING)
            if(cityweatherinfo.m_lastUpdateTime.length() <= 0)
                cityweatherinfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE;
            else
                cityweatherinfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK;
        if(flag)
            Toast.makeText(this, 0x7f0b0039, 0).show();
    }

    private void checkAddCity()
    {
        if(WeatherData.getCityInfo(0).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
        {
            Gl.setHandler(MainHandler);
            Intent intent = new Intent(this, com/moji/mjweather/activity/AddCityActivity);
            Bundle bundle = new Bundle();
            bundle.putInt("cityindex", 0);
            bundle.putBoolean("isNoDisplayLocation", true);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    private void checkStopBroadcast()
    {
        if(PlayerUtil.isBroadcasting)
            PlayerUtil.manualBroadcast(mCDialogManager, MainHandler);
    }

    private void checkTuorialDisplay()
    {
        if(Gl.getIsFirstRun())
            startActivityForResult(new Intent(this, com/moji/mjweather/activity/TutorialActivity), 100);
        else
            checkAddCity();
    }

    private void doAddCityResult(Message message)
    {
        int i = 0;
        while(i < 9) 
        {
            if(WeatherData.getCityInfo(i).m_cityID == message.arg2)
            {
                mCDialogManager.CancelCurrentDialog();
                if(message.arg2 != -1)
                    mCDialogManager.ShowMsgOKDialog(0x7f0b0035);
                else
                    mCDialogManager.ShowMsgOKDialog(0x7f0b003f);
            }
            i++;
        }
        CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(message.arg1);
        cityweatherinfo.Clean();
        cityweatherinfo.m_cityID = message.arg2;
        cityweatherinfo.mCityName = message.obj.toString();
        cityweatherinfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE;
        cityweatherinfo.mWeatherMainInfo.mWeatherDescription = "";
        cityweatherinfo.m_lastUpdateTime = "";
        Gl.saveCityInfo(message.arg1, cityweatherinfo);
        Gl.saveCurrentCityIndex(message.arg1);
    }

    private void doBroadcast()
    {
        if(WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
        {
            mCDialogManager.showNotifyAddCityDialog();
        } else
        {
            PlayerUtil.manualBroadcast(mCDialogManager, MainHandler);
            if(PlayerUtil.isBroadcasting)
                mBroadcast.setImageResource(0x7f02014b);
            else
                mBroadcast.setImageResource(0x7f02014a);
        }
    }

    private void doIntentCityManager()
    {
        if(WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING)
        {
            Toast.makeText(this, 0x7f0b0041, 0).show();
        } else
        {
            Gl.setChangedCity(false);
            startActivityForResult(new Intent(this, com/moji/mjweather/activity/CityManagerActivity), 99);
        }
    }

    private void doUpdateCityWeather(boolean flag)
    {
        CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(Gl.getCurrentCityIndex());
        if((!flag || cityweatherinfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE) && cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
            if(!Util.isConnectInternet(this))
            {
                mCDialogManager.CancelCurrentDialog();
                mCDialogManager.ShowMsgOKDialog(0x7f0b0032);
            } else
            {
                mUpdateLayout = (LinearLayout)mWorkSpace.getChildAt(mWorkSpace.getCurrentScreen()).findViewById(0x7f0d0106);
                if(cityweatherinfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK)
                    mPublicTextView = (TextView)mWorkSpace.getChildAt(mWorkSpace.getCurrentScreen()).findViewById(0x7f0d0117);
                if(isUpdating)
                    cancelUpdateWeather(cityweatherinfo, true);
                else
                    startUpdateWeather();
            }
    }

    private void doUpdateResult(com.moji.mjweather.common.WeatherUpdater.Result result)
    {
        if(AbstractWeatherUpdater.isSucceed(result))
        {
            CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(result.cityIndex);
            Gl.Ct().deleteFile((new StringBuilder()).append(cityweatherinfo.m_cityID).append(".txt").toString());
            mWorkSpace.replaceCity(Gl.getCurrentCityIndex(), false);
            Gl.setNeedNotifyTrendState(true);
        } else
        {
            mCDialogManager.CancelCurrentDialog();
            mCDialogManager.ShowMsgOKDialogFromString((String)result.errMsg);
        }
        cancelUpdateWeather(null, false);
    }

    private void forFirstRun()
    {
        if(Gl.getIsFirstRun())
        {
            if(!Gl.getAdON())
                StatsService.checkAdSwitchAsync();
            StatsUtil.setNextSendTime(false);
            if(PlayerUtil.isDataExpired())
            {
                FileUtil.delFile(PlayerUtil.TTS_DATA_BG_PATH);
                Toast.makeText(Gl.Ct(), 0x7f0b0221, 1).show();
            }
        }
    }

    private void initMain()
    {
        mWorkSpace = (Workspace)findViewById(0x7f0d01d7);
        mCDialogManager = new CDialogManager(this, MainHandler);
        mIndexControlView = (CityIndexControlView)findViewById(0x7f0d01d9);
        mIndexControlView.bindScrollIndexView(mWorkSpace);
        mCityWeatherBgSwitcher = (CityWeatherBgSwitcher)getParent().findViewById(0x7f0d01ad);
        mCityWeatherBgSwitcher.bindScrollBgView(mWorkSpace);
        mWorkSpace.setBgSwitcher(mCityWeatherBgSwitcher);
        mCityNameView = (CityNameView)findViewById(0x7f0d01dd);
        mCityNameView.bindScrollCityNameView(mWorkSpace);
        mCityNameView.setOnClickListener(this);
        mCityManager = (ImageView)findViewById(0x7f0d01db);
        mCityManager.setOnClickListener(this);
        mBroadcast = (ImageView)findViewById(0x7f0d01de);
        mBroadcast.setOnClickListener(this);
        mUpdateWeather = (ImageView)findViewById(0x7f0d01dc);
        mUpdateWeather.setOnClickListener(this);
        mAdUmeng = (ImageView)findViewById(0x7f0d01da);
        mAdUmeng.setOnClickListener(this);
        bindCheckNeedUpdate(mWorkSpace);
        mCurrentCityIdx = Gl.getCurrentCityIndex();
    }

    private void initWindow()
    {
        requestWindowFeature(1);
        getWindow().setFormat(-2);
    }

    private void startUpdateWeather()
    {
        mUpdateWeather.setImageResource(0x7f02014f);
        isUpdating = true;
        if(mUpdateCallbackImpl == null)
            mUpdateCallbackImpl = new UpdateCallbackImpl();
        WeatherPublisher.getInstance().unSubscribe(mUpdateCallbackImpl);
        WeatherPublisher.getInstance().subscribe(mUpdateCallbackImpl);
        if(mWeatherUpdater == null)
            mWeatherUpdater = AbstractWeatherUpdater.createInstance();
        mWeatherUpdater.update(Gl.getCurrentCityIndex());
        WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING;
        mUpdateLayout.setVisibility(0);
        if(mPublicTextView != null)
            mPublicTextView.setVisibility(8);
    }

    private void subscribeWeathertabCallBack()
    {
        if(mWeathearTabCallBackImpl == null)
            mWeathearTabCallBackImpl = new WeathearTabCheckedCallBackImpl();
        WeatherTabPublisher.getInstance().unSubscribe(mWeathearTabCallBackImpl);
        WeatherTabPublisher.getInstance().subscribe(mWeathearTabCallBackImpl);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        mIsFromCityView = true;
        if(i != 99) goto _L2; else goto _L1
_L1:
        if(Gl.isChangedCity())
        {
            Gl.setChangedCity(false);
            mWorkSpace.loadCityView();
        }
        mWorkSpace.setToScreen(Gl.getCurrentCityIndex());
_L4:
        return;
_L2:
        if(i == 100)
            checkAddCity();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onClick(View view)
    {
        if(view == mCityManager || view == mCityNameView)
            doIntentCityManager();
        else
        if(view == mBroadcast)
            doBroadcast();
        else
        if(view == mUpdateWeather)
            doUpdateCityWeather(false);
        else
        if(view != mAdUmeng);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        MojiLog.v("WeatherMainActivity", "onCreate");
        initWindow();
        setContentView(0x7f03004f);
        initMain();
        forFirstRun();
        checkTuorialDisplay();
        addUmengAd();
        subscribeWeathertabCallBack();
        mFadeAnim = AnimationUtils.loadAnimation(this, 0x7f040008);
        mFadeAnim.setDuration(300L);
    }

    protected void onDestroy()
    {
        MojiLog.v("WeatherMainActivity", "onDestroy");
        super.onDestroy();
        if(mWeathearTabCallBackImpl != null)
            WeatherTabPublisher.getInstance().unSubscribe(mWeathearTabCallBackImpl);
        mCityWeatherBgSwitcher.removeTimer();
        checkStopBroadcast();
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        boolean flag = true;
        if(i == 4 && isUpdating)
        {
            if(isUpdating)
                cancelUpdateWeather(null, flag);
        } else
        {
            flag = super.onKeyUp(i, keyevent);
        }
        return flag;
    }

    protected void onPause()
    {
        super.onPause();
        MojiLog.v("WeatherMainActivity", "onPause");
        if(isUpdating)
            cancelUpdateWeather(null, true);
    }

    protected void onResume()
    {
        super.onResume();
        MojiLog.v("WeatherMainActivity", "onResume");
        if(android.os.Build.VERSION.SDK_INT > 4)
            if(mIsFromCityView)
            {
                mIsFromCityView = false;
                if(mCurrentCityIdx != Gl.getCurrentCityIndex())
                {
                    mCurrentCityIdx = Gl.getCurrentCityIndex();
                    ((ViewGroup)findViewById(0x7f0d01d7)).startAnimation(mFadeAnim);
                }
            } else
            {
                ((ViewGroup)findViewById(0x7f0d01d7)).startAnimation(mFadeAnim);
            }
        StatsUtil.updateStatsPv(com.moji.mjweather.util.StatsUtil.StatsPv.PV_WW);
    }

    protected void onStop()
    {
        MojiLog.v("WeatherMainActivity", "onStop");
        super.onStop();
        Gl.saveCurrentCityIndex(Gl.getCurrentCityIndex());
    }

    public static final int CODE_CITY_MANAGER_REQUEST = 99;
    public static final int CODE_TUTORIAL_REQUEST = 100;
    private static final int FADE_ANI_DURATION = 300;
    private static final String TAG = "WeatherMainActivity";
    private static final String UMENG_AREA_VIEW = "action_type: 0";
    private static final String UMENG_DOWNLOAD_CLICK = "action_type: 3";
    private static final String UMENG_DOWNLOAD_CLICK_DIRECT = "action_type: 7";
    private static com.adm.controller.ReportThread.ReportListener sReportListner;
    Handler MainHandler;
    private boolean isUpdating;
    private ImageView mAdUmeng;
    private ImageView mBroadcast;
    private CDialogManager mCDialogManager;
    private ImageView mCityManager;
    private CityNameView mCityNameView;
    private CityWeatherBgSwitcher mCityWeatherBgSwitcher;
    private int mCurrentCityIdx;
    private ExchangeViewManager mExchangeViewManager;
    private Animation mFadeAnim;
    private CityIndexControlView mIndexControlView;
    private boolean mIsFromCityView;
    private TextView mPublicTextView;
    private UpdateCallbackImpl mUpdateCallbackImpl;
    private LinearLayout mUpdateLayout;
    private ImageView mUpdateWeather;
    private WeathearTabCheckedCallBackImpl mWeathearTabCallBackImpl;
    private WeatherUpdater mWeatherUpdater;
    private Workspace mWorkSpace;





}
