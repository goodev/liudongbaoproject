import java.util.zip.ZipException;

public final class wl
  implements wo
{
  private static final wv a = new wv(51966);
  private static final wv b = new wv(0);
  private static final byte[] c = new byte[0];
  private static final wl d = new wl();

  public wv a()
  {
    return a;
  }

  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      return;
    throw new ZipException("JarMarker doesn't expect any data");
  }

  public wv b()
  {
    return b;
  }

  public wv c()
  {
    return b;
  }

  public byte[] d()
  {
    return c;
  }

  public byte[] e()
  {
    return c;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wl
 * JD-Core Version:    0.6.0
 */