import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mymoney.ui.widget.wheelview.WheelDatePicker;

public class vc extends vm
{
  int a;
  int b;

  public vc(WheelDatePicker paramWheelDatePicker, Context paramContext, String[] paramArrayOfString, int paramInt)
  {
    super(paramContext, paramArrayOfString);
    this.b = paramInt;
    a(23);
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.a = paramInt;
    return super.a(paramInt, paramView, paramViewGroup);
  }

  protected void a(TextView paramTextView)
  {
    super.a(paramTextView);
    int i = this.a;
    int j = this.b;
    if (i == j)
    {
      int k = WheelDatePicker.g(this.c).getResources().getColor(2131296286);
      paramTextView.setTextColor(k);
    }
    Typeface localTypeface = Typeface.DEFAULT;
    paramTextView.setTypeface(localTypeface, 1);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vc
 * JD-Core Version:    0.6.0
 */