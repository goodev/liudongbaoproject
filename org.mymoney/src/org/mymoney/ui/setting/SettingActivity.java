package org.mymoney.ui.setting;

import org.mymoney.R;
import org.mymoney.ui.base.BaseActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;


public class SettingActivity extends BaseActivity implements
		View.OnClickListener, AdapterView.OnItemSelectedListener {

	public void onClick(View paramView) {
		switch (paramView.getId()) {
		default:
			return;
		}
	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.setting_activity);

	}

	protected Dialog onCreateDialog(int paramInt) {

		return super.onCreateDialog(paramInt);

	}

	public boolean onCreateOptionsMenu(Menu paramMenu) {
		getMenuInflater().inflate(2131623944, paramMenu);
		return super.onCreateOptionsMenu(paramMenu);
	}

	protected void onDestroy() {
		super.onDestroy();
	}

	public void onItemSelected(AdapterView paramAdapterView, View paramView,
			int paramInt, long paramLong) {
		int m = paramAdapterView.getId();
	}

	public void onNothingSelected(AdapterView paramAdapterView) {
	}

	public boolean onOptionsItemSelected(MenuItem paramMenuItem) {

		return super.onOptionsItemSelected(paramMenuItem);

	}

	protected void onPause() {
		super.onPause();
	}

	protected void onRestart() {
		super.onRestart();
	}

	protected void onResume() {

		super.onResume();
	}

	protected void onStart() {
		super.onStart();
	}

	protected void onStop() {
		super.onStop();
	}
}
