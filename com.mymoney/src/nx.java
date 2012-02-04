import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mymoney.ui.setting.HelpActivity;

public class nx extends WebViewClient
{
  public nx(HelpActivity paramHelpActivity)
  {
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    paramWebView.loadUrl(paramString);
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     nx
 * JD-Core Version:    0.6.0
 */