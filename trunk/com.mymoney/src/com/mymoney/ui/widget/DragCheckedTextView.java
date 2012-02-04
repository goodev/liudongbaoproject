package com.mymoney.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.Checkable;
import android.widget.TextView;

public class DragCheckedTextView extends TextView
  implements Checkable
{
  private static final int[] g;
  private Drawable a;
  private boolean b;
  private Drawable c;
  private int d;
  private int e;
  private int f;

  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16842912;
    g = arrayOfInt;
  }

  public DragCheckedTextView(Context paramContext)
  {
    this(paramContext, null);
  }

  public DragCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DragCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Drawable localDrawable = getResources().getDrawable(2130838092);
    if (localDrawable != null)
      a(localDrawable);
    int i = getPaddingRight();
    this.d = i;
  }

  public void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (this.c != null)
      {
        this.c.setCallback(null);
        Drawable localDrawable = this.c;
        unscheduleDrawable(localDrawable);
      }
      paramDrawable.setCallback(this);
      if (getVisibility() == 0)
      {
        int i = 1;
        boolean bool1 = paramDrawable.setVisible(i, 0);
        int[] arrayOfInt1 = g;
        boolean bool2 = paramDrawable.setState(arrayOfInt1);
        int k = paramDrawable.getIntrinsicHeight();
        setMinHeight(k);
        int m = paramDrawable.getIntrinsicWidth();
        this.e = m;
        int n = this.e;
        int i1 = this.d;
        int i2 = n + i1;
        this.f = i2;
        int[] arrayOfInt2 = getDrawableState();
        boolean bool3 = paramDrawable.setState(arrayOfInt2);
        this.c = paramDrawable;
      }
    }
    while (true)
    {
      requestLayout();
      return;
      int j = 0;
      break;
      int i3 = this.d;
      this.f = i3;
    }
  }

  public void b(Drawable paramDrawable)
  {
    this.a = paramDrawable;
    invalidate();
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.c == null)
      return;
    int[] arrayOfInt = getDrawableState();
    boolean bool = this.c.setState(arrayOfInt);
    invalidate();
  }

  public boolean isChecked()
  {
    return this.b;
  }

  protected int[] onCreateDrawableState(int paramInt)
  {
    int i = paramInt + 1;
    int[] arrayOfInt1 = super.onCreateDrawableState(i);
    if (isChecked())
    {
      int[] arrayOfInt2 = g;
      int[] arrayOfInt3 = mergeDrawableStates(arrayOfInt1, arrayOfInt2);
    }
    return arrayOfInt1;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Drawable localDrawable1 = getResources().getDrawable(2130837742);
    int i;
    int j;
    if (localDrawable1 != null)
    {
      i = getGravity() & 0x70;
      j = localDrawable1.getIntrinsicHeight();
    }
    int k;
    int i4;
    int i5;
    label163: Drawable localDrawable3;
    int i10;
    switch (i)
    {
    default:
      k = 0;
      int m = getWidth();
      int n = localDrawable1.getIntrinsicWidth();
      int i1 = m - n;
      int i2 = j + k;
      localDrawable1.setBounds(i1, k, m, i2);
      localDrawable1.draw(paramCanvas);
      int i3;
      if (this.a != null)
      {
        i3 = getGravity() & 0x70;
        i4 = this.a.getIntrinsicHeight();
      }
      switch (i3)
      {
      default:
        i5 = 0;
        float f1 = getResources().getDisplayMetrics().density;
        int i6 = (int)(11.0F * f1);
        Drawable localDrawable2 = this.a;
        int i7 = this.a.getIntrinsicWidth() + i6;
        int i8 = i4 + i5;
        localDrawable2.setBounds(i6, i5, i7, i8);
        this.a.draw(paramCanvas);
        localDrawable3 = this.c;
        if (localDrawable3 == null)
          return;
        int i9 = getGravity() & 0x70;
        i10 = localDrawable3.getIntrinsicHeight();
        switch (i9)
        {
        default:
          k = 0;
        case 80:
        case 16:
        }
      case 80:
      case 16:
      }
    case 80:
    case 16:
    }
    while (true)
    {
      int i11 = getWidth();
      int i12 = this.e;
      int i13 = i11 - i12;
      int i14 = this.d;
      int i15 = i13 - i14;
      int i16 = this.d;
      int i17 = i11 - i16;
      int i18 = i10 + k;
      localDrawable3.setBounds(i15, k, i17, i18);
      localDrawable3.draw(paramCanvas);
      return;
      k = getHeight() - j;
      break;
      k = (getHeight() - j) / 2;
      break;
      i5 = getHeight() - i4;
      break label163;
      i5 = (getHeight() - i4) / 2;
      break label163;
      k = getHeight() - i10;
      continue;
      k = (getHeight() - i10) / 2;
    }
  }

  public void setChecked(boolean paramBoolean)
  {
    if (this.b == paramBoolean)
      return;
    this.b = paramBoolean;
    refreshDrawableState();
  }

  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = this.f;
    this.d = i;
  }

  public void toggle()
  {
    if (!this.b);
    int j;
    for (int i = 1; ; j = 0)
    {
      setChecked(i);
      return;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.DragCheckedTextView
 * JD-Core Version:    0.6.0
 */