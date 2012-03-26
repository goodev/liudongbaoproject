// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WeatherDataParser.java

package com.moji.mjweather.common;

import android.util.Xml;
import com.moji.mjweather.data.*;
import com.moji.mjweather.util.UiUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.moji.mjweather.common:
//            MojiLog, WeatherAlert

public final class WeatherDataParser {
	private static final String TAG = "WeatherDataParser";
	private static final String XML_TAG_CITY = "ct";
	private static final String XML_TAG_CITYS = "cts";
	private static final String XML_TAG_CITY_ID = "id";
	private static final String XML_TAG_CITY_NAME = "nm";
	private static final String XML_TAG_CREAL = "cc";
	private static final String XML_TAG_DATE = "date";
	private static final String XML_TAG_DESC = "desc";
	private static final String XML_TAG_DL = "dl";
	private static final String XML_TAG_DOW = "dow";
	private static final String XML_TAG_DT = "dt";
	private static final String XML_TAG_DW = "dw";
	private static final String XML_TAG_ET = "et";
	private static final String XML_TAG_FORECAST = "fc";
	private static final String XML_TAG_FTV = "ftv";
	private static final String XML_TAG_GDT = "gdt";
	private static final String XML_TAG_HTMP = "htmp";
	private static final String XML_TAG_HUM = "hum";
	private static final String XML_TAG_HWD = "hwd";
	private static final String XML_TAG_HWDIR = "hwdir";
	private static final String XML_TAG_HWID = "hwid";
	private static final String XML_TAG_HWL = "hwl";
	private static final String XML_TAG_ICON = "icon";
	private static final String XML_TAG_INFO = "info";
	private static final String XML_TAG_KN = "kn";
	private static final String XML_TAG_LDT = "ldt";
	private static final String XML_TAG_LTMP = "ltmp";
	private static final String XML_TAG_LWD = "lwd";
	private static final String XML_TAG_LWDIR = "lwdir";
	private static final String XML_TAG_LWID = "lwid";
	private static final String XML_TAG_LWL = "lwl";
	private static final String XML_TAG_PAGE_ID = "id";
	private static final String XML_TAG_PT = "pt";
	private static final String XML_TAG_SR = "sr";
	private static final String XML_TAG_SS = "ss";
	private static final String XML_TAG_TMP = "tmp";
	private static final String XML_TAG_TREND_DAY = "day";
	private static final String XML_TAG_UPT = "upt";
	private static final String XML_TAG_URL = "url";
	private static final String XML_TAG_UV = "uvidx";
	private static final String XML_TAG_VER = "ver";
	private static final String XML_TAG_WD = "wd";
	private static final String XML_TAG_WDIR = "wdir";
	private static final String XML_TAG_WID = "wid";
	private static final String XML_TAG_WL = "wl";
	private static final String XML_TAG_WR = "wr";

	public WeatherDataParser() {
	}

