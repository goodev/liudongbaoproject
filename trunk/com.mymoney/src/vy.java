public class vy
{
  public float a;
  public float b;

  public vy()
  {
  }

  public vy(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }

  public boolean equals(Object paramObject)
  {
    int i;
    if ((paramObject instanceof vy))
    {
      paramObject = (vy)paramObject;
      float f1 = this.a;
      float f2 = paramObject.a;
      if (f1 == f2)
      {
        float f3 = this.b;
        float f4 = paramObject.b;
        if (f3 == f4)
          i = 1;
      }
    }
    while (true)
    {
      return i;
      i = 0;
      continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    float f1 = this.a * 32713.0F;
    float f2 = this.b;
    return (int)(f1 + f2);
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("Point(");
    float f1 = this.a;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(f1).append(", ");
    float f2 = this.b;
    return f2 + ")";
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vy
 * JD-Core Version:    0.6.0
 */