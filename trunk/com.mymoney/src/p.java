import com.mymoney.core.application.ApplicationContext;
import com.mymoney.core.vo.AccountGroupVo;
import com.mymoney.core.vo.AccountVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class p
  implements e
{
  private ac a;

  public p()
  {
    ac localac = ai.a().c();
    this.a = localac;
  }

  private AccountVo a(eq parameq, boolean paramBoolean)
  {
    AccountVo localAccountVo = new AccountVo();
    long l1 = parameq.f();
    localAccountVo.a(l1);
    String str1 = parameq.g();
    localAccountVo.a(str1);
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str2 = parameq.g();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append("(");
    String str3 = parameq.h();
    String str4 = str3 + ")";
    localAccountVo.d(str4);
    String str5 = parameq.h();
    localAccountVo.b(str5);
    double d1 = parameq.b();
    localAccountVo.a(d1);
    double d2 = parameq.c();
    localAccountVo.b(d2);
    double d3 = parameq.d();
    localAccountVo.c(d3);
    String str6 = parameq.i();
    localAccountVo.c(str6);
    boolean bool = parameq.j();
    localAccountVo.a(bool);
    long l2 = parameq.k().b();
    String str7 = parameq.k().c();
    int i = parameq.k().i();
    long l3 = parameq.k().d();
    String str8 = parameq.k().e();
    if (paramBoolean)
    {
      AccountGroupVo localAccountGroupVo1 = g.a().i().b(l2);
      localAccountVo.a(localAccountGroupVo1);
    }
    while (true)
    {
      return localAccountVo;
      AccountGroupVo localAccountGroupVo2 = new AccountGroupVo();
      localAccountGroupVo2.a(l2);
      localAccountGroupVo2.a(str7);
      localAccountGroupVo2.b(i);
      localAccountGroupVo2.b(l3);
      localAccountGroupVo2.c(str8);
      localAccountVo.a(localAccountGroupVo2);
    }
  }

  private eq d(AccountVo paramAccountVo)
  {
    long l1 = AccountGroupVo.a(paramAccountVo.c());
    eq localeq = new eq();
    long l2 = paramAccountVo.a();
    localeq.b(l2);
    String str1 = paramAccountVo.b();
    localeq.a(str1);
    double d1 = paramAccountVo.e();
    localeq.a(d1);
    double d2 = paramAccountVo.f();
    localeq.b(d2);
    double d3 = paramAccountVo.g();
    localeq.c(d3);
    String str2 = paramAccountVo.h();
    localeq.c(str2);
    boolean bool = paramAccountVo.j();
    localeq.a(bool);
    String str3 = paramAccountVo.d();
    localeq.b(str3);
    er localer = new er(l1);
    localeq.a(localer);
    return localeq;
  }

  public double a()
  {
    ba localba = ba.a();
    String str = ApplicationContext.g;
    return localba.a(str).doubleValue();
  }

  public long a(AccountVo paramAccountVo)
  {
    eq localeq = d(paramAccountVo);
    try
    {
      long l1 = this.a.a(localeq);
      l2 = l1;
      eb localeb = eb.a();
      String str = ea.e;
      localeb.a(str);
      return l2;
    }
    catch (ed localed)
    {
      while (true)
      {
        localed.printStackTrace();
        long l2 = 0L;
      }
    }
  }

  public List a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.a.a(paramBoolean).iterator();
      while (localIterator.hasNext())
      {
        eq localeq = (eq)localIterator.next();
        AccountVo localAccountVo = a(localeq, 0);
        boolean bool = localArrayList.add(localAccountVo);
      }
    }
    catch (ed localed)
    {
      localed.printStackTrace();
    }
    return localArrayList;
  }

  public void a(Map paramMap)
  {
    ArrayList localArrayList = new ArrayList(50);
    long l = gt.f();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      int i = ((Integer)paramMap.get(localLong)).intValue();
      String str = "UPDATE t_account SET ordered = " + i + ", lastUpdateTime = " + l + " WHERE accountPOID = " + localLong;
      boolean bool = localArrayList.add(str);
    }
    he.a(localArrayList, 1);
    localArrayList.clear();
  }

  public boolean a(long paramLong)
  {
    return this.a.b(paramLong);
  }

  public boolean a(String paramString)
  {
    if (this.a.a(paramString) != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean a(boolean paramBoolean, long paramLong)
  {
    boolean bool = this.a.a(paramBoolean, paramLong);
    eb localeb = eb.a();
    String str = ea.f;
    localeb.a(str);
    return bool;
  }

  public double b()
  {
    ba localba = ba.a();
    String str = ApplicationContext.g;
    return localba.b(str).doubleValue();
  }

  public AccountVo b(String paramString)
  {
    eq localeq = this.a.a(paramString);
    return a(localeq, 1);
  }

  public boolean b(long paramLong)
  {
    double d1 = this.a.d(paramLong);
    boolean bool = this.a.a(paramLong, d1);
    double d2 = this.a.e(paramLong);
    return this.a.b(paramLong, d2);
  }

  public boolean b(AccountVo paramAccountVo)
  {
    ac localac = this.a;
    eq localeq = d(paramAccountVo);
    boolean bool = localac.b(localeq);
    eb localeb = eb.a();
    String str = ea.f;
    localeb.a(str);
    return bool;
  }

  public List c()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.a.a(1).iterator();
      while (localIterator.hasNext())
      {
        eq localeq = (eq)localIterator.next();
        if (localeq.k().i() != 0)
          continue;
        AccountVo localAccountVo = a(localeq, 0);
        boolean bool = localArrayList.add(localAccountVo);
      }
    }
    catch (ed localed)
    {
      localed.printStackTrace();
    }
    return localArrayList;
  }

  public boolean c(long paramLong)
  {
    int i = 0;
    try
    {
      boolean bool = this.a.c(paramLong);
      i = bool;
      eb localeb = eb.a();
      String str = ea.g;
      localeb.a(str);
      return i;
    }
    catch (ed localed)
    {
      while (true)
        localed.printStackTrace();
    }
  }

  public boolean c(AccountVo paramAccountVo)
  {
    ac localac = this.a;
    String str = paramAccountVo.b();
    long l = AccountGroupVo.a(paramAccountVo.c());
    if (localac.a(str, l) != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public AccountVo d(long paramLong)
  {
    eq localeq = this.a.a(paramLong);
    return a(localeq, 1);
  }

  public List d()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = this.a.a(1).iterator();
      while (localIterator.hasNext())
      {
        eq localeq = (eq)localIterator.next();
        int i = localeq.k().i();
        String str = localeq.k().c();
        if ((i != 0) && ((1 != i) || (!"信用卡".equalsIgnoreCase(str))))
          continue;
        AccountVo localAccountVo = a(localeq, 0);
        boolean bool = localArrayList.add(localAccountVo);
      }
    }
    catch (ed localed)
    {
      localed.printStackTrace();
    }
    return localArrayList;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     p
 * JD-Core Version:    0.6.0
 */