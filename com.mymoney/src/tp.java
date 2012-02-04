import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.mymoney.ui.widget.Panel;

public class tp
  implements GestureDetector.OnGestureListener
{
  float a;
  float b;

  public tp(Panel paramPanel)
  {
  }

  public void a(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1;
    this.b = f1;
    float f2 = paramInt2;
    this.a = f2;
  }

  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.a = 0.0F;
    this.b = 0.0F;
    boolean bool = this.c.b();
    return true;
  }

  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    Panel localPanel1 = this.c;
    tq localtq1 = tq.e;
    tq localtq2 = Panel.a(localPanel1, localtq1);
    Panel localPanel2 = this.c;
    float f1;
    if (Panel.d(this.c) == 1)
      f1 = paramFloat2;
    while (true)
    {
      float f2 = Panel.c(localPanel2, f1);
      Panel localPanel3 = this.c;
      Runnable localRunnable = this.c.c;
      boolean bool = localPanel3.post(localRunnable);
      return true;
      f1 = paramFloat1;
    }
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    Panel localPanel1 = this.c;
    tq localtq1 = tq.d;
    tq localtq2 = Panel.a(localPanel1, localtq1);
    float f3;
    float f4;
    if (Panel.d(this.c) == 1)
    {
      float f1 = this.a - paramFloat2;
      this.a = f1;
      if (Panel.e(this.c) == 0)
      {
        Panel localPanel2 = this.c;
        float f2 = this.a;
        int i = -Panel.g(this.c);
        f3 = Panel.a(localPanel2, f2, i, 0);
        f4 = 0.0F;
      }
    }
    while (true)
    {
      float f5 = Panel.o(this.c);
      if (f4 == f5)
      {
        float f6 = Panel.l(this.c);
        if (f3 == f6);
      }
      else
      {
        float f7 = Panel.a(this.c, f4);
        float f8 = Panel.b(this.c, f3);
        this.c.invalidate();
      }
      return true;
      Panel localPanel3 = this.c;
      float f9 = this.a;
      int j = Panel.g(this.c);
      f3 = Panel.a(localPanel3, f9, 0, j);
      f4 = 0.0F;
      continue;
      float f10 = this.b - paramFloat1;
      this.b = f10;
      if (Panel.e(this.c) == 2)
      {
        Panel localPanel4 = this.c;
        float f11 = this.b;
        int k = -Panel.f(this.c);
        f4 = Panel.a(localPanel4, f11, k, 0);
        f3 = 0.0F;
        continue;
      }
      Panel localPanel5 = this.c;
      float f12 = this.b;
      int m = Panel.f(this.c);
      f4 = Panel.a(localPanel5, f12, 0, m);
      f3 = 0.0F;
    }
  }

  public void onShowPress(MotionEvent paramMotionEvent)
  {
  }

  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     tp
 * JD-Core Version:    0.6.0
 */