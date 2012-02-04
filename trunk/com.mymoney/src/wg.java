import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public abstract interface wg extends FileFilter, FilenameFilter
{
  public abstract boolean accept(File paramFile);

  public abstract boolean accept(File paramFile, String paramString);
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     wg
 * JD-Core Version:    0.6.0
 */