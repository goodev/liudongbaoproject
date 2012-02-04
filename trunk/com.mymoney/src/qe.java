import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;
import com.mymoney.ui.setting.DefaultCurrencyCodeListViewAdapter;
import com.mymoney.ui.setting.SettingCurrencySelectActivity;
import java.util.List;

public class qe extends AsyncTask
{
  List a;

  public qe(SettingCurrencySelectActivity paramSettingCurrencySelectActivity)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    List localList = SettingCurrencySelectActivity.a(this.b).a();
    this.a = localList;
    return null;
  }

  protected void onPostExecute(Object paramObject)
  {
    if (SettingCurrencySelectActivity.b(this.b).getVisibility() == 0)
      SettingCurrencySelectActivity.b(this.b).setVisibility(8);
    DefaultCurrencyCodeListViewAdapter localDefaultCurrencyCodeListViewAdapter = SettingCurrencySelectActivity.c(this.b);
    List localList1 = this.a;
    localDefaultCurrencyCodeListViewAdapter.a(localList1);
    ListView localListView = SettingCurrencySelectActivity.e(this.b);
    List localList2 = this.a;
    hk localhk = SettingCurrencySelectActivity.d(this.b);
    int i = localList2.indexOf(localhk);
    localListView.setItemChecked(i, 1);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     qe
 * JD-Core Version:    0.6.0
 */