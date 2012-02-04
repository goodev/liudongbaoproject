public class gh
{
  public static boolean a = gg.a().f();
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  public static int k;
  public static int l;
  public static String m;

  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = gg.a().b();
    b = str1 + "/sync";
    StringBuilder localStringBuilder2 = new StringBuilder();
    String str2 = gg.a().b();
    c = str2 + "/sync/img";
    StringBuilder localStringBuilder3 = new StringBuilder();
    String str3 = gg.a().b();
    d = str3 + "/sync/upload";
    StringBuilder localStringBuilder4 = new StringBuilder();
    String str4 = gg.a().b();
    e = str4 + "/android/buyFlow.html";
    StringBuilder localStringBuilder5 = new StringBuilder();
    String str5 = gg.a().b();
    f = str5 + "/distribute-data?data=currency&exchange=";
    g = 0;
    h = 1;
    i = 2;
    j = 3;
    k = 4;
    m = "￥";
  }

  public static final boolean a(String paramString)
  {
    String str1;
    String str2;
    if (paramString.indexOf("/") != -1)
    {
      String[] arrayOfString = paramString.split("/");
      str1 = arrayOfString[0];
      str2 = arrayOfString[1];
    }
    while (true)
    {
      if (!str2.equals(""))
        str2 = "/" + str2;
      String str3 = "http://" + str1 + str2 + "/sync";
      String str4 = "http://" + str1 + str2 + "/sync/upload";
      String str5 = "http://" + str1 + str2 + "/sync/img";
      String str6 = "http://" + str1 + str2 + "/android/buyFlow.html";
      String str7 = "http://" + str1 + str2 + "/distribute-data?data=currency&exchange=";
      b = str3;
      d = str4;
      c = str5;
      e = str6;
      f = str7;
      g.a().h().b(paramString);
      return true;
      str2 = "";
      str1 = paramString;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gh
 * JD-Core Version:    0.6.0
 */