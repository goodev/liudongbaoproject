import android.util.Log;
import android.widget.TextView;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.widget.wheelview.WheelView;
import java.util.List;

public class ie
  implements uq
{
  public ie(AddOrEditTransNewActivity paramAddOrEditTransNewActivity)
  {
  }

  public void a(WheelView paramWheelView, int paramInt1, int paramInt2)
  {
    int i = AddOrEditTransNewActivity.b(this.a, paramInt2);
    List localList1 = AddOrEditTransNewActivity.y(this.a);
    int j = AddOrEditTransNewActivity.x(this.a);
    CategoryVo localCategoryVo1 = (CategoryVo)localList1.get(j);
    List localList2 = AddOrEditTransNewActivity.y(this.a);
    int k = AddOrEditTransNewActivity.x(this.a);
    List localList3 = ((CategoryVo)localList2.get(k)).g();
    AddOrEditTransNewActivity.B(this.a).e(localCategoryVo1);
    int m = AddOrEditTransNewActivity.C(this.a);
    CategoryVo localCategoryVo2 = (CategoryVo)localList3.get(m);
    localCategoryVo1.e(localCategoryVo2);
    TextView localTextView1 = AddOrEditTransNewActivity.E(this.a);
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = AddOrEditTransNewActivity.B(this.a).e().b();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(">");
    String str2 = AddOrEditTransNewActivity.B(this.a).e().e().b();
    String str3 = str2;
    localTextView1.setText(str3);
    TextView localTextView2 = AddOrEditTransNewActivity.E(this.a);
    StringBuilder localStringBuilder3 = new StringBuilder();
    String str4 = AddOrEditTransNewActivity.B(this.a).e().b();
    StringBuilder localStringBuilder4 = localStringBuilder3.append(str4).append(">");
    String str5 = AddOrEditTransNewActivity.B(this.a).e().e().b();
    String str6 = str5;
    localTextView2.setText(str6);
    StringBuilder localStringBuilder5 = new StringBuilder().append("mSecondLevelCategoryWv#OnWheelChangedListener(),CurrentItem is ");
    int n = AddOrEditTransNewActivity.A(this.a).d();
    String str7 = n + ",oldValue is " + paramInt1 + ",newValue is " + paramInt2;
    int i1 = Log.i("AddOrEditTransNewActivity", str7);
    StringBuilder localStringBuilder6 = new StringBuilder().append("mSecondLevelCategoryWvSelectedIdx is ");
    int i2 = AddOrEditTransNewActivity.C(this.a);
    StringBuilder localStringBuilder7 = localStringBuilder6.append(i2).append(",second  name is ");
    String str8 = AddOrEditTransNewActivity.B(this.a).e().e().b();
    String str9 = str8;
    gj.a("AddOrEditTransNewActivity", str9);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ie
 * JD-Core Version:    0.6.0
 */