import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.mymoney.core.application.ApplicationContext;
import java.io.File;

public class gu
{
  public static String A;
  public static String B;
  public static String C;
  public static String D;
  private static SharedPreferences E;
  private static SharedPreferences.Editor F;
  public static String a = "MymoneyPerfencesUtil";
  public static String b = "mymoney_prefences";
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public static String p;
  public static String q;
  public static String r;
  public static String s;
  public static String t;
  public static String u;
  public static String v;
  public static String w;
  public static String x;
  public static String y;
  public static String z;

  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = b;
    c = str1 + ".xml";
    StringBuilder localStringBuilder2 = new StringBuilder().append("/data/data/");
    String str2 = ApplicationContext.a.getPackageName();
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append("/shared_prefs/");
    String str3 = b;
    d = str3 + ".xml";
    e = "flurry_api_key";
    f = "partner_code";
    g = "product_name";
    h = "product_name_for_display";
    i = "device_uuid";
    j = "sync_label";
    k = "sync_time_in_mills";
    l = "offset_time_in_mills";
    m = "sync_time_str";
    n = "last_aotu_check_version_time_in_mills";
    o = "security_password";
    p = "enable_security_password";
    q = "is_new_add_trans_mode";
    r = "last_backup_time_in_mills";
    s = "last_sync_time_in_mills";
    t = "enable_quick_mode";
    u = "restore_original_data";
    v = "is_first_time_enter";
    w = "is_first_time_sync";
    x = "report_filter_report_type";
    y = "report_filter_time_peroid_type";
    z = "report_filter_begin_time";
    A = "report_filter_end_time";
    B = "is_replace_db_continue";
    C = "is_inport_data_from_hd_success";
    D = "meizu_vip_license_pass";
    Context localContext = ApplicationContext.a;
    String str4 = b;
    E = localContext.getSharedPreferences(str4, 0);
    F = E.edit();
  }

  public static String A()
  {
    return a(D);
  }

  public static File a()
  {
    String str = d;
    return new File(str);
  }

  public static String a(String paramString)
  {
    return E.getString(paramString, "");
  }

  public static void a(int paramInt)
  {
    a(x, paramInt);
  }

  public static void a(long paramLong)
  {
    a(z, paramLong);
  }

  public static void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = F.putInt(paramString, paramInt);
    boolean bool = F.commit();
  }

  public static void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = F.putLong(paramString, paramLong);
    boolean bool = F.commit();
  }

  public static void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = F.putString(paramString1, paramString2);
    boolean bool = F.commit();
  }

  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = F.putBoolean(paramString, paramBoolean);
    boolean bool = F.commit();
  }

  public static void a(boolean paramBoolean)
  {
    a(p, paramBoolean);
  }

  public static int b(String paramString)
  {
    return E.getInt(paramString, 0);
  }

  public static int b(String paramString, int paramInt)
  {
    return E.getInt(paramString, paramInt);
  }

  public static void b()
  {
    a(i, "");
    a(j, "");
    a(k, 0L);
    a(l, 0L);
    a(m, "");
    a(p, 0);
    a(t, 0);
    a(o, "");
  }

  public static void b(int paramInt)
  {
    a(y, paramInt);
  }

  public static void b(long paramLong)
  {
    a(A, paramLong);
  }

  public static void b(boolean paramBoolean)
  {
    a(q, paramBoolean);
  }

  public static boolean b(String paramString, boolean paramBoolean)
  {
    return E.getBoolean(paramString, paramBoolean);
  }

  public static long c(String paramString)
  {
    SharedPreferences localSharedPreferences = E;
    long l1 = Long.valueOf(0L).longValue();
    return localSharedPreferences.getLong(paramString, l1);
  }

  public static String c()
  {
    if (TextUtils.isEmpty(a(f)))
    {
      String str1 = f;
      String str2 = gg.a().c();
      a(str1, str2);
    }
    return a(f);
  }

  public static void c(int paramInt)
  {
    a("auto_backup_cycle", paramInt);
  }

  public static void c(boolean paramBoolean)
  {
    a(t, paramBoolean);
  }

  public static String d()
  {
    if (TextUtils.isEmpty(a(g)))
    {
      String str1 = g;
      String str2 = gg.a().d();
      a(str1, str2);
    }
    return a(g);
  }

  public static void d(int paramInt)
  {
    a("update_log_version_code", paramInt);
  }

  public static void d(boolean paramBoolean)
  {
    a(u, paramBoolean);
  }

  public static boolean d(String paramString)
  {
    return E.getBoolean(paramString, 0);
  }

  public static String e()
  {
    if (TextUtils.isEmpty(a(h)))
    {
      String str1 = h;
      String str2 = gg.a().e();
      a(str1, str2);
    }
    return gg.a().e();
  }

  public static void e(int paramInt)
  {
    a("add_trans_drop_down_menu_tips_times", paramInt);
  }

  public static void e(String paramString)
  {
    a(o, paramString);
  }

  public static void e(boolean paramBoolean)
  {
    a(v, paramBoolean);
  }

  public static String f()
  {
    return a(o);
  }

  public static void f(String paramString)
  {
    a("auto_backup_time", paramString);
  }

  public static void f(boolean paramBoolean)
  {
    a(w, paramBoolean);
  }

  public static void g(String paramString)
  {
    a(D, paramString);
  }

  public static void g(boolean paramBoolean)
  {
    a(C, paramBoolean);
  }

  public static boolean g()
  {
    return d(p);
  }

  public static void h(boolean paramBoolean)
  {
    a(B, paramBoolean);
  }

  public static boolean h()
  {
    return b(q, 1);
  }

  public static void i(boolean paramBoolean)
  {
    a("enable_auto_backup", paramBoolean);
  }

  public static boolean i()
  {
    return d(t);
  }

  public static void j(boolean paramBoolean)
  {
    a("is_enable_default_auto_backup", paramBoolean);
  }

  public static boolean j()
  {
    return d(u);
  }

  public static void k(boolean paramBoolean)
  {
    a("enable_add_trans_remind", paramBoolean);
  }

  public static boolean k()
  {
    return b(v, 1);
  }

  public static void l(boolean paramBoolean)
  {
    a("enable_default_add_trans_remind", paramBoolean);
  }

  public static boolean l()
  {
    return b(w, 1);
  }

  public static boolean m()
  {
    return d(B);
  }

  public static boolean n()
  {
    return d(C);
  }

  public static int o()
  {
    return b(x, 1);
  }

  public static int p()
  {
    return b(y, 0);
  }

  public static long q()
  {
    return c(z);
  }

  public static long r()
  {
    return c(A);
  }

  public static boolean s()
  {
    return b("enable_auto_backup", 0);
  }

  public static String t()
  {
    return E.getString("auto_backup_time", "23:00");
  }

  public static int u()
  {
    return b("auto_backup_cycle", 2);
  }

  public static boolean v()
  {
    return E.getBoolean("is_enable_default_auto_backup", 0);
  }

  public static boolean w()
  {
    return b("enable_add_trans_remind", 1);
  }

  public static int x()
  {
    return b("update_log_version_code", -1);
  }

  public static boolean y()
  {
    return b("enable_default_add_trans_remind", 0);
  }

  public static int z()
  {
    return b("add_trans_drop_down_menu_tips_times");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gu
 * JD-Core Version:    0.6.0
 */