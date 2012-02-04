import android.widget.TextView;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.widget.wheelview.WheelDatePicker;

public class hu
  implements uz
{
  public hu(AddOrEditTransNewActivity paramAddOrEditTransNewActivity)
  {
  }

  public void a(WheelDatePicker paramWheelDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramInt1).append("年 ");
    int i = paramInt2 + 1;
    String str1 = i + "月  " + paramInt3 + "日";
    gj.a("AddOrEditTransNewActivity", str1);
    AddOrEditTransNewActivity localAddOrEditTransNewActivity = this.a;
    long l1 = gi.a(paramInt1, paramInt2, paramInt3);
    long l2 = AddOrEditTransNewActivity.a(localAddOrEditTransNewActivity, l1);
    TransactionVo localTransactionVo = AddOrEditTransNewActivity.u(this.a);
    long l3 = AddOrEditTransNewActivity.J(this.a);
    localTransactionVo.b(l3);
    TextView localTextView = AddOrEditTransNewActivity.K(this.a);
    String str2 = gi.f(AddOrEditTransNewActivity.J(this.a));
    localTextView.setText(str2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hu
 * JD-Core Version:    0.6.0
 */