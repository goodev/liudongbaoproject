import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.setting.SettingAccountTransactionListActivity;

class oj
  implements DialogInterface.OnClickListener
{
  oj(oh paramoh)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    m localm = SettingAccountTransactionListActivity.a(this.a.c);
    long l = this.a.b;
    boolean bool = localm.a(l, 1);
    hb.b(SettingAccountTransactionListActivity.a(), "删除成功.");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     oj
 * JD-Core Version:    0.6.0
 */