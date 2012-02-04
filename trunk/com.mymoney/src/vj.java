import android.database.DataSetObserver;
import com.mymoney.ui.widget.wheelview.WheelView;

public class vj extends DataSetObserver
{
  public vj(WheelView paramWheelView)
  {
  }

  public void onChanged()
  {
    this.a.b(0);
  }

  public void onInvalidated()
  {
    this.a.b(1);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vj
 * JD-Core Version:    0.6.0
 */