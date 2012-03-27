// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherUpdateService.java

package com.moji.mjweather.service;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.*;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.util.Util;
import java.text.*;
import java.util.*;

// Referenced classes of package com.moji.mjweather.service:
//            AutoShareService

public class WeatherUpdateService extends Service
{
    private class UpdateSupervisor extends TimerTask
    {

        public void run()
        {
            if(mSubscriber != null)
            {
                com.moji.mjweather.common.WeatherUpdater.Result result = new com.moji.mjweather.common.WeatherUpdater.Result();
                result.errCode = 1;
                mSubscriber.doCallback(result);
            }
        }

        final WeatherUpdateService this$0;

        private UpdateSupervisor()
        {
            this$0 = WeatherUpdateService.this;
            super();
        }

    }

    private class CallbackImpl
        implements WeatherSubscriber
    {

        public void doCallback(com.moji.mjweather.common.WeatherUpdater.Result result)
        {
            MojiLog.d("WeatherUpdateService", (new StringBuilder()).append("errCode = ").append(result.errCode).toString());
            if(mTimer != null)
                mTimer.cancel();
            if(AbstractWeatherUpdater.isSucceed(result))
            {
                CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(result.cityIndex);
                Gl.Ct().deleteFile((new StringBuilder()).append(cityweatherinfo.m_cityID).append(".txt").toString());
                Gl.saveAutoUpdateFailCount(0);
                WeatherUpdateService.setNextUpdateTime();
                if(AutoShareService.needShareWeatherData())
                    AutoShareService.start();
            } else
            {
                if(Gl.getAutoUpdateFailCount() < 4)
                    Gl.saveAutoUpdateFailCount(1 + Gl.getAutoUpdateFailCount());
                WeatherUpdateService.setNextUpdateTime(true);
            }
            stopSelf();
        }

        final WeatherUpdateService this$0;

        private CallbackImpl()
        {
            this$0 = WeatherUpdateService.this;
            super();
        }

    }


    public WeatherUpdateService()
    {
    }

