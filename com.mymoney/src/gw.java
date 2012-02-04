import android.graphics.Bitmap;
import android.graphics.Matrix;

public class gw
{
  private Bitmap a;
  private int b;

  public gw(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    this.b = 0;
  }

  public gw(Bitmap paramBitmap, int paramInt)
  {
    this.a = paramBitmap;
    int i = paramInt % 360;
    this.b = i;
  }

  public int a()
  {
    return this.b;
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
  }

  public void a(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }

  public Bitmap b()
  {
    return this.a;
  }

  public Matrix c()
  {
    Matrix localMatrix = new Matrix();
    if (this.b != 0)
    {
      int i = this.a.getWidth() / 2;
      int j = this.a.getHeight() / 2;
      float f1 = -i;
      float f2 = -j;
      boolean bool1 = localMatrix.preTranslate(f1, f2);
      float f3 = this.b;
      boolean bool2 = localMatrix.postRotate(f3);
      float f4 = f() / 2;
      float f5 = e() / 2;
      boolean bool3 = localMatrix.postTranslate(f4, f5);
    }
    return localMatrix;
  }

  public boolean d()
  {
    if (this.b / 90 % 2 != 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public int e()
  {
    if (d());
    for (int i = this.a.getWidth(); ; i = this.a.getHeight())
      return i;
  }

  public int f()
  {
    if (d());
    for (int i = this.a.getHeight(); ; i = this.a.getWidth())
      return i;
  }

  public void g()
  {
    if (this.a == null)
      return;
    this.a.recycle();
    this.a = null;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gw
 * JD-Core Version:    0.6.0
 */