import android.database.sqlite.SQLiteDatabase;

public abstract class bt extends ct
{
  protected SQLiteDatabase a;

  public String a(String paramString)
  {
    return "'" + paramString + "'";
  }

  protected void a(int paramInt)
  {
    he.a("update t_metadata set databaseSchemaVersion = " + paramInt, 0);
  }

  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    this.a = paramSQLiteDatabase;
  }

  public abstract boolean a();
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     bt
 * JD-Core Version:    0.6.0
 */