package com.mymoney.ui.widget.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import gw;
import ui;
import uj;

public abstract class ImageViewTouchBase extends ImageView
{
  protected Matrix a;
  protected Matrix b;
  protected final gw c;
  int d;
  int e;
  protected Handler f;
  private final Matrix g;
  private final float[] h;
  private float i;
  private uj j;
  private Runnable k;

  public ImageViewTouchBase(Context paramContext)
  {
    super(paramContext);
    Matrix localMatrix1 = new Matrix();
    this.a = localMatrix1;
    Matrix localMatrix2 = new Matrix();
    this.b = localMatrix2;
    Matrix localMatrix3 = new Matrix();
    this.g = localMatrix3;
    float[] arrayOfFloat = new float[9];
    this.h = arrayOfFloat;
    gw localgw = new gw(null);
    this.c = localgw;
    this.d = -1;
    this.e = -1;
    Handler localHandler = new Handler();
    this.f = localHandler;
    this.k = null;
    h();
  }

  public ImageViewTouchBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Matrix localMatrix1 = new Matrix();
    this.a = localMatrix1;
    Matrix localMatrix2 = new Matrix();
    this.b = localMatrix2;
    Matrix localMatrix3 = new Matrix();
    this.g = localMatrix3;
    float[] arrayOfFloat = new float[9];
    this.h = arrayOfFloat;
    gw localgw = new gw(null);
    this.c = localgw;
    this.d = -1;
    this.e = -1;
    Handler localHandler = new Handler();
    this.f = localHandler;
    this.k = null;
    h();
  }

  private void a(Bitmap paramBitmap, int paramInt)
  {
    super.setImageBitmap(paramBitmap);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
      localDrawable.setDither(1);
    Bitmap localBitmap = this.c.b();
    this.c.a(paramBitmap);
    this.c.a(paramInt);
    if (localBitmap == null)
      return;
    if (localBitmap == paramBitmap)
      return;
    if (this.j == null)
      return;
    this.j.a(localBitmap);
  }

  private void a(gw paramgw, Matrix paramMatrix)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    float f3 = paramgw.f();
    float f4 = paramgw.e();
    paramMatrix.reset();
    float f5 = Math.min(f1 / f3, 3.0F);
    float f6 = Math.min(f2 / f4, 3.0F);
    float f7 = Math.min(f5, f6);
    Matrix localMatrix = paramgw.c();
    boolean bool1 = paramMatrix.postConcat(localMatrix);
    boolean bool2 = paramMatrix.postScale(f7, f7);
    float f8 = f3 * f7;
    float f9 = (f1 - f8) / 2.0F;
    float f10 = f4 * f7;
    float f11 = (f2 - f10) / 2.0F;
    boolean bool3 = paramMatrix.postTranslate(f9, f11);
  }

  private void h()
  {
    ImageView.ScaleType localScaleType = ImageView.ScaleType.MATRIX;
    setScaleType(localScaleType);
  }

  protected float a(Matrix paramMatrix)
  {
    return a(paramMatrix, 0);
  }

  protected float a(Matrix paramMatrix, int paramInt)
  {
    float[] arrayOfFloat = this.h;
    paramMatrix.getValues(arrayOfFloat);
    return this.h[paramInt];
  }

  public void a()
  {
    a(null, 1);
  }

  public void a(float paramFloat)
  {
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    a(paramFloat, f1, f2);
  }

  protected void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = this.i;
    float f2;
    if (paramFloat1 > f1)
      f2 = this.i;
    while (true)
    {
      float f3 = b();
      float f4 = f2 / f3;
      boolean bool = this.b.postScale(f4, f4, paramFloat2, paramFloat3);
      Matrix localMatrix = c();
      setImageMatrix(localMatrix);
      a(1, 1);
      return;
      f2 = paramFloat1;
    }
  }

  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    gw localgw = new gw(paramBitmap);
    a(localgw, paramBoolean);
  }

  public void a(gw paramgw, boolean paramBoolean)
  {
    if (getWidth() <= 0)
    {
      ui localui = new ui(this, paramgw, paramBoolean);
      this.k = localui;
      return;
    }
    if (paramgw.b() != null)
    {
      Matrix localMatrix1 = this.a;
      a(paramgw, localMatrix1);
      Bitmap localBitmap = paramgw.b();
      int m = paramgw.a();
      a(localBitmap, m);
    }
    while (true)
    {
      if (paramBoolean)
        this.b.reset();
      Matrix localMatrix2 = c();
      setImageMatrix(localMatrix2);
      float f1 = d();
      this.i = f1;
      return;
      this.a.reset();
      setImageBitmap(null);
    }
  }

  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.c.b() == null)
      return;
    Matrix localMatrix1 = c();
    float f1 = this.c.b().getWidth();
    float f2 = this.c.b().getHeight();
    RectF localRectF = new RectF(0.0F, 0.0F, f1, f2);
    boolean bool = localMatrix1.mapRect(localRectF);
    float f3 = localRectF.height();
    float f4 = localRectF.width();
    int m;
    float f8;
    if (paramBoolean2)
    {
      m = getHeight();
      float f5 = m;
      if (f3 < f5)
      {
        float f6 = (m - f3) / 2.0F;
        float f7 = localRectF.top;
        f8 = f6 - f7;
      }
    }
    while (true)
    {
      int n;
      float f12;
      if (paramBoolean1)
      {
        n = getWidth();
        float f9 = n;
        if (f4 < f9)
        {
          float f10 = (n - f4) / 2.0F;
          float f11 = localRectF.left;
          f12 = f10 - f11;
        }
      }
      while (true)
      {
        b(f12, f8);
        Matrix localMatrix2 = c();
        setImageMatrix(localMatrix2);
        return;
        if (localRectF.top > 0.0F)
        {
          f8 = -localRectF.top;
          break;
        }
        float f13 = localRectF.bottom;
        float f14 = m;
        if (f13 >= f14)
          break label335;
        float f15 = getHeight();
        float f16 = localRectF.bottom;
        f8 = f15 - f16;
        break;
        if (localRectF.left > 0.0F)
        {
          f12 = -localRectF.left;
          continue;
        }
        float f17 = localRectF.right;
        float f18 = n;
        if (f17 < f18)
        {
          float f19 = n;
          float f20 = localRectF.right;
          f12 = f19 - f20;
          continue;
        }
        f12 = 0.0F;
      }
      label335: f8 = 0.0F;
    }
  }

  public float b()
  {
    Matrix localMatrix = this.b;
    return a(localMatrix);
  }

  protected void b(float paramFloat)
  {
    float f1 = b();
    float f2 = this.i;
    if (f1 >= f2)
      return;
    if (this.c.b() == null)
      return;
    float f3 = getWidth() / 2.0F;
    float f4 = getHeight() / 2.0F;
    boolean bool = this.b.postScale(paramFloat, paramFloat, f3, f4);
    Matrix localMatrix = c();
    setImageMatrix(localMatrix);
  }

  public void b(float paramFloat1, float paramFloat2)
  {
    boolean bool = this.b.postTranslate(paramFloat1, paramFloat2);
  }

  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    float f3 = f1 - paramFloat2;
    float f4 = f2 - paramFloat3;
    c(f3, f4);
    a(paramFloat1, f1, f2);
  }

  protected Matrix c()
  {
    Matrix localMatrix1 = this.g;
    Matrix localMatrix2 = this.a;
    localMatrix1.set(localMatrix2);
    Matrix localMatrix3 = this.g;
    Matrix localMatrix4 = this.b;
    boolean bool = localMatrix3.postConcat(localMatrix4);
    return this.g;
  }

  protected void c(float paramFloat)
  {
    if (this.c.b() == null)
      return;
    float f1 = getWidth() / 2.0F;
    float f2 = getHeight() / 2.0F;
    Matrix localMatrix1 = this.b;
    Matrix localMatrix2 = new Matrix(localMatrix1);
    float f3 = 1.0F / paramFloat;
    float f4 = 1.0F / paramFloat;
    boolean bool1 = localMatrix2.postScale(f3, f4, f1, f2);
    if (a(localMatrix2) < 1.0F)
      this.b.setScale(1.0F, 1.0F, f1, f2);
    while (true)
    {
      Matrix localMatrix3 = c();
      setImageMatrix(localMatrix3);
      a(1, 1);
      return;
      Matrix localMatrix4 = this.b;
      float f5 = 1.0F / paramFloat;
      float f6 = 1.0F / paramFloat;
      boolean bool2 = localMatrix4.postScale(f5, f6, f1, f2);
    }
  }

  protected void c(float paramFloat1, float paramFloat2)
  {
    b(paramFloat1, paramFloat2);
    Matrix localMatrix = c();
    setImageMatrix(localMatrix);
  }

  protected float d()
  {
    float f1;
    if (this.c.b() == null)
      f1 = 1.0F;
    while (true)
    {
      return f1;
      float f2 = this.c.f();
      float f3 = this.d;
      float f4 = f2 / f3;
      float f5 = this.c.e();
      float f6 = this.e;
      float f7 = f5 / f6;
      f1 = Math.max(f4, f7) * 4.0F;
    }
  }

  public void e()
  {
    b(1.25F);
  }

  public void f()
  {
    c(1.25F);
  }

  public float g()
  {
    return this.i;
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (b() > 1.0F));
    boolean bool;
    for (int m = 1; ; bool = super.onKeyDown(paramInt, paramKeyEvent))
      return m;
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (b() > 1.0F))
      a(1.0F);
    boolean bool;
    for (int m = 1; ; bool = super.onKeyUp(paramInt, paramKeyEvent))
      return m;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int m = paramInt3 - paramInt1;
    this.d = m;
    int n = paramInt4 - paramInt2;
    this.e = n;
    Runnable localRunnable = this.k;
    if (localRunnable != null)
    {
      this.k = null;
      localRunnable.run();
    }
    if (this.c.b() == null)
      return;
    gw localgw = this.c;
    Matrix localMatrix1 = this.a;
    a(localgw, localMatrix1);
    Matrix localMatrix2 = c();
    setImageMatrix(localMatrix2);
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    a(paramBitmap, 0);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.common.ImageViewTouchBase
 * JD-Core Version:    0.6.0
 */