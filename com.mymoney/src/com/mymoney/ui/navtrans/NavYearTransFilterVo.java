package com.mymoney.ui.navtrans;

import g;
import k;

public class NavYearTransFilterVo
  implements Cloneable
{
  public static String a = "NavYearTransFilterVo";
  private static long c = 65535L;
  private static long d = 65535L;
  private static NavYearTransFilterVo l = null;
  private String b;
  private long[] e;
  private long[] f;
  private long[] g;
  private long[] h;
  private String i = null;
  private String j;
  private String k;

  public static final NavYearTransFilterVo a()
  {
    if (l == null)
    {
      l = new NavYearTransFilterVo();
      l.b();
    }
    return l;
  }

  public void a(long paramLong)
  {
    c = paramLong;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public void a(long[] paramArrayOfLong)
  {
    this.e = paramArrayOfLong;
  }

  public void b()
  {
    String str = g.a().h().a();
    l.a(str);
    l.a(65535L);
    l.b(65535L);
    l.a(null);
    l.b(null);
    l.c(null);
    l.d(null);
    l.b(null);
    l.d(null);
    l.c(null);
  }

  public void b(long paramLong)
  {
    d = paramLong;
  }

  public void b(String paramString)
  {
    this.i = paramString;
  }

  public void b(long[] paramArrayOfLong)
  {
    this.f = paramArrayOfLong;
  }

  public void c(String paramString)
  {
    this.j = paramString;
  }

  public void c(long[] paramArrayOfLong)
  {
    this.g = paramArrayOfLong;
  }

  public long[] c()
  {
    return this.e;
  }

  public Object clone()
  {
    return super.clone();
  }

  public void d(String paramString)
  {
    this.k = paramString;
  }

  public void d(long[] paramArrayOfLong)
  {
    this.h = paramArrayOfLong;
  }

  public long[] d()
  {
    return this.f;
  }

  public long[] e()
  {
    return this.g;
  }

  public long[] f()
  {
    return this.h;
  }

  public String g()
  {
    return this.i;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.navtrans.NavYearTransFilterVo
 * JD-Core Version:    0.6.0
 */