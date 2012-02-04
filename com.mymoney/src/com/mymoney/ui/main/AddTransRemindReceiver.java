package com.mymoney.ui.main;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import c;
import com.flurry.android.FlurryAgent;
import com.mymoney.ui.splash.SplashScreenActivity;
import g;
import gt;
import gv;
import la;
import m;

public class AddTransRemindReceiver extends BroadcastReceiver
{
  private long a = 259200000L;
  private long b;
  private Context c;
  private PendingIntent d;
  private int e;
  private m f;

  public AddTransRemindReceiver()
  {
    m localm = g.a().b();
    this.f = localm;
  }

  private void a()
  {
    long l1 = gt.a();
    long l2 = this.b;
    long l3 = l1 - l2;
    if (this.e > 0)
    {
      long l4 = this.a;
      if (l3 > l4)
      {
        int i = (int)(l3 / 86400000L);
        Context localContext = this.c;
        String str = "您已经有" + i + "天没有记账了";
        PendingIntent localPendingIntent = this.d;
        gv.b(localContext, 128, str, "点击开始记账", localPendingIntent);
      }
    }
    FlurryAgent.onEndSession(this.c);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = c.a;
    FlurryAgent.onStartSession(paramContext, str);
    FlurryAgent.onPageView();
    this.c = paramContext;
    Context localContext = this.c;
    Intent localIntent = new Intent(paramContext, SplashScreenActivity.class);
    PendingIntent localPendingIntent = PendingIntent.getActivity(localContext, 0, localIntent, 0);
    this.d = localPendingIntent;
    la localla = new la(this, null);
    Void[] arrayOfVoid = new Void[0];
    AsyncTask localAsyncTask = localla.execute(arrayOfVoid);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.main.AddTransRemindReceiver
 * JD-Core Version:    0.6.0
 */