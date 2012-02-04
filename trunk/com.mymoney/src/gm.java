import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

public class gm
{
  public static int a = 30000;
  private static final DefaultHttpClient b;

  static
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpVersion localHttpVersion = HttpVersion.HTTP_1_1;
    HttpProtocolParams.setVersion(localBasicHttpParams, localHttpVersion);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, 0);
    int i = a;
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, i);
    int j = a;
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, j);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpClientParams.setRedirecting(localBasicHttpParams, 0);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, "android/1.1");
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    PlainSocketFactory localPlainSocketFactory = PlainSocketFactory.getSocketFactory();
    Scheme localScheme1 = new Scheme("http", localPlainSocketFactory, 80);
    Scheme localScheme2 = localSchemeRegistry.register(localScheme1);
    SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
    Scheme localScheme3 = new Scheme("https", localSSLSocketFactory, 443);
    Scheme localScheme4 = localSchemeRegistry.register(localScheme3);
    ThreadSafeClientConnManager localThreadSafeClientConnManager = new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry);
    b = new DefaultHttpClient(localThreadSafeClientConnManager, localBasicHttpParams);
  }

  public static HttpResponse a(HttpGet paramHttpGet)
  {
    return b.execute(paramHttpGet);
  }

  public static HttpResponse a(HttpPost paramHttpPost)
  {
    return b.execute(paramHttpPost);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gm
 * JD-Core Version:    0.6.0
 */