import com.mymoney.core.vo.CategoryVo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class q
  implements f
{
  private ae a;
  private an b;

  public q()
  {
    ae localae = ai.a().g();
    this.a = localae;
    an localan = ai.a().b();
    this.b = localan;
  }

  private hh a(es parames)
  {
    CategoryVo localCategoryVo = new CategoryVo();
    long l1 = parames.d().b();
    localCategoryVo.a(l1);
    String str1 = parames.d().c();
    localCategoryVo.a(str1);
    String str2 = parames.d().i();
    localCategoryVo.b(str2);
    long l2 = gi.h();
    long l3 = gi.i();
    an localan = this.b;
    long l4 = localCategoryVo.a();
    double d1 = localan.a(0, l4, l2, l3);
    hh localhh = new hh();
    double d2 = parames.c();
    double d3;
    if (d2 == 0.0D)
      d3 = 0.0D;
    while (true)
    {
      long l5 = parames.b();
      localhh.a(l5);
      localhh.b(d2);
      localhh.a(localCategoryVo);
      localhh.c(d3);
      localhh.a(d1);
      return localhh;
      d3 = d2 - d1;
    }
  }

  private void d()
  {
    double d1 = b();
    double d2 = this.a.b();
    if (d2 <= d1)
      return;
    boolean bool = this.a.a(d2);
  }

  public hh a(long paramLong)
  {
    Object localObject = this.a.b(paramLong);
    if (localObject == null);
    for (localObject = hh.a(); ; localObject = a((es)localObject))
      return localObject;
  }

  public List a()
  {
    List localList = this.a.c();
    int i = localList.size();
    ArrayList localArrayList = new ArrayList(i);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      es locales = (es)localIterator.next();
      hh localhh = a(locales);
      boolean bool = localArrayList.add(localhh);
    }
    return localArrayList;
  }

  public boolean a(double paramDouble)
  {
    boolean bool = this.a.a(paramDouble);
    eb localeb = eb.a();
    String str = ea.o;
    localeb.a(str);
    return bool;
  }

  public boolean a(hh paramhh)
  {
    es locales = new es();
    long l = paramhh.b();
    locales.b(l);
    double d = paramhh.d();
    locales.a(d);
    boolean bool = this.a.a(locales, 0);
    d();
    eb localeb = eb.a();
    String str = ea.o;
    localeb.a(str);
    return bool;
  }

  public double b()
  {
    es locales = this.a.a();
    double d;
    if (locales != null)
      d = locales.c();
    while (true)
    {
      return d;
      d = this.a.b();
    }
  }

  /** @deprecated */
  public void b(hh paramhh)
  {
    monitorenter;
    try
    {
      et localet = new et();
      long l1 = paramhh.c().a();
      localet.a(l1);
      es locales = new es();
      double d = paramhh.d();
      locales.a(d);
      locales.a(localet);
      long l2 = paramhh.c().a();
      if (this.a.b(l2) == null)
      {
        long l3 = this.a.a(locales);
        d();
        eb localeb = eb.a();
        String str = ea.n;
        localeb.a(str);
      }
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public double c()
  {
    return this.a.b();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     q
 * JD-Core Version:    0.6.0
 */