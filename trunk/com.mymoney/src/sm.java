import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.mymoney.ui.sync.SyncActivity;

class sm
  implements DialogInterface.OnClickListener
{
  sm(sl paramsl)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SyncActivity.k(this.a.a);
    hb.b(SyncActivity.a(), "取消同步可能会导致数据跟服务器端不一致");
    this.a.a.finish();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     sm
 * JD-Core Version:    0.6.0
 */