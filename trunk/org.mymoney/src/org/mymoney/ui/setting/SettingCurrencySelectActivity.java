package org.mymoney.ui.setting;

import java.util.ArrayList;

import org.mymoney.R;
import org.mymoney.ui.base.BaseActivity;
import org.mymoney.ui.widget.CheckedListItem;
import org.mymoney.util.CurrencyCodeIconResourcesHelper;
import org.mymoney.util.MymoneySQLiteOpenHelper;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mymoney.core.vo.AccountGroupVo;
import com.mymoney.core.vo.CurrencyVo;

public class SettingCurrencySelectActivity extends BaseActivity implements
		View.OnClickListener, AdapterView.OnItemClickListener {

	public class DefaultCurrencyCodeListViewAdapter extends BaseAdapter {
		ArrayList<CurrencyVo> currencyVos = null;

		public DefaultCurrencyCodeListViewAdapter(
				ArrayList<CurrencyVo> currencyVos) {
			super();
			this.currencyVos = currencyVos;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return currencyVos.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return currencyVos.get(position);
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
			CheckedListItem layout = (CheckedListItem) SettingCurrencySelectActivity.this
					.getLayoutInflater()
					.inflate(
							R.layout.simple_list_item_single_choice_for_currency,
							null);
			CurrencyVo vo = this.currencyVos.get(position);
			((ImageView) layout.findViewById(R.id.currency_icon_iv))
					.setBackgroundResource(CurrencyCodeIconResourcesHelper
							.geResId(vo.getIcon()));
			((TextView) layout.findViewById(R.id.currency_name_tv)).setText(vo
					.getName());
			((TextView) layout.findViewById(R.id.currency_code_tv)).setText(vo
					.getCode());
			return layout;
		}
	}

	private Intent a(String paramString) {
		Intent localIntent1 = new Intent();
		localIntent1.putExtra("currencyCode", paramString);
		return localIntent1;
	}

	public void onClick(View paramView) {
		switch (paramView.getId()) {
		default:
			return;
		case 2131230807:
		}
		Intent localIntent = a(null);
		setResult(2, localIntent);
		finish();
	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.setting_currency_select_activity);
		ListView currency_lv = (ListView) findViewById(R.id.currency_lv);
		currency_lv.setAdapter(getDefaultCurrencyCodeListViewAdapter());
	}

	private DefaultCurrencyCodeListViewAdapter getDefaultCurrencyCodeListViewAdapter() {
		MymoneySQLiteOpenHelper sqlLiteOpenhelper = new MymoneySQLiteOpenHelper(
				getApplicationContext());
		String sql = "SELECT " + "  t_currency.[currencyPOID] AS _id ,  "
				+ "  t_currency.[code] ,  " + "  t_currency.[name] ,  "
				+ "  t_currency.[icon]  " + "FROM  " + "  t_currency ";
		Cursor cursor = sqlLiteOpenhelper.getWritableDatabase().rawQuery(sql,
				null);
		int size = cursor.getCount();
		cursor.moveToFirst();
		ArrayList<CurrencyVo> currencyVos = new ArrayList<CurrencyVo>();
		for (int i = 0; i < size; i++) {
			CurrencyVo vo = new CurrencyVo();
			currencyVos.add(vo);
			vo.set_id(cursor.getInt(0));
			vo.setCode(cursor.getString(1));
			vo.setName(cursor.getString(2));
			vo.setIcon(cursor.getString(3));
			cursor.moveToNext();
		}
		cursor.close();
		return new DefaultCurrencyCodeListViewAdapter(currencyVos);
	}

	public void onItemClick(AdapterView paramAdapterView, View paramView,
			int paramInt, long paramLong) {

	}
}
