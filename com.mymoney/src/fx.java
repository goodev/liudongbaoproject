import android.os.Handler;
import android.os.Message;

public class fx
  implements fy
{
  private Handler a;
  private Message b;

  public fx(Handler paramHandler)
  {
    this.a = paramHandler;
  }

  public void a()
  {
    Message localMessage1 = this.a.obtainMessage();
    this.b = localMessage1;
    Message localMessage2 = this.b;
    String str = new String("开始同步操作...");
    localMessage2.obj = str;
    Handler localHandler = this.a;
    Message localMessage3 = this.b;
    boolean bool = localHandler.sendMessage(localMessage3);
  }

  public void a(String paramString)
  {
    Message localMessage1 = this.a.obtainMessage();
    this.b = localMessage1;
    this.b.obj = paramString;
    Handler localHandler = this.a;
    Message localMessage2 = this.b;
    boolean bool = localHandler.sendMessage(localMessage2);
  }

  public void b()
  {
    Message localMessage1 = this.a.obtainMessage();
    this.b = localMessage1;
    Message localMessage2 = this.b;
    String str = new String("同步结束...");
    localMessage2.obj = str;
    Handler localHandler = this.a;
    Message localMessage3 = this.b;
    boolean bool = localHandler.sendMessage(localMessage3);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fx
 * JD-Core Version:    0.6.0
 */