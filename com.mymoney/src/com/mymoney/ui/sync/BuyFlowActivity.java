package com.mymoney.ui.sync;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.mymoney.ui.base.BaseActivity;
import hb;
import ri;
import rj;

public class BuyFlowActivity extends BaseActivity
{
  private static String a = BuyFlowActivity.class.getSimpleName();
  private Context b = this;
  private WebView c;
  private ProgressBar d;

  private void a()
  {
    AsyncTask localAsyncTask = new rj(this).execute(null);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903056);
    WebView localWebView1 = (WebView)findViewById(2131230804);
    this.c = localWebView1;
    ProgressBar localProgressBar = (ProgressBar)findViewById(2131230805);
    this.d = localProgressBar;
    WebSettings localWebSettings = this.c.getSettings();
    localWebSettings.setSupportZoom(0);
    localWebSettings.setSupportMultipleWindows(0);
    localWebSettings.setJavaScriptEnabled(1);
    WebView localWebView2 = this.c;
    ri localri = new ri(this);
    localWebView2.setWebViewClient(localri);
    hb.b(this.b, "正在加载开通同步服务页面...");
    a();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623938, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131231179:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      finish();
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.sync.BuyFlowActivity
 * JD-Core Version:    0.6.0
 */