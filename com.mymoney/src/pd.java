import android.os.Handler;
import android.os.Message;
import com.mymoney.ui.setting.SettingActivity;

public class pd extends Handler
{
  public pd(SettingActivity paramSettingActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 0)
      return;
    SettingActivity.g(this.a);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     pd
 * JD-Core Version:    0.6.0
 */