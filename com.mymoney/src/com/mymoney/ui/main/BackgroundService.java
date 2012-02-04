package com.mymoney.ui.main;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.text.TextUtils;
import com.mymoney.ui.helper.NetworkHelper;
import fn;
import ft;
import g;
import gj;
import gt;
import gu;
import hn;
import k;
import lb;
import lc;
import ld;

public class BackgroundService extends Service
{
  public static String a = BackgroundService.class.getSimpleName();
  public static int b = 1;
  public static int c = 259200000;
  public static int d = 432000000;
  public static int e = 432000000;
  public static fn g;
  public final IBinder f;
  private Context h;
  private NotificationManager i;
  private long j;

  public BackgroundService()
  {
    BackgroundService.BackgroundServiceBinder localBackgroundServiceBinder = new BackgroundService.BackgroundServiceBinder(this);
    this.f = localBackgroundServiceBinder;
  }

  public void a()
  {
    ft localft = new ft();
    hn localhn = g.a().h().g();
    String str1 = localhn.a();
    String str2 = localhn.b();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      localft.a(str1, str2);
      gj.a(a, "background service is sign in");
      return;
    }
    gj.a(a, "username or password is empty,background service is sign in cancel");
  }

  public IBinder onBind(Intent paramIntent)
  {
    return this.f;
  }

  public void onCreate()
  {
    super.onCreate();
    gj.a(a, "onCreate()...");
    this.h = this;
    NotificationManager localNotificationManager = (NotificationManager)getSystemService("notification");
    this.i = localNotificationManager;
    if (NetworkHelper.b(this.h))
      AsyncTask localAsyncTask1 = new ld(this).execute(null);
    AsyncTask localAsyncTask2 = new lc(this).execute(null);
    long l1 = gu.c(gu.n);
    long l2 = System.currentTimeMillis();
    this.j = l2;
    long l3 = this.j - l1;
    long l4 = c;
    if (l3 <= l4)
      return;
    if (NetworkHelper.a(this.h))
    {
      if (gt.a(this.h))
      {
        gj.a(a, "Vip Version,cancel auto upgrade auto version check......");
        return;
      }
      if (gt.h())
      {
        gj.a(a, "meizu Version,cancel auto upgrade auto version check......");
        return;
      }
      gj.a(a, "Free Version,auto  upgrade version check...");
      AsyncTask localAsyncTask3 = new lb(this).execute(null);
      return;
    }
    gj.a(a, "network error,cancel auto upgrade auto version check...");
  }

  public void onDestroy()
  {
    super.onDestroy();
    NotificationManager localNotificationManager = this.i;
    int k = b;
    localNotificationManager.cancel(k);
    gj.a(a, "onDestroy()...");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.main.BackgroundService
 * JD-Core Version:    0.6.0
 */