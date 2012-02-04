import android.os.Handler;

public abstract class dx
{
  Handler a;
  private Object b;

  public dx(Handler paramHandler)
  {
    Object localObject = new Object();
    this.b = localObject;
    this.a = paramHandler;
  }

  protected void a()
  {
  }

  public final void b()
  {
    if (this.a == null)
    {
      a();
      return;
    }
    Handler localHandler = this.a;
    dy localdy = new dy(this);
    boolean bool = localHandler.post(localdy);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     dx
 * JD-Core Version:    0.6.0
 */