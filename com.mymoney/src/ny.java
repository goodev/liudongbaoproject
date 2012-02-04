import android.os.AsyncTask;
import android.webkit.WebView;
import com.mymoney.ui.setting.HelpActivity;

public class ny extends AsyncTask
{
  public ny(HelpActivity paramHelpActivity)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    HelpActivity.b(this.a).loadUrl("http://www.feidee.com/licai/mobile/help.php");
    return null;
  }

  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ny
 * JD-Core Version:    0.6.0
 */