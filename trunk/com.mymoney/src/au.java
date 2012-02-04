import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mymoney.core.application.ApplicationContext;
import java.util.ArrayList;
import java.util.List;

public class au extends ar
  implements af
{
  String a = " select categoryPOID,name,parentCategoryPOID,hasChildren,path,depth,lastUpdateTime,_tempIconName,type,ordered from   (select a.categoryPOID as categoryPOID , a.name as name , a.parentCategoryPOID as  parentCategoryPOID,     a.path as path, a.depth as depth, a.lastUpdateTime as lastUpdateTime,     a.ordered as ordered,     (case when b.categoryPOID is null then 0 else 1  end) hasChildren ,      a._tempIconName as  _tempIconName,a.type as type   from t_category a     left  join    t_category b on(a.categoryPOID = b.parentCategoryPOID)   group by a.categoryPOID )";

  private long a(et paramet, int paramInt)
  {
    long l = c(paramInt);
    return a(l, paramet);
  }

  private et b(Cursor paramCursor)
  {
    et localet = new et();
    int i = paramCursor.getColumnIndex("categoryPOID");
    long l1 = paramCursor.getLong(i);
    localet.a(l1);
    int j = paramCursor.getColumnIndex("name");
    String str1 = paramCursor.getString(j);
    localet.a(str1);
    int k = paramCursor.getColumnIndex("parentCategoryPOID");
    long l2 = paramCursor.getLong(k);
    localet.c(l2);
    int m = paramCursor.getColumnIndex("path");
    String str2 = paramCursor.getString(m);
    localet.b(str2);
    int n = paramCursor.getColumnIndex("depth");
    int i1 = paramCursor.getInt(n);
    localet.b(i1);
    int i2 = paramCursor.getColumnIndex("lastUpdateTime");
    long l3 = paramCursor.getLong(i2);
    localet.b(l3);
    int i3 = paramCursor.getColumnIndex("_tempIconName");
    String str3 = paramCursor.getString(i3);
    localet.c(str3);
    int i4 = paramCursor.getColumnIndex("type");
    int i5 = paramCursor.getInt(i4);
    localet.a(i5);
    int i6 = paramCursor.getColumnIndex("hasChildren");
    if (paramCursor.getInt(i6) == 1);
    int i8;
    for (int i7 = 1; ; i8 = 0)
    {
      localet.a(i7);
      return localet;
    }
  }

  private List b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = this.a;
    String str2 = str1 + " where type = ? and depth = ? order by abs(parentCategoryPOID) asc,ordered asc ";
    String[] arrayOfString = new String[2];
    String str3 = String.valueOf(paramInt);
    arrayOfString[0] = str3;
    String str4 = String.valueOf(2);
    arrayOfString[1] = str4;
    Cursor localCursor = g().rawQuery(str2, arrayOfString);
    int i = localCursor.getCount();
    ArrayList localArrayList = new ArrayList(i);
    while (localCursor.moveToNext())
    {
      et localet = b(localCursor);
      boolean bool = localArrayList.add(localet);
    }
    super.a(localCursor);
    return localArrayList;
  }

  private long c(int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = g();
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

  public long a(long paramLong, et paramet)
  {
    et localet = c(paramLong);
    int i = localet.h();
    String str1 = localet.g();
    String str2 = dn.a;
    long l = c(str2);
    StringBuilder localStringBuilder = new StringBuilder().append(str1).append(l);
    String str3 = dn.c;
    String str4 = str3;
    int j = i + 1;
    int k = localet.f();
    paramet.a(l);
    paramet.c(paramLong);
    paramet.b(str4);
    paramet.b(j);
    paramet.a(k);
    String str5 = dn.a;
    a(str5, paramet);
    return l;
  }

  public long a(et paramet)
  {
    return a(paramet, 0);
  }

  public et a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = this.a;
    String str2 = str1 + " where name = ? and depth = ? and parentCategoryPOID = ?  and type = ?";
    String[] arrayOfString = new String[4];
    arrayOfString[0] = paramString;
    String str3 = String.valueOf(paramInt1);
    arrayOfString[1] = str3;
    String str4 = String.valueOf(paramLong);
    arrayOfString[2] = str4;
    String str5 = String.valueOf(paramInt2);
    arrayOfString[3] = str5;
    Cursor localCursor = b.a().rawQuery(str2, arrayOfString);
    for (et localet = null; localCursor.moveToNext(); localet = b(localCursor));
    a(localCursor);
    return localet;
  }

  public List a()
  {
    return a(0);
  }

  public List a(int paramInt)
  {
    long l = c(paramInt);
    return b(l);
  }

  protected void a(String paramString, et paramet)
  {
    ContentValues localContentValues = new ContentValues();
    String str1 = dn.d;
    Long localLong1 = Long.valueOf(paramet.b());
    localContentValues.put(str1, localLong1);
    String str2 = dn.e;
    String str3 = paramet.c();
    localContentValues.put(str2, str3);
    String str4 = dn.f;
    Long localLong2 = Long.valueOf(paramet.e());
    localContentValues.put(str4, localLong2);
    String str5 = dn.g;
    String str6 = paramet.g();
    localContentValues.put(str5, str6);
    if (paramet.d() > 0L)
    {
      String str7 = dn.i;
      Long localLong3 = Long.valueOf(paramet.d());
      localContentValues.put(str7, localLong3);
    }
    while (true)
    {
      String str8 = dn.h;
      Integer localInteger1 = Integer.valueOf(paramet.h());
      localContentValues.put(str8, localInteger1);
      String str9 = dn.j;
      Long localLong4 = Long.valueOf(ApplicationContext.d);
      localContentValues.put(str9, localLong4);
      String str10 = dn.k;
      String str11 = paramet.i();
      localContentValues.put(str10, str11);
      String str12 = dn.l;
      Integer localInteger2 = Integer.valueOf(paramet.f());
      localContentValues.put(str12, localInteger2);
      Integer localInteger3 = Integer.valueOf(paramet.j());
      localContentValues.put("ordered", localInteger3);
      long l = b.a().insert(paramString, null, localContentValues);
      return;
      String str13 = dn.i;
      Long localLong5 = Long.valueOf(gt.f());
      localContentValues.put(str13, localLong5);
    }
  }

  public boolean a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = dn.d;
    String str2 = str1 + " = ? ";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    while (true)
    {
      try
      {
        b.a().beginTransaction();
        et localet = c(paramLong);
        localet.b(0L);
        String str4 = dn.b;
        a(str4, localet);
        SQLiteDatabase localSQLiteDatabase = b.a();
        String str5 = dn.a;
        int i = localSQLiteDatabase.delete(str5, str2, arrayOfString);
        b.a().setTransactionSuccessful();
        b.a().endTransaction();
        if (i > 0)
        {
          j = 1;
          return j;
        }
      }
      finally
      {
        b.a().endTransaction();
      }
      int j = 0;
    }
  }

  public boolean a(et paramet, boolean paramBoolean)
  {
    String str1 = paramet.c();
    String str2 = paramet.i();
    ContentValues localContentValues = new ContentValues();
    String str3 = dn.e;
    localContentValues.put(str3, str1);
    if ((str2 != null) && (!str2.equals("")))
    {
      String str4 = dn.k;
      localContentValues.put(str4, str2);
    }
    if (paramBoolean)
    {
      String str5 = dn.i;
      Long localLong1 = Long.valueOf(paramet.d());
      localContentValues.put(str5, localLong1);
      StringBuilder localStringBuilder = new StringBuilder();
      String str6 = dn.d;
      String str7 = str6 + " = ?";
      String[] arrayOfString = new String[1];
      String str8 = String.valueOf(paramet.b());
      arrayOfString[0] = str8;
      SQLiteDatabase localSQLiteDatabase = b.a();
      String str9 = dn.a;
      if (localSQLiteDatabase.update(str9, localContentValues, str7, arrayOfString) <= 0)
        break label203;
    }
    label203: for (int i = 1; ; i = 0)
    {
      return i;
      String str10 = dn.i;
      Long localLong2 = Long.valueOf(gt.f());
      localContentValues.put(str10, localLong2);
      break;
    }
  }

  public long b(et paramet)
  {
    return a(paramet, 1);
  }

  public List b()
  {
    return a(1);
  }

  public List b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = this.a;
    String str2 = str1 + " where parentCategoryPOID = ? order by ordered asc";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    Cursor localCursor = b.a().rawQuery(str2, arrayOfString);
    int i = localCursor.getCount();
    ArrayList localArrayList = new ArrayList(i);
    while (localCursor.moveToNext())
    {
      et localet = b(localCursor);
      boolean bool = localArrayList.add(localet);
    }
    a(localCursor);
    return localArrayList;
  }

  public et c(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = this.a;
    String str2 = str1 + " where categoryPOID = ?";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    Cursor localCursor = b.a().rawQuery(str2, arrayOfString);
    for (et localet = null; localCursor.moveToNext(); localet = b(localCursor));
    a(localCursor);
    return localet;
  }

  public List c()
  {
    return b(0);
  }

  public List d()
  {
    return b(1);
  }

  public boolean d(long paramLong)
  {
    if (b(paramLong).size() > 0);
    for (int i = 0; ; i = 1)
    {
      String[] arrayOfString = new String[2];
      String str1 = String.valueOf(paramLong);
      arrayOfString[0] = str1;
      String str2 = String.valueOf(paramLong);
      arrayOfString[1] = str2;
      Cursor localCursor = b.a().rawQuery("select transactionPOID from t_transaction where buyerCategoryPOID = ? or sellerCategoryPOID = ?", arrayOfString);
      while (localCursor.moveToNext())
        i = 0;
      a(localCursor);
      return i;
    }
  }

  public et e()
  {
    long l = h();
    return c(l);
  }

  public et f()
  {
    long l = i();
    return c(l);
  }

  public long h()
  {
    return c(0);
  }

  public long i()
  {
    return c(1);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     au
 * JD-Core Version:    0.6.0
 */