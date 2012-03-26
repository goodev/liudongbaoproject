// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SkinInfo.java

package com.moji.mjweather.widgetskin;

import com.moji.mjweather.util.UiUtil;
import java.util.ArrayList;

// Referenced classes of package com.moji.mjweather.widgetskin:
//            SkinDrawIconInfo

public class SkinInfo
{
 

	public static enum BitmapContentType   
    { CT_TIME_HOUR_TENS , CT_TIME_HOUR_UNITS ,CT_TIME_MINUTE_TENS , CT_TIME_MINUTE_UNITS,CT_TIME_COLON , CT_TIME_COLON_AUTO ,
            CT_TIME_AMPM ,
            CT_BACKGROUND ,
            CT_BACKGROUND_MASK,
            CT_CUSTOM ,
            CT_WEATHER_ICON_CURRENT,
            CT_WEATHER_ICON_CURRENT_TYPE2,
            CT_WEATHER_ICON_CURRENT_TYPE3,
            CT_WEATHER_ICON_FORECAST_00_12,
            CT_WEATHER_ICON_FORECAST_12_24 ,
            CT_WEATHER_ICON_FORECAST_00_12_TYPE2 ,
            CT_WEATHER_ICON_FORECAST_12_24_TYPE2,
            CT_WEATHER_ICON_FORECAST_00_12_TYPE3,
            CT_WEATHER_ICON_FORECAST_12_24_TYPE3,
            CT_WEATHER_ICON_FORECAST_DAY_1 ,
            CT_WEATHER_ICON_FORECAST_DAY_2 ,
            CT_WEATHER_ICON_FORECAST_DAY_3 ,
            CT_WEATHER_ICON_FORECAST_DAY_4,
            CT_WEATHER_ICON_FORECAST_DAY_5,
            CT_WEATHER_ICON_FORECAST_NIGHT_1,
            CT_WEATHER_ICON_FORECAST_NIGHT_2 ,
            CT_WEATHER_ICON_FORECAST_NIGHT_3,
            CT_WEATHER_ICON_FORECAST_NIGHT_4 ,
            CT_WEATHER_ICON_FORECAST_NIGHT_5  ;
            
        };

         
 

    public static enum TextContentType   
    {
    	CT_CUSTOM,CT_TIME
        
    };

    public static enum   SkinType   
    {

    	ST_4x2,ST_4x1,ST_2x2,ST_2x1,ST_UNKNOWN 
    }

 
    public static enum    ScreenResolution  
    {
    	SR_320_480,SR_240_320,SR_480_800,SR_480_854,SR_360_640,SR_240_400,SR_640_960,SR_540_960,SR_800_1280,SR_720_1280,SR_720_1184,SR_600_1024,SR_OTHER
    } 


    public SkinInfo()
    {
        m_skinName = "";
        m_author = "";
        m_description = "";
        m_skinToolVer = 2F;
        m_UseIconTimeClock = false;
        m_UseTextTimeClock = false;
        m_org_weather_icon_used = true;
        m_useOrgNumberIcon = true;
        m_useOrgBackground = true;
        m_SkinType = SkinType.ST_4x1;
        m_UseColorMask = false;
        m_DefaultMaskColor = 0xffffff;
        m_DefaultMaskAlpha = 125;
        m_isUserTextBeAnalysisCount = 0;
        m_Resolution = "";
        m_needDrawTextList = null;
        m_needDrawIconList = null;
        m_needDrawTextList = new ArrayList();
        m_needDrawIconList = new ArrayList();
    }

    public static ScreenResolution getScreeType()
    {
        return getScreeType(UiUtil.getScreenWidth(), UiUtil.getScreenHeight());
    }

    public static ScreenResolution getScreeType(int i, int j)
    {
        ScreenResolution screenresolution;
        if(i == 320 && j == 480 || i == 480 && j == 320)
            screenresolution = ScreenResolution.SR_320_480;
        else
        if(i == 320 && j == 240 || i == 240 && j == 320)
            screenresolution = ScreenResolution.SR_240_320;
        else
        if(i == 480 && j == 800 || i == 800 && j == 480)
            screenresolution = ScreenResolution.SR_480_800;
        else
        if(i == 480 && j == 854 || i == 854 && j == 480)
            screenresolution = ScreenResolution.SR_480_854;
        else
        if(i == 360 && j == 640 || i == 640 && j == 360)
            screenresolution = ScreenResolution.SR_360_640;
        else
        if(i == 400 && j == 240 || i == 240 && j == 400)
            screenresolution = ScreenResolution.SR_240_400;
        else
        if(i == 960 && j == 640 || i == 640 && j == 960)
            screenresolution = ScreenResolution.SR_640_960;
        else
        if(i == 960 && j == 540 || i == 540 && j == 960)
            screenresolution = ScreenResolution.SR_540_960;
        else
        if(i == 1280 && j == 800 || i == 800 && j == 1280)
            screenresolution = ScreenResolution.SR_800_1280;
        else
        if(i == 1280 && j == 720 || i == 720 && j == 1280)
            screenresolution = ScreenResolution.SR_720_1280;
        else
        if(i == 1184 && j == 720 || i == 720 && j == 1184 || i == 1196 && j == 720)
            screenresolution = ScreenResolution.SR_720_1184;
        else
        if(i == 1024 && j == 600 || i == 600 && j == 1024)
            screenresolution = ScreenResolution.SR_600_1024;
        else
            screenresolution = ScreenResolution.SR_OTHER;
        return screenresolution;
    }

    public void CleanAll()
    {
        m_needDrawTextList.clear();
        m_needDrawIconList.clear();
    }

    public SkinDrawIconInfo GetTargetIconInfo(BitmapContentType bitmapcontenttype)
    {
       
 
        SkinDrawIconInfo skindrawiconinfo=null;
        int i = 0;
       do{
        skindrawiconinfo = (SkinDrawIconInfo)m_needDrawIconList.get(i);
        if(bitmapcontenttype != skindrawiconinfo.mContentType) i++; else return skindrawiconinfo;
       }
       while(i < m_needDrawIconList.size());
       return skindrawiconinfo;
    }

    public int m_DefaultMaskAlpha;
    public int m_DefaultMaskColor;
    public String m_Resolution;
    public SkinType m_SkinType;
    public boolean m_UseColorMask;
    public boolean m_UseIconTimeClock;
    public boolean m_UseTextTimeClock;
    public String m_author;
    public String m_description;
    public int m_isUserTextBeAnalysisCount;
    public ArrayList m_needDrawIconList;
    public ArrayList m_needDrawTextList;
    public boolean m_org_weather_icon_used;
    public String m_skinName;
    public float m_skinToolVer;
    public boolean m_useOrgBackground;
    public boolean m_useOrgNumberIcon;
}
