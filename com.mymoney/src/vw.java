import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class vw
{
  public static vv a(String paramString, List paramList)
  {
    vv localvv = new vv(paramString);
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Map)localIterator1.next()).entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator2.next();
        String str = (String)localEntry.getKey();
        double d = ((Double)localEntry.getValue()).doubleValue();
        localvv.a(str, d);
      }
    }
    return localvv;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vw
 * JD-Core Version:    0.6.0
 */