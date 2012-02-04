import android.database.Cursor;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.ProjectVo;
import com.mymoney.core.vo.TransactionVo;
import java.util.List;

public abstract interface m
{
  public abstract int a();

  public abstract Cursor a(long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, long[] paramArrayOfLong5, String paramString);

  public abstract TransactionVo a(long paramLong);

  public abstract TransactionVo a(String paramString);

  public abstract List a(int paramInt, String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, long[] paramArrayOfLong5, String paramString2, String paramString3, String paramString4);

  public abstract List a(long paramLong1, long paramLong2);

  public abstract List a(String paramString, int paramInt);

  public abstract boolean a(double paramDouble1, AccountVo paramAccountVo1, double paramDouble2, AccountVo paramAccountVo2, long paramLong, ProjectVo paramProjectVo, String paramString, boolean paramBoolean);

  public abstract boolean a(long paramLong1, double paramDouble1, AccountVo paramAccountVo1, double paramDouble2, AccountVo paramAccountVo2, long paramLong2, ProjectVo paramProjectVo, String paramString);

  public abstract boolean a(long paramLong, boolean paramBoolean);

  public abstract boolean a(TransactionVo paramTransactionVo);

  public abstract boolean a(TransactionVo paramTransactionVo, int paramInt);

  public abstract double b(long paramLong1, long paramLong2);

  public abstract List b(long paramLong);

  public abstract boolean b();

  public abstract double c(long paramLong1, long paramLong2);

  public abstract long c();

  public abstract Cursor d(long paramLong1, long paramLong2);
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     m
 * JD-Core Version:    0.6.0
 */