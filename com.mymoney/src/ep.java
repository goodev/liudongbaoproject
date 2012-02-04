import android.os.Environment;
import com.mymoney.core.application.ApplicationContext;
import java.io.File;

public class ep
{
  public static String a;
  public static String b;
  public static String c;

  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    File localFile = Environment.getExternalStorageDirectory();
    a = localFile + "";
    b = "/sdcard";
    c = ".mymoney";
    if (gu.c().indexOf("vip") != -1)
    {
      c = ".mymoneyvip";
      return;
    }
    if (!gt.c(ApplicationContext.a))
      return;
    c = ".mymoneylephonevip";
  }

  public static boolean a()
  {
    String str = Environment.getExternalStorageState();
    if ("mounted".equalsIgnoreCase(str));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ep
 * JD-Core Version:    0.6.0
 */