package com.mymoney.core.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import dalvik.system.VMRuntime;
import dh;
import ei;
import fp;
import g;
import gj;
import gu;
import hp;
import k;

public class ApplicationContext extends Application
{
  public static Context a;
  public static dh b;
  public static hp c;
  public static long d;
  public static boolean e;
  public static long f;
  public static String g;
  private static String h = "ApplicationContext";

  static
  {
    d = 65533L;
    e = 1;
    f = 65535L;
    g = "";
  }

  public ApplicationContext()
  {
    a();
  }

  private void a()
  {
    a = this;
  }

  private void b()
  {
    if (!gu.m())
      return;
    gj.a(h, "start replace mymoney database continue...");
    try
    {
      fp.c();
      gu.h(0);
      gj.a(h, "replace mymoney database success");
      return;
    }
    catch (ei localei)
    {
      while (true)
        localei.printStackTrace();
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    gj.a(h, "onConfigurationChanged(Configuration newConfig)...");
  }

  public void onCreate()
  {
    gj.a(h, "onCreate()...");
    Context localContext = a;
    b = new dh(localContext);
    gj.a(h, "dbHelpser is construct...");
    float f1 = VMRuntime.getRuntime().setTargetHeapUtilization(0.75F);
    b();
    try
    {
      g = g.a().h().a();
      return;
    }
    catch (Exception localException)
    {
      g = "CNY";
      localException.printStackTrace();
    }
  }

  public void onLowMemory()
  {
    gj.a(h, "onLowMemory()...");
  }

  public void onTerminate()
  {
    gj.a(h, "onTerminate()...");
    if (b != null)
    {
      b.close();
      b = null;
    }
    super.onTerminate();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.core.application.ApplicationContext
 * JD-Core Version:    0.6.0
 */