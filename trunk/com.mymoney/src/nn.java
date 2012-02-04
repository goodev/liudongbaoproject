import android.view.View;
import android.view.View.OnClickListener;
import com.mymoney.ui.setting.AboutActivity;

public class nn
  implements View.OnClickListener
{
  public nn(AboutActivity paramAboutActivity)
  {
  }

  public void onClick(View paramView)
  {
    AboutActivity.a(this.a, "http://wap.crossmo.com/?c=cp022");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     nn
 * JD-Core Version:    0.6.0
 */