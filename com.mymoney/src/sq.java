import android.widget.EditText;
import com.mymoney.ui.base.SimpleTextWatcher;
import com.mymoney.ui.transfer.TransferActivity;

public class sq extends SimpleTextWatcher
{
  public sq(TransferActivity paramTransferActivity)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TransferActivity.e(this.a))
      return;
    boolean bool1 = TransferActivity.b(this.a, 0);
    EditText localEditText = TransferActivity.f(this.a);
    int i = paramInt1 + paramInt3;
    CharSequence localCharSequence = paramCharSequence.subSequence(paramInt1, i);
    localEditText.setText(localCharSequence);
    TransferActivity.f(this.a).clearFocus();
    boolean bool2 = TransferActivity.f(this.a).requestFocus();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     sq
 * JD-Core Version:    0.6.0
 */