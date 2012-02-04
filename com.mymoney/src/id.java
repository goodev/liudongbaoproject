import android.util.Log;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.widget.wheelview.WheelView;
import java.util.List;

public class id
  implements uq
{
  public id(AddOrEditTransNewActivity paramAddOrEditTransNewActivity)
  {
  }

  public void a(WheelView paramWheelView, int paramInt1, int paramInt2)
  {
    int i = AddOrEditTransNewActivity.a(this.a, paramInt2);
    List localList1 = AddOrEditTransNewActivity.y(this.a);
    int j = AddOrEditTransNewActivity.x(this.a);
    CategoryVo localCategoryVo1 = (CategoryVo)localList1.get(j);
    List localList2 = localCategoryVo1.g();
    WheelView localWheelView1 = AddOrEditTransNewActivity.A(this.a);
    ju localju = AddOrEditTransNewActivity.z(this.a);
    localWheelView1.a(localju);
    AddOrEditTransNewActivity.z(this.a).a(localList2);
    AddOrEditTransNewActivity localAddOrEditTransNewActivity1 = this.a;
    CategoryVo localCategoryVo2 = AddOrEditTransNewActivity.B(this.a).e().e();
    int k = localList2.indexOf(localCategoryVo2);
    int m = AddOrEditTransNewActivity.b(localAddOrEditTransNewActivity1, k);
    int n = AddOrEditTransNewActivity.C(this.a);
    int i1 = localList2.size();
    if (n >= i1)
    {
      AddOrEditTransNewActivity localAddOrEditTransNewActivity2 = this.a;
      int i2 = localList2.size() - 1;
      int i3 = AddOrEditTransNewActivity.b(localAddOrEditTransNewActivity2, i2);
    }
    if (AddOrEditTransNewActivity.C(this.a) == -1)
      int i4 = AddOrEditTransNewActivity.b(this.a, 0);
    WheelView localWheelView2 = AddOrEditTransNewActivity.A(this.a);
    int i5 = AddOrEditTransNewActivity.C(this.a);
    localWheelView2.b(i5, 0);
    StringBuilder localStringBuilder1 = new StringBuilder().append("mFirstLevelCategoryWv#OnWheelChangedListener(),CurrentItem is ");
    int i6 = AddOrEditTransNewActivity.D(this.a).d();
    String str1 = i6 + ",oldValue is " + paramInt1 + ",newValue is " + paramInt2;
    int i7 = Log.i("AddOrEditTransNewActivity", str1);
    StringBuilder localStringBuilder2 = new StringBuilder().append("mFirstLevelCategoryWvSelectedIdx is ");
    int i8 = AddOrEditTransNewActivity.x(this.a);
    StringBuilder localStringBuilder3 = localStringBuilder2.append(i8).append(",name is ");
    String str2 = localCategoryVo1.b();
    String str3 = str2;
    gj.a("AddOrEditTransNewActivity", str3);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     id
 * JD-Core Version:    0.6.0
 */