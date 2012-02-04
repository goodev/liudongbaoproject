import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.setting.SettingFirstLevelCategoryActivity;

class qi
  implements DialogInterface.OnClickListener
{
  qi(qg paramqg)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h localh = SettingFirstLevelCategoryActivity.a(this.a.b);
    long l = this.a.a;
    boolean bool = localh.a(l);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qi
 * JD-Core Version:    0.6.0
 */