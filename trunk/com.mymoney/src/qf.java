import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.mymoney.ui.setting.SettingExportDataToExcelActivity;
import java.io.IOException;

public class qf extends AsyncTask
{
  ProgressDialog a = null;
  boolean b = 1;
  String c = "";

  public qf(SettingExportDataToExcelActivity paramSettingExportDataToExcelActivity)
  {
  }

  protected Boolean a(String[] paramArrayOfString)
  {
    try
    {
      String str = SettingExportDataToExcelActivity.b(this.d).k();
      this.c = str;
      return null;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        localIOException.printStackTrace();
        this.b = 0;
      }
    }
  }

  protected void a(Boolean paramBoolean)
  {
    this.a.dismiss();
    if (this.b)
    {
      Context localContext = SettingExportDataToExcelActivity.a(this.d);
      StringBuilder localStringBuilder1 = new StringBuilder().append("随手记数据已成功导出excel到sd卡,文件名为");
      String str1 = this.c;
      String str2 = str1;
      hb.a(localContext, str2);
      String str3 = SettingExportDataToExcelActivity.b(this.d).g().a();
      if (TextUtils.isEmpty(str3))
        str3 = "yourAccount@qq.com";
      if (SettingExportDataToExcelActivity.c(this.d))
      {
        Intent localIntent1 = new Intent("android.intent.action.SEND");
        Intent localIntent2 = localIntent1.putExtra("android.intent.extra.EMAIL", str3);
        Intent localIntent3 = localIntent1.setType("image/*");
        StringBuilder localStringBuilder2 = new StringBuilder().append("随手记数据导出到Excel(CSV)文件(");
        String str4 = this.c;
        String str5 = str4 + ")";
        Intent localIntent4 = localIntent1.putExtra("android.intent.extra.SUBJECT", str5);
        StringBuilder localStringBuilder3 = new StringBuilder().append("file://");
        String str6 = ep.a;
        StringBuilder localStringBuilder4 = localStringBuilder3.append(str6).append("/");
        String str7 = this.c;
        Uri localUri = Uri.parse(str7);
        Intent localIntent5 = localIntent1.putExtra("android.intent.extra.STREAM", localUri);
        String str8 = SettingExportDataToExcelActivity.a(this.d).getResources().getString(2131492909);
        Intent localIntent6 = localIntent1.putExtra("android.intent.extra.TEXT", str8);
        SettingExportDataToExcelActivity localSettingExportDataToExcelActivity = this.d;
        Intent localIntent7 = Intent.createChooser(localIntent1, "导出数据到Email");
        localSettingExportDataToExcelActivity.startActivity(localIntent7);
      }
    }
    while (true)
    {
      super.onPostExecute(paramBoolean);
      return;
      hb.a(SettingExportDataToExcelActivity.a(this.d), "数据导出excel失败,请重试.");
    }
  }

  protected void onPreExecute()
  {
    ProgressDialog localProgressDialog = ProgressDialog.show(SettingExportDataToExcelActivity.a(this.d), "", "正在导出数据请稍后...", 1, 0);
    this.a = localProgressDialog;
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qf
 * JD-Core Version:    0.6.0
 */