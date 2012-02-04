import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.report.ReportTransListActivity;

class nh
  implements DialogInterface.OnClickListener
{
  nh(nf paramnf)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    m localm = ReportTransListActivity.a(this.a.c);
    long l = this.a.a;
    boolean bool = localm.a(l, 1);
    hb.b(ReportTransListActivity.a(), "删除成功.");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     nh
 * JD-Core Version:    0.6.0
 */