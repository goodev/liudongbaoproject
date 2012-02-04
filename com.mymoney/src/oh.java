import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.core.application.ApplicationContext;
import com.mymoney.ui.setting.SettingAccountTransactionListActivity;

public class oh
  implements DialogInterface.OnClickListener
{
  public oh(SettingAccountTransactionListActivity paramSettingAccountTransactionListActivity, int paramInt, long paramLong)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      int i = this.a;
      if ((1 == i) || (this.a == 0))
      {
        SettingAccountTransactionListActivity localSettingAccountTransactionListActivity = this.c;
        long l = this.b;
        int j = this.a;
        SettingAccountTransactionListActivity.a(localSettingAccountTransactionListActivity, l, j);
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
                  break label132;
              }
            }
          }
        }
      }
      hb.b(ApplicationContext.a, "请到流水里编辑转帐");
      return;
      label132: hb.b(ApplicationContext.a, "抱歉,余额变更不可以编辑");
      return;
    }
    if (paramInt != 1)
      return;
    Context localContext = SettingAccountTransactionListActivity.a();
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle(2131492899).setMessage(2131492900);
    oj localoj = new oj(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton(2131492901, localoj);
    oi localoi = new oi(this);
    localBuilder2.setNegativeButton(2131492902, localoi).create().show();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     oh
 * JD-Core Version:    0.6.0
 */