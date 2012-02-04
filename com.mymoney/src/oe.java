import com.mymoney.ui.setting.AccountListViewAdapter;
import com.mymoney.ui.setting.SettingAccountActivity;
import java.util.Map;

class oe
  implements Runnable
{
  oe(od paramod, AccountListViewAdapter paramAccountListViewAdapter)
  {
  }

  public void run()
  {
    e locale = SettingAccountActivity.a(this.b.a);
    SettingAccountActivity localSettingAccountActivity = this.b.a;
    AccountListViewAdapter localAccountListViewAdapter = this.a;
    Map localMap = SettingAccountActivity.a(localSettingAccountActivity, localAccountListViewAdapter);
    locale.a(localMap);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     oe
 * JD-Core Version:    0.6.0
 */