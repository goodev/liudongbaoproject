import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class bs extends ar
  implements ao
{
  private static String a = "select u.tradingEntityPOID as id,u.username as name from t_user as u ";

  public fc a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = a;
    String str2 = str1 + " where u.username = ? and u.password = ?";
    SQLiteDatabase localSQLiteDatabase = g();
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString1;
    arrayOfString[1] = paramString2;
    Cursor localCursor = localSQLiteDatabase.rawQuery(str2, arrayOfString);
    fc localfc = null;
    while (localCursor.moveToNext())
    {
      localfc = new fc();
      int i = localCursor.getColumnIndex("id");
      long l = localCursor.getLong(i);
      localfc.a(l);
      int j = localCursor.getColumnIndex("name");
      String str3 = localCursor.getString(j);
      localfc.a(str3);
    }
    a(localCursor);
    return localfc;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     bs
 * JD-Core Version:    0.6.0
 */