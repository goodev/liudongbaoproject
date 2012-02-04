import android.view.inputmethod.InputMethodManager;
import com.mymoney.ui.navtrans.NavTransactionActivity;

public class ma
  implements Runnable
{
  public ma(NavTransactionActivity paramNavTransactionActivity)
  {
  }

  public void run()
  {
    ((InputMethodManager)this.a.getSystemService("input_method")).toggleSoftInput(0, 2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ma
 * JD-Core Version:    0.6.0
 */