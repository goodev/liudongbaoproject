import java.util.Calendar;
import java.util.TimeZone;

public class ha
{
  public static int a(String paramString)
  {
    int i = TimeZone.getDefault().getRawOffset();
    int j = TimeZone.getTimeZone(paramString).getRawOffset();
    return i - j;
  }

  public static final long a(long paramLong)
  {
    return e(paramLong).getTimeInMillis();
  }

  public static final long b(long paramLong)
  {
    return d(paramLong).getTimeInMillis();
  }

  public static final long c(long paramLong)
  {
    return a("GMT+08:00") + paramLong;
  }

  private static final Calendar d(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
    localCalendar1.setTimeInMillis(paramLong);
    int i = localCalendar1.get(1);
    int j = localCalendar1.get(2);
    int k = localCalendar1.get(5);
    Calendar localCalendar2 = Calendar.getInstance();
    int m = 0;
    int n = 0;
    localCalendar2.set(i, j, k, 0, m, n);
    localCalendar2.set(14, 0);
    return localCalendar2;
  }

  private static final Calendar e(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong);
    int i = localCalendar1.get(1);
    int j = localCalendar1.get(2);
    int k = localCalendar1.get(5);
    Calendar localCalendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
    int m = 0;
    int n = 0;
    localCalendar2.set(i, j, k, 0, m, n);
    localCalendar2.set(14, 0);
    return localCalendar2;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ha
 * JD-Core Version:    0.6.0
 */