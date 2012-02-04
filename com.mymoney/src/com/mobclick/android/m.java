package com.mobclick.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import javax.microedition.khronos.opengles.GL10;

public class m
{
  // ERROR //
  public static String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: new 16	java/io/FileReader
    //   5: dup
    //   6: ldc 18
    //   8: invokespecial 21	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +30 -> 43
    //   16: new 23	java/io/BufferedReader
    //   19: dup
    //   20: aload_1
    //   21: sipush 1024
    //   24: invokespecial 26	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 29	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload_3
    //   34: astore_0
    //   35: aload_2
    //   36: invokevirtual 32	java/io/BufferedReader:close	()V
    //   39: aload_1
    //   40: invokevirtual 33	java/io/FileReader:close	()V
    //   43: aload_0
    //   44: ifnull +20 -> 64
    //   47: aload_0
    //   48: bipush 58
    //   50: invokevirtual 39	java/lang/String:indexOf	(I)I
    //   53: iconst_1
    //   54: iadd
    //   55: istore 4
    //   57: aload_0
    //   58: iload 4
    //   60: invokevirtual 43	java/lang/String:substring	(I)Ljava/lang/String;
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 46	java/lang/String:trim	()Ljava/lang/String;
    //   68: areturn
    //   69: astore 5
    //   71: aconst_null
    //   72: astore_1
    //   73: aload 5
    //   75: astore 6
    //   77: ldc 48
    //   79: ldc 50
    //   81: aload 6
    //   83: invokestatic 56	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   86: istore 7
    //   88: aload_1
    //   89: astore_0
    //   90: goto -47 -> 43
    //   93: astore 8
    //   95: aconst_null
    //   96: astore_1
    //   97: aload 8
    //   99: astore 9
    //   101: ldc 48
    //   103: ldc 58
    //   105: aload 9
    //   107: invokestatic 56	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   110: istore 10
    //   112: aload_1
    //   113: astore_0
    //   114: goto -71 -> 43
    //   117: astore 11
    //   119: aload_0
    //   120: astore_1
    //   121: aload 11
    //   123: astore 9
    //   125: goto -24 -> 101
    //   128: astore 9
    //   130: goto -29 -> 101
    //   133: astore 12
    //   135: aload_0
    //   136: astore_1
    //   137: aload 12
    //   139: astore 6
    //   141: goto -64 -> 77
    //
    // Exception table:
    //   from	to	target	type
    //   16	33	69	java/io/IOException
    //   2	12	93	java/io/FileNotFoundException
    //   16	33	93	java/io/FileNotFoundException
    //   35	43	117	java/io/FileNotFoundException
    //   77	88	128	java/io/FileNotFoundException
    //   35	43	133	java/io/IOException
  }

  public static boolean a(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    String str = paramContext.getPackageName();
    if (localPackageManager.checkPermission(paramString, str) != 0);
    for (int i = 0; ; i = 1)
      return i;
  }

  public static String[] a(GL10 paramGL10)
  {
    try
    {
      arrayOfString = new String[2];
      String str1 = paramGL10.glGetString(7936);
      String str2 = paramGL10.glGetString(7937);
      arrayOfString[0] = str1;
      arrayOfString[1] = str2;
      return arrayOfString;
    }
    catch (Exception localException)
    {
      while (true)
      {
        int i = Log.e("MobclickAgent", "Could not read gpu infor:", localException);
        String[] arrayOfString = new String[0];
      }
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mobclick.android.m
 * JD-Core Version:    0.6.0
 */