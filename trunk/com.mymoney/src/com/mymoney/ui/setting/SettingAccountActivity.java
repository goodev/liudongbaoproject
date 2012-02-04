package com.mymoney.ui.setting;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.mymoney.core.vo.AccountGroupVo;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.transfer.TransferActivity;
import com.mymoney.ui.widget.DragListView;
import com.mymoney.ui.widget.DragListView.OnDropListener;
import com.mymoney.ui.widget.Panel;
import com.mymoney.ui.widget.Panel.OnPanelListener;
import dz;
import e;
import ea;
import g;
import gj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k;
import oa;
import od;
import of;
import og;
import tz;
import um;
import un;

public class SettingAccountActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, Panel.OnPanelListener
{
  private static String a = SettingAccountActivity.class.getSimpleName();
  private static Context b;
  private int c = 2;
  private boolean d = 1;
  private Button e;
  private Button f;
  private Button g;
  private Button h;
  private Button i;
  private Panel j;
  private TextView k;
  private TextView l;
  private TextView n;
  private DragListView o;
  private TextView p;
  private tz q;
  private e r;
  private k s;
  private List t;
  private DragListView.OnDropListener u;

  public SettingAccountActivity()
  {
    e locale = g.a().c();
    this.r = locale;
    k localk = g.a().h();
    this.s = localk;
    ArrayList localArrayList = new ArrayList();
    this.t = localArrayList;
    od localod = new od(this);
    this.u = localod;
  }

  private Map a(AccountListViewAdapter paramAccountListViewAdapter)
  {
    HashMap localHashMap = new HashMap();
    int m = paramAccountListViewAdapter.getCount();
    int i1 = 0;
    while (i1 < m)
    {
      Long localLong = Long.valueOf(((AccountVo)paramAccountListViewAdapter.getItem(i1)).a());
      Integer localInteger = Integer.valueOf(i1);
      Object localObject = localHashMap.put(localLong, localInteger);
      i1 += 1;
    }
    return localHashMap;
  }

  private void a(long paramLong)
  {
    Context localContext = b;
    Intent localIntent1 = new Intent(localContext, SettingAccountTransactionListActivity.class);
    String str = SettingAccountTransactionListActivity.a;
    Intent localIntent2 = localIntent1.putExtra(str, paramLong);
    startActivity(localIntent1);
  }

  private void b()
  {
    Context localContext = b;
    Intent localIntent1 = new Intent(localContext, SettingAddOrEditAccountActivity.class);
    Intent localIntent2 = localIntent1.putExtra("mode", 1);
    startActivity(localIntent1);
  }

  private void c()
  {
    Context localContext = b;
    Intent localIntent = new Intent(localContext, TransferActivity.class);
    startActivity(localIntent);
  }

  private void d()
  {
    AsyncTask localAsyncTask = new of(this).execute(null);
  }

