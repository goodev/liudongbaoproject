import android.view.View;
import android.view.View.OnClickListener;
import com.mymoney.ui.widget.Panel;

public class tm
  implements View.OnClickListener
{
  public tm(Panel paramPanel)
  {
  }

  public void onClick(View paramView)
  {
    if (Panel.b(this.a))
      this.a.bringToFront();
    if (!this.a.b())
      return;
    Panel localPanel = this.a;
    Runnable localRunnable = this.a.c;
    boolean bool = localPanel.post(localRunnable);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     tm
 * JD-Core Version:    0.6.0
 */