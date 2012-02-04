import android.content.DialogInterface;
import android.widget.TextView;
import com.mymoney.ui.report.ReportFilterActivity;

public class my extends ue
{
  public my(ReportFilterActivity paramReportFilterActivity)
  {
  }

  public void a(DialogInterface paramDialogInterface, int paramInt, ty paramty)
  {
    hm localhm = ReportFilterActivity.d(this.a);
    int i = Integer.parseInt(String.valueOf(ReportFilterActivity.c(this.a).a()));
    localhm.e(i);
    ReportFilterActivity localReportFilterActivity = this.a;
    int j = Integer.parseInt(String.valueOf(ReportFilterActivity.c(this.a).a()));
    int k = ReportFilterActivity.a(localReportFilterActivity, j);
    ReportFilterActivity.e(this.a);
    TextView localTextView = this.a.i;
    String str = paramty.toString();
    localTextView.setText(str);
    paramDialogInterface.dismiss();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     my
 * JD-Core Version:    0.6.0
 */