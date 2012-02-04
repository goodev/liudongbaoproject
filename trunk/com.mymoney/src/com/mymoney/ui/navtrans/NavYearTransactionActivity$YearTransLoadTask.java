package com.mymoney.ui.navtrans;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import en;
import m;

public class NavYearTransactionActivity$YearTransLoadTask extends AsyncTask
{
  Cursor a = null;

  public NavYearTransactionActivity$YearTransLoadTask(NavYearTransactionActivity paramNavYearTransactionActivity)
  {
  }

  protected Integer a(Integer[] paramArrayOfInteger)
  {
    m localm = NavYearTransactionActivity.a(this.b);
    long l1 = NavYearTransactionActivity.c(this.b);
    long l2 = NavYearTransactionActivity.d(this.b);
    Cursor localCursor = localm.d(l1, l2);
    this.a = localCursor;
    return null;
  }

  protected void a(Integer paramInteger)
  {
    NavYearTransactionActivity.e(this.b).setVisibility(8);
    if (this.a.getCount() > 0)
      NavYearTransactionActivity.b(this.b).setVisibility(8);
    while (true)
    {
      NavYearTransactionActivity localNavYearTransactionActivity1 = this.b;
      NavYearTransactionActivity localNavYearTransactionActivity2 = this.b;
      Cursor localCursor = this.a;
      Context localContext = NavYearTransactionActivity.a();
      String[] arrayOfString1 = en.a;
      int[] arrayOfInt1 = { 2131230813, 2131230813, 2131230814, 2131230857 };
      String[] arrayOfString2 = en.b;
      int[] arrayOfInt2 = { 2131230763, 2131230798, 2131230763, 2131231121, 2131231093, 2131231122 };
      NavYearTransactionActivity.YearTransListAdapter localYearTransListAdapter1 = new NavYearTransactionActivity.YearTransListAdapter(localNavYearTransactionActivity2, localCursor, localContext, 2130903118, 2130903117, arrayOfString1, arrayOfInt1, arrayOfString2, arrayOfInt2);
      NavYearTransactionActivity.YearTransListAdapter localYearTransListAdapter2 = NavYearTransactionActivity.a(localNavYearTransactionActivity1, localYearTransListAdapter1);
      ExpandableListView localExpandableListView1 = NavYearTransactionActivity.g(this.b);
      NavYearTransactionActivity.YearTransListAdapter localYearTransListAdapter3 = NavYearTransactionActivity.f(this.b);
      localExpandableListView1.setAdapter(localYearTransListAdapter3);
      ExpandableListView localExpandableListView2 = NavYearTransactionActivity.g(this.b);
      int i = NavYearTransactionActivity.h(this.b);
      boolean bool = localExpandableListView2.expandGroup(i);
      super.onPostExecute(paramInteger);
      return;
      NavYearTransactionActivity.b(this.b).setVisibility(0);
    }
  }

  protected void onPreExecute()
  {
    NavYearTransactionActivity.b(this.b).setVisibility(8);
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.navtrans.NavYearTransactionActivity.YearTransLoadTask
 * JD-Core Version:    0.6.0
 */