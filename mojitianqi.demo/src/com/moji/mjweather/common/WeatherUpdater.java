// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherUpdater.java

package com.moji.mjweather.common;


public interface WeatherUpdater
{
    public static interface Callback
    {

        public abstract void doCallback(Result result);
    }

    public static class Result
    {

        public int cityIndex;
        public int errCode;
        public Object errMsg;

        public Result()
        {
        }
    }


    public abstract void cancel();

    public abstract boolean update(int i);

    public abstract boolean update(int i, boolean flag);

    public abstract Result updateSync(int i);

    public static final int ERR_AD = 3;
    public static final int ERR_FAIL = 1;
    public static final int ERR_LOCATION_FAIL = 5;
    public static final int ERR_MUST_UPGRADE = 4;
    public static final int ERR_NEW_VERSION = 2;
    public static final int ERR_SUCCESS=0;
}
