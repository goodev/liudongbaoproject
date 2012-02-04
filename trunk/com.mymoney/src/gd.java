import android.graphics.BitmapFactory.Options;

class gd
{
  public gc a;
  public BitmapFactory.Options b;

  private gd()
  {
    gc localgc = gc.b;
    this.a = localgc;
  }

  public String toString()
  {
    gc localgc1 = this.a;
    gc localgc2 = gc.a;
    String str;
    if (localgc1 == localgc2)
      str = "Cancel";
    while (true)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("thread state = ").append(str).append(", options = ");
      BitmapFactory.Options localOptions = this.b;
      return localOptions;
      gc localgc3 = this.a;
      gc localgc4 = gc.b;
      if (localgc3 == localgc4)
      {
        str = "Allow";
        continue;
      }
      str = "?";
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gd
 * JD-Core Version:    0.6.0
 */