import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.sync.SyncActivity;

public class rm
  implements DialogInterface.OnClickListener
{
  public rm(SyncActivity paramSyncActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.n = 0;
    SyncActivity.b(this.a);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     rm
 * JD-Core Version:    0.6.0
 */