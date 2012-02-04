import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.mymoney.ui.security.SecurityActivity;

public class nk extends LinearLayout
{
  public nk(SecurityActivity paramSecurityActivity, Context paramContext)
  {
    super(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    setLayoutParams(localLayoutParams);
    setScrollContainer(1);
    setBackgroundResource(2130837989);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt4 == 0)
      return;
    int i = 0;
    while (true)
    {
      View localView2;
      View localView1;
      try
      {
        ViewGroup localViewGroup = (ViewGroup)getChildAt(i);
        localView2 = localViewGroup.getChildAt(0);
        localView1 = localViewGroup.getChildAt(1);
        if (paramInt2 > paramInt4)
        {
          localView2.setVisibility(0);
          localView1.setVisibility(0);
          requestLayout();
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      localView2.setVisibility(8);
      localView1.setVisibility(8);
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     nk
 * JD-Core Version:    0.6.0
 */