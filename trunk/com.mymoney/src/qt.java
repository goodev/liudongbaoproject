import android.os.AsyncTask;
import android.widget.TextView;
import com.mymoney.core.vo.ProjectVo;
import com.mymoney.ui.setting.ProjectListViewAdapter;
import com.mymoney.ui.setting.SettingProjectActivity;
import com.mymoney.ui.widget.DragListView;
import java.util.List;

public class qt extends AsyncTask
{
  List a;

  public qt(SettingProjectActivity paramSettingProjectActivity)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    List localList = y.a().a(1);
    this.a = localList;
    ProjectVo localProjectVo = new ProjectVo();
    localProjectVo.a(0L);
    localProjectVo.a("无项目");
    localProjectVo.a(1);
    this.a.add(0, localProjectVo);
    return null;
  }

  protected void onPostExecute(Object paramObject)
  {
    if (SettingProjectActivity.c(this.b).getVisibility() == 0)
      SettingProjectActivity.c(this.b).setVisibility(8);
    ProjectListViewAdapter localProjectListViewAdapter = SettingProjectActivity.d(this.b);
    List localList = this.a;
    localProjectListViewAdapter.a(localList);
    ProjectVo localProjectVo = SettingProjectActivity.a(this.b).d();
    DragListView localDragListView = SettingProjectActivity.e(this.b);
    int i = this.a.indexOf(localProjectVo);
    localDragListView.setItemChecked(i, 1);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qt
 * JD-Core Version:    0.6.0
 */