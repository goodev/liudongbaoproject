import android.content.Context;
import com.mymoney.core.application.ApplicationContext;
import java.io.File;

public class fp
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;

  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("/data/data/");
    String str1 = ApplicationContext.a.getPackageName();
    a = str1;
    StringBuilder localStringBuilder2 = new StringBuilder();
    String str2 = a;
    b = str2 + "/databases/mymoney.sqlite";
    StringBuilder localStringBuilder3 = new StringBuilder();
    String str3 = a;
    c = str3 + "/databases/mymoney.kbs";
    StringBuilder localStringBuilder4 = new StringBuilder();
    String str4 = a;
    d = str4 + "/databases/servermymoney.kbs";
    StringBuilder localStringBuilder5 = new StringBuilder();
    String str5 = a;
    e = str5 + "/databases/servermymoney.sqlite";
  }

  public static void a()
  {
    ApplicationContext.b.close();
    boolean bool = ApplicationContext.b.b();
    String str1 = e;
    File localFile1 = new File(str1);
    String str2 = b;
    File localFile2 = new File(str2);
    gl.a(localFile1, localFile2);
  }

  public static void b()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = a;
    String str2 = str1 + "/databases/mymoney.sqlite";
    StringBuilder localStringBuilder2 = new StringBuilder();
    String str3 = a;
    String str4 = str3 + "/databases/mymoneytemp.sqlite";
    try
    {
      File localFile1 = new File(str2);
      File localFile2 = new File(str4);
      gl.a(localFile1, localFile2);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void c()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = a;
    String str2 = str1 + "/databases/mymoneytemp.sqlite";
    StringBuilder localStringBuilder2 = new StringBuilder();
    String str3 = a;
    String str4 = str3 + "/databases/mymoney.sqlite";
    ApplicationContext.b.close();
    boolean bool = ApplicationContext.b.b();
    try
    {
      File localFile1 = new File(str2);
      File localFile2 = new File(str4);
      gl.a(localFile1, localFile2);
      return;
    }
    catch (Exception localException)
    {
    }
    throw new ei(localException);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fp
 * JD-Core Version:    0.6.0
 */