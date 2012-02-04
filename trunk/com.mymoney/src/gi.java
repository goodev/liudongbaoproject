import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class gi
{
  private static Calendar a = Calendar.getInstance();
  private static SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd");
  private static SimpleDateFormat c = new SimpleDateFormat("MM.dd");
  private static SimpleDateFormat d = new SimpleDateFormat("yyyy-MM");
  private static SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
  private static SimpleDateFormat f = new SimpleDateFormat("dd");
  private static SimpleDateFormat g = new SimpleDateFormat("M月d日");
  private static SimpleDateFormat h = new SimpleDateFormat("MM-dd");

  public static int a(long paramLong1, long paramLong2)
  {
    return a(paramLong1, paramLong2, 1);
  }

  public static int a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    long l1;
    long l3;
    if (paramLong1 > paramLong2)
    {
      l1 = paramLong1;
      l3 = paramLong2;
    }
    while (true)
    {
      int j;
      synchronized (a)
      {
        ???.setTimeInMillis(l3);
        l3 = 0;
        if (???.getTimeInMillis() >= l1)
          continue;
        ???.add(5, 1);
        j = l3 + 1;
        continue;
        if ((paramBoolean) && (???.getTimeInMillis() > l1))
        {
          int i = j + -1;
          return i;
        }
      }
      long l2 = j;
      continue;
      l2 = paramLong2;
      long l4 = paramLong1;
    }
  }

  public static long a()
  {
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = new Date();
    localCalendar.setTime(localDate);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }

  public static long a(int paramInt)
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      int i = paramInt;
      localCalendar.set(i, 11, 31, 23, 59, 59);
      localCalendar.set(14, 0);
      label28: return localCalendar.getTimeInMillis();
    }
    catch (Exception localException)
    {
      break label28;
    }
  }

  public static long a(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2);
    localCalendar.set(5, paramInt3);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }

  public static long a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    return c(i, j);
  }

  public static long a(long paramLong, int paramInt)
  {
    synchronized (a)
    {
      ???.setTimeInMillis(paramLong);
      ???.add(5, paramInt);
      long l = ???.getTimeInMillis();
      return l;
    }
  }

  public static long a(String paramString)
  {
    int[] arrayOfInt = b(paramString);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, i);
    localCalendar.set(12, j);
    localCalendar.set(13, 0);
    long l1 = localCalendar.getTimeInMillis();
    long l2 = System.currentTimeMillis();
    if (l1 > l2);
    while (true)
    {
      return l1;
      localCalendar.add(5, 1);
      l1 = localCalendar.getTimeInMillis();
    }
  }

  public static String a(Date paramDate, String paramString)
  {
    if (paramDate == null);
    for (String str = ""; ; str = new SimpleDateFormat(paramString).format(paramDate))
      return str;
  }

  public static Date a(int paramInt1, int paramInt2)
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      int i = paramInt1;
      int j = paramInt2;
      localCalendar.set(i, j, 1, 0, 0, 0);
      localCalendar.set(14, 0);
      Date localDate1 = localCalendar.getTime();
      localDate2 = localDate1;
      return localDate2;
    }
    catch (Exception localException)
    {
      while (true)
        Date localDate2 = null;
    }
  }

  public static Date a(Date paramDate)
  {
    if (paramDate == null);
    Calendar localCalendar;
    for (Date localDate = null; ; localDate = localCalendar.getTime())
    {
      return localDate;
      localCalendar = Calendar.getInstance();
      long l = paramDate.getTime();
      localCalendar.setTimeInMillis(l);
      localCalendar.add(2, 1);
    }
  }

  public static final void a(Calendar paramCalendar)
  {
    paramCalendar.set(11, 0);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    paramCalendar.set(14, 0);
  }

  public static int b(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(1);
  }

  public static long b()
  {
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = new Date();
    localCalendar.setTime(localDate);
    localCalendar.set(11, 23);
    localCalendar.set(12, 59);
    localCalendar.set(13, 59);
    localCalendar.set(14, 999);
    return localCalendar.getTimeInMillis();
  }

  public static long b(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2).getTime();
  }

  public static long b(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2);
    localCalendar.set(5, paramInt3);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }

  public static long b(long paramLong, int paramInt)
  {
    return a(paramLong, paramInt);
  }

  public static String b(Date paramDate, String paramString)
  {
    return new SimpleDateFormat(paramString).format(paramDate);
  }

  public static Date b(Date paramDate)
  {
    if (paramDate == null);
    Calendar localCalendar;
    for (Date localDate = null; ; localDate = localCalendar.getTime())
    {
      return localDate;
      localCalendar = Calendar.getInstance();
      long l = paramDate.getTime();
      localCalendar.setTimeInMillis(l);
      localCalendar.add(2, -1);
    }
  }

  public static int[] b(String paramString)
  {
    if (paramString.equals(""));
    for (String str = "23:00"; ; str = paramString)
    {
      String[] arrayOfString = str.split(":");
      int i = Integer.valueOf(arrayOfString[0]).intValue();
      int j = Integer.valueOf(arrayOfString[1]).intValue();
      int[] arrayOfInt = new int[2];
      arrayOfInt[0] = i;
      arrayOfInt[1] = j;
      return arrayOfInt;
    }
  }

  public static int c(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(2);
  }

  public static long c()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(7) - 1;
    if (i == 0)
      i = 7;
    int j = -i + 1;
    localCalendar.add(5, j);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }

  public static long c(int paramInt1, int paramInt2)
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      int i = paramInt1;
      int j = paramInt2;
      localCalendar.set(i, j, 1, 23, 59, 59);
      localCalendar.set(14, 999);
      localCalendar.add(2, 1);
      localCalendar.add(5, -1);
      label45: return localCalendar.getTimeInMillis();
    }
    catch (Exception localException)
    {
      break label45;
    }
  }

  public static long c(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2);
    localCalendar.set(5, paramInt3);
    localCalendar.set(11, 23);
    localCalendar.set(12, 59);
    localCalendar.set(13, 59);
    localCalendar.set(14, 999);
    return localCalendar.getTimeInMillis();
  }

  public static long c(long paramLong, int paramInt)
  {
    int i = -paramInt;
    return a(paramLong, i);
  }

  public static Date c(Date paramDate)
  {
    if (paramDate == null);
    Calendar localCalendar;
    for (Date localDate = null; ; localDate = localCalendar.getTime())
    {
      return localDate;
      localCalendar = Calendar.getInstance();
      long l = paramDate.getTime();
      localCalendar.setTimeInMillis(l);
      localCalendar.add(2, 3);
    }
  }

  public static int d(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(5);
  }

  public static long d()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(7) - 1;
    if (i == 0)
      i = 7;
    int j = -i + 7;
    localCalendar.add(5, j);
    localCalendar.set(11, 23);
    localCalendar.set(12, 59);
    localCalendar.set(13, 59);
    localCalendar.set(14, 999);
    return localCalendar.getTimeInMillis();
  }

  public static Date d(Date paramDate)
  {
    if (paramDate == null);
    Calendar localCalendar;
    for (Date localDate = null; ; localDate = localCalendar.getTime())
    {
      return localDate;
      localCalendar = Calendar.getInstance();
      long l = paramDate.getTime();
      localCalendar.setTimeInMillis(l);
      localCalendar.add(2, -1);
    }
  }

  public static long e()
  {
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = j(m());
    localCalendar.setTime(localDate);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    return b(i, j, k);
  }

  public static long e(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }

  public static Date e(Date paramDate)
  {
    if (paramDate == null);
    Calendar localCalendar;
    for (Date localDate = null; ; localDate = localCalendar.getTime())
    {
      return localDate;
      localCalendar = Calendar.getInstance();
      long l = paramDate.getTime();
      localCalendar.setTimeInMillis(l);
      localCalendar.add(1, -1);
    }
  }

  public static long f()
  {
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = k(m());
    localCalendar.setTime(localDate);
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    return c(i, j, k);
  }

  public static String f(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = b;
    Date localDate = new Date(paramLong);
    return localSimpleDateFormat.format(localDate);
  }

  public static Date f(Date paramDate)
  {
    if (paramDate == null);
    Calendar localCalendar;
    for (Date localDate = null; ; localDate = localCalendar.getTime())
    {
      return localDate;
      localCalendar = Calendar.getInstance();
      long l = paramDate.getTime();
      localCalendar.setTimeInMillis(l);
      localCalendar.add(1, 1);
    }
  }

  public static long g()
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(2, 0);
      localCalendar.set(5, 1);
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      long l1 = localCalendar.getTimeInMillis();
      l2 = l1;
      return l2;
    }
    catch (Exception localException)
    {
      while (true)
        long l2 = 0L;
    }
  }

  public static final long g(long paramLong)
  {
    return paramLong / 1000L * 1000L;
  }

  public static String g(Date paramDate)
  {
    if (paramDate == null);
    for (String str = ""; ; str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paramDate))
      return str;
  }

  public static long h()
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(5, 1);
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      long l1 = localCalendar.getTimeInMillis();
      l2 = l1;
      return l2;
    }
    catch (Exception localException)
    {
      while (true)
        long l2 = 0L;
    }
  }

  public static long h(long paramLong)
  {
    return a(paramLong, 1);
  }

  public static final Date h(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    a(localCalendar);
    return localCalendar.getTime();
  }

  public static int i(Date paramDate)
  {
    int i = 0;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    switch (localCalendar.get(2))
    {
    default:
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
    case 10:
    case 11:
    }
    while (true)
    {
      return i;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
    }
  }

  public static long i()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    return c(i, j);
  }

  public static long i(long paramLong)
  {
    return a(paramLong, 7);
  }

  public static long j()
  {
    return a(Calendar.getInstance().get(1));
  }

  public static long j(long paramLong)
  {
    return a(paramLong, -1);
  }

  public static Date j(Date paramDate)
  {
    return l(n(paramDate)[0]);
  }

  public static long k()
  {
    return e(Calendar.getInstance().getTimeInMillis());
  }

  public static long k(long paramLong)
  {
    return a(paramLong, -1);
  }

  public static Date k(Date paramDate)
  {
    return m(n(paramDate)[2]);
  }

  public static final Date l()
  {
    long l = g(gt.a());
    return new Date(l);
  }

  public static Date l(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int i = localCalendar.getActualMinimum(5);
    localCalendar.set(5, i);
    return localCalendar.getTime();
  }

  public static final Date m()
  {
    return h(l());
  }

  public static Date m(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int i = localCalendar.getActualMaximum(5);
    localCalendar.set(5, i);
    return localCalendar.getTime();
  }

  public static Date[] n(Date paramDate)
  {
    Date[] arrayOfDate = new Date[3];
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int i = i(paramDate);
    if (i == 1)
    {
      localCalendar.set(2, 0);
      Date localDate1 = localCalendar.getTime();
      arrayOfDate[0] = localDate1;
      localCalendar.set(2, 1);
      Date localDate2 = localCalendar.getTime();
      arrayOfDate[1] = localDate2;
      localCalendar.set(2, 2);
      Date localDate3 = localCalendar.getTime();
      arrayOfDate[2] = localDate3;
    }
    while (true)
    {
      return arrayOfDate;
      if (i == 2)
      {
        localCalendar.set(2, 3);
        Date localDate4 = localCalendar.getTime();
        arrayOfDate[0] = localDate4;
        localCalendar.set(2, 4);
        Date localDate5 = localCalendar.getTime();
        arrayOfDate[1] = localDate5;
        localCalendar.set(2, 5);
        Date localDate6 = localCalendar.getTime();
        arrayOfDate[2] = localDate6;
        continue;
      }
      if (i == 3)
      {
        localCalendar.set(2, 6);
        Date localDate7 = localCalendar.getTime();
        arrayOfDate[0] = localDate7;
        localCalendar.set(2, 7);
        Date localDate8 = localCalendar.getTime();
        arrayOfDate[1] = localDate8;
        localCalendar.set(2, 8);
        Date localDate9 = localCalendar.getTime();
        arrayOfDate[2] = localDate9;
        continue;
      }
      if (i != 4)
        continue;
      localCalendar.set(2, 9);
      Date localDate10 = localCalendar.getTime();
      arrayOfDate[0] = localDate10;
      localCalendar.set(2, 10);
      Date localDate11 = localCalendar.getTime();
      arrayOfDate[1] = localDate11;
      localCalendar.set(2, 11);
      Date localDate12 = localCalendar.getTime();
      arrayOfDate[2] = localDate12;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gi
 * JD-Core Version:    0.6.0
 */