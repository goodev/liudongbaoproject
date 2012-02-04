import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.setting.SettingAccountActivity;

class oc
  implements DialogInterface.OnClickListener
{
  oc(oa paramoa)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    e locale = SettingAccountActivity.a(this.a.e);
    long l = this.a.a;
    boolean bool = locale.c(l);
    hb.b(SettingAccountActivity.a(), "删除成功.");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     oc
 * JD-Core Version:    0.6.0
 */