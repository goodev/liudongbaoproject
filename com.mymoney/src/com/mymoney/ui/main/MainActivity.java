package com.mymoney.ui.main;

import android.app.AlarmManager;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mymoney.core.application.ApplicationContext;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.budget.BudgetActivity;
import com.mymoney.ui.navtrans.NavTransactionActivity;
import com.mymoney.ui.navtrans.NavYearTransactionActivity;
import com.mymoney.ui.report.ReportActivity;
import com.mymoney.ui.setting.SettingAccountActivity;
import com.mymoney.ui.setting.SettingActivity;
import com.mymoney.ui.sync.SyncActivity;
import com.mymoney.ui.transfer.TransferActivity;
import com.mymoney.ui.widget.BatteryView;
import dh;
import dz;
import ea;
import f;
import g;
import gi;
import gj;
import gq;
import gs;
import gt;
import gu;
import java.util.Calendar;
import java.util.Date;
import le;
import lf;
import lg;
import lh;
import li;
import lj;
import lm;
import ln;
import lo;
import lr;
import m;

public class MainActivity extends BaseActivity
  implements View.OnClickListener
{
  public static Context a;
  public static String b = "MainActivity";
  public static String c = "com.mymoney.upgrade.action";
  public static String d = "com.mymoney.syncRemind.action";
  public static String e = "com.mymoney.backup.action";
  private TextView A;
  private TextView B;
  private Button C;
  private Button D;
  private Button E;
  private Button F;
  private Button G;
  private m H;
  private f I;
  private BackgroundService J;
  private lr K;
  private lo L;
  private lj M;
  private AlarmManager N;
  private int O;
  private int P;
  private int Q;
  private ServiceConnection R;
  private ln f;
  private boolean g;
  private LinearLayout h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private BatteryView n;
  private Button o;
  private RelativeLayout p;
  private TextView q;
  private TextView r;
  private TextView s;
  private TextView t;
  private RelativeLayout u;
  private TextView v;
  private TextView w;
  private TextView x;
  private RelativeLayout y;
  private TextView z;

  public MainActivity()
  {
    ln localln = new ln(this);
    this.f = localln;
    this.g = 0;
    m localm = g.a().b();
    this.H = localm;
    f localf = g.a().g();
    this.I = localf;
    li localli = new li(this);
    this.R = localli;
  }

  private void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    Context localContext = a;
    Intent localIntent1 = new Intent(localContext, NavTransactionActivity.class);
    String str1 = NavTransactionActivity.a;
    Intent localIntent2 = localIntent1.putExtra(str1, paramLong1);
    String str2 = NavTransactionActivity.b;
    Intent localIntent3 = localIntent1.putExtra(str2, paramLong2);
    String str3 = NavTransactionActivity.c;
    Intent localIntent4 = localIntent1.putExtra(str3, paramString);
    String str4 = NavTransactionActivity.d;
    Intent localIntent5 = localIntent1.putExtra(str4, paramInt);
    startActivity(localIntent1);
  }

  private void a(Class paramClass)
  {
    Context localContext = a;
    Intent localIntent = new Intent(localContext, paramClass);
    startActivity(localIntent);
  }

  private void c()
  {
    Context localContext = a;
    Intent localIntent = new Intent("com.mymoney.ui.setting.Action.AUTO_BACKUP");
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(localContext, 0, localIntent, 0);
    long l1 = gi.a(gu.t());
    int m = gu.u();
    AlarmManager localAlarmManager = this.N;
    long l2 = m * 86400000L;
    localAlarmManager.setRepeating(0, l1, l2, localPendingIntent);
  }

  private void d()
  {
    String str1 = b;
    StringBuilder localStringBuilder = new StringBuilder().append("versionCode:");
    int m = gt.d();
    String str2 = m;
    int i1 = Log.d(str1, str2);
    int i2 = gt.d();
    int i3 = gu.x();
    if (i2 <= i3)
      return;
    showDialog(1);
  }

  private void e()
  {
    long l1 = gi.a("20:00");
    Context localContext = a;
    Intent localIntent = new Intent("com.mymoney.ui.main.ADD_TRANS_REMIND");
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(localContext, 0, localIntent, 0);
    if (gu.y())
      return;
    this.N.setRepeating(0, l1, 172800000L, localPendingIntent);
    gu.l(1);
  }

  private void f()
  {
    Context localContext = a;
    Intent localIntent = new Intent(localContext, BackgroundService.class);
    ServiceConnection localServiceConnection = this.R;
    boolean bool = bindService(localIntent, localServiceConnection, 1);
  }

  private void g()
  {
    ServiceConnection localServiceConnection = this.R;
    unbindService(localServiceConnection);
    Context localContext = a;
    Intent localIntent = new Intent(localContext, BackgroundService.class);
    boolean bool = stopService(localIntent);
  }

  private void h()
  {
    a(SyncActivity.class);
  }

  private void i()
  {
    a(BudgetActivity.class);
  }

  private void j()
  {
    a(NavYearTransactionActivity.class);
  }

  private void k()
  {
    if (gu.h())
    {
      Context localContext1 = a;
      Intent localIntent1 = new Intent(localContext1, AddOrEditTransNewActivity.class);
      Intent localIntent2 = localIntent1.putExtra("state", 1);
      Intent localIntent3 = localIntent1.putExtra("transType", 0);
      startActivity(localIntent1);
      return;
    }
    Context localContext2 = a;
    Intent localIntent4 = new Intent(localContext2, AddOrEditTransactionActivity.class);
    Intent localIntent5 = localIntent4.putExtra("state", 2);
    Intent localIntent6 = localIntent4.putExtra("transType", 0);
    startActivity(localIntent4);
  }

  private void l()
  {
    if (gu.h())
    {
      Context localContext1 = a;
      Intent localIntent1 = new Intent(localContext1, AddOrEditTransNewActivity.class);
      Intent localIntent2 = localIntent1.putExtra("state", 1);
      Intent localIntent3 = localIntent1.putExtra("transType", 1);
      startActivity(localIntent1);
      return;
    }
    Context localContext2 = a;
    Intent localIntent4 = new Intent(localContext2, AddOrEditTransactionActivity.class);
    Intent localIntent5 = localIntent4.putExtra("state", 2);
    Intent localIntent6 = localIntent4.putExtra("transType", 1);
    startActivity(localIntent4);
  }

  private void m()
  {
    a(TransferActivity.class);
  }

  private void n()
  {
    Context localContext = a;
    Intent localIntent1 = new Intent(localContext, SettingAccountActivity.class);
    Intent localIntent2 = localIntent1.putExtra("from", 1);
    startActivity(localIntent1);
  }

  private void o()
  {
    a(ReportActivity.class);
  }

  private void p()
  {
    a(SettingActivity.class);
  }

  private void q()
  {
    long l1 = System.currentTimeMillis();
    double d1 = this.I.b();
    m localm1 = this.H;
    long l2 = gi.h();
    long l3 = gi.i();
    double d2 = localm1.c(l2, l3);
    m localm2 = this.H;
    long l4 = gi.h();
    long l5 = gi.i();
    double d3 = localm2.b(l4, l5);
    double d4 = d1 - d3;
    m localm3 = this.H;
    long l6 = gi.a();
    long l7 = gi.b();
    double d5 = localm3.b(l6, l7);
    m localm4 = this.H;
    long l8 = gi.a();
    long l9 = gi.b();
    double d6 = localm4.c(l8, l9);
    m localm5 = this.H;
    long l10 = gi.c();
    long l11 = gi.d();
    double d7 = localm5.b(l10, l11);
    m localm6 = this.H;
    long l12 = gi.c();
    long l13 = gi.d();
    double d8 = localm6.c(l12, l13);
    long l14 = System.currentTimeMillis();
    String str1 = b;
    StringBuilder localStringBuilder1 = new StringBuilder().append("time spend  in report data query is ");
    long l15 = l14 - l1;
    StringBuilder localStringBuilder2 = localStringBuilder1;
    long l16 = l15;
    String str2 = l16 + "ms";
    String str3 = str1;
    String str4 = str2;
    gj.a(str3, str4);
    TextView localTextView1 = this.j;
    String str5 = gs.a(d2, null);
    localTextView1.setText(str5);
    TextView localTextView2 = this.k;
    String str6 = gs.a(d3, null);
    localTextView2.setText(str6);
    TextView localTextView3 = this.l;
    String str7 = gs.a(d4, null);
    localTextView3.setText(str7);
    if (d1 == 0.0D)
      this.l.setText("");
    int i1;
    for (int m = 1; ; i1 = 0)
    {
      BatteryView localBatteryView = this.n;
      float f1 = (float)(d4 / d1);
      localBatteryView.a(f1, m);
      TextView localTextView4 = this.s;
      String str8 = gs.a(d5, null, 0);
      localTextView4.setText(str8);
      TextView localTextView5 = this.t;
      double d9 = d6;
      String str9 = null;
      int i2 = 1;
      String str10 = gs.a(d9, str9, i2);
      localTextView5.setText(str10);
      TextView localTextView6 = this.w;
      double d10 = d7;
      String str11 = null;
      int i3 = 0;
      String str12 = gs.a(d10, str11, i3);
      localTextView6.setText(str12);
      TextView localTextView7 = this.x;
      double d11 = d8;
      String str13 = null;
      int i4 = 1;
      String str14 = gs.a(d11, str13, i4);
      localTextView7.setText(str14);
      TextView localTextView8 = this.A;
      String str15 = gs.a(d3, null, 0);
      localTextView8.setText(str15);
      TextView localTextView9 = this.B;
      String str16 = gs.a(d2, null, 1);
      localTextView9.setText(str16);
      int i5 = 0;
      this.g = i5;
      return;
      TextView localTextView10 = this.l;
      String str17 = gs.a(d4, null);
      localTextView10.setText(str17);
    }
  }

  void a()
  {
    Uri localUri = Uri.parse("http://wap.crossmo.com/");
    Intent localIntent1 = new Intent("android.intent.action.VIEW", localUri);
    Intent localIntent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    Intent localIntent3 = localIntent2.putExtra("android.intent.extra.shortcut.NAME", "十字猫");
    Intent localIntent4 = localIntent2.putExtra("android.intent.extra.shortcut.INTENT", localIntent1);
    Intent.ShortcutIconResource localShortcutIconResource = Intent.ShortcutIconResource.fromContext(this, 2130837909);
    Intent localIntent5 = localIntent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", localShortcutIconResource);
    Intent localIntent6 = localIntent2.putExtra("duplicate", 0);
    sendBroadcast(localIntent2);
  }

  void b()
  {
    Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    String str1 = getString(2131492865);
    Intent localIntent2 = localIntent1.putExtra("android.intent.extra.shortcut.NAME", str1);
    Intent localIntent3 = localIntent1.putExtra("duplicate", 0);
    Intent localIntent4 = new Intent();
    String str2 = getPackageName();
    ComponentName localComponentName = new ComponentName(str2, "com.mymoney.ui.splash.SplashScreenActivity");
    Intent localIntent5 = localIntent4.setComponent(localComponentName);
    Intent localIntent6 = localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent4);
    Intent.ShortcutIconResource localShortcutIconResource = Intent.ShortcutIconResource.fromContext(this, 2130837739);
    Intent localIntent7 = localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", localShortcutIconResource);
    sendBroadcast(localIntent1);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230812:
      long l1 = gi.h();
      long l2 = gi.i();
      int m = NavTransactionActivity.f;
      a(l1, l2, "流水清单-本月", m);
      return;
    case 2131230817:
      i();
      return;
    case 2131230818://add_expense_quickly_btn
      k();
      return;
    case 2131230819:
      long l3 = gi.a();
      long l4 = gi.b();
      int i1 = NavTransactionActivity.h;
      a(l3, l4, "流水清单-按天", i1);
      return;
    case 2131230827:
      long l5 = gi.c();
      long l6 = gi.d();
      int i2 = NavTransactionActivity.g;
      a(l5, l6, "流水清单-按周", i2);
      return;
    case 2131230832:
      long l7 = gi.h();
      long l8 = gi.i();
      int i3 = NavTransactionActivity.f;
      a(l7, l8, "流水清单-按月", i3);
      return;
    case 2131230833:
      k();
      return;
    case 2131230840:
      j();
      return;
    case 2131230841:
      n();
      return;
    case 2131230842:
      o();
      return;
    case 2131230843:
      i();
      return;
    case 2131230844:
    }
    p();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903066);
    a = this;
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131230812);
    this.h = localLinearLayout;
    TextView localTextView1 = (TextView)findViewById(2131230813);
    this.i = localTextView1;
    TextView localTextView2 = (TextView)findViewById(2131230814);
    this.j = localTextView2;
    TextView localTextView3 = (TextView)findViewById(2131230815);
    this.k = localTextView3;
    TextView localTextView4 = (TextView)findViewById(2131230816);
    this.l = localTextView4;
    BatteryView localBatteryView = (BatteryView)findViewById(2131230817);
    this.n = localBatteryView;
    Button localButton1 = (Button)findViewById(2131230818);
    this.o = localButton1;
    RelativeLayout localRelativeLayout1 = (RelativeLayout)findViewById(2131230819);
    this.p = localRelativeLayout1;
    TextView localTextView5 = (TextView)findViewById(2131230822);
    this.q = localTextView5;
    TextView localTextView6 = (TextView)findViewById(2131230824);
    this.r = localTextView6;
    TextView localTextView7 = (TextView)findViewById(2131230825);
    this.s = localTextView7;
    TextView localTextView8 = (TextView)findViewById(2131230826);
    this.t = localTextView8;
    RelativeLayout localRelativeLayout2 = (RelativeLayout)findViewById(2131230827);
    this.u = localRelativeLayout2;
    TextView localTextView9 = (TextView)findViewById(2131230829);
    this.v = localTextView9;
    TextView localTextView10 = (TextView)findViewById(2131230830);
    this.w = localTextView10;
    TextView localTextView11 = (TextView)findViewById(2131230831);
    this.x = localTextView11;
    RelativeLayout localRelativeLayout3 = (RelativeLayout)findViewById(2131230832);
    this.y = localRelativeLayout3;
    TextView localTextView12 = (TextView)findViewById(2131230835);
    this.z = localTextView12;
    TextView localTextView13 = (TextView)findViewById(2131230836);
    this.A = localTextView13;
    TextView localTextView14 = (TextView)findViewById(2131230837);
    this.B = localTextView14;
    Button localButton2 = (Button)findViewById(2131230840);
    this.C = localButton2;
    Button localButton3 = (Button)findViewById(2131230841);
    this.D = localButton3;
    Button localButton4 = (Button)findViewById(2131230842);
    this.E = localButton4;
    Button localButton5 = (Button)findViewById(2131230843);
    this.F = localButton5;
    Button localButton6 = (Button)findViewById(2131230844);
    this.G = localButton6;
    this.h.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.G.setOnClickListener(this);
    Calendar localCalendar = Calendar.getInstance();
    int m = localCalendar.get(1);
    this.O = m;
    int i1 = localCalendar.get(2) + 1;
    this.P = i1;
    int i2 = localCalendar.get(5);
    this.Q = i2;
    long l1 = gi.c();
    String str1 = gi.b(new Date(l1), "MM月dd日");
    long l2 = gi.d();
    String str2 = gi.b(new Date(l2), "MM月dd日");
    long l3 = gi.h();
    String str3 = gi.b(new Date(l3), "MM月dd日");
    long l4 = gi.i();
    String str4 = gi.b(new Date(l4), "MM月dd日");
    AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
    this.N = localAlarmManager;
    TextView localTextView15 = this.i;
    String str5 = String.valueOf(this.P);
    localTextView15.setText(str5);
    TextView localTextView16 = this.q;
    String str6 = String.valueOf(this.Q);
    localTextView16.setText(str6);
    TextView localTextView17 = this.r;
    String str7 = gi.b(localCalendar.getTime(), "yyyy年MM月dd日");
    localTextView17.setText(str7);
    TextView localTextView18 = this.v;
    String str8 = str1 + "-" + str2;
    localTextView18.setText(str8);
    TextView localTextView19 = this.z;
    String str9 = str3 + "-" + str4;
    localTextView19.setText(str9);
    lm locallm = new lm(this, null);
    dz localdz1 = dz.a();
    String str10 = ea.b;
    localdz1.a(str10, locallm);
    dz localdz2 = dz.a();
    String str11 = ea.c;
    localdz2.a(str11, locallm);
    dz localdz3 = dz.a();
    String str12 = ea.d;
    localdz3.a(str12, locallm);
    dz localdz4 = dz.a();
    String str13 = ea.o;
    localdz4.a(str13, locallm);
    dz localdz5 = dz.a();
    String str14 = ea.n;
    localdz5.a(str14, locallm);
    dz localdz6 = dz.a();
    String str15 = ea.p;
    localdz6.a(str15, locallm);
    dz localdz7 = dz.a();
    String str16 = ea.s;
    localdz7.a(str16, locallm);
    dz localdz8 = dz.a();
    String str17 = ea.t;
    localdz8.a(str17, locallm);
    dz localdz9 = dz.a();
    String str18 = ea.u;
    localdz9.a(str18, locallm);
    dz localdz10 = dz.a();
    String str19 = ea.r;
    localdz10.a(str19, locallm);
    dz localdz11 = dz.a();
    String str20 = ea.q;
    localdz11.a(str20, locallm);
    lr locallr1 = new lr(this);
    this.K = locallr1;
    IntentFilter localIntentFilter1 = new IntentFilter();
    String str21 = c;
    localIntentFilter1.addAction(str21);
    Context localContext1 = a;
    lr locallr2 = this.K;
    Intent localIntent1 = localContext1.registerReceiver(locallr2, localIntentFilter1);
    lo locallo1 = new lo(this);
    this.L = locallo1;
    IntentFilter localIntentFilter2 = new IntentFilter();
    String str22 = d;
    localIntentFilter2.addAction(str22);
    Context localContext2 = a;
    lo locallo2 = this.L;
    Intent localIntent2 = localContext2.registerReceiver(locallo2, localIntentFilter2);
    lj locallj1 = new lj(this);
    this.M = locallj1;
    IntentFilter localIntentFilter3 = new IntentFilter();
    String str23 = e;
    localIntentFilter3.addAction(str23);
    Context localContext3 = a;
    lj locallj2 = this.M;
    Intent localIntent3 = localContext3.registerReceiver(locallj2, localIntentFilter3);
    if (gu.k())
    {
      b();
      if ((gt.l()) || (gt.m()))
        a();
      gu.e(0);
    }
    if (!gu.v())
    {
      c();
      gu.j(1);
      gu.i(1);
    }
    e();
    q();
    f();
    d();
    if (!gt.d(this))
      return;
    gq.a(this);
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 0:
    case 1:
    }
    while (true)
    {
      return localObject;
      Context localContext = a;
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle("温馨提示").setMessage("你确定要退出吗?");
      lf locallf = new lf(this);
      AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton("确定", locallf);
      le localle = new le(this);
      localObject = localBuilder2.setNegativeButton(2131492875, localle).create();
      continue;
      AlertDialog.Builder localBuilder3 = new AlertDialog.Builder(this);
      StringBuilder localStringBuilder = new StringBuilder();
      String str1 = gt.e();
      String str2 = str1 + "版本更新内容如下";
      AlertDialog.Builder localBuilder4 = localBuilder3.setTitle(str2).setMessage(2131492910);
      lh locallh = new lh(this);
      AlertDialog.Builder localBuilder5 = localBuilder4.setPositiveButton("确定", locallh);
      lg locallg = new lg(this);
      localObject = localBuilder5.setNeutralButton("取消", locallg).setCancelable(1).create();
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623940, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    Context localContext1 = a;
    lr locallr = this.K;
    localContext1.unregisterReceiver(locallr);
    Context localContext2 = a;
    lj locallj = this.M;
    localContext2.unregisterReceiver(locallj);
    Context localContext3 = a;
    lo locallo = this.L;
    localContext3.unregisterReceiver(locallo);
    g();
    if (gt.d(this))
      gq.b(this);
    ApplicationContext.b.close();
    Process.killProcess(Process.myPid());
    super.onDestroy();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131231180:
    case 2131231181:
    case 2131231182:
    case 2131231183:
    case 2131231184:
    case 2131231185:
    case 2131231179:
    case 2131231186:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      k();
      continue;
      l();
      continue;
      m();
      continue;
      n();
      continue;
      o();
      continue;
      i();
      continue;
      h();
      continue;
      p();
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
    if (this.g)
      q();
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
 * Qualified Name:     com.mymoney.ui.main.MainActivity
 * JD-Core Version:    0.6.0
 */