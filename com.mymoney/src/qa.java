import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.mymoney.ui.setting.SettingCurrencyRateActivity;

public class qa
  implements DialogInterface.OnClickListener
{
  public qa(SettingCurrencyRateActivity paramSettingCurrencyRateActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent1 = new Intent();
    Intent localIntent2 = localIntent1.setAction("android.settings.WIRELESS_SETTINGS");
    try
    {
      this.a.startActivity(localIntent1);
      return;
    }
    catch (Exception localException)
    {
      hb.b(SettingCurrencyRateActivity.a(), "抱歉,无法打开网络连接界面,请手动进入设置打开");
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qa
 * JD-Core Version:    0.6.0
 */