import com.mymoney.core.vo.CategoryVo;
import com.mymoney.ui.setting.CategoryListViewAdapter;
import com.mymoney.ui.setting.SettingSubcategoryActivity;
import com.mymoney.ui.widget.DragListView;
import com.mymoney.ui.widget.DragListView.OnDropListener;

public class rb
  implements DragListView.OnDropListener
{
  public rb(SettingSubcategoryActivity paramSettingSubcategoryActivity)
  {
  }

  public void a(int paramInt1, int paramInt2)
  {
    int i = SettingSubcategoryActivity.h(this.a).getCheckedItemPosition();
    CategoryVo localCategoryVo1 = null;
    if (i != -1)
      localCategoryVo1 = (CategoryVo)SettingSubcategoryActivity.g(this.a).getItem(i);
    CategoryVo localCategoryVo2 = (CategoryVo)SettingSubcategoryActivity.g(this.a).getItem(paramInt1);
    SettingSubcategoryActivity.g(this.a).b(localCategoryVo2);
    SettingSubcategoryActivity.g(this.a).a(localCategoryVo2, paramInt2);
    if (localCategoryVo1 != null)
    {
      int j = SettingSubcategoryActivity.g(this.a).c(localCategoryVo1);
      SettingSubcategoryActivity.h(this.a).setItemChecked(j, 1);
    }
    SettingSubcategoryActivity localSettingSubcategoryActivity = this.a;
    rc localrc = new rc(this);
    localSettingSubcategoryActivity.runOnUiThread(localrc);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     rb
 * JD-Core Version:    0.6.0
 */