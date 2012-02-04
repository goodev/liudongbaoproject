import android.database.Cursor;
import java.math.BigDecimal;
import java.util.List;

class bm
  implements as
{
  bm(ba paramba, List paramList)
  {
  }

  public Object a(Cursor paramCursor)
  {
    int m;
    for (int i = 0; paramCursor.moveToNext(); i = m)
    {
      ey localey = new ey();
      int j = paramCursor.getColumnIndex("tradeMonth");
      String str1 = paramCursor.getString(j);
      localey.a(str1);
      int k = paramCursor.getColumnIndex("amount");
      double d = paramCursor.getDouble(k);
      BigDecimal localBigDecimal1 = new BigDecimal(d);
      localey.b(localBigDecimal1);
      m = i + 1;
      long l = i;
      localey.a(l);
      ba localba = this.b;
      String str2 = localey.b();
      String str3 = ba.a(localba, str2);
      localey.c(str3);
      BigDecimal localBigDecimal2 = localey.c();
      localey.a(localBigDecimal2);
      boolean bool = this.a.add(localey);
    }
    return null;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     bm
 * JD-Core Version:    0.6.0
 */