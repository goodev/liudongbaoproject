import android.content.DialogInterface;
import android.widget.TextView;
import com.mymoney.ui.navtrans.NavYearTransactionFilterActivity;

public class ml extends tw
{
  public ml(NavYearTransactionFilterActivity paramNavYearTransactionFilterActivity)
  {
  }

  public void a(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NavYearTransactionFilterActivity.b(this.a).b())
    {
      this.a.g.setText("全部");
      return;
    }
    this.a.g.setText("已选择");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ml
 * JD-Core Version:    0.6.0
 */