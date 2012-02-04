import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;

public class is
  implements DialogInterface.OnClickListener
{
  public is(AddOrEditTransactionActivity paramAddOrEditTransactionActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    m localm = AddOrEditTransactionActivity.h(this.a);
    long l = AddOrEditTransactionActivity.g(this.a);
    boolean bool = localm.a(l, 1);
    hb.b(AddOrEditTransactionActivity.a(), "删除成功.");
    this.a.finish();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     is
 * JD-Core Version:    0.6.0
 */