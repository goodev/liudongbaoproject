import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.mymoney.ui.setting.SettingActivity;
import com.mymoney.ui.sync.SyncActivity;

public class oq
  implements DialogInterface.OnClickListener
{
  public oq(SettingActivity paramSettingActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Context localContext = SettingActivity.a();
    Intent localIntent1 = new Intent(localContext, SyncActivity.class);
    String str = SyncActivity.a;
    Intent localIntent2 = localIntent1.putExtra(str, 1);
    this.a.startActivity(localIntent1);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     oq
 * JD-Core Version:    0.6.0
 */