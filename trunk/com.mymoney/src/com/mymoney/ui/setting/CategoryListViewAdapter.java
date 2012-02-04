package com.mymoney.ui.setting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.ui.helper.CategoryIconResourcesHelper;
import com.mymoney.ui.widget.DragCheckedTextView;
import ns;
import tr;

public class CategoryListViewAdapter extends tr
{
  private final Resources a;
  private boolean b = 1;

  public CategoryListViewAdapter(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt);
    Resources localResources = paramContext.getResources();
    this.a = localResources;
    this.b = paramBoolean;
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    CategoryVo localCategoryVo = (CategoryVo)getItem(paramInt1);
    View localView1;
    ns localns2;
    if (paramView == null)
    {
      ns localns1 = new ns(this);
      LayoutInflater localLayoutInflater = d();
      int i = c();
      localView1 = localLayoutInflater.inflate(i, null, 0);
      DragCheckedTextView localDragCheckedTextView1 = (DragCheckedTextView)localView1.findViewById(2131230806);
      localns1.a = localDragCheckedTextView1;
      localView1.setTag(localns1);
      localns2 = localns1;
    }
    for (View localView2 = localView1; ; localView2 = paramView)
    {
      String str1 = localCategoryVo.f();
      int j = localCategoryVo.c();
      Resources localResources = this.a;
      int k = CategoryIconResourcesHelper.a(str1, j);
      Drawable localDrawable = localResources.getDrawable(k);
      localns2.a.b(localDrawable);
      DragCheckedTextView localDragCheckedTextView2 = localns2.a;
      String str2 = localCategoryVo.b();
      localDragCheckedTextView2.setText(str2);
      return localView2;
      localns2 = (ns)paramView.getTag();
    }
  }

  public long getItemId(int paramInt)
  {
    return ((CategoryVo)getItem(paramInt)).a();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.CategoryListViewAdapter
 * JD-Core Version:    0.6.0
 */