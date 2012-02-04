import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.core.vo.CorporationVo;
import com.mymoney.core.vo.TransactionVo;

public final class ho
  implements Parcelable.Creator
{
  public TransactionVo a(Parcel paramParcel)
  {
    TransactionVo localTransactionVo = new TransactionVo();
    long l1 = paramParcel.readLong();
    long l2 = TransactionVo.a(localTransactionVo, l1);
    double d1 = paramParcel.readDouble();
    double d2 = TransactionVo.a(localTransactionVo, d1);
    String str1 = paramParcel.readString();
    String str2 = TransactionVo.a(localTransactionVo, str1);
    String str3 = paramParcel.readString();
    String str4 = TransactionVo.b(localTransactionVo, str3);
    boolean[] arrayOfBoolean = new boolean[1];
    paramParcel.readBooleanArray(arrayOfBoolean);
    int i = arrayOfBoolean[0];
    boolean bool = TransactionVo.a(localTransactionVo, i);
    long l3 = paramParcel.readLong();
    long l4 = TransactionVo.b(localTransactionVo, l3);
    String str5 = paramParcel.readString();
    String str6 = TransactionVo.c(localTransactionVo, str5);
    ClassLoader localClassLoader1 = TransactionVo.class.getClassLoader();
    CategoryVo localCategoryVo1 = (CategoryVo)paramParcel.readValue(localClassLoader1);
    CategoryVo localCategoryVo2 = TransactionVo.a(localTransactionVo, localCategoryVo1);
    ClassLoader localClassLoader2 = TransactionVo.class.getClassLoader();
    AccountVo localAccountVo1 = (AccountVo)paramParcel.readValue(localClassLoader2);
    AccountVo localAccountVo2 = TransactionVo.a(localTransactionVo, localAccountVo1);
    ClassLoader localClassLoader3 = TransactionVo.class.getClassLoader();
    AccountVo localAccountVo3 = (AccountVo)paramParcel.readValue(localClassLoader3);
    AccountVo localAccountVo4 = TransactionVo.b(localTransactionVo, localAccountVo3);
    ClassLoader localClassLoader4 = TransactionVo.class.getClassLoader();
    CorporationVo localCorporationVo1 = (CorporationVo)paramParcel.readValue(localClassLoader4);
    CorporationVo localCorporationVo2 = TransactionVo.a(localTransactionVo, localCorporationVo1);
    return localTransactionVo;
  }

  public TransactionVo[] a(int paramInt)
  {
    return new TransactionVo[paramInt];
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ho
 * JD-Core Version:    0.6.0
 */