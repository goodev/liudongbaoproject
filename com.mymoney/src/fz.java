public class fz
{
  public static String a = "AES";

  // ERROR //
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 20
    //   3: invokevirtual 26	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   6: aload_1
    //   7: invokestatic 29	fz:a	([BLjava/lang/String;)[B
    //   10: invokestatic 32	fz:a	([B)Ljava/lang/String;
    //   13: astore_2
    //   14: aload_2
    //   15: areturn
    //   16: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	14	16	java/io/UnsupportedEncodingException
  }

  public static String a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length * 3;
    StringBuffer localStringBuffer1 = new StringBuffer(i);
    int j = 0;
    while (true)
    {
      int k = paramArrayOfByte.length;
      if (j >= k)
        break;
      int m = paramArrayOfByte[j] & 0xFF;
      if (m < 16)
        StringBuffer localStringBuffer2 = localStringBuffer1.append("0");
      String str = Integer.toHexString(m);
      StringBuffer localStringBuffer3 = localStringBuffer1.append(str);
      j += 1;
    }
    return localStringBuffer1.toString();
  }

  public static byte[] a(String paramString)
  {
    int i = paramString.length();
    if (i % 2 != 0)
      throw new IllegalArgumentException("长度不是偶数!");
    byte[] arrayOfByte = new byte[i / 2];
    int j = 0;
    while (j < i)
    {
      int k = j + 2;
      String str = paramString.substring(j, k);
      int m = j / 2;
      int n = (byte)Integer.parseInt(str, 16);
      arrayOfByte[m] = n;
      j += 2;
    }
    return arrayOfByte;
  }

  // ERROR //
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: ldc 10
    //   2: invokestatic 80	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   5: astore_2
    //   6: aload_1
    //   7: invokestatic 83	fz:b	(Ljava/lang/String;)[B
    //   10: astore_3
    //   11: new 85	javax/crypto/spec/SecretKeySpec
    //   14: dup
    //   15: aload_3
    //   16: ldc 10
    //   18: invokespecial 88	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   21: astore 4
    //   23: aload_2
    //   24: iconst_1
    //   25: aload 4
    //   27: invokevirtual 92	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   30: aload_2
    //   31: aload_0
    //   32: invokevirtual 96	javax/crypto/Cipher:doFinal	([B)[B
    //   35: astore 5
    //   37: aload 5
    //   39: areturn
    //   40: astore 6
    //   42: aload 6
    //   44: athrow
    //   45: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	37	40	java/lang/Exception
    //   0	37	45	finally
    //   42	45	45	finally
  }

  // ERROR //
  public static String b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 98	fz:a	(Ljava/lang/String;)[B
    //   4: aload_1
    //   5: invokestatic 100	fz:b	([BLjava/lang/String;)[B
    //   8: astore_2
    //   9: new 22	java/lang/String
    //   12: dup
    //   13: aload_2
    //   14: ldc 20
    //   16: invokespecial 101	java/lang/String:<init>	([BLjava/lang/String;)V
    //   19: astore_3
    //   20: aload_3
    //   21: areturn
    //   22: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	20	22	java/io/UnsupportedEncodingException
  }

  public static byte[] b(String paramString)
  {
    if (paramString.length() >= 16)
      return paramString.substring(0, 16).getBytes("UTF-8");
    throw new Exception("");
  }

  // ERROR //
  public static byte[] b(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: ldc 10
    //   2: invokestatic 80	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   5: astore_2
    //   6: aload_1
    //   7: invokestatic 83	fz:b	(Ljava/lang/String;)[B
    //   10: astore_3
    //   11: new 85	javax/crypto/spec/SecretKeySpec
    //   14: dup
    //   15: aload_3
    //   16: ldc 10
    //   18: invokespecial 88	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   21: astore 4
    //   23: aload_2
    //   24: iconst_2
    //   25: aload 4
    //   27: invokevirtual 92	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   30: aload_2
    //   31: aload_0
    //   32: invokevirtual 96	javax/crypto/Cipher:doFinal	([B)[B
    //   35: astore 5
    //   37: aload 5
    //   39: areturn
    //   40: astore 6
    //   42: aload 6
    //   44: athrow
    //   45: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	37	40	java/lang/Exception
    //   0	37	45	finally
    //   42	45	45	finally
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fz
 * JD-Core Version:    0.6.0
 */