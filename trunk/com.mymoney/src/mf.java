import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.mymoney.ui.helper.SeparatedListAdapterHelper;
import com.mymoney.ui.navtrans.NavTransactionActivity;
import java.util.List;

public class mf extends AsyncTask
{
  List a;
  double b;
  double c;

  public mf(NavTransactionActivity paramNavTransactionActivity)
  {
  }

  protected Integer a(Void[] paramArrayOfVoid)
  {
    m localm1 = NavTransactionActivity.a(this.d);
    long l1 = NavTransactionActivity.c(this.d);
    long l2 = NavTransactionActivity.d(this.d);
    List localList = localm1.a(l1, l2);
    this.a = localList;
    m localm2 = NavTransactionActivity.a(this.d);
    long l3 = NavTransactionActivity.c(this.d);
    long l4 = NavTransactionActivity.d(this.d);
    double d1 = localm2.c(l3, l4);
    this.b = d1;
    m localm3 = NavTransactionActivity.a(this.d);
    long l5 = NavTransactionActivity.c(this.d);
    long l6 = NavTransactionActivity.d(this.d);
    double d2 = localm3.b(l5, l6);
    this.c = d2;
    return null;
  }

  protected void a(Integer paramInteger)
  {
    if (NavTransactionActivity.e(this.d).getVisibility() == 0)
      NavTransactionActivity.e(this.d).setVisibility(8);
    NavTransactionActivity.f(this.d).setVisibility(8);
    NavTransactionActivity localNavTransactionActivity = this.d;
    Context localContext = NavTransactionActivity.a();
    List localList = this.a;
    tz localtz1 = SeparatedListAdapterHelper.a(localContext, localList, 0);
    tz localtz2 = NavTransactionActivity.a(localNavTransactionActivity, localtz1);
    ListView localListView = NavTransactionActivity.h(this.d);
    tz localtz3 = NavTransactionActivity.g(this.d);
    localListView.setAdapter(localtz3);
    if (this.a.size() == 0)
      NavTransactionActivity.f(this.d).setVisibility(0);
    TextView localTextView1 = NavTransactionActivity.i(this.d);
    String str1 = gs.a(this.b, null);
    localTextView1.setText(str1);
    TextView localTextView2 = NavTransactionActivity.j(this.d);
    String str2 = gs.a(this.c, null);
    localTextView2.setText(str2);
    double d1 = this.b;
    double d2 = this.c;
    double d3 = d1 - d2;
    TextView localTextView3 = NavTransactionActivity.k(this.d);
    String str3 = gs.a(d3, null);
    localTextView3.setText(str3);
    super.onPostExecute(paramInteger);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     mf
 * JD-Core Version:    0.6.0
 */