import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mymoney.ui.main.MainActivity;

public class lj extends BroadcastReceiver
{
  public lj(MainActivity paramMainActivity)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    String str2 = MainActivity.e;
    if (!str1.equalsIgnoreCase(str2))
      return;
    gj.a(MainActivity.b, "BackupBroadcastReceiver#Receiver()");
    Context localContext = MainActivity.a;
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle("温馨提示").setMessage("你已经有段时间没有备份了,是否要进行备份?");
    ll localll = new ll(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton("确定", localll);
    lk locallk = new lk(this);
    AlertDialog localAlertDialog = localBuilder2.setNegativeButton("下次再说", locallk).show();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     lj
 * JD-Core Version:    0.6.0
 */