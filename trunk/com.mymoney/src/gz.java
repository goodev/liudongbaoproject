import dalvik.system.VMRuntime;

public class gz
{
  public static void a()
  {
    System.gc();
    System.gc();
    System.gc();
  }

  public static void b()
  {
    long l = VMRuntime.getRuntime().setMinimumHeapSize(5242880L);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gz
 * JD-Core Version:    0.6.0
 */