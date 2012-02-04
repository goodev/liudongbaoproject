import android.widget.RadioGroup;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.widget.CurrencyRateOperationInputPanel.OnCheckedChangeListener;

public class ik
  implements CurrencyRateOperationInputPanel.OnCheckedChangeListener
{
  private ik(AddOrEditTransNewActivity paramAddOrEditTransNewActivity)
  {
  }

  public void a(RadioGroup paramRadioGroup, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2131230781)
    {
      AddOrEditTransNewActivity.U(this.a);
      return;
    }
    AddOrEditTransNewActivity.f(this.a, paramInt2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ik
 * JD-Core Version:    0.6.0
 */