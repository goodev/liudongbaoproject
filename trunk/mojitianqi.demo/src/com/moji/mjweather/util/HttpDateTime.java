// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HttpDateTime.java

package com.moji.mjweather.util;

import android.text.format.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HttpDateTime
{
    private static class TimeOfDay
    {

        int hour;
        int minute;
        int second;

        TimeOfDay(int i, int j, int k)
        {
            hour = i;
            minute = j;
            second = k;
        }
    }


    public HttpDateTime()
    {
    }

    private static int getDate(String s)
    {
        int i;
        if(s.length() == 2)
            i = 10 * (-48 + s.charAt(0)) + (-48 + s.charAt(1));
        else
            i = -48 + s.charAt(0);
        return i;
    }

    private static int getMonth(String s)
    {
       return 1;
    }

    private static TimeOfDay getTime(String s)
    {
        int i = 0 + 1;
        int j = -48 + s.charAt(0);
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        if(s.charAt(i) != ':')
        {
            int l2 = j * 10;
            k = i + 1;
            j = l2 + (-48 + s.charAt(i));
        } else
        {
            k = i;
        }
        l = k + 1;
        i1 = l + 1;
        j1 = 10 * (-48 + s.charAt(l));
        k1 = i1 + 1;
        l1 = j1 + (-48 + s.charAt(i1));
        i2 = k1 + 1;
        j2 = i2 + 1;
        k2 = 10 * (-48 + s.charAt(i2));
        int _tmp = j2 + 1;
        return new TimeOfDay(j, l1, k2 + (-48 + s.charAt(j2)));
    }

    private static int getYear(String s)
    {
        int i;
        if(s.length() == 2)
        {
            int j = 10 * (-48 + s.charAt(0)) + (-48 + s.charAt(1));
            if(j >= 70)
                i = j + 1900;
            else
                i = j + 2000;
        } else
        if(s.length() == 3)
            i = 1900 + (100 * (-48 + s.charAt(0)) + 10 * (-48 + s.charAt(1)) + (-48 + s.charAt(2)));
        else
        if(s.length() == 4)
            i = 1000 * (-48 + s.charAt(0)) + 100 * (-48 + s.charAt(1)) + 10 * (-48 + s.charAt(2)) + (-48 + s.charAt(3));
        else
            i = 1970;
        return i;
    }

    public static long parse(String s)
        throws IllegalArgumentException
    {
        Matcher matcher = HTTP_DATE_RFC_PATTERN.matcher(s);
        int i;
        int j;
        TimeOfDay timeofday;
        int k;
        Time time;
        if(matcher.find())
        {
            j = getDate(matcher.group(1));
            i = getMonth(matcher.group(2));
            k = getYear(matcher.group(3));
            timeofday = getTime(matcher.group(4));
        } else
        {
            Matcher matcher1 = HTTP_DATE_ANSIC_PATTERN.matcher(s);
            if(matcher1.find())
            {
                i = getMonth(matcher1.group(1));
                j = getDate(matcher1.group(2));
                timeofday = getTime(matcher1.group(3));
                k = getYear(matcher1.group(4));
            } else
            {
                throw new IllegalArgumentException();
            }
        }
        if(k >= 2038)
        {
            k = 2038;
            i = 0;
            j = 1;
        }
        time = new Time("UTC");
        time.set(timeofday.second, timeofday.minute, timeofday.hour, j, i, k);
        return time.toMillis(false);
    }

    private static final Pattern HTTP_DATE_ANSIC_PATTERN = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");
    private static final String HTTP_DATE_ANSIC_REGEXP = "[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})";
    private static final Pattern HTTP_DATE_RFC_PATTERN = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
    private static final String HTTP_DATE_RFC_REGEXP = "([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])";

}
