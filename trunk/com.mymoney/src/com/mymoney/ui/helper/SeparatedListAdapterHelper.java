package com.mymoney.ui.helper;

import android.content.Context;
import com.mymoney.core.vo.AccountGroupVo;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.setting.AccountListViewAdapter;
import gi;
import java.util.Iterator;
import java.util.List;
import kv;
import tz;

public class SeparatedListAdapterHelper
{
  public static tz a(Context paramContext, List paramList1, List paramList2)
  {
    tz localtz = new tz(paramContext, 2130903129);
    Iterator localIterator = paramList1.iterator();
    Object localObject = "";
    AccountListViewAdapter localAccountListViewAdapter = null;
    while (localIterator.hasNext())
    {
      AccountVo localAccountVo = (AccountVo)localIterator.next();
      String str = localAccountVo.c().e();
      if (!((String)localObject).equalsIgnoreCase(str))
      {
        localAccountListViewAdapter = new AccountListViewAdapter(paramContext, 2130903106);
        localtz.a(str, localAccountListViewAdapter);
        AccountGroupVo localAccountGroupVo = localAccountVo.c();
        boolean bool1 = paramList2.add(localAccountGroupVo);
      }
      localAccountListViewAdapter.a(localAccountVo);
      boolean bool2 = paramList2.add(localAccountVo);
      localObject = str;
    }
    return (tz)localtz;
  }

  public static tz a(Context paramContext, List paramList, boolean paramBoolean)
  {
    tz localtz = new tz(paramContext, 2130903128);
    Iterator localIterator = paramList.iterator();
    Object localObject = "";
    kv localkv = null;
    while (localIterator.hasNext())
    {
      TransactionVo localTransactionVo = (TransactionVo)localIterator.next();
      String str = gi.f(localTransactionVo.j());
      if (!((String)localObject).equalsIgnoreCase(str))
      {
        localkv = new kv(paramContext, 2130903064, paramBoolean, 1);
        localtz.a(str, localkv);
      }
      localkv.a(localTransactionVo);
      localObject = str;
    }
    return (tz)localtz;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.helper.SeparatedListAdapterHelper
 * JD-Core Version:    0.6.0
 */