import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;

public class fk extends FilterOutputStream
{
  private boolean a = 0;
  protected Deflater b;
  protected byte[] c;
  boolean d = 0;

  public fk(OutputStream paramOutputStream)
  {
    this(paramOutputStream, localDeflater);
    this.d = 1;
  }

  public fk(OutputStream paramOutputStream, Deflater paramDeflater)
  {
    this(paramOutputStream, paramDeflater, 512);
  }

  public fk(OutputStream paramOutputStream, Deflater paramDeflater, int paramInt)
  {
    super(paramOutputStream);
    if ((paramOutputStream == null) || (paramDeflater == null))
      throw new NullPointerException();
    if (paramInt <= 0)
      throw new IllegalArgumentException("buffer size <= 0");
    this.b = paramDeflater;
    byte[] arrayOfByte = new byte[paramInt];
    this.c = arrayOfByte;
  }

  public void a()
  {
    if (this.b.finished())
      return;
    this.b.finish();
    while (true)
    {
      if (this.b.finished())
        return;
      b();
    }
  }

  protected void b()
  {
    Deflater localDeflater = this.b;
    byte[] arrayOfByte1 = this.c;
    int i = this.c.length;
    int j = localDeflater.deflate(arrayOfByte1, 0, i);
    if (j <= 0)
      return;
    OutputStream localOutputStream = this.out;
    byte[] arrayOfByte2 = this.c;
    localOutputStream.write(arrayOfByte2, 0, j);
  }

  public void close()
  {
    if (this.a)
      return;
    a();
    if (this.d)
      this.b.end();
    this.out.close();
    this.a = 1;
  }

  public void write(int paramInt)
  {
    byte[] arrayOfByte = new byte[1];
    int i = (byte)(paramInt & 0xFF);
    arrayOfByte[0] = i;
    write(arrayOfByte, 0, 1);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.b.finished())
      throw new IOException("write beyond end of stream");
    int i = paramInt1 | paramInt2;
    int j = paramInt1 + paramInt2;
    int k = i | j;
    int m = paramArrayOfByte.length;
    int n = paramInt1 + paramInt2;
    int i1 = m - n;
    if ((k | i1) < 0)
      throw new IndexOutOfBoundsException();
    if (paramInt2 == 0)
      return;
    if (this.b.finished())
      return;
    int i2 = this.c.length;
    int i3 = 0;
    while (true)
    {
      if (i3 >= paramInt2)
        return;
      Deflater localDeflater = this.b;
      int i4 = paramInt1 + i3;
      int i5 = paramInt2 - i3;
      int i6 = Math.min(i2, i5);
      localDeflater.setInput(paramArrayOfByte, i4, i6);
      while (!this.b.needsInput())
        b();
      i3 += i2;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fk
 * JD-Core Version:    0.6.0
 */