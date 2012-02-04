import android.text.TextUtils;
import com.mymoney.core.application.ApplicationContext;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class gs
{
  public static String a = "MoneyFormalUtil";
  public static String b = "error";
  public static String c = "0.00";
  public static Map d = new HashMap();

  static
  {
    Object localObject1 = d.put("CNY", "￥");
    Object localObject2 = d.put("USD", "$");
    Object localObject3 = d.put("EUR", "€");
    Object localObject4 = d.put("AUD", "$");
    Object localObject5 = d.put("BRL", "R$");
    Object localObject6 = d.put("CAD", "$");
    Object localObject7 = d.put("DKK", "kr");
    Object localObject8 = d.put("CHF", "$");
    Object localObject9 = d.put("GBP", "￡");
    Object localObject10 = d.put("HKD", "$");
    Object localObject11 = d.put("JPY", "￥");
    Object localObject12 = d.put("KRW", "W");
    Object localObject13 = d.put("MOP", "$");
    Object localObject14 = d.put("MYR", "RM");
    Object localObject15 = d.put("NZD", "$");
    Object localObject16 = d.put("NOK", "kr");
    Object localObject17 = d.put("PHP", "$");
    Object localObject18 = d.put("SGD", "$");
    Object localObject19 = d.put("SEK", "kr");
    Object localObject20 = d.put("TWD", "NT$");
    Object localObject21 = d.put("THB", "?");
    Object localObject22 = d.put("LKR", "Rs");
  }

  public static String a(double paramDouble)
  {
    String str = c;
    return new DecimalFormat(str).format(paramDouble);
  }

  public static String a(double paramDouble, String paramString)
  {
    int i;
    if (paramDouble > 0.0D)
      i = 1;
    while (true)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat("#,##0.00");
      if (TextUtils.isEmpty(paramString));
      for (String str1 = ApplicationContext.g; ; str1 = paramString)
      {
        String str2 = (String)d.get(str1);
        if (TextUtils.isEmpty(str2))
          str2 = "";
        StringBuilder localStringBuilder1 = new StringBuilder();
        if (i != 0);
        for (String str3 = ""; ; str3 = "-")
        {
          StringBuilder localStringBuilder2 = localStringBuilder1.append(str3).append(str2);
          double d1 = Math.abs(paramDouble);
          String str4 = localDecimalFormat.format(d1);
          return str4;
          if (paramDouble >= 0.0D)
            break label143;
          i = 0;
          break;
        }
      }
      label143: i = 1;
    }
  }

  public static String a(double paramDouble, String paramString, boolean paramBoolean)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("#,##0.00");
    if (TextUtils.isEmpty(paramString));
    for (String str1 = ApplicationContext.g; ; str1 = paramString)
    {
      String str2 = (String)d.get(str1);
      if (TextUtils.isEmpty(str2))
        str2 = "";
      StringBuilder localStringBuilder1;
      String str3;
      if (paramBoolean != null)
      {
        localStringBuilder1 = new StringBuilder().append("+").append(str2);
        double d1 = Math.abs(paramDouble);
        str3 = localDecimalFormat.format(d1);
      }
      StringBuilder localStringBuilder2;
      String str4;
      for (str2 = str3; ; str2 = str4)
      {
        return str2;
        localStringBuilder2 = new StringBuilder().append("-").append(str2);
        double d2 = Math.abs(paramDouble);
        str4 = localDecimalFormat.format(d2);
      }
    }
  }

  public static final BigDecimal a(String paramString)
  {
    BigDecimal localBigDecimal1 = new BigDecimal(paramString);
    BigDecimal localBigDecimal2 = new BigDecimal("1");
    return localBigDecimal1.divide(localBigDecimal2, 2, 4);
  }

  public static final BigDecimal a(BigDecimal paramBigDecimal)
  {
    BigDecimal localBigDecimal = new BigDecimal("1");
    return paramBigDecimal.divide(localBigDecimal, 2, 4);
  }

  public static String b(double paramDouble)
  {
    return new DecimalFormat("#,##0.00").format(paramDouble);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gs
 * JD-Core Version:    0.6.0
 */