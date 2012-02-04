import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlSerializer;

public class fs
{
  public static String a = "LoginForSyncService";
  public static String b = "0";
  public static String c = "1";
  public static String d = "2";
  public static String e = "3";
  private ff f;
  private fy g;
  private String h = null;

  public fs(ff paramff, fg paramfg, fy paramfy)
  {
    this.f = paramff;
    this.g = paramfy;
  }

  private int a(Document paramDocument)
  {
    Element localElement = paramDocument.getDocumentElement();
    String str1 = fd.a("PFService", "cmd", localElement);
    String str2 = fe.d;
    if (!str1.equals(str2))
    {
      String str3 = fd.a("Error", localElement);
      throw new ej(str3);
    }
    Node localNode = fd.b("Redirect", localElement);
    if (localNode != null)
    {
      String str4 = gx.a(localNode.getFirstChild().getNodeValue());
      this.h = str4;
      if (gx.a(this.h));
    }
    for (int i = 0; ; i = 1)
    {
      return i;
      String str5 = fd.a("SessionKey", localElement);
      String str6 = fd.a("ServiceTime", localElement);
      this.f.d(str5);
      long l1 = Long.valueOf(str6).longValue();
      long l2 = System.currentTimeMillis();
      long l3 = l1 - l2;
      String str7 = "update t_profile set syncOffsetTime = " + l3;
      ArrayList localArrayList = new ArrayList(1);
      boolean bool = localArrayList.add(str7);
      he.a(localArrayList, 0);
      com.mymoney.core.application.ApplicationContext.f = l3;
      String str8 = a;
      String str9 = "offsetTimeInMills(web server compare to local) is " + l3;
      gj.a(str8, str9);
    }
  }

  private String a(String paramString1, String paramString2, String paramString3)
  {
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer1 = fd.a(localStringWriter);
    XmlSerializer localXmlSerializer2 = fd.b(localXmlSerializer1);
    XmlSerializer localXmlSerializer3 = localXmlSerializer1.startTag("", "Provider");
    XmlSerializer localXmlSerializer4 = localXmlSerializer1.attribute("", "id", "android");
    XmlSerializer localXmlSerializer5 = localXmlSerializer1.text(paramString3);
    XmlSerializer localXmlSerializer6 = localXmlSerializer1.endTag("", "Provider");
    XmlSerializer localXmlSerializer7 = localXmlSerializer1.startTag("", "PFService");
    XmlSerializer localXmlSerializer8 = localXmlSerializer1.attribute("", "cmd", "syncDSStart");
    XmlSerializer localXmlSerializer9 = localXmlSerializer1.startTag("", "UserName");
    XmlSerializer localXmlSerializer10 = localXmlSerializer1.text(paramString1);
    XmlSerializer localXmlSerializer11 = localXmlSerializer1.endTag("", "UserName");
    XmlSerializer localXmlSerializer12 = localXmlSerializer1.startTag("", "Password");
    XmlSerializer localXmlSerializer13 = localXmlSerializer1.text(paramString2);
    XmlSerializer localXmlSerializer14 = localXmlSerializer1.endTag("", "Password");
    XmlSerializer localXmlSerializer15 = localXmlSerializer1.endTag("", "PFService");
    XmlSerializer localXmlSerializer16 = fd.c(localXmlSerializer1);
    fd.a(localXmlSerializer1);
    return localStringWriter.toString();
  }

