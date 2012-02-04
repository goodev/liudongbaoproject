import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.text.Html;
import android.text.Spanned;
import com.mymoney.ui.setting.SettingActivity;

public class ow extends AsyncTask
{
  boolean a = 0;
  boolean b = 0;
  boolean c = 0;
  private ProgressDialog e;

  public ow(SettingActivity paramSettingActivity)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    try
    {
      SettingActivity localSettingActivity = this.d;
      fm localfm = fm.a();
      Context localContext = SettingActivity.a();
      fn localfn1 = localfm.a(localContext);
      fn localfn2 = SettingActivity.a(localSettingActivity, localfn1);
      return null;
    }
    catch (ek localek)
    {
      while (true)
      {
        this.a = 1;
        this.b = 1;
        localek.printStackTrace();
      }
    }
    catch (ef localef)
    {
      while (true)
      {
        this.a = 1;
        this.c = 1;
        localef.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        this.a = 1;
        this.c = 1;
        localException.printStackTrace();
      }
    }
  }

  protected void onPostExecute(Object paramObject)
  {
    int i = 0;
    this.e.dismiss();
    if ((this.a) || (SettingActivity.d(this.d) == null))
    {
      if (this.b)
      {
        hb.b(SettingActivity.a(), "网络连接断开或不稳定,请重试");
        return;
      }
      hb.b(SettingActivity.a(), "服务器错误,请重试");
      return;
    }
    try
    {
      PackageManager localPackageManager = SettingActivity.a().getPackageManager();
      String str1 = SettingActivity.a().getPackageName();
      int j = localPackageManager.getPackageInfo(str1, 0).versionCode;
      String str2 = gu.n;
      long l = System.currentTimeMillis();
      gu.a(str2, l);
      if (SettingActivity.d(this.d).a() > j)
      {
        String[] arrayOfString = SettingActivity.d(this.d).d().split("#");
        StringBuilder localStringBuilder1 = new StringBuilder();
        int k = arrayOfString.length;
        int m = 0;
        i = 1;
        int n = m;
        while (n < k)
        {
          String str3 = arrayOfString[n];
          StringBuilder localStringBuilder2 = new StringBuilder();
          String str4 = String.valueOf(i);
          String str5 = str4 + ".";
          StringBuilder localStringBuilder3 = localStringBuilder1.append(str5);
          StringBuilder localStringBuilder4 = localStringBuilder1.append(str3);
          StringBuilder localStringBuilder5 = localStringBuilder1.append("<br /><br />");
          i += 1;
          n += 1;
        }
        Context localContext = SettingActivity.a();
        AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext);
        StringBuilder localStringBuilder6 = new StringBuilder().append("发现新版本:");
        String str6 = SettingActivity.d(this.d).b();
        String str7 = str6;
        AlertDialog.Builder localBuilder2 = localBuilder1.setTitle(str7);
        Spanned localSpanned = Html.fromHtml(localStringBuilder1.toString());
        AlertDialog.Builder localBuilder3 = localBuilder2.setMessage(localSpanned);
        oz localoz = new oz(this);
        AlertDialog.Builder localBuilder4 = localBuilder3.setPositiveButton("下载新版", localoz);
        oy localoy = new oy(this);
        localBuilder4.setNegativeButton("以后再说", localoy).create().show();
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      hb.b(SettingActivity.a(), "系统错误,无法获取软件版本号");
      localNameNotFoundException.printStackTrace();
      return;
    }
    hb.b(SettingActivity.a(), "已经是最新版不需要升级");
  }

  protected void onPreExecute()
  {
    Context localContext = SettingActivity.a();
    ProgressDialog localProgressDialog1 = new ProgressDialog(localContext);
    this.e = localProgressDialog1;
    this.e.setTitle("提示");
    this.e.setMessage("正在获取软件新版本信息...");
    this.e.setIndeterminate(1);
    this.e.setCancelable(1);
    ProgressDialog localProgressDialog2 = this.e;
    ox localox = new ox(this);
    localProgressDialog2.setButton(-1, "取消", localox);
    this.e.show();
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ow
 * JD-Core Version:    0.6.0
 */