	public static boolean parse(InputStream inputstream,
			CityWeatherInfo cityweatherinfo) {
		WeatherMainInfo weathermaininfo;
		List list;
		List list1;
		List list2;
		weathermaininfo = cityweatherinfo.mWeatherMainInfo;
		list = cityweatherinfo.mWeatherAlertInfoList;
		list1 = cityweatherinfo.mWeatherTrendInfoList;
		list2 = cityweatherinfo.mWeatherDayDetailInfoList;
		XmlPullParser xmlpullparser;

		WeatherDayDetailInfo weatherdaydetailinfo;
		WeatherTrendInfo weathertrendinfo;
		WeatherAlertInfo weatheralertinfo;
		ForecastInfo forecastinfo;
		xmlpullparser = Xml.newPullParser();
		int eventType = 0;
		try {
			xmlpullparser.setInput(inputstream, "utf-8");
			eventType = xmlpullparser.getEventType();
		} catch (XmlPullParserException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		weatherdaydetailinfo = null;
		weathertrendinfo = null;
		weatheralertinfo = null;
		forecastinfo = null;
		boolean flag = true;
		WeatherDayDetailInfo weatherdaydetailinfo1;
		WeatherTrendInfo weathertrendinfo1;
		WeatherAlertInfo weatheralertinfo1;
		ForecastInfo forecastinfo1;
		while (eventType != XmlPullParser.END_DOCUMENT) {

			if (eventType == XmlPullParser.START_DOCUMENT) {

			} else if (eventType == XmlPullParser.END_DOCUMENT) {
				return flag;
			} else if (eventType == XmlPullParser.START_TAG) {
				if (!"wr".equals(xmlpullparser.getName())) {
					if (!"cts".equals(xmlpullparser.getName())) {

						if (!"ct".equals(xmlpullparser.getName())) {
							if (!"cc".equals(xmlpullparser.getName())) {

								if (!"fc".equals(xmlpullparser.getName()))
									continue;
								forecastinfo1 = new ForecastInfo();
								if (xmlpullparser.getAttributeValue(null, "id") != null
										&& xmlpullparser.getAttributeValue(
												null, "id").length() > 0)
									forecastinfo1.mId = Integer
											.parseInt(xmlpullparser
													.getAttributeValue(null,
															"id"));
								if (xmlpullparser
										.getAttributeValue(null, "dow") != null
										&& xmlpullparser.getAttributeValue(
												null, "dow").length() > 0)
									forecastinfo1.mWeek = Integer
											.parseInt(xmlpullparser
													.getAttributeValue(null,
															"dow"));
								if (xmlpullparser.getAttributeValue(null,
										"htmp") != null
										&& xmlpullparser.getAttributeValue(
												null, "htmp").length() > 0)
									forecastinfo1.mHighTemperature = Integer
											.parseInt(xmlpullparser
													.getAttributeValue(null,
															"htmp"));
								if (xmlpullparser.getAttributeValue(null,
										"ltmp") != null
										&& xmlpullparser.getAttributeValue(
												null, "ltmp").length() > 0)
									forecastinfo1.mLowTemperature = Integer
											.parseInt(xmlpullparser
													.getAttributeValue(null,
															"ltmp"));
								if (xmlpullparser.getAttributeValue(null,
										"ltmp") != null
										&& xmlpullparser.getAttributeValue(
												null, "ltmp").length() > 0)
									forecastinfo1.mWeatherIconId = Integer
											.parseInt(xmlpullparser
													.getAttributeValue(null,
															"wid"));
								forecastinfo1.mIsEmpty = false;
								weatherdaydetailinfo1 = weatherdaydetailinfo;
								weathertrendinfo1 = weathertrendinfo;
								weatheralertinfo1 = weatheralertinfo;
							}

							else

							{
								weathermaininfo.mSolarUpdateDate = xmlpullparser
										.getAttributeValue(null, "gdt");
								weathermaininfo.mLunarUpdateDate = xmlpullparser
										.getAttributeValue(null, "ldt");
								weathermaininfo.mLunarUpdateDate = weathermaininfo.mLunarUpdateDate
										.replace("\u5E74\u4E00\u6708",
												"\u5E74\u6B63\u6708");
								weathermaininfo.mLunarUpdateDate = weathermaininfo.mLunarUpdateDate
										.replace("\u5341\u4E00\u6708",
												"\u51AC\u6708");
								weathermaininfo.mLunarUpdateDate = weathermaininfo.mLunarUpdateDate
										.replace("\u5341\u4E8C\u6708",
												"\u814A\u6708");
								weathermaininfo.mLastUpdateTime = xmlpullparser
										.getAttributeValue(null, "upt");
								if (xmlpullparser
										.getAttributeValue(null, "tmp") != null
										&& xmlpullparser.getAttributeValue(
												null, "tmp").length() > 0)
									weathermaininfo.mCurrentTemperature = Integer
											.parseInt(xmlpullparser
													.getAttributeValue(null,
															"tmp"));
								else
									weathermaininfo.mIsSpecCity = true;
								if (xmlpullparser.getAttributeValue(null,
										"htmp") != null
										&& xmlpullparser.getAttributeValue(
												null, "htmp").length() > 0)
									weathermaininfo.mHighTemperature = Integer
											.parseInt(xmlpullparser
													.getAttributeValue(null,
															"htmp"));
								if (xmlpullparser.getAttributeValue(null,
										"ltmp") != null
										&& xmlpullparser.getAttributeValue(
												null, "ltmp").length() > 0)
									weathermaininfo.mLowTemperature = Integer
											.parseInt(xmlpullparser
													.getAttributeValue(null,
															"ltmp"));
								weathermaininfo.mWeatherDescription = xmlpullparser
										.getAttributeValue(null, "wd");
								if (xmlpullparser
										.getAttributeValue(null, "wid") != null
										&& xmlpullparser.getAttributeValue(
												null, "wid").length() > 0)
									weathermaininfo.mWeatherId = Integer
											.parseInt(xmlpullparser
													.getAttributeValue(null,
															"wid"));
								weathermaininfo.mWindSpeed = xmlpullparser
										.getAttributeValue(null, "wl");
								weathermaininfo.mWindDirection = xmlpullparser
										.getAttributeValue(null, "wdir");
								weathermaininfo.mUV = xmlpullparser
										.getAttributeValue(null, "uvidx");
								if (xmlpullparser
										.getAttributeValue(null, "hum") != null
										&& xmlpullparser.getAttributeValue(
												null, "hum").length() > 0)
									weathermaininfo.mHumidity = Float
											.parseFloat(xmlpullparser
													.getAttributeValue(null,
															"hum"));
								if (xmlpullparser.getAttributeValue(null, "dl") != null
										&& xmlpullparser.getAttributeValue(
												null, "dl").length() > 0)
									weathermaininfo.mDaylight = Integer
											.parseInt(xmlpullparser
													.getAttributeValue(null,
															"dl"));
								if (xmlpullparser.getAttributeValue(null, "sr") != null)
									weathermaininfo.mSunRise = xmlpullparser
											.getAttributeValue(null, "sr");
								if (xmlpullparser.getAttributeValue(null, "ss") != null)
									weathermaininfo.mSunSet = xmlpullparser
											.getAttributeValue(null, "ss");
								weathermaininfo.mIsEmpty = false;
								weatherdaydetailinfo1 = weatherdaydetailinfo;
								weathertrendinfo1 = weathertrendinfo;
								weatheralertinfo1 = weatheralertinfo;
								forecastinfo1 = forecastinfo;
							}
						} else {

							weathermaininfo.mCityId = Integer
									.parseInt(xmlpullparser.getAttributeValue(
											null, "id"));
							weathermaininfo.mCityName = xmlpullparser
									.getAttributeValue(null, "nm");
							weatherdaydetailinfo1 = weatherdaydetailinfo;
							weathertrendinfo1 = weathertrendinfo;
							weatheralertinfo1 = weatheralertinfo;
							forecastinfo1 = forecastinfo;
						}
					} else {
						weatherdaydetailinfo1 = weatherdaydetailinfo;
						weathertrendinfo1 = weathertrendinfo;
						weatheralertinfo1 = weatheralertinfo;
						forecastinfo1 = forecastinfo;
					}
				} else {
					if (xmlpullparser.getAttributeValue(null, "ver") == null
							|| xmlpullparser.getAttributeValue(null, "ver")
									.length() <= 0)
						continue;
					else {
						weathermaininfo.mUiFormatVersion = xmlpullparser
								.getAttributeValue(null, "ver");
						weatherdaydetailinfo1 = weatherdaydetailinfo;
						weathertrendinfo1 = weathertrendinfo;
						weatheralertinfo1 = weatheralertinfo;
						forecastinfo1 = forecastinfo;
					}
				}

				if (!"dt".equals(xmlpullparser.getName()))
					continue;
				weatherdaydetailinfo1 = new WeatherDayDetailInfo();
				if (xmlpullparser.getAttributeValue(null, "id") != null
						&& xmlpullparser.getAttributeValue(null, "id").length() > 0)
					weatherdaydetailinfo1.mId = Integer.parseInt(xmlpullparser
							.getAttributeValue(null, "id"));
				if (xmlpullparser.getAttributeValue(null, "dow") != null
						&& xmlpullparser.getAttributeValue(null, "dow")
								.length() > 0)
					weatherdaydetailinfo1.mWeek = Integer
							.parseInt(xmlpullparser.getAttributeValue(null,
									"dow"));
				weatherdaydetailinfo1.mDate = xmlpullparser.getAttributeValue(
						null, "date");
				weatherdaydetailinfo1.mKind = xmlpullparser.getAttributeValue(
						null, "kn");
				weatherdaydetailinfo1.mWindSpeed = xmlpullparser
						.getAttributeValue(null, "wl");
				weatherdaydetailinfo1.mWindDirection = xmlpullparser
						.getAttributeValue(null, "wdir");
				if (xmlpullparser.getAttributeValue(null, "hwid") != null
						&& xmlpullparser.getAttributeValue(null, "hwid")
								.length() > 0)
					weatherdaydetailinfo1.mHighWeatherIconId = Integer
							.parseInt(xmlpullparser.getAttributeValue(null,
									"hwid"));
				if (xmlpullparser.getAttributeValue(null, "lwid") != null
						&& xmlpullparser.getAttributeValue(null, "lwid")
								.length() > 0)
					weatherdaydetailinfo1.mLowWeatherIconId = Integer
							.parseInt(xmlpullparser.getAttributeValue(null,
									"lwid"));
				if (xmlpullparser.getAttributeValue(null, "htmp") != null
						&& xmlpullparser.getAttributeValue(null, "htmp")
								.length() > 0)
					weatherdaydetailinfo1.mHighTemperature = Integer
							.parseInt(xmlpullparser.getAttributeValue(null,
									"htmp"));
				if (xmlpullparser.getAttributeValue(null, "ltmp") != null
						&& xmlpullparser.getAttributeValue(null, "ltmp")
								.length() > 0)
					weatherdaydetailinfo1.mLowTemperature = Integer
							.parseInt(xmlpullparser.getAttributeValue(null,
									"ltmp"));
				weatherdaydetailinfo1.mHighWeatherDescription = xmlpullparser
						.getAttributeValue(null, "hwd");
				weatherdaydetailinfo1.mLowWeatherDescription = xmlpullparser
						.getAttributeValue(null, "lwd");
				weatherdaydetailinfo1.mFestival = xmlpullparser
						.getAttributeValue(null, "ftv");
				weatherdaydetailinfo1.mSunRise = xmlpullparser
						.getAttributeValue(null, "sr");
				weatherdaydetailinfo1.mSunSet = xmlpullparser
						.getAttributeValue(null, "ss");
				weatherdaydetailinfo1.mIsEmpty = false;
				weathertrendinfo1 = weathertrendinfo;
				weatheralertinfo1 = weatheralertinfo;
				forecastinfo1 = forecastinfo;

				if (!"day".equals(xmlpullparser.getName()))
					continue;
				weathertrendinfo1 = new WeatherTrendInfo();
				if (xmlpullparser.getAttributeValue(null, "id") != null
						&& xmlpullparser.getAttributeValue(null, "id").length() > 0)
					weathertrendinfo1.mId = Integer.parseInt(xmlpullparser
							.getAttributeValue(null, "id"));
				if (xmlpullparser.getAttributeValue(null, "dow") != null
						&& xmlpullparser.getAttributeValue(null, "dow")
								.length() > 0)
					weathertrendinfo1.mWeek = Integer.parseInt(xmlpullparser
							.getAttributeValue(null, "dow"));
				weathertrendinfo1.mDate = xmlpullparser.getAttributeValue(null,
						"date");
				if (xmlpullparser.getAttributeValue(null, "hwid") != null
						&& xmlpullparser.getAttributeValue(null, "hwid")
								.length() > 0)
					weathertrendinfo1.mHightWeatherID = Integer
							.parseInt(xmlpullparser.getAttributeValue(null,
									"hwid"));
				if (xmlpullparser.getAttributeValue(null, "lwid") != null
						&& xmlpullparser.getAttributeValue(null, "lwid")
								.length() > 0)
					weathertrendinfo1.mLowWeatherID = Integer
							.parseInt(xmlpullparser.getAttributeValue(null,
									"lwid"));
				weathertrendinfo1.mHighTempDes = xmlpullparser
						.getAttributeValue(null, "hwd");
				weathertrendinfo1.mLowTempDes = xmlpullparser
						.getAttributeValue(null, "lwd");
				if (xmlpullparser.getAttributeValue(null, "htmp") != null
						&& xmlpullparser.getAttributeValue(null, "htmp")
								.length() > 0)
					weathertrendinfo1.mHighTemperature = Integer
							.parseInt(xmlpullparser.getAttributeValue(null,
									"htmp"));
				if (xmlpullparser.getAttributeValue(null, "ltmp") != null
						&& xmlpullparser.getAttributeValue(null, "ltmp")
								.length() > 0)
					weathertrendinfo1.mLowTemperature = Integer
							.parseInt(xmlpullparser.getAttributeValue(null,
									"ltmp"));
				weathertrendinfo1.mHighTempWindSpeed = xmlpullparser
						.getAttributeValue(null, "hwl");
				weathertrendinfo1.mLowTempWindSpeed = xmlpullparser
						.getAttributeValue(null, "lwl");
				weathertrendinfo1.mHighTempWindDirection = xmlpullparser
						.getAttributeValue(null, "hwdir");
				weathertrendinfo1.mLowTempWindDirection = xmlpullparser
						.getAttributeValue(null, "lwdir");
				weathertrendinfo1.mIsEmpty = false;
				weatherdaydetailinfo1 = weatherdaydetailinfo;
				weatheralertinfo1 = weatheralertinfo;
				forecastinfo1 = forecastinfo;
				if ("dw".equals(xmlpullparser.getName())) {
					weatheralertinfo1 = new WeatherAlertInfo();
					weatheralertinfo1.mPublicTime = xmlpullparser
							.getAttributeValue(null, "pt");
					weatheralertinfo1.mEndTime = xmlpullparser
							.getAttributeValue(null, "et");
					weatheralertinfo1.mAlertDescription = xmlpullparser
							.getAttributeValue(null, "desc");
					weatheralertinfo1.mAlertIconId = xmlpullparser
							.getAttributeValue(null, "icon");
					weatheralertinfo1.mAlertDetailInfo = xmlpullparser
							.getAttributeValue(null, "info");
					weatheralertinfo1.mAlertUrl = xmlpullparser
							.getAttributeValue(null, "url");
					weatherdaydetailinfo1 = weatherdaydetailinfo;
					weathertrendinfo1 = weathertrendinfo;
					forecastinfo1 = forecastinfo;
					continue;
				}

				{
					if ("fc".equals(xmlpullparser.getName())) {
						weathermaininfo.mForecastInfoList.add(forecastinfo);
						forecastinfo1 = null;
						weatherdaydetailinfo1 = weatherdaydetailinfo;
						weathertrendinfo1 = weathertrendinfo;
						weatheralertinfo1 = weatheralertinfo;
					} else if ("dt".equals(xmlpullparser.getName())) {
						list2.add(weatherdaydetailinfo);
						weatherdaydetailinfo1 = null;
						weathertrendinfo1 = weathertrendinfo;
						weatheralertinfo1 = weatheralertinfo;
						forecastinfo1 = forecastinfo;
					} else {
						if (!"day".equals(xmlpullparser.getName()))
							continue;
						list1.add(weathertrendinfo);
						weathertrendinfo1 = null;
						weatherdaydetailinfo1 = weatherdaydetailinfo;
						weatheralertinfo1 = weatheralertinfo;
						forecastinfo1 = forecastinfo;
					}

				}
				if ("dw".equals(xmlpullparser.getName()))
					if (!WeatherAlert.needClose(weatheralertinfo.mEndTime)
							&& UiUtil
									.canFindAlertResource(weatheralertinfo.mAlertIconId))
						list.add(weatheralertinfo);
				weatheralertinfo1 = null;
				weatherdaydetailinfo1 = weatherdaydetailinfo;
				weathertrendinfo1 = weathertrendinfo;
				forecastinfo1 = forecastinfo;
				continue;
			} else if (eventType == XmlPullParser.END_TAG) {

			} else if (eventType == XmlPullParser.TEXT) {

			}
			try {
				eventType = xmlpullparser.next();
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;

	}

}
