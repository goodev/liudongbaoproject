import android.view.animation.Interpolator;

public class un
  implements Interpolator
{
  private um a;

  public un(um paramum)
  {
    this.a = paramum;
  }

  private float a(float paramFloat)
  {
    double d1;
    if (paramFloat == 0.0F)
      d1 = 0.0D;
    while (true)
    {
      return (float)d1;
      float f = paramFloat - 1.0F;
      double d2 = 10.0F * f;
      d1 = Math.pow(2.0D, d2);
    }
  }

  private float b(float paramFloat)
  {
    double d1;
    if (paramFloat >= 1.0F)
      d1 = 1.0D;
    while (true)
    {
      return (float)d1;
      double d2 = -10.0F * paramFloat;
      d1 = -Math.pow(2.0D, d2) + 1.0D;
    }
  }

  private float c(float paramFloat)
  {
    float f1;
    if (paramFloat == 0.0F)
      f1 = 0.0F;
    while (true)
    {
      return f1;
      if (paramFloat >= 1.0F)
      {
        f1 = 1.0F;
        continue;
      }
      float f2 = 2.0F * paramFloat;
      if (f2 < 1.0F)
      {
        double d1 = (f2 - 1.0F) * 10.0F;
        f1 = (float)(Math.pow(2.0D, d1) * 0.5D);
        continue;
      }
      double d2 = (f2 - 1.0F) * -10.0F;
      f1 = (float)((-Math.pow(2.0D, d2) + 2.0D) * 0.5D);
    }
  }

  public float getInterpolation(float paramFloat)
  {
    um localum1 = this.a;
    um localum2 = um.a;
    float f;
    if (localum1 == localum2)
      f = a(paramFloat);
    while (true)
    {
      return f;
      um localum3 = this.a;
      um localum4 = um.b;
      if (localum3 == localum4)
      {
        f = b(paramFloat);
        continue;
      }
      um localum5 = this.a;
      um localum6 = um.c;
      if (localum5 == localum6)
      {
        f = c(paramFloat);
        continue;
      }
      int i = 0;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     un
 * JD-Core Version:    0.6.0
 */