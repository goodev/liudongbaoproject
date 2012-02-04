package com.mymoney.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.RelativeLayout;

public class CheckedListItem extends RelativeLayout
  implements Checkable
{
  private static final int[] g;
  private boolean a;
  private Drawable b;
  private int c;
  private int d;
  private int e;
  private boolean f;

  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16842912;
    g = arrayOfInt;
  }

  public CheckedListItem(Context paramContext)
  {
    this(paramContext, null);
  }

  public CheckedListItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public CheckedListItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Drawable localDrawable = paramContext.getResources().getDrawable(2130838092);
    if (localDrawable != null)
      a(localDrawable);
    setChecked(1);
  }

  private void a(Canvas paramCanvas)
  {
    Drawable localDrawable = getResources().getDrawable(2130837742);
    if (localDrawable == null)
      return;
    int i = localDrawable.getIntrinsicHeight();
    int j = (getHeight() - i) / 2;
    int k = getWidth();
    int m = localDrawable.getIntrinsicWidth();
    int n = k - m;
    int i1 = i + j;
    localDrawable.setBounds(n, j, k, i1);
    localDrawable.draw(paramCanvas);
  }

  public void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (this.b != null)
      {
        this.b.setCallback(null);
        Drawable localDrawable = this.b;
        unscheduleDrawable(localDrawable);
      }
      paramDrawable.setCallback(this);
      if (getVisibility() == 0)
      {
        int i = 1;
        boolean bool1 = paramDrawable.setVisible(i, 0);
        int[] arrayOfInt1 = g;
        boolean bool2 = paramDrawable.setState(arrayOfInt1);
        int k = paramDrawable.getIntrinsicWidth();
        this.d = k;
        int m = this.d;
        int n = this.c;
        int i1 = m + n;
        this.e = i1;
        int[] arrayOfInt2 = getDrawableState();
        boolean bool3 = paramDrawable.setState(arrayOfInt2);
      }
    }
    while (true)
    {
      this.b = paramDrawable;
      requestLayout();
      return;
      int j = 0;
      break;
      int i2 = this.c;
      this.e = i2;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    invalidate();
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.b == null)
      return;
    int[] arrayOfInt = getDrawableState();
    boolean bool = this.b.setState(arrayOfInt);
    invalidate();
  }

  public boolean isChecked()
  {
    return this.a;
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
    Drawable localDrawable = this.b;
    if (localDrawable != null)
    {
      int i = localDrawable.getIntrinsicHeight();
      int j = (getHeight() - i) / 2;
      int k = getWidth();
      int m = this.d;
      int n = k - m;
      int i1 = this.c;
      int i2 = n - i1;
      int i3 = this.c;
      int i4 = k - i3;
      int i5 = i + j;
      localDrawable.setBounds(i2, j, i4, i5);
      localDrawable.draw(paramCanvas);
    }
    if (!this.f)
      return;
    a(paramCanvas);
  }

  public void setChecked(boolean paramBoolean)
  {
    if (this.a == paramBoolean)
      return;
    this.a = paramBoolean;
    refreshDrawableState();
  }

  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = paramInt3;
  }

  public void toggle()
  {
    if (!this.a);
    int j;
    for (int i = 1; ; j = 0)
    {
      setChecked(i);
      return;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.CheckedListItem
 * JD-Core Version:    0.6.0
 */