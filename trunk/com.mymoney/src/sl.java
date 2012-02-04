import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import com.mymoney.ui.sync.SyncActivity;

public class sl extends AsyncTask
{
  public sl(SyncActivity paramSyncActivity)
  {
  }

  protected Void a(Void[] paramArrayOfVoid)
  {
    SyncActivity localSyncActivity = this.a;
    boolean bool = this.a.n;
    SyncActivity.a(localSyncActivity, bool);
    return null;
  }

  protected void a(Void paramVoid)
  {
    SyncActivity.f(this.a).dismiss();
  }

  protected void onPreExecute()
  {
    if ((gt.g()) || (gt.c(SyncActivity.a())))
    {
      SyncActivity localSyncActivity1 = this.a;
      Context localContext = SyncActivity.a();
      ProgressDialog localProgressDialog1 = new ProgressDialog(localContext);
      ProgressDialog localProgressDialog2 = SyncActivity.a(localSyncActivity1, localProgressDialog1);
      SyncActivity.f(this.a).setTitle("数据同步中");
      SyncActivity.f(this.a).setMessage("开始同步数据...");
      SyncActivity.f(this.a).setIndeterminate(1);
      SyncActivity.f(this.a).setCancelable(0);
      ProgressDialog localProgressDialog3 = SyncActivity.f(this.a);
      SyncActivity localSyncActivity2 = this.a;
      sa localsa = new sa(localSyncActivity2);
      localProgressDialog3.setOnCancelListener(localsa);
      ProgressDialog localProgressDialog4 = SyncActivity.f(this.a);
      sm localsm = new sm(this);
      localProgressDialog4.setButton(-1, "取消", localsm);
      SyncActivity.f(this.a).show();
      return;
    }
    SyncActivity localSyncActivity3 = this.a;
    ProgressDialog localProgressDialog5 = ProgressDialog.show(SyncActivity.a(), null, "开始同步数据...", 1, 0);
    ProgressDialog localProgressDialog6 = SyncActivity.a(localSyncActivity3, localProgressDialog5);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     sl
 * JD-Core Version:    0.6.0
 */