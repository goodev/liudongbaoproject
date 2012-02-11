package com.hellogame;

import android.os.Bundle;
import android.util.Log;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.android.AndroidApplication;

public class MainActivity extends AndroidApplication {

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		String ApplicationListener = getIntent().getExtras().getString(
				"ApplicationListener");
		try {
			initialize((ApplicationListener) Class.forName(ApplicationListener)
					.newInstance(), false);
		} catch (Exception e) {
			e.printStackTrace();
			Log.e(null, e.getMessage(), e);
		}
	}
}