import java.io.InputStream;
import java.io.StringWriter;
import java.net.URI;
import org.xmlpull.v1.XmlSerializer;

public class ft
{
  public String a = "SignInService";

  private String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new StringWriter();
    try
    {
      XmlSerializer localXmlSerializer1 = fd.a((StringWriter)localObject);
      XmlSerializer localXmlSerializer2 = localXmlSerializer1.startTag("", "PFSMLService");
      String str1 = gg.a().h();
      XmlSerializer localXmlSerializer3 = localXmlSerializer1.attribute("", "protocolVersion", str1);
      XmlSerializer localXmlSerializer4 = localXmlSerializer1.startTag("", "ServiceProvider");
      XmlSerializer localXmlSerializer5 = localXmlSerializer1.startTag("", "Provider");
      XmlSerializer localXmlSerializer6 = localXmlSerializer1.attribute("", "id", "android");
      XmlSerializer localXmlSerializer7 = localXmlSerializer1.text(paramString3);
      XmlSerializer localXmlSerializer8 = localXmlSerializer1.endTag("", "Provider");
      XmlSerializer localXmlSerializer9 = localXmlSerializer1.endTag("", "ServiceProvider");
      XmlSerializer localXmlSerializer10 = localXmlSerializer1.startTag("", "SPServiceRepository");
      XmlSerializer localXmlSerializer11 = localXmlSerializer1.startTag("", "PFService");
      XmlSerializer localXmlSerializer12 = localXmlSerializer1.attribute("", "cmd", "signIn");
      XmlSerializer localXmlSerializer13 = localXmlSerializer1.startTag("", "ParamObj");
      XmlSerializer localXmlSerializer14 = localXmlSerializer1.attribute("", "type", "String");
      XmlSerializer localXmlSerializer15 = localXmlSerializer1.attribute("", "name", "username");
      XmlSerializer localXmlSerializer16 = localXmlSerializer1.text(paramString1);
      XmlSerializer localXmlSerializer17 = localXmlSerializer1.endTag("", "ParamObj");
      XmlSerializer localXmlSerializer18 = localXmlSerializer1.startTag("", "ParamObj");
      XmlSerializer localXmlSerializer19 = localXmlSerializer1.attribute("", "type", "String");
      XmlSerializer localXmlSerializer20 = localXmlSerializer1.attribute("", "name", "password");
      XmlSerializer localXmlSerializer21 = localXmlSerializer1.text(paramString2);
      XmlSerializer localXmlSerializer22 = localXmlSerializer1.endTag("", "ParamObj");
      XmlSerializer localXmlSerializer23 = localXmlSerializer1.endTag("", "PFService");
      XmlSerializer localXmlSerializer24 = localXmlSerializer1.endTag("", "SPServiceRepository");
      XmlSerializer localXmlSerializer25 = localXmlSerializer1.endTag("", "PFSMLService");
      fd.a(localXmlSerializer1);
      String str2 = ((StringWriter)localObject).toString();
      localObject = str2;
      gj.c((String)localObject, "SignInRequest.xml");
      return localObject;
    }
    catch (Exception localException)
    {
      while (true)
        localObject = "";
    }
  }

  public void a(String paramString1, String paramString2)
  {
    try
    {
      String str1 = gt.p();
      String str2 = gk.a(paramString2);
      String str3 = a(paramString1, str2, str1);
      URI localURI = URI.create(gh.b);
      InputStream localInputStream = new fh(localURI).a(str3);
      return;
    }
    catch (ek localek)
    {
      localek.printStackTrace();
      return;
    }
    catch (ef localef)
    {
      localef.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ft
 * JD-Core Version:    0.6.0
 */