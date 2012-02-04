import com.mymoney.core.vo.ProjectVo;
import com.mymoney.ui.setting.ProjectListViewAdapter;
import com.mymoney.ui.setting.SettingProjectActivity;
import com.mymoney.ui.widget.DragListView;
import com.mymoney.ui.widget.DragListView.OnDropListener;

public class qq
  implements DragListView.OnDropListener
{
  public qq(SettingProjectActivity paramSettingProjectActivity)
  {
  }

  public void a(int paramInt1, int paramInt2)
  {
    int i = SettingProjectActivity.e(this.a).getCheckedItemPosition();
    ProjectVo localProjectVo1 = null;
    if (i != -1)
      localProjectVo1 = (ProjectVo)SettingProjectActivity.d(this.a).getItem(i);
    ProjectVo localProjectVo2 = (ProjectVo)SettingProjectActivity.d(this.a).getItem(paramInt1);
    SettingProjectActivity.d(this.a).b(localProjectVo2);
    SettingProjectActivity.d(this.a).a(localProjectVo2, paramInt2);
    if (localProjectVo1 != null)
    {
      int j = SettingProjectActivity.d(this.a).c(localProjectVo1);
      SettingProjectActivity.e(this.a).setItemChecked(j, 1);
    }
    SettingProjectActivity localSettingProjectActivity = this.a;
    qr localqr = new qr(this);
    localSettingProjectActivity.runOnUiThread(localqr);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qq
 * JD-Core Version:    0.6.0
 */