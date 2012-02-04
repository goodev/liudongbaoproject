import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.mymoney.ui.sync.SyncActivity;

public class ro
  implements DialogInterface.OnClickListener
{
  public ro(SyncActivity paramSyncActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SyncActivity.c(this.a).setText("");
    SyncActivity.d(this.a).setText("");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ro
 * JD-Core Version:    0.6.0
 */