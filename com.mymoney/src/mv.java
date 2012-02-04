import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ScrollView;
import com.mymoney.ui.report.ReportActivity;

public class mv
  implements Animation.AnimationListener
{
  public mv(ReportActivity paramReportActivity)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    ReportActivity.a(this.a).setVisibility(0);
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     mv
 * JD-Core Version:    0.6.0
 */