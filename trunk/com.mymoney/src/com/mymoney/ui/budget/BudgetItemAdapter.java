package com.mymoney.ui.budget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.ui.helper.CategoryIconResourcesHelper;
import com.mymoney.ui.widget.LineBarView;
import gs;
import hh;
import ki;
import tr;

public class BudgetItemAdapter extends tr
{
  private Context a;

  public BudgetItemAdapter(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    hh localhh = (hh)getItem(paramInt1);
    ki localki;
    View localView;
    if (paramView == null)
    {
      localki = new ki(this);
      LayoutInflater localLayoutInflater = d();
      int i = c();
      localView = localLayoutInflater.inflate(i, null, 0);
      ImageView localImageView1 = (ImageView)localView.findViewById(2131230798);
      localki.a = localImageView1;
      TextView localTextView1 = (TextView)localView.findViewById(2131230763);
      localki.b = localTextView1;
      TextView localTextView2 = (TextView)localView.findViewById(2131230800);
      localki.c = localTextView2;
      TextView localTextView3 = (TextView)localView.findViewById(2131230801);
      localki.d = localTextView3;
      LineBarView localLineBarView1 = (LineBarView)localView.findViewById(2131230738);
      localki.e = localLineBarView1;
      localView.setTag(localki);
      String str1 = localhh.c().f();
      ImageView localImageView2 = localki.a;
      int j = CategoryIconResourcesHelper.a(str1, 1);
      localImageView2.setBackgroundResource(j);
      TextView localTextView4 = localki.b;
      String str2 = localhh.c().b();
      localTextView4.setText(str2);
      TextView localTextView5 = localki.c;
      String str3 = gs.a(localhh.d(), null);
      localTextView5.setText(str3);
      double d = localhh.e();
      if (d >= 0.0D)
        break label380;
      TextView localTextView6 = localki.d;
      int k = this.a.getResources().getColor(2131296256);
      localTextView6.setTextColor(k);
      label275: TextView localTextView7 = localki.d;
      StringBuilder localStringBuilder = new StringBuilder().append("余额: ");
      String str4 = gs.a(d, null);
      String str5 = str4;
      localTextView7.setText(str5);
      if (localhh.d() != 0.0D)
        break label411;
    }
    label380: int n;
    label411: for (int m = 1; ; n = 0)
    {
      LineBarView localLineBarView2 = localki.e;
      float f = localhh.f();
      localLineBarView2.a(f, m);
      return localView;
      localki = (ki)paramView.getTag();
      localView = paramView;
      break;
      TextView localTextView8 = localki.d;
      int i1 = this.a.getResources().getColor(2131296289);
      localTextView8.setTextColor(i1);
      break label275;
    }
  }

  public long getItemId(int paramInt)
  {
    return ((hh)getItem(paramInt)).b();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.budget.BudgetItemAdapter
 * JD-Core Version:    0.6.0
 */