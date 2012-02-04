import java.io.File;
import java.io.Serializable;

public class wd
  implements Serializable, wg
{
  public static final wg a = new wd();
  public static final wg b = a;

  public boolean accept(File paramFile)
  {
    return paramFile.isDirectory();
  }

  public boolean accept(File paramFile, String paramString)
  {
    File localFile = new File(paramFile, paramString);
    return accept(localFile);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wd
 * JD-Core Version:    0.6.0
 */