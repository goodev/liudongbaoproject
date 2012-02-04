import android.os.AsyncTask;
import android.widget.TextView;
import com.mymoney.ui.setting.CategoryListViewAdapter;
import com.mymoney.ui.setting.SettingFirstLevelCategoryActivity;
import java.util.List;

public class qm extends AsyncTask
{
  List a;

  public qm(SettingFirstLevelCategoryActivity paramSettingFirstLevelCategoryActivity)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    int i = SettingFirstLevelCategoryActivity.b(this.b);
    int j = SettingFirstLevelCategoryActivity.c;
    if (i == j)
    {
      List localList1 = SettingFirstLevelCategoryActivity.a(this.b).b();
      this.a = localList1;
    }
    while (true)
    {
      return null;
      int k = SettingFirstLevelCategoryActivity.b(this.b);
      int m = SettingFirstLevelCategoryActivity.d;
      if (k != m)
        continue;
      List localList2 = SettingFirstLevelCategoryActivity.a(this.b).a();
      this.a = localList2;
    }
  }

  protected void onPostExecute(Object paramObject)
  {
    if (SettingFirstLevelCategoryActivity.c(this.b).getVisibility() == 0)
      SettingFirstLevelCategoryActivity.c(this.b).setVisibility(8);
    CategoryListViewAdapter localCategoryListViewAdapter = SettingFirstLevelCategoryActivity.d(this.b);
    List localList = this.a;
    localCategoryListViewAdapter.a(localList);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qm
 * JD-Core Version:    0.6.0
 */