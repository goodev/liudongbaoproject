import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.text.TextUtils;
import com.meizu.mstore.license.ILicensingService;
import com.meizu.mstore.license.LicenseCheckHelper;
import com.meizu.mstore.license.LicenseResult;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class gq
{
  private static final String a;
  private static ILicensingService b;
  private static Context c;
  private static ServiceConnection d;

  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCthnPi6AySRJbU5Nc+EJ7PU6XWmJbKw3UTbP95S7Q0dSjQi4tfR//qozGrUUAC4HkGu9C1vTFo3L20aFTXxS0GVDAT3vthVDIvCZhFGyawYH9kxVQQVd1e3S8E+2W5USUenbWtX6d+JO73hsgBEk1a8dDEVizDSl/Z3z8fOoARlQIDAQAB");
    String str1 = gt.e();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    int i = gt.d();
    StringBuilder localStringBuilder3 = localStringBuilder2.append(i);
    String str2 = gt.c();
    a = str2;
    b = null;
    d = new gr();
  }

  private static String a(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).reset();
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      ((MessageDigest)localObject).update(arrayOfByte);
      if (localObject != null)
      {
        localObject = ((MessageDigest)localObject).digest();
        i = 0;
        while (true)
        {
          int j = localObject.length;
          if (i >= j)
            break label150;
          if (Integer.toHexString(localObject[i] & 0xFF).length() != 1)
            break;
          StringBuilder localStringBuilder2 = localStringBuilder1.append("0");
          String str1 = Integer.toHexString(localObject[i] & 0xFF);
          StringBuilder localStringBuilder3 = localStringBuilder2.append(str1);
          i += 1;
        }
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      while (true)
        localObject = null;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
      {
        int i;
        Object localObject = null;
        continue;
        String str2 = Integer.toHexString(localObject[i] & 0xFF);
        StringBuilder localStringBuilder4 = localStringBuilder1.append(str2);
      }
    }
    label150: return (String)localStringBuilder1.toString();
  }

  public static void a(Context paramContext)
  {
    c = paramContext;
    if (b != null)
      return;
    Intent localIntent1 = new Intent();
    String str = ILicensingService.class.getName();
    Intent localIntent2 = localIntent1.setAction(str);
    ServiceConnection localServiceConnection = d;
    boolean bool = paramContext.bindService(localIntent1, localServiceConnection, 1);
  }

  public static boolean a()
  {
    String str1 = gu.A();
    String str2 = a(a);
    return str1.equals(str2);
  }

  public static void b(Context paramContext)
  {
    if (b == null)
      return;
    ServiceConnection localServiceConnection = d;
    paramContext.unbindService(localServiceConnection);
  }

  private static boolean c()
  {
    String str = a(a);
    if (TextUtils.isEmpty(str));
    for (int i = 0; ; i = 1)
    {
      return i;
      gu.g(str);
    }
  }

  private static boolean d(Context paramContext)
  {
    int i = 0;
    String str1 = paramContext.getPackageName();
    try
    {
      LicenseResult localLicenseResult1 = b.checkLicense(str1);
      localLicenseResult2 = localLicenseResult1;
      j = 0;
      if ((localLicenseResult2 != null) && (localLicenseResult2.getResponseCode() == 1))
      {
        boolean bool = LicenseCheckHelper.checkResult("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCthnPi6AySRJbU5Nc+EJ7PU6XWmJbKw3UTbP95S7Q0dSjQi4tfR//qozGrUUAC4HkGu9C1vTFo3L20aFTXxS0GVDAT3vthVDIvCZhFGyawYH9kxVQQVd1e3S8E+2W5USUenbWtX6d+JO73hsgBEk1a8dDEVizDSl/Z3z8fOoARlQIDAQAB", localLicenseResult2);
        i = localLicenseResult2.getPurchaseType();
        String str2 = "purchaseType:" + i;
        gj.a("MeizuVipLicenseValidUtil", str2);
        if ((bool) && (i == 1) && (c()))
          j = 1;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("responseCode:");
      if (localLicenseResult2 == null)
      {
        localObject = "无结果";
        String str3 = localObject;
        gj.a("MeizuVipLicenseValidUtil", str3);
        return j;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        LicenseResult localLicenseResult2 = null;
        int j = 0;
        continue;
        Object localObject = Integer.valueOf(localLicenseResult2.getResponseCode());
      }
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gq
 * JD-Core Version:    0.6.0
 */