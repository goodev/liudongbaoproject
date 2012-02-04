import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mymoney.core.vo.CategoryVo;

public final class hi
  implements Parcelable.Creator
{
  public CategoryVo a(Parcel paramParcel)
  {
    CategoryVo localCategoryVo1 = new CategoryVo();
    long l1 = paramParcel.readLong();
    long l2 = CategoryVo.a(localCategoryVo1, l1);
    String str1 = paramParcel.readString();
    String str2 = CategoryVo.a(localCategoryVo1, str1);
    ClassLoader localClassLoader = CategoryVo.class.getClassLoader();
    CategoryVo localCategoryVo2 = (CategoryVo)paramParcel.readValue(localClassLoader);
    CategoryVo localCategoryVo3 = CategoryVo.a(localCategoryVo1, localCategoryVo2);
    return localCategoryVo1;
  }

  public CategoryVo[] a(int paramInt)
  {
    return new CategoryVo[paramInt];
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hi
 * JD-Core Version:    0.6.0
 */