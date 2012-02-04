import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;

public class iw
  implements DialogInterface.OnClickListener
{
  public iw(AddOrEditTransactionActivity paramAddOrEditTransactionActivity, EditText paramEditText)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.setText("");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     iw
 * JD-Core Version:    0.6.0
 */