// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AutoShareService.java

package com.moji.mjweather.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.*;
import android.telephony.SmsManager;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.data.*;
import com.moji.mjweather.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class AutoShareService extends Service
    implements Runnable
{
    public static final class ChannelType extends Enum
    {

        public static ChannelType valueOf(String s)
        {
            return (ChannelType)Enum.valueOf(com/moji/mjweather/service/AutoShareService$ChannelType, s);
        }

        public static ChannelType[] values()
        {
            return (ChannelType[])$VALUES.clone();
        }

        private static final ChannelType $VALUES[];
        public static final ChannelType CHANNEL_KAIXIN;
        public static final ChannelType CHANNEL_RENREN;
        public static final ChannelType CHANNEL_SINA;
        public static final ChannelType CHANNEL_TENCENT;

        static 
        {
            CHANNEL_SINA = new ChannelType("CHANNEL_SINA", 0);
            CHANNEL_TENCENT = new ChannelType("CHANNEL_TENCENT", 1);
            CHANNEL_RENREN = new ChannelType("CHANNEL_RENREN", 2);
            CHANNEL_KAIXIN = new ChannelType("CHANNEL_KAIXIN", 3);
            ChannelType achanneltype[] = new ChannelType[4];
            achanneltype[0] = CHANNEL_SINA;
            achanneltype[1] = CHANNEL_TENCENT;
            achanneltype[2] = CHANNEL_RENREN;
            achanneltype[3] = CHANNEL_KAIXIN;
            $VALUES = achanneltype;
        }

        private ChannelType(String s, int i)
        {
            super(s, i);
        }
    }

    class CIncomingHandler extends Handler
    {

        public void handleMessage(Message message)
        {
            String s;
            s = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
            MojiLog.i("AutoShareService.CIncomingHandler", (new StringBuilder()).append(" msg.what = ").append(message.what).toString());
            message.what;
            JVM INSTR tableswitch 101 105: default 88
        //                       101 99
        //                       102 88
        //                       103 110
        //                       104 88
        //                       105 117;
               goto _L1 _L2 _L1 _L3 _L1 _L4
_L1:
            AutoShareService.JoinThread();
            stopSelf();
            return;
_L2:
            Gl.saveUpdateFailedCount(1 + Gl.getUpdateFailedCount());
            continue; /* Loop/switch isn't completed */
_L3:
            Gl.saveLastSuccessShareDate(s);
            continue; /* Loop/switch isn't completed */
_L4:
            Gl.saveLastSuccessShareDate(s);
            if(true) goto _L1; else goto _L5
_L5:
        }

        private static final String TAG = "AutoShareService.CIncomingHandler";
        final AutoShareService this$0;

        public CIncomingHandler(Looper looper)
        {
            this$0 = AutoShareService.this;
            super(looper);
        }
    }


    public AutoShareService()
    {
        m_Context = null;
        mServiceHandler = null;
    }

    private static void JoinThread()
    {
        MojiLog.v("AutoShareService", "JoinThread");
        if(mThread == null)
            break MISSING_BLOCK_LABEL_23;
        mThread.join(1000L);
_L1:
        return;
        Exception exception;
        exception;
        MojiLog.e("AutoShareService", "jointhread error", exception);
          goto _L1
    }

    private boolean NeedSendSMS()
    {
        MojiLog.v("AutoShareService", "NeedSendSMS ");
        if(mCOAuthShareSqliteManager == null)
            mCOAuthShareSqliteManager = new ShareOAuthShareSqliteManager(this);
        return mCOAuthShareSqliteManager.getSendSMSCount();
    }

    private boolean NeedShareMicroBlog()
    {
        MojiLog.v("AutoShareService", "NeedShareMicroBlog ");
        if(mCOAuthShareSqliteManager == null)
            mCOAuthShareSqliteManager = new ShareOAuthShareSqliteManager(this);
        return mCOAuthShareSqliteManager.getShareMicroBlogCount();
    }

    private int SendWeatherDataToMicroBlog(String s, String s1)
    {
        SQLiteDatabase sqlitedatabase;
        Cursor cursor;
        int i;
        MojiLog.v("AutoShareService", "SendWeatherDataToMicroBlog ");
        if(mCOAuthShareSqliteManager == null)
            mCOAuthShareSqliteManager = new ShareOAuthShareSqliteManager(this);
        sqlitedatabase = mCOAuthShareSqliteManager.dbOpenHelper.getReadableDatabase();
        cursor = sqlitedatabase.rawQuery("select * from ACCOUNT ORDER BY id ASC", null);
        i = 0;
_L4:
        int j;
        int k;
        if(!cursor.moveToNext())
            break MISSING_BLOCK_LABEL_264;
        String s2 = cursor.getString(1);
        String s3 = cursor.getString(2);
        String s4 = cursor.getString(3);
        j = 0;
        if(s1.equals("0"))
        {
            if(s4.equals(ChannelType.CHANNEL_SINA.toString()))
                j = ShareMicroBlogUtil.autoSharMicroBlog(s2, s3, s, 202, true, 203).intValue();
            else
            if(s4.equals(ChannelType.CHANNEL_KAIXIN.toString()))
                j = ShareMicroBlogUtil.autoSharMicroBlog(s2, s3, s, 202, true, 303).intValue();
            break MISSING_BLOCK_LABEL_313;
        }
        UiUtil.savePictureShot(ShareMicroBlogUtil.saveCityViewBitmap(this));
        if(s4.equals(ChannelType.CHANNEL_SINA.toString()))
        {
            j = ShareMicroBlogUtil.autoSharMicroBlog(s2, s3, s, 202, false, 203).intValue();
            break MISSING_BLOCK_LABEL_313;
        }
        if(!s4.equals(ChannelType.CHANNEL_KAIXIN.toString()))
            break MISSING_BLOCK_LABEL_313;
        k = ShareMicroBlogUtil.autoSharMicroBlog(s2, s3, s, 202, false, 303).intValue();
        j = k;
        break MISSING_BLOCK_LABEL_313;
        cursor.close();
        sqlitedatabase.close();
_L2:
        return i;
        Exception exception1;
        exception1;
        cursor.close();
        sqlitedatabase.close();
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        cursor.close();
        sqlitedatabase.close();
        throw exception;
        if(j != 0)
            i++;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private boolean SendWeatherDataToSMSContect(String s)
    {
        MojiLog.v("AutoShareService", "SendWeatherDataToSMSContect");
        boolean flag;
        if(s != null && !s.equals(""))
        {
            SmsManager smsmanager = SmsManager.getDefault();
            ArrayList arraylist = smsmanager.divideMessage(s);
            for(Iterator iterator = getContactsList().iterator(); iterator.hasNext();)
            {
                String s1 = (String)iterator.next();
                Iterator iterator1 = arraylist.iterator();
                while(iterator1.hasNext()) 
                    smsmanager.sendTextMessage(s1, null, (String)iterator1.next(), null, null);
            }

            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    private List getContactsList()
    {
        if(mCOAuthShareSqliteManager == null)
            mCOAuthShareSqliteManager = new ShareOAuthShareSqliteManager(this);
        SQLiteDatabase sqlitedatabase = mCOAuthShareSqliteManager.dbOpenHelper.getWritableDatabase();
        Cursor cursor = sqlitedatabase.rawQuery("select * from contacts", null);
        int i = cursor.getCount();
        String as[] = new String[i];
        ArrayList arraylist = new ArrayList();
        cursor.moveToPosition(-1);
        for(int j = 0; j < i && cursor.moveToNext(); j++)
        {
            as[j] = cursor.getString(2);
            arraylist.add(as[j]);
        }

        sqlitedatabase.close();
        return arraylist;
    }

    public static boolean needShareWeatherData()
    {
        boolean flag;
        flag = false;
        MojiLog.v("AutoShareService", "NeedShareWeatherData ");
        if(Gl.getEnableAutoShare()) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        String s = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        if(MojiLog.isDevelopMode())
            MojiLog.d("AutoShareService", (new StringBuilder()).append("dateInString = ").append(s).append(", GetLastTryShareDate() = ").append(Gl.getLastTryShareDate()).toString());
        if(!s.equals(Gl.getLastTryShareDate()))
        {
            Gl.saveLastTryShareDate(s);
            flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static void start()
    {
        Gl.Ct().startService(new Intent(Gl.Ct(), com/moji/mjweather/service/AutoShareService));
    }

    public IBinder onBind(Intent intent)
    {
        MojiLog.v("AutoShareService", "onBind");
        return null;
    }

    public void onDestroy()
    {
        MojiLog.v("AutoShareService", "onDestroy");
        mServiceHandler = null;
    }

    public void onStart(Intent intent, int i)
    {
        super.onStart(intent, i);
        MojiLog.v("AutoShareService", "onStart");
        if(mServiceHandler == null)
            mServiceHandler = new CIncomingHandler(Looper.getMainLooper());
        mThread = new Thread(this);
        mThread.start();
    }

    public void run()
    {
        int i;
label0:
        {
            int j;
            try
            {
                i = Gl.getAutoShareCity().intValue();
                if(i >= 0 && i <= 8)
                    break label0;
                j = Gl.getCurrentCityIndex();
            }
            catch(Exception exception)
            {
                MojiLog.e("AutoShareService", exception.getMessage());
                mServiceHandler.sendEmptyMessageDelayed(101, 500L);
                MojiLog.d("AutoShareService", "run return at1");
                continue; /* Loop/switch isn't completed */
            }
            i = j;
        }
        if(MojiLog.isDevelopMode())
            MojiLog.d("AutoShareService", (new StringBuilder()).append("cityIndex = ").append(i).append(", NeedUpdateWeatherData = ").append(Util.isNeedUpdateWeatherData(i)).toString());
        if(!Util.isNeedUpdateWeatherData(i)) goto _L2; else goto _L1
_L1:
        if(Util.updateWeatherData(i)) goto _L4; else goto _L3
_L3:
        mServiceHandler.sendEmptyMessageDelayed(101, 500L);
        MojiLog.d("AutoShareService", "run return at2");
_L6:
        return;
_L4:
        CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(i);
        Gl.Ct().deleteFile((new StringBuilder()).append(cityweatherinfo.m_cityID).append(".txt").toString());
_L2:
        if(NeedSendSMS())
        {
            StatsUtil.updateStatsCount(com.moji.mjweather.util.StatsUtil.StatsCount.COUNT_ASMS);
            if(!SendWeatherDataToSMSContect(WeatherData.getCityWeatherDescription(i, Gl.getShareForecastDays().intValue(), true)))
            {
                mServiceHandler.sendEmptyMessageDelayed(104, 500L);
                MojiLog.v("AutoShareService", "run return at3");
                continue; /* Loop/switch isn't completed */
            }
        }
        if(NeedShareMicroBlog())
        {
            StatsUtil.updateStatsCount(com.moji.mjweather.util.StatsUtil.StatsCount.COUNT_AWB);
            int k = SendWeatherDataToMicroBlog(WeatherData.getCityWeatherDescription(i, Gl.getShareForecastDays().intValue(), true), Gl.getAutoShareType());
            MojiLog.d("AutoShareService", (new StringBuilder()).append("accountErrorCounter = ").append(k).append("--mServiceHandler = ").append(mServiceHandler).toString());
            if(k > 0 && mServiceHandler != null)
            {
                mServiceHandler.sendEmptyMessageDelayed(103, 500L);
                continue; /* Loop/switch isn't completed */
            }
        }
        if(mServiceHandler != null)
            mServiceHandler.sendEmptyMessageDelayed(105, 500L);
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static final int METHOD_TYPE_SHARE = 202;
    private static final int MICRO_RESPONSE_CODE_SUCCESS = 0;
    private static final int MSG_THREAD_SEND_SMS_FAILED = 104;
    private static final int MSG_THREAD_SHARE_MICRO_BLOG_ACCOUNT_FAILED = 103;
    private static final int MSG_THREAD_SHARE_MICRO_BLOG_NETWORK_FAILED = 102;
    private static final int MSG_THREAD_SHARE_WEATHER_DATA_SUCCESS = 105;
    private static final int MSG_THREAD_UPDATE_WEATHER_FAILED = 101;
    private static final String SHARE_TYPES_CHARACTERS = "0";
    private static final int SHARE_TYPE_KAIXIN = 303;
    private static final int SHARE_TYPE_SINA = 203;
    private static final String TAG = "AutoShareService";
    private static Thread mThread = null;
    private ShareOAuthShareSqliteManager mCOAuthShareSqliteManager;
    CIncomingHandler mServiceHandler;
    String m_Context;


}
