package com.mymoney.ui.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import gj;

public class NetworkHelper
{
  public static String a = NetworkHelper.class.getSimpleName();

  public static boolean a(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null)
      gj.a(a, "activeNetInfo is null ");
    boolean bool1;
    for (int i = 0; ; bool1 = localNetworkInfo.isAvailable())
    {
      return i;
      String str1 = a;
      String str2 = localNetworkInfo.toString();
      gj.a(str1, str2);
      String str3 = a;
      StringBuilder localStringBuilder1 = new StringBuilder().append("network is isConnected:");
      boolean bool2 = localNetworkInfo.isConnected();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(bool2).append(",isConnectedOrConnecting:");
      boolean bool3 = localNetworkInfo.isConnectedOrConnecting();
      String str4 = bool3;
      gj.a(str3, str4);
      StringBuilder localStringBuilder3 = new StringBuilder().append("network is isConnected:");
      boolean bool4 = localNetworkInfo.isConnected();
      StringBuilder localStringBuilder4 = localStringBuilder3.append(bool4).append(",isConnectedOrConnecting:");
      boolean bool5 = localNetworkInfo.isConnectedOrConnecting();
      String str5 = bool5;
      gj.a(paramContext, str5);
    }
  }

  public static boolean b(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    int k;
    if (localNetworkInfo != null)
    {
      int i = localNetworkInfo.getType();
      int j = localNetworkInfo.getSubtype();
      if (i == 1)
        k = 1;
    }
    while (true)
    {
      return k;
      k = 0;
      continue;
      k = 0;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.helper.NetworkHelper
 * JD-Core Version:    0.6.0
 */