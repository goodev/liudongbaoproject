import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;
import com.mymoney.ui.main.MainActivity;

public class lf
  implements DialogInterface.OnClickListener
{
  public lf(MainActivity paramMainActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
    Process.killProcess(Process.myPid());
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     lf
 * JD-Core Version:    0.6.0
 */