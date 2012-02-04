import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mymoney.ui.addtrans.TransactionPhotoEditActivity;

public class jl
  implements View.OnTouchListener
{
  public jl(TransactionPhotoEditActivity paramTransactionPhotoEditActivity, View.OnTouchListener paramOnTouchListener)
  {
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.a.onTouch(paramView, paramMotionEvent);
    boolean bool2 = this.b.d.onTouchEvent(paramMotionEvent);
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     jl
 * JD-Core Version:    0.6.0
 */