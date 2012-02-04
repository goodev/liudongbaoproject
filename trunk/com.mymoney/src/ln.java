import android.os.Handler;
import android.os.Message;
import com.mymoney.ui.main.MainActivity;

public class ln extends Handler
{
  public ln(MainActivity paramMainActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 0)
      return;
    MainActivity.a(this.a);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ln
 * JD-Core Version:    0.6.0
 */