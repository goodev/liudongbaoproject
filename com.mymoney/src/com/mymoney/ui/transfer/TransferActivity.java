package com.mymoney.ui.transfer;

import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.mymoney.core.application.ApplicationContext;
import com.mymoney.core.vo.AccountGroupVo;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.ProjectVo;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.base.BaseActivity;
import e;
import g;
import gi;
import gs;
import hb;
import j;
import java.util.HashMap;
import kn;
import kt;
import m;
import so;
import sp;
import sq;
import sr;
import ss;
import st;
import su;
import sv;
import sw;

public class TransferActivity extends BaseActivity
  implements View.OnClickListener, View.OnFocusChangeListener, AdapterView.OnItemSelectedListener
{
  public static String a = TransferActivity.class.getSimpleName();
  private static Context b;
  private AccountVo A;
  private long B;
  private ProjectVo C;
  private String D;
  private boolean E;
  private boolean F;
  private boolean G;
  private e H;
  private m I;
  private j J;
  private int c;
  private Button d;
  private Button e;
  private TextView f;
  private Spinner g;
  private Spinner h;
  private EditText i;
  private LinearLayout j;
  private EditText k;
  private EditText l;
  private Button n;
  private Spinner o;
  private Button p;
  private kn q;
  private kn r;
  private kt s;
  private TransactionVo t;
  private HashMap u;
  private long v;
  private double w;
  private double x;
  private AccountVo y;
  private double z;

  public TransferActivity()
  {
    TransactionVo localTransactionVo = new TransactionVo();
    this.t = localTransactionVo;
    this.D = "";
    this.E = 1;
    this.F = 1;
    this.G = 1;
    e locale = g.a().c();
    this.H = locale;
    m localm = g.a().b();
    this.I = localm;
    j localj = g.a().k();
    this.J = localj;
  }

  private void a(String paramString)
  {
    su localsu = new su(this, null);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString;
    AsyncTask localAsyncTask = localsu.execute(arrayOfString);
  }

  private void b()
  {
    if (d())
    {
      this.i.setVisibility(0);
      this.j.setVisibility(8);
      this.j.setBackgroundResource(2130838064);
      return;
    }
    this.i.setVisibility(8);
    this.j.setVisibility(0);
    this.j.setBackgroundResource(2130838069);
  }

  private void c()
  {
    EditText localEditText1 = this.i;
    sp localsp = new sp(this);
    localEditText1.addTextChangedListener(localsp);
    EditText localEditText2 = this.l;
    sq localsq = new sq(this);
    localEditText2.addTextChangedListener(localsq);
    EditText localEditText3 = this.k;
    sr localsr = new sr(this);
    localEditText3.addTextChangedListener(localsr);
  }

  private boolean d()
  {
    int m;
    if ((this.y == null) || (this.A == null))
      m = 0;
    while (true)
    {
      return m;
      String str1 = this.y.d();
      String str2 = this.A.d();
      if (str1.equalsIgnoreCase(str2))
      {
        m = 1;
        continue;
      }
      m = 0;
    }
  }

  private void e()
  {
    long l1 = this.y.a();
    long l2 = this.A.a();
    if (l1 == l2)
    {
      hb.b(b, "转出账户和转入账户不能相同");
      return;
    }
    if ((this.y.a() == 0L) || (this.A.a() == 0L))
    {
      hb.b(b, "数据不完整");
      return;
    }
    String str1 = this.i.getText().toString();
    String str2 = this.k.getText().toString();
    String str3 = this.l.getText().toString();
    if (d())
    {
      if (TextUtils.isEmpty(str1))
      {
        hb.b(ApplicationContext.a, "请填写转账金额");
        return;
      }
    }
    else if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
    {
      hb.b(ApplicationContext.a, "请填写转账金额");
      return;
    }
    int m = this.y.c().d();
    int i1 = this.A.c().d();
    switch (m)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      int i2 = 0;
      try
      {
        if (d())
        {
          double d1 = Double.parseDouble(str1);
          this.w = d1;
        }
        while (true)
        {
          i3 = i2;
          if (i3 == 0)
            break label328;
          hb.b(b, "输入的转账金额不合法,金额只能为数字");
          return;
          if (1 != i1)
            break;
          hb.b(b, "负债类账户不能转账到负债类账户");
          return;
          if (1 == i1)
          {
            hb.b(b, "债权类账户不能转账到负债类账户");
            return;
          }
          if (2 != i1)
            break;
          hb.b(b, "债权类账户不能转账到债权类账户");
          return;
          double d2 = Double.parseDouble(str2);
          this.x = d2;
          double d3 = Double.parseDouble(str3);
          this.z = d3;
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          localException.printStackTrace();
          int i3 = 1;
        }
        label328: if (d())
        {
          if (this.w < 0.0D)
          {
            hb.b(b, "输入的转账金额不合法,不能为负值");
            return;
          }
          if (this.w == 0.0D)
          {
            hb.b(b, "请输入转账金额,金额不能为0");
            return;
          }
        }
        else
        {
          if (this.x < 0.0D)
          {
            hb.b(b, "输入的转账金额不合法,不能为负值");
            return;
          }
          if (this.x == 0.0D)
          {
            hb.b(b, "请输入转账金额,金额不能为0");
            return;
          }
          if (this.z < 0.0D)
          {
            hb.b(b, "输入的转账金额不合法,不能为负值");
            return;
          }
          if (this.z == 0.0D)
          {
            hb.b(b, "请输入转账金额,金额不能为0");
            return;
          }
        }
        f();
      }
    }
  }

  private void f()
  {
    sw localsw = new sw(this);
    Void[] arrayOfVoid = new Void[0];
    AsyncTask localAsyncTask = localsw.execute(arrayOfVoid);
  }

  private void g()
  {
    sv localsv = new sv(this);
    Void[] arrayOfVoid = new Void[0];
    AsyncTask localAsyncTask = localsv.execute(arrayOfVoid);
  }

  private boolean h()
  {
    int m = this.c;
    if (1 == m);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private boolean i()
  {
    int m = this.c;
    if (2 == m);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131231136:
      int m = gi.b(this.B);
      int i1 = gi.c(this.B);
      int i2 = gi.d(this.B);
      Context localContext = b;
      so localso = new so(this);
      new DatePickerDialog(localContext, localso, m, i1, i2).show();
      return;
    case 2131231133:
      this.j.setBackgroundResource(2130838069);
      return;
    case 2131231134:
      this.j.setBackgroundResource(2130838068);
      return;
    case 2131230748:
      showDialog(1);
      return;
    case 2131230807:
      finish();
      return;
    case 2131230808:
    }
    e();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903123);
    b = this;
    TextView localTextView = (TextView)findViewById(2131230730);
    this.f = localTextView;
    Button localButton1 = (Button)findViewById(2131230807);
    this.d = localButton1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.e = localButton2;
    Spinner localSpinner1 = (Spinner)findViewById(2131231127);
    this.g = localSpinner1;
    Spinner localSpinner2 = (Spinner)findViewById(2131231129);
    this.h = localSpinner2;
    EditText localEditText1 = (EditText)findViewById(2131231135);
    this.i = localEditText1;
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131231132);
    this.j = localLinearLayout;
    EditText localEditText2 = (EditText)findViewById(2131231133);
    this.k = localEditText2;
    EditText localEditText3 = (EditText)findViewById(2131231134);
    this.l = localEditText3;
    Button localButton3 = (Button)findViewById(2131231136);
    this.n = localButton3;
    Spinner localSpinner3 = (Spinner)findViewById(2131230747);
    this.o = localSpinner3;
    Button localButton4 = (Button)findViewById(2131230748);
    this.p = localButton4;
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.g.setOnItemSelectedListener(this);
    this.h.setOnItemSelectedListener(this);
    this.k.setOnClickListener(this);
    this.k.setOnFocusChangeListener(this);
    this.l.setOnClickListener(this);
    this.l.setOnFocusChangeListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnItemSelectedListener(this);
    this.p.setOnClickListener(this);
    Context localContext1 = ApplicationContext.a;
    kn localkn1 = new kn(localContext1, 2130903113);
    this.q = localkn1;
    this.q.a(2130903111);
    Spinner localSpinner4 = this.g;
    kn localkn2 = this.q;
    localSpinner4.setAdapter(localkn2);
    Context localContext2 = ApplicationContext.a;
    kn localkn3 = new kn(localContext2, 2130903113);
    this.r = localkn3;
    this.r.a(2130903111);
    Spinner localSpinner5 = this.h;
    kn localkn4 = this.r;
    localSpinner5.setAdapter(localkn4);
    Context localContext3 = ApplicationContext.a;
    kt localkt1 = new kt(localContext3, 2130903116);
    this.s = localkt1;
    this.s.a(2130903111);
    Spinner localSpinner6 = this.o;
    kt localkt2 = this.s;
    localSpinner6.setAdapter(localkt2);
    this.e.setText("保存");
    Object localObject = getIntent();
    int m = ((Intent)localObject).getIntExtra("state", 1);
    this.c = m;
    String str2;
    if (h())
    {
      long l1 = gi.k();
      this.B = l1;
      this.f.setText("新增转账");
      double d1 = ((Intent)localObject).getDoubleExtra("cost", 0.0D);
      this.w = d1;
      String str1 = ((Intent)localObject).getStringExtra("memo");
      this.D = str1;
      localObject = this.i;
      if (this.w == 0.0D)
      {
        str2 = "";
        ((EditText)localObject).setText(str2);
      }
    }
    do
    {
      Button localButton5 = this.n;
      String str3 = gi.f(this.B);
      localButton5.setText(str3);
      Button localButton6 = this.p;
      String str4 = this.D;
      localButton6.setText(str4);
      boolean bool = this.g.requestFocus();
      g();
      return;
      str2 = gs.a(this.w);
      break;
    }
    while (!i());
    long l2 = ((Intent)localObject).getLongExtra("id", 0L);
    this.v = l2;
    if (this.v == 0L)
    {
      hb.b(b, "id参数错误");
      finish();
    }
    m localm = this.I;
    long l3 = this.v;
    TransactionVo localTransactionVo = localm.a(l3);
    this.t = localTransactionVo;
    double d2 = this.t.b();
    this.w = d2;
    AccountVo localAccountVo1 = this.t.g();
    this.y = localAccountVo1;
    AccountVo localAccountVo2 = this.t.p();
    this.A = localAccountVo2;
    long l4 = this.t.j();
    this.B = l4;
    ProjectVo localProjectVo = this.t.i();
    this.C = localProjectVo;
    String str5 = this.t.c();
    this.D = str5;
    this.f.setText("编辑转账");
    this.g.setBackgroundResource(2130838082);
    this.h.setBackgroundResource(2130838082);
    if (d())
    {
      EditText localEditText4 = this.i;
      String str6 = gs.a(this.w);
      localEditText4.setText(str6);
      c();
    }
    while (true)
    {
      b();
      break;
      double d3 = this.t.b();
      this.x = d3;
      String str7 = this.t.o();
      a(str7);
    }
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject = LayoutInflater.from(b);
    switch (paramInt)
    {
    default:
    case 1:
    }
    AlertDialog.Builder localBuilder2;
    ss localss;
    for (localObject = super.onCreateDialog(paramInt); ; localObject = localBuilder2.setNegativeButton(2131492875, localss).create())
    {
      return localObject;
      View localView = ((LayoutInflater)localObject).inflate(2130903057, null);
      EditText localEditText = (EditText)localView.findViewById(2131230776);
      String str = this.D;
      localEditText.setText(str);
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this).setTitle("备注").setView(localView);
      st localst = new st(this, localEditText);
      localBuilder2 = localBuilder1.setPositiveButton("保存", localst);
      localss = new ss(this, localEditText);
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623949, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
      return;
    switch (paramView.getId())
    {
    default:
      return;
    case 2131231133:
      this.j.setBackgroundResource(2130838069);
      return;
    case 2131231134:
    }
    String str1 = this.k.getText().toString();
    double d1 = 0.0D;
    try
    {
      double d2 = Double.parseDouble(str1);
      d3 = d2;
      m = 0;
      if (m == 0)
      {
        j localj = this.J;
        String str2 = this.y.d();
        String str3 = this.A.d();
        double d4 = localj.a(str2, str3);
        EditText localEditText = this.l;
        String str4 = gs.a(d3 * d4);
        localEditText.setText(str4);
      }
      this.j.setBackgroundResource(2130838068);
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        double d5 = d1;
        int m = 1;
        double d3 = d5;
      }
    }
  }

  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramAdapterView.getId())
    {
    default:
      return;
    case 2131231127:
      HashMap localHashMap1 = this.u;
      Long localLong1 = Long.valueOf(paramLong);
      AccountVo localAccountVo1 = (AccountVo)localHashMap1.get(localLong1);
      this.y = localAccountVo1;
      b();
      return;
    case 2131231129:
      HashMap localHashMap2 = this.u;
      Long localLong2 = Long.valueOf(paramLong);
      AccountVo localAccountVo2 = (AccountVo)localHashMap2.get(localLong2);
      this.A = localAccountVo2;
      b();
      return;
    case 2131230747:
    }
    ProjectVo localProjectVo = new ProjectVo();
    this.C = localProjectVo;
    this.C.a(paramLong);
  }

  public void onNothingSelected(AdapterView paramAdapterView)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131231182:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      boolean bool = this.e.performClick();
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.transfer.TransferActivity
 * JD-Core Version:    0.6.0
 */