package com.mymoney.ui.setting;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.helper.CurrencyCodeIconResourcesHelper;
import com.mymoney.ui.helper.NetworkHelper;
import dz;
import ea;
import g;
import hk;
import j;
import java.util.List;
import k;
import pz;
import qa;
import qb;
import qc;

public class SettingCurrencyRateActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private static Context a;
  private static String b = "SettingCurrencyRateActivity";
  private Button c;
  private TextView d;
  private Button e;
  private RelativeLayout f;
  private ImageView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private ListView k;
  private TextView l;
  private CurrencyRateListViewAdapter n;
  private j o;
  private k p;
  private List q;

  public SettingCurrencyRateActivity()
  {
    j localj = g.a().k();
    this.o = localj;
    k localk = g.a().h();
    this.p = localk;
  }

  private void b()
  {
    String str = this.p.a();
    List localList1 = this.o.b(str);
    this.q = localList1;
    CurrencyRateListViewAdapter localCurrencyRateListViewAdapter = this.n;
    List localList2 = this.q;
    localCurrencyRateListViewAdapter.a(localList2);
  }

  private void c()
  {
    j localj = this.o;
    String str1 = this.p.a();
    hk localhk = localj.a(str1);
    if (localhk == null)
      return;
    String str2 = localhk.d();
    ImageView localImageView = this.g;
    int m = CurrencyCodeIconResourcesHelper.a(str2);
    localImageView.setBackgroundResource(m);
    TextView localTextView1 = this.h;
    String str3 = localhk.b();
    localTextView1.setText(str3);
    TextView localTextView2 = this.i;
    String str4 = localhk.c();
    localTextView2.setText(str4);
    this.j.setText("本位币");
  }

  private void d()
  {
    if (NetworkHelper.a(a))
    {
      AsyncTask localAsyncTask = new qc(this).execute(null);
      return;
    }
    b();
    Context localContext = a;
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle("温馨提示").setMessage("汇率更新需要在网络环境下进行,请打开你的手机网络.");
    qa localqa = new qa(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton("打开网络", localqa);
    pz localpz = new pz(this);
    localBuilder2.setNegativeButton("取消", localpz).create().show();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default:
      return;
    case 1:
    }
    if (paramInt2 != 1)
      return;
    d();
    c();
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
      d();
      return;
    case 2131231061:
    }
    Context localContext = a;
    Intent localIntent1 = new Intent(localContext, SettingCurrencySelectActivity.class);
    Intent localIntent2 = localIntent1.putExtra("from", 1);
    String str = this.p.a();
    Intent localIntent3 = localIntent1.putExtra("currencyCode", str);
    startActivityForResult(localIntent1, 1);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a = this;
    setContentView(2130903089);
    Button localButton1 = (Button)findViewById(2131230807);
    this.c = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.d = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.e = localButton2;
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131231061);
    this.f = localRelativeLayout;
    ImageView localImageView = (ImageView)findViewById(2131231062);
    this.g = localImageView;
    TextView localTextView2 = (TextView)findViewById(2131231033);
    this.h = localTextView2;
    TextView localTextView3 = (TextView)findViewById(2131231063);
    this.i = localTextView3;
    TextView localTextView4 = (TextView)findViewById(2131231064);
    this.j = localTextView4;
    ListView localListView1 = (ListView)findViewById(2131231065);
    this.k = localListView1;
    TextView localTextView5 = (TextView)findViewById(2131230797);
    this.l = localTextView5;
    c();
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.k.setOnItemClickListener(this);
    Context localContext = a;
    CurrencyRateListViewAdapter localCurrencyRateListViewAdapter1 = new CurrencyRateListViewAdapter(localContext, 2130903108);
    this.n = localCurrencyRateListViewAdapter1;
    ListView localListView2 = this.k;
    CurrencyRateListViewAdapter localCurrencyRateListViewAdapter2 = this.n;
    localListView2.setAdapter(localCurrencyRateListViewAdapter2);
    this.d.setText("初始汇率");
    Handler localHandler = new Handler();
    qb localqb = new qb(this, localHandler);
    dz localdz = dz.a();
    String str = ea.q;
    localdz.a(str, localqb);
    b();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Context localContext = a;
    Intent localIntent1 = new Intent(localContext, SettingCurrencyRateEditActivity.class);
    long l1 = ((hk)this.q.get(paramInt)).g();
    Intent localIntent2 = localIntent1.putExtra("exchangePOID", l1);
    startActivity(localIntent1);
  }

  protected void onResume()
  {
    super.onResume();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingCurrencyRateActivity
 * JD-Core Version:    0.6.0
 */