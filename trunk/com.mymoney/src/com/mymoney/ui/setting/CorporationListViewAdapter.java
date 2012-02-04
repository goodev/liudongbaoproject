package com.mymoney.ui.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mymoney.core.vo.CorporationVo;
import nt;
import tr;

public class CorporationListViewAdapter extends tr
{
  public CorporationListViewAdapter(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    CorporationVo localCorporationVo = (CorporationVo)getItem(paramInt1);
    nt localnt;
    View localView;
    if (paramView == null)
    {
      localnt = new nt(this);
      LayoutInflater localLayoutInflater = d();
      int i = c();
      localView = localLayoutInflater.inflate(i, null, 0);
      TextView localTextView1 = (TextView)localView.findViewById(2131230806);
      localnt.a = localTextView1;
      localView.setTag(localnt);
    }
    while (true)
    {
      TextView localTextView2 = localnt.a;
      String str = localCorporationVo.b();
      localTextView2.setText(str);
      return localView;
      localnt = (nt)paramView.getTag();
      localView = paramView;
    }
  }

  public long getItemId(int paramInt)
  {
    return ((CorporationVo)getItem(paramInt)).a();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.CorporationListViewAdapter
 * JD-Core Version:    0.6.0
 */