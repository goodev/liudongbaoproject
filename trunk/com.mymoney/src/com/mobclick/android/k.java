package com.mobclick.android;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class k
{
  private static String A;
  public static String a = "last_send_time";
  private static String b = "用户反馈";
  private static String c = "Feedback";
  private static String d = "欢迎您提出宝贵的意见和建议，您留下的每个字都将用来改善我们的服务。";
  private static String e = "Any comments and suggestions are welcome, we believe every word you write will benefit us";
  private static String f = "请输入您的反馈意见（字数500以内）";
  private static String g = "Input your suggestions here";
  private static String h = "提交反馈";
  private static String i = "Submit suggestions";
  private static String j = "请正确选择年龄和性别再提交";
  private static String k = "Please fill in a correct age and gender before submitting";
  private static String[] l;
  private static String[] m;
  private static String[] n;
  private static String[] o;
  private static String p;
  private static String q;
  private static String r;
  private static String s;
  private static String t;
  private static String u;
  private static String v;
  private static String w;
  private static String x;
  private static String y;
  private static String z;

  static
  {
    String[] arrayOfString1 = new String[9];
    arrayOfString1[0] = "年龄";
    arrayOfString1[1] = "18岁以下";
    arrayOfString1[2] = "18-24岁";
    arrayOfString1[3] = "25-30岁";
    arrayOfString1[4] = "31-35岁";
    arrayOfString1[5] = "36-40岁";
    arrayOfString1[6] = "41-50岁";
    arrayOfString1[7] = "51-59岁";
    arrayOfString1[8] = "60岁及60岁以上";
    l = arrayOfString1;
    String[] arrayOfString2 = new String[9];
    arrayOfString2[0] = "Age";
    arrayOfString2[1] = "<18";
    arrayOfString2[2] = "18~24";
    arrayOfString2[3] = "25~30";
    arrayOfString2[4] = "31~35";
    arrayOfString2[5] = "36~40";
    arrayOfString2[6] = "41~50";
    arrayOfString2[7] = "51~59";
    arrayOfString2[8] = ">=60";
    m = arrayOfString2;
    String[] arrayOfString3 = new String[3];
    arrayOfString3[0] = "性别";
    arrayOfString3[1] = "男";
    arrayOfString3[2] = "女";
    n = arrayOfString3;
    String[] arrayOfString4 = new String[3];
    arrayOfString4[0] = "Gender";
    arrayOfString4[1] = "Male";
    arrayOfString4[2] = "Female";
    o = arrayOfString4;
    p = "应用程序有新版本更新";
    q = "New version found";
    r = "最新版本: ";
    s = "Latest version: ";
    t = "立即更新";
    u = "Update now";
    v = "应用更新";
    w = "App updating";
    x = "正在更新应用程序...";
    y = "Updating application...";
    z = "以后再说";
    A = "Not now";
  }

  public static String A()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
  }

  public static int a(Date paramDate1, Date paramDate2)
  {
    Date localDate1;
    if (paramDate1.after(paramDate2))
      localDate1 = paramDate1;
    for (Date localDate2 = paramDate2; ; localDate2 = paramDate1)
    {
      long l1 = localDate2.getTime();
      return (int)((localDate1.getTime() - l1) / 86400000L);
      localDate1 = paramDate2;
    }
  }

  public static String a()
  {
    return b;
  }

  public static String a(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().locale.toString().equals("zh_CN"));
    for (String str = b; ; str = c)
      return str;
  }

  public static Date a(String paramString)
  {
    try
    {
      Date localDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(paramString);
      localDate2 = localDate1;
      return localDate2;
    }
    catch (Exception localException)
    {
      while (true)
        Date localDate2 = null;
    }
  }

  public static String b()
  {
    return c;
  }

  public static String b(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().locale.toString().equals("zh_CN"));
    for (String str = d; ; str = e)
      return str;
  }

  public static String c()
  {
    return d;
  }

  public static String c(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().locale.toString().equals("zh_CN"));
    for (String str = f; ; str = g)
      return str;
  }

  public static String d()
  {
    return e;
  }

  public static String d(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().locale.toString().equals("zh_CN"));
    for (String str = h; ; str = i)
      return str;
  }

  public static String e()
  {
    return f;
  }

  public static String e(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().locale.toString().equals("zh_CN"));
    for (String str = j; ; str = k)
      return str;
  }

  public static String f()
  {
    return g;
  }

  public static String[] f(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().locale.toString().equals("zh_CN"));
    for (String[] arrayOfString = l; ; arrayOfString = m)
      return arrayOfString;
  }

  public static String g()
  {
    return h;
  }

  public static String[] g(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().locale.toString().equals("zh_CN"));
    for (String[] arrayOfString = n; ; arrayOfString = o)
      return arrayOfString;
  }

  public static String h()
  {
    return i;
  }

  public static String h(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().locale.toString().equals("zh_CN"));
    for (String str = p; ; str = q)
      return str;
  }

  public static String i()
  {
    return j;
  }

  public static String i(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().locale.toString().equals("zh_CN"));
    for (String str = r; ; str = s)
      return str;
  }

  public static String j()
  {
    return k;
  }

  public static String j(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().locale.toString().equals("zh_CN"));
    for (String str = t; ; str = u)
      return str;
  }

  public static String k(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().locale.toString().equals("zh_CN"));
    for (String str = v; ; str = w)
      return str;
  }

  public static String[] k()
  {
    return l;
  }

  public static String l(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().locale.toString().equals("zh_CN"));
    for (String str = x; ; str = y)
      return str;
  }

  public static String[] l()
  {
    return m;
  }

  public static String m(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().locale.toString().equals("zh_CN"));
    for (String str = z; ; str = A)
      return str;
  }

  public static String[] m()
  {
    return n;
  }

  public static String[] n()
  {
    return o;
  }

  public static String o()
  {
    return p;
  }

  public static String p()
  {
    return q;
  }

  public static String q()
  {
    return r;
  }

  public static String r()
  {
    return s;
  }

  public static String s()
  {
    return t;
  }

  public static String t()
  {
    return u;
  }

  public static String u()
  {
    return v;
  }

  public static String v()
  {
    return w;
  }

  public static String w()
  {
    return x;
  }

  public static String x()
  {
    return y;
  }

  public static String y()
  {
    return z;
  }

  public static String z()
  {
    return A;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mobclick.android.k
 * JD-Core Version:    0.6.0
 */