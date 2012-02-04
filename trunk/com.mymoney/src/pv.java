import com.mymoney.core.vo.CorporationVo;
import com.mymoney.ui.setting.CorporationListViewAdapter;
import com.mymoney.ui.setting.SettingCorporationActivity;
import com.mymoney.ui.widget.DragListView;
import com.mymoney.ui.widget.DragListView.OnDropListener;

public class pv
  implements DragListView.OnDropListener
{
  public pv(SettingCorporationActivity paramSettingCorporationActivity)
  {
  }

  public void a(int paramInt1, int paramInt2)
  {
    int i = SettingCorporationActivity.f(this.a).getCheckedItemPosition();
    CorporationVo localCorporationVo1 = null;
    if (i != -1)
      localCorporationVo1 = (CorporationVo)SettingCorporationActivity.e(this.a).getItem(i);
    CorporationVo localCorporationVo2 = (CorporationVo)SettingCorporationActivity.e(this.a).getItem(paramInt1);
    SettingCorporationActivity.e(this.a).b(localCorporationVo2);
    SettingCorporationActivity.e(this.a).a(localCorporationVo2, paramInt2);
    if (localCorporationVo1 != null)
    {
      int j = SettingCorporationActivity.e(this.a).c(localCorporationVo1);
      SettingCorporationActivity.f(this.a).setItemChecked(j, 1);
    }
    SettingCorporationActivity localSettingCorporationActivity = this.a;
    pw localpw = new pw(this);
    localSettingCorporationActivity.runOnUiThread(localpw);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     pv
 * JD-Core Version:    0.6.0
 */