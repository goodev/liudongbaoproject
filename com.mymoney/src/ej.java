public class ej extends Exception
{
  public ej(Exception paramException)
  {
    super(paramException);
  }

  public ej(String paramString)
  {
    super(paramString);
  }

  public ej(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }

  public String toString()
  {
    Object localObject = getLocalizedMessage();
    String str = getClass().getName();
    if (localObject == null)
      localObject = str;
    return (String)localObject;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ej
 * JD-Core Version:    0.6.0
 */