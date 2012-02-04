import android.app.PendingIntent;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.mymoney.ui.setting.AutoBackupService;
import java.util.Date;

public class nr extends AsyncTask
{
  private nr(AutoBackupService paramAutoBackupService)
  {
  }

  protected Boolean a(String[] paramArrayOfString)
  {
    boolean bool = AutoBackupService.c(this.a);
    int i = Log.i("AutoBackupService", "aotu backup,execute AutoBackUpTask#doInBackground()");
    return Boolean.valueOf(bool);
  }

  protected void a(Boolean paramBoolean)
  {
    boolean bool = paramBoolean.booleanValue();
    if (bool)
    {
      Context localContext1 = AutoBackupService.a(this.a);
      StringBuilder localStringBuilder = new StringBuilder().append("备份时间：");
      String str1 = gi.a(new Date(), "yyyy-MM-dd HH:mm:ss");
      String str2 = str1;
      PendingIntent localPendingIntent1 = AutoBackupService.d(this.a);
      gv.b(localContext1, 256, "数据备份成功", str2, localPendingIntent1);
      String str3 = gu.r;
      long l = gt.a();
      gu.a(str3, l);
    }
    while (true)
    {
      super.onPostExecute(paramBoolean);
      String str4 = "aotu backup,execute AutoBackUpTask#onPostExecute(),result is " + bool;
      int i = Log.i("AutoBackupService", str4);
      this.a.stopSelf();
      return;
      Context localContext2 = AutoBackupService.a(this.a);
      PendingIntent localPendingIntent2 = AutoBackupService.b(this.a);
      gv.b(localContext2, 256, "自动备份数据失败", "确保你手机sd卡可以使用,请重试.", localPendingIntent2);
    }
  }

  protected void onPreExecute()
  {
    Context localContext = AutoBackupService.a(this.a);
    PendingIntent localPendingIntent = AutoBackupService.b(this.a);
    gv.a(localContext, 256, "正在备份数据...", "", localPendingIntent);
    int i = Log.i("AutoBackupService", "start aotu backup,execute AutoBackUpTask#onPreExecute()");
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     nr
 * JD-Core Version:    0.6.0
 */