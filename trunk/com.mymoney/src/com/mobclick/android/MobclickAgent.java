package com.mobclick.android;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MobclickAgent
  implements e
{
  private static final MobclickAgent a = new MobclickAgent();
  private static final String b = "MobclickAgent";
  private static final String c = "Android";
  private static final String d = "Android";
  private static final String e = "2.1";
  private static final long f = 30000L;
  private static final String g = "http://www.umeng.com/app_logs";
  private static final String h = "http://www.umeng.com/api/check_app_update";
  private static final int i = 8;
  private static int j = 1;
  private static String m = "";
  private static String n = "";
  private static boolean o = 1;
  private static UmengUpdateListener p = null;
  private static UmengFeedbackListener q = null;
  private static boolean r = 1;
  private Context k;
  private final Handler l;

  private MobclickAgent()
  {
    HandlerThread localHandlerThread = new HandlerThread("MobclickAgent");
    localHandlerThread.start();
    Looper localLooper = localHandlerThread.getLooper();
    Handler localHandler = new Handler(localLooper);
    this.l = localHandler;
  }

  private static String a(Context paramContext)
  {
    Object localObject = null;
    try
    {
      String str = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      localObject = str;
      return localObject;
    }
    catch (Exception localException)
    {
      while (true)
        int i1 = Log.i("MobclickAgent", "Could not read MAC, forget to include ACCESS_WIFI_STATE permission?", localException);
    }
  }

  private String a(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    Long localLong = Long.valueOf(System.currentTimeMillis());
    SharedPreferences.Editor localEditor1 = paramSharedPreferences.edit();
    long l1 = localLong.longValue();
    SharedPreferences.Editor localEditor2 = localEditor1.putLong("start_millis", l1);
    SharedPreferences.Editor localEditor3 = localEditor1.putLong("end_millis", 65535L);
    boolean bool = localEditor1.commit();
    return paramSharedPreferences.getString("session_id", null);
  }

  private String a(Context paramContext, String paramString, SharedPreferences paramSharedPreferences)
  {
    c(paramContext, paramSharedPreferences);
    long l1 = System.currentTimeMillis();
    String str1 = String.valueOf(paramString);
    StringBuilder localStringBuilder = new StringBuilder(str1);
    String str2 = String.valueOf(l1);
    String str3 = str2;
    SharedPreferences.Editor localEditor1 = paramSharedPreferences.edit();
    SharedPreferences.Editor localEditor2 = localEditor1.putString("appkey", paramString);
    SharedPreferences.Editor localEditor3 = localEditor1.putString("session_id", str3);
    SharedPreferences.Editor localEditor4 = localEditor1.putLong("start_millis", l1);
    SharedPreferences.Editor localEditor5 = localEditor1.putLong("end_millis", 65535L);
    SharedPreferences.Editor localEditor6 = localEditor1.putLong("duration", 0L);
    SharedPreferences.Editor localEditor7 = localEditor1.putString("activities", "");
    boolean bool = localEditor1.commit();
    b(paramContext, paramSharedPreferences);
    return str3;
  }

  // ERROR //
  private static String a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 206	java/io/InputStreamReader
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 209	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   8: astore_1
    //   9: new 211	java/io/BufferedReader
    //   12: dup
    //   13: aload_1
    //   14: sipush 8192
    //   17: invokespecial 214	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_2
    //   21: new 176	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   28: astore_3
    //   29: aload_2
    //   30: invokevirtual 218	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore 4
    //   35: aload 4
    //   37: astore 5
    //   39: aload 5
    //   41: ifnonnull +14 -> 55
    //   44: aload_0
    //   45: invokevirtual 223	java/io/InputStream:close	()V
    //   48: aload_3
    //   49: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore_2
    //   53: aload_2
    //   54: areturn
    //   55: aload 5
    //   57: invokestatic 174	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   60: astore 6
    //   62: new 176	java/lang/StringBuilder
    //   65: dup
    //   66: aload 6
    //   68: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: ldc 225
    //   73: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore 7
    //   81: aload_3
    //   82: aload 7
    //   84: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: astore 8
    //   89: goto -60 -> 29
    //   92: astore_2
    //   93: ldc 12
    //   95: ldc 227
    //   97: aload_2
    //   98: invokestatic 229	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   101: istore 9
    //   103: aload_0
    //   104: invokevirtual 223	java/io/InputStream:close	()V
    //   107: aconst_null
    //   108: astore_2
    //   109: goto -56 -> 53
    //   112: astore 10
    //   114: ldc 12
    //   116: ldc 227
    //   118: aload 10
    //   120: invokestatic 229	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   123: istore 11
    //   125: aconst_null
    //   126: astore_2
    //   127: goto -74 -> 53
    //   130: astore 12
    //   132: aload_0
    //   133: invokevirtual 223	java/io/InputStream:close	()V
    //   136: aload 12
    //   138: athrow
    //   139: astore 13
    //   141: ldc 12
    //   143: ldc 227
    //   145: aload 13
    //   147: invokestatic 229	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   150: istore 14
    //   152: aconst_null
    //   153: astore_2
    //   154: goto -101 -> 53
    //   157: astore 15
    //   159: ldc 12
    //   161: ldc 227
    //   163: aload 15
    //   165: invokestatic 229	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   168: istore 16
    //   170: aconst_null
    //   171: astore_2
    //   172: goto -119 -> 53
    //
    // Exception table:
    //   from	to	target	type
    //   29	35	92	java/io/IOException
    //   55	89	92	java/io/IOException
    //   103	107	112	java/io/IOException
    //   29	35	130	finally
    //   55	89	130	finally
    //   93	103	130	finally
    //   132	136	139	java/io/IOException
    //   44	48	157	java/io/IOException
  }

  private static String a(JSONObject paramJSONObject, String paramString)
  {
    String str1 = paramJSONObject.toString();
    int i1 = Log.i("MobclickAgent", str1);
    Object localObject = new HttpPost(paramString);
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
    try
    {
      ArrayList localArrayList = new ArrayList(1);
      String str2 = paramJSONObject.toString();
      BasicNameValuePair localBasicNameValuePair = new BasicNameValuePair("content", str2);
      boolean bool = localArrayList.add(localBasicNameValuePair);
      UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(localArrayList, "UTF-8");
      ((HttpPost)localObject).setEntity(localUrlEncodedFormEntity);
      localObject = localDefaultHttpClient.execute((HttpUriRequest)localObject);
      if (((HttpResponse)localObject).getStatusLine().getStatusCode() == 200)
      {
        String str3 = "Sent message to " + paramString;
        int i2 = Log.i("MobclickAgent", str3);
        localObject = ((HttpResponse)localObject).getEntity();
        if (localObject != null)
          localObject = a(((HttpEntity)localObject).getContent());
      }
      while (true)
      {
        return localObject;
        localObject = null;
        continue;
        int i3 = Log.i("MobclickAgent", "Failed to send message.");
        localObject = null;
      }
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      while (true)
      {
        int i4 = Log.i("MobclickAgent", "ClientProtocolException,Failed to send message.", localClientProtocolException);
        localObject = null;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        int i5 = Log.i("MobclickAgent", "IOException,Failed to send message.", localIOException);
        localObject = null;
      }
    }
  }

  private void a(Context paramContext, SharedPreferences paramSharedPreferences, String paramString1, String paramString2, int paramInt)
  {
    String str1 = paramSharedPreferences.getString("session_id", "");
    String str2 = b();
    String str3 = str2.split(" ")[0];
    String str4 = str2.split(" ")[1];
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = localJSONObject1.put("type", "event");
      JSONObject localJSONObject3 = localJSONObject1.put("session_id", str1);
      JSONObject localJSONObject4 = localJSONObject1.put("date", str3);
      JSONObject localJSONObject5 = localJSONObject1.put("time", str4);
      JSONObject localJSONObject6 = localJSONObject1.put("tag", paramString1);
      JSONObject localJSONObject7 = localJSONObject1.put("label", paramString2);
      JSONObject localJSONObject8 = localJSONObject1.put("acc", paramInt);
      Handler localHandler = this.l;
      j localj = new j(this, paramContext, localJSONObject1);
      boolean bool = localHandler.post(localj);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  /** @deprecated */
  // ERROR //
  private void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 234	org/json/JSONObject
    //   5: dup
    //   6: invokespecial 337	org/json/JSONObject:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: ldc_w 339
    //   14: ldc_w 370
    //   17: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   20: astore 4
    //   22: aload_3
    //   23: ldc 189
    //   25: aload_2
    //   26: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: astore 5
    //   31: aload_1
    //   32: invokevirtual 374	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   35: astore 6
    //   37: aload_1
    //   38: invokevirtual 377	android/content/Context:getPackageName	()Ljava/lang/String;
    //   41: astore 7
    //   43: aload 6
    //   45: aload 7
    //   47: iconst_0
    //   48: invokevirtual 383	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   51: getfield 388	android/content/pm/PackageInfo:versionCode	I
    //   54: istore 8
    //   56: aload_1
    //   57: invokevirtual 377	android/content/Context:getPackageName	()Ljava/lang/String;
    //   60: astore 9
    //   62: aload_3
    //   63: ldc_w 390
    //   66: iload 8
    //   68: invokevirtual 358	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   71: astore 10
    //   73: aload_3
    //   74: ldc_w 392
    //   77: aload 9
    //   79: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   82: astore 11
    //   84: aload_0
    //   85: getfield 90	com/mobclick/android/MobclickAgent:l	Landroid/os/Handler;
    //   88: astore 12
    //   90: new 360	com/mobclick/android/j
    //   93: dup
    //   94: aload_0
    //   95: aload_1
    //   96: aload_3
    //   97: invokespecial 363	com/mobclick/android/j:<init>	(Lcom/mobclick/android/MobclickAgent;Landroid/content/Context;Lorg/json/JSONObject;)V
    //   100: astore 13
    //   102: aload 12
    //   104: aload 13
    //   106: invokevirtual 367	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   109: istore 14
    //   111: aload_0
    //   112: monitorexit
    //   113: return
    //   114: astore 15
    //   116: aload_0
    //   117: monitorexit
    //   118: aload 15
    //   120: athrow
    //   121: astore 16
    //   123: goto -12 -> 111
    //
    // Exception table:
    //   from	to	target	type
    //   2	10	114	finally
    //   10	84	114	finally
    //   84	111	114	finally
    //   10	84	121	java/lang/Exception
  }

  /** @deprecated */
  private void a(Context paramContext, String paramString1, String paramString2)
  {
    monitorenter;
    while (true)
    {
      SharedPreferences localSharedPreferences2;
      try
      {
        this.k = paramContext;
        SharedPreferences localSharedPreferences1 = m(paramContext);
        localSharedPreferences2 = localSharedPreferences1;
        if (localSharedPreferences2 == null)
          return;
        if (a(localSharedPreferences2))
        {
          String str1 = a(paramContext, paramString1, localSharedPreferences2);
          String str2 = "Start new session: " + str1;
          int i1 = Log.i("MobclickAgent", str2);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      String str3 = a(paramContext, localSharedPreferences2);
      String str4 = "Extend current session: " + str3;
      int i2 = Log.i("MobclickAgent", str4);
    }
  }

  /** @deprecated */
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    monitorenter;
    try
    {
      SharedPreferences localSharedPreferences1 = m(paramContext);
      SharedPreferences localSharedPreferences2 = localSharedPreferences1;
      if (localSharedPreferences2 == null);
      while (true)
      {
        return;
        MobclickAgent localMobclickAgent = this;
        Context localContext = paramContext;
        String str1 = paramString2;
        String str2 = paramString3;
        int i1 = paramInt;
        localMobclickAgent.a(localContext, localSharedPreferences2, str1, str2, i1);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  /** @deprecated */
  private void a(Context paramContext, JSONObject paramJSONObject)
  {
    monitorenter;
    if (paramJSONObject != null);
    try
    {
      b(paramContext, paramJSONObject);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private boolean a(SharedPreferences paramSharedPreferences)
  {
    long l1 = paramSharedPreferences.getLong("end_millis", 65535L);
    if (System.currentTimeMillis() - l1 > 30000L);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private static boolean a(String paramString, Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    String str1 = paramContext.getPackageName();
    boolean bool;
    if ((localPackageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", str1) == 0) && (!p(paramContext)))
      bool = false;
    while (true)
    {
      return bool;
      if ((paramString == "update") || (paramString == "feedback"))
      {
        bool = true;
        continue;
      }
      if (j == 3)
      {
        if (paramString == "flush")
        {
          bool = true;
          continue;
        }
      }
      else
      {
        if (paramString == "error")
        {
          bool = true;
          continue;
        }
        if ((j == 1) && (paramString == "launch"))
        {
          bool = true;
          continue;
        }
        if ((j == 2) && (paramString == "terminate"))
        {
          bool = true;
          continue;
        }
        if (j == 0)
        {
          bool = true;
          continue;
        }
        if (j == 4)
        {
          SharedPreferences localSharedPreferences = l(paramContext);
          String str2 = k.A();
          String str3 = localSharedPreferences.getString(str2, "false");
          String str4 = "Log has been sent today: " + str3 + ";type:" + paramString;
          int i1 = Log.i("MobclickAgent", str4);
          if ((str3.equals("true")) || (!paramString.equals("launch")))
          {
            bool = false;
            continue;
          }
          bool = true;
          continue;
        }
        if (j == 5)
        {
          bool = q(paramContext)[0].equals("Wi-Fi");
          continue;
        }
      }
      bool = false;
    }
  }

  private static String b()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date localDate = new Date();
    return localSimpleDateFormat.format(localDate);
  }

  private static String b(Context paramContext)
  {
    Object localObject1 = null;
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      String str1 = paramContext.getPackageName();
      Object localObject2 = localPackageManager.getApplicationInfo(str1, 128);
      if (localObject2 != null)
      {
        String str2 = ((ApplicationInfo)localObject2).metaData.getString("UMENG_APPKEY");
        localObject2 = str2;
        if (localObject2 == null)
          break label57;
        localObject1 = localObject2;
      }
      while (true)
      {
        return localObject1.trim();
        label57: int i1 = Log.i("MobclickAgent", "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
      }
    }
    catch (Exception localException)
    {
      while (true)
        int i2 = Log.i("MobclickAgent", "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", localException);
    }
  }

  private void b(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    String str1 = paramSharedPreferences.getString("session_id", null);
    if (str1 == null)
    {
      int i1 = Log.e("MobclickAgent", "Missing session_id, ignore message");
      return;
    }
    String str2 = b();
    String str3 = str2.split(" ")[0];
    String str4 = str2.split(" ")[1];
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = localJSONObject1.put("type", "launch");
      JSONObject localJSONObject3 = localJSONObject1.put("session_id", str1);
      JSONObject localJSONObject4 = localJSONObject1.put("date", str3);
      JSONObject localJSONObject5 = localJSONObject1.put("time", str4);
      Handler localHandler = this.l;
      j localj = new j(this, paramContext, localJSONObject1);
      boolean bool = localHandler.post(localj);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  /** @deprecated */
  private void b(Context paramContext, String paramString)
  {
    monitorenter;
    try
    {
      String str = d(paramContext);
      if (str != "")
      {
        int i1 = str.length();
        if (i1 <= 10240)
          break label30;
      }
      while (true)
      {
        return;
        label30: c(paramContext, str);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void b(Context paramContext, JSONObject paramJSONObject)
  {
    String str1 = b();
    String str2 = str1.split(" ")[0];
    String str3 = str1.split(" ")[1];
    try
    {
      JSONObject localJSONObject1 = paramJSONObject.put("type", "feedback");
      JSONObject localJSONObject2 = paramJSONObject.put("date", str2);
      JSONObject localJSONObject3 = paramJSONObject.put("time", str3);
      Handler localHandler = this.l;
      j localj = new j(this, paramContext, paramJSONObject);
      boolean bool = localHandler.post(localj);
      return;
    }
    catch (JSONException localJSONException)
    {
      UmengFeedbackListener localUmengFeedbackListener = q;
      int i1 = FeedbackStatus.FAILED;
      localUmengFeedbackListener.onFeedbackReturned(i1);
    }
  }

  private static String c(Context paramContext)
  {
    Object localObject1 = "Unknown";
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      String str = paramContext.getPackageName();
      Object localObject2 = localPackageManager.getApplicationInfo(str, 128);
      if ((localObject2 != null) && (((ApplicationInfo)localObject2).metaData != null))
      {
        localObject2 = ((ApplicationInfo)localObject2).metaData.getString("UMENG_CHANNEL");
        if (localObject2 == null)
          break label60;
        localObject1 = localObject2;
      }
      while (true)
      {
        return localObject1;
        label60: int i1 = Log.i("MobclickAgent", "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
      }
    }
    catch (Exception localException)
    {
      while (true)
        int i2 = Log.i("MobclickAgent", "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.", localException);
    }
  }

  private void c(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    Object localObject = paramSharedPreferences.getString("session_id", null);
    if (localObject == null)
    {
      int i1 = Log.w("MobclickAgent", "Missing session_id, ignore message");
      return;
    }
    Long localLong1 = Long.valueOf(paramSharedPreferences.getLong("duration", 65535L));
    if (localLong1.longValue() <= 0L)
      Long localLong2 = Long.valueOf(0L);
    String str1 = b();
    String str2 = str1.split(" ")[0];
    String str3 = str1.split(" ")[1];
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = localJSONObject1.put("type", "terminate");
      JSONObject localJSONObject3 = localJSONObject1.put("session_id", localObject);
      JSONObject localJSONObject4 = localJSONObject1.put("date", str2);
      JSONObject localJSONObject5 = localJSONObject1.put("time", str3);
      String str4 = String.valueOf(localLong1.longValue() / 1000L);
      JSONObject localJSONObject6 = localJSONObject1.put("duration", str4);
      JSONArray localJSONArray1;
      if (o)
      {
        localObject = paramSharedPreferences.getString("activities", "").split(";");
        localJSONArray1 = new JSONArray();
        str3 = null;
      }
      while (true)
      {
        int i3 = localObject.length;
        if (str3 >= i3)
        {
          JSONObject localJSONObject7 = localJSONObject1.put("activities", localJSONArray1);
          Handler localHandler = this.l;
          j localj = new j(this, paramContext, localJSONObject1);
          boolean bool = localHandler.post(localj);
          return;
        }
        String str5 = localObject[str3];
        JSONArray localJSONArray2 = new JSONArray(str5);
        JSONArray localJSONArray3 = localJSONArray1.put(localJSONArray2);
        int i2 = str3 + 1;
      }
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void c(Context paramContext, String paramString)
  {
    String str1 = b();
    String str2 = str1.split(" ")[0];
    String str3 = str1.split(" ")[1];
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = localJSONObject1.put("type", "error");
      JSONObject localJSONObject3 = localJSONObject1.put("context", paramString);
      JSONObject localJSONObject4 = localJSONObject1.put("date", str2);
      JSONObject localJSONObject5 = localJSONObject1.put("time", str3);
      Handler localHandler = this.l;
      j localj = new j(this, paramContext, localJSONObject1);
      boolean bool = localHandler.post(localj);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void c(Context paramContext, JSONObject paramJSONObject)
  {
    if (a("update", paramContext))
    {
      String str1 = a(paramJSONObject, "http://www.umeng.com/api/check_app_update");
      String str2 = "return message from " + str1;
      int i1 = Log.i("MobclickAgent", str2);
      if (str1 != null)
      {
        d(paramContext, str1);
        return;
      }
      if (p == null)
        return;
      UmengUpdateListener localUmengUpdateListener1 = p;
      int i2 = UpdateStatus.Timeout;
      localUmengUpdateListener1.onUpdateReturned(i2);
      return;
    }
    if (p == null)
      return;
    UmengUpdateListener localUmengUpdateListener2 = p;
    int i3 = UpdateStatus.No;
    localUmengUpdateListener2.onUpdateReturned(i3);
  }

  private AlertDialog d(Context paramContext, JSONObject paramJSONObject)
  {
    try
    {
      String str1 = paramJSONObject.getString("version");
      String str2 = paramJSONObject.getString("update_log");
      String str3 = paramJSONObject.getString("path");
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(paramContext);
      String str4 = k.h(paramContext);
      AlertDialog.Builder localBuilder2 = localBuilder1.setTitle(str4);
      String str5 = String.valueOf(k.i(paramContext));
      String str6 = str5 + str1 + "\n" + str2;
      AlertDialog.Builder localBuilder3 = localBuilder2.setMessage(str6).setCancelable(0);
      String str7 = k.j(paramContext);
      g localg = new g(this, paramContext, str3);
      AlertDialog.Builder localBuilder4 = localBuilder3.setPositiveButton(str7, localg);
      String str8 = k.m(paramContext);
      h localh = new h(this);
      AlertDialog.Builder localBuilder5 = localBuilder4.setNegativeButton(str8, localh);
      localAlertDialog = localBuilder1.create();
      localAlertDialog.setCancelable(1);
      return localAlertDialog;
    }
    catch (Exception localException)
    {
      while (true)
      {
        int i1 = Log.e("MobclickAgent", "Fail to create update dialog box.", localException);
        AlertDialog localAlertDialog = null;
      }
    }
  }

  private static String d(Context paramContext)
  {
    Object localObject1 = 0;
    try
    {
      localObject2 = paramContext.getPackageName();
      ArrayList localArrayList = new ArrayList();
      boolean bool1 = localArrayList.add("logcat");
      boolean bool2 = localArrayList.add("-d");
      boolean bool3 = localArrayList.add("-v");
      boolean bool4 = localArrayList.add("raw");
      boolean bool5 = localArrayList.add("-s");
      boolean bool6 = localArrayList.add("AndroidRuntime:E");
      boolean bool7 = localArrayList.add("-p");
      boolean bool8 = localArrayList.add(localObject2);
      Runtime localRuntime = Runtime.getRuntime();
      String[] arrayOfString1 = new String[localArrayList.size()];
      String[] arrayOfString2 = (String[])localArrayList.toArray(arrayOfString1);
      InputStream localInputStream = localRuntime.exec(arrayOfString2).getInputStream();
      InputStreamReader localInputStreamReader = new InputStreamReader(localInputStream);
      BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader, 1024);
      String str1 = localBufferedReader.readLine();
      int i1 = 0;
      String str2 = "";
      if (str1 == null)
      {
        int i2 = str2.length();
        if ((i2 > 0) && (i1 != 0) && (localObject1 != 0))
          localObject2 = str2;
      }
      else
      {
        while (true)
        {
          try
          {
            Process localProcess = Runtime.getRuntime().exec("logcat -c");
            return localObject2;
            if (str1.indexOf("thread attach failed") >= 0)
              continue;
            String str4 = String.valueOf(str2);
            String str5 = str4 + str1 + 10;
            if ((i1 != 0) || (str1.toLowerCase().indexOf("exception") < 0))
              continue;
            i1 = 1;
            if ((localObject1 != 0) || (str1.indexOf((String)localObject2) < 0))
              break label349;
            Object localObject3 = 1;
            String str3 = localBufferedReader.readLine();
            String str6 = str3;
            localObject1 = localObject3;
            localObject4 = str6;
          }
          catch (Exception localException1)
          {
            try
            {
              int i3 = Log.e("MobclickAgent", "Failed to clear log");
            }
            catch (Exception localException2)
            {
            }
          }
          int i4 = Log.e("MobclickAgent", "Failed to catch error log");
        }
      }
    }
    catch (Exception localException3)
    {
      while (true)
      {
        Object localObject2 = "";
        continue;
        localObject2 = "";
        continue;
        label349: Object localObject4 = localObject1;
      }
    }
  }

  private void d(Context paramContext, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (!localJSONObject.getString("update").equals("Yes"))
      {
        if (p == null)
          return;
        UmengUpdateListener localUmengUpdateListener1 = p;
        int i1 = UpdateStatus.No;
        localUmengUpdateListener1.onUpdateReturned(i1);
        return;
      }
      if (p != null)
      {
        UmengUpdateListener localUmengUpdateListener2 = p;
        int i2 = UpdateStatus.Yes;
        localUmengUpdateListener2.onUpdateReturned(i2);
      }
      d(paramContext, localJSONObject).show();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  /** @deprecated */
  private void e(Context paramContext)
  {
    monitorenter;
    while (true)
    {
      Object localObject1;
      try
      {
        if (this.k == paramContext)
          continue;
        int i1 = Log.e("MobclickAgent", "onPause() called without context from corresponding onResume()");
        return;
        this.k = paramContext;
        localObject1 = m(paramContext);
        if (localObject1 == null)
          continue;
        l1 = ((SharedPreferences)localObject1).getLong("start_millis", 65535L);
        if (l1 == 65535L)
        {
          int i2 = Log.e("MobclickAgent", "onEndSession called before onStartSession");
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      long l2 = System.currentTimeMillis();
      long l1 = l2 - l1;
      long l3 = ((SharedPreferences)localObject1).getLong("duration", 0L);
      SharedPreferences.Editor localEditor1 = ((SharedPreferences)localObject1).edit();
      if (o)
      {
        localObject1 = ((SharedPreferences)localObject1).getString("activities", "");
        String str1 = paramContext.getClass().getName();
        if (!"".equals(localObject1))
        {
          String str2 = String.valueOf(localObject1);
          localObject1 = str2 + ";";
        }
        String str3 = String.valueOf(localObject1);
        StringBuilder localStringBuilder = new StringBuilder(str3).append("[").append(str1).append(",");
        long l4 = l1 / 1000L;
        String str4 = l4 + "]";
        SharedPreferences.Editor localEditor2 = localEditor1.remove("activities");
        SharedPreferences.Editor localEditor3 = localEditor1.putString("activities", str4);
      }
      SharedPreferences.Editor localEditor4 = localEditor1.putLong("start_millis", 65535L);
      SharedPreferences.Editor localEditor5 = localEditor1.putLong("end_millis", l2);
      long l5 = l1 + l3;
      SharedPreferences.Editor localEditor6 = localEditor1.putLong("duration", l5);
      boolean bool = localEditor1.commit();
    }
  }

  private void e(Context paramContext, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject1 = j(paramContext);
    if (localJSONObject1 == null)
    {
      int i1 = Log.e("MobclickAgent", "Fail to construct message header");
      return;
    }
    JSONObject localJSONObject2 = h(paramContext);
    JSONObject localJSONObject3 = new JSONObject();
    String str1;
    while (true)
    {
      try
      {
        str1 = paramJSONObject.getString("type");
        if (str1 == null)
          return;
        if (str1 == "flush")
          continue;
        Object localObject = paramJSONObject.remove("type");
        if (localJSONObject2 == null)
          break label159;
        if (localJSONObject2.isNull(str1))
        {
          JSONArray localJSONArray1 = new JSONArray();
          JSONArray localJSONArray2 = localJSONArray1.put(paramJSONObject);
          JSONObject localJSONObject4 = localJSONObject2.put(str1, localJSONArray1);
          if (localJSONObject2 != null)
            break;
          int i2 = Log.w("MobclickAgent", "No cache message to flush");
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        int i3 = Log.e("MobclickAgent", "Fail to construct json message.");
        i(paramContext);
        return;
      }
      JSONArray localJSONArray3 = localJSONObject2.getJSONArray(str1).put(paramJSONObject);
      continue;
      label159: localJSONObject2 = new JSONObject();
      JSONArray localJSONArray4 = new JSONArray();
      JSONArray localJSONArray5 = localJSONArray4.put(paramJSONObject);
      JSONObject localJSONObject5 = localJSONObject2.put(str1, localJSONArray4);
    }
    JSONObject localJSONObject6 = localJSONObject3.put("header", localJSONObject1);
    JSONObject localJSONObject7 = localJSONObject3.put("body", localJSONObject2);
    if (a(str1, paramContext))
    {
      if (a(localJSONObject3, "http://www.umeng.com/app_logs") != null)
      {
        int i4 = Log.i("MobclickAgent", "send message succeed, clear cache");
        if (str1.equals("feedback"))
        {
          UmengFeedbackListener localUmengFeedbackListener1 = q;
          int i5 = FeedbackStatus.SUCCEED;
          localUmengFeedbackListener1.onFeedbackReturned(i5);
        }
        i(paramContext);
        if (j != 4)
          return;
        SharedPreferences.Editor localEditor1 = l(paramContext).edit();
        String str2 = k.A();
        SharedPreferences.Editor localEditor2 = localEditor1.putString(str2, "true");
        boolean bool = localEditor1.commit();
        return;
      }
      if (str1.equals("feedback"))
      {
        UmengFeedbackListener localUmengFeedbackListener2 = q;
        int i6 = FeedbackStatus.FAILED;
        localUmengFeedbackListener2.onFeedbackReturned(i6);
      }
    }
    while (true)
    {
      f(paramContext, localJSONObject2);
      return;
      if (!str1.equals("feedback"))
        continue;
      UmengFeedbackListener localUmengFeedbackListener3 = q;
      int i7 = FeedbackStatus.DISCONNECT;
      localUmengFeedbackListener3.onFeedbackReturned(i7);
    }
  }

  public static void enterPage(Context paramContext, String paramString)
  {
    onEvent(paramContext, "_PAGE_", paramString);
  }

  /** @deprecated */
  private void f(Context paramContext)
  {
    monitorenter;
    try
    {
      g(paramContext);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private static void f(Context paramContext, JSONObject paramJSONObject)
  {
    String str = o(paramContext);
    try
    {
      FileOutputStream localFileOutputStream = paramContext.openFileOutput(str, 0);
      byte[] arrayOfByte = paramJSONObject.toString().getBytes();
      localFileOutputStream.write(arrayOfByte);
      localFileOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
    }
  }

  public static void flush(Context paramContext)
  {
    if (paramContext == null);
    try
    {
      int i1 = Log.e("MobclickAgent", "unexpected null context");
      a.f(paramContext);
      return;
    }
    catch (Exception localException)
    {
      int i2 = Log.e("MobclickAgent", "Exception occurred in Mobclick.flush(). ");
    }
  }

  private void g(Context paramContext)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = localJSONObject1.put("type", "flush");
      Handler localHandler = this.l;
      j localj = new j(this, paramContext, localJSONObject1);
      boolean bool = localHandler.post(localj);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private static JSONObject h(Context paramContext)
  {
    Object localObject1 = o(paramContext);
    try
    {
      localObject1 = paramContext.openFileInput((String)localObject1);
      Object localObject2 = "";
      Object localObject3 = new byte[16384];
      int i1 = ((FileInputStream)localObject1).read(localObject3);
      if (i1 == -1)
      {
        if (((String)localObject2).length() != 0)
          break label93;
        localObject1 = null;
      }
      while (true)
      {
        return localObject1;
        String str1 = String.valueOf(localObject2);
        StringBuilder localStringBuilder = new StringBuilder(str1);
        String str2 = new String(localObject3, 0, i1);
        String str3 = str2;
        localObject2 = str3;
        break;
        try
        {
          label93: localObject3 = new JSONObject((String)localObject2);
          localObject1 = localObject3;
        }
        catch (JSONException localJSONException)
        {
          ((FileInputStream)localObject1).close();
          i(paramContext);
          localObject1 = null;
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (true)
        localObject1 = null;
    }
    catch (IOException localIOException)
    {
      while (true)
        localObject1 = null;
    }
  }

  private static void i(Context paramContext)
  {
    String str1 = n(paramContext);
    boolean bool1 = paramContext.deleteFile(str1);
    String str2 = o(paramContext);
    boolean bool2 = paramContext.deleteFile(str2);
  }

  // ERROR //
  private static JSONObject j(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 832	com/mobclick/android/MobclickAgent:k	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   4: astore_1
    //   5: new 234	org/json/JSONObject
    //   8: dup
    //   9: invokespecial 337	org/json/JSONObject:<init>	()V
    //   12: astore_2
    //   13: aload_0
    //   14: ldc_w 834
    //   17: invokevirtual 102	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   20: checkcast 836	android/telephony/TelephonyManager
    //   23: astore_3
    //   24: aload_3
    //   25: ifnonnull +17 -> 42
    //   28: ldc 12
    //   30: ldc_w 838
    //   33: invokestatic 544	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   36: istore 4
    //   38: aconst_null
    //   39: astore_3
    //   40: aload_3
    //   41: areturn
    //   42: ldc 57
    //   44: astore 5
    //   46: aload_0
    //   47: ldc_w 840
    //   50: invokestatic 845	com/mobclick/android/m:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   53: ifeq +13 -> 66
    //   56: aload_3
    //   57: invokevirtual 848	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   60: astore 6
    //   62: aload 6
    //   64: astore 5
    //   66: aload 5
    //   68: invokestatic 854	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifeq +39 -> 110
    //   74: ldc 12
    //   76: ldc_w 838
    //   79: invokestatic 544	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   82: istore 7
    //   84: aload_0
    //   85: invokestatic 856	com/mobclick/android/MobclickAgent:a	(Landroid/content/Context;)Ljava/lang/String;
    //   88: astore 5
    //   90: aload 5
    //   92: ifnonnull +18 -> 110
    //   95: ldc 12
    //   97: ldc_w 858
    //   100: invokestatic 544	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   103: istore 8
    //   105: aconst_null
    //   106: astore_3
    //   107: goto -67 -> 40
    //   110: aload_2
    //   111: ldc_w 860
    //   114: aload 5
    //   116: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   119: astore 9
    //   121: getstatic 865	android/os/Build:MODEL	Ljava/lang/String;
    //   124: astore 10
    //   126: aload_2
    //   127: ldc_w 867
    //   130: aload 10
    //   132: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   135: astore 11
    //   137: aload_0
    //   138: invokestatic 869	com/mobclick/android/MobclickAgent:b	(Landroid/content/Context;)Ljava/lang/String;
    //   141: astore 5
    //   143: aload 5
    //   145: ifnonnull +18 -> 163
    //   148: ldc 12
    //   150: ldc_w 871
    //   153: invokestatic 516	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   156: istore 12
    //   158: aconst_null
    //   159: astore_3
    //   160: goto -120 -> 40
    //   163: aload_2
    //   164: ldc 189
    //   166: aload 5
    //   168: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: astore 13
    //   173: aload_0
    //   174: invokestatic 873	com/mobclick/android/MobclickAgent:c	(Landroid/content/Context;)Ljava/lang/String;
    //   177: astore 14
    //   179: aload_2
    //   180: ldc_w 875
    //   183: aload 14
    //   185: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   188: astore 15
    //   190: aload_0
    //   191: invokevirtual 374	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   194: astore 16
    //   196: aload_0
    //   197: invokevirtual 377	android/content/Context:getPackageName	()Ljava/lang/String;
    //   200: astore 17
    //   202: aload 16
    //   204: aload 17
    //   206: iconst_0
    //   207: invokevirtual 383	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   210: astore 18
    //   212: aload 18
    //   214: getfield 878	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   217: astore 19
    //   219: aload 18
    //   221: getfield 388	android/content/pm/PackageInfo:versionCode	I
    //   224: istore 20
    //   226: aload_2
    //   227: ldc_w 880
    //   230: aload 19
    //   232: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   235: astore 21
    //   237: aload_2
    //   238: ldc_w 390
    //   241: iload 20
    //   243: invokevirtual 358	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   246: astore 22
    //   248: aload_2
    //   249: ldc_w 882
    //   252: ldc 15
    //   254: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   257: astore 23
    //   259: aload_2
    //   260: ldc_w 884
    //   263: ldc 19
    //   265: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   268: astore 24
    //   270: aload_2
    //   271: ldc_w 886
    //   274: ldc 15
    //   276: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   279: astore 25
    //   281: getstatic 891	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   284: astore 26
    //   286: aload_2
    //   287: ldc_w 893
    //   290: aload 26
    //   292: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   295: astore 27
    //   297: new 895	android/content/res/Configuration
    //   300: dup
    //   301: invokespecial 896	android/content/res/Configuration:<init>	()V
    //   304: astore 5
    //   306: aload_0
    //   307: invokevirtual 900	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   310: aload 5
    //   312: invokestatic 906	android/provider/Settings$System:getConfiguration	(Landroid/content/ContentResolver;Landroid/content/res/Configuration;)V
    //   315: aload 5
    //   317: ifnull +512 -> 829
    //   320: aload 5
    //   322: getfield 910	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   325: ifnull +504 -> 829
    //   328: aload 5
    //   330: getfield 910	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   333: invokevirtual 915	java/util/Locale:getCountry	()Ljava/lang/String;
    //   336: astore 28
    //   338: aload_2
    //   339: ldc_w 917
    //   342: aload 28
    //   344: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   347: astore 29
    //   349: aload 5
    //   351: getfield 910	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   354: invokevirtual 918	java/util/Locale:toString	()Ljava/lang/String;
    //   357: astore 30
    //   359: aload_2
    //   360: ldc_w 920
    //   363: aload 30
    //   365: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   368: astore 31
    //   370: aload 5
    //   372: getfield 910	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   375: invokestatic 926	java/util/Calendar:getInstance	(Ljava/util/Locale;)Ljava/util/Calendar;
    //   378: astore 5
    //   380: aload 5
    //   382: ifnull +433 -> 815
    //   385: aload 5
    //   387: invokevirtual 930	java/util/Calendar:getTimeZone	()Ljava/util/TimeZone;
    //   390: astore 5
    //   392: aload 5
    //   394: ifnull +388 -> 782
    //   397: aload 5
    //   399: invokevirtual 935	java/util/TimeZone:getRawOffset	()I
    //   402: ldc_w 936
    //   405: idiv
    //   406: istore 32
    //   408: aload_2
    //   409: ldc_w 938
    //   412: iload 32
    //   414: invokevirtual 358	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   417: astore 33
    //   419: new 940	android/util/DisplayMetrics
    //   422: dup
    //   423: invokespecial 941	android/util/DisplayMetrics:<init>	()V
    //   426: astore 34
    //   428: aload_0
    //   429: ldc_w 943
    //   432: invokevirtual 102	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   435: checkcast 945	android/view/WindowManager
    //   438: invokeinterface 949 1 0
    //   443: aload 34
    //   445: invokevirtual 955	android/view/Display:getMetrics	(Landroid/util/DisplayMetrics;)V
    //   448: aload 34
    //   450: getfield 958	android/util/DisplayMetrics:widthPixels	I
    //   453: istore 35
    //   455: aload 34
    //   457: getfield 961	android/util/DisplayMetrics:heightPixels	I
    //   460: invokestatic 964	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   463: invokestatic 174	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   466: astore 36
    //   468: new 176	java/lang/StringBuilder
    //   471: dup
    //   472: aload 36
    //   474: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   477: ldc_w 966
    //   480: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: astore 37
    //   485: iload 35
    //   487: invokestatic 964	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   490: astore 38
    //   492: aload 37
    //   494: aload 38
    //   496: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: astore 39
    //   504: aload_2
    //   505: ldc_w 968
    //   508: aload 39
    //   510: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   513: astore 40
    //   515: aload_0
    //   516: invokestatic 474	com/mobclick/android/MobclickAgent:q	(Landroid/content/Context;)[Ljava/lang/String;
    //   519: astore 5
    //   521: aload 5
    //   523: iconst_0
    //   524: aaload
    //   525: astore 41
    //   527: aload_2
    //   528: ldc_w 970
    //   531: aload 41
    //   533: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   536: astore 42
    //   538: aload 5
    //   540: iconst_0
    //   541: aaload
    //   542: ldc_w 972
    //   545: invokevirtual 471	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   548: ifeq +20 -> 568
    //   551: aload 5
    //   553: iconst_1
    //   554: aaload
    //   555: astore 43
    //   557: aload_2
    //   558: ldc_w 974
    //   561: aload 43
    //   563: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   566: astore 44
    //   568: aload_3
    //   569: invokevirtual 977	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
    //   572: astore 45
    //   574: aload_2
    //   575: ldc_w 979
    //   578: aload 45
    //   580: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   583: astore 46
    //   585: aload_0
    //   586: invokestatic 982	com/mobclick/android/MobclickAgent:r	(Landroid/content/Context;)Landroid/location/Location;
    //   589: astore_3
    //   590: aload_3
    //   591: ifnull +327 -> 918
    //   594: aload_3
    //   595: invokevirtual 988	android/location/Location:getLatitude	()D
    //   598: invokestatic 991	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   601: astore 47
    //   603: aload_2
    //   604: ldc_w 993
    //   607: aload 47
    //   609: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   612: astore 48
    //   614: aload_3
    //   615: invokevirtual 996	android/location/Location:getLongitude	()D
    //   618: invokestatic 991	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   621: astore 49
    //   623: aload_2
    //   624: ldc_w 998
    //   627: aload 49
    //   629: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   632: astore 50
    //   634: invokestatic 1000	com/mobclick/android/m:a	()Ljava/lang/String;
    //   637: astore 51
    //   639: aload_2
    //   640: ldc_w 1002
    //   643: aload 51
    //   645: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   648: astore 52
    //   650: getstatic 59	com/mobclick/android/MobclickAgent:m	Ljava/lang/String;
    //   653: ldc 57
    //   655: invokevirtual 471	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   658: ifne +19 -> 677
    //   661: getstatic 59	com/mobclick/android/MobclickAgent:m	Ljava/lang/String;
    //   664: astore 53
    //   666: aload_2
    //   667: ldc_w 1004
    //   670: aload 53
    //   672: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   675: astore 54
    //   677: getstatic 61	com/mobclick/android/MobclickAgent:n	Ljava/lang/String;
    //   680: ldc 57
    //   682: invokevirtual 471	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   685: ifne +19 -> 704
    //   688: getstatic 61	com/mobclick/android/MobclickAgent:n	Ljava/lang/String;
    //   691: astore 55
    //   693: aload_2
    //   694: ldc_w 1006
    //   697: aload 55
    //   699: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   702: astore 56
    //   704: aload_1
    //   705: invokeinterface 140 1 0
    //   710: astore 57
    //   712: aload_2
    //   713: invokevirtual 235	org/json/JSONObject:toString	()Ljava/lang/String;
    //   716: astore 58
    //   718: aload 57
    //   720: ldc_w 762
    //   723: aload 58
    //   725: invokeinterface 193 3 0
    //   730: astore 59
    //   732: aload 57
    //   734: invokeinterface 159 1 0
    //   739: istore 60
    //   741: aload_2
    //   742: astore_3
    //   743: goto -703 -> 40
    //   746: astore 61
    //   748: aload_2
    //   749: ldc_w 880
    //   752: ldc_w 1008
    //   755: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   758: astore 62
    //   760: aload_2
    //   761: ldc_w 390
    //   764: ldc_w 1008
    //   767: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   770: astore 63
    //   772: goto -524 -> 248
    //   775: astore 64
    //   777: aconst_null
    //   778: astore_3
    //   779: goto -739 -> 40
    //   782: aload_2
    //   783: ldc_w 938
    //   786: bipush 8
    //   788: invokevirtual 358	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   791: astore 65
    //   793: goto -374 -> 419
    //   796: astore 66
    //   798: ldc 12
    //   800: ldc_w 1010
    //   803: aload 66
    //   805: invokestatic 229	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   808: istore 67
    //   810: aconst_null
    //   811: astore_3
    //   812: goto -772 -> 40
    //   815: aload_2
    //   816: ldc_w 938
    //   819: bipush 8
    //   821: invokevirtual 358	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   824: astore 68
    //   826: goto -407 -> 419
    //   829: aload_2
    //   830: ldc_w 917
    //   833: ldc_w 537
    //   836: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   839: astore 69
    //   841: aload_2
    //   842: ldc_w 920
    //   845: ldc_w 537
    //   848: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   851: astore 70
    //   853: aload_2
    //   854: ldc_w 938
    //   857: bipush 8
    //   859: invokevirtual 358	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   862: astore 71
    //   864: goto -445 -> 419
    //   867: astore 72
    //   869: aload_2
    //   870: ldc_w 968
    //   873: ldc_w 537
    //   876: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   879: astore 73
    //   881: goto -366 -> 515
    //   884: astore 74
    //   886: aload_2
    //   887: ldc_w 970
    //   890: ldc_w 537
    //   893: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   896: astore 75
    //   898: goto -330 -> 568
    //   901: astore 76
    //   903: aload_2
    //   904: ldc_w 979
    //   907: ldc_w 537
    //   910: invokevirtual 345	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   913: astore 77
    //   915: goto -330 -> 585
    //   918: aload_2
    //   919: ldc_w 993
    //   922: ldc2_w 1011
    //   925: invokevirtual 1015	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   928: astore 78
    //   930: aload_2
    //   931: ldc_w 998
    //   934: ldc2_w 1011
    //   937: invokevirtual 1015	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   940: astore 79
    //   942: goto -308 -> 634
    //   945: astore 80
    //   947: goto -881 -> 66
    //
    // Exception table:
    //   from	to	target	type
    //   190	248	746	android/content/pm/PackageManager$NameNotFoundException
    //   13	46	775	org/json/JSONException
    //   46	62	775	org/json/JSONException
    //   66	190	775	org/json/JSONException
    //   190	248	775	org/json/JSONException
    //   248	419	775	org/json/JSONException
    //   419	515	775	org/json/JSONException
    //   515	568	775	org/json/JSONException
    //   568	585	775	org/json/JSONException
    //   585	704	775	org/json/JSONException
    //   748	775	775	org/json/JSONException
    //   815	942	775	org/json/JSONException
    //   13	46	796	java/lang/SecurityException
    //   46	62	796	java/lang/SecurityException
    //   66	190	796	java/lang/SecurityException
    //   190	248	796	java/lang/SecurityException
    //   248	419	796	java/lang/SecurityException
    //   419	515	796	java/lang/SecurityException
    //   515	568	796	java/lang/SecurityException
    //   568	585	796	java/lang/SecurityException
    //   585	704	796	java/lang/SecurityException
    //   748	793	796	java/lang/SecurityException
    //   815	942	796	java/lang/SecurityException
    //   419	515	867	java/lang/Exception
    //   515	568	884	java/lang/Exception
    //   568	585	901	java/lang/Exception
    //   46	62	945	java/lang/Exception
  }

  private static SharedPreferences k(Context paramContext)
  {
    String str1 = paramContext.getPackageName();
    String str2 = "mobclick_agent_header_" + str1;
    return paramContext.getSharedPreferences(str2, 0);
  }

  private static SharedPreferences l(Context paramContext)
  {
    String str1 = paramContext.getPackageName();
    String str2 = "mobclick_agent_update_" + str1;
    return paramContext.getSharedPreferences(str2, 0);
  }

  private static SharedPreferences m(Context paramContext)
  {
    String str1 = paramContext.getPackageName();
    String str2 = "mobclick_agent_state_" + str1;
    return paramContext.getSharedPreferences(str2, 0);
  }

  private static String n(Context paramContext)
  {
    String str = paramContext.getPackageName();
    return "mobclick_agent_header_" + str;
  }

  private static String o(Context paramContext)
  {
    String str = paramContext.getPackageName();
    return "mobclick_agent_cached_" + str;
  }

  public static void onError(Context paramContext)
  {
    String str;
    try
    {
      str = b(paramContext);
      if ((str == null) || (str.length() == 0))
      {
        int i1 = Log.e("MobclickAgent", "unexpected empty appkey");
        return;
      }
      if (paramContext == null)
      {
        int i2 = Log.e("MobclickAgent", "unexpected null context");
        return;
      }
    }
    catch (Exception localException)
    {
      int i3 = Log.e("MobclickAgent", "Exception occurred in Mobclick.onError()");
      return;
    }
    new i(paramContext, str, 2).start();
  }

  public static void onEvent(Context paramContext, String paramString)
  {
    onEvent(paramContext, paramString, 1);
  }

  public static void onEvent(Context paramContext, String paramString, int paramInt)
  {
    onEvent(paramContext, paramString, paramString, paramInt);
  }

  public static void onEvent(Context paramContext, String paramString1, String paramString2)
  {
    onEvent(paramContext, paramString1, paramString2, 1);
  }

  public static void onEvent(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    String str1;
    try
    {
      str1 = b(paramContext);
      if ((str1 == null) || (str1.length() == 0))
      {
        int i1 = Log.e("MobclickAgent", "unexpected empty appkey");
        return;
      }
      if (paramContext == null)
      {
        int i2 = Log.e("MobclickAgent", "unexpected null context");
        return;
      }
    }
    catch (Exception localException)
    {
      int i3 = Log.e("MobclickAgent", "Exception occurred in Mobclick.onEvent(). ");
      return;
    }
    if ((paramString1 == null) || (paramString1 == ""))
    {
      int i4 = Log.e("MobclickAgent", "tag is null or empty");
      return;
    }
    if ((paramString2 == null) || (paramString2 == ""))
    {
      int i5 = Log.e("MobclickAgent", "label is null or empty");
      return;
    }
    if (paramInt <= 0)
    {
      int i6 = Log.e("MobclickAgent", "Illegal value of acc");
      return;
    }
    Context localContext = paramContext;
    String str2 = paramString1;
    String str3 = paramString2;
    int i7 = paramInt;
    new i(localContext, str1, str2, str3, i7, 3).start();
  }

  public static void onPause(Context paramContext)
  {
    if (paramContext == null);
    try
    {
      int i1 = Log.e("MobclickAgent", "unexpected null context");
      return;
      new i(paramContext, 0).start();
      return;
    }
    catch (Exception localException)
    {
      int i2 = Log.e("MobclickAgent", "Exception occurred in Mobclick.onRause(). ");
    }
  }

  public static void onResume(Context paramContext)
  {
    String str1 = b(paramContext);
    String str2 = c(paramContext);
    onResume(paramContext, str1, str2);
  }

  public static void onResume(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null);
    try
    {
      int i1 = Log.e("MobclickAgent", "unexpected null context");
      return;
      if ((paramString1 == null) || (paramString1.length() == 0))
      {
        int i2 = Log.e("MobclickAgent", "unexpected empty appkey");
        return;
      }
    }
    catch (Exception localException)
    {
      int i3 = Log.e("MobclickAgent", "Exception occurred in Mobclick.onResume(). ");
      return;
    }
    new i(paramContext, paramString1, paramString2, 1).start();
  }

  public static void openActivityDurationTrack(boolean paramBoolean)
  {
    o = paramBoolean;
  }

  public static void openFeedbackActivity(Context paramContext)
  {
    UmengFeedback.a(paramContext);
    UmengFeedback.a(a);
    Intent localIntent = new Intent(paramContext, UmengFeedback.class);
    paramContext.startActivity(localIntent);
  }

  private static boolean p(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    int i1;
    if (localConnectivityManager == null)
      i1 = 0;
    while (true)
    {
      return i1;
      NetworkInfo.State localState1 = localConnectivityManager.getNetworkInfo(0).getState();
      NetworkInfo.State localState2 = NetworkInfo.State.CONNECTED;
      if (localState1 == localState2)
      {
        i1 = 1;
        continue;
      }
      NetworkInfo.State localState3 = localConnectivityManager.getNetworkInfo(1).getState();
      NetworkInfo.State localState4 = NetworkInfo.State.CONNECTED;
      if (localState3 == localState4)
      {
        i1 = 1;
        continue;
      }
      i1 = 0;
    }
  }

  private static String[] q(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "Unknown";
    arrayOfString[1] = "Unknown";
    PackageManager localPackageManager = paramContext.getPackageManager();
    String str1 = paramContext.getPackageName();
    if (localPackageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", str1) != 0)
      arrayOfString[0] = "Unknown";
    while (true)
    {
      return arrayOfString;
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null)
      {
        arrayOfString[0] = "Unknown";
        continue;
      }
      NetworkInfo.State localState1 = paramContext.getNetworkInfo(1).getState();
      NetworkInfo.State localState2 = NetworkInfo.State.CONNECTED;
      if (localState1 == localState2)
      {
        arrayOfString[0] = "Wi-Fi";
        continue;
      }
      NetworkInfo localNetworkInfo = paramContext.getNetworkInfo(0);
      NetworkInfo.State localState3 = localNetworkInfo.getState();
      NetworkInfo.State localState4 = NetworkInfo.State.CONNECTED;
      if (localState3 != localState4)
        continue;
      arrayOfString[0] = "2G/3G";
      String str2 = localNetworkInfo.getSubtypeName();
      arrayOfString[1] = str2;
    }
  }

  private static Location r(Context paramContext)
  {
    return new f(paramContext).a();
  }

  public static void setFeedbackListener(UmengFeedbackListener paramUmengFeedbackListener)
  {
    q = paramUmengFeedbackListener;
  }

  public static void setOpenGLContext(GL10 paramGL10)
  {
    if (paramGL10 == null)
      return;
    String[] arrayOfString = m.a(paramGL10);
    if (arrayOfString.length != 2)
      return;
    m = arrayOfString[0];
    n = arrayOfString[1];
  }

  public static void setReportPolicy(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 5))
    {
      int i1 = Log.e("MobclickAgent", "Illegal value of report policy");
      return;
    }
    j = paramInt;
  }

  public static void setUpdateListener(UmengUpdateListener paramUmengUpdateListener)
  {
    p = paramUmengUpdateListener;
  }

  public static void setUpdateOnlyWifi(boolean paramBoolean)
  {
    r = paramBoolean;
  }

  public static void update(Context paramContext)
  {
    try
    {
      if ((r) && (!q(paramContext)[0].equals("Wi-Fi")))
      {
        UmengUpdateListener localUmengUpdateListener1 = p;
        int i1 = UpdateStatus.NoneWifi;
        localUmengUpdateListener1.onUpdateReturned(i1);
        return;
      }
      if (paramContext == null)
      {
        UmengUpdateListener localUmengUpdateListener2 = p;
        int i2 = UpdateStatus.No;
        localUmengUpdateListener2.onUpdateReturned(i2);
        int i3 = Log.e("MobclickAgent", "unexpected null context");
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("Exception occurred in Mobclick.update(). ");
      String str1 = localException.getMessage();
      String str2 = str1;
      int i4 = Log.e("MobclickAgent", str2);
      return;
    }
    MobclickAgent localMobclickAgent = a;
    String str3 = b(paramContext);
    localMobclickAgent.a(paramContext, str3);
  }

  public void onFeedbackReturned(JSONObject paramJSONObject)
  {
    try
    {
      if (this.k == null)
        return;
      MobclickAgent localMobclickAgent = a;
      Context localContext = this.k;
      localMobclickAgent.a(localContext, paramJSONObject);
      return;
    }
    catch (Exception localException)
    {
      int i1 = Log.e("MobclickAgent", "Exception occurred while sending feedback.");
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mobclick.android.MobclickAgent
 * JD-Core Version:    0.6.0
 */