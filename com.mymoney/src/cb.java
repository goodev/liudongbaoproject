import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class cb extends bt
{
  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    cb localcb = new cb();
    localcb.a(paramSQLiteDatabase);
    return localcb.a();
  }

  public boolean a()
  {
    gj.a("DatabaseUpgrade17", "upgrade database to Version17");
    ArrayList localArrayList = new ArrayList(50);
    boolean bool1 = localArrayList.add("delete from t_tradingEntity where  name = 'demo' or name = 'trial'");
    boolean bool2 = localArrayList.add("delete from t_id_seed where  tableName = 't_planning' or tableName = 't_planning_item' or tableName = 't_tradeItem' or tableName = 't_account_group'");
    boolean bool3 = localArrayList.add("drop table if exists t_account_tag_map");
    boolean bool4 = localArrayList.add("drop table if exists t_budget");
    boolean bool5 = localArrayList.add("drop table if exists t_corporation");
    boolean bool6 = localArrayList.add("drop table if exists t_deleted_corporation");
    boolean bool7 = localArrayList.add("drop table if exists t_deleted_tradeItem_bak");
    boolean bool8 = localArrayList.add("drop table if exists t_deleted_transaction_bak");
    boolean bool9 = localArrayList.add("drop table if exists t_externalData");
    boolean bool10 = localArrayList.add("drop table if exists t_local_server_id_map");
    boolean bool11 = localArrayList.add("drop table if exists t_planning");
    boolean bool12 = localArrayList.add("drop table if exists t_planning_item");
    boolean bool13 = localArrayList.add("drop table if exists t_tradeItem_bak");
    boolean bool14 = localArrayList.add("drop table if exists t_tradeItem_tag_map");
    boolean bool15 = localArrayList.add("drop table if exists t_transaction_bak");
    he.a(localArrayList, 1);
    localArrayList.clear();
    gj.a("DatabaseUpgrade17", "upgrade database to Version17 success");
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     cb
 * JD-Core Version:    0.6.0
 */