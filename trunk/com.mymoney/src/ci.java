import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ci extends bt
{
  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    ci localci = new ci();
    localci.a(paramSQLiteDatabase);
    return localci.a();
  }

  public boolean a()
  {
    gj.a("DatabaseUpgrade6", "upgrade database to Version6");
    this.a.execSQL("alter table t_account add column currencyType varchar(50) default 'CNY'");
    this.a.execSQL("alter table t_account add column memo varchar(200)");
    this.a.execSQL("alter table t_deleted_account add column currencyType varchar(50) default 'CNY'");
    this.a.execSQL("alter table t_deleted_account add column memo varchar(200)");
    this.a.execSQL("create table t_exchange(    exchangePOID integer  primary key autoincrement,    sell  varchar(50) not null,    buy varchar(50) not null,    rate decimal(12,2) not null,    aotuRefresh integer default 1  );");
    this.a.execSQL("create index idx_exchange_buy on t_exchange(buy)");
    this.a.execSQL("alter table t_transaction add column relation varchar(200) default ''");
    this.a.execSQL("alter table t_deleted_transaction add column relation varchar(200)  default ''");
    this.a.execSQL("drop view v_transaction_for_sync");
    this.a.execSQL(" create view v_transaction_for_sync as  select      transactionPOID,       createdTime,      modifiedTime,       tradeTime,       memo,       type,       relation,       creatorTradingEntityPOID,       modifierTradingEntityPOID,       buyerAccountPOID,       buyerTradingEntityPOID,      sellerAccountPOID,       sellerTradingEntityPOID,        photoName,      photoNeedUpload,     lastUpdateTime,       0 as deleted,       serverId     from       t_transaction  as trans  left join       t_local_server_id_map as idMap on trans.transactionPOID = idMap.localId and idMap.ownerTable = 't_transaction'  union  select        transactionPOID,       createdTime,       modifiedTime,      tradeTime,       memo,       type,       relation,       creatorTradingEntityPOID,       modifierTradingEntityPOID,       buyerAccountPOID,       buyerTradingEntityPOID,       sellerAccountPOID,       sellerTradingEntityPOID,         photoName,     photoNeedUpload,     lastUpdateTime,      1 as deleted,        serverId  from      t_deleted_transaction  as trans  left join   t_local_server_id_map as idMap on trans.transactionPOID = idMap.localId and idMap.ownerTable = 't_transaction'");
    this.a.execSQL("alter table t_account_group add column type integer default 1");
    StringBuilder localStringBuilder1 = new StringBuilder().append(" select accountGroupPOID,name,path from ");
    String str1 = cn.a;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("  where depth = ");
    int i = cv.d;
    String str2 = i;
    Cursor localCursor = this.a.rawQuery(str2, null);
    int j = localCursor.getCount();
    ArrayList localArrayList = new ArrayList(j);
    while (localCursor.moveToNext())
    {
      cv localcv1 = new cv();
      int k = localCursor.getColumnIndex("accountGroupPOID");
      long l1 = localCursor.getLong(k);
      localcv1.a(l1);
      int m = localCursor.getColumnIndex("name");
      String str3 = localCursor.getString(m);
      localcv1.a(str3);
      int n = localCursor.getColumnIndex("path");
      String str4 = localCursor.getString(n);
      localcv1.b(str4);
      boolean bool = localArrayList.add(localcv1);
    }
    localCursor.close();
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator = localArrayList.iterator();
    if (localIterator.hasNext())
    {
      cv localcv2 = (cv)localIterator.next();
      long l2 = localcv2.a();
      String str5 = localcv2.b();
      String str6 = localcv2.c();
      String str7;
      int i2;
      if (str5.indexOf("现金") != -1)
      {
        int i1 = 1;
        str7 = "现金账户";
        i2 = i1;
      }
      while (true)
      {
        localContentValues.clear();
        String str8 = cn.d;
        localContentValues.put(str8, str7);
        SQLiteDatabase localSQLiteDatabase1 = this.a;
        String str9 = cn.a;
        StringBuilder localStringBuilder3 = new StringBuilder();
        String str10 = cn.c;
        String str11 = str10 + " = ?";
        String[] arrayOfString = new String[1];
        String str12 = String.valueOf(l2);
        arrayOfString[0] = str12;
        int i3 = localSQLiteDatabase1.update(str9, localContentValues, str11, arrayOfString);
        localContentValues.clear();
        String str13 = cn.h;
        Integer localInteger = Integer.valueOf(i2);
        localContentValues.put(str13, localInteger);
        SQLiteDatabase localSQLiteDatabase2 = this.a;
        String str14 = cn.a;
        String str15 = " path like '" + str6 + "%'";
        int i4 = localSQLiteDatabase2.update(str14, localContentValues, str15, null);
        break;
        if (str5.indexOf("负债") != -1)
        {
          int i5 = 2;
          str7 = "负债账户";
          i2 = i5;
          continue;
        }
        if (str5.indexOf("债权") != -1)
        {
          int i6 = 3;
          str7 = "债权账户";
          i2 = i6;
          continue;
        }
        int i7 = 1;
        str7 = str5;
        i2 = i7;
      }
    }
    this.a.execSQL("drop view v_account_for_sync");
    this.a.execSQL("create view [v_account_for_sync] as  select       account.accountPOID as accountPOID,      account.name as name,      account.lastUpdateTime as lastUpdateTime,      0 as deleted,      account.tradingEntityPOID as tradingEntityPOID,        account.accountGroupPOID as accountGroupPOID,        account.currencyType as currencyType,        account.memo as memo,        accountGroup.name as accountGroupName,      accountGroup.type as accountGroupType,      account.balance as balance,        idMap.serverId as serverId from       t_account as  account    left join      t_account_group as accountGroup on account.accountGroupPOID = accountGroup.accountGroupPOID  left join       t_local_server_id_map as idMap on account.accountPOID = idMap.localId and idMap.ownerTable = 't_account'  union   select       account.accountPOID as accountPOID,      account.name as name,      account.lastUpdateTime as lastUpdateTime,      1 as deleted,      account.tradingEntityPOID as tradingEntityPOID,        account.accountGroupPOID as accountGroupPOID,        account.currencyType as currencyType,        account.memo as memo,        accountGroup.name as accountGroupName,      accountGroup.type as accountGroupType,      account.balance as balance,        idMap.serverId as serverId from       t_deleted_account as account  left join      t_account_group as accountGroup on account.accountGroupPOID = accountGroup.accountGroupPOID  left join      t_local_server_id_map as idMap on account.accountPOID = idMap.localId and idMap.ownerTable = 't_account' ");
    this.a.execSQL("alter table t_profile add column defaultCurrencyCode varchar(10) default 'CNY'");
    this.a.execSQL(" create table t_currency(    currencyPOID integer  primary key autoincrement,    code  varchar(50) not null ,   name  varchar(50) not null ,   icon  varchar(50) not null default 'currency_icon_default' );");
    this.a.execSQL(" update t_account_group set type = 0 where name = 'root';");
    gu.a(gu.j, "");
    gu.a(gu.k, 0L);
    gu.a(gu.l, 0L);
    gu.a(gu.m, "");
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ci
 * JD-Core Version:    0.6.0
 */