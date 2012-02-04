package org.mymoney.core.application;

import android.app.Application;
import android.content.res.Configuration;

public class ApplicationContext extends Application {

	@Override
	public void onConfigurationChanged(Configuration paramConfiguration) {

	}

	@Override
	public void onCreate() {

	}

	@Override
	public void onLowMemory() {

	}

	@Override
	public void onTerminate() {

		super.onTerminate();
	}
}
