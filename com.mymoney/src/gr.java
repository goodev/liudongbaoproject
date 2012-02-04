import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.meizu.mstore.license.ILicensingService;
import com.meizu.mstore.license.ILicensingService.Stub;

final class gr
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    ILicensingService localILicensingService = gq.a(ILicensingService.Stub.asInterface(paramIBinder));
    boolean bool = gq.c(gq.b());
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    ILicensingService localILicensingService = gq.a(null);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gr
 * JD-Core Version:    0.6.0
 */