import android.widget.Button;
import com.mymoney.core.vo.CorporationVo;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.widget.wheelview.WheelView;
import java.util.List;

public class hw
  implements uq
{
  public hw(AddOrEditTransNewActivity paramAddOrEditTransNewActivity)
  {
  }

  public void a(WheelView paramWheelView, int paramInt1, int paramInt2)
  {
    int i = AddOrEditTransNewActivity.e(this.a, paramInt2);
    AddOrEditTransNewActivity localAddOrEditTransNewActivity = this.a;
    List localList = AddOrEditTransNewActivity.R(this.a);
    int j = AddOrEditTransNewActivity.Q(this.a);
    CorporationVo localCorporationVo1 = (CorporationVo)localList.get(j);
    CorporationVo localCorporationVo2 = AddOrEditTransNewActivity.a(localAddOrEditTransNewActivity, localCorporationVo1);
    TransactionVo localTransactionVo = AddOrEditTransNewActivity.u(this.a);
    CorporationVo localCorporationVo3 = AddOrEditTransNewActivity.S(this.a);
    localTransactionVo.a(localCorporationVo3);
    Button localButton = AddOrEditTransNewActivity.T(this.a);
    String str1 = AddOrEditTransNewActivity.S(this.a).b();
    localButton.setText(str1);
    StringBuilder localStringBuilder1 = new StringBuilder().append("mCorporationWvSelectedIdx is ");
    int k = AddOrEditTransNewActivity.Q(this.a);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(k).append(",corp name is ");
    String str2 = AddOrEditTransNewActivity.S(this.a).b();
    String str3 = str2;
    gj.a("AddOrEditTransNewActivity", str3);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hw
 * JD-Core Version:    0.6.0
 */