import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.setting.SettingActivity;

public class ou
  implements DialogInterface.OnClickListener
{
  public ou(SettingActivity paramSettingActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SettingActivity.b(this.a);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ou
 * JD-Core Version:    0.6.0
 */