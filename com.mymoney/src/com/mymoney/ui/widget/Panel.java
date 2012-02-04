package com.mymoney.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import b;
import tl;
import tm;
import tn;
import to;
import tp;
import tq;

public class Panel extends LinearLayout
{
  private Animation.AnimationListener A;
  View.OnTouchListener a;
  View.OnClickListener b;
  public Runnable c;
  private boolean d;
  private int e;
  private int f;
  private boolean g;
  private int h;
  private int i;
  private View j;
  private View k;
  private Drawable l;
  private Drawable m;
  private float n;
  private float o;
  private float p;
  private Panel.OnPanelListener q;
  private tq r;
  private Interpolator s;
  private GestureDetector t;
  private int u;
  private int v;
  private int w;
  private float x;
  private tp y;
  private boolean z;

  public Panel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    tl localtl = new tl(this);
    this.a = localtl;
    tm localtm = new tm(this);
    this.b = localtm;
    tn localtn = new tn(this);
    this.c = localtn;
    to localto = new to(this);
    this.A = localto;
    int[] arrayOfInt = b.d;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
    int i1 = localTypedArray.getInteger(0, 750);
    this.f = i1;
    int i2 = localTypedArray.getInteger(1, 1);
    this.e = i2;
    boolean bool = localTypedArray.getBoolean(4, 0);
    this.g = bool;
    float f1 = localTypedArray.getFraction(5, 0, 1, 0.0F);
    this.x = f1;
    if ((this.x < 0.0F) || (this.x > 1.0F))
    {
      this.x = 0.0F;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1 = localTypedArray.getPositionDescription();
      String str2 = str1 + ": weight must be > 0 and <= 1";
      int i3 = Log.w("Panel", str2);
    }
    Drawable localDrawable1 = localTypedArray.getDrawable(6);
    this.l = localDrawable1;
    Drawable localDrawable2 = localTypedArray.getDrawable(7);
    this.m = localDrawable2;
    IllegalArgumentException localIllegalArgumentException = null;
    int i4 = localTypedArray.getResourceId(2, 0);
    this.h = i4;
    if (this.h == 0)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str3 = localTypedArray.getPositionDescription();
      String str4 = str3 + ": The handle attribute is required and must refer to a valid child.";
      localIllegalArgumentException = new IllegalArgumentException(str4);
    }
    int i5 = localTypedArray.getResourceId(3, 0);
    this.i = i5;
    if (this.i == 0)
    {
      StringBuilder localStringBuilder3 = new StringBuilder();
      String str5 = localTypedArray.getPositionDescription();
      String str6 = str5 + ": The content attribute is required and must refer to a valid child.";
      localIllegalArgumentException = new IllegalArgumentException(str6);
    }
    localTypedArray.recycle();
    if (localIllegalArgumentException != null)
      throw localIllegalArgumentException;
    if ((this.e == 0) || (this.e == 1));
    for (int i6 = 1; ; i6 = 0)
    {
      this.w = i6;
      int i7 = this.w;
      setOrientation(i7);
      tq localtq = tq.c;
      this.r = localtq;
      tp localtp1 = new tp(this);
      this.y = localtp1;
      tp localtp2 = this.y;
      GestureDetector localGestureDetector = new GestureDetector(localtp2);
      this.t = localGestureDetector;
      this.t.setIsLongpressEnabled(0);
      setBaselineAligned(0);
      return;
    }
  }

  private float a(float paramFloat, int paramInt1, int paramInt2)
  {
    float f1 = paramInt1;
    float f2 = Math.max(paramFloat, f1);
    float f3 = paramInt2;
    return Math.min(f2, f3);
  }

  private void c()
  {
    if (this.q == null)
      return;
    if (this.d)
    {
      this.q.a(this);
      return;
    }
    this.q.b(this);
  }

  public void a(Interpolator paramInterpolator)
  {
    this.s = paramInterpolator;
  }

  public void a(Panel.OnPanelListener paramOnPanelListener)
  {
    this.q = paramOnPanelListener;
  }

  public boolean a()
  {
    if (this.k.getVisibility() == 0);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    tq localtq1 = this.r;
    tq localtq2 = tq.c;
    int i1;
    if ((localtq1 == localtq2) && ((a() ^ paramBoolean1)))
      if (!paramBoolean1)
      {
        i1 = 1;
        this.d = i1;
        if (!paramBoolean2)
          break label96;
        tq localtq3 = tq.a;
        this.r = localtq3;
        if (!this.d)
          this.k.setVisibility(0);
        Runnable localRunnable = this.c;
        boolean bool = post(localRunnable);
      }
    for (int i2 = 1; ; i2 = 0)
    {
      return i2;
      i1 = 0;
      break;
      label96: View localView = this.k;
      if (paramBoolean1);
      for (int i3 = 0; ; i3 = 8)
      {
        localView.setVisibility(i3);
        c();
        break;
      }
    }
  }

  public boolean b()
  {
    tq localtq1 = this.r;
    tq localtq2 = tq.c;
    int i1;
    if (localtq1 != localtq2)
    {
      i1 = 0;
      return i1;
    }
    tq localtq3 = tq.a;
    this.r = localtq3;
    if (this.k.getVisibility() == 0);
    for (int i2 = 1; ; i2 = 0)
    {
      this.d = i2;
      if (!this.d)
        this.k.setVisibility(0);
      i1 = 1;
      break;
    }
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    tq localtq1 = this.r;
    tq localtq2 = tq.a;
    int i1;
    if ((localtq1 == localtq2) && (!this.d))
    {
      if (this.w != 1)
        break label138;
      i1 = this.u;
      if ((this.e == 2) || (this.e == 0))
        i1 = -i1;
      if (this.w != 1)
        break label147;
      float f1 = i1;
      paramCanvas.translate(0.0F, f1);
    }
    while (true)
    {
      tq localtq3 = this.r;
      tq localtq4 = tq.d;
      if (localtq3 != localtq4)
      {
        tq localtq5 = this.r;
        tq localtq6 = tq.e;
        if (localtq5 != localtq6);
      }
      else
      {
        float f2 = this.n;
        float f3 = this.o;
        paramCanvas.translate(f2, f3);
      }
      super.dispatchDraw(paramCanvas);
      return;
      label138: i1 = this.v;
      break;
      label147: float f4 = i1;
      paramCanvas.translate(f4, 0.0F);
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if (localViewParent == null)
      return;
    if (!(localViewParent instanceof FrameLayout))
      return;
    this.z = 1;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int i1 = this.h;
    View localView1 = findViewById(i1);
    this.j = localView1;
    if (this.j == null)
    {
      Resources localResources1 = getResources();
      int i2 = this.h;
      String str1 = localResources1.getResourceEntryName(i2);
      String str2 = "Your Panel must have a child View whose id attribute is 'R.id." + str1 + "'";
      throw new RuntimeException(str2);
    }
    View localView2 = this.j;
    View.OnTouchListener localOnTouchListener = this.a;
    localView2.setOnTouchListener(localOnTouchListener);
    View localView3 = this.j;
    View.OnClickListener localOnClickListener = this.b;
    localView3.setOnClickListener(localOnClickListener);
    int i3 = this.i;
    View localView4 = findViewById(i3);
    this.k = localView4;
    if (this.k == null)
    {
      Resources localResources2 = getResources();
      int i4 = this.h;
      String str3 = localResources2.getResourceEntryName(i4);
      String str4 = "Your Panel must have a child View whose id attribute is 'R.id." + str3 + "'";
      throw new RuntimeException(str4);
    }
    View localView5 = this.j;
    removeView(localView5);
    View localView6 = this.k;
    removeView(localView6);
    ViewGroup.LayoutParams localLayoutParams;
    if ((this.e == 0) || (this.e == 2))
    {
      View localView7 = this.k;
      addView(localView7);
      View localView8 = this.j;
      addView(localView8);
      if (this.m != null)
      {
        View localView9 = this.j;
        Drawable localDrawable = this.m;
        localView9.setBackgroundDrawable(localDrawable);
      }
      this.k.setClickable(1);
      this.k.setVisibility(8);
      if (this.x <= 0.0F)
        return;
      localLayoutParams = this.k.getLayoutParams();
      if (this.w != 1)
        break label389;
      localLayoutParams.height = -1;
    }
    while (true)
    {
      this.k.setLayoutParams(localLayoutParams);
      return;
      View localView10 = this.j;
      addView(localView10);
      View localView11 = this.k;
      addView(localView11);
      break;
      label389: localLayoutParams.width = -1;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    int i1 = this.k.getWidth();
    this.v = i1;
    int i2 = this.k.getHeight();
    this.u = i2;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView;
    int i1;
    int i2;
    if ((this.x > 0.0F) && (this.k.getVisibility() == 0))
    {
      localView = (View)getParent();
      if (localView != null)
        if (this.w == 1)
        {
          float f1 = localView.getHeight();
          float f2 = this.x;
          i1 = View.MeasureSpec.makeMeasureSpec((int)(f1 * f2), 1073741824);
          i2 = paramInt1;
        }
    }
    while (true)
    {
      super.onMeasure(i2, i1);
      return;
      float f3 = localView.getWidth();
      float f4 = this.x;
      i2 = View.MeasureSpec.makeMeasureSpec((int)(f3 * f4), 1073741824);
      i1 = paramInt2;
      continue;
      i1 = paramInt2;
      i2 = paramInt1;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.Panel
 * JD-Core Version:    0.6.0
 */