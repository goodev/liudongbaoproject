package com.mymoney.ui.main.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import c;
import com.flurry.android.FlurryAgent;
import gi;
import gj;
import gu;

public class BootCompletedReceiver extends BroadcastReceiver
{
  private AlarmManager a;
  private PendingIntent b;
  private PendingIntent c;

  private void a()
  {
    if (!gu.s())
      return;
    long l1 = gi.a(gu.t());
    AlarmManager localAlarmManager = this.a;
    long l2 = gu.u() * 86400000L;
    PendingIntent localPendingIntent = this.b;
    localAlarmManager.setRepeating(0, l1, l2, localPendingIntent);
  }

  private void b()
  {
    long l = gi.a("20:00");
    AlarmManager localAlarmManager = this.a;
    PendingIntent localPendingIntent = this.c;
    localAlarmManager.setRepeating(0, l, 172800000L, localPendingIntent);
    gu.l(1);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = c.a;
    FlurryAgent.onStartSession(paramContext, str1);
    FlurryAgent.onPageView();
    if (paramIntent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Action:");
      String str2 = paramIntent.getAction();
      String str3 = str2;
      gj.a("BootCompletedReceiver", str3);
      AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
      this.a = localAlarmManager;
      Intent localIntent1 = new Intent("com.mymoney.ui.setting.Action.AUTO_BACKUP");
      PendingIntent localPendingIntent1 = PendingIntent.getBroadcast(paramContext, 0, localIntent1, 0);
      this.b = localPendingIntent1;
      Intent localIntent2 = new Intent("com.mymoney.ui.main.ADD_TRANS_REMIND");
      PendingIntent localPendingIntent2 = PendingIntent.getBroadcast(paramContext, 0, localIntent2, 0);
      this.c = localPendingIntent2;
      a();
      b();
    }
    FlurryAgent.onEndSession(paramContext);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.main.receiver.BootCompletedReceiver
 * JD-Core Version:    0.6.0
 */