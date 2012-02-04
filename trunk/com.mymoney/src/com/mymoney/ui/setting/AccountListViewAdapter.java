package com.mymoney.ui.setting;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mymoney.core.vo.AccountGroupVo;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.ui.widget.CheckedListItem;
import gs;
import np;
import tr;

public class AccountListViewAdapter extends tr
{
  public AccountListViewAdapter(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    AccountVo localAccountVo = (AccountVo)getItem(paramInt1);
    View localView2;
    np localnp3;
    label199: String str3;
    if (paramView == null)
    {
      np localnp1 = new np(this);
      LayoutInflater localLayoutInflater = d();
      int i = c();
      View localView1 = localLayoutInflater.inflate(i, null, 0);
      ImageView localImageView = (ImageView)localView1.findViewById(2131231090);
      localnp1.a = localImageView;
      TextView localTextView1 = (TextView)localView1.findViewById(2131230766);
      localnp1.b = localTextView1;
      TextView localTextView2 = (TextView)localView1.findViewById(2131231091);
      localnp1.c = localTextView2;
      TextView localTextView3 = (TextView)localView1.findViewById(2131231093);
      localnp1.d = localTextView3;
      TextView localTextView4 = (TextView)localView1.findViewById(2131231092);
      localnp1.e = localTextView4;
      localView1.setTag(localnp1);
      np localnp2 = localnp1;
      localView2 = localView1;
      localnp3 = localnp2;
      CheckedListItem localCheckedListItem = (CheckedListItem)localView2;
      localCheckedListItem.a(null);
      localCheckedListItem.a(1);
      if (!localAccountVo.j())
        break label330;
      localnp3.a.setVisibility(0);
      TextView localTextView5 = localnp3.b;
      String str1 = localAccountVo.i();
      localTextView5.setText(str1);
      TextView localTextView6 = localnp3.c;
      String str2 = localAccountVo.c().b();
      localTextView6.setText(str2);
      if (!TextUtils.isEmpty(localAccountVo.h()))
        break label343;
      localnp3.d.setText("");
      label265: int j = localAccountVo.c().d();
      str3 = localAccountVo.d();
      switch (j)
      {
      default:
      case 0:
      case 1:
      case 2:
      }
    }
    while (true)
    {
      return localView2;
      localnp3 = (np)paramView.getTag();
      localView2 = paramView;
      break;
      label330: localnp3.a.setVisibility(8);
      break label199;
      label343: TextView localTextView7 = localnp3.d;
      StringBuilder localStringBuilder1 = new StringBuilder().append("[");
      String str4 = localAccountVo.h();
      String str5 = str4 + "]";
      localTextView7.setText(str5);
      break label265;
      TextView localTextView8 = localnp3.e;
      String str6 = gs.a(localAccountVo.e(), str3);
      localTextView8.setText(str6);
      continue;
      TextView localTextView9 = localnp3.e;
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str7 = gs.a(localAccountVo.g(), str3);
      String str8 = str7 + "(负债金额)";
      localTextView9.setText(str8);
      continue;
      TextView localTextView10 = localnp3.e;
      StringBuilder localStringBuilder3 = new StringBuilder();
      String str9 = gs.a(localAccountVo.f(), str3);
      String str10 = str9 + "(债权金额)";
      localTextView10.setText(str10);
    }
  }

  public long getItemId(int paramInt)
  {
    return ((AccountVo)getItem(paramInt)).a();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.AccountListViewAdapter
 * JD-Core Version:    0.6.0
 */