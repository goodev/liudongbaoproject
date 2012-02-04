package com.mymoney.ui.navtrans;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mymoney.core.application.ApplicationContext;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.transfer.TransferActivity;
import com.mymoney.ui.widget.Panel;
import dz;
import ea;
import g;
import gi;
import gu;
import hb;
import java.util.Date;
import lw;
import lz;
import m;
import ma;
import mb;
import mc;
import md;
import me;
import mf;
import tz;
import um;
import un;

public class NavTransactionActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, RadioGroup.OnCheckedChangeListener
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  private static String i = "NavTransactionActivity";
  private static Context j;
  private static String k = "yyyy年MM月dd日";
  private View A;
  private ImageView B;
  private Panel C;
  private RelativeLayout D;
  private View E;
  private EditText F;
  private Button G;
  private Button H;
  private RadioGroup I;
  private ListView J;
  private PopupWindow K;
  private long L;
  private long M;
  private String N;
  private String O;
  private int P;
  private tz Q;
  private m R;
  private tz S;
  private int l;
  private Handler n;
  private boolean o;
  private Button p;
  private Button q;
  private Button r;
  private Button s;
  private TextView t;
  private Button u;
  private TextView v;
  private TextView w;
  private TextView x;
  private TextView y;
  private ListView z;

  static
  {
    a = "startTime";
    b = "endTime";
    c = "title";
    d = "mode";
    e = 0;
    f = 1;
    g = 2;
    h = 3;
  }

  public NavTransactionActivity()
  {
    int m = e;
    this.l = m;
    mc localmc = new mc(this);
    this.n = localmc;
    this.o = 1;
    m localm = g.a().b();
    this.R = localm;
  }

  private void a(long paramLong)
  {
    Context localContext = j;
    Intent localIntent1 = new Intent(localContext, TransferActivity.class);
    Intent localIntent2 = localIntent1.putExtra("id", paramLong);
    Intent localIntent3 = localIntent1.putExtra("state", 2);
    startActivity(localIntent1);
  }

  private void a(long paramLong, int paramInt)
  {
    Context localContext = j;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(localContext).setTitle("流水操作");
    lw locallw = new lw(this, paramInt, paramLong);
    localBuilder.setItems(2131165185, locallw).setNegativeButton("取消", null).create().show();
  }

  private void b(long paramLong, int paramInt)
  {
    if (gu.h())
    {
      Context localContext1 = j;
      Intent localIntent1 = new Intent(localContext1, AddOrEditTransNewActivity.class);
      Intent localIntent2 = localIntent1.putExtra("state", 2);
      Intent localIntent3 = localIntent1.putExtra("transType", paramInt);
      Intent localIntent4 = localIntent1.putExtra("id", paramLong);
      startActivity(localIntent1);
      return;
    }
    Context localContext2 = j;
    Intent localIntent5 = new Intent(localContext2, AddOrEditTransactionActivity.class);
    Intent localIntent6 = localIntent5.putExtra("state", 3);
    Intent localIntent7 = localIntent5.putExtra("transType", paramInt);
    Intent localIntent8 = localIntent5.putExtra("id", paramLong);
    startActivity(localIntent5);
  }

  private void c()
  {
    int m = this.l;
    int i1 = h;
    if (m == i1)
    {
      TextView localTextView1 = this.t;
      long l1 = this.L;
      Date localDate1 = new Date(l1);
      String str1 = k;
      String str2 = gi.b(localDate1, str1);
      localTextView1.setText(str2);
      return;
    }
    TextView localTextView2 = this.t;
    StringBuilder localStringBuilder1 = new StringBuilder();
    long l2 = this.L;
    Date localDate2 = new Date(l2);
    String str3 = k;
    String str4 = gi.b(localDate2, str3);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str4).append("-");
    long l3 = this.M;
    Date localDate3 = new Date(l3);
    String str5 = k;
    String str6 = gi.b(localDate3, str5);
    String str7 = str6;
    localTextView2.setText(str7);
  }

  private void d()
  {
    if (gu.h())
    {
      Context localContext1 = j;
      Intent localIntent1 = new Intent(localContext1, AddOrEditTransNewActivity.class);
      Intent localIntent2 = localIntent1.putExtra("state", 1);
      Intent localIntent3 = localIntent1.putExtra("transType", 0);
      startActivity(localIntent1);
      return;
    }
    Context localContext2 = j;
    Intent localIntent4 = new Intent(localContext2, AddOrEditTransactionActivity.class);
    Intent localIntent5 = localIntent4.putExtra("state", 2);
    Intent localIntent6 = localIntent4.putExtra("transType", 0);
    startActivity(localIntent4);
  }

  private void e()
  {
    if (gu.h())
    {
      Context localContext1 = j;
      Intent localIntent1 = new Intent(localContext1, AddOrEditTransNewActivity.class);
      Intent localIntent2 = localIntent1.putExtra("state", 1);
      Intent localIntent3 = localIntent1.putExtra("transType", 1);
      startActivity(localIntent1);
      return;
    }
    Context localContext2 = j;
    Intent localIntent4 = new Intent(localContext2, AddOrEditTransactionActivity.class);
    Intent localIntent5 = localIntent4.putExtra("state", 2);
    Intent localIntent6 = localIntent4.putExtra("transType", 1);
    startActivity(localIntent4);
  }

  private void f()
  {
    Context localContext = j;
    Intent localIntent = new Intent(localContext, TransferActivity.class);
    startActivity(localIntent);
  }

  private void g()
  {
    mf localmf = new mf(this);
    Void[] arrayOfVoid = new Void[0];
    AsyncTask localAsyncTask = localmf.execute(arrayOfVoid);
    this.o = 0;
  }

  private void h()
  {
    if (this.Q != null)
      this.Q.a();
    if (this.O == null)
      return;
    if (this.O.equals(""))
      return;
    me localme = new me(this);
    Void[] arrayOfVoid = new Void[0];
    AsyncTask localAsyncTask = localme.execute(arrayOfVoid);
  }

  private void i()
  {
    View localView1 = this.E;
    PopupWindow localPopupWindow1 = new PopupWindow(localView1, -1, -1, 1);
    this.K = localPopupWindow1;
    PopupWindow localPopupWindow2 = this.K;
    lz locallz = new lz(this);
    localPopupWindow2.setOnDismissListener(locallz);
    this.K.setClippingEnabled(0);
    this.K.setInputMethodMode(1);
    PopupWindow localPopupWindow3 = this.K;
    BitmapDrawable localBitmapDrawable = new BitmapDrawable();
    localPopupWindow3.setBackgroundDrawable(localBitmapDrawable);
    PopupWindow localPopupWindow4 = this.K;
    View localView2 = findViewById(2131230856);
    float f1 = getResources().getDisplayMetrics().density;
    int m = (int)(25.0F * f1);
    localPopupWindow4.showAtLocation(localView2, 0, 0, m);
    this.I.check(2131230923);
    this.D.setVisibility(8);
    j();
  }

  private void j()
  {
    Handler localHandler = this.n;
    ma localma = new ma(this);
    boolean bool = localHandler.postDelayed(localma, 500L);
  }

  private void k()
  {
    g();
    if (this.K == null)
      return;
    if (!this.K.isShowing())
      return;
    h();
  }

  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 2131230923:
    case 2131230924:
    case 2131230925:
    case 2131230926:
    }
    while (true)
    {
      h();
      return;
      this.P = 0;
      continue;
      this.P = 1;
      continue;
      this.P = 2;
      continue;
      this.P = 3;
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
    case 2131230809:
      Button localButton1 = this.q;
      Panel localPanel1 = this.C;
      super.a(localButton1, localPanel1);
      return;
    case 2131230808:
      Button localButton2 = this.q;
      Panel localPanel2 = this.C;
      super.a(localButton2, localPanel2);
      return;
    case 2131230861:
      int m = this.l;
      int i1 = f;
      if (m == i1)
      {
        long l1 = this.L;
        long l2 = gi.b(new Date(l1)).getTime();
        this.L = l2;
        long l3 = this.M;
        long l4 = gi.a(gi.b(new Date(l3)).getTime());
        this.M = l4;
      }
      while (true)
      {
        c();
        g();
        return;
        int i2 = this.l;
        int i3 = g;
        if (i2 == i3)
        {
          long l5 = gi.k(this.L);
          this.L = l5;
          long l6 = gi.k(this.M);
          this.M = l6;
          continue;
        }
        int i4 = this.l;
        int i5 = h;
        if (i4 != i5)
          continue;
        long l7 = gi.j(this.L);
        this.L = l7;
        long l8 = gi.j(this.M);
        this.M = l8;
      }
    case 2131230863:
      int i6 = this.l;
      int i7 = f;
      if (i6 == i7)
      {
        long l9 = this.L;
        long l10 = gi.a(new Date(l9)).getTime();
        this.L = l10;
        long l11 = this.M;
        long l12 = gi.a(gi.a(new Date(l11)).getTime());
        this.M = l12;
      }
      while (true)
      {
        c();
        g();
        return;
        int i8 = this.l;
        int i9 = g;
        if (i8 == i9)
        {
          long l13 = gi.i(this.L);
          this.L = l13;
          long l14 = gi.i(this.M);
          this.M = l14;
          continue;
        }
        int i10 = this.l;
        int i11 = h;
        if (i10 != i11)
          continue;
        long l15 = gi.h(this.L);
        this.L = l15;
        long l16 = gi.h(this.M);
        this.M = l16;
      }
    case 2131230858:
      i();
      return;
    case 2131230920:
      this.F.setText("");
      return;
    case 2131230921:
    }
    this.K.dismiss();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903068);
    j = this;
    Button localButton1 = (Button)findViewById(2131230807);
    this.p = localButton1;
    Button localButton2 = (Button)findViewById(2131230809);
    this.q = localButton2;
    Button localButton3 = (Button)findViewById(2131230808);
    this.r = localButton3;
    Button localButton4 = (Button)findViewById(2131230861);
    this.s = localButton4;
    TextView localTextView1 = (TextView)findViewById(2131230862);
    this.t = localTextView1;
    Button localButton5 = (Button)findViewById(2131230863);
    this.u = localButton5;
    TextView localTextView2 = (TextView)findViewById(2131230814);
    this.v = localTextView2;
    TextView localTextView3 = (TextView)findViewById(2131230857);
    this.w = localTextView3;
    TextView localTextView4 = (TextView)findViewById(2131230801);
    this.x = localTextView4;
    ImageView localImageView = (ImageView)findViewById(2131230859);
    this.B = localImageView;
    ListView localListView1 = (ListView)findViewById(2131230860);
    this.z = localListView1;
    TextView localTextView5 = (TextView)findViewById(2131230797);
    this.y = localTextView5;
    View localView1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903058, null);
    this.A = localView1;
    Panel localPanel1 = (Panel)findViewById(2131230778);
    this.C = localPanel1;
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131230858);
    this.D = localRelativeLayout;
    View localView2 = getLayoutInflater().inflate(2130903078, null);
    this.E = localView2;
    EditText localEditText1 = (EditText)this.E.findViewById(2131230919);
    this.F = localEditText1;
    Button localButton6 = (Button)this.E.findViewById(2131230920);
    this.G = localButton6;
    Button localButton7 = (Button)this.E.findViewById(2131230921);
    this.H = localButton7;
    RadioGroup localRadioGroup = (RadioGroup)this.E.findViewById(2131230922);
    this.I = localRadioGroup;
    ListView localListView2 = (ListView)this.E.findViewById(2131230927);
    this.J = localListView2;
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.z.setOnItemClickListener(this);
    this.z.setOnItemLongClickListener(this);
    this.D.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.I.setOnCheckedChangeListener(this);
    EditText localEditText2 = this.F;
    md localmd = new md(this, null);
    localEditText2.addTextChangedListener(localmd);
    this.J.setOnItemClickListener(this);
    this.J.setOnItemLongClickListener(this);
    Intent localIntent = getIntent();
    String str1 = a;
    long l1 = localIntent.getLongExtra(str1, 0L);
    this.L = l1;
    String str2 = b;
    long l2 = localIntent.getLongExtra(str2, 0L);
    this.M = l2;
    String str3 = c;
    String str4 = localIntent.getStringExtra(str3);
    this.N = str4;
    String str5 = d;
    int m = e;
    int i1 = localIntent.getIntExtra(str5, m);
    this.l = i1;
    if ((this.L != 0L) && (this.M != 0L) && (!TextUtils.isEmpty(this.N)))
    {
      int i2 = this.l;
      int i3 = e;
      if (i2 != i3);
    }
    else
    {
      hb.b(j, "系统错误");
      finish();
    }
    this.r.setVisibility(4);
    c();
    ListView localListView3 = this.z;
    View localView3 = this.A;
    localListView3.setEmptyView(localView3);
    Button localButton8 = this.q;
    String str6 = this.N;
    localButton8.setText(str6);
    Panel localPanel2 = this.C;
    um localum = um.b;
    un localun = new un(localum);
    localPanel2.a(localun);
    mb localmb = new mb(this, null);
    dz localdz1 = dz.a();
    String str7 = ea.b;
    localdz1.a(str7, localmb);
    dz localdz2 = dz.a();
    String str8 = ea.c;
    localdz2.a(str8, localmb);
    dz localdz3 = dz.a();
    String str9 = ea.d;
    localdz3.a(str9, localmb);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131623941, paramMenu);
    return true;
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = null;
    switch (paramAdapterView.getId())
    {
    default:
    case 2131230860:
    case 2131230927:
    }
    long l1;
    TransactionVo localTransactionVo;
    while (true)
    {
      if (localObject == null)
        return;
      l1 = localObject.a();
      int m = localObject.k();
      if ((1 != m) && (m != 0))
        break;
      b(l1, m);
      return;
      localTransactionVo = (TransactionVo)this.S.getItem(paramInt);
      continue;
      localTransactionVo = (TransactionVo)this.Q.getItem(paramInt);
    }
    if ((2 == localTransactionVo) || (3 == localTransactionVo) || (4 == localTransactionVo) || (5 == localTransactionVo) || (6 == localTransactionVo) || (7 == localTransactionVo))
    {
      a(l1);
      return;
    }
    hb.b(ApplicationContext.a, "抱歉,余额变更不可以编辑");
  }

  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    TransactionVo localTransactionVo = null;
    switch (paramAdapterView.getId())
    {
    default:
    case 2131230860:
    case 2131230927:
    }
    while (true)
    {
      if (localTransactionVo != null)
      {
        long l1 = localTransactionVo.a();
        int m = localTransactionVo.k();
        a(l1, m);
      }
      return false;
      localTransactionVo = (TransactionVo)this.S.getItem(paramInt);
      continue;
      localTransactionVo = (TransactionVo)this.Q.getItem(paramInt);
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 84)
      i();
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
    case 2131231187:
    case 2131231181:
    case 2131231182:
    case 2131231178:
    }
    while (true)
    {
      return true;
      d();
      continue;
      e();
      continue;
      f();
      continue;
      finish();
    }
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
  }

  protected void onResume()
  {
    if (this.o)
      g();
    super.onResume();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.navtrans.NavTransactionActivity
 * JD-Core Version:    0.6.0
 */