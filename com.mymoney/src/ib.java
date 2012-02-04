import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;

public class ib
  implements DialogInterface.OnClickListener
{
  public ib(AddOrEditTransNewActivity paramAddOrEditTransNewActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    m localm = AddOrEditTransNewActivity.i(this.a);
    long l = AddOrEditTransNewActivity.h(this.a);
    boolean bool = localm.a(l, 1);
    hb.b(AddOrEditTransNewActivity.j(this.a), "删除成功.");
    this.a.finish();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ib
 * JD-Core Version:    0.6.0
 */