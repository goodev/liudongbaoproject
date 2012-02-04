import android.database.Cursor;
import android.database.MatrixCursor;
import android.text.TextUtils;
import android.util.Log;
import com.mymoney.core.application.ApplicationContext;
import com.mymoney.core.vo.AccountGroupVo;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.core.vo.CorporationVo;
import com.mymoney.core.vo.ProjectVo;
import com.mymoney.core.vo.TransactionVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class z
  implements m
{
  public static String a = "TransactionServiceImpl";
  private h b;
  private an c;
  private ba d;

  public z()
  {
    h localh = g.a().d();
    this.b = localh;
    an localan = ai.a().b();
    this.c = localan;
    ba localba = ba.a();
    this.d = localba;
  }

  private TransactionVo a(fb paramfb, boolean paramBoolean)
  {
    Object localObject = paramfb.b();
    int i;
    AccountVo localAccountVo1;
    AccountVo localAccountVo2;
    CorporationVo localCorporationVo;
    eq localeq1;
    eq localeq2;
    if (paramBoolean)
    {
      h localh = this.b;
      long l1 = ((et)localObject).b();
      localObject = localh.d(l1);
      i = paramfb.d();
      localAccountVo1 = new AccountVo();
      localAccountVo2 = null;
      localCorporationVo = new CorporationVo();
      localeq1 = paramfb.q();
      localeq2 = paramfb.r();
      if (i != 0)
        break label493;
      long l2 = localeq1.f();
      localAccountVo1.a(l2);
      String str1 = localeq1.g();
      localAccountVo1.a(str1);
      String str2 = localeq1.h();
      localAccountVo1.b(str2);
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str3 = localeq1.g();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str3).append("(");
      String str4 = localeq1.h();
      String str5 = str4 + ")";
      localAccountVo1.d(str5);
      long l3 = paramfb.s().b();
      localCorporationVo.a(l3);
      String str6 = paramfb.s().c();
      localCorporationVo.a(str6);
    }
    while (true)
    {
      ProjectVo localProjectVo = new ProjectVo();
      long l4 = paramfb.g().a();
      localProjectVo.a(l4);
      String str7 = paramfb.g().b();
      localProjectVo.a(str7);
      TransactionVo localTransactionVo = new TransactionVo();
      long l5 = paramfb.a();
      localTransactionVo.a(l5);
      localTransactionVo.a(i);
      String str8 = paramfb.k();
      localTransactionVo.d(str8);
      double d1 = paramfb.n();
      localTransactionVo.a(d1);
      String str9 = paramfb.t();
      localTransactionVo.c(str9);
      boolean bool1 = paramfb.v();
      localTransactionVo.b(bool1);
      double d2 = paramfb.u();
      localTransactionVo.b(d2);
      String str10 = paramfb.f();
      localTransactionVo.a(str10);
      String str11 = paramfb.j();
      localTransactionVo.b(str11);
      boolean bool2 = paramfb.l();
      localTransactionVo.a(bool2);
      long l6 = paramfb.h();
      localTransactionVo.b(l6);
      localTransactionVo.a((CategoryVo)localObject);
      localTransactionVo.a(localCorporationVo);
      localTransactionVo.a(localAccountVo1);
      if (localAccountVo2 != null)
        localTransactionVo.b(localAccountVo2);
      localTransactionVo.a(localProjectVo);
      return localTransactionVo;
      CategoryVo localCategoryVo = new CategoryVo();
      long l7 = ((et)localObject).b();
      localCategoryVo.a(l7);
      String str12 = ((et)localObject).c();
      localCategoryVo.a(str12);
      String str13 = ((et)localObject).i();
      localCategoryVo.b(str13);
      localObject = localCategoryVo;
      break;
      label493: if (i == 1)
      {
        long l8 = localeq2.f();
        localAccountVo1.a(l8);
        String str14 = localeq2.g();
        localAccountVo1.a(str14);
        String str15 = localeq2.h();
        localAccountVo1.b(str15);
        StringBuilder localStringBuilder3 = new StringBuilder();
        String str16 = localeq2.g();
        StringBuilder localStringBuilder4 = localStringBuilder3.append(str16).append("(");
        String str17 = localeq2.h();
        String str18 = str17 + ")";
        localAccountVo1.d(str18);
        continue;
      }
      if (3 == i)
      {
        long l9 = localeq1.f();
        localAccountVo1.a(l9);
        String str19 = localeq1.g();
        localAccountVo1.a(str19);
        String str20 = localeq1.h();
        localAccountVo1.b(str20);
        StringBuilder localStringBuilder5 = new StringBuilder();
        String str21 = localeq1.g();
        StringBuilder localStringBuilder6 = localStringBuilder5.append(str21).append("(");
        String str22 = localeq1.h();
        String str23 = str22 + ")";
        localAccountVo1.d(str23);
        localAccountVo2 = new AccountVo();
        long l10 = localeq2.f();
        localAccountVo2.a(l10);
        String str24 = localeq2.g();
        localAccountVo2.a(str24);
        String str25 = localeq2.h();
        localAccountVo2.b(str25);
        StringBuilder localStringBuilder7 = new StringBuilder();
        String str26 = localeq2.g();
        StringBuilder localStringBuilder8 = localStringBuilder7.append(str26).append("(");
        String str27 = localeq2.h();
        String str28 = str27 + ")";
        localAccountVo2.d(str28);
        continue;
      }
      if ((5 == i) || (7 == i))
      {
        long l11 = localeq1.f();
        localAccountVo1.a(l11);
        String str29 = localeq1.g();
        localAccountVo1.a(str29);
        String str30 = localeq1.h();
        localAccountVo1.b(str30);
        StringBuilder localStringBuilder9 = new StringBuilder();
        String str31 = localeq1.g();
        StringBuilder localStringBuilder10 = localStringBuilder9.append(str31).append("(");
        String str32 = localeq1.h();
        String str33 = str32 + ")";
        localAccountVo1.d(str33);
        continue;
      }
      if ((i == 2) || (8 == i) || (9 == i) || (10 == i) || (4 == i) || (6 == i))
      {
        long l12 = localeq2.f();
        localAccountVo1.a(l12);
        String str34 = localeq2.g();
        localAccountVo1.a(str34);
        String str35 = localeq2.h();
        localAccountVo1.b(str35);
        StringBuilder localStringBuilder11 = new StringBuilder();
        String str36 = localeq2.g();
        StringBuilder localStringBuilder12 = localStringBuilder11.append(str36).append("(");
        String str37 = localeq2.h();
        String str38 = str37 + ")";
        localAccountVo1.d(str38);
        continue;
      }
      long l13 = localeq1.f();
      localAccountVo1.a(l13);
      String str39 = localeq1.g();
      localAccountVo1.a(str39);
      String str40 = localeq1.h();
      localAccountVo1.b(str40);
      StringBuilder localStringBuilder13 = new StringBuilder();
      String str41 = localeq1.g();
      StringBuilder localStringBuilder14 = localStringBuilder13.append(str41).append("(");
      String str42 = localeq1.h();
      String str43 = str42 + ")";
      localAccountVo1.d(str43);
    }
  }

  private List a(List paramList)
  {
    int i = paramList.size();
    ArrayList localArrayList = new ArrayList(i);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      fb localfb = (fb)localIterator.next();
      TransactionVo localTransactionVo = a(localfb, 0);
      boolean bool = localArrayList.add(localTransactionVo);
    }
    return localArrayList;
  }

  private boolean a(double paramDouble1, AccountVo paramAccountVo1, double paramDouble2, AccountVo paramAccountVo2, long paramLong, ProjectVo paramProjectVo, String paramString1, String paramString2)
  {
    String str1 = paramAccountVo1.d();
    z localz1 = this;
    AccountVo localAccountVo1 = paramAccountVo1;
    double d1 = paramAccountVo2;
    double d2 = paramDouble1;
    ProjectVo localProjectVo1 = paramProjectVo;
    long l1 = paramString1;
    String str2 = paramString2;
    long l2 = paramLong;
    boolean bool = localz1.a(3, localAccountVo1, d1, d2, str1, localProjectVo1, l1, str2, l2);
    String str3 = paramAccountVo2.d();
    z localz2 = this;
    AccountVo localAccountVo2 = paramAccountVo1;
    double d3 = paramAccountVo2;
    double d4 = paramDouble2;
    ProjectVo localProjectVo2 = paramProjectVo;
    long l3 = paramString1;
    String str4 = paramString2;
    long l4 = paramLong;
    return localz2.a(2, localAccountVo2, d3, d4, str3, localProjectVo2, l3, str4, l4);
  }

  private boolean a(int paramInt, AccountVo paramAccountVo1, AccountVo paramAccountVo2, double paramDouble, String paramString1, ProjectVo paramProjectVo, String paramString2, String paramString3, long paramLong)
  {
    TransactionVo localTransactionVo = new TransactionVo();
    localTransactionVo.a(paramInt);
    localTransactionVo.b(paramLong);
    localTransactionVo.a(paramAccountVo1);
    localTransactionVo.b(paramAccountVo2);
    localTransactionVo.a(paramDouble);
    localTransactionVo.b(paramLong);
    localTransactionVo.c(paramString1);
    localTransactionVo.a(paramProjectVo);
    localTransactionVo.a(paramString2);
    localTransactionVo.d(paramString3);
    if (b(localTransactionVo, paramInt) != 0L);
    for (int i = 1; ; i = 0)
      return i;
  }

  private long b(TransactionVo paramTransactionVo, int paramInt)
  {
    gu.d(0);
    long l1 = gt.a();
    eq localeq1 = new eq();
    eq localeq2 = new eq();
    eu localeu = new eu();
    if (paramInt == 0)
    {
      long l2 = paramTransactionVo.g().a();
      localeq1.b(l2);
      long l3 = paramTransactionVo.h().a();
      localeu.a(l3);
      localeq2.b(0L);
    }
    while (true)
    {
      fb localfb = new fb();
      localfb.b(l1);
      localfb.c(l1);
      long l4 = paramTransactionVo.j();
      localfb.d(l4);
      localfb.b(paramInt);
      String str1 = paramTransactionVo.c();
      localfb.a(str1);
      String str2 = paramTransactionVo.d();
      localfb.b(str2);
      boolean bool = paramTransactionVo.e();
      localfb.a(bool);
      localfb.a(localeq1);
      localfb.b(localeq2);
      localfb.a(localeu);
      String str3 = paramTransactionVo.o();
      localfb.c(str3);
      double d1 = paramTransactionVo.b();
      localfb.b(d1);
      double d2 = paramTransactionVo.b();
      localfb.c(d2);
      if (paramInt == 0)
      {
        long l5 = CategoryVo.a(paramTransactionVo.f());
        localfb.f(l5);
        localfb.e(0L);
      }
      if (paramInt == 1)
      {
        long l6 = CategoryVo.a(paramTransactionVo.f());
        localfb.e(l6);
        localfb.f(0L);
      }
      try
      {
        dj.a();
        long l7 = this.c.a(localfb);
        if ((paramTransactionVo.i() != null) && (paramTransactionVo.i().a() != 0L))
        {
          long l8 = paramTransactionVo.i().a();
          long l9 = this.c.a(l7, l8);
        }
        dj.b();
        dj.c();
        return l7;
        if (1 == paramInt)
        {
          localeq1.b(0L);
          long l10 = paramTransactionVo.g().a();
          localeq2.b(l10);
          continue;
        }
        if ((8 == paramInt) || (9 == paramInt) || (10 == paramInt))
        {
          long l11 = paramTransactionVo.g().a();
          localeq2.b(l11);
          continue;
        }
        if ((2 == paramInt) || (3 == paramInt))
        {
          long l12 = paramTransactionVo.g().a();
          localeq1.b(l12);
          long l13 = paramTransactionVo.p().a();
          localeq2.b(l13);
          continue;
        }
        if ((4 == paramInt) || (6 == paramInt))
        {
          long l14 = paramTransactionVo.p().a();
          localeq2.b(l14);
          continue;
        }
        if ((5 == paramInt) || (7 == paramInt))
        {
          long l15 = paramTransactionVo.g().a();
          localeq1.b(l15);
          continue;
        }
        throw new IllegalArgumentException("unsupport this type transaction");
      }
      finally
      {
      }
    }
    throw localObject;
  }

  private fb b(TransactionVo paramTransactionVo)
  {
    long l1 = paramTransactionVo.a();
    double d1 = paramTransactionVo.b();
    int i = paramTransactionVo.k();
    String str1 = paramTransactionVo.c();
    String str2 = paramTransactionVo.d();
    boolean bool1 = paramTransactionVo.e();
    long l2 = paramTransactionVo.j();
    CategoryVo localCategoryVo = paramTransactionVo.f();
    AccountVo localAccountVo = paramTransactionVo.g();
    CorporationVo localCorporationVo = paramTransactionVo.h();
    ProjectVo localProjectVo = paramTransactionVo.i();
    long l3 = CategoryVo.a(localCategoryVo);
    long l4 = localAccountVo.a();
    fb localfb1 = new fb();
    if (i == 0)
    {
      long l5 = localCorporationVo.a();
      eq localeq1 = new eq(l4);
      fb localfb2 = localfb1;
      eq localeq2 = localeq1;
      localfb2.a(localeq2);
      eu localeu1 = new eu;
      eu localeu2 = localeu1;
      long l6 = l5;
      localeu2.<init>(l6);
      fb localfb3 = localfb1;
      eu localeu3 = localeu1;
      localfb3.a(localeu3);
      fb localfb4 = localfb1;
      long l7 = l3;
      localfb4.f(l7);
    }
    while (true)
    {
      fb localfb5 = localfb1;
      long l8 = l1;
      localfb5.a(l8);
      fb localfb6 = localfb1;
      int j = i;
      localfb6.b(j);
      fb localfb7 = localfb1;
      long l9 = l2;
      localfb7.d(l9);
      fb localfb8 = localfb1;
      String str3 = str1;
      localfb8.a(str3);
      fb localfb9 = localfb1;
      String str4 = str2;
      localfb9.b(str4);
      fb localfb10 = localfb1;
      boolean bool2 = bool1;
      localfb10.a(bool2);
      if (localProjectVo != null)
      {
        long l10 = localProjectVo.a();
        String str5 = localProjectVo.b();
        fa localfa1 = new fa(l10, str5);
        fb localfb11 = localfb1;
        fa localfa2 = localfa1;
        localfb11.a(localfa2);
      }
      fb localfb12 = localfb1;
      double d2 = d1;
      localfb12.c(d2);
      fb localfb13 = localfb1;
      double d3 = d1;
      localfb13.b(d3);
      return localfb1;
      if (i != 1)
        continue;
      eq localeq3 = new eq(l4);
      fb localfb14 = localfb1;
      eq localeq4 = localeq3;
      localfb14.b(localeq4);
      fb localfb15 = localfb1;
      long l11 = l3;
      localfb15.e(l11);
    }
  }

  private boolean b(double paramDouble1, AccountVo paramAccountVo1, double paramDouble2, AccountVo paramAccountVo2, long paramLong, ProjectVo paramProjectVo, String paramString1, String paramString2)
  {
    String str1 = paramAccountVo1.d();
    z localz1 = this;
    double d1 = paramAccountVo2;
    AccountVo localAccountVo1 = paramAccountVo1;
    double d2 = paramDouble1;
    ProjectVo localProjectVo1 = paramProjectVo;
    long l1 = paramString1;
    String str2 = paramString2;
    long l2 = paramLong;
    boolean bool1 = localz1.a(4, d1, localAccountVo1, d2, str1, localProjectVo1, l1, str2, l2);
    String str3 = paramAccountVo1.d();
    z localz2 = this;
    AccountVo localAccountVo2 = paramAccountVo1;
    double d3 = paramAccountVo2;
    double d4 = paramDouble1;
    ProjectVo localProjectVo2 = paramProjectVo;
    long l3 = paramString1;
    String str4 = paramString2;
    long l4 = paramLong;
    boolean bool2 = localz2.a(3, localAccountVo2, d3, d4, str3, localProjectVo2, l3, str4, l4);
    String str5 = paramAccountVo2.d();
    z localz3 = this;
    AccountVo localAccountVo3 = paramAccountVo1;
    double d5 = paramAccountVo2;
    double d6 = paramDouble2;
    ProjectVo localProjectVo3 = paramProjectVo;
    long l5 = paramString1;
    String str6 = paramString2;
    long l6 = paramLong;
    return localz3.a(2, localAccountVo3, d5, d6, str5, localProjectVo3, l5, str6, l6);
  }

  private boolean c(double paramDouble1, AccountVo paramAccountVo1, double paramDouble2, AccountVo paramAccountVo2, long paramLong, ProjectVo paramProjectVo, String paramString1, String paramString2)
  {
    String str1 = paramAccountVo2.d();
    z localz1 = this;
    double d1 = paramAccountVo2;
    AccountVo localAccountVo1 = paramAccountVo1;
    double d2 = paramDouble2;
    ProjectVo localProjectVo1 = paramProjectVo;
    long l1 = paramString1;
    String str2 = paramString2;
    long l2 = paramLong;
    boolean bool1 = localz1.a(5, d1, localAccountVo1, d2, str1, localProjectVo1, l1, str2, l2);
    String str3 = paramAccountVo1.d();
    z localz2 = this;
    AccountVo localAccountVo2 = paramAccountVo1;
    double d3 = paramAccountVo2;
    double d4 = paramDouble1;
    ProjectVo localProjectVo2 = paramProjectVo;
    long l3 = paramString1;
    String str4 = paramString2;
    long l4 = paramLong;
    boolean bool2 = localz2.a(3, localAccountVo2, d3, d4, str3, localProjectVo2, l3, str4, l4);
    String str5 = paramAccountVo2.d();
    z localz3 = this;
    AccountVo localAccountVo3 = paramAccountVo1;
    double d5 = paramAccountVo2;
    double d6 = paramDouble2;
    ProjectVo localProjectVo3 = paramProjectVo;
    long l5 = paramString1;
    String str6 = paramString2;
    long l6 = paramLong;
    return localz3.a(2, localAccountVo3, d5, d6, str5, localProjectVo3, l5, str6, l6);
  }

  private boolean d(double paramDouble1, AccountVo paramAccountVo1, double paramDouble2, AccountVo paramAccountVo2, long paramLong, ProjectVo paramProjectVo, String paramString1, String paramString2)
  {
    String str1 = paramAccountVo2.d();
    z localz1 = this;
    double d1 = paramAccountVo2;
    AccountVo localAccountVo1 = paramAccountVo1;
    double d2 = paramDouble1;
    ProjectVo localProjectVo1 = paramProjectVo;
    long l1 = paramString1;
    String str2 = paramString2;
    long l2 = paramLong;
    boolean bool1 = localz1.a(6, d1, localAccountVo1, d2, str1, localProjectVo1, l1, str2, l2);
    String str3 = paramAccountVo1.d();
    z localz2 = this;
    AccountVo localAccountVo2 = paramAccountVo1;
    double d3 = paramAccountVo2;
    double d4 = paramDouble1;
    ProjectVo localProjectVo2 = paramProjectVo;
    long l3 = paramString1;
    String str4 = paramString2;
    long l4 = paramLong;
    boolean bool2 = localz2.a(3, localAccountVo2, d3, d4, str3, localProjectVo2, l3, str4, l4);
    String str5 = paramAccountVo2.d();
    z localz3 = this;
    AccountVo localAccountVo3 = paramAccountVo1;
    double d5 = paramAccountVo2;
    double d6 = paramDouble2;
    ProjectVo localProjectVo3 = paramProjectVo;
    long l5 = paramString1;
    String str6 = paramString2;
    long l6 = paramLong;
    return localz3.a(2, localAccountVo3, d5, d6, str5, localProjectVo3, l5, str6, l6);
  }

  private boolean e(double paramDouble1, AccountVo paramAccountVo1, double paramDouble2, AccountVo paramAccountVo2, long paramLong, ProjectVo paramProjectVo, String paramString1, String paramString2)
  {
    String str1 = paramAccountVo2.d();
    z localz1 = this;
    double d1 = paramAccountVo2;
    AccountVo localAccountVo1 = paramAccountVo1;
    double d2 = paramDouble2;
    ProjectVo localProjectVo1 = paramProjectVo;
    long l1 = paramString1;
    String str2 = paramString2;
    long l2 = paramLong;
    boolean bool1 = localz1.a(7, d1, localAccountVo1, d2, str1, localProjectVo1, l1, str2, l2);
    String str3 = paramAccountVo1.d();
    z localz2 = this;
    AccountVo localAccountVo2 = paramAccountVo1;
    double d3 = paramAccountVo2;
    double d4 = paramDouble1;
    ProjectVo localProjectVo2 = paramProjectVo;
    long l3 = paramString1;
    String str4 = paramString2;
    long l4 = paramLong;
    boolean bool2 = localz2.a(3, localAccountVo2, d3, d4, str3, localProjectVo2, l3, str4, l4);
    String str5 = paramAccountVo2.d();
    z localz3 = this;
    AccountVo localAccountVo3 = paramAccountVo1;
    double d5 = paramAccountVo2;
    double d6 = paramDouble2;
    ProjectVo localProjectVo3 = paramProjectVo;
    long l5 = paramString1;
    String str6 = paramString2;
    long l6 = paramLong;
    return localz3.a(2, localAccountVo3, d5, d6, str5, localProjectVo3, l5, str6, l6);
  }

  private boolean f(double paramDouble1, AccountVo paramAccountVo1, double paramDouble2, AccountVo paramAccountVo2, long paramLong, ProjectVo paramProjectVo, String paramString1, String paramString2)
  {
    String str1 = paramAccountVo1.d();
    z localz1 = this;
    double d1 = paramAccountVo2;
    AccountVo localAccountVo1 = paramAccountVo1;
    double d2 = paramDouble1;
    ProjectVo localProjectVo1 = paramProjectVo;
    long l1 = paramString1;
    String str2 = paramString2;
    long l2 = paramLong;
    boolean bool1 = localz1.a(4, d1, localAccountVo1, d2, str1, localProjectVo1, l1, str2, l2);
    String str3 = paramAccountVo2.d();
    z localz2 = this;
    double d3 = paramAccountVo2;
    AccountVo localAccountVo2 = paramAccountVo1;
    double d4 = paramDouble2;
    ProjectVo localProjectVo2 = paramProjectVo;
    long l3 = paramString1;
    String str4 = paramString2;
    long l4 = paramLong;
    boolean bool2 = localz2.a(5, d3, localAccountVo2, d4, str3, localProjectVo2, l3, str4, l4);
    String str5 = paramAccountVo1.d();
    z localz3 = this;
    AccountVo localAccountVo3 = paramAccountVo1;
    double d5 = paramAccountVo2;
    double d6 = paramDouble1;
    ProjectVo localProjectVo3 = paramProjectVo;
    long l5 = paramString1;
    String str6 = paramString2;
    long l6 = paramLong;
    boolean bool3 = localz3.a(3, localAccountVo3, d5, d6, str5, localProjectVo3, l5, str6, l6);
    String str7 = paramAccountVo2.d();
    z localz4 = this;
    AccountVo localAccountVo4 = paramAccountVo1;
    double d7 = paramAccountVo2;
    double d8 = paramDouble2;
    ProjectVo localProjectVo4 = paramProjectVo;
    long l7 = paramString1;
    String str8 = paramString2;
    long l8 = paramLong;
    return localz4.a(2, localAccountVo4, d7, d8, str7, localProjectVo4, l7, str8, l8);
  }

  public int a()
  {
    return this.c.a();
  }

  public Cursor a(long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, long[] paramArrayOfLong5, String paramString)
  {
    String str1 = ApplicationContext.g;
    z localz = this;
    long l1 = paramLong1;
    long l2 = paramLong2;
    long l3 = paramArrayOfLong1;
    long[] arrayOfLong1 = paramArrayOfLong2;
    long[] arrayOfLong2 = paramArrayOfLong3;
    long[] arrayOfLong3 = paramArrayOfLong4;
    long[] arrayOfLong4 = paramArrayOfLong5;
    String str2 = paramString;
    List localList = localz.a(-1, str1, l1, l2, l3, arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, "", "");
    String[] arrayOfString1 = en.b;
    MatrixCursor localMatrixCursor = new MatrixCursor(arrayOfString1);
    Iterator localIterator = localList.iterator();
    int i;
    AccountVo localAccountVo1;
    AccountVo localAccountVo2;
    String str4;
    String str5;
    String str6;
    String str9;
    String str10;
    String str11;
    String str12;
    String str13;
    Object localObject1;
    String str15;
    Object localObject2;
    if (localIterator.hasNext())
    {
      this = (TransactionVo)localIterator.next();
      i = k();
      CategoryVo localCategoryVo = f();
      localAccountVo1 = g();
      localAccountVo2 = p();
      double d1 = b();
      String str3 = l();
      str4 = gs.a(d1, str3);
      str5 = gi.f(j());
      str6 = String.valueOf(n());
      StringBuilder localStringBuilder = new StringBuilder().append("折合:");
      double d2 = m();
      String str7 = ApplicationContext.g;
      String str8 = gs.a(d2, str7);
      str9 = str8;
      str10 = "";
      str11 = "";
      str12 = "";
      str13 = c();
      if ((i == 0) || (1 == i))
      {
        String str14 = CategoryVo.c(localCategoryVo);
        localObject1 = CategoryVo.b(f());
        str15 = str14;
        localObject2 = str12;
      }
    }
    while (true)
    {
      String[] arrayOfString2 = new String[en.b.length];
      int j = 0;
      label295: int k = arrayOfString2.length;
      String str16;
      String str17;
      String str21;
      if (j < k)
      {
        switch (j)
        {
        default:
          gj.a(a, "yearTransChildrenColumns.length > index error");
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        }
        while (true)
        {
          int m = j + 1;
          break label295;
          if (3 == i)
          {
            str16 = localAccountVo1.b();
            str17 = localAccountVo2.b();
            if (!TextUtils.isEmpty(str13))
              break label699;
            String str18 = str10;
            String str19 = str16;
            String str20 = str17;
            localObject1 = str19;
            break;
          }
          if (8 == i)
          {
            str21 = localAccountVo1.b();
            if (!TextUtils.isEmpty(str13))
              break label669;
            localObject1 = str21;
            String str22 = str10;
            String str23 = str12;
            break;
          }
          if (9 == i)
          {
            str21 = localAccountVo1.b();
            if (!TextUtils.isEmpty(str13))
              break label669;
            localObject1 = str21;
            String str24 = str10;
            String str25 = str12;
            break;
          }
          if (10 != i)
            break label684;
          str21 = localAccountVo1.b();
          if (!TextUtils.isEmpty(str13))
            break label669;
          localObject1 = str21;
          String str26 = str10;
          String str27 = str12;
          break;
          String str28 = String.valueOf(a());
          arrayOfString2[0] = str28;
          continue;
          arrayOfString2[1] = str15;
          continue;
          arrayOfString2[2] = localObject1;
          continue;
          arrayOfString2[3] = localObject2;
          continue;
          arrayOfString2[4] = str5;
          continue;
          String str29 = c();
          arrayOfString2[5] = str29;
          continue;
          arrayOfString2[6] = str4;
          continue;
          String str30 = String.valueOf(i);
          arrayOfString2[7] = str30;
          continue;
          arrayOfString2[8] = str6;
          continue;
          arrayOfString2[9] = str9;
        }
      }
      localMatrixCursor.addRow(arrayOfString2);
      break;
      return localMatrixCursor;
      label669: localObject1 = str21;
      str15 = str10;
      localObject2 = str12;
      continue;
      label684: localObject2 = str12;
      localObject1 = str11;
      str15 = str10;
      continue;
      label699: str15 = str10;
      String str31 = str16;
      localObject2 = str17;
      localObject1 = str31;
    }
  }

  public TransactionVo a(long paramLong)
  {
    fb localfb = this.c.g(paramLong);
    return a(localfb, 1);
  }

  public TransactionVo a(String paramString)
  {
    fb localfb = this.c.a(paramString);
    return a(localfb, 0);
  }

  public List a(int paramInt, String paramString1, long paramLong1, long paramLong2, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3, long[] paramArrayOfLong4, long[] paramArrayOfLong5, String paramString2, String paramString3, String paramString4)
  {
    an localan = this.c;
    int i = paramInt;
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
    List localList = localan.a(i, str1, l1, l2, l3, arrayOfLong1, arrayOfLong2, arrayOfLong3, arrayOfLong4, str2, str3, str4);
    return a(localList);
  }

  public List a(long paramLong1, long paramLong2)
  {
    List localList = this.c.b(paramLong1, paramLong2);
    return a(localList);
  }

  public List a(String paramString, int paramInt)
  {
    List localList = this.c.a(paramString, paramInt);
    return a(localList);
  }

  public boolean a(double paramDouble1, AccountVo paramAccountVo1, double paramDouble2, AccountVo paramAccountVo2, long paramLong, ProjectVo paramProjectVo, String paramString, boolean paramBoolean)
  {
    long l1 = paramAccountVo1.a();
    long l2 = paramAccountVo2.a();
    if (l1 == l2)
    {
      i = 0;
      label24: return i;
    }
    if (paramAccountVo1 == null)
      throw new RuntimeException("outAccountVo cann't be null");
    if (paramAccountVo2 == 0)
      throw new RuntimeException("inAccountVo cann't be null");
    String str1 = gt.o();
    int i = 0;
    int k = paramAccountVo1.c().d();
    long l3 = paramAccountVo1.a();
    int m = paramAccountVo2.c().d();
    long l4 = paramAccountVo2.a();
    if (paramBoolean);
    while (true)
    {
      double d2;
      try
      {
        dj.a();
        AccountVo localAccountVo1;
        double d3;
        double d4;
        long l5;
        ProjectVo localProjectVo1;
        long l6;
        boolean bool1;
        z localz6;
        switch (k)
        {
        default:
          i = 0;
          if (!paramBoolean)
            break;
          dj.c();
          break;
        case 0:
          if (m != 0)
            continue;
          z localz2 = this;
          double d1 = paramDouble1;
          localAccountVo1 = paramAccountVo1;
          d3 = paramDouble2;
          d4 = paramAccountVo2;
          l5 = paramLong;
          localProjectVo1 = paramProjectVo;
          l6 = paramString;
          bool1 = localz2.a(d1, localAccountVo1, d3, d4, l5, localProjectVo1, l6, str1);
          if (!bool1)
            continue;
          ac localac = ai.a().c();
          switch (k)
          {
          default:
            switch (m)
            {
            default:
              if (!paramBoolean)
                continue;
              dj.b();
              eb localeb = eb.a();
              String str2 = ea.b;
              localeb.a(str2);
              if (!paramBoolean)
                break label24;
              dj.c();
              break label24;
              int n = m;
              int i1 = 1;
              if (n != i1)
                continue;
              localz2 = this;
              d2 = paramDouble1;
              localAccountVo1 = paramAccountVo1;
              d3 = paramDouble2;
              d4 = paramAccountVo2;
              l5 = paramLong;
              localProjectVo1 = paramProjectVo;
              l6 = paramString;
              bool1 = localz2.e(d2, localAccountVo1, d3, d4, l5, localProjectVo1, l6, str1);
              continue;
              int i2 = m;
              int i3 = 2;
              if (i2 != i3)
                continue;
              z localz3 = this;
              double d5 = paramDouble1;
              AccountVo localAccountVo2 = paramAccountVo1;
              double d6 = paramDouble2;
              double d7 = paramAccountVo2;
              long l7 = paramLong;
              ProjectVo localProjectVo2 = paramProjectVo;
              long l8 = paramString;
              bool1 = localz3.c(d5, localAccountVo2, d6, d7, l7, localProjectVo2, l8, str1);
            case 0:
            case 1:
            case 2:
            }
          case 0:
          case 1:
          case 2:
          }
          break;
        case 1:
          if (m != 0)
            continue;
          z localz4 = this;
          double d8 = paramDouble1;
          AccountVo localAccountVo3 = paramAccountVo1;
          double d9 = paramDouble2;
          double d10 = paramAccountVo2;
          long l9 = paramLong;
          ProjectVo localProjectVo3 = paramProjectVo;
          long l10 = paramString;
          bool1 = localz4.b(d8, localAccountVo3, d9, d10, l9, localProjectVo3, l10, str1);
          continue;
          int i4 = m;
          int i5 = 2;
          if (i4 != i5)
            continue;
          z localz5 = this;
          double d11 = paramDouble1;
          AccountVo localAccountVo4 = paramAccountVo1;
          double d12 = paramDouble2;
          double d13 = paramAccountVo2;
          long l11 = paramLong;
          ProjectVo localProjectVo4 = paramProjectVo;
          long l12 = paramString;
          localz6 = localz5.f(d11, localAccountVo4, d12, d13, l11, localProjectVo4, l12, str1);
          bool1 = localz6;
          continue;
          bool1 = false;
          if (!paramBoolean)
            break;
          dj.c();
          break;
        case 2:
          if (m != 0)
            continue;
          z localz1 = this;
          d2 = paramDouble1;
          localAccountVo1 = paramAccountVo1;
          d3 = paramDouble2;
          d4 = paramAccountVo2;
          l5 = paramLong;
          localProjectVo1 = paramProjectVo;
          l6 = paramString;
          localz6 = localz1.d(d2, localAccountVo1, d3, d4, l5, localProjectVo1, l6, str1);
          localz1 = localz6;
          continue;
          j = 0;
          if (!paramBoolean)
            break;
          dj.c();
          break;
          double d14 = d2;
          long l13 = l3;
          double d15 = d14.d(l13);
          double d16 = d2;
          long l14 = l3;
          double d17 = d15;
          boolean bool2 = d16.a(l14, d17);
          continue;
        }
      }
      catch (Exception localException)
      {
        int j = 0;
        if (!paramBoolean)
          break;
        dj.c();
        break;
        e locale1 = g.a().c();
        long l15 = l3;
        boolean bool3 = locale1.b(l15);
        continue;
      }
      finally
      {
        if (!paramBoolean)
          continue;
        dj.c();
      }
      double d18 = d2;
      long l16 = l3;
      double d19 = d18.f(l16);
      double d20 = d2;
      long l17 = l3;
      double d21 = d19;
      boolean bool4 = d20.c(l17, d21);
      continue;
      double d22 = d2;
      long l18 = l4;
      double d23 = d22.d(l18);
      double d24 = d2;
      long l19 = l4;
      double d25 = d23;
      boolean bool5 = d24.a(l19, d25);
      continue;
      e locale2 = g.a().c();
      long l20 = l4;
      boolean bool6 = locale2.b(l20);
      continue;
      double d26 = d2;
      long l21 = l4;
      double d27 = d26.f(l21);
      double d28 = d2;
      long l22 = l4;
      double d29 = d27;
      boolean bool7 = d28.c(l22, d29);
    }
  }

  public boolean a(long paramLong1, double paramDouble1, AccountVo paramAccountVo1, double paramDouble2, AccountVo paramAccountVo2, long paramLong2, ProjectVo paramProjectVo, String paramString)
  {
    while (true)
    {
      boolean bool;
      try
      {
        TransactionVo localTransactionVo = a(paramLong1);
        an localan = this.c;
        String str1 = localTransactionVo.o();
        Object localObject1 = localan.b(str1);
        int i = ((List)localObject1).size();
        if (i <= 4)
          continue;
        j = 0;
        return j;
        dj.a();
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext())
          break label452;
        paramLong1 = (fb)((Iterator)localObject1).next();
        long l1 = paramLong1;
        double d1 = paramLong2;
        l1.d(d1);
        if (paramProjectVo == null)
          continue;
        long l2 = paramProjectVo.a();
        String str2 = paramProjectVo.b();
        fa localfa = new fa(l2, str2);
        paramLong1.a(localfa);
        long l3 = paramLong1;
        String str3 = paramString;
        l3.a(str3);
        i = paramLong1.d();
        switch (i)
        {
        default:
          j = 0;
          dj.c();
          break;
        case 2:
          long l4 = paramLong1;
          double d2 = paramDouble2;
          l4.c(d2);
          long l5 = paramLong1;
          double d3 = paramDouble2;
          l5.b(d3);
          bool = this.c.b(paramLong1);
          if (bool)
            continue;
          j = 0;
          dj.c();
          break;
        case 3:
          long l6 = paramLong1;
          double d4 = paramDouble1;
          l6.c(d4);
          long l7 = paramLong1;
          double d5 = paramDouble1;
          l7.b(d5);
          continue;
        case 4:
        case 5:
        case 6:
        case 7:
        }
      }
      catch (Exception localException)
      {
        String str4 = a;
        String str5 = localException.getLocalizedMessage();
        int k = Log.e(str4, str5);
        j = 0;
        dj.c();
        continue;
        long l8 = paramLong1;
        double d6 = paramDouble1;
        l8.c(d6);
        long l9 = paramLong1;
        double d7 = paramDouble1;
        l9.b(d7);
        continue;
      }
      finally
      {
        dj.c();
      }
      long l10 = paramLong1;
      double d8 = paramDouble2;
      l10.c(d8);
      long l11 = paramLong1;
      double d9 = paramDouble2;
      l11.b(d9);
      continue;
      long l12 = paramLong1;
      double d10 = paramDouble1;
      l12.c(d10);
      long l13 = paramLong1;
      double d11 = paramDouble1;
      l13.b(d11);
      continue;
      long l14 = paramLong1;
      double d12 = paramDouble2;
      l14.c(d12);
      long l15 = paramLong1;
      double d13 = paramDouble2;
      l15.b(d13);
      continue;
      label452: int m = paramAccountVo1.c().d();
      int n = paramAccountVo2.c().d();
      long l16 = paramAccountVo1.a();
      long l17 = paramAccountVo2.a();
      ac localac = ai.a().c();
      switch (m)
      {
      default:
        label524: switch (n)
        {
        default:
        case 0:
        case 1:
        case 2:
        }
      case 0:
      case 1:
      case 2:
      }
      do
      {
        do
        {
          do
          {
            dj.b();
            j = 1;
            eb localeb = eb.a();
            String str6 = ea.c;
            localeb.a(str6);
            dj.c();
            break;
            double d14 = localac.d(l16);
            bool = localac.a(l16, d14);
            if (bool)
              break label524;
            j = 0;
            dj.c();
            break;
            bool = g.a().c().b(l16);
            if (bool)
              break label524;
            j = 0;
            dj.c();
            break;
            double d15 = localac.f(l16);
            bool = localac.c(l16, d15);
            if (bool)
              break label524;
            j = 0;
            dj.c();
            break;
            double d16 = localac.d(l17);
            bool = localac.a(l17, d16);
          }
          while (bool);
          j = 0;
          dj.c();
          break;
          bool = g.a().c().b(l17);
        }
        while (bool);
        j = 0;
        dj.c();
        break;
        double d17 = localac.f(l17);
        bool = localac.c(l17, d17);
      }
      while (bool);
      int j = 0;
      dj.c();
    }
  }

  public boolean a(long paramLong, boolean paramBoolean)
  {
    fb localfb1 = this.c.g(paramLong);
    int n = localfb1.d();
    String str1 = localfb1.k();
    String str2 = localfb1.j();
    ac localac = ai.a().c();
    if (!TextUtils.isEmpty(str2))
      boolean bool2 = eo.c(str2);
    if (paramBoolean);
    Iterator localIterator;
    int m;
    while (true)
    {
      long l3;
      try
      {
        dj.a();
        if ((n != 0) && (1 != n) && (8 != n))
          continue;
        l3 = a(localfb1, 0).g().a();
        int i = localac.a(l3).k().i();
        if (i != 0)
          continue;
        boolean bool1 = this.c.f(paramLong);
        double d1 = localac.d(l3);
        boolean bool3 = localac.a(l3, d1);
        if (!paramBoolean)
          continue;
        dj.b();
        eb localeb = eb.a();
        String str3 = ea.d;
        localeb.a(str3);
        return bool1;
        if (true != bool1)
          continue;
        if (TextUtils.isEmpty(str1))
          continue;
        localIterator = this.c.b(str1).iterator();
        if (!localIterator.hasNext())
          continue;
        fb localfb2 = (fb)localIterator.next();
        an localan1 = this.c;
        long l4 = localfb2.a();
        boolean bool4 = localan1.f(l4);
        gj.a("TransactionServiceImpl", "deleteTransaction fuzhai record...");
        continue;
      }
      catch (Exception m)
      {
        localException.printStackTrace();
        if (!paramBoolean)
          continue;
        dj.c();
        int j = 0;
        continue;
        boolean bool5 = g.a().c().b(l3);
        j = 0;
        continue;
        if ((2 != localIterator) && (3 != localIterator) && (4 != localIterator) && (5 != localIterator) && (6 != localIterator) && (7 != localIterator))
          break;
        List localList = this.c.b(str1);
        int i2 = localList.size();
        if (i2 <= 4)
          continue;
        if (!paramBoolean)
          continue;
        dj.c();
        int k = 0;
        continue;
        localIterator = k.iterator();
        Object localObject1 = null;
        if (!localIterator.hasNext())
          continue;
        fb localfb3 = (fb)localIterator.next();
        an localan2 = this.c;
        long l5 = localfb3.a();
        int i1 = localan2.f(l5);
        l3 = a(localfb3, 0).g().a();
        m = localac.a(l3).k().i();
        if (m != 0)
          continue;
        double d2 = localac.d(l3);
        boolean bool6 = localac.a(l3, d2);
        m = i1;
        continue;
        if (1 == m)
        {
          boolean bool7 = g.a().c().b(l3);
          continue;
        }
      }
      finally
      {
        if (!paramBoolean)
          continue;
        dj.c();
      }
      if (2 != m)
        continue;
      double d3 = localac.f(l3);
      boolean bool8 = localac.c(l3, d3);
    }
    if ((10 == localIterator) || (9 == localIterator))
    {
      long l1 = a(m, 0).g().a();
      int i3 = localac.a(l1).k().i();
      long l2 = this.c.f(paramLong);
      switch (i3)
      {
      default:
      case 1:
      case 2:
      }
      while (true)
      {
        l1 = l2;
        break;
        boolean bool9 = g.a().c().b(l1);
        continue;
        double d4 = localac.f(l1);
        boolean bool10 = localac.c(l1, d4);
      }
    }
    throw new RuntimeException("unkonwn transaction type");
  }

  public boolean a(TransactionVo paramTransactionVo)
  {
    String str1 = "";
    ac localac = ai.a().c();
    long l1 = paramTransactionVo.a();
    long l2 = paramTransactionVo.g().a();
    int j = paramTransactionVo.k();
    int k = localac.a(l2).k().i();
    fb localfb1 = this.c.g(l1);
    TransactionVo localTransactionVo = a(localfb1, 0);
    fb localfb2 = b(paramTransactionVo);
    while (true)
    {
      try
      {
        dj.a();
        boolean bool2 = this.c.a(l1);
        if (j != 0)
          continue;
        if (1 != k)
          continue;
        str1 = gt.o();
        paramTransactionVo.d(str1);
        AccountVo localAccountVo = paramTransactionVo.g();
        paramTransactionVo.b(localAccountVo);
        long l4 = b(paramTransactionVo, 4);
        localfb2.c(str1);
        boolean bool1 = this.c.b(localfb2);
        double d1 = localTransactionVo.b();
        long l3 = localTransactionVo.g().a();
        double d2 = paramTransactionVo.b();
        l5 = paramTransactionVo.g().a();
        if ((d1 == d2) && (l3 == l5))
          continue;
        switch (k)
        {
        default:
          if (l3 == l5)
            continue;
          double d3 = localac.d(l3);
          boolean bool3 = localac.a(l3, d3);
          dj.b();
          eb localeb = eb.a();
          String str2 = ea.c;
          localeb.a(str2);
          return bool1;
          if (1 != j)
            continue;
          bool1 = this.c.b(localfb2);
          continue;
          throw new RuntimeException("unsupport transaction type");
        case 0:
        case 1:
        }
      }
      catch (Exception i)
      {
        long l5;
        localException.printStackTrace();
        int i = 0;
        dj.c();
        continue;
        double d4 = localac.d(l5);
        boolean bool4 = localac.a(l5, d4);
        continue;
      }
      finally
      {
        dj.c();
      }
      boolean bool5 = g.a().c().b(l2);
    }
  }

  public boolean a(TransactionVo paramTransactionVo, int paramInt)
  {
    while (true)
    {
      try
      {
        dj.a();
        localac = ai.a().c();
        l1 = paramTransactionVo.g().a();
        eq localeq = localac.a(l1);
        String str1 = localeq.h();
        paramTransactionVo.c(str1);
        int i = localeq.k().i();
        switch (paramInt)
        {
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        default:
          String str2 = a;
          String str3 = "" + paramInt;
          gj.a(str2, str3);
          dj.c();
          j = 0;
          return j;
        case 0:
          if (1 != i)
            continue;
          String str4 = gt.o();
          paramTransactionVo.d(str4);
          AccountVo localAccountVo = paramTransactionVo.g();
          paramTransactionVo.b(localAccountVo);
          long l2 = b(paramTransactionVo, 4);
          long l3 = b(paramTransactionVo, paramInt);
          l4 = l3;
          switch (i)
          {
          default:
            dj.c();
            j = 0;
          case 0:
          case 1:
          case 2:
          }
          break;
        case 1:
          paramTransactionVo.d("");
          l4 = b(paramTransactionVo, paramInt);
          break;
        case 8:
          l4 = b(paramTransactionVo, paramInt);
          break;
        case 9:
          l4 = b(paramTransactionVo, paramInt);
          break;
        case 10:
        }
        long l4 = b(paramTransactionVo, paramInt);
        continue;
        double d1 = localac.d(l1);
        boolean bool1 = localac.a(l1, d1);
        dj.b();
        eb localeb = eb.a();
        String str5 = ea.b;
        localeb.a(str5);
        dj.c();
        if (l4 != 0L)
        {
          j = 1;
          continue;
          boolean bool2 = g.a().c().b(l1);
          continue;
        }
      }
      catch (Exception localException)
      {
        ac localac;
        long l1;
        dj.c();
        j = 0;
        continue;
        double d2 = localac.f(l1);
        boolean bool3 = localac.c(l1, d2);
        continue;
      }
      finally
      {
        dj.c();
      }
      int j = 0;
    }
  }

  public double b(long paramLong1, long paramLong2)
  {
    an localan = this.c;
    long l1 = paramLong1;
    long l2 = paramLong2;
    return localan.a(0, l1, l2);
  }

  public List b(long paramLong)
  {
    List localList = this.c.h(paramLong);
    return a(localList);
  }

  public boolean b()
  {
    return this.c.b();
  }

  public double c(long paramLong1, long paramLong2)
  {
    an localan = this.c;
    long l1 = paramLong1;
    long l2 = paramLong2;
    return localan.a(1, l1, l2);
  }

  public long c()
  {
    return this.c.d();
  }

  public Cursor d(long paramLong1, long paramLong2)
  {
    ba localba1 = this.d;
    String str1 = ApplicationContext.g;
    long l1 = paramLong1;
    long l2 = paramLong2;
    List localList1 = localba1.b(str1, l1, l2);
    ba localba2 = this.d;
    String str2 = ApplicationContext.g;
    long l3 = paramLong1;
    long l4 = paramLong2;
    List localList2 = localba2.a(str2, l3, l4);
    HashMap localHashMap1 = new HashMap();
    Object localObject1 = localList1.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ey localey = (ey)((Iterator)localObject1).next();
      HashMap localHashMap2 = new HashMap();
      BigDecimal localBigDecimal1 = localey.c();
      Object localObject2 = localHashMap2.put("key_monthsum_payout", localBigDecimal1);
      String str3 = localey.b();
      Object localObject3 = localHashMap1.put(str3, localHashMap2);
    }
    Object localObject4 = localList2.iterator();
    Map localMap;
    if (((Iterator)localObject4).hasNext())
    {
      paramLong1 = (ey)((Iterator)localObject4).next();
      String str4 = paramLong1.b();
      localMap = (Map)localHashMap1.get(str4);
      if (localMap != null)
        break label869;
    }
    label708: label711: label856: label869: for (localObject1 = new HashMap(); ; localObject1 = localMap)
    {
      BigDecimal localBigDecimal2 = paramLong1.c();
      Object localObject5 = ((Map)localObject1).put("key_monthsum_income", localBigDecimal2);
      String str5 = paramLong1.b();
      Object localObject6 = localHashMap1.put(str5, localObject1);
      break;
      String[] arrayOfString1 = new String[12];
      arrayOfString1[0] = "01";
      arrayOfString1[1] = "02";
      arrayOfString1[2] = "03";
      arrayOfString1[3] = "04";
      arrayOfString1[4] = "05";
      arrayOfString1[5] = "06";
      arrayOfString1[6] = "07";
      arrayOfString1[7] = "08";
      arrayOfString1[8] = "09";
      arrayOfString1[9] = "10";
      arrayOfString1[10] = "11";
      arrayOfString1[11] = "12";
      int i = gi.c(gt.a()) + 1;
      String[] arrayOfString2 = new String[i];
      int j = 0;
      while (j < i)
      {
        String str6 = arrayOfString1[j];
        arrayOfString2[j] = str6;
        int k = j + 1;
      }
      int m = arrayOfString2.length;
      int n = 0;
      String str7;
      while (n < m)
      {
        str7 = arrayOfString2[n];
        if (localHashMap1.get(str7) == null)
        {
          HashMap localHashMap3 = new HashMap();
          BigDecimal localBigDecimal3 = new BigDecimal(0);
          Object localObject7 = localHashMap3.put("key_monthsum_payout", localBigDecimal3);
          BigDecimal localBigDecimal4 = new BigDecimal(0);
          Object localObject8 = localHashMap3.put("key_monthsum_income", localBigDecimal4);
          Object localObject9 = localHashMap1.put(str7, localHashMap3);
        }
        n += 1;
      }
      Set localSet = localHashMap1.keySet();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator1 = localSet.iterator();
      while (localIterator1.hasNext())
      {
        String str8 = (String)localIterator1.next();
        boolean bool = localArrayList.add(str8);
      }
      aa localaa = new aa(this);
      Collections.sort(localArrayList, localaa);
      String[] arrayOfString3 = en.a;
      localObject4 = new MatrixCursor(arrayOfString3);
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        this = (String)localIterator2.next();
        String[] arrayOfString4 = new String[en.a.length];
        paramLong1 = (Map)localHashMap1.get(this);
        String str9;
        int i1;
        if (paramLong1.get("key_monthsum_income") == null)
        {
          str7 = gs.a(0.0D, null);
          if (paramLong1.get("key_monthsum_payout") != null)
            break label798;
          str9 = gs.a(0.0D, null);
          i1 = 0;
          int i2 = arrayOfString4.length;
          if (i1 >= i2)
            break label856;
          switch (i1)
          {
          default:
            gj.a(a, "yearTransGroupColumns.length > index error");
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        while (true)
        {
          i1 += 1;
          break label711;
          String str10 = gs.a(((BigDecimal)paramLong1.get("key_monthsum_income")).doubleValue(), null);
          break;
          str9 = gs.a(((BigDecimal)paramLong1.get("key_monthsum_payout")).doubleValue(), null);
          break label708;
          arrayOfString4[0] = this;
          continue;
          arrayOfString4[1] = this;
          continue;
          arrayOfString4[2] = str7;
          continue;
          arrayOfString4[3] = str9;
        }
        ((MatrixCursor)localObject4).addRow(arrayOfString4);
      }
      return localObject4;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     z
 * JD-Core Version:    0.6.0
 */