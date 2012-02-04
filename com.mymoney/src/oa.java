import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.mymoney.ui.setting.SettingAccountActivity;
import com.mymoney.ui.setting.SettingAddOrEditAccountActivity;

public class oa
  implements DialogInterface.OnClickListener
{
  public oa(SettingAccountActivity paramSettingAccountActivity, long paramLong, int paramInt, boolean paramBoolean, String paramString)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      Context localContext1 = SettingAccountActivity.a();
      Intent localIntent1 = new Intent(localContext1, SettingAddOrEditAccountActivity.class);
      Intent localIntent2 = localIntent1.putExtra("mode", 0);
      long l1 = this.a;
      Intent localIntent3 = localIntent1.putExtra("id", l1);
      int i = this.b;
      Intent localIntent4 = localIntent1.putExtra("accountType", i);
      this.e.startActivity(localIntent1);
      return;
    }
    if (paramInt == 1)
    {
      e locale1 = SettingAccountActivity.a(this.e);
      long l2 = this.a;
      if (locale1.a(l2))
      {
        Context localContext2 = SettingAccountActivity.a();
        AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext2).setTitle(2131492899).setMessage(2131492900);
        oc localoc = new oc(this);
        AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton(2131492901, localoc);
        ob localob = new ob(this);
        localBuilder2.setNegativeButton(2131492902, localob).create().show();
        return;
      }
      String str1 = SettingAccountActivity.a().getResources().getString(2131492903);
      hb.b(SettingAccountActivity.a(), str1);
      return;
    }
    if (paramInt == 2)
    {
      if (this.c)
      {
        e locale2 = SettingAccountActivity.a(this.e);
        long l3 = this.a;
        boolean bool1 = locale2.a(0, l3);
        Context localContext3 = SettingAccountActivity.a();
        StringBuilder localStringBuilder1 = new StringBuilder().append("成功设置  '");
        String str2 = this.d;
        String str3 = str2 + "' 状态为显示";
        hb.b(localContext3, str3);
        return;
      }
      e locale3 = SettingAccountActivity.a(this.e);
      long l4 = this.a;
      boolean bool2 = locale3.a(1, l4);
      Context localContext4 = SettingAccountActivity.a();
      StringBuilder localStringBuilder2 = new StringBuilder().append("成功设置  '");
      String str4 = this.d;
      String str5 = str4 + "' 状态为隐藏";
      hb.b(localContext4, str5);
      return;
    }
    if (paramInt != 3)
      return;
    k localk = SettingAccountActivity.b(this.e);
    long l5 = this.a;
    boolean bool3 = localk.a(l5);
    Context localContext5 = SettingAccountActivity.a();
    StringBuilder localStringBuilder3 = new StringBuilder().append("成功设置  '");
    String str6 = this.d;
    String str7 = str6 + "' 为默认账户";
    hb.b(localContext5, str7);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     oa
 * JD-Core Version:    0.6.0
 */