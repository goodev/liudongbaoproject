public class wm
  implements wo
{
  private wv a;
  private byte[] b;
  private byte[] c;

  public wv a()
  {
    return this.a;
  }

  public void a(wv paramwv)
  {
    this.a = paramwv;
  }

  public void a(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
  }

  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    a(arrayOfByte);
  }

  public wv b()
  {
    int i = this.b.length;
    return new wv(i);
  }

  public wv c()
  {
    int i;
    if (this.c != null)
      i = this.c.length;
    for (wv localwv = new wv(i); ; localwv = b())
      return localwv;
  }

  public byte[] d()
  {
    return this.b;
  }

  public byte[] e()
  {
    if (this.c != null);
    for (byte[] arrayOfByte = this.c; ; arrayOfByte = d())
      return arrayOfByte;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wm
 * JD-Core Version:    0.6.0
 */