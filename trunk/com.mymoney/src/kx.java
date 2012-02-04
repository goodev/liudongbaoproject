import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class kx extends AsyncTask
{
  public static String a = kx.class.getSimpleName();
  public ProgressDialog b;
  private Context c;
  private fn d;

  public kx(Context paramContext, fn paramfn)
  {
    this.c = paramContext;
    this.d = paramfn;
  }

  protected Boolean a(Object[] paramArrayOfObject)
  {
    int i = 1;
    Object localObject = new DefaultHttpClient();
    String str1 = this.d.c();
    HttpGet localHttpGet = new HttpGet(str1);
    String str2 = a;
    StringBuilder localStringBuilder = new StringBuilder().append("apk download url is ");
    String str3 = this.d.c();
    String str4 = str3;
    gj.a(str2, str4);
    try
    {
      HttpEntity localHttpEntity = ((HttpClient)localObject).execute(localHttpGet).getEntity();
      long l = localHttpEntity.getContentLength();
      String str5 = a;
      String str6 = "apk file length is " + l;
      gj.a(str5, str6);
      localObject = localHttpEntity.getContent();
      arrayOfByte = null;
      if (localObject != null)
      {
        File localFile1 = Environment.getExternalStorageDirectory();
        File localFile2 = new File(localFile1, "Mymoney_for_upgrade.apk");
        boolean bool = localFile2.createNewFile();
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile2);
        arrayOfByte = new byte[1024];
        int k = 0;
        while (true)
        {
          int m = ((InputStream)localObject).read(arrayOfByte);
          if (m == -1)
            break;
          localFileOutputStream.write(arrayOfByte, 0, m);
          k += m;
          if (l <= 0L)
            continue;
        }
        localObject = localFileOutputStream;
        ((FileOutputStream)localObject).flush();
        if (localObject != null)
          ((FileOutputStream)localObject).close();
        return Boolean.valueOf(i);
      }
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      while (true)
      {
        localClientProtocolException.printStackTrace();
        j = 0;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        localIOException.printStackTrace();
        j = 0;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        byte[] arrayOfByte;
        localException.printStackTrace();
        int j = 0;
        continue;
        localObject = arrayOfByte;
      }
    }
  }

  protected void a(Boolean paramBoolean)
  {
    this.b.dismiss();
    if (paramBoolean.booleanValue())
    {
      Intent localIntent1 = new Intent("android.intent.action.VIEW");
      Uri localUri = Uri.fromFile(new File("/sdcard/Mymoney_for_upgrade.apk"));
      Intent localIntent2 = localIntent1.setDataAndType(localUri, "application/vnd.android.package-archive");
      this.c.startActivity(localIntent1);
    }
    while (true)
    {
      super.onPostExecute(paramBoolean);
      return;
      hb.b(this.c, "抱歉,下载更新包失败,请重试");
    }
  }

  protected void a(Integer[] paramArrayOfInteger)
  {
    super.onProgressUpdate(paramArrayOfInteger);
    int i = paramArrayOfInteger[0].intValue();
  }

  protected void onPreExecute()
  {
    Context localContext = this.c;
    ProgressDialog localProgressDialog1 = new ProgressDialog(localContext);
    this.b = localProgressDialog1;
    ProgressDialog localProgressDialog2 = this.b;
    StringBuilder localStringBuilder = new StringBuilder().append("下载最新版随手记");
    String str1 = this.d.b();
    String str2 = str1;
    localProgressDialog2.setTitle(str2);
    this.b.setMessage("正在下载安装包...");
    this.b.setIndeterminate(1);
    this.b.setCancelable(1);
    ProgressDialog localProgressDialog3 = this.b;
    ky localky = new ky(this);
    localProgressDialog3.setButton(-1, "取消", localky);
    this.b.show();
    super.onPreExecute();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     kx
 * JD-Core Version:    0.6.0
 */