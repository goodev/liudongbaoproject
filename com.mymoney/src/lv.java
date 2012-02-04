import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import com.mymoney.ui.main.MainActivity;

class lv
  implements DialogInterface.OnClickListener
{
  lv(lt paramlt)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Context localContext = MainActivity.a;
    fn localfn = this.a.a.a;
    AsyncTask localAsyncTask = new kx(localContext, localfn).execute(null);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     lv
 * JD-Core Version:    0.6.0
 */