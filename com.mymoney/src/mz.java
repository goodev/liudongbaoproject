import android.content.DialogInterface;
import android.widget.TextView;
import com.mymoney.ui.report.ReportFilterActivity;

public class mz extends tw
{
  public mz(ReportFilterActivity paramReportFilterActivity)
  {
  }

  public void a(DialogInterface paramDialogInterface, int paramInt)
  {
    if (ReportFilterActivity.f(this.a).b())
    {
      this.a.l.setText("全部");
      return;
    }
    this.a.l.setText("已选择");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     mz
 * JD-Core Version:    0.6.0
 */