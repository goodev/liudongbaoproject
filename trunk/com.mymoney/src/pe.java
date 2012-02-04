import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.mymoney.ui.setting.SettingActivity;

public class pe extends AsyncTask
{
  ProgressDialog a = null;

  public pe(SettingActivity paramSettingActivity)
  {
  }

  protected Boolean a(String[] paramArrayOfString)
  {
    int i = 1;
    try
    {
      SettingActivity.e(this.b).i();
      return Boolean.valueOf(i);
    }
    catch (ec localec)
    {
      while (true)
      {
        localec.printStackTrace();
        j = 0;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        int j = 0;
      }
    }
  }

  protected void a(Boolean paramBoolean)
  {
    this.a.dismiss();
    if (paramBoolean.booleanValue() == 1)
      hb.b(SettingActivity.a(), "数据恢复成功.");
    while (true)
    {
      super.onPostExecute(paramBoolean);
      return;
      hb.b(SettingActivity.a(), "数据恢复失败,请重试.");
    }
  }

  protected void onPreExecute()
  {
    ProgressDialog localProgressDialog = ProgressDialog.show(SettingActivity.a(), null, "正在恢复初始数据...", 1, 0);
    this.a = localProgressDialog;
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     pe
 * JD-Core Version:    0.6.0
 */