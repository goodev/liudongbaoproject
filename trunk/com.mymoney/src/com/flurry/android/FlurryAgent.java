package com.flurry.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class FlurryAgent
  implements LocationListener
{
  private static volatile String a = null;
  private static final FlurryAgent b;
  private static long c;
  private static long d;
  private static boolean e;
  private static boolean f;
  private static boolean g;
  private static Criteria h;
  private static volatile String kInsecureReportUrl = "http://data.flurry.com/aar.do";
  private static volatile String kSecureReportUrl = "https://data.flurry.com/aar.do";
  private long A;
  private String B;
  private int C;
  private Location D;
  private Map E;
  private List F;
  private boolean G;
  private int H;
  private List I;
  private int J;
  private final Handler i;
  private File j = null;
  private boolean k = 0;
  private boolean l = 0;
  private long m;
  private Map n;
  private String o;
  private String p;
  private String q;
  private boolean r;
  private List s;
  private LocationManager t;
  private String u;
  private boolean v;
  private long w;
  private List x;
  private long y;
  private long z;

  static
  {
    b = new FlurryAgent();
    c = 10000L;
    d = 20000L;
    e = 1;
    f = 0;
    g = 1;
    h = null;
  }

  private FlurryAgent()
  {
    WeakHashMap localWeakHashMap = new WeakHashMap();
    this.n = localWeakHashMap;
    this.r = 1;
    ArrayList localArrayList = new ArrayList();
    this.x = localArrayList;
    HandlerThread localHandlerThread = new HandlerThread("FlurryAgent");
    localHandlerThread.start();
    Looper localLooper = localHandlerThread.getLooper();
    Handler localHandler = new Handler(localLooper);
    this.i = localHandler;
  }

  private static String a(String paramString)
  {
    String str;
    if (paramString == null)
      str = "";
    while (true)
    {
      return str;
      if (paramString.length() <= 255)
      {
        str = paramString;
        continue;
      }
      str = paramString.substring(0, 255);
    }
  }

  /** @deprecated */
  // ERROR //
  private void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 148	com/flurry/android/FlurryAgent:o	Ljava/lang/String;
    //   6: ifnull +62 -> 68
    //   9: aload_0
    //   10: getfield 148	com/flurry/android/FlurryAgent:o	Ljava/lang/String;
    //   13: aload_2
    //   14: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifne +51 -> 68
    //   20: new 154	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   27: ldc 157
    //   29: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: astore_3
    //   33: aload_0
    //   34: getfield 148	com/flurry/android/FlurryAgent:o	Ljava/lang/String;
    //   37: astore 4
    //   39: aload_3
    //   40: aload 4
    //   42: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 163
    //   47: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_2
    //   51: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore 5
    //   59: ldc 113
    //   61: aload 5
    //   63: invokestatic 172	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   66: istore 6
    //   68: aload_0
    //   69: getfield 102	com/flurry/android/FlurryAgent:n	Ljava/util/Map;
    //   72: aload_1
    //   73: aload_1
    //   74: invokeinterface 178 3 0
    //   79: checkcast 180	android/content/Context
    //   82: ifnull +12 -> 94
    //   85: ldc 113
    //   87: ldc 182
    //   89: invokestatic 184	com/flurry/android/Flog:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   92: istore 7
    //   94: aload_0
    //   95: getfield 95	com/flurry/android/FlurryAgent:k	Z
    //   98: ifne +567 -> 665
    //   101: aload_0
    //   102: aload_2
    //   103: putfield 148	com/flurry/android/FlurryAgent:o	Ljava/lang/String;
    //   106: new 154	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   113: ldc 186
    //   115: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: astore 8
    //   120: aload_0
    //   121: getfield 148	com/flurry/android/FlurryAgent:o	Ljava/lang/String;
    //   124: invokevirtual 189	java/lang/String:hashCode	()I
    //   127: bipush 16
    //   129: invokestatic 193	java/lang/Integer:toString	(II)Ljava/lang/String;
    //   132: astore 9
    //   134: aload 8
    //   136: aload 9
    //   138: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore 10
    //   146: aload_1
    //   147: aload 10
    //   149: invokevirtual 197	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   152: astore 11
    //   154: aload_0
    //   155: aload 11
    //   157: putfield 93	com/flurry/android/FlurryAgent:j	Ljava/io/File;
    //   160: getstatic 88	com/flurry/android/FlurryAgent:g	Z
    //   163: ifeq +13 -> 176
    //   166: new 199	com/flurry/android/d
    //   169: dup
    //   170: invokespecial 200	com/flurry/android/d:<init>	()V
    //   173: invokestatic 206	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   176: aload_1
    //   177: invokevirtual 210	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   180: astore 12
    //   182: aload_0
    //   183: ldc 81
    //   185: putfield 95	com/flurry/android/FlurryAgent:k	Z
    //   188: aload_0
    //   189: getfield 212	com/flurry/android/FlurryAgent:q	Ljava/lang/String;
    //   192: ifnonnull +16 -> 208
    //   195: aload 12
    //   197: invokestatic 215	com/flurry/android/FlurryAgent:b	(Landroid/content/Context;)Ljava/lang/String;
    //   200: astore 13
    //   202: aload_0
    //   203: aload 13
    //   205: putfield 212	com/flurry/android/FlurryAgent:q	Ljava/lang/String;
    //   208: aload 12
    //   210: invokevirtual 218	android/content/Context:getPackageName	()Ljava/lang/String;
    //   213: astore 14
    //   215: aload_0
    //   216: getfield 220	com/flurry/android/FlurryAgent:p	Ljava/lang/String;
    //   219: ifnull +66 -> 285
    //   222: aload_0
    //   223: getfield 220	com/flurry/android/FlurryAgent:p	Ljava/lang/String;
    //   226: aload 14
    //   228: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifne +54 -> 285
    //   234: new 154	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   241: ldc 222
    //   243: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: astore 15
    //   248: aload_0
    //   249: getfield 220	com/flurry/android/FlurryAgent:p	Ljava/lang/String;
    //   252: astore 16
    //   254: aload 15
    //   256: aload 16
    //   258: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc 163
    //   263: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload 14
    //   268: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: astore 17
    //   276: ldc 113
    //   278: aload 17
    //   280: invokestatic 172	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   283: istore 18
    //   285: aload_0
    //   286: aload 14
    //   288: putfield 220	com/flurry/android/FlurryAgent:p	Ljava/lang/String;
    //   291: invokestatic 228	android/os/SystemClock:elapsedRealtime	()J
    //   294: lstore 14
    //   296: aload_0
    //   297: getfield 230	com/flurry/android/FlurryAgent:m	J
    //   300: lstore 19
    //   302: lload 14
    //   304: lload 19
    //   306: lsub
    //   307: lstore 21
    //   309: getstatic 76	com/flurry/android/FlurryAgent:c	J
    //   312: lstore 23
    //   314: lload 21
    //   316: lload 23
    //   318: lcmp
    //   319: ifle +451 -> 770
    //   322: ldc 113
    //   324: ldc 232
    //   326: invokestatic 234	com/flurry/android/Flog:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   329: istore 25
    //   331: invokestatic 239	java/lang/System:currentTimeMillis	()J
    //   334: lstore 26
    //   336: aload_0
    //   337: lload 26
    //   339: putfield 241	com/flurry/android/FlurryAgent:y	J
    //   342: aload_0
    //   343: lload 14
    //   345: putfield 243	com/flurry/android/FlurryAgent:z	J
    //   348: aload_0
    //   349: ldc2_w 244
    //   352: putfield 247	com/flurry/android/FlurryAgent:A	J
    //   355: aload_0
    //   356: ldc 133
    //   358: putfield 249	com/flurry/android/FlurryAgent:B	Ljava/lang/String;
    //   361: aload_0
    //   362: iconst_0
    //   363: putfield 251	com/flurry/android/FlurryAgent:C	I
    //   366: aload_0
    //   367: aconst_null
    //   368: putfield 253	com/flurry/android/FlurryAgent:D	Landroid/location/Location;
    //   371: new 255	java/util/HashMap
    //   374: dup
    //   375: invokespecial 256	java/util/HashMap:<init>	()V
    //   378: astore 28
    //   380: aload_0
    //   381: aload 28
    //   383: putfield 258	com/flurry/android/FlurryAgent:E	Ljava/util/Map;
    //   386: new 106	java/util/ArrayList
    //   389: dup
    //   390: invokespecial 107	java/util/ArrayList:<init>	()V
    //   393: astore 29
    //   395: aload_0
    //   396: aload 29
    //   398: putfield 260	com/flurry/android/FlurryAgent:F	Ljava/util/List;
    //   401: aload_0
    //   402: ldc 81
    //   404: putfield 262	com/flurry/android/FlurryAgent:G	Z
    //   407: new 106	java/util/ArrayList
    //   410: dup
    //   411: invokespecial 107	java/util/ArrayList:<init>	()V
    //   414: astore 30
    //   416: aload_0
    //   417: aload 30
    //   419: putfield 264	com/flurry/android/FlurryAgent:I	Ljava/util/List;
    //   422: aload_0
    //   423: iconst_0
    //   424: putfield 266	com/flurry/android/FlurryAgent:H	I
    //   427: aload_0
    //   428: iconst_0
    //   429: putfield 268	com/flurry/android/FlurryAgent:J	I
    //   432: aload_0
    //   433: getfield 97	com/flurry/android/FlurryAgent:l	Z
    //   436: ifne +194 -> 630
    //   439: aload_0
    //   440: getfield 93	com/flurry/android/FlurryAgent:j	Ljava/io/File;
    //   443: invokevirtual 274	java/io/File:exists	()Z
    //   446: istore 31
    //   448: iload 31
    //   450: ifeq +83 -> 533
    //   453: aconst_null
    //   454: astore 14
    //   456: aload_0
    //   457: getfield 93	com/flurry/android/FlurryAgent:j	Ljava/io/File;
    //   460: astore 32
    //   462: new 276	java/io/FileInputStream
    //   465: dup
    //   466: aload 32
    //   468: invokespecial 279	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   471: astore 33
    //   473: new 281	java/io/DataInputStream
    //   476: dup
    //   477: aload 33
    //   479: invokespecial 284	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   482: astore 34
    //   484: aload 34
    //   486: invokevirtual 287	java/io/DataInputStream:readUnsignedShort	()I
    //   489: ldc_w 288
    //   492: if_icmpne +9 -> 501
    //   495: aload_0
    //   496: aload 34
    //   498: invokespecial 291	com/flurry/android/FlurryAgent:a	(Ljava/io/DataInputStream;)V
    //   501: aload 34
    //   503: invokestatic 294	com/flurry/android/FlurryAgent:a	(Ljava/io/Closeable;)V
    //   506: aload_0
    //   507: getfield 97	com/flurry/android/FlurryAgent:l	Z
    //   510: ifne +23 -> 533
    //   513: aload_0
    //   514: getfield 93	com/flurry/android/FlurryAgent:j	Ljava/io/File;
    //   517: invokevirtual 297	java/io/File:delete	()Z
    //   520: ifne +13 -> 533
    //   523: ldc 113
    //   525: ldc_w 299
    //   528: invokestatic 172	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   531: istore 35
    //   533: aload_0
    //   534: getfield 97	com/flurry/android/FlurryAgent:l	Z
    //   537: ifne +93 -> 630
    //   540: aload_0
    //   541: ldc 84
    //   543: putfield 301	com/flurry/android/FlurryAgent:v	Z
    //   546: aload_0
    //   547: getfield 241	com/flurry/android/FlurryAgent:y	J
    //   550: lstore 36
    //   552: aload_0
    //   553: lload 36
    //   555: putfield 303	com/flurry/android/FlurryAgent:w	J
    //   558: aload 12
    //   560: invokevirtual 307	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   563: ldc_w 309
    //   566: invokestatic 315	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   569: astore 14
    //   571: aload 14
    //   573: ifnull +157 -> 730
    //   576: aload 14
    //   578: invokevirtual 139	java/lang/String:length	()I
    //   581: ifle +149 -> 730
    //   584: aload 14
    //   586: ldc_w 317
    //   589: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   592: ifne +138 -> 730
    //   595: new 154	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 319
    //   605: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload 14
    //   610: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: astore 14
    //   618: aload_0
    //   619: aload 14
    //   621: putfield 321	com/flurry/android/FlurryAgent:u	Ljava/lang/String;
    //   624: aload_0
    //   625: ldc 81
    //   627: putfield 97	com/flurry/android/FlurryAgent:l	Z
    //   630: aload_0
    //   631: getfield 104	com/flurry/android/FlurryAgent:r	Z
    //   634: istore 38
    //   636: aload_0
    //   637: getfield 130	com/flurry/android/FlurryAgent:i	Landroid/os/Handler;
    //   640: astore 39
    //   642: new 323	com/flurry/android/c
    //   645: dup
    //   646: aload_0
    //   647: aload 12
    //   649: iload 38
    //   651: invokespecial 326	com/flurry/android/c:<init>	(Lcom/flurry/android/FlurryAgent;Landroid/content/Context;Z)V
    //   654: astore 40
    //   656: aload 39
    //   658: aload 40
    //   660: invokevirtual 330	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   663: istore 41
    //   665: aload_0
    //   666: monitorexit
    //   667: return
    //   668: astore 42
    //   670: aload 14
    //   672: astore 43
    //   674: aload 42
    //   676: astore 14
    //   678: ldc 113
    //   680: ldc 133
    //   682: aload 14
    //   684: invokestatic 333	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   687: istore 44
    //   689: aload 43
    //   691: invokestatic 294	com/flurry/android/FlurryAgent:a	(Ljava/io/Closeable;)V
    //   694: goto -188 -> 506
    //   697: astore 45
    //   699: aload_0
    //   700: monitorexit
    //   701: aload 45
    //   703: athrow
    //   704: astore 12
    //   706: aload 14
    //   708: invokestatic 294	com/flurry/android/FlurryAgent:a	(Ljava/io/Closeable;)V
    //   711: aload 12
    //   713: athrow
    //   714: astore 46
    //   716: ldc 113
    //   718: ldc 133
    //   720: aload 46
    //   722: invokestatic 333	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   725: istore 47
    //   727: goto -194 -> 533
    //   730: new 154	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   737: ldc_w 335
    //   740: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: astore 48
    //   745: invokestatic 239	java/lang/System:currentTimeMillis	()J
    //   748: bipush 16
    //   750: invokestatic 340	java/lang/Long:toString	(JI)Ljava/lang/String;
    //   753: astore 49
    //   755: aload 48
    //   757: aload 49
    //   759: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: astore 14
    //   767: goto -149 -> 618
    //   770: ldc 113
    //   772: ldc_w 342
    //   775: invokestatic 234	com/flurry/android/Flog:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   778: istore 50
    //   780: aload_0
    //   781: getfield 109	com/flurry/android/FlurryAgent:x	Ljava/util/List;
    //   784: astore 51
    //   786: aload_0
    //   787: getfield 109	com/flurry/android/FlurryAgent:x	Ljava/util/List;
    //   790: invokeinterface 347 1 0
    //   795: iconst_1
    //   796: isub
    //   797: istore 52
    //   799: aload 51
    //   801: iload 52
    //   803: invokeinterface 351 2 0
    //   808: astore 53
    //   810: goto -145 -> 665
    //   813: astore 12
    //   815: aload 34
    //   817: astore 14
    //   819: goto -113 -> 706
    //   822: astore 12
    //   824: aload 43
    //   826: astore 14
    //   828: goto -122 -> 706
    //   831: astore 14
    //   833: aload 34
    //   835: astore 43
    //   837: goto -159 -> 678
    //
    // Exception table:
    //   from	to	target	type
    //   456	484	668	java/lang/Throwable
    //   2	448	697	finally
    //   501	506	697	finally
    //   506	533	697	finally
    //   533	665	697	finally
    //   689	694	697	finally
    //   706	810	697	finally
    //   456	484	704	finally
    //   506	533	714	java/lang/Throwable
    //   484	501	813	finally
    //   678	689	822	finally
    //   484	501	831	java/lang/Throwable
  }

  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable == null)
      return;
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  /** @deprecated */
  private void a(DataInputStream paramDataInputStream)
  {
    monitorenter;
    int i1;
    try
    {
      i1 = paramDataInputStream.readUnsignedShort();
      if (i1 > 2)
      {
        String str2 = "Unknown agent file version: " + i1;
        throw new IOException(str2);
      }
    }
    finally
    {
      monitorexit;
    }
    int i2;
    if (i1 >= 2)
    {
      String str1 = paramDataInputStream.readUTF();
      String str3 = this.o;
      if (!str1.equals(str3))
        break label154;
      String str4 = paramDataInputStream.readUTF();
      this.u = str4;
      boolean bool = paramDataInputStream.readBoolean();
      this.v = bool;
      long l1 = paramDataInputStream.readLong();
      this.w = l1;
      while (true)
      {
        i2 = paramDataInputStream.readUnsignedShort();
        if (i2 == 0)
          break;
        byte[] arrayOfByte = new byte[i2];
        paramDataInputStream.readFully(arrayOfByte);
        this.x.add(0, arrayOfByte);
      }
      this.l = 1;
    }
    while (true)
    {
      monitorexit;
      return;
      label154: StringBuilder localStringBuilder = new StringBuilder().append("Api keys do not match, old: ").append(i2).append(", new: ");
      String str5 = this.o;
      String str6 = str5;
      int i3 = Flog.a("FlurryAgent", str6);
    }
  }

  /** @deprecated */
  private void a(String paramString1, String paramString2, String paramString3)
  {
    monitorenter;
    try
    {
      if (this.I == null)
      {
        String str1 = "onError called before onStartSession.  Error: " + paramString1;
        int i1 = Flog.b("FlurryAgent", str1);
      }
      while (true)
      {
        return;
        int i2 = this.C + 1;
        this.C = i2;
        if (this.I.size() >= 10)
          continue;
        f localf = new f();
        long l1 = System.currentTimeMillis();
        localf.a = l1;
        String str2 = a(paramString1);
        localf.b = str2;
        String str3 = a(paramString2);
        localf.c = str3;
        String str4 = a(paramString3);
        localf.d = str4;
        boolean bool = this.I.add(localf);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  /** @deprecated */
  private void a(String paramString, Map paramMap)
  {
    monitorenter;
    while (true)
    {
      String str2;
      try
      {
        if (this.F != null)
          continue;
        String str1 = "onEvent called before onStartSession.  Event: " + paramString;
        int i1 = Flog.b("FlurryAgent", str1);
        return;
        str2 = a(paramString);
        if (str2.length() == 0)
          continue;
        localObject1 = (e)this.E.get(str2);
        if (localObject1 != null)
          break label277;
        if (this.E.size() < 100)
        {
          e locale = new e();
          locale.a = 1;
          Object localObject2 = this.E.put(str2, locale);
          if ((!e) || (this.F.size() >= 100) || (this.H >= 8000))
            break label379;
          if (paramMap != null)
            break label388;
          localObject1 = Collections.emptyMap();
          if (((Map)localObject1).size() <= 10)
            break label296;
          if (!Flog.a("FlurryAgent"))
            continue;
          StringBuilder localStringBuilder = new StringBuilder().append("MaxEventParams exceeded: ");
          int i2 = ((Map)localObject1).size();
          String str3 = i2;
          int i3 = Flog.a("FlurryAgent", str3);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      if (!Flog.a("FlurryAgent"))
        continue;
      String str4 = "MaxEventIds exceeded: " + str2;
      int i4 = Flog.a("FlurryAgent", str4);
      continue;
      label277: int i5 = ((e)localObject1).a + 1;
      ((e)localObject1).a = i5;
      continue;
      label296: Object localObject1 = b(str2, (Map)localObject1);
      int i6 = localObject1.length;
      int i7 = this.H;
      if (i6 + i7 <= 8000)
      {
        boolean bool = this.F.add(localObject1);
        int i8 = this.H;
        int i9 = localObject1.length + i8;
        this.H = i9;
        continue;
      }
      this.H = 8000;
      this.G = 0;
      continue;
      label379: this.G = 0;
      continue;
      label388: localObject1 = paramMap;
    }
  }

  private boolean a(byte[] paramArrayOfByte)
  {
    String str;
    int i1;
    if (a != null)
    {
      str = a;
      if (str != null)
        break label25;
      i1 = 0;
    }
    while (true)
    {
      return i1;
      str = kInsecureReportUrl;
      break;
      try
      {
        label25: boolean bool = a(paramArrayOfByte, str);
        i1 = bool;
        if ((i1 != 0) || (a == null))
          continue;
      }
      catch (Exception localException)
      {
        while (true)
          i1 = 0;
      }
    }
  }

  private boolean a(byte[] paramArrayOfByte, String paramString)
  {
    String str = "Sending report to: " + paramString;
    int i1 = Flog.a("FlurryAgent", str);
    int i2 = 0;
    ByteArrayEntity localByteArrayEntity = new ByteArrayEntity(paramArrayOfByte);
    localByteArrayEntity.setContentType("application/octet-stream");
    HttpPost localHttpPost = new HttpPost(paramString);
    localHttpPost.setEntity(localByteArrayEntity);
    int i3 = new DefaultHttpClient().execute(localHttpPost).getStatusLine().getStatusCode();
    monitorenter;
    if (i3 == 200);
    try
    {
      int i4 = Flog.a("FlurryAgent", "Report successful");
      this.v = 1;
      List localList1 = this.x;
      List localList2 = this.s;
      boolean bool = localList1.removeAll(localList2);
      i2 = 1;
      while (true)
      {
        monitorexit;
        this.s = null;
        return i2;
        int i5 = Flog.a("FlurryAgent", "Report failed");
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static String b(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      String str1 = paramContext.getPackageName();
      localObject = localPackageManager.getPackageInfo(str1, 0);
      if (((PackageInfo)localObject).versionName != null);
      String str2;
      for (localObject = ((PackageInfo)localObject).versionName; ; localObject = str2)
      {
        return localObject;
        if (((PackageInfo)localObject).versionCode == 0)
          break;
        str2 = Integer.toString(((PackageInfo)localObject).versionCode);
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        int i1 = Flog.b("FlurryAgent", "", localThrowable);
        Object localObject = "Unknown";
      }
    }
  }

  /** @deprecated */
  private void b(Context paramContext, boolean paramBoolean)
  {
    monitorenter;
    if (paramContext != null);
    try
    {
      if ((Context)this.n.remove(paramContext) == null)
        int i1 = Flog.c("FlurryAgent", "onEndSession called without context from corresponding onStartSession");
      if ((this.k) && (this.n.isEmpty()))
      {
        int i2 = Flog.a("FlurryAgent", "Ending session");
        a();
        if (paramContext != null)
          break label232;
      }
      label232: Context localContext;
      for (Object localObject1 = null; ; localObject1 = localContext)
      {
        if (paramContext != null)
        {
          String str1 = ((Context)localObject1).getPackageName();
          if (!this.p.equals(str1))
          {
            StringBuilder localStringBuilder = new StringBuilder().append("onEndSession called from different application package, expected: ");
            String str2 = this.p;
            String str3 = str2 + " actual: " + str1;
            int i3 = Flog.b("FlurryAgent", str3);
          }
        }
        this.k = 0;
        long l1 = SystemClock.elapsedRealtime();
        this.m = l1;
        long l2 = this.z;
        long l3 = l1 - l2;
        this.A = l3;
        c();
        g();
        if (!paramBoolean)
        {
          Handler localHandler = this.i;
          a locala = new a(this, (Context)localObject1);
          long l4 = c;
          boolean bool = localHandler.postDelayed(locala, l4);
        }
        return;
        localContext = paramContext.getApplicationContext();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  private static byte[] b(String paramString, Map paramMap)
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    DataOutputStream localDataOutputStream;
    Object localObject;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
      localDataOutputStream.writeUTF(paramString);
      int i1 = paramMap.size();
      localDataOutputStream.writeShort(i1);
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str1 = a((String)localEntry.getKey());
        localDataOutputStream.writeUTF(str1);
        String str2 = a((String)localEntry.getValue());
        localDataOutputStream.writeUTF(str2);
      }
    }
    catch (IOException localIOException)
    {
      localObject = new byte[0];
    }
    while (true)
    {
      return localObject;
      localDataOutputStream.close();
      byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
      localObject = arrayOfByte;
    }
  }

  private Location c(Context paramContext)
  {
    Object localObject1;
    if ((paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) || (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0))
    {
      localObject1 = (LocationManager)paramContext.getSystemService("location");
      monitorenter;
    }
    while (true)
    {
      try
      {
        if (this.t != null)
          continue;
        this.t = ((LocationManager)localObject1);
        Object localObject2 = h;
        if (localObject2 != null)
          continue;
        localObject2 = new Criteria();
        localObject2 = ((LocationManager)localObject1).getBestProvider((Criteria)localObject2, 1);
        if (localObject2 == null)
          continue;
        Looper localLooper = Looper.getMainLooper();
        FlurryAgent localFlurryAgent = this;
        ((LocationManager)localObject1).requestLocationUpdates((String)localObject2, 0L, 0.0F, localFlurryAgent, localLooper);
        Handler localHandler = this.i;
        b localb = new b(this);
        long l1 = d;
        boolean bool = localHandler.postDelayed(localb, l1);
        monitorexit;
        if (localObject2 != null)
        {
          localObject1 = ((LocationManager)localObject1).getLastKnownLocation((String)localObject2);
          return localObject1;
          localObject1 = this.t;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      localObject1 = null;
    }
  }

  private void c()
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    DataOutputStream localDataOutputStream;
    while (true)
    {
      try
      {
        localByteArrayOutputStream = new ByteArrayOutputStream();
        localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
        String str1 = this.q;
        localDataOutputStream.writeUTF(str1);
        long l1 = this.y;
        localDataOutputStream.writeLong(l1);
        long l2 = this.A;
        localDataOutputStream.writeLong(l2);
        String str2 = this.B;
        localDataOutputStream.writeUTF(str2);
        if (this.D == null)
        {
          localDataOutputStream.writeBoolean(0);
          int i1 = this.J;
          localDataOutputStream.writeInt(i1);
          localDataOutputStream.writeByte(-1);
          int i2 = this.E.size();
          localDataOutputStream.writeShort(i2);
          Iterator localIterator1 = this.E.entrySet().iterator();
          if (!localIterator1.hasNext())
            break;
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          String str3 = (String)localEntry.getKey();
          localDataOutputStream.writeUTF(str3);
          int i3 = ((e)localEntry.getValue()).a;
          localDataOutputStream.writeInt(i3);
          continue;
        }
      }
      catch (IOException localIOException)
      {
        int i4 = Flog.b("FlurryAgent", "", localIOException);
        return;
      }
      int i5 = 1;
      localDataOutputStream.writeBoolean(i5);
      double d1 = this.D.getLatitude();
      localDataOutputStream.writeDouble(d1);
      double d2 = this.D.getLongitude();
      localDataOutputStream.writeDouble(d2);
      float f1 = this.D.getAccuracy();
      localDataOutputStream.writeFloat(f1);
    }
    int i6 = this.F.size();
    localDataOutputStream.writeShort(i6);
    Iterator localIterator2 = this.F.iterator();
    while (localIterator2.hasNext())
    {
      byte[] arrayOfByte1 = (byte[])localIterator2.next();
      localDataOutputStream.write(arrayOfByte1);
    }
    boolean bool1 = this.G;
    localDataOutputStream.writeBoolean(bool1);
    int i7 = this.C;
    localDataOutputStream.writeInt(i7);
    int i8 = this.I.size();
    localDataOutputStream.writeShort(i8);
    localIterator2 = this.I.iterator();
    while (localIterator2.hasNext())
    {
      f localf = (f)localIterator2.next();
      long l3 = localf.a;
      localDataOutputStream.writeLong(l3);
      String str4 = localf.b;
      localDataOutputStream.writeUTF(str4);
      String str5 = localf.c;
      localDataOutputStream.writeUTF(str5);
      String str6 = localf.d;
      localDataOutputStream.writeUTF(str6);
    }
    localDataOutputStream.writeShort(0);
    List localList = this.x;
    byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
    boolean bool2 = localList.add(arrayOfByte2);
  }

  /** @deprecated */
  private void d()
  {
    monitorenter;
    try
    {
      int i1 = this.J + 1;
      this.J = i1;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  /** @deprecated */
  private byte[] e()
  {
    monitorenter;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
      localDataOutputStream.writeShort(8);
      localDataOutputStream.writeShort(0);
      localDataOutputStream.writeShort(3);
      localDataOutputStream.writeShort(30);
      long l1 = System.currentTimeMillis();
      localDataOutputStream.writeLong(l1);
      String str1 = this.o;
      localDataOutputStream.writeUTF(str1);
      String str2 = this.q;
      localDataOutputStream.writeUTF(str2);
      String str3 = this.u;
      localDataOutputStream.writeUTF(str3);
      long l2 = this.w;
      localDataOutputStream.writeLong(l2);
      long l3 = this.y;
      localDataOutputStream.writeLong(l3);
      localDataOutputStream.writeShort(4);
      localDataOutputStream.writeUTF("device.model");
      String str4 = Build.MODEL;
      localDataOutputStream.writeUTF(str4);
      localDataOutputStream.writeUTF("build.brand");
      String str5 = Build.BRAND;
      localDataOutputStream.writeUTF(str5);
      localDataOutputStream.writeUTF("build.id");
      String str6 = Build.ID;
      localDataOutputStream.writeUTF(str6);
      localDataOutputStream.writeUTF("version.release");
      String str7 = Build.VERSION.RELEASE;
      localDataOutputStream.writeUTF(str7);
      int i1 = this.x.size();
      localDataOutputStream.writeShort(i1);
      int i2 = 0;
      while (i2 < i1)
      {
        byte[] arrayOfByte1 = (byte[])this.x.get(i2);
        localDataOutputStream.write(arrayOfByte1);
        i2 += 1;
      }
      List localList = this.x;
      ArrayList localArrayList = new ArrayList(localList);
      this.s = localArrayList;
      localDataOutputStream.close();
      byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
      byte[] arrayOfByte3 = arrayOfByte2;
      return arrayOfByte3;
    }
    catch (IOException localObject1)
    {
      while (true)
      {
        int i3 = Flog.b("FlurryAgent", "", localIOException);
        Object localObject1 = null;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  private void f()
  {
    try
    {
      byte[] arrayOfByte = e();
      if (arrayOfByte == null)
        return;
      if (!a(arrayOfByte))
        return;
      g();
      return;
    }
    catch (IOException localIOException)
    {
      int i1 = Flog.a("FlurryAgent", "", localIOException);
      return;
    }
    catch (Throwable localThrowable)
    {
      int i2 = Flog.b("FlurryAgent", "", localThrowable);
    }
  }

  /** @deprecated */
  // ERROR //
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 93	com/flurry/android/FlurryAgent:j	Ljava/io/File;
    //   6: invokevirtual 712	java/io/File:getParentFile	()Ljava/io/File;
    //   9: astore_1
    //   10: aload_1
    //   11: invokevirtual 715	java/io/File:mkdirs	()Z
    //   14: ifne +49 -> 63
    //   17: aload_1
    //   18: invokevirtual 274	java/io/File:exists	()Z
    //   21: ifne +42 -> 63
    //   24: new 154	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 717
    //   34: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 720	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore_2
    //   45: ldc 113
    //   47: aload_2
    //   48: invokestatic 172	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   51: istore_3
    //   52: aconst_null
    //   53: astore 4
    //   55: aload 4
    //   57: invokestatic 294	com/flurry/android/FlurryAgent:a	(Ljava/io/Closeable;)V
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: aload_0
    //   64: getfield 93	com/flurry/android/FlurryAgent:j	Ljava/io/File;
    //   67: astore 5
    //   69: new 722	java/io/FileOutputStream
    //   72: dup
    //   73: aload 5
    //   75: invokespecial 723	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   78: astore 6
    //   80: new 544	java/io/DataOutputStream
    //   83: dup
    //   84: aload 6
    //   86: invokespecial 547	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   89: astore 7
    //   91: ldc_w 288
    //   94: istore 8
    //   96: aload 7
    //   98: iload 8
    //   100: invokevirtual 554	java/io/DataOutputStream:writeShort	(I)V
    //   103: aload 7
    //   105: iconst_2
    //   106: invokevirtual 554	java/io/DataOutputStream:writeShort	(I)V
    //   109: aload_0
    //   110: getfield 148	com/flurry/android/FlurryAgent:o	Ljava/lang/String;
    //   113: astore 9
    //   115: aload 7
    //   117: aload 9
    //   119: invokevirtual 550	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   122: aload_0
    //   123: getfield 321	com/flurry/android/FlurryAgent:u	Ljava/lang/String;
    //   126: astore 10
    //   128: aload 7
    //   130: aload 10
    //   132: invokevirtual 550	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   135: aload_0
    //   136: getfield 301	com/flurry/android/FlurryAgent:v	Z
    //   139: istore 11
    //   141: aload 7
    //   143: iload 11
    //   145: invokevirtual 641	java/io/DataOutputStream:writeBoolean	(Z)V
    //   148: aload_0
    //   149: getfield 303	com/flurry/android/FlurryAgent:w	J
    //   152: lstore 12
    //   154: aload 7
    //   156: lload 12
    //   158: invokevirtual 637	java/io/DataOutputStream:writeLong	(J)V
    //   161: aload_0
    //   162: getfield 109	com/flurry/android/FlurryAgent:x	Ljava/util/List;
    //   165: invokeinterface 347 1 0
    //   170: iconst_1
    //   171: isub
    //   172: istore 14
    //   174: iload 14
    //   176: iflt +72 -> 248
    //   179: aload_0
    //   180: getfield 109	com/flurry/android/FlurryAgent:x	Ljava/util/List;
    //   183: iload 14
    //   185: invokeinterface 699 2 0
    //   190: checkcast 671	[B
    //   193: astore 8
    //   195: aload 8
    //   197: arraylength
    //   198: istore 15
    //   200: iload 15
    //   202: iconst_2
    //   203: iadd
    //   204: istore 16
    //   206: aload 7
    //   208: invokevirtual 724	java/io/DataOutputStream:size	()I
    //   211: istore 17
    //   213: iload 16
    //   215: iload 17
    //   217: iadd
    //   218: ldc_w 725
    //   221: if_icmpgt +27 -> 248
    //   224: aload 7
    //   226: iload 15
    //   228: invokevirtual 554	java/io/DataOutputStream:writeShort	(I)V
    //   231: aload 7
    //   233: aload 8
    //   235: invokevirtual 674	java/io/DataOutputStream:write	([B)V
    //   238: iload 14
    //   240: bipush 255
    //   242: iadd
    //   243: istore 18
    //   245: goto -71 -> 174
    //   248: aload 7
    //   250: iconst_0
    //   251: invokevirtual 554	java/io/DataOutputStream:writeShort	(I)V
    //   254: aload 7
    //   256: invokestatic 294	com/flurry/android/FlurryAgent:a	(Ljava/io/Closeable;)V
    //   259: goto -199 -> 60
    //   262: astore 19
    //   264: aload_0
    //   265: monitorexit
    //   266: aload 19
    //   268: athrow
    //   269: astore 4
    //   271: aconst_null
    //   272: astore 7
    //   274: ldc 113
    //   276: ldc 133
    //   278: aload 4
    //   280: invokestatic 333	com/flurry/android/Flog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   283: istore 20
    //   285: aload 7
    //   287: invokestatic 294	com/flurry/android/FlurryAgent:a	(Ljava/io/Closeable;)V
    //   290: goto -230 -> 60
    //   293: astore 4
    //   295: aconst_null
    //   296: astore 7
    //   298: aload 7
    //   300: invokestatic 294	com/flurry/android/FlurryAgent:a	(Ljava/io/Closeable;)V
    //   303: aload 4
    //   305: athrow
    //   306: astore 4
    //   308: goto -10 -> 298
    //   311: astore 4
    //   313: goto -39 -> 274
    //
    // Exception table:
    //   from	to	target	type
    //   55	60	262	finally
    //   254	259	262	finally
    //   285	306	262	finally
    //   2	52	269	java/lang/Throwable
    //   63	91	269	java/lang/Throwable
    //   2	52	293	finally
    //   63	91	293	finally
    //   96	254	306	finally
    //   274	285	306	finally
    //   96	254	311	java/lang/Throwable
  }

  public static boolean getForbidPlaintextFallback()
  {
    return false;
  }

  public static void onEndSession(Context paramContext)
  {
    if (paramContext == null)
      throw new NullPointerException("Null context");
    try
    {
      b.b(paramContext, 0);
      return;
    }
    catch (Throwable localThrowable)
    {
      int i1 = Flog.b("FlurryAgent", "", localThrowable);
    }
  }

  public static void onError(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      b.a(paramString1, paramString2, paramString3);
      return;
    }
    catch (Throwable localThrowable)
    {
      int i1 = Flog.b("FlurryAgent", "", localThrowable);
    }
  }

  public static void onEvent(String paramString)
  {
    try
    {
      b.a(paramString, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      int i1 = Flog.b("FlurryAgent", "", localThrowable);
    }
  }

  public static void onEvent(String paramString, Map paramMap)
  {
    try
    {
      b.a(paramString, paramMap);
      return;
    }
    catch (Throwable localThrowable)
    {
      int i1 = Flog.b("FlurryAgent", "", localThrowable);
    }
  }

  public static void onPageView()
  {
    try
    {
      b.d();
      return;
    }
    catch (Throwable localThrowable)
    {
      int i1 = Flog.b("FlurryAgent", "", localThrowable);
    }
  }

  public static void onStartSession(Context paramContext, String paramString)
  {
    if (paramContext == null)
      throw new NullPointerException("Null context");
    if ((paramString == null) || (paramString.length() == 0))
      throw new IllegalArgumentException("Api key not specified");
    try
    {
      b.a(paramContext, paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      int i1 = Flog.b("FlurryAgent", "", localThrowable);
    }
  }

  public static void setCaptureUncaughtExceptions(boolean paramBoolean)
  {
    synchronized (b)
    {
      if (b.k)
      {
        int i1 = Flog.b("FlurryAgent", "Cannot setCaptureUncaughtExceptions after onSessionStart");
        return;
      }
      g = paramBoolean;
      return;
    }
  }

  public static void setContinueSessionMillis(long paramLong)
  {
    synchronized (b)
    {
      c = paramLong;
      return;
    }
  }

  public static void setLocationCriteria(Criteria paramCriteria)
  {
    synchronized (b)
    {
      h = paramCriteria;
      return;
    }
  }

  public static void setLocationFixTimeoutMillis(long paramLong)
  {
    synchronized (b)
    {
      d = paramLong;
      return;
    }
  }

  public static void setLogEnabled(boolean paramBoolean)
  {
    FlurryAgent localFlurryAgent = b;
    monitorenter;
    if (paramBoolean);
    try
    {
      Flog.enableLog();
      return;
      Flog.disableLog();
    }
    finally
    {
      monitorexit;
    }
  }

  public static void setLogEvents(boolean paramBoolean)
  {
    synchronized (b)
    {
      e = paramBoolean;
      return;
    }
  }

  public static void setReportLocation(boolean paramBoolean)
  {
    synchronized (b)
    {
      b.r = 0;
      return;
    }
  }

  public static void setReportUrl(String paramString)
  {
    a = paramString;
  }

  public static void setUserId(String paramString)
  {
    synchronized (b)
    {
      FlurryAgent localFlurryAgent2 = b;
      String str = a(paramString);
      localFlurryAgent2.B = str;
      return;
    }
  }

  public static void setVersionName(String paramString)
  {
    synchronized (b)
    {
      b.q = paramString;
      return;
    }
  }

  /** @deprecated */
  final void a()
  {
    monitorenter;
    try
    {
      if (this.t != null)
        this.t.removeUpdates(this);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  final void a(Context paramContext)
  {
    try
    {
      monitorenter;
      try
      {
        if (!this.k)
        {
          long l1 = SystemClock.elapsedRealtime();
          long l2 = this.m;
          long l3 = l1 - l2;
          long l4 = c;
          if ((l3 <= l4) || (this.x.size() <= 0));
        }
        for (int i1 = 1; ; i1 = 0)
        {
          monitorexit;
          if (i1 == 0)
            return;
          f();
          return;
        }
      }
      finally
      {
        monitorexit;
      }
    }
    catch (Throwable localThrowable)
    {
      int i2 = Flog.b("FlurryAgent", "", localThrowable);
    }
  }

  final void a(Context paramContext, boolean paramBoolean)
  {
    Location localLocation = null;
    if (paramBoolean);
    try
    {
      localLocation = c(paramContext);
      monitorenter;
      try
      {
        this.D = localLocation;
        if ((!this.v) || (this.x.size() > 0));
        for (localLocation = null; ; localLocation = null)
        {
          monitorexit;
          if (localLocation == null)
            return;
          f();
          return;
        }
      }
      finally
      {
        monitorexit;
      }
    }
    catch (Throwable localThrowable)
    {
      int i1 = Flog.b("FlurryAgent", "", localThrowable);
    }
  }

  final void a(Throwable paramThrowable)
  {
    String str1 = paramThrowable.getMessage();
    String str2 = paramThrowable.getClass().toString();
    onError("uncaught", str1, str2);
    this.n.clear();
    b(null, 1);
  }

  /** @deprecated */
  public void onLocationChanged(Location paramLocation)
  {
    monitorenter;
    try
    {
      this.D = paramLocation;
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        int i1 = Flog.b("FlurryAgent", "", localThrowable);
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void onProviderDisabled(String paramString)
  {
  }

  public void onProviderEnabled(String paramString)
  {
  }

  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.flurry.android.FlurryAgent
 * JD-Core Version:    0.6.0
 */