import android.os.AsyncTask;
import android.text.TextUtils;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;
import java.io.File;
import java.io.FileOutputStream;

public class jh extends AsyncTask
{
  public jh(AddOrEditTransactionActivity paramAddOrEditTransactionActivity)
  {
  }

  protected Integer a(String[] paramArrayOfString)
  {
    String str1 = paramArrayOfString[0];
    String str2 = paramArrayOfString[1];
    try
    {
      File localFile = eo.b(str1);
      FileOutputStream localFileOutputStream = eo.a(AddOrEditTransactionActivity.n(this.a), localFile);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      label38: if (!TextUtils.isEmpty(str2))
        boolean bool = eo.c(str2);
      return null;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     jh
 * JD-Core Version:    0.6.0
 */