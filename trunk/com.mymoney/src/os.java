import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.mymoney.ui.setting.SettingActivity;

public class os
  implements DialogInterface.OnClickListener
{
  public os(SettingActivity paramSettingActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent1 = new Intent();
    Intent localIntent2 = localIntent1.setAction("android.settings.WIRELESS_SETTINGS");
    this.a.startActivity(localIntent1);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     os
 * JD-Core Version:    0.6.0
 */