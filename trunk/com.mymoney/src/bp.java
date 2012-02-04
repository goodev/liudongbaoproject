import android.database.Cursor;
import java.util.List;

class bp
  implements as
{
  bp(bo parambo, List paramList)
  {
  }

  public Object a(Cursor paramCursor)
  {
    while (paramCursor.moveToNext())
    {
      fa localfa = new fa();
      int i = paramCursor.getColumnIndex("tagPOID");
      long l1 = paramCursor.getLong(i);
      localfa.a(l1);
      int j = paramCursor.getColumnIndex("name");
      String str = paramCursor.getString(j);
      localfa.a(str);
      int k = paramCursor.getColumnIndex("tagType");
      int m = paramCursor.getInt(k);
      localfa.a(m);
      int n = paramCursor.getColumnIndex("lastUpdateTime");
      long l2 = paramCursor.getLong(n);
      localfa.b(l2);
      boolean bool = this.a.add(localfa);
    }
    return null;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     bp
 * JD-Core Version:    0.6.0
 */