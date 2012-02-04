import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.ui.helper.SeparatedListAdapterHelper;
import com.mymoney.ui.setting.SettingAccountActivity;
import com.mymoney.ui.widget.DragListView;
import java.util.List;

public class of extends AsyncTask
{
  List a;

  public of(SettingAccountActivity paramSettingAccountActivity)
  {
  }

  protected Integer a(Integer[] paramArrayOfInteger)
  {
    e locale = SettingAccountActivity.a(this.b);
    boolean bool = SettingAccountActivity.c(this.b);
    List localList = locale.a(bool);
    this.a = localList;
    return new Integer(1);
  }

  protected void a(Integer paramInteger)
  {
    if (SettingAccountActivity.d(this.b).getVisibility() == 0)
      SettingAccountActivity.d(this.b).setVisibility(8);
    SettingAccountActivity localSettingAccountActivity = this.b;
    Context localContext = SettingAccountActivity.a();
    List localList1 = this.a;
    List localList2 = SettingAccountActivity.e(this.b);
    tz localtz1 = SeparatedListAdapterHelper.a(localContext, localList1, localList2);
    tz localtz2 = SettingAccountActivity.a(localSettingAccountActivity, localtz1);
    DragListView localDragListView1 = SettingAccountActivity.g(this.b);
    tz localtz3 = SettingAccountActivity.f(this.b);
    localDragListView1.setAdapter(localtz3);
    AccountVo localAccountVo = SettingAccountActivity.b(this.b).e();
    DragListView localDragListView2 = SettingAccountActivity.g(this.b);
    int i = SettingAccountActivity.e(this.b).indexOf(localAccountVo);
    localDragListView2.setItemChecked(i, 1);
    double d1 = SettingAccountActivity.a(this.b).a();
    double d2 = SettingAccountActivity.a(this.b).b();
    TextView localTextView1 = SettingAccountActivity.h(this.b);
    String str1 = gs.a(d1, null);
    localTextView1.setText(str1);
    TextView localTextView2 = SettingAccountActivity.i(this.b);
    String str2 = gs.a(d2, null);
    localTextView2.setText(str2);
    TextView localTextView3 = SettingAccountActivity.j(this.b);
    String str3 = gs.a(d1 - d2, null);
    localTextView3.setText(str3);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     of
 * JD-Core Version:    0.6.0
 */