package com.mymoney.ui.report;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.helper.MultipleScreensHelper;
import com.mymoney.ui.widget.Panel;
import com.mymoney.ui.widget.Panel.OnPanelListener;
import dz;
import ea;
import ey;
import gi;
import gj;
import gz;
import hb;
import hm;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mp;
import mq;
import mr;
import ms;
import mt;
import mu;
import mv;
import org.achartengine.chart.AnimationPieChartForMymoney;
import ug;
import um;
import un;
import vs;
import vv;
import vw;

public class ReportActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, RadioGroup.OnCheckedChangeListener, Panel.OnPanelListener, vs
{
  private static Context b;
  private Button A;
  private Button B;
  private Button C;
  private Button D;
  private Button E;
  private Button F;
  private Button G;
  private Button H;
  private Button I;
  private Button J;
  private Button K;
  private Button L;
  private Button M;
  private Button N;
  private Map O;
  private ReportLvAdapter P;
  private Animation Q;
  private Animation R;
  private List S;
  private BigDecimal T;
  private int U;
  private String a;
  private boolean c;
  private int d;
  private hm e;
  private Handler f;
  private Button g;
  private Button h;
  private Button i;
  private Panel j;
  private ScrollView k;
  private RadioGroup l;
  private RadioButton n;
  private Button o;
  private FrameLayout p;
  private FrameLayout q;
  private FrameLayout r;
  private Button s;
  private Button t;
  private TextView u;
  private AnimationPieChartForMymoney v;
  private Button w;
  private TextView x;
  private ListView y;
  private Menu z;

  public ReportActivity()
  {
    String str = ReportActivity.class.getSimpleName();
    this.a = str;
    this.c = 1;
    this.e = null;
    mr localmr = new mr(this);
    this.f = localmr;
    this.A = null;
    this.B = null;
    this.C = null;
    this.D = null;
    this.E = null;
    this.F = null;
    this.G = null;
    this.H = null;
    this.I = null;
    this.J = null;
    this.K = null;
    this.L = null;
    this.M = null;
    this.N = null;
    HashMap localHashMap = new HashMap();
    this.O = localHashMap;
    this.U = -1;
  }

