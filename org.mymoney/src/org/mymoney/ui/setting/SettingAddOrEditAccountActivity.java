package org.mymoney.ui.setting;

import java.util.ArrayList;

import org.mymoney.R;
import org.mymoney.ui.base.BaseActivity;
import org.mymoney.util.MymoneySQLiteOpenHelper;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.mymoney.core.vo.AccountGroupVo;

public class SettingAddOrEditAccountActivity extends BaseActivity implements
		View.OnClickListener, AdapterView.OnItemSelectedListener,
		CompoundButton.OnCheckedChangeListener {

	public class AccountLoadTask extends AsyncTask<Long, Void, Integer> {
		private MymoneySQLiteOpenHelper sqlLiteOpenhelper;

		@Override
		protected Integer doInBackground(Long... params) {
			sqlLiteOpenhelper = new MymoneySQLiteOpenHelper(
					getApplicationContext());
			String sql = "SELECT "
					+ "  [t_account_group].[accountGroupPOID] AS _id , "
					+ "  [t_account_group].name as name , "
					+ "  [t_account_group].path as path , "
					+ "  [t_account_group].[depth] AS depth " + "FROM "
					+ "  [t_account_group] " + "WHERE "
					+ "  depth =1 or depth =2 " + "ORDER BY " + "  depth ";
			Cursor cursor = sqlLiteOpenhelper.getWritableDatabase().rawQuery(
					sql, null);
			int size = cursor.getCount();
			cursor.moveToFirst();
			for (int i = 0; i < size; i++) {
				AccountGroupVo vo = new AccountGroupVo();
				accountGroups.add(vo);
				vo.set_id(cursor.getInt(0));
				vo.setName(cursor.getString(1));
				vo.setPath(cursor.getString(2));
				vo.setDepth(cursor.getInt(3));
				cursor.moveToNext();
			}
			cursor.close();
			return size;
		}

		@Override
		protected void onPostExecute(Integer result) {
			ArrayList<AccountGroupVo> first_level_accountGroups = getFirst_Level_AccountGroups();
			AccountGroupAdapter firstLevelAccountGroupAdapter = new AccountGroupAdapter(
					first_level_accountGroups);
			first_level_accountgroup_spn
					.setAdapter(firstLevelAccountGroupAdapter);
		}

	}

	public class AccountGroupAdapter extends BaseAdapter {
		private ArrayList<AccountGroupVo> accountGroups = new ArrayList<AccountGroupVo>();

		public AccountGroupAdapter(ArrayList<AccountGroupVo> accountGroups) {
			this.accountGroups = accountGroups;
		}

		@Override
		public int getCount() {
			return accountGroups.size();
		}

		@Override
		public Object getItem(int position) {
			return accountGroups.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView != null)
				return convertView;
			TextView view = (TextView) SettingAddOrEditAccountActivity.this
					.getLayoutInflater().inflate(
							R.layout.simple_spinner_item_gravity_right, null);
			view.setText(accountGroups.get(position).getName());
			return view;
		}

		@Override
		public View getDropDownView(int position, View convertView,
				ViewGroup parent) {
			if (convertView != null)
				return convertView;
			TextView view = (TextView) SettingAddOrEditAccountActivity.this
					.getLayoutInflater().inflate(
							R.layout.simple_spinner_dropdown_item, null);
			view.setText(accountGroups.get(position).getName());
			return view;
		}

		public ArrayList<AccountGroupVo> getAccountGroups() {
			return accountGroups;
		}

	}

	private Spinner first_level_accountgroup_spn;
	private Spinner second_level_accountgroup_spn;
	private ArrayList<AccountGroupVo> accountGroups = new ArrayList<AccountGroupVo>();

	public void onCheckedChanged(CompoundButton paramCompoundButton,
			boolean paramBoolean) {

	}

	public ArrayList<AccountGroupVo> getSecond_Level_AccountGroups(
			AccountGroupVo accountGroupVo) {
		ArrayList<AccountGroupVo> results = new ArrayList<AccountGroupVo>();
		int size = this.accountGroups.size();
		for (int i = 0; i < size; i++) {
			AccountGroupVo vo = accountGroups.get(i);
			if (vo.getPath().startsWith(accountGroupVo.getPath()))
				results.add(vo);
		}
		return results;
	}

	public ArrayList<AccountGroupVo> getFirst_Level_AccountGroups() {
		ArrayList<AccountGroupVo> results = new ArrayList<AccountGroupVo>();
		int size = this.accountGroups.size();
		for (int i = 0; i < size; i++) {
			AccountGroupVo vo = accountGroups.get(i);
			if (vo.getDepth() == 1)
				results.add(vo);
		}
		return results;
	}

	public void onClick(View paramView) {
		switch (paramView.getId()) {
		default:
			return;
		case R.id.back_btn:
			finish();
			return;
		case R.id.titlebar_right_btn:

			return;
		case R.id.name_ly:

			return;
		case R.id.amount_of_money_ly:

			return;
		case R.id.hidden_or_not_ly:

		case R.id.memo_ly:

			return;
		case R.id.currency_type_ly:

			Intent localIntent1 = new Intent(getApplicationContext(),
					SettingCurrencySelectActivity.class);
			localIntent1.putExtra("from", 2);

			Intent localIntent3 = localIntent1.putExtra("currencyCode", "");
			startActivityForResult(localIntent1, 2);
		}

	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.setting_add_or_edit_account);
		first_level_accountgroup_spn = (Spinner) findViewById(R.id.first_level_accountgroup_spn);
		second_level_accountgroup_spn = (Spinner) findViewById(R.id.second_level_accountgroup_spn);
		first_level_accountgroup_spn.setOnItemSelectedListener(this);
		second_level_accountgroup_spn.setOnItemSelectedListener(this);
		findViewById(R.id.currency_type_ly).setOnClickListener(this);
		new AccountLoadTask().execute(null);
	}

	public boolean onCreateOptionsMenu(Menu paramMenu) {
		boolean bool = super.onCreateOptionsMenu(paramMenu);
		getMenuInflater().inflate(R.menu.setting_edit_common_activity_menu,
				paramMenu);
		return true;
	}

	protected void onDestroy() {
		super.onDestroy();
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

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		switch (parent.getId()) {
		// case R.id.first_level_accountgroup_detail_iv:
		case R.id.first_level_accountgroup_spn:
			AccountGroupAdapter adapter = (AccountGroupAdapter) this.first_level_accountgroup_spn
					.getAdapter();
			ArrayList<AccountGroupVo> second_level_accountGroups = getSecond_Level_AccountGroups(adapter
					.getAccountGroups().get(position));
			AccountGroupAdapter secondLevelAccountGroupAdapter = new AccountGroupAdapter(
					second_level_accountGroups);
			second_level_accountgroup_spn
					.setAdapter(secondLevelAccountGroupAdapter);
			return;
		case R.id.second_level_accountgroup_spn:

		default:
			return;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (2 == requestCode) {
			if (1 != resultCode)
				return;
			String str1 = data.getStringExtra("currencyCode");
		}
	}
}
