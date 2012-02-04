package org.mymoney.ui.navtrans;

import org.mymoney.ui.base.BaseActivity;
import org.mymoney.ui.widget.Panel;
import org.mymoney.util.CategoryIconResourcesHelper;
import org.mymoney.util.DateHelper;
import org.mymoney.util.MymoneySQLiteOpenHelper;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.SimpleCursorTreeAdapter;
import android.widget.TextView;

import org.mymoney.R;

public class NavYearTransactionActivity extends BaseActivity implements
		View.OnClickListener, View.OnCreateContextMenuListener,
		ExpandableListView.OnChildClickListener,
		ExpandableListView.OnGroupExpandListener, Panel.OnPanelListener {
	private static final int FILTERACTIVITY_REQUEST_CODE = -100000;

	public class YearTransListAdapter extends SimpleCursorTreeAdapter {

		private NavYearTransactionActivity activity = null;
		private Resources res = null;

		public YearTransListAdapter(NavYearTransactionActivity activity,
				Context context, Cursor cursor, int groupLayout,
				int childLayout, String[] groupFrom, int[] groupTo,
				String[] childFrom, int[] childTo) {
			super(context, cursor, groupLayout, groupLayout, groupFrom,
					groupTo, childLayout, childFrom, childTo);
			this.activity = activity;
			this.res = activity.getResources();
		}

		@Override
		protected void bindChildView(View paramView, Context context,
				Cursor paramCursor, boolean isLastChild) {
			ImageView item_icon_iv = (ImageView) paramView
					.findViewById(R.id.item_icon_iv);
			TextView item_id_tv = (TextView) paramView
					.findViewById(R.id.item_id_tv);
			TextView item_type_tv = (TextView) paramView
					.findViewById(R.id.item_type_tv);
			TextView item_name_tv = (TextView) paramView
					.findViewById(R.id.item_name_tv);
			TextView item_name_tv1 = (TextView) paramView
					.findViewById(R.id.item_name_tv1);
			TextView trade_date_tv = (TextView) paramView
					.findViewById(R.id.trade_date_tv);
			TextView memo_tv = (TextView) paramView.findViewById(R.id.memo_tv);
			TextView cost_tv = (TextView) paramView.findViewById(R.id.cost_tv);
			TextView cost_tv1 = (TextView) paramView
					.findViewById(R.id.cost_tv1);
			TextView currency_cost_tv = (TextView) paramView
					.findViewById(R.id.currency_cost_tv);

			/*
			 * String[] childFrom = { "_id", "iconName", "itemName",
			 * "itemName1", "tradeTime", "memo", "cost", "type",
			 * "isHasCurrencyCost", "currencyCost" };
			 */
			item_icon_iv.setImageResource(CategoryIconResourcesHelper
					.geResId(paramCursor.getString(3)));
			item_id_tv.setText(paramCursor.getString(0));
			int type = paramCursor.getInt(7);
			if (type == 1) {
				item_type_tv.setText("收入");
			} else {
				item_type_tv.setText("支出");
			}
			item_name_tv.setText(paramCursor.getString(1));
			item_name_tv1.setText(paramCursor.getString(2));
			trade_date_tv
					.setText(DateHelper.toMonthDay(paramCursor.getLong(4)));
			memo_tv.setText(paramCursor.getString(5));
			cost_tv.setText(paramCursor.getString(6));
			cost_tv1.setText(paramCursor.getString(6));
			currency_cost_tv.setText(paramCursor.getString(6));
		}

		@Override
		protected void bindGroupView(View paramView, Context context,
				Cursor paramCursor, boolean isExpanded) {
			TextView month_tv = (TextView) paramView
					.findViewById(R.id.month_tv);
			TextView income_amount_tv = (TextView) paramView
					.findViewById(R.id.income_amount_tv);
			TextView payout_amount_tv = (TextView) paramView
					.findViewById(R.id.payout_amount_tv);
			income_amount_tv.setTextColor(res
					.getColor(R.color.transaction_income_amount));
			payout_amount_tv.setTextColor(res
					.getColor(R.color.transaction_payout_amount));
			month_tv.setText(paramCursor.getString(1) + "月");
			income_amount_tv.setText(paramCursor.getString(3));
			payout_amount_tv.setText(paramCursor.getString(2));
		}

		@Override
		protected Cursor getChildrenCursor(Cursor groupCursor) {
			int month = groupCursor.getInt(1);
			Long[] monthRanges = DateHelper.getYearMonthRanges(startTime,
					endTime);
			Long startTimeOfMonth = monthRanges[2 * month - 2];
			Long endTimeOfMonth = monthRanges[2 * month - 1];
			String sql = "SELECT "
					+ "  t_transaction.[transactionPOID] AS _id , "
					+ "  t_category.[name] AS itemName , "
					+ "  t_category.[name] AS itemName1 , "
					+ "  t_category.[_tempIconName] AS iconName , "
					+ "  t_transaction.[tradeTime] AS tradeTime , "
					+ "  t_transaction.[memo] AS memo , "
					+ "  t_transaction.[buyerMoney] AS cost , "
					+ "  t_transaction.type AS type , "
					+ "  0 AS isHasCurrencyCost , "
					+ "  0 AS currencyCost "
					+ "FROM "
					+ "  t_transaction , "
					+ "  t_category "
					+ "WHERE "
					+ "  t_category.[categoryPOID] = t_transaction.[buyerCategoryPOID] AND t_transaction.[tradeTime] > "
					+ startTimeOfMonth
					+ " AND t_transaction.[tradeTime] <  "
					+ endTimeOfMonth
					+ " UNION "
					+ "SELECT "
					+ "  t_transaction.[transactionPOID] AS _id , "
					+ "  t_category.[name] AS itemName , "
					+ "  t_category.[name] AS itemName1 , "
					+ "  t_category.[_tempIconName] AS iconName , "
					+ "  t_transaction.[tradeTime] AS tradeTime , "
					+ "  t_transaction.[memo] AS memo , "
					+ "  t_transaction.[buyerMoney] AS cost , "
					+ "  t_transaction.type AS type , "
					+ "  0 AS isHasCurrencyCost , "
					+ "  0 AS currencyCost "
					+ "FROM "
					+ "  t_transaction , "
					+ "  t_category "
					+ "WHERE "
					+ "  t_category.[categoryPOID] = t_transaction.[sellerCategoryPOID] AND t_transaction.[tradeTime] > "
					+ startTimeOfMonth
					+ " AND t_transaction.[tradeTime] <  "
					+ endTimeOfMonth;
			return sqlLiteOpenhelper.getWritableDatabase().rawQuery(sql, null);
		}

	}

	public class YearTransLoadTask extends AsyncTask<Long, Void, Integer> {
		private NavYearTransactionActivity activity;
		Cursor localCursor = null;

		public YearTransLoadTask(NavYearTransactionActivity activity) {
			this.activity = activity;
		}

		protected Integer doInBackground(Long... array) {
			SQLiteDatabase database = sqlLiteOpenhelper.getWritableDatabase();
			Long[] monthRanges = DateHelper.getYearMonthRanges(array[0],
					array[1]);
			String sql = " SELECT * FROM   ( SELECT"
					+ " t10.month as _id, t10.month   as month  , "
					+ "  t10.payoutAmount as payoutAmount , "
					+ "  t11.incomeAmount as incomeAmount " + "FROM " + "  ( "
					+ "    SELECT " + "      1 AS month , "
					+ "      sum( t.[buyerMoney] ) AS payoutAmount "
					+ "    FROM " + "      MAIN.[t_transaction] t "
					+ "    WHERE " + "      t.[tradeTime] >"
					+ monthRanges[0]
					+ " AND t.[tradeTime] < "
					+ monthRanges[1]
					+ " AND t.type = 0 "
					+ "  ) t10 JOIN "
					+ "  ( "
					+ "    SELECT "
					+ "      1 AS month , "
					+ "      sum( t.[buyerMoney] ) AS incomeAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[0]
					+ " AND t.[tradeTime] < "
					+ monthRanges[1]
					+ " AND t.type = 1 "
					+ "  ) t11 ON t10.month = t11.month "
					+ "UNION "
					+ "SELECT "
					+ "  t20.month as _id,t20.month , "
					+ "  t20.payoutAmount , "
					+ "  t21.incomeAmount "
					+ "FROM "
					+ "  ( "
					+ "    SELECT "
					+ "      2 AS month , "
					+ "      sum( t.[buyerMoney] ) AS payoutAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[2]
					+ " AND t.[tradeTime] < "
					+ monthRanges[3]
					+ " AND t.type = 0 "
					+ "  ) t20 JOIN "
					+ "  ( "
					+ "    SELECT "
					+ "      2 AS month , "
					+ "      sum( t.[buyerMoney] ) AS incomeAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[2]
					+ " AND t.[tradeTime] < "
					+ monthRanges[3]
					+ " AND t.type = 1 "
					+ "  ) t21 ON t20.month = t21.month "
					+ "UNION "
					+ "SELECT "
					+ "  t30.month as _id, t30.month , "
					+ "  t30.payoutAmount , "
					+ "  t31.incomeAmount "
					+ "FROM "
					+ "  ( "
					+ "    SELECT "
					+ "      3 AS month , "
					+ "      sum( t.[buyerMoney] ) AS payoutAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[4]
					+ " AND t.[tradeTime] < "
					+ monthRanges[5]
					+ " AND t.type = 0 "
					+ "  ) t30 JOIN "
					+ "  ( "
					+ "    SELECT "
					+ "      3 AS month , "
					+ "      sum( t.[buyerMoney] ) AS incomeAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[4]
					+ " AND t.[tradeTime] < "
					+ monthRanges[5]
					+ " AND t.type = 1 "
					+ "  ) t31 ON t30.month = t31.month "
					+ "UNION "
					+ "SELECT "
					+ "  t40.month as _id, t40.month , "
					+ "  t40.payoutAmount , "
					+ "  t41.incomeAmount "
					+ "FROM "
					+ "  ( "
					+ "    SELECT "
					+ "      4 AS month , "
					+ "      sum( t.[buyerMoney] ) AS payoutAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[6]
					+ " AND t.[tradeTime] < "
					+ monthRanges[7]
					+ " AND t.type = 0 "
					+ "  ) t40 JOIN "
					+ "  ( "
					+ "    SELECT "
					+ "      4 AS month , "
					+ "      sum( t.[buyerMoney] ) AS incomeAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[6]
					+ " AND t.[tradeTime] < "
					+ monthRanges[7]
					+ " AND t.type = 1 "
					+ "  ) t41 ON t40.month = t41.month "
					+ "UNION "
					+ "SELECT "
					+ "  t50.month as _id, t50.month , "
					+ "  t50.payoutAmount , "
					+ "  t51.incomeAmount "
					+ "FROM "
					+ "  ( "
					+ "    SELECT "
					+ "      5 AS month , "
					+ "      sum( t.[buyerMoney] ) AS payoutAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[8]
					+ " AND t.[tradeTime] < "
					+ monthRanges[9]
					+ " AND t.type = 0 "
					+ "  ) t50 JOIN "
					+ "  ( "
					+ "    SELECT "
					+ "      5 AS month , "
					+ "      sum( t.[buyerMoney] ) AS incomeAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[8]
					+ " AND t.[tradeTime] < "
					+ monthRanges[9]
					+ " AND t.type = 1 "
					+ "  ) t51 ON t50.month = t51.month "
					+ "UNION "
					+ "SELECT "
					+ "   t60.month as _id,t60.month , "
					+ "  t60.payoutAmount , "
					+ "  t61.incomeAmount "
					+ "FROM "
					+ "  ( "
					+ "    SELECT "
					+ "      6 AS month , "
					+ "      sum( t.[buyerMoney] ) AS payoutAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[10]
					+ " AND t.[tradeTime] < "
					+ monthRanges[11]
					+ " AND t.type = 0 "
					+ "  ) t60 JOIN "
					+ "  ( "
					+ "    SELECT "
					+ "      6 AS month , "
					+ "      sum( t.[buyerMoney] ) AS incomeAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[10]
					+ " AND t.[tradeTime] < "
					+ monthRanges[11]
					+ " AND t.type = 1 "
					+ "  ) t61 ON t60.month = t61.month "
					+ "UNION "
					+ "SELECT "
					+ "   t70.month as _id,t70.month , "
					+ "  t70.payoutAmount , "
					+ "  t71.incomeAmount "
					+ "FROM "
					+ "  ( "
					+ "    SELECT "
					+ "      7 AS month , "
					+ "      sum( t.[buyerMoney] ) AS payoutAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[12]
					+ " AND t.[tradeTime] < "
					+ monthRanges[13]
					+ " AND t.type = 0 "
					+ "  ) t70 JOIN "
					+ "  ( "
					+ "    SELECT "
					+ "      7 AS month , "
					+ "      sum( t.[buyerMoney] ) AS incomeAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[12]
					+ " AND t.[tradeTime] < "
					+ monthRanges[13]
					+ " AND t.type = 1 "
					+ "  ) t71 ON t70.month = t71.month "
					+ "UNION "
					+ "SELECT "
					+ "  t80.month as _id, t80.month , "
					+ "  t80.payoutAmount , "
					+ "  t81.incomeAmount "
					+ "FROM "
					+ "  ( "
					+ "    SELECT "
					+ "      8 AS month , "
					+ "      sum( t.[buyerMoney] ) AS payoutAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[14]
					+ " AND t.[tradeTime] < "
					+ monthRanges[15]
					+ " AND t.type = 0 "
					+ "  ) t80 JOIN "
					+ "  ( "
					+ "    SELECT "
					+ "      8 AS month , "
					+ "      sum( t.[buyerMoney] ) AS incomeAmount "
					+ "    FROM "
					+ "      MAIN.[t_transaction] t "
					+ "    WHERE "
					+ "      t.[tradeTime] > "
					+ monthRanges[14]
					+ " AND t.[tradeTime] < "
					+ monthRanges[15]
					+ " AND t.type = 1 "
					+ "  ) t81 ON t80.month = t81.month  )   order by _id desc ";
			localCursor = database.rawQuery(sql, null);
			return localCursor.getCount();
		}

		protected void onPostExecute(Integer paramInteger) {
			String[] groupFrom = { "_id", "month", "incomeAmount",
					"payoutAmount" };
			int[] groupTo = { R.id.month_tv, R.id.month_tv,
					R.id.income_amount_tv, R.id.payout_amount_tv };
			String[] childFrom = { "_id", "iconName", "itemName", "itemName1",
					"tradeTime", "memo", "cost", "type", "isHasCurrencyCost",
					"currencyCost" };
			int[] childTo = { R.id.category_name_tv, R.id.category_icon_iv,
					R.id.category_name_tv, R.id.trade_date_tv, R.id.memo_tv,
					R.id.cost_tv };
			YearTransListAdapter adapter = new YearTransListAdapter(activity,
					activity.getApplicationContext(), localCursor,
					R.layout.simple_year_trans_expandable_group_list_item,
					R.layout.simple_year_trans_expandable_child_list_item,
					groupFrom, groupTo, childFrom, childTo);
			expandableListView.setAdapter(adapter);
			super.onPostExecute(paramInteger);
			listview_loading_tv.setVisibility(View.INVISIBLE);

		}

		protected void onPreExecute() {
			super.onPreExecute();
			listview_loading_tv.setVisibility(View.VISIBLE);
		}

	}

	public static final String END_TIME = "endTime";
	public static final String START_TIME = "startTime";
	public static final String TITLE = "title";
	private long endTime = 0L;
	private ExpandableListView expandableListView;
	private boolean isOpenMenu = false;

	private TextView listview_loading_tv;
	private Panel menu_pn = null;
	private MymoneySQLiteOpenHelper sqlLiteOpenhelper;

	private long startTime = 0L;
	private String title = "";
	private String tag = "NavYearTransactionActivity";

	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.v(tag , "requestCode:"+requestCode+"/resultCode:"+resultCode);
	}

	public boolean onChildClick(ExpandableListView paramExpandableListView,
			View paramView, int paramInt1, int paramInt2, long paramLong) {
		return true;
	}

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
		case R.id.filter_btn:
			startNavYearTransactionFilterActivity();
			break;

		}

	}

	public void startNavYearTransactionFilterActivity() {
		Intent intent = new Intent();
		intent.setClass(this,
				NavYearTransactionFilterActivity.class);
	    startActivityForResult(intent, FILTERACTIVITY_REQUEST_CODE);
	}

	public boolean onContextItemSelected(MenuItem paramMenuItem) {
		return super.onContextItemSelected(paramMenuItem);
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.nav_year_trans_activity);
		expandableListView = (ExpandableListView) findViewById(2131230864);
		sqlLiteOpenhelper = new MymoneySQLiteOpenHelper(getApplicationContext());
		Bundle bundle = this.getIntent().getExtras();
		startTime = bundle.getLong(START_TIME);
		endTime = bundle.getLong(END_TIME);
		title = bundle.getString(TITLE);
		listview_loading_tv = (TextView) findViewById(R.id.listview_loading_tv);
		new YearTransLoadTask(this).execute(new Long[] { startTime, endTime });
		menu_pn = (Panel) findViewById(R.id.menu_pn);
		menu_pn.setOnPanelListener(this);
		Button title_btn = (Button) findViewById(R.id.title_btn);
		title_btn.setOnClickListener(this);
		title_btn.setText(title);
		Button back_btn = (Button) findViewById(R.id.back_btn);
		back_btn.setOnClickListener(this);
		Button titlebar_right_btn = (Button) findViewById(R.id.titlebar_right_btn);
		titlebar_right_btn.setOnClickListener(this);
		Button filter_btn = (Button) findViewById(R.id.filter_btn);
		filter_btn.setOnClickListener(this);

	}

	public void onCreateContextMenu(ContextMenu paramContextMenu,
			View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
		paramContextMenu.setHeaderTitle("请选择操作类型");
		paramContextMenu.add(0, 0, 0, "编辑");
		paramContextMenu.add(0, 1, 1, "删除");
	}

	protected void onDestroy() {
		sqlLiteOpenhelper.close();
		super.onDestroy();
	}

	public void onGroupExpand(int paramInt) {

	}

	@Override
	public void onPanelClosed(Panel panel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPanelOpened(Panel panel) {
		// TODO Auto-generated method stub

	}

	protected void onRestoreInstanceState(Bundle paramBundle) {
		super.onRestoreInstanceState(paramBundle);

	}

	protected void onResume() {

		super.onResume();
	}

	protected void onSaveInstanceState(Bundle paramBundle) {
		super.onSaveInstanceState(paramBundle);

	}
}
