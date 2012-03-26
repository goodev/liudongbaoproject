// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UiUtil.java

package com.moji.mjweather.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.view.*;
import android.widget.TextView;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.data.WeatherMainInfo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

// Referenced classes of package com.moji.mjweather.util:
//            Util

public class UiUtil {

	public UiUtil() {
	}

	public static boolean canFindAlertResource(String s) {
		boolean flag;
		if (s.length() > 0 && getWeatherAlertIcon(Integer.parseInt(s)) != -1)
			flag = true;
		else
			flag = false;
		return flag;
	}

	public static void drawTextInCenter(Canvas canvas, String s, Paint paint,
			int i, int j) {
		int k = (int) paint.measureText(s);
		android.graphics.Paint.FontMetrics fontmetrics = paint.getFontMetrics();
		canvas.drawText(s, i - k / 2, ((float) j + paint.getTextSize() / 2F)
				- fontmetrics.descent / 2F, paint);
	}

	public static void drawTextInCenterByHorizontal(Canvas canvas, String s,
			Paint paint, int i, int j) {
		canvas.drawText(s, i - (int) paint.measureText(s) / 2, j, paint);
	}

	public static void drawTextInCenterByVertical(Canvas canvas, String s,
			Paint paint, int i, int j) {
		android.graphics.Paint.FontMetrics fontmetrics = paint.getFontMetrics();
		canvas.drawText(s, i, ((float) j + paint.getTextSize() / 2F)
				- fontmetrics.descent / 2F, paint);
	}

	public static BitmapDrawable getBgBitmapDrawable() {
		if (sBitmap == null)
			sBitmap = BitmapFactory.decodeResource(Gl.Ct().getResources(),
					0x7f02015d);
		sBitmapDrawable = new BitmapDrawable(sBitmap);
		sBitmapDrawable.setTileModeXY(android.graphics.Shader.TileMode.REPEAT,
				android.graphics.Shader.TileMode.REPEAT);
		sBitmapDrawable.setDither(true);
		return sBitmapDrawable;
	}

	public static int getScreenHeight() {
		if (sDisplay == null)
			sDisplay = ((WindowManager) Gl.Ct().getSystemService("window"))
					.getDefaultDisplay();
		return sDisplay.getHeight();
	}

	public static int getScreenWidth() {
		if (sDisplay == null)
			sDisplay = ((WindowManager) Gl.Ct().getSystemService("window"))
					.getDefaultDisplay();
		return sDisplay.getWidth();
	}

	public static int getStatusBarHeight() {
		return sStatusBarHeight;
	}

	public static int getWeatherAlertIcon(int i) {
		setWLResoucesMap();
		int j;
		if (sWeatherAlertResoucesMap.get(Integer.valueOf(i)) == null)
			j = -1;
		else
			j = ((Integer) sWeatherAlertResoucesMap.get(Integer.valueOf(i)))
					.intValue();
		return j;
	}

	public static int getWeatherAlertTextColor(int i) {

		return Color.rgb(49, 102, 255);

	}

	public static int getWeatherBgResourceId(int i, boolean flag) {
		return 0x7f020010;

	}

	public static int getWeatherID(int i, boolean flag) {
		return 10;

	}

	public static int getWeatherIconResouceId(int i, boolean flag) {
		return 0x7f020170;

	}

	public static boolean isDay(CityWeatherInfo cityweatherinfo) {
		sSunriseDate = Util
				.getDateByTime(cityweatherinfo.mWeatherMainInfo.mSunRise);
		sSunsetDate = Util
				.getDateByTime(cityweatherinfo.mWeatherMainInfo.mSunSet);
		sCurrentDate = new Date(System.currentTimeMillis());
		boolean flag;
		if (sCurrentDate.after(sSunriseDate)
				&& sCurrentDate.before(sSunsetDate))
			flag = true;
		else
			flag = false;
		return flag;
	}

	public static boolean isNeedSetBlackColor(int i) {
		boolean flag = true;
		if (i != 0 && i != 1 && i != 13 && i != 3)
			flag = false;
		return flag;
	}

	public static boolean isNeedsetWhilteShadow(int i) {
		boolean flag = true;
		if (i != 0 && i != 1 && i != 13 && i != 3)
			flag = false;
		return flag;
	}

	public static boolean savePictureShot(Bitmap bitmap) {
		return savePictureShot(bitmap, "screen_shot_to_share.jpg", 90);
	}

	public static boolean savePictureShot(Bitmap bitmap, String s) {
		return savePictureShot(bitmap, s, 100);
	}

