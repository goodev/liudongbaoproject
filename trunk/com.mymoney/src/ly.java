import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.navtrans.NavTransactionActivity;

class ly
  implements DialogInterface.OnClickListener
{
  ly(lw paramlw)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    m localm = NavTransactionActivity.a(this.a.c);
    long l = this.a.b;
    boolean bool = localm.a(l, 1);
    hb.b(NavTransactionActivity.a(), "删除成功.");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ly
 * JD-Core Version:    0.6.0
 */