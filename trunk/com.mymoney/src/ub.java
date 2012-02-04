import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ub
  implements DialogInterface.OnClickListener
{
  ub(ua paramua, uf paramuf)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ua localua = this.b;
    ty localty1 = ua.a(this.b)[paramInt];
    localua.k = localty1;
    uf localuf = this.a;
    ty localty2 = this.b.k;
    localuf.a(paramDialogInterface, paramInt, localty2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ub
 * JD-Core Version:    0.6.0
 */