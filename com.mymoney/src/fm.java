import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xmlpull.v1.XmlSerializer;

public class fm
{
  public static String a = "AutoUpgradeService";
  private static fm b = new fm();

  public static fm a()
  {
    return b;
  }

  private fn a(Document paramDocument)
  {
    Object localObject = paramDocument.getDocumentElement();
    String str1 = fd.a("Result", (Element)localObject);
    fn localfn;
    if (fe.d.equalsIgnoreCase(str1))
      localfn = new fn(this);
    while (true)
    {
      try
      {
        String str2 = fd.a("VersionCode", (Element)localObject);
        String str3 = fd.a("VersionName", (Element)localObject);
        String str4 = fd.a("ApkDownloadUrl", (Element)localObject);
        String str5 = fd.a("Describe", (Element)localObject);
        int i = Integer.parseInt(str2);
        localfn.a(i);
        localfn.a(str3);
        localfn.b(str4);
        localfn.c(str5);
        localObject = localfn;
        return localObject;
      }
      catch (Exception localException)
      {
        String str6 = a;
        StringBuilder localStringBuilder = new StringBuilder().append("handle aotuUpgrade reps xml error,");
        String str7 = localException.getCause().getMessage();
        String str8 = str7;
        gj.a(str6, str8);
        localObject = null;
        continue;
      }
      localObject = null;
    }
  }

  private String b(Context paramContext)
  {
    while (true)
    {
      XmlSerializer localXmlSerializer1;
      try
      {
        StringWriter localStringWriter = new StringWriter();
        localXmlSerializer1 = fd.a(localStringWriter);
        XmlSerializer localXmlSerializer2 = localXmlSerializer1.startTag("", "PFSMLService");
        String str1 = gg.a().h();
        XmlSerializer localXmlSerializer3 = localXmlSerializer1.attribute("", "protocolVersion", str1);
        XmlSerializer localXmlSerializer4 = localXmlSerializer1.startTag("", "ServiceProvider");
        XmlSerializer localXmlSerializer5 = localXmlSerializer1.startTag("", "Provider");
        XmlSerializer localXmlSerializer6 = localXmlSerializer1.attribute("", "id", "android");
        XmlSerializer localXmlSerializer7 = localXmlSerializer1.endTag("", "Provider");
        XmlSerializer localXmlSerializer8 = localXmlSerializer1.endTag("", "ServiceProvider");
        XmlSerializer localXmlSerializer9 = localXmlSerializer1.startTag("", "SPServiceRepository");
        XmlSerializer localXmlSerializer10 = localXmlSerializer1.startTag("", "PFService");
        XmlSerializer localXmlSerializer11 = localXmlSerializer1.attribute("", "type", "Common");
        XmlSerializer localXmlSerializer12 = localXmlSerializer1.attribute("", "cmd", "upgrade");
        XmlSerializer localXmlSerializer13 = localXmlSerializer1.startTag("", "ParamObj");
        XmlSerializer localXmlSerializer14 = localXmlSerializer1.attribute("", "name", "client");
        XmlSerializer localXmlSerializer15 = localXmlSerializer1.attribute("", "type", "String");
        if (!gt.c(paramContext))
          continue;
        XmlSerializer localXmlSerializer16 = localXmlSerializer1.text("lephone");
        XmlSerializer localXmlSerializer17 = localXmlSerializer1.endTag("", "ParamObj");
        XmlSerializer localXmlSerializer18 = localXmlSerializer1.startTag("", "ParamObj");
        XmlSerializer localXmlSerializer19 = localXmlSerializer1.attribute("", "name", "vip");
        XmlSerializer localXmlSerializer20 = localXmlSerializer1.attribute("", "type", "String");
        if (!gt.c(paramContext))
          break label400;
        XmlSerializer localXmlSerializer21 = localXmlSerializer1.text("true");
        XmlSerializer localXmlSerializer22 = localXmlSerializer1.endTag("", "ParamObj");
        XmlSerializer localXmlSerializer23 = localXmlSerializer1.endTag("", "PFService");
        XmlSerializer localXmlSerializer24 = localXmlSerializer1.endTag("", "SPServiceRepository");
        XmlSerializer localXmlSerializer25 = localXmlSerializer1.endTag("", "PFSMLService");
        fd.a(localXmlSerializer1);
        String str2 = localStringWriter.toString();
        gj.c(str2, "aotuUpdateCheckRequest.xml");
        return str2;
        if (gt.b(paramContext))
        {
          XmlSerializer localXmlSerializer26 = localXmlSerializer1.text("ophone");
          continue;
        }
      }
      catch (IOException localIOException)
      {
        throw new ek("自动升级请求错误");
      }
      XmlSerializer localXmlSerializer27 = localXmlSerializer1.text("android");
      continue;
      label400: if (gt.b(paramContext))
      {
        XmlSerializer localXmlSerializer28 = localXmlSerializer1.text("true");
        continue;
      }
      XmlSerializer localXmlSerializer29 = localXmlSerializer1.text("false");
    }
  }

  public fn a(Context paramContext)
  {
    String str = b(paramContext);
    gj.a(a, str);
    URI localURI = URI.create(gh.b);
    InputStream localInputStream = new fh(localURI).a(str);
    gj.a(localInputStream, "aotuUpdateCheckResponse.xml");
    Document localDocument = fd.a(localInputStream);
    fn localfn = a(localDocument);
    gz.a();
    return localfn;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fm
 * JD-Core Version:    0.6.0
 */