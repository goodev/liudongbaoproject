import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class bn extends ar
  implements am
{
  private String a;

  public bn()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("  select ");
    String str1 = ds.b;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(",");
    String str2 = ds.c;
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(" from  ");
    String str3 = ds.a;
    String str4 = str3 + " order by syncTime desc ";
    this.a = str4;
  }

  public List a()
  {
    SQLiteDatabase localSQLiteDatabase = g();
    String str1 = this.a;
    Cursor localCursor = localSQLiteDatabase.rawQuery(str1, null);
    int i = localCursor.getCount();
    ArrayList localArrayList = new ArrayList(i);
    while (localCursor.moveToNext())
    {
      ez localez = new ez();
      String str2 = ds.b;
      int j = localCursor.getColumnIndex(str2);
      long l = localCursor.getLong(j);
      localez.a(l);
      String str3 = ds.c;
      int k = localCursor.getColumnIndex(str3);
      String str4 = localCursor.getString(k);
      localez.a(str4);
      boolean bool = localArrayList.add(localez);
    }
    a(localCursor);
    return localArrayList;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     bn
 * JD-Core Version:    0.6.0
 */