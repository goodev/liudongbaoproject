// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TabSelectorActivity.java

package com.moji.mjweather.activity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import android.app.TabActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.Toast;

import com.moji.mjweather.CDialogManager;
import com.moji.mjweather.Gl;
import com.moji.mjweather.R;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.common.WeatherAlert;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.common.WeatherTabPublisher;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.service.StatsService;
import com.moji.mjweather.service.WeatherUpdateService;
import com.moji.mjweather.util.ShareMicroBlogUtil;
import com.moji.mjweather.util.StatsUtil;
import com.moji.mjweather.util.UiUtil;
import com.moji.mjweather.util.Util;
import com.moji.mjweather.widgetskin.SkinSelector;

// Referenced classes of package com.moji.mjweather.activity:
//            WeatherMainActivity, WeatherTrendActivity, WeatherIndexActivity, WeatherToolsActivity, 
//            WeatherSettingActivity, HuangLiActivity

public class TabSelectorActivity extends TabActivity implements
		android.widget.RadioGroup.OnCheckedChangeListener {

	public TabSelectorActivity() {
		isExit = false;
		mCurrentCityIndex = 44;
	}

	private void checkMore() {
		WeatherAlert.cancelAllAlertNotifications();
		Gl.setHighPriorityDialogIsOpen(false);
		if (!Gl.getMustUpdateUrl().equals("")) {
			getDlgMgr().showUrlDialog(getString(0x7f0b017d),
					Gl.getMustUpdateUrl());
			Gl.setHighPriorityDialogIsOpen(true);
		}
		if (!Gl.getHighPriorityDialogIsOpen())
			checkNewVersionOrPushInfo(true);
		if (!Gl.getHighPriorityDialogIsOpen())
			checkNewVersionOrPushInfo(false);
	}

	private void checkNewVersionOrPushInfo(boolean flag) {
		FileInputStream fileinputstream;
		Map map;
		String s;
		String s1 = null;
		File file;
		String s2 = null;
		if (flag)
			s = "newversion.xml";
		else
			s = "pushinfo.xml";
		if (flag)
			s1 = "supd";
		else
			s1 = "adv";
		file = Gl.Ct().getFileStreamPath(s);
		if (file == null || !file.exists())
			return;
		fileinputstream = null;
		try {
			fileinputstream = Gl.Ct().openFileInput(s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map = Util.parseNewVersionOrPushInfo(fileinputstream, s1);
		if (map.size() > 0)
			s2 = (String) map.get("info");
		if (s2 != null && !s2.equals(""))
			if (!flag) {

				getDlgMgr().showUrlDialog((String) map.get("info"),
						(String) map.get("url"));

				Gl.setHighPriorityDialogIsOpen(true);
			} else
				getDlgMgr().showNewVersionDialog((String) map.get("info"),
						0x7f0b001d, map);

		Gl.Ct().deleteFile(s);

	}

	private void forTest() {
		if (StatsUtil.isDevelopMode())
			startService(new Intent(this, StatsService.class));
	}

	private CDialogManager getDlgMgr() {
		if (mDialogManager == null)
			mDialogManager = new CDialogManager(this, null);
		return mDialogManager;
	}

	private void showManualShareListDialog() {
		CityWeatherInfo cityweatherinfo;
		String s;
		int i = Gl.getCurrentCityIndex();
		StatsUtil
				.updateStatsCount(com.moji.mjweather.util.StatsUtil.StatsCount.COUNT_SS);
		cityweatherinfo = WeatherData.getCityInfo(i);
		s = WeatherData.getCityWeatherDescription(Gl.getCurrentCityIndex(), Gl
				.getShareForecastDays().intValue(), false);
		if (cityweatherinfo.mShowType == com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_OK)

		{
			boolean flag = false;
			if (Gl.getManualShareType().equals("1")) {
				flag = UiUtil.savePictureShot(ShareMicroBlogUtil
						.saveCityViewBitmap(this, Gl.getCurrentCityIndex()));
				if (!flag) {
					weatherImageTextShare(s);

				}
			}
			weatherTextShare(s);
			if (Gl.getManualShareType().equals("1") && !flag)
				Toast.makeText(this, getString(0x7f0b01b7), 0).show();

		} else
			getDlgMgr().ShowMsgOKDialog(0x7f0b016e);

	}

	private void startWidgetServiceIfNeeded() {
		 
	}

	private void weatherImageTextShare(String s) {
		Intent intent = new Intent("android.intent.action.SEND");
		intent.putExtra("android.intent.extra.TEXT", s);
		intent.setType("image/*");
		intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(
				getFilesDir(), "screen_shot_to_share.jpg")));
		startActivity(Intent.createChooser(intent,
				getResources().getString(0x7f0b0124)));
	}

	private void weatherTextShare(String s) {
		Intent intent = new Intent("android.intent.action.SEND");
		intent.setType("text/plain");
		intent.putExtra("android.intent.extra.TEXT", s);
		startActivity(Intent.createChooser(intent,
				getResources().getString(0x7f0b0124)));
	}

	public boolean dispatchKeyEvent(KeyEvent keyevent) {
		boolean flag = true;
		if (keyevent.getAction() == 0 && keyevent.getKeyCode() == 4) {
			mCurrentCityIndex = Gl.getCurrentCityIndex();
			mCityInfo = WeatherData.getCityInfo(mCurrentCityIndex);
			if (mCityInfo.mShowType != com.moji.mjweather.data.CityWeatherInfo.ShowType.ST_UPDATING)
				if (isExit) {
					finish();
				} else {
					Toast.makeText(this, getString(0x7f0b003d), 0).show();
					isExit = flag;
				}
		} else {
			flag = false;
		}
		return flag;
	}

	public void onCheckedChanged(RadioGroup radiogroup, int i) {
		isExit = false;
		switch (i) {
		case 2131558831:
			mTabHost.setCurrentTabByTag("tab_weather");
			WeatherTabPublisher.getInstance().publish();
			break;
		case 2131558832:
			mTabHost.setCurrentTabByTag("tab_trend");
			break;
		case 2131558833:
			mTabHost.setCurrentTabByTag("tab_index");
			break;
		case 2131558834:
			mTabHost.setCurrentTabByTag("tab_tools");
			break;
		case 2131558835:
			mTabHost.setCurrentTabByTag("tab_setting");
			break;
		default:
			return;
		}

	}

	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		requestWindowFeature(1);
		getWindow().setFormat(-2);
		getWindow().getDecorView().setBackgroundDrawable(null);
		setContentView(R.layout.layout_tab_selector);
		mTabHost = getTabHost();
		mTabHost.addTab(mTabHost.newTabSpec("tab_weather")
				.setIndicator("tab_weather")
				.setContent(new Intent(this, WeatherMainActivity.class)));
		mTabHost.addTab(mTabHost.newTabSpec("tab_trend")
				.setIndicator("tab_trend")
				.setContent(new Intent(this, WeatherTrendActivity.class)));
		mTabHost.addTab(mTabHost.newTabSpec("tab_index")
				.setIndicator("tab_index")
				.setContent(new Intent(this, WeatherIndexActivity.class)));
		mTabHost.addTab(mTabHost.newTabSpec("tab_tools")
				.setIndicator("tab_tools")
				.setContent(new Intent(this, WeatherToolsActivity.class)));
		mTabHost.addTab(mTabHost.newTabSpec("tab_setting")
				.setIndicator("tab_setting")
				.setContent(new Intent(this, WeatherSettingActivity.class)));
		mRadioGroup = (RadioGroup) findViewById(0x7f0d01ae);
		mRadioGroup.setOnCheckedChangeListener(this);
		if (UiUtil.getStatusBarHeight() == 0)
			UiUtil.saveStatusBarHeight(this);
		checkMore();
		mOldCityIndex = Gl.getCurrentCityIndex();
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		boolean flag = true;
		if (!mTabHost.getCurrentTabTag().equals("tab_tools")
				&& !mTabHost.getCurrentTabTag().equals("tab_setting"))

		{
			menu.add(1, 0, 0, 0x7f0b000d).setIcon(0x7f0200ec);
			menu.add(1, 1, 1, 0x7f0b000e).setIcon(0x7f0200ea);
			menu.add(1, 2, 2, 0x7f0b000f).setIcon(0x7f0200eb);
			if (StatsUtil.isDevelopMode())
				menu.add(1, 3, 3, 0x7f0b0010);
		} else {
			MojiLog.d("TabSelectorActivity",
					"Tools or setting can not display menu");
			flag = false;
		}
		return flag;

	}

	protected void onDestroy() {
		MojiLog.v("TabSelectorActivity", "onDestroy");
		Log.d("TabSelectorActivity", "onDestroy");
		StatsUtil.setNextSendTime(false);
		WeatherUpdateService.setNextUpdateTime();
		super.onDestroy();
	}

	public boolean onOptionsItemSelected(MenuItem menuitem) {
		switch (menuitem.getItemId()) {
		case 0:
			startActivity(new Intent(this, SkinSelector.class));
			break;

		case 1:
			startActivity(new Intent(this, HuangLiActivity.class));
			break;

		case 2:
			showManualShareListDialog();
			break;

		case 3:
			forTest();
			break;
		default:
			return true;
		}
		return true;
	}

	protected void onStop() {
		MojiLog.v("TabSelectorActivity", "onStop");
		Log.d("TabSelectorActivity", "onStop");
		StatsUtil.saveStatsFile();
		startWidgetServiceIfNeeded();
		super.onStop();
	}

	private static final String IMAGET_SHARE_TYPE = "image/*";
	private static final int MENU_GROUP_WEATHER = 1;
	private static final int MENU_ITEM_HUANGLI = 1;
	private static final int MENU_ITEM_SHARE = 2;
	private static final int MENU_ITEM_SKIN = 0;
	private static final int MENU_ITEM_TEST = 3;
	private static final int STATUS_BAR_HEIGHT_NOSET = 0;
	private static final String TAB_INDEX = "tab_index";
	private static final String TAB_SETTING = "tab_setting";
	private static final String TAB_TOOLS = "tab_tools";
	private static final String TAB_TREND = "tab_trend";
	private static final String TAB_WEATHER = "tab_weather";
	private static final String TAG = "TabSelectorActivity";
	private static final String TEXT_SHARE_TPYE = "text/plain";
	private boolean isExit;
	private CityWeatherInfo mCityInfo;
	private int mCurrentCityIndex;
	private CDialogManager mDialogManager;
	private int mOldCityIndex;
	private RadioGroup mRadioGroup;
	private TabHost mTabHost;
}
