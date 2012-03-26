// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherTrendInfo.java

package com.moji.mjweather.data;


public class WeatherTrendInfo
{

    public WeatherTrendInfo()
    {
        mHightWeatherID = 44;
        mLowWeatherID = 44;
        mIsEmpty = true;
    }

    public void clean()
    {
        mId = 0;
        mDate = "";
        mWeek = 0;
        mHightWeatherID = -1;
        mLowWeatherID = -1;
        mHighTempDes = "";
        mLowTempDes = "";
        mHighTempWindSpeed = "";
        mLowTempWindSpeed = "";
        mHighTempWindDirection = "";
        mLowTempWindDirection = "";
        mIsEmpty = true;
    }

    public String mDate;
    public String mHighTempDes;
    public String mHighTempWindDirection;
    public String mHighTempWindSpeed;
    public int mHighTemperature;
    public int mHightWeatherID;
    public int mId;
    public boolean mIsEmpty;
    public String mLowTempDes;
    public String mLowTempWindDirection;
    public String mLowTempWindSpeed;
    public int mLowTemperature;
    public int mLowWeatherID;
    public int mWeek;
}