	public static boolean savePictureShot(Bitmap bitmap, String s, int i) {
		boolean flag = true;
		FileOutputStream fileoutputstream;
		Gl.Ct().deleteFile(s);
		try {
			fileoutputstream = Gl.Ct().openFileOutput(s, 1);
			if (fileoutputstream == null || bitmap == null) {

				flag = false;
			} else {
				bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, i,
						fileoutputstream);
			}

			fileoutputstream.flush();
			fileoutputstream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;

	}

	public static void saveStatusBarHeight(final Context context) {
		(new View(context)).post(new Runnable() {

			public void run() {
				if (UiUtil.sRectgle == null)
					UiUtil.sRectgle = new Rect();
				UiUtil.sWindow = ((Activity) context).getWindow();
				UiUtil.sWindow.getDecorView().getWindowVisibleDisplayFrame(
						UiUtil.sRectgle);
				MojiLog.i(
						"UiUtil",
						(new StringBuilder())
								.append("Window status bar height = ")
								.append(UiUtil.sRectgle.top).toString());
				UiUtil.sStatusBarHeight = UiUtil.sRectgle.top;
			}

			 
		});
	}

	public static void setStatusBarHeight(int i) {
		sStatusBarHeight = i;
	}

	public static void setTextShadow(TextView textview, int i) {
		textview.setShadowLayer(0.01F, 0F, 1F, i);
	}

	private static void setWLResoucesMap() {
		if (sWeatherAlertResoucesMap == null) {
			sWeatherAlertResoucesMap = new HashMap();
			sWeatherAlertResoucesMap.put(Integer.valueOf(11),
					Integer.valueOf(0x7f0201b5));
			sWeatherAlertResoucesMap.put(Integer.valueOf(12),
					Integer.valueOf(0x7f0201b8));
			sWeatherAlertResoucesMap.put(Integer.valueOf(13),
					Integer.valueOf(0x7f0201b6));
			sWeatherAlertResoucesMap.put(Integer.valueOf(14),
					Integer.valueOf(0x7f0201b7));
			sWeatherAlertResoucesMap.put(Integer.valueOf(21),
					Integer.valueOf(0x7f0201a7));
			sWeatherAlertResoucesMap.put(Integer.valueOf(22),
					Integer.valueOf(0x7f0201aa));
			sWeatherAlertResoucesMap.put(Integer.valueOf(23),
					Integer.valueOf(0x7f0201a8));
			sWeatherAlertResoucesMap.put(Integer.valueOf(24),
					Integer.valueOf(0x7f0201a9));
			sWeatherAlertResoucesMap.put(Integer.valueOf(31),
					Integer.valueOf(0x7f0201ae));
			sWeatherAlertResoucesMap.put(Integer.valueOf(32),
					Integer.valueOf(0x7f0201b1));
			sWeatherAlertResoucesMap.put(Integer.valueOf(33),
					Integer.valueOf(0x7f0201af));
			sWeatherAlertResoucesMap.put(Integer.valueOf(34),
					Integer.valueOf(0x7f0201b0));
			sWeatherAlertResoucesMap.put(Integer.valueOf(41),
					Integer.valueOf(0x7f020190));
			sWeatherAlertResoucesMap.put(Integer.valueOf(42),
					Integer.valueOf(0x7f020193));
			sWeatherAlertResoucesMap.put(Integer.valueOf(43),
					Integer.valueOf(0x7f020191));
			sWeatherAlertResoucesMap.put(Integer.valueOf(44),
					Integer.valueOf(0x7f020192));
			sWeatherAlertResoucesMap.put(Integer.valueOf(51),
					Integer.valueOf(0x7f0201b9));
			sWeatherAlertResoucesMap.put(Integer.valueOf(52),
					Integer.valueOf(0x7f0201bc));
			sWeatherAlertResoucesMap.put(Integer.valueOf(53),
					Integer.valueOf(0x7f0201ba));
			sWeatherAlertResoucesMap.put(Integer.valueOf(54),
					Integer.valueOf(0x7f0201bb));
			sWeatherAlertResoucesMap.put(Integer.valueOf(62),
					Integer.valueOf(0x7f0201ad));
			sWeatherAlertResoucesMap.put(Integer.valueOf(63),
					Integer.valueOf(0x7f0201ab));
			sWeatherAlertResoucesMap.put(Integer.valueOf(64),
					Integer.valueOf(0x7f0201ac));
			sWeatherAlertResoucesMap.put(Integer.valueOf(72),
					Integer.valueOf(0x7f0201a6));
			sWeatherAlertResoucesMap.put(Integer.valueOf(73),
					Integer.valueOf(0x7f0201a4));
			sWeatherAlertResoucesMap.put(Integer.valueOf(74),
					Integer.valueOf(0x7f0201a5));
			sWeatherAlertResoucesMap.put(Integer.valueOf(83),
					Integer.valueOf(0x7f020194));
			sWeatherAlertResoucesMap.put(Integer.valueOf(84),
					Integer.valueOf(0x7f020195));
			sWeatherAlertResoucesMap.put(Integer.valueOf(92),
					Integer.valueOf(0x7f0201b4));
			sWeatherAlertResoucesMap.put(Integer.valueOf(93),
					Integer.valueOf(0x7f0201b2));
			sWeatherAlertResoucesMap.put(Integer.valueOf(94),
					Integer.valueOf(0x7f0201b3));
			sWeatherAlertResoucesMap.put(Integer.valueOf(103),
					Integer.valueOf(0x7f0201a0));
			sWeatherAlertResoucesMap.put(Integer.valueOf(104),
					Integer.valueOf(0x7f0201a1));
			sWeatherAlertResoucesMap.put(Integer.valueOf(111),
					Integer.valueOf(0x7f02019d));
			sWeatherAlertResoucesMap.put(Integer.valueOf(112),
					Integer.valueOf(0x7f02019f));
			sWeatherAlertResoucesMap.put(Integer.valueOf(113),
					Integer.valueOf(0x7f02019e));
			sWeatherAlertResoucesMap.put(Integer.valueOf(121),
					Integer.valueOf(0x7f020196));
			sWeatherAlertResoucesMap.put(Integer.valueOf(122),
					Integer.valueOf(0x7f020199));
			sWeatherAlertResoucesMap.put(Integer.valueOf(123),
					Integer.valueOf(0x7f020197));
			sWeatherAlertResoucesMap.put(Integer.valueOf(124),
					Integer.valueOf(0x7f020198));
			sWeatherAlertResoucesMap.put(Integer.valueOf(132),
					Integer.valueOf(0x7f0201a3));
			sWeatherAlertResoucesMap.put(Integer.valueOf(133),
					Integer.valueOf(0x7f0201a2));
			sWeatherAlertResoucesMap.put(Integer.valueOf(142),
					Integer.valueOf(0x7f02019c));
			sWeatherAlertResoucesMap.put(Integer.valueOf(143),
					Integer.valueOf(0x7f02019a));
			sWeatherAlertResoucesMap.put(Integer.valueOf(144),
					Integer.valueOf(0x7f02019b));
		}
	}

