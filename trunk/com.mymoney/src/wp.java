import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

public class wp
{
  private Hashtable a;
  private Hashtable b;
  private String c;
  private RandomAccessFile d;

  public wp(File paramFile)
  {
    this(paramFile, null);
  }

  public wp(File paramFile, String paramString)
  {
    Hashtable localHashtable1 = new Hashtable(509);
    this.a = localHashtable1;
    Hashtable localHashtable2 = new Hashtable(509);
    this.b = localHashtable2;
    this.c = null;
    this.c = paramString;
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "r");
    this.d = localRandomAccessFile;
    try
    {
      c();
      e();
      return;
    }
    catch (IOException localIOException1)
    {
    }
    try
    {
      this.d.close();
      label84: throw localIOException1;
    }
    catch (IOException localIOException2)
    {
      break label84;
    }
  }

  private static long a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = (int)(paramLong >> 25 & 0x7F) + 1980;
    localCalendar.set(1, i);
    int j = (int)(paramLong >> 21 & 0xF) - 1;
    localCalendar.set(2, j);
    int k = (int)(paramLong >> 16) & 0x1F;
    localCalendar.set(5, k);
    int m = (int)(paramLong >> 11) & 0x1F;
    localCalendar.set(11, m);
    int n = (int)(paramLong >> 5) & 0x3F;
    localCalendar.set(12, n);
    int i1 = (int)(paramLong << 1) & 0x3E;
    localCalendar.set(13, i1);
    return localCalendar.getTime().getTime();
  }

  private void c()
  {
    d();
    byte[] arrayOfByte1 = new byte[42];
    byte[] arrayOfByte2 = new byte[4];
    this.d.readFully(arrayOfByte2);
    long l1 = wt.a(arrayOfByte2);
    long l2 = wt.a(wu.e);
    while (true)
    {
      if (l1 != l2)
        return;
      this.d.readFully(arrayOfByte1);
      wn localwn = new wn();
      int i = wv.a(arrayOfByte1, 0);
      int j = 0 + 2;
      int k = i >> 8 & 0xF;
      localwn.b(k);
      int m = j + 4;
      int n = wv.a(arrayOfByte1, m);
      localwn.setMethod(n);
      int i1 = m + 2;
      long l3 = a(wt.a(arrayOfByte1, i1));
      localwn.setTime(l3);
      int i2 = i1 + 4;
      long l4 = wt.a(arrayOfByte1, i2);
      localwn.setCrc(l4);
      int i3 = i2 + 4;
      long l5 = wt.a(arrayOfByte1, i3);
      localwn.setCompressedSize(l5);
      int i4 = i3 + 4;
      long l6 = wt.a(arrayOfByte1, i4);
      localwn.setSize(l6);
      int i5 = i4 + 4;
      int i6 = wv.a(arrayOfByte1, i5);
      int i7 = i5 + 2;
      int i8 = wv.a(arrayOfByte1, i7);
      int i9 = i7 + 2;
      int i10 = wv.a(arrayOfByte1, i9);
      int i11 = i9 + 2 + 2;
      int i12 = wv.a(arrayOfByte1, i11);
      localwn.a(i12);
      int i13 = i11 + 2;
      long l7 = wt.a(arrayOfByte1, i13);
      localwn.a(l7);
      int i14 = i13 + 4;
      byte[] arrayOfByte3 = new byte[i6];
      this.d.readFully(arrayOfByte3);
      String str1 = a(arrayOfByte3);
      localwn.a(str1);
      ws localws = new ws(null);
      long l8 = wt.a(arrayOfByte1, i14);
      long l9 = ws.a(localws, l8);
      Object localObject1 = this.a.put(localwn, localws);
      Hashtable localHashtable = this.b;
      String str2 = localwn.getName();
      Object localObject2 = localHashtable.put(str2, localwn);
      int i15 = this.d.skipBytes(i8);
      byte[] arrayOfByte4 = new byte[i10];
      this.d.readFully(arrayOfByte4);
      String str3 = a(arrayOfByte4);
      localwn.setComment(str3);
      this.d.readFully(arrayOfByte2);
      l1 = wt.a(arrayOfByte2);
    }
  }

  private void d()
  {
    long l1 = this.d.length() - 22L;
    long l2;
    int j;
    int i5;
    if (l1 >= 0L)
    {
      this.d.seek(l1);
      byte[] arrayOfByte1 = wu.f;
      int i = this.d.read();
      l2 = l1;
      j = i;
      if (j != -1)
      {
        int k = arrayOfByte1[0];
        if (j == k)
        {
          int m = this.d.read();
          int n = arrayOfByte1[1];
          if (m == n)
          {
            int i1 = this.d.read();
            int i2 = arrayOfByte1[2];
            if (i1 == i2)
            {
              int i3 = this.d.read();
              int i4 = arrayOfByte1[3];
              if (i3 == i4)
              {
                l1 = l2;
                i5 = 1;
              }
            }
          }
        }
      }
    }
    while (true)
    {
      if (i5 == 0)
      {
        throw new ZipException("archive is not a ZIP archive");
        RandomAccessFile localRandomAccessFile1 = this.d;
        l2 -= 1L;
        localRandomAccessFile1.seek(l2);
        j = this.d.read();
        break;
      }
      RandomAccessFile localRandomAccessFile2 = this.d;
      long l3 = l1 + 16L;
      localRandomAccessFile2.seek(l3);
      byte[] arrayOfByte2 = new byte[4];
      this.d.readFully(arrayOfByte2);
      RandomAccessFile localRandomAccessFile3 = this.d;
      long l4 = wt.a(arrayOfByte2);
      localRandomAccessFile3.seek(l4);
      return;
      l1 = l2;
      i5 = 0;
      continue;
      i5 = 0;
    }
  }

  private void e()
  {
    Enumeration localEnumeration = b();
    while (true)
    {
      if (!localEnumeration.hasMoreElements())
        return;
      wn localwn = (wn)localEnumeration.nextElement();
      ws localws = (ws)this.a.get(localwn);
      long l1 = ws.b(localws);
      RandomAccessFile localRandomAccessFile = this.d;
      long l2 = l1 + 26L;
      localRandomAccessFile.seek(l2);
      byte[] arrayOfByte1 = new byte[2];
      this.d.readFully(arrayOfByte1);
      int i = wv.a(arrayOfByte1);
      this.d.readFully(arrayOfByte1);
      int j = wv.a(arrayOfByte1);
      int k = this.d.skipBytes(i);
      byte[] arrayOfByte2 = new byte[j];
      this.d.readFully(arrayOfByte2);
      localwn.setExtra(arrayOfByte2);
      long l3 = l1 + 26L + 2L + 2L;
      long l4 = i;
      long l5 = l3 + l4;
      long l6 = j;
      long l7 = l5 + l6;
      long l8 = ws.b(localws, l7);
    }
  }

  public InputStream a(wn paramwn)
  {
    Object localObject = (ws)this.a.get(paramwn);
    if (localObject == null);
    Inflater localInflater;
    for (localObject = null; ; localObject = new InflaterInputStream((InputStream)localObject, localInflater))
    {
      return localObject;
      long l1 = ws.a((ws)localObject);
      long l2 = paramwn.getCompressedSize();
      wp localwp = this;
      localObject = new wr(localwp, l1, l2);
      switch (paramwn.getMethod())
      {
      case 0:
      default:
        StringBuilder localStringBuilder = new StringBuilder().append("Found unsupported compression method ");
        int i = paramwn.getMethod();
        String str = i;
        throw new ZipException(str);
      case 8:
      }
      ((wr)localObject).a();
      localInflater = new Inflater(1);
    }
  }

  protected String a(byte[] paramArrayOfByte)
  {
    String str1;
    if (this.c == null)
      str1 = new String(paramArrayOfByte);
    String str3;
    while (true)
    {
      return str1;
      try
      {
        String str2 = this.c;
        str1 = new String(paramArrayOfByte, str2);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        str3 = localUnsupportedEncodingException.getMessage();
      }
    }
    throw new ZipException(str3);
  }

  public void a()
  {
    this.d.close();
  }

  public Enumeration b()
  {
    return this.a.keys();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wp
 * JD-Core Version:    0.6.0
 */