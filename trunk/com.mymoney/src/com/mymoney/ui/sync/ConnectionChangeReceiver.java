package com.mymoney.ui.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import gj;

public class ConnectionChangeReceiver extends BroadcastReceiver
{
  public static String a = ConnectionChangeReceiver.class.getSimpleName();

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    NetworkInfo localNetworkInfo1 = localConnectivityManager.getActiveNetworkInfo();
    NetworkInfo localNetworkInfo2 = localConnectivityManager.getNetworkInfo(0);
    NetworkInfo localNetworkInfo3 = localConnectivityManager.getNetworkInfo(1);
    String str1 = a;
    String str2 = "ConnectionChangeReceiver,activeNetInfo is " + localNetworkInfo1 + ",mobNetInfo is " + localNetworkInfo2;
    gj.a(str1, str2);
    if (localNetworkInfo1 == null)
      return;
    String str3 = a;
    String str4 = localNetworkInfo1.toString();
    gj.a(str3, str4);
    String str5 = a;
    StringBuilder localStringBuilder1 = new StringBuilder().append("network is isConnected:");
    boolean bool1 = localNetworkInfo1.isConnected();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(bool1).append(",isConnectedOrConnecting:");
    boolean bool2 = localNetworkInfo1.isConnectedOrConnecting();
    String str6 = bool2;
    gj.a(str5, str6);
    StringBuilder localStringBuilder3 = new StringBuilder().append("network is isConnected:");
    boolean bool3 = localNetworkInfo1.isConnected();
    StringBuilder localStringBuilder4 = localStringBuilder3.append(bool3).append(",isConnectedOrConnecting:");
    boolean bool4 = localNetworkInfo1.isConnectedOrConnecting();
    String str7 = bool4;
    gj.a(paramContext, str7);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.sync.ConnectionChangeReceiver
 * JD-Core Version:    0.6.0
 */