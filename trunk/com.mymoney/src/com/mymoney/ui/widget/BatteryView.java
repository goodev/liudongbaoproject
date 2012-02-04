package com.mymoney.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import b;
import java.util.Timer;
import sx;
import sy;
import um;
import uo;

public class BatteryView extends View
{
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private int I;
  private sy J;
  private String a;
  private long b;
  private long c;
  private uo d;
  private int e;
  private int f;
  private int g;
  private long h;
  private int i;
  private boolean j;
  private Timer k;
  private int l;
  private int m;
  private boolean n;
  private boolean o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private Drawable v;
  private Drawable w;
  private Drawable x;
  private Drawable y;
  private Drawable z;

  public BatteryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    String str = BatteryView.class.getSimpleName();
    this.a = str;
    um localum = um.b;
    uo localuo = new uo(localum);
    this.d = localuo;
    this.o = 1;
    sy localsy = new sy(this);
    this.J = localsy;
    int[] arrayOfInt = b.b;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
    int i1 = localTypedArray.getInt(0, 0);
    this.e = i1;
    long l1 = localTypedArray.getInt(1, 0);
    this.b = l1;
    int i2 = localTypedArray.getInt(2, 0);
    this.l = i2;
    int i3 = localTypedArray.getInt(3, 0);
    this.m = i3;
    int i4 = localTypedArray.getInt(4, 0);
    this.t = i4;
    int i5 = localTypedArray.getInt(6, 0);
    this.u = i5;
    Drawable localDrawable1 = localTypedArray.getDrawable(8);
    this.v = localDrawable1;
    Drawable localDrawable2 = localTypedArray.getDrawable(9);
    this.w = localDrawable2;
    Drawable localDrawable3 = localTypedArray.getDrawable(10);
    this.x = localDrawable3;
    Drawable localDrawable4 = localTypedArray.getDrawable(11);
    this.y = localDrawable4;
    Drawable localDrawable5 = localTypedArray.getDrawable(12);
    this.z = localDrawable5;
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    int i1 = this.t;
    this.p = i1;
    int i2 = this.u;
    this.q = i2;
    int i3 = this.t;
    int i4 = this.l;
    int i5 = i3 + i4;
    this.r = i5;
    int i6 = this.u;
    int i7 = this.m;
    int i8 = i6 + i7;
    this.s = i8;
    int i9 = this.y.getIntrinsicHeight();
    this.A = i9;
    int i10 = this.v.getIntrinsicHeight();
    this.B = i10;
    int i11 = this.x.getIntrinsicHeight();
    this.C = i11;
    int i12 = this.z.getIntrinsicHeight();
    this.D = i12;
    int i13 = this.z.getIntrinsicWidth();
    this.E = i13;
  }

  private void b()
  {
    long l1 = System.nanoTime();
    this.h = l1;
    Timer localTimer = this.k;
    sx localsx = new sx(this);
    long l2 = this.e;
    localTimer.scheduleAtFixedRate(localsx, 0L, l2);
  }

  private void c()
  {
    long l1 = System.nanoTime();
    long l2 = this.h;
    long l3 = (l1 - l2) / 1000000L;
    float f1 = (float)l3;
    float f2 = (float)this.c;
    float f3 = Math.min(f1 / f2, 1.0F);
    float f4 = this.G;
    float f5 = this.i;
    float f6 = f3 * f5;
    int i1 = (int)(f4 - f6);
    this.F = i1;
    long l4 = this.c;
    if (l3 <= l4)
      return;
    this.k.cancel();
  }

  public void a()
  {
    if (!this.j)
      return;
    this.J.a();
  }

  public void a(float paramFloat, boolean paramBoolean)
  {
    float f1;
    if (paramFloat < 0.0F)
      f1 = 0.0F;
    while (true)
    {
      if (f1 > 1.0F)
        f1 = 1.0F;
      Timer localTimer = new Timer();
      this.k = localTimer;
      long l1;
      if (this.o)
      {
        this.o = 0;
        int i1 = this.m;
        this.G = i1;
        int i2 = this.G;
        this.F = i2;
        float f2 = this.m;
        int i3 = (int)(f1 * f2);
        this.H = i3;
        int i4 = this.H;
        this.I = i4;
        int i5 = this.G;
        int i6 = this.H;
        int i7 = i5 - i6;
        this.i = i7;
        this.n = paramBoolean;
        int i8 = this.i;
        int i9 = this.m;
        if (i8 / i9 <= 0.5D)
          break label195;
        l1 = this.b * 2L;
      }
      label195: long l2;
      for (this.c = l1; ; this.c = l2)
      {
        b();
        return;
        int i10 = this.I;
        this.G = i10;
        break;
        l2 = this.b;
      }
      f1 = paramFloat;
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.j = 1;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.j = 0;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.n)
    {
      int i1 = this.F;
      int i2 = this.A;
      if (i1 > i2)
        break label143;
      int i3 = this.p;
      int i4 = this.s;
      int i5 = this.A;
      int i6 = i4 - i5;
      int i7 = this.r;
      int i8 = this.s;
      Rect localRect1 = new Rect(i3, i6, i7, i8);
      this.y.setBounds(localRect1);
      this.y.draw(paramCanvas);
    }
    while (true)
    {
      int i9 = this.E;
      int i10 = this.D;
      Rect localRect2 = new Rect(0, 0, i9, i10);
      this.z.setBounds(localRect2);
      this.z.draw(paramCanvas);
      return;
      label143: int i11 = this.m;
      int i12 = this.F;
      int i13 = i11 - i12;
      int i14 = this.u;
      int i15 = i13 + i14;
      int i16 = this.B + i15 - 1;
      int i17 = this.F;
      int i18 = this.B;
      int i19 = i17 - i18;
      int i20 = this.C;
      int i21 = i19 - i20 + 1;
      int i22 = this.p;
      int i23 = this.r;
      int i24 = i21 + i16;
      Rect localRect3 = new Rect(i22, i16, i23, i24);
      this.w.setBounds(localRect3);
      this.w.draw(paramCanvas);
      int i25 = this.p;
      int i26 = this.r;
      int i27 = this.B + i15;
      Rect localRect4 = new Rect(i25, i15, i26, i27);
      this.v.setBounds(localRect4);
      this.v.draw(paramCanvas);
      int i28 = this.p;
      int i29 = this.s;
      int i30 = this.C;
      int i31 = i29 - i30;
      int i32 = this.r;
      int i33 = this.s;
      Rect localRect5 = new Rect(i28, i31, i32, i33);
      this.x.setBounds(localRect5);
      this.x.draw(paramCanvas);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    this.f = i1;
    int i2 = View.MeasureSpec.getSize(paramInt2);
    this.g = i2;
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.BatteryView
 * JD-Core Version:    0.6.0
 */