import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.navtrans.NavYearTransactionActivity;

public class mh
  implements DialogInterface.OnClickListener
{
  public mh(NavYearTransactionActivity paramNavYearTransactionActivity, long paramLong)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    m localm = NavYearTransactionActivity.a(this.b);
    long l = this.a;
    boolean bool = localm.a(l, 1);
    hb.b(NavYearTransactionActivity.a(), "删除成功.");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     mh
 * JD-Core Version:    0.6.0
 */