// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SoftWare.java

package com.moji.mjweather.recommend;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.moji.mjweather.recommend:
//            AppUtil

public class SoftWare
    implements Serializable, Comparable
{

    public SoftWare()
    {
    }

    public static SoftWare parseJson(JSONObject jsonobject)
        throws JSONException
    {
        if(jsonobject != null) goto _L2; else goto _L1
_L1:
        SoftWare software = null;
_L4:
        return software;
_L2:
        software = new SoftWare();
        software.setAppDesc(jsonobject.optString("appDesc"));
        software.setAppid(jsonobject.optString("appid"));
        software.setAppName(jsonobject.optString("appName"));
        software.setAppPicturePath(jsonobject.optString("appPicturePath"));
        software.setAppRatingLevel(jsonobject.optString("appRatingLevel"));
        software.setAppSize(jsonobject.optString("appSize"));
        software.setAppSortNO(jsonobject.optString("appSortNO"));
        software.setAppState(jsonobject.optString("appState"));
        software.setAppVersion(jsonobject.optString("appVersion"));
        software.setAppIconPath(jsonobject.optString("appIconPath"));
        software.setAppPkgName(jsonobject.optString("appPkgName"));
        software.setAppPkgVersionName(jsonobject.optString("appPkgVersionName"));
        software.setAppPkgVersionCode(jsonobject.optString("appPkgVersionCode"));
        software.setAppLanguage(jsonobject.optString("appLanguage"));
        software.setAppDownPath(jsonobject.optString("appDownPath"));
        software.setAppCreateTime(jsonobject.optString("appCreateTime"));
        software.setAppscreenshoturl(jsonobject.optString("appscreenshoturl"));
        software.setAppDownNum(jsonobject.optString("appDownNum"));
        software.setAppType(jsonobject.optString("appType"));
        software.setAppauthor(jsonobject.optString("appauthor"));
        software.setAppBannerUrl(jsonobject.optString("appBannerUrl"));
        if(jsonobject.has("appImgType"))
            try
            {
                software.setAppImgType(Integer.valueOf(jsonobject.optString("appImgType")).intValue());
            }
            catch(Exception exception)
            {
                software.setAppImgType(0);
            }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int compareTo(SoftWare software)
    {
        byte byte0;
        if(softstate > software.softstate)
            byte0 = -1;
        else
        if(softstate == software.softstate)
            byte0 = 0;
        else
            byte0 = 1;
        return byte0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((SoftWare)obj);
    }

    public String getAppBannerUrl()
    {
        return appBannerUrl;
    }

    public String getAppCreateTime()
    {
        return appCreateTime;
    }

    public String getAppDesc()
    {
        return appDesc;
    }

    public String getAppDownNum()
    {
        return appDownNum;
    }

    public String getAppDownPath()
    {
        return appDownPath;
    }

    public String getAppIconPath()
    {
        return appIconPath;
    }

    public int getAppImgType()
    {
        return appImgType;
    }

    public String getAppLanguage()
    {
        return appLanguage;
    }

    public String getAppName()
    {
        return appName;
    }

    public String getAppPicturePath()
    {
        return appPicturePath;
    }

    public String getAppPkgName()
    {
        return appPkgName;
    }

    public String getAppPkgVersionCode()
    {
        return appPkgVersionCode;
    }

    public String getAppPkgVersionName()
    {
        return appPkgVersionName;
    }

    public String getAppRatingLevel()
    {
        return appRatingLevel;
    }

    public String getAppSize()
    {
        return appSize;
    }

    public String getAppSortNO()
    {
        return appSortNO;
    }

    public String getAppState()
    {
        return appState;
    }

    public String getAppType()
    {
        return appType;
    }

    public String getAppVersion()
    {
        return appVersion;
    }

    public String getAppauthor()
    {
        return appauthor;
    }

    public String getAppid()
    {
        return appid;
    }

    public String getAppscreenshoturl()
    {
        return appscreenshoturl;
    }

    public Drawable getDrawable()
    {
        return drawable;
    }

    public int getSoftstate()
    {
        return softstate;
    }

    public int refreshState(Context context)
    {
        int i;
        softstate = AppUtil.check(context, appPkgName, appPkgVersionCode);
        i = AppUtil.checkIfHaveDownlaod(appid);
        if(i != 5) goto _L2; else goto _L1
_L1:
        softstate;
        JVM INSTR tableswitch 1 4: default 64
    //                   1 64
    //                   2 69
    //                   3 64
    //                   4 64;
           goto _L2 _L2 _L3 _L2 _L2
_L2:
        return softstate;
_L3:
        softstate = i;
        if(true) goto _L2; else goto _L4
_L4:
    }

    public void setAppBannerUrl(String s)
    {
        appBannerUrl = s;
    }

    public void setAppCreateTime(String s)
    {
        appCreateTime = s;
    }

    public void setAppDesc(String s)
    {
        appDesc = s;
    }

    public void setAppDownNum(String s)
    {
        appDownNum = s;
    }

    public void setAppDownPath(String s)
    {
        appDownPath = s;
    }

    public void setAppIconPath(String s)
    {
        appIconPath = s;
    }

    public void setAppImgType(int i)
    {
        appImgType = i;
    }

    public void setAppLanguage(String s)
    {
        appLanguage = s;
    }

    public void setAppName(String s)
    {
        appName = s;
    }

    public void setAppPicturePath(String s)
    {
        appPicturePath = s;
    }

    public void setAppPkgName(String s)
    {
        appPkgName = s;
    }

    public void setAppPkgVersionCode(String s)
    {
        appPkgVersionCode = s;
    }

    public void setAppPkgVersionName(String s)
    {
        appPkgVersionName = s;
    }

    public void setAppRatingLevel(String s)
    {
        appRatingLevel = s;
    }

    public void setAppSize(String s)
    {
        appSize = s;
    }

    public void setAppSortNO(String s)
    {
        appSortNO = s;
    }

    public void setAppState(String s)
    {
        appState = s;
    }

    public void setAppType(String s)
    {
        appType = s;
    }

    public void setAppVersion(String s)
    {
        appVersion = s;
    }

    public void setAppauthor(String s)
    {
        appauthor = s;
    }

    public void setAppid(String s)
    {
        appid = s;
    }

    public void setAppscreenshoturl(String s)
    {
        appscreenshoturl = s;
    }

    public void setDrawable(Drawable drawable1)
    {
        drawable = drawable1;
    }

    public void setSoftstate(int i)
    {
        softstate = i;
    }

    private static final long serialVersionUID = 0x4ef4632f4be416a4L;
    private String appBannerUrl;
    private String appCreateTime;
    private String appDesc;
    private String appDownNum;
    private String appDownPath;
    private String appIconPath;
    private int appImgType;
    private String appLanguage;
    private String appName;
    private String appPicturePath;
    private String appPkgName;
    private String appPkgVersionCode;
    private String appPkgVersionName;
    private String appRatingLevel;
    private String appSize;
    private String appSortNO;
    private String appState;
    private String appType;
    private String appVersion;
    private String appauthor;
    private String appid;
    private String appscreenshoturl;
    private Drawable drawable;
    private int softstate;
}
