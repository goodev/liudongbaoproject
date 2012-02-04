package com.mymoney.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import g;
import hb;
import hk;
import j;
import k;
import qe;

public class SettingCurrencySelectActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private static Context b;
  private int a = 2;
  private Button c;
  private TextView d;
  private Button e;
  private ListView f;
  private TextView g;
  private String h = "";
  private hk i;
  private DefaultCurrencyCodeListViewAdapter j;
  private j k;
  private k l;

  public SettingCurrencySelectActivity()
  {
    j localj = g.a().k();
    this.k = localj;
    k localk = g.a().h();
    this.l = localk;
  }

  private Intent a(String paramString)
  {
    Intent localIntent1 = new Intent();
    Intent localIntent2 = localIntent1.putExtra("currencyCode", paramString);
    return localIntent1;
  }

  private void a()
  {
    AsyncTask localAsyncTask = new qe(this).execute(null);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230807:
    }
    Intent localIntent = a(null);
    setResult(2, localIntent);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b = this;
    setContentView(2130903091);
    Button localButton1 = (Button)findViewById(2131230807);
    this.c = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.d = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.e = localButton2;
    ListView localListView1 = (ListView)findViewById(2131231065);
    this.f = localListView1;
    TextView localTextView2 = (TextView)findViewById(2131230797);
    this.g = localTextView2;
    this.c.setOnClickListener(this);
    this.f.setOnItemClickListener(this);
    Context localContext = b;
    DefaultCurrencyCodeListViewAdapter localDefaultCurrencyCodeListViewAdapter1 = new DefaultCurrencyCodeListViewAdapter(localContext, 2130903107);
    this.j = localDefaultCurrencyCodeListViewAdapter1;
    ListView localListView2 = this.f;
    DefaultCurrencyCodeListViewAdapter localDefaultCurrencyCodeListViewAdapter2 = this.j;
    localListView2.setAdapter(localDefaultCurrencyCodeListViewAdapter2);
    Intent localIntent = getIntent();
    int m = localIntent.getIntExtra("from", -1);
    this.a = m;
    String str1 = localIntent.getStringExtra("currencyCode");
    this.h = str1;
    if ((this.a == -1) || (TextUtils.isEmpty(this.h)))
    {
      hb.b(b, "参数错误");
      finish();
    }
    this.f.setChoiceMode(1);
    this.d.setText("币种");
    this.e.setVisibility(4);
    j localj = this.k;
    String str2 = this.h;
    hk localhk = localj.a(str2);
    this.i = localhk;
    a();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str1 = this.k.a(paramLong).c();
    if (this.h.equalsIgnoreCase(str1))
    {
      String str2 = this.h;
      Intent localIntent1 = a(str2);
      setResult(2, localIntent1);
    }
    while (true)
    {
      finish();
      return;
      int m = this.a;
      if (1 == m)
        boolean bool = this.l.a(str1);
      Intent localIntent2 = a(str1);
      setResult(1, localIntent2);
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingCurrencySelectActivity
 * JD-Core Version:    0.6.0
 */