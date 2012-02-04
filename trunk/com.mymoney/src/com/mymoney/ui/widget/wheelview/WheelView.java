package com.mymoney.ui.widget.wheelview;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.LinearLayout;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import up;
import uq;
import ur;
import us;
import vd;
import ve;
import vh;
import vi;
import vj;
import vn;

public class WheelView extends View
{
  private static final int[] c = { -15658735, 11184810, 11184810 };
  boolean a = 0;
  vh b;
  private int d = 0;
  private int e = 5;
  private int f = 0;
  private Drawable g;
  private GradientDrawable h;
  private GradientDrawable i;
  private ve j;
  private boolean k;
  private int l;
  private LinearLayout m;
  private int n;
  private vn o;
  private vd p;
  private List q;
  private List r;
  private List s;
  private DataSetObserver t;

  public WheelView(Context paramContext)
  {
    super(paramContext);
    vd localvd = new vd(this);
    this.p = localvd;
    LinkedList localLinkedList1 = new LinkedList();
    this.q = localLinkedList1;
    LinkedList localLinkedList2 = new LinkedList();
    this.r = localLinkedList2;
    LinkedList localLinkedList3 = new LinkedList();
    this.s = localLinkedList3;
    vi localvi = new vi(this);
    this.b = localvi;
    vj localvj = new vj(this);
    this.t = localvj;
    a(paramContext);
  }

  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    vd localvd = new vd(this);
    this.p = localvd;
    LinkedList localLinkedList1 = new LinkedList();
    this.q = localLinkedList1;
    LinkedList localLinkedList2 = new LinkedList();
    this.r = localLinkedList2;
    LinkedList localLinkedList3 = new LinkedList();
    this.s = localLinkedList3;
    vi localvi = new vi(this);
    this.b = localvi;
    vj localvj = new vj(this);
    this.t = localvj;
    a(paramContext);
  }

  public WheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    vd localvd = new vd(this);
    this.p = localvd;
    LinkedList localLinkedList1 = new LinkedList();
    this.q = localLinkedList1;
    LinkedList localLinkedList2 = new LinkedList();
    this.r = localLinkedList2;
    LinkedList localLinkedList3 = new LinkedList();
    this.s = localLinkedList3;
    vi localvi = new vi(this);
    this.b = localvi;
    vj localvj = new vj(this);
    this.t = localvj;
    a(paramContext);
  }

  private int a(LinearLayout paramLinearLayout)
  {
    if ((paramLinearLayout != null) && (paramLinearLayout.getChildAt(0) != null))
    {
      int i1 = paramLinearLayout.getChildAt(0).getMeasuredHeight();
      this.f = i1;
    }
    int i2 = this.f;
    int i3 = this.e;
    int i4 = i2 * i3;
    int i5 = this.f * 10 / 50;
    int i6 = i4 - i5;
    int i7 = getSuggestedMinimumHeight();
    return Math.max(i6, i7);
  }

  private void a(Context paramContext)
  {
    Context localContext = getContext();
    vh localvh = this.b;
    ve localve = new ve(localContext, localvh);
    this.j = localve;
  }

  private void a(Canvas paramCanvas)
  {
    double d1 = g();
    int i1 = (int)(1.5D * d1);
    GradientDrawable localGradientDrawable1 = this.h;
    int i2 = getWidth();
    localGradientDrawable1.setBounds(0, 0, i2, i1);
    this.h.draw(paramCanvas);
    GradientDrawable localGradientDrawable2 = this.i;
    int i3 = getHeight() - i1;
    int i4 = getWidth();
    int i5 = getHeight();
    localGradientDrawable2.setBounds(0, i3, i4, i5);
    this.i.draw(paramCanvas);
  }

  private void b(Canvas paramCanvas)
  {
    int i1 = paramCanvas.save();
    int i2 = this.d;
    int i3 = this.n;
    int i4 = i2 - i3;
    int i5 = g();
    int i6 = i4 * i5;
    int i7 = g();
    int i8 = getHeight();
    int i9 = (i7 - i8) / 2;
    int i10 = -(i6 + i9);
    int i11 = this.l;
    float f1 = i10 + i11;
    paramCanvas.translate(20.0F, f1);
    this.m.draw(paramCanvas);
    paramCanvas.restore();
  }

  private int c(int paramInt1, int paramInt2)
  {
    f();
    LinearLayout localLinearLayout1 = this.m;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    localLinearLayout1.setLayoutParams(localLayoutParams);
    LinearLayout localLinearLayout2 = this.m;
    int i1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    localLinearLayout2.measure(i1, i2);
    int i3 = this.m.getMeasuredWidth();
    if (paramInt2 == 1073741824);
    for (int i4 = paramInt1; ; i4 = paramInt1)
      do
      {
        LinearLayout localLinearLayout3 = this.m;
        int i5 = View.MeasureSpec.makeMeasureSpec(i4 - 40, 1073741824);
        int i6 = View.MeasureSpec.makeMeasureSpec(0, 0);
        localLinearLayout3.measure(i5, i6);
        return i4;
        int i7 = i3 + 40;
        int i8 = getSuggestedMinimumWidth();
        i4 = Math.max(i7, i8);
      }
      while ((paramInt2 != -2147483648) || (paramInt1 >= i4));
  }

  private void c(Canvas paramCanvas)
  {
    int i1 = getHeight() / 2;
    int i2 = (int)(g() / 2 * 1.2D);
    Drawable localDrawable = this.g;
    int i3 = i1 - i2;
    int i4 = getWidth();
    int i5 = i1 + i2;
    localDrawable.setBounds(0, i3, i4, i5);
    this.g.draw(paramCanvas);
  }

  private boolean c(int paramInt, boolean paramBoolean)
  {
    View localView = f(paramInt);
    if (localView != null)
      if (paramBoolean)
        this.m.addView(localView, 0);
    for (int i1 = 1; ; i1 = 0)
    {
      return i1;
      this.m.addView(localView);
      break;
    }
  }

  private void d(int paramInt)
  {
    int i1 = this.l + paramInt;
    this.l = i1;
    int i2 = g();
    int i3 = this.l / i2;
    int i4 = this.d - i3;
    int i5 = this.o.a();
    int i6 = this.l % i2;
    int i7 = Math.abs(i6);
    int i8 = i2 / 2;
    if (i7 <= i8)
      i6 = 0;
    int i12;
    int i13;
    if ((this.a) && (i5 > 0))
      if (i6 > 0)
      {
        int i9 = i4 + -1;
        int i10 = i3 + 1;
        int i11 = i9;
        i12 = i10;
        i13 = i11;
      }
    while (true)
    {
      if (i13 < 0)
      {
        i13 += i5;
        continue;
        if (i6 < 0)
        {
          int i14 = i4 + 1;
          int i15 = i3 + -1;
          int i16 = i14;
          i12 = i15;
          i13 = i16;
          continue;
        }
      }
      else
      {
        int i17 = i13 % i5;
        while (true)
        {
          int i18 = this.l;
          int i19 = this.d;
          if (i17 != i19)
            a(i17, 0);
          while (true)
          {
            int i20 = i2 * i12;
            int i21 = i18 - i20;
            this.l = i21;
            int i22 = this.l;
            int i23 = getHeight();
            if (i22 <= i23)
              return;
            int i24 = this.l;
            int i25 = getHeight();
            int i26 = i24 % i25;
            int i27 = getHeight();
            int i28 = i26 + i27;
            this.l = i28;
            return;
            if (i4 < 0)
            {
              i12 = this.d;
              i17 = 0;
              break;
            }
            if (i4 >= i5)
            {
              int i29 = this.d - i5 + 1;
              int i30 = i5 - 1;
              i12 = i29;
              i17 = i30;
              break;
            }
            if ((i4 > 0) && (i6 > 0))
            {
              int i31 = i4 + -1;
              int i32 = i3 + 1;
              int i33 = i31;
              i12 = i32;
              i17 = i33;
              break;
            }
            int i34 = i5 - 1;
            if ((i4 >= i34) || (i6 >= 0))
              break label420;
            int i35 = i4 + 1;
            int i36 = i3 + -1;
            int i37 = i35;
            i12 = i36;
            i17 = i37;
            break;
            invalidate();
          }
          label420: int i38 = i4;
          i12 = i3;
          i17 = i38;
        }
      }
      int i39 = i4;
      i12 = i3;
      i13 = i39;
    }
  }

  private void d(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1 - 40;
    this.m.layout(0, 0, i1, paramInt2);
  }

  private boolean e(int paramInt)
  {
    if ((this.o != null) && (this.o.a() > 0))
      if (!this.a)
      {
        if (paramInt < 0)
          break label49;
        int i1 = this.o.a();
        if (paramInt >= i1)
          break label49;
      }
    label49: for (int i2 = 1; ; i2 = 0)
      return i2;
  }

  private View f(int paramInt)
  {
    if ((this.o == null) || (this.o.a() == 0));
    vn localvn1;
    View localView2;
    LinearLayout localLinearLayout1;
    for (View localView1 = null; ; localView1 = localvn1.a(localView2, localLinearLayout1))
    {
      return localView1;
      int i1 = this.o.a();
      if (e(paramInt))
        break;
      localvn1 = this.o;
      localView2 = this.p.b();
      localLinearLayout1 = this.m;
    }
    while (true)
    {
      int i2;
      int i3;
      if (i2 < 0)
      {
        int i4 = i2 + i3;
        continue;
      }
      int i5 = i2 % i3;
      vn localvn2 = this.o;
      View localView3 = this.p.a();
      LinearLayout localLinearLayout2 = this.m;
      localView1 = localvn2.a(i5, localView3, localLinearLayout2);
      break;
      int i6 = paramInt;
    }
  }

  private void f()
  {
    if (this.g == null)
    {
      Drawable localDrawable = getContext().getResources().getDrawable(2130838146);
      this.g = localDrawable;
    }
    if (this.h == null)
    {
      GradientDrawable.Orientation localOrientation1 = GradientDrawable.Orientation.TOP_BOTTOM;
      int[] arrayOfInt1 = c;
      GradientDrawable localGradientDrawable1 = new GradientDrawable(localOrientation1, arrayOfInt1);
      this.h = localGradientDrawable1;
    }
    if (this.i == null)
    {
      GradientDrawable.Orientation localOrientation2 = GradientDrawable.Orientation.BOTTOM_TOP;
      int[] arrayOfInt2 = c;
      GradientDrawable localGradientDrawable2 = new GradientDrawable(localOrientation2, arrayOfInt2);
      this.i = localGradientDrawable2;
    }
    setBackgroundResource(2130838145);
  }

  private int g()
  {
    int i1;
    if (this.f != 0)
      i1 = this.f;
    while (true)
    {
      return i1;
      if ((this.m != null) && (this.m.getChildAt(0) != null))
      {
        int i2 = this.m.getChildAt(0).getHeight();
        this.f = i2;
        i1 = this.f;
        continue;
      }
      int i3 = getHeight();
      int i4 = this.e;
      i1 = i3 / i4;
    }
  }

  private up h()
  {
    if (g() == 0);
    int i3;
    int i4;
    for (up localup = null; ; localup = new up(i3, i4))
    {
      return localup;
      int i1 = this.d;
      int i2 = 1;
      i3 = i1;
      i4 = i2;
      while (true)
      {
        int i5 = g() * i4;
        int i6 = getHeight();
        if (i5 >= i6)
          break;
        i3 += -1;
        i4 += 2;
      }
      if (this.l == 0)
        continue;
      if (this.l > 0)
        i3 += -1;
      int i7 = i4 + 1;
      int i8 = this.l;
      int i9 = g();
      int i10 = i8 / i9;
      i3 -= i10;
      double d1 = i7;
      double d2 = Math.asin(i10);
      i4 = (int)(d1 + d2);
    }
  }

  private boolean i()
  {
    up localup = h();
    int i3;
    int i4;
    label60: label109: int i13;
    if (this.m != null)
    {
      vd localvd = this.p;
      LinearLayout localLinearLayout = this.m;
      int i1 = this.n;
      int i2 = localvd.a(localLinearLayout, i1, localup);
      if (this.n != i2)
      {
        i3 = 1;
        this.n = i2;
        i4 = i3;
        if (i4 == 0)
        {
          int i5 = this.n;
          int i6 = localup.a();
          if (i5 == i6)
          {
            int i7 = this.m.getChildCount();
            int i8 = localup.c();
            if (i7 == i8)
              break label277;
          }
          i4 = 1;
        }
        int i9 = this.n;
        int i10 = localup.a();
        if (i9 <= i10)
          break label299;
        int i11 = this.n;
        int i12 = localup.b();
        if (i11 > i12)
          break label299;
        i13 = this.n - 1;
        label155: int i14 = localup.a();
        if ((i13 >= i14) && (c(i13, 1)))
          break label283;
      }
    }
    int i17;
    while (true)
    {
      int i15 = this.n;
      int i16 = this.m.getChildCount();
      i17 = i15;
      int i18 = i16;
      while (true)
      {
        int i19 = localup.c();
        if (i18 >= i19)
          break;
        int i20 = this.n + i18;
        if ((!c(i20, 0)) && (this.m.getChildCount() == 0))
          i17 += 1;
        i18 += 1;
      }
      i3 = 0;
      break;
      k();
      i4 = 1;
      break label60;
      label277: i4 = 0;
      break label109;
      label283: this.n = i13;
      i13 += -1;
      break label155;
      label299: int i21 = localup.a();
      this.n = i21;
    }
    this.n = i17;
    return i4;
  }

  private void j()
  {
    if (!i())
      return;
    int i1 = getWidth();
    int i2 = c(i1, 1073741824);
    int i3 = getWidth();
    int i4 = getHeight();
    d(i3, i4);
  }

  private void k()
  {
    if (this.m != null)
      return;
    Context localContext = getContext();
    LinearLayout localLinearLayout = new LinearLayout(localContext);
    this.m = localLinearLayout;
    this.m.setOrientation(1);
  }

  private void l()
  {
    if (this.m != null)
    {
      vd localvd = this.p;
      LinearLayout localLinearLayout = this.m;
      int i1 = this.n;
      up localup = new up();
      int i2 = localvd.a(localLinearLayout, i1, localup);
    }
    while (true)
    {
      int i3 = this.e / 2;
      int i4 = this.d + i3;
      while (true)
      {
        int i5 = this.d - i3;
        if (i4 < i5)
          return;
        if (c(i4, 1))
          this.n = i4;
        i4 += -1;
      }
      k();
    }
  }

  public vn a()
  {
    return this.o;
  }

  public void a(int paramInt)
  {
    this.e = paramInt;
  }

  protected void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.q.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((uq)localIterator.next()).a(this, paramInt1, paramInt2);
    }
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.o == null)
      return;
    if (this.o.a() == 0)
      return;
    int i1 = this.o.a();
    int i2;
    if ((paramInt < 0) || (paramInt >= i1))
    {
      if (!this.a)
        return;
      i2 = paramInt;
      while (i2 < 0)
        i2 += i1;
    }
    for (int i3 = i2 % i1; ; i3 = paramInt)
    {
      int i4 = this.d;
      if (i3 == i4)
        return;
      int i6;
      if (paramBoolean)
      {
        int i5 = this.d;
        i6 = i3 - i5;
        if (!this.a)
          break label218;
        int i7 = this.d;
        int i8 = Math.min(i3, i7);
        int i9 = i1 + i8;
        int i10 = this.d;
        int i11 = Math.max(i3, i10);
        i1 = i9 - i11;
        int i12 = Math.abs(i6);
        if (i1 >= i12)
          break label218;
        if (i6 >= 0);
      }
      while (true)
      {
        b(i1, 0);
        return;
        i1 = -i1;
        continue;
        this.l = 0;
        int i13 = this.d;
        this.d = i3;
        int i14 = this.d;
        a(i13, i14);
        invalidate();
        return;
        label218: i1 = i6;
      }
    }
  }

  public void a(uq paramuq)
  {
    boolean bool = this.q.add(paramuq);
  }

  public void a(us paramus)
  {
    boolean bool = this.r.add(paramus);
  }

  public void a(vn paramvn)
  {
    if (this.o != null)
    {
      vn localvn1 = this.o;
      DataSetObserver localDataSetObserver1 = this.t;
      localvn1.unregisterDataSetObserver(localDataSetObserver1);
    }
    this.o = paramvn;
    if (this.o != null)
    {
      vn localvn2 = this.o;
      DataSetObserver localDataSetObserver2 = this.t;
      localvn2.registerDataSetObserver(localDataSetObserver2);
    }
    b(1);
  }

  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    b(0);
  }

  public void b()
  {
    Iterator localIterator = this.r.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((us)localIterator.next()).a(this);
    }
  }

  protected void b(int paramInt)
  {
    Iterator localIterator = this.s.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((ur)localIterator.next()).a(this, paramInt);
    }
  }

  public void b(int paramInt1, int paramInt2)
  {
    int i1 = g() * paramInt1;
    int i2 = this.l;
    int i3 = i1 - i2;
    this.j.a(i3, paramInt2);
  }

  public void b(int paramInt, boolean paramBoolean)
  {
    if (this.o == null)
      return;
    if (this.o.a() == 0)
      return;
    int i1 = this.o.a();
    int i2;
    if ((paramInt < 0) || (paramInt >= i1))
    {
      if (!this.a)
        return;
      i2 = paramInt;
      while (i2 < 0)
        i2 += i1;
    }
    for (int i3 = i2 % i1; ; i3 = paramInt)
    {
      int i5;
      if (paramBoolean)
      {
        int i4 = this.d;
        i5 = i3 - i4;
        if (!this.a)
          break label204;
        int i6 = this.d;
        int i7 = Math.min(i3, i6);
        int i8 = i1 + i7;
        int i9 = this.d;
        int i10 = Math.max(i3, i9);
        i1 = i8 - i10;
        int i11 = Math.abs(i5);
        if (i1 >= i11)
          break label204;
        if (i5 >= 0);
      }
      while (true)
      {
        b(i1, 0);
        return;
        i1 = -i1;
        continue;
        this.l = 0;
        int i12 = this.d;
        this.d = i3;
        int i13 = this.d;
        a(i12, i13);
        invalidate();
        return;
        label204: i1 = i5;
      }
    }
  }

  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.p.c();
      if (this.m != null)
        this.m.removeAllViews();
      this.l = 0;
    }
    while (true)
    {
      invalidate();
      return;
      if (this.m == null)
        continue;
      vd localvd = this.p;
      LinearLayout localLinearLayout = this.m;
      int i1 = this.n;
      up localup = new up();
      int i2 = localvd.a(localLinearLayout, i1, localup);
    }
  }

  public void c()
  {
    Iterator localIterator = this.r.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((us)localIterator.next()).b(this);
    }
  }

  public void c(int paramInt)
  {
    a(paramInt, 0);
  }

  public int d()
  {
    return this.d;
  }

  public boolean e()
  {
    return this.a;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.o != null) && (this.o.a() > 0))
    {
      j();
      b(paramCanvas);
      c(paramCanvas);
    }
    a(paramCanvas);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    d(i1, i2);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    l();
    int i5 = c(i3, i1);
    int i6;
    if (i2 == 1073741824)
      i6 = i4;
    while (true)
    {
      setMeasuredDimension(i5, i6);
      return;
      LinearLayout localLinearLayout = this.m;
      int i7 = a(localLinearLayout);
      if (i2 == -2147483648)
      {
        i6 = Math.min(i7, i4);
        continue;
      }
      i6 = i7;
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if ((!isEnabled()) || (a() == null))
    {
      bool = true;
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    default:
    case 2:
    case 1:
    }
    do
      while (true)
      {
        bool = this.j.a(paramMotionEvent);
        break;
        if (getParent() == null)
          continue;
        getParent().requestDisallowInterceptTouchEvent(1);
      }
    while (this.k);
    int i1 = (int)paramMotionEvent.getY();
    int i2 = getHeight() / 2;
    int i3 = i1 - i2;
    int i4;
    if (i3 > 0)
      i4 = g() / 2;
    int i11;
    for (int i5 = i3 + i4; ; i5 = i3 - i11)
    {
      int i6 = g();
      int i7 = i5 / i6;
      if (i7 == 0)
        break;
      int i8 = this.d + i7;
      if (!e(i8))
        break;
      int i9 = this.d;
      int i10 = i7 + i9;
      b(i10);
      break;
      i11 = g() / 2;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.wheelview.WheelView
 * JD-Core Version:    0.6.0
 */