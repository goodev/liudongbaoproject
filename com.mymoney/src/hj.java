import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mymoney.core.vo.CorporationVo;

public final class hj
  implements Parcelable.Creator
{
  public CorporationVo a(Parcel paramParcel)
  {
    CorporationVo localCorporationVo = new CorporationVo();
    long l1 = paramParcel.readLong();
    long l2 = CorporationVo.a(localCorporationVo, l1);
    String str1 = paramParcel.readString();
    String str2 = CorporationVo.a(localCorporationVo, str1);
    return localCorporationVo;
  }

  public CorporationVo[] a(int paramInt)
  {
    return new CorporationVo[paramInt];
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hj
 * JD-Core Version:    0.6.0
 */