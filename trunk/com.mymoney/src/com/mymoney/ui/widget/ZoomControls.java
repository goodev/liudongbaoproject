package com.mymoney.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.ZoomButton;

public class ZoomControls extends LinearLayout
{
  private final ZoomButton a;
  private final ZoomButton b;

  public ZoomControls(Context paramContext)
  {
    this(paramContext, null);
  }

  public ZoomControls(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(0);
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903130, this, 1);
    ZoomButton localZoomButton1 = (ZoomButton)findViewById(2131231172);
    this.a = localZoomButton1;
    ZoomButton localZoomButton2 = (ZoomButton)findViewById(2131231171);
    this.b = localZoomButton2;
  }

  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setDuration(500L);
    startAnimation(localAlphaAnimation);
    setVisibility(paramInt);
  }

  public void a()
  {
    a(0, 0.0F, 1.0F);
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }

  public void a(boolean paramBoolean)
  {
    this.a.setEnabled(paramBoolean);
  }

  public void b()
  {
    a(8, 1.0F, 0.0F);
  }

  public void b(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(paramOnClickListener);
  }

  public void b(boolean paramBoolean)
  {
    this.b.setEnabled(paramBoolean);
  }

  public boolean hasFocus()
  {
    if ((this.a.hasFocus()) || (this.b.hasFocus()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.ZoomControls
 * JD-Core Version:    0.6.0
 */