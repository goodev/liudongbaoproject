import android.os.AsyncTask;
import android.widget.Spinner;
import android.widget.TextView;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.ProjectVo;
import com.mymoney.ui.transfer.TransferActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class sv extends AsyncTask
{
  private List b;
  private List c;
  private List d;

  public sv(TransferActivity paramTransferActivity)
  {
  }

  protected Void a(Void[] paramArrayOfVoid)
  {
    List localList1;
    if (TransferActivity.o(this.a))
      localList1 = TransferActivity.v(this.a).a(1);
    List localList4;
    for (this.b = localList1; ; this.b = localList4)
    {
      List localList2 = this.b;
      this.c = localList2;
      List localList3 = y.a().a(1);
      this.d = localList3;
      TransferActivity localTransferActivity = this.a;
      int i = this.b.size();
      HashMap localHashMap1 = new HashMap(i);
      HashMap localHashMap2 = TransferActivity.a(localTransferActivity, localHashMap1);
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        AccountVo localAccountVo = (AccountVo)localIterator.next();
        HashMap localHashMap3 = TransferActivity.w(this.a);
        Long localLong = Long.valueOf(localAccountVo.a());
        Object localObject = localHashMap3.put(localLong, localAccountVo);
      }
      localList4 = TransferActivity.v(this.a).a(0);
    }
    List localList5 = this.d;
    ProjectVo localProjectVo = new ProjectVo("无项目");
    localList5.add(0, localProjectVo);
    return null;
  }

  protected void a(Void paramVoid)
  {
    kn localkn1 = TransferActivity.x(this.a);
    List localList1 = this.b;
    localkn1.a(localList1);
    kn localkn2 = TransferActivity.y(this.a);
    List localList2 = this.c;
    localkn2.a(localList2);
    kt localkt = TransferActivity.z(this.a);
    List localList3 = this.d;
    localkt.a(localList3);
    if (TransferActivity.o(this.a))
    {
      if (this.b.size() >= 1)
        TransferActivity.A(this.a).setSelection(0);
      if (this.c.size() < 2)
        return;
      TransferActivity.B(this.a).setSelection(1);
      return;
    }
    if (!TransferActivity.t(this.a))
      return;
    List localList4 = this.b;
    AccountVo localAccountVo1 = TransferActivity.p(this.a);
    int i = localList4.indexOf(localAccountVo1);
    List localList5 = this.c;
    AccountVo localAccountVo2 = TransferActivity.q(this.a);
    int j = localList5.indexOf(localAccountVo2);
    TransferActivity.A(this.a).setSelection(i, 1);
    TransferActivity.A(this.a).setSelection(i);
    TransferActivity.B(this.a).setSelection(j, 1);
    TransferActivity.B(this.a).setSelection(j);
    Spinner localSpinner = TransferActivity.C(this.a);
    List localList6 = this.d;
    ProjectVo localProjectVo = TransferActivity.r(this.a);
    int k = localList6.indexOf(localProjectVo);
    localSpinner.setSelection(k);
    try
    {
      ((TextView)TransferActivity.A(this.a).getSelectedView()).setTextColor(-7829368);
      ((TextView)TransferActivity.B(this.a).getSelectedView()).setTextColor(-7829368);
      label315: TransferActivity.A(this.a).setEnabled(0);
      TransferActivity.B(this.a).setEnabled(0);
      return;
    }
    catch (Exception localException)
    {
      break label315;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     sv
 * JD-Core Version:    0.6.0
 */