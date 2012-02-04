import android.database.sqlite.SQLiteDatabase;
import com.mymoney.core.application.ApplicationContext;

public class dj
{
  public static void a()
  {
    ApplicationContext.b.a().beginTransaction();
  }

  public static void b()
  {
    ApplicationContext.b.a().setTransactionSuccessful();
  }

  public static void c()
  {
    ApplicationContext.b.a().endTransaction();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     dj
 * JD-Core Version:    0.6.0
 */