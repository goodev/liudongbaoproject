import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import com.mymoney.ui.main.BackgroundService;
import com.mymoney.ui.main.MainActivity;

public class lb extends AsyncTask
{
  public lb(BackgroundService paramBackgroundService)
  {
  }

  public void a()
  {
    try
    {
      fm localfm = fm.a();
      Context localContext = BackgroundService.b(this.a);
      BackgroundService.g = localfm.a(localContext);
      String str1 = gu.n;
      long l = BackgroundService.a(this.a);
      gu.a(str1, l);
      return;
    }
    catch (Exception localException)
    {
      String str2 = BackgroundService.a;
      StringBuilder localStringBuilder = new StringBuilder().append("aotu service error occur,exception is ");
      Throwable localThrowable = localException.getCause();
      String str3 = localThrowable;
      gj.a(str2, str3);
    }
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    a();
    return null;
  }

  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    if (BackgroundService.g == null)
      return;
    try
    {
      PackageManager localPackageManager = BackgroundService.b(this.a).getPackageManager();
      String str1 = BackgroundService.b(this.a).getPackageName();
      int i = localPackageManager.getPackageInfo(str1, 0).versionCode;
      if (BackgroundService.g.a() <= i)
        return;
      Context localContext = BackgroundService.b(this.a);
      String str2 = MainActivity.c;
      Intent localIntent = new Intent(str2);
      localContext.sendBroadcast(localIntent);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     lb
 * JD-Core Version:    0.6.0
 */