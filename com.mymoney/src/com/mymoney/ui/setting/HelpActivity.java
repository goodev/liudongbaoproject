package com.mymoney.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import hb;
import nw;
import nx;
import ny;

public class HelpActivity extends Activity
  implements View.OnClickListener
{
  private Context a;
  private WebView b;
  private Button c;

  private void a()
  {
    AsyncTask localAsyncTask = new ny(this).execute(null);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230811:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903065);
    this.a = this;
    Button localButton = (Button)findViewById(2131230811);
    this.c = localButton;
    WebView localWebView1 = (WebView)findViewById(2131230810);
    this.b = localWebView1;
    this.c.setOnClickListener(this);
    WebSettings localWebSettings = this.b.getSettings();
    localWebSettings.setSupportZoom(0);
    localWebSettings.setSupportMultipleWindows(0);
    localWebSettings.setJavaScriptEnabled(1);
    WebView localWebView2 = this.b;
    nw localnw = new nw(this);
    localWebView2.setWebViewClient(localnw);
    WebView localWebView3 = this.b;
    nx localnx = new nx(this);
    localWebView3.setWebViewClient(localnx);
    hb.b(this.a, "正在加载帮助,请稍后...");
    a();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.b.canGoBack()))
      this.b.goBack();
    boolean bool;
    for (int i = 1; ; bool = super.onKeyDown(paramInt, paramKeyEvent))
      return i;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.HelpActivity
 * JD-Core Version:    0.6.0
 */