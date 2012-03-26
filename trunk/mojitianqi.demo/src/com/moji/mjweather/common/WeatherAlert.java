// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherAlert.java

package com.moji.mjweather.common;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.moji.mjweather.Gl;
import com.moji.mjweather.data.*;
import com.moji.mjweather.util.UiUtil;
import com.moji.mjweather.util.Util;
import java.text.*;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.moji.mjweather.common:
//            WeatherData, MojiLog

public final class WeatherAlert {

	public WeatherAlert() {
	}

	public static void cancelAllAlertNotifications() {
		if (Gl.getAutoUpdate() && Gl.getAlertNotificationEnable())
			((NotificationManager) Gl.Ct().getSystemService("notification"))
					.cancelAll();
	}

	public static void check(int i) {
		if (Gl.getAlertNotificationEnable()) {
			CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(i);
			boolean flag = true;
			int j = cityweatherinfo.mWeatherAlertInfoList.size();
			if (MojiLog.isDevelopMode()) {
				MojiLog.d("WeatherAlert",
						(new StringBuilder()).append("cityInfo.name = ")
								.append(cityweatherinfo.mCityName).toString());
				MojiLog.d("WeatherAlert",
						(new StringBuilder()).append("alertSize = ").append(j)
								.toString());
			}
			if (j > 0) {
				for (int k = 0; k < j; k++) {
					WeatherAlertInfo weatheralertinfo = (WeatherAlertInfo) cityweatherinfo.mWeatherAlertInfoList
							.get(k);
					if (!needNotify(i, weatheralertinfo))
						continue;
					if (flag) {
						cancelAllAlertNotifications();
						flag = false;
					}
					sendNotification(
							cityweatherinfo.mWeatherMainInfo.mCityId,
							UiUtil.getWeatherAlertIcon(Integer
									.parseInt(weatheralertinfo.mAlertIconId)),
							(new StringBuilder())
									.append(weatheralertinfo.mAlertDescription)
									.append(Gl.Ct().getResources()
											.getString(0x7f0b01d3)).toString(),
							weatheralertinfo.mAlertDetailInfo);
				}

			}
		}
	}

	public static void checkKindNotice(int i) {
		if (!Gl.getNotificationEnable())
			return;

		Date date;
		String s;
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy/MM/dd");
		date = new Date();
		s = simpledateformat.format(date);
		if (!Gl.getKindNoticeDate().equals(s)) {
			if (!Util.isBetweenTimes(
					(new SimpleDateFormat("HH:mm")).format(date), "18:00",
					"21:00")) {
				MojiLog.d("WeatherAlert",
						"checkKindNotice: is not between 18-21.");
				return;
			}
		} else {
			MojiLog.d("WeatherAlert",
					"checkKindNotice: have sent notification today.");
			return;
		}

		CityWeatherInfo cityweatherinfo;
		int j;
		float f2;
		String s2;
		String as[];
		cityweatherinfo = WeatherData.getCityInfo(i);
		float f = ((WeatherTrendInfo) cityweatherinfo.mWeatherTrendInfoList
				.get(1)).mHighTemperature;
		j = ((WeatherTrendInfo) cityweatherinfo.mWeatherTrendInfoList.get(1)).mHightWeatherID;
		String s1 = Gl.getWUpdateDate(i);
		float f1 = Gl.getWTempHi(i);
		if (s1.equals("") || f1 == 100F)
			MojiLog.d("WeatherAlert", "checkKindNotice: no day data.");
		f2 = 0F;
		if (s.equals(s1) && f1 != 100F)
			f2 = f1 - f;
		if (MojiLog.isDevelopMode())
			MojiLog.d(
					"WeatherAlert",
					(new StringBuilder()).append("checkKindNotice: curDate:")
							.append(s).append(" fcDate: ").append(s1)
							.append(", curTmpeHi: ").append(f1)
							.append(", secDaytemHi: ").append(f)
							.append(", wID:").append(j).toString());
		s2 = "";
		as = Gl.Ct().getResources().getStringArray(0x7f070019);
		if (f2 < 5F) {
			int k = 0;
			if (j >= 3 && j <= 5 || j >= 7 && j <= 10 || j == 33)
				k = 1;
			else if (j >= 13 && j <= 17 || j == 34)
				k = 2;
			else if (j == 19)
				k = 3;
			else if (j == 20 || j == 29 || j == 35 || j == 36)
				k = 4;
			if (k != 0)
				s2 = (new StringBuilder())
						.append(as[0]
								.replace("c", cityweatherinfo.mCityName)
								.replace(
										"w",
										((WeatherTrendInfo) cityweatherinfo.mWeatherTrendInfoList
												.get(1)).mHighTempDes))
						.append(as[k]).toString();

		} else {
			s2 = as[5].replace("c", cityweatherinfo.mCityName).replace("d",
					String.valueOf(f2));
		}

		if (s2.equals("")) {
			MojiLog.d("WeatherAlert",
					"checkKindNotice: weather doesn't change.");
		} else {
			Util.sendNotification(s2);
			Gl.saveKindNoticeDate(s);
		}

	}

