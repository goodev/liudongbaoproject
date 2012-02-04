import android.content.Context;
import com.mymoney.core.application.ApplicationContext;

public class gy
{
  public static String a;
  private static String b = "SwitchAccountUtil";

  static
  {
    a = dh.b;
  }

  public static final void a(String paramString)
  {
    String str1 = b;
    String str2 = "switch to " + paramString;
    gj.a(str1, str2);
    ApplicationContext.b.close();
    ApplicationContext.b = null;
    dh.a = a;
    Context localContext = ApplicationContext.a;
    ApplicationContext.b = new dh(localContext);
    ar.b = ApplicationContext.b;
    try
    {
      ai.a().i().b();
      boolean bool = a();
      ApplicationContext.g = g.a().h().a();
      String str3 = b;
      String str4 = "switch to " + paramString + "finish";
      gj.a(str3, str4);
      return;
    }
    catch (ec localec)
    {
      while (true)
        localec.printStackTrace();
    }
  }

  private static final boolean a()
  {
    ApplicationContext.c = g.a().f().a();
    ApplicationContext.d = ApplicationContext.c.a();
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gy
 * JD-Core Version:    0.6.0
 */