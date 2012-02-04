import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.mymoney.ui.setting.SettingFirstLevelCategoryActivity;

public class qg
  implements DialogInterface.OnClickListener
{
  public qg(SettingFirstLevelCategoryActivity paramSettingFirstLevelCategoryActivity, long paramLong)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      SettingFirstLevelCategoryActivity localSettingFirstLevelCategoryActivity = this.b;
      long l1 = this.a;
      SettingFirstLevelCategoryActivity.a(localSettingFirstLevelCategoryActivity, l1);
      return;
    }
    if (paramInt != 1)
      return;
    h localh = SettingFirstLevelCategoryActivity.a(this.b);
    long l2 = this.a;
    if (localh.e(l2))
    {
      Context localContext = SettingFirstLevelCategoryActivity.a();
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle(2131492899).setMessage(2131492900);
      qi localqi = new qi(this);
      AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton(2131492901, localqi);
      qh localqh = new qh(this);
      localBuilder2.setNegativeButton(2131492902, localqh).create().show();
      return;
    }
    String str = SettingFirstLevelCategoryActivity.a().getResources().getString(2131492904);
    hb.b(SettingFirstLevelCategoryActivity.a(), str);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qg
 * JD-Core Version:    0.6.0
 */