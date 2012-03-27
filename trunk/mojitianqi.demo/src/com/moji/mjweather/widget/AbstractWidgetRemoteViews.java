// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AbstractWidgetRemoteViews.java

package com.moji.mjweather.widget;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.*;
import android.net.Uri;
import android.os.Environment;
import android.widget.RemoteViews;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.data.*;
import com.moji.mjweather.util.*;
import com.moji.mjweather.widgetskin.SkinDrawIconInfo;
import com.moji.mjweather.widgetskin.SkinDrawTextInfo;
import com.moji.mjweather.widgetskin.SkinInfo;
import com.moji.mjweather.widgetskin.SkinSelector;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

abstract class AbstractWidgetRemoteViews
{
    private class RV
    {

        public void addView(RemoteViews remoteviews, RemoteViews remoteviews1, int i)
        {
            remoteviews.addView(i, remoteviews1);
        }

        public void removeAllViews(RemoteViews remoteviews, int i)
        {
            remoteviews.removeAllViews(i);
        }

        final AbstractWidgetRemoteViews this$0;

        private RV()
        {
            this$0 = AbstractWidgetRemoteViews.this;
            super();
        }

    }

    private static class TimeInfo
    {

        public static TimeInfo getTimeInfo(Context context)
        {
            TimeInfo timeinfo;
            timeinfo = new TimeInfo();
            timeinfo.timeVal = Integer.valueOf((new SimpleDateFormat("HHmm")).format(new Date())).intValue();
            int i;
            boolean flag;
            if(timeinfo.timeVal > 999)
                i = timeinfo.timeVal / 1000;
            else
                i = 0;
            timeinfo.hour1 = i;
            timeinfo.hour2 = timeinfo.timeVal / 100 - 10 * timeinfo.hour1;
            timeinfo.minute1 = timeinfo.timeVal / 10 - 100 * timeinfo.hour1 - 10 * timeinfo.hour2;
            timeinfo.minute2 = timeinfo.timeVal - 1000 * timeinfo.hour1 - 100 * timeinfo.hour2 - 10 * timeinfo.minute1;
            if(10 * timeinfo.hour1 + timeinfo.hour2 >= 12)
                flag = true;
            else
                flag = false;
            timeinfo.isPM = flag;
            timeinfo.is24HourFormat = Util.is24HourFormat(context);
            if(timeinfo.is24HourFormat) goto _L2; else goto _L1
_L1:
            if(10 * timeinfo.hour1 + timeinfo.hour2 <= 12) goto _L4; else goto _L3
_L3:
            int j = -12 + (10 * timeinfo.hour1 + timeinfo.hour2);
            if(j < 10 && j != 0)
            {
                timeinfo.hour1 = 0;
                timeinfo.hour2 = j;
            } else
            if(j == 0)
            {
                timeinfo.hour1 = 1;
                timeinfo.hour2 = 2;
            } else
            {
                timeinfo.hour1 = 1;
                timeinfo.hour2 = j + -10;
            }
_L2:
            return timeinfo;
_L4:
            if(timeinfo.hour1 == 0 && timeinfo.hour2 == 0)
            {
                timeinfo.hour1 = 1;
                timeinfo.hour2 = 2;
            }
            if(true) goto _L2; else goto _L5
_L5:
        }

        public int hour1;
        public int hour2;
        public boolean is24HourFormat;
        public boolean isPM;
        public int minute1;
        public int minute2;
        public int timeVal;

        private TimeInfo()
        {
        }
    }

    /* member class not found */
    class WidgetTextInfo {}


    public AbstractWidgetRemoteViews(Context context, String s)
    {
        mMinuteLast = -1;
        mHourLast = -1;
        mContext = context;
        mWidgetType = s;
    }

    private void addToList(boolean flag, int i, List list, Bitmap bitmap, Bitmap bitmap1, Bitmap bitmap2, Bitmap bitmap3, 
            int j, int k)
    {
        if(flag)
        {
            list.add(scaledBitmapUri(bitmap, (new StringBuilder()).append("hour").append(i).append("_").append(1).append(".png").toString(), j, k));
            list.add(scaledBitmapUri(bitmap1, (new StringBuilder()).append("hour").append(i).append("_").append(2).append(".png").toString(), j, k));
            list.add(scaledBitmapUri(bitmap2, (new StringBuilder()).append("hour").append(i).append("_").append(3).append(".png").toString(), j, k));
            list.add(scaledBitmapUri(bitmap3, (new StringBuilder()).append("hour").append(i).append("_").append(4).append(".png").toString(), j, k));
        } else
        {
            list.add(scaledBitmapUri(bitmap, (new StringBuilder()).append("minute").append(i).append("_").append(1).append(".png").toString(), j, k));
            list.add(scaledBitmapUri(bitmap1, (new StringBuilder()).append("minute").append(i).append("_").append(2).append(".png").toString(), j, k));
            list.add(scaledBitmapUri(bitmap2, (new StringBuilder()).append("minute").append(i).append("_").append(3).append(".png").toString(), j, k));
            list.add(scaledBitmapUri(bitmap3, (new StringBuilder()).append("minute").append(i).append("_").append(4).append(".png").toString(), j, k));
        }
    }

    private void clearAllView(RemoteViews remoteviews)
    {
        if(remoteviews != null)
        {
            remoteviews.setImageViewResource(0x7f0d024a, getLoadingBg());
            remoteviews.setImageViewResource(0x7f0d024b, 0x7f020046);
            if(getWidgetLayoutID() == 0x7f030075)
                clearDefaultTimeView(remoteviews);
            clearSDCardTimeView(remoteviews);
        }
    }

    private void clearDefaultTimeView(RemoteViews remoteviews)
    {
        if(remoteviews != null)
        {
            remoteviews.setImageViewResource(0x7f0d0257, 0x7f020046);
            remoteviews.setImageViewResource(0x7f0d0258, 0x7f020046);
            if(Gl.getClockAimationEnable())
            {
                (new RV()).removeAllViews(remoteviews, 0x7f0d025a);
                (new RV()).removeAllViews(remoteviews, 0x7f0d0259);
            }
            remoteviews.setViewVisibility(0x7f0d025a, 8);
            remoteviews.setViewVisibility(0x7f0d0259, 8);
        }
    }

    private void clearSDCardTimeView(RemoteViews remoteviews)
    {
        if(remoteviews != null)
        {
            remoteviews.setImageViewResource(0x7f0d024c, 0x7f020046);
            remoteviews.setImageViewResource(0x7f0d024d, 0x7f020046);
            remoteviews.setImageViewResource(0x7f0d024e, 0x7f020046);
            remoteviews.setImageViewResource(0x7f0d024f, 0x7f020046);
            remoteviews.setImageViewResource(0x7f0d0250, 0x7f020046);
        }
    }

    private void clearWeatherInfoView(RemoteViews remoteviews)
    {
        if(remoteviews != null)
            remoteviews.setImageViewResource(0x7f0d0251, 0x7f020046);
    }

