import com.mymoney.core.vo.CategoryVo;

public class hh
{
  private long a;
  private CategoryVo b;
  private double c;
  private double d;
  private double e;
  private float f;

  public static hh a()
  {
    hh localhh = new hh();
    localhh.a(0L);
    localhh.b(0.0D);
    localhh.c(0.0D);
    localhh.a(0.0D);
    CategoryVo localCategoryVo = new CategoryVo(0L);
    localhh.a(localCategoryVo);
    return localhh;
  }

  public void a(double paramDouble)
  {
    this.e = paramDouble;
  }

  public void a(long paramLong)
  {
    this.a = paramLong;
  }

  public void a(CategoryVo paramCategoryVo)
  {
    this.b = paramCategoryVo;
  }

  public long b()
  {
    return this.a;
  }

  public void b(double paramDouble)
  {
    this.c = paramDouble;
  }

  public CategoryVo c()
  {
    return this.b;
  }

  public void c(double paramDouble)
  {
    this.d = paramDouble;
  }

  public double d()
  {
    return this.c;
  }

  public double e()
  {
    return this.d;
  }

  public float f()
  {
    double d1 = this.d;
    double d2 = this.c;
    float f1 = (float)(d1 / d2);
    this.f = f1;
    return this.f;
  }

  public boolean g()
  {
    if (this.c == 0.0D);
    for (int i = 0; ; i = 1)
      return i;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hh
 * JD-Core Version:    0.6.0
 */