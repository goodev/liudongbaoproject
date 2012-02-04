import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.mymoney.ui.setting.SettingFirstLevelCategoryActivity;
import com.mymoney.ui.setting.SettingSubcategoryActivity;

public class qy
  implements DialogInterface.OnClickListener
{
  public qy(SettingSubcategoryActivity paramSettingSubcategoryActivity, long paramLong)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      SettingSubcategoryActivity localSettingSubcategoryActivity = this.b;
      long l1 = this.a;
      SettingSubcategoryActivity.a(localSettingSubcategoryActivity, l1);
      return;
    }
    if (paramInt == 1)
    {
      h localh = SettingSubcategoryActivity.a(this.b);
      long l2 = this.a;
      if (localh.e(l2))
      {
        Context localContext = SettingSubcategoryActivity.a();
        AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle(2131492899).setMessage(2131492900);
        ra localra = new ra(this);
        AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton(2131492901, localra);
        qz localqz = new qz(this);
        localBuilder2.setNegativeButton(2131492902, localqz).create().show();
        return;
      }
      String str = SettingSubcategoryActivity.a().getResources().getString(2131492904);
      hb.b(SettingSubcategoryActivity.a(), str);
      return;
    }
    if (paramInt != 2)
      return;
    int i = SettingSubcategoryActivity.b(this.b);
    int j = SettingFirstLevelCategoryActivity.c;
    if (i == j)
    {
      k localk1 = SettingSubcategoryActivity.c(this.b);
      long l3 = this.a;
      boolean bool1 = localk1.d(l3);
      hb.b(SettingSubcategoryActivity.a(), "成功设置为默认收入分类");
    }
    while (true)
    {
      SettingSubcategoryActivity.d(this.b);
      return;
      int k = SettingSubcategoryActivity.b(this.b);
      int m = SettingFirstLevelCategoryActivity.d;
      if (k != m)
        continue;
      k localk2 = SettingSubcategoryActivity.c(this.b);
      long l4 = this.a;
      boolean bool2 = localk2.c(l4);
      hb.b(SettingSubcategoryActivity.a(), "成功设置为默认支出分类");
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qy
 * JD-Core Version:    0.6.0
 */