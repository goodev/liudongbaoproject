package com.mymoney.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import c;
import com.flurry.android.FlurryAgent;
import com.mobclick.android.MobclickAgent;
import com.mymoney.ui.widget.Panel;
import gj;
import gt;

public abstract class BaseActivity extends Activity
{
  public static String m = "BaseActivity";

  protected void a(Context paramContext, Class paramClass)
  {
    Intent localIntent = new Intent(paramContext, paramClass);
    startActivity(localIntent);
  }

  public void a(Button paramButton, Panel paramPanel)
  {
    a(paramButton, paramPanel, null);
  }

  public void a(Button paramButton, Panel paramPanel, Boolean paramBoolean)
  {
    int i;
    if ((paramButton != null) && (paramPanel != null))
    {
      if (paramBoolean != null)
        break label70;
      if (!paramPanel.a())
        i = 1;
    }
    while (true)
    {
      if (i != 0)
        paramButton.setBackgroundResource(2130837614);
      while (true)
      {
        boolean bool = paramPanel.a(i, 1);
        return;
        j = 0;
        break;
        paramButton.setBackgroundResource(2130837611);
      }
      gj.a(m, "changeMenuPanelStatus invoke error,titleBtn or menuPanel is null");
      return;
      label70: int j = 0;
    }
  }

  public void onPause()
  {
    super.onPause();
    if (!gt.n())
      return;
    MobclickAgent.onPause(this);
  }

  public void onResume()
  {
    super.onResume();
    if (!gt.n())
      return;
    MobclickAgent.onResume(this);
  }

  public void onStart()
  {
    super.onStart();
    String str = c.a;
    FlurryAgent.onStartSession(this, str);
    FlurryAgent.onPageView();
    gj.a("BaseActivity", "onStart()");
  }

  public void onStop()
  {
    super.onStop();
    FlurryAgent.onEndSession(this);
    gj.a("BaseActivity", "onStop()");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.base.BaseActivity
 * JD-Core Version:    0.6.0
 */