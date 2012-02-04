import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class bw extends bt
{
  static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("update ").append(paramString1).append(" set ").append(paramString2).append(" = (0 - ").append(paramString2).append(")");
    String str = " where " + paramString2 + " > 0";
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str);
    return localStringBuilder1.toString();
  }

  public static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    bw localbw = new bw();
    localbw.a(paramSQLiteDatabase);
    return localbw.a();
  }

  public boolean a()
  {
    gj.a("DatabaseUpgrade12", "upgrade database to Version12");
    ArrayList localArrayList = new ArrayList(50);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "0";
    if (TextUtils.isEmpty((CharSequence)he.b("select synclabel from t_profile", arrayOfString, null).get("synclabel")))
    {
      String str1 = a("t_transaction_projectcategory_map", "projectCategoryPOID");
      boolean bool1 = localArrayList.add(str1);
      String str2 = a("t_transaction_projectcategory_map", "transactionPOID");
      boolean bool2 = localArrayList.add(str2);
    }
    String str3 = "update t_profile set syncLabel = '" + "" + "'";
    boolean bool3 = localArrayList.add(str3);
    he.a(localArrayList, 1);
    localArrayList.clear();
    return true;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     bw
 * JD-Core Version:    0.6.0
 */