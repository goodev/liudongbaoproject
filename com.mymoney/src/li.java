import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.mymoney.ui.main.BackgroundService;
import com.mymoney.ui.main.BackgroundService.BackgroundServiceBinder;
import com.mymoney.ui.main.MainActivity;

public class li
  implements ServiceConnection
{
  public li(MainActivity paramMainActivity)
  {
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    MainActivity localMainActivity = this.a;
    BackgroundService localBackgroundService1 = ((BackgroundService.BackgroundServiceBinder)paramIBinder).a();
    BackgroundService localBackgroundService2 = MainActivity.a(localMainActivity, localBackgroundService1);
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    BackgroundService localBackgroundService = MainActivity.a(this.a, null);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     li
 * JD-Core Version:    0.6.0
 */