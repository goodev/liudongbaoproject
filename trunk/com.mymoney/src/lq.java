import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.mymoney.ui.main.MainActivity;
import com.mymoney.ui.sync.SyncActivity;

class lq
  implements DialogInterface.OnClickListener
{
  lq(lo paramlo)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Context localContext = MainActivity.a;
    Intent localIntent1 = new Intent(localContext, SyncActivity.class);
    String str = SyncActivity.a;
    Intent localIntent2 = localIntent1.putExtra(str, 1);
    this.a.a.startActivity(localIntent1);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     lq
 * JD-Core Version:    0.6.0
 */