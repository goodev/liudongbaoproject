import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import java.util.List;

public class ua
{
  Context a;
  AlertDialog.Builder b;
  List c;
  String d = "";
  String e;
  String f;
  String g;
  boolean h = 0;
  boolean i = 0;
  int j = 0;
  ty k = null;
  String l = "确定";
  String m = "取消";
  boolean n = 0;
  boolean o = 0;
  private ty[] p = null;

  public ua(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramContext;
    this.g = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    b();
  }

  private void b()
  {
    Context localContext = this.a;
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext);
    this.b = localBuilder1;
    if (this.g == null)
      return;
    AlertDialog.Builder localBuilder2 = this.b;
    String str = this.g;
    AlertDialog.Builder localBuilder3 = localBuilder2.setTitle(str);
  }

  public long a()
  {
    return Long.parseLong(this.k.a());
  }

  public AlertDialog a(uf paramuf)
  {
    List localList = this.c;
    String str1 = this.e;
    String str2 = this.f;
    ty[] arrayOfty1 = ty.a(localList, str1, str2);
    this.p = arrayOfty1;
    int i1 = 0;
    while (true)
    {
      int i2 = this.p.length;
      if (i1 < i2)
      {
        String str3 = this.p[i1].a();
        String str4 = this.d;
        if (str3.equals(str4))
          this.j = i1;
      }
      else
      {
        AlertDialog.Builder localBuilder1 = this.b;
        ty[] arrayOfty2 = this.p;
        int i3 = this.j;
        ub localub = new ub(this, paramuf);
        AlertDialog.Builder localBuilder2 = localBuilder1.setSingleChoiceItems(arrayOfty2, i3, localub);
        if (this.n)
        {
          AlertDialog.Builder localBuilder3 = this.b;
          String str5 = this.l;
          uc localuc = new uc(this, paramuf);
          AlertDialog.Builder localBuilder4 = localBuilder3.setPositiveButton(str5, localuc);
        }
        if (this.o)
        {
          AlertDialog.Builder localBuilder5 = this.b;
          String str6 = this.m;
          ud localud = new ud(this, paramuf);
          AlertDialog.Builder localBuilder6 = localBuilder5.setNegativeButton(str6, localud);
        }
        return this.b.create();
      }
      i1 += 1;
    }
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public void a(List paramList)
  {
    this.c = paramList;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ua
 * JD-Core Version:    0.6.0
 */