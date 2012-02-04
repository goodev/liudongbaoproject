import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.setting.SettingBackUpActivity;

public class po
  implements DialogInterface.OnClickListener
{
  private po(SettingBackUpActivity paramSettingBackUpActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SettingBackUpActivity localSettingBackUpActivity = this.a;
    int i = paramInt + 1;
    int j = SettingBackUpActivity.a(localSettingBackUpActivity, i);
    String str1 = SettingBackUpActivity.f(this.a);
    StringBuilder localStringBuilder = new StringBuilder().append("autoBackupCycle ");
    int k = SettingBackUpActivity.i(this.a);
    String str2 = k + " days";
    gj.a(str1, str2);
    gu.c(SettingBackUpActivity.i(this.a));
    SettingBackUpActivity.h(this.a);
    paramDialogInterface.dismiss();
    hb.b(SettingBackUpActivity.d(this.a), "设置自动备份周期成功");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     po
 * JD-Core Version:    0.6.0
 */