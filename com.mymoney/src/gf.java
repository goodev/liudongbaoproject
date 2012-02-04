import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;

public class gf
{
  private static final SimpleDateFormat i = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
  private static final SimpleDateFormat j = new SimpleDateFormat("dd-MMM-yyyy");
  private Writer a;
  private PrintWriter b;
  private char c;
  private char d;
  private char e;
  private String f;
  private int g;
  private StringBuffer h;

  public gf(Writer paramWriter)
  {
    this(paramWriter, 44);
  }

  public gf(Writer paramWriter, char paramChar)
  {
    this(paramWriter, paramChar, 34);
  }

  public gf(Writer paramWriter, char paramChar1, char paramChar2)
  {
    this(paramWriter, paramChar1, paramChar2, 34);
  }

  public gf(Writer paramWriter, char paramChar1, char paramChar2, char paramChar3)
  {
  }

  public gf(Writer paramWriter, char paramChar1, char paramChar2, char paramChar3, String paramString)
  {
    this.a = paramWriter;
    PrintWriter localPrintWriter = new PrintWriter(paramWriter);
    this.b = localPrintWriter;
    this.c = paramChar1;
    this.d = paramChar2;
    this.e = paramChar3;
    this.f = paramString;
    this.g = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    this.h = localStringBuffer;
  }

  public void a()
  {
    StringBuffer localStringBuffer1 = this.h;
    String str1 = this.f;
    StringBuffer localStringBuffer2 = localStringBuffer1.append(str1);
    PrintWriter localPrintWriter = this.b;
    String str2 = this.h.toString();
    localPrintWriter.write(str2);
    StringBuffer localStringBuffer3 = this.h;
    int k = this.h.length();
    StringBuffer localStringBuffer4 = localStringBuffer3.delete(0, k);
    this.g = 0;
  }

  public void a(String paramString)
  {
    this.f = paramString;
  }

  public void a(String paramString, boolean paramBoolean)
  {
    String str1 = "";
    if (this.g > 0)
    {
      StringBuffer localStringBuffer1 = this.h;
      char c2 = this.c;
      StringBuffer localStringBuffer2 = localStringBuffer1.append(c2);
    }
    int k = this.g + 1;
    this.g = k;
    if (paramString == null)
      return;
    if (this.d != 0)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("");
      char c3 = this.d;
      String str2 = c3;
      if (paramString.contains(str2));
    }
    else
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append("");
      char c4 = this.c;
      String str3 = c4;
      if (!paramString.contains(str3))
        if (this.e != 0)
        {
          StringBuilder localStringBuilder3 = new StringBuilder().append("");
          char c5 = this.e;
          String str4 = c5;
          if (paramString.contains(str4));
        }
        else
        {
          StringBuilder localStringBuilder4 = new StringBuilder().append("");
          String str5 = this.f;
          String str6 = str5;
          if (!paramString.contains(str6))
            break label436;
        }
    }
    label436: for (boolean bool = true; ; bool = paramBoolean)
    {
      if ((this.d != 0) && (bool))
      {
        StringBuffer localStringBuffer3 = this.h;
        char c6 = this.d;
        StringBuffer localStringBuffer4 = localStringBuffer3.append(c6);
      }
      int m = 0;
      int n = paramString.length();
      if (m < n)
      {
        char c1 = paramString.charAt(m);
        if (this.e != 0)
        {
          char c7 = this.d;
          if (c1 == c7)
          {
            StringBuffer localStringBuffer5 = this.h;
            char c8 = this.e;
            StringBuffer localStringBuffer6 = localStringBuffer5.append(c8).append(c1);
          }
        }
        while (true)
        {
          m += 1;
          break;
          if (this.e != 0)
          {
            char c9 = this.e;
            if (c1 == c9)
            {
              StringBuffer localStringBuffer7 = this.h;
              char c10 = this.e;
              StringBuffer localStringBuffer8 = localStringBuffer7.append(c10).append(c1);
              continue;
            }
          }
          StringBuffer localStringBuffer9 = this.h.append(c1);
        }
      }
      if (this.d == 0)
        return;
      if (!bool)
        return;
      StringBuffer localStringBuffer10 = this.h;
      char c11 = this.d;
      StringBuffer localStringBuffer11 = localStringBuffer10.append(c11);
      return;
    }
  }

  public void b()
  {
    this.b.flush();
    this.b.close();
    this.a.close();
  }

  public void b(String paramString)
  {
    a(paramString, 1);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gf
 * JD-Core Version:    0.6.0
 */