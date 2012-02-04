public class eu
{
  private long a;
  private String b;
  private int c;
  private long d;

  public eu()
  {
  }

  public eu(long paramLong)
  {
    this.a = paramLong;
  }

  public static eu a()
  {
    eu localeu = new eu();
    localeu.a(0L);
    localeu.a("无商家");
    return localeu;
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void a(long paramLong)
  {
    this.a = paramLong;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public long b()
  {
    return this.a;
  }

  public void b(long paramLong)
  {
    this.d = paramLong;
  }

  public String c()
  {
    return this.b;
  }

  public int d()
  {
    return this.c;
  }

  public long e()
  {
    return this.d;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     eu
 * JD-Core Version:    0.6.0
 */