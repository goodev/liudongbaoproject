import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.mymoney.core.application.ApplicationContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class di extends SQLiteOpenHelper
{
  private static SQLiteDatabase c;
  private static final String d;
  private String a = "MySQLiteSyncOpenHelper";
  private Resources b;

  static
  {
    StringBuilder localStringBuilder = new StringBuilder().append("/data/data/");
    String str = ApplicationContext.a.getPackageName();
    d = str + "/databases/";
  }

  public di(Context paramContext)
  {
    super(paramContext, "servermymoney.sqlite", null, 1);
    Resources localResources = paramContext.getResources();
    this.b = localResources;
  }

  public SQLiteDatabase a()
  {
    Object localObject1 = "servermymoney.sqlite";
    Object localObject2;
    InputStream localInputStream;
    if ((c == null) || (!c.isOpen()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str1 = d;
      localObject2 = str1 + "servermymoney.sqlite";
      String str2 = d;
      boolean bool = new File(str2).mkdirs();
      if (new File((String)localObject2).exists())
      {
        c = getWritableDatabase();
        localObject2 = c;
        return localObject2;
      }
      try
      {
        localInputStream = this.b.getAssets().open("servermymoney.sqlite");
        localObject1 = new FileOutputStream((String)localObject2);
        byte[] arrayOfByte = new byte[1024];
        while (true)
        {
          int i = localInputStream.read(arrayOfByte);
          if (i <= 0)
            break;
          ((OutputStream)localObject1).write(arrayOfByte, 0, i);
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    while (true)
    {
      c = getWritableDatabase();
      localObject2 = c;
      break;
      ((OutputStream)localObject1).close();
      localInputStream.close();
    }
  }

  /** @deprecated */
  public void close()
  {
    monitorenter;
    try
    {
      super.close();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = Log.i(this.a, "onCreate()...");
  }

  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = Log.i(this.a, "onOpen()...");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int i = Log.i(this.a, "onUpgrade()...");
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     di
 * JD-Core Version:    0.6.0
 */