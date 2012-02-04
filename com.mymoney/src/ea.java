import java.util.ArrayList;

public class ea
{
  public static String b;
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
  private static ea w;
  private static Object x = new Object();
  public ArrayList a;

  static
  {
    b = "com.mymoney.addTransaction";
    c = "com.mymoney.updateTransaction";
    d = "com.mymoney.deleteTransaction";
    e = "com.mymoney.addAccount";
    f = "com.mymoney.updateAccount";
    g = "com.mymoney.deleteAccount";
    h = "com.mymoney.addCorporation";
    i = "com.mymoney.updateCorporation";
    j = "com.mymoney.deleteCorporation";
    k = "com.mymoney.addCategory";
    l = "com.mymoney.updateCategory";
    m = "com.mymoney.deleteCategory";
    n = "com.mymoney.addBudgetItem";
    o = "com.mymoney.updateBudgetItem";
    p = "com.mymoney.deleteBudgetItem";
    q = "com.mymoney.updateExchangeRate";
    r = "com.mymoney.updateDefaultCurrency";
    s = "com.mymoney.syncSuccess";
    t = "com.mymoney.restoreOriginalData";
    u = "com.mymoney.restoreData";
    v = "com.mymoney.reportSettingChange";
  }

  private ea()
  {
    ArrayList localArrayList1 = new ArrayList();
    this.a = localArrayList1;
    ArrayList localArrayList2 = this.a;
    String str1 = b;
    boolean bool1 = localArrayList2.add(str1);
    ArrayList localArrayList3 = this.a;
    String str2 = c;
    boolean bool2 = localArrayList3.add(str2);
    ArrayList localArrayList4 = this.a;
    String str3 = d;
    boolean bool3 = localArrayList4.add(str3);
    ArrayList localArrayList5 = this.a;
    String str4 = e;
    boolean bool4 = localArrayList5.add(str4);
    ArrayList localArrayList6 = this.a;
    String str5 = f;
    boolean bool5 = localArrayList6.add(str5);
    ArrayList localArrayList7 = this.a;
    String str6 = g;
    boolean bool6 = localArrayList7.add(str6);
    ArrayList localArrayList8 = this.a;
    String str7 = h;
    boolean bool7 = localArrayList8.add(str7);
    ArrayList localArrayList9 = this.a;
    String str8 = i;
    boolean bool8 = localArrayList9.add(str8);
    ArrayList localArrayList10 = this.a;
    String str9 = j;
    boolean bool9 = localArrayList10.add(str9);
    ArrayList localArrayList11 = this.a;
    String str10 = k;
    boolean bool10 = localArrayList11.add(str10);
    ArrayList localArrayList12 = this.a;
    String str11 = l;
    boolean bool11 = localArrayList12.add(str11);
    ArrayList localArrayList13 = this.a;
    String str12 = m;
    boolean bool12 = localArrayList13.add(str12);
    ArrayList localArrayList14 = this.a;
    String str13 = n;
    boolean bool13 = localArrayList14.add(str13);
    ArrayList localArrayList15 = this.a;
    String str14 = o;
    boolean bool14 = localArrayList15.add(str14);
    ArrayList localArrayList16 = this.a;
    String str15 = p;
    boolean bool15 = localArrayList16.add(str15);
    ArrayList localArrayList17 = this.a;
    String str16 = q;
    boolean bool16 = localArrayList17.add(str16);
    ArrayList localArrayList18 = this.a;
    String str17 = r;
    boolean bool17 = localArrayList18.add(str17);
    ArrayList localArrayList19 = this.a;
    String str18 = s;
    boolean bool18 = localArrayList19.add(str18);
    ArrayList localArrayList20 = this.a;
    String str19 = t;
    boolean bool19 = localArrayList20.add(str19);
    ArrayList localArrayList21 = this.a;
    String str20 = u;
    boolean bool20 = localArrayList21.add(str20);
    ArrayList localArrayList22 = this.a;
    String str21 = v;
    boolean bool21 = localArrayList22.add(str21);
    boolean bool22 = this.a.add("com.mymoney.monthWeekStartChange");
  }

  public static ea a()
  {
    if (w == null);
    synchronized (x)
    {
      w = new ea();
      return w;
    }
  }

  public boolean a(String paramString)
  {
    return this.a.contains(paramString);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ea
 * JD-Core Version:    0.6.0
 */