import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.mymoney.ui.sync.SyncActivity;

public class sa
  implements DialogInterface.OnCancelListener
{
  sa(SyncActivity paramSyncActivity)
  {
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    SyncActivity.j(this.a);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     sa
 * JD-Core Version:    0.6.0
 */