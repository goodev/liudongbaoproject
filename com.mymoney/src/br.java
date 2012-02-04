import android.database.Cursor;
import java.util.List;

class br
  implements as
{
  br(bq parambq, List paramList)
  {
  }

  public Object a(Cursor paramCursor)
  {
    while (paramCursor.moveToNext())
    {
      List localList = this.a;
      fb localfb = bq.a(this.b, paramCursor);
      boolean bool = localList.add(localfb);
    }
    return null;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     br
 * JD-Core Version:    0.6.0
 */