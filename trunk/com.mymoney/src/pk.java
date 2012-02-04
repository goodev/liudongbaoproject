import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.setting.SettingBackUpActivity;

public class pk
  implements DialogInterface.OnClickListener
{
  public pk(SettingBackUpActivity paramSettingBackUpActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SettingBackUpActivity localSettingBackUpActivity = this.a;
    String str1 = SettingBackUpActivity.b(this.a)[paramInt];
    String str2 = SettingBackUpActivity.a(localSettingBackUpActivity, str1);
    this.a.showDialog(1);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     pk
 * JD-Core Version:    0.6.0
 */