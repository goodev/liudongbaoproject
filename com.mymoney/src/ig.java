import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import java.io.File;
import java.io.FileOutputStream;

public class ig extends AsyncTask
{
  public ig(AddOrEditTransNewActivity paramAddOrEditTransNewActivity)
  {
  }

  protected Integer a(Object[] paramArrayOfObject)
  {
    String str1 = (String)paramArrayOfObject[0];
    String str2 = (String)paramArrayOfObject[1];
    Bitmap localBitmap = (Bitmap)paramArrayOfObject[2];
    try
    {
      File localFile = eo.b(str1);
      FileOutputStream localFileOutputStream = eo.a(localBitmap, localFile);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      label47: if (!TextUtils.isEmpty(str2))
        boolean bool = eo.c(str2);
      return null;
    }
    catch (Exception localException)
    {
      break label47;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ig
 * JD-Core Version:    0.6.0
 */