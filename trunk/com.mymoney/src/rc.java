import com.mymoney.ui.setting.SettingSubcategoryActivity;
import java.util.Map;

class rc
  implements Runnable
{
  rc(rb paramrb)
  {
  }

  public void run()
  {
    h localh = SettingSubcategoryActivity.a(this.a.a);
    Map localMap = SettingSubcategoryActivity.i(this.a.a);
    localh.a(localMap);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     rc
 * JD-Core Version:    0.6.0
 */