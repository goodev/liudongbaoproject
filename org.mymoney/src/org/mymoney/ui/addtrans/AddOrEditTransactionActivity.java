package org.mymoney.ui.addtrans;

import org.mymoney.R;
import org.mymoney.ui.base.BaseActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;


public class AddOrEditTransactionActivity extends BaseActivity implements
		View.OnClickListener, AdapterView.OnItemSelectedListener,
		RadioGroup.OnCheckedChangeListener {
	@Override
	protected void onActivityResult(int paramInt1, int paramInt2,
			Intent paramIntent) {
		super.onActivityResult(paramInt1, paramInt2, paramIntent);

	}

	@Override
	public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt) {

	}

	@Override
	public void onClick(View paramView) {

	}

	@Override
	protected void onCreate(Bundle paramBundle) {

		super.onCreate(paramBundle);

		setContentView(R.layout.add_or_edit_expense_activity);

	}

	@Override
	protected Dialog onCreateDialog(int paramInt) {
		return null;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu paramMenu) {
		boolean bool = super.onCreateOptionsMenu(paramMenu);
		return bool;

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onItemSelected(AdapterView paramAdapterView, View paramView,
			int paramInt, long paramLong) {

	}

	@Override
	public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
		return false;

	}

	@Override
	public void onNothingSelected(AdapterView paramAdapterView) {
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
		return false;

	}

	@Override
	protected void onPause() {

		super.onPause();
	}

	@Override
	protected void onRestart() {

		super.onRestart();
	}

	@Override
	protected void onRestoreInstanceState(Bundle paramBundle) {

	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onSaveInstanceState(Bundle paramBundle) {

	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}
}
