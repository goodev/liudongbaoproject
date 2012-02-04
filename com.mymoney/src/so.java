import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.Button;
import android.widget.DatePicker;
import com.mymoney.ui.transfer.TransferActivity;

public class so
  implements DatePickerDialog.OnDateSetListener
{
  public so(TransferActivity paramTransferActivity)
  {
  }

  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    TransferActivity localTransferActivity = this.a;
    long l1 = gi.a(paramInt1, paramInt2, paramInt3);
    long l2 = TransferActivity.a(localTransferActivity, l1);
    Button localButton = TransferActivity.b(this.a);
    String str = gi.f(TransferActivity.a(this.a));
    localButton.setText(str);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     so
 * JD-Core Version:    0.6.0
 */