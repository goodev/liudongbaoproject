package com.mymoney.ui.report;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import gi;
import gj;
import hb;
import hm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mw;
import mx;
import my;
import mz;
import na;
import nb;
import nc;
import nd;
import ts;
import ua;

public class ReportFilterActivity extends BaseActivity
  implements View.OnClickListener
{
  private static Context s;
  private Button A;
  private long B;
  private long C;
  private hm D;
  private int E;
  private List F;
  private List G;
  private List H;
  private List I;
  private List J;
  private ua K;
  private ts L;
  private ts M;
  private ts N;
  private ts O;
  LinearLayout a;
  LinearLayout b;
  LinearLayout c;
  LinearLayout d;
  LinearLayout e;
  LinearLayout f;
  LinearLayout g;
  LinearLayout h;
  public TextView i;
  public TextView j;
  public TextView k;
  public TextView l;
  public TextView n;
  public TextView o;
  public TextView p;
  EditText q;
  private String r;
  private final int t;
  private final int u;
  private final int v;
  private final int w;
  private final int x;
  private Button y;
  private TextView z;

  public ReportFilterActivity()
  {
    String str = ReportFilterActivity.class.getSimpleName();
    this.r = str;
    this.t = 1;
    this.u = 2;
    this.v = 3;
    this.w = 4;
    this.x = 5;
  }

  private void b()
  {
    hm localhm = hm.a();
    this.D = localhm;
    ArrayList localArrayList = new ArrayList();
    this.F = localArrayList;
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    String str1 = String.valueOf(0);
    Object localObject1 = localHashMap2.put("value", str1);
    Object localObject2 = localHashMap2.put("text", "本月");
    boolean bool1 = this.F.add(localHashMap2);
    HashMap localHashMap3 = new HashMap();
    String str2 = String.valueOf(1);
    Object localObject3 = localHashMap3.put("value", str2);
    Object localObject4 = localHashMap3.put("text", "本天");
    boolean bool2 = this.F.add(localHashMap3);
    HashMap localHashMap4 = new HashMap();
    String str3 = String.valueOf(2);
    Object localObject5 = localHashMap4.put("value", str3);
    Object localObject6 = localHashMap4.put("text", "本周");
    boolean bool3 = this.F.add(localHashMap4);
    HashMap localHashMap5 = new HashMap();
    String str4 = String.valueOf(3);
    Object localObject7 = localHashMap5.put("value", str4);
    Object localObject8 = localHashMap5.put("text", "本季");
    boolean bool4 = this.F.add(localHashMap5);
    HashMap localHashMap6 = new HashMap();
    String str5 = String.valueOf(4);
    Object localObject9 = localHashMap6.put("value", str5);
    Object localObject10 = localHashMap6.put("text", "本年");
    boolean bool5 = this.F.add(localHashMap6);
    HashMap localHashMap7 = new HashMap();
    String str6 = String.valueOf(5);
    Object localObject11 = localHashMap7.put("value", str6);
    Object localObject12 = localHashMap7.put("text", "自定义时间段");
    boolean bool6 = this.F.add(localHashMap7);
    c();
  }

  private void c()
  {
    switch (this.D.q())
    {
    default:
      gj.a(this.r, "error TimePeroidType");
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      TextView localTextView1 = this.j;
      String str1 = gi.f(this.B);
      localTextView1.setText(str1);
      TextView localTextView2 = this.k;
      String str2 = gi.f(this.C);
      localTextView2.setText(str2);
      return;
      this.i.setText("本月");
      long l1 = gi.h();
      this.B = l1;
      long l2 = gi.i();
      this.C = l2;
      continue;
      this.i.setText("本天");
      long l3 = gi.a();
      this.B = l3;
      long l4 = gi.b();
      this.C = l4;
      continue;
      this.i.setText("本周");
      long l5 = gi.c();
      this.B = l5;
      long l6 = gi.d();
      this.C = l6;
      continue;
      this.i.setText("本季");
      long l7 = gi.e();
      this.B = l7;
      long l8 = gi.f();
      this.C = l8;
      continue;
      this.i.setText("本年");
      long l9 = gi.g();
      this.B = l9;
      long l10 = gi.j();
      this.C = l10;
      continue;
      this.i.setText("自定义报表查询时间段");
      long l11 = this.D.g();
      this.B = l11;
      long l12 = this.D.h();
      this.C = l12;
    }
  }

  private void d()
  {
    hm localhm = hm.a();
    long l1 = this.B;
    localhm.b(l1);
    long l2 = this.C;
    localhm.c(l2);
    if ((this.L == null) || (this.L.b()))
    {
      localhm.a(null);
      if ((this.M != null) && (!this.M.b()))
        break label151;
      localhm.b(null);
      label70: if ((this.N != null) && (!this.N.b()))
        break label169;
      localhm.c(null);
      label92: if ((this.O != null) && (!this.O.b()))
        break label187;
      localhm.d(null);
    }
    while (true)
    {
      String str = this.q.getText().toString();
      localhm.b(str);
      return;
      long[] arrayOfLong1 = this.L.a();
      localhm.a(arrayOfLong1);
      break;
      label151: long[] arrayOfLong2 = this.M.a();
      localhm.b(arrayOfLong2);
      break label70;
      label169: long[] arrayOfLong3 = this.N.a();
      localhm.c(arrayOfLong3);
      break label92;
      label187: long[] arrayOfLong4 = this.O.a();
      localhm.d(arrayOfLong4);
    }
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
      d();
      this.D.c();
      setResult(-1);
      finish();
      return;
    case 2131230904:
      Class localClass1 = getClass();
      showDialog(5);
      return;
    case 2131230906:
      int m = this.E;
      if (5 == m)
      {
        int i1 = gi.b(this.B);
        int i2 = gi.c(this.B);
        int i3 = gi.d(this.B);
        Context localContext1 = s;
        mw localmw = new mw(this);
        new DatePickerDialog(localContext1, localmw, i1, i2, i3).show();
        return;
      }
      hb.b(s, "报表日期区间类型为自定义才能选择起始日期");
      return;
    case 2131230908:
      int i4 = this.E;
      if (5 == i4)
      {
        int i5 = gi.b(this.C);
        int i6 = gi.c(this.C);
        int i7 = gi.d(this.C);
        Context localContext2 = s;
        mx localmx = new mx(this);
        new DatePickerDialog(localContext2, localmx, i5, i6, i7).show();
        return;
      }
      hb.b(s, "报表日期区间类型为自定义才能选择结束日期");
      return;
    case 2131230869:
      Class localClass2 = getClass();
      showDialog(1);
      return;
    case 2131230871:
      Class localClass3 = getClass();
      showDialog(2);
      return;
    case 2131230873:
      Class localClass4 = getClass();
      showDialog(3);
      return;
    case 2131230875:
      Class localClass5 = getClass();
      showDialog(4);
      return;
    case 2131230877:
    }
    boolean bool = this.q.requestFocus();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    s = this;
    setContentView(2130903073);
    Button localButton1 = (Button)findViewById(2131230807);
    this.y = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.z = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.A = localButton2;
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131230904);
    this.a = localLinearLayout1;
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131230906);
    this.b = localLinearLayout2;
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131230908);
    this.c = localLinearLayout3;
    LinearLayout localLinearLayout4 = (LinearLayout)findViewById(2131230869);
    this.d = localLinearLayout4;
    LinearLayout localLinearLayout5 = (LinearLayout)findViewById(2131230871);
    this.e = localLinearLayout5;
    LinearLayout localLinearLayout6 = (LinearLayout)findViewById(2131230873);
    this.f = localLinearLayout6;
    LinearLayout localLinearLayout7 = (LinearLayout)findViewById(2131230875);
    this.g = localLinearLayout7;
    LinearLayout localLinearLayout8 = (LinearLayout)findViewById(2131230877);
    this.h = localLinearLayout8;
    TextView localTextView2 = (TextView)findViewById(2131230905);
    this.i = localTextView2;
    TextView localTextView3 = (TextView)findViewById(2131230907);
    this.j = localTextView3;
    TextView localTextView4 = (TextView)findViewById(2131230909);
    this.k = localTextView4;
    TextView localTextView5 = (TextView)findViewById(2131230870);
    this.l = localTextView5;
    TextView localTextView6 = (TextView)findViewById(2131230872);
    this.n = localTextView6;
    TextView localTextView7 = (TextView)findViewById(2131230874);
    this.o = localTextView7;
    TextView localTextView8 = (TextView)findViewById(2131230876);
    this.p = localTextView8;
    EditText localEditText = (EditText)findViewById(2131230776);
    this.q = localEditText;
    this.y.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    b();
    int m = this.D.q();
    this.E = m;
    this.A.setText("确定");
    this.z.setText("条件筛选");
    AsyncTask localAsyncTask = new nd(this).execute(null);
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 5:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return localObject;
      ua localua1 = new ua(this, "选择报表时间区间", "value", "text");
      this.K = localua1;
      ua localua2 = this.K;
      List localList1 = this.F;
      localua2.a(localList1);
      ua localua3 = this.K;
      String str = String.valueOf(this.D.q());
      localua3.a(str);
      ua localua4 = this.K;
      my localmy = new my(this);
      localObject = localua4.a(localmy);
      continue;
      ReportFilterActivity localReportFilterActivity1 = this;
      ts localts1 = new ts(localReportFilterActivity1, 0, 1, "选择分类", "id", "name");
      this.L = localts1;
      ts localts2 = this.L;
      List localList2 = this.G;
      localts2.a(localList2);
      ts localts3 = this.L;
      mz localmz = new mz(this);
      localObject = localts3.a(localmz);
      continue;
      ReportFilterActivity localReportFilterActivity2 = this;
      ts localts4 = new ts(localReportFilterActivity2, 0, 1, "选择账户", "id", "name");
      this.M = localts4;
      ts localts5 = this.M;
      List localList3 = this.H;
      localts5.a(localList3);
      ts localts6 = this.M;
      na localna = new na(this);
      localObject = localts6.a(localna);
      continue;
      ReportFilterActivity localReportFilterActivity3 = this;
      ts localts7 = new ts(localReportFilterActivity3, 0, 1, "选择项目", "id", "name");
      this.N = localts7;
      ts localts8 = this.N;
      List localList4 = this.I;
      localts8.a(localList4);
      ts localts9 = this.N;
      nb localnb = new nb(this);
      localObject = localts9.a(localnb);
      continue;
      ReportFilterActivity localReportFilterActivity4 = this;
      ts localts10 = new ts(localReportFilterActivity4, 0, 1, "选择商家", "id", "name");
      this.O = localts10;
      ts localts11 = this.O;
      List localList5 = this.J;
      localts11.a(localList5);
      ts localts12 = this.O;
      nc localnc = new nc(this);
      localObject = localts12.a(localnc);
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.report.ReportFilterActivity
 * JD-Core Version:    0.6.0
 */