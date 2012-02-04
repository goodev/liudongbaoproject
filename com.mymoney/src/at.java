import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mymoney.core.application.ApplicationContext;

public class at extends ar
  implements ae
{
  public static String a = "  select category.categoryPOID as categoryId,          category.name as categoryName ,         category._tempIconName as _tempIconName,          budgetItem.budgetItemPOID as id,         (case when budgetItem.amount is null then 0 else budgetItem.amount end) as amount,          budgetItem.lastUpdateTime as lastUpdateTime  from        (select * from t_category where t_category.type = 0 and t_category.depth = 1 ) as category  left join        t_budget_item as budgetItem  on (category.categoryPOID = budgetItem.categoryPOID  ) ";

  private es b(Cursor paramCursor)
  {
    es locales = new es();
    int i = paramCursor.getColumnIndex("id");
    long l1 = paramCursor.getLong(i);
    locales.b(l1);
    int j = paramCursor.getColumnIndex("amount");
    double d = paramCursor.getDouble(j);
    locales.a(d);
    int k = paramCursor.getColumnIndex("lastUpdateTime");
    long l2 = paramCursor.getLong(k);
    locales.a(l2);
    et localet = new et();
    int m = paramCursor.getColumnIndex("categoryId");
    long l3 = paramCursor.getLong(m);
    localet.a(l3);
    int n = paramCursor.getColumnIndex("categoryName");
    String str1 = paramCursor.getString(n);
    localet.a(str1);
    int i1 = paramCursor.getColumnIndex("_tempIconName");
    String str2 = paramCursor.getString(i1);
    localet.c(str2);
    locales.a(localet);
    return locales;
  }

  public long a(es parames)
  {
    String str1 = dm.a;
    long l1 = c(str1);
    ContentValues localContentValues = new ContentValues();
    String str2 = dm.b;
    Long localLong1 = Long.valueOf(l1);
    localContentValues.put(str2, localLong1);
    String str3 = dm.d;
    Double localDouble = Double.valueOf(parames.c());
    localContentValues.put(str3, localDouble);
    String str4 = dm.e;
    Long localLong2 = Long.valueOf(parames.d().b());
    localContentValues.put(str4, localLong2);
    String str5 = dm.c;
    Long localLong3 = Long.valueOf(ApplicationContext.d);
    localContentValues.put(str5, localLong3);
    if (parames.a() > 0L)
    {
      String str6 = dm.f;
      Long localLong4 = Long.valueOf(parames.a());
      localContentValues.put(str6, localLong4);
    }
    while (true)
    {
      SQLiteDatabase localSQLiteDatabase = b.a();
      String str7 = dm.a;
      long l2 = localSQLiteDatabase.insert(str7, null, localContentValues);
      return l1;
      String str8 = dm.f;
      Long localLong5 = Long.valueOf(gt.f());
      localContentValues.put(str8, localLong5);
    }
  }

  public es a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(" select budgetItemPOID,tradingEntityPOID,amount,categoryPOID,lastUpdateTime from t_budget_item where categoryPOID = ");
    int i = es.a;
    String str = i;
    Cursor localCursor = b.a().rawQuery(str, null);
    es locales = null;
    while (localCursor.moveToNext())
    {
      locales = new es();
      int j = localCursor.getColumnIndex("budgetItemPOID");
      long l1 = localCursor.getLong(j);
      locales.b(l1);
      int k = localCursor.getColumnIndex("amount");
      double d = localCursor.getDouble(k);
      locales.a(d);
      int m = localCursor.getColumnIndex("lastUpdateTime");
      long l2 = localCursor.getLong(m);
      locales.a(l2);
    }
    a(localCursor);
    return locales;
  }

  public boolean a(double paramDouble)
  {
    ContentValues localContentValues = new ContentValues();
    String str1 = dm.d;
    Double localDouble = Double.valueOf(paramDouble);
    localContentValues.put(str1, localDouble);
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = dm.e;
    String str3 = str2 + " = ?";
    String[] arrayOfString = new String[1];
    String str4 = String.valueOf(es.a);
    arrayOfString[0] = str4;
    SQLiteDatabase localSQLiteDatabase = b.a();
    String str5 = dm.a;
    if (localSQLiteDatabase.update(str5, localContentValues, str3, arrayOfString) != 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = dm.e;
    String str2 = str1 + " = ?";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    SQLiteDatabase localSQLiteDatabase = b.a();
    String str4 = dm.a;
    if (localSQLiteDatabase.delete(str4, str2, arrayOfString) > 0L);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean a(es parames, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = dm.b;
    String str2 = str1 + " = ?";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(parames.b());
    arrayOfString[0] = str3;
    ContentValues localContentValues = new ContentValues();
    String str4 = dm.d;
    Double localDouble = Double.valueOf(parames.c());
    localContentValues.put(str4, localDouble);
    if (paramBoolean)
    {
      String str5 = dm.f;
      Long localLong1 = Long.valueOf(parames.a());
      localContentValues.put(str5, localLong1);
      SQLiteDatabase localSQLiteDatabase = b.a();
      String str6 = dm.a;
      if (localSQLiteDatabase.update(str6, localContentValues, str2, arrayOfString) <= 0L)
        break label174;
    }
    label174: for (int i = 1; ; i = 0)
    {
      return i;
      String str7 = dm.f;
      Long localLong2 = Long.valueOf(gt.f());
      localContentValues.put(str7, localLong2);
      break;
    }
  }

  // ERROR //
  public double b()
  {
    // Byte code:
    //   0: new 153	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   7: ldc 206
    //   9: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: astore_1
    //   13: getstatic 77	dm:a	Ljava/lang/String;
    //   16: astore_2
    //   17: aload_1
    //   18: aload_2
    //   19: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 208
    //   24: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: astore_3
    //   28: getstatic 112	dm:e	Ljava/lang/String;
    //   31: astore 4
    //   33: aload_3
    //   34: aload 4
    //   36: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 210
    //   41: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: astore 5
    //   46: getstatic 163	es:a	I
    //   49: istore 6
    //   51: aload 5
    //   53: iload 6
    //   55: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 7
    //   63: ldc2_w 128
    //   66: lstore 8
    //   68: getstatic 135	at:b	Ldh;
    //   71: invokevirtual 140	dh:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   74: aload 7
    //   76: aconst_null
    //   77: invokevirtual 174	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore 10
    //   82: aload 10
    //   84: astore 11
    //   86: aload 11
    //   88: invokeinterface 178 1 0
    //   93: ifeq +32 -> 125
    //   96: aload 11
    //   98: ldc 212
    //   100: invokeinterface 30 2 0
    //   105: istore 12
    //   107: aload 11
    //   109: iload 12
    //   111: invokeinterface 43 2 0
    //   116: dstore 10
    //   118: dload 10
    //   120: dstore 8
    //   122: goto -36 -> 86
    //   125: aload_0
    //   126: aload 11
    //   128: invokevirtual 183	at:a	(Landroid/database/Cursor;)V
    //   131: lload 8
    //   133: lreturn
    //   134: astore 13
    //   136: aconst_null
    //   137: astore 14
    //   139: aload_0
    //   140: aload 14
    //   142: invokevirtual 183	at:a	(Landroid/database/Cursor;)V
    //   145: aload 13
    //   147: athrow
    //   148: astore 15
    //   150: aload 11
    //   152: astore 14
    //   154: aload 15
    //   156: astore 13
    //   158: goto -19 -> 139
    //
    // Exception table:
    //   from	to	target	type
    //   68	82	134	finally
    //   86	118	148	finally
  }

  public es b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = a;
    String str2 = str1 + " where budgetItem.categoryPOID = ?" + " order by category.ordered asc";
    String[] arrayOfString = new String[1];
    String str3 = String.valueOf(paramLong);
    arrayOfString[0] = str3;
    Cursor localCursor = b.a().rawQuery(str2, arrayOfString);
    for (es locales = null; localCursor.moveToNext(); locales = b(localCursor));
    a(localCursor);
    return locales;
  }

  // ERROR //
  public java.util.List c()
  {
    // Byte code:
    //   0: new 153	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: getstatic 14	at:a	Ljava/lang/String;
    //   11: astore_2
    //   12: aload_1
    //   13: aload_2
    //   14: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc 217
    //   19: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: astore_3
    //   26: getstatic 135	at:b	Ldh;
    //   29: invokevirtual 140	dh:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: aload_3
    //   33: aconst_null
    //   34: invokevirtual 174	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore 4
    //   39: aload 4
    //   41: astore_3
    //   42: aload_3
    //   43: invokeinterface 224 1 0
    //   48: istore 5
    //   50: new 226	java/util/ArrayList
    //   53: dup
    //   54: iload 5
    //   56: invokespecial 229	java/util/ArrayList:<init>	(I)V
    //   59: astore 6
    //   61: aload_3
    //   62: invokeinterface 178 1 0
    //   67: ifeq +42 -> 109
    //   70: aload_0
    //   71: aload_3
    //   72: invokespecial 219	at:b	(Landroid/database/Cursor;)Les;
    //   75: astore 7
    //   77: aload 6
    //   79: aload 7
    //   81: invokeinterface 235 2 0
    //   86: istore 8
    //   88: goto -27 -> 61
    //   91: astore 9
    //   93: aload_3
    //   94: astore 10
    //   96: aload 9
    //   98: astore 11
    //   100: aload_0
    //   101: aload 10
    //   103: invokevirtual 183	at:a	(Landroid/database/Cursor;)V
    //   106: aload 11
    //   108: athrow
    //   109: aload_0
    //   110: aload_3
    //   111: invokevirtual 183	at:a	(Landroid/database/Cursor;)V
    //   114: aload 6
    //   116: areturn
    //   117: astore 11
    //   119: aconst_null
    //   120: astore 10
    //   122: goto -22 -> 100
    //
    // Exception table:
    //   from	to	target	type
    //   42	88	91	finally
    //   26	39	117	finally
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     at
 * JD-Core Version:    0.6.0
 */