import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mymoney.ui.addtrans.TransactionPhotoEditActivity;

public class jk
  implements View.OnTouchListener
{
  public jk(TransactionPhotoEditActivity paramTransactionPhotoEditActivity)
  {
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    TransactionPhotoEditActivity.c(this.a);
    return false;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     jk
 * JD-Core Version:    0.6.0
 */