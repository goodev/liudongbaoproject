import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.mymoney.ui.setting.SettingAddOrEditAccountActivity;

class ph
  implements TextWatcher
{
  ph(pg parampg)
  {
  }

  public void afterTextChanged(Editable paramEditable)
  {
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!SettingAddOrEditAccountActivity.t(this.a.a))
      return;
    boolean bool1 = SettingAddOrEditAccountActivity.a(this.a.a, 0);
    if (paramCharSequence.length() - 1 > 0)
    {
      EditText localEditText = SettingAddOrEditAccountActivity.j(this.a.a);
      int i = paramCharSequence.length() - 1;
      int j = paramCharSequence.length();
      CharSequence localCharSequence = paramCharSequence.subSequence(i, j);
      localEditText.setText(localCharSequence);
    }
    SettingAddOrEditAccountActivity.j(this.a.a).clearFocus();
    boolean bool2 = SettingAddOrEditAccountActivity.j(this.a.a).requestFocus();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ph
 * JD-Core Version:    0.6.0
 */