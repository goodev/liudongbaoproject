package com.mymoney.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.mymoney.core.vo.AccountGroupVo;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.base.BaseActivity;
import d;
import e;
import g;
import gi;
import hb;
import hk;
import j;
import java.util.List;
import k;
import kj;
import m;
import pg;

public class SettingAddOrEditAccountActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener
{
  public static Context a;
  private j A;
  private m B;
  private k C;
  private kj D;
  private kj E;
  private List F;
  private List G;
  private long H;
  private String I;
  private double J;
  private String K;
  private boolean L;
  private String M;
  private String N;
  private double O;
  private AccountVo P;
  private AccountGroupVo Q;
  private int b;
  private int c;
  private boolean d = 1;
  private Button e;
  private Button f;
  private TextView g;
  private LinearLayout h;
  private EditText i;
  private LinearLayout j;
  private TextView k;
  private EditText l;
  private EditText n;
  private LinearLayout o;
  private LinearLayout p;
  private TextView q;
  private CheckBox r;
  private LinearLayout s;
  private TextView t;
  private Spinner u;
  private ImageView v;
  private Spinner w;
  private ImageView x;
  private e y;
  private d z;

  public SettingAddOrEditAccountActivity()
  {
    e locale = g.a().c();
    this.y = locale;
    d locald = g.a().i();
    this.z = locald;
    j localj = g.a().k();
    this.A = localj;
    m localm = g.a().b();
    this.B = localm;
    k localk = g.a().h();
    this.C = localk;
    this.J = 0.0D;
    this.O = 0.0D;
  }

  private void a()
  {
    String str1 = this.i.getText().toString();
    this.I = str1;
    String str2 = this.l.getText().toString();
    String str3 = this.n.getText().toString();
    this.M = str3;
    boolean bool1 = this.r.isChecked();
    this.L = bool1;
    if (TextUtils.isEmpty(this.I))
    {
      hb.b(a, "账户名不能为空");
      return;
    }
    if (TextUtils.isEmpty(str2))
    {
      hb.b(a, "余额不能为空");
      return;
    }
    int m = this.Q.c().d();
    try
    {
      double d1 = Double.valueOf(str2).doubleValue();
      this.J = d1;
      switch (m)
      {
      default:
      case 1:
        while (true)
        {
          i1 = 0;
          if (i1 == 0)
            break label276;
          if (1 != m)
            break;
          hb.b(a, "负债金额填写不正确,只能为数字");
          return;
          AccountVo localAccountVo1 = this.P;
          double d2 = this.J;
          localAccountVo1.c(d2);
        }
      case 2:
      case 0:
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        int i1 = 1;
        continue;
        AccountVo localAccountVo2 = this.P;
        double d3 = this.J;
        localAccountVo2.b(d3);
        continue;
        AccountVo localAccountVo3 = this.P;
        double d4 = this.J;
        localAccountVo3.a(d4);
      }
      if (2 == m)
      {
        hb.b(a, "债权金额填写不正确,只能为数字");
        return;
      }
      if (m != 0)
        return;
      hb.b(a, "余额金额填写不正确,只能为数字");
      return;
    }
    label276: AccountVo localAccountVo4 = this.P;
    String str4 = this.I;
    localAccountVo4.a(str4);
    AccountVo localAccountVo5 = this.P;
    String str5 = this.M;
    localAccountVo5.c(str5);
    AccountVo localAccountVo6 = this.P;
    boolean bool2 = this.L;
    localAccountVo6.a(bool2);
    AccountVo localAccountVo7 = this.P;
    String str6 = this.K;
    localAccountVo7.b(str6);
    AccountVo localAccountVo8 = this.P;
    AccountGroupVo localAccountGroupVo = this.Q;
    localAccountVo8.a(localAccountGroupVo);
    int i2 = this.b;
    int i3;
    if (1 == i2)
    {
      e locale1 = this.y;
      String str7 = this.I;
      if (locale1.a(str7))
      {
        hb.b(a, "对不起,该账户已经存在!");
        return;
      }
      e locale2 = this.y;
      AccountVo localAccountVo9 = this.P;
      long l1 = locale2.a(localAccountVo9);
      if (l1 != 0L)
      {
        i3 = 1;
        this.P.a(l1);
      }
    }
    while (true)
    {
      label461: double d5 = this.J;
      double d6 = this.O;
      double d7 = d5 - d6;
      TransactionVo localTransactionVo;
      if (d7 != 0.0D)
      {
        localTransactionVo = new TransactionVo();
        localTransactionVo.a(d7);
        AccountVo localAccountVo10 = this.P;
        localTransactionVo.a(localAccountVo10);
        long l2 = gi.k();
        localTransactionVo.b(l2);
        switch (m)
        {
        default:
        case 0:
        case 1:
        case 2:
        }
      }
      while (true)
      {
        if (i3 == 0)
          break label753;
        hb.b(a, "保存成功.");
        finish();
        return;
        i3 = 0;
        break;
        if (this.b != 0)
          break label763;
        String str8 = this.N;
        String str9 = this.I;
        if (!str8.equalsIgnoreCase(str9))
        {
          e locale3 = this.y;
          AccountVo localAccountVo11 = this.P;
          if (locale3.c(localAccountVo11))
          {
            hb.b(a, "对不起,该账户已经存在!");
            return;
          }
        }
        e locale4 = this.y;
        AccountVo localAccountVo12 = this.P;
        boolean bool3 = locale4.b(localAccountVo12);
        break label461;
        localTransactionVo.a("余额变更");
        bool3 = this.B.a(localTransactionVo, 8);
        continue;
        localTransactionVo.a("负债金额变更");
        bool3 = this.B.a(localTransactionVo, 9);
        continue;
        localTransactionVo.a("债权金额变更");
        bool3 = this.B.a(localTransactionVo, 10);
      }
      label753: hb.b(a, "抱歉,软件故障,操作失败.");
      return;
      label763: int i4 = 1;
    }
  }

