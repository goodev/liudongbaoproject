import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;
import com.mymoney.ui.budget.BudgetActivity;
import com.mymoney.ui.budget.BudgetItemAdapter;
import java.util.List;

public class kc extends AsyncTask
{
  List a;

  public kc(BudgetActivity paramBudgetActivity)
  {
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    BudgetActivity localBudgetActivity1 = this.b;
    double d1 = BudgetActivity.e(this.b).b();
    double d2 = BudgetActivity.a(localBudgetActivity1, d1);
    BudgetActivity localBudgetActivity2 = this.b;
    double d3 = BudgetActivity.e(this.b).c();
    double d4 = BudgetActivity.b(localBudgetActivity2, d3);
    List localList = BudgetActivity.e(this.b).a();
    this.a = localList;
    return null;
  }

  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    if (BudgetActivity.h(this.b).getVisibility() == 0)
      BudgetActivity.h(this.b).setVisibility(8);
    Button localButton = BudgetActivity.j(this.b);
    String str = gs.a(BudgetActivity.i(this.b), null);
    localButton.setText(str);
    BudgetItemAdapter localBudgetItemAdapter = BudgetActivity.k(this.b);
    List localList = this.a;
    localBudgetItemAdapter.a(localList);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     kc
 * JD-Core Version:    0.6.0
 */