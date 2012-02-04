import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.setting.SettingCorporationActivity;

public class ps
  implements DialogInterface.OnClickListener
{
  public ps(SettingCorporationActivity paramSettingCorporationActivity, long paramLong)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      SettingCorporationActivity localSettingCorporationActivity = this.b;
      long l1 = this.a;
      SettingCorporationActivity.a(localSettingCorporationActivity, l1);
      return;
    }
    if (paramInt == 1)
    {
      Context localContext = SettingCorporationActivity.a();
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle(2131492899).setMessage("删除该商家后，该商家关联的账单同时也被解除关联，您确定要删除该商家吗?");
      pu localpu = new pu(this);
      AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton(2131492901, localpu);
      pt localpt = new pt(this);
      localBuilder2.setNegativeButton(2131492902, localpt).create().show();
      return;
    }
    if (paramInt != 2)
      return;
    k localk = SettingCorporationActivity.b(this.b);
    long l2 = this.a;
    boolean bool = localk.b(l2);
    hb.b(SettingCorporationActivity.a(), "成功设置为默认商家.");
    SettingCorporationActivity.c(this.b);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ps
 * JD-Core Version:    0.6.0
 */