// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherMainInfo.java

package com.moji.mjweather.data;

import java.util.*;

public class WeatherMainInfo
{

    public WeatherMainInfo()
    {
        mSolarUpdateDate = "";
        mLunarUpdateDate = "";
        mLastUpdateTime = "";
        mHighTemperature = 100;
        mWeatherDescription = "";
        mWeatherId = 44;
        mSunRise = "08:00";
        mSunSet = "18:00";
        mIsEmpty = true;
        mIsSpecCity = false;
        mForecastInfoList = new ArrayList();
        mSupd = new HashMap();
    }

    public void clear()
    {
        mSolarUpdateDate = "";
        mLunarUpdateDate = "";
        mLastUpdateTime = "";
        mCurrentTemperature = 0;
        mHighTemperature = 100;
        mLowTemperature = 0;
        mWeatherDescription = "";
        mWeatherId = 44;
        mWindSpeed = "";
        mWindDirection = "";
        mUV = "";
        mHumidity = 0F;
        mDaylight = 1;
        mSunRise = "08:00";
        mSunSet = "18:00";
        if(mForecastInfoList != null)
            mForecastInfoList.clear();
    }

    public int mCityId;
    public String mCityName;
    public int mCurrentTemperature;
    public int mDaylight;
    public List mForecastInfoList;
    public int mHighTemperature;
    public float mHumidity;
    public boolean mIsEmpty;
    public boolean mIsSpecCity;
    public String mLastUpdateTime;
    public int mLowTemperature;
    public String mLunarUpdateDate;
    public String mSolarUpdateDate;
    public String mSunRise;
    public String mSunSet;
    public Map mSupd;
    public String mUV;
    public String mUiFormatVersion;
    public String mWeatherDescription;
    public int mWeatherId;
    public String mWindDirection;
    public String mWindSpeed;
}
