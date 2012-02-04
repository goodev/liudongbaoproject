package com.mymoney.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.mymoney.ui.helper.CategoryIconResourcesHelper;

public class CategoryIconPicker extends RadioButton
{
  private int a;
  private int b;
  private Drawable c;
  private String d;
  private int e;

  public CategoryIconPicker(Context paramContext)
  {
    this(paramContext, null);
  }

  public CategoryIconPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public String a()
  {
    return this.d;
  }

  public void a(String paramString)
  {
    this.d = paramString;
    int i = Integer.valueOf(CategoryIconResourcesHelper.a(paramString)).intValue();
    this.e = i;
    Resources localResources = getResources();
    int j = this.e;
    Drawable localDrawable = localResources.getDrawable(j);
    this.c = localDrawable;
    invalidate();
  }

  public int b()
  {
    return this.e;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.c == null)
      return;
    int i = this.c.getIntrinsicWidth();
    int j = this.c.getIntrinsicHeight();
    int k = getMeasuredWidth() / 2;
    this.a = k;
    int m = getMeasuredHeight() / 2;
    this.b = m;
    int n = this.a;
    int i1 = i / 2;
    int i2 = n - i1;
    int i3 = this.b;
    int i4 = j / 2;
    int i5 = i3 - i4;
    Drawable localDrawable = this.c;
    int i6 = i + i2;
    int i7 = j + i5;
    localDrawable.setBounds(i2, i5, i6, i7);
    this.c.draw(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.CategoryIconPicker
 * JD-Core Version:    0.6.0
 */