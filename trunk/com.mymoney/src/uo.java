import android.view.animation.Interpolator;

public class uo
  implements Interpolator
{
  private um a;

  public uo(um paramum)
  {
    this.a = paramum;
  }

  private float a(float paramFloat)
  {
    return paramFloat * paramFloat;
  }

  private float b(float paramFloat)
  {
    float f1 = -paramFloat;
    float f2 = paramFloat - 2.0F;
    return f1 * f2;
  }

  private float c(float paramFloat)
  {
    float f1 = paramFloat * 2.0F;
    float f3;
    if (f1 < 1.0F)
    {
      float f2 = 0.5F * f1;
      f3 = f1 * f2;
    }
    while (true)
    {
      return f3;
      float f4 = f1 - 1.0F;
      float f5 = f4 - 2.0F;
      f3 = (f4 * f5 - 1.0F) * -0.5F;
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
 * Qualified Name:     uo
 * JD-Core Version:    0.6.0
 */