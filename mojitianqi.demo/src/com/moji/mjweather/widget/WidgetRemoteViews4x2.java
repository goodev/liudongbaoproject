// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WidgetRemoteViews4x2.java

package com.moji.mjweather.widget;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.*;
import android.widget.RemoteViews;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
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

class WidgetRemoteViews4x2 extends AbstractWidgetRemoteViews
{

    public WidgetRemoteViews4x2(Context context, String s)
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
            mWidgetDrawBuffer = SkinUtil.createDrawBuffer(Gl.getScreenTypeIntValue(), com.moji.mjweather.widgetskin.SkinInfo.SkinType.ST_4x2, f);
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
            if(cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE)
            {
                String s4 = cityweatherinfo.mWeatherMainInfo.mWeatherDescription;
                if(!cityweatherinfo.mWeatherMainInfo.mIsSpecCity)
                    s4 = (new StringBuilder()).append(s4).append(" ").append(cityweatherinfo.mWeatherMainInfo.mCurrentTemperature).append("\260").toString();
                paint1.setTextSize(widgettextinfo.cityDescSize);
                canvas.drawText(s4, 1F + widgettextinfo.cityDescX, 1F + widgettextinfo.cityDescY, paint1);
                paint.setTextSize(widgettextinfo.cityDescSize);
                canvas.drawText(s4, widgettextinfo.cityDescX, widgettextinfo.cityDescY, paint);
            }
            String s = Util.GetTWWeekName(Integer.valueOf(calendar.get(7)).intValue());
            SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd ");
            String s1 = (new StringBuilder()).append(simpledateformat.format(calendar.getTime())).append(s).toString();
            paint1.setTextAlign(android.graphics.Paint.Align.RIGHT);
            paint1.setTextSize(widgettextinfo.cityDateSize);
            canvas.drawText(s1, 1F + widgettextinfo.cityDateX, 1F + widgettextinfo.cityDateY, paint1);
            paint.setTextAlign(android.graphics.Paint.Align.RIGHT);
            paint.setTextSize(widgettextinfo.cityDateSize);
            canvas.drawText(s1, widgettextinfo.cityDateX, widgettextinfo.cityDateY, paint);
            String s2 = (new NongliUtil(calendar)).GetMonthDate();
            paint1.setTextSize(widgettextinfo.cityNLSize);
            canvas.drawText(s2, 1F + widgettextinfo.cityNLX, 1F + widgettextinfo.cityNLY, paint1);
            paint.setTextSize(widgettextinfo.cityNLSize);
            canvas.drawText(s2, widgettextinfo.cityNLX, widgettextinfo.cityNLY, paint);
            if(cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE)
            {
                String s3;
                if(cityweatherinfo.mWeatherMainInfo.mDaylight == 1)
                    s3 = (new StringBuilder()).append(cityweatherinfo.mWeatherMainInfo.mLowTemperature).append("~").append(cityweatherinfo.mWeatherMainInfo.mHighTemperature).append("\260").toString();
                else
                    s3 = (new StringBuilder()).append(Gl.Ct().getResources().getString(0x7f0b0150)).append(cityweatherinfo.mWeatherMainInfo.mLowTemperature).append("\260").toString();
                paint1.setTextSize(widgettextinfo.cityTemprSize);
                canvas.drawText(s3, 1F + widgettextinfo.cityTemprX, 1F + widgettextinfo.cityTemprY, paint1);
                paint.setTextSize(widgettextinfo.cityTemprSize);
                canvas.drawText(s3, widgettextinfo.cityTemprX, widgettextinfo.cityTemprY, paint);
            }
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
        return Gl.getCurrentSkin4x2();
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
        return 0x7f0200d9;
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
        widgettextinfo.timeY = 5F;
        widgettextinfo.hourLeftX = 160F;
        widgettextinfo.minuteLetfX = 490F;
        widgettextinfo.weatherIconX = 155F;
        widgettextinfo.weatherIconY = 100F;
        widgettextinfo.amPmX = 120F;
        widgettextinfo.amPmY = 170F;
        widgettextinfo.timeScale = 0.25F;
        widgettextinfo.weatherScale = 0.5F;
        widgettextinfo.amPmScale = 0.4F;
        widgettextinfo.colonFlagX = 325F;
        widgettextinfo.colonFlagY = 83F;
        widgettextinfo.colonFlagScale = 0.35F;
_L4:
        return widgettextinfo;
_L2:
        if(Gl.getScreenTypeIntValue() == 1)
        {
            widgettextinfo.timeY = 20F;
            widgettextinfo.hourLeftX = 143F;
            widgettextinfo.minuteLetfX = 473F;
            widgettextinfo.weatherIconX = 175F;
            widgettextinfo.weatherIconY = 150F;
            widgettextinfo.amPmX = 75F;
            widgettextinfo.amPmY = 180F;
            widgettextinfo.timeScale = 0.35F;
            widgettextinfo.weatherScale = 0.6F;
            widgettextinfo.amPmScale = 0.6F;
            widgettextinfo.colonFlagX = 300F;
            widgettextinfo.colonFlagY = 95F;
            widgettextinfo.colonFlagScale = 0.5F;
        } else
        if(Gl.getScreenTypeIntValue() == 2)
        {
            widgettextinfo.timeY = 30F;
            widgettextinfo.hourLeftX = 120F;
            widgettextinfo.minuteLetfX = 450F;
            widgettextinfo.weatherIconX = 150F;
            widgettextinfo.weatherIconY = 135F;
            widgettextinfo.timeScale = 0.55F;
            widgettextinfo.amPmX = 65F;
            widgettextinfo.amPmY = 175F;
            widgettextinfo.colonFlagX = 250F;
            widgettextinfo.colonFlagY = 85F;
            widgettextinfo.colonFlagScale = 0.9F;
        } else
        if(Gl.getScreenTypeIntValue() == 3)
        {
            widgettextinfo.timeY = 30F;
            widgettextinfo.hourLeftX = 120F;
            widgettextinfo.minuteLetfX = 450F;
            widgettextinfo.weatherIconX = 150F;
            widgettextinfo.weatherIconY = 145F;
            widgettextinfo.timeScale = 0.55F;
            widgettextinfo.amPmX = 65F;
            widgettextinfo.amPmY = 185F;
            widgettextinfo.colonFlagX = 250F;
            widgettextinfo.colonFlagY = 95F;
            widgettextinfo.colonFlagScale = 0.9F;
        } else
        if(Gl.getScreenTypeIntValue() == 5)
        {
            widgettextinfo.timeY = 20F;
            widgettextinfo.hourLeftX = 120F;
            widgettextinfo.minuteLetfX = 460F;
            widgettextinfo.weatherIconX = 145F;
            widgettextinfo.weatherIconY = 145F;
            widgettextinfo.amPmX = 100F;
            widgettextinfo.amPmY = 215F;
            widgettextinfo.timeScale = 0.27F;
            widgettextinfo.weatherScale = 0.5F;
            widgettextinfo.amPmScale = 0.4F;
            widgettextinfo.colonFlagX = 330F;
            widgettextinfo.colonFlagY = 135F;
            widgettextinfo.colonFlagScale = 0.35F;
        } else
        if(Gl.getScreenTypeIntValue() == 7)
        {
            widgettextinfo.timeY = 0F;
            widgettextinfo.hourLeftX = 145F;
            widgettextinfo.minuteLetfX = 470F;
            widgettextinfo.weatherIconX = 230F;
            widgettextinfo.weatherIconY = 170F;
            widgettextinfo.amPmX = 70F;
            widgettextinfo.amPmY = 145F;
            widgettextinfo.timeScale = 0.7F;
            widgettextinfo.weatherScale = 1F;
            widgettextinfo.amPmScale = 1.3F;
            widgettextinfo.colonFlagX = 300F;
            widgettextinfo.colonFlagY = 70F;
        } else
        if(Gl.getScreenTypeIntValue() == 8)
        {
            widgettextinfo.timeY = 15F;
            widgettextinfo.hourLeftX = 140F;
            widgettextinfo.minuteLetfX = 460F;
            widgettextinfo.weatherIconX = 155F;
            widgettextinfo.weatherIconY = 130F;
            widgettextinfo.amPmX = 65F;
            widgettextinfo.amPmY = 165F;
            widgettextinfo.timeScale = 0.6F;
            widgettextinfo.weatherScale = 1.1F;
            widgettextinfo.amPmScale = 1.1F;
            widgettextinfo.colonFlagX = 250F;
            widgettextinfo.colonFlagY = 75F;
        } else
        if(Gl.getScreenTypeIntValue() == 9)
        {
            widgettextinfo.timeY = 0F;
            widgettextinfo.hourLeftX = 255F;
            widgettextinfo.hourRightX = 290F;
            widgettextinfo.minuteLetfX = 600F;
            widgettextinfo.minuteRightX = 610F;
            widgettextinfo.weatherIconX = 172F;
            widgettextinfo.weatherIconY = 120F;
            widgettextinfo.amPmX = 95F;
            widgettextinfo.amPmY = 155F;
            widgettextinfo.timeScale = 0.7F;
            widgettextinfo.weatherScale = 1.5F;
            widgettextinfo.amPmScale = 1.5F;
            widgettextinfo.colonFlagX = 300F;
            widgettextinfo.colonFlagY = 70F;
        } else
        if(Gl.getScreenTypeIntValue() == 10)
        {
            widgettextinfo.timeY = 0F;
            widgettextinfo.hourLeftX = 195F;
            widgettextinfo.hourRightX = 230F;
            widgettextinfo.minuteLetfX = 540F;
            widgettextinfo.minuteRightX = 560F;
            widgettextinfo.weatherIconX = 120F;
            widgettextinfo.weatherIconY = 80F;
            widgettextinfo.amPmX = 85F;
            widgettextinfo.amPmY = 145F;
            widgettextinfo.timeScale = 0.7F;
            widgettextinfo.weatherScale = 1.7F;
            widgettextinfo.amPmScale = 1.5F;
            widgettextinfo.colonFlagX = 300F;
            widgettextinfo.colonFlagY = 70F;
        } else
        if(Gl.getScreenTypeIntValue() == 11)
        {
            widgettextinfo.timeY = 0F;
            widgettextinfo.hourLeftX = 195F;
            widgettextinfo.hourRightX = 230F;
            widgettextinfo.minuteLetfX = 540F;
            widgettextinfo.minuteRightX = 560F;
            widgettextinfo.weatherIconX = 120F;
            widgettextinfo.weatherIconY = 80F;
            widgettextinfo.amPmX = 85F;
            widgettextinfo.amPmY = 145F;
            widgettextinfo.timeScale = 0.7F;
            widgettextinfo.weatherScale = 1.7F;
            widgettextinfo.amPmScale = 1.5F;
            widgettextinfo.colonFlagX = 300F;
            widgettextinfo.colonFlagY = 70F;
        } else
        if(Gl.getScreenTypeIntValue() == 12)
        {
            widgettextinfo.timeY = 0F;
            widgettextinfo.hourLeftX = 190F;
            widgettextinfo.hourRightX = 205F;
            widgettextinfo.minuteLetfX = 515F;
            widgettextinfo.minuteRightX = 545F;
            widgettextinfo.weatherIconX = 210F;
            widgettextinfo.weatherIconY = 160F;
            widgettextinfo.amPmX = 90F;
            widgettextinfo.amPmY = 185F;
            widgettextinfo.timeScale = 0.6F;
            widgettextinfo.weatherScale = 1F;
            widgettextinfo.amPmScale = 1F;
            widgettextinfo.colonFlagX = 300F;
            widgettextinfo.colonFlagY = 70F;
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
        return "widget_4x2_bkg.png";
    }

