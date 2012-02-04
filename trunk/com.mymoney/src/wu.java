import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.ZipException;

public class wu extends FilterOutputStream
{
  protected static final byte[] c;
  protected static final byte[] d;
  protected static final byte[] e;
  protected static final byte[] f;
  private static final byte[] s = { 0, 0 };
  private static final byte[] t = { 0, 0, 0, 0 };
  private static final byte[] x;
  protected Deflater a;
  protected byte[] b;
  private wn g;
  private String h = "";
  private int i = -1;
  private boolean j = 0;
  private int k = 8;
  private Vector l;
  private CRC32 m;
  private long n;
  private long o;
  private long p;
  private long q;
  private long r;
  private Hashtable u;
  private String v;
  private RandomAccessFile w;

  static
  {
    c = wt.a(67324752L);
    d = wt.a(134695760L);
    e = wt.a(33639248L);
    f = wt.a(101010256L);
    x = wt.a(8448L);
  }

  public wu(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
    Vector localVector = new Vector();
    this.l = localVector;
    CRC32 localCRC32 = new CRC32();
    this.m = localCRC32;
    this.n = 0L;
    this.o = 0L;
    this.p = 0L;
    this.q = 0L;
    this.r = 0L;
    Hashtable localHashtable = new Hashtable();
    this.u = localHashtable;
    this.v = null;
    int i1 = this.i;
    Deflater localDeflater = new Deflater(i1, 1);
    this.a = localDeflater;
    byte[] arrayOfByte = new byte[512];
    this.b = arrayOfByte;
    this.w = null;
  }

  protected static long a(int paramInt)
  {
    long l2;
    if (paramInt < 0)
    {
      long l1 = paramInt;
      l2 = 4294967296L + l1;
    }
    while (true)
    {
      return l2;
      l2 = paramInt;
    }
  }

  protected static byte[] a(long paramLong)
  {
    Object localObject = new Date(paramLong);
    int i1 = ((Date)localObject).getYear() + 1900;
    if (i1 < 1980);
    int i11;
    for (localObject = x; ; localObject = wt.a(((Date)localObject).getSeconds() >> 1 | i11))
    {
      return localObject;
      int i2 = ((Date)localObject).getMonth() + 1;
      int i3 = i1 - 1980 << 25;
      int i4 = i2 << 21;
      int i5 = i3 | i4;
      int i6 = ((Date)localObject).getDate() << 16;
      int i7 = i5 | i6;
      int i8 = ((Date)localObject).getHours() << 11;
      int i9 = i7 | i8;
      int i10 = ((Date)localObject).getMinutes() << 5;
      i11 = i9 | i10;
    }
  }

  public void a()
  {
    b();
    long l1 = this.n;
    this.q = l1;
    int i1 = this.l.size();
    int i2 = 0;
    while (i2 < i1)
    {
      wn localwn = (wn)this.l.elementAt(i2);
      d(localwn);
      i2 += 1;
    }
    long l2 = this.n;
    long l3 = this.q;
    long l4 = l2 - l3;
    this.r = l4;
    d();
    this.u.clear();
    this.l.removeAllElements();
  }

  public void a(String paramString)
  {
    this.h = paramString;
  }

  public void a(wn paramwn)
  {
    b();
    this.g = paramwn;
    Vector localVector = this.l;
    wn localwn1 = this.g;
    localVector.addElement(localwn1);
    if (this.g.getMethod() == -1)
    {
      wn localwn2 = this.g;
      int i1 = this.k;
      localwn2.setMethod(i1);
    }
    if (this.g.getTime() == 65535L)
    {
      wn localwn3 = this.g;
      long l1 = System.currentTimeMillis();
      localwn3.setTime(l1);
    }
    if ((this.g.getMethod() == 0) && (this.w == null))
    {
      if (this.g.getSize() == 65535L)
        throw new ZipException("uncompressed size is required for STORED method when not writing to a file");
      if (this.g.getCrc() == 65535L)
        throw new ZipException("crc checksum is required for STORED method when not writing to a file");
      wn localwn4 = this.g;
      long l2 = this.g.getSize();
      localwn4.setCompressedSize(l2);
    }
    if ((this.g.getMethod() == 8) && (this.j))
    {
      Deflater localDeflater = this.a;
      int i2 = this.i;
      localDeflater.setLevel(i2);
      this.j = 0;
    }
    wn localwn5 = this.g;
    b(localwn5);
  }

