import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.mymoney.ui.setting.SettingBackUpActivity;

public class pr extends AsyncTask
{
  ProgressDialog a = null;

  public pr(SettingBackUpActivity paramSettingBackUpActivity)
  {
  }

  protected Boolean a(String[] paramArrayOfString)
  {
    String str = paramArrayOfString[0];
    return Boolean.valueOf(SettingBackUpActivity.c(this.b, str));
  }

  protected void a(Boolean paramBoolean)
  {
    this.a.dismiss();
    if (paramBoolean.booleanValue())
    {
      hb.b(SettingBackUpActivity.d(this.b), "数据恢复成功");
      this.b.finish();
    }
    while (true)
    {
      super.onPostExecute(paramBoolean);
      return;
      hb.b(SettingBackUpActivity.d(this.b), "数据恢复失败,请重试.");
    }
  }

  protected void onPreExecute()
  {
    ProgressDialog localProgressDialog = ProgressDialog.show(SettingBackUpActivity.d(this.b), "", "正在恢复数据...", 1, 0);
    this.a = localProgressDialog;
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     pr
 * JD-Core Version:    0.6.0
 */