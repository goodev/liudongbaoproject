import android.content.Context;
import android.content.res.Resources;
import com.mymoney.core.application.ApplicationContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class gg
{
  static Properties a;
  private static gg b;
  private static Object c = new Object();
  private static String d = "syncServerUrl";
  private static String e = "partnerCode";
  private static String f = "productName";
  private static String g = "productNameForDisplay";
  private static String h = "productVersion";
  private static String i = "syncProtocolVersion";
  private static String j = "debug";
  private static String k = "apikey";

  static
  {
    a = new Properties();
  }

  private gg()
  {
  }

  private gg(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt);
  }

  public static gg a()
  {
    if (b == null);
    synchronized (c)
    {
      Context localContext = ApplicationContext.a;
      b = new gg(localContext, 2131099648);
      return b;
    }
  }

  static void a(Context paramContext, int paramInt)
  {
    if (paramContext == null)
      return;
    a = new Properties();
    InputStream localInputStream = paramContext.getResources().openRawResource(paramInt);
    try
    {
      a.load(localInputStream);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public String b()
  {
    Properties localProperties = a;
    String str = d;
    return localProperties.getProperty(str);
  }

  public String c()
  {
    Properties localProperties = a;
    String str = e;
    return localProperties.getProperty(str);
  }

  public String d()
  {
    Properties localProperties = a;
    String str = f;
    return localProperties.getProperty(str);
  }

  public String e()
  {
    Properties localProperties = a;
    String str = g;
    return localProperties.getProperty(str);
  }

  public boolean f()
  {
    Properties localProperties = a;
    String str = j;
    return Boolean.valueOf(localProperties.getProperty(str)).booleanValue();
  }

  public String g()
  {
    Properties localProperties = a;
    String str = k;
    return localProperties.getProperty(str);
  }

  public String h()
  {
    Properties localProperties = a;
    String str = i;
    return localProperties.getProperty(str);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gg
 * JD-Core Version:    0.6.0
 */