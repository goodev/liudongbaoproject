package com.meizu.mstore.license;

import android.util.Base64;
import android.util.Log;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class LicenseCheckHelper
{
  private static Signature signature;

  static
  {
    try
    {
      signature = Signature.getInstance("SHA1WithRSA");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      String str = localNoSuchAlgorithmException.getMessage();
      int i = Log.e("error", str);
    }
  }

  public static final boolean checkResult(String paramString, LicenseResult paramLicenseResult)
  {
    if (paramLicenseResult.getResponseCode() == 1);
    while (true)
    {
      try
      {
        KeyFactory localKeyFactory = KeyFactory.getInstance("RSA");
        byte[] arrayOfByte1 = Base64.decode(paramString, 0);
        X509EncodedKeySpec localX509EncodedKeySpec = new X509EncodedKeySpec(arrayOfByte1);
        PublicKey localPublicKey = localKeyFactory.generatePublic(localX509EncodedKeySpec);
        signature.initVerify(localPublicKey);
        Signature localSignature1 = signature;
        byte[] arrayOfByte2 = paramLicenseResult.getSignedDataBytes();
        localSignature1.update(arrayOfByte2);
        Signature localSignature2 = signature;
        byte[] arrayOfByte3 = paramLicenseResult.getSignatureBytes();
        boolean bool = localSignature2.verify(arrayOfByte3);
        if (bool)
        {
          i = 1;
          return i;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      int i = 0;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.meizu.mstore.license.LicenseCheckHelper
 * JD-Core Version:    0.6.0
 */