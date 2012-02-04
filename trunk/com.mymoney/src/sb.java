import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mymoney.ui.sync.SyncActivity;

public class sb extends Handler
{
  public sb(SyncActivity paramSyncActivity, Looper paramLooper)
  {
    super(paramLooper);
  }

  private void a()
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (SyncActivity.e(this.a))
    {
      String str1 = (String)paramMessage.obj;
      SyncActivity.f(this.a).setMessage(str1);
      int i = paramMessage.what;
      int j = SyncActivity.c;
      if (i == j)
      {
        Context localContext1 = SyncActivity.a();
        AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext1).setTitle("同步成功").setMessage("恭喜你已经成功同步数据.");
        sc localsc = new sc(this);
        localBuilder1.setPositiveButton("确定", localsc).create().show();
        SyncActivity.g(this.a);
        a();
        return;
      }
      int k = paramMessage.what;
      int m = SyncActivity.d;
      if (k == m)
      {
        if (gx.a(str1))
          str1 = "抱歉,服务器错误,同步数据出现问题,请重试,只有在成功同步数据后手机端的数据才会跟web端一致.";
        Context localContext2 = SyncActivity.a();
        AlertDialog.Builder localBuilder2 = new AlertDialog.Builder(localContext2).setTitle("同步故障").setMessage(str1);
        sd localsd = new sd(this);
        localBuilder2.setPositiveButton("重试", localsd).setNegativeButton("取消", null).create().show();
        a();
        return;
      }
      int n = paramMessage.what;
      int i1 = SyncActivity.k;
      if (n == i1)
      {
        Context localContext3 = SyncActivity.a();
        AlertDialog.Builder localBuilder3 = new AlertDialog.Builder(localContext3).setTitle("同步故障").setMessage(str1);
        se localse = new se(this);
        localBuilder3.setPositiveButton("确定", localse).create().show();
        a();
        return;
      }
      int i2 = paramMessage.what;
      int i3 = SyncActivity.f;
      if (i2 == i3)
      {
        Context localContext4 = SyncActivity.a();
        AlertDialog.Builder localBuilder4 = new AlertDialog.Builder(localContext4).setTitle("同步失败").setMessage("抱歉,用户名或密码错误,请重试.");
        sf localsf = new sf(this);
        localBuilder4.setPositiveButton("确定", localsf).create().show();
        a();
        return;
      }
      int i4 = paramMessage.what;
      int i5 = SyncActivity.g;
      if (i4 == i5)
      {
        Context localContext5 = SyncActivity.a();
        AlertDialog.Builder localBuilder5 = new AlertDialog.Builder(localContext5).setTitle("同步失败").setMessage("抱歉,另一设备正用此账号数据同步中,请稍后重试.");
        sg localsg = new sg(this);
        localBuilder5.setPositiveButton("确定", localsg).create().show();
        a();
        return;
      }
      int i6 = paramMessage.what;
      int i7 = SyncActivity.h;
      if (i6 == i7)
      {
        Context localContext6 = SyncActivity.a();
        AlertDialog.Builder localBuilder6 = new AlertDialog.Builder(localContext6).setTitle("同步失败").setMessage(str1);
        sh localsh = new sh(this);
        localBuilder6.setPositiveButton("确定", localsh).create().show();
        a();
        return;
      }
      int i8 = paramMessage.what;
      int i9 = SyncActivity.i;
      if (i8 == i9)
      {
        Context localContext7 = SyncActivity.a();
        AlertDialog.Builder localBuilder7 = new AlertDialog.Builder(localContext7).setTitle("同步故障").setMessage("抱歉,网络中断或不稳定无法继续进行数据同步,请检查你的网络设置,只有在成功同步数据后手机端的数据才会跟web端一致.");
        si localsi = new si(this);
        localBuilder7.setPositiveButton("重试", localsi).setNegativeButton("取消", null).create().show();
        return;
      }
      int i10 = paramMessage.what;
      int i11 = SyncActivity.j;
      if (i10 != i11)
        return;
      Context localContext8 = SyncActivity.a();
      AlertDialog.Builder localBuilder8 = new AlertDialog.Builder(localContext8).setTitle("同步故障").setMessage("抱歉,同步交易本地分类数据有错误,其服务器id不能为0,只有在成功同步数据后手机端的数据才会跟web端一致");
      sj localsj = new sj(this);
      localBuilder8.setPositiveButton("重试", localsj).setNegativeButton("取消", null).create().show();
      return;
    }
    if (!SyncActivity.i(this.a))
      return;
    String str2 = (String)paramMessage.obj;
    SyncActivity.f(this.a).setMessage(str2);
    int i12 = paramMessage.what;
    int i13 = SyncActivity.c;
    if (i12 != i13)
      return;
    Context localContext9 = SyncActivity.a();
    AlertDialog.Builder localBuilder9 = new AlertDialog.Builder(localContext9).setTitle("同步成功").setMessage(str2);
    sk localsk = new sk(this);
    localBuilder9.setPositiveButton("确定", localsk).create().show();
    SyncActivity.g(this.a);
    a();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     sb
 * JD-Core Version:    0.6.0
 */