import android.content.Context;
import android.os.AsyncTask;
import com.mymoney.ui.appwidget.MyMoneyAppWidget;

public class ka extends AsyncTask
{
  int a;

  public ka(MyMoneyAppWidget paramMyMoneyAppWidget)
  {
    int i = MyMoneyAppWidget.a;
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
        int i = MyMoneyAppWidget.b;
        this.a = i;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        int j = MyMoneyAppWidget.c;
        this.a = j;
      }
    }
  }

  protected void a(Integer paramInteger)
  {
    int i = MyMoneyAppWidget.b;
    int j = paramInteger.intValue();
    if (i == j)
      hb.a(MyMoneyAppWidget.a(this.b), "随手记软件版本过低,请升级你的软件到最新版本.");
    while (true)
    {
      gj.a("MyMoneyAppWidget", "UpgradeDatabaseTask#onPostExecute()");
      super.onPostExecute(paramInteger);
      return;
      int k = MyMoneyAppWidget.c;
      int m = paramInteger.intValue();
      if (k != m)
        continue;
      MyMoneyAppWidget localMyMoneyAppWidget = this.b;
      Context localContext = MyMoneyAppWidget.a(this.b);
      MyMoneyAppWidget.a(localMyMoneyAppWidget, localContext);
    }
  }

  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ka
 * JD-Core Version:    0.6.0
 */