import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.mymoney.ui.widget.CurrencyRateOperationInputPanel;

public class tg
  implements View.OnClickListener
{
  private tg(CurrencyRateOperationInputPanel paramCurrencyRateOperationInputPanel)
  {
  }

  public void onClick(View paramView)
  {
    CurrencyRateOperationInputPanel.a(this.a);
    if ((!CurrencyRateOperationInputPanel.b(this.a).equals("")) && (CurrencyRateOperationInputPanel.c(this.a).equals("")))
    {
      TextView localTextView = CurrencyRateOperationInputPanel.d(this.a);
      String str1 = CurrencyRateOperationInputPanel.a;
      localTextView.setText(str1);
      boolean bool = CurrencyRateOperationInputPanel.a(this.a, 0);
    }
    String str2 = CurrencyRateOperationInputPanel.d(this.a).getText().toString();
    if ((CurrencyRateOperationInputPanel.a.equalsIgnoreCase(str2)) || (CurrencyRateOperationInputPanel.b.equalsIgnoreCase(str2)));
    for (String str3 = ""; ; str3 = str2)
    {
      String str4 = (String)((Button)paramView).getText();
      String str5;
      if (CurrencyRateOperationInputPanel.e(this.a))
      {
        str5 = str4;
        CurrencyRateOperationInputPanel.d(this.a).setText(str5);
        if (!CurrencyRateOperationInputPanel.b(this.a).equals(""))
          break label241;
        String str6 = CurrencyRateOperationInputPanel.a(this.a, str5);
      }
      while (true)
      {
        if (CurrencyRateOperationInputPanel.f(this.a))
        {
          EditText localEditText = (EditText)CurrencyRateOperationInputPanel.d(this.a);
          int i = str5.length();
          localEditText.setSelection(i);
        }
        this.a.a(0);
        return;
        str5 = str3 + str4;
        break;
        label241: String str7 = CurrencyRateOperationInputPanel.b(this.a, str5);
      }
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     tg
 * JD-Core Version:    0.6.0
 */