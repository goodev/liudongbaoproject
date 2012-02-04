public class hk
{
  private long a;
  private String b;
  private String c;
  private String d;
  private long e;
  private double f;
  private boolean g;

  public long a()
  {
    return this.a;
  }

  public void a(double paramDouble)
  {
    this.f = paramDouble;
  }

  public void a(long paramLong)
  {
    this.a = paramLong;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  public String b()
  {
    return this.b;
  }

  public void b(long paramLong)
  {
    this.e = paramLong;
  }

  public void b(String paramString)
  {
    this.c = paramString;
  }

  public String c()
  {
    return this.c;
  }

  public void c(String paramString)
  {
    this.d = paramString;
  }

  public String d()
  {
    return this.d;
  }

  public double e()
  {
    return this.f;
  }

  public boolean equals(Object paramObject)
  {
    int i;
    if (this == paramObject)
      i = 1;
    while (true)
    {
      return i;
      if (paramObject == null)
      {
        i = 0;
        continue;
      }
      Class localClass1 = getClass();
      Class localClass2 = paramObject.getClass();
      if (localClass1 != localClass2)
      {
        i = 0;
        continue;
      }
      paramObject = (hk)paramObject;
      if (this.c == null)
      {
        if (paramObject.c != null)
        {
          i = 0;
          continue;
        }
      }
      else
      {
        String str1 = this.c;
        String str2 = paramObject.c;
        if (!str1.equals(str2))
        {
          i = 0;
          continue;
        }
      }
      long l1 = this.a;
      long l2 = paramObject.a;
      if (l1 != l2)
      {
        i = 0;
        continue;
      }
      if (this.b == null)
      {
        if (paramObject.b != null)
        {
          i = 0;
          continue;
        }
      }
      else
      {
        String str3 = this.b;
        String str4 = paramObject.b;
        if (!str3.equals(str4))
        {
          i = 0;
          continue;
        }
      }
      i = 1;
    }
  }

  public boolean f()
  {
    return this.g;
  }

  public long g()
  {
    return this.e;
  }

  public int hashCode()
  {
    int i = 1 * 31;
    int j;
    int n;
    if (this.c == null)
    {
      j = 0;
      int k = (j + 31) * 31;
      long l1 = this.a;
      long l2 = this.a >>> 32;
      int m = (int)(l1 ^ l2);
      n = (k + m) * 31;
      if (this.b != null)
        break label81;
    }
    label81: for (int i1 = 0; ; i1 = this.b.hashCode())
    {
      return n + i1;
      j = this.c.hashCode();
      break;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hk
 * JD-Core Version:    0.6.0
 */