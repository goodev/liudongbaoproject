import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mymoney.core.vo.AccountGroupVo;
import com.mymoney.core.vo.AccountVo;

public final class hg
  implements Parcelable.Creator
{
  public AccountVo a(Parcel paramParcel)
  {
    AccountVo localAccountVo = new AccountVo();
    long l1 = paramParcel.readLong();
    long l2 = AccountVo.a(localAccountVo, l1);
    String str1 = paramParcel.readString();
    String str2 = AccountVo.a(localAccountVo, str1);
    String str3 = paramParcel.readString();
    String str4 = AccountVo.b(localAccountVo, str3);
    double d1 = paramParcel.readDouble();
    double d2 = AccountVo.a(localAccountVo, d1);
    double d3 = paramParcel.readDouble();
    double d4 = AccountVo.b(localAccountVo, d3);
    double d5 = paramParcel.readDouble();
    double d6 = AccountVo.c(localAccountVo, d5);
    String str5 = paramParcel.readString();
    String str6 = AccountVo.c(localAccountVo, str5);
    boolean[] arrayOfBoolean = new boolean[1];
    paramParcel.readBooleanArray(arrayOfBoolean);
    int i = arrayOfBoolean[0];
    boolean bool = AccountVo.a(localAccountVo, i);
    ClassLoader localClassLoader = AccountVo.class.getClassLoader();
    AccountGroupVo localAccountGroupVo1 = (AccountGroupVo)paramParcel.readValue(localClassLoader);
    AccountGroupVo localAccountGroupVo2 = AccountVo.a(localAccountVo, localAccountGroupVo1);
    String str7 = paramParcel.readString();
    String str8 = AccountVo.d(localAccountVo, str7);
    return localAccountVo;
  }

  public AccountVo[] a(int paramInt)
  {
    return new AccountVo[paramInt];
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hg
 * JD-Core Version:    0.6.0
 */