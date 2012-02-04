import android.content.Context;

public class vm extends vl
{
  private Object[] a;

  public vm(Context paramContext, Object[] paramArrayOfObject)
  {
    super(paramContext);
    this.a = paramArrayOfObject;
  }

  public int a()
  {
    return this.a.length;
  }

  public CharSequence b(int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt >= 0)
    {
      int i = this.a.length;
      if (paramInt < i)
      {
        localObject1 = this.a[paramInt];
        if ((localObject1 instanceof CharSequence))
          localObject2 = (CharSequence)localObject1;
      }
    }
    while (true)
    {
      return localObject2;
      localObject2 = localObject1.toString();
      continue;
      localObject2 = null;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     vm
 * JD-Core Version:    0.6.0
 */