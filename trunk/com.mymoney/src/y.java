import com.mymoney.core.vo.ProjectVo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class y
{
  public static String a = "TagServiceImpl";
  private static y b = null;
  private bo c = null;

  private y()
  {
    bo localbo = bo.a();
    this.c = localbo;
  }

  public static y a()
  {
    if (b == null)
      b = new y();
    return b;
  }

  public fa a(long paramLong)
  {
    return this.c.c(paramLong);
  }

  public List a(int paramInt)
  {
    List localList = this.c.a(paramInt);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      fa localfa = (fa)localIterator.next();
      ProjectVo localProjectVo = new ProjectVo();
      long l = localfa.a();
      localProjectVo.a(l);
      String str = localfa.b();
      localProjectVo.a(str);
      int i = localfa.d();
      localProjectVo.a(i);
      boolean bool = localArrayList.add(localProjectVo);
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
      String str = "UPDATE t_tag SET ordered = " + i + ", lastUpdateTime = " + l + " WHERE tagPOID = " + localLong;
      boolean bool = localArrayList.add(str);
    }
    he.a(localArrayList, 1);
    localArrayList.clear();
  }

  public boolean a(fa paramfa)
  {
    boolean bool = this.c.b(paramfa);
    eb localeb = eb.a();
    String str = ea.l;
    localeb.a(str);
    return bool;
  }

  public boolean a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    return this.c.a(paramString1, paramString2, paramInt, paramBoolean);
  }

  public long b(fa paramfa)
  {
    int i = gt.b();
    paramfa.b(i);
    long l = this.c.a(paramfa);
    eb localeb = eb.a();
    String str = ea.k;
    localeb.a(str);
    return l;
  }

  public boolean b(long paramLong)
  {
    an localan = ai.a().b();
    try
    {
      dj.a();
      c(paramLong);
      boolean bool = this.c.b(paramLong);
      localan.b(paramLong);
      localan.c(paramLong);
      dj.b();
      eb localeb = eb.a();
      String str = ea.m;
      localeb.a(str);
      return bool;
    }
    finally
    {
      dj.c();
    }
    throw localObject;
  }

  public void c(long paramLong)
  {
    this.c.a(paramLong);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     y
 * JD-Core Version:    0.6.0
 */