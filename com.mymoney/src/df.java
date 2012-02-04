public class df
{
  public static int a = 0;
  public static int b = 1;
  private long c;
  private long d;
  private long e;
  private long f;
  private int g;
  private String h;
  private String i;
  private String j;
  private boolean k;
  private String l = "";
  private cz m;
  private cz n;
  private dd o;
  private dd p;
  private long q;
  private long r = 0L;
  private cx s;

  public long a()
  {
    return this.c;
  }

  public void a(int paramInt)
  {
    this.g = paramInt;
  }

  public void a(long paramLong)
  {
    this.c = paramLong;
  }

  public void a(cx paramcx)
  {
    this.s = paramcx;
  }

  public void a(cz paramcz)
  {
    this.m = paramcz;
  }

  public void a(dd paramdd)
  {
    this.o = paramdd;
  }

  public void a(String paramString)
  {
    this.i = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public long b()
  {
    return this.d;
  }

  public void b(long paramLong)
  {
    this.d = paramLong;
  }

  public void b(cz paramcz)
  {
    this.n = paramcz;
  }

  public void b(dd paramdd)
  {
    this.p = paramdd;
  }

  public void b(String paramString)
  {
    this.j = paramString;
  }

  public int c()
  {
    return this.g;
  }

  public void c(long paramLong)
  {
    this.e = paramLong;
  }

  public void c(String paramString)
  {
    if ((paramString == null) || ("null".equalsIgnoreCase(paramString)) || ("NULL".equalsIgnoreCase(paramString)))
    {
      this.l = "";
      return;
    }
    this.l = paramString;
  }

  public long d()
  {
    return this.e;
  }

  public void d(long paramLong)
  {
    this.f = paramLong;
  }

  public void d(String paramString)
  {
    this.h = paramString;
  }

  public String e()
  {
    return this.i;
  }

  public cx f()
  {
    return this.s;
  }

  public cz g()
  {
    return this.m;
  }

  public cz h()
  {
    return this.n;
  }

  public dd i()
  {
    return this.o;
  }

  public dd j()
  {
    return this.p;
  }

  public long k()
  {
    return this.f;
  }

  public long l()
  {
    return this.q;
  }

  public String m()
  {
    return this.j;
  }

  public String n()
  {
    if (this.l != null)
    {
      String str1 = this.l;
      if (!"null".equalsIgnoreCase(str1))
      {
        String str2 = this.l;
        if (!"NULL".equalsIgnoreCase(str2))
          break label41;
      }
    }
    this.l = "";
    label41: return this.l;
  }

  public boolean o()
  {
    return this.k;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     df
 * JD-Core Version:    0.6.0
 */