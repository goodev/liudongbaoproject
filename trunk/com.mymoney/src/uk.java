import android.view.animation.Interpolator;

public class uk
  implements Interpolator
{
  private um a;
  private float b;

  public uk(um paramum, float paramFloat)
  {
    this.a = paramum;
    this.b = paramFloat;
  }

  private float a(float paramFloat1, float paramFloat2)
  {
    float f1;
    if (paramFloat2 == 0.0F)
      f1 = 1.70158F;
    while (true)
    {
      float f2 = paramFloat1 * paramFloat1;
      return ((1.0F + f1) * paramFloat1 - f1) * f2;
      f1 = paramFloat2;
    }
  }

  private float b(float paramFloat1, float paramFloat2)
  {
    float f1;
    if (paramFloat2 == 0.0F)
      f1 = 1.70158F;
    while (true)
    {
      float f2 = paramFloat1 - 1.0F;
      float f3 = f2 * f2;
      float f4 = f1 + 1.0F;
      float f5 = f2 * f4;
      return (f1 + f5) * f3 + 1.0F;
      f1 = paramFloat2;
    }
  }

  private float c(float paramFloat1, float paramFloat2)
  {
    float f1;
    if (paramFloat2 == 0.0F)
      f1 = 1.70158F;
    while (true)
    {
      float f2 = paramFloat1 * 2.0F;
      float f6;
      if (f2 < 1.0F)
      {
        float f3 = f2 * f2;
        float f4 = (float)(f1 * 1.525D);
        float f5 = f4 + 1.0F;
        f6 = (f2 * f5 - f4) * f3 * 0.5F;
      }
      while (true)
      {
        return f6;
        float f7 = f2 - 2.0F;
        float f8 = f7 * f7;
        float f9 = (float)(f1 * 1.525D);
        float f10 = f9 + 1.0F;
        float f11 = f7 * f10;
        f6 = ((f9 + f11) * f8 + 2.0F) * 0.5F;
      }
      f1 = paramFloat2;
    }
  }

  public float getInterpolation(float paramFloat)
  {
    um localum1 = this.a;
    um localum2 = um.a;
    float f2;
    if (localum1 == localum2)
    {
      float f1 = this.b;
      f2 = a(paramFloat, f1);
    }
    while (true)
    {
      return f2;
      um localum3 = this.a;
      um localum4 = um.b;
      if (localum3 == localum4)
      {
        float f3 = this.b;
        f2 = b(paramFloat, f3);
        continue;
      }
      um localum5 = this.a;
      um localum6 = um.c;
      if (localum5 == localum6)
      {
        float f4 = this.b;
        f2 = c(paramFloat, f4);
        continue;
      }
      int i = 0;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     uk
 * JD-Core Version:    0.6.0
 */