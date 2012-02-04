import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class ca extends bt
{
  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    ca localca = new ca();
    localca.a(paramSQLiteDatabase);
    return localca.a();
  }

  public boolean a()
  {
    gj.a("DatabaseUpgrade16", "upgrade database to Version16");
    ArrayList localArrayList = new ArrayList(50);
    boolean bool1 = localArrayList.add("alter table t_metadata add column databaseSchemaVersion integer default 1");
    boolean bool2 = localArrayList.add("alter table t_account add column ordered integer default 0");
    boolean bool3 = localArrayList.add("alter table t_deleted_account add column ordered integer default 0");
    boolean bool4 = localArrayList.add("alter table t_category add column ordered integer default 0");
    boolean bool5 = localArrayList.add("alter table t_deleted_category add column ordered integer default 0");
    boolean bool6 = localArrayList.add("alter table t_corporation add column ordered integer default 0");
    boolean bool7 = localArrayList.add("alter table t_deleted_corporation add column ordered integer default 0");
    boolean bool8 = localArrayList.add("alter table t_tradingEntity add column ordered integer default 0");
    boolean bool9 = localArrayList.add("alter table t_deleted_tradingEntity add column ordered integer default 0");
    boolean bool10 = localArrayList.add("update t_account set ordered = (         select tt.newNumber from         (                 select a.*,count(*) as newNumber from                     (select accountPOID,accountGroupPOID, rowid as rownumber  from t_account order by accountGroupPOID, rownumber) a,                     (select accountPOID,accountGroupPOID, rowid as rownumber  from t_account order by accountGroupPOID, rownumber) b                     where a.accountGroupPOID = b.accountGroupPOID and a.rownumber <= b.rownumber             group by a.accountpoid             order by a.accountGroupPOID, newNumber         ) tt where t_account.accountPOID = tt.accountPOID         )");
    boolean bool11 = localArrayList.add("update t_deleted_account set ordered = (         select tt.newNumber from         (                 select a.*,count(*) as newNumber from                     (select accountPOID,accountGroupPOID, rowid as rownumber  from t_deleted_account order by accountGroupPOID, rownumber) a,                     (select accountPOID,accountGroupPOID, rowid as rownumber  from t_deleted_account order by accountGroupPOID, rownumber) b                     where a.accountGroupPOID = b.accountGroupPOID and a.rownumber <= b.rownumber             group by a.accountpoid             order by a.accountGroupPOID, newNumber         ) tt where t_deleted_account.accountPOID = tt.accountPOID         )");
    boolean bool12 = localArrayList.add("update t_category set ordered = (         select tt.newNumber from         (                 select a.*,count(*) as newNumber from                     (select categoryPOID,parentCategoryPOID, rowid as rownumber  from t_category order by parentCategoryPOID, rownumber) a,                     (select categoryPOID,parentCategoryPOID, rowid as rownumber  from t_category order by parentCategoryPOID, rownumber) b                     where a.parentCategoryPOID = b.parentCategoryPOID and a.rownumber > b.rownumber             group by a.categoryPOID             order by a.parentCategoryPOID, newNumber         ) tt where t_category.categoryPOID = tt.categoryPOID         )");
    boolean bool13 = localArrayList.add("update t_deleted_category set ordered = (         select tt.newNumber from         (                 select a.*,count(*) as newNumber from                     (select categoryPOID,parentCategoryPOID, rowid as rownumber  from t_deleted_category order by parentCategoryPOID, rownumber) a,                     (select categoryPOID,parentCategoryPOID, rowid as rownumber  from t_deleted_category order by parentCategoryPOID, rownumber) b                     where a.parentCategoryPOID = b.parentCategoryPOID and a.rownumber <= b.rownumber             group by a.categoryPOID             order by a.parentCategoryPOID, newNumber         ) tt where t_deleted_category.categoryPOID = tt.categoryPOID         )");
    boolean bool14 = localArrayList.add("update t_corporation set ordered = rowid");
    boolean bool15 = localArrayList.add("update t_deleted_corporation set ordered = rowid");
    boolean bool16 = localArrayList.add("update t_tradingEntity set ordered = rowid");
    boolean bool17 = localArrayList.add("update t_deleted_tradingEntity set ordered = rowid");
    boolean bool18 = localArrayList.add(" CREATE TABLE t_transaction_temp (transactionPOID LONG NOT NULL, createdTime LONG NOT NULL, modifiedTime LONG NOT NULL, tradeTime LONG NOT NULL, memo varchar(100), type integer NOT NULL, creatorTradingEntityPOID LONG, modifierTradingEntityPOID LONG, buyerAccountPOID LONG, buyerCategoryPOID LONG default 0, buyerMoney decimal(12,2), sellerAccountPOID LONG, sellerCategoryPOID LONG default 0, sellerMoney decimal(12,2), lastUpdateTime LONG, photoName VARCHAR(100), photoNeedUpload integer default 0, relation varchar(200) default '', relationUnitPOID LONG, PRIMARY KEY (transactionPOID))");
    boolean bool19 = localArrayList.add("insert into t_transaction_temp(transactionPOID, createdTime, modifiedTime, tradeTime, memo, type,creatorTradingEntityPOID,modifierTradingEntityPOID,buyerAccountPOID, sellerAccountPOID,lastUpdateTime,photoName,photoNeedUpload,relation,relationUnitPOID ) select transactionPOID, createdTime, modifiedTime, tradeTime, memo, type,creatorTradingEntityPOID,modifierTradingEntityPOID,buyerAccountPOID, sellerAccountPOID,lastUpdateTime,photoName,photoNeedUpload,relation,sellerTradingEntityPOID from t_transaction");
    boolean bool20 = localArrayList.add("update t_transaction_temp set sellerCategoryPOID = (select categoryPOID from t_tradeItem as ti where ti.transactionPOID = t_transaction_temp.transactionPOID and tradeItemType=1) where type = 0");
    boolean bool21 = localArrayList.add("update t_transaction_temp set buyerCategoryPOID = (select categoryPOID from t_tradeItem as ti where ti.transactionPOID = t_transaction_temp.transactionPOID and tradeItemType=1) where type = 1");
    boolean bool22 = localArrayList.add("update t_transaction_temp set buyerMoney = (select currencyValue from t_tradeItem as ti where ti.transactionPOID = t_transaction_temp.transactionPOID and tradeItemType=1), sellerMoney=buyerMoney");
    boolean bool23 = localArrayList.add("update t_transaction_temp set sellerMoney=buyerMoney");
    boolean bool24 = localArrayList.add("DROP INDEX IF EXISTS idx_transaction_buyerAccountPOID");
    boolean bool25 = localArrayList.add("DROP INDEX IF EXISTS idx_transaction_buyerTradingEntityPOID");
    boolean bool26 = localArrayList.add("DROP INDEX IF EXISTS idx_transaction_projectcategory_projectCategoryPOID");
    boolean bool27 = localArrayList.add("DROP INDEX IF EXISTS idx_transaction_projectcategory_transactionPOID");
    boolean bool28 = localArrayList.add("DROP INDEX IF EXISTS idx_transaction_relation");
    boolean bool29 = localArrayList.add("DROP INDEX IF EXISTS idx_transaction_sellerTradingEntityPOID");
    boolean bool30 = localArrayList.add("DROP INDEX IF EXISTS idx_transaction_tradeTime");
    boolean bool31 = localArrayList.add("alter table t_transaction rename to t_transaction_bak");
    boolean bool32 = localArrayList.add("alter table t_transaction_temp rename to t_transaction");
    boolean bool33 = localArrayList.add("CREATE INDEX IF NOT EXISTS idx_transaction_buyerAccountPOID on t_transaction(buyerAccountPOID)");
    boolean bool34 = localArrayList.add("CREATE INDEX IF NOT EXISTS idx_transaction_relation on t_transaction(relation)");
    boolean bool35 = localArrayList.add("CREATE INDEX IF NOT EXISTS idx_transaction_tradeTime on t_transaction(tradeTime)");
    boolean bool36 = localArrayList.add("CREATE TABLE t_deleted_transaction_temp (transactionPOID LONG NOT NULL, createdTime LONG NOT NULL, modifiedTime LONG NOT NULL, tradeTime LONG NOT NULL, memo varchar(100), type integer NOT NULL, creatorTradingEntityPOID LONG, modifierTradingEntityPOID LONG, buyerAccountPOID LONG, buyerCategoryPOID LONG default 0, buyerMoney decimal(12,2), sellerAccountPOID LONG, sellerCategoryPOID LONG default 0, sellerMoney decimal(12,2), lastUpdateTime LONG, photoName VARCHAR(100), photoNeedUpload integer default 0, relation varchar(200) default '', relationUnitPOID LONG, PRIMARY KEY (transactionPOID))");
    boolean bool37 = localArrayList.add("insert into t_deleted_transaction_temp(transactionPOID, createdTime, modifiedTime, tradeTime, memo, type,creatorTradingEntityPOID,modifierTradingEntityPOID,buyerAccountPOID, sellerAccountPOID,lastUpdateTime,photoName,photoNeedUpload,relation,relationUnitPOID ) select transactionPOID, createdTime, modifiedTime, tradeTime, memo, type,creatorTradingEntityPOID,modifierTradingEntityPOID,buyerAccountPOID, sellerAccountPOID,lastUpdateTime,photoName,photoNeedUpload,relation,sellerTradingEntityPOID from t_deleted_transaction");
    boolean bool38 = localArrayList.add("update t_deleted_transaction_temp set sellerCategoryPOID = (select categoryPOID from t_deleted_tradeItem as ti where ti.transactionPOID = t_deleted_transaction_temp.transactionPOID and tradeItemType=1) where type = 0");
    boolean bool39 = localArrayList.add("update t_deleted_transaction_temp set buyerCategoryPOID = (select categoryPOID from t_deleted_tradeItem as ti where ti.transactionPOID = t_deleted_transaction_temp.transactionPOID and tradeItemType=1) where type = 1");
    boolean bool40 = localArrayList.add("update t_deleted_transaction_temp set buyerMoney = (select currencyValue from t_deleted_tradeItem as ti where ti.transactionPOID = t_deleted_transaction_temp.transactionPOID and tradeItemType=1)");
    boolean bool41 = localArrayList.add("update t_deleted_transaction_temp set sellerMoney=buyerMoney");
    boolean bool42 = localArrayList.add("DROP INDEX IF EXISTS idx_deleted_transaction_buyerAccountPOID");
    boolean bool43 = localArrayList.add("DROP INDEX IF EXISTS idx_deleted_transaction_buyerTradingEntityPOID");
    boolean bool44 = localArrayList.add("DROP INDEX IF EXISTS idx_deleted_transaction_relation");
    boolean bool45 = localArrayList.add("DROP INDEX IF EXISTS idx_deleted_transaction_sellerTradingEntityPOID");
    boolean bool46 = localArrayList.add("DROP INDEX IF EXISTS idx_deleted_transaction_tradeTime");
    boolean bool47 = localArrayList.add("alter table t_deleted_transaction rename to t_deleted_transaction_bak");
    boolean bool48 = localArrayList.add("alter table t_deleted_transaction_temp rename to t_deleted_transaction");
    boolean bool49 = localArrayList.add("CREATE INDEX IF NOT EXISTS idx_deleted_transaction_buyerAccountPOID on t_deleted_transaction(buyerAccountPOID)");
    boolean bool50 = localArrayList.add("CREATE INDEX IF NOT EXISTS idx_deleted_transaction_relation on t_deleted_transaction(relation)");
    boolean bool51 = localArrayList.add("CREATE INDEX IF NOT EXISTS idx_deleted_transaction_tradeTime on t_deleted_transaction(tradeTime)");
    boolean bool52 = localArrayList.add("alter table t_tradeItem rename to t_tradeItem_bak");
    boolean bool53 = localArrayList.add("alter table t_deleted_tradeItem rename to t_deleted_tradeItem_bak");
    boolean bool54 = localArrayList.add("alter table  t_tag add column tagType integer default 1");
    boolean bool55 = localArrayList.add("alter table  t_tag add column ordered integer");
    boolean bool56 = localArrayList.add("delete from t_tag");
    boolean bool57 = localArrayList.add("insert into t_tag(tagPOID, name, lastUpdateTime) select categoryPOID, name, lastUpdateTime from t_category where t_category.type = 2 and depth=1");
    boolean bool58 = localArrayList.add("delete from t_category where t_category.type = 2 and depth=1");
    boolean bool59 = localArrayList.add("update t_id_seed set idSeed = (select idSeed from t_id_seed as ids where ids.tableName='t_category') where tableName='t_tag'");
    boolean bool60 = localArrayList.add("update t_tag set ordered = rowid");
    boolean bool61 = localArrayList.add("CREATE TABLE t_deleted_tag ( tagPOID LONG NOT NULL,  name varchar(100),  tagType integer default 0, lastUpdateTime LONG,  ordered integer, PRIMARY KEY (tagPOID))");
    boolean bool62 = localArrayList.add("insert into t_deleted_tag(tagPOID, name, lastUpdateTime) select categoryPOID, name, lastUpdateTime from t_deleted_category where t_deleted_category.type = 2 and depth=1");
    boolean bool63 = localArrayList.add("delete from t_deleted_category where t_deleted_category.type = 2 and depth=1");
    boolean bool64 = localArrayList.add("update t_deleted_tag set ordered = rowid");
    boolean bool65 = localArrayList.add("alter table t_tradingEntity add column belongTo LONG");
    boolean bool66 = localArrayList.add("update t_tradingEntity set belongTo = (select belongTo from t_corporation as c where c.tradingEntityPOID = t_tradingEntity.tradingEntityPOID)");
    boolean bool67 = localArrayList.add("alter table t_deleted_tradingEntity add column belongTo LONG");
    boolean bool68 = localArrayList.add("update t_deleted_tradingEntity set belongTo = (select belongTo from t_deleted_corporation as c where c.tradingEntityPOID = t_deleted_tradingEntity.tradingEntityPOID)");
    boolean bool69 = localArrayList.add("alter table t_metadata add column agent varchar(20) default '' ");
    boolean bool70 = localArrayList.add("alter table t_metadata add column agentVersion varchar(20) default '' ");
    boolean bool71 = localArrayList.add("update t_metadata set agent='mymoney' ");
    StringBuilder localStringBuilder = new StringBuilder().append("update t_metadata set agentVersion='");
    String str1 = gt.e();
    String str2 = str1 + "'";
    boolean bool72 = localArrayList.add(str2);
    boolean bool73 = localArrayList.add("drop view if exists v_account_for_sync");
    boolean bool74 = localArrayList.add("drop view if exists v_budget_item_for_sync");
    boolean bool75 = localArrayList.add("drop view if exists v_category_for_sync");
    boolean bool76 = localArrayList.add("drop view if exists v_category_temp_for_sync");
    boolean bool77 = localArrayList.add("drop view if exists v_coporation_for_sync");
    boolean bool78 = localArrayList.add("drop view if exists v_tradeItem_for_sync");
    boolean bool79 = localArrayList.add("drop view if exists v_tradingEntity_for_sync");
    boolean bool80 = localArrayList.add("drop view if exists v_transaction_for_sync");
    he.a(localArrayList, 1);
    localArrayList.clear();
    a(3);
    gj.a("DatabaseUpgrade16", "upgrade database to Version16 success");
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ca
 * JD-Core Version:    0.6.0
 */