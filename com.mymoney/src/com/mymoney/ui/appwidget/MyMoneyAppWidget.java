package com.mymoney.ui.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.RemoteViews;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;
import com.mymoney.ui.repair.RepairModeActivity;
import com.mymoney.ui.splash.SplashScreenActivity;
import com.mymoney.ui.transfer.TransferActivity;
import gu;
import hb;
import ka;

public class MyMoneyAppWidget extends AppWidgetProvider
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  private ka d;
  private Context e;

  private void a()
  {
    ka localka = new ka(this);
    this.d = localka;
    AsyncTask localAsyncTask = this.d.execute(null);
  }

  private void a(Context paramContext)
  {
    hb.a(paramContext, "抱歉,软件发生未知错误,自动进入特别维护模式.");
    Intent localIntent = new Intent(paramContext, RepairModeActivity.class);
    paramContext.startActivity(localIntent);
  }

  private Intent b(Context paramContext)
  {
    return new Intent(paramContext, SplashScreenActivity.class);
  }

  private Intent c(Context paramContext)
  {
    Intent localIntent1;
    if (gu.h())
    {
      localIntent1 = new Intent(paramContext, AddOrEditTransNewActivity.class);
      Intent localIntent2 = localIntent1.putExtra("state", 1);
      Intent localIntent3 = localIntent1.putExtra("transType", 1);
      Intent localIntent4 = localIntent1.putExtra("isFromSecurityLogin", 1);
      Intent localIntent5 = localIntent1.putExtra("com.mymoney.requestTypeFromAppwidget", "income");
    }
    while (true)
    {
      Intent localIntent6 = localIntent1.setAction("addIncome");
      return localIntent1;
      localIntent1 = new Intent(paramContext, AddOrEditTransactionActivity.class);
      Intent localIntent7 = localIntent1.putExtra("state", 2);
      Intent localIntent8 = localIntent1.putExtra("transType", 1);
      Intent localIntent9 = localIntent1.putExtra("isFromSecurityLogin", 1);
      Intent localIntent10 = localIntent1.putExtra("com.mymoney.requestTypeFromAppwidget", "income");
    }
  }

  private Intent d(Context paramContext)
  {
    Intent localIntent1;
    if (gu.h())
    {
      localIntent1 = new Intent(paramContext, AddOrEditTransNewActivity.class);
      Intent localIntent2 = localIntent1.putExtra("state", 1);
      Intent localIntent3 = localIntent1.putExtra("transType", 0);
      Intent localIntent4 = localIntent1.putExtra("isFromSecurityLogin", 1);
      Intent localIntent5 = localIntent1.putExtra("com.mymoney.requestTypeFromAppwidget", "payout");
    }
    while (true)
    {
      Intent localIntent6 = localIntent1.setAction("addPayout");
      return localIntent1;
      localIntent1 = new Intent(paramContext, AddOrEditTransactionActivity.class);
      Intent localIntent7 = localIntent1.putExtra("state", 2);
      Intent localIntent8 = localIntent1.putExtra("transType", 0);
      Intent localIntent9 = localIntent1.putExtra("isFromSecurityLogin", 1);
      Intent localIntent10 = localIntent1.putExtra("com.mymoney.requestTypeFromAppwidget", "payout");
    }
  }

  private Intent e(Context paramContext)
  {
    return new Intent(paramContext, TransferActivity.class);
  }

  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    this.e = paramContext;
    String str = paramContext.getPackageName();
    RemoteViews localRemoteViews = new RemoteViews(str, 2130903067);
    Intent localIntent1 = b(paramContext);
    PendingIntent localPendingIntent1 = PendingIntent.getActivity(paramContext, 0, localIntent1, 0);
    Intent localIntent2 = d(paramContext);
    PendingIntent localPendingIntent2 = PendingIntent.getActivity(paramContext, 0, localIntent2, 0);
    Intent localIntent3 = c(paramContext);
    PendingIntent localPendingIntent3 = PendingIntent.getActivity(paramContext, 0, localIntent3, 0);
    Intent localIntent4 = e(paramContext);
    PendingIntent localPendingIntent4 = PendingIntent.getActivity(paramContext, 0, localIntent4, 0);
    localRemoteViews.setOnClickPendingIntent(2131230852, localPendingIntent1);
    localRemoteViews.setOnClickPendingIntent(2131230853, localPendingIntent2);
    localRemoteViews.setOnClickPendingIntent(2131230854, localPendingIntent3);
    localRemoteViews.setOnClickPendingIntent(2131230855, localPendingIntent4);
    ComponentName localComponentName = new ComponentName(paramContext, MyMoneyAppWidget.class);
    AppWidgetManager.getInstance(paramContext).updateAppWidget(localComponentName, localRemoteViews);
    a();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.appwidget.MyMoneyAppWidget
 * JD-Core Version:    0.6.0
 */