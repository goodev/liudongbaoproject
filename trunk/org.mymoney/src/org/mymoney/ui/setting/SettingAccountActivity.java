package org.mymoney.ui.setting;

import java.util.ArrayList;

import org.mymoney.R;
import org.mymoney.ui.base.BaseActivity;
import org.mymoney.ui.widget.AccountDragListView;
import org.mymoney.ui.widget.CheckedListItem;
import org.mymoney.ui.widget.Panel;
import org.mymoney.ui.widget.Panel.OnPanelListener;
import org.mymoney.util.MymoneySQLiteOpenHelper;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingAccountActivity extends BaseActivity implements
		View.OnClickListener, AdapterView.OnItemClickListener,
		AdapterView.OnItemLongClickListener, OnPanelListener {
	MymoneySQLiteOpenHelper sqlLiteOpenhelper = null;
	private Panel menu_pn;
	private boolean open = true;
	private Button title_btn;

	public void onClick(View paramView) {
		switch (paramView.getId()) {
		case R.id.title_btn:
			this.menu_pn.setOpen(open, false);
			if (open) {
				title_btn
						.setBackgroundResource(R.drawable.common_title_btn_arrow_up);
			} else {
				title_btn
						.setBackgroundResource(R.drawable.common_title_btn_arrow_down);
			}
			open = !open;

			break;
		case R.id.back_btn:
			this.finish();
			break;
		case R.id.titlebar_right_btn:
			startSettingAddOrEditAccountActivity();
			break;

		}

	}

	private void startSettingAddOrEditAccountActivity() {

		Intent localIntent1 = new Intent(this.getApplicationContext(),
				SettingAddOrEditAccountActivity.class);
		localIntent1.putExtra("mode", 1);
		startActivity(localIntent1);
	}

	protected void onCreate(Bundle paramBundle) {

		super.onCreate(paramBundle);
		setContentView(R.layout.setting_account_activity);
		AccountDragListView listView = (AccountDragListView) this
				.findViewById(R.id.account_lv);
		sqlLiteOpenhelper = new MymoneySQLiteOpenHelper(
				this.getApplicationContext());
		listView.setAdapter(new AccountListViewAdapter());
		menu_pn = (Panel) findViewById(R.id.menu_pn);
		menu_pn.setOnPanelListener(this);
		title_btn = (Button) findViewById(R.id.title_btn);
		title_btn.setOnClickListener(this);
		title_btn.setText("账户");
		Button back_btn = (Button) findViewById(R.id.back_btn);
		back_btn.setOnClickListener(this);
		Button titlebar_right_btn = (Button) findViewById(R.id.titlebar_right_btn);
		titlebar_right_btn.setOnClickListener(this);
		titlebar_right_btn.setText("添加");
	}

	protected Dialog onCreateDialog(int paramInt) {
		return super.onCreateDialog(paramInt);
	}

	public boolean onCreateOptionsMenu(Menu paramMenu) {
		getMenuInflater().inflate(2131623946, paramMenu);
		paramMenu.findItem(2131231186).setTitle("首页");
		return super.onCreateOptionsMenu(paramMenu);
	}

	public boolean onOptionsItemSelected(MenuItem paramMenuItem) {

		return super.onOptionsItemSelected(paramMenuItem);

	}

	protected void onPause() {

		super.onPause();
	}

	protected void onPrepareDialog(int paramInt, Dialog paramDialog) {
		super.onPrepareDialog(paramInt, paramDialog);
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

	protected void onDestroy() {
		sqlLiteOpenhelper.close();
		super.onDestroy();
	}

	public class AccountEntity {
		public int _id = 0;
		public String name = "";
		public String type = "";
		public String path = "";
		public String balance = "";
		public static final String type_account = "account";
		public static final String type_account_group = "account_group";
	}

	public class AccountListViewAdapter extends BaseAdapter {

		private ArrayList<AccountEntity> items = new ArrayList<AccountEntity>();

		private AccountListViewAdapter() {
			super();
			SQLiteDatabase database = sqlLiteOpenhelper.getWritableDatabase();
			String sql = "SELECT"
					+ "  [t_account_group].[accountGroupPOID] AS _id ,"
					+ "  [t_account_group].name , "
					+ "  'account_group' AS type , "
					+ "  [t_account_group].path " + " FROM "
					+ "  [t_account_group] " + " WHERE "
					+ "  [t_account_group].type = 0 AND depth = 1";
			Cursor accountGroupCursor = database.rawQuery(sql, null);
			sql = "SELECT"
					+ "  [t_account].[accountPOID] AS _id , "
					+ "  [t_account].name , "
					+ "  'account' AS type , "
					+ "  [t_account].[balance] , "
					+ "  [t_account_group].path "
					+ "FROM "
					+ "  [t_account] , "
					+ "  [t_account_group] "
					+ "WHERE "
					+ "  [t_account].[accountGroupPOID] = [t_account_group].[accountGroupPOID] AND [t_account_group].type = 0 ";
			Cursor accountCursor = database.rawQuery(sql, null);
			int groupSize = accountGroupCursor.getCount();
			int accountSize = accountCursor.getCount();
			accountGroupCursor.moveToFirst();
			for (int i = 0; i < groupSize; i++) {
				AccountEntity item = new AccountEntity();
				item._id = accountGroupCursor.getInt(0);
				item.name = accountGroupCursor.getString(1);
				item.type = accountGroupCursor.getString(2);
				item.path = accountGroupCursor.getString(3);
				items.add(item);
				accountCursor.moveToFirst();
				for (int j = 0; j < accountSize; j++) {
					String path = accountCursor.getString(4);
					if (path.startsWith(item.path)) {
						AccountEntity item2 = new AccountEntity();
						item2._id = accountCursor.getInt(0);
						item2.name = accountCursor.getString(1);
						item2.type = accountCursor.getString(2);
						item2.balance = accountCursor.getString(3);
						item2.path = path;
						items.add(item2);
					}
					accountCursor.moveToNext();
				}
				accountGroupCursor.moveToNext();
			}
			accountCursor.close();
			accountGroupCursor.close();
		}

		@Override
		public int getCount() {
			return items.size();
		}

		@Override
		public AccountEntity getItem(int position) {
			return items.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			AccountEntity item = this.getItem(position);
			if (item.type.equals(AccountEntity.type_account_group)) {
				RelativeLayout layout = (RelativeLayout) SettingAccountActivity.this
						.getLayoutInflater().inflate(
								R.layout.simple_list_item_for_account_group,
								null);
				TextView view = (TextView) layout
						.findViewById(R.id.account_group_name_tv);
				view.setText(item.name);
				return layout;
			} else {
				CheckedListItem listItem = (CheckedListItem) SettingAccountActivity.this
						.getLayoutInflater()
						.inflate(
								R.layout.simple_list_item_single_choice_for_account,
								null);
				TextView account_name_tv = (TextView) listItem
						.findViewById(R.id.account_name_tv);
				account_name_tv.setText(item.name);
				TextView second_level_account_group_name_tv = (TextView) listItem
						.findViewById(R.id.second_level_account_group_name_tv);
				second_level_account_group_name_tv.setText(item.name);
				TextView account_balance_tv = (TextView) listItem
						.findViewById(R.id.account_balance_tv);
				account_balance_tv.setText(item.balance);

				listItem.findViewById(R.id.account_hidden_status_iv)
						.setVisibility(android.view.View.INVISIBLE);
				return listItem;
			}
		}

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
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub

	}
}
