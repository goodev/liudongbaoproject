import android.widget.Button;
import android.widget.TextView;
import com.mymoney.core.vo.ProjectVo;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.widget.wheelview.WheelView;
import java.util.List;

public class hv
  implements uq
{
  public hv(AddOrEditTransNewActivity paramAddOrEditTransNewActivity)
  {
  }

  public void a(WheelView paramWheelView, int paramInt1, int paramInt2)
  {
    int i = AddOrEditTransNewActivity.d(this.a, paramInt2);
    AddOrEditTransNewActivity localAddOrEditTransNewActivity = this.a;
    List localList = AddOrEditTransNewActivity.M(this.a);
    int j = AddOrEditTransNewActivity.L(this.a);
    ProjectVo localProjectVo1 = (ProjectVo)localList.get(j);
    ProjectVo localProjectVo2 = AddOrEditTransNewActivity.a(localAddOrEditTransNewActivity, localProjectVo1);
    TransactionVo localTransactionVo = AddOrEditTransNewActivity.u(this.a);
    ProjectVo localProjectVo3 = AddOrEditTransNewActivity.N(this.a);
    localTransactionVo.a(localProjectVo3);
    Button localButton = AddOrEditTransNewActivity.O(this.a);
    String str1 = AddOrEditTransNewActivity.N(this.a).b();
    localButton.setText(str1);
    TextView localTextView = AddOrEditTransNewActivity.P(this.a);
    String str2 = AddOrEditTransNewActivity.N(this.a).b();
    localTextView.setText(str2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hv
 * JD-Core Version:    0.6.0
 */