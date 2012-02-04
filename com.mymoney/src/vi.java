import com.mymoney.ui.widget.wheelview.WheelView;

public class vi
  implements vh
{
  public vi(WheelView paramWheelView)
  {
  }

  public void a()
  {
    boolean bool = WheelView.a(this.a, 1);
    this.a.b();
  }

  public void a(int paramInt)
  {
    WheelView.a(this.a, paramInt);
    int i = this.a.getHeight();
    if (WheelView.a(this.a) > i)
    {
      int j = WheelView.b(this.a, i);
      WheelView.b(this.a).a();
      return;
    }
    int k = WheelView.a(this.a);
    int m = -i;
    if (k >= m)
      return;
    WheelView localWheelView = this.a;
    int n = -i;
    int i1 = WheelView.b(localWheelView, n);
    WheelView.b(this.a).a();
  }

  public void b()
  {
    if (WheelView.c(this.a))
    {
      this.a.c();
      boolean bool = WheelView.a(this.a, 0);
    }
    int i = WheelView.b(this.a, 0);
    this.a.invalidate();
  }

  public void c()
  {
    if (Math.abs(WheelView.a(this.a)) <= 1)
      return;
    ve localve = WheelView.b(this.a);
    int i = WheelView.a(this.a);
    localve.a(i, 0);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vi
 * JD-Core Version:    0.6.0
 */