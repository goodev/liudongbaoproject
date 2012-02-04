import android.os.Handler;
import android.os.Message;
import com.mymoney.ui.widget.BatteryView;

public class sy extends Handler
{
  public sy(BatteryView paramBatteryView)
  {
  }

  public void a()
  {
    removeMessages(0);
    Message localMessage = obtainMessage(0);
    boolean bool = super.sendMessage(localMessage);
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    BatteryView.a(this.a);
    this.a.invalidate();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     sy
 * JD-Core Version:    0.6.0
 */