import java.util.zip.CRC32;
import java.util.zip.ZipException;

public class wj
  implements Cloneable, wo
{
  private static final wv a = new wv(30062);
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private String e = "";
  private boolean f = 0;
  private CRC32 g;

  public wj()
  {
    CRC32 localCRC32 = new CRC32();
    this.g = localCRC32;
  }

  public wv a()
  {
    return a;
  }

  public void a(int paramInt)
  {
    int i = b(paramInt);
    this.b = i;
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    int i = this.b;
    int j = b(i);
    this.b = j;
  }

  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = wt.a(paramArrayOfByte, paramInt1);
    byte[] arrayOfByte1 = new byte[paramInt2 - 4];
    int i = paramInt1 + 4;
    int j = paramInt2 - 4;
    System.arraycopy(paramArrayOfByte, i, arrayOfByte1, 0, j);
    this.g.reset();
    this.g.update(arrayOfByte1);
    long l2 = this.g.getValue();
    if (l1 != l2)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("bad CRC checksum ");
      String str1 = Long.toHexString(l1);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(" instead of ");
      String str2 = Long.toHexString(l2);
      String str3 = str2;
      throw new ZipException(str3);
    }
    int k = wv.a(arrayOfByte1, 0);
    byte[] arrayOfByte2 = new byte[(int)wt.a(arrayOfByte1, 2)];
    int m = wv.a(arrayOfByte1, 6);
    this.c = m;
    int n = wv.a(arrayOfByte1, 8);
    this.d = n;
    if (arrayOfByte2.length == 0)
    {
      this.e = "";
      if ((k & 0x4000) == 0)
        break label256;
    }
    label256: int i2;
    for (int i1 = 1; ; i2 = 0)
    {
      a(i1);
      a(k);
      return;
      int i3 = arrayOfByte2.length;
      System.arraycopy(arrayOfByte1, 10, arrayOfByte2, 0, i3);
      String str4 = new String(arrayOfByte2);
      this.e = str4;
      break;
    }
  }

  protected int b(int paramInt)
  {
    int i = 32768;
    if (i())
      i = 40960;
    while (true)
    {
      int j = paramInt & 0xFFF;
      return i | j;
      if (!k())
        continue;
      i = 16384;
    }
  }

  public wv b()
  {
    int i = h().getBytes().length + 14;
    return new wv(i);
  }

  public wv c()
  {
    return b();
  }

  public byte[] d()
  {
    byte[] arrayOfByte1 = new byte[b().b() - 4];
    System.arraycopy(wv.a(j()), 0, arrayOfByte1, 0, 2);
    byte[] arrayOfByte2 = h().getBytes();
    System.arraycopy(wt.a(arrayOfByte2.length), 0, arrayOfByte1, 2, 4);
    System.arraycopy(wv.a(f()), 0, arrayOfByte1, 6, 2);
    System.arraycopy(wv.a(g()), 0, arrayOfByte1, 8, 2);
    int i = arrayOfByte2.length;
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 10, i);
    this.g.reset();
    this.g.update(arrayOfByte1);
    long l = this.g.getValue();
    byte[] arrayOfByte3 = new byte[arrayOfByte1.length + 4];
    System.arraycopy(wt.a(l), 0, arrayOfByte3, 0, 4);
    int j = arrayOfByte1.length;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 4, j);
    return arrayOfByte3;
  }

  public byte[] e()
  {
    return d();
  }

  public int f()
  {
    return this.c;
  }

  public int g()
  {
    return this.d;
  }

  public String h()
  {
    return this.e;
  }

  public boolean i()
  {
    if (h().length() != 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public int j()
  {
    return this.b;
  }

  public boolean k()
  {
    if ((this.f) && (!i()));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wj
 * JD-Core Version:    0.6.0
 */