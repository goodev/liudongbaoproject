import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.mymoney.ui.sync.SyncActivity;

public class rz extends AsyncTask
{
  public rz(SyncActivity paramSyncActivity)
  {
  }

  protected Void a(Void[] paramArrayOfVoid)
  {
    SyncActivity localSyncActivity = this.a;
    boolean bool = this.a.n;
    SyncActivity.b(localSyncActivity, bool);
    return null;
  }

  protected void a(Void paramVoid)
  {
    SyncActivity.f(this.a).dismiss();
  }

  protected void onPreExecute()
  {
    SyncActivity localSyncActivity = this.a;
    ProgressDialog localProgressDialog1 = ProgressDialog.show(SyncActivity.a(), null, "开始自动测试同步数据...", 1, 0);
    ProgressDialog localProgressDialog2 = SyncActivity.a(localSyncActivity, localProgressDialog1);
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     rz
 * JD-Core Version:    0.6.0
 */