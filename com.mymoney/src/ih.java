import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;

public class ih extends AsyncTask
{
  ProgressDialog a = null;
  boolean b = 0;
  boolean c = 0;

  public ih(AddOrEditTransNewActivity paramAddOrEditTransNewActivity)
  {
  }

  protected Void a(Boolean[] paramArrayOfBoolean)
  {
    boolean bool1 = paramArrayOfBoolean[0].booleanValue();
    this.c = bool1;
    boolean bool2;
    if (AddOrEditTransNewActivity.t(this.d))
    {
      m localm1 = AddOrEditTransNewActivity.i(this.d);
      TransactionVo localTransactionVo1 = AddOrEditTransNewActivity.u(this.d);
      bool2 = localm1.a(localTransactionVo1);
    }
    boolean bool3;
    for (this.b = bool2; ; this.b = bool3)
    {
      return null;
      m localm2 = AddOrEditTransNewActivity.i(this.d);
      TransactionVo localTransactionVo2 = AddOrEditTransNewActivity.u(this.d);
      int i = AddOrEditTransNewActivity.v(this.d);
      bool3 = localm2.a(localTransactionVo2, i);
    }
  }

  protected void a(Void paramVoid)
  {
    if (AddOrEditTransNewActivity.s(this.d))
      this.a.dismiss();
    if (this.b)
    {
      hb.b(AddOrEditTransNewActivity.j(this.d), "保存成功.");
      if (this.d.k)
        this.d.finish();
      if (this.c)
        AddOrEditTransNewActivity.w(this.d);
    }
    while (true)
    {
      super.onPostExecute(paramVoid);
      return;
      hb.b(AddOrEditTransNewActivity.j(this.d), "抱歉,软件故障,请重试.");
    }
  }

  protected void onPreExecute()
  {
    if (AddOrEditTransNewActivity.s(this.d))
    {
      ProgressDialog localProgressDialog = ProgressDialog.show(AddOrEditTransNewActivity.j(this.d), null, "正在保存数据...", 1, 0);
      this.a = localProgressDialog;
    }
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ih
 * JD-Core Version:    0.6.0
 */