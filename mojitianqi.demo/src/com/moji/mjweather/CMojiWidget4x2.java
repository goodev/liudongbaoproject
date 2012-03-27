// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CMojiWidget4x2.java

package com.moji.mjweather;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.service.WeatherUpdateService;
import com.moji.mjweather.util.Util;
import com.moji.mjweather.widget.AbstractWidget;

// Referenced classes of package com.moji.mjweather:
//            Gl

public class CMojiWidget4x2 extends AbstractWidget {

	public CMojiWidget4x2() {
		MojiLog.v("CMojiWidget4x2", "constructed");
	}

	protected String getWidgetType() {
		return "4x2";
	}

	protected void onHotArea(Context context, String s) {
		MojiLog.v("CMojiWidget4x2", (new StringBuilder()).append("onHotArea: ")
				.append(s).toString());
		if (s.equals("com.moji.mjweather.widget.LEFT_BITMAP_BUTTON")) {
			boolean flag1 = Util.widgetIntentCustomLoader(context, 1, "4x2");

			if (!flag1)
				Util.IntentClock(context, flag1);

			return;
		}

		if (s.equals("com.moji.mjweather.widget.RIGHT_BITMAP_BUTTON")) {
			boolean flag = Util.widgetIntentCustomLoader(context, 2, "4x2");
			if (!flag)
				Util.intentCalendar(context, flag);
		} else if (s
				.equals("com.moji.mjweather.widget.LEFT_BOTTOM_BITMAP_BUTTON")) {
			if (!WeatherData.hasMoreCity()) {
				Toast.makeText(context, 0x7f0b0171, 1).show();
			} else {
				Toast.makeText(context, 0x7f0b0172, 0).show();
				changeCityIndex(context);
			}
		} else if (s
				.equals("com.moji.mjweather.widget.MIDDLE_BOTTOM_BITMAP_BUTTON")) {
			Intent intent = new Intent(context, Gl.getMainActivityClass());
			intent.setAction("android.intent.action.MAIN");
			intent.setFlags(0x10200000);
			context.startActivity(intent);
		} else if (s
				.equals("com.moji.mjweather.widget.RIGHT_BOTTOM_BITMAP_BUTTON")
				&& !Util.widgetIntentCustomLoader(context, 3, "4x2"))
			if (!Util.isConnectInternet(context)) {
				Toast.makeText(context, 0x7f0b0160, 1).show();
			} else {
				Toast.makeText(context, 0x7f0b0170, 1).show();
				WeatherUpdateService.start(true);
			}

	}

	private static final String TAG = "CMojiWidget4x2";
}
