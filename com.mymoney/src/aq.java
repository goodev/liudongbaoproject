import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mymoney.core.application.ApplicationContext;
import java.util.ArrayList;
import java.util.List;

public class aq extends ar
  implements ad
{
  public static String a = "select accountGroupPOID,name,parentAccountGroupPOID,path,depth,type,lastUpdateTime,hasChildren,userTradingEntityPOID, _tempIconName  from      (select a.accountGroupPOID as accountGroupPOID , a.name as name , a.parentAccountGroupPOID as  parentAccountGroupPOID,          a.path as path, a.depth as depth,a.type as type, a.lastUpdateTime as lastUpdateTime,          (case when b.accountGroupPOID is null then 0 else 1  end) hasChildren ,          a.userTradingEntityPOID as userTradingEntityPOID, a._tempIconName as _tempIconName      from t_account_group a       left  join       t_account_group b on(a.accountGroupPOID = b.parentAccountGroupPOID)  group by a.accountGroupPOID ) ";

  private er b(Cursor paramCursor)
  {
    er localer = new er();
    String str1 = dl.c;
    int i = paramCursor.getColumnIndex(str1);
    long l1 = paramCursor.getLong(i);
    localer.a(l1);
    String str2 = dl.d;
    int j = paramCursor.getColumnIndex(str2);
    String str3 = paramCursor.getString(j);
    localer.a(str3);
    String str4 = dl.e;
    int k = paramCursor.getColumnIndex(str4);
    long l2 = paramCursor.getLong(k);
    localer.b(l2);
    String str5 = dl.l;
    int m = paramCursor.getColumnIndex(str5);
    int n = paramCursor.getInt(m);
    int i1 = er.b;
    if (n == i1);
    int i3;
    for (int i2 = 1; ; i3 = 0)
    {
      localer.a(i2);
      String str6 = dl.f;
      int i4 = paramCursor.getColumnIndex(str6);
      String str7 = paramCursor.getString(i4);
      localer.c(str7);
      String str8 = dl.g;
      int i5 = paramCursor.getColumnIndex(str8);
      int i6 = paramCursor.getInt(i5);
      localer.a(i6);
      String str9 = dl.h;
      int i7 = paramCursor.getColumnIndex(str9);
      int i8 = paramCursor.getInt(i7);
      localer.b(i8);
      String str10 = dl.i;
      int i9 = paramCursor.getColumnIndex(str10);
      long l3 = paramCursor.getLong(i9);
      localer.c(l3);
      String str11 = dl.k;
      int i10 = paramCursor.getColumnIndex(str11);
      String str12 = paramCursor.getString(i10);
      localer.d(str12);
      return localer;
    }
  }

  private long c(long paramLong)
  {
    long l = 0L;
    SQLiteDatabase localSQLiteDatabase = g();
    String[] arrayOfString = new String[1];
    String str = String.valueOf(paramLong);
    arrayOfString[0] = str;
    Cursor localCursor = localSQLiteDatabase.rawQuery("select accountGroupPOID from t_account_group where depth = 0 and userTradingEntityPOID = ?", arrayOfString);
    while (localCursor.moveToNext())
    {
      int i = localCursor.getColumnIndex("accountGroupPOID");
      l = localCursor.getLong(i);
    }
    a(localCursor);
    return l;
  }

  public long a()
  {
    long l = ApplicationContext.d;
    return c(l);
  }

  public er a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = a;
    String str2 = str1 + "  where accountGroupPOID = ?";
    SQLiteDatabase localSQLiteDatabase = g();
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    Cursor localCursor = localSQLiteDatabase.rawQuery(str2, arrayOfString);
    for (er localer = null; localCursor.moveToNext(); localer = b(localCursor));
    a(localCursor);
    return localer;
  }

  public er b()
  {
    long l = a();
    return a(l);
  }

  public List b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = a;
    String str2 = str1 + " where parentAccountGroupPOID = ?";
    SQLiteDatabase localSQLiteDatabase = g();
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    Cursor localCursor = localSQLiteDatabase.rawQuery(str2, arrayOfString);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      er localer = b(localCursor);
      boolean bool = localArrayList.add(localer);
    }
    a(localCursor);
    return localArrayList;
  }

  public List c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = a;
    String str2 = str1 + " where userTradingEntityPOID = ? and  depth != 0";
    SQLiteDatabase localSQLiteDatabase = g();
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(ApplicationContext.d);
    arrayOfString[0] = str3;
    Cursor localCursor = localSQLiteDatabase.rawQuery(str2, arrayOfString);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      er localer = b(localCursor);
      boolean bool = localArrayList.add(localer);
    }
    a(localCursor);
    return localArrayList;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     aq
 * JD-Core Version:    0.6.0
 */