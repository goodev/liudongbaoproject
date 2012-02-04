import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.setting.SettingBackUpActivity;

public class pn
  implements DialogInterface.OnClickListener
{
  public pn(SettingBackUpActivity paramSettingBackUpActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     pn
 * JD-Core Version:    0.6.0
 */