import android.os.Handler;
import android.os.Message;
import android.widget.Scroller;

class vg extends Handler
{
  vg(ve paramve)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    boolean bool1 = ve.b(this.a).computeScrollOffset();
    int i = ve.b(this.a).getCurrY();
    int j = ve.a(this.a) - i;
    int k = ve.a(this.a, i);
    if (j != 0)
      ve.c(this.a).a(j);
    int m = ve.b(this.a).getFinalY();
    if (Math.abs(i - m) < 1)
    {
      int n = ve.b(this.a).getFinalY();
      ve.b(this.a).forceFinished(1);
    }
    if (!ve.b(this.a).isFinished())
    {
      Handler localHandler = ve.d(this.a);
      int i1 = paramMessage.what;
      boolean bool2 = localHandler.sendEmptyMessage(i1);
      return;
    }
    if (paramMessage.what == 0)
    {
      ve.e(this.a);
      return;
    }
    this.a.b();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vg
 * JD-Core Version:    0.6.0
 */