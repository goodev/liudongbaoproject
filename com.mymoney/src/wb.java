import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class wb
{
  public static int a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = b(paramInputStream, paramOutputStream);
    if (l > 2147483647L);
    for (int i = -1; ; i = (int)l)
      return i;
  }

  public static void a(InputStream paramInputStream)
  {
    if (paramInputStream == null)
      return;
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null)
      return;
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public static long b(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    long l1 = 0L;
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (-1 == i)
        break;
      paramOutputStream.write(arrayOfByte, 0, i);
      long l2 = i;
      l1 += l2;
    }
    return l1;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wb
 * JD-Core Version:    0.6.0
 */