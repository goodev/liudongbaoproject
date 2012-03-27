// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WidgetRemoteViews4x1.java

package com.moji.mjweather.widget;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.*;
import android.widget.RemoteViews;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.data.WeatherMainInfo;
import com.moji.mjweather.util.*;
import com.moji.mjweather.widgetskin.SkinInfo;
import com.moji.mjweather.widgetskin.SkinLoader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// Referenced classes of package com.moji.mjweather.widget:
//            AbstractWidgetRemoteViews, WidgetManager

class WidgetRemoteViews4x1 extends AbstractWidgetRemoteViews
{

    public WidgetRemoteViews4x1(Context context, String s)
    {
        super(context, s);
    }

    protected int createBackgroundSaveSeq()
    {
        if(bkgSaveCount == 0)
            bkgSaveCount = 1;
        else
            bkgSaveCount = 0;
        return bkgSaveCount;
    }

    protected int createCustomInfoLayerSaveSeq()
    {
        if(customInfoLayerSaveCount == 0)
            customInfoLayerSaveCount = 1;
        else
            customInfoLayerSaveCount = 0;
        return customInfoLayerSaveCount;
    }

    protected Bitmap createDrawBuffer()
    {
        if(mWidgetDrawBuffer == null)
        {
            float f;
            if(getCurrentSkin() != null)
                f = getCurrentSkin().m_skinToolVer;
            else
                f = 3F;
            mWidgetDrawBuffer = SkinUtil.createDrawBuffer(Gl.getScreenTypeIntValue(), com.moji.mjweather.widgetskin.SkinInfo.SkinType.ST_4x1, f);
        } else
        {
            mWidgetDrawBuffer.eraseColor(Color.argb(0, 0, 0, 0));
        }
        return mWidgetDrawBuffer;
    }

    protected int createOrgTextLayerSaveSeq()
    {
        if(orgTextLayerSaveCount == 0)
            orgTextLayerSaveCount = 1;
        else
            orgTextLayerSaveCount = 0;
        return orgTextLayerSaveCount;
    }

    protected int createTimeLayerSaveSeq()
    {
        if(timeLayerSaveCount == 0)
            timeLayerSaveCount = 1;
        else
            timeLayerSaveCount = 0;
        return timeLayerSaveCount;
    }

