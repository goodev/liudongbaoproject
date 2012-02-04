package com.mymoney.ui.setting;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import c;
import com.flurry.android.FlurryAgent;
import com.mymoney.ui.splash.SplashScreenActivity;
import ep;
import g;
import gj;
import gv;
import k;
import nr;

public class AutoBackupService extends Service
{
  private Context a;
  private PendingIntent b;
  private PendingIntent c;
  private k d;

  public AutoBackupService()
  {
    k localk = g.a().h();
    this.d = localk;
  }

  private boolean a()
  {
    return this.d.j();
  }

  private void b()
  {
    gj.a("AutoBackupService", "startting auto backup");
    if (ep.a())
    {
      nr localnr = new nr(this, null);
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "";
      AsyncTask localAsyncTask = localnr.execute(arrayOfString);
      return;
    }
    Context localContext = this.a;
    PendingIntent localPendingIntent = this.b;
    gv.b(localContext, 256, "自动备份数据失败", "SD卡不可用", localPendingIntent);
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    this.a = this;
    Context localContext1 = this.a;
    Intent localIntent1 = new Intent();
    PendingIntent localPendingIntent1 = PendingIntent.getBroadcast(localContext1, 0, localIntent1, 0);
    this.b = localPendingIntent1;
    Context localContext2 = this.a;
    Intent localIntent2 = new Intent(this, SplashScreenActivity.class);
    PendingIntent localPendingIntent2 = PendingIntent.getActivity(localContext2, 0, localIntent2, 0);
    this.c = localPendingIntent2;
  }

  public void onDestroy()
  {
    super.onDestroy();
    FlurryAgent.onEndSession(this.a);
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    String str = c.a;
    FlurryAgent.onStartSession(this, str);
    FlurryAgent.onPageView();
    b();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.AutoBackupService
 * JD-Core Version:    0.6.0
 */