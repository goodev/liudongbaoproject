import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.mymoney.ui.widget.CurrencyRateOperationInputPanel;
import com.mymoney.ui.widget.CurrencyRateOperationInputPanel.OnDigitInputFinishListener;

public class tf
  implements View.OnClickListener
{
  private tf(CurrencyRateOperationInputPanel paramCurrencyRateOperationInputPanel)
  {
  }

  public void onClick(View paramView)
  {
    CurrencyRateOperationInputPanel.a(this.a);
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
      if ((!CurrencyRateOperationInputPanel.b(this.a).equals("")) && (CurrencyRateOperationInputPanel.c(this.a).equals("")))
      {
        TextView localTextView = CurrencyRateOperationInputPanel.d(this.a);
        String str1 = CurrencyRateOperationInputPanel.a;
        localTextView.setText(str1);
        boolean bool1 = CurrencyRateOperationInputPanel.a(this.a, 0);
      }
      String str2 = CurrencyRateOperationInputPanel.d(this.a).getText().toString();
      if (CurrencyRateOperationInputPanel.g(this.a))
        return;
      if (str2.contains("."))
        return;
      String str3;
      if (CurrencyRateOperationInputPanel.e(this.a))
      {
        str3 = ".";
        label159: CurrencyRateOperationInputPanel.d(this.a).setText(str3);
        if (!CurrencyRateOperationInputPanel.b(this.a).equals(""))
          break label236;
        String str4 = CurrencyRateOperationInputPanel.a(this.a, str3);
      }
      while (true)
      {
        boolean bool2 = CurrencyRateOperationInputPanel.a(this.a, 1);
        break;
        str3 = str2 + ".";
        break label159;
        label236: String str5 = CurrencyRateOperationInputPanel.b(this.a, str3);
      }
      CurrencyRateOperationInputPanel.h(this.a);
      continue;
      if (CurrencyRateOperationInputPanel.f(this.a))
        this.a.setVisibility(8);
      if (CurrencyRateOperationInputPanel.i(this.a) == null)
        continue;
      CurrencyRateOperationInputPanel.OnDigitInputFinishListener localOnDigitInputFinishListener = CurrencyRateOperationInputPanel.i(this.a);
      String str6 = CurrencyRateOperationInputPanel.d(this.a).getText().toString();
      localOnDigitInputFinishListener.a(str6);
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     tf
 * JD-Core Version:    0.6.0
 */