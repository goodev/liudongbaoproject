import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;

public class iq
  implements DialogInterface.OnClickListener
{
  public iq(AddOrEditTransactionActivity paramAddOrEditTransactionActivity, EditText paramEditText)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AddOrEditTransactionActivity localAddOrEditTransactionActivity = this.b;
    String str1 = this.a.getText().toString();
    String str2 = AddOrEditTransactionActivity.f(localAddOrEditTransactionActivity, str1);
    Button localButton = AddOrEditTransactionActivity.f(this.b);
    String str3 = AddOrEditTransactionActivity.e(this.b);
    localButton.setText(str3);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     iq
 * JD-Core Version:    0.6.0
 */