  private void e()
  {
    d();
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
      Button localButton1 = this.f;
      Panel localPanel1 = this.j;
      super.a(localButton1, localPanel1);
      return;
    case 2131230808:
      b();
      return;
    case 2131231001:
      int m;
      if (!this.d)
      {
        m = 1;
        this.d = m;
        if (!this.d)
          break label159;
        this.h.setText("显示");
        this.h.setBackgroundResource(2130838013);
      }
      while (true)
      {
        e();
        Button localButton2 = this.f;
        Panel localPanel2 = this.j;
        super.a(localButton2, localPanel2);
        return;
        m = 0;
        break;
        label159: this.h.setText("隐藏");
        this.h.setBackgroundResource(2130838014);
      }
    case 2131231002:
    }
    c();
    Button localButton3 = this.f;
    Panel localPanel3 = this.j;
    super.a(localButton3, localPanel3);
  }

  protected void onCreate(Bundle paramBundle)
  {
    gj.a(a, "onCreate()");
    super.onCreate(paramBundle);
    b = this;
    setContentView(2130903081);
    Button localButton1 = (Button)findViewById(2131230807);
    this.e = localButton1;
    Button localButton2 = (Button)findViewById(2131230809);
    this.f = localButton2;
    Button localButton3 = (Button)findViewById(2131230808);
    this.g = localButton3;
    Button localButton4 = (Button)findViewById(2131231001);
    this.h = localButton4;
    Button localButton5 = (Button)findViewById(2131231002);
    this.i = localButton5;
    Panel localPanel1 = (Panel)findViewById(2131230778);
    this.j = localPanel1;
    TextView localTextView1 = (TextView)findViewById(2131231003);
    this.k = localTextView1;
    TextView localTextView2 = (TextView)findViewById(2131231004);
    this.l = localTextView2;
    TextView localTextView3 = (TextView)findViewById(2131231005);
    this.n = localTextView3;
    DragListView localDragListView1 = (DragListView)findViewById(2131231000);
    this.o = localDragListView1;
    TextView localTextView4 = (TextView)findViewById(2131230797);
    this.p = localTextView4;
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.a(this);
    this.o.setOnItemClickListener(this);
    this.o.setOnItemLongClickListener(this);
    DragListView localDragListView2 = this.o;
    DragListView.OnDropListener localOnDropListener = this.u;
    localDragListView2.a(localOnDropListener);
    this.o.setChoiceMode(1);
    Panel localPanel2 = this.j;
    um localum = um.b;
    un localun = new un(localum);
    localPanel2.a(localun);
    int m = getIntent().getIntExtra("from", 2);
    this.c = m;
    int i1 = this.c;
    if (1 == i1)
      this.f.setText("账户");
    while (true)
    {
      this.g.setText("添加");
      e();
      Handler localHandler = new Handler();
      og localog = new og(this, localHandler);
      dz localdz1 = dz.a();
      String str1 = ea.e;
      localdz1.a(str1, localog);
      dz localdz2 = dz.a();
      String str2 = ea.f;
      localdz2.a(str2, localog);
      dz localdz3 = dz.a();
      String str3 = ea.g;
      localdz3.a(str3, localog);
      dz localdz4 = dz.a();
      String str4 = ea.b;
      localdz4.a(str4, localog);
      dz localdz5 = dz.a();
      String str5 = ea.c;
      localdz5.a(str5, localog);
      dz localdz6 = dz.a();
      String str6 = ea.d;
      localdz6.a(str6, localog);
      return;
      this.f.setText("设置-账户");
    }
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    return super.onCreateDialog(paramInt);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623946, paramMenu);
    int m = this.c;
    if (1 == m)
      MenuItem localMenuItem = paramMenu.findItem(2131231186).setTitle("首页");
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    gj.a(a, "onDestroy()");
    super.onDestroy();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramAdapterView.getId())
    {
    default:
      return;
    case 2131231000:
    }
    long l1 = ((AccountVo)this.q.getItem(paramInt)).a();
    a(l1);
  }

  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AccountVo localAccountVo = (AccountVo)this.q.getItem(paramInt);
    long l1 = localAccountVo.a();
    int m = localAccountVo.c().d();
    String str = localAccountVo.b();
    boolean bool = localAccountVo.j();
    Context localContext = b;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(localContext).setTitle("账户操作").setNegativeButton("取消", null);
    SettingAccountActivity localSettingAccountActivity = this;
    oa localoa = new oa(localSettingAccountActivity, l1, m, bool, str);
    if (m == 0)
      if (bool)
      {
        String[] arrayOfString1 = new String[4];
        arrayOfString1[0] = "编辑";
        arrayOfString1[1] = "删除";
        arrayOfString1[2] = "设置账户为显示";
        arrayOfString1[3] = "设置为默认账户";
        localBuilder.setItems(arrayOfString1, localoa).create().show();
      }
    while (true)
    {
      return true;
      String[] arrayOfString2 = new String[4];
      arrayOfString2[0] = "编辑";
      arrayOfString2[1] = "删除";
      arrayOfString2[2] = "设置账户为隐藏";
      arrayOfString2[3] = "设置为默认账户";
      localBuilder.setItems(arrayOfString2, localoa).create().show();
      continue;
      if (bool)
      {
        String[] arrayOfString3 = new String[3];
        arrayOfString3[0] = "编辑";
        arrayOfString3[1] = "删除";
        arrayOfString3[2] = "设置账户为显示";
        localBuilder.setItems(arrayOfString3, localoa).create().show();
        continue;
      }
      String[] arrayOfString4 = new String[3];
      arrayOfString4[0] = "编辑";
      arrayOfString4[1] = "删除";
      arrayOfString4[2] = "设置账户为隐藏";
      localBuilder.setItems(arrayOfString4, localoa).create().show();
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131231186:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      finish();
    }
  }

  protected void onPause()
  {
    gj.a(a, "onPause()");
    super.onPause();
  }

  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    super.onPrepareDialog(paramInt, paramDialog);
  }

  protected void onRestart()
  {
    gj.a(a, "onRestart()");
    super.onRestart();
  }

  protected void onResume()
  {
    gj.a(a, "onResume()");
    super.onResume();
  }

  protected void onStart()
  {
    gj.a(a, "onStart()");
    super.onStart();
  }

  protected void onStop()
  {
    gj.a(a, "onStop()");
    super.onStop();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingAccountActivity
 * JD-Core Version:    0.6.0
 */