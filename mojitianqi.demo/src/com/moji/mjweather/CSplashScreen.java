// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CSplashScreen.java

package com.moji.mjweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.moji.mjweather.activity.TabSelectorActivity;

public class CSplashScreen extends Activity {
	class AnimationModel {

		public void overridePendingTransition(int i, int j) {
			context.overridePendingTransition(i, j);
		}

		private Activity context;

		public AnimationModel(Activity activity) {
			super();
			context = activity;
		}
	}

	public CSplashScreen() {
		splashHandler = new Handler() {

			public void handleMessage(Message message) {
				if (message.what == 0) {
					goPastSplash();
				}
				return;
			}

			
		};
	}

	private void goPastSplash() {
		Intent intent = new Intent(this, TabSelectorActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString("intent", "CSplashScreen");
		intent.putExtras(bundle);
		startActivity(intent);
		if (android.os.Build.VERSION.SDK_INT > 4)
			(new AnimationModel(this)).overridePendingTransition(0x7f040008,
					0x7f040024);
		finish();
	}

	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		requestWindowFeature(1);
		//UiUtil.saveStatusBarHeight(this);
		getWindow().setFormat(-2);
		setContentView(R.layout.layout_splash);
		((ImageView) findViewById(0x7f0d01ac)).setImageResource(0x7f02012e);
		Message message = new Message();
		message.what = 0;
		splashHandler.sendMessageDelayed(message, 1000L);
	}

	private static final long SPLASH_TIME_DELAY = 1000L;
	private static final int STOP_SPLASH = 0;
	private static final String TAG = "CSplashScreen";
	private Handler splashHandler;

}
