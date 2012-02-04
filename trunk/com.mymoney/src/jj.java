import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.addtrans.TransactionPhotoEditActivity;

public class jj
  implements DialogInterface.OnClickListener
{
  public jj(TransactionPhotoEditActivity paramTransactionPhotoEditActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
      TransactionPhotoEditActivity.a(this.a);
      return;
    case 1:
    }
    TransactionPhotoEditActivity.b(this.a);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     jj
 * JD-Core Version:    0.6.0
 */