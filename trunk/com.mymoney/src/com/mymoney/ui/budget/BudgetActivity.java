package com.mymoney.ui.budget;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.widget.DigitKeypad;
import dz;
import ea;
import f;
import g;
import hh;
import kb;
import kc;
import kd;
import ke;
import kf;
import kg;

public class BudgetActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
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
  private hh p;
  private boolean q;
  private double r;
  private double s;
  private BudgetItemAdapter t;
  private f u;

  public BudgetActivity()
  {
    Handler localHandler = new Handler();
    this.c = localHandler;
    this.q = 0;
    f localf = g.a().g();
    this.u = localf;
  }

  private void a()
  {
    AsyncTask localAsyncTask = new kc(this).execute(null);
  }

  private void a(double paramDouble)
  {
    this.p.b(paramDouble);
    if (this.p.b() != 0L)
    {
      f localf1 = this.u;
      hh localhh1 = this.p;
      boolean bool = localf1.a(localhh1);
      return;
    }
    f localf2 = this.u;
    hh localhh2 = this.p;
    localf2.b(localhh2);
  }

  private void b()
  {
    DigitKeypad localDigitKeypad1 = this.l;
    Animation localAnimation1 = this.n;
    localDigitKeypad1.setAnimation(localAnimation1);
    DigitKeypad localDigitKeypad2 = this.l;
    Animation localAnimation2 = this.n;
    localDigitKeypad2.startAnimation(localAnimation2);
  }

  private void c()
  {
    DigitKeypad localDigitKeypad1 = this.l;
    Animation localAnimation1 = this.o;
    localDigitKeypad1.setAnimation(localAnimation1);
    DigitKeypad localDigitKeypad2 = this.l;
    Animation localAnimation2 = this.o;
    localDigitKeypad2.startAnimation(localAnimation2);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131230804:
    case 2131230805:
    case 2131230806:
    default:
      return;
    case 2131230807:
      finish();
      return;
    case 2131230802:
      b();
      this.q = 1;
      DigitKeypad localDigitKeypad1 = this.l;
      String str1 = String.valueOf(this.r);
      localDigitKeypad1.a(str1);
      return;
    case 2131230803:
    }
    b();
    this.q = 1;
    DigitKeypad localDigitKeypad2 = this.l;
    String str2 = String.valueOf(this.r);
    localDigitKeypad2.a(str2);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = this;
    setContentView(2130903053);
    Button localButton1 = (Button)findViewById(2131230807);
    this.d = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.e = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.f = localButton2;
    Button localButton3 = (Button)findViewById(2131230802);
    this.g = localButton3;
    Button localButton4 = (Button)findViewById(2131230803);
    this.h = localButton4;
    TextView localTextView2 = (TextView)findViewById(2131230797);
    this.i = localTextView2;
    ListView localListView1 = (ListView)findViewById(2131230796);
    this.j = localListView1;
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131230729);
    this.k = localLinearLayout;
    DigitKeypad localDigitKeypad1 = (DigitKeypad)findViewById(2131230752);
    this.l = localDigitKeypad1;
    this.d.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.j.setOnItemClickListener(this);
    DigitKeypad localDigitKeypad2 = this.l;
    ke localke = new ke(this);
    localDigitKeypad2.a(localke);
    DigitKeypad localDigitKeypad3 = this.l;
    kf localkf = new kf(this);
    localDigitKeypad3.a(localkf);
    Animation localAnimation1 = AnimationUtils.loadAnimation(this.b, 2130968577);
    this.n = localAnimation1;
    Animation localAnimation2 = this.n;
    kg localkg = new kg(this);
    localAnimation2.setAnimationListener(localkg);
    Animation localAnimation3 = AnimationUtils.loadAnimation(this.b, 2130968576);
    this.o = localAnimation3;
    Animation localAnimation4 = this.o;
    kd localkd = new kd(this);
    localAnimation4.setAnimationListener(localkd);
    Context localContext = this.b;
    BudgetItemAdapter localBudgetItemAdapter1 = new BudgetItemAdapter(localContext, 2130903054);
    this.t = localBudgetItemAdapter1;
    ListView localListView2 = this.j;
    BudgetItemAdapter localBudgetItemAdapter2 = this.t;
    localListView2.setAdapter(localBudgetItemAdapter2);
    this.e.setText("分类预算");
    this.f.setVisibility(4);
    Handler localHandler = this.c;
    kb localkb = new kb(this, localHandler);
    dz localdz1 = dz.a();
    String str1 = ea.n;
    localdz1.a(str1, localkb);
    dz localdz2 = dz.a();
    String str2 = ea.o;
    localdz2.a(str2, localkb);
    dz localdz3 = dz.a();
    String str3 = ea.p;
    localdz3.a(str3, localkb);
    a();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131623937, paramMenu);
    return true;
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b();
    hh localhh = (hh)paramAdapterView.getItemAtPosition(paramInt);
    this.p = localhh;
    double d1 = this.p.d();
    DigitKeypad localDigitKeypad = this.l;
    String str = String.valueOf(d1);
    localDigitKeypad.a(str);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (this.l.a()))
      c();
    boolean bool;
    for (int m = 1; ; bool = super.onKeyDown(paramInt, paramKeyEvent))
      return m;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131231178:
    }
    while (true)
    {
      return true;
      finish();
    }
  }

  protected void onPause()
  {
    super.onPause();
  }

  protected void onRestart()
  {
    super.onRestart();
  }

  protected void onResume()
  {
    super.onResume();
  }

  protected void onStart()
  {
    super.onStart();
  }

  protected void onStop()
  {
    super.onStop();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.budget.BudgetActivity
 * JD-Core Version:    0.6.0
 */