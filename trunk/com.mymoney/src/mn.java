import android.content.DialogInterface;
import android.widget.TextView;
import com.mymoney.ui.navtrans.NavYearTransactionFilterActivity;

public class mn extends tw
{
  public mn(NavYearTransactionFilterActivity paramNavYearTransactionFilterActivity)
  {
  }

  public void a(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NavYearTransactionFilterActivity.d(this.a).b())
    {
      this.a.i.setText("全部");
      return;
    }
    this.a.i.setText("已选择");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     mn
 * JD-Core Version:    0.6.0
 */