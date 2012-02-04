import android.os.AsyncTask;
import com.mymoney.ui.main.BackgroundService;

public class ld extends AsyncTask
{
  public ld(BackgroundService paramBackgroundService)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    try
    {
      this.a.a();
      return null;
    }
    catch (Exception localException)
    {
      while (true)
      {
        String str1 = BackgroundService.a;
        StringBuilder localStringBuilder = new StringBuilder().append("signIn exception ,msg is");
        String str2 = localException.getMessage();
        String str3 = str2;
        gj.a(str1, str3);
      }
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ld
 * JD-Core Version:    0.6.0
 */