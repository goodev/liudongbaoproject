import android.os.Environment;
import java.io.File;
import java.util.Date;

public class el
{
  public static String a;
  public static String b;
  public static String c;

  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    File localFile = Environment.getExternalStorageDirectory();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(localFile).append("/");
    String str = ep.c;
    a = str + "/backup/";
    b = ".kbf";
    c = "/";
  }

  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("backup_");
    long l = gt.a();
    String str = gi.b(new Date(l), "yyyy-MM-dd-HH");
    return str;
  }

  public static String a(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = a;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(paramString);
    String str2 = b;
    return str2;
  }

  public static File b(String paramString)
  {
    String str = a(paramString);
    return new File(str);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     el
 * JD-Core Version:    0.6.0
 */