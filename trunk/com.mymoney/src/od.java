import com.mymoney.core.vo.AccountGroupVo;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.ui.setting.AccountListViewAdapter;
import com.mymoney.ui.setting.SettingAccountActivity;
import com.mymoney.ui.widget.DragListView;
import com.mymoney.ui.widget.DragListView.OnDropListener;
import java.util.List;

public class od
  implements DragListView.OnDropListener
{
  public od(SettingAccountActivity paramSettingAccountActivity)
  {
  }

  public void a(int paramInt1, int paramInt2)
  {
    int i = SettingAccountActivity.g(this.a).getCheckedItemPosition();
    if (i != -1);
    for (Object localObject = SettingAccountActivity.f(this.a).getItem(i); ; localObject = null)
    {
      if (!SettingAccountActivity.f(this.a).isEnabled(paramInt2))
        return;
      AccountVo localAccountVo1 = (AccountVo)SettingAccountActivity.f(this.a).getItem(paramInt1);
      AccountVo localAccountVo2 = (AccountVo)SettingAccountActivity.f(this.a).getItem(paramInt2);
      String str1 = localAccountVo1.c().e();
      String str2 = localAccountVo2.c().e();
      if (!str1.equals(str2))
        return;
      AccountListViewAdapter localAccountListViewAdapter1 = (AccountListViewAdapter)SettingAccountActivity.f(this.a).a(str1);
      int j = localAccountListViewAdapter1.c(localAccountVo2);
      localAccountListViewAdapter1.b(localAccountVo1);
      boolean bool = SettingAccountActivity.e(this.a).remove(localAccountVo1);
      localAccountListViewAdapter1.a(localAccountVo1, j);
      SettingAccountActivity.e(this.a).add(paramInt2, localAccountVo1);
      if (localObject != null)
      {
        DragListView localDragListView = SettingAccountActivity.g(this.a);
        int k = SettingAccountActivity.e(this.a).indexOf(localObject);
        localDragListView.setItemChecked(k, 1);
      }
      SettingAccountActivity.f(this.a).notifyDataSetChanged();
      AccountListViewAdapter localAccountListViewAdapter2 = (AccountListViewAdapter)SettingAccountActivity.f(this.a).a(str1);
      SettingAccountActivity localSettingAccountActivity = this.a;
      oe localoe = new oe(this, localAccountListViewAdapter2);
      localSettingAccountActivity.runOnUiThread(localoe);
      return;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     od
 * JD-Core Version:    0.6.0
 */