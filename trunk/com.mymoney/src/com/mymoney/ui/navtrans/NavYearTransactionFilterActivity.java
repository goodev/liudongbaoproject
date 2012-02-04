package com.mymoney.ui.navtrans;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import java.util.List;
import mk;
import ml;
import mm;
import mn;
import mo;
import ts;

public class NavYearTransactionFilterActivity extends BaseActivity
  implements View.OnClickListener
{
  private static Context n;
  private ts A;
  private ts B;
  private ts C;
  LinearLayout a;
  LinearLayout b;
  LinearLayout c;
  LinearLayout d;
  LinearLayout e;
  public TextView f;
  public TextView g;
  public TextView h;
  public TextView i;
  EditText j;
  NavYearTransFilterVo k;
  private String l;
  private final int o;
  private final int p;
  private final int q;
  private final int r;
  private Button s;
  private TextView t;
  private Button u;
  private List v;
  private List w;
  private List x;
  private List y;
  private ts z;

  public NavYearTransactionFilterActivity()
  {
    String str = NavYearTransactionFilterActivity.class.getSimpleName();
    this.l = str;
    this.o = 1;
    this.p = 2;
    this.q = 3;
    this.r = 4;
    NavYearTransFilterVo localNavYearTransFilterVo = NavYearTransFilterVo.a();
    this.k = localNavYearTransFilterVo;
  }

  private void a()
  {
    if ((this.z == null) || (this.z.b()))
    {
      this.k.a(null);
      if ((this.A != null) && (!this.A.b()))
        break label146;
      this.k.b(null);
      label50: if ((this.B != null) && (!this.B.b()))
        break label169;
      this.k.c(null);
      label75: if ((this.C != null) && (!this.C.b()))
        break label194;
      this.k.d(null);
    }
    while (true)
    {
      if (!TextUtils.isEmpty(this.j.getText().toString()))
        break label219;
      this.k.b(null);
      return;
      NavYearTransFilterVo localNavYearTransFilterVo1 = this.k;
      long[] arrayOfLong1 = this.z.a();
      localNavYearTransFilterVo1.a(arrayOfLong1);
      break;
      label146: NavYearTransFilterVo localNavYearTransFilterVo2 = this.k;
      long[] arrayOfLong2 = this.A.a();
      localNavYearTransFilterVo2.b(arrayOfLong2);
      break label50;
      label169: NavYearTransFilterVo localNavYearTransFilterVo3 = this.k;
      long[] arrayOfLong3 = this.B.a();
      localNavYearTransFilterVo3.c(arrayOfLong3);
      break label75;
      label194: NavYearTransFilterVo localNavYearTransFilterVo4 = this.k;
      long[] arrayOfLong4 = this.C.a();
      localNavYearTransFilterVo4.d(arrayOfLong4);
    }
    label219: NavYearTransFilterVo localNavYearTransFilterVo5 = this.k;
    String str = this.j.getText().toString();
    localNavYearTransFilterVo5.b(str);
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
      setResult(1);
      finish();
      return;
    case 2131230869:
      showDialog(1);
      return;
    case 2131230871:
      showDialog(2);
      return;
    case 2131230873:
      showDialog(3);
      return;
    case 2131230875:
      showDialog(4);
      return;
    case 2131230877:
    }
    boolean bool = this.j.requestFocus();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    n = this;
    setContentView(2130903070);
    Button localButton1 = (Button)findViewById(2131230807);
    this.s = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.t = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.u = localButton2;
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131230869);
    this.a = localLinearLayout1;
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131230871);
    this.b = localLinearLayout2;
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131230873);
    this.c = localLinearLayout3;
    LinearLayout localLinearLayout4 = (LinearLayout)findViewById(2131230875);
    this.d = localLinearLayout4;
    LinearLayout localLinearLayout5 = (LinearLayout)findViewById(2131230877);
    this.e = localLinearLayout5;
    TextView localTextView2 = (TextView)findViewById(2131230870);
    this.f = localTextView2;
    TextView localTextView3 = (TextView)findViewById(2131230872);
    this.g = localTextView3;
    TextView localTextView4 = (TextView)findViewById(2131230874);
    this.h = localTextView4;
    TextView localTextView5 = (TextView)findViewById(2131230876);
    this.i = localTextView5;
    EditText localEditText = (EditText)findViewById(2131230776);
    this.j = localEditText;
    this.s.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.u.setText("确定");
    this.t.setText("条件筛选");
    AsyncTask localAsyncTask = new mo(this).execute(null);
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return localObject;
      NavYearTransactionFilterActivity localNavYearTransactionFilterActivity1 = this;
      ts localts1 = new ts(localNavYearTransactionFilterActivity1, 0, 1, "选择分类", "id", "name");
      this.z = localts1;
      ts localts2 = this.z;
      List localList1 = this.v;
      localts2.a(localList1);
      ts localts3 = this.z;
      mk localmk = new mk(this);
      localObject = localts3.a(localmk);
      continue;
      NavYearTransactionFilterActivity localNavYearTransactionFilterActivity2 = this;
      ts localts4 = new ts(localNavYearTransactionFilterActivity2, 0, 1, "选择账户", "id", "name");
      this.A = localts4;
      ts localts5 = this.A;
      List localList2 = this.w;
      localts5.a(localList2);
      ts localts6 = this.A;
      ml localml = new ml(this);
      localObject = localts6.a(localml);
      continue;
      NavYearTransactionFilterActivity localNavYearTransactionFilterActivity3 = this;
      ts localts7 = new ts(localNavYearTransactionFilterActivity3, 0, 1, "选择项目", "id", "name");
      this.B = localts7;
      ts localts8 = this.B;
      List localList3 = this.x;
      localts8.a(localList3);
      ts localts9 = this.B;
      mm localmm = new mm(this);
      localObject = localts9.a(localmm);
      continue;
      NavYearTransactionFilterActivity localNavYearTransactionFilterActivity4 = this;
      ts localts10 = new ts(localNavYearTransactionFilterActivity4, 0, 1, "选择商家", "id", "name");
      this.C = localts10;
      ts localts11 = this.C;
      List localList4 = this.y;
      localts11.a(localList4);
      ts localts12 = this.C;
      mn localmn = new mn(this);
      localObject = localts12.a(localmn);
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.navtrans.NavYearTransactionFilterActivity
 * JD-Core Version:    0.6.0
 */