  protected final void a(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    a(paramArrayOfByte, 0, i1);
  }

  protected final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.w != null)
    {
      this.w.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
  }

  public void b()
  {
    if (this.g == null)
      return;
    long l1 = this.m.getValue();
    this.m.reset();
    if (this.g.getMethod() == 8)
    {
      this.a.finish();
      while (!this.a.finished())
        c();
      wn localwn1 = this.g;
      long l2 = a(this.a.getTotalIn());
      localwn1.setSize(l2);
      wn localwn2 = this.g;
      long l3 = a(this.a.getTotalOut());
      localwn2.setCompressedSize(l3);
      this.g.setCrc(l1);
      this.a.reset();
      long l4 = this.n;
      long l5 = this.g.getCompressedSize();
      long l6 = l4 + l5;
      this.n = l6;
    }
    while (true)
    {
      if (this.w != null)
      {
        long l7 = this.w.getFilePointer();
        RandomAccessFile localRandomAccessFile = this.w;
        long l8 = this.p;
        localRandomAccessFile.seek(l8);
        byte[] arrayOfByte1 = wt.a(this.g.getCrc());
        a(arrayOfByte1);
        byte[] arrayOfByte2 = wt.a(this.g.getCompressedSize());
        a(arrayOfByte2);
        byte[] arrayOfByte3 = wt.a(this.g.getSize());
        a(arrayOfByte3);
        this.w.seek(l7);
      }
      wn localwn3 = this.g;
      c(localwn3);
      this.g = null;
      return;
      if (this.w == null)
      {
        if (this.g.getCrc() != l1)
        {
          StringBuilder localStringBuilder1 = new StringBuilder().append("bad CRC checksum for entry ");
          String str1 = this.g.getName();
          StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(": ");
          String str2 = Long.toHexString(this.g.getCrc());
          StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(" instead of ");
          String str3 = Long.toHexString(l1);
          String str4 = str3;
          throw new ZipException(str4);
        }
        long l9 = this.g.getSize();
        long l10 = this.n;
        long l11 = this.o;
        long l12 = l10 - l11;
        if (l9 == l12)
          continue;
        StringBuilder localStringBuilder4 = new StringBuilder().append("bad size for entry ");
        String str5 = this.g.getName();
        StringBuilder localStringBuilder5 = localStringBuilder4.append(str5).append(": ");
        long l13 = this.g.getSize();
        StringBuilder localStringBuilder6 = localStringBuilder5.append(l13).append(" instead of ");
        long l14 = this.n;
        long l15 = this.o;
        long l16 = l14 - l15;
        String str6 = l16;
        throw new ZipException(str6);
      }
      long l17 = this.n;
      long l18 = this.o;
      long l19 = l17 - l18;
      this.g.setSize(l19);
      this.g.setCompressedSize(l19);
      this.g.setCrc(l1);
    }
  }

  protected void b(wn paramwn)
  {
    Hashtable localHashtable = this.u;
    byte[] arrayOfByte1 = wt.a(this.n);
    Object localObject = localHashtable.put(paramwn, arrayOfByte1);
    byte[] arrayOfByte2 = c;
    a(arrayOfByte2);
    long l1 = this.n + 4L;
    this.n = l1;
    int i1 = paramwn.getMethod();
    if ((i1 == 8) && (this.w == null))
    {
      byte[] arrayOfByte3 = wv.a(20);
      a(arrayOfByte3);
      byte[] arrayOfByte4 = wv.a(8);
      a(arrayOfByte4);
      long l2 = this.n + 4L;
      this.n = l2;
      byte[] arrayOfByte5 = wv.a(i1);
      a(arrayOfByte5);
      long l3 = this.n + 2L;
      this.n = l3;
      byte[] arrayOfByte6 = a(paramwn.getTime());
      a(arrayOfByte6);
      long l4 = this.n + 4L;
      this.n = l4;
      long l5 = this.n;
      this.p = l5;
      if ((i1 != 8) && (this.w == null))
        break label423;
      byte[] arrayOfByte7 = t;
      a(arrayOfByte7);
      byte[] arrayOfByte8 = t;
      a(arrayOfByte8);
      byte[] arrayOfByte9 = t;
      a(arrayOfByte9);
    }
    while (true)
    {
      long l6 = this.n + 12L;
      this.n = l6;
      String str = paramwn.getName();
      byte[] arrayOfByte10 = b(str);
      byte[] arrayOfByte11 = wv.a(arrayOfByte10.length);
      a(arrayOfByte11);
      long l7 = this.n + 2L;
      this.n = l7;
      byte[] arrayOfByte12 = paramwn.f();
      byte[] arrayOfByte13 = wv.a(arrayOfByte12.length);
      a(arrayOfByte13);
      long l8 = this.n + 2L;
      this.n = l8;
      a(arrayOfByte10);
      long l9 = this.n;
      long l10 = arrayOfByte10.length;
      long l11 = l9 + l10;
      this.n = l11;
      a(arrayOfByte12);
      long l12 = this.n;
      long l13 = arrayOfByte12.length + l12;
      this.n = l13;
      long l14 = this.n;
      this.o = l14;
      return;
      byte[] arrayOfByte14 = wv.a(10);
      a(arrayOfByte14);
      byte[] arrayOfByte15 = s;
      a(arrayOfByte15);
      break;
      label423: byte[] arrayOfByte16 = wt.a(paramwn.getCrc());
      a(arrayOfByte16);
      byte[] arrayOfByte17 = wt.a(paramwn.getSize());
      a(arrayOfByte17);
      byte[] arrayOfByte18 = wt.a(paramwn.getSize());
      a(arrayOfByte18);
    }
  }

  protected byte[] b(String paramString)
  {
    Object localObject;
    if (this.v == null)
      localObject = paramString.getBytes();
    String str2;
    while (true)
    {
      return localObject;
      try
      {
        String str1 = this.v;
        byte[] arrayOfByte = paramString.getBytes(str1);
        localObject = arrayOfByte;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        str2 = localUnsupportedEncodingException.getMessage();
      }
    }
    throw new ZipException(str2);
  }

  protected final void c()
  {
    Deflater localDeflater = this.a;
    byte[] arrayOfByte1 = this.b;
    int i1 = this.b.length;
    int i2 = localDeflater.deflate(arrayOfByte1, 0, i1);
    if (i2 <= 0)
      return;
    byte[] arrayOfByte2 = this.b;
    a(arrayOfByte2, 0, i2);
  }

  protected void c(wn paramwn)
  {
    if (paramwn.getMethod() != 8)
      return;
    if (this.w != null)
      return;
    byte[] arrayOfByte1 = d;
    a(arrayOfByte1);
    byte[] arrayOfByte2 = wt.a(this.g.getCrc());
    a(arrayOfByte2);
    byte[] arrayOfByte3 = wt.a(this.g.getCompressedSize());
    a(arrayOfByte3);
    byte[] arrayOfByte4 = wt.a(this.g.getSize());
    a(arrayOfByte4);
    long l1 = this.n + 16L;
    this.n = l1;
  }

  public void close()
  {
    a();
    if (this.w != null)
      this.w.close();
    if (this.out == null)
      return;
    this.out.close();
  }

  protected void d()
  {
    byte[] arrayOfByte1 = f;
    a(arrayOfByte1);
    byte[] arrayOfByte2 = s;
    a(arrayOfByte2);
    byte[] arrayOfByte3 = s;
    a(arrayOfByte3);
    byte[] arrayOfByte4 = wv.a(this.l.size());
    a(arrayOfByte4);
    a(arrayOfByte4);
    byte[] arrayOfByte5 = wt.a(this.r);
    a(arrayOfByte5);
    byte[] arrayOfByte6 = wt.a(this.q);
    a(arrayOfByte6);
    String str = this.h;
    byte[] arrayOfByte7 = b(str);
    byte[] arrayOfByte8 = wv.a(arrayOfByte7.length);
    a(arrayOfByte8);
    a(arrayOfByte7);
  }

  protected void d(wn paramwn)
  {
    byte[] arrayOfByte1 = e;
    a(arrayOfByte1);
    long l1 = this.n + 4L;
    this.n = l1;
    byte[] arrayOfByte2 = wv.a(paramwn.c() << 8 | 0x14);
    a(arrayOfByte2);
    long l2 = this.n + 2L;
    this.n = l2;
    if ((paramwn.getMethod() == 8) && (this.w == null))
    {
      byte[] arrayOfByte3 = wv.a(20);
      a(arrayOfByte3);
      byte[] arrayOfByte4 = wv.a(8);
      a(arrayOfByte4);
    }
    while (true)
    {
      long l3 = this.n + 4L;
      this.n = l3;
      byte[] arrayOfByte5 = wv.a(paramwn.getMethod());
      a(arrayOfByte5);
      long l4 = this.n + 2L;
      this.n = l4;
      byte[] arrayOfByte6 = a(paramwn.getTime());
      a(arrayOfByte6);
      long l5 = this.n + 4L;
      this.n = l5;
      byte[] arrayOfByte7 = wt.a(paramwn.getCrc());
      a(arrayOfByte7);
      byte[] arrayOfByte8 = wt.a(paramwn.getCompressedSize());
      a(arrayOfByte8);
      byte[] arrayOfByte9 = wt.a(paramwn.getSize());
      a(arrayOfByte9);
      long l6 = this.n + 12L;
      this.n = l6;
      String str1 = paramwn.getName();
      byte[] arrayOfByte10 = b(str1);
      byte[] arrayOfByte11 = wv.a(arrayOfByte10.length);
      a(arrayOfByte11);
      long l7 = this.n + 2L;
      this.n = l7;
      byte[] arrayOfByte12 = paramwn.g();
      byte[] arrayOfByte13 = wv.a(arrayOfByte12.length);
      a(arrayOfByte13);
      long l8 = this.n + 2L;
      this.n = l8;
      String str2 = paramwn.getComment();
      if (str2 == null)
        str2 = "";
      byte[] arrayOfByte14 = b(str2);
      byte[] arrayOfByte15 = wv.a(arrayOfByte14.length);
      a(arrayOfByte15);
      long l9 = this.n + 2L;
      this.n = l9;
      byte[] arrayOfByte16 = s;
      a(arrayOfByte16);
      long l10 = this.n + 2L;
      this.n = l10;
      byte[] arrayOfByte17 = wv.a(paramwn.a());
      a(arrayOfByte17);
      long l11 = this.n + 2L;
      this.n = l11;
      byte[] arrayOfByte18 = wt.a(paramwn.b());
      a(arrayOfByte18);
      long l12 = this.n + 4L;
      this.n = l12;
      byte[] arrayOfByte19 = (byte[])(byte[])this.u.get(paramwn);
      a(arrayOfByte19);
      long l13 = this.n + 4L;
      this.n = l13;
      a(arrayOfByte10);
      long l14 = this.n;
      long l15 = arrayOfByte10.length + l14;
      this.n = l15;
      a(arrayOfByte12);
      long l16 = this.n;
      long l17 = arrayOfByte12.length;
      long l18 = l16 + l17;
      this.n = l18;
      a(arrayOfByte14);
      long l19 = this.n;
      long l20 = arrayOfByte14.length;
      long l21 = l19 + l20;
      this.n = l21;
      return;
      byte[] arrayOfByte20 = wv.a(10);
      a(arrayOfByte20);
      byte[] arrayOfByte21 = s;
      a(arrayOfByte21);
    }
  }

  public void flush()
  {
    if (this.out == null)
      return;
    this.out.flush();
  }

  public void write(int paramInt)
  {
    byte[] arrayOfByte = new byte[1];
    int i1 = (byte)(paramInt & 0xFF);
    arrayOfByte[0] = i1;
    write(arrayOfByte, 0, 1);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.g.getMethod() == 8)
    {
      if ((paramInt2 > 0) && (!this.a.finished()))
      {
        this.a.setInput(paramArrayOfByte, paramInt1, paramInt2);
        while (!this.a.needsInput())
          c();
      }
    }
    else
    {
      a(paramArrayOfByte, paramInt1, paramInt2);
      long l1 = this.n;
      long l2 = paramInt2;
      long l3 = l1 + l2;
      this.n = l3;
    }
    this.m.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wu
 * JD-Core Version:    0.6.0
 */