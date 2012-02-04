import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;

class tt
  implements DialogInterface.OnMultiChoiceClickListener
{
  tt(ts paramts, tx paramtx)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt, boolean paramBoolean)
  {
    ty localty = ts.a(this.b)[paramInt];
    localty.a(paramBoolean);
    this.a.a(paramDialogInterface, paramInt, paramBoolean, localty);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     tt
 * JD-Core Version:    0.6.0
 */