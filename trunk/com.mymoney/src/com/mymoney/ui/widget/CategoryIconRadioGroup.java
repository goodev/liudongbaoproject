package com.mymoney.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import ta;

public class CategoryIconRadioGroup extends RadioGroup
{
  public CategoryIconRadioGroup(Context paramContext)
  {
    super(paramContext);
  }

  public CategoryIconRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a(LinearLayout paramLinearLayout)
  {
    int i = paramLinearLayout.getChildCount();
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      View localView = paramLinearLayout.getChildAt(j);
      if ((localView instanceof LinearLayout))
      {
        LinearLayout localLinearLayout = (LinearLayout)localView;
        b(localLinearLayout);
      }
      j += 1;
    }
  }

  private void b(LinearLayout paramLinearLayout)
  {
    int i = 0;
    while (true)
    {
      int j = paramLinearLayout.getChildCount();
      if (i >= j)
        return;
      Object localObject = paramLinearLayout.getChildAt(i);
      if ((localObject instanceof RadioButton))
      {
        localObject = (RadioButton)localObject;
        if (((RadioButton)localObject).isChecked())
        {
          int k = ((RadioButton)localObject).getId();
          check(k);
        }
        ta localta = new ta(this, null);
        ((RadioButton)localObject).setOnCheckedChangeListener(localta);
      }
      i += 1;
    }
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!(paramView instanceof LinearLayout))
      return;
    LinearLayout localLinearLayout = (LinearLayout)paramView;
    a(localLinearLayout);
    super.addView(paramView, paramInt, paramLayoutParams);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.CategoryIconRadioGroup
 * JD-Core Version:    0.6.0
 */