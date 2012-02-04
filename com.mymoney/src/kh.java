import android.os.AsyncTask;
import com.mymoney.ui.budget.BudgetActivity;

public class kh extends AsyncTask
{
  kh(BudgetActivity paramBudgetActivity)
  {
  }

  protected Boolean a(Double[] paramArrayOfDouble)
  {
    BudgetActivity localBudgetActivity = this.a;
    double d = paramArrayOfDouble[0].doubleValue();
    BudgetActivity.c(localBudgetActivity, d);
    return null;
  }

  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
    hb.b(BudgetActivity.d(this.a), "分类预算设置成功.");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     kh
 * JD-Core Version:    0.6.0
 */