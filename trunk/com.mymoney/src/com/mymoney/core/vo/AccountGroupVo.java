package com.mymoney.core.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import hf;

public class AccountGroupVo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR = new hf();
  private long a;
  private String b;
  private AccountGroupVo c;
  private String d;
  private boolean e;
  private int f;
  private int g;
  private long h;
  private String i;

  public static long a(AccountGroupVo paramAccountGroupVo)
  {
    if (paramAccountGroupVo == null)
      throw new IllegalArgumentException("accountGroup can not be null");
    long l1 = paramAccountGroupVo.a();
    AccountGroupVo localAccountGroupVo1 = paramAccountGroupVo.c();
    long l2 = l1;
    for (AccountGroupVo localAccountGroupVo2 = localAccountGroupVo1; localAccountGroupVo2 != null; localAccountGroupVo2 = localAccountGroupVo2.c())
      l2 = localAccountGroupVo2.a();
    return l2;
  }

  public long a()
  {
    return this.a;
  }

  public void a(int paramInt)
  {
    this.f = paramInt;
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
    this.e = paramBoolean;
  }

  public String b()
  {
    return this.b;
  }

  public void b(int paramInt)
  {
    this.g = paramInt;
  }

  public void b(long paramLong)
  {
    this.h = paramLong;
  }

  public void b(AccountGroupVo paramAccountGroupVo)
  {
    this.c = paramAccountGroupVo;
  }

  public void b(String paramString)
  {
    this.d = paramString;
  }

  public AccountGroupVo c()
  {
    return this.c;
  }

  public void c(String paramString)
  {
    this.i = paramString;
  }

  protected Object clone()
  {
    AccountGroupVo localAccountGroupVo1 = (AccountGroupVo)super.clone();
    if (this.c != null)
    {
      AccountGroupVo localAccountGroupVo2 = (AccountGroupVo)this.c.clone();
      localAccountGroupVo1.c = localAccountGroupVo2;
    }
    return localAccountGroupVo1;
  }

  public int d()
  {
    return this.g;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.i;
  }

  public boolean equals(Object paramObject)
  {
    int j;
    if (this == paramObject)
      j = 1;
    while (true)
    {
      return j;
      if (paramObject == null)
      {
        j = 0;
        continue;
      }
      Class localClass1 = getClass();
      Class localClass2 = paramObject.getClass();
      if (localClass1 != localClass2)
      {
        j = 0;
        continue;
      }
      paramObject = (AccountGroupVo)paramObject;
      long l1 = this.a;
      long l2 = paramObject.a;
      if (l1 != l2)
      {
        j = 0;
        continue;
      }
      if (this.b == null)
      {
        if (paramObject.b != null)
        {
          j = 0;
          continue;
        }
      }
      else
      {
        String str1 = this.b;
        String str2 = paramObject.b;
        if (!str1.equals(str2))
        {
          j = 0;
          continue;
        }
      }
      j = 1;
    }
  }

  public int hashCode()
  {
    int j = 1 * 31;
    long l1 = this.a;
    long l2 = this.a >>> 32;
    int k = ((int)(l1 ^ l2) + 31) * 31;
    if (this.b == null);
    for (int m = 0; ; m = this.b.hashCode())
      return k + m;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    long l = this.a;
    paramParcel.writeLong(l);
    String str1 = this.b;
    paramParcel.writeString(str1);
    AccountGroupVo localAccountGroupVo = this.c;
    paramParcel.writeValue(localAccountGroupVo);
    String str2 = this.d;
    paramParcel.writeString(str2);
    boolean[] arrayOfBoolean = new boolean[1];
    boolean bool = this.e;
    arrayOfBoolean[0] = bool;
    paramParcel.writeBooleanArray(arrayOfBoolean);
    int j = this.f;
    paramParcel.writeInt(j);
    int k = this.g;
    paramParcel.writeInt(k);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.core.vo.AccountGroupVo
 * JD-Core Version:    0.6.0
 */