    private RemoteViews createRemoteViewsWithDefaultSkin(Context context, boolean flag)
    {
        RemoteViews remoteviews = new RemoteViews(context.getPackageName(), getWidgetLayoutID());
        int i = Gl.getClockAnimationItem().intValue();
        CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(Gl.getCurrentCityIndex());
        MojiLog.v("AbstractWidgetRemoteViews", (new StringBuilder()).append("createRemoteViewsWithDefaultSkin, city ID = ").append(cityweatherinfo.m_cityID).toString());
        clearSDCardTimeView(remoteviews);
        Bitmap bitmap = null;
        Bitmap bitmap1 = createDrawBuffer();
        bitmap1.eraseColor(Color.argb(0, 0, 0, 0));
        Canvas canvas = new Canvas(bitmap1);
        TimeInfo timeinfo = TimeInfo.getTimeInfo(context);
        WidgetTextInfo widgettextinfo = getTimeAndWeatherIconInfo();
        canvas.save();
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        if(Gl.getClockAimationEnable() && mWidgetType.equals("4x2"))
        {
            MojiLog.d("AbstractWidgetRemoteViews", (new StringBuilder()).append("last = ").append(mMinuteLast).append(", current = ").append(timeinfo.minute2).toString());
            remoteviews.setViewVisibility(0x7f0d0257, 8);
            remoteviews.setViewVisibility(0x7f0d0258, 8);
            remoteviews.setViewVisibility(0x7f0d0259, 0);
            remoteviews.setViewVisibility(0x7f0d025a, 0);
            RV rv = new RV();
            rv.removeAllViews(remoteviews, 0x7f0d025a);
            rv.removeAllViews(remoteviews, 0x7f0d0259);
            int j = timeinfo.hour1;
            int k = timeinfo.hour2;
            int l;
            int i1;
            if(timeinfo.minute1 == 0 && timeinfo.minute2 == 0)
                if(timeinfo.hour2 == 0)
                {
                    if(timeinfo.hour1 == 0)
                    {
                        j = 2;
                        k = 3;
                    } else
                    {
                        j = -1 + timeinfo.hour1;
                        k = 9;
                    }
                } else
                {
                    k = -1 + timeinfo.hour2;
                }
            if(timeinfo.minute2 != 0)
                l = timeinfo.minute1;
            else
            if(timeinfo.minute1 == 0)
                l = 5;
            else
                l = -1 + timeinfo.minute1;
            if(timeinfo.minute2 == 0)
                i1 = 9;
            else
                i1 = -1 + timeinfo.minute2;
            if(i == 3 || i == 6)
            {
                String s;
                Bitmap bitmap2;
                Bitmap bitmap3;
                if(mHourLast != timeinfo.hour2)
                {
                    mHourLast = timeinfo.hour2;
                    RemoteViews remoteviews4 = new RemoteViews(context.getPackageName(), getHourAnimation());
                    rv.addView(remoteviews, remoteviews4, 0x7f0d0259);
                    remoteviews.setImageViewUri(0x7f0d0018, halfBitmap(true, 1, SkinUtil.getNumBitmapResID(timeinfo.hour1), SkinUtil.getNumBitmapResID(timeinfo.hour2)));
                    remoteviews.setImageViewUri(0x7f0d001a, halfBitmap(true, 2, SkinUtil.getNumBitmapResID(j), SkinUtil.getNumBitmapResID(k)));
                    remoteviews.setImageViewUri(0x7f0d001e, halfBitmap(true, 3, SkinUtil.getNumBitmapResID(timeinfo.hour1), SkinUtil.getNumBitmapResID(timeinfo.hour2)));
                    remoteviews.setImageViewUri(0x7f0d001c, halfBitmap(true, 4, SkinUtil.getNumBitmapResID(j), SkinUtil.getNumBitmapResID(k)));
                    if(i == 3)
                        remoteviews.setImageViewResource(0x7f0d01e9, 0x7f020145);
                } else
                {
                    Uri uri = wholeBitmap(true, "full_hour", SkinUtil.getNumBitmapResID(timeinfo.hour1), SkinUtil.getNumBitmapResID(timeinfo.hour2), i);
                    if(i == 3)
                    {
                        RemoteViews remoteviews1 = new RemoteViews(context.getPackageName(), 0x7f030055);
                        rv.addView(remoteviews, remoteviews1, 0x7f0d0259);
                        remoteviews.setImageViewResource(0x7f0d01eb, 0x7f020145);
                        remoteviews.setImageViewResource(0x7f0d01ec, 0x7f020145);
                        remoteviews.setImageViewUri(0x7f0d01ed, uri);
                    } else
                    if(i == 6)
                    {
                        remoteviews.setViewVisibility(0x7f0d0257, 0);
                        remoteviews.setImageViewResource(0x7f0d0257, 0x7f020046);
                        remoteviews.setImageViewUri(0x7f0d0257, uri);
                    }
                }
                if(mMinuteLast != timeinfo.minute2)
                {
                    mMinuteLast = timeinfo.minute2;
                    RemoteViews remoteviews3 = new RemoteViews(context.getPackageName(), getMinuteAnimation());
                    rv.addView(remoteviews, remoteviews3, 0x7f0d025a);
                    remoteviews.setImageViewUri(0x7f0d0020, halfBitmap(false, 1, SkinUtil.getNumBitmapResID(timeinfo.minute1), SkinUtil.getNumBitmapResID(timeinfo.minute2)));
                    remoteviews.setImageViewUri(0x7f0d0022, halfBitmap(false, 2, SkinUtil.getNumBitmapResID(l), SkinUtil.getNumBitmapResID(i1)));
                    remoteviews.setImageViewUri(0x7f0d0026, halfBitmap(false, 3, SkinUtil.getNumBitmapResID(timeinfo.minute1), SkinUtil.getNumBitmapResID(timeinfo.minute2)));
                    remoteviews.setImageViewUri(0x7f0d0024, halfBitmap(false, 4, SkinUtil.getNumBitmapResID(l), SkinUtil.getNumBitmapResID(i1)));
                    if(i == 3)
                        remoteviews.setImageViewResource(0x7f0d01ea, 0x7f020145);
                } else
                {
                    Uri uri1 = wholeBitmap(true, "full_minute", SkinUtil.getNumBitmapResID(timeinfo.minute1), SkinUtil.getNumBitmapResID(timeinfo.minute2), i);
                    if(i == 3)
                    {
                        RemoteViews remoteviews2 = new RemoteViews(context.getPackageName(), 0x7f030056);
                        rv.addView(remoteviews, remoteviews2, 0x7f0d025a);
                        remoteviews.setImageViewResource(0x7f0d01ee, 0x7f020145);
                        remoteviews.setImageViewResource(0x7f0d01ef, 0x7f020145);
                        remoteviews.setImageViewUri(0x7f0d01f0, uri1);
                    } else
                    if(i == 6)
                    {
                        remoteviews.setViewVisibility(0x7f0d0258, 0);
                        remoteviews.setImageViewResource(0x7f0d0258, 0x7f020046);
                        remoteviews.setImageViewUri(0x7f0d0258, uri1);
                    }
                }
            } else
            if(i == 0 || i == 4)
            {
                if(mHourLast != timeinfo.hour2)
                {
                    mHourLast = timeinfo.hour2;
                    RemoteViews remoteviews6 = new RemoteViews(context.getPackageName(), getHourAnimation());
                    rv.addView(remoteviews, remoteviews6, 0x7f0d0259);
                    List list3 = null;
                    RemoteViews remoteviews5;
                    List list2;
                    if(i == 4)
                    {
                        list3 = fourRect(0, 1, true, SkinUtil.getNumBitmapResID(timeinfo.hour1), SkinUtil.getNumBitmapResID(timeinfo.hour2));
                        List list5 = fourRect(0, 2, true, SkinUtil.getNumBitmapResID(j), SkinUtil.getNumBitmapResID(k));
                        list3.addAll(list5);
                    } else
                    if(i == 0)
                    {
                        list3 = fourRect(2, 1, true, SkinUtil.getNumBitmapResID(timeinfo.hour1), SkinUtil.getNumBitmapResID(timeinfo.hour2));
                        List list4 = fourRect(2, 2, true, SkinUtil.getNumBitmapResID(j), SkinUtil.getNumBitmapResID(k));
                        list3.addAll(list4);
                    }
                    remoteviews.setImageViewUri(0x7f0d00a5, (Uri)list3.get(0));
                    remoteviews.setImageViewUri(0x7f0d00a7, (Uri)list3.get(1));
                    remoteviews.setImageViewUri(0x7f0d00a9, (Uri)list3.get(2));
                    remoteviews.setImageViewUri(0x7f0d00ab, (Uri)list3.get(3));
                    remoteviews.setImageViewUri(0x7f0d00ad, (Uri)list3.get(4));
                    remoteviews.setImageViewUri(0x7f0d00af, (Uri)list3.get(5));
                    remoteviews.setImageViewUri(0x7f0d00b1, (Uri)list3.get(6));
                    remoteviews.setImageViewUri(0x7f0d00b3, (Uri)list3.get(7));
                    list3.removeAll(list3);
                } else
                {
                    remoteviews.setViewVisibility(0x7f0d0257, 0);
                    remoteviews.setImageViewResource(0x7f0d0257, 0x7f020046);
                    remoteviews.setImageViewUri(0x7f0d0257, wholeBitmap(true, "full_hour", SkinUtil.getNumBitmapResID(timeinfo.hour1), SkinUtil.getNumBitmapResID(timeinfo.hour2), i));
                }
                if(mMinuteLast != timeinfo.minute2)
                {
                    mMinuteLast = timeinfo.minute2;
                    remoteviews5 = new RemoteViews(context.getPackageName(), getMinuteAnimation());
                    rv.addView(remoteviews, remoteviews5, 0x7f0d025a);
                    List list = null;
                    if(i == 4)
                    {
                        list = fourRect(0, 1, false, SkinUtil.getNumBitmapResID(timeinfo.minute1), SkinUtil.getNumBitmapResID(timeinfo.minute2));
                        list2 = fourRect(0, 2, false, SkinUtil.getNumBitmapResID(l), SkinUtil.getNumBitmapResID(i1));
                        list.addAll(list2);
                    } else
                    if(i == 0)
                    {
                        list = fourRect(2, 1, false, SkinUtil.getNumBitmapResID(timeinfo.minute1), SkinUtil.getNumBitmapResID(timeinfo.minute2));
                        List list1 = fourRect(2, 2, false, SkinUtil.getNumBitmapResID(l), SkinUtil.getNumBitmapResID(i1));
                        list.addAll(list1);
                    }
                    remoteviews.setImageViewUri(0x7f0d00b5, (Uri)list.get(0));
                    remoteviews.setImageViewUri(0x7f0d00b7, (Uri)list.get(1));
                    remoteviews.setImageViewUri(0x7f0d00b9, (Uri)list.get(2));
                    remoteviews.setImageViewUri(0x7f0d00bb, (Uri)list.get(3));
                    remoteviews.setImageViewUri(0x7f0d00bd, (Uri)list.get(4));
                    remoteviews.setImageViewUri(0x7f0d00bf, (Uri)list.get(5));
                    remoteviews.setImageViewUri(0x7f0d00c1, (Uri)list.get(6));
                    remoteviews.setImageViewUri(0x7f0d00c3, (Uri)list.get(7));
                    list.removeAll(list);
                } else
                {
                    remoteviews.setViewVisibility(0x7f0d0258, 0);
                    remoteviews.setImageViewResource(0x7f0d0258, 0x7f020046);
                    remoteviews.setImageViewUri(0x7f0d0258, wholeBitmap(true, "full_minute", SkinUtil.getNumBitmapResID(timeinfo.minute1), SkinUtil.getNumBitmapResID(timeinfo.minute2), i));
                }
            } else
            if(i == 5)
            {
                if(mHourLast != timeinfo.hour2)
                {
                    mHourLast = timeinfo.hour2;
                    RemoteViews remoteviews10 = new RemoteViews(context.getPackageName(), getHourAnimation());
                    rv.addView(remoteviews, remoteviews10, 0x7f0d0259);
                    List list7 = fourRect(2, 1, true, SkinUtil.getNumBitmapResID(j), SkinUtil.getNumBitmapResID(k));
                    list7.addAll(fourRect(2, 2, true, SkinUtil.getNumBitmapResID(timeinfo.hour1), SkinUtil.getNumBitmapResID(timeinfo.hour2)));
                    remoteviews.setImageViewUri(0x7f0d00f6, (Uri)list7.get(0));
                    remoteviews.setImageViewUri(0x7f0d00f7, (Uri)list7.get(1));
                    remoteviews.setImageViewUri(0x7f0d00f8, (Uri)list7.get(2));
                    remoteviews.setImageViewUri(0x7f0d00f9, (Uri)list7.get(3));
                    remoteviews.setImageViewUri(0x7f0d00fa, (Uri)list7.get(4));
                    remoteviews.setImageViewUri(0x7f0d00fb, (Uri)list7.get(5));
                    remoteviews.setImageViewUri(0x7f0d00fc, (Uri)list7.get(6));
                    remoteviews.setImageViewUri(0x7f0d00fd, (Uri)list7.get(7));
                    list7.removeAll(list7);
                } else
                {
                    remoteviews.setViewVisibility(0x7f0d0257, 0);
                    remoteviews.setImageViewResource(0x7f0d0257, 0x7f020046);
                    remoteviews.setImageViewUri(0x7f0d0257, wholeBitmap(true, "full_hour", SkinUtil.getNumBitmapResID(timeinfo.hour1), SkinUtil.getNumBitmapResID(timeinfo.hour2), i));
                }
                if(mMinuteLast != timeinfo.minute2)
                {
                    mMinuteLast = timeinfo.minute2;
                    RemoteViews remoteviews9 = new RemoteViews(context.getPackageName(), getMinuteAnimation());
                    rv.addView(remoteviews, remoteviews9, 0x7f0d025a);
                    List list6 = fourRect(2, 1, false, SkinUtil.getNumBitmapResID(l), SkinUtil.getNumBitmapResID(i1));
                    list6.addAll(fourRect(2, 2, false, SkinUtil.getNumBitmapResID(timeinfo.minute1), SkinUtil.getNumBitmapResID(timeinfo.minute2)));
                    remoteviews.setImageViewUri(0x7f0d00fe, (Uri)list6.get(0));
                    remoteviews.setImageViewUri(0x7f0d00ff, (Uri)list6.get(1));
                    remoteviews.setImageViewUri(0x7f0d0100, (Uri)list6.get(2));
                    remoteviews.setImageViewUri(0x7f0d0101, (Uri)list6.get(3));
                    remoteviews.setImageViewUri(0x7f0d0102, (Uri)list6.get(4));
                    remoteviews.setImageViewUri(0x7f0d0103, (Uri)list6.get(5));
                    remoteviews.setImageViewUri(0x7f0d0104, (Uri)list6.get(6));
                    remoteviews.setImageViewUri(0x7f0d0105, (Uri)list6.get(7));
                    list6.removeAll(list6);
                } else
                {
                    remoteviews.setViewVisibility(0x7f0d0258, 0);
                    remoteviews.setImageViewResource(0x7f0d0258, 0x7f020046);
                    remoteviews.setImageViewUri(0x7f0d0258, wholeBitmap(true, "full_minute", SkinUtil.getNumBitmapResID(timeinfo.minute1), SkinUtil.getNumBitmapResID(timeinfo.minute2), i));
                }
            } else
            if(i == 7)
            {
                int j2 = timeinfo.hour1;
                int k2 = timeinfo.hour2;
                int l2 = timeinfo.minute1;
                int i3 = timeinfo.minute2;
                setFourRectsBitmapUri(7, remoteviews, j2, k2, j, k, l2, i3, l, i1, timeinfo, context, i);
            } else
            if(i == 8)
            {
                int j1 = timeinfo.hour1;
                int k1 = timeinfo.hour2;
                int l1 = timeinfo.minute1;
                int i2 = timeinfo.minute2;
                setFourRectsBitmapUri(8, remoteviews, j, k, j1, k1, l, i1, l1, i2, timeinfo, context, i);
            } else
            {
                if(mHourLast != timeinfo.hour2)
                {
                    mHourLast = timeinfo.hour2;
                    RemoteViews remoteviews8 = new RemoteViews(context.getPackageName(), getHourAnimation());
                    rv.addView(remoteviews, remoteviews8, 0x7f0d0259);
                    remoteviews.setViewVisibility(0x7f0d0257, 0);
                    remoteviews.setImageViewResource(0x7f0d0257, 0x7f020144);
                    remoteviews.setImageViewUri(0x7f0d0236, wholeBitmap(false, "full_hour", SkinUtil.getNumBitmapResID(timeinfo.hour1), SkinUtil.getNumBitmapResID(timeinfo.hour2), i));
                    remoteviews.setImageViewUri(0x7f0d0238, wholeBitmap(false, "full_hour_old", SkinUtil.getNumBitmapResID(j), SkinUtil.getNumBitmapResID(k), i));
                } else
                {
                    remoteviews.setViewVisibility(0x7f0d0257, 0);
                    remoteviews.setImageViewResource(0x7f0d0257, 0x7f020046);
                    remoteviews.setImageViewUri(0x7f0d0257, wholeBitmap(true, "full_hour", SkinUtil.getNumBitmapResID(timeinfo.hour1), SkinUtil.getNumBitmapResID(timeinfo.hour2), i));
                }
                if(mMinuteLast != timeinfo.minute2)
                {
                    mMinuteLast = timeinfo.minute2;
                    RemoteViews remoteviews7 = new RemoteViews(context.getPackageName(), getMinuteAnimation());
                    rv.addView(remoteviews, remoteviews7, 0x7f0d025a);
                    remoteviews.setViewVisibility(0x7f0d0258, 0);
                    remoteviews.setImageViewResource(0x7f0d0258, 0x7f020144);
                    remoteviews.setImageViewUri(0x7f0d023a, wholeBitmap(false, "full_minute", SkinUtil.getNumBitmapResID(timeinfo.minute1), SkinUtil.getNumBitmapResID(timeinfo.minute2), i));
                    remoteviews.setImageViewUri(0x7f0d023c, wholeBitmap(false, "full_minute_old", SkinUtil.getNumBitmapResID(l), SkinUtil.getNumBitmapResID(i1), i));
                } else
                {
                    remoteviews.setViewVisibility(0x7f0d0258, 0);
                    remoteviews.setImageViewResource(0x7f0d0258, 0x7f020046);
                    remoteviews.setImageViewUri(0x7f0d0258, wholeBitmap(true, "full_minute", SkinUtil.getNumBitmapResID(timeinfo.minute1), SkinUtil.getNumBitmapResID(timeinfo.minute2), i));
                }
            }
        } else
        {
            if(mWidgetType.equals("4x2"))
            {
                clearDefaultTimeView(remoteviews);
                canvas.scale(widgettextinfo.timeScale, widgettextinfo.timeScale);
                Bitmap bitmap4;
                float f;
                float f1;
                float f2;
                float f3;
                if(Gl.getWidgetUseBackground() == 0)
                    bitmap4 = wholeBitmap(true, SkinUtil.getNumBitmapResID(timeinfo.hour1), SkinUtil.getNumBitmapResID(timeinfo.hour2));
                else
                    bitmap4 = wholeBitmap(false, SkinUtil.getNumBitmapResID(timeinfo.hour1), SkinUtil.getNumBitmapResID(timeinfo.hour2));
                f = widgettextinfo.hourLeftX;
                f1 = widgettextinfo.timeY;
                canvas.drawBitmap(bitmap4, f, f1, null);
                if(Gl.getWidgetUseBackground() == 0)
                    bitmap = wholeBitmap(true, SkinUtil.getNumBitmapResID(timeinfo.minute1), SkinUtil.getNumBitmapResID(timeinfo.minute2));
                else
                    bitmap = wholeBitmap(false, SkinUtil.getNumBitmapResID(timeinfo.minute1), SkinUtil.getNumBitmapResID(timeinfo.minute2));
                f2 = widgettextinfo.minuteLetfX;
                f3 = widgettextinfo.timeY;
                canvas.drawBitmap(bitmap, f2, f3, null);
            } else
            if(!mWidgetType.equals("4x1"));
            if(bitmap != null)
                bitmap.recycle();
        }
        if(cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
        {
            if(!timeinfo.is24HourFormat && mWidgetType.equals("4x2"))
            {
                canvas.restore();
                canvas.save();
                canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
                canvas.scale(widgettextinfo.amPmScale, widgettextinfo.amPmScale);
                bitmap3 = BitmapFactory.decodeStream(Gl.Ct().getResources().openRawResource(SkinUtil.getAMPMResID(timeinfo.isPM)));
                canvas.drawBitmap(bitmap3, widgettextinfo.amPmX, widgettextinfo.amPmY, null);
                if(bitmap3 != null)
                    bitmap3.recycle();
            }
            canvas.restore();
            canvas.save();
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.scale(widgettextinfo.weatherScale, widgettextinfo.weatherScale);
            bitmap2 = BitmapFactory.decodeStream(Gl.Ct().getResources().openRawResource(UiUtil.getWeatherIconResouceId(cityweatherinfo.mWeatherMainInfo.mWeatherId, UiUtil.isDay(WeatherData.getCityInfo(Gl.getCurrentCityIndex())))));
            canvas.drawBitmap(bitmap2, widgettextinfo.weatherIconX, widgettextinfo.weatherIconY, null);
            if(bitmap2 != null)
                bitmap2.recycle();
        }
        remoteviews.setImageViewResource(0x7f0d024b, 0x7f020046);
        remoteviews.setImageViewResource(0x7f0d024c, 0x7f020046);
        canvas.restore();
        drawText(canvas, cityweatherinfo);
        SkinUtil.saveBitmapToPrivateDir(context, (new StringBuilder()).append(getWidgetTextox()).append(createOrgTextLayerSaveSeq()).append(".png").toString(), bitmap1);
        s = (new StringBuilder()).append(getWidgetTextox()).append(getOrgTextLayerSaveSeq()).append(".png").toString();
        remoteviews.setImageViewUri(0x7f0d0251, Uri.parse((new StringBuilder()).append(mContext.getFilesDir()).append("/").append(s).toString()));
        if(Gl.getWidgetUseBackground() == 0)
            remoteviews.setImageViewResource(0x7f0d024a, getWidgetBkgID());
        else
            remoteviews.setImageViewResource(0x7f0d024a, 0x7f020046);
        return setHotAreaAction(context, remoteviews, false, true);
    }

    private RemoteViews createRemoteViewsWithSDCardSkin(Context context, boolean flag)
    {
        RemoteViews remoteviews;
        CityWeatherInfo cityweatherinfo;
        String s = context.getPackageName();
        int i = getWidgetLayoutID();
        remoteviews = new RemoteViews(s, i);
        cityweatherinfo = WeatherData.getCityInfo(Gl.getCurrentCityIndex());
        if(MojiLog.isDevelopMode())
            MojiLog.v("AbstractWidgetRemoteViews", (new StringBuilder()).append("createRemoteViewsWithSDCardSkin, city ID = ").append(cityweatherinfo.m_cityID).append(", updateNow = ").append(flag).toString());
        if(Environment.getExternalStorageState().equals("mounted")) goto _L2; else goto _L1
_L1:
        clearAllView(remoteviews);
        String s10 = Gl.Ct().getResources().getString(0x7f0b0152);
        remoteviews.setTextViewText(0x7f0d0256, s10);
        remoteviews = setHotAreaAction(context, remoteviews, true, true);
_L24:
        return remoteviews;
_L2:
        SkinInfo skininfo;
        boolean flag4;
        Bitmap bitmap;
        PaintFlagsDrawFilter paintflagsdrawfilter;
        PaintFlagsDrawFilter paintflagsdrawfilter1;
        Canvas canvas;
        SkinDrawIconInfo skindrawiconinfo;
        if(mRebootSDError)
        {
            mRebootSDError = false;
            reloadSkin(Gl.getScreenTypeString());
        }
        skininfo = getCurrentSkin();
        if(skininfo == null)
        {
            clearSDCardTimeView(remoteviews);
            clearAllView(remoteviews);
            clearWeatherInfoView(remoteviews);
            String s9 = Gl.Ct().getResources().getString(0x7f0b0153);
            remoteviews.setTextViewText(0x7f0d0256, s9);
            Intent intent1 = new Intent(context, com/moji/mjweather/widgetskin/SkinSelector);
            intent1.setAction("com.moji.mjweather.widget.UsageMessageActivity.ACTION_WIDGET_CONFIGURE");
            PendingIntent pendingintent1 = PendingIntent.getActivity(context, 0, intent1, 0);
            remoteviews.setOnClickPendingIntent(0x7f0d024c, pendingintent1);
            continue; /* Loop/switch isn't completed */
        }
        if(cityweatherinfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
        {
            String s8 = Gl.Ct().getResources().getString(0x7f0b0154);
            remoteviews.setTextViewText(0x7f0d0256, s8);
            clearAllView(remoteviews);
            remoteviews.setImageViewResource(0x7f0d0251, 0x7f020046);
            Intent intent = new Intent(context, Gl.getMainActivityClass());
            intent.setFlags(0x10200000);
            intent.setAction("com.moji.mjweather.widget.UsageMessageActivity.ACTION_WIDGET_CONFIGURE");
            PendingIntent pendingintent = PendingIntent.getActivity(context, 0, intent, 0);
            remoteviews.setOnClickPendingIntent(0x7f0d024c, pendingintent);
            MojiLog.d("AbstractWidgetRemoteViews", "no city is set, show message!");
            remoteviews = setHotAreaAction(context, remoteviews, true, true);
            continue; /* Loop/switch isn't completed */
        }
        TimeInfo timeinfo = TimeInfo.getTimeInfo(context);
        int j = Calendar.getInstance().get(5);
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag5;
        ArrayList arraylist;
        int k;
        int l;
        if(getOldDayOfMonth() != j)
            flag1 = true;
        else
            flag1 = false;
        setOldDayOfMonth(j);
        flag2 = UiUtil.isDay(cityweatherinfo);
        if(getIsDayTime() != flag2)
            flag3 = true;
        else
            flag3 = false;
        setIsDayTime(flag2);
        if(MojiLog.isDevelopMode())
        {
            MojiLog.d("AbstractWidgetRemoteViews", (new StringBuilder()).append("m_isUserTextBeAnalysis = ").append(skininfo.m_isUserTextBeAnalysisCount).toString());
            MojiLog.d("AbstractWidgetRemoteViews", (new StringBuilder()).append("dayTimeChanged = ").append(flag3).append(", dateChanged = ").append(flag1).toString());
        }
        if(flag || flag3 || flag1)
            flag4 = true;
        else
            flag4 = false;
        bitmap = createDrawBuffer();
        paintflagsdrawfilter = new PaintFlagsDrawFilter(0, 2);
        paintflagsdrawfilter1 = new PaintFlagsDrawFilter(2, 0);
        if(skininfo.m_UseIconTimeClock)
            flag5 = true;
        else
            flag5 = false;
        if(skininfo.m_isUserTextBeAnalysisCount < 1 || flag4)
            if(flag5)
            {
                bitmap.eraseColor(Color.argb(0, 0, 0, 0));
                Canvas canvas2 = new Canvas(bitmap);
                SkinDrawIconInfo skindrawiconinfo2 = skininfo.GetTargetIconInfo(com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_TIME_COLON);
                if(skindrawiconinfo2 != null)
                {
                    Bitmap bitmap4 = SkinUtil.getColonSkinBitmap(context, skininfo.m_useOrgNumberIcon, Gl.getCurrentSkinDir());
                    SkinUtil.drawBitmapToLayer(context, bitmap4, skindrawiconinfo2, canvas2, paintflagsdrawfilter, paintflagsdrawfilter1, null);
                    bitmap4.recycle();
                }
                SkinDrawIconInfo skindrawiconinfo3 = skininfo.GetTargetIconInfo(com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_TIME_COLON_AUTO);
                if(skindrawiconinfo3 != null && Gl.getWidgetUseBackground() == 1)
                {
                    Bitmap bitmap3 = SkinUtil.getColonSkinBitmap(context, skininfo.m_useOrgNumberIcon, Gl.getCurrentSkinDir());
                    SkinUtil.drawBitmapToLayer(context, bitmap3, skindrawiconinfo3, canvas2, paintflagsdrawfilter, paintflagsdrawfilter1, null);
                    bitmap3.recycle();
                }
                if(!timeinfo.is24HourFormat && cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
                {
                    SkinDrawIconInfo skindrawiconinfo4 = skininfo.GetTargetIconInfo(com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_TIME_AMPM);
                    if(skindrawiconinfo4 != null)
                    {
                        Bitmap bitmap2 = SkinUtil.getAMPMSkinBitmap(context, timeinfo.isPM, Gl.getCurrentSkinDir());
                        if(bitmap2 != null)
                        {
                            SkinUtil.drawBitmapToLayer(context, bitmap2, skindrawiconinfo4, canvas2, paintflagsdrawfilter, paintflagsdrawfilter1, null);
                            bitmap2.recycle();
                        }
                    }
                }
                SkinUtil.saveBitmapToPrivateDir(context, (new StringBuilder()).append(getWidgetTimex()).append(createTimeLayerSaveSeq()).append(".png").toString(), bitmap);
            } else
            if(!skininfo.m_UseTextTimeClock)
                bitmap.eraseColor(Color.argb(0, 0, 0, 0));
        if(flag5)
        {
            String s3 = (new StringBuilder()).append(Gl.getCurrentSkinDir()).append(getWidgetNx()).append(timeinfo.hour1).append("0.png").toString();
            Uri uri2 = Uri.parse((new StringBuilder()).append(mContext.getFilesDir()).append("/").append(s3).toString());
            remoteviews.setImageViewUri(0x7f0d024d, uri2);
            String s4 = (new StringBuilder()).append(Gl.getCurrentSkinDir()).append(getWidgetNx()).append(timeinfo.hour2).append("1.png").toString();
            Uri uri3 = Uri.parse((new StringBuilder()).append(mContext.getFilesDir()).append("/").append(s4).toString());
            remoteviews.setImageViewUri(0x7f0d024e, uri3);
            String s5 = (new StringBuilder()).append(Gl.getCurrentSkinDir()).append(getWidgetNx()).append(timeinfo.minute1).append("2.png").toString();
            Uri uri4 = Uri.parse((new StringBuilder()).append(mContext.getFilesDir()).append("/").append(s5).toString());
            remoteviews.setImageViewUri(0x7f0d024f, uri4);
            MojiLog.d("AbstractWidgetRemoteViews", (new StringBuilder()).append("widgetMinute1TimeLayer = ").append(uri4.toString()).toString());
            String s6 = (new StringBuilder()).append(Gl.getCurrentSkinDir()).append(getWidgetNx()).append(timeinfo.minute2).append("3.png").toString();
            Uri uri5 = Uri.parse((new StringBuilder()).append(mContext.getFilesDir()).append("/").append(s6).toString());
            remoteviews.setImageViewUri(0x7f0d0250, uri5);
            MojiLog.d("AbstractWidgetRemoteViews", (new StringBuilder()).append("widgetMinute2TimeLayer = ").append(uri5.toString()).toString());
            String s7 = (new StringBuilder()).append(getWidgetTimex()).append(getTimeLayerSaveSeq()).append(".png").toString();
            Uri uri6 = Uri.parse((new StringBuilder()).append(mContext.getFilesDir()).append("/").append(s7).toString());
            remoteviews.setImageViewUri(0x7f0d024c, uri6);
        } else
        {
            clearSDCardTimeView(remoteviews);
        }
        if(Gl.getWidgetUseBackground() == 0 && (skininfo.m_isUserTextBeAnalysisCount < 1 || getChangeSkinFlag()))
        {
            setChangeSkinFlag(false);
            bitmap.eraseColor(Color.argb(0, 0, 0, 0));
            Canvas canvas1 = new Canvas(bitmap);
            skininfo.GetTargetIconInfo(com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_BACKGROUND_MASK);
            SkinDrawIconInfo skindrawiconinfo1 = skininfo.GetTargetIconInfo(com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_BACKGROUND);
            if(skindrawiconinfo1 != null)
                SkinUtil.drawBitmapToLayer(context, getBackgroundSkinBitmap(context, skininfo.m_useOrgBackground, Gl.getCurrentSkinDir(), skindrawiconinfo1.mCustomBitmapName), skindrawiconinfo1, canvas1, paintflagsdrawfilter, paintflagsdrawfilter1, null);
            SkinUtil.saveBitmapToPrivateDir(context, (new StringBuilder()).append(getWidgetBkgx()).append(createBackgroundSaveSeq()).append(".png").toString(), bitmap);
        }
        if(skininfo.m_isUserTextBeAnalysisCount >= 1 && !flag4)
            break MISSING_BLOCK_LABEL_2401;
        bitmap.eraseColor(Color.argb(0, 0, 0, 0));
        canvas = new Canvas(bitmap);
        if(getWidgetLayoutID() == 0x7f030075)
            clearDefaultTimeView(remoteviews);
        remoteviews.setImageViewResource(0x7f0d0251, 0x7f020046);
        arraylist = skininfo.m_needDrawIconList;
        k = 0;
        l = arraylist.size();
        if(k >= l)
            break MISSING_BLOCK_LABEL_1950;
        skindrawiconinfo = (SkinDrawIconInfo)arraylist.get(k);
        if(skindrawiconinfo.mContentType.ordinal() > com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_BACKGROUND_MASK.ordinal())
            break; /* Loop/switch isn't completed */
_L21:
        k++;
        if(true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_1502;
_L3:
        Bitmap bitmap1;
        int i2;
        int j2;
        bitmap1 = null;
        i2 = -1;
        j2 = 0;
        class _cls1
        {

            static final int $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[];

            static 
            {
                $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType = new int[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.values().length];
                NoSuchFieldError nosuchfielderror16;
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_CUSTOM.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_CURRENT.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_FORECAST_00_12.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_FORECAST_DAY_1.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_FORECAST_DAY_2.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_FORECAST_DAY_3.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_FORECAST_DAY_4.ordinal()] = 7;
                }
                catch(NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_FORECAST_DAY_5.ordinal()] = 8;
                }
                catch(NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_FORECAST_NIGHT_1.ordinal()] = 9;
                }
                catch(NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_FORECAST_NIGHT_2.ordinal()] = 10;
                }
                catch(NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_FORECAST_NIGHT_3.ordinal()] = 11;
                }
                catch(NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_FORECAST_NIGHT_4.ordinal()] = 12;
                }
                catch(NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_FORECAST_NIGHT_5.ordinal()] = 13;
                }
                catch(NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_FORECAST_00_12_TYPE2.ordinal()] = 14;
                }
                catch(NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_CURRENT_TYPE2.ordinal()] = 15;
                }
                catch(NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_FORECAST_00_12_TYPE3.ordinal()] = 16;
                }
                catch(NoSuchFieldError nosuchfielderror15) { }
                $SwitchMap$com$moji$mjweather$widgetskin$SkinInfo$BitmapContentType[com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_WEATHER_ICON_CURRENT_TYPE3.ordinal()] = 17;
