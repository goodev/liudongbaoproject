package com.meizu.mstore.license;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;

public class SubProduct
  implements Parcelable
{
  public static final Parcelable.Creator<SubProduct> CREATOR = new SubProduct.1();
  private int mDate;
  private String mProductId;
  private int mQuantity;

  public SubProduct()
  {
  }

  private SubProduct(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }

  public int describeContents()
  {
    return 0;
  }

  public Calendar getDate()
  {
    Calendar localCalendar = Calendar.getInstance();
    if (this.mDate > 0)
    {
      int i = this.mDate / 10000;
      int j = this.mDate / 100 % 100;
      int k = this.mDate % 100;
      localCalendar.set(i, j, k);
    }
    return localCalendar;
  }

  public String getProductId()
  {
    return this.mProductId;
  }

  public int getQuantity()
  {
    return this.mQuantity;
  }

  public void readFromParcel(Parcel paramParcel)
  {
    String str = paramParcel.readString();
    this.mProductId = str;
    int i = paramParcel.readInt();
    this.mQuantity = i;
    int j = paramParcel.readInt();
    this.mDate = j;
  }

  protected void setDate(int paramInt)
  {
    this.mDate = paramInt;
  }

  protected void setProductId(String paramString)
  {
    this.mProductId = paramString;
  }

  protected void setQuantity(int paramInt)
  {
    this.mQuantity = paramInt;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    String str = this.mProductId;
    paramParcel.writeString(str);
    int i = this.mQuantity;
    paramParcel.writeInt(i);
    int j = this.mDate;
    paramParcel.writeInt(j);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.meizu.mstore.license.SubProduct
 * JD-Core Version:    0.6.0
 */