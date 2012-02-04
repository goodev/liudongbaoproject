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

public class dh extends SQLiteOpenHelper
{
  public static String a = "mymoney.sqlite";
  public static String b = "mymoney_demo.sqlite";
  public static String c;
  private static SQLiteDatabase g;
  private static String h;
  private String d = "MySQLiteOpenHelper";
  private Context e;
  private Resources f;
  private String i = "";

  static
  {
    StringBuilder localStringBuilder = new StringBuilder().append("/data/data/");
    String str = ApplicationContext.a.getPackageName();
    c = str + "/databases/";
    h = "no tables";
  }

  public dh(Context paramContext)
  {
    super(paramContext, str, null, 1);
    Resources localResources = paramContext.getResources();
    this.f = localResources;
    this.e = paramContext;
  }

  public static File c()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = c;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    String str2 = a;
    String str3 = str2;
    return new File(str3);
  }

  public static void d()
  {
    File localFile1 = c();
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = em.a;
    String str2 = str1 + "mymoney.db";
    File localFile2 = new File(str2);
    gl.a(localFile1, localFile2);
    StringBuilder localStringBuilder2 = new StringBuilder().append("/data/data/");
    String str3 = ApplicationContext.a.getPackageName();
    String str4 = str3;
    File localFile3 = new File(str4);
    StringBuilder localStringBuilder3 = new StringBuilder();
    String str5 = em.a;
    String str6 = str5 + "data";
    File localFile4 = new File(str6);
    wa.a(localFile3, localFile4, 0);
  }

  public SQLiteDatabase a()
  {
    Object localObject;
    InputStream localInputStream;
    FileOutputStream localFileOutputStream;
    if ((g == null) || (!g.isOpen()))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1 = c;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
      String str2 = a;
      localObject = str2;
      String str3 = c;
      boolean bool = new File(str3).mkdirs();
      if (new File((String)localObject).exists())
      {
        g = getWritableDatabase();
        localObject = g;
        return localObject;
      }
      try
      {
        AssetManager localAssetManager = this.f.getAssets();
        String str4 = a;
        localInputStream = localAssetManager.open(str4);
        localFileOutputStream = new FileOutputStream((String)localObject);
        byte[] arrayOfByte = new byte[1024];
        while (true)
        {
          int j = localInputStream.read(arrayOfByte);
          if (j <= 0)
            break;
          localFileOutputStream.write(arrayOfByte, 0, j);
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    while (true)
    {
      g = getWritableDatabase();
      localObject = g;
      break;
      localFileOutputStream.close();
      localInputStream.close();
    }
  }

  public boolean b()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = c;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    String str2 = a;
    String str3 = str2;
    return new File(str3).delete();
  }

  /** @deprecated */
  public void close()
  {
    monitorenter;
    try
    {
      super.close();
      if (g != null)
      {
        if (!g.isOpen())
          break label34;
        g.close();
        g = null;
      }
      while (true)
      {
        return;
        label34: Object localObject1 = null;
        g = localObject1;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    int j = Log.i(this.d, "onCreate()...");
  }

  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    int j = Log.i(this.d, "onOpen()...");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int j = Log.i(this.d, "onUpgrade()...");
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     dh
 * JD-Core Version:    0.6.0
 */