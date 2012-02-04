import android.os.Handler;
import android.os.Message;
import com.mymoney.ui.navtrans.NavYearTransactionActivity;

public class mj extends Handler
{
  public mj(NavYearTransactionActivity paramNavYearTransactionActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 0)
      return;
    NavYearTransactionActivity.l(this.a);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     mj
 * JD-Core Version:    0.6.0
 */