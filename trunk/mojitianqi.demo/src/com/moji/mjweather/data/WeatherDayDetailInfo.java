// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherDayDetailInfo.java

package com.moji.mjweather.data;


public class WeatherDayDetailInfo
{

    public WeatherDayDetailInfo()
    {
        mHighTemperature = 100;
        mHighWeatherIconId = -1;
        mLowWeatherIconId = -1;
        mFestival = "";
        mSunRise = "08:00";
        mSunSet = "18:00";
        mIsEmpty = true;
    }

    public void clean()
    {
        mId = 0;
        mDate = "";
        mWeek = 0;
        mKind = "";
        mHighTemperature = 100;
        mLowTemperature = 0;
        mHighWeatherDescription = "";
        mLowWeatherDescription = "";
        mHighWeatherIconId = -1;
        mLowWeatherIconId = -1;
        mWindSpeed = "";
        mWindDirection = "";
        mFestival = "";
        mSunRise = "08:00";
        mSunSet = "18:00";
        mLimitNumber = "";
        mIsEmpty = false;
    }

    public String mDate;
    public String mFestival;
    public int mHighTemperature;
    public String mHighWeatherDescription;
    public int mHighWeatherIconId;
    public int mId;
    public boolean mIsEmpty;
    public String mKind;
    public String mLimitNumber;
    public int mLowTemperature;
    public String mLowWeatherDescription;
    public int mLowWeatherIconId;
    public String mSunRise;
    public String mSunSet;
    public int mWeek;
    public String mWindDirection;
    public String mWindSpeed;
}