  private void b()
  {
    if (!gh.a(this.h))
      return;
    this.h = null;
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	fs:g	Lfy;
    //   4: ldc 227
    //   6: invokeinterface 231 2 0
    //   11: aload_0
    //   12: getfield 45	fs:f	Lff;
    //   15: invokevirtual 233	ff:b	()Ljava/lang/String;
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 45	fs:f	Lff;
    //   23: invokevirtual 235	ff:c	()Ljava/lang/String;
    //   26: invokestatic 240	gk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_2
    //   30: aload_0
    //   31: getfield 45	fs:f	Lff;
    //   34: invokevirtual 242	ff:a	()Ljava/lang/String;
    //   37: astore_3
    //   38: aload_0
    //   39: aload_1
    //   40: aload_2
    //   41: aload_3
    //   42: invokespecial 244	fs:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 4
    //   47: aload 4
    //   49: astore 5
    //   51: iconst_0
    //   52: istore 6
    //   54: aload_0
    //   55: getfield 43	fs:h	Ljava/lang/String;
    //   58: invokestatic 105	gx:a	(Ljava/lang/String;)Z
    //   61: ifne +18 -> 79
    //   64: aload_0
    //   65: getfield 47	fs:g	Lfy;
    //   68: ldc 246
    //   70: invokeinterface 231 2 0
    //   75: aload_0
    //   76: invokespecial 248	fs:b	()V
    //   79: getstatic 249	gh:b	Ljava/lang/String;
    //   82: invokestatic 255	java/net/URI:create	(Ljava/lang/String;)Ljava/net/URI;
    //   85: astore 7
    //   87: new 257	fh
    //   90: dup
    //   91: aload 7
    //   93: invokespecial 260	fh:<init>	(Ljava/net/URI;)V
    //   96: astore 8
    //   98: aconst_null
    //   99: astore 9
    //   101: aload 8
    //   103: aload 5
    //   105: invokevirtual 263	fh:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   108: astore 10
    //   110: new 130	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 265
    //   120: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 9
    //   125: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: ldc_w 270
    //   131: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 11
    //   139: aload 10
    //   141: aload 11
    //   143: invokestatic 273	gj:a	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   146: iconst_1
    //   147: iconst_1
    //   148: iadd
    //   149: istore 12
    //   151: aload 10
    //   153: invokestatic 276	fd:a	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   156: astore 13
    //   158: aload_0
    //   159: aload 13
    //   161: invokespecial 278	fs:a	(Lorg/w3c/dom/Document;)I
    //   164: istore 14
    //   166: invokestatic 282	gz:a	()V
    //   169: iload 14
    //   171: ifle +49 -> 220
    //   174: aload 8
    //   176: invokevirtual 283	fh:b	()V
    //   179: return
    //   180: astore 15
    //   182: aload 15
    //   184: invokevirtual 286	java/lang/Exception:printStackTrace	()V
    //   187: new 130	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 288
    //   197: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 15
    //   202: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: astore 16
    //   210: new 79	ej
    //   213: dup
    //   214: aload 16
    //   216: invokespecial 82	ej:<init>	(Ljava/lang/String;)V
    //   219: athrow
    //   220: aload 8
    //   222: invokevirtual 283	fh:b	()V
    //   225: goto -171 -> 54
    //   228: astore 9
    //   230: aload 9
    //   232: invokevirtual 292	ek:printStackTrace	()V
    //   235: invokestatic 297	gg:a	()Lgg;
    //   238: invokevirtual 298	gg:b	()Ljava/lang/String;
    //   241: ldc_w 300
    //   244: ldc 183
    //   246: invokevirtual 304	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   249: astore 17
    //   251: aload_0
    //   252: getfield 43	fs:h	Ljava/lang/String;
    //   255: invokestatic 102	gx:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   258: aload 17
    //   260: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: ifne +29 -> 292
    //   266: iload 6
    //   268: ifne +24 -> 292
    //   271: aload_0
    //   272: aload 17
    //   274: putfield 43	fs:h	Ljava/lang/String;
    //   277: aload_0
    //   278: invokespecial 248	fs:b	()V
    //   281: aload 8
    //   283: invokevirtual 283	fh:b	()V
    //   286: iconst_1
    //   287: istore 6
    //   289: goto -235 -> 54
    //   292: new 79	ej
    //   295: dup
    //   296: aload 9
    //   298: invokespecial 307	ej:<init>	(Ljava/lang/Exception;)V
    //   301: athrow
    //   302: astore 18
    //   304: aload 8
    //   306: invokevirtual 283	fh:b	()V
    //   309: aload 18
    //   311: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   11	47	180	java/lang/Exception
    //   101	169	228	ek
    //   101	169	302	finally
    //   230	281	302	finally
    //   292	302	302	finally
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fs
 * JD-Core Version:    0.6.0
 */