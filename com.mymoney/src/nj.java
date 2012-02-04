import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.mymoney.ui.helper.SeparatedListAdapterHelper;
import com.mymoney.ui.report.ReportTransListActivity;
import java.util.List;

public class nj extends AsyncTask
{
  List a;

  public nj(ReportTransListActivity paramReportTransListActivity)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    int i = hm.a().d();
    if ((hm.a(i)) || (i == 11))
    {
      u localu1 = u.a();
      hm localhm1 = hm.a();
      List localList1 = localu1.m(localhm1);
      this.a = localList1;
    }
    while (true)
    {
      return null;
      if ((hm.b(i)) || (i == 10))
      {
        u localu2 = u.a();
        hm localhm2 = hm.a();
        List localList2 = localu2.n(localhm2);
        this.a = localList2;
        continue;
      }
      u localu3 = u.a();
      hm localhm3 = hm.a();
      List localList3 = localu3.o(localhm3);
      this.a = localList3;
    }
  }

  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    if (ReportTransListActivity.b(this.b).getVisibility() == 0)
      ReportTransListActivity.b(this.b).setVisibility(8);
    ReportTransListActivity localReportTransListActivity = this.b;
    Context localContext = ReportTransListActivity.a();
    List localList = this.a;
    tz localtz1 = SeparatedListAdapterHelper.a(localContext, localList, 0);
    tz localtz2 = ReportTransListActivity.a(localReportTransListActivity, localtz1);
    ListView localListView1 = ReportTransListActivity.d(this.b);
    tz localtz3 = ReportTransListActivity.c(this.b);
    localListView1.setAdapter(localtz3);
    if (this.a.size() != 0)
      return;
    ListView localListView2 = ReportTransListActivity.d(this.b);
    View localView = ReportTransListActivity.e(this.b);
    localListView2.setEmptyView(localView);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     nj
 * JD-Core Version:    0.6.0
 */