_L2:
                return;
                nosuchfielderror16;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType[skindrawiconinfo.mContentType.ordinal()];
        JVM INSTR tableswitch 1 17: default 1712
    //                   1 1768
    //                   2 1785
    //                   3 1785
    //                   4 1798
    //                   5 1810
    //                   6 1822
    //                   7 1834
    //                   8 1846
    //                   9 1858
    //                   10 1870
    //                   11 1882
    //                   12 1894
    //                   13 1906
    //                   14 1918
    //                   15 1918
    //                   16 1934
    //                   17 1934;
           goto _L5 _L6 _L7 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L18 _L19 _L19
_L6:
        break; /* Loop/switch isn't completed */
_L5:
        break; /* Loop/switch isn't completed */
_L19:
        break MISSING_BLOCK_LABEL_1934;
_L22:
        if(skindrawiconinfo.mContentType != com.moji.mjweather.widgetskin.SkinInfo.BitmapContentType.CT_CUSTOM)
            bitmap1 = getWeatherIconSkinBitmap(context, skininfo.m_org_weather_icon_used, Gl.getCurrentSkinDir(), i2, j2, true, cityweatherinfo);
        SkinUtil.drawBitmapToLayer(context, bitmap1, skindrawiconinfo, canvas, paintflagsdrawfilter, paintflagsdrawfilter1, null);
        bitmap1.recycle();
        if(true) goto _L21; else goto _L20
