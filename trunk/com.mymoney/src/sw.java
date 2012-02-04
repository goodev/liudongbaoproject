import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.ProjectVo;
import com.mymoney.ui.transfer.TransferActivity;

public class sw extends AsyncTask
{
  ProgressDialog a = null;
  boolean b = 0;

  public sw(TransferActivity paramTransferActivity)
  {
  }

  protected Void a(Void[] paramArrayOfVoid)
  {
    double d2;
    double d3;
    if (TransferActivity.k(this.c))
    {
      double d1 = TransferActivity.l(this.c);
      d2 = TransferActivity.l(this.c);
      d3 = d1;
      if (!TransferActivity.o(this.c))
        break label152;
      m localm1 = TransferActivity.s(this.c);
      AccountVo localAccountVo1 = TransferActivity.p(this.c);
      AccountVo localAccountVo2 = TransferActivity.q(this.c);
      long l1 = TransferActivity.a(this.c);
      ProjectVo localProjectVo1 = TransferActivity.r(this.c);
      String str1 = TransferActivity.i(this.c);
      boolean bool1 = localm1.a(d3, localAccountVo1, d2, localAccountVo2, l1, localProjectVo1, str1, 1);
      this.b = bool1;
    }
    while (true)
    {
      return null;
      double d4 = TransferActivity.m(this.c);
      d2 = TransferActivity.n(this.c);
      d3 = d4;
      break;
      label152: if (!TransferActivity.t(this.c))
        continue;
      m localm2 = TransferActivity.s(this.c);
      long l2 = TransferActivity.u(this.c);
      AccountVo localAccountVo3 = TransferActivity.p(this.c);
      AccountVo localAccountVo4 = TransferActivity.q(this.c);
      long l3 = TransferActivity.a(this.c);
      ProjectVo localProjectVo2 = TransferActivity.r(this.c);
      String str2 = TransferActivity.i(this.c);
      double d5 = d3;
      double d6 = d2;
      boolean bool2 = localm2.a(l2, d5, localAccountVo3, d6, localAccountVo4, l3, localProjectVo2, str2);
      this.b = bool2;
    }
  }

  protected void a(Void paramVoid)
  {
    this.a.dismiss();
    if (this.b)
    {
      hb.b(TransferActivity.a(), "保存成功.");
      this.c.finish();
      return;
    }
    hb.b(TransferActivity.a(), "抱歉,系统故障请重试.");
  }

  protected void onPreExecute()
  {
    ProgressDialog localProgressDialog = ProgressDialog.show(TransferActivity.a(), null, "正在保存数据...", 1, 0);
    this.a = localProgressDialog;
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     sw
 * JD-Core Version:    0.6.0
 */