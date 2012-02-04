import android.os.AsyncTask;
import android.widget.TextView;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.ui.setting.CategoryListViewAdapter;
import com.mymoney.ui.setting.SettingFirstLevelCategoryActivity;
import com.mymoney.ui.setting.SettingSubcategoryActivity;
import com.mymoney.ui.widget.DragListView;
import java.util.List;

public class re extends AsyncTask
{
  List a;

  public re(SettingSubcategoryActivity paramSettingSubcategoryActivity)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    h localh = SettingSubcategoryActivity.a(this.b);
    long l = SettingSubcategoryActivity.e(this.b).a();
    List localList = localh.b(l);
    this.a = localList;
    return null;
  }

  protected void onPostExecute(Object paramObject)
  {
    if (SettingSubcategoryActivity.f(this.b).getVisibility() == 0)
      SettingSubcategoryActivity.f(this.b).setVisibility(8);
    CategoryListViewAdapter localCategoryListViewAdapter = SettingSubcategoryActivity.g(this.b);
    List localList = this.a;
    localCategoryListViewAdapter.a(localList);
    CategoryVo localCategoryVo = null;
    int i = SettingSubcategoryActivity.b(this.b);
    int j = SettingFirstLevelCategoryActivity.c;
    if (i == j)
      localCategoryVo = CategoryVo.d(SettingSubcategoryActivity.c(this.b).c());
    while (true)
    {
      DragListView localDragListView = SettingSubcategoryActivity.h(this.b);
      int k = this.a.indexOf(localCategoryVo);
      localDragListView.setItemChecked(k, 1);
      return;
      int m = SettingSubcategoryActivity.b(this.b);
      int n = SettingFirstLevelCategoryActivity.d;
      if (m != n)
        continue;
      localCategoryVo = CategoryVo.d(SettingSubcategoryActivity.c(this.b).b());
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     re
 * JD-Core Version:    0.6.0
 */