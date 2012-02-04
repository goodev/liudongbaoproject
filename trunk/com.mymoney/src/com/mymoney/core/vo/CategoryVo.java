package com.mymoney.core.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import hi;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CategoryVo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator CREATOR;
  public static long a = 0L;
  private long b;
  private String c;
  private long d;
  private int e;
  private CategoryVo f;
  private String g;
  private List h;
  private boolean i = 0;

  static
  {
    CREATOR = new hi();
  }

  public CategoryVo()
  {
  }

  public CategoryVo(long paramLong)
  {
    this.b = paramLong;
  }

  public CategoryVo(String paramString)
  {
    this.c = paramString;
  }

  public static long a(CategoryVo paramCategoryVo)
  {
    if (paramCategoryVo == null)
      throw new IllegalArgumentException("category not be null");
    long l1 = paramCategoryVo.a();
    CategoryVo localCategoryVo1 = paramCategoryVo.e();
    long l2 = l1;
    for (CategoryVo localCategoryVo2 = localCategoryVo1; localCategoryVo2 != null; localCategoryVo2 = localCategoryVo2.e())
      l2 = localCategoryVo2.a();
    return l2;
  }

  public static String b(CategoryVo paramCategoryVo)
  {
    if (paramCategoryVo == null)
      throw new IllegalArgumentException("category not be null");
    Object localObject1 = paramCategoryVo.e();
    Object localObject2 = "";
    if (localObject1 == null)
    {
      String str1 = paramCategoryVo.b();
      localObject2 = localObject1;
      localObject1 = str1;
    }
    while (true)
    {
      if (localObject2 != null)
      {
        String str2 = ((CategoryVo)localObject2).b();
        CategoryVo localCategoryVo = ((CategoryVo)localObject2).e();
        continue;
      }
      return localObject1;
      Object localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }

  public static String c(CategoryVo paramCategoryVo)
  {
    if (paramCategoryVo == null)
      throw new IllegalArgumentException("category not be null");
    Object localObject1 = paramCategoryVo.e();
    Object localObject2 = "";
    if (localObject1 == null)
    {
      String str1 = paramCategoryVo.f();
      localObject2 = localObject1;
      localObject1 = str1;
    }
    while (true)
    {
      if (localObject2 != null)
      {
        String str2 = ((CategoryVo)localObject2).f();
        CategoryVo localCategoryVo = ((CategoryVo)localObject2).e();
        continue;
      }
      return localObject1;
      Object localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }

  public static CategoryVo d(CategoryVo paramCategoryVo)
  {
    if (paramCategoryVo == null)
      throw new IllegalArgumentException("categoryVo not be null");
    Stack localStack = new Stack();
    Object localObject1 = localStack.push(paramCategoryVo);
    for (CategoryVo localCategoryVo = paramCategoryVo.e(); localCategoryVo != null; localCategoryVo = localCategoryVo.e())
      Object localObject2 = localStack.push(localCategoryVo);
    return (CategoryVo)localStack.peek();
  }

  public long a()
  {
    return this.b;
  }

  public void a(int paramInt)
  {
    this.e = paramInt;
  }

  public void a(long paramLong)
  {
    this.b = paramLong;
  }

  public void a(String paramString)
  {
    this.c = paramString;
  }

  public void a(List paramList)
  {
    this.h = paramList;
  }

  public String b()
  {
    return this.c;
  }

  public void b(long paramLong)
  {
    this.d = paramLong;
  }

  public void b(String paramString)
  {
    this.g = paramString;
  }

  public int c()
  {
    return this.e;
  }

  protected Object clone()
  {
    CategoryVo localCategoryVo1 = (CategoryVo)super.clone();
    if (this.f != null)
    {
      CategoryVo localCategoryVo2 = (CategoryVo)this.f.clone();
      localCategoryVo1.f = localCategoryVo2;
    }
    return localCategoryVo1;
  }

  public long d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public CategoryVo e()
  {
    return this.f;
  }

  public void e(CategoryVo paramCategoryVo)
  {
    this.f = paramCategoryVo;
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
      paramObject = (CategoryVo)paramObject;
      long l1 = this.b;
      long l2 = paramObject.b;
      if (l1 != l2)
      {
        j = 0;
        continue;
      }
      if (this.c == null)
      {
        if (paramObject.c != null)
        {
          j = 0;
          continue;
        }
      }
      else
      {
        String str1 = this.c;
        String str2 = paramObject.c;
        if (!str1.equals(str2))
        {
          j = 0;
          continue;
        }
      }
      j = 1;
    }
  }

  public String f()
  {
    return this.g;
  }

  public List g()
  {
    if ((this.h == null) || (this.h.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      this.h = localArrayList;
      CategoryVo localCategoryVo = new CategoryVo();
      localCategoryVo.a("空分类");
      localCategoryVo.a(2);
      boolean bool = this.h.add(localCategoryVo);
    }
    return this.h;
  }

  public int hashCode()
  {
    int j = 1 * 31;
    long l1 = this.b;
    long l2 = this.b >>> 32;
    int k = ((int)(l1 ^ l2) + 31) * 31;
    if (this.c == null);
    for (int m = 0; ; m = this.c.hashCode())
      return k + m;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    long l = this.b;
    paramParcel.writeLong(l);
    String str = this.c;
    paramParcel.writeString(str);
    CategoryVo localCategoryVo = this.f;
    paramParcel.writeValue(localCategoryVo);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.core.vo.CategoryVo
 * JD-Core Version:    0.6.0
 */