    protected int getWidgetBkgID()
    {
        return 0x7f0201c2;
    }

    protected String getWidgetBkgcx()
    {
        return "bkgc4x2";
    }

    protected String getWidgetBkgx()
    {
        return "bkg4x2";
    }

    protected int getWidgetLayoutID()
    {
        return 0x7f030075;
    }

    protected int getWidgetMaskID()
    {
        return 0x7f0201c3;
    }

    protected String getWidgetNx()
    {
        return "n42_";
    }

    protected AbstractWidgetRemoteViews.WidgetTextInfo getWidgetTextInfo()
    {
        AbstractWidgetRemoteViews.WidgetTextInfo widgettextinfo = new AbstractWidgetRemoteViews.WidgetTextInfo();
        if(Gl.getScreenTypeIntValue() != 0) goto _L2; else goto _L1
_L1:
        widgettextinfo.cityNameX = 23F;
        widgettextinfo.cityNameY = 103F;
        widgettextinfo.cityNameSize = 16F;
        widgettextinfo.cityDescX = 13F;
        widgettextinfo.cityDescY = 121F;
        widgettextinfo.cityDescSize = 13F;
        widgettextinfo.cityDateX = 220F;
        widgettextinfo.cityDateY = 98F;
        widgettextinfo.cityDateSize = 11F;
        widgettextinfo.cityNLX = 225F;
        widgettextinfo.cityNLY = 110F;
        widgettextinfo.cityNLSize = 11F;
        widgettextinfo.cityTemprX = 230F;
        widgettextinfo.cityTemprY = 123F;
        widgettextinfo.cityTemprSize = 10F;
_L4:
        return widgettextinfo;
_L2:
        if(Gl.getScreenTypeIntValue() == 1)
        {
            widgettextinfo.cityNameX = 25F;
            widgettextinfo.cityNameY = 151F;
            widgettextinfo.cityNameSize = 24F;
            widgettextinfo.cityDescX = 17F;
            widgettextinfo.cityDescY = 177F;
            widgettextinfo.cityDescSize = 19F;
            widgettextinfo.cityDateX = 295F;
            widgettextinfo.cityDateY = 144F;
            widgettextinfo.cityDateSize = 16F;
            widgettextinfo.cityNLX = 300F;
            widgettextinfo.cityNLY = 161F;
            widgettextinfo.cityNLSize = 16F;
            widgettextinfo.cityTemprX = 305F;
            widgettextinfo.cityTemprY = 179F;
            widgettextinfo.cityTemprSize = 16F;
        } else
        if(Gl.getScreenTypeIntValue() == 2)
        {
            widgettextinfo.cityNameX = 32F;
            widgettextinfo.cityNameY = 240F;
            widgettextinfo.cityNameSize = 24F;
            widgettextinfo.cityDescX = 17F;
            widgettextinfo.cityDescY = 285F;
            widgettextinfo.cityDescSize = 26F;
            widgettextinfo.cityDateX = 450F;
            widgettextinfo.cityDateY = 234F;
            widgettextinfo.cityDateSize = 23F;
            widgettextinfo.cityNLX = 460F;
            widgettextinfo.cityNLY = 261F;
            widgettextinfo.cityNLSize = 23F;
            widgettextinfo.cityTemprX = 470F;
            widgettextinfo.cityTemprY = 286F;
            widgettextinfo.cityTemprSize = 23F;
        } else
        if(Gl.getScreenTypeIntValue() == 3)
        {
            widgettextinfo.cityNameX = 35F;
            widgettextinfo.cityNameY = 255F;
            widgettextinfo.cityNameSize = 33F;
            widgettextinfo.cityDescX = 23F;
            widgettextinfo.cityDescY = 292F;
            widgettextinfo.cityDescSize = 26F;
            widgettextinfo.cityDateX = 443F;
            widgettextinfo.cityDateY = 244F;
            widgettextinfo.cityDateSize = 23F;
            widgettextinfo.cityNLX = 453F;
            widgettextinfo.cityNLY = 271F;
            widgettextinfo.cityNLSize = 23F;
            widgettextinfo.cityTemprX = 458F;
            widgettextinfo.cityTemprY = 296F;
            widgettextinfo.cityTemprSize = 23F;
        } else
        if(Gl.getScreenTypeIntValue() == 5)
        {
            widgettextinfo.cityNameX = 20F;
            widgettextinfo.cityNameY = 120F;
            widgettextinfo.cityNameSize = 17F;
            widgettextinfo.cityDescX = 11F;
            widgettextinfo.cityDescY = 140F;
            widgettextinfo.cityDescSize = 13F;
            widgettextinfo.cityDateX = 220F;
            widgettextinfo.cityDateY = 116F;
            widgettextinfo.cityDateSize = 11F;
            widgettextinfo.cityNLX = 225F;
            widgettextinfo.cityNLY = 129F;
            widgettextinfo.cityNLSize = 11F;
            widgettextinfo.cityTemprX = 230F;
            widgettextinfo.cityTemprY = 142F;
            widgettextinfo.cityTemprSize = 11F;
        } else
        if(Gl.getScreenTypeIntValue() == 7)
        {
            widgettextinfo.cityNameX = 55F;
            widgettextinfo.cityNameY = 278F;
            widgettextinfo.cityNameSize = 38F;
            widgettextinfo.cityDescX = 40F;
            widgettextinfo.cityDescY = 323F;
            widgettextinfo.cityDescSize = 33F;
            widgettextinfo.cityDateX = 585F;
            widgettextinfo.cityDateY = 263F;
            widgettextinfo.cityDateSize = 30F;
            widgettextinfo.cityNLX = 598F;
            widgettextinfo.cityNLY = 298F;
            widgettextinfo.cityNLSize = 30F;
            widgettextinfo.cityTemprX = 608F;
            widgettextinfo.cityTemprY = 333F;
            widgettextinfo.cityTemprSize = 30F;
        } else
        if(Gl.getScreenTypeIntValue() == 8)
        {
            widgettextinfo.cityNameX = 48F;
            widgettextinfo.cityNameY = 260F;
            widgettextinfo.cityNameSize = 35F;
            widgettextinfo.cityDescX = 32F;
            widgettextinfo.cityDescY = 305F;
            widgettextinfo.cityDescSize = 30F;
            widgettextinfo.cityDateX = 495F;
            widgettextinfo.cityDateY = 245F;
            widgettextinfo.cityDateSize = 25F;
            widgettextinfo.cityNLX = 505F;
            widgettextinfo.cityNLY = 275F;
            widgettextinfo.cityNLSize = 25F;
            widgettextinfo.cityTemprX = 515F;
            widgettextinfo.cityTemprY = 305F;
            widgettextinfo.cityTemprSize = 25F;
        } else
        if(Gl.getScreenTypeIntValue() == 9)
        {
            widgettextinfo.cityNameX = 70F;
            widgettextinfo.cityNameY = 345F;
            widgettextinfo.cityNameSize = 46F;
            widgettextinfo.cityDescX = 54F;
            widgettextinfo.cityDescY = 405F;
            widgettextinfo.cityDescSize = 44F;
            widgettextinfo.cityDateX = 730F;
            widgettextinfo.cityDateY = 330F;
            widgettextinfo.cityDateSize = 38F;
            widgettextinfo.cityNLX = 740F;
            widgettextinfo.cityNLY = 370F;
            widgettextinfo.cityNLSize = 38F;
            widgettextinfo.cityTemprX = 750F;
            widgettextinfo.cityTemprY = 410F;
            widgettextinfo.cityTemprSize = 38F;
        } else
        if(Gl.getScreenTypeIntValue() == 10)
        {
            widgettextinfo.cityNameX = 53F;
            widgettextinfo.cityNameY = 315F;
            widgettextinfo.cityNameSize = 46F;
            widgettextinfo.cityDescX = 37F;
            widgettextinfo.cityDescY = 375F;
            widgettextinfo.cityDescSize = 44F;
            widgettextinfo.cityDateX = 670F;
            widgettextinfo.cityDateY = 305F;
            widgettextinfo.cityDateSize = 38F;
            widgettextinfo.cityNLX = 680F;
            widgettextinfo.cityNLY = 345F;
            widgettextinfo.cityNLSize = 38F;
            widgettextinfo.cityTemprX = 690F;
            widgettextinfo.cityTemprY = 385F;
            widgettextinfo.cityTemprSize = 38F;
        } else
        if(Gl.getScreenTypeIntValue() == 11)
        {
            widgettextinfo.cityNameX = 53F;
            widgettextinfo.cityNameY = 315F;
            widgettextinfo.cityNameSize = 46F;
            widgettextinfo.cityDescX = 37F;
            widgettextinfo.cityDescY = 375F;
            widgettextinfo.cityDescSize = 44F;
            widgettextinfo.cityDateX = 670F;
            widgettextinfo.cityDateY = 305F;
            widgettextinfo.cityDateSize = 38F;
            widgettextinfo.cityNLX = 680F;
            widgettextinfo.cityNLY = 345F;
            widgettextinfo.cityNLSize = 38F;
            widgettextinfo.cityTemprX = 690F;
            widgettextinfo.cityTemprY = 385F;
            widgettextinfo.cityTemprSize = 38F;
        } else
        if(Gl.getScreenTypeIntValue() == 12)
        {
            widgettextinfo.cityNameX = 55F;
            widgettextinfo.cityNameY = 260F;
            widgettextinfo.cityNameSize = 32F;
            widgettextinfo.cityDescX = 32F;
            widgettextinfo.cityDescY = 305F;
            widgettextinfo.cityDescSize = 28F;
            widgettextinfo.cityDateX = 545F;
            widgettextinfo.cityDateY = 245F;
            widgettextinfo.cityDateSize = 24F;
            widgettextinfo.cityNLX = 555F;
            widgettextinfo.cityNLY = 278F;
            widgettextinfo.cityNLSize = 24F;
            widgettextinfo.cityTemprX = 565F;
            widgettextinfo.cityTemprY = 310F;
            widgettextinfo.cityTemprSize = 24F;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected String getWidgetTextox()
    {
        return "texto42";
    }

    protected String getWidgetTimex()
    {
        return "time42";
    }

    protected boolean hasColonWhenUseBackground()
    {
        return false;
    }

    protected void loadSkin(String s)
    {
        if(getCurrentSkin() != null)
        {
            getCurrentSkin().CleanAll();
            Gl.setCurrentSkin4x2(null);
        }
        MojiLog.e("WidgetRemoteView4", "getCurrentSkin() == null");
        SkinLoader skinloader = new SkinLoader();
        try
        {
            skinloader.LoadSkinConfingFile(Gl.Ct(), Gl.getCurrentSkinDir(), s);
            Gl.setCurrentSkin4x2(skinloader.GetCurrentSkin(SkinInfo.getScreeType(UiUtil.getScreenWidth(), UiUtil.getScreenHeight()), com.moji.mjweather.widgetskin.SkinInfo.SkinType.ST_4x2));
        }
        catch(Exception exception) { }
        if(getCurrentSkin() == null)
            try
            {
                skinloader.RemoveAllInfo();
                if(!"ORG".equals(Gl.getCurrentSkinDir()))
                {
                    skinloader.LoadSkinConfingFile(Gl.Ct(), "ORG", s);
                    Gl.setCurrentSkin4x2(skinloader.GetCurrentSkin(SkinInfo.getScreeType(UiUtil.getScreenWidth(), UiUtil.getScreenHeight()), com.moji.mjweather.widgetskin.SkinInfo.SkinType.ST_4x2));
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
        Class class1 = WidgetManager.getWidgetClassByType(mWidgetType);
        Intent intent = new Intent(context, class1);
        intent.setAction("com.moji.mjweather.widget.LEFT_BITMAP_BUTTON");
        remoteviews.setOnClickPendingIntent(0x7f0d025c, PendingIntent.getBroadcast(context, 0, intent, 0));
        Intent intent1 = new Intent(context, class1);
        intent1.setAction("com.moji.mjweather.widget.RIGHT_BITMAP_BUTTON");
        remoteviews.setOnClickPendingIntent(0x7f0d025d, PendingIntent.getBroadcast(context, 0, intent1, 0));
        Intent intent2 = new Intent(context, class1);
        intent2.setAction("com.moji.mjweather.widget.LEFT_BOTTOM_BITMAP_BUTTON");
        remoteviews.setOnClickPendingIntent(0x7f0d0254, PendingIntent.getBroadcast(context, 0, intent2, 0));
        Intent intent3 = new Intent(context, class1);
        intent3.setAction("com.moji.mjweather.widget.MIDDLE_BOTTOM_BITMAP_BUTTON");
        remoteviews.setOnClickPendingIntent(0x7f0d025e, PendingIntent.getBroadcast(context, 0, intent3, 0));
        Intent intent4 = new Intent(context, class1);
        intent4.setAction("com.moji.mjweather.widget.RIGHT_BOTTOM_BITMAP_BUTTON");
        remoteviews.setOnClickPendingIntent(0x7f0d0255, PendingIntent.getBroadcast(context, 0, intent4, 0));
        if(!flag)
            remoteviews.setTextViewText(0x7f0d0256, "");
        if(flag1 && WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
        {
            Intent intent5 = new Intent();
            intent5.setClassName("com.moji.mjweather", "com.moji.mjweather.activity.TabSelectorActivity");
            intent5.setFlags(0x10200000);
            intent5.setAction("com.moji.mjweather.widget.UsageMessageActivity.ACTION_WIDGET_CONFIGURE");
            PendingIntent pendingintent = PendingIntent.getActivity(context, 0, intent5, 0);
            remoteviews.setOnClickPendingIntent(0x7f0d025c, pendingintent);
            remoteviews.setOnClickPendingIntent(0x7f0d025d, pendingintent);
            remoteviews.setOnClickPendingIntent(0x7f0d0254, pendingintent);
            remoteviews.setOnClickPendingIntent(0x7f0d025e, pendingintent);
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
