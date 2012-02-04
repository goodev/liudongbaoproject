import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mymoney.core.application.ApplicationContext;

public class ch extends bt
{
  String b = " select categoryPOID,name,parentCategoryPOID,hasChildren,path,depth,lastUpdateTime,userTradingEntityPOID,_tempIconName,type from   (select a.categoryPOID as categoryPOID , a.name as name , a.parentCategoryPOID as  parentCategoryPOID,     a.path as path, a.depth as depth, a.lastUpdateTime as lastUpdateTime,     (case when b.categoryPOID is null then 0 else 1  end) hasChildren ,     a.userTradingEntityPOID as userTradingEntityPOID,a._tempIconName as  _tempIconName,a.type as type   from t_category a     left  join    t_category b on(a.categoryPOID = b.parentCategoryPOID)   group by a.categoryPOID )";

  private long a(cx paramcx, int paramInt, boolean paramBoolean)
  {
    long l = b(paramInt);
    return a(l, paramcx, paramBoolean);
  }

  private cx a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = this.b;
    String str2 = str1 + " where name = ? and depth = ? and parentCategoryPOID = ? and userTradingEntityPOID = ? and type = ?";
    long l = ApplicationContext.d;
    String[] arrayOfString = new String[5];
    arrayOfString[0] = paramString;
    String str3 = String.valueOf(paramInt1);
    arrayOfString[1] = str3;
    String str4 = String.valueOf(paramLong);
    arrayOfString[2] = str4;
    String str5 = String.valueOf(l);
    arrayOfString[3] = str5;
    String str6 = String.valueOf(paramInt2);
    arrayOfString[4] = str6;
    Cursor localCursor = this.a.rawQuery(str2, arrayOfString);
    for (cx localcx = null; localCursor.moveToNext(); localcx = b(localCursor));
    a(localCursor);
    return localcx;
  }

  private long b(int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.a;
    String[] arrayOfString = new String[2];
    String str1 = String.valueOf(ApplicationContext.d);
    arrayOfString[0] = str1;
    String str2 = String.valueOf(paramInt);
    arrayOfString[1] = str2;
    Cursor localCursor = localSQLiteDatabase.rawQuery("select categoryPOID from t_category where depth = 0 and userTradingEntityPOID = ? and type = ?", arrayOfString);
    long l = 0L;
    while (localCursor.moveToNext())
    {
      int i = localCursor.getColumnIndex("categoryPOID");
      l = localCursor.getLong(i);
    }
    a(localCursor);
    return l;
  }

  private cx b(Cursor paramCursor)
  {
    cx localcx = new cx();
    int i = paramCursor.getColumnIndex("categoryPOID");
    long l1 = paramCursor.getLong(i);
    localcx.b(l1);
    int j = paramCursor.getColumnIndex("name");
    String str1 = paramCursor.getString(j);
    localcx.c(str1);
    int k = paramCursor.getColumnIndex("parentCategoryPOID");
    long l2 = paramCursor.getLong(k);
    localcx.a(l2);
    int m = paramCursor.getColumnIndex("path");
    String str2 = paramCursor.getString(m);
    localcx.a(str2);
    int n = paramCursor.getColumnIndex("depth");
    int i1 = paramCursor.getInt(n);
    localcx.b(i1);
    int i2 = paramCursor.getColumnIndex("lastUpdateTime");
    long l3 = paramCursor.getLong(i2);
    localcx.c(l3);
    int i3 = paramCursor.getColumnIndex("_tempIconName");
    String str3 = paramCursor.getString(i3);
    localcx.b(str3);
    int i4 = paramCursor.getColumnIndex("type");
    int i5 = paramCursor.getInt(i4);
    localcx.a(i5);
    int i6 = paramCursor.getColumnIndex("hasChildren");
    if (paramCursor.getInt(i6) == 1);
    int i8;
    for (int i7 = 1; ; i8 = 0)
    {
      localcx.a(i7);
      return localcx;
    }
  }

  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    ch localch = new ch();
    localch.a(paramSQLiteDatabase);
    return localch.a();
  }

  public long a(long paramLong, cx paramcx, boolean paramBoolean)
  {
    cx localcx = a(paramLong);
    int i = localcx.d();
    String str1 = localcx.c();
    String str2 = cp.a;
    long l1 = c(str2);
    if (paramBoolean != null)
      l1 = Math.abs(l1);
    StringBuilder localStringBuilder = new StringBuilder().append(str1).append(l1);
    String str3 = cp.c;
    String str4 = str3;
    int j = i + 1;
    int k = localcx.b();
    paramcx.b(l1);
    paramcx.a(paramLong);
    paramcx.a(str4);
    paramcx.b(j);
    paramcx.a(k);
    String str5 = cp.a;
    a(str5, paramcx);
    long l2 = c;
    String str6 = cp.a;
    a(l1, l2, str6);
    return l1;
  }

  public long a(cx paramcx)
  {
    return a(paramcx, 2, 1);
  }

  public cx a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = this.b;
    String str2 = str1 + " where categoryPOID = ?";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    Cursor localCursor = this.a.rawQuery(str2, arrayOfString);
    for (cx localcx = null; localCursor.moveToNext(); localcx = b(localCursor));
    a(localCursor);
    return localcx;
  }

  protected void a(String paramString, cx paramcx)
  {
    ContentValues localContentValues = new ContentValues();
    String str1 = cp.d;
    Long localLong1 = Long.valueOf(paramcx.f());
    localContentValues.put(str1, localLong1);
    String str2 = cp.e;
    String str3 = paramcx.g();
    localContentValues.put(str2, str3);
    String str4 = cp.f;
    Long localLong2 = Long.valueOf(paramcx.a());
    localContentValues.put(str4, localLong2);
    String str5 = cp.g;
    String str6 = paramcx.c();
    localContentValues.put(str5, str6);
    if (paramcx.h() > 0L)
    {
      String str7 = cp.i;
      Long localLong3 = Long.valueOf(paramcx.h());
      localContentValues.put(str7, localLong3);
    }
    while (true)
    {
      String str8 = cp.h;
      Integer localInteger1 = Integer.valueOf(paramcx.d());
      localContentValues.put(str8, localInteger1);
      String str9 = cp.j;
      Long localLong4 = Long.valueOf(ApplicationContext.d);
      localContentValues.put(str9, localLong4);
      String str10 = cp.k;
      String str11 = paramcx.e();
      localContentValues.put(str10, str11);
      String str12 = cp.l;
      Integer localInteger2 = Integer.valueOf(paramcx.b());
      localContentValues.put(str12, localInteger2);
      long l = this.a.insert(paramString, null, localContentValues);
      return;
      String str13 = cp.i;
      Long localLong5 = Long.valueOf(gt.f());
      localContentValues.put(str13, localLong5);
    }
  }

  public boolean a()
  {
    int i = 0;
    gj.a("DatabaseUpgrade5", "upgrade database to Version5");
    long l1 = b();
    String[] arrayOfString = new String[5];
    arrayOfString[i] = "出差";
    arrayOfString[1] = "公司报销";
    arrayOfString[2] = "装修";
    arrayOfString[3] = "旅游";
    arrayOfString[4] = "腐败";
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      cx localcx = new cx();
      localcx.c(str);
      localcx.b("default_firstlevelcategory_icon");
      if (a(str, 1, l1, 2) == null)
        long l2 = a(localcx);
      i += 1;
    }
    return true;
  }

  public long b()
  {
    return b(2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ch
 * JD-Core Version:    0.6.0
 */