// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WidgetManager.java

package com.moji.mjweather.widget;

import android.appwidget.AppWidgetManager;
import android.content.*;
import android.content.res.Resources;
import android.util.Log;
import android.widget.RemoteViews;
import com.moji.mjweather.*;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.util.UiUtil;
import com.moji.mjweather.widgetskin.SkinInfo;

// Referenced classes of package com.moji.mjweather.widget:
//            WidgetRemoteViews4x1, AbstractWidgetRemoteViews, WidgetRemoteViews4x2

public class WidgetManager
{
    public static final class WidgetServiceType extends Enum
    {

        public static WidgetServiceType valueOf(String s)
        {
            return (WidgetServiceType)Enum.valueOf(com/moji/mjweather/widget/WidgetManager$WidgetServiceType, s);
        }

        public static WidgetServiceType[] values()
        {
            return (WidgetServiceType[])$VALUES.clone();
        }

        private static final WidgetServiceType $VALUES[];
        public static final WidgetServiceType RELOAD_SKIN;
        public static final WidgetServiceType UPDATE;
        public static final WidgetServiceType UPDATE_NOW;

        static 
        {
            UPDATE = new WidgetServiceType("UPDATE", 0);
            UPDATE_NOW = new WidgetServiceType("UPDATE_NOW", 1);
            RELOAD_SKIN = new WidgetServiceType("RELOAD_SKIN", 2);
            WidgetServiceType awidgetservicetype[] = new WidgetServiceType[3];
            awidgetservicetype[0] = UPDATE;
            awidgetservicetype[1] = UPDATE_NOW;
            awidgetservicetype[2] = RELOAD_SKIN;
            $VALUES = awidgetservicetype;
        }

        private WidgetServiceType(String s, int i)
        {
            super(s, i);
        }
    }


    public WidgetManager()
    {
    }

