import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.setting.SettingProjectActivity;

public class qn
  implements DialogInterface.OnClickListener
{
  public qn(SettingProjectActivity paramSettingProjectActivity, long paramLong)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      SettingProjectActivity localSettingProjectActivity = this.b;
      long l1 = this.a;
      SettingProjectActivity.a(localSettingProjectActivity, l1);
      return;
    }
    if (paramInt == 1)
    {
      Context localContext = SettingProjectActivity.a();
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle(2131492899).setMessage("删除该项目后，该项目关联的账单同时也被解除关联，您确定要删除该项目吗?");
      qp localqp = new qp(this);
      AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton(2131492901, localqp);
      qo localqo = new qo(this);
      localBuilder2.setNegativeButton(2131492902, localqo).create().show();
      return;
    }
    if (paramInt != 2)
      return;
    k localk = SettingProjectActivity.a(this.b);
    long l2 = this.a;
    boolean bool = localk.e(l2);
    hb.b(SettingProjectActivity.a(), "成功设置为默认项目");
    SettingProjectActivity.b(this.b);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qn
 * JD-Core Version:    0.6.0
 */