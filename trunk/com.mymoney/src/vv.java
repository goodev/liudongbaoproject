import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class vv
  implements Serializable
{
  private String a;
  private List b;
  private List c;

  public vv(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    this.b = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this.c = localArrayList2;
    this.a = paramString;
  }

  public double a(int paramInt)
  {
    return ((Double)this.c.get(paramInt)).doubleValue();
  }

  public int a()
  {
    return this.c.size();
  }

  public void a(String paramString, double paramDouble)
  {
    boolean bool1 = this.b.add(paramString);
    List localList = this.c;
    Double localDouble = Double.valueOf(paramDouble);
    boolean bool2 = localList.add(localDouble);
  }

  public String b(int paramInt)
  {
    String str1 = (String)this.b.get(paramInt);
    if (str1 == null);
    for (String str2 = ""; ; str2 = str1)
      return str2;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vv
 * JD-Core Version:    0.6.0
 */