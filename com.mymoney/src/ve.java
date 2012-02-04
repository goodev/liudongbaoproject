import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

public class ve
{
  private vh a;
  private Context b;
  private GestureDetector c;
  private Scroller d;
  private int e;
  private float f;
  private boolean g;
  private GestureDetector.SimpleOnGestureListener h;
  private final int i;
  private final int j;
  private Handler k;

  public ve(Context paramContext, vh paramvh)
  {
    vf localvf = new vf(this);
    this.h = localvf;
    this.i = 0;
    this.j = 1;
    vg localvg = new vg(this);
    this.k = localvg;
    GestureDetector.SimpleOnGestureListener localSimpleOnGestureListener = this.h;
    GestureDetector localGestureDetector = new GestureDetector(paramContext, localSimpleOnGestureListener);
    this.c = localGestureDetector;
    this.c.setIsLongpressEnabled(0);
    Scroller localScroller = new Scroller(paramContext);
    this.d = localScroller;
    this.a = paramvh;
    this.b = paramContext;
  }

  private void a(int paramInt)
  {
    c();
    boolean bool = this.k.sendEmptyMessage(paramInt);
  }

  private void c()
  {
    this.k.removeMessages(0);
    this.k.removeMessages(1);
  }

  private void d()
  {
    this.a.c();
    a(1);
  }

  private void e()
  {
    if (this.g)
      return;
    this.g = 1;
    this.a.a();
  }

  public void a()
  {
    this.d.forceFinished(1);
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.d.forceFinished(1);
    this.e = 0;
    Scroller localScroller = this.d;
    if (paramInt2 != 0);
    for (int m = paramInt2; ; m = 400)
    {
      int n = 0;
      int i1 = 0;
      int i2 = paramInt1;
      localScroller.startScroll(0, n, i1, i2, m);
      a(0);
      e();
      return;
    }
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 1:
    default:
    case 0:
    case 2:
    }
    while (true)
    {
      if ((!this.c.onTouchEvent(paramMotionEvent)) && (paramMotionEvent.getAction() == 1))
        d();
      return true;
      float f1 = paramMotionEvent.getY();
      this.f = f1;
      this.d.forceFinished(1);
      c();
      continue;
      float f2 = paramMotionEvent.getY();
      float f3 = this.f;
      int m = (int)(f2 - f3);
      if (m == 0)
        continue;
      e();
      this.a.a(m);
      float f4 = paramMotionEvent.getY();
      this.f = f4;
    }
  }

  void b()
  {
    if (!this.g)
      return;
    this.a.b();
    this.g = 0;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ve
 * JD-Core Version:    0.6.0
 */