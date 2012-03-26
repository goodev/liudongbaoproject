// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AbstractWeatherUpdater.java

package com.moji.mjweather.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.os.Looper;

import com.moji.mjweather.Gl;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.util.HttpUtil;
import com.moji.mjweather.util.StatsUtil;
import com.moji.mjweather.util.UrlUtil;

// Referenced classes of package com.moji.mjweather.common:
//            WeatherUpdater, WeatherUpdaterImpl, WeatherUpdaterCDNImpl, WeatherAlert, 
//            WeatherData, WeatherPublisher, MojiLog

public abstract class AbstractWeatherUpdater implements WeatherUpdater {
	private class NetworkThread extends Thread {

		public void cancel() {
			if (mHttpUtil != null)
				mHttpUtil.cancel();
		}

		public void run() {
			Looper.prepare();
			mHttpUtil = new HttpUtil();
			doUpadte(mCityIndex, mHttpUtil);
		}

		private int mCityIndex;
		private HttpUtil mHttpUtil;

		public NetworkThread(int i) {
			super();
			mCityIndex = i;
		}
	}

	protected AbstractWeatherUpdater() {
	}

	public static WeatherUpdater createInstance() {
		Object obj;
		if (IMPL_TYPE == 1)
			obj = new WeatherUpdaterImpl();
		else if (IMPL_TYPE == 0)
			obj = new WeatherUpdaterCDNImpl();
		else
			obj = null;
		return ((WeatherUpdater) (obj));
	}

	public static boolean isSucceed(WeatherUpdater.Result result) {
		boolean flag;
		if (result != null
				&& (result.errCode == 0 || result.errCode == 3 || result.errCode == 2))
			flag = true;
		else
			flag = false;
		return flag;
	}

	public static void setImplType(int i) {
		IMPL_TYPE = i;
	}

	public void cancel() {
		if (mThread != null) {
			mThread.cancel();
			mThread = null;
		}
	}

	protected void doCheckAfterSaveIfRunInService(int i) {
		if (mIsRunInService)
			WeatherAlert.checkKindNotice(i);
	}

	protected void doCheckBeforeSaveIfRunInService(int i) {
		if (mIsRunInService)
			WeatherAlert.check(i);
	}

	protected WeatherUpdater.Result doRegister(HttpUtil httputil) {
		Object obj = null;
		httputil.doRequest(UrlUtil.getRegisterURL(((String) (obj))));
		if (!httputil.isCanceled())
			obj = processRegisterResult(httputil.getResponse());
		return ((WeatherUpdater.Result) (obj));
	}

	protected abstract WeatherUpdater.Result doUpadte(int i, HttpUtil httputil);

	protected void onFinished(WeatherUpdater.Result result) {
		if (!isSucceed(result)) {
			CityWeatherInfo cityweatherinfo = WeatherData
					.getCityInfo(result.cityIndex);
			if (cityweatherinfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING)
				if (cityweatherinfo.m_lastUpdateTime.length() <= 0)
					cityweatherinfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE;
				else
					cityweatherinfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK;
		}
		WeatherPublisher.getInstance().publish(result);
	}

	protected WeatherUpdater.Result processRegisterResult(List list) {
		WeatherUpdater.Result result;
		result = new WeatherUpdater.Result();
		result.errCode = 1;
		result.errMsg = Gl.Ct().getString(0x7f0b0032);
		if (list != null && list.size() > 0) {
			String s = HttpUtil.getContent(list, 0);
			boolean flag = "0".equals(s);
			boolean flag1 = "5".equals(s);
			boolean flag2 = "2".equals(s);
			boolean flag3 = "8".equals(s);
			if (flag || flag1) {
				Gl.saveOldPartnerID(Gl.getPartnerID());
				Gl.saveRegCode(HttpUtil.getContent(list, 1));
				result.errCode = 0;
			} else if (flag2) {
				result.errCode = 4;
				try {
					result.errMsg = HttpUtil.getContent(list, 2);
				} catch (Exception exception) {
					MojiLog.e("AbstractWeatherUpdater", exception.getMessage());
				}
			} else if (flag3)
				result.errMsg = Gl.Ct().getString(0x7f0b0054);
		} else {
			WeatherData.resetAllCityInfo();
			if (WeatherData.getCityInfo(0).mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK)
				WeatherData.getCityInfo(0).mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE;
		}

		return result;
	}

	protected void saveCityInfo(int i) {
		CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(i);
		Date date = new Date();
		cityweatherinfo.m_lastUpdateTime = (new SimpleDateFormat("HH:mm"))
				.format(date);
		cityweatherinfo.m_lastUpdateDate = (new SimpleDateFormat("yyyy-MM-dd"))
				.format(date);
		Gl.saveCityInfo(i, cityweatherinfo);
	}

	public boolean update(int i) {
		return update(i, false);
	}

	public boolean update(int i, boolean flag) {
		int j = WeatherData.getCityInfo(i).mWeatherMainInfo.mCityId;
		if (j == 0)
			j = WeatherData.getCityInfo(i).m_cityID;
		StatsUtil.updateStatsCityQC(j);
		mIsRunInService = flag;
		mThread = new NetworkThread(i);
		mThread.start();
		return true;
	}

	public WeatherUpdater.Result updateSync(int i) {
		int j = WeatherData.getCityInfo(i).mWeatherMainInfo.mCityId;
		if (j == 0)
			j = WeatherData.getCityInfo(i).m_cityID;
		StatsUtil.updateStatsCityQC(j);
		mIsRunInService = false;
		return doUpadte(i, new HttpUtil());
	}

	public static final int IMPL_CDN = 0;
	public static final int IMPL_NORMAL = 1;
	private static int IMPL_TYPE = 0;
	private static final String TAG = "AbstractWeatherUpdater";
	protected boolean mIsRunInService;
	protected NetworkThread mThread;

	static {
		IMPL_TYPE = 1;
		setImplType(0);
	}
}
