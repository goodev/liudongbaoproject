import android.app.TimePickerDialog.OnTimeSetListener;
import android.widget.TimePicker;
import com.mymoney.ui.setting.SettingBackUpActivity;

public class pp
  implements TimePickerDialog.OnTimeSetListener
{
  private pp(SettingBackUpActivity paramSettingBackUpActivity)
  {
  }

  public void onTimeSet(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    String str1 = SettingBackUpActivity.f(this.a);
    String str2 = "autoBackupTime " + paramInt1 + ":" + paramInt2;
    gj.a(str1, str2);
    SettingBackUpActivity localSettingBackUpActivity = this.a;
    String str3 = paramInt1 + ":" + paramInt2;
    String str4 = SettingBackUpActivity.d(localSettingBackUpActivity, str3);
    gu.f(SettingBackUpActivity.g(this.a));
    SettingBackUpActivity.h(this.a);
    hb.b(SettingBackUpActivity.d(this.a), "设置自动备份时间成功");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     pp
 * JD-Core Version:    0.6.0
 */