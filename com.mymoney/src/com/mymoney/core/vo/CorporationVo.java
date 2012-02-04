package com.mymoney.core.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import hj;

public class CorporationVo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new hj();
  private long a;
  private String b;
  private boolean c = 0;

  public CorporationVo()
  {
  }

  public CorporationVo(String paramString)
  {
    this.b = paramString;
  }

  public long a()
  {
    return this.a;
  }

  public void a(long paramLong)
  {
    this.a = paramLong;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public String b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
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
      paramObject = (CorporationVo)paramObject;
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
        String str1 = this.b;
        String str2 = paramObject.b;
        if (!str1.equals(str2))
        {
          i = 0;
          continue;
        }
      }
      i = 1;
    }
  }

  public int hashCode()
  {
    int i = 1 * 31;
    long l1 = this.a;
    long l2 = this.a >>> 32;
    int j = ((int)(l1 ^ l2) + 31) * 31;
    if (this.b == null);
    for (int k = 0; ; k = this.b.hashCode())
      return j + k;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    long l = this.a;
    paramParcel.writeLong(l);
    String str = this.b;
    paramParcel.writeString(str);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.core.vo.CorporationVo
 * JD-Core Version:    0.6.0
 */