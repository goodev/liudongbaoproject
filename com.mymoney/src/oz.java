import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import com.mymoney.ui.helper.NetworkHelper;
import com.mymoney.ui.setting.SettingActivity;

class oz
  implements DialogInterface.OnClickListener
{
  oz(ow paramow)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (ep.a())
      if (NetworkHelper.b(SettingActivity.a()))
      {
        Context localContext1 = SettingActivity.a();
        fn localfn = SettingActivity.d(this.a.d);
        AsyncTask localAsyncTask = new kx(localContext1, localfn).execute(null);
      }
    while (true)
    {
      paramDialogInterface.dismiss();
      return;
      Context localContext2 = SettingActivity.a();
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext2).setTitle("温馨提示").setMessage("你当前的手机网络不是wifi,下载新版需要耗费较多的流量(大约3M)和时间,建议在wifi网络环境下下载,你是否确定要下载?");
      pb localpb = new pb(this);
      AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton("确定下载", localpb);
      pa localpa = new pa(this);
      AlertDialog localAlertDialog = localBuilder2.setNegativeButton("取消下载", localpa).show();
      continue;
      hb.b(SettingActivity.a(), "sd卡不可用,无法下载最新的软件安装包");
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     oz
 * JD-Core Version:    0.6.0
 */