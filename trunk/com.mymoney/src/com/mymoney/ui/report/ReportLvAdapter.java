package com.mymoney.ui.report;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mymoney.ui.helper.CategoryIconResourcesHelper;
import com.mymoney.ui.widget.ReportBarView;
import ey;
import gs;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import ne;
import tr;

public class ReportLvAdapter extends tr
{
  private BigDecimal a = null;
  private float b;

  public ReportLvAdapter(Context paramContext, int paramInt, float paramFloat)
  {
    super(paramContext, paramInt);
    this.b = paramFloat;
  }

  private BigDecimal a()
  {
    BigDecimal localBigDecimal1 = new BigDecimal(0);
    this.a = localBigDecimal1;
    Iterator localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      ey localey = (ey)localIterator.next();
      double d1 = localey.a().doubleValue();
      double d2 = this.a.doubleValue();
      if (d1 <= d2)
        continue;
      BigDecimal localBigDecimal2 = localey.a();
      this.a = localBigDecimal2;
    }
    return this.a;
  }

  protected View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    ey localey = (ey)getItem(paramInt1);
    if (this.a == null)
    {
      BigDecimal localBigDecimal1 = a();
      this.a = localBigDecimal1;
    }
    ne localne2;
    View localView2;
    float f1;
    if (paramView == null)
    {
      ne localne1 = new ne(this);
      LayoutInflater localLayoutInflater = d();
      int i = c();
      View localView1 = localLayoutInflater.inflate(i, null, 0);
      ImageView localImageView1 = (ImageView)localView1.findViewById(2131230911);
      localne1.a = localImageView1;
      TextView localTextView1 = (TextView)localView1.findViewById(2131230912);
      localne1.b = localTextView1;
      TextView localTextView2 = (TextView)localView1.findViewById(2131230913);
      localne1.c = localTextView2;
      TextView localTextView3 = (TextView)localView1.findViewById(2131230914);
      localne1.d = localTextView3;
      ReportBarView localReportBarView1 = (ReportBarView)localView1.findViewById(2131230915);
      localne1.e = localReportBarView1;
      localView1.setTag(localne1);
      localne2 = localne1;
      localView2 = localView1;
      String str1 = localey.e();
      String str2 = localey.f();
      ImageView localImageView2 = localne2.a;
      int j = CategoryIconResourcesHelper.a(str2, 1);
      localImageView2.setBackgroundResource(j);
      localne2.b.setText(str1);
      TextView localTextView4 = localne2.c;
      String str3 = gs.a(localey.a().doubleValue(), null);
      localTextView4.setText(str3);
      if (this.a.doubleValue() <= 0.0D)
        break label334;
      BigDecimal localBigDecimal2 = localey.a();
      BigDecimal localBigDecimal3 = this.a;
      f1 = localBigDecimal2.divide(localBigDecimal3, 2, 6).floatValue();
    }
    while (true)
    {
      ReportBarView localReportBarView2 = localne2.e;
      float f2 = this.b;
      localReportBarView2.a(f1, paramInt1, f2);
      return localView2;
      localne2 = (ne)paramView.getTag();
      localView2 = paramView;
      break;
      label334: f1 = 0.0F;
    }
  }

  public void a(List paramList)
  {
    this.a = null;
    super.a(paramList);
  }

  public long getItemId(int paramInt)
  {
    return ((ey)getItem(paramInt)).d();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.report.ReportLvAdapter
 * JD-Core Version:    0.6.0
 */