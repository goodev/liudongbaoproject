import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.mymoney.ui.widget.CurrencyRateOperationInputPanel;

public class th
  implements View.OnClickListener
{
  private th(CurrencyRateOperationInputPanel paramCurrencyRateOperationInputPanel)
  {
  }

  public void onClick(View paramView)
  {
    CurrencyRateOperationInputPanel.a(this.a);
    switch (paramView.getId())
    {
    default:
    case 2131231158:
    case 2131231157:
    case 2131231159:
    }
    while (true)
    {
      this.a.a(0);
      return;
      if ((!CurrencyRateOperationInputPanel.b(this.a).equals("")) && (!CurrencyRateOperationInputPanel.j(this.a).equals("")))
        CurrencyRateOperationInputPanel.k(this.a);
      String str1 = CurrencyRateOperationInputPanel.c(this.a, "+");
      CurrencyRateOperationInputPanel.l(this.a).setVisibility(8);
      CurrencyRateOperationInputPanel.m(this.a).setVisibility(0);
      continue;
      if ((!CurrencyRateOperationInputPanel.b(this.a).equals("")) && (!CurrencyRateOperationInputPanel.j(this.a).equals("")))
        CurrencyRateOperationInputPanel.k(this.a);
      String str2 = CurrencyRateOperationInputPanel.c(this.a, "-");
      CurrencyRateOperationInputPanel.l(this.a).setVisibility(8);
      CurrencyRateOperationInputPanel.m(this.a).setVisibility(0);
      continue;
      if (!CurrencyRateOperationInputPanel.j(this.a).equals(""))
        CurrencyRateOperationInputPanel.k(this.a);
      CurrencyRateOperationInputPanel.l(this.a).setVisibility(0);
      CurrencyRateOperationInputPanel.m(this.a).setVisibility(8);
      String str3 = CurrencyRateOperationInputPanel.c(this.a, "");
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     th
 * JD-Core Version:    0.6.0
 */