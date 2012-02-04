package org.mymoney.ui.navtrans;

import java.util.ArrayList;

import org.mymoney.R;
import org.mymoney.ui.base.BaseActivity;
import org.mymoney.ui.navtrans.NavYearTransactionFilterActivity.NavYearTransFilterDialogBuliderListener;
import org.mymoney.ui.navtrans.NavYearTransactionFilterActivity.NavYearTransFilterDialogBuliderListener.Type;
import org.mymoney.util.MymoneySQLiteOpenHelper;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NavYearTransactionFilterActivity extends BaseActivity implements
		View.OnClickListener {
	private static final String TAG = "NavYearTransactionFilterActivity";

	public interface NavYearTransFilterDialogBuliderListener {
		void onClick(ArrayList<Integer> results, Type type);

		enum Type {
			category, account, project, corporation
		};

	}

	public class NavYearTransFilterDialogBulider implements
			OnMultiChoiceClickListener, DialogInterface.OnClickListener {
		private MymoneySQLiteOpenHelper sqlLiteOpenhelper;
		private AlertDialog.Builder builder = null;
		private int[] itemsId = null;
		private String[] itemsName = null;
		private boolean[] checkedItems = null;
		private NavYearTransFilterDialogBuliderListener.Type type = Type.category;
		private NavYearTransFilterDialogBuliderListener listener = null;

		public void setListener(NavYearTransFilterDialogBuliderListener listener) {
			this.listener = listener;
		}

		public NavYearTransFilterDialogBulider(Context paramContext,
				String title, Type type) {
			sqlLiteOpenhelper = new MymoneySQLiteOpenHelper(
					getApplicationContext());
			builder = new AlertDialog.Builder(paramContext);
			this.type = type;
			String sql = null;
			if (type == Type.account) {
				sql = "Select [accountPOID] as id, name From [t_account]";

			} else if (type == Type.category) {
				sql = "Select   t_category.[categoryPOID] as id , t_category.name as name  From [t_category] where  t_category.[depth]=1";

			} else if (type == Type.corporation) {
				sql = "Select [tradingEntityPOID] as id ,name From  [t_tradingEntity]";

			} else if (type == Type.project) {
				sql = "Select  [tagPOID] as id,name  From  [t_tag]";

			}
			Cursor cursor = sqlLiteOpenhelper.getWritableDatabase().rawQuery(
					sql, null);
			int itemSize = cursor.getCount();
			itemsId = new int[itemSize];
			itemsName = new String[itemSize];
			checkedItems = new boolean[itemSize];
			cursor.moveToFirst();
			for (int i = 0; i < itemSize; i++) {
				itemsId[i] = cursor.getInt(0);
				itemsName[i] = cursor.getString(1);
				checkedItems[i] = true;
				cursor.moveToNext();
			}
			cursor.close();
			builder.setMultiChoiceItems(itemsName, checkedItems, this);
			builder.setTitle(title);
			builder.setNegativeButton("确定", this);
		}

		@Override
		public void onClick(DialogInterface dialog, int which, boolean isChecked) {
			Log.v(TAG,
					"onClick(DialogInterface dialog, int which, boolean isChecked) :which="
							+ which + ",isChecked:" + isChecked);
			checkedItems[which] = isChecked;

		}

		public AlertDialog createDialog() {
			return builder.create();
		}

		@Override
		public void onClick(DialogInterface dialog, int which) {
			Log.v(TAG, "onClick(DialogInterface dialog, int which):which="
					+ which);
			if (null == listener)
				return;
			ArrayList<Integer> results = new ArrayList<Integer>();
			if (which == DialogInterface.BUTTON_NEGATIVE) {
				for (int i = 0; i < this.checkedItems.length; i++) {
					if (checkedItems[i]) {
						results.add(this.itemsId[i]);
					}
				}
			}
			listener.onClick(results, type);

		}
	}

	public static class NavYearTransFilterTask extends AsyncTask {

		public NavYearTransFilterTask(
				NavYearTransactionFilterActivity paramNavYearTransactionFilterActivity) {
		}

		protected Object doInBackground(Object[] paramArrayOfObject) {
			/*
			 * NavYearTransactionFilterActivity
			 * localNavYearTransactionFilterActivity1 = this.b; List localList1
			 * = u.a().b(); List localList2 =
			 * NavYearTransactionFilterActivity.a(
			 * localNavYearTransactionFilterActivity1, localList1);
			 * NavYearTransactionFilterActivity
			 * localNavYearTransactionFilterActivity2 = this.b; List localList3
			 * = u.a().c(); List localList4 =
			 * NavYearTransactionFilterActivity.b(
			 * localNavYearTransactionFilterActivity2, localList3);
			 * NavYearTransactionFilterActivity
			 * localNavYearTransactionFilterActivity3 = this.b; List localList5
			 * = u.a().e(); List localList6 =
			 * NavYearTransactionFilterActivity.c(
			 * localNavYearTransactionFilterActivity3, localList5);
			 * NavYearTransactionFilterActivity
			 * localNavYearTransactionFilterActivity4 = this.b; List localList7
			 * = u.a().d(); List localList8 =
			 * NavYearTransactionFilterActivity.d(
			 * localNavYearTransactionFilterActivity4, localList7);
			 */return null;
		}

		protected void onPostExecute(Object paramObject) {
			super.onPostExecute(paramObject);
		}

		protected void onPreExecute() {
			super.onPreExecute();
		}
	}

	private NavYearTransFilterVo localNavYearTransFilterVo = NavYearTransFilterVo
			.getNavYearTransFilterVo();

	private NavYearTransFilterDialogBuliderListener listener = new NavYearTransFilterDialogBuliderListener() {

		@Override
		public void onClick(ArrayList<Integer> results, Type type) {
			Log.v(TAG, "type:" + type.toString() + "/results:" + results);
			if (type == Type.account) {
				localNavYearTransFilterVo.accounts = results;

			} else if (type == Type.category) {
				localNavYearTransFilterVo.categorys = results;

			} else if (type == Type.corporation) {
				localNavYearTransFilterVo.corporations = results;

			} else if (type == Type.project) {
				localNavYearTransFilterVo.projects = results;

			}

			Log.v(TAG,
					"localNavYearTransFilterVo:"
							+ localNavYearTransFilterVo.toString());

		}

	};

	public void onClick(View paramView) {
		switch (paramView.getId()) {

		case R.id.back_btn:
			finish();
			return;
		case R.id.titlebar_right_btn:
			setResult(RESULT_FIRST_USER);
			finish();
			return;
		case R.id.category_ly:
			showDialog(1);
			return;
		case R.id.account_ly:
			showDialog(2);
			return;
		case R.id.project_ly:
			showDialog(3);
			return;
		case R.id.corporation_ly:
			showDialog(4);
			return;
		default:
			return;
		}

	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.nav_year_trans_filter_activity);
		findViewById(R.id.back_btn).setOnClickListener(this);
		Button titlebar_right_btn = (Button) findViewById(R.id.titlebar_right_btn);
		titlebar_right_btn.setText("确定");
		titlebar_right_btn.setOnClickListener(this);
		findViewById(R.id.category_ly).setOnClickListener(this);
		findViewById(R.id.account_ly).setOnClickListener(this);
		findViewById(R.id.project_ly).setOnClickListener(this);
		findViewById(R.id.corporation_ly).setOnClickListener(this);
		new NavYearTransFilterTask(this).execute(null);

	}

	protected Dialog onCreateDialog(int paramInt) {
		NavYearTransFilterDialogBulider dialogBulider = null;
		switch (paramInt) {
		case 1:
			dialogBulider = new NavYearTransFilterDialogBulider(
					NavYearTransactionFilterActivity.this, "选择分类",
					Type.category);
			break;
		case 2:
			dialogBulider = new NavYearTransFilterDialogBulider(
					NavYearTransactionFilterActivity.this, "选择账户", Type.account);
			break;
		case 3:
			dialogBulider = new NavYearTransFilterDialogBulider(
					NavYearTransactionFilterActivity.this, "选择项目", Type.project);
			break;
		case 4:
			dialogBulider = new NavYearTransFilterDialogBulider(
					NavYearTransactionFilterActivity.this, "选择商家",
					Type.corporation);
			break;
		default:

		}
		dialogBulider.setListener(listener);
		return dialogBulider.createDialog();

	}

	protected void onDestroy() {
		super.onDestroy();
	}

}
