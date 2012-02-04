import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ts
{
  Context a;
  AlertDialog.Builder b;
  List c;
  String[] d = null;
  String e;
  String f;
  String g;
  boolean h;
  boolean i = 0;
  boolean j = 0;
  String k = "确定";
  String l = "取消";
  boolean m = 1;
  boolean n = 0;
  private ty[] o = null;
  private boolean[] p = null;

  public ts(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramContext;
    this.h = paramBoolean1;
    this.i = paramBoolean2;
    this.g = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    c();
  }

  private void c()
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

  public AlertDialog a(tx paramtx)
  {
    List localList = this.c;
    String str1 = this.e;
    String str2 = this.f;
    ty[] arrayOfty1 = ty.a(localList, str1, str2);
    this.o = arrayOfty1;
    boolean[] arrayOfBoolean = null;
    if (this.i)
    {
      arrayOfBoolean = new boolean[this.o.length];
      int i1 = 0;
      while (true)
      {
        int i2 = this.o.length;
        if (i1 >= i2)
          break;
        ty localty1 = this.o[i1];
        arrayOfBoolean[i1] = true;
        localty1.a(1);
        i1 += 1;
      }
    }
    int i3;
    ty localty2;
    int i5;
    if (this.d != null)
    {
      arrayOfBoolean = new boolean[this.o.length];
      i3 = 0;
      int i4 = this.o.length;
      if (i3 < i4)
      {
        localty2 = this.o[i3];
        i5 = 0;
        label143: int i6 = this.d.length;
        if (i5 >= i6)
          break label383;
        String str3 = localty2.a();
        String str4 = this.d[i5];
        if (!str3.equals(str4));
      }
    }
    label383: int i8;
    for (int i7 = 1; ; i8 = 0)
    {
      arrayOfBoolean[i3] = i7;
      localty2.a(i7);
      i3 += 1;
      break;
      i5 += 1;
      break label143;
      if (this.h)
      {
        ty[] arrayOfty2 = this.o;
        boolean bool = this.h;
        if (ty.a(arrayOfty2, bool))
        {
          arrayOfBoolean[0] = true;
          this.o[0].a(1);
        }
      }
      AlertDialog.Builder localBuilder1 = this.b;
      ty[] arrayOfty3 = this.o;
      tt localtt = new tt(this, paramtx);
      AlertDialog.Builder localBuilder2 = localBuilder1.setMultiChoiceItems(arrayOfty3, arrayOfBoolean, localtt);
      AlertDialog.Builder localBuilder3 = this.b;
      String str5 = this.k;
      tu localtu = new tu(this, paramtx);
      AlertDialog.Builder localBuilder4 = localBuilder3.setPositiveButton(str5, localtu);
      if (this.n)
      {
        AlertDialog.Builder localBuilder5 = this.b;
        String str6 = this.l;
        tv localtv = new tv(this, paramtx);
        AlertDialog.Builder localBuilder6 = localBuilder5.setNegativeButton(str6, localtv);
      }
      return this.b.create();
    }
  }

  public void a(List paramList)
  {
    if (this.h)
    {
      HashMap localHashMap = new HashMap();
      String str1 = this.e;
      Object localObject1 = localHashMap.put(str1, "allChecked");
      String str2 = this.f;
      Object localObject2 = localHashMap.put(str2, "全部选择");
      paramList.add(0, localHashMap);
    }
    this.c = paramList;
  }

  public long[] a()
  {
    ArrayList localArrayList = new ArrayList();
    int i2;
    if ((this.h) && (this.o[0].d))
    {
      i2 = 1;
      while (true)
      {
        int i3 = this.o.length;
        if (i2 >= i3)
          break;
        Long localLong1 = Long.valueOf(Long.parseLong(this.o[i2].a()));
        boolean bool1 = localArrayList.add(localLong1);
        i2 += 1;
      }
      this.j = 1;
      if (!localArrayList.isEmpty())
        break label154;
    }
    label154: int i6;
    for (int i1 = 0; ; i1 = i6)
    {
      return i1;
      i2 = 0;
      while (true)
      {
        int i4 = this.o.length;
        if (i2 >= i4)
          break;
        ty localty = this.o[i2];
        if (localty.d)
        {
          Long localLong2 = Long.valueOf(Long.parseLong(localty.a()));
          boolean bool2 = i1.add(localLong2);
        }
        i2 += 1;
      }
      i6 = i1.size();
      int i5 = 0;
      while (true)
      {
        int i7 = i1.size();
        if (i5 >= i7)
          break;
        long l1 = ((Long)i1.get(i5)).longValue();
        i6[i5] = l1;
        int i8 = i5 + 1;
      }
    }
  }

  public boolean b()
  {
    return this.j;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ts
 * JD-Core Version:    0.6.0
 */