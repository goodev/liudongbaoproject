import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mymoney.core.application.ApplicationContext;

public abstract class ar
{
  public static dh b;
  private String a = "BaseAbstractDao";

  public ar()
  {
    b = ApplicationContext.b;
  }

  // ERROR //
  public Object a(String paramString, String[] paramArrayOfString, as paramas)
  {
    // Byte code:
    //   0: invokestatic 29	gt:a	()J
    //   3: lstore 4
    //   5: aload_0
    //   6: getfield 16	ar:a	Ljava/lang/String;
    //   9: astore 6
    //   11: new 31	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   18: ldc 34
    //   20: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore 7
    //   32: aload 6
    //   34: aload 7
    //   36: invokestatic 47	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_2
    //   40: ifnull +53 -> 93
    //   43: aload_0
    //   44: getfield 16	ar:a	Ljava/lang/String;
    //   47: astore 8
    //   49: new 31	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   56: ldc 49
    //   58: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: astore 9
    //   63: aload_2
    //   64: invokestatic 54	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   67: astore 10
    //   69: aload 9
    //   71: aload 10
    //   73: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 56
    //   78: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore 11
    //   86: aload 8
    //   88: aload 11
    //   90: invokestatic 47	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_0
    //   94: invokevirtual 60	ar:g	()Landroid/database/sqlite/SQLiteDatabase;
    //   97: aload_1
    //   98: aload_2
    //   99: invokevirtual 66	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   102: astore 12
    //   104: aload 12
    //   106: astore 13
    //   108: aload_3
    //   109: aload 13
    //   111: invokeinterface 71 2 0
    //   116: astore 14
    //   118: aload_0
    //   119: aload 13
    //   121: invokevirtual 74	ar:a	(Landroid/database/Cursor;)V
    //   124: aload_0
    //   125: aload 13
    //   127: invokevirtual 74	ar:a	(Landroid/database/Cursor;)V
    //   130: aload_0
    //   131: getfield 16	ar:a	Ljava/lang/String;
    //   134: astore 15
    //   136: new 31	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   143: ldc 76
    //   145: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: astore 16
    //   150: invokestatic 29	gt:a	()J
    //   153: lload 4
    //   155: lsub
    //   156: lstore 17
    //   158: aload 16
    //   160: lload 17
    //   162: invokevirtual 79	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   165: ldc 81
    //   167: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore 19
    //   175: aload 15
    //   177: aload 19
    //   179: invokestatic 47	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 14
    //   184: areturn
    //   185: astore 20
    //   187: aconst_null
    //   188: astore 21
    //   190: aload 20
    //   192: astore 22
    //   194: aload_0
    //   195: aload 21
    //   197: invokevirtual 74	ar:a	(Landroid/database/Cursor;)V
    //   200: aload 22
    //   202: invokevirtual 84	android/database/sqlite/SQLiteException:printStackTrace	()V
    //   205: aload 22
    //   207: athrow
    //   208: astore 23
    //   210: aload_0
    //   211: aload 21
    //   213: invokevirtual 74	ar:a	(Landroid/database/Cursor;)V
    //   216: aload_0
    //   217: getfield 16	ar:a	Ljava/lang/String;
    //   220: astore 24
    //   222: new 31	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   229: ldc 76
    //   231: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: astore 25
    //   236: invokestatic 29	gt:a	()J
    //   239: lload 4
    //   241: lsub
    //   242: lstore 26
    //   244: aload 25
    //   246: lload 26
    //   248: invokevirtual 79	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   251: ldc 81
    //   253: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: astore 28
    //   261: aload 24
    //   263: aload 28
    //   265: invokestatic 47	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload 23
    //   270: athrow
    //   271: astore 29
    //   273: aconst_null
    //   274: astore 21
    //   276: aload 29
    //   278: astore 23
    //   280: goto -70 -> 210
    //   283: astore 30
    //   285: aload 13
    //   287: astore 21
    //   289: aload 30
    //   291: astore 23
    //   293: goto -83 -> 210
    //   296: astore 31
    //   298: aload 13
    //   300: astore 21
    //   302: aload 31
    //   304: astore 22
    //   306: goto -112 -> 194
    //
    // Exception table:
    //   from	to	target	type
    //   5	104	185	android/database/sqlite/SQLiteException
    //   194	208	208	finally
    //   5	104	271	finally
    //   108	124	283	finally
    //   108	124	296	android/database/sqlite/SQLiteException
  }

  protected void a(Cursor paramCursor)
  {
    if (paramCursor == null)
      return;
    if (paramCursor.isClosed())
      return;
    paramCursor.close();
  }

  public long c(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase1 = b.a();
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = paramString;
    Cursor localCursor = localSQLiteDatabase1.rawQuery("select idSeed from t_id_seed where tableName = ?", arrayOfString1);
    long l = 65535L;
    while (localCursor.moveToNext())
    {
      int i = localCursor.getColumnIndex("idSeed");
      l = localCursor.getLong(i);
    }
    a(localCursor);
    ContentValues localContentValues = new ContentValues();
    Long localLong = Long.valueOf(1L + l);
    localContentValues.put("idSeed", localLong);
    SQLiteDatabase localSQLiteDatabase2 = b.a();
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = paramString;
    int j = localSQLiteDatabase2.update("t_id_seed", localContentValues, "tableName = ?", arrayOfString2);
    return 0L - l;
  }

  public SQLiteDatabase g()
  {
    return b.a();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ar
 * JD-Core Version:    0.6.0
 */