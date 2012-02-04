import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.setting.SettingActivity;

public class ov
  implements DialogInterface.OnClickListener
{
  public ov(SettingActivity paramSettingActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SettingActivity.c(this.a);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ov
 * JD-Core Version:    0.6.0
 */