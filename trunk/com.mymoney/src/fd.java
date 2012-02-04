import android.util.Xml;
import java.io.InputStream;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlSerializer;

public class fd
{
  public static String a(String paramString1, String paramString2, Element paramElement)
  {
    return gx.a(paramElement.getElementsByTagName(paramString1).item(0).getAttributes().getNamedItem(paramString2).getNodeValue());
  }

  public static String a(String paramString, Element paramElement)
  {
    return gx.a(paramElement.getElementsByTagName(paramString).item(0).getFirstChild().getNodeValue());
  }

  public static final Document a(InputStream paramInputStream)
  {
    Object localObject = DocumentBuilderFactory.newInstance();
    try
    {
      localObject = ((DocumentBuilderFactory)localObject).newDocumentBuilder().parse(paramInputStream);
      paramInputStream.close();
      return localObject;
    }
    catch (Exception localException)
    {
    }
    throw new ek(localException);
  }

  public static XmlSerializer a(StringWriter paramStringWriter)
  {
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    localXmlSerializer.setOutput(paramStringWriter);
    Boolean localBoolean = Boolean.valueOf(1);
    localXmlSerializer.startDocument("UTF-8", localBoolean);
    return localXmlSerializer;
  }

  public static void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.endDocument();
  }

  public static Node b(String paramString, Element paramElement)
  {
    return paramElement.getElementsByTagName(paramString).item(0);
  }

  public static final XmlSerializer b(XmlSerializer paramXmlSerializer)
  {
    XmlSerializer localXmlSerializer1 = paramXmlSerializer.startTag("", "PFSMLService");
    String str = gg.a().h();
    XmlSerializer localXmlSerializer2 = paramXmlSerializer.attribute("", "protocolVersion", str);
    return paramXmlSerializer;
  }

  public static final XmlSerializer c(XmlSerializer paramXmlSerializer)
  {
    XmlSerializer localXmlSerializer = paramXmlSerializer.endTag("", "PFSMLService");
    return paramXmlSerializer;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fd
 * JD-Core Version:    0.6.0
 */