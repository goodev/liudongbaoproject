import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import org.xmlpull.v1.XmlSerializer;

public class fr
{
  public static String a = "HeartbeatService";
  boolean b = 0;
  String c;
  private ff d;
  private fy e;

  public fr(ff paramff, fg paramfg, fy paramfy, String paramString)
  {
    this.d = paramff;
    this.e = paramfy;
    this.c = paramString;
  }

  private void a(String paramString)
  {
    if (this.e == null)
      return;
    this.e.a(paramString);
  }

  // ERROR //
  private void a(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: ldc 48
    //   5: invokevirtual 54	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   8: invokestatic 59	gx:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   11: astore_3
    //   12: aload_3
    //   13: ldc 61
    //   15: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +298 -> 316
    //   21: invokestatic 72	gt:a	()J
    //   24: lstore 4
    //   26: aload_0
    //   27: getfield 32	fr:c	Ljava/lang/String;
    //   30: astore 6
    //   32: new 74	java/io/File
    //   35: dup
    //   36: aload 6
    //   38: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: invokevirtual 80	java/io/File:exists	()Z
    //   44: ifeq +23 -> 67
    //   47: aload_0
    //   48: getfield 32	fr:c	Ljava/lang/String;
    //   51: astore 7
    //   53: new 74	java/io/File
    //   56: dup
    //   57: aload 7
    //   59: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: invokevirtual 83	java/io/File:delete	()Z
    //   65: istore 8
    //   67: aload_0
    //   68: getfield 32	fr:c	Ljava/lang/String;
    //   71: astore 9
    //   73: new 85	java/io/FileOutputStream
    //   76: dup
    //   77: aload 9
    //   79: invokespecial 86	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   82: astore 10
    //   84: aload 10
    //   86: invokestatic 91	fi:a	(Ljava/io/OutputStream;)V
    //   89: aload_1
    //   90: invokevirtual 95	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   93: astore 11
    //   95: aload 11
    //   97: astore 12
    //   99: sipush 1024
    //   102: istore_2
    //   103: iload_2
    //   104: newarray byte
    //   106: astore 13
    //   108: aload 12
    //   110: aload 13
    //   112: invokevirtual 101	java/io/InputStream:read	([B)I
    //   115: istore 14
    //   117: iload 14
    //   119: bipush 255
    //   121: if_icmpeq +25 -> 146
    //   124: aload 10
    //   126: aload 13
    //   128: iconst_0
    //   129: iload 14
    //   131: invokevirtual 105	java/io/FileOutputStream:write	([BII)V
    //   134: aload 12
    //   136: aload 13
    //   138: invokevirtual 101	java/io/InputStream:read	([B)I
    //   141: istore 14
    //   143: goto -26 -> 117
    //   146: aload 10
    //   148: invokevirtual 108	java/io/FileOutputStream:flush	()V
    //   151: aload 10
    //   153: ifnull +8 -> 161
    //   156: aload 10
    //   158: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   161: aload 12
    //   163: ifnull +8 -> 171
    //   166: aload 12
    //   168: invokevirtual 112	java/io/InputStream:close	()V
    //   171: aload_0
    //   172: ldc 113
    //   174: putfield 26	fr:b	Z
    //   177: getstatic 19	fr:a	Ljava/lang/String;
    //   180: astore 15
    //   182: new 115	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   189: ldc 118
    //   191: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: astore 16
    //   196: invokestatic 72	gt:a	()J
    //   199: lload 4
    //   201: lsub
    //   202: lstore 17
    //   204: aload 16
    //   206: lload 17
    //   208: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   211: ldc 127
    //   213: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: astore 19
    //   221: aload 15
    //   223: aload 19
    //   225: invokestatic 136	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload_1
    //   229: invokestatic 140	fh:a	(Ljava/net/HttpURLConnection;)V
    //   232: return
    //   233: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   236: goto -65 -> 171
    //   239: astore 20
    //   241: aconst_null
    //   242: astore 21
    //   244: aconst_null
    //   245: astore 10
    //   247: aload 20
    //   249: invokevirtual 144	java/net/SocketTimeoutException:printStackTrace	()V
    //   252: new 146	ej
    //   255: dup
    //   256: ldc 148
    //   258: invokespecial 149	ej:<init>	(Ljava/lang/String;)V
    //   261: athrow
    //   262: astore 22
    //   264: aload 10
    //   266: ifnull +8 -> 274
    //   269: aload 10
    //   271: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   274: aload 21
    //   276: ifnull +8 -> 284
    //   279: aload 21
    //   281: invokevirtual 112	java/io/InputStream:close	()V
    //   284: aload 22
    //   286: athrow
    //   287: astore 20
    //   289: aconst_null
    //   290: astore 21
    //   292: aconst_null
    //   293: astore 10
    //   295: aload 20
    //   297: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   300: new 146	ej
    //   303: dup
    //   304: aload 20
    //   306: invokespecial 152	ej:<init>	(Ljava/lang/Exception;)V
    //   309: athrow
    //   310: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   313: goto -29 -> 284
    //   316: aload_3
    //   317: ldc 154
    //   319: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   322: ifeq +41 -> 363
    //   325: aload_1
    //   326: ldc 156
    //   328: invokevirtual 54	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   331: invokestatic 59	gx:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   334: ldc 158
    //   336: invokestatic 164	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   339: astore 23
    //   341: aload_0
    //   342: ldc 113
    //   344: putfield 26	fr:b	Z
    //   347: new 146	ej
    //   350: dup
    //   351: aload 23
    //   353: invokespecial 149	ej:<init>	(Ljava/lang/String;)V
    //   356: athrow
    //   357: invokevirtual 165	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   360: goto -132 -> 228
    //   363: aload_3
    //   364: ldc 167
    //   366: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   369: ifeq +58 -> 427
    //   372: aload_1
    //   373: ldc 156
    //   375: invokevirtual 54	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   378: invokestatic 59	gx:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   381: ldc 158
    //   383: invokestatic 164	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   386: astore 24
    //   388: aload 24
    //   390: astore 25
    //   392: aload 25
    //   394: ldc 169
    //   396: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   399: ifne +9 -> 408
    //   402: aload_0
    //   403: aload 25
    //   405: invokespecial 170	fr:a	(Ljava/lang/String;)V
    //   408: aload_0
    //   409: ldc 24
    //   411: putfield 26	fr:b	Z
    //   414: goto -186 -> 228
    //   417: invokevirtual 165	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   420: ldc 169
    //   422: astore 25
    //   424: goto -32 -> 392
    //   427: aload_0
    //   428: ldc 113
    //   430: putfield 26	fr:b	Z
    //   433: new 146	ej
    //   436: dup
    //   437: ldc 172
    //   439: invokespecial 149	ej:<init>	(Ljava/lang/String;)V
    //   442: athrow
    //   443: astore 26
    //   445: goto -284 -> 161
    //   448: astore 27
    //   450: goto -176 -> 274
    //   453: astore 22
    //   455: aconst_null
    //   456: astore 21
    //   458: aconst_null
    //   459: astore 10
    //   461: goto -197 -> 264
    //   464: astore 22
    //   466: aconst_null
    //   467: astore 21
    //   469: goto -205 -> 264
    //   472: astore 22
    //   474: aload 12
    //   476: astore 21
    //   478: goto -214 -> 264
    //   481: astore 20
    //   483: aconst_null
    //   484: astore 21
    //   486: goto -191 -> 295
    //   489: astore 20
    //   491: aload 12
    //   493: astore 21
    //   495: goto -200 -> 295
    //   498: astore 20
    //   500: aconst_null
    //   501: astore 21
    //   503: goto -256 -> 247
    //   506: astore 20
    //   508: aload 12
    //   510: astore 21
    //   512: goto -265 -> 247
    //
    // Exception table:
    //   from	to	target	type
    //   166	171	233	java/lang/Exception
    //   67	84	239	java/net/SocketTimeoutException
    //   247	262	262	finally
    //   295	310	262	finally
    //   67	84	287	java/lang/Exception
    //   279	284	310	java/lang/Exception
    //   325	357	357	java/io/UnsupportedEncodingException
    //   372	388	417	java/io/UnsupportedEncodingException
    //   156	161	443	java/io/IOException
    //   269	274	448	java/io/IOException
    //   67	84	453	finally
    //   84	95	464	finally
    //   103	151	472	finally
    //   84	95	481	java/lang/Exception
    //   103	151	489	java/lang/Exception
    //   84	95	498	java/net/SocketTimeoutException
    //   103	151	506	java/net/SocketTimeoutException
  }

