package com.mymoney.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import b;
import java.util.Timer;
import um;
import uo;

public class LineBarView extends View
{
  public static float a = 0.3F;
  private String b;
  private long c;
  private uo d;
  private int e;
  private boolean f;
  private Timer g;
  private int h;
  private int i;
  private float j;
  private float k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private Drawable r;
  private Drawable s;
  private Drawable t;
  private Drawable u;
  private Drawable v;
  private Drawable w;
  private Drawable x;
  private Drawable y;
  private Drawable z;

  public LineBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    String str = LineBarView.class.getSimpleName();
    this.b = str;
    this.c = 2000L;
    um localum = um.b;
    uo localuo = new uo(localum);
    this.d = localuo;
    this.e = 30;
    Timer localTimer = new Timer();
    this.g = localTimer;
    int[] arrayOfInt = b.c;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
    a = localTypedArray.getFloat(0, 0.0F);
    Drawable localDrawable1 = localTypedArray.getDrawable(1);
    this.r = localDrawable1;
    Drawable localDrawable2 = localTypedArray.getDrawable(2);
    this.s = localDrawable2;
    Drawable localDrawable3 = localTypedArray.getDrawable(3);
    this.t = localDrawable3;
    Drawable localDrawable4 = localTypedArray.getDrawable(4);
    this.u = localDrawable4;
    Drawable localDrawable5 = localTypedArray.getDrawable(5);
    this.v = localDrawable5;
    Drawable localDrawable6 = localTypedArray.getDrawable(6);
    this.w = localDrawable6;
    Drawable localDrawable7 = localTypedArray.getDrawable(7);
    this.x = localDrawable7;
    Drawable localDrawable8 = localTypedArray.getDrawable(8);
    this.y = localDrawable8;
    Drawable localDrawable9 = localTypedArray.getDrawable(9);
    this.z = localDrawable9;
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    int i1 = this.r.getIntrinsicWidth();
    this.l = i1;
    int i2 = this.s.getIntrinsicWidth();
    this.m = i2;
    int i3 = this.u.getIntrinsicWidth();
    this.n = i3;
    int i4 = this.v.getIntrinsicWidth();
    this.o = i4;
    int i5 = this.x.getIntrinsicWidth();
    this.p = i5;
    int i6 = this.y.getIntrinsicWidth();
    this.q = i6;
  }

  public void a(float paramFloat, boolean paramBoolean)
  {
    this.j = paramFloat;
    this.f = paramBoolean;
    invalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Drawable localDrawable1 = this.t;
    int i1 = this.l;
    int i2 = this.h;
    int i3 = this.m;
    int i4 = i2 - i3;
    int i5 = this.i;
    localDrawable1.setBounds(i1, 0, i4, i5);
    Drawable localDrawable2 = this.r;
    int i6 = this.l;
    int i7 = this.i;
    localDrawable2.setBounds(0, 0, i6, i7);
    Drawable localDrawable3 = this.s;
    int i8 = this.h;
    int i9 = this.m;
    int i10 = i8 - i9;
    int i11 = this.h;
    int i12 = this.i;
    localDrawable3.setBounds(i10, 0, i11, i12);
    this.t.draw(paramCanvas);
    this.r.draw(paramCanvas);
    this.s.draw(paramCanvas);
    if (this.f)
      return;
    float f1 = this.j;
    float f2 = this.k;
    if (f1 <= f2)
    {
      Drawable localDrawable4 = this.x;
      int i13 = this.p;
      int i14 = this.i;
      localDrawable4.setBounds(0, 0, i13, i14);
      Drawable localDrawable5 = this.y;
      int i15 = this.p;
      int i16 = this.p;
      int i17 = this.q;
      int i18 = i16 + i17;
      int i19 = this.i;
      localDrawable5.setBounds(i15, 0, i18, i19);
      this.x.draw(paramCanvas);
      this.y.draw(paramCanvas);
      return;
    }
    float f3 = this.j;
    float f4 = a;
    Drawable localDrawable6;
    Drawable localDrawable7;
    if (f3 <= f4)
    {
      localDrawable6 = this.x;
      float f5 = this.j;
      float f6 = a;
      if (f5 > f6)
        break label526;
      localDrawable7 = this.y;
      label325: float f7 = this.j;
      float f8 = a;
      if (f7 > f8)
        break label535;
    }
    label526: label535: for (Drawable localDrawable8 = this.z; ; localDrawable8 = this.w)
    {
      float f9 = this.h;
      float f10 = this.j;
      int i20 = (int)(f9 * f10);
      int i21 = localDrawable6.getIntrinsicWidth();
      int i22 = i20 - i21;
      int i23 = localDrawable7.getIntrinsicWidth();
      int i24 = i22 - i23;
      int i25 = localDrawable6.getIntrinsicWidth();
      int i26 = this.i;
      localDrawable6.setBounds(0, 0, i25, i26);
      int i27 = localDrawable7.getIntrinsicWidth();
      int i28 = i20 - i27;
      int i29 = this.i;
      localDrawable7.setBounds(i28, 0, i20, i29);
      int i30 = localDrawable6.getIntrinsicWidth() - 1;
      int i31 = localDrawable6.getIntrinsicWidth();
      int i32 = i24 + i31 + 1;
      int i33 = this.i;
      localDrawable8.setBounds(i30, 0, i32, i33);
      localDrawable6.draw(paramCanvas);
      localDrawable7.draw(paramCanvas);
      localDrawable8.draw(paramCanvas);
      return;
      localDrawable6 = this.u;
      break;
      localDrawable7 = this.v;
      break label325;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    this.h = i1;
    int i2 = View.MeasureSpec.getSize(paramInt2);
    this.i = i2;
    float f1 = this.l * 2;
    float f2 = this.h;
    float f3 = f1 / f2;
    this.k = f3;
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.LineBarView
 * JD-Core Version:    0.6.0
 */