    private static long ajustForHighTraffic(long l)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        calendar.set(11, 8);
        calendar.set(12, 0);
        calendar.set(13, 0);
        if(Math.abs(calendar.getTimeInMillis() - l) < 0x1d4c0L)
        {
            MojiLog.d("WeatherUpdateService", (new StringBuilder()).append("random minutes = ").append(Gl.getRandomMinutes()).toString());
            l += 1000 * (60 * Gl.getRandomMinutes());
        }
        return l;
    }

    private static long getNextUpdateTime(boolean flag)
    {
        Date date;
        long l;
        CityWeatherInfo cityweatherinfo;
        date = new Date();
        l = date.getTime();
        cityweatherinfo = WeatherData.getCityInfo(Gl.getCurrentCityIndex());
        if(cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET && cityweatherinfo.m_cityID != 0) goto _L2; else goto _L1
_L1:
        long l1 = 0x5265c00L + l;
_L4:
        return l1;
_L2:
        Date date1 = Util.getDateByTime(Gl.getUpdateStartTime());
        Date date2 = Util.getDateByTime(Gl.getUpdateEndTime());
        long l2 = (long)(1000F * (3600F * Gl.getUpdateInterval()));
        Date date3 = new Date(ajustForHighTraffic(date1.getTime()));
        boolean flag1 = true;
        String s;
        long l3;
        if(date1.before(date2))
        {
            if(date.before(date3))
            {
                l = date1.getTime();
                flag1 = false;
            } else
            if(date.after(date2) || date.equals(date2))
            {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.set(6, 1 + calendar.get(6));
                calendar.set(11, date1.getHours());
                calendar.set(12, date1.getMinutes());
                calendar.set(13, 0);
                l = calendar.getTimeInMillis();
                flag1 = false;
            }
        } else
        if(date1.after(date2) && (date.after(date2) || date.equals(date2)) && date.before(date3))
        {
            l = date1.getTime();
            flag1 = false;
        }
        if(!flag1)
            break MISSING_BLOCK_LABEL_240;
        if(flag)
            break; /* Loop/switch isn't completed */
        s = (new StringBuilder()).append(cityweatherinfo.m_lastUpdateDate).append(" ").append(cityweatherinfo.m_lastUpdateTime).toString();
        MojiLog.d("WeatherUpdateService", (new StringBuilder()).append("last update time: ").append(s).toString());
        if(s.trim().equals(""))
            break MISSING_BLOCK_LABEL_240;
        l = l2 + DF.parse(s).getTime();
        if(l >= date.getTime())
            break MISSING_BLOCK_LABEL_240;
        l3 = date.getTime();
        l = l3;
_L5:
        l1 = ajustForHighTraffic(l);
        if(true) goto _L4; else goto _L3
        ParseException parseexception;
        parseexception;
        MojiLog.e("WeatherUpdateService", parseexception.toString());
          goto _L5
_L3:
        MojiLog.d("WeatherUpdateService", (new StringBuilder()).append("last update failed, retry after ").append(15 * Gl.getAutoUpdateFailCount()).append(" minutes").toString());
        l += 0xdbba0 * Gl.getAutoUpdateFailCount();
          goto _L5
    }

    private static boolean needDelay()
    {
        boolean flag = true;
        if(!Util.isAirplaneModeOn()) goto _L2; else goto _L1
_L1:
        MojiLog.d("WeatherUpdateService", "airplane mode is on");
_L4:
        return flag;
_L2:
        Date date = new Date();
        Date date1 = Util.getDateByTime(Gl.getUpdateStartTime());
        Date date2 = Util.getDateByTime(Gl.getUpdateEndTime());
        Date date3 = new Date(ajustForHighTraffic(date1.getTime()));
        if(date1.before(date2) ? !date.before(date3) && !date.after(date2) && !date.equals(date2) : !date1.after(date2) || !date.before(date3) || !date.after(date2) && !date.equals(date2))
        {
            CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(Gl.getCurrentCityIndex());
            if(cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET && cityweatherinfo.m_cityID != 0)
                flag = false;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static void setAlarm(long l)
    {
        if(MojiLog.isDevelopMode())
            MojiLog.d("WeatherUpdateService", (new StringBuilder()).append("next update time: ").append((new Date(l)).toString()).toString());
        Intent intent = new Intent(Gl.Ct(), com/moji/mjweather/service/WeatherUpdateService);
        PendingIntent pendingintent = PendingIntent.getService(Gl.Ct(), 0, intent, 0);
        AlarmManager alarmmanager = (AlarmManager)Gl.Ct().getSystemService("alarm");
        alarmmanager.cancel(pendingintent);
        alarmmanager.set(0, l, pendingintent);
    }

    public static void setNextUpdateTime()
    {
        setNextUpdateTime(false);
    }

    private static void setNextUpdateTime(boolean flag)
    {
        if(Gl.getAutoUpdate())
            if(Util.isAirplaneModeOn())
                MojiLog.d("WeatherUpdateService", "airplane mode is on, do nothing, waiting for change of android.net.conn.CONNECTIVITY_CHANGE.");
            else
                setAlarm(getNextUpdateTime(flag));
    }

    public static void start(Context context, boolean flag)
    {
        sNeedUpdateRightNow = flag;
        context.startService(new Intent(context, com/moji/mjweather/service/WeatherUpdateService));
    }

    public static void start(boolean flag)
    {
        start(Gl.Ct(), flag);
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        MojiLog.v("WeatherUpdateService", "onCreate");
        mSubscriber = new CallbackImpl();
        WeatherPublisher.getInstance().subscribe(mSubscriber);
        mTimer = new Timer();
    }

    public void onDestroy()
    {
        MojiLog.v("WeatherUpdateService", "onDestroy");
        WeatherPublisher.getInstance().unSubscribe(mSubscriber);
        if(mTimer != null)
            mTimer.cancel();
        super.onDestroy();
    }

    public void onStart(Intent intent, int i)
    {
        super.onStart(intent, i);
        MojiLog.v("WeatherUpdateService", "onStart");
        if(needDelay() && !sNeedUpdateRightNow)
        {
            setNextUpdateTime();
            stopSelf();
        } else
        {
            try
            {
                mTimer.schedule(new UpdateSupervisor(), 0x1d4c0L);
            }
            catch(Exception exception)
            {
                MojiLog.e("WeatherUpdateService", "error: ", exception);
            }
            AbstractWeatherUpdater.createInstance().update(Gl.getCurrentCityIndex(), true);
        }
        sNeedUpdateRightNow = false;
    }

    private static final int AROUND_HIGH_TRAFFIC = 0x1d4c0;
    private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final int HIGH_TRAFFIC_HOUR = 8;
    private static final int MAX_RETRY_TIMES = 4;
    private static final int RETRY_INTERVAL = 0xdbba0;
    private static final int RETRY_WHEN_NO_CITY = 0x5265c00;
    private static final String TAG = "WeatherUpdateService";
    private static final long UPDATE_TIMEOUT = 0x1d4c0L;
    private static boolean sNeedUpdateRightNow = false;
    private CallbackImpl mSubscriber;
    private Timer mTimer;




}
