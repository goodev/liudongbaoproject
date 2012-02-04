import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import com.mymoney.ui.setting.SettingActivity;

class pb
  implements DialogInterface.OnClickListener
{
  pb(oz paramoz)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Context localContext = SettingActivity.a();
    fn localfn = SettingActivity.d(this.a.a.d);
    AsyncTask localAsyncTask = new kx(localContext, localfn).execute(null);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     pb
 * JD-Core Version:    0.6.0
 */