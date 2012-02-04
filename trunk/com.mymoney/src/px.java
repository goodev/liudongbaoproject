import android.os.AsyncTask;
import android.widget.TextView;
import com.mymoney.core.vo.CorporationVo;
import com.mymoney.ui.setting.CorporationListViewAdapter;
import com.mymoney.ui.setting.SettingCorporationActivity;
import com.mymoney.ui.widget.DragListView;
import java.util.List;

public class px extends AsyncTask
{
  List a;

  public px(SettingCorporationActivity paramSettingCorporationActivity)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    List localList = SettingCorporationActivity.a(this.b).a();
    this.a = localList;
    CorporationVo localCorporationVo = new CorporationVo();
    localCorporationVo.a(0L);
    localCorporationVo.a("无商家");
    this.a.add(0, localCorporationVo);
    return null;
  }

  protected void onPostExecute(Object paramObject)
  {
    if (SettingCorporationActivity.d(this.b).getVisibility() == 0)
      SettingCorporationActivity.d(this.b).setVisibility(8);
    CorporationListViewAdapter localCorporationListViewAdapter = SettingCorporationActivity.e(this.b);
    List localList = this.a;
    localCorporationListViewAdapter.a(localList);
    CorporationVo localCorporationVo = SettingCorporationActivity.b(this.b).f();
    DragListView localDragListView = SettingCorporationActivity.f(this.b);
    int i = this.a.indexOf(localCorporationVo);
    localDragListView.setItemChecked(i, 1);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     px
 * JD-Core Version:    0.6.0
 */