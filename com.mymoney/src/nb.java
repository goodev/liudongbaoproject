import android.content.DialogInterface;
import android.widget.TextView;
import com.mymoney.ui.report.ReportFilterActivity;

public class nb extends tw
{
  public nb(ReportFilterActivity paramReportFilterActivity)
  {
  }

  public void a(DialogInterface paramDialogInterface, int paramInt)
  {
    if (ReportFilterActivity.h(this.a).b())
    {
      this.a.o.setText("全部");
      return;
    }
    this.a.o.setText("已选择");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     nb
 * JD-Core Version:    0.6.0
 */