  private vv a(List paramList)
  {
    int m = paramList.size();
    HashMap localHashMap1 = new HashMap(m);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      this = (ey)localIterator.next();
      HashMap localHashMap2 = new HashMap();
      double d1 = a().doubleValue();
      if (d1 <= 0.0D)
        continue;
      String str = e();
      Double localDouble = Double.valueOf(d1);
      Object localObject = localHashMap2.put(str, localDouble);
      boolean bool = localArrayList.add(localHashMap2);
    }
    return vw.a("animation piechart", localArrayList);
  }

  private void a()
  {
    long l1 = this.e.g();
    long l2 = this.e.h();
    long l4;
    long l5;
    switch (this.e.q())
    {
    default:
      gj.a(this.a, "error TimePeroidType");
      long l3 = l2;
      l4 = l1;
      l5 = l3;
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      this.e.b(l4);
      this.e.c(l5);
      f();
      return;
      long l6 = gi.b(new Date(l1)).getTime();
      long l7 = gi.a(gi.b(new Date(l2)).getTime());
      l4 = l6;
      l5 = l7;
      continue;
      long l8 = gi.j(l1);
      long l9 = gi.j(l2);
      l4 = l8;
      l5 = l9;
      continue;
      long l10 = gi.k(l1);
      long l11 = gi.k(l2);
      l4 = l10;
      l5 = l11;
      continue;
      long l12 = gi.d(new Date(l1)).getTime();
      long l13 = gi.a(gi.d(new Date(l2)).getTime());
      l4 = l12;
      l5 = l13;
      continue;
      long l14 = gi.e(new Date(l1)).getTime();
      long l15 = gi.a(gi.b(l2) - 1);
      l4 = l14;
      l5 = l15;
      continue;
      int m = gi.a(l1, l2);
      long l16 = gi.c(this.e.g(), m);
      long l17 = gi.c(this.e.h(), m);
      l4 = l16;
      l5 = l17;
    }
  }

  private void a(MenuItem paramMenuItem)
  {
    if (paramMenuItem != null)
      MenuItem localMenuItem = paramMenuItem.setTitle("条形图");
    this.d = 1;
    hm localhm = this.e;
    int m = this.d;
    localhm.d(m);
    int i1 = this.p.getWidth() / 2;
    int i2 = this.p.getHeight() / 2;
    FrameLayout localFrameLayout1 = this.q;
    FrameLayout localFrameLayout2 = this.r;
    ug localug = new ug(localFrameLayout1, localFrameLayout2, i1, i2, 0);
    mp localmp = new mp(this);
    localug.setAnimationListener(localmp);
    this.p.startAnimation(localug);
  }

  private void a(View paramView)
  {
    Button localButton = (Button)paramView;
    hm localhm = hm.a();
    Map localMap = this.O;
    Integer localInteger = Integer.valueOf(paramView.getId());
    int m = ((Integer)localMap.get(localInteger)).intValue();
    localhm.c(m);
  }

  private void a(ey paramey)
  {
    int m = this.e.d();
    if ((8 == m) || (9 == m))
    {
      hb.b(b, "资产和负债报表没有明细");
      return;
    }
    hm localhm = hm.a();
    long l1 = paramey.d();
    localhm.a(l1);
    if ((m == 11) || (m == 10))
    {
      long l2 = localhm.g();
      if (l2 == 65535L)
      {
        l2 = localhm.h();
        if (l2 != 65535L);
      }
      int i1 = gi.b(l2);
      int i2 = Integer.parseInt(paramey.e().replaceAll("月", "")) - 1;
      long l3 = gi.b(i1, i2);
      localhm.d(l3);
      long l4 = gi.c(i1, i2);
      localhm.e(l4);
    }
    String str1 = paramey.e();
    String str2;
    if ((hm.a(m)) || (m == 11))
      str2 = str1 + "（支出）";
    while (true)
    {
      Context localContext = b;
      Intent localIntent1 = new Intent(localContext, ReportTransListActivity.class);
      String str3 = ReportTransListActivity.a;
      long l5 = paramey.d();
      Intent localIntent2 = localIntent1.putExtra(str3, l5);
      String str4 = ReportTransListActivity.b;
      Intent localIntent3 = localIntent1.putExtra(str4, str2);
      startActivity(localIntent1);
      return;
      if ((hm.b(m)) || (m == 10))
      {
        str2 = str1 + "（收入）";
        continue;
      }
      str2 = str1;
    }
  }

  private void b()
  {
    long l1 = this.e.g();
    long l2 = this.e.h();
    long l4;
    long l5;
    switch (this.e.q())
    {
    default:
      gj.a(this.a, "error TimePeroidType");
      long l3 = l2;
      l4 = l1;
      l5 = l3;
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      this.e.b(l4);
      this.e.c(l5);
      f();
      return;
      long l6 = gi.a(new Date(l1)).getTime();
      long l7 = gi.a(gi.a(new Date(l2)).getTime());
      l4 = l6;
      l5 = l7;
      continue;
      long l8 = gi.h(l1);
      long l9 = gi.h(l2);
      l4 = l8;
      l5 = l9;
      continue;
      long l10 = gi.i(l1);
      long l11 = gi.i(l2);
      l4 = l10;
      l5 = l11;
      continue;
      long l12 = gi.c(new Date(l1)).getTime();
      long l13 = gi.a(gi.c(new Date(l2)).getTime());
      l4 = l12;
      l5 = l13;
      continue;
      long l14 = this.e.g();
      long l15 = gi.f(new Date(l14)).getTime();
      long l16 = gi.a(gi.b(this.e.h()) + 1);
      l4 = l15;
      l5 = l16;
      continue;
      int m = gi.a(l1, l2);
      long l17 = gi.b(this.e.g(), m);
      long l18 = gi.b(this.e.h(), m);
      l4 = l17;
      l5 = l18;
    }
  }

  private void b(MenuItem paramMenuItem)
  {
    if (paramMenuItem != null)
      MenuItem localMenuItem = paramMenuItem.setTitle("饼图");
    this.d = 2;
    hm localhm = this.e;
    int m = this.d;
    localhm.d(m);
    int i1 = this.p.getWidth() / 2;
    int i2 = this.p.getHeight() / 2;
    FrameLayout localFrameLayout1 = this.q;
    FrameLayout localFrameLayout2 = this.r;
    ug localug = new ug(localFrameLayout1, localFrameLayout2, i1, i2, 1);
    mq localmq = new mq(this);
    localug.setAnimationListener(localmq);
    this.p.startAnimation(localug);
  }

  private void c()
  {
    Context localContext = b;
    Intent localIntent = new Intent(localContext, ReportFilterActivity.class);
    startActivityForResult(localIntent, 0);
  }

  private void d()
  {
    Button localButton = this.h;
    String str = hm.a().p();
    localButton.setText(str);
  }

  private void e()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("[");
    long l1 = this.e.g();
    String str1 = gi.b(new Date(l1), "yyyy-MM-dd");
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(" , ");
    long l2 = this.e.h();
    String str2 = gi.b(new Date(l2), "yyyy-MM-dd");
    String str3 = str2 + "]";
    this.u.setText(str3);
  }

  private void f()
  {
    d();
    e();
    g();
  }

  private void g()
  {
    AsyncTask localAsyncTask = new ms(this).execute(null);
  }

  public void a(int paramInt)
  {
    this.U = paramInt;
    this.w.setEnabled(1);
  }

  protected void a(Button paramButton, Panel paramPanel)
  {
    if (!paramPanel.a());
    for (int m = 1; ; m = 0)
    {
      super.a(paramButton, paramPanel);
      if (m == 0)
        break;
      gj.a(this.a, "mReportTypeSv is set visible");
      this.k.setVisibility(0);
      return;
    }
    gj.a(this.a, "mReportTypeSv is set gone");
    this.k.setVisibility(8);
  }

  public void a(Panel paramPanel)
  {
    Resources localResources = getResources();
    int m = paramPanel.getId();
    String str1 = localResources.getResourceEntryName(m);
    String str2 = "Panel [" + str1 + "] closed";
    int i1 = Log.d("TestPanels", str2);
  }

  public void b(Panel paramPanel)
  {
    Resources localResources = getResources();
    int m = paramPanel.getId();
    String str1 = localResources.getResourceEntryName(m);
    String str2 = "Panel [" + str1 + "] opened";
    int i1 = Log.d("TestPanels", str2);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 0)
      f();
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 2131230887:
      this.i.setBackgroundResource(2130837923);
      if (this.d != 2)
        return;
      a(null);
      return;
    case 2131230888:
    }
    this.i.setBackgroundResource(2130837924);
    if (this.d != 1)
      return;
    b(null);
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
      Button localButton1 = this.h;
      Panel localPanel1 = this.j;
      a(localButton1, localPanel1);
      return;
    case 2131230808:
      int m = this.l.getCheckedRadioButtonId();
      if (2131230887 == m)
      {
        this.l.check(2131230888);
        this.i.setBackgroundResource(2130837924);
        return;
      }
      this.l.check(2131230887);
      this.i.setBackgroundResource(2130837923);
      return;
    case 2131230881:
      a();
      return;
    case 2131230883:
      b();
      return;
    case 2131230917:
      if (this.U < 0)
        return;
      List localList = this.S;
      int i1 = this.U;
      ey localey = (ey)localList.get(i1);
      a(localey);
      return;
    case 2131230868:
      Button localButton2 = this.h;
      Panel localPanel2 = this.j;
      super.a(localButton2, localPanel2);
      this.k.setVisibility(8);
      c();
      return;
    case 2131230890:
    case 2131230891:
    case 2131230892:
    case 2131230893:
    case 2131230894:
    case 2131230895:
    case 2131230896:
    case 2131230897:
    case 2131230898:
    case 2131230899:
    case 2131230900:
    case 2131230901:
    case 2131230902:
    case 2131230903:
    }
    Button localButton3 = this.h;
    Panel localPanel3 = this.j;
    a(localButton3, localPanel3);
    a(paramView);
    f();
  }

  protected void onCreate(Bundle paramBundle)
  {
    gz.b();
    super.onCreate(paramBundle);
    b = this;
    setContentView(2130903072);
    Button localButton1 = (Button)findViewById(2131230807);
    this.g = localButton1;
    Button localButton2 = (Button)findViewById(2131230809);
    this.h = localButton2;
    Button localButton3 = (Button)findViewById(2131230808);
    this.i = localButton3;
    Panel localPanel1 = (Panel)findViewById(2131230778);
    this.j = localPanel1;
    RadioGroup localRadioGroup = (RadioGroup)findViewById(2131230886);
    this.l = localRadioGroup;
    RadioButton localRadioButton1 = (RadioButton)findViewById(2131230887);
    this.n = localRadioButton1;
    RadioButton localRadioButton2 = (RadioButton)findViewById(2131230888);
    this.n = localRadioButton2;
    Button localButton4 = (Button)findViewById(2131230868);
    this.o = localButton4;
    ScrollView localScrollView = (ScrollView)findViewById(2131230889);
    this.k = localScrollView;
    FrameLayout localFrameLayout1 = (FrameLayout)findViewById(2131230879);
    this.p = localFrameLayout1;
    FrameLayout localFrameLayout2 = (FrameLayout)findViewById(2131230880);
    this.q = localFrameLayout2;
    FrameLayout localFrameLayout3 = (FrameLayout)findViewById(2131230884);
    this.r = localFrameLayout3;
    Button localButton5 = (Button)findViewById(2131230881);
    this.s = localButton5;
    Button localButton6 = (Button)findViewById(2131230883);
    this.t = localButton6;
    TextView localTextView1 = (TextView)findViewById(2131230882);
    this.u = localTextView1;
    AnimationPieChartForMymoney localAnimationPieChartForMymoney = (AnimationPieChartForMymoney)findViewById(2131230918);
    this.v = localAnimationPieChartForMymoney;
    Button localButton7 = (Button)findViewById(2131230917);
    this.w = localButton7;
    TextView localTextView2 = (TextView)findViewById(2131230797);
    this.x = localTextView2;
    ListView localListView1 = (ListView)findViewById(2131230885);
    this.y = localListView1;
    Button localButton8 = (Button)findViewById(2131230890);
    this.A = localButton8;
    Button localButton9 = (Button)findViewById(2131230891);
    this.B = localButton9;
    Button localButton10 = (Button)findViewById(2131230892);
    this.C = localButton10;
    Button localButton11 = (Button)findViewById(2131230893);
    this.D = localButton11;
    Button localButton12 = (Button)findViewById(2131230894);
    this.E = localButton12;
    Button localButton13 = (Button)findViewById(2131230895);
    this.F = localButton13;
    Button localButton14 = (Button)findViewById(2131230896);
    this.G = localButton14;
    Button localButton15 = (Button)findViewById(2131230897);
    this.H = localButton15;
    Button localButton16 = (Button)findViewById(2131230898);
    this.I = localButton16;
    Button localButton17 = (Button)findViewById(2131230899);
    this.J = localButton17;
    Button localButton18 = (Button)findViewById(2131230900);
    this.K = localButton18;
    Button localButton19 = (Button)findViewById(2131230901);
    this.L = localButton19;
    Button localButton20 = (Button)findViewById(2131230902);
    this.M = localButton20;
    Button localButton21 = (Button)findViewById(2131230903);
    this.N = localButton21;
    Map localMap1 = this.O;
    Integer localInteger1 = Integer.valueOf(this.A.getId());
    Integer localInteger2 = Integer.valueOf(1);
    Object localObject1 = localMap1.put(localInteger1, localInteger2);
    Map localMap2 = this.O;
    Integer localInteger3 = Integer.valueOf(this.B.getId());
    Integer localInteger4 = Integer.valueOf(13);
    Object localObject2 = localMap2.put(localInteger3, localInteger4);
    Map localMap3 = this.O;
    Integer localInteger5 = Integer.valueOf(this.C.getId());
    Integer localInteger6 = Integer.valueOf(2);
    Object localObject3 = localMap3.put(localInteger5, localInteger6);
    Map localMap4 = this.O;
    Integer localInteger7 = Integer.valueOf(this.D.getId());
    Integer localInteger8 = Integer.valueOf(4);
    Object localObject4 = localMap4.put(localInteger7, localInteger8);
    Map localMap5 = this.O;
    Integer localInteger9 = Integer.valueOf(this.E.getId());
    Integer localInteger10 = Integer.valueOf(3);
    Object localObject5 = localMap5.put(localInteger9, localInteger10);
    Map localMap6 = this.O;
    Integer localInteger11 = Integer.valueOf(this.F.getId());
    Integer localInteger12 = Integer.valueOf(5);
    Object localObject6 = localMap6.put(localInteger11, localInteger12);
    Map localMap7 = this.O;
    Integer localInteger13 = Integer.valueOf(this.G.getId());
    Integer localInteger14 = Integer.valueOf(14);
    Object localObject7 = localMap7.put(localInteger13, localInteger14);
    Map localMap8 = this.O;
    Integer localInteger15 = Integer.valueOf(this.H.getId());
    Integer localInteger16 = Integer.valueOf(6);
    Object localObject8 = localMap8.put(localInteger15, localInteger16);
    Map localMap9 = this.O;
    Integer localInteger17 = Integer.valueOf(this.I.getId());
    Integer localInteger18 = Integer.valueOf(7);
    Object localObject9 = localMap9.put(localInteger17, localInteger18);
    Map localMap10 = this.O;
    Integer localInteger19 = Integer.valueOf(this.J.getId());
    Integer localInteger20 = Integer.valueOf(8);
    Object localObject10 = localMap10.put(localInteger19, localInteger20);
    Map localMap11 = this.O;
    Integer localInteger21 = Integer.valueOf(this.K.getId());
    Integer localInteger22 = Integer.valueOf(9);
    Object localObject11 = localMap11.put(localInteger21, localInteger22);
    Map localMap12 = this.O;
    Integer localInteger23 = Integer.valueOf(this.L.getId());
    Integer localInteger24 = Integer.valueOf(10);
    Object localObject12 = localMap12.put(localInteger23, localInteger24);
    Map localMap13 = this.O;
    Integer localInteger25 = Integer.valueOf(this.M.getId());
    Integer localInteger26 = Integer.valueOf(11);
    Object localObject13 = localMap13.put(localInteger25, localInteger26);
    Map localMap14 = this.O;
    Integer localInteger27 = Integer.valueOf(this.N.getId());
    Integer localInteger28 = Integer.valueOf(12);
    Object localObject14 = localMap14.put(localInteger27, localInteger28);
    this.w.setEnabled(0);
    this.y.setOnItemClickListener(this);
    this.w.setOnClickListener(this);
    this.v.a(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.a(this);
    this.l.setOnCheckedChangeListener(this);
    this.o.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.I.setOnClickListener(this);
    this.J.setOnClickListener(this);
    this.K.setOnClickListener(this);
    this.L.setOnClickListener(this);
    this.M.setOnClickListener(this);
    this.N.setOnClickListener(this);
    Animation localAnimation1 = AnimationUtils.loadAnimation(b, 2130968577);
    this.Q = localAnimation1;
    Animation localAnimation2 = this.Q;
    mv localmv = new mv(this);
    localAnimation2.setAnimationListener(localmv);
    Animation localAnimation3 = AnimationUtils.loadAnimation(b, 2130968576);
    this.R = localAnimation3;
    Animation localAnimation4 = this.R;
    mu localmu = new mu(this);
    localAnimation4.setAnimationListener(localmu);
    Panel localPanel2 = this.j;
    um localum = um.b;
    un localun = new un(localum);
    localPanel2.a(localun);
    Context localContext = b;
    float f1 = MultipleScreensHelper.a(this);
    ReportLvAdapter localReportLvAdapter1 = new ReportLvAdapter(localContext, 2130903074, f1);
    this.P = localReportLvAdapter1;
    ListView localListView2 = this.y;
    ReportLvAdapter localReportLvAdapter2 = this.P;
    localListView2.setAdapter(localReportLvAdapter2);
    hm localhm = hm.a();
    this.e = localhm;
    this.d = 1;
    this.i.setText("");
    this.l.check(2131230887);
    f();
    mt localmt = new mt(this, null);
    dz localdz1 = dz.a();
    String str1 = ea.b;
    localdz1.a(str1, localmt);
    dz localdz2 = dz.a();
    String str2 = ea.c;
    localdz2.a(str2, localmt);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623942, paramMenu);
    this.z = paramMenu;
    MenuItem localMenuItem1 = paramMenu.findItem(2131231188).setVisible(0);
    MenuItem localMenuItem2 = paramMenu.findItem(2131231189).setVisible(0);
    MenuItem localMenuItem3 = paramMenu.findItem(2131231190).setVisible(0);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.e.b();
    this.e.c();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ey localey = (ey)this.P.getItem(paramInt);
    a(localey);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int m;
    if (4 == paramInt)
    {
      if (this.d != 2)
        break label66;
      this.l.check(2131230887);
      m = 1;
    }
    while (true)
    {
      return m;
      if (paramInt == 21)
      {
        this.v.b();
        m = 1;
        continue;
      }
      if (paramInt == 22)
      {
        this.v.c();
        m = 1;
        continue;
      }
      label66: boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131231178:
    }
    while (true)
    {
      boolean bool = super.onOptionsItemSelected(paramMenuItem);
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

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
  }

  protected void onResume()
  {
    super.onResume();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
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
 * Qualified Name:     com.mymoney.ui.report.ReportActivity
 * JD-Core Version:    0.6.0
 */