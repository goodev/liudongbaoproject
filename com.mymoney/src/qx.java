import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import com.mymoney.ui.setting.SettingSecurityActivity;

public class qx
  implements DialogInterface.OnClickListener
{
  public qx(SettingSecurityActivity paramSettingSecurityActivity, EditText paramEditText1, EditText paramEditText2)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str1 = this.a.getText().toString();
    String str2 = this.b.getText().toString();
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      hb.b(SettingSecurityActivity.a(), "密码不能为空.");
      SettingSecurityActivity.a(this.c).setChecked(0);
      this.c.showDialog(0);
      return;
    }
    if (str1.equalsIgnoreCase(str2))
    {
      if (TextUtils.isEmpty(gu.f()))
        SettingSecurityActivity.a(this.c).setChecked(1);
      SettingSecurityActivity.a(this.c).setChecked(1);
      gu.a(1);
      gu.e(str1);
      this.a.setText("");
      this.b.setText("");
      hb.b(SettingSecurityActivity.a(), "新密码设置成功.");
      SettingSecurityActivity.b(this.c).setChecked(1);
      gu.c(1);
      return;
    }
    if (TextUtils.isEmpty(gu.f()))
      SettingSecurityActivity.a(this.c).setChecked(0);
    hb.b(SettingSecurityActivity.a(), "对不起,密码输入不一致.");
    this.a.setText("");
    this.b.setText("");
    this.c.showDialog(0);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qx
 * JD-Core Version:    0.6.0
 */