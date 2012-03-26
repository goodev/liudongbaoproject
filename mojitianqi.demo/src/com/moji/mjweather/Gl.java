// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Gl.java

package com.moji.mjweather;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.WindowManager;
import com.moji.mjweather.activity.TabSelectorActivity;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.data.WeatherAlertInfo;
import com.moji.mjweather.data.WeatherMainInfo;
import com.moji.mjweather.widgetskin.SkinInfo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class Gl extends Application {

	public Gl() {
	}

	public static Context Ct() {
		return sContext;
	}

	public static long GetAdIndexInfoUpdateTime(int i, int j) {
		return sSharedPreferences.getLong(
				(new StringBuilder()).append("NextUpdateTime_").append(i)
						.append("_").append(j).toString(), 0L);
	}

	public static void SaveAdIndexInfoUpdateTime(int i, int j, long l) {
		android.content.SharedPreferences.Editor editor = sSharedPreferences
				.edit();
		editor.putLong((new StringBuilder()).append("NextUpdateTime_")
				.append(i).append("_").append(j).toString(), l);
		editor.commit();
	}

	public static void clearAllCustomLoadInfo() {
		android.content.SharedPreferences.Editor editor = sSharedPreferences
				.edit();
		editor.putString("W4x1CustomHotAreLoaderName1", "\u9ED8\u8BA4");
		editor.putString("W4x1CustomHotAreLoaderName2", "\u95F9\u949F");
		editor.putString("W4x2CustomHotAreLoaderName1", "\u95F9\u949F");
		editor.putString("W4x2CustomHotAreLoaderName2", "\u65E5\u5386");
		editor.putString("W4x2CustomHotAreLoaderName3",
				"\u66F4\u65B0\u5929\u6C14");
		editor.putString("W4x1CustomHotAreLoaderValue1", "default|default");
		editor.putString("W4x1CustomHotAreLoaderValue2", "default|default");
		editor.putString("W4x2CustomHotAreLoaderValue1", "default|default");
		editor.putString("W4x2CustomHotAreLoaderValue2", "default|default");
		editor.putString("W4x2CustomHotAreLoaderValue3", "default|default");
		editor.commit();
	}

	public static String getADUpdateSuccessTime(int i) {
		if (adUpdateSuccessTime == null)
			adUpdateSuccessTime = sDefaultSharedPreferences.getString(
					(new StringBuilder()).append("place").append(i).toString(),
					"");
		return adUpdateSuccessTime;
	}

	public static boolean getAdON() {
		if (sAdON == null)
			sAdON = Boolean.valueOf(sSharedPreferences.getBoolean("umeng",
					getDefaultUmengSwitch()));
		return sAdON.booleanValue();
	}

	public static boolean getAlarmOnlyWorkingDay() {
		if (sAlarmOnlyWorkingDay == null)
			sAlarmOnlyWorkingDay = Boolean.valueOf(sDefaultSharedPreferences
					.getBoolean("alarm_only_working_day", false));
		return sAlarmOnlyWorkingDay.booleanValue();
	}

	public static boolean getAlertNotificationEnable() {
		if (sIsAlertNotificationEnable == null)
			sIsAlertNotificationEnable = Boolean
					.valueOf(sDefaultSharedPreferences.getBoolean(
							"alert_checkbox_notification", true));
		return sIsAlertNotificationEnable.booleanValue();
	}

	public static Long getApkDownloadTime() {
		if (apkDownloadTime == null)
			apkDownloadTime = Long.valueOf(sDefaultSharedPreferences.getLong(
					"ad_apk_downlaod_time", 0L));
		return apkDownloadTime;
	}

	public static Integer getAutoShareCity() {
		if (sAutoShareCity == null)
			sAutoShareCity = Integer.valueOf(Integer
					.parseInt(sDefaultSharedPreferences.getString(
							"share_city_list_preference", "-1")));
		return sAutoShareCity;
	}

	public static String getAutoShareType() {
		if (sAutoShareType == null)
			sAutoShareType = sDefaultSharedPreferences.getString(
					"share_type_list_preference", "1");
		return sAutoShareType;
	}

	public static boolean getAutoUpdate() {
		if (sAutoUpdate == null)
			sAutoUpdate = Boolean.valueOf(sDefaultSharedPreferences.getBoolean(
					"checkbox_preference", true));
		return sAutoUpdate.booleanValue();
	}

	public static int getAutoUpdateFailCount() {
		if (sAutoUpdateFailCount == null)
			sAutoUpdateFailCount = Integer.valueOf(sSharedPreferences.getInt(
					"auto_update_fail_count", 0));
		return sAutoUpdateFailCount.intValue();
	}

	public static boolean getAutoVoicePlay() {
		if (sAutoVoicePlay == null)
			sAutoVoicePlay = Boolean.valueOf(sDefaultSharedPreferences
					.getBoolean("EnableAutoVoicePlay", false));
		return sAutoVoicePlay.booleanValue();
	}

	public static String getAutoVoiceTime() {
		if (sAutoVoiceTime == null)
			sAutoVoiceTime = sSharedPreferences.getString("setautotime",
					"08:00");
		return sAutoVoiceTime;
	}

	public static String getCDNSecret() {
		if (sCDNSecret == null)
			sCDNSecret = sSharedPreferences.getString("CDNSecret", "");
		return sCDNSecret;
	}

	public static boolean getClockAimationEnable() {
		boolean flag;
		if (android.os.Build.VERSION.SDK_INT < 7) {
			flag = false;
		} else {
			if (sIsClockAimationEnable == null)
				sIsClockAimationEnable = Boolean
						.valueOf(sDefaultSharedPreferences.getBoolean(
								"clock_animation", true));
			flag = sIsClockAimationEnable.booleanValue();
		}
		return flag;
	}

	public static Integer getClockAnimationItem() {
		if (sClockAnimationItem == null) {
			sClockAnimationItem = Integer.valueOf(Integer
					.parseInt(sDefaultSharedPreferences.getString(
							"clock_animation_items", "3")));
			if (sClockAnimationItem.intValue() > 9) {
				sDefaultSharedPreferences.edit()
						.putString("clock_animation_items", "3").commit();
				sClockAnimationItem = Integer.valueOf(3);
			}
		}
		return sClockAnimationItem;
	}

	public static int getCurrentCityIndex() {
		if (sCurrentCityIndex == null)
			sCurrentCityIndex = Integer.valueOf(sSharedPreferences.getInt(
					"LastForceCityIndex", 0));
		return sCurrentCityIndex.intValue();
	}

	public static SkinInfo getCurrentSkin4x1() {
		return sCurrentSkin4x1;
	}

	public static SkinInfo getCurrentSkin4x2() {
		return sCurrentSkin4x2;
	}

	public static String getCurrentSkinDir() {
		if (sCurrentSkinDir == null)
			sCurrentSkinDir = sSharedPreferences.getString("SkinDirectory",
					"ORG");
		return sCurrentSkinDir;
	}

	public static String getCustomLoaderName(int i) {
		return sSharedPreferences.getString(
				(new StringBuilder()).append("CustomLoaderName").append(i)
						.toString(), "\u672A\u8BBE\u5B9A");
	}

	public static String getCustomLoaderValue(int i) {
		return sSharedPreferences.getString(
				(new StringBuilder()).append("CustomLoaderValue").append(i)
						.toString(), "none|none");
	}

	public static String getDatabaseVersion() {
		return "100";
	}

	public static boolean getDefaultUmengSwitch() {
		String s = getPartnerID();
		boolean flag;
		if (s.equals("5000") || s.equals("5080") || s.equals("5012")
				|| s.equals("5032") || s.equals("5068") || s.equals("5002")
				|| s.equals("5029"))
			flag = true;
		else
			flag = false;
		return flag;
	}

	public static boolean getDownloadListInvalid() {
		return sDownloadListInvalid;
	}

	public static boolean getEnableAutoShare() {
		if (sAutoShare == null)
			sAutoShare = Boolean.valueOf(sDefaultSharedPreferences.getBoolean(
					"share_checkbox_preference", false));
		return sAutoShare.booleanValue();
	}

	public static String getFavoriteDate(int i, int j) {
		favoriteDate = sSharedPreferences.getString((new StringBuilder())
				.append("key_favorite_date_").append(i).append("_").append(j)
				.toString(), "2000/01/01");
		return favoriteDate;
	}

	public static boolean getGpsLocationState() {
		if (sIsGPSLocationOpen == null)
			sIsGPSLocationOpen = Boolean.valueOf(sDefaultSharedPreferences
					.getBoolean("CheckBox_Gps_Location", false));
		return sIsGPSLocationOpen.booleanValue();
	}

	public static Handler getHandler() {
		return sHandler;
	}

	public static boolean getHighPriorityDialogIsOpen() {
		return sHighPriorityDialogIsOpen;
	}

	public static String getHotAreaCustomLoaderName(int i, String s)
    {
        String s1 = "\u9ED8\u8BA4";
        s1 = "\u66F4\u65B0\u5929\u6C14";
        if(s.equals("4x2"))
            s1 = "\u65E5\u5386";
        else
        if(s.equals("4x1"))
            s1 = "\u95F9\u949F";
        else
        	 s1 = "\u95F9\u949F";
        
        return sSharedPreferences.getString((new StringBuilder()).append("W").append(s).append("CustomHotAreLoaderName").append(i).toString(), s1);
 
   
        
         
    }

	public static String getHotAreaCustomLoaderValue(int i, String s) {
		return sSharedPreferences.getString((new StringBuilder()).append("W")
				.append(s).append("CustomHotAreLoaderValue").append(i)
				.toString(), "default|default");
	}

	public static int getHuangLiDBVersion() {
		if (sHuangLiDBVersion == null)
			sHuangLiDBVersion = Integer.valueOf(sSharedPreferences.getInt(
					"auto_update_fail_count", 0));
		return sHuangLiDBVersion.intValue();
	}

	public static boolean getIsFirstRun() {
		if (sIsFirstRun == null)
			sIsFirstRun = Boolean.valueOf(sSharedPreferences.getBoolean(
					"is_first_login", true));
		return sIsFirstRun.booleanValue();
	}

	public static boolean getIsFirstTestInSkin() {
		if (sIsFirstTestInSkin == null)
			sIsFirstTestInSkin = Boolean.valueOf(sSharedPreferences.getBoolean(
					"is_first_test_inskin", true));
		return sIsFirstTestInSkin.booleanValue();
	}

	public static boolean getIsLocationbyGPS() {
		return isLocationbyGPS;
	}

	public static boolean getIsNotifyVoiceDataUpdate() {
		if (sIsNotifyVoiceDataUpdate == null)
			sIsNotifyVoiceDataUpdate = Boolean.valueOf(sSharedPreferences
					.getBoolean("VoiceDataUpdateNotify", false));
		return sIsNotifyVoiceDataUpdate.booleanValue();
	}

	public static String getKindNoticeDate() {
		if (sKindNoticeDate == null)
			sKindNoticeDate = sSharedPreferences.getString("kind_notice_date",
					"");
		return sKindNoticeDate;
	}

	public static String getLastAutoVoiceTime() {
		if (sLastAutoVoiceTime == null)
			sLastAutoVoiceTime = sDefaultSharedPreferences.getString(
					"LastAutoVoicePlay", "0000-00-00 00:00");
		return sLastAutoVoiceTime;
	}

	public static String getLastSuccessShareDate() {
		if (sLastSuccessShareDate == null)
			sLastSuccessShareDate = sSharedPreferences.getString(
					"LastSuccessShareDate", "0000-00-00");
		return sLastSuccessShareDate;
	}

	public static String getLastTryShareDate() {
		if (sLastTryShareDate == null)
			sLastTryShareDate = sSharedPreferences.getString(
					"LastTryShareDate", "0000-00-00");
		return sLastTryShareDate;
	}

	public static String getLifeImgDate() {
		imgDate = sSharedPreferences.getString("key_life_img_date",
				"2000/01/01");
		return imgDate;
	}

	public static String getLifeInfoDate(int i, String s) {
		infoDate = sSharedPreferences.getString(
				(new StringBuilder()).append("key_life_info_date_").append(s)
						.append("_").append(i).toString(), "2000/01/01");
		return infoDate;
	}

	public static Class getMainActivityClass() {
		return  TabSelectorActivity.class;
	}

	public static String getManualShareType() {
		if (sManualShareType == null)
			sManualShareType = sDefaultSharedPreferences.getString(
					"share_manual_type_list_preference", "0");
		return sManualShareType;
	}

	public static String getMustUpdateUrl() {
		if (sMustUpdateUrl == null)
			sMustUpdateUrl = sSharedPreferences
					.getString("must_update_url", "");
		return sMustUpdateUrl;
	}

	public static boolean getNoticedBySound() {
		if (sIsNoticedBySound == null)
			sIsNoticedBySound = Boolean.valueOf(sDefaultSharedPreferences
					.getBoolean("checkbox_voice", false));
		return sIsNoticedBySound.booleanValue();
	}

	public static boolean getNoticedByVibrate() {
		if (sIsNoticedByVibrate == null)
			sIsNoticedByVibrate = Boolean.valueOf(sDefaultSharedPreferences
					.getBoolean("checkbox_shake", false));
		return sIsNoticedByVibrate.booleanValue();
	}

	public static boolean getNotificationEnable() {
		if (sIsNotificationEnable == null)
			sIsNotificationEnable = Boolean.valueOf(sDefaultSharedPreferences
					.getBoolean("checkbox_notification", true));
		return sIsNotificationEnable.booleanValue();
	}

	public static String getOldPartnerID() {
		if (sPartnerID == null)
			sPartnerID = sSharedPreferences.getString("PartnerID", "");
		return sPartnerID;
	}

	public static String getPartnerID() {
		return "5032";
	}

	public static int getRandomMinutes() {
		if (sRandomMinutes == null) {
			sRandomMinutes = Integer.valueOf(sSharedPreferences.getInt(
					"RandomNumber", -100));
			if (sRandomMinutes.intValue() == -100
					|| sRandomMinutes.intValue() > 15
					|| sRandomMinutes.intValue() < -15)
				saveRandomMinutes(-15
						+ (int) (System.currentTimeMillis() % 31L));
		}
		return sRandomMinutes.intValue();
	}

	public static String getRegCode() {
		if (sRegCode == null)
			sRegCode = sSharedPreferences.getString("UserRegisterdCode", "");
		return sRegCode;
	}

	public static boolean getRelink() {
		if (sRelink == null)
			sRelink = Boolean.valueOf(sSharedPreferences.getBoolean(
					"CDNUpdateRelink", true));
		return sRelink.booleanValue();
	}

	public static int getScreenTypeIntValue() {
		if (sScreenTypeIntValue == null)
			setScreenTypeStringAndIntValue();
		return sScreenTypeIntValue.intValue();
	}

	public static String getScreenTypeString() {
		if (sScreenTypeString == null)
			setScreenTypeStringAndIntValue();
		return sScreenTypeString;
	}

	public static Integer getShareForecastDays() {
		if (sShareForcastDays == null)
			sShareForcastDays = Integer.valueOf(Integer
					.parseInt(sDefaultSharedPreferences.getString(
							"share_days_list_preference", "3")));
		return sShareForcastDays;
	}

	public static String getSharePersonalRegards() {
		if (sPersonalRegards == null)
			sPersonalRegards = sSharedPreferences.getString(
					"share_personal_regards", "");
		return sPersonalRegards;
	}

	public static boolean getShowWifiWarning() {
		if (sShowWifiWarning == null)
			sShowWifiWarning = Boolean.valueOf(sSharedPreferences.getBoolean(
					"ShowWifiWaring", true));
		return sShowWifiWarning.booleanValue();
	}

	public static boolean getSkinApkInstalled() {
		if (sSkinApkInstalled == null)
			sSkinApkInstalled = Boolean.valueOf(sSharedPreferences.getBoolean(
					"skin_apk_installed", false));
		return sSkinApkInstalled.booleanValue();
	}

	public static String getSkinApks() {
		if (sSkinApks == null)
			sSkinApks = sSharedPreferences.getString("SkinApks", "");
		return sSkinApks;
	}

	public static int getStatRetryCount() {
		if (sStatRetryCount == null)
			sStatRetryCount = Integer.valueOf(sSharedPreferences.getInt(
					"StatRetryTime", 0));
		return sStatRetryCount.intValue();
	}

	public static long getStatSentTime() {
		if (sStatSentTime == null)
			sStatSentTime = Long.valueOf(sSharedPreferences.getLong(
					"StatSendTime", 0L));
		return sStatSentTime.longValue();
	}

	public static int getStatsCount(String s) {
		return sSharedPreferences.getInt(s, 0);
	}

	public static String getUpdateEndTime() {
		if (sUpdateEndTime == null)
			sUpdateEndTime = sSharedPreferences.getString("EndUpdateTime",
					"22:00");
		return sUpdateEndTime;
	}

	public static int getUpdateFailedCount() {
		if (sShareUpdateFailCount == null)
			sShareUpdateFailCount = Integer.valueOf(sDefaultSharedPreferences
					.getInt("UpdateFailedCount", 0));
		return sShareUpdateFailCount.intValue();
	}

	public static long getUpdateImageSuccessTime() {
		if (updateSuccessTime == null)
			updateSuccessTime = Long.valueOf(sDefaultSharedPreferences.getLong(
					"ad_update_image_success_time", 0L));
		return updateSuccessTime.longValue();
	}

	public static float getUpdateInterval() {
		if (sUpdateInterval == null)
			sUpdateInterval = Float.valueOf(sSharedPreferences.getFloat(
					"UpdaterIntervalTime", 4F));
		return sUpdateInterval.floatValue();
	}

	public static String getUpdateStartTime() {
		if (sUpdateStartTime == null)
			sUpdateStartTime = sSharedPreferences.getString("StartUpdateTime",
					"08:00");
		return sUpdateStartTime;
	}

	public static String getVersion() {
		return "21005";
	}

	public static String getVersionType() {
		return "1";
	}

	public static boolean getW4x1InUse() {
		if (sW4x1IsInUse == null)
			sW4x1IsInUse = Boolean.valueOf(sSharedPreferences.getBoolean(
					"UseWidget4x1", false));
		return sW4x1IsInUse.booleanValue();
	}

	public static boolean getW4x2InUse() {
		if (sW4x2IsInUse == null)
			sW4x2IsInUse = Boolean.valueOf(sSharedPreferences.getBoolean(
					"UseWidget4x2", false));
		return sW4x2IsInUse.booleanValue();
	}

	public static float getWTempHi(int i) {
		return sSharedPreferences.getFloat((new StringBuilder()).append("Item")
				.append(i).append("TempHi").toString(), 100F);
	}

	public static String getWUpdateDate(int i) {
		return sSharedPreferences.getString((new StringBuilder())
				.append("Item").append(i).append("CurrUpdateDate").toString(),
				"");
	}

	public static String getWeatherAlertContent(int i, int j) {
		return sSharedPreferences.getString((new StringBuilder())
				.append("Item").append(i).append("EarlyWarningContents")
				.append(j + 1).toString(), "");
	}

	public static int getWeatherAlertListSize(int i) {
		return sSharedPreferences.getInt((new StringBuilder()).append("Item")
				.append(i).append("EarlyWarningListSize").toString(), 0);
	}

	public static int getWeatherID(int i) {
		return sSharedPreferences.getInt((new StringBuilder()).append("Item")
				.append(i).append("WeaID").toString(), 44);
	}

	public static int getWidgetUseBackground() {
		if (sWidgetUseBackground == null)
			sWidgetUseBackground = Integer.valueOf(sSharedPreferences.getInt(
					"WidgetUseBackground", 0));
		return sWidgetUseBackground.intValue();
	}

	public static void init(Context context) {
		sContext = context;
		sDefaultSharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		sSharedPreferences = context.getSharedPreferences("mojiWeatherInfo", 0);
		for (int i = 0; i < 9; i++)
			loadCityInfo(i, WeatherData.getCityInfo(i));

	}

	public static boolean isChangedCity() {
		return sIsCityChanged;
	}

	public static void loadCityInfo(int i, CityWeatherInfo cityweatherinfo)
    {
        cityweatherinfo.m_lastLoacteCityID = sSharedPreferences.getInt((new StringBuilder()).append("Item").append(i).append("LastCityCode").toString(), 0);
        cityweatherinfo.m_cityID = sSharedPreferences.getInt((new StringBuilder()).append("Item").append(i).append("CityCode").toString(), 0);
        if(cityweatherinfo.m_cityID == 0)
            cityweatherinfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET;
        else
            cityweatherinfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK;
        if(cityweatherinfo.mShowType  == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)   
        return;
 
        cityweatherinfo.mCityName = sSharedPreferences.getString((new StringBuilder()).append("Item").append(i).append("CityName").toString(), "");
        cityweatherinfo.m_lastUpdateDate = sSharedPreferences.getString((new StringBuilder()).append("ItemXml").append(i).append("UpdateDate").toString(), "");
        if(cityweatherinfo.m_cityID != 0 && cityweatherinfo.m_lastUpdateDate.length() <= 0)
            cityweatherinfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE;
        cityweatherinfo.m_lastUpdateTime = sSharedPreferences.getString((new StringBuilder()).append("ItemXml").append(i).append("UpdateTime").toString(), "");
        cityweatherinfo.m_weatherIndexUpdateTime = sSharedPreferences.getString((new StringBuilder()).append("Item").append(cityweatherinfo.m_cityID).append("WeatherIndexUpdateTime").toString(), "");
        WeatherData.loadWeatherData(i);
        if(sSharedPreferences.getString((new StringBuilder()).append("Item").append(i).append("UpdateDate").toString(), "").length() > 0)
        {
            android.content.SharedPreferences.Editor editor = sSharedPreferences.edit();
            editor.putString((new StringBuilder()).append("Item").append(i).append("UpdateDate").toString(), "");
            editor.putString((new StringBuilder()).append("Item").append(i).append("UpdateTime").toString(), "");
            editor.putString((new StringBuilder()).append("Item").append(i).append("RealTimeWeather").toString(), "");
            for(int j = 0; j < 5; j++)
                editor.putString((new StringBuilder()).append("Item").append(i).append("RealTimeWeatherD").append(j + 1).toString(), "");

            editor.commit();
        }
         
    }

	public static boolean needNotifyTrendCityChanged() {
		return sNeedNotifyTrendCityChanged;
	}

	public static boolean needReregister() {
		boolean flag;
		if (!getOldPartnerID().equals(getPartnerID()))
			flag = true;
		else
			flag = false;
		return flag;
	}

	public static void removeAllOldCityXml() {
		for (int i = 0; i < 9; i++) {
			String s = (new StringBuilder()).append("weatherCity").append(i)
					.append(".xml").toString();
			File file = Ct().getFileStreamPath(s);
			if (!file.exists())
				continue;
			file.delete();
			CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(i);
			cityweatherinfo.resetNeedUpdate();
			if (cityweatherinfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK)
				cityweatherinfo.mShowType = com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE;
		}

	}

	public static void removeCityInfo(int i) {
		android.content.SharedPreferences.Editor editor = sSharedPreferences
				.edit();
		int j = sSharedPreferences.getInt((new StringBuilder()).append("Item")
				.append(i).append("CityCode").toString(), 0);
		if (j != 0) {
			editor.remove((new StringBuilder()).append("Item").append(i)
					.append("CityName").toString());
			editor.remove((new StringBuilder()).append("Item").append(i)
					.append("CityCode").toString());
			editor.remove((new StringBuilder()).append("Item").append(i)
					.append("LastCityCode").toString());
			editor.remove((new StringBuilder()).append("Item").append(i)
					.append("ShowIndex").toString());
			editor.remove((new StringBuilder()).append("ItemXml").append(i)
					.append("UpdateDate").toString());
			editor.remove((new StringBuilder()).append("ItemXml").append(i)
					.append("UpdateTime").toString());
			editor.remove((new StringBuilder()).append("Item").append(j)
					.append("WeatherIndexUpdateTime").toString());
			editor.remove((new StringBuilder()).append("Item").append(i)
					.append("TempHi").toString());
			editor.remove((new StringBuilder()).append("Item").append(i)
					.append("WeaID").toString());
			editor.remove((new StringBuilder()).append("Item").append(i)
					.append("CurrUpdateDate").toString());
			WeatherData.removeWeatherData(j, i);
			CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(i);
			editor.remove((new StringBuilder()).append("Item").append(i)
					.append("EarlyWarningListSize").toString());
			if (cityweatherinfo.mWeatherAlertInfoList.size() > 0) {
				for (int k = 0; k < cityweatherinfo.mWeatherAlertInfoList
						.size(); k++)
					editor.remove((new StringBuilder()).append("Item")
							.append(i).append("EarlyWarningContents")
							.append(k + 1).toString());

			}
			editor.commit();
		}
	}

	public static void removeLifeInfoDate(int i, String s) {
		sSharedPreferences
				.edit()
				.remove((new StringBuilder()).append("key_life_info_date_")
						.append(s).append("_").append(i).toString()).commit();
	}

	public static void resetADUpdateTime(int i) {
		sDefaultSharedPreferences
				.edit()
				.putString(
						(new StringBuilder()).append("place").append(i)
								.toString(), "").commit();
		adUpdateSuccessTime = null;
	}

	public static void resetAlarmOnlyWorkingDay() {
		sAlarmOnlyWorkingDay = null;
	}

	public static void resetAlertNotificationEnable() {
		sIsAlertNotificationEnable = null;
	}

	public static void resetAutoShareCity() {
		sAutoShareCity = null;
	}

	public static void resetAutoShareType() {
		sAutoShareType = null;
	}

	public static void resetAutoUpdate() {
		sAutoUpdate = null;
	}

	public static void resetAutoVoicePlay() {
		sAutoVoicePlay = null;
	}

	public static void resetClockAnimationEnable() {
		sIsClockAimationEnable = null;
	}

	public static void resetClockAnimationItem() {
		sClockAnimationItem = null;
	}

	public static void resetEnableAutoShare() {
		sAutoShare = null;
	}

	public static void resetGpsLocationState() {
		sIsGPSLocationOpen = null;
	}

	public static void resetManualShareType() {
		sManualShareType = null;
	}

	public static void resetNoticedBySound() {
		sIsNoticedBySound = null;
	}

	public static void resetNoticedByVibrate() {
		sIsNoticedByVibrate = null;
	}

	public static void resetNotificationEnable() {
		sIsNotificationEnable = null;
	}

	public static void resetShareForcastDays() {
		sShareForcastDays = null;
	}

	public static void saveADUpdateSuccessTime(int i) {
		Date date = new Date();
		String s = (new SimpleDateFormat("yyyy/MM/dd")).format(date);
		sDefaultSharedPreferences
				.edit()
				.putString(
						(new StringBuilder()).append("place").append(i)
								.toString(), s).commit();
		adUpdateSuccessTime = null;
	}

	public static void saveAdON(boolean flag) {
		if ((sAdON == null || !sAdON.equals(Boolean.valueOf(flag)))
				&& sSharedPreferences.edit().putBoolean("umeng", flag).commit())
			sAdON = Boolean.valueOf(flag);
	}

	public static void saveApkDownloadTime() {
		sDefaultSharedPreferences.edit()
				.putLong("ad_apk_downlaod_time", System.currentTimeMillis())
				.commit();
		apkDownloadTime = null;
	}

	public static void saveAutoShareCity(int i) {
		if ((sAutoShareCity == null || sAutoShareCity.intValue() != i)
				&& sDefaultSharedPreferences
						.edit()
						.putString("share_city_list_preference",
								String.valueOf(i)).commit())
			sAutoShareCity = Integer.valueOf(i);
	}

	public static void saveAutoUpdateFailCount(int i) {
		if ((sAutoUpdateFailCount == null || !sAutoUpdateFailCount
				.equals(Integer.valueOf(i)))
				&& sSharedPreferences.edit()
						.putInt("auto_update_fail_count", i).commit())
			sAutoUpdateFailCount = Integer.valueOf(i);
	}

	public static void saveAutoVoiceTime(String s) {
		if ((sAutoVoiceTime == null || !sAutoVoiceTime.equals(s))
				&& sSharedPreferences.edit().putString("setautotime", s)
						.commit())
			sAutoVoiceTime = s;
	}

	public static void saveCDNSecret(String s) {
		if ((sCDNSecret == null || !sCDNSecret.equals(s))
				&& sSharedPreferences.edit().putString("CDNSecret", s).commit())
			sCDNSecret = s;
	}

	public static boolean saveCityInfo(int i, CityWeatherInfo cityweatherinfo) {
		android.content.SharedPreferences.Editor editor = sSharedPreferences
				.edit();
		editor.putString(
				(new StringBuilder()).append("Item").append(i)
						.append("CityName").toString(),
				cityweatherinfo.mCityName);
		editor.putInt(
				(new StringBuilder()).append("Item").append(i)
						.append("CityCode").toString(),
				cityweatherinfo.m_cityID);
		editor.putInt(
				(new StringBuilder()).append("Item").append(i)
						.append("LastCityCode").toString(),
				cityweatherinfo.m_lastLoacteCityID);
		editor.putInt(
				(new StringBuilder()).append("Item").append(i)
						.append("ShowIndex").toString(), i);
		editor.putString((new StringBuilder()).append("ItemXml").append(i)
				.append("UpdateDate").toString(),
				cityweatherinfo.m_lastUpdateDate);
		editor.putString((new StringBuilder()).append("ItemXml").append(i)
				.append("UpdateTime").toString(),
				cityweatherinfo.m_lastUpdateTime);
		editor.putString(
				(new StringBuilder()).append("Item")
						.append(cityweatherinfo.m_cityID)
						.append("WeatherIndexUpdateTime").toString(),
				cityweatherinfo.m_weatherIndexUpdateTime);
		if (cityweatherinfo.mWeatherMainInfo.mDaylight == 1) {
			editor.putFloat((new StringBuilder()).append("Item").append(i)
					.append("TempHi").toString(),
					cityweatherinfo.mWeatherMainInfo.mHighTemperature);
			editor.putInt((new StringBuilder()).append("Item").append(i)
					.append("WeaID").toString(),
					cityweatherinfo.mWeatherMainInfo.mWeatherId);
			editor.putString((new StringBuilder()).append("Item").append(i)
					.append("CurrUpdateDate").toString(),
					cityweatherinfo.mWeatherMainInfo.mSolarUpdateDate);
		}
		MojiLog.d(
				"Gl",
				(new StringBuilder()).append("alertSize = ")
						.append(cityweatherinfo.mWeatherAlertInfoList.size())
						.toString());
		editor.putInt(
				(new StringBuilder()).append("Item").append(i)
						.append("EarlyWarningListSize").toString(),
				cityweatherinfo.mWeatherAlertInfoList.size());
		if (cityweatherinfo.mWeatherAlertInfoList.size() > 0) {
			for (int j = 0; j < cityweatherinfo.mWeatherAlertInfoList.size(); j++) {
				WeatherAlertInfo weatheralertinfo = (WeatherAlertInfo) cityweatherinfo.mWeatherAlertInfoList
						.get(j);
				String s = (new StringBuilder())
						.append(weatheralertinfo.mEndTime).append("|")
						.append(weatheralertinfo.mAlertDescription).append("|")
						.append(weatheralertinfo.mAlertIconId).append("|")
						.append(weatheralertinfo.mAlertDetailInfo).append("|")
						.append(weatheralertinfo.mAlertUrl).toString();
				editor.putString((new StringBuilder()).append("Item").append(i)
						.append("EarlyWarningContents").append(j + 1)
						.toString(), s);
			}

		}
		editor.commit();
		return true;
	}

	public static void saveCurrentCityIndex(int i) {
		if ((sCurrentCityIndex == null || !sCurrentCityIndex.equals(Integer
				.valueOf(i)))
				&& sSharedPreferences.edit().putInt("LastForceCityIndex", i)
						.commit())
			sCurrentCityIndex = Integer.valueOf(i);
	}

	public static void saveCurrentSkinDir(String s) {
		if ((sCurrentSkinDir == null || !sCurrentSkinDir.equals(s))
				&& sSharedPreferences.edit().putString("SkinDirectory", s)
						.commit())
			sCurrentSkinDir = s;
	}

	public static void saveCustomLoaderName(String s, int i) {
		android.content.SharedPreferences.Editor editor = sSharedPreferences
				.edit();
		editor.putString((new StringBuilder()).append("CustomLoaderName")
				.append(i).toString(), s);
		editor.commit();
	}

	public static void saveCustomLoaderValue(String s, int i) {
		android.content.SharedPreferences.Editor editor = sSharedPreferences
				.edit();
		editor.putString((new StringBuilder()).append("CustomLoaderValue")
				.append(i).toString(), s);
		editor.commit();
	}

	public static void saveGpsLocationState(boolean flag) {
		if ((sIsGPSLocationOpen == null || !sIsGPSLocationOpen.equals(Boolean
				.valueOf(flag)))
				&& sSharedPreferences.edit()
						.putBoolean("CheckBox_Gps_Location", flag).commit())
			sIsGPSLocationOpen = Boolean.valueOf(flag);
	}

	public static void saveHotAreaCustomLoaderName(String s, int i, String s1) {
		android.content.SharedPreferences.Editor editor = sSharedPreferences
				.edit();
		editor.putString(
				(new StringBuilder()).append("W").append(s1)
						.append("CustomHotAreLoaderName").append(i).toString(),
				s);
		editor.commit();
	}

	public static void saveHotAreaCustomLoaderValue(String s, int i, String s1) {
		android.content.SharedPreferences.Editor editor = sSharedPreferences
				.edit();
		editor.putString(
				(new StringBuilder()).append("W").append(s1)
						.append("CustomHotAreLoaderValue").append(i).toString(),
				s);
		editor.commit();
	}

	public static void saveHuangLiDBVersion(int i) {
		if ((sHuangLiDBVersion == null || !sHuangLiDBVersion.equals(Integer
				.valueOf(i)))
				&& sSharedPreferences.edit().putInt("huangli_DB_Version", i)
						.commit())
			sHuangLiDBVersion = Integer.valueOf(i);
	}

	public static void saveIsFirstRun(boolean flag) {
		if ((sIsFirstRun == null || !sIsFirstRun.equals(Boolean.valueOf(flag)))
				&& sSharedPreferences.edit().putBoolean("is_first_login", flag)
						.commit())
			sIsFirstRun = Boolean.valueOf(flag);
	}

	public static void saveIsFirstTestInSkin(boolean flag) {
		if ((sIsFirstTestInSkin == null || !sIsFirstTestInSkin.equals(Boolean
				.valueOf(flag)))
				&& sSharedPreferences.edit()
						.putBoolean("is_first_test_inskin", flag).commit())
			sIsFirstTestInSkin = Boolean.valueOf(flag);
	}

	public static void saveKindNoticeDate(String s) {
		if ((sKindNoticeDate == null || !sKindNoticeDate.equals(s))
				&& sSharedPreferences.edit().putString("kind_notice_date", s)
						.commit())
			sKindNoticeDate = s;
	}

	public static void saveLastAutoVoiceTime(String s) {
		if ((sLastAutoVoiceTime == null || !sLastAutoVoiceTime.equals(s))
				&& sDefaultSharedPreferences.edit()
						.putString("LastAutoVoicePlay", s).commit())
			sLastAutoVoiceTime = s;
	}

	public static void saveLastSuccessShareDate(String s) {
		if ((sLastSuccessShareDate == null || !sLastSuccessShareDate.equals(s))
				&& sSharedPreferences.edit()
						.putString("LastSuccessShareDate", s).commit())
			sLastSuccessShareDate = s;
	}

	public static void saveLastTryShareDate(String s) {
		if ((sLastTryShareDate == null || !sLastTryShareDate.equals(s))
				&& sSharedPreferences.edit().putString("LastTryShareDate", s)
						.commit())
			sLastTryShareDate = s;
	}

	public static void saveMustUpdateUrl(String s) {
		if ((sMustUpdateUrl == null || !sMustUpdateUrl.equals(s))
				&& sSharedPreferences.edit().putString("must_update_url", s)
						.commit())
			sMustUpdateUrl = s;
	}

	public static void saveNotifyVoiceDataUpdate(boolean flag) {
		if ((sIsNotifyVoiceDataUpdate == null || !sIsNotifyVoiceDataUpdate
				.equals(Boolean.valueOf(flag)))
				&& sSharedPreferences.edit()
						.putBoolean("VoiceDataUpdateNotify", flag).commit())
			sIsNotifyVoiceDataUpdate = Boolean.valueOf(flag);
	}

	public static void saveOldPartnerID(String s) {
		if ((sPartnerID == null || !sPartnerID.equals(s))
				&& sSharedPreferences.edit().putString("PartnerID", s).commit())
			sPartnerID = s;
	}

	public static void saveRandomMinutes(int i) {
		if ((sRandomMinutes == null || !sRandomMinutes.equals(Integer
				.valueOf(i)))
				&& sSharedPreferences.edit().putInt("RandomNumber", i).commit())
			sRandomMinutes = Integer.valueOf(i);
	}

	public static void saveRegCode(String s) {
		if ((sRegCode == null || !sRegCode.equals(s))
				&& sSharedPreferences.edit().putString("UserRegisterdCode", s)
						.commit())
			sRegCode = s;
	}

	public static void saveRelink(boolean flag) {
		if ((sRelink == null || !sIsNotifyVoiceDataUpdate.equals(Boolean
				.valueOf(flag)))
				&& sSharedPreferences.edit()
						.putBoolean("CDNUpdateRelink", flag).commit())
			sRelink = Boolean.valueOf(flag);
	}

	public static void saveSharePersonalRegards(String s) {
		if ((sPersonalRegards == null || !sPersonalRegards.equals(s))
				&& sSharedPreferences.edit()
						.putString("share_personal_regards", s).commit())
			sPersonalRegards = s;
	}

	public static void saveShowWifiWarning(boolean flag) {
		if ((sShowWifiWarning == null || !sShowWifiWarning.equals(Boolean
				.valueOf(flag)))
				&& sSharedPreferences.edit().putBoolean("ShowWifiWaring", flag)
						.commit())
			sShowWifiWarning = Boolean.valueOf(flag);
	}

	public static void saveSkinApkInstalled(boolean flag) {
		if ((sSkinApkInstalled == null || !sSkinApkInstalled.equals(Boolean
				.valueOf(flag)))
				&& sSharedPreferences.edit()
						.putBoolean("skin_apk_installed", flag).commit())
			sSkinApkInstalled = Boolean.valueOf(flag);
	}

	public static void saveSkinApks(String s) {
		if ((sSkinApks == null || !sSkinApks.equals(s))
				&& sSharedPreferences.edit().putString("SkinApks", s).commit())
			sSkinApks = s;
	}

	public static void saveStatRetryCount(int i) {
		if ((sStatRetryCount == null || !sStatRetryCount.equals(Integer
				.valueOf(i)))
				&& sSharedPreferences.edit().putInt("StatRetryTime", i)
						.commit())
			sStatRetryCount = Integer.valueOf(i);
	}

	public static void saveStatSentTime(long l) {
		if ((sStatSentTime == null || !sStatSentTime.equals(Long.valueOf(l)))
				&& sSharedPreferences.edit().putLong("StatSendTime", l)
						.commit())
			sStatSentTime = Long.valueOf(l);
	}

	public static void saveStatsCount(String s, int i) {
		android.content.SharedPreferences.Editor editor = sSharedPreferences
				.edit();
		editor.putInt(s, i);
		editor.commit();
	}

	public static void saveUpdateEndTime(String s) {
		if ((sUpdateEndTime == null || !sUpdateEndTime.equals(s))
				&& sSharedPreferences.edit().putString("EndUpdateTime", s)
						.commit())
			sUpdateEndTime = s;
	}

	public static void saveUpdateFailedCount(int i) {
		if ((sShareUpdateFailCount == null || !sWidgetUseBackground
				.equals(Integer.valueOf(i)))
				&& sDefaultSharedPreferences.edit()
						.putInt("UpdateFailedCount", i).commit())
			sShareUpdateFailCount = Integer.valueOf(i);
	}

	public static void saveUpdateImageSuccessTime() {
		sDefaultSharedPreferences
				.edit()
				.putLong("ad_update_image_success_time",
						System.currentTimeMillis()).commit();
		updateSuccessTime = null;
	}

	public static void saveUpdateInterval(float f) {
		if ((sUpdateInterval == null || !sUpdateInterval.equals(Float
				.valueOf(f)))
				&& sSharedPreferences.edit().putFloat("UpdaterIntervalTime", f)
						.commit())
			sUpdateInterval = Float.valueOf(f);
	}

	public static void saveUpdateStartTime(String s) {
		if ((sUpdateStartTime == null || !sUpdateStartTime.equals(s))
				&& sSharedPreferences.edit().putString("StartUpdateTime", s)
						.commit())
			sUpdateStartTime = s;
	}

	public static void saveW4x1InUse(boolean flag) {
		if ((sW4x1IsInUse == null || !sW4x1IsInUse
				.equals(Boolean.valueOf(flag)))
				&& sSharedPreferences.edit().putBoolean("UseWidget4x1", flag)
						.commit())
			sW4x1IsInUse = Boolean.valueOf(flag);
	}

	public static void saveW4x2InUse(boolean flag) {
		if ((sW4x2IsInUse == null || !sW4x2IsInUse
				.equals(Boolean.valueOf(flag)))
				&& sSharedPreferences.edit().putBoolean("UseWidget4x2", flag)
						.commit())
			sW4x2IsInUse = Boolean.valueOf(flag);
	}

	public static void saveWidgetUseBackground(int i) {
		if ((sWidgetUseBackground == null || !sWidgetUseBackground
				.equals(Integer.valueOf(i)))
				&& sSharedPreferences.edit().putInt("WidgetUseBackground", i)
						.commit())
			sWidgetUseBackground = Integer.valueOf(i);
	}

	public static void setChangedCity(boolean flag) {
		sIsCityChanged = flag;
	}

	public static void setCurrentSkin4x1(SkinInfo skininfo) {
		sCurrentSkin4x1 = skininfo;
	}

	public static void setCurrentSkin4x2(SkinInfo skininfo) {
		sCurrentSkin4x2 = skininfo;
	}

	public static void setDownloadListInvalid(boolean flag) {
		sDownloadListInvalid = flag;
	}

	public static void setFavoriteDate(int i, int j, String s) {
		if (favoriteDate == null || !favoriteDate.equals(s))
			if (!sSharedPreferences
					.edit()
					.putString(
							(new StringBuilder()).append("key_favorite_date_")
									.append(i).append("_").append(j).toString(),
							s).commit())
				;
	}

	public static void setHandler(Handler handler) {
		sHandler = handler;
	}

	public static void setHighPriorityDialogIsOpen(boolean flag) {
		sHighPriorityDialogIsOpen = flag;
	}

	public static void setIsLocationbyGPS(boolean flag) {
		isLocationbyGPS = flag;
	}

	public static void setLifeImgDate(String s) {
		sSharedPreferences.edit().putString("key_life_img_date", s).commit();
	}

	public static void setLifeInfoDate(int i, String s, String s1) {
		sSharedPreferences
				.edit()
				.putString(
						(new StringBuilder()).append("key_life_info_date_")
								.append(s).append("_").append(i).toString(), s1)
				.commit();
	}

	public static void setNeedNotifyTrendState(boolean flag) {
		sNeedNotifyTrendCityChanged = flag;
	}

	private static void setScreenTypeStringAndIntValue() {
		Display display = ((WindowManager) Ct().getSystemService("window"))
				.getDefaultDisplay();
		int i = display.getWidth();
		int j = display.getHeight();
		if (i > j)
			sScreenTypeString = (new StringBuilder()).append(j).append("*")
					.append(i).toString();
		else
			sScreenTypeString = (new StringBuilder()).append(i).append("*")
					.append(j).toString();
		sScreenTypeIntValue = Integer.valueOf(SkinInfo.getScreeType(i, j)
				.ordinal());
	}

	public void onCreate() {
		super.onCreate();
		init(getApplicationContext());
	}

	private static final String DATABASE_VERSION = "100";
	private static final String IS_NOTIFY_VOICE_DATA_UPDATE = "VoiceDataUpdateNotify";
	public static final String KEY_AUTO_SHARE_CITY = "share_city_list_preference";
	public static final String KEY_AUTO_SHARE_TYPE = "share_type_list_preference";
	public static final String KEY_FAVORITE_DATE = "key_favorite_date";
	public static final String KEY_LIFE_IMG_DATE = "key_life_img_date";
	public static final String KEY_LIFE_INFO_DATE = "key_life_info_date";
	public static final String KEY_MANUAL_SHARE_TYPE = "share_manual_type_list_preference";
	public static final String KEY_SHARE_FORCAST_DAY = "share_days_list_preference";
	public static final String KEY_SHARE_PERSONAL_REGARDS = "share_personal_regards";
	private static final String LAST_SUCCESS_SHARE_DATE = "LastSuccessShareDate";
	private static final String LAST_TRY_SHARE_DATE = "LastTryShareDate";
	private static final String PREFE_SHARE_UPDATE_FAIL_COUNT = "UpdateFailedCount";
	private static final String PREF_AD_APK_DOWNLOAD_TIME = "ad_apk_downlaod_time";
	private static final String PREF_AD_UPDATE_IMAGE_SUCCESS_TIME = "ad_update_image_success_time";
	public static final String PREF_ALARM_ONLY_WORKING_DAY = "alarm_only_working_day";
	public static final String PREF_ALERT_NOTIFICATION_ENABLE = "alert_checkbox_notification";
	public static final String PREF_AUTO_SHARE = "share_checkbox_preference";
	public static final String PREF_AUTO_UPDATE = "checkbox_preference";
	private static final String PREF_AUTO_UPDATE_FAIL_COUNT = "auto_update_fail_count";
	private static final String PREF_CDN_RELINK = "CDNUpdateRelink";
	private static final String PREF_CDN_SECRET = "CDNSecret";
	public static final String PREF_CLOCK_ANIMATION_ENABLE = "clock_animation";
	public static final String PREF_CLOCK_ANIMATION_ITEMS = "clock_animation_items";
	private static final String PREF_CURRENT_CITY = "LastForceCityIndex";
	private static final String PREF_CURRENT_SKIN_DIR = "SkinDirectory";
	public static final String PREF_ENABLE_AUTO_VOICE = "EnableAutoVoicePlay";
	private static final String PREF_FILE_NAME = "mojiWeatherInfo";
	public static final String PREF_GPS_LOACATION_ENABLE = "CheckBox_Gps_Location";
	private static final String PREF_HUANGLI_DATABASE_VERSION = "huangli_DB_Version";
	private static final String PREF_IS_FIRST_LOGIN = "is_first_login";
	private static final String PREF_IS_FIRST_TEST_INSKIN = "is_first_test_inskin";
	private static final String PREF_KIND_NOTICE_DATE = "kind_notice_date";
	private static final String PREF_LAST_AUTO_VOICE_TIME = "LastAutoVoicePlay";
	private static final String PREF_MUST_UPDATE_URL = "must_update_url";
	public static final String PREF_NOTIFICATION_BY_SOUND = "checkbox_voice";
	public static final String PREF_NOTIFICATION_BY_VIBRATE = "checkbox_shake";
	public static final String PREF_NOTIFICATION_ENABLE = "checkbox_notification";
	private static final String PREF_PARTNER_ID = "PartnerID";
	private static final String PREF_RANDOM_MINUTES = "RandomNumber";
	private static final String PREF_REG_CODE = "UserRegisterdCode";
	public static final String PREF_SET_AUTO_VOICE_TIME = "setautotime";
	private static final String PREF_SHOW_WIFI_WARNING = "ShowWifiWaring";
	private static final String PREF_SKIN_APKS = "SkinApks";
	private static final String PREF_SKIN_APK_INSTALLED = "skin_apk_installed";
	private static final String PREF_STAT_RETRY_COUNT = "StatRetryTime";
	private static final String PREF_STAT_SENT_TIME = "StatSendTime";
	private static final String PREF_UMENG = "umeng";
	private static final String PREF_UPDATE_END_TIME = "EndUpdateTime";
	private static final String PREF_UPDATE_INTERVAL = "UpdaterIntervalTime";
	private static final String PREF_UPDATE_START_TIME = "StartUpdateTime";
	private static final String PREF_W4X1_IN_USE = "UseWidget4x1";
	private static final String PREF_W4X2_IN_USE = "UseWidget4x2";
	public static final float SKIN_TOOL_VER = 3F;
	private static final String TAG = "Gl";
	private static final String VERSION = "21005";
	private static final String VersionType = "1";
	private static final String WIDGET_USE_BACKGROUND = "WidgetUseBackground";
	public static String adUpdateSuccessTime = null;
	private static Long apkDownloadTime = null;
	private static String favoriteDate = null;
	private static String imgDate = null;
	private static String infoDate = null;
	private static boolean isLocationbyGPS;
	private static Boolean sAdON = null;
	private static Boolean sAlarmOnlyWorkingDay = null;
	private static Boolean sAutoShare = null;
	private static Integer sAutoShareCity = null;
	private static String sAutoShareType = null;
	private static Boolean sAutoUpdate = null;
	private static Integer sAutoUpdateFailCount = null;
	private static Boolean sAutoVoicePlay = null;
	private static String sAutoVoiceTime = null;
	private static String sCDNSecret = null;
	private static Integer sClockAnimationItem = null;
	private static Context sContext;
	private static Integer sCurrentCityIndex = null;
	private static SkinInfo sCurrentSkin4x1 = null;
	private static SkinInfo sCurrentSkin4x2 = null;
	private static String sCurrentSkinDir = null;
	private static SharedPreferences sDefaultSharedPreferences;
	private static boolean sDownloadListInvalid;
	private static Handler sHandler;
	private static boolean sHighPriorityDialogIsOpen;
	private static Integer sHuangLiDBVersion = null;
	private static Boolean sIsAlertNotificationEnable = null;
	private static boolean sIsCityChanged;
	private static Boolean sIsClockAimationEnable = null;
	private static Boolean sIsFirstRun = null;
	private static Boolean sIsFirstTestInSkin = null;
	private static Boolean sIsGPSLocationOpen = null;
	private static Boolean sIsNoticedBySound = null;
	private static Boolean sIsNoticedByVibrate = null;
	private static Boolean sIsNotificationEnable = null;
	private static Boolean sIsNotifyVoiceDataUpdate = null;
	private static String sKindNoticeDate = null;
	private static String sLastAutoVoiceTime = null;
	private static String sLastSuccessShareDate = null;
	private static String sLastTryShareDate = null;
	private static String sManualShareType = null;
	private static String sMustUpdateUrl = null;
	private static boolean sNeedNotifyTrendCityChanged;
	private static String sPartnerID = null;
	private static String sPersonalRegards = null;
	private static Integer sRandomMinutes = null;
	private static String sRegCode = null;
	private static Boolean sRelink = null;
	private static Integer sScreenTypeIntValue = null;
	private static String sScreenTypeString = null;
	private static Integer sShareForcastDays = null;
	private static Integer sShareUpdateFailCount = null;
	private static SharedPreferences sSharedPreferences;
	private static Boolean sShowWifiWarning = null;
	private static Boolean sSkinApkInstalled = null;
	private static String sSkinApks = null;
	private static Integer sStatRetryCount = null;
	private static Long sStatSentTime = null;
	private static String sUpdateEndTime = null;
	private static Float sUpdateInterval = null;
	private static String sUpdateStartTime = null;
	private static Boolean sW4x1IsInUse = null;
	private static Boolean sW4x2IsInUse = null;
	private static Integer sWidgetUseBackground = null;
	private static Long updateSuccessTime = null;

}
