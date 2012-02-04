package com.mymoney.ui.navtrans;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.mymoney.core.application.ApplicationContext;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.transfer.TransferActivity;
import com.mymoney.ui.widget.Panel;
import com.mymoney.ui.widget.Panel.OnPanelListener;
import dz;
import ea;
import g;
import gi;
import gj;
import gu;
import hb;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import m;
import mg;
import mh;
import mi;
import mj;
import um;
import un;

public class NavYearTransactionActivity extends BaseActivity
  implements View.OnClickListener, View.OnCreateContextMenuListener, ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupExpandListener, Panel.OnPanelListener
{
  private static String a = "NavYearTransactionActivity";
  private static Context b;
  private static final String[] c;
  private static String d;
  private Handler e;
  private boolean f;
  private Button g;
  private Button h;
  private Button i;
  private Panel j;
  private Button k;
  private Button l;
  private Button n;
  private ExpandableListView o;
  private TextView p;
  private ImageView q;
  private NavYearTransactionActivity.YearTransListAdapter r;
  private NavYearTransFilterVo s;
  private int t;
  private int u;
  private long v;
  private long w;
  private Map x;
  private m y;

  static
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "编辑";
    arrayOfString[1] = "删除";
    c = arrayOfString;
    d = "yyyy年MM月dd日";
  }

  public NavYearTransactionActivity()
  {
    mj localmj = new mj(this);
    this.e = localmj;
    this.f = 1;
    NavYearTransFilterVo localNavYearTransFilterVo = NavYearTransFilterVo.a();
    this.s = localNavYearTransFilterVo;
    this.t = 0;
    this.u = 0;
    HashMap localHashMap = new HashMap();
    this.x = localHashMap;
    m localm = g.a().b();
    this.y = localm;
  }

  private void a(long paramLong)
  {
    Context localContext = b;
    Intent localIntent1 = new Intent(localContext, TransferActivity.class);
    Intent localIntent2 = localIntent1.putExtra("id", paramLong);
    Intent localIntent3 = localIntent1.putExtra("state", 2);
    startActivity(localIntent1);
  }

  private void a(long paramLong, int paramInt)
  {
    if (gu.h())
    {
      Context localContext1 = b;
      Intent localIntent1 = new Intent(localContext1, AddOrEditTransNewActivity.class);
      Intent localIntent2 = localIntent1.putExtra("state", 2);
      Intent localIntent3 = localIntent1.putExtra("transType", paramInt);
      Intent localIntent4 = localIntent1.putExtra("id", paramLong);
      startActivity(localIntent1);
      return;
    }
    Context localContext2 = b;
    Intent localIntent5 = new Intent(localContext2, AddOrEditTransactionActivity.class);
    Intent localIntent6 = localIntent5.putExtra("state", 3);
    Intent localIntent7 = localIntent5.putExtra("transType", paramInt);
    Intent localIntent8 = localIntent5.putExtra("id", paramLong);
    startActivity(localIntent5);
  }

  private void b()
  {
    c();
    d();
    this.f = 0;
  }

  private void c()
  {
    int m = gi.b(this.v);
    Button localButton = this.h;
    String str = m + "年度流水";
    localButton.setText(str);
  }

  private void d()
  {
    this.x.clear();
    AsyncTask localAsyncTask = new NavYearTransactionActivity.YearTransLoadTask(this).execute(null);
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
    {
      String str1 = a;
      String str2 = "resultCode is " + paramInt2;
      gj.a(str1, str2);
      if (paramInt2 == 1)
        b();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong)
  {
    String str1 = ((TextView)paramView.findViewById(2131231115)).getText().toString();
    String str2 = ((TextView)paramView.findViewById(2131231116)).getText().toString();
    long l1 = Long.valueOf(str1).longValue();
    int m = Integer.valueOf(str2).intValue();
    if ((1 == m) || (m == 0))
      a(l1, m);
    while (true)
    {
      return true;
      if (3 != m)
        continue;
      a(l1);
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131230808:
    default:
      return;
    case 2131230807:
      finish();
      return;
    case 2131230809:
      Button localButton1 = this.h;
      Panel localPanel1 = this.j;
      super.a(localButton1, localPanel1);
      return;
    case 2131230865:
      Button localButton2 = this.h;
      Panel localPanel2 = this.j;
      super.a(localButton2, localPanel2);
      long l1 = this.v;
      long l2 = gi.e(new Date(l1)).getTime();
      this.v = l2;
      long l3 = gi.a(gi.b(this.w) - 1);
      this.w = l3;
      b();
      return;
    case 2131230866:
      Button localButton3 = this.h;
      Panel localPanel3 = this.j;
      super.a(localButton3, localPanel3);
      long l4 = this.v;
      long l5 = gi.f(new Date(l4)).getTime();
      this.v = l5;
      long l6 = gi.a(gi.b(this.w) + 1);
      this.w = l6;
      b();
      return;
    case 2131230868:
    }
    Button localButton4 = this.h;
    Panel localPanel4 = this.j;
    super.a(localButton4, localPanel4);
    Context localContext = b;
    Intent localIntent = new Intent(localContext, NavYearTransactionFilterActivity.class);
    startActivityForResult(localIntent, 0);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    ExpandableListView.ExpandableListContextMenuInfo localExpandableListContextMenuInfo = (ExpandableListView.ExpandableListContextMenuInfo)paramMenuItem.getMenuInfo();
    int m = ExpandableListView.getPackedPositionType(localExpandableListContextMenuInfo.packedPosition);
    long l1;
    int i2;
    int i3;
    if (m == 1)
    {
      int i1 = paramMenuItem.getItemId();
      String str1 = ((TextView)localExpandableListContextMenuInfo.targetView.findViewById(2131231115)).getText().toString();
      String str2 = ((TextView)localExpandableListContextMenuInfo.targetView.findViewById(2131231116)).getText().toString();
      l1 = Long.valueOf(str1).longValue();
      i2 = Integer.valueOf(str2).intValue();
      switch (i1)
      {
      default:
        gj.a(a, " unsupport context menu action");
        i3 = 1;
      case 0:
      case 1:
      }
    }
    while (true)
    {
      return i3;
      if ((1 == i2) || (i2 == 0))
      {
        a(l1, i2);
        break;
      }
      if ((2 == i2) || (3 == i2) || (4 == i2) || (5 == i2) || (6 == i2) || (7 == i2))
      {
        a(l1);
        break;
      }
      hb.b(ApplicationContext.a, "抱歉,余额变更不可以编辑");
      break;
      Context localContext = b;
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle(2131492899).setMessage(2131492900);
      mh localmh = new mh(this, l1);
      AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton(2131492901, localmh);
      mg localmg = new mg(this);
      localBuilder2.setNegativeButton(2131492902, localmg).create().show();
      break;
      if (m == 0)
      {
        hb.b(b, "对不起,流水统计行不支持该操作");
        i3 = 1;
        continue;
      }
      i3 = 0;
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b = this;
    setContentView(2130903069);
    Button localButton1 = (Button)findViewById(2131230807);
    this.g = localButton1;
    Button localButton2 = (Button)findViewById(2131230809);
    this.h = localButton2;
    Button localButton3 = (Button)findViewById(2131230808);
    this.i = localButton3;
    Panel localPanel1 = (Panel)findViewById(2131230778);
    this.j = localPanel1;
    Button localButton4 = (Button)findViewById(2131230865);
    this.k = localButton4;
    Button localButton5 = (Button)findViewById(2131230866);
    this.l = localButton5;
    Button localButton6 = (Button)findViewById(2131230868);
    this.n = localButton6;
    ImageView localImageView = (ImageView)findViewById(2131230859);
    this.q = localImageView;
    TextView localTextView = (TextView)findViewById(2131230797);
    this.p = localTextView;
    ExpandableListView localExpandableListView1 = (ExpandableListView)findViewById(2131230864);
    this.o = localExpandableListView1;
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.j.a(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnGroupExpandListener(this);
    this.o.setOnChildClickListener(this);
    Panel localPanel2 = this.j;
    um localum = um.b;
    un localun = new un(localum);
    localPanel2.a(localun);
    this.o.setDividerHeight(0);
    this.i.setVisibility(4);
    ExpandableListView localExpandableListView2 = this.o;
    registerForContextMenu(localExpandableListView2);
    long l1 = gi.g();
    this.v = l1;
    long l2 = gi.j();
    this.w = l2;
    mi localmi = new mi(this, null);
    dz localdz1 = dz.a();
    String str1 = ea.b;
    localdz1.a(str1, localmi);
    dz localdz2 = dz.a();
    String str2 = ea.c;
    localdz2.a(str2, localmi);
    dz localdz3 = dz.a();
    String str3 = ea.d;
    localdz3.a(str3, localmi);
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    ContextMenu localContextMenu = paramContextMenu.setHeaderTitle("请选择操作类型");
    String str1 = c[0];
    MenuItem localMenuItem1 = paramContextMenu.add(0, 0, 0, str1);
    String str2 = c[1];
    MenuItem localMenuItem2 = paramContextMenu.add(0, 1, 1, str2);
  }

  protected void onDestroy()
  {
    this.s.b();
    super.onDestroy();
  }

  public void onGroupExpand(int paramInt)
  {
    this.t = paramInt;
    int m = this.u;
    int i1 = this.t;
    if (m != i1)
    {
      ExpandableListView localExpandableListView = this.o;
      int i2 = this.u;
      boolean bool = localExpandableListView.collapseGroup(i2);
    }
    int i3 = this.t;
    this.u = i3;
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    int m = paramBundle.getInt("currentExpandPositon");
    this.t = m;
    gj.a(a, "onRestoreInstanceState method");
  }

  protected void onResume()
  {
    if (this.f)
      b();
    super.onResume();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    int m = this.t;
    paramBundle.putInt("currentExpandPositon", m);
    gj.a(a, "onSaveInstanceState method");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.navtrans.NavYearTransactionActivity
 * JD-Core Version:    0.6.0
 */