_L20:
        bitmap1 = SkinUtil.getSkinBmpByName(context, Gl.getCurrentSkinDir(), skindrawiconinfo.mCustomBitmapName);
          goto _L22
_L7:
        i2 = cityweatherinfo.mWeatherMainInfo.mWeatherId;
          goto _L22
_L8:
        i2 = getDayWeatherIconID(cityweatherinfo, 1, true);
          goto _L22
_L9:
        i2 = getDayWeatherIconID(cityweatherinfo, 2, true);
          goto _L22
_L10:
        i2 = getDayWeatherIconID(cityweatherinfo, 3, true);
          goto _L22
_L11:
        i2 = getDayWeatherIconID(cityweatherinfo, 4, true);
          goto _L22
_L12:
        i2 = getDayWeatherIconID(cityweatherinfo, 5, true);
          goto _L22
_L13:
        i2 = getDayWeatherIconID(cityweatherinfo, 1, false);
          goto _L22
_L14:
        i2 = getDayWeatherIconID(cityweatherinfo, 2, false);
          goto _L22
_L15:
        i2 = getDayWeatherIconID(cityweatherinfo, 3, false);
          goto _L22
_L16:
        i2 = getDayWeatherIconID(cityweatherinfo, 4, false);
          goto _L22
_L17:
        i2 = getDayWeatherIconID(cityweatherinfo, 5, false);
          goto _L22
