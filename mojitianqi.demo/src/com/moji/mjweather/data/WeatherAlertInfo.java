// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherAlertInfo.java

package com.moji.mjweather.data;


public class WeatherAlertInfo
{

    public WeatherAlertInfo()
    {
    }

    public void clean()
    {
        mPublicTime = "";
        mEndTime = "";
        mAlertDescription = "";
        mAlertDetailInfo = "";
        mAlertUrl = "";
    }

    public String mAlertDescription;
    public String mAlertDetailInfo;
    public String mAlertIconId;
    public String mAlertUrl;
    public String mEndTime;
    public String mPublicTime;
}
