package com.mobclick.android;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

public class a
{
  private Context a;
  private int b = 50;
  private String c;
  private String d;
  private String e;
  private Notification f;
  private NotificationManager g;
  private int h;
  private String i = "未联网，更新失败";
  private String j = "Please make sure you are connected to internet, update failed";
  private boolean k = 1;
  private boolean l = 1;
  private int m;
  private Handler n;

  public a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i1 = d.a;
    this.m = i1;
    b localb = new b(this);
    this.n = localb;
    try
    {
      a(paramContext, paramString1, paramString2, paramString3, paramString4);
      return;
    }
    catch (Exception localException)
    {
      String str = localException.getMessage();
      int i2 = Log.e("initialization error", str);
      this.k = 0;
    }
  }

  private int a(String paramString1, String paramString2)
  {
    try
    {
      String str1 = String.valueOf(this.a.getPackageName());
      Field localField = Class.forName(str1 + ".R$" + paramString1).getField(paramString2);
      String str2 = localField.getName();
      int i1 = Integer.parseInt(localField.get(str2).toString());
      i2 = i1;
      return i2;
    }
    catch (Exception localException)
    {
      while (true)
      {
        String str3 = localException.getMessage();
        int i3 = Log.e("getIdByReflection error", str3);
        int i2 = 0;
      }
    }
  }

  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramContext;
    e();
    int i1 = this.m;
    int i2 = d.b;
    if (i1 == i2)
    {
      this.k = 0;
      return;
    }
    File localFile = Environment.getExternalStorageDirectory();
    String str1 = String.valueOf(localFile.getParent());
    StringBuilder localStringBuilder = new StringBuilder(str1).append("/");
    String str2 = localFile.getName();
    String str3 = str2 + "/download";
    this.c = str3;
    this.e = paramString1;
    this.h = 17301633;
    int i3 = this.h;
    Notification localNotification1 = new Notification(i3, paramString2, 1L);
    this.f = localNotification1;
    Notification localNotification2 = this.f;
    int i4 = localNotification2.flags | 0x2;
    localNotification2.flags = i4;
    String str4 = this.a.getPackageName();
    int i5 = a("layout", "umeng_download_notification");
    RemoteViews localRemoteViews = new RemoteViews(str4, i5);
    int i6 = a("id", "progress_bar");
    localRemoteViews.setProgressBar(i6, 100, 0, 0);
    int i7 = a("id", "progress_text");
    localRemoteViews.setTextViewText(i7, "0%");
    int i8 = a("id", "title");
    localRemoteViews.setTextViewText(i8, paramString3);
    int i9 = a("id", "description");
    localRemoteViews.setTextViewText(i9, paramString4);
    int i10 = a("id", "appIcon");
    int i11 = this.h;
    localRemoteViews.setImageViewResource(i10, i11);
    this.f.contentView = localRemoteViews;
    Intent localIntent1 = new Intent();
    String str5 = this.a.getPackageName();
    String str6 = this.a.getClass().getName();
    Intent localIntent2 = localIntent1.setClassName(str5, str6);
    Notification localNotification3 = this.f;
    PendingIntent localPendingIntent = PendingIntent.getActivity(this.a, 0, localIntent1, 134217728);
    localNotification3.contentIntent = localPendingIntent;
    NotificationManager localNotificationManager = (NotificationManager)this.a.getSystemService("notification");
    this.g = localNotificationManager;
  }

  private void c()
  {
    try
    {
      String str1 = this.e;
      byte[] arrayOfByte = c(str1);
      if (!this.k)
      {
        this.g.cancel(0);
        return;
      }
      String str2 = String.valueOf(System.currentTimeMillis());
      String str3 = String.valueOf(str2 + ".apk");
      this.d = str3;
      String str4 = this.c;
      String str5 = this.d;
      File localFile = new File(str4, str5);
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      int i1 = arrayOfByte.length;
      localFileOutputStream.write(arrayOfByte, 0, i1);
      localFileOutputStream.close();
      this.g.cancel(0);
      boolean bool = this.n.sendEmptyMessage(0);
      return;
    }
    catch (Exception localException)
    {
      String str6 = localException.getMessage();
      int i2 = Log.e("cannot save to sd card", str6);
      this.k = 0;
    }
  }

  private byte[] c(String paramString)
  {
    try
    {
      String str1 = this.e;
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(str1).openConnection();
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setDoOutput(1);
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.connect();
      localObject1 = localHttpURLConnection.getInputStream();
      NotificationManager localNotificationManager1 = this.g;
      Notification localNotification1 = this.f;
      localNotificationManager1.notify(0, localNotification1);
      arrayOfByte = new byte[1024];
      int i2 = localHttpURLConnection.getContentLength();
      localArrayList = new ArrayList(i2);
      i3 = 0;
      i4 = 0;
      i5 = ((InputStream)localObject1).read(arrayOfByte);
      if (i5 <= 0);
      while (true)
      {
        ((InputStream)localObject1).close();
        i2 = localArrayList.size();
        localObject1 = new byte[i2];
        arrayOfByte = null;
        if (arrayOfByte < i2)
          break label390;
        localObject2 = localObject1;
        return localObject2;
        i3 += i5;
        i6 = 0;
        if (i6 < i5)
          break;
        i5 = i4 + 1;
        int i7 = this.b;
        if (i4 % i7 != 0)
          break label383;
        if (f())
          break label251;
        this.k = 0;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        Object localObject1;
        byte[] arrayOfByte;
        ArrayList localArrayList;
        int i3;
        int i5;
        int i6;
        String str2 = localException.getMessage();
        int i8 = Log.e("can not save to memory", str2);
        Object localObject2 = null;
        continue;
        Byte localByte = Byte.valueOf(arrayOfByte[i6]);
        boolean bool = localArrayList.add(localByte);
        i6 += 1;
        continue;
        label251: float f1 = i3 * 100.0F;
        float f2 = localObject2;
        int i9 = (int)(f1 / f2);
        RemoteViews localRemoteViews1 = this.f.contentView;
        int i10 = a("id", "progress_bar");
        localRemoteViews1.setProgressBar(i10, 100, i9, 0);
        RemoteViews localRemoteViews2 = this.f.contentView;
        int i11 = a("id", "progress_text");
        String str3 = String.valueOf(String.valueOf(i9));
        String str4 = str3 + "%";
        localRemoteViews2.setTextViewText(i11, str4);
        NotificationManager localNotificationManager2 = this.g;
        Notification localNotification2 = this.f;
        localNotificationManager2.notify(0, localNotification2);
        label383: int i4 = i5;
        continue;
        label390: int i12 = ((Byte)localArrayList.get(arrayOfByte)).byteValue();
        localObject1[arrayOfByte] = i12;
        int i1 = arrayOfByte + 1;
      }
    }
  }

  private void d()
  {
    try
    {
      String str1 = String.valueOf(System.currentTimeMillis());
      String str2 = String.valueOf(str1 + ".apk");
      this.d = str2;
      String str3 = this.e;
      byte[] arrayOfByte = c(str3);
      if (!this.k)
      {
        this.g.cancel(0);
        return;
      }
      String str4 = this.a.getFilesDir().getAbsolutePath();
      this.c = str4;
      Context localContext = this.a;
      String str5 = this.d;
      FileOutputStream localFileOutputStream = localContext.openFileOutput(str5, 3);
      localFileOutputStream.write(arrayOfByte);
      localFileOutputStream.close();
      this.g.cancel(0);
      boolean bool = this.n.sendEmptyMessage(0);
      return;
    }
    catch (Exception localException)
    {
      String str6 = localException.getMessage();
      int i1 = Log.e("can not save to memory", str6);
      this.k = 0;
    }
  }

  private void d(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists())
      return;
    boolean bool = localFile.mkdirs();
  }

  private void e()
  {
    if (!f())
    {
      Context localContext = this.a;
      String str = h();
      Toast.makeText(localContext, str, 3).show();
      int i1 = d.b;
      this.m = i1;
      return;
    }
    if (!g())
    {
      int i2 = d.c;
      this.m = i2;
      return;
    }
    int i3 = d.a;
    this.m = i3;
  }

  private boolean f()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
      boolean bool1;
      if (localNetworkInfo != null)
        bool1 = localNetworkInfo.isConnectedOrConnecting();
      for (bool2 = bool1; ; bool2 = false)
        return bool2;
    }
    catch (Exception localException)
    {
      while (true)
        boolean bool2 = true;
    }
  }

  private boolean g()
  {
    if (Environment.getExternalStorageState().equals("mounted"));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private String h()
  {
    if (this.a.getResources().getConfiguration().locale.toString().equals("zh_CN"));
    for (String str = this.i; ; str = this.j)
      return str;
  }

  public void a(int paramInt)
  {
    this.h = paramInt;
    this.f.icon = paramInt;
    RemoteViews localRemoteViews = this.f.contentView;
    int i1 = a("id", "appIcon");
    localRemoteViews.setImageViewResource(i1, paramInt);
  }

  public void a(String paramString)
  {
    RemoteViews localRemoteViews = this.f.contentView;
    int i1 = a("id", "title");
    localRemoteViews.setTextViewText(i1, paramString);
  }

  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public boolean a()
  {
    return this.k;
  }

  public void b()
  {
    if (!this.k)
      return;
    try
    {
      String str1 = this.c;
      d(str1);
      new c(this).start();
      return;
    }
    catch (Exception localException)
    {
      String str2 = localException.getMessage();
      int i1 = Log.e("MobclickAgent", str2);
    }
  }

  public void b(String paramString)
  {
    this.c = paramString;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mobclick.android.a
 * JD-Core Version:    0.6.0
 */