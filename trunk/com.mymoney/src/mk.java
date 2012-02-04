import android.content.DialogInterface;
import android.widget.TextView;
import com.mymoney.ui.navtrans.NavYearTransactionFilterActivity;

public class mk extends tw
{
  public mk(NavYearTransactionFilterActivity paramNavYearTransactionFilterActivity)
  {
  }

  public void a(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NavYearTransactionFilterActivity.a(this.a).b())
    {
      this.a.f.setText("全部");
      return;
    }
    this.a.f.setText("已选择");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     mk
 * JD-Core Version:    0.6.0
 */