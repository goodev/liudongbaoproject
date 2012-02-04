import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.mymoney.ui.setting.SettingBackUpActivity;

public class pq extends AsyncTask
{
  ProgressDialog a = null;

  public pq(SettingBackUpActivity paramSettingBackUpActivity)
  {
  }

  protected Boolean a(String[] paramArrayOfString)
  {
    return Boolean.valueOf(SettingBackUpActivity.e(this.b));
  }

  protected void a(Boolean paramBoolean)
  {
    this.a.dismiss();
    if (paramBoolean.booleanValue())
    {
      hb.a(SettingBackUpActivity.d(this.b), "数据备份成功,备份文件存放于sd卡.mymoney/backup目录下,可以直接拷贝到电脑中存放.");
      String str = gu.r;
      long l = gt.a();
      gu.a(str, l);
      this.b.finish();
    }
    while (true)
    {
      super.onPostExecute(paramBoolean);
      return;
      hb.b(SettingBackUpActivity.d(this.b), "数据备份失败,请确保你手机sd卡可以使用,请重试.");
    }
  }

  protected void onPreExecute()
  {
    ProgressDialog localProgressDialog = ProgressDialog.show(SettingBackUpActivity.d(this.b), "", "正在备份数据...", 1, 0);
    this.a = localProgressDialog;
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     pq
 * JD-Core Version:    0.6.0
 */