import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ty
  implements CharSequence
{
  Map a = null;
  String b;
  String c;
  boolean d = 0;

  public ty(Map paramMap, String paramString1, String paramString2)
  {
    this.a = paramMap;
    this.b = paramString1;
    this.c = paramString2;
  }

  public static final boolean a(ty[] paramArrayOfty, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
      i = 1;
    while (true)
    {
      int j = paramArrayOfty.length;
      if (i < j)
        if (paramArrayOfty[i].d);
      for (int k = 0; ; k = 1)
      {
        return k;
        i += 1;
        break;
      }
      i = 0;
    }
  }

  public static final ty[] a(List paramList, String paramString1, String paramString2)
  {
    ty[] arrayOfty = new ty[paramList.size()];
    int i = 0;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Map localMap = (Map)localIterator.next();
      ty localty = new ty(localMap, paramString1, paramString2);
      arrayOfty[i] = localty;
      i += 1;
    }
    return arrayOfty;
  }

  public String a()
  {
    Map localMap = this.a;
    String str = this.b;
    return (String)localMap.get(str);
  }

  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public char charAt(int paramInt)
  {
    return '\000';
  }

  public int length()
  {
    return 0;
  }

  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return null;
  }

  public String toString()
  {
    Map localMap = this.a;
    String str = this.c;
    return (String)localMap.get(str);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ty
 * JD-Core Version:    0.6.0
 */