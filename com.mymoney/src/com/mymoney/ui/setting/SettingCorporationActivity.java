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
import com.mymoney.core.vo.CorporationVo;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.widget.DragListView;
import com.mymoney.ui.widget.DragListView.OnDropListener;
import dz;
import ea;
import g;
import hb;
import i;
import java.util.HashMap;
import java.util.Map;
import k;
import ps;
import pv;
import px;
import py;

public class SettingCorporationActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  private static String a = SettingCorporationActivity.class.getSimpleName();
  private static Context b;
  private Handler c;
  private Button d;
  private TextView e;
  private Button f;
  private DragListView g;
  private TextView h;
  private EditText i;
  private Button j;
  private CorporationListViewAdapter k;
  private i l;
  private k n;
  private DragListView.OnDropListener o;

  public SettingCorporationActivity()
  {
    Handler localHandler = new Handler();
    this.c = localHandler;
    i locali = g.a().e();
    this.l = locali;
    k localk = g.a().h();
    this.n = localk;
    pv localpv = new pv(this);
    this.o = localpv;
  }

  private void a(long paramLong)
  {
    Context localContext = b;
    Intent localIntent1 = new Intent(localContext, SettingEditCommonActivity.class);
    String str1 = SettingEditCommonActivity.b;
    int m = SettingEditCommonActivity.f;
    Intent localIntent2 = localIntent1.putExtra(str1, m);
    String str2 = SettingEditCommonActivity.c;
    Intent localIntent3 = localIntent1.putExtra(str2, paramLong);
    startActivity(localIntent1);
  }

  private void c()
  {
    String str = this.i.getText().toString();
    if (TextUtils.isEmpty(str))
    {
      hb.b(b, "商家名不能为空");
      return;
    }
    if (this.l.b(str))
    {
      hb.b(b, "对不起,该商家已经存在!");
      return;
    }
    CorporationVo localCorporationVo = new CorporationVo();
    long l1 = this.l.a(str);
    this.i.setText("");
    hb.b(b, "保存成功.");
  }

  private void d()
  {
    AsyncTask localAsyncTask = new px(this).execute(null);
  }

  private Map e()
  {
    HashMap localHashMap = new HashMap();
    int m = this.k.getCount();
    int i1 = 0;
    while (i1 < m)
    {
      Long localLong = Long.valueOf(((CorporationVo)this.k.getItem(i1)).a());
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
      c();
      return;
    case 2131230807:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b = this;
    setContentView(2130903088);
    Button localButton1 = (Button)findViewById(2131230807);
    this.d = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.e = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.f = localButton2;
    DragListView localDragListView1 = (DragListView)findViewById(2131231058);
    this.g = localDragListView1;
    TextView localTextView2 = (TextView)findViewById(2131230797);
    this.h = localTextView2;
    EditText localEditText = (EditText)findViewById(2131231059);
    this.i = localEditText;
    Button localButton3 = (Button)findViewById(2131231060);
    this.j = localButton3;
    this.d.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.g.setOnItemClickListener(this);
    this.g.setOnItemLongClickListener(this);
    DragListView localDragListView2 = this.g;
    DragListView.OnDropListener localOnDropListener = this.o;
    localDragListView2.a(localOnDropListener);
    Context localContext = b;
    CorporationListViewAdapter localCorporationListViewAdapter1 = new CorporationListViewAdapter(localContext, 2130903109);
    this.k = localCorporationListViewAdapter1;
    DragListView localDragListView3 = this.g;
    CorporationListViewAdapter localCorporationListViewAdapter2 = this.k;
    localDragListView3.setAdapter(localCorporationListViewAdapter2);
    this.g.setChoiceMode(1);
    Handler localHandler = this.c;
    py localpy = new py(this, localHandler);
    dz localdz1 = dz.a();
    String str1 = ea.h;
    localdz1.a(str1, localpy);
    dz localdz2 = dz.a();
    String str2 = ea.i;
    localdz2.a(str2, localpy);
    dz localdz3 = dz.a();
    String str3 = ea.j;
    localdz3.a(str3, localpy);
    this.e.setText("设置-商家");
    this.f.setVisibility(4);
    d();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623946, paramMenu);
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
    case 2131231058:
    }
    boolean bool = this.n.b(paramLong);
  }

  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramLong == 0L)
      hb.b(this, "对不起，该商家不能进行编辑或删除操作");
    while (true)
    {
      return true;
      Context localContext = b;
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(localContext);
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "编辑";
      arrayOfString[1] = "删除";
      arrayOfString[2] = "设置成默认商家";
      ps localps = new ps(this, paramLong);
      localBuilder.setItems(arrayOfString, localps).create().show();
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
 * Qualified Name:     com.mymoney.ui.setting.SettingCorporationActivity
 * JD-Core Version:    0.6.0
 */