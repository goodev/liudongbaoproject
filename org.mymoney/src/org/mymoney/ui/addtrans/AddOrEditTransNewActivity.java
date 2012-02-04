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


public class AddOrEditTransNewActivity extends BaseActivity implements
		View.OnClickListener {
	@Override
	protected void onActivityResult(int paramInt1, int paramInt2,
			Intent paramIntent) {
		super.onActivityResult(paramInt1, paramInt2, paramIntent);

	}

	@Override
	public void onClick(View paramView) {

	}

	@Override
	protected void onCreate(Bundle paramBundle) {

		super.onCreate(paramBundle);

		setContentView(R.layout.add_or_edit_trans_activity);

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
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return super.onKeyDown(keyCode, event);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);

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
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
      super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
      super.onSaveInstanceState(outState);
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
