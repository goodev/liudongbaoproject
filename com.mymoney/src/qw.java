import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import com.mymoney.ui.setting.SettingSecurityActivity;

public class qw
  implements DialogInterface.OnClickListener
{
  public qw(SettingSecurityActivity paramSettingSecurityActivity, EditText paramEditText1, EditText paramEditText2)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.setText("");
    this.b.setText("");
    if (!TextUtils.isEmpty(gu.f()))
      return;
    SettingSecurityActivity.a(this.c).setChecked(0);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qw
 * JD-Core Version:    0.6.0
 */