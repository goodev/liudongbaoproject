import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.mymoney.ui.helper.NetworkHelper;
import com.mymoney.ui.main.BackgroundService;
import com.mymoney.ui.main.MainActivity;

public class lc extends AsyncTask
{
  public lc(BackgroundService paramBackgroundService)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    try
    {
      long l1 = gu.c(gu.r);
      BackgroundService localBackgroundService1 = this.a;
      long l2 = System.currentTimeMillis();
      long l3 = BackgroundService.a(localBackgroundService1, l2);
      if (l1 == 0L)
        l1 = BackgroundService.a(this.a);
      long l4 = BackgroundService.a(this.a) - l1;
      long l5 = BackgroundService.d;
      if (l4 > l5)
      {
        if (gu.s())
          break label256;
        Context localContext1 = BackgroundService.b(this.a);
        String str1 = MainActivity.e;
        Intent localIntent1 = new Intent(str1);
        localContext1.sendBroadcast(localIntent1);
        gj.a(BackgroundService.a, " mContext.sendBroadcast(new Intent(MainActivity.ACTION_BACKUP_REMIND))");
      }
      while (true)
      {
        l1 = gu.c(gu.s);
        BackgroundService localBackgroundService2 = this.a;
        long l6 = gt.f();
        long l7 = BackgroundService.a(localBackgroundService2, l6);
        hn localhn = g.a().h().g();
        if ((!TextUtils.isEmpty(localhn.a())) && (!TextUtils.isEmpty(localhn.b())))
        {
          long l8 = BackgroundService.a(this.a) - l1;
          long l9 = BackgroundService.e;
          if ((l8 > l9) && (NetworkHelper.a(BackgroundService.b(this.a))))
          {
            Context localContext2 = BackgroundService.b(this.a);
            String str2 = MainActivity.d;
            Intent localIntent2 = new Intent(str2);
            localContext2.sendBroadcast(localIntent2);
            gj.a(BackgroundService.a, "  mContext.sendBroadcast(new Intent(MainActivity.ACTION_SYNC_REMIND))");
          }
        }
        return null;
        label256: gj.a(BackgroundService.a, " aotu backup is on,cancel backup remind");
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        String str3 = BackgroundService.a;
        StringBuilder localStringBuilder = new StringBuilder().append("RemindTask exception ,msg is");
        String str4 = localException.getMessage();
        String str5 = str4;
        gj.a(str3, str5);
      }
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     lc
 * JD-Core Version:    0.6.0
 */