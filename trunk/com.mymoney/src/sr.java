import android.widget.EditText;
import com.mymoney.ui.base.SimpleTextWatcher;
import com.mymoney.ui.transfer.TransferActivity;

public class sr extends SimpleTextWatcher
{
  public sr(TransferActivity paramTransferActivity)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TransferActivity.g(this.a))
      return;
    boolean bool1 = TransferActivity.c(this.a, 0);
    EditText localEditText = TransferActivity.h(this.a);
    int i = paramInt1 + paramInt3;
    CharSequence localCharSequence = paramCharSequence.subSequence(paramInt1, i);
    localEditText.setText(localCharSequence);
    TransferActivity.h(this.a).clearFocus();
    boolean bool2 = TransferActivity.h(this.a).requestFocus();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     sr
 * JD-Core Version:    0.6.0
 */