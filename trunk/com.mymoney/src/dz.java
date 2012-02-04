import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class dz
{
  private static String a = "EventsObservable";
  private static dz b = new dz();
  private static Object c = new Object();
  private Map d;

  public dz()
  {
    HashMap localHashMap = new HashMap();
    this.d = localHashMap;
  }

  public static dz a()
  {
    return b;
  }

  public void a(String paramString)
  {
    ArrayList localArrayList = (ArrayList)this.d.get(paramString);
    if (localArrayList == null)
      return;
    String str1 = a;
    String str2 = "event observer is be call,eventType is " + paramString;
    gj.a(str1, str2);
    Iterator localIterator = localArrayList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((dx)localIterator.next()).b();
    }
  }

  /** @deprecated */
  public void a(String paramString, dx paramdx)
  {
    monitorenter;
    try
    {
      ArrayList localArrayList = (ArrayList)this.d.get(paramString);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        Object localObject1 = this.d.put(paramString, localArrayList);
      }
      boolean bool1 = localArrayList.contains(paramdx);
      if (bool1);
      while (true)
      {
        return;
        boolean bool2 = localArrayList.add(paramdx);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     dz
 * JD-Core Version:    0.6.0
 */