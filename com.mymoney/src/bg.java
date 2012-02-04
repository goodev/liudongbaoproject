import android.database.Cursor;
import java.math.BigDecimal;
import java.util.List;

class bg
  implements as
{
  bg(ba paramba, List paramList)
  {
  }

  public Object a(Cursor paramCursor)
  {
    while (paramCursor.moveToNext())
    {
      ey localey = new ey();
      int i = paramCursor.getColumnIndex("accountPOID");
      long l = paramCursor.getLong(i);
      localey.a(l);
      int j = paramCursor.getColumnIndex("name");
      String str = paramCursor.getString(j);
      localey.c(str);
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
 * Qualified Name:     bg
 * JD-Core Version:    0.6.0
 */