public final class wt
  implements Cloneable
{
  private long a;

  public static long a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0);
  }

  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 3;
    long l1 = paramArrayOfByte[i] << 24 & 0xFF000000;
    int j = paramInt + 2;
    long l2 = paramArrayOfByte[j] << 16 & 0xFF0000;
    long l3 = l1 + l2;
    int k = paramInt + 1;
    long l4 = paramArrayOfByte[k] << 8 & 0xFF00;
    long l5 = l3 + l4;
    long l6 = paramArrayOfByte[paramInt] & 0xFF;
    return l5 + l6;
  }

  public static byte[] a(long paramLong)
  {
    byte[] arrayOfByte = new byte[4];
    int i = (byte)(int)(0xFF & paramLong);
    arrayOfByte[0] = i;
    int j = (byte)(int)((0xFF00 & paramLong) >> 8);
    arrayOfByte[1] = j;
    int k = (byte)(int)((0xFF0000 & paramLong) >> 16);
    arrayOfByte[2] = k;
    int m = (byte)(int)((0xFF000000 & paramLong) >> 24);
    arrayOfByte[3] = m;
    return arrayOfByte;
  }

  public long a()
  {
    return this.a;
  }

  public boolean equals(Object paramObject)
  {
    int i;
    if ((paramObject == null) || (!(paramObject instanceof wt)))
      i = 0;
    while (true)
    {
      return i;
      long l1 = this.a;
      long l2 = ((wt)paramObject).a();
      if (l1 == l2)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public int hashCode()
  {
    return (int)this.a;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wt
 * JD-Core Version:    0.6.0
 */