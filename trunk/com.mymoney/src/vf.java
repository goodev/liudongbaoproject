import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

class vf extends GestureDetector.SimpleOnGestureListener
{
  vf(ve paramve)
  {
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i = ve.a(this.a, 0);
    Scroller localScroller = ve.b(this.a);
    int j = ve.a(this.a);
    int k = (int)(-paramFloat2);
    int m = 0;
    int n = 0;
    int i1 = 0;
    localScroller.fling(0, j, m, k, n, i1, -2147483647, 2147483647);
    ve.b(this.a, 0);
    return true;
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vf
 * JD-Core Version:    0.6.0
 */