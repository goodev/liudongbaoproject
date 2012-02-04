import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;

public class hd
{
  private wp a;
  private wu b;
  private byte[] c;
  private int d;

  public hd()
  {
    this(1024);
  }

  public hd(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    this.c = arrayOfByte;
  }

  private String a(String paramString)
  {
    String str1 = ep.a;
    String str2;
    if (b(str1))
      if (b(paramString))
        str2 = paramString;
    while (true)
    {
      return str2;
      str2 = c(paramString);
      continue;
      String str3 = ep.a;
      if (!b(str3))
      {
        if (!b(paramString))
        {
          str2 = paramString;
          continue;
        }
        str2 = d(paramString);
        continue;
      }
      str2 = paramString;
    }
  }

  private void a(File paramFile, wu paramwu)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile.length == 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str1 = paramFile.toString();
      String str2 = str1 + "/";
      wn localwn1 = new wn(str2);
      paramwu.a(localwn1);
      paramwu.b();
      return;
    }
    int i = arrayOfFile.length;
    int j = 0;
    if (j >= i)
      return;
    File localFile = arrayOfFile[j];
    if (localFile.isDirectory())
      a(localFile, paramwu);
    while (true)
    {
      j += 1;
      break;
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      String str3 = localFile.toString();
      wn localwn2 = new wn(str3);
      paramwu.a(localwn2);
      while (true)
      {
        byte[] arrayOfByte1 = this.c;
        int k = localFileInputStream.read(arrayOfByte1);
        this.d = k;
        if (k <= 0)
          break;
        byte[] arrayOfByte2 = this.c;
        int m = this.d;
        paramwu.write(arrayOfByte2, 0, m);
      }
      paramwu.b();
    }
  }

  private boolean b(String paramString)
  {
    String str = ep.b;
    return paramString.startsWith(str);
  }

  private String c(String paramString)
  {
    String str = ep.b;
    int i = paramString.indexOf(str);
    return paramString.substring(i);
  }

  private String d(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = ep.a;
    if (!b(str1))
    {
      String str2 = ep.a;
      String str3 = ep.b;
      int i = str2.indexOf(str3);
      String str4 = ep.a.substring(0, i);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str4);
      StringBuilder localStringBuilder3 = localStringBuilder1.append(paramString);
    }
    return localStringBuilder1.toString();
  }

  public void a(File paramFile)
  {
    wp localwp = new wp(paramFile);
    this.a = localwp;
    Enumeration localEnumeration = this.a.b();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = (wn)localEnumeration.nextElement();
      String str1 = ((wn)localObject).getName();
      String str2 = a(str1);
      File localFile1 = new File(str2);
      if (((wn)localObject).isDirectory())
      {
        boolean bool1 = localFile1.mkdirs();
        continue;
      }
      File localFile2 = localFile1.getParentFile();
      if (!localFile2.exists())
        boolean bool2 = localFile2.mkdirs();
      localObject = this.a.a((wn)localObject);
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile1);
      while (true)
      {
        byte[] arrayOfByte1 = this.c;
        int i = ((InputStream)localObject).read(arrayOfByte1);
        this.d = i;
        if (i <= 0)
          break;
        byte[] arrayOfByte2 = this.c;
        int j = this.d;
        localFileOutputStream.write(arrayOfByte2, 0, j);
      }
      localFileOutputStream.close();
      ((InputStream)localObject).close();
    }
    this.a.a();
  }

  public void a(String paramString1, String paramString2)
  {
    File localFile1 = new File(paramString1);
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = localFile1.getName();
    String str2 = str1 + paramString2;
    StringBuilder localStringBuilder2 = new StringBuilder();
    String str3 = localFile1.getParent();
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str3);
    String str4 = File.separator;
    String str5 = str4 + str2;
    File localFile2 = new File(str5);
    if (localFile2.exists())
      boolean bool1 = localFile2.delete();
    boolean bool2 = localFile2.createNewFile();
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile2);
    CRC32 localCRC32 = new CRC32();
    CheckedOutputStream localCheckedOutputStream = new CheckedOutputStream(localFileOutputStream, localCRC32);
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localCheckedOutputStream);
    wu localwu1 = new wu(localBufferedOutputStream);
    this.b = localwu1;
    wu localwu2 = this.b;
    a(localFile1, localwu2);
    wu localwu3 = this.b;
    String str6 = String.valueOf(localCheckedOutputStream.getChecksum().getValue());
    localwu3.a(str6);
    this.b.close();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     hd
 * JD-Core Version:    0.6.0
 */