import android.database.sqlite.SQLiteDatabase;

public class bu extends bt
{
  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    bu localbu = new bu();
    localbu.a(paramSQLiteDatabase);
    return localbu.a();
  }

  public boolean a()
  {
    gj.a("DatabaseUpgrade10", "upgrade database to Version10");
    this.a.execSQL(" CREATE TABLE t_temp_transaction_projectcategory_map( transactionPOID long NOT NULL,projectCategoryPOID long NOT NULL)");
    this.a.execSQL("INSERT INTO t_temp_transaction_projectcategory_map(transactionPOID,projectCategoryPOID) SELECT DISTINCT transactionPOID,projectCategoryPOID FROM t_transaction_projectcategory_map");
    this.a.execSQL("DROP TABLE t_transaction_projectcategory_map");
    this.a.execSQL("ALTER TABLE t_temp_transaction_projectcategory_map RENAME TO t_transaction_projectcategory_map");
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     bu
 * JD-Core Version:    0.6.0
 */