import android.content.ContentResolver;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

public class ge
{
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = b(paramOptions, paramInt1, paramInt2);
    int j;
    if (i <= 8)
    {
      j = 1;
      while (j < i)
        int k = j << 1;
    }
    for (int m = (i + 7) / 8 * 8; ; m = j)
      return m;
  }

  // ERROR //
  public static android.graphics.Bitmap a(int paramInt1, int paramInt2, Uri paramUri, ContentResolver paramContentResolver)
  {
    // Byte code:
    //   0: aload_3
    //   1: aload_2
    //   2: ldc 18
    //   4: invokevirtual 24	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   7: astore 4
    //   9: aload 4
    //   11: astore 5
    //   13: aconst_null
    //   14: astore 6
    //   16: iload_0
    //   17: istore 7
    //   19: iload_1
    //   20: istore 8
    //   22: aload_2
    //   23: astore 9
    //   25: aload_3
    //   26: astore 10
    //   28: iload 7
    //   30: iload 8
    //   32: aload 9
    //   34: aload 10
    //   36: aload 5
    //   38: aload 6
    //   40: invokestatic 27	ge:a	(IILandroid/net/Uri;Landroid/content/ContentResolver;Landroid/os/ParcelFileDescriptor;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   43: astore 4
    //   45: aload 4
    //   47: astore 11
    //   49: aload 5
    //   51: invokestatic 30	ge:a	(Landroid/os/ParcelFileDescriptor;)V
    //   54: aload 11
    //   56: areturn
    //   57: astore 12
    //   59: aconst_null
    //   60: astore 13
    //   62: aload 13
    //   64: invokestatic 30	ge:a	(Landroid/os/ParcelFileDescriptor;)V
    //   67: aconst_null
    //   68: astore 11
    //   70: goto -16 -> 54
    //   73: astore 14
    //   75: aconst_null
    //   76: astore 15
    //   78: aload 15
    //   80: invokestatic 30	ge:a	(Landroid/os/ParcelFileDescriptor;)V
    //   83: aload 14
    //   85: athrow
    //   86: astore 14
    //   88: aload 5
    //   90: astore 15
    //   92: goto -14 -> 78
    //   95: astore 16
    //   97: aload 5
    //   99: astore 13
    //   101: goto -39 -> 62
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	57	java/io/IOException
    //   0	9	73	finally
    //   28	45	86	finally
    //   28	45	95	java/io/IOException
  }

  // ERROR //
  public static android.graphics.Bitmap a(int paramInt1, int paramInt2, Uri paramUri, ContentResolver paramContentResolver, ParcelFileDescriptor paramParcelFileDescriptor, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnonnull +263 -> 265
    //   5: aload_2
    //   6: aload_3
    //   7: invokestatic 35	ge:a	(Landroid/net/Uri;Landroid/content/ContentResolver;)Landroid/os/ParcelFileDescriptor;
    //   10: astore 6
    //   12: aload 6
    //   14: astore 7
    //   16: aload 7
    //   18: ifnonnull +14 -> 32
    //   21: aload 7
    //   23: invokestatic 30	ge:a	(Landroid/os/ParcelFileDescriptor;)V
    //   26: aconst_null
    //   27: astore 7
    //   29: aload 7
    //   31: areturn
    //   32: aload 5
    //   34: ifnonnull +224 -> 258
    //   37: new 37	android/graphics/BitmapFactory$Options
    //   40: dup
    //   41: invokespecial 38	android/graphics/BitmapFactory$Options:<init>	()V
    //   44: astore 8
    //   46: aload 7
    //   48: invokevirtual 44	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   51: astore 9
    //   53: aload 8
    //   55: ldc 45
    //   57: putfield 49	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   60: invokestatic 54	ga:a	()Lga;
    //   63: aload 9
    //   65: aload 8
    //   67: invokevirtual 57	ga:a	(Ljava/io/FileDescriptor;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   70: astore 10
    //   72: aload 8
    //   74: getfield 60	android/graphics/BitmapFactory$Options:mCancel	Z
    //   77: ifne +27 -> 104
    //   80: aload 8
    //   82: getfield 64	android/graphics/BitmapFactory$Options:outWidth	I
    //   85: bipush 255
    //   87: if_icmpeq +17 -> 104
    //   90: aload 8
    //   92: getfield 67	android/graphics/BitmapFactory$Options:outHeight	I
    //   95: istore 11
    //   97: iload 11
    //   99: bipush 255
    //   101: if_icmpne +14 -> 115
    //   104: aload 7
    //   106: invokestatic 30	ge:a	(Landroid/os/ParcelFileDescriptor;)V
    //   109: aconst_null
    //   110: astore 7
    //   112: goto -83 -> 29
    //   115: aload 8
    //   117: iload_0
    //   118: iload_1
    //   119: invokestatic 69	ge:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   122: istore 12
    //   124: aload 8
    //   126: iload 12
    //   128: putfield 72	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   131: aload 8
    //   133: ldc 73
    //   135: putfield 49	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   138: aload 8
    //   140: ldc 73
    //   142: putfield 76	android/graphics/BitmapFactory$Options:inDither	Z
    //   145: getstatic 82	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   148: astore 13
    //   150: aload 8
    //   152: aload 13
    //   154: putfield 85	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   157: invokestatic 54	ga:a	()Lga;
    //   160: aload 9
    //   162: aload 8
    //   164: invokevirtual 57	ga:a	(Ljava/io/FileDescriptor;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   167: astore 6
    //   169: aload 6
    //   171: astore 14
    //   173: aload 7
    //   175: invokestatic 30	ge:a	(Landroid/os/ParcelFileDescriptor;)V
    //   178: aload 14
    //   180: astore 7
    //   182: goto -153 -> 29
    //   185: astore 15
    //   187: aload 4
    //   189: astore 16
    //   191: ldc 87
    //   193: ldc 89
    //   195: aload 15
    //   197: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   200: istore 17
    //   202: aload 16
    //   204: invokestatic 30	ge:a	(Landroid/os/ParcelFileDescriptor;)V
    //   207: aconst_null
    //   208: astore 7
    //   210: goto -181 -> 29
    //   213: astore 18
    //   215: aload 4
    //   217: astore 16
    //   219: aload 16
    //   221: invokestatic 30	ge:a	(Landroid/os/ParcelFileDescriptor;)V
    //   224: aload 18
    //   226: athrow
    //   227: astore 19
    //   229: aload 7
    //   231: astore 16
    //   233: aload 19
    //   235: astore 18
    //   237: goto -18 -> 219
    //   240: astore 18
    //   242: goto -23 -> 219
    //   245: astore 20
    //   247: aload 7
    //   249: astore 16
    //   251: aload 20
    //   253: astore 15
    //   255: goto -64 -> 191
    //   258: aload 5
    //   260: astore 8
    //   262: goto -216 -> 46
    //   265: aload 4
    //   267: astore 7
    //   269: goto -253 -> 16
    //
    // Exception table:
    //   from	to	target	type
    //   5	12	185	java/lang/OutOfMemoryError
    //   5	12	213	finally
    //   37	97	227	finally
    //   115	169	227	finally
    //   191	202	240	finally
    //   37	97	245	java/lang/OutOfMemoryError
    //   115	169	245	java/lang/OutOfMemoryError
  }

  private static ParcelFileDescriptor a(Uri paramUri, ContentResolver paramContentResolver)
  {
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor1 = paramContentResolver.openFileDescriptor(paramUri, "r");
      localParcelFileDescriptor2 = localParcelFileDescriptor1;
      return localParcelFileDescriptor2;
    }
    catch (IOException localIOException)
    {
      while (true)
        ParcelFileDescriptor localParcelFileDescriptor2 = null;
    }
  }

  public static void a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null)
      return;
    try
    {
      paramParcelFileDescriptor.close();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private static int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i;
    int j;
    if (paramInt2 == -1)
    {
      i = 1;
      if (paramInt1 != -1)
        break label74;
      j = 128;
      label33: if (j >= i)
        break label114;
      j = i;
    }
    while (true)
    {
      return j;
      float f = d1 * d2;
      double d3 = paramInt2;
      i = (int)Math.ceil(Math.sqrt(f / d3));
      break;
      label74: double d4 = paramInt1;
      double d5 = Math.floor(d1 / d4);
      double d6 = paramInt1;
      double d7 = Math.floor(d2 / d6);
      int k = (int)Math.min(d5, d7);
      break label33;
      label114: if ((paramInt2 == -1) && (paramInt1 == -1))
      {
        j = 1;
        continue;
      }
      if (paramInt1 != -1)
        continue;
      j = i;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ge
 * JD-Core Version:    0.6.0
 */