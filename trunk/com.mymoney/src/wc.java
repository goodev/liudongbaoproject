import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wc
  implements Serializable, wg
{
  private List a;

  public wc(wg paramwg1, wg paramwg2)
  {
    if ((paramwg1 == null) || (paramwg2 == null))
      throw new IllegalArgumentException("The filters must not be null");
    ArrayList localArrayList = new ArrayList();
    this.a = localArrayList;
    a(paramwg1);
    a(paramwg2);
  }

  public void a(wg paramwg)
  {
    boolean bool = this.a.add(paramwg);
  }

  public boolean accept(File paramFile)
  {
    int i;
    if (this.a.size() == 0)
      i = 0;
    while (true)
    {
      return i;
      Iterator localIterator = this.a.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          if (((wg)localIterator.next()).accept(paramFile))
            continue;
          i = 0;
          break;
        }
      i = 1;
    }
  }

  public boolean accept(File paramFile, String paramString)
  {
    int i;
    if (this.a.size() == 0)
      i = 0;
    while (true)
    {
      return i;
      Iterator localIterator = this.a.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          if (((wg)localIterator.next()).accept(paramFile, paramString))
            continue;
          i = 0;
          break;
        }
      i = 1;
    }
  }

  public String toString()
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    String str1 = super.toString();
    StringBuffer localStringBuffer2 = localStringBuffer1.append(str1);
    StringBuffer localStringBuffer3 = localStringBuffer1.append("(");
    if (this.a != null)
    {
      int i = 0;
      int j = this.a.size();
      if (i < j)
      {
        if (i > 0)
          StringBuffer localStringBuffer4 = localStringBuffer1.append(",");
        Object localObject = this.a.get(i);
        if (localObject == null);
        for (String str2 = "null"; ; str2 = localObject.toString())
        {
          StringBuffer localStringBuffer5 = localStringBuffer1.append(str2);
          i += 1;
          break;
        }
      }
    }
    StringBuffer localStringBuffer6 = localStringBuffer1.append(")");
    return localStringBuffer1.toString();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wc
 * JD-Core Version:    0.6.0
 */