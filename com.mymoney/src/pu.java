import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.setting.SettingCorporationActivity;

class pu
  implements DialogInterface.OnClickListener
{
  pu(ps paramps)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    i locali = SettingCorporationActivity.a(this.a.b);
    long l = this.a.a;
    boolean bool = locali.a(l);
    hb.b(SettingCorporationActivity.a(), "删除成功.");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     pu
 * JD-Core Version:    0.6.0
 */