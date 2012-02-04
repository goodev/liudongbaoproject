import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.mymoney.ui.sync.SyncActivity;

class sd
  implements DialogInterface.OnClickListener
{
  sd(sb paramsb)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = SyncActivity.h(this.a.a).performClick();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     sd
 * JD-Core Version:    0.6.0
 */