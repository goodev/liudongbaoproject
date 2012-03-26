// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherUpdaterImpl.java

package com.moji.mjweather.common;

import android.content.Context;
import com.moji.mjweather.Gl;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.data.WeatherMainInfo;
import com.moji.mjweather.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

// Referenced classes of package com.moji.mjweather.common:
//            AbstractWeatherUpdater, WeatherData, WeatherDataParser, MojiLog

public final class WeatherUpdaterImpl extends AbstractWeatherUpdater {

	protected WeatherUpdaterImpl() {
	}

	private WeatherUpdater.Result processGetWeatherResult(int i,
			ArrayList arraylist) {
		WeatherUpdater.Result result;
		result = new WeatherUpdater.Result();
		result.cityIndex = i;
		result.errCode = 1;
		result.errMsg = Gl.Ct().getString(0x7f0b0032);
		if (arraylist != null) {
			boolean flag1;
			boolean flag2;
			boolean flag3;
			boolean flag4;
			boolean flag5;
			boolean flag6;
			FileInputStream fileinputstream;
			String s = HttpUtil.getContent(arraylist, 0);
			boolean flag = "0".equals(s);
			flag1 = "5".equals(s);
			flag2 = "7".equals(s);
			flag3 = "2".equals(s);
			flag4 = "3".equals(s);
			flag5 = "8".equals(s);
			flag6 = "9".equals(s);

			fileinputstream = null;
			boolean flag7;
			flag7 = WeatherData.saveWeatherData(arraylist, i);
			try {
				fileinputstream = WeatherData.getWeatherXml(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (flag7 && fileinputstream != null) {
				CityWeatherInfo cityweatherinfo = new CityWeatherInfo();
				if (WeatherDataParser.parse(fileinputstream, cityweatherinfo)) {

					CityWeatherInfo cityweatherinfo1;
					cityweatherinfo1 = WeatherData.getCityInfo(i);
					cityweatherinfo1.mWeatherMainInfo.clear();
					cityweatherinfo1.mWeatherAlertInfoList.clear();
					cityweatherinfo1.mWeatherDayDetailInfoList.clear();
					cityweatherinfo1.mWeatherTrendInfoList.clear();
					cityweatherinfo1.mWeatherMainInfo = cityweatherinfo.mWeatherMainInfo;
					cityweatherinfo1.mWeatherAlertInfoList = cityweatherinfo.mWeatherAlertInfoList;
					cityweatherinfo1.mWeatherDayDetailInfoList = cityweatherinfo.mWeatherDayDetailInfoList;
					cityweatherinfo1.mWeatherTrendInfoList = cityweatherinfo.mWeatherTrendInfoList;
					cityweatherinfo1.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK;
					if (cityweatherinfo1.m_cityID == -99) {
						cityweatherinfo1.mCityName = cityweatherinfo1.mWeatherMainInfo.mCityName;
						cityweatherinfo1.m_lastLoacteCityID = cityweatherinfo1.mWeatherMainInfo.mCityId;
					}
					doCheckBeforeSaveIfRunInService(i);
					saveCityInfo(i);
					doCheckAfterSaveIfRunInService(i);
					result.errCode = 0;
					if (flag1) {
						Map map = cityweatherinfo1.mWeatherMainInfo.mSupd;
						if (map != null && map.size() > 0) {
							String s1 = (String) map.get("info");
							if (s1 != null && !s1.equals("")) {
								result.errCode = 2;
								result.errMsg = map;
							}
						}
					}
				}
			}

		} else
			onFinished(result);

		return result;
	}

	protected WeatherUpdater.Result doUpadte(int i, HttpUtil httputil) {
		WeatherUpdater.Result result;
		if (Gl.getRegCode().length() > 0 && !Gl.needReregister()) {
			CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(i);
			int j = cityweatherinfo.m_cityID;
			String s;
			if (j == -99) {
				int k = cityweatherinfo.m_lastLoacteCityID;
				String s1 = Util.getAutoLocationInfo(Gl.Ct(), false);
				s = UrlUtil.getGetWeatherByLocURL(null, k, s1);
				MojiLog.d(
						"WeatherUpdaterImpl",
						(new StringBuilder()).append("locationInfo = ")
								.append(s1).toString());
				httputil.setWebsite("albs.moji001.com");
			} else {
				s = UrlUtil.getGetWeatherURL(null, j);
				httputil.setWebsite("weather.moji001.com");
			}
			httputil.doRequest(s);
			if (!httputil.isCanceled())
				result = processGetWeatherResult(i, httputil.getResponse());
			else
				result = null;

		} else {

			httputil.setWebsite("register.moji001.com");
			result = doRegister(httputil);
			if (result != null) {
				if (result.errCode != 0) {
					onFinished(result);

				}
			} else
				result = null;
		}

		return result;

	}

	private static final String TAG = "WeatherUpdaterImpl";
}
