import java.io.StringWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xmlpull.v1.XmlSerializer;

public class fo
{
  public static String a = "CommitService";
  boolean b = 0;
  String c;
  private ff d;
  private fy e;

  public fo(ff paramff, fg paramfg, fy paramfy)
  {
    this.d = paramff;
    this.e = paramfy;
  }

  private void a(String paramString)
  {
    if (this.e == null)
      return;
    this.e.a(paramString);
  }

  private void a(Document paramDocument)
  {
    Element localElement = paramDocument.getDocumentElement();
    String str1 = fd.a("PFService", "cmd", localElement);
    String str2 = fe.d;
    if (str1.equals(str2))
    {
      this.b = 1;
      return;
    }
    String str3 = gx.a(fd.a("PFService", "Error", localElement));
    if (gx.a(str3))
      str3 = "提交服务器保存,服务端操作失败,请重试!";
    throw new ej(str3);
  }

  private String c()
  {
    StringWriter localStringWriter = new StringWriter();
    XmlSerializer localXmlSerializer1 = fd.a(localStringWriter);
    XmlSerializer localXmlSerializer2 = localXmlSerializer1.startTag("", "PFSMLService");
    XmlSerializer localXmlSerializer3 = localXmlSerializer1.startTag("", "PFService");
    XmlSerializer localXmlSerializer4 = localXmlSerializer1.attribute("", "cmd", "syncDSCommit");
    XmlSerializer localXmlSerializer5 = localXmlSerializer1.startTag("", "SessionKey");
    String str1 = this.d.d();
    XmlSerializer localXmlSerializer6 = localXmlSerializer1.text(str1);
    XmlSerializer localXmlSerializer7 = localXmlSerializer1.endTag("", "SessionKey");
    XmlSerializer localXmlSerializer8 = localXmlSerializer1.endTag("", "PFService");
    XmlSerializer localXmlSerializer9 = localXmlSerializer1.endTag("", "PFSMLService");
    fd.a(localXmlSerializer1);
    String str2 = localStringWriter.toString();
    gj.c(str2, "CommitRequest.xml");
    return str2;
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 133
    //   3: invokespecial 134	fo:a	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: invokespecial 136	fo:c	()Ljava/lang/String;
    //   10: astore_1
    //   11: aload_1
    //   12: astore_2
    //   13: invokestatic 141	gt:a	()J
    //   16: lstore_3
    //   17: getstatic 145	gh:b	Ljava/lang/String;
    //   20: invokestatic 151	java/net/URI:create	(Ljava/lang/String;)Ljava/net/URI;
    //   23: astore 5
    //   25: new 153	fh
    //   28: dup
    //   29: aload 5
    //   31: invokespecial 156	fh:<init>	(Ljava/net/URI;)V
    //   34: astore 6
    //   36: aload 6
    //   38: aload_2
    //   39: invokevirtual 159	fh:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   42: astore 7
    //   44: aload 7
    //   46: ldc 161
    //   48: invokestatic 164	gj:a	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   51: aload 7
    //   53: invokestatic 167	fd:a	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   56: astore 8
    //   58: aload 6
    //   60: invokevirtual 169	fh:b	()V
    //   63: aload_0
    //   64: aload 8
    //   66: invokespecial 171	fo:a	(Lorg/w3c/dom/Document;)V
    //   69: invokestatic 175	gz:a	()V
    //   72: getstatic 19	fo:a	Ljava/lang/String;
    //   75: astore 9
    //   77: new 177	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   84: ldc 180
    //   86: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: astore 10
    //   91: invokestatic 141	gt:a	()J
    //   94: lload_3
    //   95: lsub
    //   96: lstore 11
    //   98: aload 10
    //   100: lload 11
    //   102: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   105: ldc 189
    //   107: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: astore 13
    //   115: aload 9
    //   117: aload 13
    //   119: invokestatic 192	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: return
    //   123: invokevirtual 195	java/io/IOException:printStackTrace	()V
    //   126: new 76	ej
    //   129: dup
    //   130: ldc 197
    //   132: invokespecial 78	ej:<init>	(Ljava/lang/String;)V
    //   135: athrow
    //   136: astore 14
    //   138: aload 14
    //   140: invokevirtual 198	ek:printStackTrace	()V
    //   143: aload 6
    //   145: invokevirtual 169	fh:b	()V
    //   148: new 76	ej
    //   151: dup
    //   152: aload 14
    //   154: invokespecial 201	ej:<init>	(Ljava/lang/Exception;)V
    //   157: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   6	11	123	java/io/IOException
    //   36	72	136	ek
  }

  public String b()
  {
    return this.c;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fo
 * JD-Core Version:    0.6.0
 */