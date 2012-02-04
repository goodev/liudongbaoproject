import com.mymoney.core.application.ApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class t
  implements j
{
  public static String a = "CurrencyCodeServiceImpl";
  private ah b;
  private aj c;

  public t()
  {
    ah localah = ai.a().m();
    this.b = localah;
    aj localaj = ai.a().l();
    this.c = localaj;
  }

  private hk a(ev paramev)
  {
    hk localhk = new hk();
    long l = paramev.a();
    localhk.a(l);
    String str1 = paramev.b();
    localhk.b(str1);
    String str2 = paramev.c();
    localhk.a(str2);
    String str3 = paramev.d();
    localhk.c(str3);
    return localhk;
  }

  private hk a(ew paramew)
  {
    String str = paramew.a();
    hk localhk = a(str);
    if (localhk != null)
    {
      long l = paramew.e();
      localhk.b(l);
      double d = paramew.c();
      localhk.a(d);
      boolean bool = paramew.d();
      localhk.a(bool);
    }
    return localhk;
  }

  public double a(String paramString1, String paramString2)
  {
    double d1;
    double d2;
    if (ApplicationContext.g.equalsIgnoreCase(paramString1))
    {
      d1 = 1.0D;
      if (!ApplicationContext.g.equalsIgnoreCase(paramString2))
        break label94;
      d2 = 1.0D;
    }
    while (true)
    {
      return d1 / d2;
      String[] arrayOfString1 = new String[1];
      arrayOfString1[0] = "2";
      String[] arrayOfString2 = new String[2];
      arrayOfString2[0] = paramString1;
      String str1 = ApplicationContext.g;
      arrayOfString2[1] = str1;
      d1 = Double.parseDouble((String)he.b("select rate from t_exchange where sell = ? and buy = ?", arrayOfString1, arrayOfString2).get("rate"));
      break;
      label94: String[] arrayOfString3 = new String[1];
      arrayOfString3[0] = "2";
      String[] arrayOfString4 = new String[2];
      arrayOfString4[0] = paramString2;
      String str2 = ApplicationContext.g;
      arrayOfString4[1] = str2;
      d2 = Double.parseDouble((String)he.b("select rate from t_exchange where sell = ? and buy = ?", arrayOfString3, arrayOfString4).get("rate"));
    }
  }

  public hk a(long paramLong)
  {
    ev localev = this.b.a(paramLong);
    return a(localev);
  }

  public hk a(String paramString)
  {
    Object localObject = null;
    try
    {
      ev localev = this.b.a(paramString);
      if (localev != null)
      {
        hk localhk = a(localev);
        localObject = localhk;
      }
      return localObject;
    }
    catch (ed localed)
    {
      while (true)
        localed.printStackTrace();
    }
  }

  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.b.a().iterator();
      while (localIterator.hasNext())
      {
        ev localev = (ev)localIterator.next();
        hk localhk = a(localev);
        boolean bool = localArrayList.add(localhk);
      }
    }
    catch (ed localed)
    {
      localed.printStackTrace();
    }
    return localArrayList;
  }

  public boolean a(long paramLong, double paramDouble, boolean paramBoolean)
  {
    ah localah = this.b;
    long l = paramLong;
    double d = paramDouble;
    boolean bool1 = paramBoolean;
    boolean bool2 = localah.a(l, d, bool1);
    eb localeb = eb.a();
    String str = ea.q;
    localeb.a(str);
    return bool2;
  }

  public hk b(long paramLong)
  {
    ew localew = this.c.a(paramLong);
    return a(localew);
  }

  public List b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.b(paramString).iterator();
    while (localIterator.hasNext())
    {
      ew localew = (ew)localIterator.next();
      hk localhk = a(localew);
      boolean bool = localArrayList.add(localhk);
    }
    return localArrayList;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     t
 * JD-Core Version:    0.6.0
 */