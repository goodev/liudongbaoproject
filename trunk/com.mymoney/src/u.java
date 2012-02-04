import java.math.BigDecimal;
import java.util.List;

public class u
{
  public static String a = "ReportNewServiceImpl";
  private static u b = null;
  private ba c = null;
  private m d = null;

  private u()
  {
    ba localba = ba.a();
    this.c = localba;
    m localm = g.a().b();
    this.d = localm;
  }

  public static u a()
  {
    if (b == null)
      b = new u();
    return b;
  }

  public BigDecimal a(String paramString)
  {
    return this.c.a(paramString);
  }

  public List a(hm paramhm)
  {
    List localList;
    switch (paramhm.d())
    {
    case 12:
    default:
      gj.a(a, "unsupport report type");
      localList = null;
    case 1:
    case 2:
    case 4:
    case 3:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 13:
    case 14:
    }
    while (true)
    {
      return localList;
      localList = b(paramhm);
      continue;
      localList = e(paramhm);
      continue;
      localList = f(paramhm);
      continue;
      localList = g(paramhm);
      continue;
      localList = h(paramhm);
      continue;
      localList = i(paramhm);
      continue;
      localList = j(paramhm);
      continue;
      String str1 = paramhm.f();
      localList = b(str1);
      continue;
      String str2 = paramhm.f();
      localList = d(str2);
      continue;
      localList = k(paramhm);
      continue;
      localList = l(paramhm);
      continue;
      localList = c(paramhm);
      continue;
      localList = d(paramhm);
    }
  }

  public List a(String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, long[] paramArrayOfLong5, String paramString2, String paramString3, String paramString4)
  {
    m localm = g.a().b();
    String str1 = paramString1;
    long l1 = paramLong1;
    long l2 = paramLong2;
    long l3 = paramArrayOfLong1;
    long[] arrayOfLong1 = paramArrayOfLong2;
    long[] arrayOfLong2 = paramArrayOfLong3;
    long[] arrayOfLong3 = paramArrayOfLong4;
    long[] arrayOfLong4 = paramArrayOfLong5;
    String str2 = paramString2;
    String str3 = paramString3;
    String str4 = paramString4;
    return localm.a(0, str1, l1, l2, l3, arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
  }

  public List b()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "1";
    arrayOfString[1] = "0";
    return he.a("select categoryPOID as id, name from t_category where depth = 1 and type in (0,1)", arrayOfString, null);
  }

