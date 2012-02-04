import android.os.Handler;
import android.os.Message;
import com.mymoney.ui.report.ReportActivity;

public class mr extends Handler
{
  public mr(ReportActivity paramReportActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 0)
      return;
    ReportActivity.d(this.a);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     mr
 * JD-Core Version:    0.6.0
 */