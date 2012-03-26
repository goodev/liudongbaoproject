// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherPublisher.java

package com.moji.mjweather.common;

import java.util.*;

// Referenced classes of package com.moji.mjweather.common:
//            WeatherSubscriber

public final class WeatherPublisher
{

    private WeatherPublisher()
    {
        sSubscriberList = new ArrayList();
    }

    public static WeatherPublisher getInstance()
    {
        if(sInstance == null)
            sInstance = new WeatherPublisher();
        return sInstance;
    }

    /**
     * @deprecated Method publish is deprecated
     */

    public void publish(WeatherUpdater.Result result)
    {
       
    }

    /**
     * @deprecated Method subscribe is deprecated
     */

    public void subscribe(WeatherSubscriber weathersubscriber)
    {
       
    }

    /**
     * @deprecated Method unSubscribe is deprecated
     */

    public void unSubscribe(WeatherSubscriber weathersubscriber)
    {
       
    }

    private static WeatherPublisher sInstance;
    private static List sSubscriberList;
}
