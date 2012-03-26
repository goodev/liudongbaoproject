// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MojiLog.java

package com.moji.mjweather.common;

import android.util.Log;

public final class MojiLog
{

    private MojiLog()
    {
    }

    public static int d(String s, String s1)
    {
        return 0;
    }

    public static int d(String s, String s1, Throwable throwable)
    {
        return 0;
    }

    public static int e(String s, String s1)
    {
        return Log.e(s, s1);
    }

    public static int e(String s, String s1, Throwable throwable)
    {
        return Log.e(s, s1, throwable);
    }

    public static int i(String s, String s1)
    {
        return 0;
    }

    public static int i(String s, String s1, Throwable throwable)
    {
        return 0;
    }

    public static boolean isDevelopMode()
    {
        return false;
    }

    public static int v(String s, String s1)
    {
        return 0;
    }

    public static int v(String s, String s1, Throwable throwable)
    {
        return 0;
    }

    public static int w(String s, String s1)
    {
        return Log.w(s, s1);
    }

    public static int w(String s, String s1, Throwable throwable)
    {
        return Log.w(s, s1, throwable);
    }

    public static int w(String s, Throwable throwable)
    {
        return Log.w(s, throwable);
    }

    private static final boolean mDevelopMode=false;
}
