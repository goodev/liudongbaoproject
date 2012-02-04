import android.os.Handler;
import com.mymoney.ui.setting.SettingAccountActivity;

public class og extends dx
{
  public String b;

  public og(SettingAccountActivity paramSettingAccountActivity, Handler paramHandler)
  {
    super(paramHandler);
    String str = og.class.getSimpleName();
    this.b = str;
  }

  public void a()
  {
    gj.a(this.b, "SettingAccountActivityEventObserver#onChange()");
    SettingAccountActivity.k(this.c);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     og
 * JD-Core Version:    0.6.0
 */