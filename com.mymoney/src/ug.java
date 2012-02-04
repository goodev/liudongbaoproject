import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ug extends Animation
{
  private Camera a;
  private View b;
  private View c;
  private float d;
  private float e;
  private boolean f;
  private boolean g;

  public ug(View paramView1, View paramView2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.b = paramView1;
    this.c = paramView2;
    float f1 = paramInt1;
    this.d = f1;
    float f2 = paramInt2;
    this.e = f2;
    this.f = paramBoolean;
    setDuration(1000L);
    setFillAfter(1);
    AccelerateDecelerateInterpolator localAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
    setInterpolator(localAccelerateDecelerateInterpolator);
  }

  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    double d1 = paramFloat * 3.141592653589793D;
    float f1 = (float)(180.0D * d1 / 3.141592653589793D);
    if (paramFloat >= 0.5F)
    {
      f1 -= 180.0F;
      if (!this.g)
      {
        if (!this.f)
          break label197;
        this.b.setVisibility(8);
        this.c.setVisibility(0);
      }
    }
    while (true)
    {
      this.g = 1;
      if (!this.f)
        f1 = -f1;
      Matrix localMatrix = paramTransformation.getMatrix();
      this.a.save();
      Camera localCamera = this.a;
      float f2 = (float)(Math.sin(d1) * 310.0D);
      localCamera.translate(0.0F, 0.0F, f2);
      this.a.rotateY(f1);
      this.a.getMatrix(localMatrix);
      this.a.restore();
      float f3 = -this.d;
      float f4 = -this.e;
      boolean bool1 = localMatrix.preTranslate(f3, f4);
      float f5 = this.d;
      float f6 = this.e;
      boolean bool2 = localMatrix.postTranslate(f5, f6);
      return;
      label197: this.c.setVisibility(8);
      this.b.setVisibility(0);
    }
  }

  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    Camera localCamera = new Camera();
    this.a = localCamera;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ug
 * JD-Core Version:    0.6.0
 */