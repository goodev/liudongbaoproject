import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class wa
{
  public static Collection a(File paramFile, wg paramwg1, wg paramwg2)
  {
    if (!paramFile.isDirectory())
      throw new IllegalArgumentException("Parameter 'directory' is not a directory");
    if (paramwg1 == null)
      throw new NullPointerException("Parameter 'fileFilter' is null");
    wg localwg1 = wf.a(wd.b);
    wg localwg2 = wf.a(paramwg1, localwg1);
    if (paramwg2 == null);
    wg localwg5;
    for (wg localwg3 = we.b; ; localwg3 = wf.a(paramwg2, localwg5))
    {
      LinkedList localLinkedList = new LinkedList();
      wg localwg4 = wf.b(localwg2, localwg3);
      a(localLinkedList, paramFile, localwg4);
      return localLinkedList;
      localwg5 = wd.b;
    }
  }

  public static void a(File paramFile)
  {
    if (!paramFile.exists())
      return;
    b(paramFile);
    if (paramFile.delete())
      return;
    String str = "Unable to delete directory " + paramFile + ".";
    throw new IOException(str);
  }

  public static void a(File paramFile1, File paramFile2)
  {
    a(paramFile1, paramFile2, 1);
  }

  public static void a(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean)
  {
    if (paramFile1 == null)
      throw new NullPointerException("Source must not be null");
    if (paramFile2 == null)
      throw new NullPointerException("Destination must not be null");
    if (!paramFile1.exists())
    {
      String str1 = "Source '" + paramFile1 + "' does not exist";
      throw new FileNotFoundException(str1);
    }
    if (!paramFile1.isDirectory())
    {
      String str2 = "Source '" + paramFile1 + "' exists but is not a directory";
      throw new IOException(str2);
    }
    String str3 = paramFile1.getCanonicalPath();
    String str4 = paramFile2.getCanonicalPath();
    if (str3.equals(str4))
    {
      String str5 = "Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same";
      throw new IOException(str5);
    }
    ArrayList localArrayList = null;
    String str6 = paramFile2.getCanonicalPath();
    String str7 = paramFile1.getCanonicalPath();
    if (str6.startsWith(str7))
    {
      if (paramFileFilter == null);
      for (File[] arrayOfFile = paramFile1.listFiles(); (arrayOfFile != null) && (arrayOfFile.length > 0); arrayOfFile = paramFile1.listFiles(paramFileFilter))
      {
        int i = arrayOfFile.length;
        localArrayList = new ArrayList(i);
        int j = 0;
        while (true)
        {
          int k = arrayOfFile.length;
          if (j >= k)
            break;
          String str8 = arrayOfFile[j].getName();
          String str9 = new File(paramFile2, str8).getCanonicalPath();
          boolean bool = localArrayList.add(str9);
          j += 1;
        }
      }
    }
    a(paramFile1, paramFile2, paramFileFilter, paramBoolean, localArrayList);
  }

  private static void a(File paramFile1, File paramFile2, FileFilter paramFileFilter, boolean paramBoolean, List paramList)
  {
    if (paramFile2.exists())
    {
      if (!paramFile2.isDirectory())
      {
        String str1 = "Destination '" + paramFile2 + "' exists but is not a directory";
        throw new IOException(str1);
      }
    }
    else
    {
      if (!paramFile2.mkdirs())
      {
        String str2 = "Destination '" + paramFile2 + "' directory cannot be created";
        throw new IOException(str2);
      }
      if (paramBoolean)
      {
        long l = paramFile1.lastModified();
        boolean bool = paramFile2.setLastModified(l);
      }
    }
    if (!paramFile2.canWrite())
    {
      String str3 = "Destination '" + paramFile2 + "' cannot be written to";
      throw new IOException(str3);
    }
    if (paramFileFilter == null);
    for (File[] arrayOfFile = paramFile1.listFiles(); arrayOfFile == null; arrayOfFile = paramFile1.listFiles(paramFileFilter))
    {
      String str4 = "Failed to list contents of " + paramFile1;
      throw new IOException(str4);
    }
    int i = 0;
    int j = arrayOfFile.length;
    if (i >= j)
      return;
    String str5 = arrayOfFile[i].getName();
    File localFile = new File(paramFile2, str5);
    if (paramList != null)
    {
      String str6 = arrayOfFile[i].getCanonicalPath();
      if (paramList.contains(str6));
    }
    else
    {
      if (!arrayOfFile[i].isDirectory())
        break label309;
      a(arrayOfFile[i], localFile, paramFileFilter, paramBoolean, paramList);
    }
    while (true)
    {
      i += 1;
      break;
      label309: b(arrayOfFile[i], localFile, paramBoolean);
    }
  }

  public static void a(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    a(paramFile1, paramFile2, null, paramBoolean);
  }

  private static void a(Collection paramCollection, File paramFile, wg paramwg)
  {
    File[] arrayOfFile = paramFile.listFiles(paramwg);
    if (arrayOfFile == null)
      return;
    int i = 0;
    int j = arrayOfFile.length;
    if (i >= j)
      return;
    if (arrayOfFile[i].isDirectory())
    {
      File localFile1 = arrayOfFile[i];
      a(paramCollection, localFile1, paramwg);
    }
    while (true)
    {
      i += 1;
      break;
      File localFile2 = arrayOfFile[i];
      boolean bool = paramCollection.add(localFile2);
    }
  }

  public static void b(File paramFile)
  {
    if (!paramFile.exists())
    {
      String str1 = paramFile + " does not exist";
      throw new IllegalArgumentException(str1);
    }
    if (!paramFile.isDirectory())
    {
      String str2 = paramFile + " is not a directory";
      throw new IllegalArgumentException(str2);
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
    {
      String str3 = "Failed to list contents of " + paramFile;
      throw new IOException(str3);
    }
    int i = 0;
    Object localObject = null;
    int j = i;
    while (true)
    {
      int k = arrayOfFile.length;
      File localFile;
      if (j < k)
        localFile = arrayOfFile[j];
      try
      {
        c(localFile);
        label144: j += 1;
        continue;
        if (localObject == null)
          return;
        throw localObject;
      }
      catch (IOException localIOException)
      {
        break label144;
      }
    }
  }

  private static void b(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if ((paramFile2.exists()) && (paramFile2.isDirectory()))
    {
      String str1 = "Destination '" + paramFile2 + "' exists but is a directory";
      throw new IOException(str1);
    }
    FileInputStream localFileInputStream = new FileInputStream(paramFile1);
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramFile2);
      try
      {
        int i = wb.a(localFileInputStream, localFileOutputStream);
        wb.a(localFileOutputStream);
        wb.a(localFileInputStream);
        long l1 = paramFile1.length();
        long l2 = paramFile2.length();
        if (l1 != l2)
        {
          String str2 = "Failed to copy full contents from '" + paramFile1 + "' to '" + paramFile2 + "'";
          throw new IOException(str2);
        }
      }
      finally
      {
        wb.a(localFileOutputStream);
      }
    }
    finally
    {
      wb.a(localFileInputStream);
    }
    if (!paramBoolean)
      return;
    long l3 = paramFile1.lastModified();
    boolean bool = paramFile2.setLastModified(l3);
  }

  public static void c(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      a(paramFile);
      return;
    }
    boolean bool = paramFile.exists();
    if (paramFile.delete())
      return;
    if (!bool)
    {
      String str1 = "File does not exist: " + paramFile;
      throw new FileNotFoundException(str1);
    }
    String str2 = "Unable to delete file: " + paramFile;
    throw new IOException(str2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wa
 * JD-Core Version:    0.6.0
 */