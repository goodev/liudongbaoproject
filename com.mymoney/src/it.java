import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;

public class it
  implements DialogInterface.OnClickListener
{
  public it(AddOrEditTransactionActivity paramAddOrEditTransactionActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
      AddOrEditTransactionActivity.c(this.a);
      return;
    case 1:
    }
    AddOrEditTransactionActivity.d(this.a);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     it
 * JD-Core Version:    0.6.0
 */