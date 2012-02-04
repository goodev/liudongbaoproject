import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mymoney.core.application.ApplicationContext;

public abstract class ct
{
  public static int c = 0;
  public static dh d;
  private String a = "BaseAbstractDao";

  public ct()
  {
    d = ApplicationContext.b;
  }

  protected void a(long paramLong1, long paramLong2, String paramString)
  {
  }

  protected void a(Cursor paramCursor)
  {
    if (paramCursor == null)
      return;
    if (paramCursor.isClosed())
      return;
    paramCursor.close();
  }

  public long c(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase1 = d.a();
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = paramString;
    Cursor localCursor = localSQLiteDatabase1.rawQuery("select idSeed from t_id_seed where tableName = ?", arrayOfString1);
    long l = 65535L;
    while (localCursor.moveToNext())
    {
      int i = localCursor.getColumnIndex("idSeed");
      l = localCursor.getLong(i);
    }
    a(localCursor);
    ContentValues localContentValues = new ContentValues();
    Long localLong = Long.valueOf(1L + l);
    localContentValues.put("idSeed", localLong);
    SQLiteDatabase localSQLiteDatabase2 = d.a();
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = paramString;
    int j = localSQLiteDatabase2.update("t_id_seed", localContentValues, "tableName = ?", arrayOfString2);
    return 0L - l;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ct
 * JD-Core Version:    0.6.0
 */