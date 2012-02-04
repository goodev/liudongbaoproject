package org.mymoney.ui.budget;

import org.mymoney.R;
import org.mymoney.ui.base.BaseActivity;
import org.mymoney.ui.widget.DigitKeypad;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class BudgetActivity extends BaseActivity implements
		View.OnClickListener, AdapterView.OnItemClickListener {
	private static String a = BudgetActivity.class.getSimpleName();
	private Context b;
	private Handler c;
	private Button d;
	private TextView e;
	private Button f;
	private Button g;
	private Button h;
	private TextView i;
	private ListView j;
	private LinearLayout k;
	private DigitKeypad l;
	private Animation n;
	private Animation o;
	private boolean q;
	private double r;
	private double s;

	private void b() {
		DigitKeypad localDigitKeypad1 = this.l;
		Animation localAnimation1 = this.n;
		localDigitKeypad1.setAnimation(localAnimation1);
		DigitKeypad localDigitKeypad2 = this.l;
		Animation localAnimation2 = this.n;
		localDigitKeypad2.startAnimation(localAnimation2);
	}

	private void c() {
		DigitKeypad localDigitKeypad1 = this.l;
		Animation localAnimation1 = this.o;
		localDigitKeypad1.setAnimation(localAnimation1);
		DigitKeypad localDigitKeypad2 = this.l;
		Animation localAnimation2 = this.o;
		localDigitKeypad2.startAnimation(localAnimation2);
	}

	public void onClick(View paramView) {

	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		this.b = this;
		setContentView(R.layout.budget_activity);
		Button localButton1 = (Button) findViewById(2131230807);
		this.d = localButton1;
		TextView localTextView1 = (TextView) findViewById(2131230730);
		this.e = localTextView1;
		Button localButton2 = (Button) findViewById(2131230808);
		this.f = localButton2;
		Button localButton3 = (Button) findViewById(2131230802);
		this.g = localButton3;
		Button localButton4 = (Button) findViewById(2131230803);
		this.h = localButton4;
		TextView localTextView2 = (TextView) findViewById(2131230797);
		this.i = localTextView2;
		ListView localListView1 = (ListView) findViewById(2131230796);
		this.j = localListView1;
		LinearLayout localLinearLayout = (LinearLayout) findViewById(2131230729);
		this.k = localLinearLayout;
		DigitKeypad localDigitKeypad1 = (DigitKeypad) findViewById(2131230752);
		this.l = localDigitKeypad1;
		this.d.setOnClickListener(this);
		this.g.setOnClickListener(this);
		this.h.setOnClickListener(this);
		this.j.setOnItemClickListener(this);
		Animation localAnimation1 = AnimationUtils.loadAnimation(this.b,
				2130968577);
		this.n = localAnimation1;
		Animation localAnimation2 = this.n;
		Animation localAnimation3 = AnimationUtils.loadAnimation(this.b,
				2130968576);
		this.o = localAnimation3;
		Animation localAnimation4 = this.o;
		Context localContext = this.b;
		this.e.setText("分类预算");
		this.f.setVisibility(4);
		Handler localHandler = this.c;
	}

	public boolean onCreateOptionsMenu(Menu paramMenu) {
		boolean bool = super.onCreateOptionsMenu(paramMenu);
		getMenuInflater().inflate(2131623937, paramMenu);
		return true;
	}

	protected void onDestroy() {
		super.onDestroy();
	}

	public void onItemClick(AdapterView paramAdapterView, View paramView,
			int paramInt, long paramLong) {

	}

	public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
		return super.onKeyDown(paramInt, paramKeyEvent);

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
}
