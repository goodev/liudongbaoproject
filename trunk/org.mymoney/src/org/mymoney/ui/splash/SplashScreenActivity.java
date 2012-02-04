package org.mymoney.ui.splash;

import org.mymoney.ui.base.BaseActivity;
import org.mymoney.ui.main.MainActivity;

import org.mymoney.R;
import android.os.Bundle;
import android.os.Handler;


public class SplashScreenActivity extends BaseActivity {
	public class EnterMainAppThread implements Runnable {

		private SplashScreenActivity activity = null;

		public EnterMainAppThread(SplashScreenActivity activity) {
			this.activity = activity;
		}

		public void run() {
			activity.enterMainApp();
		}
	}
	public static long delayTime = 1500L;//ms

	private Handler hander = new Handler();

	private void enterMainApp() {
		startActivity(this, MainActivity.class);
		finish();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mymoney.ui.base.BaseActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen_activity);
		EnterMainAppThread thread = new EnterMainAppThread(this);
		hander.postDelayed(thread, SplashScreenActivity.delayTime);
	}
}
