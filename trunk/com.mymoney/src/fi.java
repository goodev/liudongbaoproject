import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public class fi extends fk
{
  private static final byte[] e = { 31, 139, 8, 0, 0, 0, 0, 0 };
  private static final byte[] f = { 0, 0 };
  protected CRC32 a;

  public fi(OutputStream paramOutputStream)
  {
    this(paramOutputStream, 512);
  }

  public fi(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream, localDeflater, paramInt);
    CRC32 localCRC32 = new CRC32();
    this.a = localCRC32;
    this.d = 1;
    c();
    this.a.reset();
  }

  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt1 & 0xFFFF;
    b(i, paramArrayOfByte, paramInt2);
    int j = paramInt1 >> 16 & 0xFFFF;
    int k = paramInt2 + 2;
    b(j, paramArrayOfByte, k);
  }

  public static void a(OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = e;
    paramOutputStream.write(arrayOfByte);
  }

  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (int)this.a.getValue();
    a(i, paramArrayOfByte, paramInt);
    int j = this.b.getTotalIn();
    int k = paramInt + 4;
    a(j, paramArrayOfByte, k);
  }

  private void b(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = (byte)(paramInt1 & 0xFF);
    paramArrayOfByte[paramInt2] = i;
    int j = paramInt2 + 1;
    int k = (byte)(paramInt1 >> 8 & 0xFF);
    paramArrayOfByte[j] = k;
  }

  private void c()
  {
    OutputStream localOutputStream = this.out;
    byte[] arrayOfByte = f;
    localOutputStream.write(arrayOfByte);
  }

  public void a()
  {
    if (this.b.finished())
      return;
    this.b.finish();
    while (!this.b.finished())
    {
      Deflater localDeflater = this.b;
      byte[] arrayOfByte1 = this.c;
      int i = this.c.length;
      int j = localDeflater.deflate(arrayOfByte1, 0, i);
      if (this.b.finished())
      {
        int k = this.c.length - 8;
        if (j <= k)
        {
          byte[] arrayOfByte2 = this.c;
          a(arrayOfByte2, j);
          int m = j + 8;
          OutputStream localOutputStream1 = this.out;
          byte[] arrayOfByte3 = this.c;
          localOutputStream1.write(arrayOfByte3, 0, m);
          return;
        }
      }
      if (j <= 0)
        continue;
      OutputStream localOutputStream2 = this.out;
      byte[] arrayOfByte4 = this.c;
      localOutputStream2.write(arrayOfByte4, 0, j);
    }
    byte[] arrayOfByte5 = new byte[8];
    a(arrayOfByte5, 0);
    this.out.write(arrayOfByte5);
  }

  /** @deprecated */
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    monitorenter;
    try
    {
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      this.a.update(paramArrayOfByte, paramInt1, paramInt2);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fi
 * JD-Core Version:    0.6.0
 */