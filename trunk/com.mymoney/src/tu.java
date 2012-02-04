import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class tu
  implements DialogInterface.OnClickListener
{
  tu(ts paramts, tx paramtx)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ts localts = this.b;
    ty[] arrayOfty = ts.a(this.b);
    boolean bool1 = this.b.h;
    boolean bool2 = ty.a(arrayOfty, bool1);
    localts.j = bool2;
    this.a.a(paramDialogInterface, paramInt);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     tu
 * JD-Core Version:    0.6.0
 */