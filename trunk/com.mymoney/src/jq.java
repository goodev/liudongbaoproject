import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.mymoney.ui.addtrans.TransactionPhotoEditActivity;

public class jq extends AsyncTask
{
  ProgressDialog a = null;

  public jq(TransactionPhotoEditActivity paramTransactionPhotoEditActivity)
  {
  }

  protected Boolean a(Void[] paramArrayOfVoid)
  {
    return Boolean.valueOf(TransactionPhotoEditActivity.g(this.b));
  }

  protected void a(Boolean paramBoolean)
  {
    this.a.dismiss();
    if (paramBoolean.booleanValue())
    {
      hb.b(this.b.b, "照片保存成功.");
      this.b.finish();
    }
    while (true)
    {
      super.onPostExecute(paramBoolean);
      return;
      hb.b(this.b.b, "照片保存失败,请重试.");
    }
  }

  protected void onPreExecute()
  {
    ProgressDialog localProgressDialog = ProgressDialog.show(this.b.b, null, "正在保存照片...", 1, 0);
    this.a = localProgressDialog;
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     jq
 * JD-Core Version:    0.6.0
 */