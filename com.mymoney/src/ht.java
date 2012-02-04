import android.widget.TextView;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.widget.wheelview.WheelView;
import java.util.List;

public class ht
  implements uq
{
  public ht(AddOrEditTransNewActivity paramAddOrEditTransNewActivity)
  {
  }

  public void a(WheelView paramWheelView, int paramInt1, int paramInt2)
  {
    int i = AddOrEditTransNewActivity.c(this.a, paramInt2);
    AddOrEditTransNewActivity localAddOrEditTransNewActivity = this.a;
    List localList = AddOrEditTransNewActivity.G(this.a);
    int j = AddOrEditTransNewActivity.F(this.a);
    AccountVo localAccountVo1 = (AccountVo)localList.get(j);
    AccountVo localAccountVo2 = AddOrEditTransNewActivity.a(localAddOrEditTransNewActivity, localAccountVo1);
    TransactionVo localTransactionVo = AddOrEditTransNewActivity.u(this.a);
    AccountVo localAccountVo3 = AddOrEditTransNewActivity.H(this.a);
    localTransactionVo.a(localAccountVo3);
    TextView localTextView = AddOrEditTransNewActivity.I(this.a);
    String str1 = AddOrEditTransNewActivity.H(this.a).i();
    localTextView.setText(str1);
    StringBuilder localStringBuilder1 = new StringBuilder().append("mAccountWvSelectedIdx is ");
    int k = AddOrEditTransNewActivity.F(this.a);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(k).append(",account name is ");
    String str2 = AddOrEditTransNewActivity.H(this.a).b();
    String str3 = str2;
    gj.a("AddOrEditTransNewActivity", str3);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ht
 * JD-Core Version:    0.6.0
 */