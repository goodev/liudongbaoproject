// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PlayerUtil.java

package com.moji.mjweather.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Environment;
import android.os.Handler;
import android.widget.Toast;
 
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.data.*;
 
import java.io.File;
import java.text.*;
import java.util.*;

// Referenced classes of package com.moji.mjweather.util:
//            StatsUtil, VoicePlayer, FileUtil

public final class PlayerUtil
{

    public PlayerUtil()
    {
    }

     

    public static long getBroadCastContentIndex()
    {
        CityWeatherInfo cityweatherinfo;
        SimpleDateFormat simpledateformat;
        cityweatherinfo = WeatherData.getCityInfo(Gl.getCurrentCityIndex());
        simpledateformat = new SimpleDateFormat("yyyy/MM/dd");
        long l1;
        Date date = new Date();
        Date date1;
		try {
			date1 = simpledateformat.parse(cityweatherinfo.mWeatherMainInfo.mSolarUpdateDate);
			 l1 = (date.getTime() - date1.getTime()) / 0x5265c00L;
		        long l = l1;
		 
		        return l;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
       
        
    }

    public static String getCurrentDateString()
    {
        return (new SimpleDateFormat("yyyy/MM/dd")).format(new Date());
    }

    private static String getCurrentDayInfo(Context context)
    {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int j = 1 + calendar.get(2);
        int k = calendar.get(5);
        int l = calendar.get(11);
        int i1 = calendar.get(12);
        StringBuilder stringbuilder = (new StringBuilder()).append(context.getResources().getString(0x7f0b0127)).append(i).append(context.getResources().getString(0x7f0b0128)).append(j).append(context.getResources().getString(0x7f0b0129)).append(k).append(context.getResources().getString(0x7f0b012a)).append(",").append(getNowDayOfWeek(context)).append("\u3002").append(context.getResources().getString(0x7f0b012b));
        Object obj;
        String s;
        String s1;
        if(l < 10)
            obj = (new StringBuilder()).append("0").append(l).toString();
        else
            obj = Integer.valueOf(l);
        s = stringbuilder.append(obj).append(context.getResources().getString(0x7f0b012c)).toString();
        if(i1 == 0)
        {
            s1 = (new StringBuilder()).append(s).append(context.getResources().getString(0x7f0b012e)).append("\u3002").toString();
        } else
        {
            StringBuilder stringbuilder1 = (new StringBuilder()).append(s);
            Object obj1;
            if(i1 < 10)
                obj1 = (new StringBuilder()).append("0").append(i1).toString();
            else
                obj1 = Integer.valueOf(i1);
            s1 = stringbuilder1.append(obj1).append(context.getResources().getString(0x7f0b012d)).append("\u3002").toString();
        }
        return s1;
    }

    public static int getMinutesNum(Date date)
    {
        int i = 0;
        if(date != null)
            i = 60 * date.getHours() + date.getMinutes();
        return i;
    }

    public static String getNowDayOfWeek(Context context)
    {
        String as[] = context.getResources().getStringArray(0x7f070008);
        int i = Calendar.getInstance().get(7);
        String s = "";
        if(i < 8)
            s = as[i + -1];
        return s;
    }

    public static String getPlayVoiceContent(Context context, boolean flag)
    {
       return "";
    }

    public static Date getVoicePlayDate()
    {
        String s;
        SimpleDateFormat simpledateformat;
        Date date;
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int j = 1 + calendar.get(2);
        int k = calendar.get(5);
        s = (new StringBuilder()).append(i).append("-").append(j).append("-").append(k).append("  ").append(Gl.getAutoVoiceTime()).toString();
        simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
 
        Date date1= null;;
		try {
			date1 = simpledateformat.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 return date1;
 
 
    }

    public static boolean isDataExpired()
    {
        boolean flag;
        if(!FileUtil.isHaveFile(TTS_DATA_VERSION_PATH))
            flag = true;
        else
            flag = false;
        return flag;
    }

   
    public static void playVoice(Context context, final Handler mianHandler, boolean flag, boolean flag1)
    {
        
    }

    public static void playVoiceOnWidget(Context context)
    {
        if(!isBroadcasting)
        {
            CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(Gl.getCurrentCityIndex());
            File file = new File(TTS_DATA_FRD_PATH);
            File file1 = new File(TTS_DATA_BKD_PATH);
            File file2 = new File(TTS_DATA_BG_PATH);
            if(!Environment.getExternalStorageState().equals("mounted"))
                Toast.makeText(context, 0x7f0b0169, 0).show();
            else
            if(!file.exists() || !file1.exists())
                Toast.makeText(context, 0x7f0b016a, 0).show();
            else
            if(WeatherData.getCityInfo(0).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
                Toast.makeText(context, 0x7f0b016b, 0).show();
            else
            if(cityweatherinfo.m_lastUpdateTime.length() < 1)
                Toast.makeText(context, 0x7f0b016c, 0).show();
            else
            if(file.exists() && file1.exists() && !file2.exists())
            {
                Toast.makeText(context, 0x7f0b01dc, 0).show();
                playVoice(context, null, true, true);
                Toast.makeText(Gl.Ct(), 0x7f0b0220, 1).show();
            } else
            {
                Toast.makeText(Gl.Ct(), 0x7f0b0220, 1).show();
                playVoice(context, null, true, true);
            }
        } else
        {
            mVoicePlayer.stop();
            isBroadcasting = false;
        }
    }

    public static void startVoiceService()
    {
        if(Gl.getAutoVoicePlay() && !isBroadcasting)
        {
            
        }
    }

    private static final String TAG = "PlayerUtil";
    public static final String TTS_BG_MUSIC = "/download/tts_bg_music.zip";
    public static final String TTS_DATA_BG_PATH = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/moji/tempdata/forcast-music.mp3").toString();
    public static final String TTS_DATA_BKD_PATH = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/moji/tempdata/SndaTtsData.bkd").toString();
    public static final String TTS_DATA_FRD_PATH = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/moji/tempdata/SndaTtsData.frd").toString();
    public static final String TTS_DATA_MEM_PATH = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/moji/tempdata/SndaTtsData.mem").toString();
    public static final String TTS_DATA_SNDA = "/download/tts_data_snda.zip";
    public static final String TTS_DATA_VERSION_PATH = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/moji/tempdata/version.txt").toString();
    public static final String TTS_DATA_VOICE = "/download/tts_data_voice.zip";
    public static final int TTS_MAX_MEMORY = 16;
    public static final String VoiceDataPath = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/moji/tempdata/").toString();
    public static final String VoiceDataSite = "qz1.mojichina.com";
    public static boolean isBroadcasting;
    static VoicePlayer mVoicePlayer;

}
