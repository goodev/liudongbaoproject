package com.meizu.mstore.license;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import java.util.ArrayList;
import java.util.Calendar;

public class LicenseResult
  implements Parcelable
{
  public static final Parcelable.Creator<LicenseResult> CREATOR = new LicenseResult.1();
  public static final int PURCHASE_TYPE_EXPIRE = 2;
  public static final int PURCHASE_TYPE_NORMAL = 1;
  public static final int PURCHASE_TYPE_TRIAL = 0;
  public static final int RESPONSE_CODE_ERROR = 255;
  public static final int RESPONSE_CODE_NO_LICENSE_FILE = 254;
  public static final int RESPONSE_CODE_SUCCESS = 1;
  private int mPurchaseType;
  private int mResponseCode;
  private byte[] mSignatureBytes;
  private byte[] mSignedDataBytes;
  private int mStartDate;
  private ArrayList<SubProduct> mSubProducts;

  protected LicenseResult()
  {
    this.mResponseCode = -1;
    this.mPurchaseType = 0;
    this.mSignedDataBytes = null;
    this.mSignatureBytes = null;
    this.mStartDate = -1;
    ArrayList localArrayList = new ArrayList();
    this.mSubProducts = localArrayList;
  }

  protected LicenseResult(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, ArrayList<SubProduct> paramArrayList)
  {
    this.mResponseCode = paramInt1;
    this.mPurchaseType = paramInt2;
    this.mSignedDataBytes = paramArrayOfByte1;
    this.mSignatureBytes = paramArrayOfByte2;
    this.mStartDate = paramInt3;
    this.mSubProducts = paramArrayList;
  }

  public LicenseResult(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    this.mResponseCode = i;
    int j = paramParcel.readInt();
    this.mPurchaseType = j;
    byte[] arrayOfByte1 = paramParcel.createByteArray();
    this.mSignedDataBytes = arrayOfByte1;
    byte[] arrayOfByte2 = paramParcel.createByteArray();
    this.mSignatureBytes = arrayOfByte2;
    int k = paramParcel.readInt();
    this.mStartDate = k;
    ArrayList localArrayList1 = new ArrayList();
    this.mSubProducts = localArrayList1;
    ArrayList localArrayList2 = this.mSubProducts;
    ClassLoader localClassLoader = SubProduct.class.getClassLoader();
    paramParcel.readList(localArrayList2, localClassLoader);
  }

  public int describeContents()
  {
    return 0;
  }

  public int getPurchaseType()
  {
    return this.mPurchaseType;
  }

  public int getResponseCode()
  {
    return this.mResponseCode;
  }

  protected byte[] getSignatureBytes()
  {
    return this.mSignatureBytes;
  }

  protected byte[] getSignedDataBytes()
  {
    return this.mSignedDataBytes;
  }

  public Calendar getStartDate()
  {
    Calendar localCalendar = Calendar.getInstance();
    if (this.mStartDate > 0)
    {
      int i = this.mStartDate / 10000;
      int j = this.mStartDate / 100 % 100;
      int k = this.mStartDate % 100;
      localCalendar.set(i, j, k);
    }
    return localCalendar;
  }

  public ArrayList<SubProduct> getSubProducts()
  {
    return this.mSubProducts;
  }

  protected void setPurchaseType(int paramInt)
  {
    this.mPurchaseType = paramInt;
  }

  protected void setResponseCode(int paramInt)
  {
    this.mResponseCode = paramInt;
  }

  protected void setSignatureBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramArrayOfByte != null))
    {
      int i = paramInt1 + paramInt2;
      int j = paramArrayOfByte.length;
      if (i <= j);
    }
    else
    {
      int k = Log.e("MStore", "setSignatureBytes length error!");
      return;
    }
    byte[] arrayOfByte1 = new byte[paramInt2];
    this.mSignatureBytes = arrayOfByte1;
    int m = paramInt1;
    while (true)
    {
      int n = paramInt1 + paramInt2;
      if (m >= n)
        return;
      byte[] arrayOfByte2 = this.mSignatureBytes;
      int i1 = m - paramInt1;
      int i2 = paramArrayOfByte[m];
      arrayOfByte2[i1] = i2;
      m += 1;
    }
  }

  protected void setSignedDataBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramArrayOfByte != null))
    {
      int i = paramInt1 + paramInt2;
      int j = paramArrayOfByte.length;
      if (i <= j);
    }
    else
    {
      int k = Log.e("MStore", "setSignedDataBytes length error!");
      return;
    }
    byte[] arrayOfByte1 = new byte[paramInt2];
    this.mSignedDataBytes = arrayOfByte1;
    int m = paramInt1;
    while (true)
    {
      int n = paramInt1 + paramInt2;
      if (m >= n)
        return;
      byte[] arrayOfByte2 = this.mSignedDataBytes;
      int i1 = m - paramInt1;
      int i2 = paramArrayOfByte[m];
      arrayOfByte2[i1] = i2;
      m += 1;
    }
  }

  protected void setStartDate(int paramInt)
  {
    this.mStartDate = paramInt;
  }

  protected void setSubProducts(ArrayList<SubProduct> paramArrayList)
  {
    this.mSubProducts = paramArrayList;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = this.mResponseCode;
    paramParcel.writeInt(i);
    int j = this.mPurchaseType;
    paramParcel.writeInt(j);
    byte[] arrayOfByte1 = this.mSignedDataBytes;
    paramParcel.writeByteArray(arrayOfByte1);
    byte[] arrayOfByte2 = this.mSignatureBytes;
    paramParcel.writeByteArray(arrayOfByte2);
    int k = this.mStartDate;
    paramParcel.writeInt(k);
    ArrayList localArrayList = this.mSubProducts;
    paramParcel.writeList(localArrayList);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.meizu.mstore.license.LicenseResult
 * JD-Core Version:    0.6.0
 */