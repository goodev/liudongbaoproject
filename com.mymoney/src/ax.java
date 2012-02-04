import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ax extends ar
  implements aj
{
  private static String a;

  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append(" select ");
    String str1 = dp.b;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(",");
    String str2 = dp.d;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(",");
    String str3 = dp.c;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(str3).append(",");
    String str4 = dp.e;
    StringBuilder localStringBuilder5 = localStringBuilder4.append(str4).append(",");
    String str5 = dp.f;
    StringBuilder localStringBuilder6 = localStringBuilder5.append(str5).append(" from ");
    String str6 = dp.a;
    a = str6;
  }

  private ContentValues b(ew paramew)
  {
    ContentValues localContentValues = new ContentValues();
    String str1 = dp.d;
    String str2 = paramew.b();
    localContentValues.put(str1, str2);
    String str3 = dp.c;
    String str4 = paramew.a();
    localContentValues.put(str3, str4);
    String str5 = dp.e;
    Double localDouble = Double.valueOf(paramew.c());
    localContentValues.put(str5, localDouble);
    String str6 = dp.f;
    if (paramew.d());
    for (int i = ew.b; ; i = ew.a)
    {
      Integer localInteger = Integer.valueOf(i);
      localContentValues.put(str6, localInteger);
      return localContentValues;
    }
  }

  public ew a(long paramLong)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = a;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(" where ");
    String str2 = dp.b;
    String str3 = str2 + " = ?";
    SQLiteDatabase localSQLiteDatabase = g();
    String[] arrayOfString = new String[1];
    String str4 = String.valueOf(paramLong);
    arrayOfString[0] = str4;
    Cursor localCursor = localSQLiteDatabase.rawQuery(str3, arrayOfString);
    ew localew = new ew();
    if (localCursor.moveToNext())
    {
      String str5 = dp.b;
      int i = localCursor.getColumnIndex(str5);
      long l = localCursor.getLong(i);
      localew.a(l);
      String str6 = dp.d;
      int j = localCursor.getColumnIndex(str6);
      String str7 = localCursor.getString(j);
      localew.b(str7);
      String str8 = dp.c;
      int k = localCursor.getColumnIndex(str8);
      String str9 = localCursor.getString(k);
      localew.a(str9);
      String str10 = dp.e;
      int m = localCursor.getColumnIndex(str10);
      double d = localCursor.getDouble(m);
      localew.a(d);
      String str11 = dp.f;
      int n = localCursor.getColumnIndex(str11);
      int i1 = localCursor.getInt(n);
      int i2 = ew.b;
      if (i1 == i2);
      int i4;
      for (int i3 = 1; ; i4 = 0)
      {
        localew.a(i3);
        break;
      }
    }
    a(localCursor);
    return localew;
  }

  public boolean a()
  {
    SQLiteDatabase localSQLiteDatabase = g();
    String str = dp.a;
    if (localSQLiteDatabase.delete(str, null, null) > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean a(ew paramew)
  {
    ContentValues localContentValues = b(paramew);
    SQLiteDatabase localSQLiteDatabase = g();
    String str = dp.a;
    if (localSQLiteDatabase.insert(str, null, localContentValues) > 0L);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ax
 * JD-Core Version:    0.6.0
 */