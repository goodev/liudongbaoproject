// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UrlUtil.java

package com.moji.mjweather.util;

import android.os.Build;
import com.moji.mjweather.Gl;
import java.net.URLEncoder;

// Referenced classes of package com.moji.mjweather.util:
//            Util

public final class UrlUtil
{

    public UrlUtil()
    {
    }

    public static String getAdSwitcherURL()
    {
        return (new StringBuilder()).append("/advert/CheckAdvertSwitcher?Platform=Android&PartnerKey=").append(Gl.getPartnerID()).append("&Version=").append(Gl.getVersion()).toString();
    }

    public static String getBAUrl(int i)
    {
        String s = (new StringBuilder()).append("UserID=").append(Gl.getRegCode()).append("&Platform=Android").append("&BaseOSVer=").append(android.os.Build.VERSION.SDK).append("&Version=").append(Gl.getVersion()).append("&Device=phone").append("&Model=").append(URLEncoder.encode(Build.MODEL)).append("&PartnerKey=").append(Gl.getPartnerID()).append("&ADLocation=").append(i).append("&VersionType=").append(Gl.getVersionType()).toString();
        return (new StringBuilder()).append("http://ad.moji001.com/advert/GetBAAdvert?").append(s).toString();
    }

    public static String getCDNParameter(int i)
    {
        return (new StringBuilder()).append("?&Platform=Android&BaseOSVer=").append(android.os.Build.VERSION.SDK).append("&UserID=").append(Gl.getRegCode()).append("&CityID=").append(i).append("&Version=").append(Gl.getVersion()).append("&IMEI=").append(Util.GetIMEI(Gl.Ct())).append("&SdkVer=").append(URLEncoder.encode(android.os.Build.VERSION.RELEASE)).append("&Device=phone").append("&Model=").append(URLEncoder.encode(Build.MODEL)).append("&PartnerKey=").append(Gl.getPartnerID()).append("&DV=").append(Gl.getDatabaseVersion()).append("&VersionType=").append(Gl.getVersionType()).toString();
    }

    public static String getCDNURL(int i)
    {
        return (new StringBuilder()).append("/data/xml/weather/").append(Gl.getDatabaseVersion()).append("/").append(i).append(".xml").toString();
    }

    public static String getCommonPart()
    {
        return (new StringBuilder()).append("ID=").append(Gl.getRegCode()).append("&UserID=").append(Gl.getRegCode()).append("&Platform=Android").append("&Device=phone").append("&Version=").append(Gl.getVersion()).append("&VerNo=").append(Gl.getVersion()).append("&APILevel=").append(android.os.Build.VERSION.SDK).append("&SdkVer=").append(URLEncoder.encode(android.os.Build.VERSION.RELEASE)).append("&IMEI=").append(Util.GetIMEI(Gl.Ct())).append("&Model=").append(URLEncoder.encode(Build.MODEL)).toString();
    }

    public static String getGetWeatherByLocURL(String s, int i, String s1)
    {
        return (new StringBuilder()).append(getWebsiteIfNeeded(s)).append("/weather/").append("GetCDNWeatherByLocation?").append("&Platform=Android").append("&BaseOSVer=").append(android.os.Build.VERSION.SDK).append("&UserID=").append(Gl.getRegCode()).append("&CityID=").append(i).append("&Version=").append(Gl.getVersion()).append("&IMEI=").append(Util.GetIMEI(Gl.Ct())).append("&SdkVer=").append(URLEncoder.encode(android.os.Build.VERSION.RELEASE)).append("&Device=phone").append("&Model=").append(URLEncoder.encode(Build.MODEL)).append("&PartnerKey=").append(Gl.getPartnerID()).append("&DV=").append(Gl.getDatabaseVersion()).append("&VersionType=").append(Gl.getVersionType()).append(s1).toString();
    }

    public static String getGetWeatherURL(String s, int i)
    {
        return (new StringBuilder()).append(getWebsiteIfNeeded(s)).append("/weather/").append("GetWeather?").append(getCommonPart()).append("&CityID=").append(i).append("&Days=5").append("&DT=xml").toString();
    }

    public static String getMDUrl()
    {
        String s = (new StringBuilder()).append("UserID=").append(Gl.getRegCode()).append("&Platform=Android").append("&BaseOSVer=").append(android.os.Build.VERSION.SDK).append("&Version=").append(Gl.getVersion()).append("&Device=phone").append("&Model=").append(URLEncoder.encode(Build.MODEL)).append("&PartnerKey=").append(Gl.getPartnerID()).append("&VersionType=").append(Gl.getVersionType()).toString();
        return (new StringBuilder()).append("http://ad.moji001.com/advert/GetMDAdvertList?").append(s).toString();
    }

    public static String getRegisterURL(String s)
    {
        return (new StringBuilder()).append(getWebsiteIfNeeded(s)).append("/weather/").append("RegisterUser?").append(getCommonPart()).append("&PartnerID=").append(Gl.getPartnerID()).append("&DBVerNo=1").toString();
    }

    public static String getStatsURL(String s)
    {
        return (new StringBuilder()).append(getWebsiteIfNeeded(s)).append("/weather/AdvUploadStat").toString();
    }

    public static String getUploadADUrlPrefix()
    {
        String s = (new StringBuilder()).append("UserID=").append(Gl.getRegCode()).append("&Platform=Android").append("&BaseOSVer=").append(android.os.Build.VERSION.SDK).append("&Version=").append(Gl.getVersion()).append("&Device=phone").append("&Model=").append(URLEncoder.encode(Build.MODEL)).append("&PartnerKey=").append(Gl.getPartnerID()).append("&VersionType=").append(Gl.getVersionType()).toString();
        return (new StringBuilder()).append("http://ad.moji001.com/advert/UpdateAdvertStat?").append(s).toString();
    }

    public static String getUploadUVPVPrefix()
    {
        String s = (new StringBuilder()).append("UserID=").append(Gl.getRegCode()).append("&Platform=Android").append("&BaseOSVer=").append(android.os.Build.VERSION.SDK).append("&Version=").append(Gl.getVersion()).append("&Device=phone").append("&Model=").append(URLEncoder.encode(Build.MODEL)).append("&PartnerKey=").append(Gl.getPartnerID()).append("&VersionType=").append(Gl.getVersionType()).toString();
        return (new StringBuilder()).append("http://rt.stat.moji001.com/RtStatUserPvUv?").append(s).toString();
    }

    private static String getWebsiteIfNeeded(String s)
    {
        String s1;
        if(s != null && !s.equals(""))
            s1 = (new StringBuilder()).append("http://").append(s).toString();
        else
            s1 = "";
        return s1;
    }
}
