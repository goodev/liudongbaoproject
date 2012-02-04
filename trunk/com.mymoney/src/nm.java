import android.view.View;
import android.view.View.OnClickListener;
import com.mymoney.ui.setting.AboutActivity;

public class nm
  implements View.OnClickListener
{
  public nm(AboutActivity paramAboutActivity)
  {
  }

  public void onClick(View paramView)
  {
    AboutActivity.a(this.a, "http://www.gfan.com/GFanMobile.0.2.7.apk");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     nm
 * JD-Core Version:    0.6.0
 */