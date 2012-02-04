package com.mymoney.ui.sync;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ez;
import gi;
import java.util.Date;
import sn;
import tr;

public class SyncLogsAdapter extends tr
{
  private int a;
  private Context b;

  public SyncLogsAdapter(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.b = paramContext;
    this.a = paramInt;
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    ez localez = (ez)getItem(paramInt1);
    sn localsn;
    View localView;
    if (paramView == null)
    {
      localsn = new sn(this);
      localView = d().inflate(paramInt2, null, 0);
      TextView localTextView1 = (TextView)localView.findViewById(2131231112);
      localsn.a = localTextView1;
      TextView localTextView2 = (TextView)localView.findViewById(2131231113);
      localsn.b = localTextView2;
      localView.setTag(localsn);
      if (!localez.c())
        break label129;
      localsn.a.setText("");
      localsn.b.setText("");
    }
    while (true)
    {
      return localView;
      localsn = (sn)paramView.getTag();
      localView = paramView;
      break;
      label129: TextView localTextView3 = localsn.a;
      long l = localez.a();
      String str1 = gi.b(new Date(l), "yyyy年MM月dd日 HH时mm分ss秒");
      localTextView3.setText(str1);
      TextView localTextView4 = localsn.b;
      String str2 = localez.b();
      localTextView4.setText(str2);
    }
  }

  public long getItemId(int paramInt)
  {
    return 0L;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = this.a;
    return a(paramInt, paramView, paramViewGroup, i);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.sync.SyncLogsAdapter
 * JD-Core Version:    0.6.0
 */