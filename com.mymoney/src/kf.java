import android.os.AsyncTask;
import com.mymoney.ui.budget.BudgetActivity;
import com.mymoney.ui.widget.DigitKeypad.OnFinishListener;

public class kf
  implements DigitKeypad.OnFinishListener
{
  public kf(BudgetActivity paramBudgetActivity)
  {
  }

  public void a(double paramDouble)
  {
    BudgetActivity.a(this.a);
    if (BudgetActivity.b(this.a))
    {
      boolean bool1 = BudgetActivity.a(this.a, 0);
      double d = BudgetActivity.c(this.a);
      if (paramDouble < d)
      {
        hb.b(BudgetActivity.d(this.a), "总预算值不能小于一级分类预算值之和.");
        return;
      }
      boolean bool2 = BudgetActivity.e(this.a).a(paramDouble);
      hb.b(BudgetActivity.d(this.a), "总预算设置成功");
      return;
    }
    BudgetActivity localBudgetActivity = this.a;
    kh localkh = new kh(localBudgetActivity);
    Double[] arrayOfDouble = new Double[1];
    Double localDouble = Double.valueOf(paramDouble);
    arrayOfDouble[0] = localDouble;
    AsyncTask localAsyncTask = localkh.execute(arrayOfDouble);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     kf
 * JD-Core Version:    0.6.0
 */