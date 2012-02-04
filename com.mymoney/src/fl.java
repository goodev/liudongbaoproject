import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

public class fl
{
  public static String a = "AbortService";
  String b;
  private ff c;
  private fy d;

  public fl(ff paramff, fg paramfg, fy paramfy, String paramString)
  {
    this.c = paramff;
    this.d = paramfy;
    this.b = paramString;
  }

  private void a(String paramString)
  {
    if (this.d == null)
      return;
    this.d.a(paramString);
  }

  private String b()
  {
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer1 = fd.a(localStringWriter);
    XmlSerializer localXmlSerializer2 = localXmlSerializer1.startTag("", "PFSMLService");
    XmlSerializer localXmlSerializer3 = localXmlSerializer1.startTag("", "PFService");
    XmlSerializer localXmlSerializer4 = localXmlSerializer1.attribute("", "cmd", "syncDSAbort");
    XmlSerializer localXmlSerializer5 = localXmlSerializer1.startTag("", "SessionKey");
    String str1 = this.c.d();
    XmlSerializer localXmlSerializer6 = localXmlSerializer1.text(str1);
    XmlSerializer localXmlSerializer7 = localXmlSerializer1.endTag("", "SessionKey");
    XmlSerializer localXmlSerializer8 = localXmlSerializer1.startTag("", "Error");
    String str2 = this.b;
    XmlSerializer localXmlSerializer9 = localXmlSerializer1.text(str2);
    XmlSerializer localXmlSerializer10 = localXmlSerializer1.endTag("", "Error");
    XmlSerializer localXmlSerializer11 = localXmlSerializer1.endTag("", "PFService");
    XmlSerializer localXmlSerializer12 = localXmlSerializer1.endTag("", "PFSMLService");
    fd.a(localXmlSerializer1);
    String str3 = localStringWriter.toString();
    gj.c(str3, "AbortRequest.xml");
    return str3;
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 95
    //   3: invokespecial 96	fl:a	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: invokespecial 98	fl:b	()Ljava/lang/String;
    //   10: astore_1
    //   11: aload_1
    //   12: astore_2
    //   13: getstatic 101	gh:b	Ljava/lang/String;
    //   16: invokestatic 107	java/net/URI:create	(Ljava/lang/String;)Ljava/net/URI;
    //   19: astore_3
    //   20: new 109	fh
    //   23: dup
    //   24: aload_3
    //   25: invokespecial 112	fh:<init>	(Ljava/net/URI;)V
    //   28: astore 4
    //   30: aload 4
    //   32: aload_2
    //   33: invokevirtual 115	fh:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore 5
    //   38: aload 5
    //   40: ldc 117
    //   42: invokestatic 120	gj:a	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   45: aload 5
    //   47: invokestatic 123	fd:a	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   50: astore 6
    //   52: aload 4
    //   54: invokevirtual 125	fh:b	()V
    //   57: invokestatic 129	gz:a	()V
    //   60: return
    //   61: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   64: new 134	ej
    //   67: dup
    //   68: ldc 136
    //   70: invokespecial 138	ej:<init>	(Ljava/lang/String;)V
    //   73: athrow
    //   74: astore 7
    //   76: aload 7
    //   78: invokevirtual 139	ek:printStackTrace	()V
    //   81: new 134	ej
    //   84: dup
    //   85: aload 7
    //   87: invokespecial 142	ej:<init>	(Ljava/lang/Exception;)V
    //   90: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   6	11	61	java/io/IOException
    //   30	60	74	ek
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fl
 * JD-Core Version:    0.6.0
 */