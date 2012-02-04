import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mymoney.core.application.ApplicationContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class bq extends ar
  implements an
{
  public static String a = ",";
  public static String c = "/";
  public static String e = " sum( (case when exchange.rate is null then 1 else exchange.rate end) * trans.buyerMoney) as amount ";
  public static String f = "  (case when exchange.rate is null then 1 else exchange.rate end) * trans.buyerMoney ";
  protected static String g = "     (case          when trans.type  = 0 then buyerAccount.currencyType          when trans.type  = 1 then sellerAccount.currencyType         when trans.type  = 2 then sellerAccount.currencyType         when trans.type  = 3 then buyerAccount.currencyType         when trans.type  = 4 then sellerAccount.currencyType          when trans.type  = 5 then buyerAccount.currencyType          when trans.type  = 6 then sellerAccount.currencyType          when trans.type  = 7 then buyerAccount.currencyType          when trans.type  = 8 then sellerAccount.currencyType          when trans.type  = 9 then sellerAccount.currencyType          when trans.type  = 10 then sellerAccount.currencyType          else sellerAccount.currencyType        end) ";
  private static String k;
  public String d = " order by trans.tradeTime desc,trans.lastUpdateTime desc,trans.relation desc,trans.type asc";
  private final String h = " where trans.type in    (0,1,3,8,9,10)";
  private String i;
  private String j;

  static
  {
    StringBuilder localStringBuilder = new StringBuilder().append(" from t_transaction as trans    left join t_account as buyerAccount on trans.buyerAccountPOID = buyerAccount.accountPOID   left join t_account as sellerAccount on trans.sellerAccountPOID = sellerAccount.accountPOID   left join  (select sell,buy,rate from t_exchange where buy = ?) as exchange on  ( ");
    String str = g;
    k = str + " = exchange.sell) ";
  }

  public bq()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append(" select    trans.transactionPOID as id,    trans.tradeTime as tradeTime,    trans.createdTime as createdTime,   trans.modifiedTime as modifiedTime,   trans.memo as memo,   trans.type as type,   trans.relation as relation,   trans.photoName as photoName,    trans.photoNeedUpload as photoNeedUpload,   corp.tradingEntityPOID as corporationId,   corp.name as corporationName,    buyerAccount.accountPOID as buyerAccountId,   buyerAccount.name as buyerAccountName,     buyerAccount.currencyType as buyerAccountCurrencyType,     sellerAccount.accountPOID as sellerAccountId,     sellerAccount.name as sellerAccountName,     sellerAccount.currencyType as sellerAccountCurrencyType,     trans.sellerMoney as cost, ");
    String str1 = f;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(" as currencyCost,");
    String str2 = g;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(" as currencyType,").append("   category.categoryPOID as categoryId,").append("   category.name as categoryName,").append("   category._tempIconName as _tempIconName,").append("   projectCategory.tagPOID as projectCategoryId,").append("   projectCategory.name as projectCategoryName").append(" from t_transaction as trans   ").append(" left join ").append("   t_tradingEntity as corp ").append(" on trans.relationUnitPOID = corp.tradingEntityPOID ").append(" left join ").append("   t_account as buyerAccount ").append(" on trans.buyerAccountPOID = buyerAccount.accountPOID  ").append(" left join ").append("   t_account as sellerAccount ").append(" on trans.sellerAccountPOID = sellerAccount.accountPOID  ").append(" left join ").append("   t_transaction_projectcategory_map as transProjectCategoryMap ").append(" on trans.transactionPOID = transProjectCategoryMap.transactionPOID  ").append(" left join ").append("   t_tag as projectCategory ").append(" on transProjectCategoryMap.projectCategoryPOID = projectCategory.tagPOID  ").append(" left join ").append("   t_category as category  ").append(" on category.categoryPOID = ").append("    (case   ").append("       when trans.type  = ").append(0).append(" then trans.sellerCategoryPOID   ").append("       when trans.type  = ").append(1).append(" then trans.buyerCategoryPOID  ").append("       else trans.sellerCategoryPOID ").append("      end) ").append(" left join ").append(" (select sell,buy,rate from t_exchange where buy = ?) as exchange on  ( ");
    String str3 = g;
    String str4 = str3 + " = exchange.sell) ";
    this.i = str4;
    StringBuilder localStringBuilder4 = new StringBuilder();
    String str5 = this.i;
    String str6 = str5 + " where trans.type in    (0,1,3,8,9,10)";
    this.j = str6;
  }

  private long a(long paramLong, String paramString, String[] paramArrayOfString)
  {
    try
    {
      g().beginTransaction();
      i(paramLong);
      SQLiteDatabase localSQLiteDatabase1 = g();
      String str1 = dv.a;
      long l = localSQLiteDatabase1.delete(str1, paramString, paramArrayOfString);
      SQLiteDatabase localSQLiteDatabase2 = g();
      String str2 = dw.a;
      StringBuilder localStringBuilder = new StringBuilder();
      String str3 = dw.b;
      String str4 = str3 + " = ?";
      String[] arrayOfString = new String[1];
      String str5 = String.valueOf(paramLong);
      arrayOfString[0] = str5;
      int m = localSQLiteDatabase2.delete(str2, str4, arrayOfString);
      g().setTransactionSuccessful();
      return l;
    }
    finally
    {
      g().endTransaction();
    }
    throw localObject;
  }

  private String a(long paramLong1, long paramLong2, List paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramLong1 != 65535L)
    {
      String str1 = String.valueOf(paramLong1);
      boolean bool1 = paramList.add(str1);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(" and trans.tradeTime >= ? ");
    }
    if (paramLong2 != 65535L)
    {
      String str2 = String.valueOf(paramLong2);
      boolean bool2 = paramList.add(str2);
      StringBuilder localStringBuilder3 = localStringBuilder1.append(" and trans.tradeTime <= ? ");
    }
    return localStringBuilder1.toString();
  }

  private String a(long[] paramArrayOfLong, List paramList)
  {
    StringBuilder localStringBuilder;
    String str1;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      localStringBuilder = new StringBuilder().append(" and projectCategory.tagPOID in ");
      str1 = c(paramArrayOfLong, paramList);
    }
    for (String str2 = str1; ; str2 = "")
      return str2;
  }

  private List a(String paramString, String[] paramArrayOfString)
  {
    Cursor localCursor = g().rawQuery(paramString, paramArrayOfString);
    int m = localCursor.getCount();
    ArrayList localArrayList = new ArrayList(m);
    while (localCursor.moveToNext())
    {
      fb localfb = c(localCursor);
      boolean bool = localArrayList.add(localfb);
    }
    a(localCursor);
    return localArrayList;
  }

  private int b(Cursor paramCursor)
  {
    int n;
    for (int m = 0; paramCursor.moveToNext(); m = paramCursor.getInt(n))
      n = paramCursor.getColumnIndex("transCount");
    a(paramCursor);
    return m;
  }

  private String b(int paramInt, long paramLong1, long paramLong2)
  {
    long l1 = ha.c(paramLong1);
    long l2 = ha.c(paramLong2);
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = "  where trans.type = " + paramInt;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    StringBuilder localStringBuilder3 = localStringBuilder1.append("  and ");
    String str2 = "  trans.tradeTime >= " + l1;
    StringBuilder localStringBuilder4 = localStringBuilder1.append(str2);
    StringBuilder localStringBuilder5 = localStringBuilder1.append("  and ");
    String str3 = "  trans.tradeTime <= " + l2;
    StringBuilder localStringBuilder6 = localStringBuilder1.append(str3);
    return localStringBuilder1.toString();
  }

  private String b(long[] paramArrayOfLong, List paramList)
  {
    StringBuilder localStringBuilder;
    String str1;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      localStringBuilder = new StringBuilder().append(" and trans.relationUnitPOID in ");
      str1 = c(paramArrayOfLong, paramList);
    }
    for (String str2 = str1; ; str2 = "")
      return str2;
  }

  private fb c(Cursor paramCursor)
  {
    fb localfb1 = new fb();
    Cursor localCursor1 = paramCursor;
    String str1 = "id";
    int m = localCursor1.getColumnIndex(str1);
    Cursor localCursor2 = paramCursor;
    int n = m;
    long l1 = localCursor2.getLong(n);
    Cursor localCursor3 = paramCursor;
    String str2 = "tradeTime";
    int i1 = localCursor3.getColumnIndex(str2);
    Cursor localCursor4 = paramCursor;
    int i2 = i1;
    long l2 = localCursor4.getLong(i2);
    Cursor localCursor5 = paramCursor;
    String str3 = "createdTime";
    int i3 = localCursor5.getColumnIndex(str3);
    Cursor localCursor6 = paramCursor;
    int i4 = i3;
    long l3 = localCursor6.getLong(i4);
    Cursor localCursor7 = paramCursor;
    String str4 = "modifiedTime";
    int i5 = localCursor7.getColumnIndex(str4);
    Cursor localCursor8 = paramCursor;
    int i6 = i5;
    long l4 = localCursor8.getLong(i6);
    Cursor localCursor9 = paramCursor;
    String str5 = "memo";
    int i7 = localCursor9.getColumnIndex(str5);
    Cursor localCursor10 = paramCursor;
    int i8 = i7;
    String str6 = localCursor10.getString(i8);
    Cursor localCursor11 = paramCursor;
    String str7 = "type";
    int i9 = localCursor11.getColumnIndex(str7);
    Cursor localCursor12 = paramCursor;
    int i10 = i9;
    int i11 = localCursor12.getInt(i10);
    Cursor localCursor13 = paramCursor;
    String str8 = "relation";
    int i12 = localCursor13.getColumnIndex(str8);
    Cursor localCursor14 = paramCursor;
    int i13 = i12;
    String str9 = localCursor14.getString(i13);
    Cursor localCursor15 = paramCursor;
    String str10 = "photoName";
    int i14 = localCursor15.getColumnIndex(str10);
    Cursor localCursor16 = paramCursor;
    int i15 = i14;
    String str11 = localCursor16.getString(i15);
    Cursor localCursor17 = paramCursor;
    String str12 = "photoNeedUpload";
    int i16 = localCursor17.getColumnIndex(str12);
    Cursor localCursor18 = paramCursor;
    int i17 = i16;
    int i18 = localCursor18.getInt(i17);
    int i19 = fb.b;
    int i20 = i18;
    int i21 = i19;
    int i22;
    fa localfa1;
    eu localeu1;
    eq localeq1;
    eq localeq5;
    et localet1;
    if (i20 == i21)
    {
      i22 = 1;
      Cursor localCursor19 = paramCursor;
      String str13 = "corporationId";
      int i23 = localCursor19.getColumnIndex(str13);
      Cursor localCursor20 = paramCursor;
      int i24 = i23;
      long l5 = localCursor20.getLong(i24);
      Cursor localCursor21 = paramCursor;
      String str14 = "corporationName";
      int i25 = localCursor21.getColumnIndex(str14);
      Cursor localCursor22 = paramCursor;
      int i26 = i25;
      String str15 = localCursor22.getString(i26);
      Cursor localCursor23 = paramCursor;
      String str16 = "buyerAccountId";
      int i27 = localCursor23.getColumnIndex(str16);
      Cursor localCursor24 = paramCursor;
      int i28 = i27;
      long l6 = localCursor24.getLong(i28);
      Cursor localCursor25 = paramCursor;
      String str17 = "buyerAccountName";
      int i29 = localCursor25.getColumnIndex(str17);
      Cursor localCursor26 = paramCursor;
      int i30 = i29;
      String str18 = localCursor26.getString(i30);
      Cursor localCursor27 = paramCursor;
      String str19 = "buyerAccountCurrencyType";
      int i31 = localCursor27.getColumnIndex(str19);
      Cursor localCursor28 = paramCursor;
      int i32 = i31;
      String str20 = localCursor28.getString(i32);
      Cursor localCursor29 = paramCursor;
      String str21 = "sellerAccountId";
      int i33 = localCursor29.getColumnIndex(str21);
      Cursor localCursor30 = paramCursor;
      int i34 = i33;
      long l7 = localCursor30.getLong(i34);
      Cursor localCursor31 = paramCursor;
      String str22 = "sellerAccountName";
      int i35 = localCursor31.getColumnIndex(str22);
      Cursor localCursor32 = paramCursor;
      int i36 = i35;
      String str23 = localCursor32.getString(i36);
      Cursor localCursor33 = paramCursor;
      String str24 = "sellerAccountCurrencyType";
      int i37 = localCursor33.getColumnIndex(str24);
      Cursor localCursor34 = paramCursor;
      int i38 = i37;
      String str25 = localCursor34.getString(i38);
      Cursor localCursor35 = paramCursor;
      String str26 = "projectCategoryId";
      int i39 = localCursor35.getColumnIndex(str26);
      Cursor localCursor36 = paramCursor;
      int i40 = i39;
      long l8 = localCursor36.getLong(i40);
      Cursor localCursor37 = paramCursor;
      String str27 = "projectCategoryName";
      int i41 = localCursor37.getColumnIndex(str27);
      Cursor localCursor38 = paramCursor;
      int i42 = i41;
      String str28 = localCursor38.getString(i42);
      Cursor localCursor39 = paramCursor;
      String str29 = "cost";
      int i43 = localCursor39.getColumnIndex(str29);
      Cursor localCursor40 = paramCursor;
      int i44 = i43;
      double d1 = localCursor40.getDouble(i44);
      Cursor localCursor41 = paramCursor;
      String str30 = "currencyCost";
      int i45 = localCursor41.getColumnIndex(str30);
      Cursor localCursor42 = paramCursor;
      int i46 = i45;
      double d2 = localCursor42.getDouble(i46);
      Cursor localCursor43 = paramCursor;
      String str31 = "currencyType";
      int i47 = localCursor43.getColumnIndex(str31);
      Cursor localCursor44 = paramCursor;
      int i48 = i47;
      String str32 = localCursor44.getString(i48);
      Cursor localCursor45 = paramCursor;
      String str33 = "categoryId";
      int i49 = localCursor45.getColumnIndex(str33);
      Cursor localCursor46 = paramCursor;
      int i50 = i49;
      long l9 = localCursor46.getLong(i50);
      Cursor localCursor47 = paramCursor;
      String str34 = "categoryName";
      int i51 = localCursor47.getColumnIndex(str34);
      Cursor localCursor48 = paramCursor;
      int i52 = i51;
      String str35 = localCursor48.getString(i52);
      Cursor localCursor49 = paramCursor;
      String str36 = "_tempIconName";
      int i53 = localCursor49.getColumnIndex(str36);
      Cursor localCursor50 = paramCursor;
      int i54 = i53;
      String str37 = localCursor50.getString(i54);
      localfa1 = new fa();
      fa localfa2 = localfa1;
      long l10 = l8;
      localfa2.a(l10);
      fa localfa3 = localfa1;
      String str38 = str28;
      localfa3.a(str38);
      localeu1 = new eu();
      eu localeu2 = localeu1;
      long l11 = l5;
      localeu2.a(l11);
      eu localeu3 = localeu1;
      String str39 = str15;
      localeu3.a(str39);
      localeq1 = new eq();
      eq localeq2 = localeq1;
      long l12 = l7;
      localeq2.b(l12);
      eq localeq3 = localeq1;
      String str40 = str23;
      localeq3.a(str40);
      eq localeq4 = localeq1;
      String str41 = str25;
      localeq4.b(str41);
      localeq5 = new eq();
      eq localeq6 = localeq5;
      long l13 = l6;
      localeq6.b(l13);
      eq localeq7 = localeq5;
      String str42 = str18;
      localeq7.a(str42);
      eq localeq8 = localeq5;
      String str43 = str20;
      localeq8.b(str43);
      localet1 = new et();
      et localet2 = localet1;
      long l14 = l9;
      localet2.a(l14);
      et localet3 = localet1;
      String str44 = str35;
      localet3.a(str44);
      et localet4 = localet1;
      String str45 = str37;
      localet4.c(str45);
      localfb1.a(l1);
      fb localfb2 = localfb1;
      double d3 = d1;
      localfb2.b(d3);
      fb localfb3 = localfb1;
      double d4 = d1;
      localfb3.c(d4);
      fb localfb4 = localfb1;
      String str46 = str32;
      localfb4.d(str46);
      fb localfb5 = localfb1;
      double d5 = d2;
      localfb5.a(d5);
      String str47 = ApplicationContext.g;
      String str48 = str32;
      if (str47.equalsIgnoreCase(str48))
        break label1430;
    }
    label1430: int i56;
    for (int i55 = 1; ; i56 = 0)
    {
      localfb1.b(i55);
      long l15 = ha.b(l2);
      localfb1.d(l15);
      localfb1.b(l3);
      localfb1.c(l4);
      localfb1.a(str6);
      localfb1.b(i11);
      localfb1.c(str9);
      localfb1.b(str11);
      fb localfb6 = localfb1;
      int i57 = i22;
      localfb6.a(i57);
      fb localfb7 = localfb1;
      et localet5 = localet1;
      localfb7.a(localet5);
      fb localfb8 = localfb1;
      eq localeq9 = localeq5;
      localfb8.a(localeq9);
      fb localfb9 = localfb1;
      eq localeq10 = localeq1;
      localfb9.b(localeq10);
      fb localfb10 = localfb1;
      eu localeu4 = localeu1;
      localfb10.a(localeu4);
      fb localfb11 = localfb1;
      fa localfa4 = localfa1;
      localfb11.a(localfa4);
      return localfb1;
      i22 = 0;
      break;
    }
  }

  private String c(long[] paramArrayOfLong, List paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("(");
    int m = 0;
    while (true)
    {
      int n = paramArrayOfLong.length;
      if (m >= n)
        break;
      StringBuilder localStringBuilder2 = localStringBuilder1.append("?").append(",");
      String str1 = String.valueOf(paramArrayOfLong[m]);
      boolean bool = paramList.add(str1);
      m += 1;
    }
    int i1 = localStringBuilder1.length() - 1;
    String str2 = localStringBuilder1.substring(0, i1);
    localStringBuilder1.setLength(0);
    StringBuilder localStringBuilder3 = localStringBuilder1.append(str2).append(")");
    return localStringBuilder1.toString();
  }

  private String d(String paramString)
  {
    if (!gx.a(paramString));
    for (String str = " and trans.memo like '%" + paramString + "%'"; ; str = "")
      return str;
  }

  private void i(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase1 = g();
    String[] arrayOfString = new String[1];
    String str1 = String.valueOf(paramLong);
    arrayOfString[0] = str1;
    Cursor localCursor1 = localSQLiteDatabase1.rawQuery(" select transactionPOID, createdTime, modifiedTime, tradeTime, memo, photoName, type, creatorTradingEntityPOID, modifierTradingEntityPOID,  buyerAccountPOID, sellerAccountPOID, lastUpdateTime , photoNeedUpload buyerCategoryPOID , buyerMoney , sellerCategoryPOID , sellerMoney , relationUnitPOID from t_transaction where transactionPOID = ?", arrayOfString);
    while (localCursor1.moveToNext())
    {
      int m = localCursor1.getColumnIndex("createdTime");
      long l1 = localCursor1.getLong(m);
      int n = localCursor1.getColumnIndex("modifiedTime");
      long l2 = localCursor1.getLong(n);
      int i1 = localCursor1.getColumnIndex("tradeTime");
      long l3 = localCursor1.getLong(i1);
      int i2 = localCursor1.getColumnIndex("memo");
      String str2 = localCursor1.getString(i2);
      int i3 = localCursor1.getColumnIndex("photoName");
      String str3 = localCursor1.getString(i3);
      int i4 = localCursor1.getColumnIndex("type");
      int i5 = localCursor1.getInt(i4);
      int i6 = localCursor1.getColumnIndex("creatorTradingEntityPOID");
      long l4 = localCursor1.getLong(i6);
      Cursor localCursor2 = localCursor1;
      String str4 = "modifierTradingEntityPOID";
      int i7 = localCursor2.getColumnIndex(str4);
      Cursor localCursor3 = localCursor1;
      int i8 = i7;
      long l5 = localCursor3.getLong(i8);
      Cursor localCursor4 = localCursor1;
      String str5 = "buyerAccountPOID";
      int i9 = localCursor4.getColumnIndex(str5);
      Cursor localCursor5 = localCursor1;
      int i10 = i9;
      long l6 = localCursor5.getLong(i10);
      Cursor localCursor6 = localCursor1;
      String str6 = "sellerAccountPOID";
      int i11 = localCursor6.getColumnIndex(str6);
      Cursor localCursor7 = localCursor1;
      int i12 = i11;
      long l7 = localCursor7.getLong(i12);
      Cursor localCursor8 = localCursor1;
      String str7 = "buyerCategoryPOID";
      int i13 = localCursor8.getColumnIndex(str7);
      Cursor localCursor9 = localCursor1;
      int i14 = i13;
      long l8 = localCursor9.getLong(i14);
      Cursor localCursor10 = localCursor1;
      String str8 = "sellerCategoryPOID";
      int i15 = localCursor10.getColumnIndex(str8);
      Cursor localCursor11 = localCursor1;
      int i16 = i15;
      long l9 = localCursor11.getLong(i16);
      Cursor localCursor12 = localCursor1;
      String str9 = "buyerMoney";
      int i17 = localCursor12.getColumnIndex(str9);
      Cursor localCursor13 = localCursor1;
      int i18 = i17;
      double d1 = localCursor13.getDouble(i18);
      Cursor localCursor14 = localCursor1;
      String str10 = "sellerMoney";
      int i19 = localCursor14.getColumnIndex(str10);
      Cursor localCursor15 = localCursor1;
      int i20 = i19;
      double d2 = localCursor15.getDouble(i20);
      Cursor localCursor16 = localCursor1;
      String str11 = "relationUnitPOID";
      int i21 = localCursor16.getColumnIndex(str11);
      Cursor localCursor17 = localCursor1;
      int i22 = i21;
      long l10 = localCursor17.getLong(i22);
      ContentValues localContentValues1 = new ContentValues(11);
      String str12 = dv.c;
      Long localLong1 = Long.valueOf(paramLong);
      localContentValues1.put(str12, localLong1);
      String str13 = dv.d;
      Long localLong2 = Long.valueOf(l1);
      ContentValues localContentValues2 = localContentValues1;
      String str14 = str13;
      Long localLong3 = localLong2;
      localContentValues2.put(str14, localLong3);
      String str15 = dv.e;
      Long localLong4 = Long.valueOf(l2);
      ContentValues localContentValues3 = localContentValues1;
      String str16 = str15;
      Long localLong5 = localLong4;
      localContentValues3.put(str16, localLong5);
      String str17 = dv.f;
      Long localLong6 = Long.valueOf(l3);
      ContentValues localContentValues4 = localContentValues1;
      String str18 = str17;
      Long localLong7 = localLong6;
      localContentValues4.put(str18, localLong7);
      String str19 = dv.i;
      ContentValues localContentValues5 = localContentValues1;
      String str20 = str19;
      String str21 = str2;
      localContentValues5.put(str20, str21);
      String str22 = dv.j;
      ContentValues localContentValues6 = localContentValues1;
      String str23 = str22;
      String str24 = str3;
      localContentValues6.put(str23, str24);
      String str25 = dv.k;
      Integer localInteger1 = Integer.valueOf(fb.a);
      ContentValues localContentValues7 = localContentValues1;
      String str26 = str25;
      Integer localInteger2 = localInteger1;
      localContentValues7.put(str26, localInteger2);
      String str27 = dv.g;
      Integer localInteger3 = Integer.valueOf(i5);
      ContentValues localContentValues8 = localContentValues1;
      String str28 = str27;
      Integer localInteger4 = localInteger3;
      localContentValues8.put(str28, localInteger4);
      String str29 = dv.l;
      Long localLong8 = Long.valueOf(l4);
      ContentValues localContentValues9 = localContentValues1;
      String str30 = str29;
      Long localLong9 = localLong8;
      localContentValues9.put(str30, localLong9);
      String str31 = dv.m;
      Long localLong10 = Long.valueOf(l5);
      ContentValues localContentValues10 = localContentValues1;
      String str32 = str31;
      Long localLong11 = localLong10;
      localContentValues10.put(str32, localLong11);
      String str33 = dv.o;
      Long localLong12 = Long.valueOf(l6);
      ContentValues localContentValues11 = localContentValues1;
      String str34 = str33;
      Long localLong13 = localLong12;
      localContentValues11.put(str34, localLong13);
      String str35 = dv.p;
      Long localLong14 = Long.valueOf(l7);
      ContentValues localContentValues12 = localContentValues1;
      String str36 = str35;
      Long localLong15 = localLong14;
      localContentValues12.put(str36, localLong15);
      String str37 = dv.q;
      Long localLong16 = Long.valueOf(gt.f());
      ContentValues localContentValues13 = localContentValues1;
      String str38 = str37;
      Long localLong17 = localLong16;
      localContentValues13.put(str38, localLong17);
      String str39 = dv.r;
      Long localLong18 = Long.valueOf(l8);
      ContentValues localContentValues14 = localContentValues1;
      String str40 = str39;
      Long localLong19 = localLong18;
      localContentValues14.put(str40, localLong19);
      String str41 = dv.t;
      Long localLong20 = Long.valueOf(l9);
      ContentValues localContentValues15 = localContentValues1;
      String str42 = str41;
      Long localLong21 = localLong20;
      localContentValues15.put(str42, localLong21);
      String str43 = dv.s;
      BigDecimal localBigDecimal1 = new java/math/BigDecimal;
      BigDecimal localBigDecimal2 = localBigDecimal1;
      double d3 = d1;
      localBigDecimal2.<init>(d3);
      String str44 = String.valueOf(gs.a(localBigDecimal1));
      ContentValues localContentValues16 = localContentValues1;
      String str45 = str43;
      String str46 = str44;
      localContentValues16.put(str45, str46);
      String str47 = dv.u;
      BigDecimal localBigDecimal3 = new java/math/BigDecimal;
      BigDecimal localBigDecimal4 = localBigDecimal3;
      double d4 = d2;
      localBigDecimal4.<init>(d4);
      String str48 = String.valueOf(gs.a(localBigDecimal3));
      ContentValues localContentValues17 = localContentValues1;
      String str49 = str47;
      String str50 = str48;
      localContentValues17.put(str49, str50);
      String str51 = dv.v;
      Long localLong22 = Long.valueOf(l10);
      ContentValues localContentValues18 = localContentValues1;
      String str52 = str51;
      Long localLong23 = localLong22;
      localContentValues18.put(str52, localLong23);
      SQLiteDatabase localSQLiteDatabase2 = g();
      String str53 = dv.b;
      SQLiteDatabase localSQLiteDatabase3 = localSQLiteDatabase2;
      String str54 = str53;
      String str55 = null;
      ContentValues localContentValues19 = localContentValues1;
      long l11 = localSQLiteDatabase3.insert(str54, str55, localContentValues19);
    }
    bq localbq = this;
    Cursor localCursor18 = localCursor1;
    localbq.a(localCursor18);
  }

  public double a(int paramInt, long paramLong1, long paramLong2)
  {
    String str1 = b(paramInt, paramLong1, paramLong2);
    StringBuilder localStringBuilder1 = new StringBuilder().append(" select ");
    String str2 = e;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
    String str3 = k;
    String str4 = str3 + str1;
    SQLiteDatabase localSQLiteDatabase = g();
    String[] arrayOfString = new String[1];
    String str5 = ApplicationContext.g;
    arrayOfString[0] = str5;
    Cursor localCursor = localSQLiteDatabase.rawQuery(str4, arrayOfString);
    long l = 0L;
    double d1;
    if (localCursor.moveToNext())
    {
      int m = localCursor.getColumnIndex("amount");
      d1 = localCursor.getDouble(m);
    }
    a(localCursor);
    return d1;
  }

  // ERROR //
  public double a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 8
    //   3: iload_1
    //   4: istore 9
    //   6: lload 4
    //   8: lstore 10
    //   10: lload 6
    //   12: lstore 12
    //   14: aload 8
    //   16: iload 9
    //   18: lload 10
    //   20: lload 12
    //   22: invokespecial 529	bq:b	(IJJ)Ljava/lang/String;
    //   25: astore 14
    //   27: new 41	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 538
    //   37: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: astore 15
    //   42: getstatic 39	bq:g	Ljava/lang/String;
    //   45: astore 16
    //   47: aload 15
    //   49: aload 16
    //   51: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 52
    //   56: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore 17
    //   64: new 41	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 531
    //   74: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: astore 18
    //   79: getstatic 31	bq:e	Ljava/lang/String;
    //   82: astore 19
    //   84: aload 18
    //   86: aload 19
    //   88: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 17
    //   93: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 14
    //   98: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore 20
    //   106: aconst_null
    //   107: astore 21
    //   109: aload_0
    //   110: invokevirtual 136	bq:g	()Landroid/database/sqlite/SQLiteDatabase;
    //   113: astore 22
    //   115: iconst_2
    //   116: anewarray 161	java/lang/String
    //   119: astore 23
    //   121: lload_2
    //   122: invokestatic 165	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   125: astore 24
    //   127: aload 23
    //   129: iconst_0
    //   130: aload 24
    //   132: aastore
    //   133: getstatic 358	com/mymoney/core/application/ApplicationContext:g	Ljava/lang/String;
    //   136: astore 25
    //   138: aload 23
    //   140: iconst_1
    //   141: aload 25
    //   143: aastore
    //   144: aload 22
    //   146: aload 20
    //   148: aload 23
    //   150: invokevirtual 200	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   153: astore 26
    //   155: aload 26
    //   157: astore 27
    //   159: ldc2_w 532
    //   162: lstore 28
    //   164: aload 27
    //   166: invokeinterface 215 1 0
    //   171: ifeq +33 -> 204
    //   174: aload 27
    //   176: ldc_w 535
    //   179: invokeinterface 225 2 0
    //   184: istore 30
    //   186: aload 27
    //   188: iload 30
    //   190: invokeinterface 307 2 0
    //   195: dstore 26
    //   197: dload 26
    //   199: dstore 28
    //   201: goto -37 -> 164
    //   204: aload_0
    //   205: aload 27
    //   207: invokevirtual 218	bq:a	(Landroid/database/Cursor;)V
    //   210: lload 28
    //   212: lreturn
    //   213: astore 31
    //   215: aload_0
    //   216: aload 21
    //   218: invokevirtual 218	bq:a	(Landroid/database/Cursor;)V
    //   221: aload 31
    //   223: athrow
    //   224: astore 32
    //   226: aload 27
    //   228: astore 21
    //   230: aload 32
    //   232: astore 31
    //   234: goto -19 -> 215
    //
    // Exception table:
    //   from	to	target	type
    //   109	155	213	finally
    //   164	197	224	finally
  }

  public int a()
  {
    Cursor localCursor = g().rawQuery("select count(transactionPOID) from t_transaction", null);
    boolean bool = localCursor.moveToNext();
    int m = localCursor.getInt(0);
    a(localCursor);
    return m;
  }

  public long a(long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    String str1 = dw.b;
    Long localLong1 = Long.valueOf(paramLong1);
    localContentValues.put(str1, localLong1);
    String str2 = dw.c;
    Long localLong2 = Long.valueOf(paramLong2);
    localContentValues.put(str2, localLong2);
    SQLiteDatabase localSQLiteDatabase = g();
    String str3 = dw.a;
    return localSQLiteDatabase.insert(str3, null, localContentValues);
  }

  public long a(fb paramfb)
  {
    String str1 = dv.a;
    long l1 = c(str1);
    paramfb.a(l1);
    long l2 = ha.a(paramfb.h());
    paramfb.d(l2);
    String str2 = dv.a;
    a(str2, paramfb);
    return l1;
  }

  public fb a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = this.i;
    String str2 = str1 + " where trans.relation = ? and trans.type=" + 2;
    String[] arrayOfString = new String[2];
    String str3 = ApplicationContext.g;
    arrayOfString[0] = str3;
    String str4 = String.valueOf(paramString);
    arrayOfString[1] = str4;
    Cursor localCursor = g().rawQuery(str2, arrayOfString);
    for (fb localfb = null; localCursor.moveToNext(); localfb = c(localCursor));
    a(localCursor);
    return localfb;
  }

  public List a(int paramInt, String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, long[] paramArrayOfLong5, String paramString2, String paramString3, String paramString4)
  {
    LinkedList localLinkedList1 = new LinkedList();
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = this.i;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    StringBuilder localStringBuilder3 = localStringBuilder1.append(" left join t_category as firstLevelCategory on(category.parentCategoryPOID = firstLevelCategory.categoryPOID) ");
    String str2 = " where trans.type = " + paramInt;
    if (paramInt == -1)
      str2 = " where trans.type in    (0,1,3,8,9,10)";
    StringBuilder localStringBuilder4 = localStringBuilder1.append(str2);
    String str3 = ApplicationContext.g;
    boolean bool1 = localLinkedList1.add(str3);
    bq localbq1 = this;
    long l1 = paramLong1;
    long l2 = paramLong2;
    String str4 = localbq1.a(l1, l2, localLinkedList1);
    StringBuilder localStringBuilder5 = localStringBuilder1.append(str4);
    if ((paramArrayOfLong2 != 0) && (paramArrayOfLong2.length > 0))
    {
      StringBuilder localStringBuilder6 = new StringBuilder().append(" and category.categoryPOID in ");
      bq localbq2 = this;
      long l3 = paramArrayOfLong1;
      LinkedList localLinkedList2 = localLinkedList1;
      String str5 = localbq2.c(l3, localLinkedList2);
      String str6 = str5;
      StringBuilder localStringBuilder7 = localStringBuilder1.append(str6).append(" and trans.type in (0, 1) ");
      if ((paramArrayOfLong3 != null) && (paramArrayOfLong3.length > 0))
      {
        if (paramInt != 0)
          break label610;
        StringBuilder localStringBuilder8 = new StringBuilder().append(" and trans.buyerAccountPOID in ");
        bq localbq3 = this;
        long[] arrayOfLong1 = paramArrayOfLong3;
        LinkedList localLinkedList3 = localLinkedList1;
        String str7 = localbq3.c(arrayOfLong1, localLinkedList3);
        String str8 = str7;
        StringBuilder localStringBuilder9 = localStringBuilder1.append(str8);
      }
    }
    while (true)
    {
      bq localbq4 = this;
      long[] arrayOfLong2 = paramArrayOfLong4;
      LinkedList localLinkedList4 = localLinkedList1;
      String str9 = localbq4.a(arrayOfLong2, localLinkedList4);
      StringBuilder localStringBuilder10 = localStringBuilder1.append(str9);
      bq localbq5 = this;
      long[] arrayOfLong3 = paramArrayOfLong5;
      LinkedList localLinkedList5 = localLinkedList1;
      String str10 = localbq5.b(arrayOfLong3, localLinkedList5);
      StringBuilder localStringBuilder11 = localStringBuilder1.append(str10);
      bq localbq6 = this;
      String str11 = paramString2;
      String str12 = localbq6.d(str11);
      StringBuilder localStringBuilder12 = localStringBuilder1.append(str12);
      if (!gx.a(paramString3))
      {
        StringBuilder localStringBuilder13 = localStringBuilder1.append(" and cost >= ?");
        LinkedList localLinkedList6 = localLinkedList1;
        String str13 = paramString3;
        boolean bool2 = localLinkedList6.add(str13);
      }
      if (!gx.a(paramString4))
      {
        StringBuilder localStringBuilder14 = localStringBuilder1.append(" and cost <= ?");
        LinkedList localLinkedList7 = localLinkedList1;
        String str14 = paramString4;
        boolean bool3 = localLinkedList7.add(str14);
      }
      String str15 = this.d;
      StringBuilder localStringBuilder15 = localStringBuilder1.append(str15);
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString1 = new String[localLinkedList1.size()];
      String str16 = localStringBuilder1.toString();
      String[] arrayOfString2 = (String[])localLinkedList1.toArray(arrayOfString1);
      br localbr = new br(this, localArrayList);
      Object localObject = a(str16, arrayOfString2, localbr);
      localLinkedList1.clear();
      return localArrayList;
      if ((paramArrayOfLong1 == 0) || (paramArrayOfLong1.length <= 0))
        break;
      StringBuilder localStringBuilder16 = new StringBuilder().append(" and firstLevelCategory.categoryPOID in ");
      bq localbq7 = this;
      long l4 = paramArrayOfLong1;
      LinkedList localLinkedList8 = localLinkedList1;
      String str17 = localbq7.c(l4, localLinkedList8);
      String str18 = str17;
      StringBuilder localStringBuilder17 = localStringBuilder1.append(str18).append(" and trans.type in (0, 1) ");
      break;
      label610: if (paramInt == 1)
      {
        StringBuilder localStringBuilder18 = new StringBuilder().append(" and trans.sellerAccountPOID in ");
        bq localbq8 = this;
        long[] arrayOfLong4 = paramArrayOfLong3;
        LinkedList localLinkedList9 = localLinkedList1;
        String str19 = localbq8.c(arrayOfLong4, localLinkedList9);
        String str20 = str19;
        StringBuilder localStringBuilder19 = localStringBuilder1.append(str20);
        continue;
      }
      StringBuilder localStringBuilder20 = localStringBuilder1.append(" and (");
      StringBuilder localStringBuilder21 = localStringBuilder1.append(" case when trans.type = 0 then trans.buyerAccountPOID in ");
      bq localbq9 = this;
      long[] arrayOfLong5 = paramArrayOfLong3;
      LinkedList localLinkedList10 = localLinkedList1;
      String str21 = localbq9.c(arrayOfLong5, localLinkedList10);
      StringBuilder localStringBuilder22 = localStringBuilder21.append(str21);
      StringBuilder localStringBuilder23 = localStringBuilder1.append("      when trans.type = 1 then trans.sellerAccountPOID in ");
      bq localbq10 = this;
      long[] arrayOfLong6 = paramArrayOfLong3;
      LinkedList localLinkedList11 = localLinkedList1;
      String str22 = localbq10.c(arrayOfLong6, localLinkedList11);
      StringBuilder localStringBuilder24 = localStringBuilder23.append(str22);
      StringBuilder localStringBuilder25 = localStringBuilder1.append("      when trans.type = 2 then trans.sellerAccountPOID in ");
      bq localbq11 = this;
      long[] arrayOfLong7 = paramArrayOfLong3;
      LinkedList localLinkedList12 = localLinkedList1;
      String str23 = localbq11.c(arrayOfLong7, localLinkedList12);
      StringBuilder localStringBuilder26 = localStringBuilder25.append(str23);
      StringBuilder localStringBuilder27 = localStringBuilder1.append("      when trans.type = 3 then trans.buyerAccountPOID in ");
      bq localbq12 = this;
      long[] arrayOfLong8 = paramArrayOfLong3;
      LinkedList localLinkedList13 = localLinkedList1;
      String str24 = localbq12.c(arrayOfLong8, localLinkedList13);
      StringBuilder localStringBuilder28 = localStringBuilder27.append(str24);
      StringBuilder localStringBuilder29 = localStringBuilder1.append("      when trans.type = 4 then trans.sellerAccountPOID in ");
      bq localbq13 = this;
      long[] arrayOfLong9 = paramArrayOfLong3;
      LinkedList localLinkedList14 = localLinkedList1;
      String str25 = localbq13.c(arrayOfLong9, localLinkedList14);
      StringBuilder localStringBuilder30 = localStringBuilder29.append(str25);
      StringBuilder localStringBuilder31 = localStringBuilder1.append("      when trans.type = 5 then trans.buyerAccountPOID in ");
      bq localbq14 = this;
      long[] arrayOfLong10 = paramArrayOfLong3;
      LinkedList localLinkedList15 = localLinkedList1;
      String str26 = localbq14.c(arrayOfLong10, localLinkedList15);
      StringBuilder localStringBuilder32 = localStringBuilder31.append(str26);
      StringBuilder localStringBuilder33 = localStringBuilder1.append("      when trans.type = 6 then trans.sellerAccountPOID in ");
      bq localbq15 = this;
      long[] arrayOfLong11 = paramArrayOfLong3;
      LinkedList localLinkedList16 = localLinkedList1;
      String str27 = localbq15.c(arrayOfLong11, localLinkedList16);
      StringBuilder localStringBuilder34 = localStringBuilder33.append(str27);
      StringBuilder localStringBuilder35 = localStringBuilder1.append("      when trans.type = 7 then trans.buyerAccountPOID in ");
      bq localbq16 = this;
      long[] arrayOfLong12 = paramArrayOfLong3;
      LinkedList localLinkedList17 = localLinkedList1;
      String str28 = localbq16.c(arrayOfLong12, localLinkedList17);
      StringBuilder localStringBuilder36 = localStringBuilder35.append(str28);
      StringBuilder localStringBuilder37 = localStringBuilder1.append("      when trans.type = 8 then trans.sellerAccountPOID in ");
      bq localbq17 = this;
      long[] arrayOfLong13 = paramArrayOfLong3;
      LinkedList localLinkedList18 = localLinkedList1;
      String str29 = localbq17.c(arrayOfLong13, localLinkedList18);
      StringBuilder localStringBuilder38 = localStringBuilder37.append(str29);
      StringBuilder localStringBuilder39 = localStringBuilder1.append("      when trans.type = 9 then trans.sellerAccountPOID in ");
      bq localbq18 = this;
      long[] arrayOfLong14 = paramArrayOfLong3;
      LinkedList localLinkedList19 = localLinkedList1;
      String str30 = localbq18.c(arrayOfLong14, localLinkedList19);
      StringBuilder localStringBuilder40 = localStringBuilder39.append(str30);
      StringBuilder localStringBuilder41 = localStringBuilder1.append("      when trans.type = 10 then trans.sellerAccountPOID in ");
      bq localbq19 = this;
      long[] arrayOfLong15 = paramArrayOfLong3;
      LinkedList localLinkedList20 = localLinkedList1;
      String str31 = localbq19.c(arrayOfLong15, localLinkedList20);
      StringBuilder localStringBuilder42 = localStringBuilder41.append(str31);
      StringBuilder localStringBuilder43 = localStringBuilder1.append(" end ");
      StringBuilder localStringBuilder44 = localStringBuilder1.append(") ");
    }
  }

  public List a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = this.j;
    String str2 = str1 + " and ";
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append(str2).append(" ");
      String str3 = this.d;
      String str4 = str3;
      return a(str4, null);
      str2 = str2 + " (cost like '%" + paramString + "%' or categoryName like '%" + paramString + "%' or trans.memo like '%" + paramString + "%')";
      continue;
      str2 = str2 + " cost like '%" + paramString + "%'";
      continue;
      str2 = str2 + " categoryName like '%" + paramString + "%'";
      continue;
      str2 = str2 + " trans.memo like '%" + paramString + "%'";
    }
  }

  protected void a(String paramString, fb paramfb)
  {
    long l1 = paramfb.a();
    long l2 = paramfb.c();
    long l3 = paramfb.e();
    long l4 = paramfb.h();
    String str1 = paramfb.f();
    String str2 = paramfb.j();
    boolean bool = paramfb.l();
    int m = paramfb.d();
    String str3 = paramfb.k();
    long l5 = paramfb.q().f();
    long l6 = paramfb.r().f();
    long l7;
    long l8;
    ContentValues localContentValues1;
    String str23;
    if (paramfb.i() > 0L)
    {
      l7 = paramfb.i();
      l8 = paramfb.s().b();
      localContentValues1 = new ContentValues(11);
      String str4 = dv.c;
      Long localLong1 = Long.valueOf(l1);
      ContentValues localContentValues2 = localContentValues1;
      String str5 = str4;
      Long localLong2 = localLong1;
      localContentValues2.put(str5, localLong2);
      String str6 = dv.d;
      Long localLong3 = Long.valueOf(l2);
      ContentValues localContentValues3 = localContentValues1;
      String str7 = str6;
      Long localLong4 = localLong3;
      localContentValues3.put(str7, localLong4);
      String str8 = dv.e;
      Long localLong5 = Long.valueOf(l3);
      ContentValues localContentValues4 = localContentValues1;
      String str9 = str8;
      Long localLong6 = localLong5;
      localContentValues4.put(str9, localLong6);
      String str10 = dv.f;
      Long localLong7 = Long.valueOf(l4);
      ContentValues localContentValues5 = localContentValues1;
      String str11 = str10;
      Long localLong8 = localLong7;
      localContentValues5.put(str11, localLong8);
      String str12 = dv.g;
      Integer localInteger1 = Integer.valueOf(m);
      ContentValues localContentValues6 = localContentValues1;
      String str13 = str12;
      Integer localInteger2 = localInteger1;
      localContentValues6.put(str13, localInteger2);
      String str14 = dv.h;
      ContentValues localContentValues7 = localContentValues1;
      String str15 = str14;
      String str16 = str3;
      localContentValues7.put(str15, str16);
      String str17 = dv.i;
      ContentValues localContentValues8 = localContentValues1;
      String str18 = str17;
      String str19 = str1;
      localContentValues8.put(str18, str19);
      String str20 = dv.j;
      ContentValues localContentValues9 = localContentValues1;
      String str21 = str20;
      String str22 = str2;
      localContentValues9.put(str21, str22);
      str23 = dv.k;
      if (!bool)
        break label799;
    }
    label799: for (int n = fb.b; ; n = fb.a)
    {
      Integer localInteger3 = Integer.valueOf(n);
      ContentValues localContentValues10 = localContentValues1;
      String str24 = str23;
      Integer localInteger4 = localInteger3;
      localContentValues10.put(str24, localInteger4);
      String str25 = dv.l;
      Long localLong9 = Long.valueOf(ApplicationContext.d);
      ContentValues localContentValues11 = localContentValues1;
      String str26 = str25;
      Long localLong10 = localLong9;
      localContentValues11.put(str26, localLong10);
      String str27 = dv.m;
      Long localLong11 = Long.valueOf(ApplicationContext.d);
      ContentValues localContentValues12 = localContentValues1;
      String str28 = str27;
      Long localLong12 = localLong11;
      localContentValues12.put(str28, localLong12);
      String str29 = dv.o;
      Long localLong13 = Long.valueOf(l5);
      ContentValues localContentValues13 = localContentValues1;
      String str30 = str29;
      Long localLong14 = localLong13;
      localContentValues13.put(str30, localLong14);
      String str31 = dv.p;
      Long localLong15 = Long.valueOf(l6);
      ContentValues localContentValues14 = localContentValues1;
      String str32 = str31;
      Long localLong16 = localLong15;
      localContentValues14.put(str32, localLong16);
      String str33 = dv.q;
      Long localLong17 = Long.valueOf(l7);
      ContentValues localContentValues15 = localContentValues1;
      String str34 = str33;
      Long localLong18 = localLong17;
      localContentValues15.put(str34, localLong18);
      String str35 = dv.r;
      Long localLong19 = Long.valueOf(paramfb.m());
      ContentValues localContentValues16 = localContentValues1;
      String str36 = str35;
      Long localLong20 = localLong19;
      localContentValues16.put(str36, localLong20);
      String str37 = dv.s;
      double d1 = paramfb.n();
      String str38 = String.valueOf(gs.a(new BigDecimal(d1)));
      ContentValues localContentValues17 = localContentValues1;
      String str39 = str37;
      String str40 = str38;
      localContentValues17.put(str39, str40);
      String str41 = dv.t;
      Long localLong21 = Long.valueOf(paramfb.o());
      ContentValues localContentValues18 = localContentValues1;
      String str42 = str41;
      Long localLong22 = localLong21;
      localContentValues18.put(str42, localLong22);
      String str43 = dv.u;
      double d2 = paramfb.p();
      String str44 = String.valueOf(gs.a(new BigDecimal(d2)));
      ContentValues localContentValues19 = localContentValues1;
      String str45 = str43;
      String str46 = str44;
      localContentValues19.put(str45, str46);
      String str47 = dv.v;
      Long localLong23 = Long.valueOf(l8);
      ContentValues localContentValues20 = localContentValues1;
      String str48 = str47;
      Long localLong24 = localLong23;
      localContentValues20.put(str48, localLong24);
      SQLiteDatabase localSQLiteDatabase = g();
      String str49 = paramString;
      String str50 = null;
      ContentValues localContentValues21 = localContentValues1;
      long l9 = localSQLiteDatabase.insert(str49, str50, localContentValues21);
      return;
      l7 = gt.f();
      break;
    }
  }

  public boolean a(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = g();
    String str1 = dw.a;
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = dw.b;
    String str3 = str2 + " = ?";
    String[] arrayOfString = new String[1];
    String str4 = String.valueOf(paramLong);
    arrayOfString[0] = str4;
    if (localSQLiteDatabase.delete(str1, str3, arrayOfString) > 0L);
    for (int m = 1; ; m = 0)
      return m;
  }

  public boolean a(long paramLong, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    String str1 = dv.k;
    int m;
    if (paramBoolean)
    {
      m = fb.b;
      Integer localInteger = Integer.valueOf(m);
      localContentValues.put(str1, localInteger);
      SQLiteDatabase localSQLiteDatabase = g();
      String str2 = dv.a;
      String[] arrayOfString = new String[1];
      String str3 = String.valueOf(paramLong);
      arrayOfString[0] = str3;
      if (localSQLiteDatabase.update(str2, localContentValues, " transactionPOID = ?", arrayOfString) <= 0)
        break label99;
    }
    label99: for (int n = 1; ; n = 0)
    {
      return n;
      m = fb.a;
      break;
    }
  }

  public List b(long paramLong1, long paramLong2)
  {
    long l1 = ha.c(paramLong1);
    long l2 = ha.c(paramLong2);
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = this.j;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(" and trans.tradeTime >= ? and trans.tradeTime <= ? ");
    String str2 = this.d;
    String str3 = str2;
    String[] arrayOfString = new String[3];
    String str4 = ApplicationContext.g;
    arrayOfString[0] = str4;
    String str5 = String.valueOf(l1);
    arrayOfString[1] = str5;
    String str6 = String.valueOf(l2);
    arrayOfString[2] = str6;
    return a(str3, arrayOfString);
  }

  public List b(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    String str2;
    String[] arrayOfString;
    for (Object localObject = new ArrayList(); ; localObject = a(str2, arrayOfString))
    {
      return localObject;
      StringBuilder localStringBuilder = new StringBuilder();
      String str1 = this.i;
      str2 = str1 + " where trans.relation = ?";
      arrayOfString = new String[2];
      String str3 = ApplicationContext.g;
      arrayOfString[0] = str3;
      arrayOfString[1] = paramString;
    }
  }

  public void b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(" update t_transaction set lastUpdateTime = ");
    long l = gt.f();
    String str = l + "  where transactionPOID in " + " ( select " + "     t.transactionPOID " + "   from " + "     t_transaction as t " + "   left join  " + "     t_transaction_projectcategory_map as map " + "   on(t.transactionPOID = map.transactionPOID and map.projectCategoryPOID = " + paramLong + " ))";
    g().execSQL(str);
  }

  public boolean b()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("select photoNeedUpload from t_transaction where photoNeedUpload = ");
    int m = fb.b;
    String str = m;
    if (g().rawQuery(str, null).moveToNext());
    for (int n = 1; ; n = 0)
      return n;
  }

  public boolean b(fb paramfb)
  {
    long l1 = paramfb.a();
    int m = paramfb.d();
    long l2 = ha.a(paramfb.h());
    String str1 = paramfb.f();
    String str2 = paramfb.j();
    boolean bool1 = paramfb.l();
    String str3 = paramfb.k();
    boolean bool2 = a(l1);
    ContentValues localContentValues = new ContentValues(7);
    String str4 = dv.e;
    Long localLong1 = Long.valueOf(gt.f());
    localContentValues.put(str4, localLong1);
    String str5 = dv.f;
    Long localLong2 = Long.valueOf(l2);
    localContentValues.put(str5, localLong2);
    String str6 = dv.i;
    localContentValues.put(str6, str1);
    String str7 = dv.j;
    localContentValues.put(str7, str2);
    String str8 = dv.k;
    int n;
    if (bool1)
    {
      n = fb.b;
      Integer localInteger = Integer.valueOf(n);
      localContentValues.put(str8, localInteger);
      String str9 = dv.q;
      Long localLong3 = Long.valueOf(gt.f());
      localContentValues.put(str9, localLong3);
      String str10 = dv.h;
      localContentValues.put(str10, str3);
      if (m != 0)
        break label488;
      long l3 = paramfb.q().f();
      long l4 = paramfb.s().b();
      String str11 = dv.o;
      Long localLong4 = Long.valueOf(l3);
      localContentValues.put(str11, localLong4);
      String str12 = dv.v;
      Long localLong5 = Long.valueOf(l4);
      localContentValues.put(str12, localLong5);
      label265: String str13 = dv.r;
      Long localLong6 = Long.valueOf(paramfb.m());
      localContentValues.put(str13, localLong6);
      String str14 = dv.s;
      double d1 = paramfb.n();
      String str15 = String.valueOf(gs.a(new BigDecimal(d1)));
      localContentValues.put(str14, str15);
      String str16 = dv.t;
      Long localLong7 = Long.valueOf(paramfb.o());
      localContentValues.put(str16, localLong7);
      String str17 = dv.u;
      double d2 = paramfb.p();
      String str18 = String.valueOf(gs.a(new BigDecimal(d2)));
      localContentValues.put(str17, str18);
      SQLiteDatabase localSQLiteDatabase = g();
      String str19 = dv.a;
      String[] arrayOfString = new String[1];
      String str20 = String.valueOf(l1);
      arrayOfString[0] = str20;
      int i1 = localSQLiteDatabase.update(str19, localContentValues, " transactionPOID = ?", arrayOfString);
      if ((paramfb.g() != null) && (paramfb.g().a() != 0L))
      {
        long l5 = paramfb.g().a();
        long l6 = a(l1, l5);
      }
      if (i1 <= 0)
        break label527;
    }
    label527: for (int i2 = 1; ; i2 = 0)
    {
      return i2;
      n = fb.a;
      break;
      label488: if (1 != m)
        break label265;
      long l7 = paramfb.r().f();
      String str21 = dv.p;
      Long localLong8 = Long.valueOf(l7);
      localContentValues.put(str21, localLong8);
      break label265;
    }
  }

  public Map c()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("select transactionPOID, photoName from t_transaction where photoNeedUpload = ");
    int m = fb.b;
    String str1 = m;
    Cursor localCursor = g().rawQuery(str1, null);
    HashMap localHashMap = new HashMap();
    while (localCursor.moveToNext())
    {
      int n = localCursor.getColumnIndex("transactionPOID");
      Long localLong = Long.valueOf(localCursor.getLong(n));
      int i1 = localCursor.getColumnIndex("photoName");
      String str2 = localCursor.getString(i1);
      if ((TextUtils.isEmpty(str2)) || ("null".equalsIgnoreCase(str2)))
        continue;
      Object localObject = localHashMap.put(localLong, str2);
    }
    a(localCursor);
    return localHashMap;
  }

  public void c(long paramLong)
  {
    String str = "delete from t_transaction_projectcategory_map where projectCategoryPOID = " + paramLong;
    g().execSQL(str);
  }

  public long d()
  {
    Cursor localCursor = g().rawQuery("select max(lastUpdateTime) as lastUpdateTime from t_transaction", null);
    long l = 0L;
    while (localCursor.moveToNext())
    {
      int m = localCursor.getColumnIndex("lastUpdateTime");
      l = localCursor.getLong(m);
    }
    a(localCursor);
    return l;
  }

  public void d(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("update t_transaction set lastUpdateTime =  ");
    long l = gt.f();
    String str = l + " where relationUnitPOID = " + paramLong;
    g().execSQL(str);
  }

  public int e()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("select count(1) as transCount from ");
    String str1 = dv.a;
    String str2 = str1;
    Cursor localCursor = g().rawQuery(str2, null);
    return b(localCursor);
  }

  public void e(long paramLong)
  {
    String str = "update t_transaction set relationUnitPOID =  0 where relationUnitPOID = " + paramLong;
    g().execSQL(str);
  }

  public boolean f(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = dv.c;
    String str2 = str1 + " = ?";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    if (a(paramLong, str2, arrayOfString) > 0L);
    for (int m = 1; ; m = 0)
      return m;
  }

  public fb g(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = this.i;
    String str2 = str1 + " where trans.transactionPOID = ?";
    String[] arrayOfString = new String[2];
    String str3 = ApplicationContext.g;
    arrayOfString[0] = str3;
    String str4 = String.valueOf(paramLong);
    arrayOfString[1] = str4;
    Cursor localCursor = g().rawQuery(str2, arrayOfString);
    for (fb localfb = null; localCursor.moveToNext(); localfb = c(localCursor));
    a(localCursor);
    return localfb;
  }

  public List h(long paramLong)
  {
    eq localeq = ai.a().c().a(paramLong);
    int m = localeq.k().i();
    String[] arrayOfString;
    String str8;
    if (m == 0)
    {
      arrayOfString = new String[6];
      String str1 = ApplicationContext.g;
      arrayOfString[0] = str1;
      String str2 = String.valueOf(paramLong);
      arrayOfString[1] = str2;
      String str3 = String.valueOf(paramLong);
      arrayOfString[2] = str3;
      String str4 = String.valueOf(paramLong);
      arrayOfString[3] = str4;
      String str5 = String.valueOf(paramLong);
      arrayOfString[4] = str5;
      String str6 = String.valueOf(paramLong);
      arrayOfString[5] = str6;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str7 = this.i;
      str8 = str7 + " where " + "    (trans.type = " + 0 + " and buyerAccount.accountPOID = ? )" + "    or (trans.type = " + 1 + " and sellerAccount.accountPOID = ? )" + "    or (trans.type = " + 3 + " and buyerAccount.accountPOID = ? )" + "    or (trans.type = " + 2 + " and sellerAccount.accountPOID = ? )" + "    or (trans.type = " + 8 + " and sellerAccount.accountPOID = ? )";
    }
    while (true)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append(str8);
      String str9 = this.d;
      String str10 = str9;
      return a(str10, arrayOfString);
      if (1 == m)
      {
        String str11 = localeq.k().c();
        if ("信用卡".equalsIgnoreCase(str11))
        {
          arrayOfString = new String[5];
          String str12 = ApplicationContext.g;
          arrayOfString[0] = str12;
          String str13 = String.valueOf(paramLong);
          arrayOfString[1] = str13;
          String str14 = String.valueOf(paramLong);
          arrayOfString[2] = str14;
          String str15 = String.valueOf(paramLong);
          arrayOfString[3] = str15;
          String str16 = String.valueOf(paramLong);
          arrayOfString[4] = str16;
          StringBuilder localStringBuilder3 = new StringBuilder();
          String str17 = this.i;
          str8 = str17 + " where " + "    (trans.type = " + 0 + " and buyerAccount.accountPOID = ? )" + "    or (trans.type = " + 3 + " and buyerAccount.accountPOID = ? )" + "    or (trans.type = " + 2 + " and sellerAccount.accountPOID = ? )" + "    or (trans.type = " + 9 + " and sellerAccount.accountPOID = ? )";
          continue;
        }
        arrayOfString = new String[4];
        String str18 = ApplicationContext.g;
        arrayOfString[0] = str18;
        String str19 = String.valueOf(paramLong);
        arrayOfString[1] = str19;
        String str20 = String.valueOf(paramLong);
        arrayOfString[2] = str20;
        String str21 = String.valueOf(paramLong);
        arrayOfString[3] = str21;
        StringBuilder localStringBuilder4 = new StringBuilder();
        String str22 = this.i;
        str8 = str22 + " where " + "    (trans.type = " + 9 + " and sellerAccount.accountPOID = ? )" + "    or (trans.type = " + 4 + " and sellerAccount.accountPOID = ? )" + "    or (trans.type = " + 7 + " and buyerAccount.accountPOID = ? )";
        continue;
      }
      if (2 == m)
      {
        arrayOfString = new String[4];
        String str23 = ApplicationContext.g;
        arrayOfString[0] = str23;
        String str24 = String.valueOf(paramLong);
        arrayOfString[1] = str24;
        String str25 = String.valueOf(paramLong);
        arrayOfString[2] = str25;
        String str26 = String.valueOf(paramLong);
        arrayOfString[3] = str26;
        StringBuilder localStringBuilder5 = new StringBuilder();
        String str27 = this.i;
        str8 = str27 + " where " + "    (trans.type = " + 5 + " and buyerAccount.accountPOID = ? )" + "    or (trans.type = " + 6 + " and sellerAccount.accountPOID = ? )" + "    or (trans.type = " + 10 + " and sellerAccount.accountPOID = ? )";
        continue;
      }
      str8 = "";
      arrayOfString = null;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     bq
 * JD-Core Version:    0.6.0
 */