  public List b(hm paramhm)
  {
    ba localba = this.c;
    String str1 = paramhm.f();
    long l1 = paramhm.g();
    long l2 = paramhm.h();
    long[] arrayOfLong1 = paramhm.i();
    long[] arrayOfLong2 = paramhm.j();
    long[] arrayOfLong3 = paramhm.k();
    long[] arrayOfLong4 = paramhm.l();
    String str2 = paramhm.m();
    String str3 = paramhm.n();
    String str4 = paramhm.o();
    return localba.a(str1, l1, l2, arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
  }

  public List b(String paramString)
  {
    return this.c.d(paramString);
  }

  public List b(String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, long[] paramArrayOfLong5, String paramString2, String paramString3, String paramString4)
  {
    m localm = this.d;
    String str1 = paramString1;
    long l1 = paramLong1;
    long l2 = paramLong2;
    long l3 = paramArrayOfLong1;
    long[] arrayOfLong1 = paramArrayOfLong2;
    long[] arrayOfLong2 = paramArrayOfLong3;
    long[] arrayOfLong3 = paramArrayOfLong4;
    long[] arrayOfLong4 = paramArrayOfLong5;
    String str2 = paramString2;
    String str3 = paramString3;
    String str4 = paramString4;
    return localm.a(1, str1, l1, l2, l3, arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
  }

  public BigDecimal c(String paramString)
  {
    return this.c.b(paramString);
  }

  public List c()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "1";
    arrayOfString[1] = "0";
    return he.a("select accountPOID as id, name from t_account", arrayOfString, null);
  }

  public List c(hm paramhm)
  {
    ba localba = this.c;
    String str1 = paramhm.f();
    long l1 = paramhm.g();
    long l2 = paramhm.h();
    long[] arrayOfLong1 = paramhm.i();
    long[] arrayOfLong2 = paramhm.j();
    long[] arrayOfLong3 = paramhm.k();
    long[] arrayOfLong4 = paramhm.l();
    String str2 = paramhm.m();
    String str3 = paramhm.n();
    String str4 = paramhm.o();
    return localba.b(str1, l1, l2, arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
  }

  public List d()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "1";
    arrayOfString[1] = "0";
    return he.a("select tradingEntityPOID as id, name from t_tradingEntity", arrayOfString, null);
  }

  public List d(hm paramhm)
  {
    ba localba = this.c;
    String str1 = paramhm.f();
    long l1 = paramhm.g();
    long l2 = paramhm.h();
    long[] arrayOfLong1 = paramhm.i();
    long[] arrayOfLong2 = paramhm.j();
    long[] arrayOfLong3 = paramhm.k();
    long[] arrayOfLong4 = paramhm.l();
    String str2 = paramhm.m();
    String str3 = paramhm.n();
    String str4 = paramhm.o();
    return localba.c(str1, l1, l2, arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
  }

  public List d(String paramString)
  {
    return this.c.e(paramString);
  }

  public List e()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "1";
    arrayOfString[1] = "0";
    return he.a("select tagPOID as id, name from t_tag where tagType = 1", arrayOfString, null);
  }

  public List e(hm paramhm)
  {
    ba localba = this.c;
    String str1 = paramhm.f();
    long l1 = paramhm.g();
    long l2 = paramhm.h();
    long[] arrayOfLong1 = paramhm.i();
    long[] arrayOfLong2 = paramhm.j();
    long[] arrayOfLong3 = paramhm.k();
    long[] arrayOfLong4 = paramhm.l();
    String str2 = paramhm.m();
    String str3 = paramhm.n();
    String str4 = paramhm.o();
    return localba.d(str1, l1, l2, arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
  }

  public List f(hm paramhm)
  {
    ba localba = this.c;
    String str1 = paramhm.f();
    long l1 = paramhm.g();
    long l2 = paramhm.h();
    long[] arrayOfLong1 = paramhm.i();
    long[] arrayOfLong2 = paramhm.j();
    long[] arrayOfLong3 = paramhm.k();
    long[] arrayOfLong4 = paramhm.l();
    String str2 = paramhm.m();
    String str3 = paramhm.n();
    String str4 = paramhm.o();
    return localba.e(str1, l1, l2, arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
  }

  public List g(hm paramhm)
  {
    ba localba = this.c;
    String str1 = paramhm.f();
    long l1 = paramhm.g();
    long l2 = paramhm.h();
    long[] arrayOfLong1 = paramhm.i();
    long[] arrayOfLong2 = paramhm.j();
    long[] arrayOfLong3 = paramhm.k();
    long[] arrayOfLong4 = paramhm.l();
    String str2 = paramhm.m();
    String str3 = paramhm.n();
    String str4 = paramhm.o();
    return localba.f(str1, l1, l2, arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
  }

  public List h(hm paramhm)
  {
    ba localba = this.c;
    String str1 = paramhm.f();
    long l1 = paramhm.g();
    long l2 = paramhm.h();
    long[] arrayOfLong1 = paramhm.i();
    long[] arrayOfLong2 = paramhm.j();
    long[] arrayOfLong3 = paramhm.k();
    long[] arrayOfLong4 = paramhm.l();
    String str2 = paramhm.m();
    String str3 = paramhm.n();
    String str4 = paramhm.o();
    return localba.g(str1, l1, l2, arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
  }

  public List i(hm paramhm)
  {
    ba localba = this.c;
    String str1 = paramhm.f();
    long l1 = paramhm.g();
    long l2 = paramhm.h();
    long[] arrayOfLong1 = paramhm.i();
    long[] arrayOfLong2 = paramhm.j();
    long[] arrayOfLong3 = paramhm.k();
    long[] arrayOfLong4 = paramhm.l();
    String str2 = paramhm.m();
    String str3 = paramhm.n();
    String str4 = paramhm.o();
    return localba.h(str1, l1, l2, arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
  }

  public List j(hm paramhm)
  {
    ba localba = this.c;
    String str1 = paramhm.f();
    long l1 = paramhm.g();
    long l2 = paramhm.h();
    long[] arrayOfLong1 = paramhm.i();
    long[] arrayOfLong2 = paramhm.j();
    long[] arrayOfLong3 = paramhm.k();
    long[] arrayOfLong4 = paramhm.l();
    String str2 = paramhm.m();
    String str3 = paramhm.n();
    String str4 = paramhm.o();
    return localba.i(str1, l1, l2, arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
  }

  public List k(hm paramhm)
  {
    ba localba = this.c;
    String str = paramhm.f();
    long l1 = paramhm.g();
    long l2 = paramhm.h();
    return localba.a(str, l1, l2);
  }

  public List l(hm paramhm)
  {
    ba localba = this.c;
    String str = paramhm.f();
    long l1 = paramhm.g();
    long l2 = paramhm.h();
    return localba.b(str, l1, l2);
  }

  public List m(hm paramhm)
  {
    long l1 = paramhm.e();
    1[0] = l1;
    List localList;
    switch (paramhm.d())
    {
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 12:
    default:
      String str1 = paramhm.f();
      long l2 = paramhm.g();
      long l3 = paramhm.h();
      long[] arrayOfLong1 = paramhm.i();
      long[] arrayOfLong2 = paramhm.j();
      long[] arrayOfLong3 = paramhm.k();
      long[] arrayOfLong4 = paramhm.l();
      String str2 = paramhm.m();
      String str3 = paramhm.n();
      String str4 = paramhm.o();
      localList = a(str1, l2, l3, arrayOfLong1, null, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
    case 1:
    case 13:
    case 2:
    case 4:
    case 3:
    case 11:
    }
    while (true)
    {
      return localList;
      String str5 = paramhm.f();
      long l4 = paramhm.g();
      long l5 = paramhm.h();
      long[] arrayOfLong5 = paramhm.j();
      long[] arrayOfLong6 = paramhm.k();
      long[] arrayOfLong7 = paramhm.l();
      String str6 = paramhm.m();
      String str7 = paramhm.n();
      String str8 = paramhm.o();
      localList = a(str5, l4, l5, null, null, arrayOfLong5, arrayOfLong6, arrayOfLong7, str6, str7, str8);
      continue;
      String str9 = paramhm.f();
      long l6 = paramhm.g();
      long l7 = paramhm.h();
      long[] arrayOfLong8 = paramhm.j();
      long[] arrayOfLong9 = paramhm.k();
      long[] arrayOfLong10 = paramhm.l();
      String str10 = paramhm.m();
      String str11 = paramhm.n();
      String str12 = paramhm.o();
      u localu1 = this;
      long[] arrayOfLong11 = null;
      localList = localu1.a(str9, l6, l7, null, arrayOfLong11, arrayOfLong8, arrayOfLong9, arrayOfLong10, str10, str11, str12);
      continue;
      String str13 = paramhm.f();
      long l8 = paramhm.g();
      long l9 = paramhm.h();
      long[] arrayOfLong12 = paramhm.i();
      long[] arrayOfLong13 = paramhm.k();
      long[] arrayOfLong14 = paramhm.l();
      String str14 = paramhm.m();
      String str15 = paramhm.n();
      String str16 = paramhm.o();
      u localu2 = this;
      long[] arrayOfLong15 = null;
      localList = localu2.a(str13, l8, l9, arrayOfLong12, null, arrayOfLong15, arrayOfLong13, arrayOfLong14, str14, str15, str16);
      continue;
      String str17 = paramhm.f();
      long l10 = paramhm.g();
      long l11 = paramhm.h();
      long[] arrayOfLong16 = paramhm.i();
      long[] arrayOfLong17 = paramhm.j();
      long[] arrayOfLong18 = paramhm.k();
      String str18 = paramhm.m();
      String str19 = paramhm.n();
      String str20 = paramhm.o();
      u localu3 = this;
      long[] arrayOfLong19 = null;
      localList = localu3.a(str17, l10, l11, arrayOfLong16, null, arrayOfLong17, arrayOfLong18, arrayOfLong19, str18, str19, str20);
      continue;
      String str21 = paramhm.f();
      long l12 = paramhm.g();
      long l13 = paramhm.h();
      long[] arrayOfLong20 = paramhm.i();
      long[] arrayOfLong21 = paramhm.j();
      long[] arrayOfLong22 = paramhm.l();
      String str22 = paramhm.m();
      String str23 = paramhm.n();
      String str24 = paramhm.o();
      u localu4 = this;
      long[] arrayOfLong23 = null;
      localList = localu4.a(str21, l12, l13, arrayOfLong20, null, arrayOfLong21, arrayOfLong23, arrayOfLong22, str22, str23, str24);
      continue;
      String str25 = paramhm.f();
      long l14 = paramhm.r();
      long l15 = paramhm.s();
      long[] arrayOfLong24 = paramhm.i();
      long[] arrayOfLong25 = paramhm.j();
      long[] arrayOfLong26 = paramhm.k();
      long[] arrayOfLong27 = paramhm.l();
      String str26 = paramhm.m();
      String str27 = paramhm.n();
      String str28 = paramhm.o();
      localList = a(str25, l14, l15, arrayOfLong24, null, arrayOfLong25, arrayOfLong26, arrayOfLong27, str26, str27, str28);
    }
  }

  public List n(hm paramhm)
  {
    long l1 = paramhm.e();
    1[0] = l1;
    List localList;
    switch (paramhm.d())
    {
    case 8:
    case 9:
    case 11:
    case 12:
    case 13:
    default:
      String str1 = paramhm.f();
      long l2 = paramhm.g();
      long l3 = paramhm.h();
      long[] arrayOfLong1 = paramhm.i();
      long[] arrayOfLong2 = paramhm.j();
      long[] arrayOfLong3 = paramhm.k();
      long[] arrayOfLong4 = paramhm.l();
      String str2 = paramhm.m();
      String str3 = paramhm.n();
      String str4 = paramhm.o();
      localList = b(str1, l2, l3, arrayOfLong1, null, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
    case 5:
    case 14:
    case 6:
    case 7:
    case 10:
    }
    while (true)
    {
      return localList;
      String str5 = paramhm.f();
      long l4 = paramhm.g();
      long l5 = paramhm.h();
      long[] arrayOfLong5 = paramhm.j();
      long[] arrayOfLong6 = paramhm.k();
      long[] arrayOfLong7 = paramhm.l();
      String str6 = paramhm.m();
      String str7 = paramhm.n();
      String str8 = paramhm.o();
      localList = b(str5, l4, l5, null, null, arrayOfLong5, arrayOfLong6, arrayOfLong7, str6, str7, str8);
      continue;
      String str9 = paramhm.f();
      long l6 = paramhm.g();
      long l7 = paramhm.h();
      long[] arrayOfLong8 = paramhm.j();
      long[] arrayOfLong9 = paramhm.k();
      long[] arrayOfLong10 = paramhm.l();
      String str10 = paramhm.m();
      String str11 = paramhm.n();
      String str12 = paramhm.o();
      u localu1 = this;
      long[] arrayOfLong11 = null;
      localList = localu1.b(str9, l6, l7, null, arrayOfLong11, arrayOfLong8, arrayOfLong9, arrayOfLong10, str10, str11, str12);
      continue;
      String str13 = paramhm.f();
      long l8 = paramhm.g();
      long l9 = paramhm.h();
      long[] arrayOfLong12 = paramhm.i();
      long[] arrayOfLong13 = paramhm.k();
      long[] arrayOfLong14 = paramhm.l();
      String str14 = paramhm.m();
      String str15 = paramhm.n();
      String str16 = paramhm.o();
      u localu2 = this;
      long[] arrayOfLong15 = null;
      localList = localu2.b(str13, l8, l9, arrayOfLong12, null, arrayOfLong15, arrayOfLong13, arrayOfLong14, str14, str15, str16);
      continue;
      String str17 = paramhm.f();
      long l10 = paramhm.g();
      long l11 = paramhm.h();
      long[] arrayOfLong16 = paramhm.i();
      long[] arrayOfLong17 = paramhm.j();
      long[] arrayOfLong18 = paramhm.l();
      String str18 = paramhm.m();
      String str19 = paramhm.n();
      String str20 = paramhm.o();
      u localu3 = this;
      long[] arrayOfLong19 = null;
      localList = localu3.b(str17, l10, l11, arrayOfLong16, null, arrayOfLong17, arrayOfLong19, arrayOfLong18, str18, str19, str20);
      continue;
      String str21 = paramhm.f();
      long l12 = paramhm.r();
      long l13 = paramhm.s();
      long[] arrayOfLong20 = paramhm.i();
      long[] arrayOfLong21 = paramhm.j();
      long[] arrayOfLong22 = paramhm.k();
      long[] arrayOfLong23 = paramhm.l();
      String str22 = paramhm.m();
      String str23 = paramhm.n();
      String str24 = paramhm.o();
      localList = b(str21, l12, l13, arrayOfLong20, null, arrayOfLong21, arrayOfLong22, arrayOfLong23, str22, str23, str24);
    }
  }

  public List o(hm paramhm)
  {
    m localm = g.a().b();
    String str1 = paramhm.f();
    long l1 = paramhm.g();
    long l2 = paramhm.h();
    long[] arrayOfLong1 = paramhm.i();
    long[] arrayOfLong2 = paramhm.j();
    long[] arrayOfLong3 = paramhm.k();
    long[] arrayOfLong4 = paramhm.l();
    String str2 = paramhm.m();
    String str3 = paramhm.n();
    String str4 = paramhm.o();
    return localm.a(-1, str1, l1, l2, arrayOfLong1, null, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     u
 * JD-Core Version:    0.6.0
 */