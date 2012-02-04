import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.core.application.ApplicationContext;
import com.mymoney.ui.navtrans.NavTransactionActivity;

public class lw
  implements DialogInterface.OnClickListener
{
  public lw(NavTransactionActivity paramNavTransactionActivity, int paramInt, long paramLong)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      int i = this.a;
      if ((1 == i) || (this.a == 0))
      {
        NavTransactionActivity localNavTransactionActivity1 = this.c;
        long l1 = this.b;
        int j = this.a;
        NavTransactionActivity.a(localNavTransactionActivity1, l1, j);
        return;
      }
      int k = this.a;
      if (2 != k)
      {
        int m = this.a;
        if (3 != m)
        {
          int n = this.a;
          if (4 != n)
          {
            int i1 = this.a;
            if (5 != i1)
            {
              int i2 = this.a;
              if (6 != i2)
              {
                int i3 = this.a;
                if (7 != i3)
                  break label143;
              }
            }
          }
        }
      }
      NavTransactionActivity localNavTransactionActivity2 = this.c;
      long l2 = this.b;
      NavTransactionActivity.a(localNavTransactionActivity2, l2);
      return;
      label143: hb.b(ApplicationContext.a, "抱歉,余额变更不可以编辑");
      return;
    }
    if (paramInt != 1)
      return;
    Context localContext = NavTransactionActivity.a();
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle(2131492899).setMessage(2131492900);
    ly locally = new ly(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton(2131492901, locally);
    lx locallx = new lx(this);
    localBuilder2.setNegativeButton(2131492902, locallx).create().show();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     lw
 * JD-Core Version:    0.6.0
 */