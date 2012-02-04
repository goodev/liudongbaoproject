package com.mymoney.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.mymoney.core.application.ApplicationContext;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.main.MainActivity;
import com.mymoney.ui.repair.RepairModeActivity;
import com.mymoney.ui.security.SecurityActivity;
import g;
import gh;
import gj;
import gu;
import hb;
import hp;
import n;
import rg;
import rh;

public class SplashScreenActivity extends BaseActivity
{
  public static long a = 0L;
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  private String e = "SplashScreenActivity";
  private Context f = this;
  private boolean g = 0;
  private TextView h;
  private AsyncTask i;
  private Handler j;

  public SplashScreenActivity()
  {
    Handler localHandler = new Handler();
    this.j = localHandler;
  }

  private void a()
  {
    if ((TextUtils.isEmpty(gu.f())) && (gu.g()))
      gu.a(0);
    if (gu.g())
    {
      c();
      return;
    }
    b();
  }

  private void b()
  {
    Context localContext = this.f;
    Intent localIntent = new Intent(localContext, MainActivity.class);
    startActivity(localIntent);
    finish();
  }

  private void c()
  {
    Context localContext = this.f;
    Intent localIntent = new Intent(localContext, SecurityActivity.class);
    startActivity(localIntent);
    finish();
  }

  private void d()
  {
    hb.a(this.f, "抱歉,软件发生未知错误,自动进入特别维护模式.");
    Context localContext = this.f;
    Intent localIntent = new Intent(localContext, RepairModeActivity.class);
    startActivity(localIntent);
    finish();
  }

  private void e()
  {
    rh localrh = new rh(this);
    this.i = localrh;
    AsyncTask localAsyncTask = this.i.execute(null);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.f = this;
    setContentView(2130903119);
    TextView localTextView1 = (TextView)findViewById(2131231101);
    this.h = localTextView1;
    TextView localTextView2 = this.h;
    String str = gu.e();
    localTextView2.setText(str);
    if (gh.a)
      hb.a(this.f, "开发版.");
    try
    {
      ApplicationContext.c = g.a().f().a();
      ApplicationContext.d = ApplicationContext.c.a();
      if (this.g)
      {
        d();
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
        this.g = 1;
      Handler localHandler = this.j;
      rg localrg = new rg(this);
      long l = a;
      boolean bool = localHandler.postDelayed(localrg, l);
    }
  }

  protected void onDestroy()
  {
    gj.a(this.e, "onDestroy()");
    super.onDestroy();
  }

  protected void onPause()
  {
    gj.a(this.e, "onPause()");
    super.onPause();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.splash.SplashScreenActivity
 * JD-Core Version:    0.6.0
 */