package com.mymoney.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;

public class AccountDragListView extends DragListView
{
  public AccountDragListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected void a()
  {
    int i = this.a;
    int j = getFirstVisiblePosition();
    int k = i - j;
    int m = this.a;
    int n = this.b;
    if (m > n)
      k += 1;
    int i1 = this.b;
    int i2 = getFirstVisiblePosition();
    int i3 = i1 - i2;
    View localView1 = getChildAt(i3);
    int i4 = 0;
    View localView2 = getChildAt(i4);
    if (localView2 == null)
      return;
    int i5 = this.c;
    int i9;
    int i10;
    if (localView2.equals(localView1))
    {
      int i6 = this.a;
      int i7 = this.b;
      if (i6 == i7)
      {
        int i8 = 4;
        i9 = i5;
        i10 = i8;
      }
    }
    while (true)
    {
      ViewGroup.LayoutParams localLayoutParams = localView2.getLayoutParams();
      localLayoutParams.height = i9;
      localView2.setLayoutParams(localLayoutParams);
      localView2.setVisibility(i10);
      i4 += 1;
      break;
      i10 = 0;
      i9 = 1;
      continue;
      if (i4 == k)
      {
        int i11 = this.a;
        int i12 = getCount() - 1;
        if ((i11 < i12) && (getAdapter().getItemViewType(i4) != 0))
        {
          i9 = this.d;
          i10 = 0;
          continue;
        }
      }
      i9 = i5;
      i10 = 0;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.AccountDragListView
 * JD-Core Version:    0.6.0
 */