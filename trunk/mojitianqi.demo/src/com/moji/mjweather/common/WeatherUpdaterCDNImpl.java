// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherUpdaterCDNImpl.java

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

public class WeatherUpdaterCDNImpl extends AbstractWeatherUpdater {

	protected WeatherUpdaterCDNImpl() {
	}

	private void doProcessSucceedCase(int i, ArrayList arraylist, boolean flag,
			boolean flag1, boolean flag2, WeatherUpdater.Result result) {
		FileInputStream fileinputstream = null;
		boolean flag3;
		flag3 = WeatherData.saveWeatherData(arraylist, i, flag);
		try {
			fileinputstream = WeatherData.getWeatherXml(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag3 && fileinputstream != null) {
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
						String s = (String) map.get("info");
						if (s != null && !s.equals("")) {
							result.errCode = 2;
							result.errMsg = map;
						}
					}
				}
			}
		}

	}

	private WeatherUpdater.Result doWeatherNoFoundResult(int i,
			ArrayList arraylist) {
		WeatherUpdater.Result result = new WeatherUpdater.Result();
		result.cityIndex = i;
		result.errCode = 1;
		result.errMsg = Gl.Ct().getString(0x7f0b003e);
		onFinished(result);
		return result;
	}

	private WeatherUpdater.Result processCDNGetWeatherResult(int i,
			ArrayList arraylist) {
		WeatherUpdater.Result result = new WeatherUpdater.Result();
		result.cityIndex = i;
		result.errCode = 1;
		result.errMsg = Gl.Ct().getString(0x7f0b0032);
		if (arraylist == null) {
			onFinished(result);
		} else {
			doProcessSucceedCase(i, arraylist, true, false, false, result);
			onFinished(result);
		}
		return result;
	}

	private WeatherUpdater.Result processGetWeatherResult(int i,
			ArrayList arraylist) {
		WeatherUpdater.Result result;
		result = new WeatherUpdater.Result();
		result.cityIndex = i;
		result.errCode = 1;
		result.errMsg = Gl.Ct().getString(0x7f0b0032);
		if (arraylist == null) {
			onFinished(result);
		} else {
			boolean flag;
			boolean flag2;
			boolean flag3;
			String s = HttpUtil.getContent(arraylist, 0);
			MojiLog.d("WeatherUpdaterCDNImpl",
					(new StringBuilder()).append("Location content code = ")
							.append(s).toString());
			flag = "1".equals(s);
			boolean flag1 = "2".equals(s);
			flag2 = "10".equals(s);
			flag3 = "20".equals(s);

			result.errCode = 5;
			result.errMsg = Gl.Ct().getString(0x7f0b0043);

			if (!flag1)
				return result;
			else {
				if (flag || flag2 || flag3) {
					result.errCode = 1;
					result.errMsg = Gl.Ct().getString(0x7f0b0266);
				} else {
					doProcessSucceedCase(i, arraylist, false, false, false,
							result);
				}
				onFinished(result);
			}
		}
		return result;

	}

	protected WeatherUpdater.Result doUpadte(int i, HttpUtil httputil) {
		WeatherUpdater.Result result = null, result2 = null;
		WeatherUpdater.Result result1 = null;
		boolean flag1 = false;
		if (Gl.getRegCode().length() > 0 && !Gl.needReregister()) {
			CityWeatherInfo cityweatherinfo;

			cityweatherinfo = WeatherData.getCityInfo(i);
			boolean flag;
			String s;
			if (cityweatherinfo.m_cityID == -99)
				flag = true;
			else
				flag = false;
			if (flag) {
				httputil.setWebsite("albs.moji001.com");
				String s1 = Util.getAutoLocationInfo(Gl.Ct(), false);
				MojiLog.d("WeatherUpdaterCDNImpl", (new StringBuilder())
						.append("locationInfo = ").append(s1).toString());
				s = UrlUtil.getGetWeatherByLocURL(null,
						cityweatherinfo.m_lastLoacteCityID, s1);
			} else {
				httputil.setWebsite("cdn.moji001.com");
				s = HttpUtil.getMD5URL(
						UrlUtil.getCDNURL(cityweatherinfo.m_cityID),
						UrlUtil.getCDNParameter(cityweatherinfo.m_cityID));
			}
			httputil.doRequest(s);
			MojiLog.d("WeatherUpdaterCDNImpl",
					(new StringBuilder()).append("URLString = ").append(s)
							.toString());
			result1 = null;
			if (!httputil.isCanceled())
				flag1 = true;
			else
				flag1 = false;
			if (!flag1) {
				result2 = result1;
				return result2;
			} else {
				if (!flag) {
					if (httputil.getRespCode() != 403)
						return result2;
					MojiLog.d("WeatherUpdaterCDNImpl",
							"refresh the secret and try again...");
					HttpUtil.getCDNSecret();
					httputil.doRequest(HttpUtil.getMD5URL(
							UrlUtil.getCDNURL(cityweatherinfo.m_cityID),
							UrlUtil.getCDNParameter(cityweatherinfo.m_cityID)));
					if (!httputil.isCanceled())
						flag1 = true;
					else
						flag1 = false;
				} else

				{
					result1 = processGetWeatherResult(i, httputil.getResponse());
				}
			}
		} else {

			httputil.setWebsite("register.moji001.com");
			result = doRegister(httputil);
			result2 = null;
			if (result != null) {
				if (result.errCode != 0) {
					onFinished(result);
					result2 = result;
					return result2;
				}
			}

		}

		if (flag1)
			result1 = processCDNGetWeatherResult(i, httputil.getResponse());

		result2 = doWeatherNoFoundResult(i, httputil.getResponse());
		return result;
	}

	private static final String TAG = "WeatherUpdaterCDNImpl";
}
