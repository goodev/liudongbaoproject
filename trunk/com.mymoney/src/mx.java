import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import android.widget.TextView;
import com.mymoney.ui.report.ReportFilterActivity;

public class mx
  implements DatePickerDialog.OnDateSetListener
{
  public mx(ReportFilterActivity paramReportFilterActivity)
  {
  }

  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    long l1 = gi.c(paramInt1, paramInt2, paramInt3);
    long l2 = ReportFilterActivity.b(this.a);
    if (l1 > l2)
    {
      long l3 = ReportFilterActivity.b(this.a, l1);
      TextView localTextView = this.a.k;
      String str = gi.f(ReportFilterActivity.a(this.a));
      localTextView.setText(str);
      return;
    }
    hb.b(ReportFilterActivity.a(), "结束日期必须大于开始日期");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     mx
 * JD-Core Version:    0.6.0
 */