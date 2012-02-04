package org.mymoney.ui.transfer;

import org.mymoney.R;
import org.mymoney.ui.base.BaseActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;


public class TransferActivity extends BaseActivity implements
		View.OnClickListener, View.OnFocusChangeListener,
		AdapterView.OnItemSelectedListener {

	protected void onActivityResult(int paramInt1, int paramInt2,
			Intent paramIntent) {
		super.onActivityResult(paramInt1, paramInt2, paramIntent);
	}

	public void onClick(View paramView) {

	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.transfer_activity);

	}

	protected Dialog onCreateDialog(int paramInt) {
		return super.onCreateDialog(paramInt);
	}

	public boolean onCreateOptionsMenu(Menu paramMenu) {
		getMenuInflater().inflate(R.menu.transfer_activity_menu,
				paramMenu);
		return super.onCreateOptionsMenu(paramMenu);
	}

	public void onFocusChange(View paramView, boolean paramBoolean) {

	}

	public void onItemSelected(AdapterView paramAdapterView, View paramView,
			int paramInt, long paramLong) {

	}

	public void onNothingSelected(AdapterView paramAdapterView) {
	}

	public boolean onOptionsItemSelected(MenuItem paramMenuItem) {

		return super.onOptionsItemSelected(paramMenuItem);

	}
}
