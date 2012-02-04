import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class va extends View.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new vb();
  private final int a;
  private final int b;
  private final int c;

  private va(Parcel paramParcel)
  {
    super(paramParcel);
    int i = paramParcel.readInt();
    this.a = i;
    int j = paramParcel.readInt();
    this.b = j;
    int k = paramParcel.readInt();
    this.c = k;
  }

  private va(Parcelable paramParcelable, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramParcelable);
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }

  public int a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    int i = this.a;
    paramParcel.writeInt(i);
    int j = this.b;
    paramParcel.writeInt(j);
    int k = this.c;
    paramParcel.writeInt(k);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     va
 * JD-Core Version:    0.6.0
 */