_L18:
        i2 = cityweatherinfo.mWeatherMainInfo.mWeatherId;
        j2 = 2;
          goto _L22
        i2 = cityweatherinfo.mWeatherMainInfo.mWeatherId;
        j2 = 3;
          goto _L22
        ArrayList arraylist1 = skininfo.m_needDrawTextList;
        if(skininfo.m_isUserTextBeAnalysisCount == 0 || flag4)
        {
            int i1 = 0;
            do
            {
                int j1 = arraylist1.size();
                if(i1 >= j1)
                    break;
                SkinDrawTextInfo skindrawtextinfo1 = (SkinDrawTextInfo)arraylist1.get(i1);
                if(skindrawtextinfo1.mContentType == com.moji.mjweather.widgetskin.SkinInfo.TextContentType.CT_CUSTOM)
                    if(cityweatherinfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE)
                        skindrawtextinfo1.mRealShowText = "";
                    else
                        skindrawtextinfo1.mRealShowText = dealSkinUserString(cityweatherinfo, skindrawtextinfo1.mUserSettingText);
                i1++;
            } while(true);
        }
        Paint paint = new Paint();
        paint.setFlags(1);
        paint.setAntiAlias(true);
        Paint paint1 = new Paint();
        int k1 = 0;
        do
        {
            int l1 = arraylist1.size();
            if(k1 >= l1)
                break;
            SkinDrawTextInfo skindrawtextinfo = (SkinDrawTextInfo)arraylist1.get(k1);
            if(skindrawtextinfo.mContentType == com.moji.mjweather.widgetskin.SkinInfo.TextContentType.CT_CUSTOM && skindrawtextinfo.mRealShowText.length() > 0)
            {
                if(skindrawtextinfo.mUseShadow)
                {
                    paint1.setColor(Color.argb(255, Color.red(skindrawtextinfo.mShadowColor), Color.green(skindrawtextinfo.mShadowColor), Color.blue(skindrawtextinfo.mShadowColor)));
                    paint1.setTextSize(skindrawtextinfo.mSize);
                    paint1.setTextAlign(skindrawtextinfo.mAlign);
                    BlurMaskFilter blurmaskfilter = new BlurMaskFilter(skindrawtextinfo.mShadowBlurSize, android.graphics.BlurMaskFilter.Blur.NORMAL);
                    paint1.setMaskFilter(blurmaskfilter);
                    canvas.drawText(skindrawtextinfo.mRealShowText, skindrawtextinfo.mX + skindrawtextinfo.mShadowOffsetX, skindrawtextinfo.mY + skindrawtextinfo.mShadowOffsetY, paint1);
                }
                paint.setTextSize(skindrawtextinfo.mSize);
                paint.setTextAlign(skindrawtextinfo.mAlign);
                paint.setColor(Color.argb(255, Color.red(skindrawtextinfo.mColor), Color.green(skindrawtextinfo.mColor), Color.blue(skindrawtextinfo.mColor)));
                canvas.drawText(skindrawtextinfo.mRealShowText, skindrawtextinfo.mX, skindrawtextinfo.mY, paint);
            }
            k1++;
        } while(true);
        skininfo.m_isUserTextBeAnalysisCount = 1 + skininfo.m_isUserTextBeAnalysisCount;
        SkinUtil.saveBitmapToPrivateDir(context, (new StringBuilder()).append(getWidgetBkgcx()).append(createCustomInfoLayerSaveSeq()).append(".png").toString(), bitmap);
        String s1;
        Uri uri;
        if(Gl.getWidgetUseBackground() == 0)
        {
            String s2 = (new StringBuilder()).append(getWidgetBkgx()).append(getBackgroundSaveSeq()).append(".png").toString();
            Uri uri1 = Uri.parse((new StringBuilder()).append(mContext.getFilesDir()).append("/").append(s2).toString());
            remoteviews.setImageViewUri(0x7f0d024a, uri1);
        } else
        {
            remoteviews.setImageViewResource(0x7f0d024a, 0x7f020046);
        }
        s1 = (new StringBuilder()).append(getWidgetBkgcx()).append(getCustomInfoLayerSaveSeq()).append(".png").toString();
        uri = Uri.parse((new StringBuilder()).append(mContext.getFilesDir()).append("/").append(s1).toString());
        remoteviews.setImageViewUri(0x7f0d024b, uri);
        remoteviews = setHotAreaAction(context, remoteviews, false, false);
        if(true) goto _L24; else goto _L23
