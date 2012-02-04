import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;
import com.mymoney.ui.widget.DigitKeypad;

public class jg
  implements Animation.AnimationListener
{
  public jg(AddOrEditTransactionActivity paramAddOrEditTransactionActivity)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    AddOrEditTransactionActivity.l(this.a).setVisibility(8);
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
    AddOrEditTransactionActivity.m(this.a).setVisibility(0);
    AddOrEditTransactionActivity.m(this.a).a(1);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     jg
 * JD-Core Version:    0.6.0
 */