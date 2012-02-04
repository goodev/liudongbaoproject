import java.security.MessageDigest;

public class gk
{
  public static String a(String paramString)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA");
    byte[] arrayOfByte = paramString.getBytes();
    localMessageDigest.update(arrayOfByte);
    return a(localMessageDigest.digest());
  }

  private static String a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length * 3;
    StringBuffer localStringBuffer1 = new StringBuffer(i);
    int j = 0;
    while (true)
    {
      int k = paramArrayOfByte.length;
      if (j >= k)
        break;
      char c1 = Character.forDigit((paramArrayOfByte[j] & 0xF0) >> 4, 16);
      StringBuffer localStringBuffer2 = localStringBuffer1.append(c1);
      char c2 = Character.forDigit(paramArrayOfByte[j] & 0xF, 16);
      StringBuffer localStringBuffer3 = localStringBuffer1.append(c2);
      j += 1;
    }
    return localStringBuffer1.toString();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gk
 * JD-Core Version:    0.6.0
 */