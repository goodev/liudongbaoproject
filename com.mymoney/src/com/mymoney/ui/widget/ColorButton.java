package com.mymoney.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class ColorButton extends Button
{
  int a;
  Drawable b;
  long c;

  public ColorButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }

  private void a(int paramInt, Canvas paramCanvas)
  {
    Drawable localDrawable = this.b.mutate();
    int i = 255 - paramInt;
    localDrawable.setAlpha(i);
    this.b.draw(paramCanvas);
  }

  private void b()
  {
    Drawable localDrawable = getResources().getDrawable(2130837556);
    this.b = localDrawable;
    this.a = 16775091;
    TextPaint localTextPaint = getPaint();
    int i = getTextColors().getDefaultColor();
    localTextPaint.setColor(i);
    this.c = 65535L;
  }

  private void c()
  {
    int i = this.b.getIntrinsicWidth();
    int j = this.b.getIntrinsicHeight();
    int k = (getWidth() - i) / 2;
    int m = (getHeight() - j) / 2;
    Drawable localDrawable = this.b;
    int n = i + k;
    int i1 = j + m;
    localDrawable.setBounds(k, m, n, i1);
  }

  public void a()
  {
    long l = System.currentTimeMillis();
    this.c = l;
    invalidate();
  }

  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.c != 65535L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.c;
      int i = (int)(l1 - l2);
      if (i >= 255)
      {
        this.c = 65535L;
        return;
      }
      a(i, paramCanvas);
      postInvalidateDelayed(10L);
      return;
    }
    if (isPressed())
    {
      a(0, paramCanvas);
      return;
    }
    a(255, paramCanvas);
  }

  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 0) || (i == 3))
      invalidate();
    while (true)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (i != 1)
        continue;
      a();
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.ColorButton
 * JD-Core Version:    0.6.0
 */