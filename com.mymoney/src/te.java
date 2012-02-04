import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mymoney.ui.widget.CurrencyRateOperationInputPanel;

public class te extends Handler
{
  public te(CurrencyRateOperationInputPanel paramCurrencyRateOperationInputPanel)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return;
    case 1:
      CurrencyRateOperationInputPanel.n(this.a).setVisibility(8);
      CurrencyRateOperationInputPanel.o(this.a).setBackgroundResource(2130838096);
      return;
    case 2:
      CurrencyRateOperationInputPanel.n(this.a).setVisibility(0);
      CurrencyRateOperationInputPanel.o(this.a).setBackgroundResource(2130838097);
      return;
    case 3:
    }
    int i = ((Integer)paramMessage.obj).intValue();
    CurrencyRateOperationInputPanel.a(this.a, i);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     te
 * JD-Core Version:    0.6.0
 */