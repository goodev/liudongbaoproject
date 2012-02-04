import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.mymoney.ui.navtrans.NavTransactionActivity;

public class md
  implements TextWatcher
{
  private md(NavTransactionActivity paramNavTransactionActivity)
  {
  }

  public void afterTextChanged(Editable paramEditable)
  {
    NavTransactionActivity localNavTransactionActivity = this.a;
    String str1 = paramEditable.toString();
    String str2 = NavTransactionActivity.a(localNavTransactionActivity, str1);
    String str3 = NavTransactionActivity.b();
    StringBuilder localStringBuilder = new StringBuilder().append("keyword:");
    String str4 = NavTransactionActivity.n(this.a);
    String str5 = str4;
    gj.a(str3, str5);
    if (NavTransactionActivity.n(this.a).equals(""))
      NavTransactionActivity.o(this.a).setVisibility(4);
    while (true)
    {
      NavTransactionActivity.p(this.a);
      return;
      NavTransactionActivity.o(this.a).setVisibility(0);
    }
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     md
 * JD-Core Version:    0.6.0
 */