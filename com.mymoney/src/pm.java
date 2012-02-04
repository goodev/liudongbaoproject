import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.setting.SettingBackUpActivity;

public class pm
  implements DialogInterface.OnClickListener
{
  public pm(SettingBackUpActivity paramSettingBackUpActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (ep.a())
    {
      SettingBackUpActivity localSettingBackUpActivity = this.a;
      String str = SettingBackUpActivity.c(this.a);
      SettingBackUpActivity.b(localSettingBackUpActivity, str);
      return;
    }
    hb.b(SettingBackUpActivity.d(this.a), "sd卡不可用.");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     pm
 * JD-Core Version:    0.6.0
 */