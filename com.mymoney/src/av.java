import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mymoney.core.application.ApplicationContext;
import java.util.ArrayList;
import java.util.List;

public class av extends ar
  implements ag
{
  private static String a = " select t.tradingEntityPOID as id,t.name as name ,t.lastUpdateTime as lastUpdateTime   from     t_tradingEntity as t";

  private eu b(Cursor paramCursor)
  {
    eu localeu = new eu();
    int i = paramCursor.getColumnIndex("id");
    long l1 = paramCursor.getLong(i);
    localeu.a(l1);
    int j = paramCursor.getColumnIndex("name");
    String str = paramCursor.getString(j);
    localeu.a(str);
    int k = paramCursor.getColumnIndex("lastUpdateTime");
    long l2 = paramCursor.getLong(k);
    localeu.b(l2);
    return localeu;
  }

  public long a(eu parameu)
  {
    String str1 = du.a;
    long l = c(str1);
    parameu.a(l);
    String str2 = du.a;
    a(str2, parameu);
    return l;
  }

  public eu a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = a;
    String str2 = str1 + " where t.tradingEntityPOID = ? ";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    Cursor localCursor = b.a().rawQuery(str2, arrayOfString);
    for (eu localeu = null; localCursor.moveToNext(); localeu = b(localCursor));
    a(localCursor);
    return localeu;
  }

  public eu a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = a;
    String str2 = str1 + " where  t.name = ?";
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString;
    Cursor localCursor = b.a().rawQuery(str2, arrayOfString);
    for (eu localeu = null; localCursor.moveToNext(); localeu = b(localCursor));
    a(localCursor);
    return localeu;
  }

  public List a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = a;
    String str2 = str1 + "  order by ordered,lastUpdateTime";
    Cursor localCursor = b.a().rawQuery(str2, null);
    int i = localCursor.getCount();
    ArrayList localArrayList = new ArrayList(i);
    while (localCursor.moveToNext())
    {
      eu localeu = b(localCursor);
      boolean bool = localArrayList.add(localeu);
    }
    a(localCursor);
    return localArrayList;
  }

  protected void a(String paramString, eu parameu)
  {
    ContentValues localContentValues = new ContentValues();
    String str1 = du.c;
    Long localLong1 = Long.valueOf(parameu.b());
    localContentValues.put(str1, localLong1);
    String str2 = du.d;
    String str3 = parameu.c();
    localContentValues.put(str2, str3);
    if (parameu.e() > 0L)
    {
      String str4 = du.e;
      Long localLong2 = Long.valueOf(parameu.e());
      localContentValues.put(str4, localLong2);
    }
    while (true)
    {
      Integer localInteger = Integer.valueOf(parameu.d());
      localContentValues.put("ordered", localInteger);
      Long localLong3 = Long.valueOf(ApplicationContext.d);
      localContentValues.put("belongTo", localLong3);
      long l = b.a().insert(paramString, null, localContentValues);
      return;
      String str5 = du.e;
      Long localLong4 = Long.valueOf(gt.f());
      localContentValues.put(str5, localLong4);
    }
  }

  public boolean a(eu parameu, boolean paramBoolean)
  {
    long l1 = parameu.b();
    String str1 = parameu.c();
    long l2;
    if (paramBoolean)
    {
      l2 = parameu.e();
      ContentValues localContentValues = new ContentValues();
      String str2 = du.d;
      localContentValues.put(str2, str1);
      String str3 = du.e;
      Long localLong = Long.valueOf(l2);
      localContentValues.put(str3, localLong);
      StringBuilder localStringBuilder = new StringBuilder();
      String str4 = du.c;
      String str5 = str4 + " = ?";
      String[] arrayOfString = new String[1];
      String str6 = String.valueOf(l1);
      arrayOfString[0] = str6;
      SQLiteDatabase localSQLiteDatabase = b.a();
      String str7 = du.a;
      if (localSQLiteDatabase.update(str7, localContentValues, str5, arrayOfString) <= 0)
        break label157;
    }
    label157: for (int i = 1; ; i = 0)
    {
      return i;
      l2 = gt.f();
      break;
    }
  }

  public boolean b(long paramLong)
  {
    while (true)
    {
      try
      {
        b.a().beginTransaction();
        eu localeu = a(paramLong);
        long l = gt.f();
        localeu.b(l);
        String str1 = du.b;
        a(str1, localeu);
        SQLiteDatabase localSQLiteDatabase = b.a();
        String str2 = du.a;
        StringBuilder localStringBuilder = new StringBuilder();
        String str3 = du.c;
        String str4 = str3 + " = ? ";
        String[] arrayOfString = new String[1];
        String str5 = String.valueOf(paramLong);
        arrayOfString[0] = str5;
        int i = localSQLiteDatabase.delete(str2, str4, arrayOfString);
        b.a().setTransactionSuccessful();
        b.a().endTransaction();
        if (0 > 0)
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
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     av
 * JD-Core Version:    0.6.0
 */