  private void b()
  {
    AsyncTask localAsyncTask = new pg(this).execute(null);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (2 == paramInt1)
    {
      if (1 != paramInt2)
        break label144;
      String str1 = paramIntent.getStringExtra("currencyCode");
      this.K = str1;
      AccountVo localAccountVo = this.P;
      String str2 = this.K;
      localAccountVo.b(str2);
      j localj = this.A;
      String str3 = this.K;
      hk localhk = localj.a(str3);
      TextView localTextView = this.t;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str4 = localhk.b();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str4).append("(");
      String str5 = localhk.c();
      String str6 = str5 + ")";
      localTextView.setText(str6);
    }
    while (true)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label144: if (2 != paramInt1)
        continue;
    }
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int m = paramCompoundButton.getId();
    if (2131231044 != m)
      return;
    if (paramBoolean)
    {
      this.q.setText("隐藏");
      return;
    }
    this.q.setText("显示");
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
    case 2131230808:
      a();
      return;
    case 2131231038:
      boolean bool1 = this.i.performClick();
      boolean bool2 = this.i.requestFocus();
      return;
    case 2131231039:
      boolean bool3 = this.l.performClick();
      boolean bool4 = this.l.requestFocus();
      return;
    case 2131231042:
      CheckBox localCheckBox = this.r;
      if (!this.r.isChecked());
      int i1;
      for (int m = 1; ; i1 = 0)
      {
        localCheckBox.setChecked(m);
        return;
      }
    case 2131230877:
      boolean bool5 = this.n.performClick();
      boolean bool6 = this.n.requestFocus();
      return;
    case 2131231045:
    }
    Context localContext = a;
    Intent localIntent1 = new Intent(localContext, SettingCurrencySelectActivity.class);
    Intent localIntent2 = localIntent1.putExtra("from", 2);
    String str = this.K;
    Intent localIntent3 = localIntent1.putExtra("currencyCode", str);
    startActivityForResult(localIntent1, 2);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903085);
    a = this;
    Button localButton1 = (Button)findViewById(2131230807);
    this.e = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.g = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.f = localButton2;
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131231038);
    this.h = localLinearLayout1;
    EditText localEditText1 = (EditText)findViewById(2131230754);
    this.i = localEditText1;
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131231039);
    this.j = localLinearLayout2;
    TextView localTextView2 = (TextView)findViewById(2131231040);
    this.k = localTextView2;
    EditText localEditText2 = (EditText)findViewById(2131231041);
    this.l = localEditText2;
    EditText localEditText3 = (EditText)findViewById(2131230776);
    this.n = localEditText3;
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131230877);
    this.o = localLinearLayout3;
    LinearLayout localLinearLayout4 = (LinearLayout)findViewById(2131231042);
    this.p = localLinearLayout4;
    TextView localTextView3 = (TextView)findViewById(2131231043);
    this.q = localTextView3;
    CheckBox localCheckBox = (CheckBox)findViewById(2131231044);
    this.r = localCheckBox;
    LinearLayout localLinearLayout5 = (LinearLayout)findViewById(2131231045);
    this.s = localLinearLayout5;
    TextView localTextView4 = (TextView)findViewById(2131231046);
    this.t = localTextView4;
    Spinner localSpinner1 = (Spinner)findViewById(2131231047);
    this.u = localSpinner1;
    ImageView localImageView1 = (ImageView)findViewById(2131231048);
    this.v = localImageView1;
    Spinner localSpinner2 = (Spinner)findViewById(2131231049);
    this.w = localSpinner2;
    ImageView localImageView2 = (ImageView)findViewById(2131231050);
    this.x = localImageView2;
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.r.setOnCheckedChangeListener(this);
    this.u.setOnItemSelectedListener(this);
    this.w.setOnItemSelectedListener(this);
    Context localContext1 = a;
    kj localkj1 = new kj(localContext1, 2130903115);
    this.D = localkj1;
    this.D.a(2130903111);
    Spinner localSpinner3 = this.u;
    kj localkj2 = this.D;
    localSpinner3.setAdapter(localkj2);
    Context localContext2 = a;
    kj localkj3 = new kj(localContext2, 2130903115);
    this.E = localkj3;
    this.E.a(2130903111);
    Spinner localSpinner4 = this.w;
    kj localkj4 = this.E;
    localSpinner4.setAdapter(localkj4);
    this.f.setText("保存");
    this.g.setText("设置-账户");
    int m = getIntent().getIntExtra("mode", -1);
    this.b = m;
    int i1 = getIntent().getIntExtra("accountType", -1);
    this.c = i1;
    long l1 = getIntent().getLongExtra("id", 0L);
    this.H = l1;
    if (this.b == -1)
    {
      hb.b(a, "系统错误");
      finish();
    }
    if (this.H == 0L)
      this.b = 1;
    if (this.b == 0)
    {
      this.u.setEnabled(0);
      this.w.setEnabled(0);
      this.v.setVisibility(8);
      this.x.setVisibility(8);
    }
    if (this.b == 0)
    {
      int i2 = this.c;
      if (1 == i2)
        this.k.setText("负债金额");
    }
    if (this.b == 0)
    {
      int i3 = this.c;
      if (2 == i3)
        this.k.setText("债权金额");
    }
    b();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131623945, paramMenu);
    return true;
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramAdapterView.getId())
    {
    case 2131231048:
    default:
      return;
    case 2131231047:
      AccountGroupVo localAccountGroupVo1 = (AccountGroupVo)this.F.get(paramInt);
      int m = localAccountGroupVo1.d();
      this.Q.b(localAccountGroupVo1);
      List localList1 = this.z.a(paramLong);
      this.G = localList1;
      kj localkj = this.E;
      List localList2 = this.G;
      localkj.a(localList2);
      return;
    case 2131231049:
    }
    AccountGroupVo localAccountGroupVo2 = (AccountGroupVo)this.G.get(paramInt);
    this.Q.c().b(localAccountGroupVo2);
  }

  public void onNothingSelected(AdapterView paramAdapterView)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131231174:
    case 2131231175:
    }
    while (true)
    {
      return true;
      a();
      continue;
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
 * Qualified Name:     com.mymoney.ui.setting.SettingAddOrEditAccountActivity
 * JD-Core Version:    0.6.0
 */