  private String b()
  {
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer1 = fd.a(localStringWriter);
    XmlSerializer localXmlSerializer2 = localXmlSerializer1.startTag("", "PFSMLService");
    XmlSerializer localXmlSerializer3 = localXmlSerializer1.startTag("", "PFService");
    XmlSerializer localXmlSerializer4 = localXmlSerializer1.attribute("", "cmd", "syncHeartbeat");
    XmlSerializer localXmlSerializer5 = localXmlSerializer1.startTag("", "SessionKey");
    String str1 = this.d.d();
    XmlSerializer localXmlSerializer6 = localXmlSerializer1.text(str1);
    XmlSerializer localXmlSerializer7 = localXmlSerializer1.endTag("", "SessionKey");
    XmlSerializer localXmlSerializer8 = localXmlSerializer1.startTag("", "ClientTime");
    String str2 = String.valueOf(System.currentTimeMillis());
    XmlSerializer localXmlSerializer9 = localXmlSerializer1.text(str2);
    XmlSerializer localXmlSerializer10 = localXmlSerializer1.endTag("", "ClientTime");
    XmlSerializer localXmlSerializer11 = localXmlSerializer1.endTag("", "PFService");
    XmlSerializer localXmlSerializer12 = localXmlSerializer1.endTag("", "PFSMLService");
    fd.a(localXmlSerializer1);
    String str3 = localStringWriter.toString();
    gj.c(str3, "HearbeatRequest.xml");
    return str3;
  }

  public void a()
  {
    a("从服务端下载数据...");
    try
    {
      String str1 = b();
      String str2 = str1;
      HttpURLConnection localHttpURLConnection = fh.a(gh.b, str2);
      a(localHttpURLConnection);
      gz.a();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    throw new ej("客户端请求错误");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fr
 * JD-Core Version:    0.6.0
 */