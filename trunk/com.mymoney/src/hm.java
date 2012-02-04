import java.util.HashMap;
import java.util.Map;

public class hm
  implements Cloneable
{
  public static String a = "ReportFilterVo";
  private static int c = 2;
  private static int d = 1;
  private static int e = 0;
  private static long j = 65535L;
  private static long k = 65535L;
  private static hm s = null;
  public Map b;
  private long f;
  private long g;
  private long h;
  private String i;
  private long[] l;
  private long[] m;
  private long[] n;
  private long[] o;
  private String p;
  private String q;
  private String r;

  private hm()
  {
    HashMap localHashMap = new HashMap();
    this.b = localHashMap;
  }

  public static final hm a()
  {
    if (s == null)
    {
      s = new hm();
      Map localMap1 = s.b;
      Integer localInteger1 = Integer.valueOf(1);
      Object localObject1 = localMap1.put(localInteger1, "分类支出");
      Map localMap2 = s.b;
      Integer localInteger2 = Integer.valueOf(2);
      Object localObject2 = localMap2.put(localInteger2, "账户支出");
      Map localMap3 = s.b;
      Integer localInteger3 = Integer.valueOf(3);
      Object localObject3 = localMap3.put(localInteger3, "项目支出");
      Map localMap4 = s.b;
      Integer localInteger4 = Integer.valueOf(4);
      Object localObject4 = localMap4.put(localInteger4, "商家支出");
      Map localMap5 = s.b;
      Integer localInteger5 = Integer.valueOf(5);
      Object localObject5 = localMap5.put(localInteger5, "分类收入");
      Map localMap6 = s.b;
      Integer localInteger6 = Integer.valueOf(6);
      Object localObject6 = localMap6.put(localInteger6, "账户收入");
      Map localMap7 = s.b;
      Integer localInteger7 = Integer.valueOf(7);
      Object localObject7 = localMap7.put(localInteger7, "项目收入");
      Map localMap8 = s.b;
      Integer localInteger8 = Integer.valueOf(8);
      Object localObject8 = localMap8.put(localInteger8, "资产");
      Map localMap9 = s.b;
      Integer localInteger9 = Integer.valueOf(9);
      Object localObject9 = localMap9.put(localInteger9, "负债");
      Map localMap10 = s.b;
      Integer localInteger10 = Integer.valueOf(10);
      Object localObject10 = localMap10.put(localInteger10, "月度收入");
      Map localMap11 = s.b;
      Integer localInteger11 = Integer.valueOf(11);
      Object localObject11 = localMap11.put(localInteger11, "月度支出");
      Map localMap12 = s.b;
      Integer localInteger12 = Integer.valueOf(12);
      Object localObject12 = localMap12.put(localInteger12, "月度收支对比");
      Map localMap13 = s.b;
      Integer localInteger13 = Integer.valueOf(13);
      Object localObject13 = localMap13.put(localInteger13, "二级支出");
      Map localMap14 = s.b;
      Integer localInteger14 = Integer.valueOf(14);
      Object localObject14 = localMap14.put(localInteger14, "二级收入");
      s.b();
      c = gu.o();
      e = gu.p();
      switch (e)
      {
      default:
        gj.a(a, "unsupport timePeroidType");
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    }
    while (true)
    {
      return s;
      j = gi.h();
      k = gi.i();
      continue;
      j = gi.a();
      k = gi.b();
      continue;
      j = gi.c();
      k = gi.d();
      continue;
      j = gi.e();
      k = gi.f();
      continue;
      j = gi.g();
      k = gi.j();
      continue;
      j = gu.q();
      k = gu.r();
    }
  }

  public static final boolean a(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 13));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public static final boolean b(int paramInt)
  {
    if ((paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 14));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public void a(long paramLong)
  {
    this.f = paramLong;
  }

  public void a(String paramString)
  {
    this.i = paramString;
  }

  public void a(long[] paramArrayOfLong)
  {
    this.l = paramArrayOfLong;
  }

  public void b()
  {
    String str = g.a().h().a();
    s.a(str);
    s.a(null);
    s.b(null);
    s.c(null);
    s.d(null);
    s.b(null);
    s.d(null);
    s.c(null);
  }

  public void b(long paramLong)
  {
    j = paramLong;
  }

  public void b(String paramString)
  {
    this.p = paramString;
  }

  public void b(long[] paramArrayOfLong)
  {
    this.m = paramArrayOfLong;
  }

  public void c()
  {
    gu.a(d());
    gu.b(q());
    gu.a(g());
    gu.b(h());
    gj.a(a, "saveToMymoneyPerfences() invoke success ");
  }

  public void c(int paramInt)
  {
    c = paramInt;
  }

  public void c(long paramLong)
  {
    k = paramLong;
  }

  public void c(String paramString)
  {
    this.q = paramString;
  }

  public void c(long[] paramArrayOfLong)
  {
    this.n = paramArrayOfLong;
  }

  public Object clone()
  {
    return super.clone();
  }

  public int d()
  {
    return c;
  }

  public void d(int paramInt)
  {
    d = paramInt;
  }

  public void d(long paramLong)
  {
    this.g = paramLong;
  }

  public void d(String paramString)
  {
    this.r = paramString;
  }

  public void d(long[] paramArrayOfLong)
  {
    this.o = paramArrayOfLong;
  }

  public long e()
  {
    return this.f;
  }

  public void e(int paramInt)
  {
    e = paramInt;
  }

  public void e(long paramLong)
  {
    this.h = paramLong;
  }

  public String f()
  {
    return this.i;
  }

  public long g()
  {
    return j;
  }

  public long h()
  {
    return k;
  }

  public long[] i()
  {
    return this.l;
  }

  public long[] j()
  {
    return this.m;
  }

  public long[] k()
  {
    return this.n;
  }

  public long[] l()
  {
    return this.o;
  }

  public String m()
  {
    return this.p;
  }

  public String n()
  {
    return this.q;
  }

  public String o()
  {
    return this.r;
  }

  public String p()
  {
    Map localMap = this.b;
    Integer localInteger = Integer.valueOf(c);
    return (String)localMap.get(localInteger);
  }

  public int q()
  {
    return e;
  }

  public long r()
  {
    return this.g;
  }

  public long s()
  {
    return this.h;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hm
 * JD-Core Version:    0.6.0
 */