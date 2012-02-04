import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;
import com.mymoney.ui.report.ReportActivity;
import com.mymoney.ui.report.ReportLvAdapter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.chart.AnimationPieChartForMymoney;

public class ms extends AsyncTask
{
  public ms(ReportActivity paramReportActivity)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    ReportActivity localReportActivity1 = this.a;
    u localu1 = u.a();
    hm localhm1 = hm.a();
    List localList1 = localu1.a(localhm1);
    List localList2 = ReportActivity.a(localReportActivity1, localList1);
    if (ReportActivity.e(this.a) == null)
    {
      ReportActivity localReportActivity2 = this.a;
      ArrayList localArrayList = new ArrayList();
      List localList3 = ReportActivity.a(localReportActivity2, localArrayList);
    }
    hm localhm2 = hm.a();
    if (localhm2.d() == 8)
    {
      ReportActivity localReportActivity3 = this.a;
      u localu2 = u.a();
      String str1 = hm.a().f();
      BigDecimal localBigDecimal1 = localu2.a(str1);
      BigDecimal localBigDecimal2 = ReportActivity.a(localReportActivity3, localBigDecimal1);
    }
    while (true)
    {
      return null;
      if (localhm2.d() == 9)
      {
        ReportActivity localReportActivity4 = this.a;
        u localu3 = u.a();
        String str2 = hm.a().f();
        BigDecimal localBigDecimal3 = localu3.c(str2);
        BigDecimal localBigDecimal4 = ReportActivity.a(localReportActivity4, localBigDecimal3);
        continue;
      }
      BigDecimal localBigDecimal5 = ReportActivity.a(this.a, null);
    }
  }

  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    if (ReportActivity.f(this.a).getVisibility() == 0)
      ReportActivity.f(this.a).setVisibility(8);
    AnimationPieChartForMymoney localAnimationPieChartForMymoney = ReportActivity.h(this.a);
    ReportActivity localReportActivity = this.a;
    List localList1 = ReportActivity.e(this.a);
    vv localvv = ReportActivity.b(localReportActivity, localList1);
    BigDecimal localBigDecimal = ReportActivity.g(this.a);
    localAnimationPieChartForMymoney.a(localvv, localBigDecimal);
    ReportActivity.i(this.a);
    ReportLvAdapter localReportLvAdapter = ReportActivity.j(this.a);
    List localList2 = ReportActivity.e(this.a);
    localReportLvAdapter.a(localList2);
    if (!ReportActivity.e(this.a).isEmpty())
      return;
    ReportActivity.k(this.a).setEnabled(0);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ms
 * JD-Core Version:    0.6.0
 */