	public static boolean needClose(String s) {
		boolean flag = true;
		if (s.length() < 0)
			return flag;

		SimpleDateFormat simpledateformat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm");
		boolean flag1 = false;
		try {
			flag1 = (new Date()).before(simpledateformat.parse(s));
		} catch (ParseException e) {
			MojiLog.e("WeatherAlert", "date parse error", e);
		}
		if (flag1)
			flag = false;
		else
			flag = true;
		return flag;

	}

	private static boolean needNotify(int i, WeatherAlertInfo weatheralertinfo) {
		boolean flag;
		int j;
		flag = true;
		MojiLog.v("WeatherAlert", "needNotify");
		j = Gl.getWeatherAlertListSize(i);
		if (j <= 0)
			return flag;

		String s;
		int k;
		if (needClose(weatheralertinfo.mEndTime)) {
			flag = false;

		}
		s = (new StringBuilder()).append(weatheralertinfo.mEndTime).append("|")
				.append(weatheralertinfo.mAlertDescription).append("|")
				.append(weatheralertinfo.mAlertIconId).append("|")
				.append(weatheralertinfo.mAlertDetailInfo).append("|")
				.append(weatheralertinfo.mAlertUrl).toString();
		MojiLog.d("WeatherAlert", (new StringBuilder()).append("contents = ")
				.append(s).toString());
		k = 0;

		while (k < j) {

			if (!s.equals(Gl.getWeatherAlertContent(i, k)))
				break;
			MojiLog.v("WeatherAlert", "needNotify return false");
			flag = false;
			k++;
		}

		return flag;

	}

	private static void sendNotification(int i, int j, String s, String s1) {
		NotificationManager notificationmanager = (NotificationManager) Gl.Ct()
				.getSystemService("notification");
		Notification notification = new Notification(j, s,
				System.currentTimeMillis());
		if (Gl.getNoticedBySound())
			notification.defaults = 1 | notification.defaults;
		if (Gl.getNoticedByVibrate())
			notification.defaults = 2 | notification.defaults;
		Intent intent = new Intent(Gl.Ct(), Gl.getMainActivityClass());
		Bundle bundle = new Bundle();
		bundle.putBoolean("EarlyWarning", true);
		bundle.putInt("EarlyWarningCityIndex", i);
		intent.putExtras(bundle);
		PendingIntent pendingintent = PendingIntent.getActivity(Gl.Ct(),
				notification.hashCode(), intent, 0);
		notification.setLatestEventInfo(Gl.Ct(), s, s1, pendingintent);
		notificationmanager.notify(notification.hashCode(), notification);
	}

	private static final String TAG = "WeatherAlert";
}
