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
import java.text.DecimalFormat;
import nu;
import tr;

public class CurrencyRateListViewAdapter extends tr
{
  private Context a;
  private DecimalFormat b;

  public CurrencyRateListViewAdapter(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    DecimalFormat localDecimalFormat = new DecimalFormat("0.0000");
    this.b = localDecimalFormat;
    this.a = paramContext;
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    hk localhk = (hk)getItem(paramInt1);
    nu localnu2;
    View localView2;
    if (paramView == null)
    {
      nu localnu1 = new nu(this);
      LayoutInflater localLayoutInflater = d();
      int i = c();
      View localView1 = localLayoutInflater.inflate(i, null, 0);
      ImageView localImageView = (ImageView)localView1.findViewById(2131231094);
      localnu1.a = localImageView;
      TextView localTextView1 = (TextView)localView1.findViewById(2131231095);
      localnu1.b = localTextView1;
      TextView localTextView2 = (TextView)localView1.findViewById(2131231096);
      localnu1.c = localTextView2;
      TextView localTextView3 = (TextView)localView1.findViewById(2131231099);
      localnu1.d = localTextView3;
      TextView localTextView4 = (TextView)localView1.findViewById(2131231100);
      localnu1.e = localTextView4;
      localView1.setTag(localnu1);
      localnu2 = localnu1;
      localView2 = localView1;
      String str1 = localhk.d();
      Resources localResources = this.a.getResources();
      int j = CurrencyCodeIconResourcesHelper.a(str1);
      Drawable localDrawable = localResources.getDrawable(j);
      localnu2.a.setBackgroundDrawable(localDrawable);
      TextView localTextView5 = localnu2.b;
      String str2 = localhk.b();
      localTextView5.setText(str2);
      TextView localTextView6 = localnu2.c;
      String str3 = localhk.c();
      localTextView6.setText(str3);
      TextView localTextView7 = localnu2.d;
      DecimalFormat localDecimalFormat = this.b;
      double d = localhk.e();
      String str4 = localDecimalFormat.format(d);
      localTextView7.setText(str4);
      if (!localhk.f())
        break label323;
      localnu2.e.setText("手动设置");
      localnu2.e.setVisibility(0);
    }
    while (true)
    {
      return localView2;
      localnu2 = (nu)paramView.getTag();
      localView2 = paramView;
      break;
      label323: localnu2.e.setVisibility(8);
    }
  }

  public long getItemId(int paramInt)
  {
    return ((hk)getItem(paramInt)).a();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.CurrencyRateListViewAdapter
 * JD-Core Version:    0.6.0
 */