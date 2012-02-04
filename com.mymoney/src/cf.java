import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mymoney.core.application.ApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cf extends bt
{
  String b = " select categoryPOID,name,parentCategoryPOID,hasChildren,path,depth,lastUpdateTime,userTradingEntityPOID,_tempIconName,type from   (select a.categoryPOID as categoryPOID , a.name as name , a.parentCategoryPOID as  parentCategoryPOID,     a.path as path, a.depth as depth, a.lastUpdateTime as lastUpdateTime,     (case when b.categoryPOID is null then 0 else 1  end) hasChildren ,     a.userTradingEntityPOID as userTradingEntityPOID,a._tempIconName as  _tempIconName,a.type as type   from t_category a     left  join    t_category b on(a.categoryPOID = b.parentCategoryPOID)   group by a.categoryPOID )";

  private long a(cx paramcx, int paramInt, boolean paramBoolean)
  {
    String str1 = cp.a;
    long l = c(str1);
    if (paramBoolean)
      l = Math.abs(l);
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str2 = cp.c;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append(l);
    String str3 = cp.c;
    String str4 = str3;
    paramcx.b(l);
    paramcx.a(0L);
    paramcx.a(str4);
    paramcx.b(0);
    paramcx.b("default_root_category_icon");
    paramcx.a(paramInt);
    String str5 = cp.a;
    a(str5, paramcx);
    return l;
  }

  private long b(int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.a;
    String[] arrayOfString = new String[2];
    String str1 = String.valueOf(ApplicationContext.d);
    arrayOfString[0] = str1;
    String str2 = String.valueOf(paramInt);
    arrayOfString[1] = str2;
    Cursor localCursor = localSQLiteDatabase.rawQuery("select categoryPOID from t_category where depth = 0 and userTradingEntityPOID = ? and type = ?", arrayOfString);
    long l = 0L;
    while (localCursor.moveToNext())
    {
      int i = localCursor.getColumnIndex("categoryPOID");
      l = localCursor.getLong(i);
    }
    a(localCursor);
    return l;
  }

  private long b(cx paramcx, int paramInt, boolean paramBoolean)
  {
    long l = b(paramInt);
    return a(l, paramcx, paramBoolean);
  }

  private cx b(Cursor paramCursor)
  {
    cx localcx = new cx();
    int i = paramCursor.getColumnIndex("categoryPOID");
    long l1 = paramCursor.getLong(i);
    localcx.b(l1);
    int j = paramCursor.getColumnIndex("name");
    String str1 = paramCursor.getString(j);
    localcx.c(str1);
    int k = paramCursor.getColumnIndex("parentCategoryPOID");
    long l2 = paramCursor.getLong(k);
    localcx.a(l2);
    int m = paramCursor.getColumnIndex("path");
    String str2 = paramCursor.getString(m);
    localcx.a(str2);
    int n = paramCursor.getColumnIndex("depth");
    int i1 = paramCursor.getInt(n);
    localcx.b(i1);
    int i2 = paramCursor.getColumnIndex("lastUpdateTime");
    long l3 = paramCursor.getLong(i2);
    localcx.c(l3);
    int i3 = paramCursor.getColumnIndex("_tempIconName");
    String str3 = paramCursor.getString(i3);
    localcx.b(str3);
    int i4 = paramCursor.getColumnIndex("type");
    int i5 = paramCursor.getInt(i4);
    localcx.a(i5);
    int i6 = paramCursor.getColumnIndex("hasChildren");
    if (paramCursor.getInt(i6) == 1);
    int i8;
    for (int i7 = 1; ; i8 = 0)
    {
      localcx.a(i7);
      return localcx;
    }
  }

  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    cf localcf = new cf();
    localcf.a(paramSQLiteDatabase);
    return localcf.a();
  }

  public long a(long paramLong, cx paramcx, boolean paramBoolean)
  {
    cx localcx = a(paramLong);
    int i = localcx.d();
    String str1 = localcx.c();
    String str2 = cp.a;
    long l1 = c(str2);
    if (paramBoolean != null)
      l1 = Math.abs(l1);
    StringBuilder localStringBuilder = new StringBuilder().append(str1).append(l1);
    String str3 = cp.c;
    String str4 = str3;
    int j = i + 1;
    int k = localcx.b();
    paramcx.b(l1);
    paramcx.a(paramLong);
    paramcx.a(str4);
    paramcx.b(j);
    paramcx.a(k);
    String str5 = cp.a;
    a(str5, paramcx);
    long l2 = c;
    String str6 = cp.a;
    a(l1, l2, str6);
    return l1;
  }

  public long a(cx paramcx)
  {
    return a(paramcx, 1, 1);
  }

  public cx a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = this.b;
    String str2 = str1 + " where categoryPOID = ?";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    Cursor localCursor = this.a.rawQuery(str2, arrayOfString);
    for (cx localcx = null; localCursor.moveToNext(); localcx = b(localCursor));
    a(localCursor);
    return localcx;
  }

  protected void a(String paramString, cx paramcx)
  {
    ContentValues localContentValues = new ContentValues();
    String str1 = cp.d;
    Long localLong1 = Long.valueOf(paramcx.f());
    localContentValues.put(str1, localLong1);
    String str2 = cp.e;
    String str3 = paramcx.g();
    localContentValues.put(str2, str3);
    String str4 = cp.f;
    Long localLong2 = Long.valueOf(paramcx.a());
    localContentValues.put(str4, localLong2);
    String str5 = cp.g;
    String str6 = paramcx.c();
    localContentValues.put(str5, str6);
    if (paramcx.h() > 0L)
    {
      String str7 = cp.i;
      Long localLong3 = Long.valueOf(paramcx.h());
      localContentValues.put(str7, localLong3);
    }
    while (true)
    {
      String str8 = cp.h;
      Integer localInteger1 = Integer.valueOf(paramcx.d());
      localContentValues.put(str8, localInteger1);
      String str9 = cp.j;
      Long localLong4 = Long.valueOf(ApplicationContext.d);
      localContentValues.put(str9, localLong4);
      String str10 = cp.k;
      String str11 = paramcx.e();
      localContentValues.put(str10, str11);
      String str12 = cp.l;
      Integer localInteger2 = Integer.valueOf(paramcx.b());
      localContentValues.put(str12, localInteger2);
      long l = this.a.insert(paramString, null, localContentValues);
      return;
      String str13 = cp.i;
      Long localLong5 = Long.valueOf(gt.f());
      localContentValues.put(str13, localLong5);
    }
  }

  public boolean a()
  {
    gj.a("DatabaseUpgrade3", "upgrade database to Version3");
    this.a.execSQL("alter table t_account add column usedCount integer default 0");
    this.a.execSQL("alter table t_tradingEntity add column usedCount integer default 0");
    this.a.execSQL("alter table t_category add column usedCount integer default 0");
    this.a.execSQL("alter table t_profile add column defaultIncomeCategoryPOID long default 0");
    this.a.execSQL("alter table t_profile add column defaultProjectCategoryPOID long default 0");
    this.a.execSQL("create table t_account_group (  accountGroupPOID long not null,  name varchar(100) not null,  parentAccountGroupPOID long not null,  path varchar(200),  depth integer,  lastUpdateTime long,  userTradingEntityPOID long,  _tempIconName varchar(100) default defaultAccountGroupIcon,  primary key (accountGroupPOID))");
    this.a.execSQL("alter table t_account add column accountGroupPOID integer");
    this.a.execSQL("alter table t_account add column balance decimal(12, 2) default 0");
    this.a.execSQL("alter table t_deleted_account add column accountGroupPOID integer");
    this.a.execSQL("alter table t_deleted_account add column balance decimal(12, 2) default 0");
    this.a.execSQL("insert into t_id_seed(tableName,idSeed) values('t_account_group','1')");
    this.a.execSQL("drop view v_account_for_sync");
    this.a.execSQL("create view [v_account_for_sync] as  select       account.accountPOID as accountPOID,      account.name as name,      account.lastUpdateTime as lastUpdateTime,      0 as deleted,      account.tradingEntityPOID as tradingEntityPOID,        account.accountGroupPOID as accountGroupPOID,        accountGroup.name as accountGroupName,      account.balance as balance,        idMap.serverId as serverId from       t_account as  account    left join      t_account_group as accountGroup on account.accountGroupPOID = accountGroup.accountGroupPOID  left join       t_local_server_id_map as idMap on account.accountPOID = idMap.localId and idMap.ownerTable = 't_account'  union   select       account.accountPOID as accountPOID,      account.name as name,      account.lastUpdateTime as lastUpdateTime,      1 as deleted,      account.tradingEntityPOID as tradingEntityPOID,        account.accountGroupPOID as accountGroupPOID,        accountGroup.name as accountGroupName,      account.balance as balance,        idMap.serverId as serverId from       t_deleted_account as account  left join      t_account_group as accountGroup on account.accountGroupPOID = accountGroup.accountGroupPOID  left join      t_local_server_id_map as idMap on account.accountPOID = idMap.localId and idMap.ownerTable = 't_account' ");
    this.a.execSQL("drop view v_transaction_for_sync");
    this.a.execSQL(" create view v_transaction_for_sync as  select      transactionPOID,       createdTime,      modifiedTime,       tradeTime,       memo,       type,       creatorTradingEntityPOID,       modifierTradingEntityPOID,       buyerAccountPOID,       buyerTradingEntityPOID,      sellerAccountPOID,       sellerTradingEntityPOID,        photoName,      photoNeedUpload,     lastUpdateTime,       0 as deleted,       serverId     from       t_transaction  as trans  left join       t_local_server_id_map as idMap on trans.transactionPOID = idMap.localId and idMap.ownerTable = 't_transaction'  union  select        transactionPOID,       createdTime,       modifiedTime,      tradeTime,       memo,       type,       creatorTradingEntityPOID,       modifierTradingEntityPOID,       buyerAccountPOID,       buyerTradingEntityPOID,       sellerAccountPOID,       sellerTradingEntityPOID,         photoName,     photoNeedUpload,     lastUpdateTime,      1 as deleted,        serverId  from      t_deleted_transaction  as trans  left join   t_local_server_id_map as idMap on trans.transactionPOID = idMap.localId and idMap.ownerTable = 't_transaction'");
    ArrayList localArrayList1 = new ArrayList();
    boolean bool1 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(1,'root',0,'/0001/',0,1289876493701,3)");
    boolean bool2 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(2,'现金',1,'/0001/0002/',1,1289876493701,3)");
    boolean bool3 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(3,'现金口袋',2,'/0001/0002/0003/',2,1289876493701,3)");
    boolean bool4 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(4,'金融账户',1,'/0001/0004/',1,1289876493701,3)");
    boolean bool5 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(5,'银行卡',4,'/0001/0004/0005/',2,1289876493701,3)");
    boolean bool6 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(6,'存折',4,'/0001/0004/0006/',2,1289876493701,3)");
    boolean bool7 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(7,'理财产品',4,'/0001/0004/0007/',2,1289876493701,3)");
    boolean bool8 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(8,'虚拟账户',1,'/0001/0008/',1,1289876493701,3)");
    boolean bool9 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(9,'在线支付',8,'/0001/0008/0009/',2,1289876493701,3)");
    boolean bool10 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(10,'现金券',8,'/0001/0008/0010/',2,1289876493701,3)");
    boolean bool11 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(11,'储值卡',8,'/0001/0008/0011/',2,1289876493701,3)");
    boolean bool12 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(12,'负债',1,'/0001/0012/',1,1289876493701,3)");
    boolean bool13 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(13,'应付款项',12,'/0001/0012/0013/',2,1289876493701,3)");
    boolean bool14 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(14,'信用卡',12,'/0001/0012/0014/',2,1289876493701,3)");
    boolean bool15 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(15,'债权',1,'/0001/0015/',1,1289876493701,3)");
    boolean bool16 = localArrayList1.add("insert into t_account_group(accountGroupPOID,name,parentAccountGroupPOID,path,depth,lastUpdateTime,userTradingEntityPOID) values(16,'应收款项',15,'/0001/0015/0016/',2,1289876493701,3)");
    he.a(localArrayList1, 1);
    Cursor localCursor = this.a.rawQuery("select accountPOID,name from t_account", null);
    int i = localCursor.getCount();
    ArrayList localArrayList2 = new ArrayList(i);
    while (localCursor.moveToNext())
    {
      cu localcu1 = new cu();
      int j = localCursor.getColumnIndex("accountPOID");
      long l1 = localCursor.getLong(j);
      localcu1.a(l1);
      int k = localCursor.getColumnIndex("name");
      String str1 = localCursor.getString(k);
      localcu1.a(str1);
      boolean bool17 = localArrayList2.add(localcu1);
    }
    localCursor.close();
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator = localArrayList2.iterator();
    if (localIterator.hasNext())
    {
      cu localcu2 = (cu)localIterator.next();
      String str2 = localcu2.b();
      if (str2.indexOf("信用卡") != -1)
      {
        cv localcv1 = new cv();
        localcv1.a(14L);
        localcu2.a(localcv1);
      }
      while (true)
      {
        StringBuilder localStringBuilder1 = new StringBuilder().append(" update ");
        String str3 = cm.a;
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str3).append(" set ");
        String str4 = cm.d;
        StringBuilder localStringBuilder3 = localStringBuilder2.append(str4).append(" = '");
        String str5 = localcu2.b();
        StringBuilder localStringBuilder4 = localStringBuilder3.append(str5).append("',");
        String str6 = cm.l;
        StringBuilder localStringBuilder5 = localStringBuilder4.append(str6).append(" = ");
        long l2 = localcu2.c().a();
        StringBuilder localStringBuilder6 = localStringBuilder5.append(l2).append(" where ");
        String str7 = cm.c;
        StringBuilder localStringBuilder7 = localStringBuilder6.append(str7).append(" = ");
        long l3 = localcu2.a();
        String str8 = l3;
        this.a.execSQL(str8);
        break;
        if ((str2.indexOf("银行") != -1) || (str2.indexOf("银行卡") != -1))
        {
          cv localcv2 = new cv();
          localcv2.a(5L);
          localcu2.a(localcv2);
          continue;
        }
        if ((str2.indexOf("公交卡") != -1) || (str2.indexOf("饭卡") != -1))
        {
          cv localcv3 = new cv();
          localcv3.a(11L);
          localcu2.a(localcv3);
          continue;
        }
        if (str2.indexOf("支付宝") != -1)
        {
          cv localcv4 = new cv();
          localcv4.a(9L);
          localcu2.a(localcv4);
          continue;
        }
        if (str2.indexOf("财富通") != -1)
        {
          cv localcv5 = new cv();
          localcv5.a(9L);
          localcu2.a("财付通");
          localcu2.a(localcv5);
          continue;
        }
        cv localcv6 = new cv();
        localcv6.a(3L);
        localcu2.a(localcv6);
      }
    }
    this.a.execSQL("alter table t_category add  column type integer default 0");
    this.a.execSQL("alter table t_deleted_category add column type integer default 0");
    this.a.execSQL("drop view v_category_temp_for_sync");
    this.a.execSQL("create view [v_category_temp_for_sync] as  select      categoryPOID,      name,      parentCategoryPOID,      path,      depth,      type,      lastUpdateTime,      0 as deleted,      userTradingEntityPOID   from t_category  union   select      categoryPOID,      name,      parentCategoryPOID,      path,      depth,      type,      lastUpdateTime,      1 as deleted,      userTradingEntityPOID  from t_deleted_category");
    this.a.execSQL("drop view v_category_for_sync");
    this.a.execSQL("create view [v_category_for_sync] as  select      categoryPOID,      name,      parentCategoryPOID,      hasChildren,      path,      depth,      type,      lastUpdateTime,      deleted,      userTradingEntityPOID,      serverId  from      (select a.categoryPOID as categoryPOID,a.name as name,a.parentCategoryPOID as parentCategoryPOID,      a.path as path, a.depth as depth, a.type as type,a.lastUpdateTime as lastUpdateTime,      (case when b.categoryPOID is null then 0 else 1  end) hasChildren,a.deleted as deleted,      a.userTradingEntityPOID as userTradingEntityPOID  from v_category_temp_for_sync a       left  join v_category_temp_for_sync b      on(a.categoryPOID = b.parentCategoryPOID)      group by a.categoryPOID )  as category    left join       t_local_server_id_map as idMap on category.categoryPOID = idMap.localId and idMap.ownerTable = 't_category'");
    cx localcx1 = new cx();
    localcx1.c("incomeRoot");
    cf localcf1 = this;
    cx localcx2 = localcx1;
    long l4 = localcf1.a(localcx2);
    String[] arrayOfString1 = new String[2];
    arrayOfString1[0] = "职业收入";
    arrayOfString1[1] = "其他收入";
    String[] arrayOfString2 = new String[2];
    arrayOfString2[0] = "icon_zysr";
    arrayOfString2[1] = "icon_qtsr";
    String[] arrayOfString3 = new String[2];
    String[] arrayOfString4 = new String[6];
    arrayOfString4[0] = "工资收入";
    arrayOfString4[1] = "利息收入";
    arrayOfString4[2] = "加班收入";
    arrayOfString4[3] = "奖金收入";
    arrayOfString4[4] = "投资收入";
    arrayOfString4[5] = "兼职收入";
    arrayOfString3[0] = arrayOfString4;
    String[] arrayOfString5 = new String[4];
    arrayOfString5[0] = "礼金收入";
    arrayOfString5[1] = "中奖收入";
    arrayOfString5[2] = "意外来钱";
    arrayOfString5[3] = "经营所得";
    arrayOfString3[1] = arrayOfString5;
    String[] arrayOfString6 = new String[2];
    String[] arrayOfString7 = new String[6];
    arrayOfString7[0] = "icon_zysr_gzsr";
    arrayOfString7[1] = "icon_zysr_lxsr";
    arrayOfString7[2] = "icon_zysr_jbsr";
    arrayOfString7[3] = "icon_zysr_jjsr";
    arrayOfString7[4] = "icon_zysr_tzsr";
    arrayOfString7[5] = "icon_zysr_jzsr";
    arrayOfString6[0] = arrayOfString7;
    String[] arrayOfString8 = new String[4];
    arrayOfString8[0] = "icon_qtsr_ljsr";
    arrayOfString8[1] = "icon_qtsr_zjsr";
    arrayOfString8[2] = "icon_qtsr_ywlq";
    arrayOfString8[3] = "icon_qtsr_jysd";
    arrayOfString6[1] = arrayOfString8;
    int m = arrayOfString1.length;
    int n = 0;
    int i1 = 0;
    int i2 = n;
    while (i2 < m)
    {
      String str9 = arrayOfString1[i2];
      cx localcx3 = new cx();
      localcx3.c(str9);
      String str10 = arrayOfString2[i1];
      localcx3.b(str10);
      cf localcf2 = this;
      cx localcx4 = localcx3;
      long l5 = localcf2.c(localcx4);
      String str11 = arrayOfString3[i1];
      int i3 = str11.length;
      int i4 = 0;
      int i5 = 0;
      int i6 = i4;
      while (true)
      {
        int i7 = i6;
        int i8 = i3;
        if (i7 >= i8)
          break;
        Object localObject1 = str11[i6];
        cx localcx5 = new cx();
        cx localcx6 = localcx5;
        Object localObject2 = localObject1;
        localcx6.c(localObject2);
        Object localObject3 = arrayOfString6[i1][i5];
        cx localcx7 = localcx5;
        Object localObject4 = localObject3;
        localcx7.b(localObject4);
        cf localcf3 = this;
        long l6 = l5;
        cx localcx8 = localcx5;
        int i9 = 1;
        long l7 = localcf3.a(l6, localcx8, i9);
        i5 += 1;
        i6 += 1;
      }
      i1 += 1;
      i2 += 1;
    }
    cx localcx9 = new cx();
    localcx9.c("projectRoot");
    localcx9.a(2);
    cf localcf4 = this;
    cx localcx10 = localcx9;
    long l8 = localcf4.b(localcx10);
    this.a.execSQL("update t_transaction set type = 0");
    this.a.execSQL("create table t_sync_logs (  syncTime long not null,  memo varchar(100) not null)");
    return true;
  }

  public long b(cx paramcx)
  {
    return a(paramcx, 2, 1);
  }

  public long c(cx paramcx)
  {
    return b(paramcx, 1, 1);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     cf
 * JD-Core Version:    0.6.0
 */