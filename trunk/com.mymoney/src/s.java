import com.mymoney.core.vo.CorporationVo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class s
  implements i
{
  private ag a;
  private al b;

  public s()
  {
    ag localag = ai.a().e();
    this.a = localag;
    al localal = ai.a().h();
    this.b = localal;
  }

  private CorporationVo a(eu parameu)
  {
    CorporationVo localCorporationVo = new CorporationVo();
    long l = parameu.b();
    localCorporationVo.a(l);
    String str = parameu.c();
    localCorporationVo.a(str);
    return localCorporationVo;
  }

  public long a(String paramString)
  {
    eu localeu = new eu();
    localeu.a(paramString);
    int i = gt.b();
    localeu.a(i);
    long l = this.a.a(localeu);
    eb localeb = eb.a();
    String str = ea.h;
    localeb.a(str);
    return l;
  }

  public List a()
  {
    List localList = this.a.a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      eu localeu = (eu)localIterator.next();
      CorporationVo localCorporationVo = a(localeu);
      boolean bool = localArrayList.add(localCorporationVo);
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
      String str = "UPDATE t_tradingEntity SET ordered = " + i + ", lastUpdateTime = " + l + " WHERE tradingEntityPOID = " + localLong;
      boolean bool = localArrayList.add(str);
    }
    he.a(localArrayList, 1);
    localArrayList.clear();
  }

  public boolean a(long paramLong)
  {
    an localan = ai.a().b();
    try
    {
      dj.a();
      boolean bool = this.a.b(paramLong);
      localan.d(paramLong);
      localan.e(paramLong);
      dj.b();
      eb localeb = eb.a();
      String str = ea.j;
      localeb.a(str);
      return bool;
    }
    finally
    {
      dj.c();
    }
    throw localObject;
  }

  public boolean a(long paramLong, String paramString)
  {
    eu localeu = new eu();
    localeu.a(paramLong);
    localeu.a(paramString);
    boolean bool = this.a.a(localeu, 0);
    eb localeb = eb.a();
    String str = ea.i;
    localeb.a(str);
    return bool;
  }

  public CorporationVo b(long paramLong)
  {
    eu localeu = this.a.a(paramLong);
    return a(localeu);
  }

  public boolean b(String paramString)
  {
    if (this.a.a(paramString) != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public CorporationVo c(String paramString)
  {
    eu localeu = this.a.a(paramString);
    return a(localeu);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     s
 * JD-Core Version:    0.6.0
 */