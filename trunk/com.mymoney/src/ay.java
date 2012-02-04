import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ay extends ar
  implements ak
{
  public static String a = "MaintainDaoImpl";

  private int a(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.rawQuery("select database_version from t_metadata", null);
    int j;
    if (localCursor.moveToNext())
    {
      String str = dq.b;
      int i = localCursor.getColumnIndex(str);
      j = localCursor.getInt(i);
      localCursor.close();
    }
    for (int k = j; ; k = -1)
    {
      return k;
      gj.a(a, "db version record in database is null");
    }
  }

  private void c()
  {
    try
    {
      String str = gx.a(g.a().h().m().k());
      if (gx.a(str))
        return;
      boolean bool = gh.a(str);
      return;
    }
    catch (Throwable localThrowable)
    {
      gj.a(a, "this is normal debug message");
      localThrowable.printStackTrace();
    }
  }

  public boolean a()
  {
    b.close();
    return b.b();
  }

  public void b()
  {
    SQLiteDatabase localSQLiteDatabase = g();
    int i = a(localSQLiteDatabase);
    if (i == -1)
    {
      gj.a(a, "database version cann't be -1");
      return;
    }
    int j = 0;
    if (19 < i)
      throw new ec("application version is low");
    if (19 > i);
    while (true)
    {
      int k;
      int m;
      try
      {
        localSQLiteDatabase.beginTransaction();
        k = j;
        m = 1;
        if (i < 19)
        {
          switch (i + 1)
          {
          default:
            if (m != 0)
              continue;
            i = m;
            j = k;
            if (i == 0)
              continue;
            ContentValues localContentValues = new ContentValues();
            String str1 = dq.b;
            Integer localInteger = Integer.valueOf(19);
            localContentValues.put(str1, localInteger);
            String str2 = dq.a;
            int n = localSQLiteDatabase.update(str2, localContentValues, null, null);
            localSQLiteDatabase.setTransactionSuccessful();
            localSQLiteDatabase.endTransaction();
            i1 = j;
            if (i1 == 0)
              continue;
            localSQLiteDatabase.execSQL("VACUUM t_local_server_id_map");
            gj.a(a, "truncate table t_local_server_id_map finish");
            c();
            return;
          case 2:
            m = ce.b(localSQLiteDatabase);
            break;
          case 3:
            m = cf.b(localSQLiteDatabase);
            break;
          case 4:
            m = cg.b(localSQLiteDatabase);
            break;
          case 5:
            m = ch.b(localSQLiteDatabase);
            break;
          case 6:
            m = ci.b(localSQLiteDatabase);
            break;
          case 7:
            m = cj.b(localSQLiteDatabase);
            break;
          case 8:
            m = ck.b(localSQLiteDatabase);
            break;
          case 9:
            m = cl.b(localSQLiteDatabase);
            break;
          case 10:
            m = bu.b(localSQLiteDatabase);
            break;
          case 11:
            m = bv.b(localSQLiteDatabase);
            k = 1;
            break;
          case 12:
            m = bw.b(localSQLiteDatabase);
            break;
          case 13:
            m = bx.b(localSQLiteDatabase);
            break;
          case 14:
            m = by.b(localSQLiteDatabase);
            break;
          case 15:
            m = bz.b(localSQLiteDatabase);
            break;
          case 16:
            m = ca.b(localSQLiteDatabase);
            break;
          case 17:
            m = cb.b(localSQLiteDatabase);
            break;
          case 18:
            m = cc.b(localSQLiteDatabase);
            break;
          case 19:
          }
          int i2 = cd.b(localSQLiteDatabase);
          m = i2;
          continue;
          i += 1;
          continue;
        }
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
      i = m;
      j = k;
      continue;
      int i1 = j;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ay
 * JD-Core Version:    0.6.0
 */