// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AbstractWidget.java

package com.moji.mjweather.widget;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.*;
import com.moji.mjweather.data.CityWeatherInfo;

// Referenced classes of package com.moji.mjweather.widget:
//            WidgetManager

public abstract class AbstractWidget extends AppWidgetProvider
{
    static abstract class AbstractWidgetService extends Service
    {

        protected abstract boolean doOnStart(Intent intent, int i);

        public IBinder onBind(Intent intent)
        {
            MojiLog.v("AbstractWidgetService", "onBind");
            return null;
        }

        public void onCreate()
        {
            super.onCreate();
            MojiLog.v("AbstractWidgetService", "onCreate");
        }

        public void onStart(Intent intent, int i)
        {
            MojiLog.v("AbstractWidgetService", "onStart");
            if(!doOnStart(intent, i))
            {
                updateWidget();
                stopSelf();
            }
            super.onStart(intent, i);
        }

        protected abstract void updateWidget();

        private static final String TAG = "AbstractWidgetService";

        AbstractWidgetService()
        {
        }
    }

    public static class ReloadSkinService extends AbstractWidgetService
    {

        protected boolean doOnStart(Intent intent, int i)
        {
            MojiLog.v("ReloadSkinService", "doOnStart");
            WidgetManager.setChangeSkinFlag(true);
            return false;
        }

        public volatile IBinder onBind(Intent intent)
        {
            return super.onBind(intent);
        }

        public volatile void onCreate()
        {
            super.onCreate();
        }

        public void onDestroy()
        {
            MojiLog.v("ReloadSkinService", "onDestroy");
            super.onDestroy();
        }

        public volatile void onStart(Intent intent, int i)
        {
            super.onStart(intent, i);
        }

        protected void updateWidget()
        {
            WidgetManager.updateWidget(this, true);
        }

        private static final String TAG = "ReloadSkinService";

        public ReloadSkinService()
        {
        }
    }

    /* member class not found */
    class UpdateImmediatelyService {}

    /* member class not found */
    class WidgetUpdateService {}


    public AbstractWidget()
    {
    }

    protected static void changeCityIndex(Context context)
    {
        if(Gl.getCurrentCityIndex() != 0 || WeatherData.getCityInfo(1 + Gl.getCurrentCityIndex()).mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
        {
            if(Gl.getCurrentCityIndex() >= 8 || WeatherData.getCityInfo(1 + Gl.getCurrentCityIndex()).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
                Gl.saveCurrentCityIndex(0);
            else
                Gl.saveCurrentCityIndex(1 + Gl.getCurrentCityIndex());
            WeatherAlert.cancelAllAlertNotifications();
            WidgetManager.startWidgetService(context, null, WidgetManager.WidgetServiceType.UPDATE_NOW);
        }
    }

    protected abstract String getWidgetType();

    public void onDeleted(Context context, int ai[])
    {
        MojiLog.v("AbstractWidget", (new StringBuilder()).append("onDeleted: ").append(getWidgetType()).toString());
        super.onDeleted(context, ai);
    }

    public void onDisabled(Context context)
    {
        MojiLog.v("AbstractWidget", (new StringBuilder()).append("onDisabled: ").append(getWidgetType()).toString());
        try
        {
            WidgetManager.stopWidgetService(context, getWidgetType(), WidgetManager.WidgetServiceType.UPDATE);
            WidgetManager.setInUse(context, getWidgetType(), false);
        }
        catch(Exception exception)
        {
            MojiLog.e("AbstractWidget", "onDisabled error: ", exception);
        }
        super.onDisabled(context);
    }

    public void onEnabled(Context context)
    {
        MojiLog.v("AbstractWidget", (new StringBuilder()).append("onEnabled: ").append(getWidgetType()).toString());
        WidgetManager.setInUse(context, getWidgetType(), true);
        super.onEnabled(context);
    }

    protected void onHotArea(Context context, String s)
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        MojiLog.v("AbstractWidget", (new StringBuilder()).append("onReceive: ").append(getWidgetType()).toString());
        if(intent != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        s = intent.getAction();
        if(MojiLog.isDevelopMode())
            MojiLog.d("AbstractWidget", (new StringBuilder()).append("context = ").append(context.toString()).append(" getAction = ").append(s).toString());
        if(!s.equals("android.intent.action.USER_PRESENT")) goto _L4; else goto _L3
_L3:
        WidgetManager.restartUpdateServiceIfNotRunning(context);
_L5:
        super.onReceive(context, intent);
          goto _L1
_L4:
        if(!s.equals("android.appwidget.action.APPWIDGET_UPDATE"))
            break MISSING_BLOCK_LABEL_143;
        WidgetManager.updateWidget(context, getWidgetType(), true);
          goto _L3
        Exception exception;
        exception;
        MojiLog.e("AbstractWidget", "onReceive error: ", exception);
          goto _L5
        if(s.equals("android.intent.action.TIME_SET") || s.equals("android.intent.action.DATE_CHANGED") || s.equals("android.intent.action.TIMEZONE_CHANGED"))
        {
            Intent intent1 = new Intent("");
            intent1.setAction("com.moji.mjweather.widget.update.now");
            WidgetManager.startWidgetService(context, intent1, getWidgetType(), WidgetManager.WidgetServiceType.UPDATE);
        } else
        {
            onHotArea(context, s);
        }
          goto _L3
    }

    public void onUpdate(Context context, AppWidgetManager appwidgetmanager, int ai[])
    {
        MojiLog.v("AbstractWidget", (new StringBuilder()).append("onUpdate: ").append(getWidgetType()).toString());
        super.onUpdate(context, appwidgetmanager, ai);
    }

    private static final String TAG = "AbstractWidget";
}
