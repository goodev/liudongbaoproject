import android.os.AsyncTask;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.mymoney.ui.sync.BuyFlowActivity;

public class rj extends AsyncTask
{
  public rj(BuyFlowActivity paramBuyFlowActivity)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    WebView localWebView = BuyFlowActivity.b(this.a);
    String str = gh.e;
    localWebView.loadUrl(str);
    return null;
  }

  protected void onPostExecute(Object paramObject)
  {
    BuyFlowActivity.c(this.a).setVisibility(8);
    super.onPostExecute(paramObject);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     rj
 * JD-Core Version:    0.6.0
 */