// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StatsUtil.java

package com.moji.mjweather.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
 
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package com.moji.mjweather.util:
//            StatsXmlMgr, StatsData

public final class StatsUtil
{
    public static enum StatsSwitcher 
    {
 SWITCHER_AL, SWITCHER_END,SWITCHER_TV 

         
    };

    public static enum StatsPv 
    {
        
        
        PV_ALM,
        PV_CM,
        PV_DAYS_MATTER,
        PV_DD,
        PV_END,
        PV_IDX_COSMETIC,
        PV_IDX_DRESS,
        PV_IDX_SPORT,
        PV_IDX_UV,
        PV_IDX_WASHCAR,
        PV_LF,
        PV_SKIN,
        PV_TC,
        PV_WW

       
    }

    public static enum  StatsCount 
    {

        
        COUNT_ALM,
        COUNT_ASMS,
        COUNT_AWB,
        COUNT_END,
        COUNT_MSMS,
        COUNT_MWB,
        COUNT_SS,
        COUNT_VC;

		 
    }


    public StatsUtil()
    {
    }

    public static void deleteStatsFile()
    {
     
    }

    public static String getStatsContent()
    {
        String s = "";
 
 
        return s;
        
    }

    private static StatsData getStatsData()
    {
        if(mStatsData == null)
            mStatsData = new StatsData();
        return mStatsData;
    }

    public static boolean isDevelopMode()
    {
        return false;
    }

    public static void saveStatsFile()
    {
        try {
			StatsXmlMgr.saveToXml();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        StatsXmlMgr.deleteStatsFile();
    
    }

    private static void setAlarm(long l)
    {
         
    }

    public static void setNextSendTime(boolean flag)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 13 + (int)(2D * Math.random()));
        calendar.set(12, (int)(60D * Math.random()));
        calendar.set(13, 0);
        long l = Gl.getStatSentTime();
        if(flag || l == 0L)
        {
            l = 0x5265c00L + calendar.getTimeInMillis();
            Gl.saveStatSentTime(l);
        }
        setAlarm(l);
    }

    public static void setRetryTime()
    {
        int i = Gl.getStatRetryCount();
        if(i < 4)
        {
            MojiLog.d("StatsUtil", (new StringBuilder()).append("retry: count = ").append(i).toString());
            Gl.saveStatRetryCount(i + 1);
            long l = System.currentTimeMillis() + SEND_STAT_RETRY_TIME[i];
            Gl.saveStatSentTime(l);
            setAlarm(l);
        } else
        {
            Gl.saveStatRetryCount(0);
            setNextSendTime(true);
        }
    }

    public static void updateStatsAdClick()
    {
 
    }

    public static void updateStatsAdDown()
    {
       
    }

    public static void updateStatsAdView()
    {
        
    }

    public static void updateStatsCityQC(int i)
    {
       
    }

    public static void updateStatsCount(StatsCount statscount)
    {
       
    }

    public static void updateStatsPv(StatsPv statspv)
    {
       
    }

    private static final int MAX_RETYR_COUNT = 4;
    private static final long ONE_HOUR = 0x36ee80L;
    private static final long SEND_STAT_INTERVAL_TIME = 0x5265c00L;
    private static final long SEND_STAT_RETRY_TIME[];
    private static final boolean mDevelopMode=false;
    public static StatsData mStatsData = null;

    static 
    {
        long al[] = new long[4];
        al[0] = 0x6ddd00L;
        al[1] = 0xdbba00L;
        al[2] = 0x1499700L;
        al[3] = 0x1b77400L;
        SEND_STAT_RETRY_TIME = al;
    }
}
