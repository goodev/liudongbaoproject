package org.mymoney.ui.navtrans;

import org.mymoney.ui.base.BaseActivity;
import org.mymoney.ui.widget.Panel;
import org.mymoney.ui.widget.Panel.OnPanelListener;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;

import org.mymoney.R;

public class NavTransactionActivity extends BaseActivity implements
		View.OnClickListener, AdapterView.OnItemClickListener,
		AdapterView.OnItemLongClickListener,
		RadioGroup.OnCheckedChangeListener, OnPanelListener {

	public static final int DAY = 3;
	public static final String END_TIME = "endTime";
	public static final String MODE = "mode";
	public static final int MONTH = 1;
	public static final String START_TIME = "startTime";
	public static final String TITLE = "title";
	public static final int WEEK = 2;
	public static final int YEAR = 0;
	private long endTime = 0L;
	private boolean isOpenMenu = false;
	private Panel menu_pn = null;

	private long startTime = 0L;
	private String title = "";

	@Override
	public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt) {

	}

	@Override
	public void onClick(View paramView) {
		switch (paramView.getId()) {
		case R.id.title_btn:
			break;
		case R.id.back_btn:
			this.finish();
			break;
		case R.id.titlebar_right_btn:
			isOpenMenu = !isOpenMenu;
			menu_pn.setOpen(isOpenMenu, true);
			break;
		}

	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.nav_trans_activity);
		Bundle bundle = this.getIntent().getExtras();
		startTime = bundle.getLong(START_TIME);
		endTime = bundle.getLong(END_TIME);
		title = bundle.getString(TITLE);
		Button title_btn = (Button) findViewById(R.id.title_btn);
		title_btn.setOnClickListener(this);
		title_btn.setText(title);
		Button back_btn = (Button) findViewById(R.id.back_btn);
		back_btn.setOnClickListener(this);
		Button titlebar_right_btn = (Button) findViewById(R.id.titlebar_right_btn);
		titlebar_right_btn.setOnClickListener(this);
		menu_pn = (Panel) findViewById(R.id.menu_pn);
		menu_pn.setOnPanelListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu paramMenu) {
		getMenuInflater().inflate(R.menu.nav_expense_activity_menu,
				paramMenu);
		return super.onCreateOptionsMenu(paramMenu);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
		return super.onOptionsItemSelected(paramMenuItem);

	}

	@Override
	public void onPanelClosed(Panel panel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPanelOpened(Panel panel) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onRestoreInstanceState(Bundle paramBundle) {
		super.onRestoreInstanceState(paramBundle);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
}
