import java.util.Vector;
import java.util.zip.ZipEntry;

public class wn extends ZipEntry
  implements Cloneable
{
  private int a = 0;
  private int b = 0;
  private long c = 0L;
  private Vector d = null;
  private String e = null;

  protected wn()
  {
    super("");
  }

  public wn(String paramString)
  {
    super(paramString);
  }

  public wn(ZipEntry paramZipEntry)
  {
    super(paramZipEntry);
    byte[] arrayOfByte = paramZipEntry.getExtra();
    if (arrayOfByte != null)
    {
      wo[] arrayOfwo = wk.a(arrayOfByte);
      a(arrayOfwo);
      return;
    }
    e();
  }

  public int a()
  {
    return this.a;
  }

  public void a(int paramInt)
  {
    this.a = paramInt;
  }

  public void a(long paramLong)
  {
    this.c = paramLong;
  }

  protected void a(String paramString)
  {
    this.e = paramString;
  }

  public void a(wo[] paramArrayOfwo)
  {
    Vector localVector1 = new Vector();
    this.d = localVector1;
    int i = 0;
    while (true)
    {
      int j = paramArrayOfwo.length;
      if (i >= j)
        break;
      Vector localVector2 = this.d;
      wo localwo = paramArrayOfwo[i];
      localVector2.addElement(localwo);
      i += 1;
    }
    e();
  }

  public long b()
  {
    return this.c;
  }

  protected void b(int paramInt)
  {
    this.b = paramInt;
  }

  public int c()
  {
    return this.b;
  }

  public Object clone()
  {
    wn localwn = (wn)super.clone();
    if (this.d != null);
    for (Vector localVector = (Vector)this.d.clone(); ; localVector = null)
    {
      localwn.d = localVector;
      int i = a();
      localwn.a(i);
      long l = b();
      localwn.a(l);
      wo[] arrayOfwo = d();
      localwn.a(arrayOfwo);
      return localwn;
    }
  }

  public wo[] d()
  {
    wo[] arrayOfwo;
    if (this.d == null)
      arrayOfwo = new wo[0];
    while (true)
    {
      return arrayOfwo;
      arrayOfwo = new wo[this.d.size()];
      this.d.copyInto(arrayOfwo);
    }
  }

  protected void e()
  {
    byte[] arrayOfByte = wk.a(d());
    super.setExtra(arrayOfByte);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    for (int i = 1; ; i = 0)
      return i;
  }

  public byte[] f()
  {
    byte[] arrayOfByte = getExtra();
    if (arrayOfByte != null);
    while (true)
    {
      return arrayOfByte;
      arrayOfByte = new byte[0];
    }
  }

  public byte[] g()
  {
    return wk.b(d());
  }

  public String getName()
  {
    if (this.e == null);
    for (String str = super.getName(); ; str = this.e)
      return str;
  }

  public int hashCode()
  {
    return getName().hashCode();
  }

  public boolean isDirectory()
  {
    return getName().endsWith("/");
  }

  public void setExtra(byte[] paramArrayOfByte)
  {
    String str;
    try
    {
      wo[] arrayOfwo = wk.a(paramArrayOfByte);
      a(arrayOfwo);
      return;
    }
    catch (Exception localException)
    {
      str = localException.getMessage();
    }
    throw new RuntimeException(str);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wn
 * JD-Core Version:    0.6.0
 */