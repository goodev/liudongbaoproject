import android.database.Cursor;
import java.math.BigDecimal;
import java.util.List;

class be
  implements as
{
  be(ba paramba, List paramList)
  {
  }

  public Object a(Cursor paramCursor)
  {
    while (paramCursor.moveToNext())
    {
      ey localey = new ey();
      int i = paramCursor.getColumnIndex("name");
      String str1 = paramCursor.getString(i);
      localey.c(str1);
      int j = paramCursor.getColumnIndex("currencyType");
      String str2 = paramCursor.getString(j);
      localey.b(str2);
      int k = paramCursor.getColumnIndex("amount");
      double d = paramCursor.getDouble(k);
      BigDecimal localBigDecimal = new BigDecimal(d);
      localey.a(localBigDecimal);
      boolean bool = this.a.add(localey);
    }
    return null;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     be
 * JD-Core Version:    0.6.0
 */