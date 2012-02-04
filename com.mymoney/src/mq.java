import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ScrollView;
import com.mymoney.ui.report.ReportActivity;
import com.mymoney.ui.widget.Panel;

public class mq
  implements Animation.AnimationListener
{
  public mq(ReportActivity paramReportActivity)
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
    ReportActivity.a(this.a).setVisibility(8);
    ReportActivity localReportActivity = this.a;
    Button localButton = ReportActivity.b(this.a);
    Panel localPanel = ReportActivity.c(this.a);
    Boolean localBoolean = Boolean.valueOf(ReportActivity.c(this.a).a());
    ReportActivity.b(localReportActivity, localButton, localPanel, localBoolean);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     mq
 * JD-Core Version:    0.6.0
 */