import android.os.Handler;
import android.os.Message;
import org.achartengine.chart.AnimationPieChartForMymoney;

public class vt extends Handler
{
  public vt(AnimationPieChartForMymoney paramAnimationPieChartForMymoney)
  {
  }

  public void a()
  {
    removeMessages(0);
    Message localMessage = obtainMessage(0);
    boolean bool = super.sendMessage(localMessage);
  }

  public void handleMessage(Message paramMessage)
  {
    vu localvu1 = AnimationPieChartForMymoney.a(this.a);
    vu localvu2 = vu.a;
    if (localvu1 == localvu2)
    {
      AnimationPieChartForMymoney.b(this.a);
      this.a.invalidate();
      return;
    }
    vu localvu3 = AnimationPieChartForMymoney.a(this.a);
    vu localvu4 = vu.b;
    if (localvu3 == localvu4)
    {
      AnimationPieChartForMymoney.b(this.a);
      this.a.invalidate();
      return;
    }
    vu localvu5 = AnimationPieChartForMymoney.a(this.a);
    vu localvu6 = vu.c;
    if (localvu5 == localvu6)
    {
      this.a.invalidate();
      return;
    }
    vu localvu7 = AnimationPieChartForMymoney.a(this.a);
    vu localvu8 = vu.d;
    if (localvu7 != localvu8)
      return;
    AnimationPieChartForMymoney.b(this.a);
    this.a.invalidate();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vt
 * JD-Core Version:    0.6.0
 */