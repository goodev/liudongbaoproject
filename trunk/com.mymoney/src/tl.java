import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mymoney.ui.widget.Panel;

public class tl
  implements View.OnTouchListener
{
  int a;
  int b;
  boolean c;

  public tl(Panel paramPanel)
  {
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    tq localtq1 = Panel.a(this.d);
    tq localtq2 = tq.b;
    int i;
    if (localtq1 == localtq2)
    {
      i = 0;
      return i;
    }
    int j = paramMotionEvent.getAction();
    int k;
    if (j == 0)
    {
      if (Panel.b(this.d))
        this.d.bringToFront();
      this.a = 0;
      this.b = 0;
      if (Panel.c(this.d).getVisibility() == 8)
      {
        if (Panel.d(this.d) != 1)
          break label171;
        if (Panel.e(this.d) == 0)
        {
          k = -1;
          label103: this.b = k;
        }
      }
      else
      {
        this.c = 1;
      }
    }
    while (true)
    {
      if ((!Panel.i(this.d).onTouchEvent(paramMotionEvent)) && (j == 1))
      {
        Panel localPanel = this.d;
        Runnable localRunnable = this.d.c;
        boolean bool = localPanel.post(localRunnable);
      }
      i = 0;
      break;
      k = 1;
      break label103;
      label171: if (Panel.e(this.d) == 2);
      for (k = -1; ; k = 1)
      {
        this.a = k;
        break;
      }
      if (this.c)
      {
        int m = this.a;
        int n = Panel.f(this.d);
        int i1 = m * n;
        this.a = i1;
        int i2 = this.b;
        int i3 = Panel.g(this.d);
        int i4 = i2 * i3;
        this.b = i4;
        tp localtp = Panel.h(this.d);
        int i5 = this.a;
        int i6 = this.b;
        localtp.a(i5, i6);
        this.c = 0;
        int i7 = -this.a;
        this.a = i7;
        int i8 = -this.b;
        this.b = i8;
      }
      float f1 = this.a;
      float f2 = this.b;
      paramMotionEvent.offsetLocation(f1, f2);
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     tl
 * JD-Core Version:    0.6.0
 */