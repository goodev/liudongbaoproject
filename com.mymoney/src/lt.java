import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import com.mymoney.ui.helper.NetworkHelper;
import com.mymoney.ui.main.MainActivity;

class lt
  implements DialogInterface.OnClickListener
{
  lt(lr paramlr)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (ep.a())
      if (NetworkHelper.b(MainActivity.a))
      {
        Context localContext1 = MainActivity.a;
        fn localfn = this.a.a;
        AsyncTask localAsyncTask = new kx(localContext1, localfn).execute(null);
      }
    while (true)
    {
      paramDialogInterface.dismiss();
      return;
      Context localContext2 = MainActivity.a;
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext2).setTitle("温馨提示").setMessage("你当前的手机网络不是wifi,下载需要耗费较多的流量(大约3M)和时间,建议在wifi网络环境下下载,你是否确定要下载?");
      lv locallv = new lv(this);
      AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton("确定下载", locallv);
      lu locallu = new lu(this);
      AlertDialog localAlertDialog = localBuilder2.setNegativeButton("取消下载", locallu).show();
      continue;
      hb.b(MainActivity.a, "sd卡不可用,无法下载最新的软件安装包");
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     lt
 * JD-Core Version:    0.6.0
 */