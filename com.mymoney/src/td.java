import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.mymoney.ui.widget.CurrencyRateInputPanel;

public class td
  implements View.OnClickListener
{
  private td(CurrencyRateInputPanel paramCurrencyRateInputPanel)
  {
  }

  public void onClick(View paramView)
  {
    String str1 = CurrencyRateInputPanel.a(this.a).getText().toString();
    if ((CurrencyRateInputPanel.a.equalsIgnoreCase(str1)) || (CurrencyRateInputPanel.b.equalsIgnoreCase(str1)));
    for (String str2 = ""; ; str2 = str1)
    {
      String str3 = (String)((Button)paramView).getText();
      if (CurrencyRateInputPanel.b(this.a));
      for (String str4 = str3; ; str4 = str2 + str3)
      {
        CurrencyRateInputPanel.a(this.a).setText(str4);
        if (CurrencyRateInputPanel.c(this.a))
        {
          EditText localEditText = (EditText)CurrencyRateInputPanel.a(this.a);
          int i = str4.length();
          localEditText.setSelection(i);
        }
        this.a.a(0);
        return;
      }
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     td
 * JD-Core Version:    0.6.0
 */