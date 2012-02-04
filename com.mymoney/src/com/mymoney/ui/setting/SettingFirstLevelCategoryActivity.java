package com.mymoney.ui.setting;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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
import android.widget.TextView;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.widget.DragListView;
import com.mymoney.ui.widget.DragListView.OnDropListener;
import dz;
import ea;
import g;
import gj;
import h;
import hb;
import java.util.HashMap;
import java.util.Map;
import qg;
import qj;
import ql;
import qm;

public class SettingFirstLevelCategoryActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  public static String a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  private static String f = SettingFirstLevelCategoryActivity.class.getSimpleName();
  private static Context g;
  private Handler h;
  private Button i;
  private TextView j;
  private Button k;
  private DragListView l;
  private TextView n;
  private EditText o;
  private Button p;
  private CategoryVo q;
  private int r;
  private CategoryListViewAdapter s;
  private h t;
  private DragListView.OnDropListener u;

  static
  {
    a = "categoryType";
    b = -1;
    c = 1;
    d = 2;
    e = 3;
  }

  public SettingFirstLevelCategoryActivity()
  {
    Handler localHandler = new Handler();
    this.h = localHandler;
    h localh = g.a().d();
    this.t = localh;
    qj localqj = new qj(this);
    this.u = localqj;
  }

  private void a(long paramLong)
  {
    Context localContext = g;
    Intent localIntent1 = new Intent(localContext, SettingSubcategoryActivity.class);
    String str1 = SettingSubcategoryActivity.a;
    Intent localIntent2 = localIntent1.putExtra(str1, paramLong);
    String str2 = a;
    int m = this.r;
    Intent localIntent3 = localIntent1.putExtra(str2, m);
    startActivity(localIntent1);
  }

  private void b()
  {
    String str = this.o.getText().toString();
    int m = 0;
    int i1 = this.r;
    int i2 = c;
    boolean bool;
    if (i1 == i2)
    {
      h localh1 = this.t;
      int i3 = this.q.c() + 1;
      long l1 = this.q.a();
      bool = localh1.c(str, i3, l1);
    }
    while (TextUtils.isEmpty(str))
    {
      int i4 = this.r;
      int i5 = e;
      if (i4 == i5)
      {
        hb.b(g, "项目名不能为空.");
        return;
        int i6 = this.r;
        int i7 = d;
        if (i6 != i7)
          continue;
        h localh2 = this.t;
        int i8 = this.q.c() + 1;
        long l2 = this.q.a();
        bool = localh2.b(str, i8, l2);
        continue;
      }
      hb.b(g, "类别名不能为空.");
      return;
    }
    if (bool)
    {
      int i9 = this.r;
      int i10 = e;
      if (i9 == i10)
      {
        hb.b(g, "对不起,该项目已经存在.");
        return;
      }
      hb.b(g, "对不起,该分类已经存在.");
      return;
    }
    int i11 = this.r;
    int i12 = c;
    if (i11 == i12)
      long l3 = this.t.b(str);
    while (true)
    {
      this.o.setText("");
      hb.b(g, "保存成功");
      return;
      int i13 = this.r;
      int i14 = d;
      if (i13 != i14)
        continue;
      long l4 = this.t.a(str);
    }
  }

  private void b(long paramLong)
  {
    Intent localIntent1 = new Intent();
    int m = this.r;
    int i1 = e;
    if (m == i1)
    {
      Context localContext1 = g;
      Intent localIntent2 = localIntent1.setClass(localContext1, SettingEditCommonActivity.class);
      String str1 = SettingEditCommonActivity.b;
      int i2 = SettingEditCommonActivity.g;
      Intent localIntent3 = localIntent1.putExtra(str1, i2);
    }
    while (true)
    {
      String str2 = SettingEditCommonActivity.c;
      Intent localIntent4 = localIntent1.putExtra(str2, paramLong);
      String str3 = a;
      int i3 = this.r;
      Intent localIntent5 = localIntent1.putExtra(str3, i3);
      startActivity(localIntent1);
      return;
      Context localContext2 = g;
      Intent localIntent6 = localIntent1.setClass(localContext2, SettingEditCategoryActivity.class);
      String str4 = SettingEditCommonActivity.b;
      int i4 = SettingEditCategoryActivity.g;
      Intent localIntent7 = localIntent1.putExtra(str4, i4);
    }
  }

  private void c()
  {
    AsyncTask localAsyncTask = new qm(this).execute(null);
  }

  private Map d()
  {
    HashMap localHashMap = new HashMap();
    int m = this.s.getCount();
    int i1 = 0;
    while (i1 < m)
    {
      Long localLong = Long.valueOf(((CategoryVo)this.s.getItem(i1)).a());
      Integer localInteger = Integer.valueOf(i1);
      Object localObject = localHashMap.put(localLong, localInteger);
      i1 += 1;
    }
    return localHashMap;
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131231060:
      b();
      return;
    case 2131230807:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g = this;
    setContentView(2130903097);
    Button localButton1 = (Button)findViewById(2131230807);
    this.i = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.j = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.k = localButton2;
    DragListView localDragListView1 = (DragListView)findViewById(2131231077);
    this.l = localDragListView1;
    TextView localTextView2 = (TextView)findViewById(2131230797);
    this.n = localTextView2;
    EditText localEditText = (EditText)findViewById(2131231078);
    this.o = localEditText;
    Button localButton3 = (Button)findViewById(2131231060);
    this.p = localButton3;
    this.i.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.l.setOnItemClickListener(this);
    this.l.setOnItemLongClickListener(this);
    DragListView localDragListView2 = this.l;
    DragListView.OnDropListener localOnDropListener = this.u;
    localDragListView2.a(localOnDropListener);
    Context localContext = g;
    CategoryListViewAdapter localCategoryListViewAdapter1 = new CategoryListViewAdapter(localContext, 2130903061, 1);
    this.s = localCategoryListViewAdapter1;
    DragListView localDragListView3 = this.l;
    CategoryListViewAdapter localCategoryListViewAdapter2 = this.s;
    localDragListView3.setAdapter(localCategoryListViewAdapter2);
    Handler localHandler = this.h;
    ql localql = new ql(this, localHandler);
    dz localdz1 = dz.a();
    String str1 = ea.k;
    localdz1.a(str1, localql);
    dz localdz2 = dz.a();
    String str2 = ea.l;
    localdz2.a(str2, localql);
    dz localdz3 = dz.a();
    String str3 = ea.m;
    localdz3.a(str3, localql);
    Intent localIntent = getIntent();
    String str4 = a;
    int m = b;
    int i1 = localIntent.getIntExtra(str4, m);
    this.r = i1;
    int i2 = this.r;
    int i3 = b;
    if (i2 == i3)
    {
      hb.b(g, "系统错误.");
      finish();
    }
    while (true)
    {
      this.k.setVisibility(4);
      c();
      return;
      int i4 = this.r;
      int i5 = d;
      if (i4 == i5)
      {
        CategoryVo localCategoryVo1 = this.t.e();
        this.q = localCategoryVo1;
        this.j.setText("设置-支出类别");
        continue;
      }
      int i6 = this.r;
      int i7 = c;
      if (i6 != i7)
        continue;
      CategoryVo localCategoryVo2 = this.t.f();
      this.q = localCategoryVo2;
      this.j.setText("设置-收入类别");
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623946, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    gj.a(f, "onDestroy");
    super.onDestroy();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramAdapterView.getId())
    {
    default:
      return;
    case 2131231077:
    }
    int m = this.r;
    int i1 = e;
    if (m == i1)
      return;
    a(paramLong);
  }

  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Context localContext = g;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(localContext);
    qg localqg = new qg(this, paramLong);
    localBuilder.setItems(2131165185, localqg).create().show();
    return true;
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
    gj.a(f, "onPause");
    super.onPause();
  }

  protected void onRestart()
  {
    gj.a(f, "onRestart");
    super.onRestart();
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    int m = paramBundle.getInt("mCategoryType");
    this.r = m;
    CategoryVo localCategoryVo = (CategoryVo)paramBundle.get("mRootCategory");
    this.q = localCategoryVo;
    gj.a(f, "onRestoreInstanceState");
  }

  protected void onResume()
  {
    gj.a(f, "onResume");
    super.onResume();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    int m = this.r;
    paramBundle.putInt("mCategoryType", m);
    CategoryVo localCategoryVo = this.q;
    paramBundle.putParcelable("rootCategory", localCategoryVo);
    gj.a(f, "onSaveInstanceState");
  }

  protected void onStart()
  {
    gj.a(f, "onStart");
    super.onStart();
  }

  protected void onStop()
  {
    gj.a(f, "onStop");
    super.onStop();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingFirstLevelCategoryActivity
 * JD-Core Version:    0.6.0
 */