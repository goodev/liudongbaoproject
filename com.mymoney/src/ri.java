import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mymoney.ui.sync.BuyFlowActivity;

public class ri extends WebViewClient
{
  public ri(BuyFlowActivity paramBuyFlowActivity)
  {
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    hb.b(BuyFlowActivity.a(this.a), "加载开通同步服务页面错误,请检查你的网络是否正常.");
    this.a.finish();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ri
 * JD-Core Version:    0.6.0
 */