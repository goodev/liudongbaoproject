// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherTabPublisher.java

package com.moji.mjweather.common;

import java.util.*;

// Referenced classes of package com.moji.mjweather.common:
//            WeatherTabCheckedCallback

public final class WeatherTabPublisher
{

    private WeatherTabPublisher()
    {
        sSubscriberList = new ArrayList();
    }

    public static WeatherTabPublisher getInstance()
    {
        if(sInstance == null)
            sInstance = new WeatherTabPublisher();
        return sInstance;
    }

    /**
     * @deprecated Method publish is deprecated
     */

    public void publish()
    {
      
    }

    /**
     * @deprecated Method subscribe is deprecated
     */

    public void subscribe(WeatherTabCheckedCallback weathertabcheckedcallback)
    {
        
    }

    /**
     * @deprecated Method unSubscribe is deprecated
     */

    public void unSubscribe(WeatherTabCheckedCallback weathertabcheckedcallback)
    {
        
    }

    private static WeatherTabPublisher sInstance;
    private static List sSubscriberList;
}
