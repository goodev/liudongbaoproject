import android.content.Context;
import com.mymoney.core.application.ApplicationContext;
import java.io.File;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class fq
{
  boolean a = 0;
  String b = "";
  int c = -1;
  di d;
  private String e = "DatabaseService";
  private ff f;
  private fg g;
  private fy h;

  public fq(ff paramff, fg paramfg, fy paramfy)
  {
    this.f = paramff;
    this.g = paramfg;
    this.h = paramfy;
  }

  private BigDecimal a(List paramList, eq parameq, int paramInt, String paramString)
  {
    BigDecimal localBigDecimal1 = new BigDecimal(0);
    Iterator localIterator = paramList.iterator();
    Object localObject1 = localBigDecimal1;
    BigDecimal localBigDecimal2;
    if (localIterator.hasNext())
    {
      Map localMap = (Map)localIterator.next();
      Object localObject2 = (String)localMap.get("buyeraccountpoid");
      String str1 = (String)localMap.get("selleraccountpoid");
      int i = Integer.parseInt((String)localMap.get("type"));
      this = (String)localMap.get("amount");
      if (paramString.equals("seller"))
        localObject2 = str1;
      if (i != paramInt)
        break label170;
      String str2 = String.valueOf(parameq.f());
      if (!((String)localObject2).equals(str2))
        break label170;
      localBigDecimal2 = new BigDecimal(this);
    }
    label170: for (Object localObject3 = ((BigDecimal)localObject1).add(localBigDecimal2); ; localObject3 = localObject1)
    {
      localObject1 = localObject3;
      break;
      return localObject1;
    }
  }

  private void a(String paramString)
  {
    if (this.h == null)
      return;
    this.h.a(paramString);
  }

  private File g()
  {
    ApplicationContext.b.close();
    fj localfj = new fj();
    String str1 = fp.b;
    String str2 = fp.c;
    localfj.a(str1, str2);
    String str3 = fp.c;
    return new File(str3);
  }

  private void h()
  {
    fj localfj = new fj();
    String str1 = fp.d;
    String str2 = fp.e;
    localfj.b(str1, str2);
  }

  private void i()
  {
    try
    {
      fp.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a = 0;
      StringBuilder localStringBuilder = new StringBuilder().append("替换数据库失败,");
      String str1 = localException.getMessage();
      String str2 = str1;
      this.b = str2;
      this.c = 1;
    }
  }

  private void j()
  {
    Context localContext = ApplicationContext.a;
    di localdi = new di(localContext);
    this.d = localdi;
    m();
    this.d.close();
    this.d = null;
    if (!d())
      return;
    int i = 1;
    int j;
    do
    {
      k();
      j = i + 1;
      if (d())
        return;
    }
    while (j < 3);
  }

  private void k()
  {
    i();
    if (!d())
      return;
    l();
  }

  private void l()
  {
    String[] arrayOfString1 = new String[12];
    arrayOfString1[0] = "t_account";
    arrayOfString1[1] = "t_account_group";
    arrayOfString1[2] = "t_category";
    arrayOfString1[3] = "t_profile";
    arrayOfString1[4] = "t_user";
    arrayOfString1[5] = "t_tradingEntity";
    arrayOfString1[6] = "t_transaction";
    arrayOfString1[7] = "t_tag";
    arrayOfString1[8] = "t_transaction_projectcategory_map";
    arrayOfString1[9] = "t_metadata";
    arrayOfString1[10] = "t_id_seed";
    arrayOfString1[11] = "t_sync_logs";
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      int i = 0;
      while (true)
      {
        int j = arrayOfString1.length;
        if (i >= j)
          return;
        localStringBuilder1.setLength(0);
        StringBuilder localStringBuilder2 = localStringBuilder1.append("select 1 from ");
        String str1 = arrayOfString1[i];
        StringBuilder localStringBuilder3 = localStringBuilder2.append(str1).append(" limit 1");
        String[] arrayOfString2 = new String[1];
        arrayOfString2[0] = "1";
        Map localMap = he.b(localStringBuilder1.toString(), arrayOfString2, null);
        i += 1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a = 0;
      StringBuilder localStringBuilder4 = new StringBuilder().append("替换数据库后格式被破坏,");
      String str2 = localException.getMessage();
      String str3 = str2;
      this.b = str3;
      this.c = 2;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.a = 0;
      StringBuilder localStringBuilder5 = new StringBuilder().append("替换数据库后格式被破坏,");
      String str4 = localThrowable.getMessage();
      String str5 = str4;
      this.b = str5;
      this.c = 2;
    }
  }

  private void m()
  {
    long l1 = gt.a();
    List localList1;
    List localList2;
    while (true)
    {
      String str2;
      Object localObject1;
      Object localObject3;
      eq localeq;
      try
      {
        localList1 = b();
        localList2 = c();
        Iterator localIterator = localList1.iterator();
        if (!localIterator.hasNext())
          break;
        Map localMap = (Map)localIterator.next();
        String str1 = (String)localMap.get("accountpoid");
        str2 = (String)localMap.get("name");
        localObject1 = (String)localMap.get("balance");
        Object localObject2 = (String)localMap.get("amountofliability");
        localObject3 = (String)localMap.get("amountofcredit");
        if (!gx.a((String)localObject1))
          continue;
        localObject1 = "0";
        if (!gx.a((String)localObject2))
          continue;
        localObject2 = "0";
        if (!gx.a((String)localObject3))
          continue;
        localObject3 = "0";
        localObject1 = gs.a((String)localObject1);
        localObject2 = gs.a((String)localObject2);
        localObject3 = gs.a((String)localObject3);
        localeq = new eq();
        long l2 = Long.parseLong(str1);
        localeq.b(l2);
        localeq.a(str2);
        BigDecimal localBigDecimal2 = new BigDecimal(0);
        int i = Integer.parseInt((String)localMap.get("grouptype"));
        if (i != 0)
          continue;
        BigDecimal localBigDecimal3 = a(localList2, localeq, 1, "seller");
        BigDecimal localBigDecimal4 = a(localList2, localeq, 2, "seller");
        BigDecimal localBigDecimal5 = a(localList2, localeq, 8, "seller");
        BigDecimal localBigDecimal6 = a(localList2, localeq, 0, "buyer");
        BigDecimal localBigDecimal7 = a(localList2, localeq, 3, "buyer");
        localBigDecimal1 = gs.a(localBigDecimal3.add(localBigDecimal4).add(localBigDecimal5).subtract(localBigDecimal6).subtract(localBigDecimal7));
        if (localBigDecimal1.compareTo((BigDecimal)localObject1) == 0)
          continue;
        String str3 = "资产类账户[" + str2 + "]余额不一致，服务端= " + localObject1 + ", 客户端= " + localBigDecimal1;
        this.b = str3;
        this.a = 0;
        this.c = 0;
        localList1.clear();
        localList2.clear();
        return;
        if (1 != localBigDecimal1)
          break label774;
        BigDecimal localBigDecimal8 = a(localList2, localeq, 4, "seller");
        BigDecimal localBigDecimal9 = a(localList2, localeq, 7, "buyer");
        BigDecimal localBigDecimal10 = a(localList2, localeq, 9, "seller");
        localBigDecimal1 = gs.a(localBigDecimal8.subtract(localBigDecimal9).add(localBigDecimal10));
        if (localBigDecimal1.compareTo((BigDecimal)localObject2) != 0)
        {
          String str4 = "负债类账户[" + str2 + "]负债金额不一致，服务端= " + localObject2 + ", 客户端= " + localBigDecimal1;
          this.b = str4;
          this.a = 0;
          this.c = 0;
          localList1.clear();
          localList2.clear();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        String str5 = this.e;
        StringBuilder localStringBuilder1 = new StringBuilder().append("calculateAccountBalance error: ");
        String str6 = localException.getMessage();
        String str7 = str6;
        gj.a(str5, str7);
        this.a = 0;
        String str8 = localException.getMessage();
        this.b = str8;
        return;
      }
      BigDecimal localBigDecimal1 = null;
      BigDecimal localBigDecimal11 = a(localList2, localeq, localBigDecimal1, "seller");
      BigDecimal localBigDecimal12 = a(localList2, localeq, 7, "buyer");
      localBigDecimal1 = gs.a(localBigDecimal11.subtract(localBigDecimal12));
      if (localBigDecimal1.compareTo((BigDecimal)localObject1) == 0)
        continue;
      String str9 = "负债类账户[" + str2 + "]现金余额不一致，服务端= " + localObject1 + ", 客户端= " + localBigDecimal1;
      this.b = str9;
      this.a = 0;
      this.c = 0;
      localList1.clear();
      localList2.clear();
      return;
      label774: if (2 != localBigDecimal1)
        continue;
      BigDecimal localBigDecimal13 = a(localList2, localeq, 5, "buyer");
      BigDecimal localBigDecimal14 = a(localList2, localeq, 6, "seller");
      BigDecimal localBigDecimal15 = a(localList2, localeq, 10, "seller");
      localBigDecimal1 = gs.a(localBigDecimal13.subtract(localBigDecimal14).add(localBigDecimal15));
      if (localBigDecimal1.compareTo((BigDecimal)localObject3) == 0)
        continue;
      String str10 = "债权类账户[" + str2 + "]债权金额不一致，服务端= " + localObject3 + ", 客户端= " + localBigDecimal1;
      this.b = str10;
      this.a = 0;
      this.c = 0;
      localList1.clear();
      localList2.clear();
      return;
    }
    localList1.clear();
    localList2.clear();
    this.a = 1;
    String str11 = this.e;
    StringBuilder localStringBuilder2 = new StringBuilder().append("sync verifyData, consume time: ");
    long l3 = gt.a() - l1;
    String str12 = l3 + " mills";
    gj.a(str11, str12);
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 340
    //   4: invokespecial 341	fq:a	(Ljava/lang/String;)V
    //   7: invokestatic 240	gt:a	()J
    //   10: lstore_1
    //   11: aload_0
    //   12: invokespecial 343	fq:g	()Ljava/io/File;
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 28	fq:e	Ljava/lang/String;
    //   20: astore 4
    //   22: new 153	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 345
    //   32: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: astore 5
    //   37: invokestatic 240	gt:a	()J
    //   40: lload_1
    //   41: lsub
    //   42: lstore 6
    //   44: aload 5
    //   46: lload 6
    //   48: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   51: ldc_w 328
    //   54: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 8
    //   62: aload 4
    //   64: aload 8
    //   66: invokestatic 314	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: getstatic 348	gh:d	Ljava/lang/String;
    //   72: astore 9
    //   74: new 350	java/net/URL
    //   77: dup
    //   78: aload 9
    //   80: invokespecial 351	java/net/URL:<init>	(Ljava/lang/String;)V
    //   83: astore_1
    //   84: aload_0
    //   85: ldc_w 353
    //   88: invokespecial 341	fq:a	(Ljava/lang/String;)V
    //   91: new 355	java/util/HashMap
    //   94: dup
    //   95: invokespecial 356	java/util/HashMap:<init>	()V
    //   98: astore 10
    //   100: aload 10
    //   102: ldc_w 358
    //   105: aload_3
    //   106: invokeinterface 362 3 0
    //   111: astore 11
    //   113: new 355	java/util/HashMap
    //   116: dup
    //   117: invokespecial 356	java/util/HashMap:<init>	()V
    //   120: astore 12
    //   122: aload_0
    //   123: getfield 39	fq:f	Lff;
    //   126: invokevirtual 366	ff:d	()Ljava/lang/String;
    //   129: astore 13
    //   131: aload 12
    //   133: ldc_w 368
    //   136: aload 13
    //   138: invokeinterface 362 3 0
    //   143: astore 14
    //   145: invokestatic 240	gt:a	()J
    //   148: lstore 15
    //   150: aload_1
    //   151: aload 10
    //   153: aload 12
    //   155: invokestatic 373	gn:b	(Ljava/net/URL;Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;
    //   158: astore_1
    //   159: aload_0
    //   160: getfield 28	fq:e	Ljava/lang/String;
    //   163: astore 17
    //   165: new 153	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 375
    //   175: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: astore 18
    //   180: invokestatic 240	gt:a	()J
    //   183: lload 15
    //   185: lsub
    //   186: lstore 19
    //   188: aload 18
    //   190: lload 19
    //   192: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   195: ldc_w 328
    //   198: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: astore 21
    //   206: aload 17
    //   208: aload 21
    //   210: invokestatic 314	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_1
    //   214: ldc_w 377
    //   217: invokeinterface 73 2 0
    //   222: invokestatic 380	gx:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   225: ldc_w 382
    //   228: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +325 -> 556
    //   234: aconst_null
    //   235: astore 10
    //   237: sipush 1000
    //   240: istore 22
    //   242: ldc2_w 383
    //   245: lstore 23
    //   247: aload_1
    //   248: ldc_w 386
    //   251: invokeinterface 73 2 0
    //   256: invokestatic 380	gx:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   259: astore_1
    //   260: aload_1
    //   261: ldc 33
    //   263: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   266: ifne +9 -> 275
    //   269: aload_1
    //   270: invokestatic 274	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   273: lstore 23
    //   275: invokestatic 240	gt:a	()J
    //   278: lstore 25
    //   280: aload 10
    //   282: astore_1
    //   283: iload 22
    //   285: i2l
    //   286: lstore 27
    //   288: aload_1
    //   289: lload 27
    //   291: ladd
    //   292: lstore_1
    //   293: lload_1
    //   294: lload 23
    //   296: lcmp
    //   297: ifle +58 -> 355
    //   300: new 334	ej
    //   303: dup
    //   304: ldc_w 388
    //   307: invokespecial 389	ej:<init>	(Ljava/lang/String;)V
    //   310: athrow
    //   311: astore 29
    //   313: aload 29
    //   315: invokevirtual 390	ej:printStackTrace	()V
    //   318: aload 29
    //   320: athrow
    //   321: astore 30
    //   323: aload 30
    //   325: invokevirtual 391	java/net/MalformedURLException:printStackTrace	()V
    //   328: new 334	ej
    //   331: dup
    //   332: aload 30
    //   334: invokespecial 394	ej:<init>	(Ljava/lang/Exception;)V
    //   337: athrow
    //   338: astore 31
    //   340: aload 31
    //   342: invokevirtual 395	java/io/IOException:printStackTrace	()V
    //   345: new 334	ej
    //   348: dup
    //   349: aload 31
    //   351: invokespecial 394	ej:<init>	(Ljava/lang/Exception;)V
    //   354: athrow
    //   355: aload_0
    //   356: getfield 39	fq:f	Lff;
    //   359: astore 32
    //   361: aload_0
    //   362: getfield 41	fq:g	Lfg;
    //   365: astore 33
    //   367: aload_0
    //   368: getfield 43	fq:h	Lfy;
    //   371: astore 34
    //   373: getstatic 140	fp:d	Ljava/lang/String;
    //   376: astore 35
    //   378: new 397	fr
    //   381: dup
    //   382: aload 32
    //   384: aload 33
    //   386: aload 34
    //   388: aload 35
    //   390: invokespecial 400	fr:<init>	(Lff;Lfg;Lfy;Ljava/lang/String;)V
    //   393: astore 36
    //   395: aload 36
    //   397: invokevirtual 401	fr:a	()V
    //   400: aload 36
    //   402: getfield 403	fr:b	Z
    //   405: ifeq +128 -> 533
    //   408: aload_0
    //   409: getfield 28	fq:e	Ljava/lang/String;
    //   412: astore 37
    //   414: new 153	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 405
    //   424: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: astore 38
    //   429: invokestatic 240	gt:a	()J
    //   432: lload 25
    //   434: lsub
    //   435: lstore 39
    //   437: aload 38
    //   439: lload 39
    //   441: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   444: ldc_w 328
    //   447: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: astore 41
    //   455: aload 37
    //   457: aload 41
    //   459: invokestatic 314	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: invokestatic 408	gz:a	()V
    //   465: invokestatic 240	gt:a	()J
    //   468: lstore 42
    //   470: aload_0
    //   471: invokespecial 410	fq:h	()V
    //   474: aload_0
    //   475: getfield 28	fq:e	Ljava/lang/String;
    //   478: astore 44
    //   480: new 153	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   487: ldc_w 412
    //   490: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: astore 45
    //   495: invokestatic 240	gt:a	()J
    //   498: lload 42
    //   500: lsub
    //   501: lstore 46
    //   503: aload 45
    //   505: lload 46
    //   507: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   510: ldc_w 328
    //   513: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: astore 48
    //   521: aload 44
    //   523: aload 48
    //   525: invokestatic 314	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: aload_0
    //   529: invokespecial 414	fq:j	()V
    //   532: return
    //   533: iload 22
    //   535: i2l
    //   536: lstore 49
    //   538: lload 49
    //   540: invokestatic 419	java/lang/Thread:sleep	(J)V
    //   543: goto -260 -> 283
    //   546: astore 51
    //   548: aload 51
    //   550: invokevirtual 420	ee:printStackTrace	()V
    //   553: aload 51
    //   555: athrow
    //   556: aload_1
    //   557: ldc_w 422
    //   560: invokeinterface 73 2 0
    //   565: invokestatic 380	gx:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   568: astore 52
    //   570: new 334	ej
    //   573: dup
    //   574: aload 52
    //   576: invokespecial 389	ej:<init>	(Ljava/lang/String;)V
    //   579: athrow
    //   580: astore 53
    //   582: aload 53
    //   584: invokevirtual 423	ef:printStackTrace	()V
    //   587: aload 53
    //   589: invokevirtual 424	ef:getMessage	()Ljava/lang/String;
    //   592: astore 54
    //   594: new 334	ej
    //   597: dup
    //   598: aload 54
    //   600: aload 53
    //   602: invokespecial 427	ej:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   605: athrow
    //   606: astore 55
    //   608: aload 55
    //   610: invokevirtual 151	java/lang/Exception:printStackTrace	()V
    //   613: new 334	ej
    //   616: dup
    //   617: aload 55
    //   619: invokespecial 394	ej:<init>	(Ljava/lang/Exception;)V
    //   622: athrow
    //   623: astore 56
    //   625: aload 56
    //   627: invokevirtual 395	java/io/IOException:printStackTrace	()V
    //   630: new 334	ej
    //   633: dup
    //   634: aload 56
    //   636: invokespecial 394	ej:<init>	(Ljava/lang/Exception;)V
    //   639: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   145	311	311	ej
    //   355	462	311	ej
    //   538	543	311	ej
    //   556	580	311	ej
    //   11	84	321	java/net/MalformedURLException
    //   11	84	338	java/io/IOException
    //   145	311	546	ee
    //   355	462	546	ee
    //   538	543	546	ee
    //   556	580	546	ee
    //   145	311	580	ef
    //   355	462	580	ef
    //   538	543	580	ef
    //   556	580	580	ef
    //   145	311	606	java/lang/Exception
    //   355	462	606	java/lang/Exception
    //   538	543	606	java/lang/Exception
    //   556	580	606	java/lang/Exception
    //   465	528	623	java/io/IOException
  }

  public List b()
  {
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "1";
    arrayOfString[1] = "0";
    arrayOfString[2] = "1";
    arrayOfString[3] = "2";
    arrayOfString[4] = "2";
    arrayOfString[5] = "2";
    return he.a(this.d.a(), "SELECT a.accountPOID, a.name, ag.type as groupType, a.balance, a.amountOfLiability, a.amountOfCredit FROM t_account AS a INNER JOIN t_account_group AS ag ON a.accountGroupPOID = ag.accountGroupPOID", arrayOfString, null);
  }

  public List c()
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "1";
    arrayOfString[1] = "1";
    arrayOfString[2] = "1";
    arrayOfString[3] = "2";
    return he.a(this.d.a(), "SELECT trans.buyerAccountPOID, trans.sellerAccountPOID,trans.type, ( CASE WHEN sum(trans.sellerMoney)IS NULL THEN 0 ELSE sum(trans.sellerMoney) END ) AS amount FROM t_transaction AS trans GROUP BY trans.buyerAccountPOID, trans.sellerAccountPOID, trans.type", arrayOfString, null);
  }

  public boolean d()
  {
    return this.a;
  }

  public String e()
  {
    return this.b;
  }

  public int f()
  {
    return this.c;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fq
 * JD-Core Version:    0.6.0
 */