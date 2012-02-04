import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.mymoney.ui.report.ReportFilterActivity;
import java.util.List;

public class nd extends AsyncTask
{
  ProgressDialog a = null;

  public nd(ReportFilterActivity paramReportFilterActivity)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    ReportFilterActivity localReportFilterActivity1 = this.b;
    List localList1 = u.a().b();
    List localList2 = ReportFilterActivity.a(localReportFilterActivity1, localList1);
    ReportFilterActivity localReportFilterActivity2 = this.b;
    List localList3 = u.a().c();
    List localList4 = ReportFilterActivity.b(localReportFilterActivity2, localList3);
    ReportFilterActivity localReportFilterActivity3 = this.b;
    List localList5 = u.a().e();
    List localList6 = ReportFilterActivity.c(localReportFilterActivity3, localList5);
    ReportFilterActivity localReportFilterActivity4 = this.b;
    List localList7 = u.a().d();
    List localList8 = ReportFilterActivity.d(localReportFilterActivity4, localList7);
    return null;
  }

  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
  }

  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     nd
 * JD-Core Version:    0.6.0
 */