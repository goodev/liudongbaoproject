import android.database.sqlite.SQLiteDatabase;

public class cg extends bt
{
  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    cg localcg = new cg();
    localcg.a(paramSQLiteDatabase);
    return localcg.a();
  }

  public boolean a()
  {
    gj.a("DatabaseUpgrade4", "upgrade database to Version4");
    this.a.execSQL("create table t_transaction_projectcategory_map (  transactionPOID long not null,  projectCategoryPOID long not null)");
    this.a.execSQL("create index idx_transaction_projectcategory_transactionPOID on t_transaction_projectcategory_map(transactionPOID);");
    this.a.execSQL("create index idx_transaction_projectcategory_projectCategoryPOID on t_transaction_projectcategory_map(projectCategoryPOID);");
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     cg
 * JD-Core Version:    0.6.0
 */