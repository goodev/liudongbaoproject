import android.widget.Button;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;

public class hx
  implements Runnable
{
  public hx(AddOrEditTransNewActivity paramAddOrEditTransNewActivity)
  {
  }

  public void run()
  {
    if (AddOrEditTransNewActivity.b(this.a))
      boolean bool = AddOrEditTransNewActivity.c(this.a).performClick();
    AddOrEditTransNewActivity.d(this.a);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hx
 * JD-Core Version:    0.6.0
 */