import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.mymoney.ui.widget.DigitKeypad;
import com.mymoney.ui.widget.DigitKeypad.OnCancelListener;
import com.mymoney.ui.widget.DigitKeypad.OnFinishListener;
import java.text.DecimalFormat;

public class tj
  implements View.OnClickListener
{
  private tj(DigitKeypad paramDigitKeypad)
  {
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131231152:
      if (DigitKeypad.a(this.a))
        return;
      Button localButton = DigitKeypad.h(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      DecimalFormat localDecimalFormat = DigitKeypad.j(this.a);
      double d1 = DigitKeypad.f(this.a);
      String str1 = localDecimalFormat.format(d1);
      String str2 = str1 + ".";
      localButton.setText(str2);
      boolean bool = DigitKeypad.a(this.a, 1);
      return;
    case 2131231166:
      DigitKeypad.k(this.a);
      return;
    case 2131231167:
      if (DigitKeypad.l(this.a) == null)
        return;
      DigitKeypad.l(this.a).a();
      return;
    case 2131231168:
      DigitKeypad.k(this.a);
      return;
    case 2131231169:
    }
    if (DigitKeypad.m(this.a) == null)
      return;
    DigitKeypad.OnFinishListener localOnFinishListener = DigitKeypad.m(this.a);
    double d2 = DigitKeypad.f(this.a);
    localOnFinishListener.a(d2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     tj
 * JD-Core Version:    0.6.0
 */