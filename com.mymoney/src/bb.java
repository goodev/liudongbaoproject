import android.database.Cursor;
import java.math.BigDecimal;
import java.util.List;

class bb
  implements as
{
  bb(ba paramba, List paramList)
  {
  }

  public Object a(Cursor paramCursor)
  {
    while (paramCursor.moveToNext())
    {
      ey localey = new ey();
      int i = paramCursor.getColumnIndex("categoryPOID");
      long l = paramCursor.getLong(i);
      localey.a(l);
      int j = paramCursor.getColumnIndex("name");
      String str1 = paramCursor.getString(j);
      localey.c(str1);
      int k = paramCursor.getColumnIndex("iconName");
      String str2 = paramCursor.getString(k);
      localey.d(str2);
      int m = paramCursor.getColumnIndex("amount");
      double d = paramCursor.getDouble(m);
      BigDecimal localBigDecimal = new BigDecimal(d);
      localey.a(localBigDecimal);
      boolean bool = this.a.add(localey);
    }
    return null;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     bb
 * JD-Core Version:    0.6.0
 */