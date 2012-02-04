import com.mymoney.core.vo.CategoryVo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class r
  implements h
{
  private af a;
  private ae b;

  public r()
  {
    af localaf = ai.a().d();
    this.a = localaf;
    ae localae = ai.a().g();
    this.b = localae;
  }

  private long a(String paramString, int paramInt)
  {
    et localet = new et();
    localet.a(paramString);
    localet.c("icon_qtzx");
    int i = gt.b();
    localet.c(i);
    long l;
    if (paramInt == 1)
      l = this.a.b(localet);
    while (true)
    {
      eb localeb = eb.a();
      String str = ea.k;
      localeb.a(str);
      return l;
      if (paramInt == 0)
      {
        l = this.a.a(localet);
        continue;
      }
      l = 0L;
    }
  }

  private CategoryVo a(et paramet)
  {
    CategoryVo localCategoryVo = new CategoryVo();
    long l1 = paramet.b();
    localCategoryVo.a(l1);
    String str1 = paramet.c();
    localCategoryVo.a(str1);
    int i = paramet.h();
    localCategoryVo.a(i);
    long l2 = paramet.e();
    localCategoryVo.b(l2);
    String str2 = paramet.i();
    localCategoryVo.b(str2);
    return localCategoryVo;
  }

  private List b(int paramInt)
  {
    List localList = this.a.a(paramInt);
    int i = localList.size();
    ArrayList localArrayList = new ArrayList(i);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      et localet = (et)localIterator.next();
      CategoryVo localCategoryVo = a(localet);
      boolean bool = localArrayList.add(localCategoryVo);
    }
    return localArrayList;
  }

  private List c(int paramInt)
  {
    List localList;
    if (paramInt == 0)
      localList = this.a.c();
    ArrayList localArrayList;
    while (true)
    {
      int i = localList.size();
      localArrayList = new ArrayList(i);
      Iterator localIterator = localList.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          et localet = (et)localIterator.next();
          CategoryVo localCategoryVo = a(localet);
          boolean bool = localArrayList.add(localCategoryVo);
          continue;
          if (1 == paramInt)
          {
            localList = this.a.d();
            break;
          }
          throw new IllegalArgumentException("unsupport category type");
        }
    }
    return localArrayList;
  }

  public long a(long paramLong, String paramString)
  {
    et localet = new et();
    localet.a(paramString);
    localet.c("icon_qtzx_qtzc");
    int i = gt.b();
    localet.c(i);
    long l = this.a.a(paramLong, localet);
    eb localeb = eb.a();
    String str = ea.k;
    localeb.a(str);
    return l;
  }

  public long a(String paramString)
  {
    return a(paramString, 0);
  }

  public CategoryVo a(String paramString, int paramInt, long paramLong)
  {
    af localaf = this.a;
    String str = paramString;
    int i = paramInt;
    long l = paramLong;
    et localet = localaf.a(str, i, l, 0);
    return a(localet);
  }

  public List a()
  {
    return b(0);
  }

  public List a(int paramInt)
  {
    List localList1 = b(paramInt);
    List localList2 = c(paramInt);
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = localList2.iterator();
    Object localObject1 = null;
    long l1 = 0L;
    Object localObject2 = localObject1;
    while (localIterator1.hasNext())
    {
      this = (CategoryVo)localIterator1.next();
      long l2 = d();
      if (l1 != l2)
      {
        localObject2 = new ArrayList();
        Long localLong1 = Long.valueOf(l2);
        Object localObject3 = localHashMap.put(localLong1, localObject2);
      }
      boolean bool1 = ((List)localObject2).add(this);
      l1 = l2;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator2 = localList1.iterator();
    while (localIterator2.hasNext())
    {
      CategoryVo localCategoryVo = (CategoryVo)localIterator2.next();
      Long localLong2 = Long.valueOf(localCategoryVo.a());
      List localList3 = (List)localHashMap.get(localLong2);
      localCategoryVo.a(localList3);
      boolean bool2 = localArrayList.add(localCategoryVo);
    }
    return (List)localArrayList;
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
      String str = "UPDATE t_category SET ordered = " + i + ", lastUpdateTime = " + l + " WHERE categoryPOID = " + localLong;
      boolean bool = localArrayList.add(str);
    }
    he.a(localArrayList, 1);
    localArrayList.clear();
  }

  public boolean a(long paramLong)
  {
    int i = this.a.c(paramLong).f();
    boolean bool1 = this.a.a(paramLong);
    if (i == 0)
    {
      boolean bool2 = this.b.a(paramLong);
      eb localeb1 = eb.a();
      String str1 = ea.p;
      localeb1.a(str1);
    }
    eb localeb2 = eb.a();
    String str2 = ea.m;
    localeb2.a(str2);
    return bool1;
  }

  public boolean a(long paramLong, String paramString1, String paramString2)
  {
    et localet = new et();
    localet.a(paramLong);
    localet.a(paramString1);
    localet.c(paramString2);
    boolean bool = this.a.a(localet, 0);
    eb localeb = eb.a();
    String str = ea.l;
    localeb.a(str);
    return bool;
  }

  public boolean a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    af localaf = this.a;
    String str = paramString;
    int i = paramInt1;
    long l = paramLong;
    int j = paramInt2;
    if (localaf.a(str, i, l, j) != null);
    for (int k = 1; ; k = 0)
      return k;
  }

  public long b(String paramString)
  {
    return a(paramString, 1);
  }

  public List b()
  {
    return b(1);
  }

  public List b(long paramLong)
  {
    List localList = this.a.b(paramLong);
    int i = localList.size();
    ArrayList localArrayList = new ArrayList(i);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      et localet = (et)localIterator.next();
      CategoryVo localCategoryVo = a(localet);
      boolean bool = localArrayList.add(localCategoryVo);
    }
    return localArrayList;
  }

  public boolean b(long paramLong, String paramString)
  {
    et localet = new et();
    localet.a(paramLong);
    localet.a(paramString);
    boolean bool = this.a.a(localet, 0);
    eb localeb = eb.a();
    String str = ea.l;
    localeb.a(str);
    return bool;
  }

  public boolean b(String paramString, int paramInt, long paramLong)
  {
    r localr = this;
    String str = paramString;
    int i = paramInt;
    long l = paramLong;
    return localr.a(str, i, l, 0);
  }

  public CategoryVo c(long paramLong)
  {
    et localet = this.a.c(paramLong);
    return a(localet);
  }

  public List c()
  {
    return a(0);
  }

  public boolean c(String paramString, int paramInt, long paramLong)
  {
    r localr = this;
    String str = paramString;
    int i = paramInt;
    long l = paramLong;
    return localr.a(str, i, l, 1);
  }

  public CategoryVo d(long paramLong)
  {
    et localet1 = this.a.c(paramLong);
    if (localet1 == null)
      localet1 = et.a();
    Stack localStack = new Stack();
    Object localObject1 = localStack.push(localet1);
    long l = localet1.e();
    while (l != 0L)
    {
      et localet2 = this.a.c(l);
      Object localObject2 = localStack.push(localet2);
      l = localet2.e();
    }
    et localet3 = (et)localStack.pop();
    CategoryVo localCategoryVo1 = a(localet3);
    CategoryVo localCategoryVo2;
    for (Object localObject3 = localCategoryVo1; !localStack.empty(); localObject3 = localCategoryVo2)
    {
      et localet4 = (et)localStack.pop();
      localCategoryVo2 = a(localet4);
      ((CategoryVo)localObject3).e(localCategoryVo2);
    }
    return (CategoryVo)localCategoryVo1;
  }

  public List d()
  {
    return a(1);
  }

  public CategoryVo e()
  {
    et localet = this.a.e();
    return a(localet);
  }

  public boolean e(long paramLong)
  {
    return this.a.d(paramLong);
  }

  public CategoryVo f()
  {
    et localet = this.a.f();
    return a(localet);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     r
 * JD-Core Version:    0.6.0
 */