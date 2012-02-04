package com.mymoney.ui.setting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mymoney.ui.helper.CurrencyCodeIconResourcesHelper;
import hk;
import nv;
import tr;

public class DefaultCurrencyCodeListViewAdapter extends tr
{
  private Context a;

  public DefaultCurrencyCodeListViewAdapter(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    hk localhk = (hk)getItem(paramInt1);
    View localView1;
    nv localnv2;
    if (paramView == null)
    {
      nv localnv1 = new nv(this);
      LayoutInflater localLayoutInflater = d();
      int i = c();
      localView1 = localLayoutInflater.inflate(i, null, 0);
      ImageView localImageView = (ImageView)localView1.findViewById(2131231094);
      localnv1.a = localImageView;
      TextView localTextView1 = (TextView)localView1.findViewById(2131231095);
      localnv1.b = localTextView1;
      TextView localTextView2 = (TextView)localView1.findViewById(2131231096);
      localnv1.c = localTextView2;
      localView1.setTag(localnv1);
      localnv2 = localnv1;
    }
    for (View localView2 = localView1; ; localView2 = paramView)
    {
      String str1 = localhk.d();
      Resources localResources = this.a.getResources();
      int j = CurrencyCodeIconResourcesHelper.a(str1);
      Drawable localDrawable = localResources.getDrawable(j);
      localnv2.a.setBackgroundDrawable(localDrawable);
      TextView localTextView3 = localnv2.b;
      String str2 = localhk.b();
      localTextView3.setText(str2);
      TextView localTextView4 = localnv2.c;
      String str3 = localhk.c();
      localTextView4.setText(str3);
      return localView2;
      localnv2 = (nv)paramView.getTag();
    }
  }

  public long getItemId(int paramInt)
  {
    return ((hk)getItem(paramInt)).a();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.DefaultCurrencyCodeListViewAdapter
 * JD-Core Version:    0.6.0
 */