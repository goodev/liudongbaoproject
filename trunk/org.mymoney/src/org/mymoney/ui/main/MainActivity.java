package org.mymoney.ui.main;


import org.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import org.mymoney.ui.base.BaseActivity;
import org.mymoney.ui.budget.BudgetActivity;
import org.mymoney.ui.navtrans.NavTransactionActivity;
import org.mymoney.ui.navtrans.NavYearTransactionActivity;
import org.mymoney.ui.report.ReportActivity;
import org.mymoney.ui.setting.SettingAccountActivity;
import org.mymoney.ui.setting.SettingActivity;
import org.mymoney.ui.transfer.TransferActivity;
import org.mymoney.ui.widget.BatteryView;
import org.mymoney.util.DateHelper;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.mymoney.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {
	private Button add_expense_quickly_btn = null;
	private BatteryView budget_status_bv = null;
	private LinearLayout month_expense_ly = null;
	private RelativeLayout month_row_rl = null;
	private Button nav_account_btn = null;
	private Button nav_budget_btn = null;
	private Button nav_report_btn = null;
	private Button nav_setting_btn = null;
	private Button nav_yeartrans_btn = null;
	private String tag = MainActivity.class.getSimpleName();
	private RelativeLayout today_row_rl = null;

	private RelativeLayout week_row_rl = null;

	@Override
	public void onClick(View v) {
		Log.v(tag, "v.getId=" + v.getId());
		switch (v.getId()) {
		case R.id.add_expense_quickly_btn:
			startAddOrEditTransNewActivity();
			return;
		case R.id.month_expense_ly:
			startNavTransactionActivity(DateHelper.startTimeOfMonth(),
					DateHelper.endTimeOfMonth(), "流水清单-本月",
					NavTransactionActivity.MONTH);
			return;
		case R.id.budget_status_bv:

			startBudgetActivity();
			return;
		case R.id.today_row_rl:
			startNavTransactionActivity(DateHelper.startTimeOfDay(),
					DateHelper.endTimeOfDay(), "流水清单-按天",
					NavTransactionActivity.DAY);
			return;
		case R.id.week_row_rl:

			startNavTransactionActivity(DateHelper.startTimeOfWeek(),
					DateHelper.endTimeOfWeek(), "流水清单-按周",
					NavTransactionActivity.WEEK);
			return;
		case R.id.month_row_rl:

			startNavTransactionActivity(DateHelper.startTimeOfMonth(),
					DateHelper.endTimeOfMonth(), "流水清单-按月",
					NavTransactionActivity.MONTH);
			return;
		case R.id.nav_add_expense_btn:
			startAddOrEditTransNewActivity();
			return;
		case R.id.nav_yeartrans_btn:
			startNavYearTransactionActivity();
			return;
		case R.id.nav_account_btn:
			startSettingAccountActivity();
			return;
		case R.id.nav_report_btn:
			startReportActivity();
			return;
		case R.id.nav_budget_btn:
			startBudgetActivity();
			return;
		case R.id.nav_setting_btn:
			startSettingActivity();
			return;
		default:
			return;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mymoney.ui.base.BaseActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		add_expense_quickly_btn = (Button) this
				.findViewById(R.id.add_expense_quickly_btn);
		add_expense_quickly_btn.setOnClickListener(this);
		month_expense_ly = (LinearLayout) this
				.findViewById(R.id.month_expense_ly);
		month_expense_ly.setOnClickListener(this);
		budget_status_bv = (BatteryView) this
				.findViewById(R.id.budget_status_bv);
		budget_status_bv.setOnClickListener(this);
		today_row_rl = (RelativeLayout) this.findViewById(R.id.today_row_rl);
		today_row_rl.setOnClickListener(this);
		week_row_rl = (RelativeLayout) this.findViewById(R.id.week_row_rl);
		week_row_rl.setOnClickListener(this);
		month_row_rl = (RelativeLayout) this.findViewById(R.id.month_row_rl);
		month_row_rl.setOnClickListener(this);
		nav_yeartrans_btn = (Button) this.findViewById(R.id.nav_yeartrans_btn);
		nav_yeartrans_btn.setOnClickListener(this);
		nav_account_btn = (Button) this.findViewById(R.id.nav_account_btn);
		nav_account_btn.setOnClickListener(this);
		nav_report_btn = (Button) this.findViewById(R.id.nav_report_btn);
		nav_report_btn.setOnClickListener(this);
		nav_budget_btn = (Button) this.findViewById(R.id.nav_budget_btn);
		nav_budget_btn.setOnClickListener(this);
		nav_setting_btn = (Button) this.findViewById(R.id.nav_setting_btn);
		nav_setting_btn.setOnClickListener(this);
		TextView month_tv = (TextView) this.findViewById(R.id.month_tv);
		month_tv.setText("8");
		TextView income_amount_tv = (TextView) this
				.findViewById(R.id.income_amount_tv);
		income_amount_tv.setText("20");
		TextView expense_amount_tv = (TextView) this
				.findViewById(R.id.expense_amount_tv);
		expense_amount_tv.setText("123");
		TextView budget_balance_amount_tv = (TextView) this
				.findViewById(R.id.budget_balance_amount_tv);
		budget_balance_amount_tv.setText("2877");

		TextView date_of_month_tv = (TextView) this
				.findViewById(R.id.date_of_month_tv);
		date_of_month_tv.setText("1");
		TextView today_datestr_tv = (TextView) this
				.findViewById(R.id.today_datestr_tv);
		today_datestr_tv.setText(DateHelper.toDay(DateHelper.startTimeOfDay()));
		TextView today_expense_amount_tv = (TextView) this
				.findViewById(R.id.today_expense_amount_tv);
		today_expense_amount_tv.setText("-100");
		TextView today_income_amount_tv = (TextView) this
				.findViewById(R.id.today_income_amount_tv);
		today_income_amount_tv.setText("+20");

		TextView week_datestr_tv = (TextView) this
				.findViewById(R.id.week_datestr_tv);
		week_datestr_tv.setText(DateHelper.toMonthDay(DateHelper
				.startTimeOfWeek())
				+ "-"
				+ DateHelper.toMonthDay(DateHelper.endTimeOfWeek()));
		TextView week_expense_amount_tv = (TextView) this
				.findViewById(R.id.week_expense_amount_tv);
		week_expense_amount_tv.setText("-123");
		TextView week_income_amount_tv = (TextView) this
				.findViewById(R.id.week_income_amount_tv);
		week_income_amount_tv.setText("+20");

		TextView month_datestr_tv = (TextView) this
				.findViewById(R.id.month_datestr_tv);
		month_datestr_tv.setText(DateHelper.toMonthDay(DateHelper
				.startTimeOfMonth())
				+ "-"
				+ DateHelper.toMonthDay(DateHelper.endTimeOfMonth()));
		TextView month_expense_amount_tv = (TextView) this
				.findViewById(R.id.month_expense_amount_tv);
		month_expense_amount_tv.setText("-123");
		TextView month_income_amount_tv = (TextView) this
				.findViewById(R.id.month_income_amount_tv);
		month_income_amount_tv.setText("+20");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateDialog(int)
	 */
	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		return super.onCreateDialog(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_activity_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		default:
		case R.id.add_expense_menu:
			this.startAddOrEditTransNewActivity();
			break;
		case R.id.add_income_menu:
			this.startAddOrEditTransNewActivity();
			break;
		case R.id.transfer_menu:
			this.startTransferActivity();
			break;
		case R.id.go_account_menu:
			this.startSettingAccountActivity();
			break;
		case R.id.go_report_menu:
			this.startReportActivity();
			break;
		case R.id.go_budget_menu:
			this.startBudgetActivity();
			break;
		case R.id.go_sync_menu:
			break;
		case R.id.go_setting_menu:
			this.startSettingActivity();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mymoney.ui.base.BaseActivity#onPause()
	 */
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mymoney.ui.base.BaseActivity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mymoney.ui.base.BaseActivity#onStart()
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mymoney.ui.base.BaseActivity#onStop()
	 */
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	private void startAddOrEditTransNewActivity() {
		this.startActivity(getApplicationContext(),
				AddOrEditTransNewActivity.class);

	}

	private void startBudgetActivity() {
		this.startActivity(getApplicationContext(), BudgetActivity.class);

	}

	private void startNavTransactionActivity(long startTime, long endTime,
			String title, int mode) {
		Intent intent = new Intent(this.getApplicationContext(),
				NavTransactionActivity.class);
		intent.putExtra(NavTransactionActivity.START_TIME, startTime);
		intent.putExtra(NavTransactionActivity.END_TIME, endTime);
		intent.putExtra(NavTransactionActivity.TITLE, title);
		intent.putExtra(NavTransactionActivity.MODE, mode);
		startActivity(intent);
	}

	private void startNavYearTransactionActivity() {
		Intent intent = new Intent(this.getApplicationContext(),
				NavYearTransactionActivity.class);
		intent.putExtra(NavYearTransactionActivity.START_TIME,
				DateHelper.startTimeOfYear());
		intent.putExtra(NavYearTransactionActivity.END_TIME,
				DateHelper.endTimeOfYear());
		intent.putExtra(NavYearTransactionActivity.TITLE, "2011年度流水");

		this.startActivity(intent);

	}

	private void startReportActivity() {
		this.startActivity(getApplicationContext(), ReportActivity.class);

	}

	private void startSettingAccountActivity() {
		Context localContext = getApplicationContext();
		Intent localIntent1 = new Intent(localContext,
				SettingAccountActivity.class);
		localIntent1.putExtra("from", 1);
		startActivity(localIntent1);
	}

	private void startSettingActivity() {
		this.startActivity(getApplicationContext(), SettingActivity.class);

	}

	private void startTransferActivity() {
		this.startActivity(getApplicationContext(), TransferActivity.class);

	}
}
