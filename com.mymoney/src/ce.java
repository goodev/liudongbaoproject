import android.database.sqlite.SQLiteDatabase;

public class ce extends bt
{
  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    ce localce = new ce();
    localce.a(paramSQLiteDatabase);
    return localce.a();
  }

  public boolean a()
  {
    gj.a("DatabaseUpgrade2", "upgrade database to Version2");
    this.a.execSQL("update t_category set path = '/0001/0010/0043/' where categoryPOID = 43;");
    this.a.execSQL("alter table t_profile add column weekStart integer;");
    this.a.execSQL("alter table t_profile add column monthStart integer;");
    this.a.execSQL("update t_profile set weekStart = 0;");
    this.a.execSQL("update t_profile set monthStart = 1;");
    this.a.execSQL("alter table t_metadata add column platform varchar(50);");
    this.a.execSQL("update t_metadata set platform = 'Android'");
    this.a.execSQL("alter table t_transaction add column photoNeedUpload integer default 0;");
    this.a.execSQL("alter table t_deleted_transaction add column photoNeedUpload integer default 0;");
    this.a.execSQL("drop view v_transaction_for_sync");
    this.a.execSQL(" create view v_transaction_for_sync as  select      transactionPOID,       createdTime,       modifiedTime,       tradeTime,       memo,       type,       creatorTradingEntityPOID,       modifierTradingEntityPOID,       buyerAccountPOID,       buyerTradingEntityPOID,       sellerAccountPOID,       sellerTradingEntityPOID,        photoName,      photoNeedUpload,     lastUpdateTime,       0 as deleted,        serverId     from      t_transaction  as trans  left join       t_local_server_id_map as idMap on trans.transactionPOID = idMap.localId and idMap.ownerTable = 't_transaction'  union  select        transactionPOID,       createdTime,       modifiedTime,       tradeTime,        memo,       type,       creatorTradingEntityPOID,       modifierTradingEntityPOID,       buyerAccountPOID,       buyerTradingEntityPOID,       sellerAccountPOID,       sellerTradingEntityPOID,         photoName,     photoNeedUpload,      lastUpdateTime,       1 as deleted,        serverId  from      t_deleted_transaction  as trans  left join    t_local_server_id_map as idMap on trans.transactionPOID = idMap.localId and idMap.ownerTable = 't_transaction'");
    this.a.execSQL("create index idx_idmap_ownerTable on t_local_server_id_map(ownerTable);");
    this.a.execSQL("create index idx_tradeItem_transactionPOID on t_tradeItem(transactionPOID);");
    this.a.execSQL("create index idx_deleted_tradeItem_transactionPOID on t_deleted_tradeItem(transactionPOID);");
    this.a.execSQL("create index idx_transaction_tradeTime on t_transaction(tradeTime);");
    this.a.execSQL("create index idx_transaction_buyerAccountPOID on t_transaction(buyerAccountPOID);");
    this.a.execSQL("create index idx_transaction_buyerTradingEntityPOID on t_transaction(buyerTradingEntityPOID);");
    this.a.execSQL("create index idx_transaction_sellerTradingEntityPOID on t_transaction(sellerTradingEntityPOID);");
    this.a.execSQL("create index idx_deleted_transaction_tradeTime on t_deleted_transaction(tradeTime);");
    this.a.execSQL("create index idx_deleted_transaction_buyerAccountPOID on t_deleted_transaction(buyerAccountPOID);");
    this.a.execSQL("create index idx_deleted_transaction_buyerTradingEntityPOID on t_deleted_transaction(buyerTradingEntityPOID);");
    this.a.execSQL("create index idx_deleted_transaction_sellerTradingEntityPOID on t_deleted_transaction(sellerTradingEntityPOID);");
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ce
 * JD-Core Version:    0.6.0
 */