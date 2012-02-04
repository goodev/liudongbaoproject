import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;

public class ip
  implements DialogInterface.OnClickListener
{
  public ip(AddOrEditTransactionActivity paramAddOrEditTransactionActivity, EditText paramEditText)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditText localEditText = this.a;
    String str = AddOrEditTransactionActivity.e(this.b);
    localEditText.setText(str);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ip
 * JD-Core Version:    0.6.0
 */