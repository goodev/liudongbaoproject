// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CityManagerAdapter.java

package com.moji.mjweather.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.*;
import android.widget.*;
import com.moji.mjweather.Gl;
import com.moji.mjweather.activity.CityManagerActivity;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.data.WeatherMainInfo;
import com.moji.mjweather.util.UiUtil;
import com.moji.mjweather.util.Util;
import java.util.List;

public class CityManagerAdapter extends ArrayAdapter {
	private class ViewHolder {

		ImageView ivCityGridBg;
		ImageView ivPlus;
		ImageView ivWeatherImg;
		ProgressBar pbUpdateItem;

		TextView tvCityName;
		TextView tvDescribe;
		TextView tvSyncTime;
		TextView tvTemperature;

	}

	public CityManagerAdapter(Context context, List list) {
		super(context, 0, list);
	}

	private String getDateDiffDesc(CityWeatherInfo cityweatherinfo) {
		String s = Util
				.getDateDiffDescription(cityweatherinfo.m_lastUpdateDate);
		if (s.length() == 0)
			s = cityweatherinfo.m_lastUpdateTime;
		return (new StringBuilder()).append(s)
				.append(Gl.Ct().getResources().getString(0x7f0b004e))
				.toString();
	}

	private void setAllViewGone(ViewHolder viewholder) {
		viewholder.ivWeatherImg.setVisibility(8);
		viewholder.tvDescribe.setVisibility(8);
		viewholder.tvTemperature.setVisibility(8);
		viewholder.tvSyncTime.setVisibility(8);
		viewholder.pbUpdateItem.setVisibility(8);
		viewholder.ivPlus.setVisibility(0);
	}

	private void setFocusBg(ViewHolder viewholder, int i) {
		if (Gl.getCurrentCityIndex() == i)
			viewholder.ivCityGridBg.setBackgroundResource(0x7f02003d);
		else
			viewholder.ivCityGridBg.setBackgroundResource(0x7f02003c);
	}

	private void setNeedUpdateState(ViewHolder viewholder) {
		viewholder.ivWeatherImg.setVisibility(0);
		viewholder.tvCityName.setVisibility(0);
		viewholder.tvSyncTime.setVisibility(0);
		viewholder.pbUpdateItem.setVisibility(8);
		viewholder.tvDescribe.setVisibility(4);
		viewholder.tvTemperature.setVisibility(4);
		viewholder.ivPlus.setVisibility(8);
	}

	private void setOtherViewGone(ViewHolder viewholder) {
		viewholder.ivWeatherImg.setVisibility(0);
		viewholder.tvCityName.setVisibility(0);
		viewholder.tvDescribe.setVisibility(0);
		viewholder.tvTemperature.setVisibility(0);
		viewholder.tvSyncTime.setVisibility(0);
		viewholder.ivPlus.setVisibility(8);
		viewholder.pbUpdateItem.setVisibility(8);
	}

	private void setTextSize(String s, TextView textview) {
		if (s == null)
			s = "";
		if (s.length() < 4)
			textview.setTextSize(18F);
		else if (s.length() < 8)
			textview.setTextSize(13F);
		else
			textview.setTextSize(12F);
		textview.setText(s);
	}

	private void setUpadeViewGone(ViewHolder viewholder) {
		viewholder.tvCityName.setVisibility(0);
		viewholder.tvSyncTime.setVisibility(0);
		viewholder.pbUpdateItem.setVisibility(0);
		viewholder.ivPlus.setVisibility(8);
		viewholder.ivWeatherImg.setVisibility(8);
		viewholder.tvDescribe.setVisibility(4);
		viewholder.tvTemperature.setVisibility(4);
	}

	public int getCount() {
		return CityManagerActivity.getList().size();

	}

	public View getView(int i, View view, ViewGroup viewgroup) {
		ViewHolder viewholder;
		CityWeatherInfo cityweatherinfo;
		if (view == null) {
			viewholder = new ViewHolder();
			view = LayoutInflater.from(getContext()).inflate(0x7f030009, null);
			viewholder.ivWeatherImg = (ImageView) view.findViewById(0x7f0d002f);
			viewholder.tvCityName = (TextView) view.findViewById(0x7f0d0036);
			viewholder.tvDescribe = (TextView) view.findViewById(0x7f0d0031);
			viewholder.tvTemperature = (TextView) view.findViewById(0x7f0d0032);
			viewholder.tvSyncTime = (TextView) view.findViewById(0x7f0d0033);
			viewholder.ivPlus = (ImageView) view.findViewById(0x7f0d0034);
			viewholder.pbUpdateItem = (ProgressBar) view
					.findViewById(0x7f0d0035);
			viewholder.ivCityGridBg = (ImageView) view.findViewById(0x7f0d002e);
			view.setTag(viewholder);
		} else {
			viewholder = (ViewHolder) view.getTag();
		}
		cityweatherinfo = WeatherData.getCityInfo(i);
		if (WeatherData.getCityInfo(i).mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET) {
			if (WeatherData.getCityInfo(i).mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NEED_BE_UPDATE) {
				setNeedUpdateState(viewholder);
				viewholder.ivWeatherImg.setImageResource(0x7f0200f2);
				setTextSize(cityweatherinfo.mCityName, viewholder.tvCityName);
				viewholder.tvSyncTime.setText(0x7f0b004f);
				setFocusBg(viewholder, i);
			} else if (cityweatherinfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK) {
				setOtherViewGone(viewholder);
				viewholder.ivWeatherImg.setImageResource(UiUtil
						.getWeatherIconResouceId(
								cityweatherinfo.mWeatherMainInfo.mWeatherId,
								UiUtil.isDay(WeatherData.getCityInfo(i))));
				setTextSize(cityweatherinfo.mWeatherMainInfo.mCityName,
						viewholder.tvCityName);
				viewholder.tvDescribe
						.setText(cityweatherinfo.mWeatherMainInfo.mWeatherDescription);
				viewholder.tvTemperature
						.setText((new StringBuilder())
								.append(String
										.valueOf(cityweatherinfo.mWeatherMainInfo.mCurrentTemperature))
								.append("\260C").toString());
				viewholder.tvSyncTime.setText(getDateDiffDesc(cityweatherinfo));
				setFocusBg(viewholder, i);
			} else if (cityweatherinfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING) {
				setUpadeViewGone(viewholder);
				setTextSize(cityweatherinfo.mCityName, viewholder.tvCityName);
			}
		}

		else {
			mPlusIndex = i;
			setAllViewGone(viewholder);
			viewholder.tvCityName.setText("");
			viewholder.ivCityGridBg.setBackgroundResource(0x7f02003c);

		}
		if (i == 8
				&& WeatherData.getCityInfo(i).mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_NOSET)
			mPlusIndex = -1;
		return view;
	}

	private static final String TAG = "CityManagerAdapter";
	public static int mPlusIndex;
}
