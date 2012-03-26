// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherData.java

package com.moji.mjweather.common;

import android.content.Context;
import com.moji.mjweather.Gl;
import com.moji.mjweather.data.*;
import com.moji.mjweather.util.Util;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

// Referenced classes of package com.moji.mjweather.common:
//            MojiLog, WeatherDataParser

public final class WeatherData {

	private WeatherData() {
	}

	public static void createCityInfo(int i) {
		sCityWeatherInfoList[i] = new CityWeatherInfo();
	}

	public static ArrayList getAvailableCityNameList() {
		ArrayList arraylist = new ArrayList();
		int i = 0;
		while (i < 9) {
			CityWeatherInfo cityweatherinfo = sCityWeatherInfoList[i];
			if (cityweatherinfo.m_cityID > 0)
				arraylist.add(cityweatherinfo.mCityName);
			else if (cityweatherinfo.m_cityID == -99)
				arraylist.add("\u5F53\u524D\u4F4D\u7F6E");
			i++;
		}
		return arraylist;
	}

	public static CityWeatherInfo getCityInfo(int i) {
		CityWeatherInfo cityweatherinfo;
		if (i >= 0 && i < 9)
			cityweatherinfo = sCityWeatherInfoList[i];
		else
			cityweatherinfo = sCityWeatherInfoList[0];
		return cityweatherinfo;
	}

	public static String getCityWeatherDescription(int i, int j, boolean flag) {
		String s;
		int k;
		String s1;
		CityWeatherInfo cityweatherinfo;
		String s2;
		s = null;
		k = 1;
		s1 = Gl.getSharePersonalRegards();
		cityweatherinfo = getCityInfo(i);
		if (cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK)
			return "";
		s2 = (new StringBuilder()).append(cityweatherinfo.mCityName)
				.append(",").toString();
		String s4;
		if (cityweatherinfo.mWeatherMainInfo.mDaylight == k)
			k = 0;
		for (; k < j; k++) {
			WeatherDayDetailInfo weatherdaydetailinfo = (WeatherDayDetailInfo) cityweatherinfo.mWeatherDayDetailInfoList
					.get(k);
			s2 = (new StringBuilder()).append(s2)
					.append(Util.GetWeekName(weatherdaydetailinfo.mWeek))
					.append(weatherdaydetailinfo.mLowTemperature).append("~")
					.append(weatherdaydetailinfo.mHighTemperature)
					.append("\u5EA6,")
					.append(weatherdaydetailinfo.mHighWeatherDescription)
					.append(";").toString();
		}

		String s3 = (new StringBuilder()).append(s2)
				.append("@\u58A8\u8FF9\u5929\u6C14\uFF0C").toString();
		SimpleDateFormat simpledateformat = new SimpleDateFormat(
				"MM\u6708dd\u65E5HH\u65F6");
		Date date = new Date();
		s4 = (new StringBuilder()).append(s3)
				.append(simpledateformat.format(date)).toString();
		s = (new StringBuilder()).append(s1).append(s4).toString();

		return s;

		// MojiLog.e("WeatherData", "get Share weather info erro", exception);

	}

	public static FileInputStream getWeatherXml(int i) throws Exception {
		String s = (new StringBuilder()).append("weatherCityindex").append(i)
				.append(".xml").toString();
		return Gl.Ct().openFileInput(s);
	}

	public static boolean hasMoreCity() {
		boolean flag = true;
		if (getCityInfo(1).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
			flag = false;
		return flag;
	}

	public static void loadWeatherData(int i) {
		CityWeatherInfo cityweatherinfo;
		String s;
		cityweatherinfo = getCityInfo(i);
		s = (new StringBuilder()).append("weatherCityindex").append(i)
				.append(".xml").toString();
		if (!Gl.Ct().getFileStreamPath(s).exists())
			return;
		try {
			if (!WeatherDataParser.parse(Gl.Ct().openFileInput(s),
					cityweatherinfo)) {
				cityweatherinfo.mWeatherMainInfo.mIsEmpty = true;
				for (int l = 0; l < cityweatherinfo.mWeatherTrendInfoList
						.size(); l++)
					((WeatherTrendInfo) cityweatherinfo.mWeatherTrendInfoList
							.get(l)).mIsEmpty = true;
				return;
			}
		} catch (FileNotFoundException e) {
			MojiLog.e("WeatherData", "loadWeatherData Exception ", e);
		}

		cityweatherinfo.mWeatherMainInfo.mIsEmpty = true;
		for (int j = 0; j < cityweatherinfo.mWeatherTrendInfoList.size(); j++)
			((WeatherTrendInfo) cityweatherinfo.mWeatherTrendInfoList.get(j)).mIsEmpty = true;

		for (int k = 0; k < cityweatherinfo.mWeatherDayDetailInfoList.size(); k++)
			((WeatherDayDetailInfo) cityweatherinfo.mWeatherDayDetailInfoList
					.get(k)).mIsEmpty = true;
		for (int i1 = 0;; i1++) {
			if (i1 >= cityweatherinfo.mWeatherDayDetailInfoList.size())
				return;
			((WeatherDayDetailInfo) cityweatherinfo.mWeatherDayDetailInfoList
					.get(i1)).mIsEmpty = true;

		}

	}

	public static void removeWeatherData(int i, int j) {
		if (Gl.Ct().deleteFile(
				(new StringBuilder()).append(String.valueOf(i)).append(".txt")
						.toString()))
			MojiLog.d("WeatherData", " removeWeatherData OK ");
		Gl.Ct().deleteFile(
				(new StringBuilder()).append("weatherCityindex").append(j)
						.append(".xml").toString());
	}

	public static void resetAllCityInfo() {
		int i = 0;
		do {

			i++;
			if (i < 9) {
				CityWeatherInfo cityweatherinfo = sCityWeatherInfoList[i];
				if (cityweatherinfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING)
					continue;
				if (cityweatherinfo.m_lastUpdateTime.length() <= 0)
					cityweatherinfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE;
				else
					cityweatherinfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK;
			}

		} while (true);
	}

	public static boolean saveWeatherData(ArrayList arraylist, int i) {
		return saveWeatherData(arraylist, i, false);
	}

	public static boolean saveWeatherData(ArrayList arraylist, int i,
			boolean flag) {
		int

		j = 0;

		OutputStreamWriter outputstreamwriter1 = null;
		String s = (new StringBuilder()).append("weatherCityindex").append(i)
				.append(".xml").toString();
		File file = Gl.Ct().getFileStreamPath(s);
		if (file.exists())
			file.delete();
		try {
			outputstreamwriter1 = new OutputStreamWriter(Gl.Ct()
					.openFileOutput(s, 0), "utf-8");
			if (!flag)
				j = 1;
			while (j < arraylist.size()) {
				outputstreamwriter1.write((new StringBuilder())
						.append(((String) arraylist.get(j)).toString())
						.append("\r\n").toString());
				j++;
			}
			flag = true;
		} catch (Exception e) {
			if (outputstreamwriter1 != null)
				try {
					outputstreamwriter1.close();
				} catch (IOException ioexception2) {
					flag = false;
				}
		}

		return flag;

	}

	public static void setCityInfo(int i) {
		sCityWeatherInfoList[i] = sCityWeatherInfoList[i + 1];
	}

	private static final String TAG = "WeatherData";
	private static CityWeatherInfo sCityWeatherInfoList[];

	static {
		sCityWeatherInfoList = null;
		sCityWeatherInfoList = new CityWeatherInfo[9];
		for (int i = 0; i < 9; i++)
			sCityWeatherInfoList[i] = new CityWeatherInfo();

	}
}
