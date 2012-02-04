package com.meizu.mstore.license;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface ILicensingService extends IInterface
{
  public abstract LicenseResult checkLicense(String paramString)
    throws RemoteException;

  public static abstract class Stub extends Binder
    implements ILicensingService
  {
    private static final String DESCRIPTOR = "com.meizu.mstore.license.ILicensingService";
    static final int TRANSACTION_checkLicense = 1;

    public Stub()
    {
      attachInterface(this, "com.meizu.mstore.license.ILicensingService");
    }

    public static ILicensingService asInterface(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder == null)
        localObject = null;
      while (true)
      {
        return localObject;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.meizu.mstore.license.ILicensingService");
        if ((localIInterface != null) && ((localIInterface instanceof ILicensingService)))
        {
          localObject = (ILicensingService)localIInterface;
          continue;
        }
        localObject = new Proxy(paramIBinder);
      }
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool;
      switch (paramInt1)
      {
      default:
      case 1598968902:
        for (bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2); ; bool = true)
        {
          return bool;
          paramParcel2.writeString("com.meizu.mstore.license.ILicensingService");
        }
      case 1:
      }
      paramParcel1.enforceInterface("com.meizu.mstore.license.ILicensingService");
      String str = paramParcel1.readString();
      LicenseResult localLicenseResult = checkLicense(str);
      paramParcel2.writeNoException();
      if (localLicenseResult != null)
      {
        paramParcel2.writeInt(1);
        localLicenseResult.writeToParcel(paramParcel2, 1);
      }
      while (true)
      {
        bool = true;
        break;
        paramParcel2.writeInt(0);
      }
    }

    private static class Proxy
      implements ILicensingService
    {
      private IBinder mRemote;

      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }

      public IBinder asBinder()
      {
        return this.mRemote;
      }

      public LicenseResult checkLicense(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.meizu.mstore.license.ILicensingService");
          localParcel1.writeString(paramString);
          boolean bool = this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            localLicenseResult = (LicenseResult)LicenseResult.CREATOR.createFromParcel(localParcel2);
            return localLicenseResult;
          }
          LicenseResult localLicenseResult = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public String getInterfaceDescriptor()
      {
        return "com.meizu.mstore.license.ILicensingService";
      }
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.meizu.mstore.license.ILicensingService
 * JD-Core Version:    0.6.0
 */