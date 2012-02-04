package org.mymoney.ui.report;

import org.mymoney.R;
import org.mymoney.ui.base.BaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;


public class ReportActivity extends BaseActivity implements
		View.OnClickListener, AdapterView.OnItemClickListener,
		RadioGroup.OnCheckedChangeListener {

	protected void onActivityResult(int paramInt1, int paramInt2,
			Intent paramIntent) {
		super.onActivityResult(paramInt1, paramInt2, paramIntent);
	}

	public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt) {

	}

	public void onClick(View paramView) {
		switch (paramView.getId()) {

		case 2131230807:
			finish();
			return;
		default:
			return;
		}
	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView( R.layout.report_activity);
	}

	public boolean onCreateOptionsMenu(Menu paramMenu) {
		getMenuInflater().inflate(2131623942, paramMenu);
		return super.onCreateOptionsMenu(paramMenu);
	}

	protected void onDestroy() {
		super.onDestroy();

	}

	public void onItemClick(AdapterView paramAdapterView, View paramView,
			int paramInt, long paramLong) {
	}

	public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
		return super.onKeyDown(paramInt, paramKeyEvent);
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

	protected void onRestoreInstanceState(Bundle paramBundle) {
	}

	protected void onResume() {
		super.onResume();
	}

	protected void onSaveInstanceState(Bundle paramBundle) {
		super.onSaveInstanceState(paramBundle);
	}

	protected void onStart() {
		super.onStart();
	}

	protected void onStop() {
		super.onStop();
	}
}
