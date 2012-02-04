import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;

public class iz
  implements DialogInterface.OnClickListener
{
  public iz(AddOrEditTransactionActivity paramAddOrEditTransactionActivity, EditText paramEditText)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = this.a.getText().toString();
    AddOrEditTransactionActivity.c(this.b, str);
    this.a.setText("");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     iz
 * JD-Core Version:    0.6.0
 */