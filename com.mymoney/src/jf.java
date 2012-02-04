import android.widget.Button;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;
import com.mymoney.ui.widget.DigitKeypad.OnFinishListener;

public class jf
  implements DigitKeypad.OnFinishListener
{
  public jf(AddOrEditTransactionActivity paramAddOrEditTransactionActivity)
  {
  }

  public void a(double paramDouble)
  {
    AddOrEditTransactionActivity.ad(this.a);
    double d = AddOrEditTransactionActivity.a(this.a, paramDouble);
    Button localButton = AddOrEditTransactionActivity.ac(this.a);
    String str = gs.a(AddOrEditTransactionActivity.ab(this.a), null);
    localButton.setText(str);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     jf
 * JD-Core Version:    0.6.0
 */