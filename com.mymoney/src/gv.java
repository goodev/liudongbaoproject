import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;

public class gv
{
  public static void a(Context paramContext, int paramInt1, int paramInt2, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, PendingIntent paramPendingIntent, int paramInt3)
  {
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    long l = System.currentTimeMillis();
    Notification localNotification = new Notification(paramInt2, paramCharSequence1, l);
    localNotification.flags = paramInt3;
    localNotification.setLatestEventInfo(paramContext, paramCharSequence2, paramCharSequence3, paramPendingIntent);
    localNotificationManager.notify(paramInt1, localNotification);
  }

  public static void a(Context paramContext, int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, PendingIntent paramPendingIntent)
  {
    Context localContext = paramContext;
    int i = paramInt;
    CharSequence localCharSequence1 = paramCharSequence1;
    CharSequence localCharSequence2 = paramCharSequence2;
    PendingIntent localPendingIntent = paramPendingIntent;
    a(localContext, i, localCharSequence1, localCharSequence2, localPendingIntent, 32);
  }

  public static void a(Context paramContext, int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, PendingIntent paramPendingIntent, int paramInt2)
  {
    Context localContext = paramContext;
    int i = paramInt1;
    CharSequence localCharSequence1 = paramCharSequence1;
    CharSequence localCharSequence2 = paramCharSequence1;
    CharSequence localCharSequence3 = paramCharSequence2;
    PendingIntent localPendingIntent = paramPendingIntent;
    int j = paramInt2;
    a(localContext, i, 2130837739, localCharSequence1, localCharSequence2, localCharSequence3, localPendingIntent, j);
  }

  public static void b(Context paramContext, int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, PendingIntent paramPendingIntent)
  {
    Context localContext = paramContext;
    int i = paramInt;
    CharSequence localCharSequence1 = paramCharSequence1;
    CharSequence localCharSequence2 = paramCharSequence1;
    CharSequence localCharSequence3 = paramCharSequence2;
    PendingIntent localPendingIntent = paramPendingIntent;
    a(localContext, i, 2130837739, localCharSequence1, localCharSequence2, localCharSequence3, localPendingIntent, 16);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gv
 * JD-Core Version:    0.6.0
 */