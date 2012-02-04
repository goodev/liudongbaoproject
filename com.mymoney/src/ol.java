import android.content.Context;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.mymoney.ui.helper.SeparatedListAdapterHelper;
import com.mymoney.ui.setting.SettingAccountTransactionListActivity;
import java.util.List;

public class ol extends AsyncTask
{
  public ol(SettingAccountTransactionListActivity paramSettingAccountTransactionListActivity)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    SettingAccountTransactionListActivity localSettingAccountTransactionListActivity = this.a;
    m localm = SettingAccountTransactionListActivity.a(this.a);
    long l = SettingAccountTransactionListActivity.b(this.a);
    List localList1 = localm.b(l);
    List localList2 = SettingAccountTransactionListActivity.a(localSettingAccountTransactionListActivity, localList1);
    return null;
  }

  protected void onPostExecute(Object paramObject)
  {
    SettingAccountTransactionListActivity localSettingAccountTransactionListActivity = this.a;
    Context localContext = SettingAccountTransactionListActivity.a();
    List localList = SettingAccountTransactionListActivity.c(this.a);
    tz localtz1 = SeparatedListAdapterHelper.a(localContext, localList, 1);
    tz localtz2 = SettingAccountTransactionListActivity.a(localSettingAccountTransactionListActivity, localtz1);
    ListView localListView = SettingAccountTransactionListActivity.e(this.a);
    tz localtz3 = SettingAccountTransactionListActivity.d(this.a);
    localListView.setAdapter(localtz3);
    if (SettingAccountTransactionListActivity.c(this.a).isEmpty())
      SettingAccountTransactionListActivity.f(this.a).setVisibility(0);
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ol
 * JD-Core Version:    0.6.0
 */