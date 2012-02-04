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
import h;
import hb;
import java.util.HashMap;
import java.util.Map;
import k;
import kp;
import qy;
import rb;
import rd;
import re;

public class SettingSubcategoryActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  public static String a;
  private static String b = SettingSubcategoryActivity.class.getSimpleName();
  private static Context c;
  private Handler d;
  private Button e;
  private TextView f;
  private Button g;
  private DragListView h;
  private TextView i;
  private EditText j;
  private Button k;
  private kp l;
  private CategoryListViewAdapter n;
  private h o;
  private k p;
  private CategoryVo q;
  private int r;
  private DragListView.OnDropListener s;

  static
  {
    a = "id";
  }

  public SettingSubcategoryActivity()
  {
    Handler localHandler = new Handler();
    this.d = localHandler;
    h localh = g.a().d();
    this.o = localh;
    k localk = g.a().h();
    this.p = localk;
    this.q = null;
    rb localrb = new rb(this);
    this.s = localrb;
  }

  private void a(long paramLong)
  {
    Context localContext = c;
    Intent localIntent1 = new Intent(localContext, SettingEditCategoryActivity.class);
    String str1 = SettingEditCommonActivity.b;
    int m = SettingEditCategoryActivity.g;
    Intent localIntent2 = localIntent1.putExtra(str1, m);
    String str2 = SettingEditCommonActivity.c;
    Intent localIntent3 = localIntent1.putExtra(str2, paramLong);
    startActivity(localIntent1);
  }

  private void b()
  {
    String str = this.j.getText().toString();
    long l1 = this.q.a();
    int m = this.q.c() + 1;
    int i1 = this.r;
    int i2 = SettingFirstLevelCategoryActivity.c;
    if (i1 == i2)
      boolean bool1 = this.o.c(str, m, l1);
    while (TextUtils.isEmpty(str))
    {
      hb.b(c, "分类名不能为空");
      return;
      int i3 = this.r;
      int i4 = SettingFirstLevelCategoryActivity.d;
      if (i3 != i4)
        continue;
      boolean bool2 = this.o.b(str, m, l1);
    }
    if (this.o.b(str, m, l1))
    {
      hb.b(c, "对不起,该分类已经存在!");
      return;
    }
    long l2 = this.o.a(l1, str);
    this.j.setText("");
    hb.b(c, "保存成功.");
  }

  private void c()
  {
    AsyncTask localAsyncTask = new re(this).execute(null);
  }

  private Map d()
  {
    HashMap localHashMap = new HashMap();
    int m = this.n.getCount();
    int i1 = 0;
    while (i1 < m)
    {
      Long localLong = Long.valueOf(((CategoryVo)this.n.getItem(i1)).a());
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
    c = this;
    setContentView(2130903101);
    Button localButton1 = (Button)findViewById(2131230807);
    this.e = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.f = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.g = localButton2;
    DragListView localDragListView1 = (DragListView)findViewById(2131231086);
    this.h = localDragListView1;
    TextView localTextView2 = (TextView)findViewById(2131230797);
    this.i = localTextView2;
    EditText localEditText = (EditText)findViewById(2131231087);
    this.j = localEditText;
    Button localButton3 = (Button)findViewById(2131231060);
    this.k = localButton3;
    this.e.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.h.setOnItemClickListener(this);
    this.h.setOnItemLongClickListener(this);
    DragListView localDragListView2 = this.h;
    DragListView.OnDropListener localOnDropListener = this.s;
    localDragListView2.a(localOnDropListener);
    Context localContext1 = c;
    kp localkp = new kp(localContext1, 2130903112);
    this.l = localkp;
    this.l.a(2130903111);
    Context localContext2 = c;
    CategoryListViewAdapter localCategoryListViewAdapter1 = new CategoryListViewAdapter(localContext2, 2130903104, 0);
    this.n = localCategoryListViewAdapter1;
    DragListView localDragListView3 = this.h;
    CategoryListViewAdapter localCategoryListViewAdapter2 = this.n;
    localDragListView3.setAdapter(localCategoryListViewAdapter2);
    Handler localHandler = this.d;
    rd localrd = new rd(this, localHandler);
    dz localdz1 = dz.a();
    String str1 = ea.k;
    localdz1.a(str1, localrd);
    dz localdz2 = dz.a();
    String str2 = ea.l;
    localdz2.a(str2, localrd);
    dz localdz3 = dz.a();
    String str3 = ea.m;
    localdz3.a(str3, localrd);
    this.h.setChoiceMode(1);
    Intent localIntent = getIntent();
    String str4 = a;
    long l1 = localIntent.getLongExtra(str4, 0L);
    String str5 = SettingFirstLevelCategoryActivity.a;
    int m = localIntent.getIntExtra(str5, 0);
    this.r = m;
    if (l1 != 0L)
    {
      int i1 = this.r;
      int i2 = SettingFirstLevelCategoryActivity.b;
      if (i1 != i2);
    }
    else
    {
      hb.b(c, "抱歉,系统错误");
      finish();
    }
    while (true)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str6 = this.q.b();
      String str7 = str6 + "-" + "子类别";
      this.f.setText(str7);
      this.g.setVisibility(4);
      c();
      return;
      CategoryVo localCategoryVo = this.o.c(l1);
      this.q = localCategoryVo;
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623947, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramAdapterView.getId())
    {
    default:
      return;
    case 2131231086:
    }
    int m = this.r;
    int i1 = SettingFirstLevelCategoryActivity.c;
    if (m == i1)
    {
      boolean bool1 = this.p.d(paramLong);
      return;
    }
    int i2 = this.r;
    int i3 = SettingFirstLevelCategoryActivity.d;
    if (i2 != i3)
      return;
    boolean bool2 = this.p.c(paramLong);
  }

  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Context localContext = c;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(localContext);
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "编辑";
    arrayOfString[1] = "删除";
    arrayOfString[2] = "设置成默认分类";
    qy localqy = new qy(this, paramLong);
    localBuilder.setItems(arrayOfString, localqy).create().show();
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131231191:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
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
 * Qualified Name:     com.mymoney.ui.setting.SettingSubcategoryActivity
 * JD-Core Version:    0.6.0
 */