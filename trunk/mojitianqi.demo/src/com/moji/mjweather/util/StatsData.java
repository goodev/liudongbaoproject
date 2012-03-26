// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StatsData.java

package com.moji.mjweather.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class StatsData {
	private class AdStats {

		void reset() {
			mClick = 0;
			mView = 0;
			mDown = 0;
		}

		private int mClick;
		private int mDown;
		private String mPub;
		private int mView;

		/*
		 * static int access$402(AdStats adstats, int i) { adstats.mClick = i;
		 * return i; }
		 */

		/*
		 * static int access$408(AdStats adstats) { int i = adstats.mClick;
		 * adstats.mClick = i + 1; return i; }
		 */

		/*
		 * static int access$502(AdStats adstats, int i) { adstats.mView = i;
		 * return i; }
		 */

		/*
		 * static int access$508(AdStats adstats) { int i = adstats.mView;
		 * adstats.mView = i + 1; return i; }
		 */

		/*
		 * static int access$602(AdStats adstats, int i) { adstats.mDown = i;
		 * return i; }
		 */

		/*
		 * static int access$608(AdStats adstats) { int i = adstats.mDown;
		 * adstats.mDown = i + 1; return i; }
		 */

		private AdStats() {

			super();
			mPub = "umeng";
		}

	}

	private class CityStats {

		private int mCityID;
		private int mCityQC;

		/*
		 * static int access$308(CityStats citystats) { int i =
		 * citystats.mCityQC; citystats.mCityQC = i + 1; return i; }
		 */

		/*
		 * static int access$312(CityStats citystats, int i) { int j = i +
		 * citystats.mCityQC; citystats.mCityQC = j; return j; }
		 */

		private CityStats(int i, int j) {

			super();
			mCityID = i;
			mCityQC = j;
		}

	}

	public StatsData() {
		saveNowTime();
		mCounts = new ArrayList();

		mPvs = new ArrayList();

		mSwitchers = new ArrayList();

		mCitys = new ArrayList();
		mAd = new AdStats();
	}

	private int getMatchCityIdx(int i, StatsData statsdata) {
		return 0;
	}

	private void mergeAd(StatsData statsdata) {
		setAdView(getAdView() + statsdata.getAdView());
		setAdClick(getAdClick() + statsdata.getAdClick());
		setAdDown(getAdDown() + statsdata.getAdDown());
	}

	private void saveNowTime() {
		mDate = (new SimpleDateFormat("yyyy/MM/dd")).format(new Date(System
				.currentTimeMillis()));
	}

	public void addNewCity(int i, int j) {
		mCitys.add(new CityStats(i, j));
	}

	public int getAdClick() {
		return mAd.mClick;
	}

	public int getAdDown() {
		return mAd.mDown;
	}

	public String getAdPub() {
		return mAd.mPub;
	}

	public int getAdView() {
		return mAd.mView;
	}

	public int getCityID(int i) {
		return ((CityStats) mCitys.get(i)).mCityID;
	}

	public int getCityQC(int i) {
		return ((CityStats) mCitys.get(i)).mCityQC;
	}

	public void mergeData(StatsData statsdata) {

	}

	public void resetData() {
		mCounts.clear();
		mSwitchers.clear();
		mPvs.clear();
		mCitys.clear();
		mAd.reset();
		mDate = "";
	}

	public void setAdClick(int i) {
		mAd.mClick = i;
	}

	public void setAdDown(int i) {
		mAd.mDown = i;
	}

	public void setAdView(int i) {
		mAd.mView = i;
	}

	public void setCountValue(StatsUtil.StatsCount statscount, Integer integer) {
		int i = 0;
		mCounts.set(i, integer);
	}

	public void setPvValue(StatsUtil.StatsPv statspv, Integer integer) {
		int i = 0;
		mPvs.set(i, integer);
	}

	public void setSwitcherValue(StatsUtil.StatsSwitcher statsswitcher, int i) {
		int j = 0;
		mSwitchers.set(j, Integer.valueOf(i));
	}

	public void updateAdClick() {
		int i = 0;
	}

	public void updateAdDown() {
		int i = 0;
	}

	public void updateAdView() {
		int i = 0;
	}

	public void updateCityQC(int i) {
	}

	public void updateCountValue(StatsUtil.StatsCount statscount) {

	}

	public void updatePvValue(StatsUtil.StatsPv statspv) {

	}

	private static final int ERR_NOTFOUND = -1;
	private static final String TIME_FORMAT = "yyyy/MM/dd";
	public AdStats mAd;
	public ArrayList mCitys;
	public ArrayList mCounts;
	public String mDate;
	public ArrayList mPvs;
	public ArrayList mSwitchers;
}
