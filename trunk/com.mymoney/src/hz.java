import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;

public class hz
  implements DialogInterface.OnClickListener
{
  public hz(AddOrEditTransNewActivity paramAddOrEditTransNewActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
      AddOrEditTransNewActivity.f(this.a);
      return;
    case 1:
    }
    AddOrEditTransNewActivity.g(this.a);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hz
 * JD-Core Version:    0.6.0
 */