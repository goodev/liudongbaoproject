import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class bo extends ar
{
  private static bo a = null;

  public static bo a()
  {
    if (a == null)
      a = new bo();
    return a;
  }

  public long a(fa paramfa)
  {
    String str1 = dt.a;
    long l1 = c(str1);
    String str2 = paramfa.b();
    ContentValues localContentValues = new ContentValues();
    String str3 = dt.b;
    Long localLong1 = Long.valueOf(l1);
    localContentValues.put(str3, localLong1);
    String str4 = dt.c;
    localContentValues.put(str4, str2);
    String str5 = dt.d;
    Integer localInteger1 = Integer.valueOf(paramfa.d());
    localContentValues.put(str5, localInteger1);
    Integer localInteger2 = Integer.valueOf(paramfa.e());
    localContentValues.put("ordered", localInteger2);
    if (paramfa.c() > 0L)
    {
      String str6 = dt.e;
      Long localLong2 = Long.valueOf(paramfa.c());
      localContentValues.put(str6, localLong2);
    }
    while (true)
    {
      SQLiteDatabase localSQLiteDatabase = g();
      String str7 = dt.a;
      long l2 = localSQLiteDatabase.insert(str7, null, localContentValues);
      return l1;
      String str8 = dt.e;
      Long localLong3 = Long.valueOf(gt.f());
      localContentValues.put(str8, localLong3);
    }
  }

  public List a(int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = "SELECT t.tagPOID, t.name, t.tagType, t.lastUpdateTime, t.ordered from t_tag t where  t.tagType = " + paramInt + " order by t.ordered,t.lastUpdateTime";
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    ArrayList localArrayList = new ArrayList();
    String str2 = localStringBuilder1.toString();
    bp localbp = new bp(this, localArrayList);
    Object localObject = a(str2, null, localbp);
    return localArrayList;
  }

  public void a(long paramLong)
  {
    he.a("insert into t_deleted_tag select * from t_tag where tagPOID = " + paramLong, 0);
    long l = gt.f();
    he.a("update t_deleted_tag set lastUpdateTime = " + l + " where tagPOID = " + paramLong, 0);
  }

  public boolean a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    String str = "select id from t_tag where name = '" + paramString2 + "' and type = " + paramInt;
    if (!gx.a(paramString1))
      str = "select id from t_tag where name = '" + paramString2 + "' and type = " + paramInt + " and tagPOID <> " + paramString1;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "1";
    if (he.b(str, arrayOfString, null).isEmpty());
    for (int i = 0; ; i = 1)
      return i;
  }

  public boolean b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = dt.b;
    String str2 = str1 + "=?";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    SQLiteDatabase localSQLiteDatabase = g();
    String str4 = dt.a;
    if (localSQLiteDatabase.delete(str4, str2, arrayOfString) > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean b(fa paramfa)
  {
    String str1 = paramfa.b();
    ContentValues localContentValues = new ContentValues();
    String str2 = dt.c;
    localContentValues.put(str2, str1);
    String str3 = dt.e;
    Long localLong = Long.valueOf(gt.f());
    localContentValues.put(str3, localLong);
    StringBuilder localStringBuilder = new StringBuilder();
    String str4 = dt.b;
    String str5 = str4 + " = ?";
    String[] arrayOfString = new String[1];
    String str6 = String.valueOf(paramfa.a());
    arrayOfString[0] = str6;
    SQLiteDatabase localSQLiteDatabase = g();
    String str7 = dt.a;
    if (localSQLiteDatabase.update(str7, localContentValues, str5, arrayOfString) > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public fa c(long paramLong)
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("select * from ");
    String str1 = dt.a;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(" where ");
    String str2 = dt.b;
    String str3 = str2 + " = ?";
    String[] arrayOfString = new String[1];
    String str4 = String.valueOf(paramLong);
    arrayOfString[0] = str4;
    Cursor localCursor = g().rawQuery(str3, arrayOfString);
    fa localfa = null;
    while (localCursor.moveToNext())
    {
      localfa = new fa();
      String str5 = dt.b;
      int i = localCursor.getColumnIndex(str5);
      long l = localCursor.getLong(i);
      localfa.a(l);
      String str6 = dt.c;
      int j = localCursor.getColumnIndex(str6);
      String str7 = localCursor.getString(j);
      localfa.a(str7);
    }
    a(localCursor);
    return localfa;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     bo
 * JD-Core Version:    0.6.0
 */