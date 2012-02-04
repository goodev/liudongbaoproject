import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ai
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  private static String h = "transationDao";
  private static String i = "accountDao";
  private static String j = "categoryDao";
  private static String k = "corporationDao";
  private static String l = "userDao";
  private static ai m;
  private Map n;

  static
  {
    a = "budgetDao";
    b = "profileDao";
    c = "maintainDao";
    d = "accountGroupDao";
    e = "syncLogsDao";
    f = "exchangeDao";
    g = "currencyDao";
    m = new ai();
  }

  private ai()
  {
    Map localMap = Collections.synchronizedMap(new HashMap());
    this.n = localMap;
  }

  public static ai a()
  {
    return m;
  }

  public an b()
  {
    Map localMap1 = this.n;
    String str1 = h;
    Object localObject1 = (an)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new bq();
      Map localMap2 = this.n;
      String str2 = h;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (an)localObject1;
  }

  public ac c()
  {
    Map localMap1 = this.n;
    String str1 = i;
    Object localObject1 = (ac)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new ap();
      Map localMap2 = this.n;
      String str2 = i;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (ac)localObject1;
  }

  public af d()
  {
    Map localMap1 = this.n;
    String str1 = j;
    Object localObject1 = (af)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new au();
      Map localMap2 = this.n;
      String str2 = j;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (af)localObject1;
  }

  public ag e()
  {
    Map localMap1 = this.n;
    String str1 = k;
    Object localObject1 = (ag)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new av();
      Map localMap2 = this.n;
      String str2 = k;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (ag)localObject1;
  }

  public ao f()
  {
    Map localMap1 = this.n;
    String str1 = l;
    Object localObject1 = (ao)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new bs();
      Map localMap2 = this.n;
      String str2 = l;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (ao)localObject1;
  }

  public ae g()
  {
    Map localMap1 = this.n;
    String str1 = a;
    Object localObject1 = (ae)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new at();
      Map localMap2 = this.n;
      String str2 = a;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (ae)localObject1;
  }

  public al h()
  {
    Map localMap1 = this.n;
    String str1 = b;
    Object localObject1 = (al)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new az();
      Map localMap2 = this.n;
      String str2 = b;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (al)localObject1;
  }

  public ak i()
  {
    Map localMap1 = this.n;
    String str1 = c;
    Object localObject1 = (ak)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new ay();
      Map localMap2 = this.n;
      String str2 = c;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (ak)localObject1;
  }

  public ad j()
  {
    Map localMap1 = this.n;
    String str1 = d;
    Object localObject1 = (ad)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new aq();
      Map localMap2 = this.n;
      String str2 = d;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (ad)localObject1;
  }

  public am k()
  {
    Map localMap1 = this.n;
    String str1 = e;
    Object localObject1 = (am)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new bn();
      Map localMap2 = this.n;
      String str2 = e;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (am)localObject1;
  }

  public aj l()
  {
    Map localMap1 = this.n;
    String str1 = f;
    Object localObject1 = (aj)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new ax();
      Map localMap2 = this.n;
      String str2 = f;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (aj)localObject1;
  }

  public ah m()
  {
    Map localMap1 = this.n;
    String str1 = g;
    Object localObject1 = (ah)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new aw();
      Map localMap2 = this.n;
      String str2 = g;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (ah)localObject1;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ai
 * JD-Core Version:    0.6.0
 */