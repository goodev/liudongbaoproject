import java.io.InputStream;
import java.io.RandomAccessFile;

class wr extends InputStream
{
  private long b;
  private long c;
  private boolean d = 0;

  wr(wp paramwp, long paramLong1, long paramLong2)
  {
    this.b = paramLong2;
    this.c = paramLong1;
  }

  void a()
  {
    this.d = 1;
  }

  public int read()
  {
    long l1 = this.b;
    long l2 = l1 - 1L;
    this.b = l2;
    int i;
    if (l1 <= 0L)
      if (this.d)
      {
        this.d = 0;
        i = 0;
      }
    while (true)
    {
      return i;
      i = -1;
      continue;
      synchronized (wp.a(this.a))
      {
        RandomAccessFile localRandomAccessFile2 = wp.a(this.a);
        long l3 = this.c;
        long l4 = l3 + 1L;
        this.c = l4;
        localRandomAccessFile2.seek(l3);
        int j = wp.a(this.a).read();
        i = j;
      }
    }
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i;
    if (this.b <= 0L)
      if (this.d)
      {
        this.d = 0;
        paramArrayOfByte[paramInt1] = 0;
        i = 1;
      }
    while (true)
    {
      return i;
      i = -1;
      continue;
      if (paramInt2 > 0)
        break;
      i = 0;
    }
    long l1 = paramInt2;
    long l2 = this.b;
    if (l1 > l2);
    int k;
    for (int j = (int)this.b; ; k = paramInt2)
      synchronized (wp.a(this.a))
      {
        RandomAccessFile localRandomAccessFile2 = wp.a(this.a);
        long l3 = this.c;
        localRandomAccessFile2.seek(l3);
        i = wp.a(this.a).read(paramArrayOfByte, paramInt1, j);
        if (i <= 0)
          break;
        long l4 = this.c;
        long l5 = i;
        long l6 = l4 + l5;
        this.c = l6;
        long l7 = this.b;
        long l8 = i;
        long l9 = l7 - l8;
        this.b = l9;
      }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wr
 * JD-Core Version:    0.6.0
 */