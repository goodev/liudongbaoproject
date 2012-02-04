import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.mymoney.ui.setting.SettingSecurityActivity;

public class qv
  implements DialogInterface.OnClickListener
{
  public qv(SettingSecurityActivity paramSettingSecurityActivity, EditText paramEditText)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str1 = this.a.getText().toString();
    if (TextUtils.isEmpty(str1))
    {
      hb.b(SettingSecurityActivity.a(), "密码不能为空.");
      this.b.showDialog(1);
      return;
    }
    String str2 = gu.f();
    if (str1.equalsIgnoreCase(str2))
    {
      this.b.showDialog(0);
      return;
    }
    hb.b(SettingSecurityActivity.a(), "密码错误.");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qv
 * JD-Core Version:    0.6.0
 */