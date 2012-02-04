import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.mymoney.ui.transfer.TransferActivity;

public class st
  implements DialogInterface.OnClickListener
{
  public st(TransferActivity paramTransferActivity, EditText paramEditText)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TransferActivity localTransferActivity = this.b;
    String str1 = this.a.getText().toString();
    String str2 = TransferActivity.a(localTransferActivity, str1);
    Button localButton = TransferActivity.j(this.b);
    String str3 = TransferActivity.i(this.b);
    localButton.setText(str3);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     st
 * JD-Core Version:    0.6.0
 */