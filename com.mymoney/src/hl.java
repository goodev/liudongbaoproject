import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mymoney.core.vo.ProjectVo;

public final class hl
  implements Parcelable.Creator
{
  public ProjectVo a(Parcel paramParcel)
  {
    ProjectVo localProjectVo = new ProjectVo();
    long l1 = paramParcel.readLong();
    long l2 = ProjectVo.a(localProjectVo, l1);
    String str1 = paramParcel.readString();
    String str2 = ProjectVo.a(localProjectVo, str1);
    int i = paramParcel.readInt();
    int j = ProjectVo.a(localProjectVo, i);
    return localProjectVo;
  }

  public ProjectVo[] a(int paramInt)
  {
    return new ProjectVo[paramInt];
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hl
 * JD-Core Version:    0.6.0
 */