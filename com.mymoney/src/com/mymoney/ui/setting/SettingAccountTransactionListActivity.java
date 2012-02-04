package com.mymoney.ui.setting;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mymoney.core.application.ApplicationContext;
import com.mymoney.core.vo.AccountGroupVo;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;
import com.mymoney.ui.base.BaseActivity;
import dz;
import e;
import ea;
import g;
import gj;
import gs;
import gu;
import hb;
import java.util.ArrayList;
import java.util.List;
import m;
import oh;
import ok;
import ol;
import tz;

public class SettingAccountTransactionListActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static long e;
  private static String f = "SettingAccountTransactionNavActivity";
  private static Context g;
  private TextView h;
  private Button i;
  private Button j;
  private RelativeLayout k;
  private TextView l;
  private TextView n;
  private TextView o;
  private LinearLayout p;
  private ListView q;
  private long r;
  private AccountVo s;
  private List t;
  private tz u;
  private e v;
  private m w;

  static
  {
    a = "accountId";
    b = "accountId";
    c = "account";
    d = "transList";
    e = 0L;
  }

  public SettingAccountTransactionListActivity()
  {
    e locale = g.a().c();
    this.v = locale;
    m localm = g.a().b();
    this.w = localm;
  }

  private void a(long paramLong, int paramInt)
  {
    Context localContext = g;
    Intent localIntent1 = new Intent(localContext, SettingAddOrEditAccountActivity.class);
    Intent localIntent2 = localIntent1.putExtra("mode", 0);
    Intent localIntent3 = localIntent1.putExtra("id", paramLong);
    Intent localIntent4 = localIntent1.putExtra("accountType", paramInt);
    startActivity(localIntent1);
  }

  private void b(long paramLong, int paramInt)
  {
    if (gu.h())
    {
      Context localContext1 = g;
      Intent localIntent1 = new Intent(localContext1, AddOrEditTransNewActivity.class);
      Intent localIntent2 = localIntent1.putExtra("state", 2);
      Intent localIntent3 = localIntent1.putExtra("transType", paramInt);
      Intent localIntent4 = localIntent1.putExtra("id", paramLong);
      startActivity(localIntent1);
      return;
    }
    Context localContext2 = g;
    Intent localIntent5 = new Intent(localContext2, AddOrEditTransactionActivity.class);
    Intent localIntent6 = localIntent5.putExtra("state", 3);
    Intent localIntent7 = localIntent5.putExtra("transType", paramInt);
    Intent localIntent8 = localIntent5.putExtra("id", paramLong);
    startActivity(localIntent5);
  }

  private void c()
  {
    e locale = this.v;
    long l1 = this.r;
    AccountVo localAccountVo = locale.d(l1);
    this.s = localAccountVo;
    d();
    e();
  }

  private void d()
  {
    TextView localTextView1 = this.l;
    String str1 = this.s.b();
    localTextView1.setText(str1);
    TextView localTextView2 = this.n;
    String str2 = this.s.c().c().b();
    localTextView2.setText(str2);
    double d1 = 0.0D;
    String str3 = this.s.d();
    switch (this.s.c().c().d())
    {
    default:
    case 0:
    case 2:
    case 1:
    }
    while (true)
    {
      TextView localTextView3 = this.o;
      String str4 = gs.a(d1, str3);
      localTextView3.setText(str4);
      return;
      d1 = this.s.e();
      continue;
      d1 = this.s.f();
      continue;
      d1 = this.s.g();
    }
  }

  private void e()
  {
    AsyncTask localAsyncTask = new ol(this).execute(null);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230807:
      finish();
      return;
    case 2131231008:
    }
    long l1 = this.s.a();
    int m = this.s.c().d();
    a(l1, m);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903083);
    g = this;
    Button localButton1 = (Button)findViewById(2131230807);
    this.i = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.h = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.j = localButton2;
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131231008);
    this.k = localRelativeLayout;
    TextView localTextView2 = (TextView)findViewById(2131230766);
    this.l = localTextView2;
    TextView localTextView3 = (TextView)findViewById(2131231009);
    this.n = localTextView3;
    TextView localTextView4 = (TextView)findViewById(2131231010);
    this.o = localTextView4;
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131231006);
    this.p = localLinearLayout;
    ListView localListView = (ListView)findViewById(2131231007);
    this.q = localListView;
    Intent localIntent = getIntent();
    String str1 = a;
    long l1 = e;
    long l2 = localIntent.getLongExtra(str1, l1);
    this.r = l2;
    long l3 = this.r;
    long l4 = e;
    if (l3 == l4)
    {
      hb.b(g, "系统错误");
      finish();
    }
    this.i.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.q.setOnItemClickListener(this);
    this.q.setOnItemLongClickListener(this);
    this.j.setVisibility(4);
    this.h.setText("账户流水");
    Handler localHandler = new Handler();
    ok localok = new ok(this, localHandler);
    dz localdz1 = dz.a();
    String str2 = ea.b;
    localdz1.a(str2, localok);
    dz localdz2 = dz.a();
    String str3 = ea.c;
    localdz2.a(str3, localok);
    dz localdz3 = dz.a();
    String str4 = ea.d;
    localdz3.a(str4, localok);
    dz localdz4 = dz.a();
    String str5 = ea.f;
    localdz4.a(str5, localok);
    c();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramAdapterView.getId())
    {
    default:
      return;
    case 2131231007:
    }
    TransactionVo localTransactionVo = (TransactionVo)this.u.getItem(paramInt);
    long l1 = localTransactionVo.a();
    int m = localTransactionVo.k();
    if ((1 == m) || (m == 0))
    {
      b(l1, m);
      return;
    }
    if ((2 == m) || (3 == m) || (4 == m) || (5 == m) || (6 == m) || (7 == m))
    {
      hb.b(ApplicationContext.a, "请到流水里编辑转帐");
      return;
    }
    hb.b(ApplicationContext.a, "抱歉,余额变更不可以编辑");
  }

  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramAdapterView.getId())
    {
    default:
    case 2131231007:
    }
    while (true)
    {
      return false;
      TransactionVo localTransactionVo = (TransactionVo)this.u.getItem(paramInt);
      long l1 = localTransactionVo.a();
      int m = localTransactionVo.k();
      Context localContext = g;
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(localContext).setTitle("流水操作");
      oh localoh = new oh(this, m, l1);
      localBuilder.setItems(2131165185, localoh).setNegativeButton("取消", null).create().show();
    }
  }

  protected void onPause()
  {
    gj.a(f, "onPause()");
    super.onPause();
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    gj.a(f, "onRestoreInstanceState()");
    String str1 = b;
    long l1 = paramBundle.getLong(str1);
    this.r = l1;
    String str2 = c;
    AccountVo localAccountVo = (AccountVo)paramBundle.get(str2);
    this.s = localAccountVo;
    String str3 = d;
    ArrayList localArrayList = paramBundle.getParcelableArrayList(str3);
    this.t = localArrayList;
    super.onRestoreInstanceState(paramBundle);
  }

  protected void onResume()
  {
    gj.a(f, "onResume()");
    super.onResume();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    gj.a(f, "onSaveInstanceState()");
    String str1 = b;
    long l1 = this.r;
    paramBundle.putLong(str1, l1);
    String str2 = c;
    AccountVo localAccountVo = this.s;
    paramBundle.putParcelable(str2, localAccountVo);
    String str3 = d;
    ArrayList localArrayList = (ArrayList)this.t;
    paramBundle.putParcelableArrayList(str3, localArrayList);
    super.onSaveInstanceState(paramBundle);
  }

  protected void onStop()
  {
    gj.a(f, "onStop()");
    super.onStop();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingAccountTransactionListActivity
 * JD-Core Version:    0.6.0
 */