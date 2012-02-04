import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;

public class ji extends AsyncTask
{
  ProgressDialog a = null;
  boolean b = 0;

  public ji(AddOrEditTransactionActivity paramAddOrEditTransactionActivity)
  {
  }

  protected Void a(Void[] paramArrayOfVoid)
  {
    boolean bool1;
    if (AddOrEditTransactionActivity.i(this.c) == 3)
    {
      m localm1 = AddOrEditTransactionActivity.h(this.c);
      TransactionVo localTransactionVo1 = AddOrEditTransactionActivity.j(this.c);
      bool1 = localm1.a(localTransactionVo1);
    }
    boolean bool2;
    for (this.b = bool1; ; this.b = bool2)
    {
      return null;
      m localm2 = AddOrEditTransactionActivity.h(this.c);
      TransactionVo localTransactionVo2 = AddOrEditTransactionActivity.j(this.c);
      int i = AddOrEditTransactionActivity.k(this.c);
      bool2 = localm2.a(localTransactionVo2, i);
    }
  }

  protected void a(Void paramVoid)
  {
    this.a.dismiss();
    if (this.b)
    {
      hb.b(AddOrEditTransactionActivity.a(), "保存成功.");
      this.c.finish();
      return;
    }
    hb.b(AddOrEditTransactionActivity.a(), "抱歉,软件故障,请重试.");
  }

  protected void onPreExecute()
  {
    ProgressDialog localProgressDialog = ProgressDialog.show(AddOrEditTransactionActivity.a(), null, "正在保存数据...", 1, 0);
    this.a = localProgressDialog;
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ji
 * JD-Core Version:    0.6.0
 */