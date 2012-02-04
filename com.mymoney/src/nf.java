import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.report.ReportTransListActivity;

public class nf
  implements DialogInterface.OnClickListener
{
  public nf(ReportTransListActivity paramReportTransListActivity, long paramLong, int paramInt)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      ReportTransListActivity localReportTransListActivity = this.c;
      long l = this.a;
      int i = this.b;
      ReportTransListActivity.a(localReportTransListActivity, l, i);
      return;
    }
    if (paramInt != 1)
      return;
    Context localContext = ReportTransListActivity.a();
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle(2131492899).setMessage(2131492900);
    nh localnh = new nh(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton(2131492901, localnh);
    ng localng = new ng(this);
    localBuilder2.setNegativeButton(2131492902, localng).create().show();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     nf
 * JD-Core Version:    0.6.0
 */