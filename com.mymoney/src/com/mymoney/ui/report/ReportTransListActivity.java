package com.mymoney.ui.report;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
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
import android.widget.ListView;
import android.widget.TextView;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.main.MainActivity;
import dz;
import ea;
import g;
import gu;
import m;
import nf;
import ni;
import nj;
import tz;

public class ReportTransListActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  public static String a = "id";
  public static String b = "title";
  private static Context d;
  private String c;
  private Handler e;
  private Button f;
  private TextView g;
  private Button h;
  private TextView i;
  private ListView j;
  private View k;
  private tz l;
  private long n;
  private String o;
  private m p;

  public ReportTransListActivity()
  {
    String str = ReportTransListActivity.class.getSimpleName();
    this.c = str;
    Handler localHandler = new Handler();
    this.e = localHandler;
    m localm = g.a().b();
    this.p = localm;
  }

  private void a(long paramLong, int paramInt)
  {
    if (gu.h())
    {
      Context localContext1 = d;
      Intent localIntent1 = new Intent(localContext1, AddOrEditTransNewActivity.class);
      Intent localIntent2 = localIntent1.putExtra("state", 2);
      Intent localIntent3 = localIntent1.putExtra("transType", paramInt);
      Intent localIntent4 = localIntent1.putExtra("id", paramLong);
      startActivity(localIntent1);
      return;
    }
    Context localContext2 = d;
    Intent localIntent5 = new Intent(localContext2, AddOrEditTransactionActivity.class);
    Intent localIntent6 = localIntent5.putExtra("state", 3);
    Intent localIntent7 = localIntent5.putExtra("transType", paramInt);
    Intent localIntent8 = localIntent5.putExtra("id", paramLong);
    startActivity(localIntent5);
  }

  private void a(Class paramClass)
  {
    Context localContext = d;
    Intent localIntent = new Intent(localContext, paramClass);
    startActivity(localIntent);
  }

  private void b()
  {
    AsyncTask localAsyncTask = new nj(this).execute(null);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230807:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d = this;
    setContentView(2130903077);
    Button localButton1 = (Button)findViewById(2131230807);
    this.f = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.g = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.h = localButton2;
    TextView localTextView2 = (TextView)findViewById(2131230797);
    this.i = localTextView2;
    ListView localListView = (ListView)findViewById(2131230860);
    this.j = localListView;
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903058, null);
    this.k = localView;
    this.f.setOnClickListener(this);
    this.j.setOnItemClickListener(this);
    this.j.setOnItemLongClickListener(this);
    Intent localIntent = getIntent();
    String str1 = a;
    long l1 = localIntent.getLongExtra(str1, 65535L);
    this.n = l1;
    String str2 = b;
    String str3 = localIntent.getStringExtra(str2);
    this.o = str3;
    TextView localTextView3 = this.g;
    String str4 = this.o;
    localTextView3.setText(str4);
    this.h.setVisibility(4);
    Handler localHandler = this.e;
    ni localni = new ni(this, localHandler);
    dz localdz1 = dz.a();
    String str5 = ea.b;
    localdz1.a(str5, localni);
    dz localdz2 = dz.a();
    String str6 = ea.c;
    localdz2.a(str6, localni);
    dz localdz3 = dz.a();
    String str7 = ea.d;
    localdz3.a(str7, localni);
    b();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623943, paramMenu);
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
    case 2131230860:
    }
    TransactionVo localTransactionVo = (TransactionVo)this.l.getItem(paramInt);
    long l1 = localTransactionVo.a();
    int m = localTransactionVo.k();
    a(l1, m);
  }

  public boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramAdapterView.getId())
    {
    default:
    case 2131230860:
    }
    while (true)
    {
      return false;
      TransactionVo localTransactionVo = (TransactionVo)this.l.getItem(paramInt);
      long l1 = localTransactionVo.a();
      int m = localTransactionVo.k();
      Context localContext = d;
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(localContext);
      nf localnf = new nf(this, l1, m);
      localBuilder.setItems(2131165185, localnf).create().show();
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131231184:
    case 2131231178:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      setResult(-1);
      finish();
      continue;
      a(MainActivity.class);
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
 * Qualified Name:     com.mymoney.ui.report.ReportTransListActivity
 * JD-Core Version:    0.6.0
 */