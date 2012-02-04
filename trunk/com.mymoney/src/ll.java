import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.main.MainActivity;
import com.mymoney.ui.setting.SettingBackUpActivity;

class ll
  implements DialogInterface.OnClickListener
{
  ll(lj paramlj)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MainActivity localMainActivity = this.a.a;
    Context localContext = MainActivity.a;
    MainActivity.a(localMainActivity, localContext, SettingBackUpActivity.class);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ll
 * JD-Core Version:    0.6.0
 */