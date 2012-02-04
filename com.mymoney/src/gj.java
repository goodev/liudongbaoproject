import android.content.Context;
import android.util.Log;
import com.mymoney.core.application.ApplicationContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class gj
{
  public static String a = "DebugUtil";

  public static List a()
  {
    LinkedList localLinkedList = new LinkedList();
    String str1 = em.b;
    File localFile = new File(str1);
    if (!localFile.exists())
      boolean bool = localFile.mkdirs();
    String str2 = em.b;
    a(new File(str2), localLinkedList);
    return localLinkedList;
  }

  public static void a(Context paramContext, String paramString)
  {
    if (gh.a)
      return;
  }

  public static void a(File paramFile)
  {
    try
    {
      ApplicationContext.b.close();
      File localFile = dh.c();
      gl.a(paramFile, localFile);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  private static void a(File paramFile, List paramList)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
      return;
    int i = 0;
    int j = arrayOfFile.length;
    if (i >= j)
      return;
    if (arrayOfFile[i].isDirectory())
      a(arrayOfFile[i], paramList);
    while (true)
    {
      i += 1;
      break;
      File localFile = arrayOfFile[i];
      boolean bool = paramList.add(localFile);
    }
  }

  public static void a(InputStream paramInputStream, String paramString)
  {
    if (!gh.a)
      return;
  }

  public static void a(String paramString1, String paramString2)
  {
    if (!gh.a)
      return;
    String str1 = paramString1 + " >  " + paramString2;
    int i = Log.v(paramString1, str1);
    b(paramString1, paramString2);
    try
    {
      if (!ep.a())
        return;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str2 = ep.a;
      String str3 = str2 + "/mymoney_debug.txt";
      File localFile = new File(str3);
      if (!localFile.exists())
        boolean bool = localFile.createNewFile();
      int j = (int)localFile.length();
      String str4 = gi.g(new Date());
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
      long l = j;
      localRandomAccessFile.seek(l);
      String str5 = str4 + " " + paramString1 + " > " + paramString2;
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str6 = System.getProperty("line.separator");
      byte[] arrayOfByte = (str6 + str5).getBytes();
      localRandomAccessFile.write(arrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void b()
  {
    try
    {
      if (!ep.a())
        return;
      StringBuilder localStringBuilder = new StringBuilder();
      String str1 = em.b;
      String str2 = str1 + "testLog.txt";
      File localFile = new File(str2);
      if (!localFile.exists())
        return;
      boolean bool = localFile.delete();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void b(String paramString1, String paramString2)
  {
    if (!gh.a)
      return;
    String str1 = gi.g(new Date());
    if (!gh.a)
      return;
    try
    {
      FileOutputStream localFileOutputStream = ApplicationContext.a.openFileOutput("debuglog.txt", 32768);
      PrintStream localPrintStream = new PrintStream(localFileOutputStream);
      String str2 = str1 + ":" + paramString1 + " >  " + paramString2;
      localPrintStream.println(str2);
      localPrintStream.println();
      localFileOutputStream.close();
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public static void c(String paramString1, String paramString2)
  {
    if (!gh.a)
      return;
    try
    {
      String str1 = em.a;
      if (!new File(str1).exists())
      {
        String str2 = em.a;
        boolean bool1 = new File(str2).mkdirs();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      String str3 = em.a;
      String str4 = str3 + paramString2;
      File localFile = new File(str4);
      if (!localFile.exists())
        boolean bool2 = localFile.createNewFile();
      FileWriter localFileWriter = new FileWriter(localFile);
      localFileWriter.write(paramString1);
      localFileWriter.flush();
      localFileWriter.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public static void d(String paramString1, String paramString2)
  {
    try
    {
      if (!ep.a())
        return;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1 = em.b;
      String str2 = str1 + "testLog.txt";
      File localFile = new File(str2);
      if (!localFile.exists())
        boolean bool = localFile.createNewFile();
      String str3 = gi.g(new Date());
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
      long l = localFile.length();
      localRandomAccessFile.seek(l);
      String str4 = str3 + " " + paramString1 + " > " + paramString2;
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str5 = System.getProperty("line.separator");
      byte[] arrayOfByte = (str5 + str4).getBytes();
      localRandomAccessFile.write(arrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gj
 * JD-Core Version:    0.6.0
 */