import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.flurry.android.FlurryAgent;

public class az extends ar
  implements al
{
  private static String a = "ProfileDaoImpl";

  private ContentValues b(ex paramex)
  {
    ContentValues localContentValues = new ContentValues();
    String str1 = dr.b;
    Long localLong1 = Long.valueOf(paramex.a());
    localContentValues.put(str1, localLong1);
    String str2 = dr.e;
    Long localLong2 = Long.valueOf(paramex.e());
    localContentValues.put(str2, localLong2);
    String str3 = dr.f;
    Long localLong3 = Long.valueOf(paramex.c());
    localContentValues.put(str3, localLong3);
    String str4 = dr.g;
    Long localLong4 = Long.valueOf(paramex.d());
    localContentValues.put(str4, localLong4);
    String str5 = dr.d;
    Long localLong5 = Long.valueOf(paramex.f());
    localContentValues.put(str5, localLong5);
    String str6 = dr.c;
    Long localLong6 = Long.valueOf(paramex.b());
    localContentValues.put(str6, localLong6);
    String str7 = dr.h;
    String str8 = paramex.g();
    localContentValues.put(str7, str8);
    String str9 = dr.i;
    String str10 = paramex.h();
    localContentValues.put(str9, str10);
    Object localObject = paramex.i();
    if (TextUtils.isEmpty((CharSequence)localObject))
      localObject = "";
    while (true)
    {
      String str11 = dr.j;
      localContentValues.put(str11, (String)localObject);
      Integer localInteger1 = Integer.valueOf(paramex.l());
      localContentValues.put("weekStart", localInteger1);
      Integer localInteger2 = Integer.valueOf(paramex.m());
      localContentValues.put("monthStart", localInteger2);
      Long localLong7 = Long.valueOf(paramex.n());
      localContentValues.put("lastUpdateTime", localLong7);
      return localContentValues;
      try
      {
        String str12 = fz.a((String)localObject, "&*($HJDGH4867%&T");
        localObject = str12;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        String str13 = localException.getMessage();
        String str14 = a;
        FlurryAgent.onError("AES.encrypt exception", str13, str14);
      }
    }
  }

  public ex a(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = b.a();
    String[] arrayOfString = new String[1];
    String str1 = String.valueOf(paramLong);
    arrayOfString[0] = str1;
    Cursor localCursor = localSQLiteDatabase.rawQuery(" select tradingEntityPOID,defaultCorporationPOID,defaultCategoryPOID,defaultIncomeCategoryPOID,defaultProjectCategoryPOID,defaultAccountPOID,defaultCurrencyCode,   syncAccountName,syncAccountPassword,syncAccountBind,syncRedirectIP,weekStart,monthStart,lastUpdateTime from t_profile where tradingEntityPOID = ?", arrayOfString);
    ex localex = null;
    if (localCursor.moveToNext())
    {
      localex = new ex();
      localex.a(paramLong);
      String str2 = dr.c;
      int i = localCursor.getColumnIndex(str2);
      long l1 = localCursor.getLong(i);
      localex.b(l1);
      String str3 = dr.d;
      int j = localCursor.getColumnIndex(str3);
      long l2 = localCursor.getLong(j);
      localex.f(l2);
      String str4 = dr.e;
      int k = localCursor.getColumnIndex(str4);
      long l3 = localCursor.getLong(k);
      localex.e(l3);
      String str5 = dr.f;
      int m = localCursor.getColumnIndex(str5);
      long l4 = localCursor.getLong(m);
      localex.c(l4);
      String str6 = dr.g;
      int n = localCursor.getColumnIndex(str6);
      long l5 = localCursor.getLong(n);
      localex.d(l5);
      String str7 = dr.h;
      int i1 = localCursor.getColumnIndex(str7);
      String str8 = localCursor.getString(i1);
      localex.a(str8);
      String str9 = dr.i;
      int i2 = localCursor.getColumnIndex(str9);
      String str10 = localCursor.getString(i2);
      localex.b(str10);
      String str11 = dr.j;
      int i3 = localCursor.getColumnIndex(str11);
      Object localObject = gx.a(localCursor.getString(i3));
      if (TextUtils.isEmpty((CharSequence)localObject))
        localObject = "";
      while (true)
      {
        localex.c((String)localObject);
        String str12 = dr.l;
        int i4 = localCursor.getColumnIndex(str12);
        String str13 = localCursor.getString(i4);
        localex.d(str13);
        String str14 = dr.m;
        int i5 = localCursor.getColumnIndex(str14);
        String str15 = localCursor.getString(i5);
        localex.e(str15);
        int i6 = localCursor.getColumnIndex("weekStart");
        int i7 = localCursor.getInt(i6);
        localex.a(i7);
        int i8 = localCursor.getColumnIndex("monthStart");
        int i9 = localCursor.getInt(i8);
        localex.b(i9);
        int i10 = localCursor.getColumnIndex("lastUpdateTime");
        long l6 = localCursor.getLong(i10);
        localex.g(l6);
        break;
        try
        {
          String str16 = fz.b((String)localObject, "&*($HJDGH4867%&T");
          localObject = str16;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          String str17 = localException.getMessage();
          String str18 = a;
          FlurryAgent.onError("AES.decrypt exception", str17, str18);
        }
      }
    }
    a(localCursor);
    return (ex)localex;
  }

  public boolean a(ex paramex)
  {
    ContentValues localContentValues = b(paramex);
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = dr.b;
    String str2 = str1 + " = ?";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramex.a());
    arrayOfString[0] = str3;
    SQLiteDatabase localSQLiteDatabase = b.a();
    String str4 = dr.a;
    if (localSQLiteDatabase.update(str4, localContentValues, str2, arrayOfString) > 0);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     az
 * JD-Core Version:    0.6.0
 */