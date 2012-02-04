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
import com.mymoney.core.vo.ProjectVo;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.widget.DragListView;
import com.mymoney.ui.widget.DragListView.OnDropListener;
import dz;
import ea;
import fa;
import g;
import gj;
import hb;
import java.util.HashMap;
import java.util.Map;
import k;
import qn;
import qq;
import qs;
import qt;
import y;

public class SettingProjectActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  public static String a;
  public static int b;
  public static int c;
  private static String d = SettingProjectActivity.class.getSimpleName();
  private static Context e;
  private Handler f;
  private Button g;
  private TextView h;
  private Button i;
  private DragListView j;
  private TextView k;
  private EditText l;
  private Button n;
  private ProjectListViewAdapter o;
  private k p;
  private DragListView.OnDropListener q;

  static
  {
    a = "categoryType";
    b = -1;
    c = 3;
  }

  public SettingProjectActivity()
  {
    Handler localHandler = new Handler();
    this.f = localHandler;
    k localk = g.a().h();
    this.p = localk;
    qq localqq = new qq(this);
    this.q = localqq;
  }

  private void a(long paramLong)
  {
    Context localContext = e;
    Intent localIntent1 = new Intent(localContext, SettingEditCommonActivity.class);
    String str1 = SettingEditCommonActivity.b;
    int m = SettingEditCommonActivity.g;
    Intent localIntent2 = localIntent1.putExtra(str1, m);
    String str2 = SettingEditCommonActivity.c;
    Intent localIntent3 = localIntent1.putExtra(str2, paramLong);
    String str3 = a;
    int i1 = c;
    Intent localIntent4 = localIntent1.putExtra(str3, i1);
    startActivity(localIntent1);
  }

  private void b()
  {
    String str = this.l.getText().toString();
    boolean bool = y.a().a("", str, 1, 1);
    if (TextUtils.isEmpty(str))
    {
      hb.b(e, "项目名不能为空.");
      return;
    }
    if (bool)
    {
      hb.b(e, "对不起,该项目已经存在.");
      return;
    }
    fa localfa = new fa();
    localfa.a(str);
    localfa.a(1);
    long l1 = y.a().b(localfa);
    this.l.setText("");
    hb.b(e, "保存成功");
  }

  private void c()
  {
    AsyncTask localAsyncTask = new qt(this).execute(null);
  }

  private Map d()
  {
    HashMap localHashMap = new HashMap();
    int m = this.o.getCount();
    int i1 = 0;
    while (i1 < m)
    {
      Long localLong = Long.valueOf(((ProjectVo)this.o.getItem(i1)).a());
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
    e = this;
    setContentView(2130903097);
    Button localButton1 = (Button)findViewById(2131230807);
    this.g = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.h = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.i = localButton2;
    DragListView localDragListView1 = (DragListView)findViewById(2131231077);
    this.j = localDragListView1;
    TextView localTextView2 = (TextView)findViewById(2131230797);
    this.k = localTextView2;
    EditText localEditText = (EditText)findViewById(2131231078);
    this.l = localEditText;
    Button localButton3 = (Button)findViewById(2131231060);
    this.n = localButton3;
    this.g.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.j.setOnItemClickListener(this);
    this.j.setOnItemLongClickListener(this);
    DragListView localDragListView2 = this.j;
    DragListView.OnDropListener localOnDropListener = this.q;
    localDragListView2.a(localOnDropListener);
    Context localContext = e;
    ProjectListViewAdapter localProjectListViewAdapter1 = new ProjectListViewAdapter(localContext, 2130903104);
    this.o = localProjectListViewAdapter1;
    DragListView localDragListView3 = this.j;
    ProjectListViewAdapter localProjectListViewAdapter2 = this.o;
    localDragListView3.setAdapter(localProjectListViewAdapter2);
    Handler localHandler = this.f;
    qs localqs = new qs(this, localHandler);
    dz localdz1 = dz.a();
    String str1 = ea.k;
    localdz1.a(str1, localqs);
    dz localdz2 = dz.a();
    String str2 = ea.l;
    localdz2.a(str2, localqs);
    dz localdz3 = dz.a();
    String str3 = ea.m;
    localdz3.a(str3, localqs);
    this.j.setChoiceMode(1);
    this.h.setText("设置-项目分类");
    this.i.setVisibility(4);
    c();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623946, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    gj.a(d, "onDestroy");
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
    boolean bool = this.p.e(paramLong);
  }

  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramLong == 0L)
      hb.b(this, "对不起，该项目不能进行编辑或删除操作");
    while (true)
    {
      return true;
      Context localContext = e;
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(localContext);
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "编辑";
      arrayOfString[1] = "删除";
      arrayOfString[2] = "设置成默认项目";
      qn localqn = new qn(this, paramLong);
      localBuilder.setItems(arrayOfString, localqn).create().show();
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
    gj.a(d, "onPause");
    super.onPause();
  }

  protected void onRestart()
  {
    gj.a(d, "onRestart");
    super.onRestart();
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    gj.a(d, "onRestoreInstanceState");
  }

  protected void onResume()
  {
    gj.a(d, "onResume");
    super.onResume();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    gj.a(d, "onSaveInstanceState");
  }

  protected void onStart()
  {
    gj.a(d, "onStart");
    super.onStart();
  }

  protected void onStop()
  {
    gj.a(d, "onStop");
    super.onStop();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingProjectActivity
 * JD-Core Version:    0.6.0
 */