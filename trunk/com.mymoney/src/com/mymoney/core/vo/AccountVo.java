package com.mymoney.core.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import hg;

public class AccountVo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR;
  public static long a = 0L;
  private long b;
  private String c;
  private String d;
  private double e;
  private double f;
  private double g;
  private String h;
  private boolean i;
  private boolean j = 0;
  private AccountGroupVo k;
  private String l;

  static
  {
    CREATOR = new hg();
  }

  public AccountVo()
  {
  }

  public AccountVo(String paramString)
  {
    this.c = paramString;
  }

  public long a()
  {
    return this.b;
  }

  public void a(double paramDouble)
  {
    this.e = paramDouble;
  }

  public void a(long paramLong)
  {
    this.b = paramLong;
  }

  public void a(AccountGroupVo paramAccountGroupVo)
  {
    this.k = paramAccountGroupVo;
  }

  public void a(String paramString)
  {
    this.c = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public String b()
  {
    return this.c;
  }

  public void b(double paramDouble)
  {
    this.f = paramDouble;
  }

  public void b(String paramString)
  {
    this.d = paramString;
  }

  public AccountGroupVo c()
  {
    return this.k;
  }

  public void c(double paramDouble)
  {
    this.g = paramDouble;
  }

  public void c(String paramString)
  {
    this.h = paramString;
  }

  protected Object clone()
  {
    AccountVo localAccountVo = (AccountVo)super.clone();
    if (this.k != null)
    {
      AccountGroupVo localAccountGroupVo = (AccountGroupVo)this.k.clone();
      localAccountVo.k = localAccountGroupVo;
    }
    return localAccountVo;
  }

  public String d()
  {
    return this.d;
  }

  public void d(String paramString)
  {
    this.l = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public double e()
  {
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    int m;
    if (this == paramObject)
      m = 1;
    while (true)
    {
      return m;
      if (paramObject == null)
      {
        m = 0;
        continue;
      }
      Class localClass1 = getClass();
      Class localClass2 = paramObject.getClass();
      if (localClass1 != localClass2)
      {
        m = 0;
        continue;
      }
      paramObject = (AccountVo)paramObject;
      long l1 = this.b;
      long l2 = paramObject.b;
      if (l1 != l2)
      {
        m = 0;
        continue;
      }
      if (this.c == null)
      {
        if (paramObject.c != null)
        {
          m = 0;
          continue;
        }
      }
      else
      {
        String str1 = this.c;
        String str2 = paramObject.c;
        if (!str1.equals(str2))
        {
          m = 0;
          continue;
        }
      }
      m = 1;
    }
  }

  public double f()
  {
    return this.f;
  }

  public double g()
  {
    return this.g;
  }

  public String h()
  {
    return this.h;
  }

  public int hashCode()
  {
    int m = 1 * 31;
    long l1 = this.b;
    long l2 = this.b >>> 32;
    int n = ((int)(l1 ^ l2) + 31) * 31;
    if (this.c == null);
    for (int i1 = 0; ; i1 = this.c.hashCode())
      return n + i1;
  }

  public String i()
  {
    return this.l;
  }

  public boolean j()
  {
    return this.i;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    long l1 = this.b;
    paramParcel.writeLong(l1);
    String str1 = this.c;
    paramParcel.writeString(str1);
    String str2 = this.d;
    paramParcel.writeString(str2);
    double d1 = this.e;
    paramParcel.writeDouble(d1);
    double d2 = this.f;
    paramParcel.writeDouble(d2);
    double d3 = this.g;
    paramParcel.writeDouble(d3);
    String str3 = this.h;
    paramParcel.writeString(str3);
    boolean[] arrayOfBoolean = new boolean[1];
    boolean bool = this.i;
    arrayOfBoolean[0] = bool;
    paramParcel.writeBooleanArray(arrayOfBoolean);
    AccountGroupVo localAccountGroupVo = this.k;
    paramParcel.writeValue(localAccountGroupVo);
    String str4 = this.l;
    paramParcel.writeString(str4);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.core.vo.AccountVo
 * JD-Core Version:    0.6.0
 */