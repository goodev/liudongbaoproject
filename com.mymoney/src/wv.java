public final class wv
  implements Cloneable
{
  private int a;

  public wv(int paramInt)
  {
    this.a = paramInt;
  }

  public wv(byte[] paramArrayOfByte, int paramInt)
  {
    int i = a(paramArrayOfByte, paramInt);
    this.a = i;
  }

  public static int a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0);
  }

  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt + 1;
    int j = paramArrayOfByte[i] << 8 & 0xFF00;
    int k = paramArrayOfByte[paramInt] & 0xFF;
    return j + k;
  }

  public static byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[2];
    int i = (byte)(paramInt & 0xFF);
    arrayOfByte[0] = i;
    int j = (byte)((0xFF00 & paramInt) >> 8);
    arrayOfByte[1] = j;
    return arrayOfByte;
  }

  public byte[] a()
  {
    byte[] arrayOfByte = new byte[2];
    int i = (byte)(this.a & 0xFF);
    arrayOfByte[0] = i;
    int j = (byte)((this.a & 0xFF00) >> 8);
    arrayOfByte[1] = j;
    return arrayOfByte;
  }

  public int b()
  {
    return this.a;
  }

  public boolean equals(Object paramObject)
  {
    int i;
    if ((paramObject == null) || (!(paramObject instanceof wv)))
      i = 0;
    while (true)
    {
      return i;
      int j = this.a;
      int k = ((wv)paramObject).b();
      if (j == k)
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public int hashCode()
  {
    return this.a;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wv
 * JD-Core Version:    0.6.0
 */