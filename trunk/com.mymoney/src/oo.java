import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.mymoney.ui.setting.SettingActivity;

public class oo
  implements DialogInterface.OnClickListener
{
  public oo(SettingActivity paramSettingActivity, EditText paramEditText)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str1 = this.a.getText().toString();
    if (TextUtils.isEmpty(str1))
    {
      hb.b(SettingActivity.a(), "密码不能为空.");
      this.b.showDialog(0);
      return;
    }
    String str2 = gu.f();
    if (str1.equalsIgnoreCase(str2))
    {
      SettingActivity.a(this.b);
      this.a.setText("");
      return;
    }
    hb.b(SettingActivity.a(), "密码错误.");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     oo
 * JD-Core Version:    0.6.0
 */