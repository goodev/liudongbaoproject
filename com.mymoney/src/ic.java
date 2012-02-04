import android.widget.Button;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.widget.CurrencyRateOperationInputPanel.OnDigitInputFinishListener;
import java.math.BigDecimal;

public class ic
  implements CurrencyRateOperationInputPanel.OnDigitInputFinishListener
{
  public ic(AddOrEditTransNewActivity paramAddOrEditTransNewActivity)
  {
  }

  public void a(String paramString)
  {
    AddOrEditTransNewActivity localAddOrEditTransNewActivity = this.a;
    double d1 = gs.a(paramString).doubleValue();
    double d2 = AddOrEditTransNewActivity.a(localAddOrEditTransNewActivity, d1);
    boolean bool = AddOrEditTransNewActivity.c(this.a).performClick();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ic
 * JD-Core Version:    0.6.0
 */