import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class aw extends ar
  implements ah
{
  private ev b(Cursor paramCursor)
  {
    ev localev = new ev();
    String str1 = do.b;
    int i = paramCursor.getColumnIndex(str1);
    int j = paramCursor.getInt(i);
    localev.a(j);
    String str2 = do.c;
    int k = paramCursor.getColumnIndex(str2);
    String str3 = paramCursor.getString(k);
    localev.a(str3);
    String str4 = do.d;
    int m = paramCursor.getColumnIndex(str4);
    String str5 = paramCursor.getString(m);
    localev.b(str5);
    String str6 = do.e;
    int n = paramCursor.getColumnIndex(str6);
    String str7 = paramCursor.getString(n);
    localev.c(str7);
    return localev;
  }

  private ew c(Cursor paramCursor)
  {
    ew localew = new ew();
    String str1 = dp.b;
    int i = paramCursor.getColumnIndex(str1);
    long l = paramCursor.getInt(i);
    localew.a(l);
    String str2 = dp.c;
    int j = paramCursor.getColumnIndex(str2);
    String str3 = paramCursor.getString(j);
    localew.a(str3);
    String str4 = dp.d;
    int k = paramCursor.getColumnIndex(str4);
    String str5 = paramCursor.getString(k);
    localew.b(str5);
    String str6 = dp.e;
    int m = paramCursor.getColumnIndex(str6);
    double d = paramCursor.getDouble(m);
    localew.a(d);
    String str7 = dp.f;
    int n = paramCursor.getColumnIndex(str7);
    int i1 = paramCursor.getInt(n);
    int i2 = ew.b;
    if (i1 == i2);
    int i4;
    for (int i3 = 1; ; i4 = 0)
    {
      localew.a(i3);
      return localew;
    }
  }

  public ev a(long paramLong)
  {
    ev localev = null;
    String[] arrayOfString = new String[1];
    String str = String.valueOf(paramLong);
    arrayOfString[0] = str;
    Cursor localCursor = b.a().rawQuery("select currencyPOID,code,name,icon from t_currency where currencyPOID = ? ", arrayOfString);
    while (localCursor.moveToNext())
      localev = b(localCursor);
    a(localCursor);
    return localev;
  }

  public ev a(String paramString)
  {
    ev localev = null;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString;
    Cursor localCursor = b.a().rawQuery("select currencyPOID,code,name,icon from t_currency where code = ? ", arrayOfString);
    while (localCursor.moveToNext())
      localev = b(localCursor);
    a(localCursor);
    return localev;
  }

  public List a()
  {
    String[] arrayOfString = new String[0];
    Cursor localCursor = b.a().rawQuery("select currencyPOID,code,name,icon from t_currency order by currencyPOID", arrayOfString);
    int i = localCursor.getCount();
    ArrayList localArrayList = new ArrayList(i);
    while (localCursor.moveToNext())
    {
      ev localev = b(localCursor);
      boolean bool = localArrayList.add(localev);
    }
    a(localCursor);
    return localArrayList;
  }

  public boolean a(long paramLong, double paramDouble, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    String str1 = dp.e;
    Double localDouble = Double.valueOf(paramDouble);
    localContentValues.put(str1, localDouble);
    String str2 = dp.f;
    int i;
    if (paramBoolean)
    {
      i = ew.b;
      Integer localInteger = Integer.valueOf(i);
      localContentValues.put(str2, localInteger);
      StringBuilder localStringBuilder = new StringBuilder();
      String str3 = dp.b;
      String str4 = str3 + " = ? ";
      SQLiteDatabase localSQLiteDatabase = b.a();
      String str5 = dp.a;
      String[] arrayOfString = new String[1];
      String str6 = String.valueOf(paramLong);
      arrayOfString[0] = str6;
      if (localSQLiteDatabase.update(str5, localContentValues, str4, arrayOfString) <= 0)
        break label152;
    }
    label152: for (int j = 1; ; j = 0)
    {
      return j;
      i = ew.a;
      break;
    }
  }

  public List b(String paramString)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString;
    arrayOfString[1] = paramString;
    Cursor localCursor = b.a().rawQuery("select exchangePOID,sell,buy,rate,manualSetting from t_exchange where sell != ? and buy = ? order by exchangePOID", arrayOfString);
    int i = localCursor.getCount();
    ArrayList localArrayList = new ArrayList(i);
    while (localCursor.moveToNext())
    {
      ew localew = c(localCursor);
      boolean bool = localArrayList.add(localew);
    }
    a(localCursor);
    return localArrayList;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     aw
 * JD-Core Version:    0.6.0
 */