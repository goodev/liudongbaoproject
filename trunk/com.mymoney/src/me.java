import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import com.mymoney.ui.helper.SeparatedListAdapterHelper;
import com.mymoney.ui.navtrans.NavTransactionActivity;
import java.util.List;

public class me extends AsyncTask
{
  List a;

  public me(NavTransactionActivity paramNavTransactionActivity)
  {
  }

  protected Void a(Void[] paramArrayOfVoid)
  {
    String str1 = NavTransactionActivity.b();
    StringBuilder localStringBuilder1 = new StringBuilder().append("search: ");
    String str2 = NavTransactionActivity.n(this.b);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append(" ");
    int i = NavTransactionActivity.q(this.b);
    String str3 = i;
    gj.a(str1, str3);
    m localm = NavTransactionActivity.a(this.b);
    String str4 = NavTransactionActivity.n(this.b);
    int j = NavTransactionActivity.q(this.b);
    List localList = localm.a(str4, j);
    this.a = localList;
    return null;
  }

  protected void a(Void paramVoid)
  {
    NavTransactionActivity localNavTransactionActivity = this.b;
    Context localContext = NavTransactionActivity.a();
    List localList = this.a;
    tz localtz1 = SeparatedListAdapterHelper.a(localContext, localList, 0);
    tz localtz2 = NavTransactionActivity.b(localNavTransactionActivity, localtz1);
    ListView localListView = NavTransactionActivity.s(this.b);
    tz localtz3 = NavTransactionActivity.r(this.b);
    localListView.setAdapter(localtz3);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     me
 * JD-Core Version:    0.6.0
 */