import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.mymoney.core.application.ApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class he
{
  public static final List a(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = null;
    if (paramSQLiteDatabase == null);
    while (true)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase1 = ApplicationContext.b.a();
        localCursor = localSQLiteDatabase1.rawQuery(paramString, paramArrayOfString2);
        localSQLiteDatabase1 = null;
        if (localCursor.moveToNext())
        {
          if (localSQLiteDatabase1 != null)
            continue;
          int i = localCursor.getColumnCount();
          HashMap localHashMap = new HashMap(i);
          int j = null;
          if (j >= i)
            continue;
          String str1 = paramArrayOfString1[j];
          if (!str1.equals("1"))
            continue;
          str1 = gx.a(Long.valueOf(localCursor.getLong(j)));
          String str2 = gx.b(localCursor.getColumnName(j).toLowerCase());
          Object localObject1 = localHashMap.put(str2, str1);
          j = j + 1;
          continue;
          if (!str1.equals("2"))
            continue;
          str1 = gx.a(Double.valueOf(localCursor.getDouble(j)));
          continue;
          str1 = gx.a(localCursor.getString(j));
          continue;
          boolean bool = localArrayList.add(localHashMap);
          continue;
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        a(localCursor);
        localSQLiteException.printStackTrace();
        throw localSQLiteException;
      }
      finally
      {
        a(localCursor);
      }
      a(localCursor);
      a(localCursor);
      return localSQLiteException;
      SQLiteDatabase localSQLiteDatabase2 = paramSQLiteDatabase;
    }
  }

  public static final List a(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    return a(null, paramString, paramArrayOfString1, paramArrayOfString2);
  }

  private static final void a(Cursor paramCursor)
  {
    if (paramCursor == null)
      return;
    try
    {
      if (paramCursor.isClosed())
        return;
      paramCursor.close();
      return;
    }
    catch (Exception localException)
    {
      gj.a("DbUtil", "close cursor error");
    }
  }

  public static final void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
      ApplicationContext.b.a().beginTransaction();
    try
    {
      ApplicationContext.b.a().execSQL(paramString);
      if (paramBoolean)
        ApplicationContext.b.a().setTransactionSuccessful();
      if (!paramBoolean)
        return;
      ApplicationContext.b.a().endTransaction();
      return;
    }
    finally
    {
      if (paramBoolean)
        ApplicationContext.b.a().endTransaction();
    }
    throw localObject;
  }

  public static final void a(List paramList, boolean paramBoolean)
  {
    if (paramList.isEmpty())
      return;
    if (paramBoolean)
      ApplicationContext.b.a().beginTransaction();
    try
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ApplicationContext.b.a().execSQL(str);
      }
    }
    finally
    {
      if (paramBoolean)
        ApplicationContext.b.a().endTransaction();
    }
    if (paramBoolean)
      ApplicationContext.b.a().setTransactionSuccessful();
    if (!paramBoolean)
      return;
    ApplicationContext.b.a().endTransaction();
  }

  // ERROR //
  public static final Map b(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 44	java/util/HashMap
    //   5: dup
    //   6: bipush 10
    //   8: invokespecial 47	java/util/HashMap:<init>	(I)V
    //   11: astore 4
    //   13: aconst_null
    //   14: astore 5
    //   16: getstatic 21	com/mymoney/core/application/ApplicationContext:b	Ldh;
    //   19: invokevirtual 26	dh:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: aload_0
    //   23: aload_2
    //   24: invokevirtual 32	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 6
    //   29: aload 6
    //   31: astore 5
    //   33: aload 5
    //   35: invokeinterface 38 1 0
    //   40: ifeq +134 -> 174
    //   43: iconst_0
    //   44: ifne +202 -> 246
    //   47: aload 5
    //   49: invokeinterface 42 1 0
    //   54: istore 7
    //   56: aload_3
    //   57: aload 7
    //   59: if_icmpge +115 -> 174
    //   62: aload_1
    //   63: aload_3
    //   64: aaload
    //   65: astore 8
    //   67: aload 8
    //   69: ldc 49
    //   71: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   74: ifeq +55 -> 129
    //   77: aload 5
    //   79: aload_3
    //   80: invokeinterface 59 2 0
    //   85: invokestatic 65	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   88: invokestatic 70	gx:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   91: astore 8
    //   93: aload 5
    //   95: aload_3
    //   96: invokeinterface 74 2 0
    //   101: invokevirtual 78	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   104: invokestatic 81	gx:b	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 9
    //   109: aload 4
    //   111: aload 9
    //   113: aload 8
    //   115: invokeinterface 87 3 0
    //   120: astore 10
    //   122: aload_3
    //   123: iconst_1
    //   124: iadd
    //   125: istore_3
    //   126: goto -70 -> 56
    //   129: aload 8
    //   131: ldc 89
    //   133: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   136: ifeq +22 -> 158
    //   139: aload 5
    //   141: aload_3
    //   142: invokeinterface 93 2 0
    //   147: invokestatic 98	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   150: invokestatic 70	gx:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   153: astore 8
    //   155: goto -62 -> 93
    //   158: aload 5
    //   160: aload_3
    //   161: invokeinterface 101 2 0
    //   166: invokestatic 70	gx:a	(Ljava/lang/Object;)Ljava/lang/String;
    //   169: astore 8
    //   171: goto -78 -> 93
    //   174: aload 5
    //   176: invokestatic 109	he:a	(Landroid/database/Cursor;)V
    //   179: aload 5
    //   181: invokestatic 109	he:a	(Landroid/database/Cursor;)V
    //   184: aload 4
    //   186: areturn
    //   187: astore 11
    //   189: aconst_null
    //   190: astore 7
    //   192: aload 11
    //   194: astore 5
    //   196: aload 7
    //   198: invokestatic 109	he:a	(Landroid/database/Cursor;)V
    //   201: aload 5
    //   203: invokevirtual 112	android/database/sqlite/SQLiteException:printStackTrace	()V
    //   206: aload 7
    //   208: invokestatic 109	he:a	(Landroid/database/Cursor;)V
    //   211: goto -27 -> 184
    //   214: astore 12
    //   216: aload 5
    //   218: invokestatic 109	he:a	(Landroid/database/Cursor;)V
    //   221: aload 12
    //   223: athrow
    //   224: astore 12
    //   226: aload 7
    //   228: astore 5
    //   230: goto -14 -> 216
    //   233: astore 13
    //   235: aload 5
    //   237: astore 7
    //   239: aload 13
    //   241: astore 5
    //   243: goto -47 -> 196
    //   246: aconst_null
    //   247: astore 7
    //   249: goto -193 -> 56
    //
    // Exception table:
    //   from	to	target	type
    //   16	29	187	android/database/sqlite/SQLiteException
    //   16	29	214	finally
    //   33	179	214	finally
    //   196	206	224	finally
    //   33	179	233	android/database/sqlite/SQLiteException
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     he
 * JD-Core Version:    0.6.0
 */