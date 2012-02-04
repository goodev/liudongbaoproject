public class vz
{
  public static float a(float paramFloat)
  {
    return (float)(180.0F * paramFloat / 3.141592653589793D);
  }

  public static float a(vy paramvy)
  {
    float f1 = paramvy.a;
    float f2 = paramvy.a;
    float f3 = f1 * f2;
    float f4 = paramvy.b;
    float f5 = paramvy.b;
    float f6 = f4 * f5;
    return (float)Math.sqrt(f3 + f6);
  }

  public static float a(vy paramvy1, vy paramvy2)
  {
    float f1 = paramvy1.a;
    float f2 = paramvy2.a;
    float f3 = f1 * f2;
    float f4 = paramvy1.b;
    float f5 = paramvy2.b;
    float f6 = f4 * f5;
    return f3 + f6;
  }

  public static vy a(vy paramvy, float paramFloat)
  {
    float f1 = paramvy.a * paramFloat;
    float f2 = paramvy.b * paramFloat;
    return new vy(f1, f2);
  }

  public static vy b(vy paramvy1, vy paramvy2)
  {
    float f1 = paramvy2.a;
    float f2 = paramvy1.a;
    float f3 = f1 - f2;
    float f4 = paramvy2.b;
    float f5 = paramvy1.b;
    float f6 = f4 - f5;
    return new vy(f3, f6);
  }

  public static void b(vy paramvy)
  {
    float f1 = a(paramvy);
    if (f1 == 0.0D)
    {
      paramvy.a = 1.0F;
      paramvy.b = 0.0F;
      return;
    }
    float f2 = paramvy.a / f1;
    paramvy.a = f2;
    float f3 = paramvy.b / f1;
    paramvy.b = f3;
  }

  public static vy c(vy paramvy1, vy paramvy2)
  {
    float f1 = paramvy1.a;
    float f2 = paramvy2.a;
    float f3 = f1 - f2;
    float f4 = paramvy1.b;
    float f5 = paramvy2.b;
    float f6 = f4 - f5;
    return new vy(f3, f6);
  }

  public static float d(vy paramvy1, vy paramvy2)
  {
    float f1 = paramvy2.a;
    float f2 = paramvy1.a;
    float f3 = Math.abs(f1 - f2);
    float f4 = paramvy2.b;
    float f5 = paramvy1.b;
    float f6 = Math.abs(f4 - f5);
    float f7 = f3 * f3;
    float f8 = f6 * f6;
    float f9 = f7 + f8;
    float f10;
    if (f9 > 0.0F)
      f10 = (float)Math.sqrt(f9);
    while (true)
    {
      return f10;
      int i = 0;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vz
 * JD-Core Version:    0.6.0
 */