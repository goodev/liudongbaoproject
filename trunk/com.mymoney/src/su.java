import android.os.AsyncTask;
import android.widget.EditText;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.transfer.TransferActivity;

public class su extends AsyncTask
{
  private su(TransferActivity paramTransferActivity)
  {
  }

  protected Void a(String[] paramArrayOfString)
  {
    m localm = TransferActivity.s(this.a);
    String str = paramArrayOfString[0];
    TransactionVo localTransactionVo = localm.a(str);
    if (localTransactionVo != null)
    {
      TransferActivity localTransferActivity = this.a;
      double d1 = localTransactionVo.b();
      double d2 = TransferActivity.a(localTransferActivity, d1);
    }
    return null;
  }

  protected void a(Void paramVoid)
  {
    EditText localEditText1 = TransferActivity.h(this.a);
    String str1 = gs.a(TransferActivity.m(this.a));
    localEditText1.setText(str1);
    EditText localEditText2 = TransferActivity.f(this.a);
    String str2 = gs.a(TransferActivity.n(this.a));
    localEditText2.setText(str2);
    TransferActivity.D(this.a);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     su
 * JD-Core Version:    0.6.0
 */