import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class g
{
  private static String a = "transactionService";
  private static String b = "accountService";
  private static String c = "categoryService";
  private static String d = "corporationService";
  private static String e = "userService";
  private static String f = "budgetService";
  private static String g = "settingService";
  private static String h = "accountGroupService";
  private static String i = "syncLogsService";
  private static String j = "currencyCodeService";
  private static g k = new g();
  private Map l;

  private g()
  {
    Map localMap = Collections.synchronizedMap(new HashMap());
    this.l = localMap;
  }

  public static g a()
  {
    return k;
  }

  public m b()
  {
    Map localMap1 = this.l;
    String str1 = a;
    Object localObject1 = (m)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new z();
      Map localMap2 = this.l;
      String str2 = a;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (m)localObject1;
  }

  public e c()
  {
    Map localMap1 = this.l;
    String str1 = b;
    Object localObject1 = (e)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new p();
      Map localMap2 = this.l;
      String str2 = b;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (e)localObject1;
  }

  public h d()
  {
    Map localMap1 = this.l;
    String str1 = c;
    Object localObject1 = (h)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new r();
      Map localMap2 = this.l;
      String str2 = c;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (h)localObject1;
  }

  public i e()
  {
    Map localMap1 = this.l;
    String str1 = d;
    Object localObject1 = (i)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new s();
      Map localMap2 = this.l;
      String str2 = d;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (i)localObject1;
  }

  public n f()
  {
    Map localMap1 = this.l;
    String str1 = e;
    Object localObject1 = (n)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new ab();
      Map localMap2 = this.l;
      String str2 = e;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (n)localObject1;
  }

  public f g()
  {
    Map localMap1 = this.l;
    String str1 = f;
    Object localObject1 = (f)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new q();
      Map localMap2 = this.l;
      String str2 = f;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (f)localObject1;
  }

  public k h()
  {
    Map localMap1 = this.l;
    String str1 = g;
    Object localObject1 = (k)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new v();
      Map localMap2 = this.l;
      String str2 = g;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (k)localObject1;
  }

  public d i()
  {
    Map localMap1 = this.l;
    String str1 = h;
    Object localObject1 = (d)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new o();
      Map localMap2 = this.l;
      String str2 = h;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (d)localObject1;
  }

  public l j()
  {
    Map localMap1 = this.l;
    String str1 = i;
    Object localObject1 = (l)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new x();
      Map localMap2 = this.l;
      String str2 = i;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (l)localObject1;
  }

  public j k()
  {
    Map localMap1 = this.l;
    String str1 = j;
    Object localObject1 = (j)localMap1.get(str1);
    if (localObject1 == null)
    {
      localObject1 = new t();
      Map localMap2 = this.l;
      String str2 = j;
      Object localObject2 = localMap2.put(str2, localObject1);
    }
    return (j)localObject1;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     g
 * JD-Core Version:    0.6.0
 */