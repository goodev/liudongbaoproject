import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.mymoney.ui.addtrans.ImageViewTouch;
import com.mymoney.ui.addtrans.TransactionPhotoEditActivity;

public class jp extends GestureDetector.SimpleOnGestureListener
{
  private jp(TransactionPhotoEditActivity paramTransactionPhotoEditActivity)
  {
  }

  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    int i;
    if (this.a.c)
    {
      i = 0;
      return i;
    }
    if (TransactionPhotoEditActivity.e(this.a).b() > 2.0F)
      TransactionPhotoEditActivity.e(this.a).a(1.0F);
    while (true)
    {
      i = 1;
      break;
      ImageViewTouch localImageViewTouch = TransactionPhotoEditActivity.e(this.a);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      localImageViewTouch.b(3.0F, f1, f2);
    }
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.a.c);
    for (int i = 0; ; i = 1)
    {
      return i;
      ImageViewTouch localImageViewTouch = TransactionPhotoEditActivity.e(this.a);
      if (localImageViewTouch.b() <= 1.0F)
        continue;
      float f1 = -paramFloat1;
      float f2 = -paramFloat2;
      localImageViewTouch.a(f1, f2);
    }
  }

  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.a.c);
    for (int i = 0; ; i = 1)
    {
      return i;
      TransactionPhotoEditActivity.f(this.a);
      this.a.a();
      TransactionPhotoEditActivity.c(this.a);
    }
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.a.c);
    for (int i = 0; ; i = 1)
      return i;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     jp
 * JD-Core Version:    0.6.0
 */