import android.os.Handler;
import android.os.Message;
import com.mymoney.ui.navtrans.NavTransactionActivity;

public class mc extends Handler
{
  public mc(NavTransactionActivity paramNavTransactionActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 0)
      return;
    NavTransactionActivity.m(this.a);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     mc
 * JD-Core Version:    0.6.0
 */