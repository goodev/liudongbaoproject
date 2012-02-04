import android.text.TextUtils;
import com.mymoney.core.application.ApplicationContext;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.core.vo.CorporationVo;
import com.mymoney.core.vo.ProjectVo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class v
  implements k
{
  public static String a = "SettingServiceImpl";
  private al b;
  private ac c;
  private ag d;
  private af e;
  private ak f;

  public v()
  {
    al localal = ai.a().h();
    this.b = localal;
    ac localac = ai.a().c();
    this.c = localac;
    ag localag = ai.a().e();
    this.d = localag;
    af localaf = ai.a().d();
    this.e = localaf;
    ak localak = ai.a().i();
    this.f = localak;
  }

  public String a()
  {
    String str = m().g();
    if (TextUtils.isEmpty(str))
      str = "CNY";
    return str;
  }

  public boolean a(int paramInt)
  {
    ex localex = m();
    localex.a(paramInt);
    boolean bool = this.b.a(localex);
    if (bool)
      eb.a().a("com.mymoney.monthWeekStartChange");
    return bool;
  }

  public boolean a(long paramLong)
  {
    ex localex = m();
    localex.f(paramLong);
    return this.b.a(localex);
  }

  public boolean a(String paramString)
  {
    ex localex = m();
    localex.a(paramString);
    long l = gt.f();
    localex.g(l);
    boolean bool = this.b.a(localex);
    ApplicationContext.g = paramString;
    eb localeb = eb.a();
    String str = ea.r;
    localeb.a(str);
    return bool;
  }

  public boolean a(String paramString1, String paramString2)
  {
    ex localex = m();
    localex.b(paramString1);
    localex.c(paramString2);
    return this.b.a(localex);
  }

  public CategoryVo b()
  {
    return c(0);
  }

  public void b(String paramString)
  {
    try
    {
      he.a("update t_profile set syncRedirectIP = '" + paramString + "'", 0);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }

  public boolean b(int paramInt)
  {
    ex localex = m();
    localex.b(paramInt);
    boolean bool = this.b.a(localex);
    if (bool)
      eb.a().a("com.mymoney.monthWeekStartChange");
    return bool;
  }

  public boolean b(long paramLong)
  {
    ex localex = m();
    localex.b(paramLong);
    return this.b.a(localex);
  }

  public CategoryVo c()
  {
    return c(1);
  }

  public CategoryVo c(int paramInt)
  {
    h localh = g.a().d();
    Object localObject = m();
    long l1;
    et localet1;
    List localList;
    if (paramInt == 0)
    {
      l1 = ((ex)localObject).e();
      localet1 = this.e.c(l1);
      if (localet1 != null)
        break label273;
      localList = null;
      if (paramInt != 0)
        break label226;
      localList = this.e.a();
      label58: Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        et localet2 = (et)localIterator.next();
        af localaf = this.e;
        long l2 = localet2.b();
        localList = localaf.b(l2);
        if (localList.size() <= 0)
          continue;
        long l3 = ((et)localList.get(0)).b();
      }
      if (paramInt != 0)
        break label245;
      boolean bool1 = c(l1);
      label151: if (this.e.c(l1) != null)
        break label261;
      et localet3 = et.a();
      CategoryVo localCategoryVo = new CategoryVo();
      long l4 = localet3.b();
      localCategoryVo.a(l4);
      String str = localet3.c();
      localCategoryVo.a(str);
      localObject = localCategoryVo;
    }
    while (true)
    {
      return localObject;
      if (1 != paramInt)
        break;
      long l5 = ((ex)localObject).c();
      break;
      label226: if (1 != paramInt)
        break label58;
      localList = this.e.b();
      break label58;
      label245: if (1 != paramInt)
        break label151;
      boolean bool2 = d(l1);
      break label151;
      label261: localObject = localh.d(l1);
      continue;
      label273: long l6 = localet1.b();
      localObject = localh.d(l6);
    }
  }

  public boolean c(long paramLong)
  {
    ex localex = m();
    localex.e(paramLong);
    return this.b.a(localex);
  }

  // ERROR //
  public boolean c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 131	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   9: astore_3
    //   10: getstatic 236	el:a	Ljava/lang/String;
    //   13: astore 4
    //   15: aload_3
    //   16: aload 4
    //   18: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: astore 5
    //   23: getstatic 241	java/io/File:separator	Ljava/lang/String;
    //   26: astore 6
    //   28: aload 5
    //   30: aload 6
    //   32: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 243
    //   37: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: astore 7
    //   42: getstatic 241	java/io/File:separator	Ljava/lang/String;
    //   45: astore 8
    //   47: aload 7
    //   49: aload 8
    //   51: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore 9
    //   59: new 238	java/io/File
    //   62: dup
    //   63: aload 9
    //   65: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 10
    //   70: aload 10
    //   72: invokevirtual 248	java/io/File:mkdirs	()Z
    //   75: istore 11
    //   77: getstatic 251	com/mymoney/core/application/ApplicationContext:b	Ldh;
    //   80: invokevirtual 256	dh:close	()V
    //   83: invokestatic 259	dh:c	()Ljava/io/File;
    //   86: astore 12
    //   88: new 131	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   95: aload 10
    //   97: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: astore 13
    //   102: getstatic 241	java/io/File:separator	Ljava/lang/String;
    //   105: astore 14
    //   107: aload 13
    //   109: aload 14
    //   111: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: astore 15
    //   116: getstatic 263	dh:a	Ljava/lang/String;
    //   119: astore 16
    //   121: aload 15
    //   123: aload 16
    //   125: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: astore 17
    //   133: new 238	java/io/File
    //   136: dup
    //   137: aload 17
    //   139: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore 18
    //   144: aload 12
    //   146: aload 18
    //   148: invokestatic 268	gl:a	(Ljava/io/File;Ljava/io/File;)V
    //   151: invokestatic 272	gu:a	()Ljava/io/File;
    //   154: astore 19
    //   156: new 131	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   163: aload 10
    //   165: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: astore 20
    //   170: getstatic 241	java/io/File:separator	Ljava/lang/String;
    //   173: astore 21
    //   175: aload 20
    //   177: aload 21
    //   179: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: astore 22
    //   184: getstatic 274	gu:c	Ljava/lang/String;
    //   187: astore 23
    //   189: aload 22
    //   191: aload 23
    //   193: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: astore 24
    //   201: new 238	java/io/File
    //   204: dup
    //   205: aload 24
    //   207: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   210: astore 25
    //   212: aload 19
    //   214: aload 25
    //   216: invokestatic 268	gl:a	(Ljava/io/File;Ljava/io/File;)V
    //   219: getstatic 278	eo:b	Ljava/lang/String;
    //   222: astore 26
    //   224: new 238	java/io/File
    //   227: dup
    //   228: aload 26
    //   230: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   233: astore 27
    //   235: new 131	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   242: aload 9
    //   244: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: astore 28
    //   249: getstatic 279	eo:c	Ljava/lang/String;
    //   252: astore 29
    //   254: aload 28
    //   256: aload 29
    //   258: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: astore 30
    //   266: new 238	java/io/File
    //   269: dup
    //   270: aload 30
    //   272: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   275: astore 31
    //   277: aload 27
    //   279: aload 31
    //   281: invokestatic 282	wa:a	(Ljava/io/File;Ljava/io/File;)V
    //   284: iconst_1
    //   285: ifne +39 -> 324
    //   288: iconst_0
    //   289: istore_2
    //   290: iload_2
    //   291: ireturn
    //   292: astore 32
    //   294: aload 32
    //   296: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   299: goto -15 -> 284
    //   302: astore 33
    //   304: getstatic 24	v:a	Ljava/lang/String;
    //   307: ldc_w 285
    //   310: invokestatic 290	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: aload 33
    //   315: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   318: iconst_0
    //   319: istore 34
    //   321: goto -37 -> 284
    //   324: aload_1
    //   325: invokestatic 293	el:b	(Ljava/lang/String;)Ljava/io/File;
    //   328: astore 35
    //   330: new 131	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   337: astore 36
    //   339: getstatic 236	el:a	Ljava/lang/String;
    //   342: astore 37
    //   344: aload 36
    //   346: aload 37
    //   348: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: astore 38
    //   353: getstatic 241	java/io/File:separator	Ljava/lang/String;
    //   356: astore 39
    //   358: aload 38
    //   360: aload 39
    //   362: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_1
    //   366: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: astore 40
    //   371: getstatic 241	java/io/File:separator	Ljava/lang/String;
    //   374: astore 41
    //   376: aload 40
    //   378: aload 41
    //   380: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: astore 42
    //   388: new 238	java/io/File
    //   391: dup
    //   392: aload 42
    //   394: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   397: astore 43
    //   399: new 295	hd
    //   402: dup
    //   403: invokespecial 296	hd:<init>	()V
    //   406: aload 35
    //   408: invokevirtual 299	hd:a	(Ljava/io/File;)V
    //   411: getstatic 278	eo:b	Ljava/lang/String;
    //   414: astore 44
    //   416: new 238	java/io/File
    //   419: dup
    //   420: aload 44
    //   422: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   425: astore 35
    //   427: aload 35
    //   429: invokestatic 300	wa:a	(Ljava/io/File;)V
    //   432: aload 35
    //   434: invokevirtual 248	java/io/File:mkdirs	()Z
    //   437: istore 45
    //   439: aload_0
    //   440: getfield 59	v:f	Lak;
    //   443: invokeinterface 304 1 0
    //   448: istore 46
    //   450: aload 43
    //   452: invokevirtual 308	java/io/File:listFiles	()[Ljava/io/File;
    //   455: astore 47
    //   457: aload 47
    //   459: arraylength
    //   460: istore 48
    //   462: iconst_0
    //   463: istore 49
    //   465: iload 49
    //   467: iload 48
    //   469: if_icmpge +703 -> 1172
    //   472: aload 47
    //   474: iload 49
    //   476: aaload
    //   477: astore 50
    //   479: aload 50
    //   481: invokevirtual 311	java/io/File:isDirectory	()Z
    //   484: ifeq +41 -> 525
    //   487: getstatic 279	eo:c	Ljava/lang/String;
    //   490: astore 51
    //   492: aload 50
    //   494: invokevirtual 314	java/io/File:getName	()Ljava/lang/String;
    //   497: astore 52
    //   499: aload 51
    //   501: aload 52
    //   503: invokevirtual 319	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   506: ifeq +19 -> 525
    //   509: aload 50
    //   511: aload 35
    //   513: invokestatic 282	wa:a	(Ljava/io/File;Ljava/io/File;)V
    //   516: iload 49
    //   518: iconst_1
    //   519: iadd
    //   520: istore 49
    //   522: goto -57 -> 465
    //   525: getstatic 263	dh:a	Ljava/lang/String;
    //   528: astore 53
    //   530: aload 50
    //   532: invokevirtual 314	java/io/File:getName	()Ljava/lang/String;
    //   535: astore 54
    //   537: aload 53
    //   539: aload 54
    //   541: invokevirtual 319	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   544: ifeq +379 -> 923
    //   547: invokestatic 259	dh:c	()Ljava/io/File;
    //   550: astore 55
    //   552: aload 50
    //   554: aload 55
    //   556: invokestatic 268	gl:a	(Ljava/io/File;Ljava/io/File;)V
    //   559: goto -43 -> 516
    //   562: astore 56
    //   564: aload 56
    //   566: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   569: getstatic 24	v:a	Ljava/lang/String;
    //   572: ldc_w 321
    //   575: invokestatic 290	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: new 131	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   585: aload 10
    //   587: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   590: astore 57
    //   592: getstatic 241	java/io/File:separator	Ljava/lang/String;
    //   595: astore 58
    //   597: aload 57
    //   599: aload 58
    //   601: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: astore 59
    //   606: getstatic 263	dh:a	Ljava/lang/String;
    //   609: astore 60
    //   611: aload 59
    //   613: aload 60
    //   615: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: astore 61
    //   623: new 238	java/io/File
    //   626: dup
    //   627: aload 61
    //   629: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   632: astore 62
    //   634: invokestatic 259	dh:c	()Ljava/io/File;
    //   637: astore 63
    //   639: aload 62
    //   641: aload 63
    //   643: invokestatic 268	gl:a	(Ljava/io/File;Ljava/io/File;)V
    //   646: new 131	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   653: aload 10
    //   655: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   658: astore 64
    //   660: getstatic 241	java/io/File:separator	Ljava/lang/String;
    //   663: astore 65
    //   665: aload 64
    //   667: aload 65
    //   669: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: astore 66
    //   674: getstatic 274	gu:c	Ljava/lang/String;
    //   677: astore 67
    //   679: aload 66
    //   681: aload 67
    //   683: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: astore 68
    //   691: new 238	java/io/File
    //   694: dup
    //   695: aload 68
    //   697: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   700: astore 69
    //   702: invokestatic 272	gu:a	()Ljava/io/File;
    //   705: astore 70
    //   707: aload 69
    //   709: aload 70
    //   711: invokestatic 268	gl:a	(Ljava/io/File;Ljava/io/File;)V
    //   714: new 131	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   721: aload 9
    //   723: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: astore 71
    //   728: getstatic 279	eo:c	Ljava/lang/String;
    //   731: astore 72
    //   733: aload 71
    //   735: aload 72
    //   737: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: astore 73
    //   745: new 238	java/io/File
    //   748: dup
    //   749: aload 73
    //   751: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   754: astore 74
    //   756: getstatic 278	eo:b	Ljava/lang/String;
    //   759: astore 75
    //   761: new 238	java/io/File
    //   764: dup
    //   765: aload 75
    //   767: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   770: astore 76
    //   772: aload 74
    //   774: aload 76
    //   776: invokestatic 282	wa:a	(Ljava/io/File;Ljava/io/File;)V
    //   779: aload 10
    //   781: invokestatic 300	wa:a	(Ljava/io/File;)V
    //   784: iconst_0
    //   785: istore_2
    //   786: aload 10
    //   788: invokestatic 300	wa:a	(Ljava/io/File;)V
    //   791: getstatic 24	v:a	Ljava/lang/String;
    //   794: ldc_w 323
    //   797: invokestatic 290	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   800: ldc 144
    //   802: invokestatic 326	gu:d	(Z)V
    //   805: invokestatic 160	g:a	()Lg;
    //   808: invokevirtual 329	g:f	()Ln;
    //   811: invokeinterface 334 1 0
    //   816: invokevirtual 338	hp:a	()J
    //   819: putstatic 341	com/mymoney/core/application/ApplicationContext:d	J
    //   822: getstatic 24	v:a	Ljava/lang/String;
    //   825: ldc_w 343
    //   828: invokestatic 290	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   831: invokestatic 32	ai:a	()Lai;
    //   834: invokevirtual 57	ai:i	()Lak;
    //   837: invokeinterface 345 1 0
    //   842: getstatic 24	v:a	Ljava/lang/String;
    //   845: ldc_w 347
    //   848: invokestatic 290	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   851: new 131	java/lang/StringBuilder
    //   854: dup
    //   855: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   858: ldc_w 349
    //   861: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: ldc_w 351
    //   867: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: ldc 140
    //   872: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: astore 77
    //   880: getstatic 251	com/mymoney/core/application/ApplicationContext:b	Ldh;
    //   883: invokevirtual 354	dh:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   886: aload 77
    //   888: invokevirtual 359	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   891: aload_0
    //   892: invokevirtual 361	v:a	()Ljava/lang/String;
    //   895: putstatic 113	com/mymoney/core/application/ApplicationContext:g	Ljava/lang/String;
    //   898: ldc 144
    //   900: invokestatic 363	gu:h	(Z)V
    //   903: invokestatic 91	eb:a	()Leb;
    //   906: astore 78
    //   908: getstatic 366	ea:u	Ljava/lang/String;
    //   911: astore 79
    //   913: aload 78
    //   915: aload 79
    //   917: invokevirtual 96	eb:a	(Ljava/lang/String;)V
    //   920: goto -630 -> 290
    //   923: getstatic 274	gu:c	Ljava/lang/String;
    //   926: astore 80
    //   928: aload 50
    //   930: invokevirtual 314	java/io/File:getName	()Ljava/lang/String;
    //   933: astore 81
    //   935: aload 80
    //   937: aload 81
    //   939: invokevirtual 319	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   942: istore 82
    //   944: iload 82
    //   946: ifeq -430 -> 516
    //   949: invokestatic 272	gu:a	()Ljava/io/File;
    //   952: astore 83
    //   954: aload 50
    //   956: aload 83
    //   958: invokestatic 268	gl:a	(Ljava/io/File;Ljava/io/File;)V
    //   961: goto -445 -> 516
    //   964: astore 50
    //   966: aload 50
    //   968: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   971: new 131	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   978: ldc_w 368
    //   981: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: astore 84
    //   986: getstatic 371	ep:a	Ljava/lang/String;
    //   989: astore 85
    //   991: aload 84
    //   993: aload 85
    //   995: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: ldc_w 373
    //   1001: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: astore 86
    //   1006: aload 50
    //   1008: invokevirtual 377	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   1011: astore 87
    //   1013: aload 86
    //   1015: aload 87
    //   1017: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1020: ldc_w 379
    //   1023: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: astore 88
    //   1028: aload 50
    //   1030: invokevirtual 382	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1033: astore 89
    //   1035: aload 88
    //   1037: aload 89
    //   1039: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: astore 90
    //   1047: getstatic 24	v:a	Ljava/lang/String;
    //   1050: astore 91
    //   1052: ldc_w 384
    //   1055: aload 90
    //   1057: aload 91
    //   1059: invokestatic 390	com/flurry/android/FlurryAgent:onError	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1062: getstatic 24	v:a	Ljava/lang/String;
    //   1065: astore 92
    //   1067: new 131	java/lang/StringBuilder
    //   1070: dup
    //   1071: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   1074: ldc_w 368
    //   1077: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: astore 93
    //   1082: getstatic 371	ep:a	Ljava/lang/String;
    //   1085: astore 94
    //   1087: aload 93
    //   1089: aload 94
    //   1091: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: ldc_w 373
    //   1097: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: astore 95
    //   1102: aload 50
    //   1104: invokevirtual 377	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   1107: astore 96
    //   1109: aload 95
    //   1111: aload 96
    //   1113: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1116: ldc_w 379
    //   1119: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: astore 97
    //   1124: aload 50
    //   1126: invokevirtual 382	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1129: astore 98
    //   1131: aload 97
    //   1133: aload 98
    //   1135: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1141: astore 99
    //   1143: aload 92
    //   1145: aload 99
    //   1147: invokestatic 290	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1150: goto -634 -> 516
    //   1153: astore 100
    //   1155: aload 10
    //   1157: invokestatic 300	wa:a	(Ljava/io/File;)V
    //   1160: getstatic 24	v:a	Ljava/lang/String;
    //   1163: ldc_w 323
    //   1166: invokestatic 290	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1169: aload 100
    //   1171: athrow
    //   1172: aload 43
    //   1174: invokestatic 300	wa:a	(Ljava/io/File;)V
    //   1177: aload 10
    //   1179: invokestatic 300	wa:a	(Ljava/io/File;)V
    //   1182: getstatic 24	v:a	Ljava/lang/String;
    //   1185: ldc_w 323
    //   1188: invokestatic 290	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1191: goto -391 -> 800
    //   1194: astore 101
    //   1196: getstatic 24	v:a	Ljava/lang/String;
    //   1199: ldc_w 392
    //   1202: invokestatic 290	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1205: aload 101
    //   1207: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   1210: goto -410 -> 800
    //   1213: astore 56
    //   1215: aload 56
    //   1217: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   1220: goto -441 -> 779
    //   1223: astore_2
    //   1224: getstatic 24	v:a	Ljava/lang/String;
    //   1227: ldc_w 394
    //   1230: invokestatic 290	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1233: aload_2
    //   1234: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   1237: iconst_0
    //   1238: istore_2
    //   1239: goto -453 -> 786
    //   1242: astore 102
    //   1244: getstatic 24	v:a	Ljava/lang/String;
    //   1247: ldc_w 392
    //   1250: invokestatic 290	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1253: aload 102
    //   1255: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   1258: goto -458 -> 800
    //   1261: astore 103
    //   1263: getstatic 24	v:a	Ljava/lang/String;
    //   1266: ldc_w 392
    //   1269: invokestatic 290	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1272: aload 103
    //   1274: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   1277: goto -108 -> 1169
    //   1280: invokevirtual 395	ec:printStackTrace	()V
    //   1283: goto -441 -> 842
    //
    // Exception table:
    //   from	to	target	type
    //   151	284	292	java/lang/Exception
    //   77	151	302	java/lang/Exception
    //   294	299	302	java/lang/Exception
    //   399	559	562	java/lang/Exception
    //   923	944	562	java/lang/Exception
    //   966	1150	562	java/lang/Exception
    //   1172	1177	562	java/lang/Exception
    //   949	961	964	java/lang/Exception
    //   399	559	1153	finally
    //   564	578	1153	finally
    //   578	714	1153	finally
    //   714	779	1153	finally
    //   779	784	1153	finally
    //   923	944	1153	finally
    //   949	961	1153	finally
    //   966	1150	1153	finally
    //   1172	1177	1153	finally
    //   1215	1220	1153	finally
    //   1224	1237	1153	finally
    //   1177	1191	1194	java/lang/Exception
    //   714	779	1213	java/lang/Exception
    //   578	714	1223	java/lang/Exception
    //   779	784	1223	java/lang/Exception
    //   1215	1220	1223	java/lang/Exception
    //   786	800	1242	java/lang/Exception
    //   1155	1169	1261	java/lang/Exception
    //   831	842	1280	ec
  }

  public ProjectVo d()
  {
    long l1 = m().d();
    fa localfa = y.a().a(l1);
    ProjectVo localProjectVo = new ProjectVo();
    if (localfa != null)
    {
      long l2 = localfa.a();
      localProjectVo.a(l2);
      String str = localfa.b();
      localProjectVo.a(str);
      int i = localfa.d();
      localProjectVo.a(i);
    }
    while (true)
    {
      return localProjectVo;
      localProjectVo.a(0L);
      localProjectVo.a("无项目");
      localProjectVo.a(1);
    }
  }

  public boolean d(long paramLong)
  {
    ex localex = m();
    localex.c(paramLong);
    return this.b.a(localex);
  }

  public AccountVo e()
  {
    long l1 = m().f();
    eq localeq1 = this.c.a(l1);
    if (localeq1 == null)
    {
      List localList = this.c.a(1);
      if (localList.size() > 0)
        l1 = ((eq)localList.get(0)).f();
      boolean bool = a(l1);
      localeq2 = this.c.a(l1);
      if (localeq2 != null);
    }
    for (eq localeq2 = eq.a(); ; localeq2 = localeq1)
    {
      AccountVo localAccountVo = new AccountVo();
      long l2 = localeq2.f();
      localAccountVo.a(l2);
      String str1 = localeq2.g();
      localAccountVo.a(str1);
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str2 = localeq2.g();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append("(");
      String str3 = localeq2.h();
      String str4 = str3 + ")";
      localAccountVo.d(str4);
      return localAccountVo;
    }
  }

  public boolean e(long paramLong)
  {
    ex localex = m();
    localex.d(paramLong);
    return this.b.a(localex);
  }

  public CorporationVo f()
  {
    long l1 = m().b();
    eu localeu = this.d.a(l1);
    if (localeu == null)
      localeu = eu.a();
    CorporationVo localCorporationVo = new CorporationVo();
    long l2 = localeu.b();
    localCorporationVo.a(l2);
    String str = localeu.c();
    localCorporationVo.a(str);
    return localCorporationVo;
  }

  public hn g()
  {
    hn localhn = new hn();
    ex localex = m();
    String str1 = localex.h();
    localhn.a(str1);
    String str2 = localex.i();
    localhn.b(str2);
    return localhn;
  }

  public void h()
  {
    this.f.b();
  }

  public void i()
  {
    boolean bool = this.f.a();
    try
    {
      String str1 = eo.b;
      wa.a(new File(str1));
      ApplicationContext.d = g.a().f().a().a();
      gj.a(a, "start upgradeDatabase...");
      this.f.b();
      gj.a(a, "upgradeDatabase finished");
      ApplicationContext.g = a();
      gu.b();
      gu.d(1);
      gu.h(0);
      eb localeb = eb.a();
      String str2 = ea.t;
      localeb.a(str2);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  // ERROR //
  public boolean j()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: getstatic 236	el:a	Ljava/lang/String;
    //   5: astore_2
    //   6: new 238	java/io/File
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 499	java/io/File:exists	()Z
    //   19: ifne +9 -> 28
    //   22: aload_3
    //   23: invokevirtual 248	java/io/File:mkdirs	()Z
    //   26: istore 4
    //   28: getstatic 278	eo:b	Ljava/lang/String;
    //   31: astore 5
    //   33: new 238	java/io/File
    //   36: dup
    //   37: aload 5
    //   39: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 6
    //   44: aload 6
    //   46: invokevirtual 499	java/io/File:exists	()Z
    //   49: ifne +10 -> 59
    //   52: aload 6
    //   54: invokevirtual 248	java/io/File:mkdirs	()Z
    //   57: istore 7
    //   59: invokestatic 500	el:a	()Ljava/lang/String;
    //   62: astore 8
    //   64: new 131	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   71: astore 9
    //   73: getstatic 236	el:a	Ljava/lang/String;
    //   76: astore 10
    //   78: aload 9
    //   80: aload 10
    //   82: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload 8
    //   87: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: astore 11
    //   92: getstatic 241	java/io/File:separator	Ljava/lang/String;
    //   95: astore 12
    //   97: aload 11
    //   99: aload 12
    //   101: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore 13
    //   109: new 238	java/io/File
    //   112: dup
    //   113: aload 13
    //   115: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore 14
    //   120: aload 14
    //   122: invokevirtual 248	java/io/File:mkdirs	()Z
    //   125: istore 15
    //   127: getstatic 251	com/mymoney/core/application/ApplicationContext:b	Ldh;
    //   130: invokevirtual 256	dh:close	()V
    //   133: invokestatic 259	dh:c	()Ljava/io/File;
    //   136: astore 16
    //   138: new 131	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   145: aload 14
    //   147: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   150: astore 17
    //   152: getstatic 241	java/io/File:separator	Ljava/lang/String;
    //   155: astore 18
    //   157: aload 17
    //   159: aload 18
    //   161: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: astore 19
    //   166: getstatic 263	dh:a	Ljava/lang/String;
    //   169: astore 20
    //   171: aload 19
    //   173: aload 20
    //   175: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: astore 21
    //   183: new 238	java/io/File
    //   186: dup
    //   187: aload 21
    //   189: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   192: astore 22
    //   194: aload 16
    //   196: aload 22
    //   198: invokestatic 268	gl:a	(Ljava/io/File;Ljava/io/File;)V
    //   201: invokestatic 272	gu:a	()Ljava/io/File;
    //   204: astore 23
    //   206: new 131	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   213: aload 14
    //   215: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: astore 24
    //   220: getstatic 241	java/io/File:separator	Ljava/lang/String;
    //   223: astore 25
    //   225: aload 24
    //   227: aload 25
    //   229: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: astore 26
    //   234: getstatic 274	gu:c	Ljava/lang/String;
    //   237: astore 27
    //   239: aload 26
    //   241: aload 27
    //   243: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: astore 28
    //   251: new 238	java/io/File
    //   254: dup
    //   255: aload 28
    //   257: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   260: astore 29
    //   262: aload 23
    //   264: aload 29
    //   266: invokestatic 268	gl:a	(Ljava/io/File;Ljava/io/File;)V
    //   269: getstatic 278	eo:b	Ljava/lang/String;
    //   272: astore 30
    //   274: new 238	java/io/File
    //   277: dup
    //   278: aload 30
    //   280: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   283: astore 31
    //   285: new 131	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   292: aload 13
    //   294: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: astore 32
    //   299: getstatic 279	eo:c	Ljava/lang/String;
    //   302: astore 33
    //   304: aload 32
    //   306: aload 33
    //   308: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: astore 34
    //   316: new 238	java/io/File
    //   319: dup
    //   320: aload 34
    //   322: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   325: astore 35
    //   327: aload 31
    //   329: aload 35
    //   331: invokestatic 282	wa:a	(Ljava/io/File;Ljava/io/File;)V
    //   334: new 295	hd
    //   337: dup
    //   338: invokespecial 296	hd:<init>	()V
    //   341: astore 36
    //   343: getstatic 501	el:b	Ljava/lang/String;
    //   346: astore 37
    //   348: aload 36
    //   350: aload 13
    //   352: aload 37
    //   354: invokevirtual 502	hd:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 14
    //   359: invokestatic 300	wa:a	(Ljava/io/File;)V
    //   362: iload_1
    //   363: ireturn
    //   364: astore 38
    //   366: aload 38
    //   368: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   371: new 131	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   378: ldc_w 368
    //   381: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: astore 39
    //   386: getstatic 371	ep:a	Ljava/lang/String;
    //   389: astore 40
    //   391: aload 39
    //   393: aload 40
    //   395: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: ldc_w 373
    //   401: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: astore 41
    //   406: aload 38
    //   408: invokevirtual 377	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   411: astore 42
    //   413: aload 41
    //   415: aload 42
    //   417: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   420: ldc_w 379
    //   423: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: astore 43
    //   428: aload 38
    //   430: invokevirtual 382	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   433: astore 44
    //   435: aload 43
    //   437: aload 44
    //   439: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: astore 45
    //   447: getstatic 24	v:a	Ljava/lang/String;
    //   450: astore 46
    //   452: ldc_w 504
    //   455: aload 45
    //   457: aload 46
    //   459: invokestatic 390	com/flurry/android/FlurryAgent:onError	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   462: getstatic 24	v:a	Ljava/lang/String;
    //   465: astore 47
    //   467: new 131	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   474: ldc_w 368
    //   477: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: astore 48
    //   482: getstatic 371	ep:a	Ljava/lang/String;
    //   485: astore 49
    //   487: aload 48
    //   489: aload 49
    //   491: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: ldc_w 373
    //   497: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: astore 50
    //   502: aload 38
    //   504: invokevirtual 377	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   507: astore 51
    //   509: aload 50
    //   511: aload 51
    //   513: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   516: ldc_w 379
    //   519: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: astore 52
    //   524: aload 38
    //   526: invokevirtual 382	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   529: astore 53
    //   531: aload 52
    //   533: aload 53
    //   535: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: astore 54
    //   543: aload 47
    //   545: aload 54
    //   547: invokestatic 290	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: goto -281 -> 269
    //   553: invokevirtual 495	java/io/IOException:printStackTrace	()V
    //   556: iconst_0
    //   557: istore_1
    //   558: goto -196 -> 362
    //   561: astore 55
    //   563: aload 55
    //   565: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   568: new 131	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   575: ldc_w 368
    //   578: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: astore 56
    //   583: getstatic 371	ep:a	Ljava/lang/String;
    //   586: astore 57
    //   588: aload 56
    //   590: aload 57
    //   592: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: ldc_w 373
    //   598: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: astore 58
    //   603: aload 55
    //   605: invokevirtual 377	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   608: astore 59
    //   610: aload 58
    //   612: aload 59
    //   614: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   617: ldc_w 379
    //   620: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: astore 60
    //   625: aload 55
    //   627: invokevirtual 382	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   630: astore 61
    //   632: aload 60
    //   634: aload 61
    //   636: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: astore 62
    //   644: getstatic 24	v:a	Ljava/lang/String;
    //   647: astore 63
    //   649: ldc_w 506
    //   652: aload 62
    //   654: aload 63
    //   656: invokestatic 390	com/flurry/android/FlurryAgent:onError	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   659: getstatic 24	v:a	Ljava/lang/String;
    //   662: astore 64
    //   664: new 131	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   671: ldc_w 368
    //   674: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: astore 65
    //   679: getstatic 371	ep:a	Ljava/lang/String;
    //   682: astore 66
    //   684: aload 65
    //   686: aload 66
    //   688: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: ldc_w 373
    //   694: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: astore 67
    //   699: aload 55
    //   701: invokevirtual 377	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   704: astore 68
    //   706: aload 67
    //   708: aload 68
    //   710: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   713: ldc_w 379
    //   716: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: astore 69
    //   721: aload 55
    //   723: invokevirtual 382	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   726: astore 70
    //   728: aload 69
    //   730: aload 70
    //   732: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: astore 71
    //   740: aload 64
    //   742: aload 71
    //   744: invokestatic 290	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: goto -413 -> 334
    //   750: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   753: iconst_0
    //   754: istore_1
    //   755: goto -393 -> 362
    //
    // Exception table:
    //   from	to	target	type
    //   201	269	364	java/lang/Exception
    //   127	201	553	java/io/IOException
    //   201	269	553	java/io/IOException
    //   269	334	553	java/io/IOException
    //   334	550	553	java/io/IOException
    //   563	747	553	java/io/IOException
    //   269	334	561	java/lang/Exception
    //   127	201	750	java/lang/Exception
    //   334	550	750	java/lang/Exception
    //   563	747	750	java/lang/Exception
  }

  public String k()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("mymoney_data_");
    long l1 = gt.a();
    String str1 = gi.b(new Date(l1), "yyyyMMddHHmm");
    String str2 = str1 + ".csv";
    StringBuilder localStringBuilder2 = new StringBuilder();
    String str3 = ep.a;
    String str4 = str3 + "/" + str2;
    File localFile1 = new File(str4);
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile1);
    localFileOutputStream.write(65519);
    localFileOutputStream.write(65467);
    localFileOutputStream.write(65471);
    localFileOutputStream.flush();
    localFileOutputStream.close();
    StringBuilder localStringBuilder3 = new StringBuilder();
    String str5 = ep.a;
    String str6 = str5 + "/" + str2;
    File localFile2 = new File(str6);
    FileWriter localFileWriter = new FileWriter(localFile2, 1);
    String str7 = gu.d();
    String str8 = gt.e();
    StringBuilder localStringBuilder4 = new StringBuilder();
    StringBuilder localStringBuilder5 = localStringBuilder4.append("随手记导出文件(headers:v4; Android;");
    String str9 = str7 + ";";
    StringBuilder localStringBuilder6 = localStringBuilder4.append(str9);
    String str10 = str8 + ";";
    StringBuilder localStringBuilder7 = localStringBuilder4.append(str10);
    String str11 = gi.b(new Date(), "yyyyMMddHHmm");
    StringBuilder localStringBuilder8 = localStringBuilder4.append(str11);
    StringBuilder localStringBuilder9 = localStringBuilder4.append(")");
    String str12 = localStringBuilder4.toString();
    localFileWriter.write(str12);
    localFileWriter.write("\n");
    gf localgf1 = new gf(localFileWriter);
    localgf1.a("\n");
    localgf1.b("交易类型");
    localgf1.b("日期");
    localgf1.b("类别");
    localgf1.b("子类别");
    localgf1.b("项目");
    localgf1.b("账户");
    localgf1.b("账户币种");
    localgf1.b("金额");
    localgf1.b("商家");
    localgf1.b("备注");
    localgf1.b("关联Id");
    localgf1.a();
    String[] arrayOfString = new String[11];
    int i = 0;
    while (i < 11)
    {
      arrayOfString[i] = "0";
      i += 1;
    }
    Iterator localIterator = he.a("select     trans.type as type,     trans.tradeTime as tradeTime,     first.name as firstLevelCategoryName,     second.name as subcategoryName,     tag.name as projectName,     acc.name as accountName,     acc.currencyType as accountCurrencyType,     trans.sellerMoney as cost,     seller.name as sellerName,     trans.memo as memo,     trans.relation as relation     from t_transaction as trans      left JOIN t_category as second on second.categoryPOID =      ( case when trans.type  = 0 then trans.sellerCategoryPOID when trans.type  = 1 then trans.buyerCategoryPOID else trans.sellerCategoryPOID      end)     left JOIN t_category as first on first.categoryPOID = second.parentCategoryPOID        INNER JOIN t_account as acc on acc.accountPOID = (      case          when trans.type = 0 then trans.buyerAccountPOID       when trans.type = 1 then trans.sellerAccountPOID       when trans.type = 2 then trans.sellerAccountPOID       when trans.type = 3 then trans.buyerAccountPOID       when trans.type = 4 then trans.sellerAccountPOID       when trans.type = 5 then trans.buyerAccountPOID       when trans.type = 6 then trans.sellerAccountPOID       when trans.type = 7 then trans.buyerAccountPOID       when trans.type = 8 then trans.sellerAccountPOID       when trans.type = 9 then trans.sellerAccountPOID       when trans.type = 10 then trans.sellerAccountPOID      else trans.sellerAccountPOID      end )      left join t_tradingEntity as seller on trans.relationUnitPOID = seller.tradingEntityPOID and seller.belongTo = -3      left JOIN t_transaction_projectcategory_map as tpm on tpm.transactionPOID = trans.transactionPOID     left join t_tag as tag on tag.tagPOID = tpm.projectCategoryPOID and tag.tagType = 1    order by trans.tradeTime desc,trans.lastUpdateTime desc,trans.relation desc,trans.type asc", arrayOfString, null).iterator();
    while (localIterator.hasNext())
    {
      Map localMap1 = (Map)localIterator.next();
      Map localMap2 = localMap1;
      String str13 = "type";
      String str14 = (String)localMap2.get(str13);
      Map localMap3 = localMap1;
      String str15 = "tradetime";
      String str16 = (String)localMap3.get(str15);
      Map localMap4 = localMap1;
      String str17 = "firstlevelcategoryname";
      String str18 = (String)localMap4.get(str17);
      Map localMap5 = localMap1;
      String str19 = "subcategoryname";
      String str20 = (String)localMap5.get(str19);
      Map localMap6 = localMap1;
      String str21 = "projectname";
      String str22 = (String)localMap6.get(str21);
      Map localMap7 = localMap1;
      String str23 = "accountname";
      String str24 = (String)localMap7.get(str23);
      Map localMap8 = localMap1;
      String str25 = "accountcurrencytype";
      String str26 = (String)localMap8.get(str25);
      Map localMap9 = localMap1;
      String str27 = "cost";
      String str28 = (String)localMap9.get(str27);
      Map localMap10 = localMap1;
      String str29 = "sellername";
      String str30 = (String)localMap10.get(str29);
      Map localMap11 = localMap1;
      String str31 = "memo";
      String str32 = (String)localMap11.get(str31);
      Map localMap12 = localMap1;
      String str33 = "relation";
      String str34 = (String)localMap12.get(str33);
      String str35 = fb.a(Integer.parseInt(str14));
      long l2 = Long.parseLong(str16);
      String str36 = gi.b(new Date(l2), "yyyy-MM-dd");
      localgf1.b(str35);
      localgf1.b(str36);
      localgf1.b(str18);
      localgf1.b(str20);
      localgf1.b(str22);
      localgf1.b(str24);
      localgf1.b(str26);
      localgf1.b(str28);
      localgf1.b(str30);
      localgf1.b(str32);
      gf localgf2 = localgf1;
      String str37 = str34;
      localgf2.b(str37);
      localgf1.a();
    }
    localgf1.b();
    return str2;
  }

  public List l()
  {
    String str1 = el.a;
    File localFile = new File(str1);
    if (!localFile.exists())
      boolean bool1 = localFile.mkdirs();
    w localw = new w(this);
    List localList = (List)wa.a(localFile, localw, null);
    int i = localList.size();
    ArrayList localArrayList = new ArrayList(i);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      String str2 = ((File)localIterator.next()).getName();
      int j = str2.indexOf(".");
      String str3 = str2.substring(0, j);
      boolean bool2 = localArrayList.add(str3);
    }
    Comparator localComparator = Collections.reverseOrder();
    Collections.sort(localArrayList, localComparator);
    return localArrayList;
  }

  public ex m()
  {
    al localal = this.b;
    long l = ApplicationContext.d;
    return localal.a(l);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     v
 * JD-Core Version:    0.6.0
 */