import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.widget.Button;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;

public class hs extends ResultReceiver
{
  public hs(AddOrEditTransNewActivity paramAddOrEditTransNewActivity, Handler paramHandler)
  {
    super(paramHandler);
  }

  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    switch (paramInt)
    {
    case 3:
    default:
      return;
    case 2:
    }
    boolean bool = AddOrEditTransNewActivity.a(this.a).performClick();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hs
 * JD-Core Version:    0.6.0
 */