import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.setting.SettingSubcategoryActivity;

class ra
  implements DialogInterface.OnClickListener
{
  ra(qy paramqy)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h localh = SettingSubcategoryActivity.a(this.a.b);
    long l = this.a.a;
    boolean bool = localh.a(l);
    hb.b(SettingSubcategoryActivity.a(), "删除成功.");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ra
 * JD-Core Version:    0.6.0
 */