import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import com.mymoney.ui.navtrans.NavTransactionActivity;

public class lz
  implements PopupWindow.OnDismissListener
{
  public lz(NavTransactionActivity paramNavTransactionActivity)
  {
  }

  public void onDismiss()
  {
    NavTransactionActivity.b(this.a).setVisibility(0);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     lz
 * JD-Core Version:    0.6.0
 */