    public static RemoteViews createRemoteViews(Context context, String s, boolean flag)
    {
        RemoteViews remoteviews = null;
        if(!s.equals("4x1")) goto _L2; else goto _L1
_L1:
        if(sWidgetRemoteViews4x1 == null)
            sWidgetRemoteViews4x1 = new WidgetRemoteViews4x1(context, s);
        remoteviews = sWidgetRemoteViews4x1.createRemoteViews(context, flag);
_L4:
        return remoteviews;
_L2:
        if(s.equals("4x2"))
        {
            if(sWidgetRemoteViews4x2 == null)
                sWidgetRemoteViews4x2 = new WidgetRemoteViews4x2(context, s);
            remoteviews = sWidgetRemoteViews4x2.createRemoteViews(context, flag);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static void doStartWidgetService(Context context, Intent intent, WidgetServiceType widgetservicetype)
    {
        Class class1 = getServiceClassByType(widgetservicetype);
        if(class1 != null)
        {
            Intent intent1 = intent;
            if(intent1 == null)
                intent1 = new Intent(context, class1);
            else
                intent1.setClass(context, class1);
            context.startService(intent1);
        }
    }

    private static Class getServiceClassByType(WidgetServiceType widgetservicetype)
    {
        Class class1 = null;
        class _cls1
        {

            static final int $SwitchMap$com$moji$mjweather$widget$WidgetManager$WidgetServiceType[];

            static 
            {
                $SwitchMap$com$moji$mjweather$widget$WidgetManager$WidgetServiceType = new int[WidgetServiceType.values().length];
                NoSuchFieldError nosuchfielderror2;
                try
                {
                    $SwitchMap$com$moji$mjweather$widget$WidgetManager$WidgetServiceType[WidgetServiceType.UPDATE.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try
                {
                    $SwitchMap$com$moji$mjweather$widget$WidgetManager$WidgetServiceType[WidgetServiceType.UPDATE_NOW.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                $SwitchMap$com$moji$mjweather$widget$WidgetManager$WidgetServiceType[WidgetServiceType.RELOAD_SKIN.ordinal()] = 3;
_L2:
                return;
                nosuchfielderror2;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.com.moji.mjweather.widget.WidgetManager.WidgetServiceType[widgetservicetype.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 38
    //                   2 45
    //                   3 52;
           goto _L1 _L2 _L3 _L4
_L1:
        return class1;
_L2:
        class1 = CLASS_UPDATE;
        continue; /* Loop/switch isn't completed */
_L3:
        class1 = CLASS_UPDATE_NOW;
        continue; /* Loop/switch isn't completed */
_L4:
        class1 = CLASS_RELOAD_SKIN;
        if(true) goto _L1; else goto _L5
_L5:
    }

    public static Class getUpdateNowServiceClassByType()
    {
        return getServiceClassByType(WidgetServiceType.UPDATE_NOW);
    }

    public static Class getWidgetClassByType(String s)
    {
        Class class1 = null;
        if(!s.equals("4x1")) goto _L2; else goto _L1
_L1:
        class1 = CLASS_WIDGET_4X1;
_L4:
        return class1;
_L2:
        if(s.equals("4x2"))
            class1 = CLASS_WIDGET_4X2;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean isInUse(Context context)
    {
        boolean flag;
        if(Gl.getW4x1InUse() || Gl.getW4x2InUse())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isInUse(Context context, String s)
    {
        boolean flag = false;
        if(!s.equals("4x1")) goto _L2; else goto _L1
_L1:
        flag = Gl.getW4x1InUse();
_L4:
        return flag;
_L2:
        if(s.equals("4x2"))
            flag = Gl.getW4x2InUse();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean isInUseWithValidate(Context context)
    {
        if(!isInUse(context))
            validateInUseFlag(context);
        return isInUse(context);
    }

    public static boolean isInUseWithValidate(Context context, String s)
    {
        if(!isInUse(context, s))
            validateInUseFlag(context, s);
        return isInUse(context, s);
    }

    private static boolean isOtherInUse(Context context, String s)
    {
        boolean flag = false;
        if(!s.equals("4x1")) goto _L2; else goto _L1
_L1:
        flag = Gl.getW4x2InUse();
_L4:
        return flag;
_L2:
        if(s.equals("4x2"))
            flag = Gl.getW4x1InUse();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static void restartUpdateServiceIfNotRunning(Context context)
    {
        if(!AbstractWidget.WidgetUpdateService.updateServiceIsRunning())
        {
            MojiLog.d("WidgetManager", "updateservice is not running, now restart it.");
            startWidgetService(context, null, WidgetServiceType.UPDATE);
        }
    }

    public static void setChangeSkinFlag(String s, boolean flag)
    {
        if(!s.equals("4x1") || sWidgetRemoteViews4x1 == null) goto _L2; else goto _L1
_L1:
        sWidgetRemoteViews4x1.setChangeSkinFlag(flag);
_L4:
        return;
_L2:
        if(s.equals("4x2") && sWidgetRemoteViews4x2 != null)
            sWidgetRemoteViews4x2.setChangeSkinFlag(flag);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static void setChangeSkinFlag(boolean flag)
    {
        setChangeSkinFlag("4x1", flag);
        setChangeSkinFlag("4x2", flag);
    }

    public static void setInUse(Context context, String s, boolean flag)
    {
        if(!s.equals("4x1")) goto _L2; else goto _L1
_L1:
        Gl.saveW4x1InUse(flag);
_L4:
        return;
_L2:
        if(s.equals("4x2"))
            Gl.saveW4x2InUse(flag);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static void startWidgetService(Context context, Intent intent, WidgetServiceType widgetservicetype)
    {
        if(isInUse(context))
            doStartWidgetService(context, intent, widgetservicetype);
    }

    public static void startWidgetService(Context context, Intent intent, String s, WidgetServiceType widgetservicetype)
    {
        if(isInUse(context, s))
            doStartWidgetService(context, intent, widgetservicetype);
    }

    public static void stopWidgetService(Context context, String s, WidgetServiceType widgetservicetype)
    {
        if(isInUse(context, s) && !isOtherInUse(context, s))
        {
            Class class1 = getServiceClassByType(widgetservicetype);
            if(class1 != null)
                context.stopService(new Intent(context, class1));
        }
    }

    public static void updateWidget(Context context, String s, boolean flag)
    {
        com.moji.mjweather.widgetskin.SkinInfo.ScreenResolution screenresolution = SkinInfo.getScreeType(UiUtil.getScreenWidth(), UiUtil.getScreenHeight());
        MojiLog.d("WidgetManager", (new StringBuilder()).append("UiUtil.getScreenWidth() = ").append(UiUtil.getScreenWidth()).append("UiUtil.getScreenHeight()) = ").append(UiUtil.getScreenHeight()).toString());
        if(isInUse(context, s))
        {
            RemoteViews remoteviews = null;
            if(screenresolution == com.moji.mjweather.widgetskin.SkinInfo.ScreenResolution.SR_OTHER)
            {
                Class class1;
                ComponentName componentname;
                if(s == "4x2")
                    remoteviews = new RemoteViews(context.getPackageName(), 0x7f030075);
                else
                if(s == "4x1")
                    remoteviews = new RemoteViews(context.getPackageName(), 0x7f030074);
                remoteviews.setTextViewText(0x7f0d0256, context.getResources().getString(0x7f0b005d));
            } else
            {
                remoteviews = createRemoteViews(context, s, flag);
            }
            class1 = getWidgetClassByType(s);
            if(remoteviews != null && class1 != null)
            {
                componentname = new ComponentName(context, class1);
                AppWidgetManager.getInstance(context).updateAppWidget(componentname, remoteviews);
            }
        }
    }

    public static void updateWidget(Context context, boolean flag)
    {
        updateWidget(context, "4x1", flag);
        updateWidget(context, "4x2", flag);
    }

    public static void validateInUseFlag(Context context)
    {
        validateInUseFlag(context, "4x1");
        validateInUseFlag(context, "4x2");
    }

    public static void validateInUseFlag(Context context, String s)
    {
        AppWidgetManager appwidgetmanager = AppWidgetManager.getInstance(context);
        if(!s.equals("4x1")) goto _L2; else goto _L1
_L1:
        Class class1 = CLASS_WIDGET_4X1;
_L5:
        boolean flag;
        boolean flag1;
        if(appwidgetmanager.getAppWidgetIds(new ComponentName(context, class1)).length > 0)
            flag = true;
        else
            flag = false;
        flag1 = isInUse(context, s);
        if(flag && !flag1)
        {
            Log.w("WidgetManager", (new StringBuilder()).append(s).append(" is use, but not set flag.").toString());
            setInUse(context, s, true);
        } else
        if(!flag && flag1)
        {
            Log.w("WidgetManager", (new StringBuilder()).append(s).append(" is not use, but still set flag.").toString());
            setInUse(context, s, false);
        }
_L4:
        return;
_L2:
        if(!s.equals("4x2")) goto _L4; else goto _L3
_L3:
        class1 = CLASS_WIDGET_4X2;
          goto _L5
    }

    private static final Class CLASS_RELOAD_SKIN = com/moji/mjweather/widget/AbstractWidget$ReloadSkinService;
    private static final Class CLASS_UPDATE = com/moji/mjweather/widget/AbstractWidget$WidgetUpdateService;
    private static final Class CLASS_UPDATE_NOW = com/moji/mjweather/widget/AbstractWidget$UpdateImmediatelyService;
    private static final Class CLASS_WIDGET_4X1 = com/moji/mjweather/CMojiWidget4x1;
    private static final Class CLASS_WIDGET_4X2 = com/moji/mjweather/CMojiWidget4x2;
    private static final String TAG = "WidgetManager";
    public static final String WIDGET_TYPE_4X1 = "4x1";
    public static final String WIDGET_TYPE_4X2 = "4x2";
    private static AbstractWidgetRemoteViews sWidgetRemoteViews4x1;
    private static AbstractWidgetRemoteViews sWidgetRemoteViews4x2;

}
