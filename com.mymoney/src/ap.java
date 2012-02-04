import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mymoney.core.application.ApplicationContext;
import java.util.ArrayList;
import java.util.List;

public class ap extends ar
  implements ac
{
  private static String a = " select     account.accountPOID as accountId,    account.name as accountName,    balance as accountBalance,     account.amountOfLiability as amountOfLiability,    account.amountOfCredit as amountOfCredit,     account.lastUpdateTime as accountLastUpdateTime,    account.tradingEntityPOID as accountTradingEntityPOID,     account.currencyType as accountCurrencyType,     account.ordered as ordered,     account.accountGroupPOID as accountGroupId,    account.memo as memo,    account.hidden as hidden,    secondLevelAccountGroup.name as accountGroupName ,    secondLevelAccountGroup.type as  accountGroupType,    firstLevelAccountGroup.accountGroupPOID as firstLevelAccountGroupId,    firstLevelAccountGroup.name as firstLevelAccountGroupName from t_account as account  inner join t_account_group as secondLevelAccountGroup on account.accountGroupPOID = secondLevelAccountGroup.accountGroupPOID inner join t_account_group as firstLevelAccountGroup on secondLevelAccountGroup.parentAccountGroupPOID = firstLevelAccountGroup.accountGroupPOID ";
  private static String c = " select  (case when sum(trans.sellerMoney) is null then 0 else sum(trans.sellerMoney) end) as amount,1 as joinFlag from t_transaction as trans ";
  private static String d;
  private static String e;
  private static String f;
  private static String g;

  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("select (amount1 + amount2 + amount3 - amount4 - amount5) as amount   from   (    select t1.amount as amount1,t2.amount as amount2,t3.amount as amount3,t4.amount as amount4,t5.amount as amount5     from      ( ");
    String str1 = c;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(" where trans.type = ").append(1).append(" and trans.sellerAccountPOID = ? ").append("     ) as t1 ").append("    inner join ").append("    ( ");
    String str2 = c;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append("  where trans.type = ").append(2).append(" and trans.sellerAccountPOID = ? ").append("     ) as t2 on t1.joinFlag  = t2.joinFlag ").append("    inner join ").append("    ( ");
    String str3 = c;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(str3).append("  where trans.type = ").append(8).append(" and trans.sellerAccountPOID = ? ").append("     ) as t3 on t2.joinFlag  = t3.joinFlag ").append("    inner join ").append("    ( ");
    String str4 = c;
    StringBuilder localStringBuilder5 = localStringBuilder4.append(str4).append("  where trans.type = ").append(0).append(" and trans.buyerAccountPOID = ?").append("     ) as t4 on t3.joinFlag  = t4.joinFlag ").append("    inner join ").append("    ( ");
    String str5 = c;
    d = str5 + "  where trans.type = " + 3 + " and trans.buyerAccountPOID = ?" + "     ) as t5 on t4.joinFlag  = t5.joinFlag  " + "   ) ";
    StringBuilder localStringBuilder6 = new StringBuilder().append("select (amount1 - amount2 + amount3) as amount  from    (    select t1.amount as amount1,t2.amount as amount2,t3.amount as amount3    from      ( ");
    String str6 = c;
    StringBuilder localStringBuilder7 = localStringBuilder6.append(str6).append(" where trans.type = ").append(4).append(" and trans.sellerAccountPOID = ?").append("     ) as t1 ").append("    inner join ").append("    ( ");
    String str7 = c;
    StringBuilder localStringBuilder8 = localStringBuilder7.append(str7).append("  where trans.type = ").append(7).append(" and trans.buyerAccountPOID = ?").append("     ) as t2 on t1.joinFlag  = t2.joinFlag ").append("    inner join ").append("    ( ");
    String str8 = c;
    e = str8 + "  where trans.type = " + 9 + " and trans.sellerAccountPOID = ? " + "     ) as t3 on t2.joinFlag  = t3.joinFlag " + "    )      ";
    StringBuilder localStringBuilder9 = new StringBuilder().append(" select (amount1 - amount2 + amount3) as amount   from    (    select t1.amount as amount1,t2.amount as amount2,t3.amount as amount3    from      ( ");
    String str9 = c;
    StringBuilder localStringBuilder10 = localStringBuilder9.append(str9).append(" where trans.type = ").append(5).append(" and trans.buyerAccountPOID = ?").append("     ) as t1 ").append("    inner join ").append("    ( ");
    String str10 = c;
    StringBuilder localStringBuilder11 = localStringBuilder10.append(str10).append("  where trans.type = ").append(6).append(" and trans.sellerAccountPOID = ?").append("     ) as t2 on t1.joinFlag  = t2.joinFlag ").append("    inner join ").append("    ( ");
    String str11 = c;
    f = str11 + "  where trans.type = " + 10 + " and trans.sellerAccountPOID = ? " + "     ) as t3 on t2.joinFlag  = t3.joinFlag " + "    )      ";
    StringBuilder localStringBuilder12 = new StringBuilder().append(" select (amount1 - amount2) as amount   from    (    select t1.amount as amount1,t2.amount as amount2     from      ( ");
    String str12 = c;
    StringBuilder localStringBuilder13 = localStringBuilder12.append(str12).append(" where trans.type = ").append(2).append(" and trans.sellerAccountPOID = ?").append("     ) as t1 ").append("    inner join ").append("    ( ");
    String str13 = c;
    g = str13 + "  where trans.type = " + 7 + " and trans.buyerAccountPOID = ?" + "     ) as t2 on t1.joinFlag  = t2.joinFlag " + "    )      ";
  }

  private eq b(Cursor paramCursor)
  {
    eq localeq = new eq();
    int i = paramCursor.getColumnIndex("accountId");
    long l1 = paramCursor.getLong(i);
    localeq.b(l1);
    int j = paramCursor.getColumnIndex("accountName");
    String str1 = paramCursor.getString(j);
    localeq.a(str1);
    int k = paramCursor.getColumnIndex("accountLastUpdateTime");
    long l2 = paramCursor.getLong(k);
    localeq.a(l2);
    int m = paramCursor.getColumnIndex("accountBalance");
    double d1 = paramCursor.getDouble(m);
    localeq.a(d1);
    int n = paramCursor.getColumnIndex("amountOfLiability");
    double d2 = paramCursor.getDouble(n);
    localeq.c(d2);
    int i1 = paramCursor.getColumnIndex("amountOfCredit");
    double d3 = paramCursor.getDouble(i1);
    localeq.b(d3);
    int i2 = paramCursor.getColumnIndex("accountCurrencyType");
    String str2 = paramCursor.getString(i2);
    localeq.b(str2);
    int i3 = paramCursor.getColumnIndex("ordered");
    int i4 = paramCursor.getInt(i3);
    localeq.a(i4);
    int i5 = paramCursor.getColumnIndex("memo");
    String str3 = gx.a(paramCursor.getString(i5));
    localeq.c(str3);
    int i6 = paramCursor.getColumnIndex("hidden");
    if (paramCursor.getInt(i6) == 1);
    int i8;
    for (int i7 = 1; ; i8 = 0)
    {
      localeq.a(i7);
      int i9 = paramCursor.getColumnIndex("accountGroupId");
      long l3 = paramCursor.getLong(i9);
      int i10 = paramCursor.getColumnIndex("accountGroupName");
      String str4 = paramCursor.getString(i10);
      int i11 = paramCursor.getColumnIndex("accountGroupType");
      int i12 = paramCursor.getInt(i11);
      int i13 = paramCursor.getColumnIndex("firstLevelAccountGroupId");
      long l4 = paramCursor.getLong(i13);
      int i14 = paramCursor.getColumnIndex("firstLevelAccountGroupName");
      String str5 = paramCursor.getString(i14);
      er localer = new er();
      localer.a(l3);
      localer.a(str4);
      localer.b(i12);
      localer.b(l4);
      localer.b(str5);
      localeq.a(localer);
      return localeq;
    }
  }

  public long a(eq parameq)
  {
    String str1 = dk.a;
    long l1 = c(str1);
    parameq.b(l1);
    int i = gt.b();
    parameq.a(i);
    try
    {
      String str2 = dk.a;
      long l2 = a(str2, parameq);
      return l1;
    }
    catch (ed localed)
    {
    }
    throw new ed(localed);
  }

  protected long a(String paramString, eq parameq)
  {
    long l1 = parameq.f();
    String str1 = parameq.g();
    long l2 = parameq.k().b();
    ContentValues localContentValues = new ContentValues();
    String str2 = dk.c;
    Long localLong1 = Long.valueOf(l1);
    localContentValues.put(str2, localLong1);
    String str3 = dk.d;
    localContentValues.put(str3, str1);
    String str4 = dk.e;
    Long localLong2 = Long.valueOf(ApplicationContext.d);
    localContentValues.put(str4, localLong2);
    String str5 = dk.f;
    String str6 = parameq.h();
    localContentValues.put(str5, str6);
    String str7 = dk.h;
    Double localDouble1 = Double.valueOf(parameq.b());
    localContentValues.put(str7, localDouble1);
    String str8 = dk.j;
    Double localDouble2 = Double.valueOf(parameq.c());
    localContentValues.put(str8, localDouble2);
    String str9 = dk.i;
    Double localDouble3 = Double.valueOf(parameq.d());
    localContentValues.put(str9, localDouble3);
    Integer localInteger1 = Integer.valueOf(parameq.l());
    localContentValues.put("ordered", localInteger1);
    String str10 = parameq.i();
    localContentValues.put("memo", str10);
    int i;
    if (parameq.j())
    {
      i = 1;
      Integer localInteger2 = Integer.valueOf(i);
      localContentValues.put("hidden", localInteger2);
      String str11 = dk.m;
      Long localLong3 = Long.valueOf(l2);
      localContentValues.put(str11, localLong3);
      if (parameq.e() <= 0L)
        break label325;
      String str12 = dk.l;
      Long localLong4 = Long.valueOf(parameq.e());
      localContentValues.put(str12, localLong4);
    }
    while (true)
    {
      if (b.a().insert(paramString, null, localContentValues) != 65535L)
        break label350;
      throw new ed("exception accur when  insert account");
      i = 0;
      break;
      label325: String str13 = dk.l;
      Long localLong5 = Long.valueOf(gt.f());
      localContentValues.put(str13, localLong5);
    }
    label350: return l1;
  }

  public eq a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = a;
    String str2 = str1 + " where account.accountPOID = ?";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    Cursor localCursor = b.a().rawQuery(str2, arrayOfString);
    for (eq localeq = null; localCursor.moveToNext(); localeq = b(localCursor));
    a(localCursor);
    return localeq;
  }

  public eq a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = a;
    String str2 = str1 + " where account.tradingEntityPOID = ? and account.name = ?";
    long l = ApplicationContext.d;
    String[] arrayOfString = new String[2];
    String str3 = String.valueOf(l);
    arrayOfString[0] = str3;
    arrayOfString[1] = paramString;
    Cursor localCursor = b.a().rawQuery(str2, arrayOfString);
    for (eq localeq = null; localCursor.moveToNext(); localeq = b(localCursor));
    a(localCursor);
    return localeq;
  }

  public eq a(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = a;
    String str2 = str1 + " where account.name = ? and account.accountGroupPOID = ?";
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString;
    String str3 = String.valueOf(paramLong);
    arrayOfString[1] = str3;
    Cursor localCursor = b.a().rawQuery(str2, arrayOfString);
    for (eq localeq = null; localCursor.moveToNext(); localeq = b(localCursor));
    a(localCursor);
    return localeq;
  }

  public List a(boolean paramBoolean)
  {
    String str1 = a;
    StringBuilder localStringBuilder1 = new StringBuilder(str1);
    if (paramBoolean)
      StringBuilder localStringBuilder2 = localStringBuilder1.append(" where hidden = 0");
    StringBuilder localStringBuilder3 = localStringBuilder1.append("  order by firstLevelAccountGroupName desc,ordered asc");
    SQLiteDatabase localSQLiteDatabase = b.a();
    String str2 = localStringBuilder1.toString();
    Cursor localCursor = localSQLiteDatabase.rawQuery(str2, null);
    int i = localCursor.getCount();
    ArrayList localArrayList = new ArrayList(i);
    while (localCursor.moveToNext())
    {
      eq localeq = b(localCursor);
      boolean bool = localArrayList.add(localeq);
    }
    a(localCursor);
    return localArrayList;
  }

  public boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("select * from t_account where currencyType <> '");
    String str1 = ApplicationContext.g;
    String str2 = str1 + "'";
    Cursor localCursor = g().rawQuery(str2, null);
    for (int i = 0; localCursor.moveToNext(); i = 1);
    return i;
  }

  public boolean a(long paramLong, double paramDouble)
  {
    ContentValues localContentValues = new ContentValues();
    String str1 = dk.h;
    Double localDouble = Double.valueOf(paramDouble);
    localContentValues.put(str1, localDouble);
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = dk.c;
    String str3 = str2 + " = ?";
    String[] arrayOfString = new String[1];
    String str4 = String.valueOf(paramLong);
    arrayOfString[0] = str4;
    SQLiteDatabase localSQLiteDatabase = b.a();
    String str5 = dk.a;
    if (localSQLiteDatabase.update(str5, localContentValues, str3, arrayOfString) > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean a(boolean paramBoolean, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = dk.c;
    String str2 = str1 + " = ?";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    ContentValues localContentValues = new ContentValues();
    int i;
    if (paramBoolean)
    {
      i = 1;
      Integer localInteger = Integer.valueOf(i);
      localContentValues.put("hidden", localInteger);
      String str4 = dk.l;
      Long localLong = Long.valueOf(gt.f());
      localContentValues.put(str4, localLong);
      SQLiteDatabase localSQLiteDatabase = g();
      String str5 = dk.a;
      if (localSQLiteDatabase.update(str5, localContentValues, str2, arrayOfString) <= 0)
        break label143;
    }
    label143: for (int j = 1; ; j = 0)
    {
      return j;
      i = 0;
      break;
    }
  }

  public boolean b(long paramLong)
  {
    String[] arrayOfString = new String[2];
    String str1 = String.valueOf(paramLong);
    arrayOfString[0] = str1;
    String str2 = String.valueOf(paramLong);
    arrayOfString[1] = str2;
    Cursor localCursor = b.a().rawQuery("select transactionPOID from  t_transaction  where buyerAccountPOID = ? or sellerAccountPOID = ?", arrayOfString);
    for (int i = 1; localCursor.moveToNext(); i = 0);
    a(localCursor);
    return i;
  }

  public boolean b(long paramLong, double paramDouble)
  {
    ContentValues localContentValues = new ContentValues();
    String str1 = dk.i;
    Double localDouble = Double.valueOf(paramDouble);
    localContentValues.put(str1, localDouble);
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = dk.c;
    String str3 = str2 + " = ?";
    String[] arrayOfString = new String[1];
    String str4 = String.valueOf(paramLong);
    arrayOfString[0] = str4;
    SQLiteDatabase localSQLiteDatabase = b.a();
    String str5 = dk.a;
    if (localSQLiteDatabase.update(str5, localContentValues, str3, arrayOfString) > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean b(eq parameq)
  {
    long l1 = parameq.f();
    String str1 = parameq.g();
    String str2 = parameq.i();
    String str3 = parameq.h();
    long l2 = parameq.k().b();
    StringBuilder localStringBuilder = new StringBuilder();
    String str4 = dk.c;
    String str5 = str4 + " = ?";
    String[] arrayOfString = new String[1];
    String str6 = String.valueOf(l1);
    arrayOfString[0] = str6;
    ContentValues localContentValues = new ContentValues();
    String str7 = dk.d;
    localContentValues.put(str7, str1);
    localContentValues.put("memo", str2);
    String str8 = dk.f;
    localContentValues.put(str8, str3);
    String str9 = dk.m;
    Long localLong1 = Long.valueOf(l2);
    localContentValues.put(str9, localLong1);
    String str10 = dk.l;
    Long localLong2 = Long.valueOf(gt.f());
    localContentValues.put(str10, localLong2);
    int i;
    if (parameq.j())
    {
      i = 1;
      Integer localInteger = Integer.valueOf(i);
      localContentValues.put("hidden", localInteger);
    }
    while (true)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = b.a();
        String str11 = dk.a;
        int j = localSQLiteDatabase.update(str11, localContentValues, str5, arrayOfString);
        if (j > 0)
        {
          k = 1;
          return k;
          i = 0;
        }
      }
      catch (Exception localException)
      {
        throw new ed(localException);
      }
      int k = 0;
    }
  }

  public boolean c(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = dk.c;
    String str2 = str1 + "=?";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    while (true)
    {
      try
      {
        b.a().beginTransaction();
        eq localeq = a(paramLong);
        long l1 = gt.f();
        localeq.a(l1);
        String str4 = dk.b;
        long l2 = a(str4, localeq);
        SQLiteDatabase localSQLiteDatabase = b.a();
        String str5 = dk.a;
        int i = localSQLiteDatabase.delete(str5, str2, arrayOfString);
        b.a().setTransactionSuccessful();
        b.a().endTransaction();
        if (i > 0)
        {
          j = 1;
          return j;
        }
      }
      finally
      {
        b.a().endTransaction();
      }
      int j = 0;
    }
  }

  public boolean c(long paramLong, double paramDouble)
  {
    ContentValues localContentValues = new ContentValues();
    String str1 = dk.j;
    Double localDouble = Double.valueOf(paramDouble);
    localContentValues.put(str1, localDouble);
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = dk.c;
    String str3 = str2 + " = ?";
    String[] arrayOfString = new String[1];
    String str4 = String.valueOf(paramLong);
    arrayOfString[0] = str4;
    SQLiteDatabase localSQLiteDatabase = b.a();
    String str5 = dk.a;
    if (localSQLiteDatabase.update(str5, localContentValues, str3, arrayOfString) > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public double d(long paramLong)
  {
    int i = a(paramLong).k().i();
    Object localObject1;
    Object localObject2;
    if (i == 0)
    {
      String str1 = d;
      String[] arrayOfString1 = new String[5];
      String str2 = String.valueOf(paramLong);
      arrayOfString1[0] = str2;
      String str3 = String.valueOf(paramLong);
      arrayOfString1[1] = str3;
      String str4 = String.valueOf(paramLong);
      arrayOfString1[2] = str4;
      String str5 = String.valueOf(paramLong);
      arrayOfString1[3] = str5;
      String str6 = String.valueOf(paramLong);
      arrayOfString1[4] = str6;
      String[] arrayOfString2 = arrayOfString1;
      localObject1 = str1;
      localObject2 = arrayOfString2;
    }
    Cursor localCursor;
    double d1;
    while (true)
    {
      localCursor = b.a().rawQuery((String)localObject1, localObject2);
      long l = 0L;
      while (true)
        if (localCursor.moveToNext())
        {
          int j = localCursor.getColumnIndex("amount");
          d1 = localCursor.getDouble(j);
          continue;
          if (1 == i)
          {
            String str7 = g;
            String[] arrayOfString3 = new String[2];
            String str8 = String.valueOf(paramLong);
            arrayOfString3[0] = str8;
            String str9 = String.valueOf(paramLong);
            arrayOfString3[1] = str9;
            String[] arrayOfString4 = arrayOfString3;
            localObject1 = str7;
            localObject2 = arrayOfString4;
            break;
          }
          throw new RuntimeException("unknown support type exception,this account type hasn't balance");
        }
    }
    a(localCursor);
    return d1;
  }

  public double e(long paramLong)
  {
    String str1 = e;
    SQLiteDatabase localSQLiteDatabase = b.a();
    String[] arrayOfString = new String[3];
    String str2 = String.valueOf(paramLong);
    arrayOfString[0] = str2;
    String str3 = String.valueOf(paramLong);
    arrayOfString[1] = str3;
    String str4 = String.valueOf(paramLong);
    arrayOfString[2] = str4;
    Cursor localCursor = localSQLiteDatabase.rawQuery(str1, arrayOfString);
    long l = 0L;
    double d1;
    while (localCursor.moveToNext())
    {
      int i = localCursor.getColumnIndex("amount");
      d1 = localCursor.getDouble(i);
    }
    a(localCursor);
    return d1;
  }

  public double f(long paramLong)
  {
    String str1 = f;
    SQLiteDatabase localSQLiteDatabase = b.a();
    String[] arrayOfString = new String[3];
    String str2 = String.valueOf(paramLong);
    arrayOfString[0] = str2;
    String str3 = String.valueOf(paramLong);
    arrayOfString[1] = str3;
    String str4 = String.valueOf(paramLong);
    arrayOfString[2] = str4;
    Cursor localCursor = localSQLiteDatabase.rawQuery(str1, arrayOfString);
    long l = 0L;
    double d1;
    while (localCursor.moveToNext())
    {
      int i = localCursor.getColumnIndex("amount");
      d1 = localCursor.getDouble(i);
    }
    a(localCursor);
    return d1;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ap
 * JD-Core Version:    0.6.0
 */