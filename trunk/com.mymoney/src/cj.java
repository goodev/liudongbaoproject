import android.database.sqlite.SQLiteDatabase;

public class cj extends bt
{
  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    cj localcj = new cj();
    localcj.a(paramSQLiteDatabase);
    return localcj.a();
  }

  public boolean a()
  {
    gj.a("DatabaseUpgrade7", "upgrade database to Version7");
    StringBuilder localStringBuilder = new StringBuilder().append(" update t_transaction set lastUpdateTime  = ");
    long l = gt.f();
    String str = l + " where relation is null ";
    this.a.execSQL(str);
    this.a.execSQL(" update t_transaction set relation = '' where relation is null");
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     cj
 * JD-Core Version:    0.6.0
 */