import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;

public class iv
  implements DialogInterface.OnClickListener
{
  public iv(AddOrEditTransactionActivity paramAddOrEditTransactionActivity, EditText paramEditText)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = this.a.getText().toString();
    AddOrEditTransactionActivity.a(this.b, str);
    this.a.setText("");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     iv
 * JD-Core Version:    0.6.0
 */