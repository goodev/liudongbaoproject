import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.Button;
import android.widget.DatePicker;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;

public class il
  implements DatePickerDialog.OnDateSetListener
{
  public il(AddOrEditTransactionActivity paramAddOrEditTransactionActivity)
  {
  }

  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    AddOrEditTransactionActivity localAddOrEditTransactionActivity = this.a;
    long l1 = gi.a(paramInt1, paramInt2, paramInt3);
    long l2 = AddOrEditTransactionActivity.a(localAddOrEditTransactionActivity, l1);
    Button localButton = AddOrEditTransactionActivity.b(this.a);
    String str = gi.f(AddOrEditTransactionActivity.a(this.a));
    localButton.setText(str);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     il
 * JD-Core Version:    0.6.0
 */