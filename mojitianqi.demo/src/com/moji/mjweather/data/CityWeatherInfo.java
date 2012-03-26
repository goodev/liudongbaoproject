// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CityWeatherInfo.java

package com.moji.mjweather.data;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.moji.mjweather.data:
//            WeatherMainInfo

public final class CityWeatherInfo {
	public static enum ShowType {

		ST_INIT, ST_NEED_BE_UPDATE, ST_NOSET, ST_OK, ST_SET_NONE_DATA, ST_UPDATING

	}

	public CityWeatherInfo() {
		m_lastAutoUpdateFailedCount = 0;
		m_lastAutoUpdateTryTime = "";
		mCityName = "";
		m_lastUpdateTime = "";
		m_lastUpdateDate = "";
		m_weatherIndexUpdateTime = "";
		mShowType = ShowType.ST_NOSET;
		mWeatherMainInfo = new WeatherMainInfo();
		mWeatherAlertInfoList = new ArrayList();
		mWeatherTrendInfoList = new ArrayList();
		mWeatherDayDetailInfoList = new ArrayList();
	}

	public void Clean() {
		mCityName = "";
		m_lastUpdateTime = "";
		m_lastUpdateDate = "";
		mShowType = ShowType.ST_NOSET;
		resetNeedUpdate();
	}

	public void resetNeedUpdate() {
		m_lastAutoUpdateTryTime = "";
		m_weatherIndexUpdateTime = "";
		if (mWeatherMainInfo != null)
			mWeatherMainInfo.clear();
		if (mWeatherAlertInfoList != null)
			mWeatherAlertInfoList.clear();
		if (mWeatherTrendInfoList != null)
			mWeatherTrendInfoList.clear();
		if (mWeatherDayDetailInfoList != null)
			mWeatherDayDetailInfoList.clear();
	}

	public String mCityName;
	public ShowType mShowType;
	public List mWeatherAlertInfoList;
	public List mWeatherDayDetailInfoList;
	public WeatherMainInfo mWeatherMainInfo;
	public List mWeatherTrendInfoList;
	public int m_cityID;
	public float m_currentTemperature;
	public int m_lastAutoUpdateFailedCount;
	public String m_lastAutoUpdateTryTime;
	public int m_lastLoacteCityID;
	public String m_lastUpdateDate;
	public String m_lastUpdateTime;
	public String m_updateTimeOrState;
	public String m_weatherIndexUpdateTime;
}