	private static final int BG_CLOUDY_DAY = 1;
	private static final int BG_FINE_DAY = 0;
	private static final int BG_SHADE = 2;
	private static final int BG_SHOWER_DAY = 3;
	private static final int BG_SNOW_SHOWER_DAY = 13;
	private static final int BG_SNOW_SHOWER_NIGHT = 34;
	public static final int COLOR_RGB_BLACK = 55;
	private static final int COLOR_RGB_MAX = 255;
	private static final int COLOR_RGB_MIDDLE = 153;
	private static final int COLOR_RGB_MIN = 0;
	private static final String TAG = "UiUtil";
	private static final int TEXTVIEW_SHADOW_DX = 0;
	private static final int TEXTVIEW_SHADOW_DY = 1;
	private static final double TEXTVIEW_SHADOW_RADIUS = 0.01D;
	private static final int WEATHER_ALERT_BLUE = 1;
	private static final int WEATHER_ALERT_ORANGE = 3;
	private static final int WEATHER_ALERT_RED = 4;
	private static final int WEATHER_ALERT_YELLOW = 2;
	private static Bitmap sBitmap;
	private static BitmapDrawable sBitmapDrawable;
	private static Date sCurrentDate;
	private static Display sDisplay;
	private static Rect sRectgle;
	private static int sStatusBarHeight = 0;
	private static Date sSunriseDate;
	private static Date sSunsetDate;
	private static Map sWeatherAlertResoucesMap;
	private static Window sWindow;

	/*
	 * static Rect access$002(Rect rect) { sRectgle = rect; return rect; }
	 */

	/*
	 * static Window access$102(Window window) { sWindow = window; return
	 * window; }
	 */

	/*
	 * static int access$202(int i) { sStatusBarHeight = i; return i; }
	 */
}
