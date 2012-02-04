import com.mymoney.core.vo.CategoryVo;
import com.mymoney.ui.setting.CategoryListViewAdapter;
import com.mymoney.ui.setting.SettingFirstLevelCategoryActivity;
import com.mymoney.ui.widget.DragListView.OnDropListener;

public class qj
  implements DragListView.OnDropListener
{
  public qj(SettingFirstLevelCategoryActivity paramSettingFirstLevelCategoryActivity)
  {
  }

  public void a(int paramInt1, int paramInt2)
  {
    CategoryVo localCategoryVo = (CategoryVo)SettingFirstLevelCategoryActivity.d(this.a).getItem(paramInt1);
    SettingFirstLevelCategoryActivity.d(this.a).b(localCategoryVo);
    SettingFirstLevelCategoryActivity.d(this.a).a(localCategoryVo, paramInt2);
    SettingFirstLevelCategoryActivity localSettingFirstLevelCategoryActivity = this.a;
    qk localqk = new qk(this);
    localSettingFirstLevelCategoryActivity.runOnUiThread(localqk);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qj
 * JD-Core Version:    0.6.0
 */