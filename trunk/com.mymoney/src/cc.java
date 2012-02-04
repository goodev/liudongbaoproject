import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class cc extends bt
{
  private void a(List paramList)
  {
    boolean bool1 = paramList.add("drop table if exists t_currency");
    boolean bool2 = paramList.add("CREATE TABLE t_currency(          currencyPOID integer  primary key autoincrement,         code  varchar(50) not null ,         name  varchar(50) not null ,         icon  varchar(50) not null default 'currency_icon_default' ) ");
  }

  private void b(List paramList)
  {
    String[] arrayOfString1 = new String[22];
    String[] arrayOfString2 = new String[3];
    arrayOfString2[0] = "CNY";
    arrayOfString2[1] = "人民币";
    arrayOfString2[2] = "currency_icon_cny";
    arrayOfString1[0] = arrayOfString2;
    String[] arrayOfString3 = new String[3];
    arrayOfString3[0] = "USD";
    arrayOfString3[1] = "美元";
    arrayOfString3[2] = "currency_icon_usd";
    arrayOfString1[1] = arrayOfString3;
    String[] arrayOfString4 = new String[3];
    arrayOfString4[0] = "EUR";
    arrayOfString4[1] = "欧元";
    arrayOfString4[2] = "currency_icon_eur";
    arrayOfString1[2] = arrayOfString4;
    String[] arrayOfString5 = new String[3];
    arrayOfString5[0] = "AUD";
    arrayOfString5[1] = "澳大利亚元";
    arrayOfString5[2] = "currency_icon_aud";
    arrayOfString1[3] = arrayOfString5;
    String[] arrayOfString6 = new String[3];
    arrayOfString6[0] = "BRL";
    arrayOfString6[1] = "巴西雷亚尔";
    arrayOfString6[2] = "currency_icon_brl";
    arrayOfString1[4] = arrayOfString6;
    String[] arrayOfString7 = new String[3];
    arrayOfString7[0] = "CAD";
    arrayOfString7[1] = "加拿大元";
    arrayOfString7[2] = "currency_icon_cad";
    arrayOfString1[5] = arrayOfString7;
    String[] arrayOfString8 = new String[3];
    arrayOfString8[0] = "DKK";
    arrayOfString8[1] = "丹麦克朗";
    arrayOfString8[2] = "currency_icon_dkk";
    arrayOfString1[6] = arrayOfString8;
    String[] arrayOfString9 = new String[3];
    arrayOfString9[0] = "CHF";
    arrayOfString9[1] = "瑞士法郎";
    arrayOfString9[2] = "currency_icon_chf";
    arrayOfString1[7] = arrayOfString9;
    String[] arrayOfString10 = new String[3];
    arrayOfString10[0] = "GBP";
    arrayOfString10[1] = "英镑";
    arrayOfString10[2] = "currency_icon_gbp";
    arrayOfString1[8] = arrayOfString10;
    String[] arrayOfString11 = new String[3];
    arrayOfString11[0] = "HKD";
    arrayOfString11[1] = "港元";
    arrayOfString11[2] = "currency_icon_hkd";
    arrayOfString1[9] = arrayOfString11;
    String[] arrayOfString12 = new String[3];
    arrayOfString12[0] = "JPY";
    arrayOfString12[1] = "日元";
    arrayOfString12[2] = "currency_icon_jpy";
    arrayOfString1[10] = arrayOfString12;
    String[] arrayOfString13 = new String[3];
    arrayOfString13[0] = "KRW";
    arrayOfString13[1] = "韩圆";
    arrayOfString13[2] = "currency_icon_krw";
    arrayOfString1[11] = arrayOfString13;
    String[] arrayOfString14 = new String[3];
    arrayOfString14[0] = "MOP";
    arrayOfString14[1] = "澳门元";
    arrayOfString14[2] = "currency_icon_mop";
    arrayOfString1[12] = arrayOfString14;
    String[] arrayOfString15 = new String[3];
    arrayOfString15[0] = "MYR";
    arrayOfString15[1] = "马来西亚林吉特";
    arrayOfString15[2] = "currency_icon_myr";
    arrayOfString1[13] = arrayOfString15;
    String[] arrayOfString16 = new String[3];
    arrayOfString16[0] = "NZD";
    arrayOfString16[1] = "新西兰元";
    arrayOfString16[2] = "currency_icon_nzd";
    arrayOfString1[14] = arrayOfString16;
    String[] arrayOfString17 = new String[3];
    arrayOfString17[0] = "NOK";
    arrayOfString17[1] = "挪威克朗";
    arrayOfString17[2] = "currency_icon_nok";
    arrayOfString1[15] = arrayOfString17;
    String[] arrayOfString18 = new String[3];
    arrayOfString18[0] = "PHP";
    arrayOfString18[1] = "菲律宾比索";
    arrayOfString18[2] = "currency_icon_php";
    arrayOfString1[16] = arrayOfString18;
    String[] arrayOfString19 = new String[3];
    arrayOfString19[0] = "SGD";
    arrayOfString19[1] = "新加坡元";
    arrayOfString19[2] = "currency_icon_sgd";
    arrayOfString1[17] = arrayOfString19;
    String[] arrayOfString20 = new String[3];
    arrayOfString20[0] = "SEK";
    arrayOfString20[1] = "瑞典克朗";
    arrayOfString20[2] = "currency_icon_sek";
    arrayOfString1[18] = arrayOfString20;
    String[] arrayOfString21 = new String[3];
    arrayOfString21[0] = "TWD";
    arrayOfString21[1] = "新台币";
    arrayOfString21[2] = "currency_icon_twd";
    arrayOfString1[19] = arrayOfString21;
    String[] arrayOfString22 = new String[3];
    arrayOfString22[0] = "THB";
    arrayOfString22[1] = "泰铢";
    arrayOfString22[2] = "currency_icon_thb";
    arrayOfString1[20] = arrayOfString22;
    String[] arrayOfString23 = new String[3];
    arrayOfString23[0] = "LKR";
    arrayOfString23[1] = "斯里兰卡卢比";
    arrayOfString23[2] = "currency_icon_lkr";
    arrayOfString1[21] = arrayOfString23;
    int i = 0;
    while (true)
    {
      int j = arrayOfString1.length;
      if (i >= j)
        return;
      StringBuilder localStringBuilder1 = new StringBuilder().append("insert into t_currency(code,name,icon) values( ");
      String str1 = arrayOfString1[i][0];
      String str2 = super.a(str1);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append(",");
      String str3 = arrayOfString1[i][1];
      String str4 = super.a(str3);
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str4).append(",");
      String str5 = arrayOfString1[i][2];
      String str6 = super.a(str5);
      String str7 = str6 + ")";
      boolean bool = paramList.add(str7);
      i += 1;
    }
  }

  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    cc localcc = new cc();
    localcc.a(paramSQLiteDatabase);
    return localcc.a();
  }

  private void c(List paramList)
  {
    String[] arrayOfString1 = new String[21];
    String[] arrayOfString2 = new String[4];
    arrayOfString2[0] = "USD";
    arrayOfString2[1] = "CNY";
    arrayOfString2[2] = "1";
    arrayOfString2[3] = "0";
    arrayOfString1[0] = arrayOfString2;
    String[] arrayOfString3 = new String[4];
    arrayOfString3[0] = "EUR";
    arrayOfString3[1] = "CNY";
    arrayOfString3[2] = "1";
    arrayOfString3[3] = "0";
    arrayOfString1[1] = arrayOfString3;
    String[] arrayOfString4 = new String[4];
    arrayOfString4[0] = "AUD";
    arrayOfString4[1] = "CNY";
    arrayOfString4[2] = "1";
    arrayOfString4[3] = "0";
    arrayOfString1[2] = arrayOfString4;
    String[] arrayOfString5 = new String[4];
    arrayOfString5[0] = "BRL";
    arrayOfString5[1] = "CNY";
    arrayOfString5[2] = "1";
    arrayOfString5[3] = "0";
    arrayOfString1[3] = arrayOfString5;
    String[] arrayOfString6 = new String[4];
    arrayOfString6[0] = "CAD";
    arrayOfString6[1] = "CNY";
    arrayOfString6[2] = "1";
    arrayOfString6[3] = "0";
    arrayOfString1[4] = arrayOfString6;
    String[] arrayOfString7 = new String[4];
    arrayOfString7[0] = "DKK";
    arrayOfString7[1] = "CNY";
    arrayOfString7[2] = "1";
    arrayOfString7[3] = "0";
    arrayOfString1[5] = arrayOfString7;
    String[] arrayOfString8 = new String[4];
    arrayOfString8[0] = "CHF";
    arrayOfString8[1] = "CNY";
    arrayOfString8[2] = "1";
    arrayOfString8[3] = "0";
    arrayOfString1[6] = arrayOfString8;
    String[] arrayOfString9 = new String[4];
    arrayOfString9[0] = "GBP";
    arrayOfString9[1] = "CNY";
    arrayOfString9[2] = "1";
    arrayOfString9[3] = "0";
    arrayOfString1[7] = arrayOfString9;
    String[] arrayOfString10 = new String[4];
    arrayOfString10[0] = "HKD";
    arrayOfString10[1] = "CNY";
    arrayOfString10[2] = "1";
    arrayOfString10[3] = "0";
    arrayOfString1[8] = arrayOfString10;
    String[] arrayOfString11 = new String[4];
    arrayOfString11[0] = "JPY";
    arrayOfString11[1] = "CNY";
    arrayOfString11[2] = "1";
    arrayOfString11[3] = "0";
    arrayOfString1[9] = arrayOfString11;
    String[] arrayOfString12 = new String[4];
    arrayOfString12[0] = "KRW";
    arrayOfString12[1] = "CNY";
    arrayOfString12[2] = "1";
    arrayOfString12[3] = "0";
    arrayOfString1[10] = arrayOfString12;
    String[] arrayOfString13 = new String[4];
    arrayOfString13[0] = "MOP";
    arrayOfString13[1] = "CNY";
    arrayOfString13[2] = "1";
    arrayOfString13[3] = "0";
    arrayOfString1[11] = arrayOfString13;
    String[] arrayOfString14 = new String[4];
    arrayOfString14[0] = "MYR";
    arrayOfString14[1] = "CNY";
    arrayOfString14[2] = "1";
    arrayOfString14[3] = "0";
    arrayOfString1[12] = arrayOfString14;
    String[] arrayOfString15 = new String[4];
    arrayOfString15[0] = "NZD";
    arrayOfString15[1] = "CNY";
    arrayOfString15[2] = "1";
    arrayOfString15[3] = "0";
    arrayOfString1[13] = arrayOfString15;
    String[] arrayOfString16 = new String[4];
    arrayOfString16[0] = "NOK";
    arrayOfString16[1] = "CNY";
    arrayOfString16[2] = "1";
    arrayOfString16[3] = "0";
    arrayOfString1[14] = arrayOfString16;
    String[] arrayOfString17 = new String[4];
    arrayOfString17[0] = "PHP";
    arrayOfString17[1] = "CNY";
    arrayOfString17[2] = "1";
    arrayOfString17[3] = "0";
    arrayOfString1[15] = arrayOfString17;
    String[] arrayOfString18 = new String[4];
    arrayOfString18[0] = "SGD";
    arrayOfString18[1] = "CNY";
    arrayOfString18[2] = "1";
    arrayOfString18[3] = "0";
    arrayOfString1[16] = arrayOfString18;
    String[] arrayOfString19 = new String[4];
    arrayOfString19[0] = "SEK";
    arrayOfString19[1] = "CNY";
    arrayOfString19[2] = "1";
    arrayOfString19[3] = "0";
    arrayOfString1[17] = arrayOfString19;
    String[] arrayOfString20 = new String[4];
    arrayOfString20[0] = "TWD";
    arrayOfString20[1] = "CNY";
    arrayOfString20[2] = "1";
    arrayOfString20[3] = "0";
    arrayOfString1[18] = arrayOfString20;
    String[] arrayOfString21 = new String[4];
    arrayOfString21[0] = "THB";
    arrayOfString21[1] = "CNY";
    arrayOfString21[2] = "1";
    arrayOfString21[3] = "0";
    arrayOfString1[19] = arrayOfString21;
    String[] arrayOfString22 = new String[4];
    arrayOfString22[0] = "LKR";
    arrayOfString22[1] = "CNY";
    arrayOfString22[2] = "1";
    arrayOfString22[3] = "0";
    arrayOfString1[20] = arrayOfString22;
    int i = 0;
    while (true)
    {
      int j = arrayOfString1.length;
      if (i >= j)
        return;
      StringBuilder localStringBuilder1 = new StringBuilder().append("insert into t_exchange(sell,buy,rate,manualSetting) values( ");
      String str1 = arrayOfString1[i][0];
      String str2 = super.a(str1);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append(",");
      String str3 = arrayOfString1[i][1];
      String str4 = super.a(str3);
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str4).append(",");
      String str5 = arrayOfString1[i][2];
      String str6 = super.a(str5);
      StringBuilder localStringBuilder4 = localStringBuilder3.append(str6).append(",");
      String str7 = arrayOfString1[i][3];
      String str8 = super.a(str7);
      String str9 = str8 + ")";
      boolean bool = paramList.add(str9);
      i += 1;
    }
  }

  public boolean a()
  {
    gj.a("DatabaseUpgrade18", "upgrade database to Version18");
    ArrayList localArrayList = new ArrayList(50);
    String str1 = dh.a;
    String str2 = dh.b;
    if (str1.equals(str2))
    {
      gj.a("DatabaseUpgrade18", "demo mode reCreate t_currency");
      a(localArrayList);
    }
    b(localArrayList);
    c(localArrayList);
    boolean bool = localArrayList.add("update t_tradingEntity set belongTo = -3 ");
    he.a(localArrayList, 1);
    localArrayList.clear();
    gj.a("DatabaseUpgrade18", "upgrade database to Version18 success");
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     cc
 * JD-Core Version:    0.6.0
 */