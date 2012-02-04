import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.mymoney.ui.widget.CurrencyRateInputPanel;
import com.mymoney.ui.widget.CurrencyRateInputPanel.OnDigitInputFinishListener;

public class tc
  implements View.OnClickListener
{
  private tc(CurrencyRateInputPanel paramCurrencyRateInputPanel)
  {
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131231153:
    default:
    case 2131231152:
    case 2131231151:
    case 2131231154:
    }
    while (true)
    {
      this.a.a(0);
      return;
      String str1 = CurrencyRateInputPanel.a(this.a).getText().toString();
      if (CurrencyRateInputPanel.d(this.a))
        return;
      if (str1.contains("."))
        return;
      if (CurrencyRateInputPanel.b(this.a))
        CurrencyRateInputPanel.a(this.a).setText(".");
      while (true)
      {
        boolean bool1 = CurrencyRateInputPanel.a(this.a, 1);
        break;
        TextView localTextView1 = CurrencyRateInputPanel.a(this.a);
        String str2 = str1 + ".";
        localTextView1.setText(str2);
      }
      TextView localTextView2 = CurrencyRateInputPanel.a(this.a);
      String str3 = CurrencyRateInputPanel.a;
      localTextView2.setText(str3);
      boolean bool2 = CurrencyRateInputPanel.a(this.a, 0);
      continue;
      if (CurrencyRateInputPanel.c(this.a))
        this.a.setVisibility(8);
      if (CurrencyRateInputPanel.e(this.a) == null)
        continue;
      CurrencyRateInputPanel.OnDigitInputFinishListener localOnDigitInputFinishListener = CurrencyRateInputPanel.e(this.a);
      String str4 = CurrencyRateInputPanel.a(this.a).getText().toString();
      localOnDigitInputFinishListener.a(str4);
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     tc
 * JD-Core Version:    0.6.0
 */