    protected void drawText(Canvas canvas, CityWeatherInfo cityweatherinfo)
    {
        AbstractWidgetRemoteViews.WidgetTextInfo widgettextinfo = getWidgetTextInfo();
        Calendar calendar = Calendar.getInstance();
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setFlags(1);
        Paint paint1 = new Paint();
        paint1.setColor(Color.rgb(40, 40, 40));
        paint1.setMaskFilter(new BlurMaskFilter(1F, android.graphics.BlurMaskFilter.Blur.NORMAL));
        paint1.setTextSize(widgettextinfo.cityNameSize);
        canvas.drawText(cityweatherinfo.mCityName, 1F + widgettextinfo.cityNameX, 1F + widgettextinfo.cityNameY, paint1);
        paint.setTextSize(widgettextinfo.cityNameSize);
        canvas.drawText(cityweatherinfo.mCityName, widgettextinfo.cityNameX, widgettextinfo.cityNameY, paint);
        if(cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
        {
            String s = cityweatherinfo.mWeatherMainInfo.mWeatherDescription;
            if(!cityweatherinfo.mWeatherMainInfo.mIsSpecCity && cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE)
                s = (new StringBuilder()).append(s).append(" ").append(cityweatherinfo.mWeatherMainInfo.mCurrentTemperature).append("\260").toString();
            paint1.setTextSize(widgettextinfo.cityDescSize);
            canvas.drawText(s, 1F + widgettextinfo.cityDescX, 1F + widgettextinfo.cityDescY, paint1);
            paint.setTextSize(widgettextinfo.cityDescSize);
            canvas.drawText(s, widgettextinfo.cityDescX, widgettextinfo.cityDescY, paint);
            String s1 = Util.GetTWWeekName(Integer.valueOf(calendar.get(7)).intValue());
            SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd ");
            String s2 = (new StringBuilder()).append(simpledateformat.format(calendar.getTime())).append(s1).toString();
            paint1.setTextAlign(android.graphics.Paint.Align.RIGHT);
            paint1.setTextSize(widgettextinfo.cityDateSize);
            canvas.drawText(s2, 1F + widgettextinfo.cityDateX, 1F + widgettextinfo.cityDateY, paint1);
            paint.setTextAlign(android.graphics.Paint.Align.RIGHT);
            paint.setTextSize(widgettextinfo.cityDateSize);
            canvas.drawText(s2, widgettextinfo.cityDateX, widgettextinfo.cityDateY, paint);
            String s3 = (new NongliUtil(calendar)).GetMonthDate();
            paint1.setTextSize(widgettextinfo.cityNLSize);
            canvas.drawText(s3, 1F + widgettextinfo.cityNLX, 1F + widgettextinfo.cityNLY, paint1);
            paint.setTextSize(widgettextinfo.cityNLSize);
            canvas.drawText(s3, widgettextinfo.cityNLX, widgettextinfo.cityNLY, paint);
            String s4 = "";
            if(cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE)
                if(cityweatherinfo.mWeatherMainInfo.mHighTemperature != 100)
                    s4 = (new StringBuilder()).append(cityweatherinfo.mWeatherMainInfo.mLowTemperature).append("~").append(cityweatherinfo.mWeatherMainInfo.mHighTemperature).append("\260").toString();
                else
                    s4 = (new StringBuilder()).append(Gl.Ct().getResources().getString(0x7f0b0150)).append(cityweatherinfo.mWeatherMainInfo.mLowTemperature).append("\260").toString();
            paint1.setTextSize(widgettextinfo.cityTemprSize);
            canvas.drawText(s4, 1F + widgettextinfo.cityTemprX, 1F + widgettextinfo.cityTemprY, paint1);
            paint.setTextSize(widgettextinfo.cityTemprSize);
            canvas.drawText(s4, widgettextinfo.cityTemprX, widgettextinfo.cityTemprY, paint);
        } else
        {
            paint1.setTextAlign(android.graphics.Paint.Align.LEFT);
            paint1.setTextSize(widgettextinfo.cityDescSize - 2F);
            canvas.drawText(Gl.Ct().getResources().getString(0x7f0b0151), 1F + widgettextinfo.cityDescX, 1F + widgettextinfo.cityDescY, paint1);
            paint.setTextAlign(android.graphics.Paint.Align.LEFT);
            paint.setTextSize(widgettextinfo.cityDescSize - 2F);
            canvas.drawText(Gl.Ct().getResources().getString(0x7f0b0151), widgettextinfo.cityDescX, widgettextinfo.cityDescY, paint);
        }
    }

    protected int getBackgroundSaveSeq()
    {
        return bkgSaveCount;
    }

    protected boolean getChangeSkinFlag()
    {
        return mChangeSkinFlag;
    }

    protected SkinInfo getCurrentSkin()
    {
        return Gl.getCurrentSkin4x1();
    }

    protected int getCustomInfoLayerSaveSeq()
    {
        return customInfoLayerSaveCount;
    }

    protected boolean getIsDayTime()
    {
        return sIsDaytime;
    }

    protected int getLoadingBg()
    {
        return 0x7f0200d8;
    }

    protected int getOldDayOfMonth()
    {
        return mOldDayOfMonth;
    }

    protected int getOrgTextLayerSaveSeq()
    {
        return orgTextLayerSaveCount;
    }

    protected AbstractWidgetRemoteViews.WidgetTextInfo getTimeAndWeatherIconInfo()
    {
        AbstractWidgetRemoteViews.WidgetTextInfo widgettextinfo = new AbstractWidgetRemoteViews.WidgetTextInfo();
        if(Gl.getScreenTypeIntValue() != 0) goto _L2; else goto _L1
_L1:
        widgettextinfo.timeY = 50F;
        widgettextinfo.hourLeftX = 630F;
        widgettextinfo.hourRightX = 740F;
        widgettextinfo.minuteLetfX = 920F;
        widgettextinfo.minuteRightX = 1030F;
        widgettextinfo.weatherIconX = 210F;
        widgettextinfo.weatherIconY = -15F;
        widgettextinfo.amPmX = 230F;
        widgettextinfo.amPmY = 13F;
        widgettextinfo.colonFlagX = 630F;
        widgettextinfo.colonFlagY = 55F;
        widgettextinfo.timeScale = 0.2F;
        widgettextinfo.weatherScale = 0.4F;
        widgettextinfo.amPmScale = 0.35F;
        widgettextinfo.colonFlagScale = 0.27F;
_L4:
        return widgettextinfo;
_L2:
        if(Gl.getScreenTypeIntValue() == 1)
        {
            widgettextinfo.timeY = 40F;
            widgettextinfo.hourLeftX = 435F;
            widgettextinfo.hourRightX = 540F;
            widgettextinfo.minuteLetfX = 680F;
            widgettextinfo.minuteRightX = 785F;
            widgettextinfo.weatherIconX = 220F;
            widgettextinfo.weatherIconY = 10F;
            widgettextinfo.amPmX = 190F;
            widgettextinfo.amPmY = 25F;
            widgettextinfo.colonFlagX = 745F;
            widgettextinfo.colonFlagY = 100F;
            widgettextinfo.timeScale = 0.35F;
            widgettextinfo.weatherScale = 0.5F;
            widgettextinfo.amPmScale = 0.6F;
            widgettextinfo.colonFlagScale = 0.3F;
        } else
        if(Gl.getScreenTypeIntValue() == 2)
        {
            widgettextinfo.timeY = 40F;
            widgettextinfo.hourLeftX = 420F;
            widgettextinfo.hourRightX = 520F;
            widgettextinfo.minuteLetfX = 650F;
            widgettextinfo.minuteRightX = 750F;
            widgettextinfo.weatherIconX = 210F;
            widgettextinfo.weatherIconY = 0F;
            widgettextinfo.amPmX = 195F;
            widgettextinfo.amPmY = 30F;
            widgettextinfo.colonFlagX = 562F;
            widgettextinfo.colonFlagY = 70F;
            widgettextinfo.timeScale = 0.55F;
            widgettextinfo.weatherScale = 0.8F;
            widgettextinfo.amPmScale = 0.9F;
            widgettextinfo.colonFlagScale = 0.6F;
        } else
        if(Gl.getScreenTypeIntValue() == 3)
        {
            widgettextinfo.timeY = 40F;
            widgettextinfo.hourLeftX = 443F;
            widgettextinfo.hourRightX = 543F;
            widgettextinfo.minuteLetfX = 693F;
            widgettextinfo.minuteRightX = 793F;
            widgettextinfo.weatherIconX = 210F;
            widgettextinfo.weatherIconY = 0F;
            widgettextinfo.amPmX = 210F;
            widgettextinfo.amPmY = 30F;
            widgettextinfo.colonFlagX = 562F;
            widgettextinfo.colonFlagY = 70F;
            widgettextinfo.timeScale = 0.52F;
            widgettextinfo.weatherScale = 0.8F;
            widgettextinfo.amPmScale = 0.8F;
            widgettextinfo.colonFlagScale = 0.6F;
        } else
        if(Gl.getScreenTypeIntValue() == 5)
        {
            widgettextinfo.timeY = 80F;
            widgettextinfo.hourLeftX = 610F;
            widgettextinfo.hourRightX = 720F;
            widgettextinfo.minuteLetfX = 910F;
            widgettextinfo.minuteRightX = 1020F;
            widgettextinfo.weatherIconX = 15F;
            widgettextinfo.weatherIconY = 15F;
            widgettextinfo.amPmX = 220F;
            widgettextinfo.amPmY = 35F;
            widgettextinfo.colonFlagX = 554F;
            widgettextinfo.colonFlagY = 65F;
            widgettextinfo.timeScale = 0.2F;
            widgettextinfo.weatherScale = 0.4F;
            widgettextinfo.amPmScale = 0.4F;
            widgettextinfo.colonFlagScale = 0.3F;
        } else
        if(Gl.getScreenTypeIntValue() == 7)
        {
            widgettextinfo.timeY = 40F;
            widgettextinfo.hourLeftX = 540F;
            widgettextinfo.hourRightX = 640F;
            widgettextinfo.minuteLetfX = 800F;
            widgettextinfo.minuteRightX = 900F;
            widgettextinfo.weatherIconX = 220F;
            widgettextinfo.weatherIconY = -5F;
            widgettextinfo.amPmX = 205F;
            widgettextinfo.amPmY = 20F;
            widgettextinfo.colonFlagX = 640F;
            widgettextinfo.colonFlagY = 55F;
            widgettextinfo.timeScale = 0.6F;
            widgettextinfo.amPmScale = 1.15F;
            widgettextinfo.colonFlagScale = 0.7F;
            widgettextinfo.weatherScale = 1F;
        } else
        if(Gl.getScreenTypeIntValue() == 8)
        {
            widgettextinfo.timeY = 40F;
            widgettextinfo.hourLeftX = 460F;
            widgettextinfo.hourRightX = 560F;
            widgettextinfo.minuteLetfX = 720F;
            widgettextinfo.minuteRightX = 820F;
            widgettextinfo.weatherIconX = 230F;
            widgettextinfo.weatherIconY = 0F;
            widgettextinfo.amPmX = 195F;
            widgettextinfo.amPmY = 20F;
            widgettextinfo.colonFlagX = 523F;
            widgettextinfo.colonFlagY = 55F;
            widgettextinfo.timeScale = 0.55F;
            widgettextinfo.colonFlagScale = 0.7F;
            widgettextinfo.weatherScale = 0.85F;
        } else
        if(Gl.getScreenTypeIntValue() == 9)
        {
            widgettextinfo.timeY = 40F;
            widgettextinfo.hourLeftX = 540F;
            widgettextinfo.hourRightX = 640F;
            widgettextinfo.minuteLetfX = 800F;
            widgettextinfo.minuteRightX = 900F;
            widgettextinfo.weatherIconX = 210F;
            widgettextinfo.weatherIconY = 0F;
            widgettextinfo.amPmX = 205F;
            widgettextinfo.amPmY = 20F;
            widgettextinfo.colonFlagX = 640F;
            widgettextinfo.colonFlagY = 55F;
            widgettextinfo.timeScale = 0.6F;
            widgettextinfo.amPmScale = 1.15F;
            widgettextinfo.colonFlagScale = 0.7F;
            widgettextinfo.weatherScale = 1.3F;
        } else
        if(Gl.getScreenTypeIntValue() == 10)
        {
            widgettextinfo.timeY = 40F;
            widgettextinfo.hourLeftX = 540F;
            widgettextinfo.hourRightX = 640F;
            widgettextinfo.minuteLetfX = 800F;
            widgettextinfo.minuteRightX = 900F;
            widgettextinfo.weatherIconX = 180F;
            widgettextinfo.weatherIconY = 0F;
            widgettextinfo.amPmX = 205F;
            widgettextinfo.amPmY = 20F;
            widgettextinfo.colonFlagX = 640F;
            widgettextinfo.colonFlagY = 55F;
            widgettextinfo.timeScale = 0.6F;
            widgettextinfo.amPmScale = 1.15F;
            widgettextinfo.colonFlagScale = 0.7F;
            widgettextinfo.weatherScale = 1.3F;
        } else
        if(Gl.getScreenTypeIntValue() == 11)
        {
            widgettextinfo.timeY = 40F;
            widgettextinfo.hourLeftX = 540F;
            widgettextinfo.hourRightX = 640F;
            widgettextinfo.minuteLetfX = 800F;
            widgettextinfo.minuteRightX = 900F;
            widgettextinfo.weatherIconX = 180F;
            widgettextinfo.weatherIconY = 0F;
            widgettextinfo.amPmX = 205F;
            widgettextinfo.amPmY = 20F;
            widgettextinfo.colonFlagX = 640F;
            widgettextinfo.colonFlagY = 55F;
            widgettextinfo.timeScale = 0.6F;
            widgettextinfo.amPmScale = 1.15F;
            widgettextinfo.colonFlagScale = 0.7F;
            widgettextinfo.weatherScale = 1.3F;
        } else
        if(Gl.getScreenTypeIntValue() == 12)
        {
            widgettextinfo.timeY = 40F;
            widgettextinfo.hourLeftX = 540F;
            widgettextinfo.hourRightX = 640F;
            widgettextinfo.minuteLetfX = 800F;
            widgettextinfo.minuteRightX = 900F;
            widgettextinfo.weatherIconX = 235F;
            widgettextinfo.weatherIconY = -10F;
            widgettextinfo.amPmX = 205F;
            widgettextinfo.amPmY = 20F;
            widgettextinfo.colonFlagX = 640F;
            widgettextinfo.colonFlagY = 55F;
            widgettextinfo.timeScale = 0.6F;
            widgettextinfo.amPmScale = 1.15F;
            widgettextinfo.colonFlagScale = 0.7F;
            widgettextinfo.weatherScale = 0.9F;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected int getTimeLayerSaveSeq()
    {
        return timeLayerSaveCount;
    }

    protected String getWidgetBkgFileName()
    {
        return "widget_4x1_bkg.png";
    }

    protected int getWidgetBkgID()
    {
        return 0x7f0201c0;
    }

    protected String getWidgetBkgcx()
    {
        return "bkgc4x1";
    }

    protected String getWidgetBkgx()
    {
        return "bkg4x1";
    }

    protected int getWidgetLayoutID()
    {
        return 0x7f030074;
    }

    protected int getWidgetMaskID()
    {
        return 0x7f0201c1;
    }

    protected String getWidgetNx()
    {
        return "n41_";
    }

    protected AbstractWidgetRemoteViews.WidgetTextInfo getWidgetTextInfo()
    {
        AbstractWidgetRemoteViews.WidgetTextInfo widgettextinfo = new AbstractWidgetRemoteViews.WidgetTextInfo();
        if(Gl.getScreenTypeIntValue() != 0) goto _L2; else goto _L1
_L1:
        widgettextinfo.cityNameX = 20F;
        widgettextinfo.cityNameY = 26F;
        widgettextinfo.cityNameSize = 18F;
        widgettextinfo.cityDescX = 18F;
        widgettextinfo.cityDescY = 47F;
        widgettextinfo.cityDescSize = 13F;
        widgettextinfo.cityDateX = 217F;
        widgettextinfo.cityDateY = 20F;
        widgettextinfo.cityDateSize = 12F;
        widgettextinfo.cityNLX = 222F;
        widgettextinfo.cityNLY = 35F;
        widgettextinfo.cityNLSize = 12F;
        widgettextinfo.cityTemprX = 230F;
        widgettextinfo.cityTemprY = 50F;
        widgettextinfo.cityTemprSize = 12F;
_L4:
        return widgettextinfo;
_L2:
        if(Gl.getScreenTypeIntValue() == 1)
        {
            widgettextinfo.cityNameX = 25F;
            widgettextinfo.cityNameY = 46F;
            widgettextinfo.cityNameSize = 22F;
            widgettextinfo.cityDescX = 26F;
            widgettextinfo.cityDescY = 73F;
            widgettextinfo.cityDescSize = 16F;
            widgettextinfo.cityDateX = 295F;
            widgettextinfo.cityDateY = 35F;
            widgettextinfo.cityDateSize = 16F;
            widgettextinfo.cityNLX = 300F;
            widgettextinfo.cityNLY = 55F;
            widgettextinfo.cityNLSize = 16F;
            widgettextinfo.cityTemprX = 310F;
            widgettextinfo.cityTemprY = 75F;
            widgettextinfo.cityTemprSize = 16F;
        } else
        if(Gl.getScreenTypeIntValue() == 2 || Gl.getScreenTypeIntValue() == 3)
        {
            widgettextinfo.cityNameX = 32F;
            widgettextinfo.cityNameY = 60F;
            widgettextinfo.cityNameSize = 24F;
            widgettextinfo.cityDescX = 17F;
            widgettextinfo.cityDescY = 110F;
            widgettextinfo.cityDescSize = 26F;
            widgettextinfo.cityDateX = 435F;
            widgettextinfo.cityDateY = 55F;
            widgettextinfo.cityDateSize = 25F;
            widgettextinfo.cityNLX = 442F;
            widgettextinfo.cityNLY = 85F;
            widgettextinfo.cityNLSize = 20F;
            widgettextinfo.cityTemprX = 449F;
            widgettextinfo.cityTemprY = 115F;
            widgettextinfo.cityTemprSize = 20F;
        } else
        if(Gl.getScreenTypeIntValue() == 5)
        {
            widgettextinfo.cityNameX = 105F;
            widgettextinfo.cityNameY = 33F;
            widgettextinfo.cityNameSize = 12F;
            widgettextinfo.cityDescX = 105F;
            widgettextinfo.cityDescY = 46F;
            widgettextinfo.cityDescSize = 12F;
            widgettextinfo.cityDateX = 5F;
            widgettextinfo.cityDateY = 60F;
            widgettextinfo.cityDateSize = 14F;
            widgettextinfo.cityNLX = 230F;
            widgettextinfo.cityNLY = 60F;
            widgettextinfo.cityNLSize = 12F;
            widgettextinfo.cityTemprX = 105F;
            widgettextinfo.cityTemprY = 59F;
            widgettextinfo.cityTemprSize = 12F;
        } else
        if(Gl.getScreenTypeIntValue() == 7)
        {
            widgettextinfo.cityNameX = 60F;
            widgettextinfo.cityNameY = 70F;
            widgettextinfo.cityNameSize = 42F;
            widgettextinfo.cityDescX = 40F;
            widgettextinfo.cityDescY = 135F;
            widgettextinfo.cityDescSize = 35F;
            widgettextinfo.cityDateX = 590F;
            widgettextinfo.cityDateY = 60F;
            widgettextinfo.cityDateSize = 32F;
            widgettextinfo.cityNLX = 600F;
            widgettextinfo.cityNLY = 100F;
            widgettextinfo.cityNLSize = 28F;
            widgettextinfo.cityTemprX = 620F;
            widgettextinfo.cityTemprY = 135F;
            widgettextinfo.cityTemprSize = 28F;
        } else
        if(Gl.getScreenTypeIntValue() == 8)
        {
            widgettextinfo.cityNameX = 45F;
            widgettextinfo.cityNameY = 70F;
            widgettextinfo.cityNameSize = 38F;
            widgettextinfo.cityDescX = 45F;
            widgettextinfo.cityDescY = 110F;
            widgettextinfo.cityDescSize = 27F;
            widgettextinfo.cityDateX = 490F;
            widgettextinfo.cityDateY = 60F;
            widgettextinfo.cityDateSize = 27F;
            widgettextinfo.cityNLX = 505F;
            widgettextinfo.cityNLY = 90F;
            widgettextinfo.cityNLSize = 24F;
            widgettextinfo.cityTemprX = 520F;
            widgettextinfo.cityTemprY = 120F;
            widgettextinfo.cityTemprSize = 24F;
        } else
        if(Gl.getScreenTypeIntValue() == 9)
        {
            widgettextinfo.cityNameX = 70F;
            widgettextinfo.cityNameY = 95F;
            widgettextinfo.cityNameSize = 48F;
            widgettextinfo.cityDescX = 54F;
            widgettextinfo.cityDescY = 160F;
            widgettextinfo.cityDescSize = 46F;
            widgettextinfo.cityDateX = 730F;
            widgettextinfo.cityDateY = 75F;
            widgettextinfo.cityDateSize = 40F;
            widgettextinfo.cityNLX = 740F;
            widgettextinfo.cityNLY = 125F;
            widgettextinfo.cityNLSize = 40F;
            widgettextinfo.cityTemprX = 750F;
            widgettextinfo.cityTemprY = 170F;
            widgettextinfo.cityTemprSize = 40F;
        } else
        if(Gl.getScreenTypeIntValue() == 10)
        {
            widgettextinfo.cityNameX = 50F;
            widgettextinfo.cityNameY = 95F;
            widgettextinfo.cityNameSize = 48F;
            widgettextinfo.cityDescX = 40F;
            widgettextinfo.cityDescY = 160F;
            widgettextinfo.cityDescSize = 46F;
            widgettextinfo.cityDateX = 670F;
            widgettextinfo.cityDateY = 75F;
            widgettextinfo.cityDateSize = 40F;
            widgettextinfo.cityNLX = 680F;
            widgettextinfo.cityNLY = 125F;
            widgettextinfo.cityNLSize = 40F;
            widgettextinfo.cityTemprX = 690F;
            widgettextinfo.cityTemprY = 170F;
            widgettextinfo.cityTemprSize = 40F;
        } else
        if(Gl.getScreenTypeIntValue() == 11)
        {
            widgettextinfo.cityNameX = 50F;
            widgettextinfo.cityNameY = 95F;
            widgettextinfo.cityNameSize = 48F;
            widgettextinfo.cityDescX = 40F;
            widgettextinfo.cityDescY = 160F;
            widgettextinfo.cityDescSize = 46F;
            widgettextinfo.cityDateX = 670F;
            widgettextinfo.cityDateY = 75F;
            widgettextinfo.cityDateSize = 40F;
            widgettextinfo.cityNLX = 680F;
            widgettextinfo.cityNLY = 125F;
            widgettextinfo.cityNLSize = 40F;
            widgettextinfo.cityTemprX = 690F;
            widgettextinfo.cityTemprY = 170F;
            widgettextinfo.cityTemprSize = 40F;
        } else
        if(Gl.getScreenTypeIntValue() == 12)
        {
            widgettextinfo.cityNameX = 70F;
            widgettextinfo.cityNameY = 55F;
            widgettextinfo.cityNameSize = 38F;
            widgettextinfo.cityDescX = 55F;
            widgettextinfo.cityDescY = 115F;
            widgettextinfo.cityDescSize = 32F;
            widgettextinfo.cityDateX = 525F;
            widgettextinfo.cityDateY = 40F;
            widgettextinfo.cityDateSize = 24F;
            widgettextinfo.cityNLX = 535F;
            widgettextinfo.cityNLY = 80F;
            widgettextinfo.cityNLSize = 24F;
            widgettextinfo.cityTemprX = 545F;
            widgettextinfo.cityTemprY = 120F;
            widgettextinfo.cityTemprSize = 24F;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected String getWidgetTextox()
    {
        return "texto41";
    }

    protected String getWidgetTimex()
    {
        return "time41";
    }

    protected boolean hasColonWhenUseBackground()
    {
        return true;
    }

    protected void loadSkin(String s)
    {
        if(getCurrentSkin() != null)
        {
            getCurrentSkin().CleanAll();
            Gl.setCurrentSkin4x1(null);
        }
        SkinLoader skinloader = new SkinLoader();
        try
        {
            skinloader.LoadSkinConfingFile(Gl.Ct(), Gl.getCurrentSkinDir(), s);
            Gl.setCurrentSkin4x1(skinloader.GetCurrentSkin(SkinInfo.getScreeType(UiUtil.getScreenWidth(), UiUtil.getScreenHeight()), com.moji.mjweather.widgetskin.SkinInfo.SkinType.ST_4x1));
        }
        catch(Exception exception) { }
        if(getCurrentSkin() == null)
            try
            {
                skinloader.RemoveAllInfo();
                if(!"ORG".equals(Gl.getCurrentSkinDir()))
                {
                    skinloader.LoadSkinConfingFile(Gl.Ct(), "ORG", s);
                    Gl.setCurrentSkin4x1(skinloader.GetCurrentSkin(SkinInfo.getScreeType(UiUtil.getScreenWidth(), UiUtil.getScreenHeight()), com.moji.mjweather.widgetskin.SkinInfo.SkinType.ST_4x1));
                }
            }
            catch(Exception exception1) { }
        skinloader.RemoveAllInfo();
    }

    protected void recycleDrawBuffer()
    {
        if(mWidgetDrawBuffer != null)
        {
            mWidgetDrawBuffer.recycle();
            mWidgetDrawBuffer = null;
        }
    }

    protected void setChangeSkinFlag(boolean flag)
    {
        mChangeSkinFlag = flag;
    }

    protected RemoteViews setHotAreaAction(Context context, RemoteViews remoteviews, boolean flag, boolean flag1)
    {
        Intent intent = new Intent(context, WidgetManager.getWidgetClassByType(mWidgetType));
        intent.setAction("com.moji.mjweather.widget.LEFT_BOTTOM_BITMAP_BUTTON");
        remoteviews.setOnClickPendingIntent(0x7f0d0254, PendingIntent.getBroadcast(context, 0, intent, 0));
        Intent intent1 = new Intent(context, WidgetManager.getWidgetClassByType(mWidgetType));
        intent1.setAction("com.moji.mjweather.widget.RIGHT_BOTTOM_BITMAP_BUTTON");
        remoteviews.setOnClickPendingIntent(0x7f0d0255, PendingIntent.getBroadcast(context, 0, intent1, 0));
        if(!flag)
            remoteviews.setTextViewText(0x7f0d0256, "");
        if(flag1 && WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
        {
            Intent intent2 = new Intent(context, Gl.getMainActivityClass());
            intent2.setFlags(0x10200000);
            intent2.setAction("com.moji.mjweather.widget.UsageMessageActivity.ACTION_WIDGET_CONFIGURE");
            PendingIntent pendingintent = PendingIntent.getActivity(context, 0, intent2, 0);
            remoteviews.setOnClickPendingIntent(0x7f0d0254, pendingintent);
            remoteviews.setOnClickPendingIntent(0x7f0d0255, pendingintent);
        }
        return remoteviews;
    }

    protected void setIsDayTime(boolean flag)
    {
        sIsDaytime = flag;
    }

    protected void setOldDayOfMonth(int i)
    {
        mOldDayOfMonth = i;
    }

    private static int bkgSaveCount = 0;
    private static int customInfoLayerSaveCount = 0;
    private static boolean mChangeSkinFlag;
    private static int mOldDayOfMonth;
    private static Bitmap mWidgetDrawBuffer;
    private static int orgTextLayerSaveCount = 0;
    private static boolean sIsDaytime = true;
    private static int timeLayerSaveCount = 0;

}
