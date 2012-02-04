import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.ZipException;

public class wk
{
  private static Hashtable a = new Hashtable();

  static
  {
    a(wj.class);
    a(wl.class);
  }

  public static wo a(wv paramwv)
  {
    Object localObject = (Class)a.get(paramwv);
    if (localObject != null)
      localObject = (wo)((Class)localObject).newInstance();
    while (true)
    {
      return localObject;
      localObject = new wm();
      ((wm)localObject).a(paramwv);
    }
  }

  public static void a(Class paramClass)
  {
    String str3;
    try
    {
      wo localwo = (wo)paramClass.newInstance();
      Hashtable localHashtable = a;
      wv localwv = localwo.a();
      Object localObject = localHashtable.put(localwv, paramClass);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      String str1 = paramClass + " doesn't implement ZipExtraField";
      throw new RuntimeException(str1);
    }
    catch (InstantiationException localInstantiationException)
    {
      String str2 = paramClass + " is not a concrete class";
      throw new RuntimeException(str2);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      str3 = paramClass + "'s no-arg constructor is not public";
    }
    throw new RuntimeException(str3);
  }

  public static byte[] a(wo[] paramArrayOfwo)
  {
    int i = paramArrayOfwo.length * 4;
    int j = 0;
    while (true)
    {
      int k = paramArrayOfwo.length;
      if (j >= k)
        break;
      int m = paramArrayOfwo[j].b().b();
      i += m;
      j += 1;
    }
    byte[] arrayOfByte1 = new byte[i];
    int n = 0;
    int i1 = 0;
    while (true)
    {
      int i2 = paramArrayOfwo.length;
      if (n >= i2)
        break;
      System.arraycopy(paramArrayOfwo[n].a().a(), 0, arrayOfByte1, i1, 2);
      byte[] arrayOfByte2 = paramArrayOfwo[n].b().a();
      int i3 = i1 + 2;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i3, 2);
      byte[] arrayOfByte3 = paramArrayOfwo[n].d();
      int i4 = i1 + 4;
      int i5 = arrayOfByte3.length;
      System.arraycopy(arrayOfByte3, 0, arrayOfByte1, i4, i5);
      int i6 = arrayOfByte3.length + 4;
      i1 += i6;
      n += 1;
    }
    return arrayOfByte1;
  }

  public static wo[] a(byte[] paramArrayOfByte)
  {
    Vector localVector = new Vector();
    int i = 0;
    while (true)
    {
      int j = paramArrayOfByte.length - 4;
      if (i > j)
        break;
      wv localwv = new wv(paramArrayOfByte, i);
      int k = i + 2;
      int m = new wv(paramArrayOfByte, k).b();
      int n = i + 4 + m;
      int i1 = paramArrayOfByte.length;
      if (n > i1)
      {
        String str1 = "data starting at " + i + " is in unknown format";
        throw new ZipException(str1);
      }
      try
      {
        wo localwo = a(localwv);
        int i2 = i + 4;
        localwo.a(paramArrayOfByte, i2, m);
        localVector.addElement(localwo);
        int i3 = m + 4;
        i += i3;
      }
      catch (InstantiationException localInstantiationException)
      {
        String str2 = localInstantiationException.getMessage();
        throw new ZipException(str2);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        String str3 = localIllegalAccessException.getMessage();
        throw new ZipException(str3);
      }
    }
    int i4 = paramArrayOfByte.length;
    if (i != i4)
    {
      String str4 = "data starting at " + i + " is in unknown format";
      throw new ZipException(str4);
    }
    wo[] arrayOfwo = new wo[localVector.size()];
    localVector.copyInto(arrayOfwo);
    return arrayOfwo;
  }

  public static byte[] b(wo[] paramArrayOfwo)
  {
    int i = paramArrayOfwo.length * 4;
    int j = 0;
    while (true)
    {
      int k = paramArrayOfwo.length;
      if (j >= k)
        break;
      int m = paramArrayOfwo[j].c().b();
      i += m;
      j += 1;
    }
    byte[] arrayOfByte1 = new byte[i];
    int n = 0;
    int i1 = 0;
    while (true)
    {
      int i2 = paramArrayOfwo.length;
      if (n >= i2)
        break;
      System.arraycopy(paramArrayOfwo[n].a().a(), 0, arrayOfByte1, i1, 2);
      byte[] arrayOfByte2 = paramArrayOfwo[n].c().a();
      int i3 = i1 + 2;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i3, 2);
      byte[] arrayOfByte3 = paramArrayOfwo[n].e();
      int i4 = i1 + 4;
      int i5 = arrayOfByte3.length;
      System.arraycopy(arrayOfByte3, 0, arrayOfByte1, i4, i5);
      int i6 = arrayOfByte3.length + 4;
      i1 += i6;
      n += 1;
    }
    return arrayOfByte1;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wk
 * JD-Core Version:    0.6.0
 */