import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mymoney.core.vo.AccountGroupVo;

public final class hf
  implements Parcelable.Creator
{
  public AccountGroupVo a(Parcel paramParcel)
  {
    AccountGroupVo localAccountGroupVo1 = new AccountGroupVo();
    long l1 = paramParcel.readLong();
    long l2 = AccountGroupVo.a(localAccountGroupVo1, l1);
    String str1 = paramParcel.readString();
    String str2 = AccountGroupVo.a(localAccountGroupVo1, str1);
    ClassLoader localClassLoader = AccountGroupVo.class.getClassLoader();
    AccountGroupVo localAccountGroupVo2 = (AccountGroupVo)paramParcel.readValue(localClassLoader);
    AccountGroupVo localAccountGroupVo3 = AccountGroupVo.a(localAccountGroupVo1, localAccountGroupVo2);
    String str3 = paramParcel.readString();
    String str4 = AccountGroupVo.b(localAccountGroupVo1, str3);
    boolean[] arrayOfBoolean = new boolean[1];
    paramParcel.readBooleanArray(arrayOfBoolean);
    int i = arrayOfBoolean[0];
    boolean bool = AccountGroupVo.a(localAccountGroupVo1, i);
    int j = paramParcel.readInt();
    int k = AccountGroupVo.a(localAccountGroupVo1, j);
    int m = paramParcel.readInt();
    int n = AccountGroupVo.b(localAccountGroupVo1, m);
    return localAccountGroupVo1;
  }

  public AccountGroupVo[] a(int paramInt)
  {
    return new AccountGroupVo[paramInt];
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hf
 * JD-Core Version:    0.6.0
 */