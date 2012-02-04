package com.mymoney.core.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import ho;

public class TransactionVo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ho();
  private long a;
  private int b;
  private double c;
  private String d;
  private String e;
  private boolean f;
  private long g;
  private String h;
  private double i;
  private boolean j;
  private String k = "";
  private CategoryVo l;
  private AccountVo m;
  private AccountVo n;
  private CorporationVo o;
  private ProjectVo p;

  public long a()
  {
    return this.a;
  }

  public void a(double paramDouble)
  {
    this.c = paramDouble;
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
  }

  public void a(long paramLong)
  {
    this.a = paramLong;
  }

  public void a(AccountVo paramAccountVo)
  {
    this.m = paramAccountVo;
  }

  public void a(CategoryVo paramCategoryVo)
  {
    this.l = paramCategoryVo;
  }

  public void a(CorporationVo paramCorporationVo)
  {
    this.o = paramCorporationVo;
  }

  public void a(ProjectVo paramProjectVo)
  {
    this.p = paramProjectVo;
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public double b()
  {
    return this.c;
  }

  public void b(double paramDouble)
  {
    this.i = paramDouble;
  }

  public void b(long paramLong)
  {
    this.g = paramLong;
  }

  public void b(AccountVo paramAccountVo)
  {
    this.n = paramAccountVo;
  }

  public void b(String paramString)
  {
    this.e = paramString;
  }

  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public String c()
  {
    return this.d;
  }

  public void c(String paramString)
  {
    this.h = paramString;
  }

  public String d()
  {
    return this.e;
  }

  public void d(String paramString)
  {
    this.k = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean e()
  {
    return this.f;
  }

  public CategoryVo f()
  {
    return this.l;
  }

  public AccountVo g()
  {
    return this.m;
  }

  public CorporationVo h()
  {
    return this.o;
  }

  public ProjectVo i()
  {
    return this.p;
  }

  public long j()
  {
    return this.g;
  }

  public int k()
  {
    return this.b;
  }

  public String l()
  {
    return this.h;
  }

  public double m()
  {
    return this.i;
  }

  public boolean n()
  {
    return this.j;
  }

  public String o()
  {
    return this.k;
  }

  public AccountVo p()
  {
    return this.n;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    long l1 = this.a;
    paramParcel.writeLong(l1);
    double d1 = this.c;
    paramParcel.writeDouble(d1);
    String str1 = this.d;
    paramParcel.writeString(str1);
    String str2 = this.e;
    paramParcel.writeString(str2);
    boolean[] arrayOfBoolean = new boolean[1];
    boolean bool = this.f;
    arrayOfBoolean[0] = bool;
    paramParcel.writeBooleanArray(arrayOfBoolean);
    long l2 = this.g;
    paramParcel.writeLong(l2);
    String str3 = this.h;
    paramParcel.writeString(str3);
    CategoryVo localCategoryVo = this.l;
    paramParcel.writeValue(localCategoryVo);
    AccountVo localAccountVo1 = this.m;
    paramParcel.writeValue(localAccountVo1);
    AccountVo localAccountVo2 = this.n;
    paramParcel.writeValue(localAccountVo2);
    CorporationVo localCorporationVo = this.o;
    paramParcel.writeValue(localCorporationVo);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.core.vo.TransactionVo
 * JD-Core Version:    0.6.0
 */