public class hc
{
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("<![CDATA[");
    StringBuilder localStringBuilder3 = localStringBuilder1.append(paramString);
    StringBuilder localStringBuilder4 = localStringBuilder1.append("]]>");
    return localStringBuilder1.toString();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hc
 * JD-Core Version:    0.6.0
 */