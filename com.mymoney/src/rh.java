import android.os.AsyncTask;
import com.mymoney.ui.splash.SplashScreenActivity;

public class rh extends AsyncTask
{
  int a;

  public rh(SplashScreenActivity paramSplashScreenActivity)
  {
    int i = SplashScreenActivity.b;
    this.a = i;
  }

  protected Integer a(String[] paramArrayOfString)
  {
    try
    {
      g.a().h().h();
      return Integer.valueOf(this.a);
    }
    catch (ec localec)
    {
      while (true)
      {
        localec.printStackTrace();
        int i = SplashScreenActivity.c;
        this.a = i;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        int j = SplashScreenActivity.d;
        this.a = j;
      }
    }
  }

  protected void a(Integer paramInteger)
  {
    int i = SplashScreenActivity.b;
    int j = paramInteger.intValue();
    if (i == j)
      SplashScreenActivity.b(this.b);
    while (true)
    {
      super.onPostExecute(paramInteger);
      return;
      int k = SplashScreenActivity.c;
      int m = paramInteger.intValue();
      if (k == m)
      {
        hb.a(SplashScreenActivity.c(this.b), "程序版本过低,请升级你的程序到最新版本.");
        this.b.finish();
        continue;
      }
      int n = SplashScreenActivity.d;
      int i1 = paramInteger.intValue();
      if (n != i1)
        continue;
      SplashScreenActivity.d(this.b);
    }
  }

  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     rh
 * JD-Core Version:    0.6.0
 */