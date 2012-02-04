public class gx
{
  public static final String a(Object paramObject)
  {
    String str1;
    if ((paramObject instanceof String))
    {
      str1 = (String)paramObject;
      if ((!a(str1)) && (!str1.equalsIgnoreCase("null")))
        break label41;
    }
    label41: for (String str2 = ""; ; str2 = str1.trim())
    {
      return str2;
      str1 = String.valueOf(paramObject);
      break;
    }
  }

  public static final boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static final String b(String paramString)
  {
    int i = paramString.indexOf(".");
    int j;
    if (i > 0)
      j = i + 1;
    for (String str = paramString.substring(j); ; str = paramString)
      return str;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gx
 * JD-Core Version:    0.6.0
 */