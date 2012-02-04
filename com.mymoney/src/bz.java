import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.flurry.android.FlurryAgent;
import java.util.Map;

public class bz extends bt
{
  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    bz localbz = new bz();
    localbz.a(paramSQLiteDatabase);
    return localbz.a();
  }

  public boolean a()
  {
    gj.a("DatabaseUpgrade15", "upgrade database to Version15");
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "0";
    Map localMap = he.b("select syncAccountPassword from t_profile", arrayOfString, null);
    try
    {
      this = (String)localMap.get("syncAccountPassword");
      if (!TextUtils.isEmpty(this))
      {
        String str1 = fz.a(this, "&*($HJDGH4867%&T");
        he.a("update t_profile set syncAccountPassword = " + str1, 0);
      }
      i = 1;
      return i;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        String str2 = localException.getMessage();
        FlurryAgent.onError("AES.encrypt exception(MaintainDaoImpl)", str2, "DatabaseUpgrade15");
        int i = 0;
      }
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     bz
 * JD-Core Version:    0.6.0
 */