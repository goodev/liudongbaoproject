import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.mymoney.ui.widget.Panel;

public class to
  implements Animation.AnimationListener
{
  public to(Panel paramPanel)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    Panel localPanel = this.a;
    tq localtq1 = tq.c;
    tq localtq2 = Panel.a(localPanel, localtq1);
    if (Panel.k(this.a))
      Panel.c(this.a).setVisibility(8);
    Panel.p(this.a);
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
    Panel localPanel = this.a;
    tq localtq1 = tq.b;
    tq localtq2 = Panel.a(localPanel, localtq1);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     to
 * JD-Core Version:    0.6.0
 */