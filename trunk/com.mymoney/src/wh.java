import java.io.File;
import java.io.Serializable;

public class wh
  implements Serializable, wg
{
  private final wg a;

  public wh(wg paramwg)
  {
    if (paramwg == null)
      throw new IllegalArgumentException("The filter must not be null");
    this.a = paramwg;
  }

  public boolean accept(File paramFile)
  {
    if (!this.a.accept(paramFile));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean accept(File paramFile, String paramString)
  {
    if (!this.a.accept(paramFile, paramString));
    for (int i = 1; ; i = 0)
      return i;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = super.toString();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("(");
    String str2 = this.a.toString();
    return str2 + ")";
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wh
 * JD-Core Version:    0.6.0
 */