_L23:
    }

    private String dealSkinUserString(CityWeatherInfo cityweatherinfo, String s)
    {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(7);
        Date date = calendar.getTime();
        String s1 = s.replaceFirst("\\$date_short_type1", (new SimpleDateFormat((new StringBuilder()).append("MM").append(mContext.getResources().getString(0x7f0b0129)).append("dd").append(mContext.getResources().getString(0x7f0b012a)).toString())).format(date)).replaceFirst("\\$date_short_type2", (new SimpleDateFormat("MM-dd")).format(date)).replaceFirst("\\$date_short_type3", (new SimpleDateFormat("MM/dd")).format(date));
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy");
        SimpleDateFormat simpledateformat1 = new SimpleDateFormat("MM");
        SimpleDateFormat simpledateformat2 = new SimpleDateFormat("dd");
        String s2 = s1.replaceFirst("\\$date_year", simpledateformat.format(date)).replaceFirst("\\$date_month", simpledateformat1.format(date)).replaceFirst("\\$date_day", simpledateformat2.format(date)).replaceFirst("\\$date_nl", (new NongliUtil(calendar)).GetMonthDate()).replaceFirst("\\$date_jq", Util.GetJQByDate(date)).replaceFirst("\\$week", Util.GetTWWeekName(Integer.valueOf(i).intValue())).replaceFirst("\\$time_type1", (new SimpleDateFormat((new StringBuilder()).append("HH").append(mContext.getResources().getString(0x7f0b012c)).append("mm").append(mContext.getResources().getString(0x7f0b012d)).toString())).format(date)).replaceFirst("\\$time_type2", (new SimpleDateFormat("HH:mm")).format(date));
        String s5;
        int j;
        if(cityweatherinfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE)
        {
            s5 = s2.replaceFirst("\\$w_cd_temp_type1", "").replaceFirst("\\$w_cd_desp", "").replaceFirst("\\$w_cd_date", "").replaceFirst("\\$w_cd_time", "").replaceFirst("\\$w_cd_update_time", "").replaceFirst("\\$time_sunrise", "").replaceFirst("\\$time_sunset", "").replaceFirst("\\$w_cd_Humidity", "").replaceFirst("\\$w_cd_uv", "").replaceFirst("\\$w_cd_wind", "").replaceFirst("\\$city_name", "");
        } else
        {
            String s3 = s2.replaceFirst("\\$w_cd_temp_type1", String.valueOf(cityweatherinfo.mWeatherMainInfo.mCurrentTemperature)).replaceFirst("\\$w_cd_desp", cityweatherinfo.mWeatherMainInfo.mWeatherDescription).replaceFirst("\\$w_cd_date", Util.getDateType1(cityweatherinfo.mWeatherMainInfo.mSolarUpdateDate)).replaceFirst("\\$w_cd_time", cityweatherinfo.mWeatherMainInfo.mLastUpdateTime).replaceFirst("\\$w_cd_update_time", (new StringBuilder()).append(cityweatherinfo.m_lastUpdateDate).append(" ").append(cityweatherinfo.m_lastUpdateTime).toString());
            String s4;
            if(cityweatherinfo.mWeatherDayDetailInfoList.size() > 0)
                s4 = s3.replaceFirst("\\$time_sunrise", ((WeatherDayDetailInfo)cityweatherinfo.mWeatherDayDetailInfoList.get(0)).mSunRise).replaceFirst("\\$time_sunset", ((WeatherDayDetailInfo)cityweatherinfo.mWeatherDayDetailInfoList.get(0)).mSunSet);
            else
                s4 = s3.replaceFirst("\\$time_sunrise", "").replaceFirst("\\$time_sunset", "");
            s5 = s4.replaceFirst("\\$w_cd_Humidity", String.valueOf((int)cityweatherinfo.mWeatherMainInfo.mHumidity)).replaceFirst("\\$w_cd_uv", cityweatherinfo.mWeatherMainInfo.mUV).replaceFirst("\\$w_cd_wind", (new StringBuilder()).append(cityweatherinfo.mWeatherMainInfo.mWindDirection).append(cityweatherinfo.mWeatherMainInfo.mWindSpeed).append("\u7EA7").toString()).replaceFirst("\\$city_name", cityweatherinfo.mCityName);
        }
        j = 1;
        while(j <= 5) 
        {
            if(cityweatherinfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE)
            {
                s5 = s5.replaceFirst((new StringBuilder()).append("\\$w_fd").append(j).append("_day_desp").toString(), "").replaceFirst((new StringBuilder()).append("\\$w_fd").append(j).append("_night_desp").toString(), "").replaceFirst((new StringBuilder()).append("\\$w_fd").append(j).append("_date_type1").toString(), "").replaceFirst((new StringBuilder()).append("\\$w_fd").append(j).append("_date_type2").toString(), "").replaceFirst((new StringBuilder()).append("\\$w_fd").append(j).append("_week").toString(), "").replaceFirst((new StringBuilder()).append("\\$w_fd").append(j).append("_day_temp").toString(), "").replaceFirst((new StringBuilder()).append("\\$w_fd").append(j).append("_night_temp").toString(), "");
            } else
            {
                String s6 = (new StringBuilder()).append("\\$w_fd").append(j).append("_day_desp").toString();
                String s7 = ((WeatherTrendInfo)cityweatherinfo.mWeatherTrendInfoList.get(j + -1)).mHighTempDes;
                String s8 = s5.replaceFirst(s6, s7).replaceFirst((new StringBuilder()).append("\\$w_fd").append(j).append("_night_desp").toString(), ((WeatherTrendInfo)cityweatherinfo.mWeatherTrendInfoList.get(j + -1)).mLowTempDes).replaceFirst((new StringBuilder()).append("\\$w_fd").append(j).append("_date_type1").toString(), Util.getDateType1(((WeatherDayDetailInfo)cityweatherinfo.mWeatherDayDetailInfoList.get(j + -1)).mDate)).replaceFirst((new StringBuilder()).append("\\$w_fd").append(j).append("_date_type2").toString(), Util.getConVertDate(((WeatherDayDetailInfo)cityweatherinfo.mWeatherDayDetailInfoList.get(j + -1)).mDate, false)).replaceFirst((new StringBuilder()).append("\\$w_fd").append(j).append("_week").toString(), Util.GetWeekName(((WeatherDayDetailInfo)cityweatherinfo.mWeatherDayDetailInfoList.get(j + -1)).mWeek));
                String s9;
                String s10;
                String s11;
                if(j == 1 && ((WeatherDayDetailInfo)cityweatherinfo.mWeatherDayDetailInfoList.get(j + -1)).mHighTemperature == 100)
                    s9 = s8.replaceFirst((new StringBuilder()).append("\\$w_fd").append(j).append("_day_temp").toString(), String.valueOf(((WeatherDayDetailInfo)cityweatherinfo.mWeatherDayDetailInfoList.get(j)).mHighTemperature));
                else
                    s9 = s8.replaceFirst((new StringBuilder()).append("\\$w_fd").append(j).append("_day_temp").toString(), String.valueOf(((WeatherDayDetailInfo)cityweatherinfo.mWeatherDayDetailInfoList.get(j + -1)).mHighTemperature));
                s10 = (new StringBuilder()).append("\\$w_fd").append(j).append("_night_temp").toString();
                s11 = String.valueOf(((WeatherDayDetailInfo)cityweatherinfo.mWeatherDayDetailInfoList.get(j + -1)).mLowTemperature);
                s5 = s9.replaceFirst(s10, s11);
            }
            j++;
        }
        MojiLog.v("AbstractWidgetRemoteViews", (new StringBuilder()).append("SkinUerString = ").append(s5).toString());
        return s5;
    }

    private List fourRect(int i, int j, boolean flag, int k, int l)
    {
        ArrayList arraylist;
        Bitmap bitmap;
        arraylist = new ArrayList();
        bitmap = BitmapFactory.decodeResource(mContext.getResources(), 0x7f020144).copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        bitmap.prepareToDraw();
        Canvas canvas = new Canvas(bitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Bitmap bitmap1 = BitmapFactory.decodeResource(mContext.getResources(), k);
        canvas.drawBitmap(bitmap1, new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight()), new Rect(10, 22, 10 + bitmap1.getWidth(), 22 + bitmap1.getHeight()), null);
        Bitmap bitmap2 = BitmapFactory.decodeResource(mContext.getResources(), l);
        canvas.drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), new Rect(10 + bitmap1.getWidth(), 22, 10 + bitmap1.getWidth() + bitmap2.getWidth(), 22 + bitmap2.getHeight()), null);
        bitmap1.recycle();
        bitmap2.recycle();
        if(i != 0) goto _L2; else goto _L1
_L1:
        addToList(flag, j, arraylist, Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth() / 4, bitmap.getHeight()), Bitmap.createBitmap(bitmap, bitmap.getWidth() / 4, 0, bitmap.getWidth() / 4, bitmap.getHeight()), Bitmap.createBitmap(bitmap, (2 * bitmap.getWidth()) / 4, 0, bitmap.getWidth() / 4, bitmap.getHeight()), Bitmap.createBitmap(bitmap, (3 * bitmap.getWidth()) / 4, 0, bitmap.getWidth() / 4, bitmap.getHeight()), 125, 500);
        bitmap.recycle();
_L4:
        return arraylist;
