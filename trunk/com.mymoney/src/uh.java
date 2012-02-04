import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

public class uh
  implements TextWatcher
{
  private TextView a;

  public uh(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() <= 10)
    {
      this.a.setTextSize(1, 28.0F);
      return;
    }
    if (paramEditable.toString().length() <= 14)
    {
      this.a.setTextSize(1, 24.0F);
      return;
    }
    if (paramEditable.toString().length() <= 20)
    {
      this.a.setTextSize(1, 20.0F);
      return;
    }
    if (paramEditable.toString().length() <= 30)
    {
      this.a.setTextSize(1, 15.0F);
      return;
    }
    if (paramEditable.toString().length() <= 40)
    {
      this.a.setTextSize(1, 10.0F);
      return;
    }
    if (paramEditable.toString().length() <= 50)
    {
      this.a.setTextSize(1, 8.0F);
      return;
    }
    this.a.setTextSize(1, 5.0F);
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     uh
 * JD-Core Version:    0.6.0
 */