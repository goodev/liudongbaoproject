import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ba extends ar
{
  private static String a = " order by amount desc ";
  private static ba c = null;

  public static ba a()
  {
    if (c == null)
      c = new ba();
    return c;
  }

  private String a(long paramLong1, long paramLong2, List paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramLong1 != 65535L)
    {
      String str1 = String.valueOf(paramLong1);
      boolean bool1 = paramList.add(str1);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(" and t.tradeTime >= ? ");
    }
    if (paramLong2 != 65535L)
    {
      String str2 = String.valueOf(paramLong2);
      boolean bool2 = paramList.add(str2);
      StringBuilder localStringBuilder3 = localStringBuilder1.append(" and t.tradeTime <= ? ");
    }
    return localStringBuilder1.toString();
  }

  private String a(String paramString1, String paramString2, List paramList)
  {
    int i = 0;
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (!gx.a(paramString1))
    {
      i = 1;
      boolean bool1 = paramList.add(paramString1);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(" HAVING amount >= ?");
    }
    if (!gx.a(paramString2))
    {
      if (i != 0)
        break label76;
      StringBuilder localStringBuilder3 = localStringBuilder1.append(" HAVING amount <= ?");
    }
    while (true)
    {
      boolean bool2 = paramList.add(paramString2);
      return localStringBuilder1.toString();
      label76: StringBuilder localStringBuilder4 = localStringBuilder1.append(" and amount <=  ?");
    }
  }

  private String a(long[] paramArrayOfLong, List paramList)
  {
    StringBuilder localStringBuilder;
    String str1;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      localStringBuilder = new StringBuilder().append(" and c.parentCategoryPOID in ");
      str1 = d(paramArrayOfLong, paramList);
    }
    for (String str2 = str1; ; str2 = "")
      return str2;
  }

  private String a(long[] paramArrayOfLong, List paramList, boolean paramBoolean)
  {
    String str1 = "buyerAccountPOID";
    if (!paramBoolean)
      str1 = "sellerAccountPOID";
    StringBuilder localStringBuilder;
    String str2;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      localStringBuilder = new StringBuilder().append(" and t.").append(str1).append(" in ");
      str2 = d(paramArrayOfLong, paramList);
    }
    for (str1 = str2; ; str1 = "")
      return str1;
  }

  private String b(long[] paramArrayOfLong, List paramList)
  {
    StringBuilder localStringBuilder;
    String str1;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      localStringBuilder = new StringBuilder().append(" and tpm.projectCategoryPOID in ");
      str1 = d(paramArrayOfLong, paramList);
    }
    for (String str2 = str1; ; str2 = "")
      return str2;
  }

  private String c(long[] paramArrayOfLong, List paramList)
  {
    StringBuilder localStringBuilder;
    String str1;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      localStringBuilder = new StringBuilder().append(" and t.relationUnitPOID in ");
      str1 = d(paramArrayOfLong, paramList);
    }
    for (String str2 = str1; ; str2 = "")
      return str2;
  }

  private String d(long[] paramArrayOfLong, List paramList)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("(");
    int i = 0;
    while (true)
    {
      int j = paramArrayOfLong.length;
      if (i >= j)
        break;
      StringBuilder localStringBuilder2 = localStringBuilder1.append("?").append(",");
      String str1 = String.valueOf(paramArrayOfLong[i]);
      boolean bool = paramList.add(str1);
      i += 1;
    }
    int k = localStringBuilder1.length() - 1;
    String str2 = localStringBuilder1.substring(0, k);
    localStringBuilder1.setLength(0);
    StringBuilder localStringBuilder3 = localStringBuilder1.append(str2).append(")");
    return localStringBuilder1.toString();
  }

  private String f(String paramString)
  {
    String str1;
    if (gx.a(paramString))
      str1 = "";
    while (true)
    {
      return str1;
      if (paramString.startsWith("0"))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = paramString.substring(1);
        str1 = str2 + "月";
        continue;
      }
      str1 = paramString + "月";
    }
  }

  private String g(String paramString)
  {
    if (!gx.a(paramString));
    for (String str = " and t.memo like '%" + paramString + "%'"; ; str = "")
      return str;
  }

  public BigDecimal a(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("SELECT sum(  ");
    StringBuilder localStringBuilder3 = localStringBuilder1.append(" (case when e.rate is null then 1 else e.rate end) *  ");
    StringBuilder localStringBuilder4 = localStringBuilder1.append(" (   case when g.type = 0 then (case when a.balance > 0 then a.balance else 0 end)");
    StringBuilder localStringBuilder5 = localStringBuilder1.append("          when g.type = 1 then (case when a.balance > 0 then a.balance else 0 end)");
    StringBuilder localStringBuilder6 = localStringBuilder1.append("          when g.type = 2 then (case when a.amountOfCredit > 0 then a.amountOfCredit else 0 end) ");
    StringBuilder localStringBuilder7 = localStringBuilder1.append("          else (case when a.balance > 0 then a.balance else 0 end) end)");
    StringBuilder localStringBuilder8 = localStringBuilder1.append(") as totalAmount");
    StringBuilder localStringBuilder9 = localStringBuilder1.append(" from t_account a");
    StringBuilder localStringBuilder10 = localStringBuilder1.append(" INNER JOIN t_account_group g on a.accountGroupPOID = g.accountGroupPOID");
    StringBuilder localStringBuilder11 = localStringBuilder1.append(" LEFT JOIN t_exchange as e on e.buy = '").append(paramString).append("' and e.sell = a.currencyType");
    String str1 = localStringBuilder1.toString();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "2";
    String str2 = (String)he.b(str1, arrayOfString, null).get("totalamount");
    return new BigDecimal(str2);
  }

  public List a(int paramInt, String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, String paramString2, String paramString3, String paramString4)
  {
    LinkedList localLinkedList1 = new LinkedList();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("select categoryPOID, name, _tempIconName as iconName, trans.amount from t_category ");
    StringBuilder localStringBuilder3 = localStringBuilder1.append("INNER join (");
    StringBuilder localStringBuilder4 = localStringBuilder1.append("     select c.categoryPOID as secondLevelCategoryID,");
    StringBuilder localStringBuilder5 = localStringBuilder1.append("     sum( (case when e.rate is null then 1 else e.rate end) * t.sellerMoney ) as amount ");
    StringBuilder localStringBuilder6 = localStringBuilder1.append("     from t_transaction as t ");
    if (paramInt == 0)
    {
      StringBuilder localStringBuilder7 = localStringBuilder1.append(" INNER JOIN t_account as acc on acc.accountPOID = t.buyerAccountPOID");
      StringBuilder localStringBuilder8 = localStringBuilder1.append("     LEFT JOIN t_exchange as e on e.buy = '").append(paramString1).append("' and e.sell = acc.currencyType ");
      StringBuilder localStringBuilder9 = localStringBuilder1.append("     INNER JOIN t_category as c on c.categoryPOID = (case when t.type  = 0 then t.sellerCategoryPOID when t.type  = 1 then t.buyerCategoryPOID else t.sellerCategoryPOID end)");
      if ((paramArrayOfLong3 != null) && (paramArrayOfLong3.length > 0))
        StringBuilder localStringBuilder10 = localStringBuilder1.append(" INNER JOIN t_transaction_projectcategory_map as tpm on tpm.transactionPOID = t.transactionPOID ");
      if (paramInt != 0)
        break label515;
      StringBuilder localStringBuilder11 = localStringBuilder1.append(" where t.type =  0");
      label136: ba localba1 = this;
      long l1 = paramLong1;
      long l2 = paramLong2;
      String str1 = localba1.a(l1, l2, localLinkedList1);
      StringBuilder localStringBuilder12 = localStringBuilder1.append(str1);
      ba localba2 = this;
      long[] arrayOfLong1 = paramArrayOfLong2;
      LinkedList localLinkedList2 = localLinkedList1;
      int i = 1;
      String str2 = localba2.a(arrayOfLong1, localLinkedList2, i);
      StringBuilder localStringBuilder13 = localStringBuilder1.append(str2);
      ba localba3 = this;
      long[] arrayOfLong2 = paramArrayOfLong3;
      LinkedList localLinkedList3 = localLinkedList1;
      String str3 = localba3.b(arrayOfLong2, localLinkedList3);
      StringBuilder localStringBuilder14 = localStringBuilder1.append(str3);
      ba localba4 = this;
      long[] arrayOfLong3 = paramArrayOfLong3;
      LinkedList localLinkedList4 = localLinkedList1;
      String str4 = localba4.c(arrayOfLong3, localLinkedList4);
      StringBuilder localStringBuilder15 = localStringBuilder1.append(str4);
      ba localba5 = this;
      String str5 = paramString2;
      String str6 = localba5.g(str5);
      StringBuilder localStringBuilder16 = localStringBuilder1.append(str6);
      StringBuilder localStringBuilder17 = localStringBuilder1.append(" GROUP BY  c.categoryPOID ");
      ba localba6 = this;
      String str7 = paramString3;
      String str8 = paramString4;
      LinkedList localLinkedList5 = localLinkedList1;
      String str9 = localba6.a(str7, str8, localLinkedList5);
      StringBuilder localStringBuilder18 = localStringBuilder1.append(str9);
      StringBuilder localStringBuilder19 = localStringBuilder1.append(") as trans on categoryPOID =  trans.secondLevelCategoryID ");
      if ((paramArrayOfLong1 == 0) || (paramArrayOfLong1.length <= 0))
        break label532;
      StringBuilder localStringBuilder20 = localStringBuilder1.append(" where t_category.categoryPOID in ");
      ba localba7 = this;
      long l3 = paramArrayOfLong1;
      LinkedList localLinkedList6 = localLinkedList1;
      String str10 = localba7.d(l3, localLinkedList6);
      StringBuilder localStringBuilder21 = localStringBuilder20.append(str10);
    }
    while (true)
    {
      String str11 = a;
      StringBuilder localStringBuilder22 = localStringBuilder1.append(str11);
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString1 = new String[localLinkedList1.size()];
      String str12 = localStringBuilder1.toString();
      String[] arrayOfString2 = (String[])localLinkedList1.toArray(arrayOfString1);
      bf localbf = new bf(this, localArrayList);
      Object localObject = a(str12, arrayOfString2, localbf);
      localLinkedList1.clear();
      return localArrayList;
      if (1 == paramInt)
      {
        StringBuilder localStringBuilder23 = localStringBuilder1.append(" INNER JOIN t_account as acc on acc.accountPOID = t.sellerAccountPOID");
        break;
      }
      throw new IllegalArgumentException("unsupport category type ,category type is payout or income");
      label515: if (1 != paramInt)
        break label136;
      StringBuilder localStringBuilder24 = localStringBuilder1.append(" where t.type =  1");
      break label136;
      label532: String str13 = " where t_category.depth = 2 and t_category.type = " + paramInt;
      StringBuilder localStringBuilder25 = localStringBuilder1.append(str13);
    }
  }

  public List a(String paramString, long paramLong1, long paramLong2)
  {
    LinkedList localLinkedList = new LinkedList();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("select strftime('%m',date(substr(t.tradeTime,1,length(t.tradeTime)-3), 'unixepoch', 'localtime'),'localtime') as tradeMonth, ");
    StringBuilder localStringBuilder3 = localStringBuilder1.append(" sum( (case when e.rate is null then 1 else e.rate end) * t.sellerMoney ) as amount ");
    StringBuilder localStringBuilder4 = localStringBuilder1.append(" from t_transaction as t");
    StringBuilder localStringBuilder5 = localStringBuilder1.append(" INNER JOIN t_account as acc on acc.accountPOID = t.sellerAccountPOID");
    String str1 = " LEFT JOIN t_exchange as e on e.buy ='" + paramString + "' and e.sell = acc.currencyType";
    StringBuilder localStringBuilder6 = localStringBuilder1.append(str1);
    StringBuilder localStringBuilder7 = localStringBuilder1.append(" where t.type = 1 ");
    ba localba = this;
    long l1 = paramLong1;
    long l2 = paramLong2;
    String str2 = localba.a(l1, l2, localLinkedList);
    StringBuilder localStringBuilder8 = localStringBuilder1.append(str2);
    StringBuilder localStringBuilder9 = localStringBuilder1.append(" GROUP BY tradeMonth ");
    StringBuilder localStringBuilder10 = localStringBuilder1.append(" ORDER BY tradeMonth DESC ");
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1 = new String[localLinkedList.size()];
    String str3 = localStringBuilder1.toString();
    String[] arrayOfString2 = (String[])localLinkedList.toArray(arrayOfString1);
    bm localbm = new bm(this, localArrayList);
    Object localObject = a(str3, arrayOfString2, localbm);
    localLinkedList.clear();
    return localArrayList;
  }

  public List a(String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, String paramString2, String paramString3, String paramString4)
  {
    LinkedList localLinkedList1 = new LinkedList();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("select categoryPOID, name, _tempIconName as iconName, trans.amount from t_category ");
    StringBuilder localStringBuilder3 = localStringBuilder1.append("INNER join (");
    StringBuilder localStringBuilder4 = localStringBuilder1.append("     select parentCategory.categoryPOID as firstCategoryID,");
    StringBuilder localStringBuilder5 = localStringBuilder1.append("     sum( (case when e.rate is null then 1 else e.rate end) * t.sellerMoney ) as amount ");
    StringBuilder localStringBuilder6 = localStringBuilder1.append("     from t_transaction as t ");
    StringBuilder localStringBuilder7 = localStringBuilder1.append("     INNER JOIN t_account as acc on acc.accountPOID = t.buyerAccountPOID");
    StringBuilder localStringBuilder8 = localStringBuilder1.append("     LEFT JOIN t_exchange as e on e.buy = '").append(paramString1).append("' and e.sell = acc.currencyType ");
    StringBuilder localStringBuilder9 = localStringBuilder1.append("     INNER JOIN t_category as c on c.categoryPOID = (case when t.type  = 0 then t.sellerCategoryPOID when t.type  = 1 then t.buyerCategoryPOID else t.sellerCategoryPOID end)");
    StringBuilder localStringBuilder10 = localStringBuilder1.append("     INNER JOIN t_category as parentCategory on parentCategory.categoryPOID = c.parentCategoryPOID ");
    if ((paramArrayOfLong3 != null) && (paramArrayOfLong3.length > 0))
      StringBuilder localStringBuilder11 = localStringBuilder1.append(" INNER JOIN t_transaction_projectcategory_map as tpm on tpm.transactionPOID = t.transactionPOID ");
    StringBuilder localStringBuilder12 = localStringBuilder1.append(" where t.type = 0 ");
    ba localba1 = this;
    long l1 = paramLong1;
    long l2 = paramLong2;
    String str1 = localba1.a(l1, l2, localLinkedList1);
    StringBuilder localStringBuilder13 = localStringBuilder1.append(str1);
    ba localba2 = this;
    long[] arrayOfLong1 = paramArrayOfLong2;
    LinkedList localLinkedList2 = localLinkedList1;
    int i = 1;
    String str2 = localba2.a(arrayOfLong1, localLinkedList2, i);
    StringBuilder localStringBuilder14 = localStringBuilder1.append(str2);
    ba localba3 = this;
    long[] arrayOfLong2 = paramArrayOfLong3;
    LinkedList localLinkedList3 = localLinkedList1;
    String str3 = localba3.b(arrayOfLong2, localLinkedList3);
    StringBuilder localStringBuilder15 = localStringBuilder1.append(str3);
    ba localba4 = this;
    long[] arrayOfLong3 = paramArrayOfLong3;
    LinkedList localLinkedList4 = localLinkedList1;
    String str4 = localba4.c(arrayOfLong3, localLinkedList4);
    StringBuilder localStringBuilder16 = localStringBuilder1.append(str4);
    ba localba5 = this;
    String str5 = paramString2;
    String str6 = localba5.g(str5);
    StringBuilder localStringBuilder17 = localStringBuilder1.append(str6);
    StringBuilder localStringBuilder18 = localStringBuilder1.append(" GROUP BY  parentCategory.categoryPOID ");
    ba localba6 = this;
    String str7 = paramString3;
    String str8 = paramString4;
    LinkedList localLinkedList5 = localLinkedList1;
    String str9 = localba6.a(str7, str8, localLinkedList5);
    StringBuilder localStringBuilder19 = localStringBuilder1.append(str9);
    StringBuilder localStringBuilder20 = localStringBuilder1.append(") as trans on categoryPOID =  trans.firstCategoryID ");
    if ((paramArrayOfLong1 != 0) && (paramArrayOfLong1.length > 0))
    {
      StringBuilder localStringBuilder21 = localStringBuilder1.append(" where t_category.categoryPOID in ");
      ba localba7 = this;
      long l3 = paramArrayOfLong1;
      LinkedList localLinkedList6 = localLinkedList1;
      String str10 = localba7.d(l3, localLinkedList6);
      StringBuilder localStringBuilder22 = localStringBuilder21.append(str10);
    }
    while (true)
    {
      String str11 = a;
      StringBuilder localStringBuilder23 = localStringBuilder1.append(str11);
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString1 = new String[localLinkedList1.size()];
      String str12 = localStringBuilder1.toString();
      String[] arrayOfString2 = (String[])localLinkedList1.toArray(arrayOfString1);
      bb localbb = new bb(this, localArrayList);
      Object localObject = a(str12, arrayOfString2, localbb);
      localLinkedList1.clear();
      return localArrayList;
      StringBuilder localStringBuilder24 = localStringBuilder1.append(" where t_category.depth = 1 and t_category.type = 0");
    }
  }

  public BigDecimal b(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("SELECT sum((case when e.rate is null then 1 else e.rate end) * (case when a.amountOfLiability > 0 then a.amountOfLiability else 0 end) ) as totalAmount ");
    StringBuilder localStringBuilder3 = localStringBuilder1.append(" from t_account a ");
    StringBuilder localStringBuilder4 = localStringBuilder1.append(" INNER JOIN t_account_group g on a.accountGroupPOID = g.accountGroupPOID ");
    StringBuilder localStringBuilder5 = localStringBuilder1.append(" LEFT JOIN t_exchange as e on e.buy = '").append(paramString).append("' and e.sell = a.currencyType ");
    StringBuilder localStringBuilder6 = localStringBuilder1.append(" where g.type = 1");
    String str1 = localStringBuilder1.toString();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "2";
    String str2 = (String)he.b(str1, arrayOfString, null).get("totalamount");
    return new BigDecimal(str2);
  }

  public List b(String paramString, long paramLong1, long paramLong2)
  {
    LinkedList localLinkedList = new LinkedList();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("select strftime('%m',date(substr(t.tradeTime,1,length(t.tradeTime)-3), 'unixepoch', 'localtime'),'localtime') as tradeMonth, ");
    StringBuilder localStringBuilder3 = localStringBuilder1.append(" sum( (case when e.rate is null then 1 else e.rate end) * t.sellerMoney ) as amount ");
    StringBuilder localStringBuilder4 = localStringBuilder1.append(" from t_transaction as t");
    StringBuilder localStringBuilder5 = localStringBuilder1.append(" INNER JOIN t_account as acc on acc.accountPOID = t.buyerAccountPOID");
    String str1 = " LEFT JOIN t_exchange as e on e.buy = '" + paramString + "' and e.sell = acc.currencyType";
    StringBuilder localStringBuilder6 = localStringBuilder1.append(str1);
    StringBuilder localStringBuilder7 = localStringBuilder1.append(" where t.type = 0 ");
    ba localba = this;
    long l1 = paramLong1;
    long l2 = paramLong2;
    String str2 = localba.a(l1, l2, localLinkedList);
    StringBuilder localStringBuilder8 = localStringBuilder1.append(str2);
    StringBuilder localStringBuilder9 = localStringBuilder1.append(" GROUP BY tradeMonth");
    StringBuilder localStringBuilder10 = localStringBuilder1.append(" ORDER BY tradeMonth DESC ");
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1 = new String[localLinkedList.size()];
    String str3 = localStringBuilder1.toString();
    String[] arrayOfString2 = (String[])localLinkedList.toArray(arrayOfString1);
    bc localbc = new bc(this, localArrayList);
    Object localObject = a(str3, arrayOfString2, localbc);
    localLinkedList.clear();
    return localArrayList;
  }

  public List b(String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, String paramString2, String paramString3, String paramString4)
  {
    ba localba = this;
    String str1 = paramString1;
    long l1 = paramLong1;
    long l2 = paramLong2;
    long l3 = paramArrayOfLong1;
    long[] arrayOfLong1 = paramArrayOfLong2;
    long[] arrayOfLong2 = paramArrayOfLong3;
    long[] arrayOfLong3 = paramArrayOfLong4;
    String str2 = paramString2;
    String str3 = paramString3;
    String str4 = paramString4;
    return localba.a(0, str1, l1, l2, l3, arrayOfLong1, arrayOfLong2, arrayOfLong3, str2, str3, str4);
  }

  public List c(String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, String paramString2, String paramString3, String paramString4)
  {
    ba localba = this;
    String str1 = paramString1;
    long l1 = paramLong1;
    long l2 = paramLong2;
    long l3 = paramArrayOfLong1;
    long[] arrayOfLong1 = paramArrayOfLong2;
    long[] arrayOfLong2 = paramArrayOfLong3;
    long[] arrayOfLong3 = paramArrayOfLong4;
    String str2 = paramString2;
    String str3 = paramString3;
    String str4 = paramString4;
    return localba.a(1, str1, l1, l2, l3, arrayOfLong1, arrayOfLong2, arrayOfLong3, str2, str3, str4);
  }

  public List d(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("SELECT a.name, a.currencyType, ");
    StringBuilder localStringBuilder3 = localStringBuilder1.append(" (case when e.rate is null then 1 else e.rate end) * ");
    StringBuilder localStringBuilder4 = localStringBuilder1.append(" (   case when g.type = 0 then a.balance ");
    StringBuilder localStringBuilder5 = localStringBuilder1.append("          when g.type = 1 then a.balance ");
    StringBuilder localStringBuilder6 = localStringBuilder1.append("          when g.type = 2 then a.amountOfCredit ");
    StringBuilder localStringBuilder7 = localStringBuilder1.append("          else a.balance");
    StringBuilder localStringBuilder8 = localStringBuilder1.append(" end) as amount ");
    StringBuilder localStringBuilder9 = localStringBuilder1.append(" from t_account a ");
    StringBuilder localStringBuilder10 = localStringBuilder1.append(" INNER JOIN t_account_group g on a.accountGroupPOID = g.accountGroupPOID ");
    StringBuilder localStringBuilder11 = localStringBuilder1.append(" LEFT JOIN t_exchange as e on e.buy = '").append(paramString).append("' and e.sell = a.currencyType ");
    String str1 = a;
    StringBuilder localStringBuilder12 = localStringBuilder1.append(str1);
    StringBuilder localStringBuilder13 = localStringBuilder1.append(" ,g.type asc");
    ArrayList localArrayList = new ArrayList();
    String str2 = localStringBuilder1.toString();
    bd localbd = new bd(this, localArrayList);
    Object localObject = a(str2, null, localbd);
    return localArrayList;
  }

  public List d(String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, String paramString2, String paramString3, String paramString4)
  {
    LinkedList localLinkedList1 = new LinkedList();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("select t_account.accountPOID, t_account.name, trans.amount from t_account ");
    StringBuilder localStringBuilder3 = localStringBuilder1.append("INNER join (");
    StringBuilder localStringBuilder4 = localStringBuilder1.append("     select acc.accountPOID as tranAccountPOID,");
    StringBuilder localStringBuilder5 = localStringBuilder1.append("     sum( (case when e.rate is null then 1 else e.rate end) * t.sellerMoney ) as amount ");
    StringBuilder localStringBuilder6 = localStringBuilder1.append("     from t_transaction as t");
    StringBuilder localStringBuilder7 = localStringBuilder1.append("     INNER JOIN t_account as acc on acc.accountPOID = t.buyerAccountPOID");
    StringBuilder localStringBuilder8 = localStringBuilder1.append("     LEFT JOIN t_exchange as e on e.buy = '").append(paramString1).append("' and e.sell = acc.currencyType");
    if ((paramArrayOfLong1 != 0) && (paramArrayOfLong1.length > 0))
    {
      StringBuilder localStringBuilder9 = localStringBuilder1.append("     INNER JOIN t_category as c on c.categoryPOID = (case when t.type  = 0 then t.sellerCategoryPOID when t.type  = 1 then t.buyerCategoryPOID else t.sellerCategoryPOID end)");
      StringBuilder localStringBuilder10 = localStringBuilder1.append("     INNER JOIN t_category as parentCategory on parentCategory.categoryPOID = c.parentCategoryPOID");
    }
    if ((paramArrayOfLong3 != null) && (paramArrayOfLong3.length > 0))
      StringBuilder localStringBuilder11 = localStringBuilder1.append(" INNER JOIN t_transaction_projectcategory_map as tpm on tpm.transactionPOID = t.transactionPOID");
    StringBuilder localStringBuilder12 = localStringBuilder1.append(" where t.type = 0 ");
    ba localba1 = this;
    long l1 = paramLong1;
    long l2 = paramLong2;
    String str1 = localba1.a(l1, l2, localLinkedList1);
    StringBuilder localStringBuilder13 = localStringBuilder1.append(str1);
    ba localba2 = this;
    long l3 = paramArrayOfLong1;
    LinkedList localLinkedList2 = localLinkedList1;
    String str2 = localba2.a(l3, localLinkedList2);
    StringBuilder localStringBuilder14 = localStringBuilder1.append(str2);
    ba localba3 = this;
    long[] arrayOfLong1 = paramArrayOfLong3;
    LinkedList localLinkedList3 = localLinkedList1;
    String str3 = localba3.b(arrayOfLong1, localLinkedList3);
    StringBuilder localStringBuilder15 = localStringBuilder1.append(str3);
    ba localba4 = this;
    long[] arrayOfLong2 = paramArrayOfLong3;
    LinkedList localLinkedList4 = localLinkedList1;
    String str4 = localba4.c(arrayOfLong2, localLinkedList4);
    StringBuilder localStringBuilder16 = localStringBuilder1.append(str4);
    ba localba5 = this;
    String str5 = paramString2;
    String str6 = localba5.g(str5);
    StringBuilder localStringBuilder17 = localStringBuilder1.append(str6);
    StringBuilder localStringBuilder18 = localStringBuilder1.append(" GROUP BY  acc.accountPOID");
    ba localba6 = this;
    String str7 = paramString3;
    String str8 = paramString4;
    LinkedList localLinkedList5 = localLinkedList1;
    String str9 = localba6.a(str7, str8, localLinkedList5);
    StringBuilder localStringBuilder19 = localStringBuilder1.append(str9);
    StringBuilder localStringBuilder20 = localStringBuilder1.append(" ) as trans on t_account.accountPOID =  trans.tranAccountPOID ");
    StringBuilder localStringBuilder21 = localStringBuilder1.append(" INNER JOIN t_account_group ag on t_account.accountGroupPOID = ag.accountGroupPOID");
    if ((paramArrayOfLong2 != null) && (paramArrayOfLong2.length > 0))
    {
      StringBuilder localStringBuilder22 = localStringBuilder1.append(" where t_account.accountPOID in ");
      ba localba7 = this;
      long[] arrayOfLong3 = paramArrayOfLong2;
      LinkedList localLinkedList6 = localLinkedList1;
      String str10 = localba7.d(arrayOfLong3, localLinkedList6);
      StringBuilder localStringBuilder23 = localStringBuilder22.append(str10);
    }
    while (true)
    {
      String str11 = a;
      StringBuilder localStringBuilder24 = localStringBuilder1.append(str11);
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString1 = new String[localLinkedList1.size()];
      String str12 = localStringBuilder1.toString();
      String[] arrayOfString2 = (String[])localLinkedList1.toArray(arrayOfString1);
      bg localbg = new bg(this, localArrayList);
      Object localObject = a(str12, arrayOfString2, localbg);
      localLinkedList1.clear();
      return localArrayList;
      StringBuilder localStringBuilder25 = localStringBuilder1.append(" where ag.type in (-1, 0) or (ag.type = 1 and ag.name = '信用卡')");
    }
  }

  public List e(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("SELECT a.name, a.currencyType, (case when e.rate is null then 1 else e.rate end) *  a.amountOfLiability as amount ");
    StringBuilder localStringBuilder3 = localStringBuilder1.append(" from t_account a ");
    StringBuilder localStringBuilder4 = localStringBuilder1.append(" INNER JOIN t_account_group g on a.accountGroupPOID = g.accountGroupPOID ");
    StringBuilder localStringBuilder5 = localStringBuilder1.append(" LEFT JOIN t_exchange as e on e.buy = '").append(paramString).append("' and e.sell = a.currencyType ");
    StringBuilder localStringBuilder6 = localStringBuilder1.append(" where g.type = 1");
    String str1 = a;
    StringBuilder localStringBuilder7 = localStringBuilder1.append(str1);
    ArrayList localArrayList = new ArrayList();
    String str2 = localStringBuilder1.toString();
    be localbe = new be(this, localArrayList);
    Object localObject = a(str2, null, localbe);
    return localArrayList;
  }

  public List e(String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, String paramString2, String paramString3, String paramString4)
  {
    LinkedList localLinkedList1 = new LinkedList();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("select t_tradingEntity.tradingEntityPOID, t_tradingEntity.name, trans.amount from t_tradingEntity ");
    StringBuilder localStringBuilder3 = localStringBuilder1.append("INNER join (");
    StringBuilder localStringBuilder4 = localStringBuilder1.append("     select cor.tradingEntityPOID as tranTradingEntityPOID,");
    StringBuilder localStringBuilder5 = localStringBuilder1.append("     sum( (case when e.rate is null then 1 else e.rate end) * t.sellerMoney ) as amount ");
    StringBuilder localStringBuilder6 = localStringBuilder1.append("     from t_transaction as t");
    StringBuilder localStringBuilder7 = localStringBuilder1.append("     INNER JOIN t_account as acc on acc.accountPOID = t.buyerAccountPOID");
    StringBuilder localStringBuilder8 = localStringBuilder1.append("     LEFT JOIN t_exchange as e on e.buy = '").append(paramString1).append("' and e.sell = acc.currencyType");
    StringBuilder localStringBuilder9 = localStringBuilder1.append("     INNER JOIN t_tradingEntity as cor on cor.tradingEntityPOID = t.relationUnitPOID");
    if ((paramArrayOfLong1 != 0) && (paramArrayOfLong1.length > 0))
    {
      StringBuilder localStringBuilder10 = localStringBuilder1.append("     INNER JOIN t_category as c on c.categoryPOID = (case when t.type  = 0 then t.sellerCategoryPOID when t.type  = 1 then t.buyerCategoryPOID else t.sellerCategoryPOID end)");
      StringBuilder localStringBuilder11 = localStringBuilder1.append("     INNER JOIN t_category as parentCategory on parentCategory.categoryPOID = c.parentCategoryPOID");
    }
    if ((paramArrayOfLong3 != null) && (paramArrayOfLong3.length > 0))
      StringBuilder localStringBuilder12 = localStringBuilder1.append(" INNER JOIN t_transaction_projectcategory_map as tpm on tpm.transactionPOID = t.transactionPOID");
    StringBuilder localStringBuilder13 = localStringBuilder1.append(" where t.type = 0 ");
    ba localba1 = this;
    long l1 = paramLong1;
    long l2 = paramLong2;
    String str1 = localba1.a(l1, l2, localLinkedList1);
    StringBuilder localStringBuilder14 = localStringBuilder1.append(str1);
    ba localba2 = this;
    long l3 = paramArrayOfLong1;
    LinkedList localLinkedList2 = localLinkedList1;
    String str2 = localba2.a(l3, localLinkedList2);
    StringBuilder localStringBuilder15 = localStringBuilder1.append(str2);
    ba localba3 = this;
    long[] arrayOfLong1 = paramArrayOfLong2;
    LinkedList localLinkedList3 = localLinkedList1;
    int i = 1;
    String str3 = localba3.a(arrayOfLong1, localLinkedList3, i);
    StringBuilder localStringBuilder16 = localStringBuilder1.append(str3);
    ba localba4 = this;
    long[] arrayOfLong2 = paramArrayOfLong3;
    LinkedList localLinkedList4 = localLinkedList1;
    String str4 = localba4.b(arrayOfLong2, localLinkedList4);
    StringBuilder localStringBuilder17 = localStringBuilder1.append(str4);
    ba localba5 = this;
    String str5 = paramString2;
    String str6 = localba5.g(str5);
    StringBuilder localStringBuilder18 = localStringBuilder1.append(str6);
    StringBuilder localStringBuilder19 = localStringBuilder1.append(" GROUP BY cor.tradingEntityPOID");
    ba localba6 = this;
    String str7 = paramString3;
    String str8 = paramString4;
    LinkedList localLinkedList5 = localLinkedList1;
    String str9 = localba6.a(str7, str8, localLinkedList5);
    StringBuilder localStringBuilder20 = localStringBuilder1.append(str9);
    StringBuilder localStringBuilder21 = localStringBuilder1.append(") as trans on t_tradingEntity.tradingEntityPOID =  trans.tranTradingEntityPOID ");
    if ((paramArrayOfLong4 != null) && (paramArrayOfLong4.length > 0))
    {
      StringBuilder localStringBuilder22 = localStringBuilder1.append(" where t_tradingEntity.tradingEntityPOID in ");
      ba localba7 = this;
      long[] arrayOfLong3 = paramArrayOfLong4;
      LinkedList localLinkedList6 = localLinkedList1;
      String str10 = localba7.d(arrayOfLong3, localLinkedList6);
      StringBuilder localStringBuilder23 = localStringBuilder22.append(str10);
    }
    while (true)
    {
      String str11 = a;
      StringBuilder localStringBuilder24 = localStringBuilder1.append(str11);
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString1 = new String[localLinkedList1.size()];
      String str12 = localStringBuilder1.toString();
      String[] arrayOfString2 = (String[])localLinkedList1.toArray(arrayOfString1);
      bh localbh = new bh(this, localArrayList);
      Object localObject = a(str12, arrayOfString2, localbh);
      localLinkedList1.clear();
      return localArrayList;
      StringBuilder localStringBuilder25 = localStringBuilder1.append(" where t_tradingEntity.tradingEntityPOID not in(-2, -3)");
    }
  }

  public List f(String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, String paramString2, String paramString3, String paramString4)
  {
    LinkedList localLinkedList1 = new LinkedList();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("select t_tag.tagPOID, t_tag.name, trans.amount from t_tag ");
    StringBuilder localStringBuilder3 = localStringBuilder1.append("INNER join (");
    StringBuilder localStringBuilder4 = localStringBuilder1.append("     select tpm.projectCategoryPOID as tranprojectCategoryPOID,");
    StringBuilder localStringBuilder5 = localStringBuilder1.append("     sum( (case when e.rate is null then 1 else e.rate end) * t.sellerMoney ) as amount ");
    StringBuilder localStringBuilder6 = localStringBuilder1.append("     from t_transaction as t");
    StringBuilder localStringBuilder7 = localStringBuilder1.append("     INNER JOIN t_account as acc on acc.accountPOID = t.buyerAccountPOID");
    StringBuilder localStringBuilder8 = localStringBuilder1.append("     LEFT JOIN t_exchange as e on e.buy = '").append(paramString1).append("' and e.sell = acc.currencyType");
    StringBuilder localStringBuilder9 = localStringBuilder1.append("     INNER JOIN t_transaction_projectcategory_map as tpm on tpm.transactionPOID = t.transactionPOID");
    if ((paramArrayOfLong1 != 0) && (paramArrayOfLong1.length > 0))
    {
      StringBuilder localStringBuilder10 = localStringBuilder1.append("     INNER JOIN t_category as c on c.categoryPOID = (case when t.type  = 0 then t.sellerCategoryPOID when t.type  = 1 then t.buyerCategoryPOID else t.sellerCategoryPOID end)");
      StringBuilder localStringBuilder11 = localStringBuilder1.append("     INNER JOIN t_category as parentCategory on parentCategory.categoryPOID = c.parentCategoryPOID");
    }
    StringBuilder localStringBuilder12 = localStringBuilder1.append(" where t.type = 0 ");
    ba localba1 = this;
    long l1 = paramLong1;
    long l2 = paramLong2;
    String str1 = localba1.a(l1, l2, localLinkedList1);
    StringBuilder localStringBuilder13 = localStringBuilder1.append(str1);
    ba localba2 = this;
    long l3 = paramArrayOfLong1;
    LinkedList localLinkedList2 = localLinkedList1;
    String str2 = localba2.a(l3, localLinkedList2);
    StringBuilder localStringBuilder14 = localStringBuilder1.append(str2);
    ba localba3 = this;
    long[] arrayOfLong1 = paramArrayOfLong2;
    LinkedList localLinkedList3 = localLinkedList1;
    int i = 1;
    String str3 = localba3.a(arrayOfLong1, localLinkedList3, i);
    StringBuilder localStringBuilder15 = localStringBuilder1.append(str3);
    ba localba4 = this;
    long[] arrayOfLong2 = paramArrayOfLong3;
    LinkedList localLinkedList4 = localLinkedList1;
    String str4 = localba4.c(arrayOfLong2, localLinkedList4);
    StringBuilder localStringBuilder16 = localStringBuilder1.append(str4);
    ba localba5 = this;
    String str5 = paramString2;
    String str6 = localba5.g(str5);
    StringBuilder localStringBuilder17 = localStringBuilder1.append(str6);
    StringBuilder localStringBuilder18 = localStringBuilder1.append(" GROUP BY tpm.projectCategoryPOID");
    ba localba6 = this;
    String str7 = paramString3;
    String str8 = paramString4;
    LinkedList localLinkedList5 = localLinkedList1;
    String str9 = localba6.a(str7, str8, localLinkedList5);
    StringBuilder localStringBuilder19 = localStringBuilder1.append(str9);
    StringBuilder localStringBuilder20 = localStringBuilder1.append(") as trans on t_tag.tagPOID =  trans.tranprojectCategoryPOID ");
    if ((paramArrayOfLong3 != null) && (paramArrayOfLong3.length > 0))
    {
      StringBuilder localStringBuilder21 = localStringBuilder1.append(" where t_tag.tagPOID in ");
      ba localba7 = this;
      long[] arrayOfLong3 = paramArrayOfLong3;
      LinkedList localLinkedList6 = localLinkedList1;
      String str10 = localba7.d(arrayOfLong3, localLinkedList6);
      StringBuilder localStringBuilder22 = localStringBuilder21.append(str10);
    }
    while (true)
    {
      String str11 = a;
      StringBuilder localStringBuilder23 = localStringBuilder1.append(str11);
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString1 = new String[localLinkedList1.size()];
      String str12 = localStringBuilder1.toString();
      String[] arrayOfString2 = (String[])localLinkedList1.toArray(arrayOfString1);
      bi localbi = new bi(this, localArrayList);
      Object localObject = a(str12, arrayOfString2, localbi);
      localLinkedList1.clear();
      return localArrayList;
      StringBuilder localStringBuilder24 = localStringBuilder1.append(" where tagType = ").append(1);
    }
  }

  public List g(String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, String paramString2, String paramString3, String paramString4)
  {
    LinkedList localLinkedList1 = new LinkedList();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("select categoryPOID, name, _tempIconName as iconName, trans.amount from t_category ");
    StringBuilder localStringBuilder3 = localStringBuilder1.append("INNER join (");
    StringBuilder localStringBuilder4 = localStringBuilder1.append("     select parentCategory.categoryPOID as firstCategoryID,");
    StringBuilder localStringBuilder5 = localStringBuilder1.append("     sum( (case when e.rate is null then 1 else e.rate end) * t.sellerMoney ) as amount ");
    StringBuilder localStringBuilder6 = localStringBuilder1.append("     from t_transaction as t");
    StringBuilder localStringBuilder7 = localStringBuilder1.append("     INNER JOIN t_account as acc on acc.accountPOID = t.sellerAccountPOID");
    StringBuilder localStringBuilder8 = localStringBuilder1.append("     LEFT JOIN t_exchange as e on e.buy = '").append(paramString1).append("' and e.sell = acc.currencyType");
    StringBuilder localStringBuilder9 = localStringBuilder1.append("     INNER JOIN t_category as c on c.categoryPOID = (case when t.type  = 0 then t.sellerCategoryPOID when t.type  = 1 then t.buyerCategoryPOID else t.sellerCategoryPOID end)");
    StringBuilder localStringBuilder10 = localStringBuilder1.append("     INNER JOIN t_category as parentCategory on parentCategory.categoryPOID = c.parentCategoryPOID");
    if ((paramArrayOfLong3 != null) && (paramArrayOfLong3.length > 0))
      StringBuilder localStringBuilder11 = localStringBuilder1.append(" INNER JOIN t_transaction_projectcategory_map as tpm on tpm.transactionPOID = t.transactionPOID");
    StringBuilder localStringBuilder12 = localStringBuilder1.append(" where t.type = 1 ");
    ba localba1 = this;
    long l1 = paramLong1;
    long l2 = paramLong2;
    String str1 = localba1.a(l1, l2, localLinkedList1);
    StringBuilder localStringBuilder13 = localStringBuilder1.append(str1);
    ba localba2 = this;
    long[] arrayOfLong1 = paramArrayOfLong2;
    LinkedList localLinkedList2 = localLinkedList1;
    int i = 0;
    String str2 = localba2.a(arrayOfLong1, localLinkedList2, i);
    StringBuilder localStringBuilder14 = localStringBuilder1.append(str2);
    ba localba3 = this;
    long[] arrayOfLong2 = paramArrayOfLong3;
    LinkedList localLinkedList3 = localLinkedList1;
    String str3 = localba3.b(arrayOfLong2, localLinkedList3);
    StringBuilder localStringBuilder15 = localStringBuilder1.append(str3);
    ba localba4 = this;
    long[] arrayOfLong3 = paramArrayOfLong3;
    LinkedList localLinkedList4 = localLinkedList1;
    String str4 = localba4.c(arrayOfLong3, localLinkedList4);
    StringBuilder localStringBuilder16 = localStringBuilder1.append(str4);
    ba localba5 = this;
    String str5 = paramString2;
    String str6 = localba5.g(str5);
    StringBuilder localStringBuilder17 = localStringBuilder1.append(str6);
    StringBuilder localStringBuilder18 = localStringBuilder1.append(" GROUP BY  parentCategory.categoryPOID");
    ba localba6 = this;
    String str7 = paramString3;
    String str8 = paramString4;
    LinkedList localLinkedList5 = localLinkedList1;
    String str9 = localba6.a(str7, str8, localLinkedList5);
    StringBuilder localStringBuilder19 = localStringBuilder1.append(str9);
    StringBuilder localStringBuilder20 = localStringBuilder1.append(") as trans on categoryPOID =  trans.firstCategoryID");
    if ((paramArrayOfLong1 != 0) && (paramArrayOfLong1.length > 0))
    {
      StringBuilder localStringBuilder21 = localStringBuilder1.append(" where t_category.categoryPOID in ");
      ba localba7 = this;
      long l3 = paramArrayOfLong1;
      LinkedList localLinkedList6 = localLinkedList1;
      String str10 = localba7.d(l3, localLinkedList6);
      StringBuilder localStringBuilder22 = localStringBuilder21.append(str10);
    }
    while (true)
    {
      String str11 = a;
      StringBuilder localStringBuilder23 = localStringBuilder1.append(str11);
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString1 = new String[localLinkedList1.size()];
      String str12 = localStringBuilder1.toString();
      String[] arrayOfString2 = (String[])localLinkedList1.toArray(arrayOfString1);
      bj localbj = new bj(this, localArrayList);
      Object localObject = a(str12, arrayOfString2, localbj);
      localLinkedList1.clear();
      return localArrayList;
      StringBuilder localStringBuilder24 = localStringBuilder1.append(" where t_category.depth = 1 and t_category.type = 1");
    }
  }

  public List h(String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, String paramString2, String paramString3, String paramString4)
  {
    LinkedList localLinkedList1 = new LinkedList();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("select t_account.accountPOID, t_account.name, trans.amount from t_account ");
    StringBuilder localStringBuilder3 = localStringBuilder1.append("INNER join (");
    StringBuilder localStringBuilder4 = localStringBuilder1.append("     select acc.accountPOID as tranAccountPOID,");
    StringBuilder localStringBuilder5 = localStringBuilder1.append("     sum( (case when e.rate is null then 1 else e.rate end) * t.sellerMoney ) as amount ");
    StringBuilder localStringBuilder6 = localStringBuilder1.append("     from t_transaction as t");
    StringBuilder localStringBuilder7 = localStringBuilder1.append("     INNER JOIN t_account as acc on acc.accountPOID = t.sellerAccountPOID");
    StringBuilder localStringBuilder8 = localStringBuilder1.append("     LEFT JOIN t_exchange as e on e.buy = '").append(paramString1).append("' and e.sell = acc.currencyType");
    if ((paramArrayOfLong1 != 0) && (paramArrayOfLong1.length > 0))
    {
      StringBuilder localStringBuilder9 = localStringBuilder1.append("     INNER JOIN t_category as c on c.categoryPOID = (case when t.type  = 0 then t.sellerCategoryPOID when t.type  = 1 then t.buyerCategoryPOID else t.sellerCategoryPOID end)");
      StringBuilder localStringBuilder10 = localStringBuilder1.append("     INNER JOIN t_category as parentCategory on parentCategory.categoryPOID = c.parentCategoryPOID");
    }
    if ((paramArrayOfLong3 != null) && (paramArrayOfLong3.length > 0))
      StringBuilder localStringBuilder11 = localStringBuilder1.append(" INNER JOIN t_transaction_projectcategory_map as tpm on tpm.transactionPOID = t.transactionPOID");
    StringBuilder localStringBuilder12 = localStringBuilder1.append(" where t.type = 1 ");
    ba localba1 = this;
    long l1 = paramLong1;
    long l2 = paramLong2;
    String str1 = localba1.a(l1, l2, localLinkedList1);
    StringBuilder localStringBuilder13 = localStringBuilder1.append(str1);
    ba localba2 = this;
    long l3 = paramArrayOfLong1;
    LinkedList localLinkedList2 = localLinkedList1;
    String str2 = localba2.a(l3, localLinkedList2);
    StringBuilder localStringBuilder14 = localStringBuilder1.append(str2);
    ba localba3 = this;
    long[] arrayOfLong1 = paramArrayOfLong3;
    LinkedList localLinkedList3 = localLinkedList1;
    String str3 = localba3.b(arrayOfLong1, localLinkedList3);
    StringBuilder localStringBuilder15 = localStringBuilder1.append(str3);
    ba localba4 = this;
    long[] arrayOfLong2 = paramArrayOfLong3;
    LinkedList localLinkedList4 = localLinkedList1;
    String str4 = localba4.c(arrayOfLong2, localLinkedList4);
    StringBuilder localStringBuilder16 = localStringBuilder1.append(str4);
    ba localba5 = this;
    String str5 = paramString2;
    String str6 = localba5.g(str5);
    StringBuilder localStringBuilder17 = localStringBuilder1.append(str6);
    StringBuilder localStringBuilder18 = localStringBuilder1.append(" GROUP BY  acc.accountPOID");
    ba localba6 = this;
    String str7 = paramString3;
    String str8 = paramString4;
    LinkedList localLinkedList5 = localLinkedList1;
    String str9 = localba6.a(str7, str8, localLinkedList5);
    StringBuilder localStringBuilder19 = localStringBuilder1.append(str9);
    StringBuilder localStringBuilder20 = localStringBuilder1.append(") as trans on t_account.accountPOID =  trans.tranAccountPOID ");
    StringBuilder localStringBuilder21 = localStringBuilder1.append(" INNER JOIN t_account_group ag on t_account.accountGroupPOID = ag.accountGroupPOID");
    if ((paramArrayOfLong2 != null) && (paramArrayOfLong2.length > 0))
    {
      StringBuilder localStringBuilder22 = localStringBuilder1.append(" where t_account.accountPOID in ");
      ba localba7 = this;
      long[] arrayOfLong3 = paramArrayOfLong2;
      LinkedList localLinkedList6 = localLinkedList1;
      String str10 = localba7.d(arrayOfLong3, localLinkedList6);
      StringBuilder localStringBuilder23 = localStringBuilder22.append(str10);
    }
    while (true)
    {
      String str11 = a;
      StringBuilder localStringBuilder24 = localStringBuilder1.append(str11);
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString1 = new String[localLinkedList1.size()];
      String str12 = localStringBuilder1.toString();
      String[] arrayOfString2 = (String[])localLinkedList1.toArray(arrayOfString1);
      bk localbk = new bk(this, localArrayList);
      Object localObject = a(str12, arrayOfString2, localbk);
      localLinkedList1.clear();
      return localArrayList;
      StringBuilder localStringBuilder25 = localStringBuilder1.append(" where ag.type in (-1, 0)");
    }
  }

  public List i(String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, String paramString2, String paramString3, String paramString4)
  {
    LinkedList localLinkedList1 = new LinkedList();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("select t_tag.tagPOID, t_tag.name, trans.amount from t_tag ");
    StringBuilder localStringBuilder3 = localStringBuilder1.append("INNER join (");
    StringBuilder localStringBuilder4 = localStringBuilder1.append("     select tpm.projectCategoryPOID as tranProjectCategoryPOID,");
    StringBuilder localStringBuilder5 = localStringBuilder1.append("     sum( (case when e.rate is null then 1 else e.rate end) * t.sellerMoney ) as amount ");
    StringBuilder localStringBuilder6 = localStringBuilder1.append("     from t_transaction as t");
    StringBuilder localStringBuilder7 = localStringBuilder1.append("     INNER JOIN t_account as acc on acc.accountPOID = t.sellerAccountPOID");
    StringBuilder localStringBuilder8 = localStringBuilder1.append("     LEFT JOIN t_exchange as e on e.buy = '").append(paramString1).append("' and e.sell = acc.currencyType");
    StringBuilder localStringBuilder9 = localStringBuilder1.append("     INNER JOIN t_transaction_projectcategory_map as tpm on tpm.transactionPOID = t.transactionPOID");
    if ((paramArrayOfLong1 != 0) && (paramArrayOfLong1.length > 0))
    {
      StringBuilder localStringBuilder10 = localStringBuilder1.append("     INNER JOIN t_category as c on c.categoryPOID = (case when t.type  = 0 then t.sellerCategoryPOID when t.type  = 1 then t.buyerCategoryPOID else t.sellerCategoryPOID end)");
      StringBuilder localStringBuilder11 = localStringBuilder1.append("     INNER JOIN t_category as parentCategory on parentCategory.categoryPOID = c.parentCategoryPOID");
    }
    StringBuilder localStringBuilder12 = localStringBuilder1.append(" where t.type = 1 ");
    ba localba1 = this;
    long l1 = paramLong1;
    long l2 = paramLong2;
    String str1 = localba1.a(l1, l2, localLinkedList1);
    StringBuilder localStringBuilder13 = localStringBuilder1.append(str1);
    ba localba2 = this;
    long l3 = paramArrayOfLong1;
    LinkedList localLinkedList2 = localLinkedList1;
    String str2 = localba2.a(l3, localLinkedList2);
    StringBuilder localStringBuilder14 = localStringBuilder1.append(str2);
    ba localba3 = this;
    long[] arrayOfLong1 = paramArrayOfLong2;
    LinkedList localLinkedList3 = localLinkedList1;
    int i = 0;
    String str3 = localba3.a(arrayOfLong1, localLinkedList3, i);
    StringBuilder localStringBuilder15 = localStringBuilder1.append(str3);
    ba localba4 = this;
    long[] arrayOfLong2 = paramArrayOfLong4;
    LinkedList localLinkedList4 = localLinkedList1;
    String str4 = localba4.c(arrayOfLong2, localLinkedList4);
    StringBuilder localStringBuilder16 = localStringBuilder1.append(str4);
    ba localba5 = this;
    String str5 = paramString2;
    String str6 = localba5.g(str5);
    StringBuilder localStringBuilder17 = localStringBuilder1.append(str6);
    StringBuilder localStringBuilder18 = localStringBuilder1.append(" GROUP BY tpm.projectCategoryPOID");
    ba localba6 = this;
    String str7 = paramString3;
    String str8 = paramString4;
    LinkedList localLinkedList5 = localLinkedList1;
    String str9 = localba6.a(str7, str8, localLinkedList5);
    StringBuilder localStringBuilder19 = localStringBuilder1.append(str9);
    StringBuilder localStringBuilder20 = localStringBuilder1.append(") as trans on t_tag.tagPOID =  trans.tranProjectCategoryPOID ");
    if ((paramArrayOfLong3 != null) && (paramArrayOfLong3.length > 0))
    {
      StringBuilder localStringBuilder21 = localStringBuilder1.append(" where t_tag.tagPOID in ");
      ba localba7 = this;
      long[] arrayOfLong3 = paramArrayOfLong3;
      LinkedList localLinkedList6 = localLinkedList1;
      String str10 = localba7.d(arrayOfLong3, localLinkedList6);
      StringBuilder localStringBuilder22 = localStringBuilder21.append(str10);
    }
    while (true)
    {
      String str11 = a;
      StringBuilder localStringBuilder23 = localStringBuilder1.append(str11);
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString1 = new String[localLinkedList1.size()];
      String str12 = localStringBuilder1.toString();
      String[] arrayOfString2 = (String[])localLinkedList1.toArray(arrayOfString1);
      bl localbl = new bl(this, localArrayList);
      Object localObject = a(str12, arrayOfString2, localbl);
      localLinkedList1.clear();
      return localArrayList;
      StringBuilder localStringBuilder24 = localStringBuilder1.append(" where tagType = ").append(1);
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ba
 * JD-Core Version:    0.6.0
 */