import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.Spanned;
import com.mymoney.ui.main.BackgroundService;
import com.mymoney.ui.main.MainActivity;

public class lr extends BroadcastReceiver
{
  fn a;

  public lr(MainActivity paramMainActivity)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    fn localfn = BackgroundService.g;
    this.a = localfn;
    String str1 = paramIntent.getAction();
    String str2 = MainActivity.c;
    if (!str1.equalsIgnoreCase(str2))
      return;
    gj.a(MainActivity.b, "UpgradeBroadcastReceiver#Receiver()");
    String[] arrayOfString = this.a.d().split("#");
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = arrayOfString.length;
    int j = 0;
    int k = 1;
    int m = j;
    while (m < i)
    {
      String str3 = arrayOfString[m];
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str4 = String.valueOf(k);
      String str5 = str4 + ".";
      StringBuilder localStringBuilder3 = localStringBuilder1.append(str5);
      StringBuilder localStringBuilder4 = localStringBuilder1.append(str3);
      StringBuilder localStringBuilder5 = localStringBuilder1.append("<br /><br />");
      k += 1;
      m += 1;
    }
    Context localContext = MainActivity.a;
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext);
    StringBuilder localStringBuilder6 = new StringBuilder().append("发现随手记新版:");
    String str6 = this.a.b();
    String str7 = str6;
    AlertDialog.Builder localBuilder2 = localBuilder1.setTitle(str7);
    Spanned localSpanned = Html.fromHtml(localStringBuilder1.toString());
    AlertDialog.Builder localBuilder3 = localBuilder2.setMessage(localSpanned);
    lt locallt = new lt(this);
    AlertDialog.Builder localBuilder4 = localBuilder3.setPositiveButton("下载新版", locallt);
    ls localls = new ls(this);
    localBuilder4.setNegativeButton("以后再说", localls).create().show();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     lr
 * JD-Core Version:    0.6.0
 */