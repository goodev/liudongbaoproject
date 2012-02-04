import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mymoney.core.application.ApplicationContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class bx extends bt
{
  protected static String b = "     (case          when trans.type  = 0 then buyerAccount.currencyType          when trans.type  = 1 then sellerAccount.currencyType         when trans.type  = 2 then sellerAccount.currencyType         when trans.type  = 3 then buyerAccount.currencyType         when trans.type  = 4 then sellerAccount.currencyType          when trans.type  = 5 then buyerAccount.currencyType          when trans.type  = 6 then sellerAccount.currencyType          when trans.type  = 7 then buyerAccount.currencyType          when trans.type  = 8 then sellerAccount.currencyType          else sellerAccount.currencyType        end) ";
  private static String e;

  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append(" select    trans.transactionPOID as id,    trans.tradeTime as tradeTime,    trans.createdTime as createdTime,   trans.modifiedTime as modifiedTime,   trans.memo as memo,   trans.type as type,   trans.relation as relation,   trans.photoName as photoName,    trans.photoNeedUpload as photoNeedUpload,   seller.tradingEntityPOID as sellerId,   seller.name as sellerName,    buyerAccount.accountPOID as buyerAccountId,   buyerAccount.name as buyerAccountName,     sellerAccount.accountPOID as sellerAccountId,     sellerAccount.name as sellerAccountName,     payment.tradeItemPOID as paymentId,   payment.name as paymentName, ");
    String str1 = b;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(" as paymentCurrencyType,").append("   payment.currencyValue as paymentCurrencyValue, ").append("   subjectItem.tradeItemPOID as subjectItemId,").append("   subjectItem.name as subjectItemName, ");
    String str2 = b;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(" as subjectItemCurrencyType,").append("   subjectItem.currencyValue as subjectItemCurrencyValue, ").append("   subjectItemCategory.categoryPOID as subjectItemCategoryId,").append("   subjectItemCategory.name as subjectItemCategoryName,").append("   subjectItemCategory._tempIconName as _tempIconName,").append("   projectCategory.categoryPOID as projectCategoryId,").append("   projectCategory.name as projectCategoryName").append(" from t_transaction as trans   ").append(" left join ").append("   t_tradingEntity as seller ").append(" on trans.sellerTradingEntityPOID = seller.tradingEntityPOID ").append(" left join ").append("   t_account as buyerAccount ").append(" on trans.buyerAccountPOID = buyerAccount.accountPOID  ").append(" left join ").append("   t_account as sellerAccount ").append(" on trans.sellerAccountPOID = sellerAccount.accountPOID  ").append(" left join ").append("   t_transaction_projectcategory_map as transProjectCategoryMap ").append(" on trans.transactionPOID = transProjectCategoryMap.transactionPOID  ").append(" left join ").append("   t_category as projectCategory ").append(" on transProjectCategoryMap.projectCategoryPOID = projectCategory.categoryPOID  ").append(" left join ").append("   t_tradeItem as payment ").append(" on (payment.transactionPOID = trans.transactionPOID and payment.tradeItemType = ");
    int i = dd.a;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(i).append(") ").append(" inner join ").append("   t_tradeItem as subjectItem ").append(" on  (subjectItem.transactionPOID = trans.transactionPOID and subjectItem.tradeItemType = ");
    int j = dd.b;
    e = j + ")" + " left join " + "   t_category as subjectItemCategory  " + " on subjectItem.categoryPOID = subjectItemCategory.categoryPOID ";
  }

  private long a(int paramInt, dd paramdd)
  {
    String str1 = cq.a;
    long l1 = c(str1);
    paramdd.a(l1);
    paramdd.a(paramInt);
    String str2 = cq.a;
    a(str2, paramdd);
    long l2 = c;
    String str3 = cq.a;
    a(l1, l2, str3);
    return l1;
  }

  static BigDecimal a(List paramList, cu paramcu, int paramInt, String paramString)
  {
    BigDecimal localBigDecimal1 = new BigDecimal(0);
    Iterator localIterator = paramList.iterator();
    Object localObject1 = localBigDecimal1;
    BigDecimal localBigDecimal2;
    if (localIterator.hasNext())
    {
      Map localMap = (Map)localIterator.next();
      Object localObject2 = (String)localMap.get("buyeraccountpoid");
      String str1 = (String)localMap.get("selleraccountpoid");
      int i = Integer.parseInt((String)localMap.get("type"));
      paramList = (String)localMap.get("amount");
      if (paramString.equals("seller"))
        localObject2 = str1;
      if (i != paramInt)
        break label169;
      String str2 = String.valueOf(paramcu.a());
      if (!((String)localObject2).equals(str2))
        break label169;
      localBigDecimal2 = new BigDecimal(paramList);
    }
    label169: for (Object localObject3 = ((BigDecimal)localObject1).add(localBigDecimal2); ; localObject3 = localObject1)
    {
      localObject1 = localObject3;
      break;
      return localObject1;
    }
  }

  private List a(String paramString, String[] paramArrayOfString)
  {
    Cursor localCursor = this.a.rawQuery(paramString, paramArrayOfString);
    int i = localCursor.getCount();
    ArrayList localArrayList = new ArrayList(i);
    while (localCursor.moveToNext())
    {
      df localdf = c(localCursor);
      boolean bool = localArrayList.add(localdf);
    }
    a(localCursor);
    return localArrayList;
  }

  private dd b(Cursor paramCursor)
  {
    Cursor localCursor1 = paramCursor;
    String str1 = "tradeItemPOID";
    int i = localCursor1.getColumnIndex(str1);
    Cursor localCursor2 = paramCursor;
    int j = i;
    long l1 = localCursor2.getLong(j);
    Cursor localCursor3 = paramCursor;
    String str2 = "currencyType";
    int k = localCursor3.getColumnIndex(str2);
    Cursor localCursor4 = paramCursor;
    int m = k;
    String str3 = localCursor4.getString(m);
    Cursor localCursor5 = paramCursor;
    String str4 = "currencyValue";
    int n = localCursor5.getColumnIndex(str4);
    Cursor localCursor6 = paramCursor;
    int i1 = n;
    double d = localCursor6.getDouble(i1);
    Cursor localCursor7 = paramCursor;
    String str5 = "name";
    int i2 = localCursor7.getColumnIndex(str5);
    Cursor localCursor8 = paramCursor;
    int i3 = i2;
    String str6 = localCursor8.getString(i3);
    Cursor localCursor9 = paramCursor;
    String str7 = "tradeItemType";
    int i4 = localCursor9.getColumnIndex(str7);
    Cursor localCursor10 = paramCursor;
    int i5 = i4;
    int i6 = localCursor10.getInt(i5);
    Cursor localCursor11 = paramCursor;
    String str8 = "categoryPOID";
    int i7 = localCursor11.getColumnIndex(str8);
    Cursor localCursor12 = paramCursor;
    int i8 = i7;
    long l2 = localCursor12.getLong(i8);
    Cursor localCursor13 = paramCursor;
    String str9 = "transactionPOID";
    int i9 = localCursor13.getColumnIndex(str9);
    Cursor localCursor14 = paramCursor;
    int i10 = i9;
    long l3 = localCursor14.getLong(i10);
    Cursor localCursor15 = paramCursor;
    String str10 = "lastUpdateTime";
    int i11 = localCursor15.getColumnIndex(str10);
    Cursor localCursor16 = paramCursor;
    int i12 = i11;
    long l4 = localCursor16.getLong(i12);
    Object localObject = null;
    int i13 = dd.a;
    int i14 = i6;
    int i15 = i13;
    if (i14 == i15)
      localObject = new db();
    while (true)
    {
      ((dd)localObject).a(l1);
      ((dd)localObject).a(str3);
      ((dd)localObject).a(d);
      ((dd)localObject).b(str6);
      ((dd)localObject).a(i6);
      cx localcx = new cx(l2);
      ((dd)localObject).a(localcx);
      ((dd)localObject).b(l3);
      ((dd)localObject).c(l4);
      return localObject;
      int i16 = dd.b;
      int i17 = i6;
      int i18 = i16;
      if (i17 != i18)
        continue;
      localObject = new dc();
    }
  }

  static void b()
  {
    long l1 = gt.a();
    ArrayList localArrayList;
    List localList1;
    List localList2;
    while (true)
    {
      String str1;
      cu localcu;
      int i;
      try
      {
        localArrayList = new ArrayList(50);
        boolean bool1 = localArrayList.add("update t_tradeItem set currencyValue = ROUND(currencyValue, 2)");
        localList1 = c();
        localList2 = d();
        Iterator localIterator = localList1.iterator();
        if (!localIterator.hasNext())
          break;
        Map localMap = (Map)localIterator.next();
        str1 = (String)localMap.get("accountpoid");
        localcu = new cu();
        long l2 = Long.parseLong(str1);
        localcu.a(l2);
        BigDecimal localBigDecimal1 = new BigDecimal(0);
        i = Integer.parseInt((String)localMap.get("grouptype"));
        if (i == 0)
        {
          BigDecimal localBigDecimal2 = a(localList2, localcu, 1, "seller");
          BigDecimal localBigDecimal3 = a(localList2, localcu, 2, "seller");
          BigDecimal localBigDecimal4 = a(localList2, localcu, 8, "seller");
          BigDecimal localBigDecimal5 = a(localList2, localcu, 0, "buyer");
          BigDecimal localBigDecimal6 = a(localList2, localcu, 3, "buyer");
          BigDecimal localBigDecimal7 = gs.a(localBigDecimal2.add(localBigDecimal3).add(localBigDecimal4).subtract(localBigDecimal5).subtract(localBigDecimal6));
          String str2 = "update t_account set balance = " + localBigDecimal7 + " where accountPOID = " + str1;
          boolean bool2 = localArrayList.add(str2);
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        StringBuilder localStringBuilder1 = new StringBuilder().append("upgrade database to Version11, calculateAccountBalance error: ");
        String str3 = localException.getMessage();
        String str4 = str3;
        gj.a("DatabaseUpgrade13", str4);
        return;
      }
      if (1 == i)
      {
        i = 4;
        BigDecimal localBigDecimal8 = a(localList2, localcu, i, "seller");
        BigDecimal localBigDecimal9 = a(localList2, localcu, 7, "buyer");
        BigDecimal localBigDecimal10 = a(localList2, localcu, 9, "seller");
        BigDecimal localBigDecimal11 = gs.a(localBigDecimal8.subtract(localBigDecimal9).add(localBigDecimal10));
        String str5 = "update t_account set amountOfLiability = " + localBigDecimal11 + " where accountPOID = " + str1;
        boolean bool3 = localArrayList.add(str5);
        BigDecimal localBigDecimal12 = a(localList2, localcu, 2, "seller");
        BigDecimal localBigDecimal13 = a(localList2, localcu, 7, "buyer");
        BigDecimal localBigDecimal14 = gs.a(localBigDecimal12.subtract(localBigDecimal13));
        String str6 = "update t_account set balance = " + localBigDecimal14 + " where accountPOID = " + str1;
        boolean bool4 = localArrayList.add(str6);
        continue;
      }
      if (2 != i)
        continue;
      BigDecimal localBigDecimal15 = a(localList2, localcu, 5, "buyer");
      BigDecimal localBigDecimal16 = a(localList2, localcu, 6, "seller");
      BigDecimal localBigDecimal17 = a(localList2, localcu, 10, "seller");
      BigDecimal localBigDecimal18 = gs.a(localBigDecimal15.subtract(localBigDecimal16).add(localBigDecimal17));
      String str7 = "update t_account set amountOfCredit = " + localBigDecimal18 + " where accountPOID = " + str1;
      boolean bool5 = localArrayList.add(str7);
    }
    localList1.clear();
    localList2.clear();
    he.a(localArrayList, 1);
    localArrayList.clear();
    StringBuilder localStringBuilder2 = new StringBuilder().append("upgrade database to Version11,calculateAccountBalance consume time: ");
    long l3 = gt.a() - l1;
    String str8 = l3 + " mills";
    gj.a("DatabaseUpgrade13", str8);
  }

  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    bx localbx = new bx();
    localbx.a(paramSQLiteDatabase);
    return localbx.a();
  }

  private df c(Cursor paramCursor)
  {
    df localdf1 = new df();
    Cursor localCursor1 = paramCursor;
    String str1 = "id";
    int i = localCursor1.getColumnIndex(str1);
    Cursor localCursor2 = paramCursor;
    int j = i;
    long l1 = localCursor2.getLong(j);
    Cursor localCursor3 = paramCursor;
    String str2 = "tradeTime";
    int k = localCursor3.getColumnIndex(str2);
    Cursor localCursor4 = paramCursor;
    int m = k;
    long l2 = localCursor4.getLong(m);
    Cursor localCursor5 = paramCursor;
    String str3 = "createdTime";
    int n = localCursor5.getColumnIndex(str3);
    Cursor localCursor6 = paramCursor;
    int i1 = n;
    long l3 = localCursor6.getLong(i1);
    Cursor localCursor7 = paramCursor;
    String str4 = "modifiedTime";
    int i2 = localCursor7.getColumnIndex(str4);
    Cursor localCursor8 = paramCursor;
    int i3 = i2;
    long l4 = localCursor8.getLong(i3);
    Cursor localCursor9 = paramCursor;
    String str5 = "memo";
    int i4 = localCursor9.getColumnIndex(str5);
    Cursor localCursor10 = paramCursor;
    int i5 = i4;
    String str6 = localCursor10.getString(i5);
    Cursor localCursor11 = paramCursor;
    String str7 = "type";
    int i6 = localCursor11.getColumnIndex(str7);
    Cursor localCursor12 = paramCursor;
    int i7 = i6;
    int i8 = localCursor12.getInt(i7);
    Cursor localCursor13 = paramCursor;
    String str8 = "relation";
    int i9 = localCursor13.getColumnIndex(str8);
    Cursor localCursor14 = paramCursor;
    int i10 = i9;
    String str9 = localCursor14.getString(i10);
    Cursor localCursor15 = paramCursor;
    String str10 = "photoName";
    int i11 = localCursor15.getColumnIndex(str10);
    Cursor localCursor16 = paramCursor;
    int i12 = i11;
    String str11 = localCursor16.getString(i12);
    Cursor localCursor17 = paramCursor;
    String str12 = "photoNeedUpload";
    int i13 = localCursor17.getColumnIndex(str12);
    Cursor localCursor18 = paramCursor;
    int i14 = i13;
    int i15 = localCursor18.getInt(i14);
    int i16 = df.b;
    int i17 = i15;
    int i18 = i16;
    int i19;
    if (i17 == i18)
      i19 = 1;
    while (true)
    {
      Cursor localCursor19 = paramCursor;
      String str13 = "sellerId";
      int i20 = localCursor19.getColumnIndex(str13);
      Cursor localCursor20 = paramCursor;
      int i21 = i20;
      long l5 = localCursor20.getLong(i21);
      Cursor localCursor21 = paramCursor;
      String str14 = "sellerName";
      int i22 = localCursor21.getColumnIndex(str14);
      Cursor localCursor22 = paramCursor;
      int i23 = i22;
      String str15 = localCursor22.getString(i23);
      Cursor localCursor23 = paramCursor;
      String str16 = "buyerAccountId";
      int i24 = localCursor23.getColumnIndex(str16);
      Cursor localCursor24 = paramCursor;
      int i25 = i24;
      long l6 = localCursor24.getLong(i25);
      Cursor localCursor25 = paramCursor;
      String str17 = "buyerAccountName";
      int i26 = localCursor25.getColumnIndex(str17);
      Cursor localCursor26 = paramCursor;
      int i27 = i26;
      String str18 = localCursor26.getString(i27);
      Cursor localCursor27 = paramCursor;
      String str19 = "sellerAccountId";
      int i28 = localCursor27.getColumnIndex(str19);
      Cursor localCursor28 = paramCursor;
      int i29 = i28;
      long l7 = localCursor28.getLong(i29);
      Cursor localCursor29 = paramCursor;
      String str20 = "sellerAccountName";
      int i30 = localCursor29.getColumnIndex(str20);
      Cursor localCursor30 = paramCursor;
      int i31 = i30;
      String str21 = localCursor30.getString(i31);
      Cursor localCursor31 = paramCursor;
      String str22 = "projectCategoryId";
      int i32 = localCursor31.getColumnIndex(str22);
      Cursor localCursor32 = paramCursor;
      int i33 = i32;
      long l8 = localCursor32.getLong(i33);
      Cursor localCursor33 = paramCursor;
      String str23 = "projectCategoryName";
      int i34 = localCursor33.getColumnIndex(str23);
      Cursor localCursor34 = paramCursor;
      int i35 = i34;
      String str24 = localCursor34.getString(i35);
      Cursor localCursor35 = paramCursor;
      String str25 = "paymentId";
      int i36 = localCursor35.getColumnIndex(str25);
      Cursor localCursor36 = paramCursor;
      int i37 = i36;
      long l9 = localCursor36.getLong(i37);
      Cursor localCursor37 = paramCursor;
      String str26 = "paymentName";
      int i38 = localCursor37.getColumnIndex(str26);
      Cursor localCursor38 = paramCursor;
      int i39 = i38;
      String str27 = localCursor38.getString(i39);
      Cursor localCursor39 = paramCursor;
      String str28 = "paymentCurrencyType";
      int i40 = localCursor39.getColumnIndex(str28);
      Cursor localCursor40 = paramCursor;
      int i41 = i40;
      String str29 = localCursor40.getString(i41);
      Cursor localCursor41 = paramCursor;
      String str30 = "paymentCurrencyValue";
      int i42 = localCursor41.getColumnIndex(str30);
      Cursor localCursor42 = paramCursor;
      int i43 = i42;
      double d1 = localCursor42.getDouble(i43);
      Cursor localCursor43 = paramCursor;
      String str31 = "subjectItemId";
      int i44 = localCursor43.getColumnIndex(str31);
      Cursor localCursor44 = paramCursor;
      int i45 = i44;
      long l10 = localCursor44.getLong(i45);
      Cursor localCursor45 = paramCursor;
      String str32 = "subjectItemName";
      int i46 = localCursor45.getColumnIndex(str32);
      Cursor localCursor46 = paramCursor;
      int i47 = i46;
      String str33 = localCursor46.getString(i47);
      Cursor localCursor47 = paramCursor;
      String str34 = "subjectItemCurrencyType";
      int i48 = localCursor47.getColumnIndex(str34);
      Cursor localCursor48 = paramCursor;
      int i49 = i48;
      String str35 = localCursor48.getString(i49);
      Cursor localCursor49 = paramCursor;
      String str36 = "subjectItemCurrencyValue";
      int i50 = localCursor49.getColumnIndex(str36);
      Cursor localCursor50 = paramCursor;
      int i51 = i50;
      double d2 = localCursor50.getDouble(i51);
      Cursor localCursor51 = paramCursor;
      String str37 = "subjectItemCategoryId";
      int i52 = localCursor51.getColumnIndex(str37);
      Cursor localCursor52 = paramCursor;
      int i53 = i52;
      long l11 = localCursor52.getLong(i53);
      Cursor localCursor53 = paramCursor;
      String str38 = "subjectItemCategoryName";
      int i54 = localCursor53.getColumnIndex(str38);
      Cursor localCursor54 = paramCursor;
      int i55 = i54;
      String str39 = localCursor54.getString(i55);
      Cursor localCursor55 = paramCursor;
      String str40 = "_tempIconName";
      int i56 = localCursor55.getColumnIndex(str40);
      Cursor localCursor56 = paramCursor;
      int i57 = i56;
      String str41 = localCursor56.getString(i57);
      cx localcx1 = new cx();
      cx localcx2 = localcx1;
      long l12 = l8;
      localcx2.b(l12);
      cx localcx3 = localcx1;
      String str42 = str24;
      localcx3.c(str42);
      cy localcy1 = new cy();
      cy localcy2 = localcy1;
      long l13 = l5;
      localcy2.a(l13);
      cy localcy3 = localcy1;
      String str43 = str15;
      localcy3.a(str43);
      cu localcu1 = new cu();
      cu localcu2 = localcu1;
      long l14 = l7;
      localcu2.a(l14);
      cu localcu3 = localcu1;
      String str44 = str21;
      localcu3.a(str44);
      cz localcz1 = new cz();
      cz localcz2 = localcz1;
      cy localcy4 = localcy1;
      localcz2.a(localcy4);
      cz localcz3 = localcz1;
      cu localcu4 = localcu1;
      localcz3.a(localcu4);
      cu localcu5 = new cu();
      cu localcu6 = localcu5;
      long l15 = l6;
      localcu6.a(l15);
      cu localcu7 = localcu5;
      String str45 = str18;
      localcu7.a(str45);
      cz localcz4 = new cz();
      cz localcz5 = localcz4;
      cu localcu8 = localcu5;
      localcz5.a(localcu8);
      dg localdg1 = new dg;
      long l16 = ApplicationContext.d;
      dg localdg2 = localdg1;
      long l17 = l16;
      localdg2.<init>(l17);
      cz localcz6 = localcz4;
      dg localdg3 = localdg1;
      localcz6.a(localdg3);
      db localdb1 = new db();
      db localdb2 = localdb1;
      long l18 = l9;
      localdb2.a(l18);
      db localdb3 = localdb1;
      String str46 = str27;
      localdb3.b(str46);
      db localdb4 = localdb1;
      String str47 = str29;
      localdb4.a(str47);
      db localdb5 = localdb1;
      double d3 = d1;
      localdb5.a(d3);
      dc localdc1 = new dc();
      dc localdc2 = localdc1;
      long l19 = l10;
      localdc2.a(l19);
      dc localdc3 = localdc1;
      String str48 = str33;
      localdc3.b(str48);
      dc localdc4 = localdc1;
      String str49 = str35;
      localdc4.a(str49);
      dc localdc5 = localdc1;
      double d4 = d2;
      localdc5.a(d4);
      cx localcx4 = new cx();
      cx localcx5 = localcx4;
      long l20 = l11;
      localcx5.b(l20);
      cx localcx6 = localcx4;
      String str50 = str39;
      localcx6.c(str50);
      cx localcx7 = localcx4;
      String str51 = str41;
      str51.b(null);
      localdc1.a(localcx4);
      localdf1.a(l1);
      long l21 = ha.b(l2);
      l21.d(-1);
      localdf1.b(l3);
      localdf1.c(l4);
      localdf1.a(str6);
      localdf1.a(i8);
      localdf1.c(str9);
      df localdf2 = localdf1;
      String str52 = str35;
      str52.d(2);
      localdf1.b(str11);
      df localdf3 = localdf1;
      int i58 = i19;
      i58.a(true);
      df localdf4 = localdf1;
      db localdb6 = localdb1;
      localdb6.a(0L);
      df localdf5 = localdf1;
      dc localdc6 = localdc1;
      localdc6.b(0.0F);
      df localdf6 = localdf1;
      cz localcz7 = localcz4;
      localcz7.a(2.0F);
      df localdf7 = localdf1;
      cz localcz8 = localcz1;
      localcz8.b(1.0D);
      df localdf8 = localdf1;
      paramCursor = new [25];
      return localdf1;
      i19 = 0;
      tmpTernaryOp = -18943;
    }
  }

  static List c()
  {
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "1";
    arrayOfString[1] = "0";
    arrayOfString[2] = "1";
    arrayOfString[3] = "2";
    arrayOfString[4] = "2";
    arrayOfString[5] = "2";
    return he.a(null, "SELECT a.accountPOID, a.name, ag.type as groupType, a.balance, a.amountOfLiability, a.amountOfCredit FROM t_account AS a INNER JOIN t_account_group AS ag ON a.accountGroupPOID = ag.accountGroupPOID", arrayOfString, null);
  }

  static List d()
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "1";
    arrayOfString[1] = "1";
    arrayOfString[2] = "1";
    arrayOfString[3] = "2";
    return he.a(null, "SELECT trans.buyerAccountPOID, trans.sellerAccountPOID,trans.type, ( CASE WHEN sum(tradeItem.currencyValue)IS NULL THEN 0 ELSE sum(tradeItem.currencyValue) END ) AS amount FROM t_transaction AS trans INNER JOIN t_tradeItem AS tradeItem ON trans.transactionPOID = tradeItem.transactionPOID AND tradeItem.tradeItemType = 1 GROUP BY trans.buyerAccountPOID, trans.sellerAccountPOID, trans.type", arrayOfString, null);
  }

  public long a(long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    String str1 = cs.b;
    Long localLong1 = Long.valueOf(paramLong1);
    localContentValues.put(str1, localLong1);
    String str2 = cs.c;
    Long localLong2 = Long.valueOf(paramLong2);
    localContentValues.put(str2, localLong2);
    SQLiteDatabase localSQLiteDatabase = this.a;
    String str3 = cs.a;
    return localSQLiteDatabase.insert(str3, null, localContentValues);
  }

  public long a(dc paramdc)
  {
    int i = dd.b;
    return a(i, paramdc);
  }

  public List a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = e;
    String str2 = str1 + " where trans.buyerAccountPOID = ?";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    return a(str2, arrayOfString);
  }

  public void a(String paramString, dd paramdd)
  {
    long l1 = paramdd.a();
    String str1 = paramdd.b();
    double d = paramdd.c();
    String str2 = paramdd.f();
    long l2 = paramdd.g().f();
    int i = paramdd.i();
    long l3 = paramdd.d();
    long l4;
    if (paramdd.h() > 0L)
      l4 = paramdd.h();
    while (true)
    {
      ContentValues localContentValues1 = new ContentValues(7);
      String str3 = cq.c;
      Long localLong1 = Long.valueOf(l1);
      ContentValues localContentValues2 = localContentValues1;
      String str4 = str3;
      Long localLong2 = localLong1;
      localContentValues2.put(str4, localLong2);
      String str5 = cq.d;
      ContentValues localContentValues3 = localContentValues1;
      String str6 = str5;
      String str7 = str1;
      localContentValues3.put(str6, str7);
      String str8 = cq.e;
      String str9 = String.valueOf(gs.a(new BigDecimal(d)));
      ContentValues localContentValues4 = localContentValues1;
      String str10 = str8;
      String str11 = str9;
      localContentValues4.put(str10, str11);
      String str12 = cq.f;
      ContentValues localContentValues5 = localContentValues1;
      String str13 = str12;
      String str14 = str2;
      localContentValues5.put(str13, str14);
      String str15 = cq.j;
      Long localLong3 = Long.valueOf(l2);
      ContentValues localContentValues6 = localContentValues1;
      String str16 = str15;
      Long localLong4 = localLong3;
      localContentValues6.put(str16, localLong4);
      String str17 = cq.g;
      Integer localInteger1 = Integer.valueOf(i);
      ContentValues localContentValues7 = localContentValues1;
      String str18 = str17;
      Integer localInteger2 = localInteger1;
      localContentValues7.put(str18, localInteger2);
      String str19 = cq.k;
      Long localLong5 = Long.valueOf(l3);
      ContentValues localContentValues8 = localContentValues1;
      String str20 = str19;
      Long localLong6 = localLong5;
      localContentValues8.put(str20, localLong6);
      String str21 = cq.l;
      Long localLong7 = Long.valueOf(l4);
      ContentValues localContentValues9 = localContentValues1;
      String str22 = str21;
      Long localLong8 = localLong7;
      localContentValues9.put(str22, localLong8);
      SQLiteDatabase localSQLiteDatabase = this.a;
      String str23 = paramString;
      String str24 = null;
      ContentValues localContentValues10 = localContentValues1;
      long l5 = localSQLiteDatabase.insert(str23, str24, localContentValues10);
      return;
      l4 = gt.f();
    }
  }

  protected void a(String paramString, df paramdf)
  {
    long l1 = paramdf.a();
    long l2 = paramdf.b();
    long l3 = paramdf.d();
    long l4 = paramdf.k();
    String str1 = paramdf.e();
    String str2 = paramdf.m();
    boolean bool = paramdf.o();
    int i = paramdf.c();
    String str3 = paramdf.n();
    long l5 = paramdf.g().b().a();
    long l6 = paramdf.h().b().a();
    long l7 = paramdf.g().a().a();
    long l8 = paramdf.h().a().a();
    long l9;
    ContentValues localContentValues1;
    String str23;
    if (paramdf.l() > 0L)
    {
      l9 = paramdf.l();
      localContentValues1 = new ContentValues(11);
      String str4 = cr.c;
      Long localLong1 = Long.valueOf(l1);
      ContentValues localContentValues2 = localContentValues1;
      String str5 = str4;
      Long localLong2 = localLong1;
      localContentValues2.put(str5, localLong2);
      String str6 = cr.d;
      Long localLong3 = Long.valueOf(l2);
      ContentValues localContentValues3 = localContentValues1;
      String str7 = str6;
      Long localLong4 = localLong3;
      localContentValues3.put(str7, localLong4);
      String str8 = cr.e;
      Long localLong5 = Long.valueOf(l3);
      ContentValues localContentValues4 = localContentValues1;
      String str9 = str8;
      Long localLong6 = localLong5;
      localContentValues4.put(str9, localLong6);
      String str10 = cr.f;
      Long localLong7 = Long.valueOf(l4);
      ContentValues localContentValues5 = localContentValues1;
      String str11 = str10;
      Long localLong8 = localLong7;
      localContentValues5.put(str11, localLong8);
      String str12 = cr.g;
      Integer localInteger1 = Integer.valueOf(i);
      ContentValues localContentValues6 = localContentValues1;
      String str13 = str12;
      Integer localInteger2 = localInteger1;
      localContentValues6.put(str13, localInteger2);
      String str14 = cr.h;
      ContentValues localContentValues7 = localContentValues1;
      String str15 = str14;
      String str16 = str3;
      localContentValues7.put(str15, str16);
      String str17 = cr.i;
      ContentValues localContentValues8 = localContentValues1;
      String str18 = str17;
      String str19 = str1;
      localContentValues8.put(str18, str19);
      String str20 = cr.j;
      ContentValues localContentValues9 = localContentValues1;
      String str21 = str20;
      String str22 = str2;
      localContentValues9.put(str21, str22);
      str23 = cr.k;
      if (!bool)
        break label685;
    }
    label685: for (int j = df.b; ; j = df.a)
    {
      Integer localInteger3 = Integer.valueOf(j);
      ContentValues localContentValues10 = localContentValues1;
      String str24 = str23;
      Integer localInteger4 = localInteger3;
      localContentValues10.put(str24, localInteger4);
      String str25 = cr.l;
      Long localLong9 = Long.valueOf(ApplicationContext.d);
      ContentValues localContentValues11 = localContentValues1;
      String str26 = str25;
      Long localLong10 = localLong9;
      localContentValues11.put(str26, localLong10);
      String str27 = cr.m;
      Long localLong11 = Long.valueOf(ApplicationContext.d);
      ContentValues localContentValues12 = localContentValues1;
      String str28 = str27;
      Long localLong12 = localLong11;
      localContentValues12.put(str28, localLong12);
      String str29 = cr.n;
      Long localLong13 = Long.valueOf(l5);
      ContentValues localContentValues13 = localContentValues1;
      String str30 = str29;
      Long localLong14 = localLong13;
      localContentValues13.put(str30, localLong14);
      String str31 = cr.o;
      Long localLong15 = Long.valueOf(l6);
      ContentValues localContentValues14 = localContentValues1;
      String str32 = str31;
      Long localLong16 = localLong15;
      localContentValues14.put(str32, localLong16);
      String str33 = cr.p;
      Long localLong17 = Long.valueOf(l7);
      ContentValues localContentValues15 = localContentValues1;
      String str34 = str33;
      Long localLong18 = localLong17;
      localContentValues15.put(str34, localLong18);
      String str35 = cr.q;
      Long localLong19 = Long.valueOf(l8);
      ContentValues localContentValues16 = localContentValues1;
      String str36 = str35;
      Long localLong20 = localLong19;
      localContentValues16.put(str36, localLong20);
      String str37 = cr.r;
      Long localLong21 = Long.valueOf(l9);
      ContentValues localContentValues17 = localContentValues1;
      String str38 = str37;
      Long localLong22 = localLong21;
      localContentValues17.put(str38, localLong22);
      SQLiteDatabase localSQLiteDatabase = this.a;
      String str39 = paramString;
      String str40 = null;
      ContentValues localContentValues18 = localContentValues1;
      long l10 = localSQLiteDatabase.insert(str39, str40, localContentValues18);
      return;
      l9 = gt.f();
      break;
    }
  }

  public boolean a()
  {
    gj.a("DatabaseUpgrade13", "upgrade database to Version13");
    ArrayList localArrayList1 = new ArrayList(50);
    String str1 = "update t_profile set syncLabel = '" + "" + "'";
    boolean bool1 = localArrayList1.add(str1);
    he.a(localArrayList1, 1);
    localArrayList1.clear();
    Object localObject = this.a.rawQuery("select      account.accountPOID as accountPOID,      accountGroup.type as accountGroupType   from       t_account as account      inner join t_account_group as accountGroup on account.accountGroupPOID = accountGroup.accountGroupPOID", null);
    int i = ((Cursor)localObject).getCount();
    ArrayList localArrayList2 = new ArrayList(i);
    while (((Cursor)localObject).moveToNext())
    {
      cu localcu = new cu();
      int k = ((Cursor)localObject).getColumnIndex("accountPOID");
      long l1 = ((Cursor)localObject).getLong(k);
      localcu.a(l1);
      cv localcv = new cv();
      int m = ((Cursor)localObject).getColumnIndex("accountGroupType");
      int n = ((Cursor)localObject).getInt(m);
      localcv.a(n);
      localcu.a(localcv);
      boolean bool2 = localArrayList2.add(localcu);
    }
    ((Cursor)localObject).close();
    Iterator localIterator2 = localArrayList2.iterator();
    break label539;
    label227: int j;
    Iterator localIterator3;
    do
      while (true)
      {
        if (!localIterator2.hasNext())
          break label788;
        localObject = (cu)localIterator2.next();
        j = ((cu)localObject).c().d();
        if (1 != j)
          break;
        long l2 = ((cu)localObject).a();
        localIterator3 = a(l2).iterator();
        while (localIterator3.hasNext())
        {
          df localdf1 = (df)localIterator3.next();
          if (!TextUtils.isEmpty(localdf1.n()))
            continue;
          String str2 = UUID.randomUUID().toString();
          localdf1.c(str2);
          long l4 = localdf1.a();
          boolean bool3 = b(l4);
          boolean bool4 = a(localdf1);
          long l5 = localdf1.g().a().a();
          long l6 = localdf1.g().b().a();
          dc localdc = (dc)localdf1.j();
          localdf1.a(4);
          localdf1.c(str2);
          localdf1.h().a().a(l5);
          localdf1.h().b().a(l6);
          localdf1.g().a().a(0L);
          localdf1.g().b().a(0L);
          long l7 = b(localdf1);
          localdc.b(l7);
          long l8 = a(localdc);
          long l3 = localdf1.f().f();
          if (l3 == 0L)
            continue;
          long l9 = a(l7, l3);
        }
      }
    while (j != 0);
    long l10 = ((cu)localObject).a();
    Iterator localIterator1 = a(l10).iterator();
    while (true)
    {
      label539: if (!localIterator1.hasNext())
        break label227;
      String str3 = ((df)localIterator1.next()).n();
      if (TextUtils.isEmpty(str3))
        break;
      localIterator3 = b(str3).iterator();
      while (localIterator3.hasNext())
      {
        df localdf2 = (df)localIterator3.next();
        int i1 = localdf2.c();
        long l11 = localdf2.a();
        if (4 != i1)
          continue;
        List localList = c(l11);
        SQLiteDatabase localSQLiteDatabase1 = this.a;
        String str4 = cq.a;
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str5 = cq.c;
        String str6 = str5 + " = ?";
        String[] arrayOfString1 = new String[1];
        String str7 = String.valueOf(l11);
        arrayOfString1[0] = str7;
        int i2 = localSQLiteDatabase1.delete(str4, str6, arrayOfString1);
        StringBuilder localStringBuilder2 = new StringBuilder();
        String str8 = cr.c;
        String str9 = str8 + " = ?";
        String[] arrayOfString2 = new String[1];
        String str10 = String.valueOf(l11);
        arrayOfString2[0] = str10;
        SQLiteDatabase localSQLiteDatabase2 = this.a;
        String str11 = cr.a;
        int i3 = localSQLiteDatabase2.delete(str11, str9, arrayOfString2);
      }
    }
    label788: b();
    return true;
  }

  public boolean a(long paramLong, dd paramdd)
  {
    cx localcx = paramdd.g();
    ContentValues localContentValues = new ContentValues();
    String str1 = cq.d;
    String str2 = paramdd.b();
    localContentValues.put(str1, str2);
    String str3 = cq.e;
    double d = paramdd.c();
    String str4 = String.valueOf(gs.a(new BigDecimal(d)));
    localContentValues.put(str3, str4);
    String str5 = cq.h;
    Double localDouble = Double.valueOf(paramdd.e());
    localContentValues.put(str5, localDouble);
    String str6 = cq.f;
    String str7 = paramdd.f();
    localContentValues.put(str6, str7);
    if (localcx != null)
    {
      String str8 = cq.j;
      Long localLong1 = Long.valueOf(localcx.f());
      localContentValues.put(str8, localLong1);
    }
    String str9 = cq.l;
    Long localLong2 = Long.valueOf(gt.f());
    localContentValues.put(str9, localLong2);
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str10 = cq.c;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str10).append(" = ? and ");
    String str11 = cq.k;
    String str12 = str11 + " = ?";
    String[] arrayOfString = new String[2];
    String str13 = String.valueOf(paramdd.a());
    arrayOfString[0] = str13;
    String str14 = String.valueOf(paramLong);
    arrayOfString[1] = str14;
    SQLiteDatabase localSQLiteDatabase = this.a;
    String str15 = cq.a;
    if (localSQLiteDatabase.update(str15, localContentValues, str12, arrayOfString) > 0L);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean a(df paramdf)
  {
    long l1 = paramdf.a();
    int i = paramdf.c();
    long l2 = paramdf.d();
    long l3 = ha.a(paramdf.k());
    String str1 = paramdf.e();
    String str2 = paramdf.m();
    boolean bool1 = paramdf.o();
    String str3 = paramdf.n();
    boolean bool2 = b(l1);
    ContentValues localContentValues = new ContentValues(7);
    String str4 = cr.e;
    Long localLong1 = Long.valueOf(gt.f());
    localContentValues.put(str4, localLong1);
    String str5 = cr.f;
    Long localLong2 = Long.valueOf(l3);
    localContentValues.put(str5, localLong2);
    String str6 = cr.i;
    localContentValues.put(str6, str1);
    String str7 = cr.j;
    localContentValues.put(str7, str2);
    String str8 = cr.k;
    int j;
    if (bool1)
    {
      j = df.b;
      Integer localInteger = Integer.valueOf(j);
      localContentValues.put(str8, localInteger);
      String str9 = cr.r;
      Long localLong3 = Long.valueOf(gt.f());
      localContentValues.put(str9, localLong3);
      String str10 = cr.h;
      localContentValues.put(str10, str3);
      if (i != 0)
        break label415;
      long l4 = paramdf.g().a().a();
      long l5 = paramdf.h().b().a();
      String str11 = cr.p;
      Long localLong4 = Long.valueOf(l4);
      localContentValues.put(str11, localLong4);
      String str12 = cr.o;
      Long localLong5 = Long.valueOf(l5);
      localContentValues.put(str12, localLong5);
      label277: SQLiteDatabase localSQLiteDatabase = this.a;
      String str13 = cr.a;
      String[] arrayOfString = new String[1];
      String str14 = String.valueOf(l1);
      arrayOfString[0] = str14;
      int k = localSQLiteDatabase.update(str13, localContentValues, " transactionPOID = ?", arrayOfString);
      if ((paramdf.f() != null) && (paramdf.f().f() != 0L))
      {
        long l6 = paramdf.f().f();
        long l7 = a(l1, l6);
      }
      if (i == 0)
      {
        dd localdd1 = paramdf.i();
        boolean bool3 = a(l1, localdd1);
      }
      dd localdd2 = paramdf.j();
      boolean bool4 = a(l1, localdd2);
      if (k <= 0)
        break label457;
    }
    label415: label457: for (int m = 1; ; m = 0)
    {
      return m;
      j = df.a;
      break;
      if (i != 1)
        break label277;
      long l8 = paramdf.h().a().a();
      String str15 = cr.q;
      Long localLong6 = Long.valueOf(l8);
      localContentValues.put(str15, localLong6);
      break label277;
    }
  }

  public long b(df paramdf)
  {
    String str1 = cr.a;
    long l1 = c(str1);
    paramdf.a(l1);
    long l2 = ha.a(paramdf.k());
    paramdf.d(l2);
    String str2 = cr.a;
    a(str2, paramdf);
    long l3 = c;
    String str3 = cr.a;
    a(l1, l3, str3);
    return l1;
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
      String str1 = e;
      str2 = str1 + " where trans.relation = ?";
      arrayOfString = new String[1];
      arrayOfString[0] = paramString;
    }
  }

  public boolean b(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = this.a;
    String str1 = cs.a;
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = cs.b;
    String str3 = str2 + " = ?";
    String[] arrayOfString = new String[1];
    String str4 = String.valueOf(paramLong);
    arrayOfString[0] = str4;
    if (localSQLiteDatabase.delete(str1, str3, arrayOfString) > 0L);
    for (int i = 1; ; i = 0)
      return i;
  }

  public List c(long paramLong)
  {
    String[] arrayOfString = new String[1];
    String str = String.valueOf(paramLong);
    arrayOfString[0] = str;
    Cursor localCursor = this.a.rawQuery(" select tradeItemPOID,currencyType,currencyValue,name,tradeItemType,categoryPOID,    transactionPOID,lastUpdateTime  from t_tradeItem where transactionPOID = ?", arrayOfString);
    int i = localCursor.getCount();
    ArrayList localArrayList = new ArrayList(i);
    while (localCursor.moveToNext())
    {
      dd localdd = b(localCursor);
      boolean bool = localArrayList.add(localdd);
    }
    a(localCursor);
    return localArrayList;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     bx
 * JD-Core Version:    0.6.0
 */