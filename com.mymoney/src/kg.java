import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.mymoney.ui.budget.BudgetActivity;
import com.mymoney.ui.widget.DigitKeypad;

public class kg
  implements Animation.AnimationListener
{
  public kg(BudgetActivity paramBudgetActivity)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
    BudgetActivity.f(this.a).setVisibility(0);
    BudgetActivity.f(this.a).a(1);
    BudgetActivity.g(this.a).setVisibility(8);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     kg
 * JD-Core Version:    0.6.0
 */