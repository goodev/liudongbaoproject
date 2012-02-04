package com.mymoney.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.View;
import b;

public class ReportBarView extends View
{
  public static float a;
  private static final int[] c;
  private String b;
  private Paint d;
  private int e;
  private int f;
  private float g;
  private int h;
  private int i;
  private Bitmap j;
  private Bitmap k;
  private NinePatchDrawable l;
  private Drawable m;
  private boolean n;

  static
  {
    int[] arrayOfInt = new int[11];
    int i1 = Color.rgb(255, 0, 68);
    arrayOfInt[0] = i1;
    int i2 = Color.rgb(5, 173, 207);
    arrayOfInt[1] = i2;
    int i3 = Color.rgb(4, 227, 66);
    arrayOfInt[2] = i3;
    int i4 = Color.rgb(255, 145, 0);
    arrayOfInt[3] = i4;
    int i5 = Color.rgb(193, 18, 213);
    arrayOfInt[4] = i5;
    int i6 = Color.rgb(255, 0, 0);
    arrayOfInt[5] = i6;
    int i7 = Color.rgb(74, 91, 255);
    arrayOfInt[6] = i7;
    int i8 = Color.rgb(186, 255, 38);
    arrayOfInt[7] = i8;
    int i9 = Color.rgb(239, 197, 0);
    arrayOfInt[8] = i9;
    int i10 = Color.rgb(120, 120, 120);
    arrayOfInt[9] = i10;
    arrayOfInt[10] = -16776961;
    c = arrayOfInt;
    a = 0.03F;
  }

  public ReportBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    String str = ReportBarView.class.getSimpleName();
    this.b = str;
    this.e = 225;
    this.f = 12;
    this.n = 0;
    int[] arrayOfInt = b.e;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
    Bitmap localBitmap1 = BitmapFactory.decodeResource(paramContext.getResources(), 2130838142);
    this.j = localBitmap1;
    try
    {
      Bitmap localBitmap2 = this.j;
      byte[] arrayOfByte = this.j.getNinePatchChunk();
      NinePatch localNinePatch = new NinePatch(localBitmap2, arrayOfByte, null);
      NinePatchDrawable localNinePatchDrawable = new NinePatchDrawable(localNinePatch);
      this.l = localNinePatchDrawable;
      if (this.n)
      {
        Bitmap localBitmap3 = BitmapFactory.decodeResource(paramContext.getResources(), 2130838141);
        this.k = localBitmap3;
        Bitmap localBitmap4 = this.k;
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(localBitmap4);
        this.m = localBitmapDrawable;
      }
      a(paramContext);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        this.n = 1;
    }
  }

  private void a(Context paramContext)
  {
    Paint localPaint1 = new Paint();
    this.d = localPaint1;
    this.d.setAntiAlias(1);
    this.d.setTextSize(20.0F);
    Paint localPaint2 = this.d;
    Paint.Align localAlign = Paint.Align.LEFT;
    localPaint2.setTextAlign(localAlign);
  }

  public void a(float paramFloat1, int paramInt, float paramFloat2)
  {
    float f1 = a;
    if (paramFloat1 > f1);
    float f4;
    for (this.g = paramFloat1; ; this.g = f4)
    {
      float f2 = this.g;
      float f3 = this.e;
      int i1 = (int)(f2 * f3 * paramFloat2);
      this.h = i1;
      int i2 = (int)(this.f * paramFloat2);
      this.f = i2;
      this.i = paramInt;
      invalidate();
      return;
      f4 = a;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Paint localPaint1 = this.d;
    int[] arrayOfInt = c;
    int i1 = this.i;
    int i2 = c.length;
    int i3 = i1 % i2;
    int i4 = arrayOfInt[i3];
    localPaint1.setColor(i4);
    int i5 = this.h;
    int i6 = this.f;
    Rect localRect = new Rect(0, 0, i5, i6);
    Paint localPaint2 = this.d;
    paramCanvas.drawRect(localRect, localPaint2);
    if (this.n)
    {
      Drawable localDrawable = this.m;
      int i7 = this.h;
      int i8 = this.f;
      localDrawable.setBounds(0, 0, i7, i8);
      this.m.draw(paramCanvas);
      return;
    }
    NinePatchDrawable localNinePatchDrawable = this.l;
    int i9 = this.h;
    int i10 = this.f;
    localNinePatchDrawable.setBounds(0, 0, i9, i10);
    this.l.draw(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.ReportBarView
 * JD-Core Version:    0.6.0
 */