package com.flurry.android;

final class d
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler a;

  d()
  {
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    this.a = localUncaughtExceptionHandler;
  }

  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      FlurryAgent.b().a(paramThrowable);
      if (this.a == null)
        return;
      this.a.uncaughtException(paramThread, paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        int i = Flog.b("FlurryAgent", "", localThrowable);
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.flurry.android.d
 * JD-Core Version:    0.6.0
 */