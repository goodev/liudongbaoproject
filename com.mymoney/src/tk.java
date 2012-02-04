import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.mymoney.ui.widget.DigitKeypad;
import java.text.DecimalFormat;

public class tk
  implements View.OnClickListener
{
  private tk(DigitKeypad paramDigitKeypad)
  {
  }

  public void onClick(View paramView)
  {
    int i = Integer.valueOf((String)((Button)paramView).getText()).intValue();
    if (DigitKeypad.a(this.a))
    {
      if (DigitKeypad.b(this.a) > 1000)
        return;
      DigitKeypad localDigitKeypad1 = this.a;
      int j = DigitKeypad.b(this.a) * 10;
      int k = i + j;
      int m = DigitKeypad.a(localDigitKeypad1, k);
      DigitKeypad localDigitKeypad2 = this.a;
      int n = DigitKeypad.c(this.a) * 10;
      int i1 = DigitKeypad.b(localDigitKeypad2, n);
    }
    while (true)
    {
      DigitKeypad localDigitKeypad3 = this.a;
      double d1 = DigitKeypad.d(this.a);
      double d2 = DigitKeypad.b(this.a);
      double d3 = DigitKeypad.c(this.a);
      double d4 = d2 / d3;
      double d5 = d1 + d4;
      double d6 = DigitKeypad.a(localDigitKeypad3, d5);
      if (!DigitKeypad.a(this.a))
        break;
      if (DigitKeypad.c(this.a) == 10)
      {
        Button localButton1 = DigitKeypad.h(this.a);
        DecimalFormat localDecimalFormat1 = DigitKeypad.g(this.a);
        double d7 = DigitKeypad.f(this.a);
        String str1 = localDecimalFormat1.format(d7);
        localButton1.setText(str1);
        return;
        int i2 = DigitKeypad.d(this.a);
        int i3 = DigitKeypad.b();
        if (i2 > i3)
          return;
        DigitKeypad localDigitKeypad4 = this.a;
        int i4 = DigitKeypad.d(this.a) * 10;
        int i5 = i + i4;
        int i6 = DigitKeypad.c(localDigitKeypad4, i5);
        DigitKeypad localDigitKeypad5 = this.a;
        int i7 = DigitKeypad.e(this.a) * 10;
        int i8 = DigitKeypad.d(localDigitKeypad5, i7);
        continue;
      }
      if (DigitKeypad.c(this.a) != 100)
        return;
      Button localButton2 = DigitKeypad.h(this.a);
      DecimalFormat localDecimalFormat2 = DigitKeypad.i(this.a);
      double d8 = DigitKeypad.f(this.a);
      String str2 = localDecimalFormat2.format(d8);
      localButton2.setText(str2);
      return;
    }
    Button localButton3 = DigitKeypad.h(this.a);
    DecimalFormat localDecimalFormat3 = DigitKeypad.j(this.a);
    double d9 = DigitKeypad.f(this.a);
    String str3 = localDecimalFormat3.format(d9);
    localButton3.setText(str3);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     tk
 * JD-Core Version:    0.6.0
 */