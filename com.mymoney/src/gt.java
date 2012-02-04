import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.mymoney.core.application.ApplicationContext;
import java.util.Map;
import java.util.UUID;

public class gt
{
  public static String a = "MyMoneyCommonUtil";

  public static long a()
  {
    return System.currentTimeMillis();
  }

  public static boolean a(Context paramContext)
  {
    int i = 0;
    if ((b(paramContext)) || (c(paramContext)))
      i = 1;
    while (true)
    {
      return i;
      if (d(paramContext))
      {
        if (!gq.a())
          continue;
        i = 1;
        continue;
      }
      if (paramContext.getPackageName().indexOf("vip") == -1)
        continue;
      i = 1;
    }
  }

  public static int b()
  {
    return (int)(a() >> 11);
  }

  public static boolean b(Context paramContext)
  {
    if (paramContext.getPackageName().indexOf("ophonevip") != -1);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static String c()
  {
    return ((TelephonyManager)ApplicationContext.a.getSystemService("phone")).getDeviceId();
  }

  public static boolean c(Context paramContext)
  {
    if (paramContext.getPackageName().indexOf("lephonevip") != -1);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static int d()
  {
    int i = -1;
    PackageInfo localPackageInfo = q();
    if (localPackageInfo != null)
      i = localPackageInfo.versionCode;
    return i;
  }

  public static boolean d(Context paramContext)
  {
    if (paramContext.getPackageName().indexOf("meizuvip") != -1);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static String e()
  {
    String str = "最新";
    PackageInfo localPackageInfo = q();
    if (localPackageInfo != null)
      str = localPackageInfo.versionName;
    return str;
  }

  public static long f()
  {
    if (ApplicationContext.f == 65535L)
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "1";
      String str = gx.a(he.b("select syncOffsetTime from t_profile", arrayOfString, null).get("syncoffsettime"));
      if (gx.a(str))
        str = "0";
      ApplicationContext.f = Long.parseLong(str);
    }
    long l1 = System.currentTimeMillis();
    long l2 = ApplicationContext.f;
    return l1 + l2;
  }

  public static boolean g()
  {
    String str = gu.c();
    if ("lephone".indexOf(str) != -1);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean h()
  {
    String str = gu.c();
    if ("meizu".indexOf(str) != -1);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean i()
  {
    String str = gu.c();
    if ("anzhuo".indexOf(str) != -1);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean j()
  {
    String str = gu.c();
    if ("360".indexOf(str) != -1);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean k()
  {
    String str = gu.c();
    if ("jifeng".indexOf(str) != -1);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean l()
  {
    String str = gu.c();
    if ("shizimao".indexOf(str) != -1);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean m()
  {
    String str = gu.c();
    if ("moto".indexOf(str) != -1);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean n()
  {
    String str = gu.c();
    if ("yingyonghui".indexOf(str) != -1);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static String o()
  {
    return UUID.randomUUID().toString();
  }

  public static String p()
  {
    Context localContext = ApplicationContext.a;
    Object localObject = (TelephonyManager)localContext.getSystemService("phone");
    gg localgg = gg.a();
    String str1 = gu.a(gu.i);
    StringBuilder localStringBuilder1;
    String str4;
    if (TextUtils.isEmpty(str1))
    {
      String str2 = ((TelephonyManager)localObject).getDeviceId();
      if (!TextUtils.isEmpty(str2))
      {
        str1 = "deviceId-" + str2;
        gu.a(gu.i, str1);
      }
    }
    else
    {
      localStringBuilder1 = new StringBuilder(400);
      StringBuilder localStringBuilder2 = localStringBuilder1.append("<SystemName>").append("android OS").append("</SystemName>");
      StringBuilder localStringBuilder3 = localStringBuilder1.append("<SystemVersion>");
      String str3 = hc.a(Build.VERSION.RELEASE);
      StringBuilder localStringBuilder4 = localStringBuilder3.append(str3).append("</SystemVersion>");
      if (!a(localContext))
        break label554;
      str4 = " Vip";
      String str5 = a;
      String str6 = "productNameAppendStr is " + str4;
      gj.a(str5, str6);
    }
    while (true)
    {
      while (true)
      {
        StringBuilder localStringBuilder5 = localStringBuilder1.append("<ProductName>");
        StringBuilder localStringBuilder6 = new StringBuilder();
        String str7 = gu.d();
        String str8 = hc.a(str7 + str4);
        StringBuilder localStringBuilder7 = localStringBuilder5.append(str8).append("</ProductName>");
        StringBuilder localStringBuilder8 = localStringBuilder1.append("<ProductVersion>");
        String str9 = hc.a(e());
        StringBuilder localStringBuilder9 = localStringBuilder8.append(str9).append("</ProductVersion>");
        StringBuilder localStringBuilder10 = localStringBuilder1.append("<Model>");
        String str10 = hc.a(Build.MODEL);
        StringBuilder localStringBuilder11 = localStringBuilder10.append(str10).append("</Model>");
        StringBuilder localStringBuilder12 = localStringBuilder1.append("<UDID>");
        String str11 = hc.a(str1);
        StringBuilder localStringBuilder13 = localStringBuilder12.append(str11).append("</UDID>");
        StringBuilder localStringBuilder14 = localStringBuilder1.append("<IMEI>");
        String str12 = hc.a(((TelephonyManager)localObject).getDeviceId());
        StringBuilder localStringBuilder15 = localStringBuilder14.append(str12).append("</IMEI>");
        StringBuilder localStringBuilder16 = localStringBuilder1.append("<Partner>");
        String str13 = hc.a(gu.c());
        StringBuilder localStringBuilder17 = localStringBuilder16.append(str13).append("</Partner>");
        try
        {
          String str14 = fz.a(localStringBuilder1.toString(), "&*($HJDGH4867%&T");
          localObject = str14;
          return localObject;
          String str15 = Settings.Secure.getString(localContext.getContentResolver(), "android_id");
          if (!TextUtils.isEmpty(str15))
          {
            str1 = "androidId-" + str15;
            break;
          }
          String str16 = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
          if (!TextUtils.isEmpty(str16))
          {
            str1 = "macAddress-" + str16;
            break;
          }
          StringBuilder localStringBuilder18 = new StringBuilder().append("customUuid-");
          long l = a();
          str1 = l;
        }
        catch (Exception localException)
        {
          while (true)
          {
            localException.printStackTrace();
            localObject = "";
          }
        }
      }
      label554: str4 = "";
    }
  }

  private static PackageInfo q()
  {
    Object localObject = ApplicationContext.a;
    PackageManager localPackageManager = ((Context)localObject).getPackageManager();
    try
    {
      String str = ((Context)localObject).getPackageName();
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(str, 0);
      localObject = localPackageInfo;
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        localObject = null;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gt
 * JD-Core Version:    0.6.0
 */