_L2:
        if(i == 1)
        {
            addToList(flag, j, arraylist, Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth() / 2, bitmap.getHeight() / 2), Bitmap.createBitmap(bitmap, bitmap.getWidth() / 2, 0, bitmap.getWidth() / 2, bitmap.getHeight() / 2), Bitmap.createBitmap(bitmap, 0, bitmap.getHeight() / 2, bitmap.getWidth() / 2, bitmap.getHeight() / 2), Bitmap.createBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, bitmap.getHeight() / 2), 250, 250);
            bitmap.recycle();
        } else
        if(i == 2)
        {
            addToList(flag, j, arraylist, Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight() / 4), Bitmap.createBitmap(bitmap, 0, bitmap.getHeight() / 4, bitmap.getWidth(), bitmap.getHeight() / 4), Bitmap.createBitmap(bitmap, 0, (2 * bitmap.getHeight()) / 4, bitmap.getWidth(), bitmap.getHeight() / 4), Bitmap.createBitmap(bitmap, 0, (3 * bitmap.getHeight()) / 4, bitmap.getWidth(), bitmap.getHeight() / 4), 500, 125);
            bitmap.recycle();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private Bitmap getBackgroundSkinBitmap(Context context, boolean flag, String s, String s1)
    {
        if(!flag) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = SkinUtil.getBmpByResId(context, getWidgetMaskID());
_L4:
        return bitmap;
_L2:
        bitmap = BitmapFactory.decodeFile((new StringBuilder()).append(SkinUtil.getMojiDir()).append(s).append("/").append(getWidgetBkgFileName()).toString());
        if(bitmap == null)
            bitmap = SkinUtil.getBmpByResId(context, 0x7f0200f2);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static int getDayWeatherIconID(CityWeatherInfo cityweatherinfo, int i, boolean flag)
    {
        int j = -1;
        if(cityweatherinfo.mWeatherDayDetailInfoList.size() > 0)
            if(flag)
            {
                if(i == 1 && cityweatherinfo.mWeatherMainInfo.mDaylight == 0)
                    j = ((WeatherDayDetailInfo)cityweatherinfo.mWeatherDayDetailInfoList.get(i + -1)).mLowWeatherIconId;
                else
                    j = ((WeatherDayDetailInfo)cityweatherinfo.mWeatherDayDetailInfoList.get(i + -1)).mHighWeatherIconId;
            } else
            {
                j = ((WeatherDayDetailInfo)cityweatherinfo.mWeatherDayDetailInfoList.get(i + -1)).mLowWeatherIconId;
            }
        return j;
    }

    private int getHourAnimation()
    {
        int i = 0x7f030053;
        Gl.getClockAnimationItem().intValue();
        JVM INSTR tableswitch 0 9: default 64
    //                   0 66
    //                   1 73
    //                   2 80
    //                   3 64
    //                   4 87
    //                   5 94
    //                   6 101
    //                   7 108
    //                   8 115
    //                   9 122;
           goto _L1 _L2 _L3 _L4 _L1 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        return i;
_L2:
        i = 0x7f03005e;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 0x7f030070;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 0x7f03006c;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 0x7f030029;
        continue; /* Loop/switch isn't completed */
_L6:
        i = 0x7f03003b;
        continue; /* Loop/switch isn't completed */
_L7:
        i = 0x7f030006;
        continue; /* Loop/switch isn't completed */
_L8:
        i = 0x7f03002d;
        continue; /* Loop/switch isn't completed */
_L9:
        i = 0x7f03002b;
        continue; /* Loop/switch isn't completed */
_L10:
        i = 0x7f030069;
        if(true) goto _L1; else goto _L11
_L11:
    }

    private int getMinuteAnimation()
    {
        int i = 0x7f030054;
        Gl.getClockAnimationItem().intValue();
        JVM INSTR tableswitch 0 9: default 64
    //                   0 66
    //                   1 73
    //                   2 80
    //                   3 64
    //                   4 87
    //                   5 94
    //                   6 101
    //                   7 108
    //                   8 115
    //                   9 122;
           goto _L1 _L2 _L3 _L4 _L1 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        return i;
_L2:
        i = 0x7f03005f;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 0x7f030071;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 0x7f03006d;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 0x7f03002a;
        continue; /* Loop/switch isn't completed */
_L6:
        i = 0x7f03003c;
        continue; /* Loop/switch isn't completed */
_L7:
        i = 0x7f030007;
        continue; /* Loop/switch isn't completed */
_L8:
        i = 0x7f03002e;
        continue; /* Loop/switch isn't completed */
_L9:
        i = 0x7f03002c;
        continue; /* Loop/switch isn't completed */
_L10:
        i = 0x7f03006a;
        if(true) goto _L1; else goto _L11
_L11:
    }

    private Bitmap getWeatherIconSkinBitmap(Context context, boolean flag, String s, int i, int j, boolean flag1, CityWeatherInfo cityweatherinfo)
    {
        if(!flag) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = SkinUtil.getBmpByResId(context, UiUtil.getWeatherIconResouceId(i, UiUtil.isDay(WeatherData.getCityInfo(Gl.getCurrentCityIndex()))));
_L4:
        return bitmap;
_L2:
        int k = UiUtil.getWeatherID(i, UiUtil.isDay(WeatherData.getCityInfo(Gl.getCurrentCityIndex())));
        if(j == 0)
        {
            bitmap = BitmapFactory.decodeFile((new StringBuilder()).append(SkinUtil.getMojiDir()).append(s).append("/w").append(k).append(".png").toString());
            if(bitmap == null)
                bitmap = SkinUtil.getBmpByResId(context, 0x7f0200f2);
        } else
        {
            bitmap = BitmapFactory.decodeFile((new StringBuilder()).append(SkinUtil.getMojiDir()).append(s).append("/w").append(k).append("_t").append(j).append(".png").toString());
            if(bitmap == null)
                bitmap = SkinUtil.getBmpByResId(context, 0x7f0200f2);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private int getWidth()
    {
        return UiUtil.getScreenWidth();
    }

    private Uri halfBitmap(boolean flag, int i, int j, int k)
    {
        Bitmap bitmap = null;
        String s = "";
        Bitmap bitmap1 = null;
        Bitmap bitmap2 = BitmapFactory.decodeResource(mContext.getResources(), 0x7f020145).copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmap2);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Bitmap bitmap3 = BitmapFactory.decodeResource(mContext.getResources(), j);
        canvas.drawBitmap(bitmap3, new Rect(0, 0, bitmap3.getWidth(), bitmap3.getHeight()), new Rect(10, 22, 10 + bitmap3.getWidth(), 22 + bitmap3.getHeight()), null);
        Bitmap bitmap4 = BitmapFactory.decodeResource(mContext.getResources(), k);
        canvas.drawBitmap(bitmap4, new Rect(0, 0, bitmap4.getWidth(), bitmap4.getHeight()), new Rect(10 + bitmap3.getWidth(), 22, 10 + bitmap3.getWidth() + bitmap4.getWidth(), 22 + bitmap4.getHeight()), null);
        bitmap3.recycle();
        bitmap4.recycle();
        if(i == 1)
        {
            bitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight() / 2);
            Uri uri;
            if(getWidth() == 640)
                bitmap1 = Bitmap.createScaledBitmap(bitmap, 500, 250, false);
            else
            if(getWidth() == 720 || getWidth() == 1196 || getWidth() == 1280)
                bitmap1 = Bitmap.createScaledBitmap(bitmap, 800, 400, false);
            else
            if(getWidth() == 800 || getWidth() == 1280)
                bitmap1 = Bitmap.createScaledBitmap(bitmap, 800, 400, false);
            if(flag)
                s = "hour1_1.png";
            else
                s = "minute1_1.png";
        } else
        if(i == 2)
        {
            bitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight() / 2);
            if(getWidth() == 640)
                bitmap1 = Bitmap.createScaledBitmap(bitmap, 500, 250, false);
            else
            if(getWidth() == 720 || getWidth() == 1196 || getWidth() == 1280)
                bitmap1 = Bitmap.createScaledBitmap(bitmap, 600, 400, false);
            else
            if(getWidth() == 800 || getWidth() == 1280)
                bitmap1 = Bitmap.createScaledBitmap(bitmap, 600, 400, false);
            if(flag)
                s = "hour1_2.png";
            else
                s = "minute1_2.png";
        } else
        if(i == 3)
        {
            bitmap = Bitmap.createBitmap(bitmap2, 0, bitmap2.getHeight() / 2, bitmap2.getWidth(), bitmap2.getHeight() / 2);
            if(getWidth() == 640)
                bitmap1 = Bitmap.createScaledBitmap(bitmap, 500, 250, false);
            else
            if(getWidth() == 720 || getWidth() == 1196 || getWidth() == 1280)
                bitmap1 = Bitmap.createScaledBitmap(bitmap, 600, 400, false);
            else
            if(getWidth() == 800 || getWidth() == 1280)
                bitmap1 = Bitmap.createScaledBitmap(bitmap, 600, 400, false);
            if(flag)
                s = "hour1_3.png";
            else
                s = "minute1_3.png";
        } else
        if(i == 4)
        {
            bitmap = Bitmap.createBitmap(bitmap2, 0, bitmap2.getHeight() / 2, bitmap2.getWidth(), bitmap2.getHeight() / 2);
            if(getWidth() == 640)
                bitmap1 = Bitmap.createScaledBitmap(bitmap, 500, 250, false);
            else
            if(getWidth() == 720 || getWidth() == 1196 || getWidth() == 1280)
                bitmap1 = Bitmap.createScaledBitmap(bitmap, 600, 400, false);
            else
            if(getWidth() == 800 || getWidth() == 1280)
                bitmap1 = Bitmap.createScaledBitmap(bitmap, 600, 400, false);
            if(flag)
                s = "hour1_4.png";
            else
                s = "minute1_4.png";
        }
        if(getWidth() == 640 || getWidth() == 720 || getWidth() == 800 || getWidth() == 1280 || getWidth() == 1196)
        {
            SkinUtil.saveBitmapToPrivateDir(mContext, s, bitmap1);
            bitmap.recycle();
        } else
        {
            SkinUtil.saveBitmapToPrivateDir(mContext, s, bitmap);
        }
        uri = Uri.parse((new StringBuilder()).append(mContext.getFilesDir()).append("/").append(s).toString());
        bitmap2.recycle();
        return uri;
    }

    private Uri scaledBitmapUri(Bitmap bitmap, String s, int i, int j)
    {
        if(getWidth() == 640 || getWidth() == 720 || getWidth() == 800 || getWidth() == 1280 || getWidth() == 1196)
        {
            Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, i, j, false);
            SkinUtil.saveBitmapToPrivateDir(mContext, s, bitmap1);
        } else
        {
            SkinUtil.saveBitmapToPrivateDir(mContext, s, bitmap);
        }
        return Uri.parse((new StringBuilder()).append(mContext.getFilesDir()).append("/").append(s).toString());
    }

    private void setFourRectsBitmapUri(int i, RemoteViews remoteviews, int j, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, TimeInfo timeinfo, Context context, int j2)
    {
        if(mHourLast != timeinfo.hour2)
        {
            mHourLast = timeinfo.hour2;
            RemoteViews remoteviews2 = new RemoteViews(context.getPackageName(), getHourAnimation());
            (new RV(null)).addView(remoteviews, remoteviews2, 0x7f0d0259);
            Uri uri1 = null;
            RemoteViews remoteviews1;
            List list;
            List list1;
            if(i == 7)
                uri1 = wholeBitmap(true, "full_hour", SkinUtil.getNumBitmapResID(j), SkinUtil.getNumBitmapResID(k), j2);
            else
            if(i == 8)
                uri1 = wholeBitmap(true, "full_hour", SkinUtil.getNumBitmapResID(j), SkinUtil.getNumBitmapResID(k), j2);
            remoteviews.setImageViewUri(0x7f0d00c4, uri1);
            list1 = fourRect(1, 1, true, SkinUtil.getNumBitmapResID(l), SkinUtil.getNumBitmapResID(i1));
            remoteviews.setImageViewUri(0x7f0d00c6, (Uri)list1.get(0));
            remoteviews.setImageViewUri(0x7f0d00c8, (Uri)list1.get(1));
            remoteviews.setImageViewUri(0x7f0d00ca, (Uri)list1.get(2));
            remoteviews.setImageViewUri(0x7f0d00cc, (Uri)list1.get(3));
            list1.removeAll(list1);
        } else
        {
            remoteviews.setViewVisibility(0x7f0d0257, 0);
            remoteviews.setImageViewResource(0x7f0d0257, 0x7f020046);
            remoteviews.setImageViewUri(0x7f0d0257, wholeBitmap(true, "full_hour", SkinUtil.getNumBitmapResID(timeinfo.hour1), SkinUtil.getNumBitmapResID(timeinfo.hour2), j2));
        }
        if(mMinuteLast != timeinfo.minute2)
        {
            mMinuteLast = timeinfo.minute2;
            remoteviews1 = new RemoteViews(context.getPackageName(), getMinuteAnimation());
            (new RV(null)).addView(remoteviews, remoteviews1, 0x7f0d025a);
            Uri uri = null;
            if(i == 7)
                uri = wholeBitmap(true, "full_minute", SkinUtil.getNumBitmapResID(j1), SkinUtil.getNumBitmapResID(k1), j2);
            else
            if(i == 8)
                uri = wholeBitmap(true, "full_minute", SkinUtil.getNumBitmapResID(j1), SkinUtil.getNumBitmapResID(k1), j2);
            remoteviews.setImageViewUri(0x7f0d00cd, uri);
            list = fourRect(1, 1, false, SkinUtil.getNumBitmapResID(l1), SkinUtil.getNumBitmapResID(i2));
            remoteviews.setImageViewUri(0x7f0d00cf, (Uri)list.get(0));
            remoteviews.setImageViewUri(0x7f0d00d1, (Uri)list.get(1));
            remoteviews.setImageViewUri(0x7f0d00d3, (Uri)list.get(2));
            remoteviews.setImageViewUri(0x7f0d00d5, (Uri)list.get(3));
            list.removeAll(list);
        } else
        {
            remoteviews.setViewVisibility(0x7f0d0258, 0);
            remoteviews.setImageViewResource(0x7f0d0258, 0x7f020046);
            remoteviews.setImageViewUri(0x7f0d0258, wholeBitmap(true, "full_minute", SkinUtil.getNumBitmapResID(timeinfo.minute1), SkinUtil.getNumBitmapResID(timeinfo.minute2), j2));
        }
    }

    private Bitmap wholeBitmap(boolean flag, int i, int j)
    {
        Bitmap bitmap;
        Canvas canvas;
        Bitmap bitmap1;
        Bitmap bitmap2;
        if(flag)
            bitmap = BitmapFactory.decodeResource(mContext.getResources(), 0x7f020144).copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        else
            bitmap = Bitmap.createBitmap(300, 300, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas();
        canvas.setBitmap(bitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        bitmap1 = BitmapFactory.decodeResource(mContext.getResources(), i);
        canvas.drawBitmap(bitmap1, new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight()), new Rect(10, 22, 10 + bitmap1.getWidth(), 22 + bitmap1.getHeight()), null);
        bitmap2 = BitmapFactory.decodeResource(mContext.getResources(), j);
        canvas.drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), new Rect(10 + bitmap1.getWidth(), 22, 10 + bitmap1.getWidth() + bitmap2.getWidth(), 22 + bitmap2.getHeight()), null);
        bitmap1.recycle();
        bitmap2.recycle();
        return bitmap;
    }

    private Uri wholeBitmap(boolean flag, String s, int i, int j, int k)
    {
        Bitmap bitmap;
        Canvas canvas;
        Bitmap bitmap1;
        Bitmap bitmap2;
        if(flag)
        {
            if(k == 3 || k == 6)
                bitmap = BitmapFactory.decodeResource(mContext.getResources(), 0x7f020145).copy(android.graphics.Bitmap.Config.ARGB_8888, true);
            else
                bitmap = BitmapFactory.decodeResource(mContext.getResources(), 0x7f020144).copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        } else
        {
            bitmap = Bitmap.createBitmap(300, 300, android.graphics.Bitmap.Config.ARGB_8888);
        }
        canvas = new Canvas(bitmap);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        bitmap1 = BitmapFactory.decodeResource(mContext.getResources(), i);
        canvas.drawBitmap(bitmap1, new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight()), new Rect(10, 22, 10 + bitmap1.getWidth(), 22 + bitmap1.getHeight()), null);
        bitmap2 = BitmapFactory.decodeResource(mContext.getResources(), j);
        canvas.drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight()), new Rect(10 + bitmap1.getWidth(), 22, 10 + bitmap1.getWidth() + bitmap2.getWidth(), 22 + bitmap2.getHeight()), null);
        bitmap1.recycle();
        bitmap2.recycle();
        if(getWidth() == 640)
        {
            Bitmap bitmap5 = Bitmap.createScaledBitmap(bitmap, 500, 500, false);
            SkinUtil.saveBitmapToPrivateDir(mContext, s, bitmap5);
            bitmap.recycle();
        } else
        if(getWidth() == 720 || getWidth() == 1196 || getWidth() == 1280)
        {
            Bitmap bitmap3 = Bitmap.createScaledBitmap(bitmap, 600, 600, false);
            SkinUtil.saveBitmapToPrivateDir(mContext, s, bitmap3);
            bitmap.recycle();
        } else
        if(getWidth() == 800 || getWidth() == 1280)
        {
            Bitmap bitmap4 = Bitmap.createScaledBitmap(bitmap, 600, 600, false);
            SkinUtil.saveBitmapToPrivateDir(mContext, s, bitmap4);
            bitmap.recycle();
        } else
        {
            SkinUtil.saveBitmapToPrivateDir(mContext, s, bitmap);
        }
        return Uri.parse((new StringBuilder()).append(mContext.getFilesDir()).append("/").append(s).toString());
    }

    protected abstract int createBackgroundSaveSeq();

    protected abstract int createCustomInfoLayerSaveSeq();

    protected abstract Bitmap createDrawBuffer();

    protected abstract int createOrgTextLayerSaveSeq();

    public RemoteViews createRemoteViews(Context context, boolean flag)
    {
        MojiLog.v("AbstractWidgetRemoteViews", "createRemoteViews");
        StringBuilder stringbuilder = (new StringBuilder()).append("reloadskin flag == ").append(getChangeSkinFlag()).append(" || ");
        boolean flag1;
        RemoteViews remoteviews;
        if(getCurrentSkin() == null)
            flag1 = true;
        else
            flag1 = false;
        MojiLog.d("AbstractWidgetRemoteViews", stringbuilder.append(flag1).toString());
        if(getChangeSkinFlag() || getCurrentSkin() == null)
            reloadSkin(Gl.getScreenTypeString());
        if("ORG".equals(Gl.getCurrentSkinDir()))
            remoteviews = createRemoteViewsWithDefaultSkin(context, flag);
        else
            remoteviews = createRemoteViewsWithSDCardSkin(context, flag);
        return remoteviews;
    }

    protected abstract int createTimeLayerSaveSeq();

    protected abstract void drawText(Canvas canvas, CityWeatherInfo cityweatherinfo);

    protected abstract int getBackgroundSaveSeq();

    protected abstract boolean getChangeSkinFlag();

    protected abstract SkinInfo getCurrentSkin();

    protected abstract int getCustomInfoLayerSaveSeq();

    protected abstract boolean getIsDayTime();

    protected abstract int getLoadingBg();

    protected abstract int getOldDayOfMonth();

    protected abstract int getOrgTextLayerSaveSeq();

    protected abstract WidgetTextInfo getTimeAndWeatherIconInfo();

    protected abstract int getTimeLayerSaveSeq();

    protected abstract String getWidgetBkgFileName();

    protected abstract int getWidgetBkgID();

    protected abstract String getWidgetBkgcx();

    protected abstract String getWidgetBkgx();

    protected abstract int getWidgetLayoutID();

    protected abstract int getWidgetMaskID();

    protected abstract String getWidgetNx();

    protected abstract WidgetTextInfo getWidgetTextInfo();

    protected abstract String getWidgetTextox();

    protected abstract String getWidgetTimex();

    protected abstract boolean hasColonWhenUseBackground();

    protected abstract void loadSkin(String s);

    protected abstract void recycleDrawBuffer();

    protected void reloadSkin(String s)
    {
        recycleDrawBuffer();
        if(!"ORG".equals(Gl.getCurrentSkinDir()))
            if(!Environment.getExternalStorageState().equals("mounted"))
                mRebootSDError = true;
            else
                loadSkin(s);
    }

    protected abstract void setChangeSkinFlag(boolean flag);

    protected abstract RemoteViews setHotAreaAction(Context context, RemoteViews remoteviews, boolean flag, boolean flag1);

    protected abstract void setIsDayTime(boolean flag);

    protected abstract void setOldDayOfMonth(int i);

    private static final int FOUR_LEAVES = 0;
    private static final int FOUR_RECTS = 1;
    private static final int FOUR_SHEETS = 2;
    private static final String TAG = "AbstractWidgetRemoteViews";
    private static boolean mRebootSDError;
    private static final boolean sMoreReloadAndCheck;
    protected Context mContext;
    private int mHourLast;
    private int mMinuteLast;
    protected String mWidgetType;
}
