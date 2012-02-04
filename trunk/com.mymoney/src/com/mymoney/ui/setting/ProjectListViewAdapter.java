package com.mymoney.ui.setting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mymoney.core.vo.ProjectVo;
import com.mymoney.ui.helper.CategoryIconResourcesHelper;
import com.mymoney.ui.widget.DragCheckedTextView;
import nz;
import tr;

public class ProjectListViewAdapter extends tr
{
  private Context a;

  public ProjectListViewAdapter(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    ProjectVo localProjectVo = (ProjectVo)getItem(paramInt1);
    View localView1;
    nz localnz2;
    if (paramView == null)
    {
      nz localnz1 = new nz(this);
      LayoutInflater localLayoutInflater = d();
      int i = c();
      localView1 = localLayoutInflater.inflate(i, null, 0);
      DragCheckedTextView localDragCheckedTextView1 = (DragCheckedTextView)localView1.findViewById(2131230806);
      localnz1.a = localDragCheckedTextView1;
      localView1.setTag(localnz1);
      localnz2 = localnz1;
    }
    for (View localView2 = localView1; ; localView2 = paramView)
    {
      Resources localResources = this.a.getResources();
      int j = CategoryIconResourcesHelper.a("default_firstlevelcategory_icon", 1);
      Drawable localDrawable = localResources.getDrawable(j);
      localnz2.a.b(localDrawable);
      DragCheckedTextView localDragCheckedTextView2 = localnz2.a;
      String str = localProjectVo.b();
      localDragCheckedTextView2.setText(str);
      return localView2;
      localnz2 = (nz)paramView.getTag();
    }
  }

  public long getItemId(int paramInt)
  {
    return ((ProjectVo)getItem(paramInt)).a();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.ProjectListViewAdapter
 * JD-Core Version:    0.6.0
 */