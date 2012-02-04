import android.os.Environment;
import com.mymoney.core.application.ApplicationContext;
import java.io.File;
import java.util.Date;

public class eo
{
  public static String a = Environment.getExternalStorageDirectory().getPath();
  public static String b;
  public static String c;
  public static String d;

  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = a;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("/");
    String str2 = ep.c;
    b = str2 + "/Photos/";
    c = "Photos";
    d = ".jpeg";
  }

  // ERROR //
  public static java.io.FileOutputStream a(android.graphics.Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_1
    //   5: invokevirtual 61	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   8: astore 4
    //   10: new 63	java/io/FileOutputStream
    //   13: dup
    //   14: aload 4
    //   16: invokespecial 66	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   19: astore 5
    //   21: bipush 100
    //   23: istore 6
    //   25: aload 5
    //   27: astore_2
    //   28: getstatic 72	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   31: astore 7
    //   33: aload_0
    //   34: aload 7
    //   36: iload 6
    //   38: aload_2
    //   39: invokevirtual 78	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   42: istore 8
    //   44: iload 6
    //   46: iconst_2
    //   47: idiv
    //   48: istore 9
    //   50: aload_2
    //   51: invokevirtual 82	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   54: invokevirtual 88	java/nio/channels/FileChannel:size	()J
    //   57: lstore 5
    //   59: lload 5
    //   61: ldc2_w 89
    //   64: lcmp
    //   65: iflt +32 -> 97
    //   68: aload_2
    //   69: invokevirtual 93	java/io/FileOutputStream:flush	()V
    //   72: aload_2
    //   73: invokevirtual 96	java/io/FileOutputStream:close	()V
    //   76: aload_1
    //   77: invokevirtual 61	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: astore 10
    //   82: new 63	java/io/FileOutputStream
    //   85: dup
    //   86: aload 10
    //   88: invokespecial 66	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   91: astore 11
    //   93: aload 11
    //   95: astore 12
    //   97: lload 5
    //   99: ldc2_w 89
    //   102: lcmp
    //   103: ifge -75 -> 28
    //   106: aload_2
    //   107: areturn
    //   108: astore 13
    //   110: aload 13
    //   112: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   115: aload_3
    //   116: astore_2
    //   117: goto -11 -> 106
    //   120: astore 14
    //   122: aload_2
    //   123: astore_3
    //   124: aload 14
    //   126: astore 13
    //   128: goto -18 -> 110
    //
    // Exception table:
    //   from	to	target	type
    //   4	21	108	java/io/IOException
    //   28	93	120	java/io/IOException
  }

  public static String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    long l1 = ApplicationContext.d;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(l1).append("_");
    long l2 = gt.a();
    String str = gi.b(new Date(l2), "yyyyMMddHHmmss");
    return str;
  }

  public static String a(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = b;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(paramString);
    String str2 = d;
    return str2;
  }

  public static File b(String paramString)
  {
    String str = a(paramString);
    b();
    return new File(str);
  }

  public static void b()
  {
    String str = b;
    File localFile = new File(str);
    if (localFile.exists())
      return;
    boolean bool = localFile.mkdirs();
  }

  public static boolean c(String paramString)
  {
    String str = a(paramString);
    return new File(str).delete();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     eo
 * JD-Core Version:    0.6.0
 */