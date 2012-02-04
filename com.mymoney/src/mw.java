import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import android.widget.TextView;
import com.mymoney.ui.report.ReportFilterActivity;

public class mw
  implements DatePickerDialog.OnDateSetListener
{
  public mw(ReportFilterActivity paramReportFilterActivity)
  {
  }

  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = gi.b(paramInt1, paramInt2, paramInt3);
    long l2 = ReportFilterActivity.a(this.a);
    if (l1 < l2)
    {
      long l3 = ReportFilterActivity.a(this.a, l1);
      TextView localTextView = this.a.j;
      String str = gi.f(ReportFilterActivity.b(this.a));
      localTextView.setText(str);
      return;
    }
    hb.b(ReportFilterActivity.a(), "起始日期必须小于结束日期");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     mw
 * JD-Core Version:    0.6.0
 */