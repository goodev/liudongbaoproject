import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mymoney.ui.setting.HelpActivity;

public class nw extends WebViewClient
{
  public nw(HelpActivity paramHelpActivity)
  {
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    hb.b(HelpActivity.a(this.a), "加载帮助页面错误,请检查你的网络是否正常.");
    this.a.finish();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     nw
 * JD-Core Version:    0.6.0
 */