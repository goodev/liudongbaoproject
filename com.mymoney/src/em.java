import android.os.Environment;
import java.io.File;

public class em
{
  public static String a;
  public static String b;

  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    File localFile1 = Environment.getExternalStorageDirectory();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(localFile1).append("/");
    String str1 = ep.c;
    a = str1 + "/debug/";
    StringBuilder localStringBuilder3 = new StringBuilder();
    File localFile2 = Environment.getExternalStorageDirectory();
    StringBuilder localStringBuilder4 = localStringBuilder3.append(localFile2).append("/");
    String str2 = ep.c;
    b = str2 + "/autosync/";
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     em
 * JD-Core Version:    0.6.0
 */