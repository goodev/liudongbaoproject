import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mymoney.ui.main.MainActivity;

public class lo extends BroadcastReceiver
{
  public lo(MainActivity paramMainActivity)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    String str2 = MainActivity.d;
    if (!str1.equalsIgnoreCase(str2))
      return;
    gj.a(MainActivity.b, "SyncRemindBroadcastReceiver#Receiver()");
    Context localContext = MainActivity.a;
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle("温馨提示").setMessage("你已经有段时间没有同步了,是否要进行同步?");
    lq locallq = new lq(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton("确定", locallq);
    lp locallp = new lp(this);
    AlertDialog localAlertDialog = localBuilder2.setNegativeButton("下次再说", locallp).show();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     lo
 * JD-Core Version:    0.6.0
 */