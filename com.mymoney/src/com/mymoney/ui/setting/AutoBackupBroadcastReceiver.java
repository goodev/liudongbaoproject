package com.mymoney.ui.setting;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import gj;

public class AutoBackupBroadcastReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    gj.a("AutoBackupBroadcastReceiver", "AutoBackupBroadcastReceiver");
    Intent localIntent = new Intent(paramContext, AutoBackupService.class);
    ComponentName localComponentName = paramContext.startService(localIntent);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.AutoBackupBroadcastReceiver
 * JD-Core Version:    0.6.0
 */