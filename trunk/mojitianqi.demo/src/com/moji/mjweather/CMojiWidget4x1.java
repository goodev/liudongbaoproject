// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CMojiWidget4x1.java

package com.moji.mjweather;

import android.content.Context;
import android.content.Intent;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.util.Util;
import com.moji.mjweather.widget.AbstractWidget;

// Referenced classes of package com.moji.mjweather:
//            Gl

public class CMojiWidget4x1 extends AbstractWidget
{

    public CMojiWidget4x1()
    {
        MojiLog.v("CMojiWidget4x1", "constructed");
    }

    protected String getWidgetType()
    {
        return "4x1";
    }

    protected void onHotArea(Context context, String s)
    {
        MojiLog.v("CMojiWidget4x1", (new StringBuilder()).append("onHotArea: ").append(s).toString());
        if(s.equals("com.moji.mjweather.widget.RIGHT_BOTTOM_BITMAP_BUTTON"))
        {
            boolean flag = Util.widgetIntentCustomLoader(context, 2, "4x1");
            if(!flag)
                Util.IntentClock(context, flag);
        }
        if(s.equals("com.moji.mjweather.widget.LEFT_BOTTOM_BITMAP_BUTTON"))
        {
            Intent intent = new Intent(context, Gl.getMainActivityClass());
            intent.setAction("android.intent.action.MAIN");
            intent.setFlags(0x10200000);
            context.startActivity(intent);
        }
    }

    private static final String TAG = "CMojiWidget4x1";
}
