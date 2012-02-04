import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import com.mymoney.ui.helper.NetworkHelper;
import com.mymoney.ui.setting.SettingCurrencyRateActivity;
import java.util.Calendar;

public class qc extends AsyncTask
{
  ProgressDialog a;
  int b = 1;
  int c = -1;

  public qc(SettingCurrencyRateActivity paramSettingCurrencyRateActivity)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    try
    {
      if (NetworkHelper.a(SettingCurrencyRateActivity.a()))
        hq.a().a(1);
      for (i = this.b; ; i = this.c)
        return Integer.valueOf(i);
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        int i = this.c;
      }
    }
  }

  protected void onPostExecute(Object paramObject)
  {
    this.a.dismiss();
    int i = this.b;
    int j = ((Integer)paramObject).intValue();
    if (i == j)
    {
      Calendar localCalendar = Calendar.getInstance();
      int k = localCalendar.get(1);
      int m = localCalendar.get(2) + 1;
      int n = localCalendar.get(5);
      hb.b(SettingCurrencyRateActivity.a(), "汇率更新成功.");
      String str = "更新于" + k + "-" + m + "-" + n;
      SettingCurrencyRateActivity.a(this.d).setText(str);
      return;
    }
    hb.b(SettingCurrencyRateActivity.a(), "汇率更新失败,请重试");
    SettingCurrencyRateActivity.a(this.d).setText("网络更新失败");
  }

  protected void onPreExecute()
  {
    Context localContext = SettingCurrencyRateActivity.a();
    ProgressDialog localProgressDialog1 = new ProgressDialog(localContext);
    this.a = localProgressDialog1;
    this.a.setTitle("更新汇率");
    this.a.setMessage("正在更新汇率中,请稍后...");
    this.a.setIndeterminate(1);
    this.a.setCancelable(1);
    ProgressDialog localProgressDialog2 = this.a;
    qd localqd = new qd(this);
    localProgressDialog2.setButton(-1, "取消", localqd);
    this.a.show();
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qc
 * JD-Core Version:    0.6.0
 */