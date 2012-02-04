package com.mymoney.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DragListView extends ListView
{
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  private ImageView e;
  private int f = 180;
  private WindowManager g;
  private WindowManager.LayoutParams h;
  private int i;
  private int j;
  private DragListView.OnDragListener k;
  private DragListView.OnDropListener l;
  private int m;
  private int n;
  private int o;
  private GestureDetector p;
  private Rect q;
  private Bitmap r;
  private final int s;
  private Context t;
  private TextView u;

  public DragListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Rect localRect = new Rect();
    this.q = localRect;
    int i1 = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.s = i1;
    this.t = paramContext;
    Context localContext = this.t;
    TextView localTextView = new TextView(localContext);
    this.u = localTextView;
    this.u.setId(16908308);
    this.u.setBackgroundColor(17170445);
  }

  private int a(int paramInt)
  {
    int i1 = this.i;
    int i2 = paramInt - i1;
    int i3 = this.c / 2;
    int i4 = i2 - i3;
    int i5 = a(0, i4);
    int i7;
    if (i5 >= 0)
    {
      int i6 = this.b;
      if (i5 > i6)
        break label70;
      i7 = i5 + 1;
    }
    while (true)
    {
      return i7;
      if (i4 < 0)
      {
        i7 = 0;
        continue;
      }
      label70: i7 = i5;
    }
  }

  private int a(int paramInt1, int paramInt2)
  {
    Rect localRect = this.q;
    int i1 = getChildCount() - 1;
    if (i1 >= 0)
    {
      getChildAt(i1).getHitRect(localRect);
      if (!localRect.contains(paramInt1, paramInt2));
    }
    for (int i2 = getFirstVisiblePosition() + i1; ; i2 = -1)
    {
      return i2;
      i1 += -1;
      break;
    }
  }

  private void a(Bitmap paramBitmap, int paramInt)
  {
    b();
    WindowManager.LayoutParams localLayoutParams1 = new WindowManager.LayoutParams();
    this.h = localLayoutParams1;
    this.h.gravity = 48;
    this.h.x = 0;
    WindowManager.LayoutParams localLayoutParams2 = this.h;
    int i1 = this.i;
    int i2 = paramInt - i1;
    int i3 = this.j;
    int i4 = i2 + i3;
    localLayoutParams2.y = i4;
    this.h.height = -1;
    this.h.width = -1;
    this.h.flags = 408;
    this.h.format = -1;
    this.h.windowAnimations = 0;
    Context localContext = this.t;
    ImageView localImageView = new ImageView(localContext);
    localImageView.setBackgroundColor(17170445);
    localImageView.setImageBitmap(paramBitmap);
    int i5 = this.f;
    localImageView.setAlpha(i5);
    this.r = paramBitmap;
    WindowManager localWindowManager1 = (WindowManager)this.t.getSystemService("window");
    this.g = localWindowManager1;
    WindowManager localWindowManager2 = this.g;
    WindowManager.LayoutParams localLayoutParams3 = this.h;
    localWindowManager2.addView(localImageView, localLayoutParams3);
    this.e = localImageView;
  }

  private void a(boolean paramBoolean)
  {
    int i1 = 0;
    while (true)
    {
      View localView = getChildAt(i1);
      if (localView == null)
      {
        if (paramBoolean)
        {
          int i2 = getFirstVisiblePosition();
          int i3 = getChildAt(0).getTop();
          ListAdapter localListAdapter = getAdapter();
          setAdapter(localListAdapter);
          setSelectionFromTop(i2, i3);
        }
        layoutChildren();
        localView = getChildAt(i1);
        if (localView == null)
          return;
      }
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i4 = this.c;
      localLayoutParams.height = i4;
      localView.setLayoutParams(localLayoutParams);
      localView.setVisibility(0);
      i1 += 1;
    }
  }

  private void b()
  {
    if (this.e != null)
    {
      WindowManager localWindowManager = (WindowManager)this.t.getSystemService("window");
      ImageView localImageView = this.e;
      localWindowManager.removeView(localImageView);
      this.e.setImageDrawable(null);
      this.e = null;
    }
    if (this.r == null)
      return;
    this.r.recycle();
    this.r = null;
  }

  private void b(int paramInt)
  {
    int i1 = this.o / 3;
    if (paramInt >= i1)
    {
      int i2 = this.o / 3;
      this.m = i2;
    }
    int i3 = this.o * 2 / 3;
    if (paramInt > i3)
      return;
    int i4 = this.o * 2 / 3;
    this.n = i4;
  }

  private void b(int paramInt1, int paramInt2)
  {
    WindowManager.LayoutParams localLayoutParams1 = this.h;
    int i1 = this.i;
    int i2 = paramInt2 - i1;
    int i3 = this.j;
    int i4 = i2 + i3;
    localLayoutParams1.y = i4;
    WindowManager localWindowManager = this.g;
    ImageView localImageView = this.e;
    WindowManager.LayoutParams localLayoutParams2 = this.h;
    localWindowManager.updateViewLayout(localImageView, localLayoutParams2);
  }

  protected void a()
  {
    int i1 = this.a;
    int i2 = getFirstVisiblePosition();
    int i3 = i1 - i2;
    int i4 = this.a;
    int i5 = this.b;
    if (i4 > i5)
      i3 += 1;
    int i6 = this.b;
    int i7 = getFirstVisiblePosition();
    int i8 = i6 - i7;
    View localView1 = getChildAt(i8);
    int i9 = 0;
    View localView2 = getChildAt(i9);
    if (localView2 == null)
      return;
    int i10 = this.c;
    int i14;
    int i15;
    if (localView2.equals(localView1))
    {
      int i11 = this.a;
      int i12 = this.b;
      if (i11 == i12)
      {
        int i13 = 4;
        i14 = i10;
        i15 = i13;
      }
    }
    while (true)
    {
      ViewGroup.LayoutParams localLayoutParams = localView2.getLayoutParams();
      localLayoutParams.height = i14;
      localView2.setLayoutParams(localLayoutParams);
      localView2.setVisibility(i15);
      i9 += 1;
      break;
      i15 = 0;
      i14 = 1;
      continue;
      if (i9 == i3)
      {
        int i16 = this.a;
        int i17 = getCount() - 1;
        if (i16 < i17)
        {
          i14 = this.d;
          i15 = 0;
          continue;
        }
      }
      i14 = i10;
      i15 = 0;
    }
  }

  public void a(DragListView.OnDropListener paramOnDropListener)
  {
    this.l = paramOnDropListener;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.k != null) || (this.l != null))
      switch (paramMotionEvent.getAction())
      {
      default:
      case 0:
      }
    while (true)
    {
      for (boolean bool = super.onInterceptTouchEvent(paramMotionEvent); ; bool = false)
      {
        return bool;
        int i1 = (int)paramMotionEvent.getX();
        int i2 = (int)paramMotionEvent.getY();
        int i3 = pointToPosition(i1, i2);
        if (i3 == -1)
          break;
        int i4 = getFirstVisiblePosition();
        int i5 = i3 - i4;
        View localView = getChildAt(i5);
        int i6 = localView.getHeight();
        this.c = i6;
        int i7 = this.c * 2;
        this.d = i7;
        int i8 = localView.getTop();
        int i9 = i2 - i8;
        this.i = i9;
        int i10 = (int)paramMotionEvent.getRawY() - i2;
        this.j = i10;
        Drawable localDrawable = getResources().getDrawable(2130837742);
        int i11 = getWidth();
        int i12 = localDrawable.getIntrinsicWidth();
        int i13 = i11 - i12;
        if ((i1 <= i13) || (!getAdapter().isEnabled(i3)))
          break label338;
        localView.setDrawingCacheEnabled(1);
        Bitmap localBitmap = Bitmap.createBitmap(localView.getDrawingCache());
        a(localBitmap, i2);
        this.a = i3;
        int i14 = this.a;
        this.b = i14;
        int i15 = getHeight();
        this.o = i15;
        int i16 = this.s;
        int i17 = i2 - i16;
        int i18 = this.o / 3;
        int i19 = Math.min(i17, i18);
        this.m = i19;
        int i20 = i16 + i2;
        int i21 = this.o * 2 / 3;
        int i22 = Math.max(i20, i21);
        this.n = i22;
      }
      label338: this.e = null;
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.p != null)
      boolean bool1 = this.p.onTouchEvent(paramMotionEvent);
    int i1;
    if (((this.k != null) || (this.l != null)) && (this.e != null))
    {
      i1 = paramMotionEvent.getAction();
      switch (i1)
      {
      default:
      case 1:
      case 3:
      case 0:
      case 2:
      }
    }
    label77: label479: 
    while (true)
    {
      int i2 = 1;
      return i2;
      Rect localRect = this.q;
      this.e.getDrawingRect(localRect);
      b();
      if ((this.l != null) && (this.a >= 0))
      {
        int i3 = this.a;
        int i4 = getCount();
        if (i3 < i4)
        {
          DragListView.OnDropListener localOnDropListener = this.l;
          int i5 = this.b;
          int i6 = this.a;
          localOnDropListener.a(i5, i6);
        }
      }
      a(0);
      continue;
      int i7 = (int)paramMotionEvent.getX();
      int i8 = (int)paramMotionEvent.getY();
      b(i7, i8);
      int i9 = a(i8);
      if (i9 < 0)
        continue;
      if (i1 != 0)
      {
        int i10 = this.a;
        if (i9 == i10);
      }
      else
      {
        if (this.k != null)
        {
          DragListView.OnDragListener localOnDragListener = this.k;
          int i11 = this.a;
          localOnDragListener.a(i11, i9);
        }
        this.a = i9;
        a();
      }
      b(i8);
      int i12 = this.n;
      if (i8 > i12)
      {
        int i13 = this.o;
        int i14 = this.n;
        int i15 = (i13 + i14) / 2;
        if (i8 > i15)
          i1 = 16;
      }
      while (true)
      {
        if (i1 == 0)
          break label479;
        int i16 = this.o / 2;
        i9 = pointToPosition(0, i16);
        if (i9 == -1)
        {
          int i17 = this.o / 2;
          int i18 = getDividerHeight();
          int i19 = i17 + i18 + 64;
          int i20 = pointToPosition(0, i19);
        }
        int i21 = getFirstVisiblePosition();
        int i22 = i9 - i21;
        View localView1 = getChildAt(i22);
        if (localView1 == null)
          break;
        int i23 = localView1.getTop() - i1;
        setSelectionFromTop(i9, i23);
        break;
        i1 = 4;
        continue;
        View localView2 = this.m;
        if (localView1 < localView2)
        {
          View localView3 = this.m / 2;
          if (localView1 < localView3)
          {
            i1 = 65520;
            continue;
          }
          i1 = -1;
          continue;
          boolean bool2 = super.onTouchEvent(paramMotionEvent);
          break label77;
        }
        i1 = 0;
      }
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.DragListView
 * JD-Core Version:    0.6.0
 */