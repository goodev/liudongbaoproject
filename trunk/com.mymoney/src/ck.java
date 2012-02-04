import android.database.sqlite.SQLiteDatabase;

public class ck extends bt
{
  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    ck localck = new ck();
    localck.a(paramSQLiteDatabase);
    return localck.a();
  }

  public boolean a()
  {
    gj.a("DatabaseUpgrade8", "upgrade database to Version8");
    this.a.execSQL("create index idx_account_tradingEntityPOID on t_account(tradingEntityPOID);");
    this.a.execSQL("create index idx_account_accountGroupPOID on t_account(accountGroupPOID);");
    this.a.execSQL("create index idx_deleted_account_tradingEntityPOID on t_deleted_account(tradingEntityPOID);");
    this.a.execSQL("create index idx_deleted_account_accountGroupPOID on t_deleted_account(accountGroupPOID);");
    this.a.execSQL("create index idx_account_group_tradingEntityPOID on t_account_group(userTradingEntityPOID);");
    this.a.execSQL("create index idx_budget_item_categoryPOID on t_budget_item(categoryPOID);");
    this.a.execSQL("create index idx_category_userTradingEntityPOID on t_category(userTradingEntityPOID);");
    this.a.execSQL("create index idx_category_parentCategoryPOID on t_category(parentCategoryPOID);");
    this.a.execSQL("create index idx_deleted_category_userTradingEntityPOID on t_deleted_category(userTradingEntityPOID);");
    this.a.execSQL("create index idx_deleted_category_parentCategoryPOID on t_deleted_category(parentCategoryPOID);");
    this.a.execSQL("create index idx_tradeItem_categoryPOID on t_tradeItem(categoryPOID);");
    this.a.execSQL("create index idx_deleted_tradeItem_categoryPOID on t_deleted_tradeItem(categoryPOID);");
    this.a.execSQL("create index idx_transaction_photoNeedUpload on t_transaction(relation);");
    this.a.execSQL("create index idx_deleted_transaction_photoNeedUpload on t_deleted_transaction(relation);");
    this.a.execSQL("drop view v_transaction_for_sync");
    this.a.execSQL(" create view v_transaction_for_sync as  select      transactionPOID,       createdTime,      modifiedTime,       tradeTime,       memo,       type,       relation,       creatorTradingEntityPOID,       modifierTradingEntityPOID,       buyerAccountPOID,       buyerTradingEntityPOID,      sellerAccountPOID,       sellerTradingEntityPOID,        photoName,      photoNeedUpload,     lastUpdateTime,       0 as deleted,       serverId     from       t_transaction  as trans  inner join       t_local_server_id_map as idMap on trans.transactionPOID = idMap.localId and idMap.ownerTable = 't_transaction'  union all select        transactionPOID,       createdTime,       modifiedTime,      tradeTime,       memo,       type,       relation,       creatorTradingEntityPOID,       modifierTradingEntityPOID,       buyerAccountPOID,       buyerTradingEntityPOID,       sellerAccountPOID,       sellerTradingEntityPOID,         photoName,     photoNeedUpload,     lastUpdateTime,      1 as deleted,        serverId  from      t_deleted_transaction  as trans  inner join   t_local_server_id_map as idMap on trans.transactionPOID = idMap.localId and idMap.ownerTable = 't_transaction'");
    this.a.execSQL("drop view v_tradeItem_for_sync");
    this.a.execSQL(" create view v_tradeItem_for_sync as  select         tradeItemPOID,        currencyType,        currencyValue,        name,        tradeItemType,        number,        categoryPOID,        transactionPOID,        lastUpdateTime,         0 as deleted,         serverId    from        t_tradeItem as  tradeItem    inner join        t_local_server_id_map as idMap on     tradeItem.tradeItemPOID = idMap.localId and idMap.ownerTable = 't_tradeItem'    union all    select         tradeItemPOID,        currencyType,        currencyValue,        name,        tradeItemType,        number,        categoryPOID,        transactionPOID,        lastUpdateTime,         1 as deleted,         serverId   from        t_deleted_tradeItem as  tradeItem   inner join        t_local_server_id_map as idMap on     tradeItem.tradeItemPOID = idMap.localId and idMap.ownerTable = 't_tradeItem'  ");
    this.a.execSQL("drop view v_account_for_sync");
    this.a.execSQL("create view [v_account_for_sync] as  select       account.accountPOID as accountPOID,      account.name as name,      account.lastUpdateTime as lastUpdateTime,      0 as deleted,      account.tradingEntityPOID as tradingEntityPOID,        account.accountGroupPOID as accountGroupPOID,        account.currencyType as currencyType,        account.memo as memo,        accountGroup.name as accountGroupName,      accountGroup.type as accountGroupType,      account.balance as balance,        idMap.serverId as serverId from       t_account as  account    inner join      t_account_group as accountGroup on account.accountGroupPOID = accountGroup.accountGroupPOID  inner join       t_local_server_id_map as idMap on account.accountPOID = idMap.localId and idMap.ownerTable = 't_account'  union all  select       account.accountPOID as accountPOID,      account.name as name,      account.lastUpdateTime as lastUpdateTime,      1 as deleted,      account.tradingEntityPOID as tradingEntityPOID,        account.accountGroupPOID as accountGroupPOID,        account.currencyType as currencyType,        account.memo as memo,        accountGroup.name as accountGroupName,      accountGroup.type as accountGroupType,      account.balance as balance,        idMap.serverId as serverId from       t_deleted_account as account  inner join      t_account_group as accountGroup on account.accountGroupPOID = accountGroup.accountGroupPOID  inner join      t_local_server_id_map as idMap on account.accountPOID = idMap.localId and idMap.ownerTable = 't_account' ");
    this.a.execSQL("drop view v_category_temp_for_sync");
    this.a.execSQL("create view [v_category_temp_for_sync] as  select      categoryPOID,      name,      parentCategoryPOID,      path,      depth,      type,      lastUpdateTime,      0 as deleted,      userTradingEntityPOID   from t_category  union  all  select      categoryPOID,      name,      parentCategoryPOID,      path,      depth,      type,      lastUpdateTime,      1 as deleted,      userTradingEntityPOID  from t_deleted_category");
    this.a.execSQL("drop view v_category_for_sync");
    this.a.execSQL("create view [v_category_for_sync] as  select      categoryPOID,      name,      parentCategoryPOID,      hasChildren,      path,      depth,      type,      lastUpdateTime,      deleted,      userTradingEntityPOID,      serverId  from      (select a.categoryPOID as categoryPOID,a.name as name,a.parentCategoryPOID as parentCategoryPOID,         a.path as path, a.depth as depth, a.type as type,a.lastUpdateTime as lastUpdateTime,         (case when b.categoryPOID is null then 0 else 1  end) hasChildren,a.deleted as deleted,          a.userTradingEntityPOID as userTradingEntityPOID      from v_category_temp_for_sync a       left  join v_category_temp_for_sync b      on(a.categoryPOID = b.parentCategoryPOID)      group by a.categoryPOID )  as category    inner join       t_local_server_id_map as idMap on category.categoryPOID = idMap.localId and idMap.ownerTable = 't_category'");
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ck
 * JD-Core Version:    0.6.0
 */