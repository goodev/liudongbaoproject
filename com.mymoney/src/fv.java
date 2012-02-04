import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class fv
{
  int a = 0;
  private String b = "TransactionPhotoSyncService";
  private ff c;
  private fg d;
  private fy e;
  private an f;

  public fv(ff paramff, fg paramfg, fy paramfy)
  {
    this.c = paramff;
    this.d = paramfg;
    this.e = paramfy;
    an localan = ai.a().b();
    this.f = localan;
  }

  public void a()
  {
    Map localMap = this.f.c();
    if (!localMap.isEmpty())
      this.e.a("开始同步照片...");
    Object localObject1 = null;
    try
    {
      String str1 = gh.c;
      localObject2 = new URL(str1);
      localObject3 = localObject2;
      Iterator localIterator = localMap.keySet().iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          break label399;
        localLong = (Long)localIterator.next();
        String str2 = (String)localMap.get(localLong);
        String str3 = eo.a(str2);
        localFile = new File(str3);
        if ((localFile != null) && (localFile.exists()))
          break;
        String str4 = this.b;
        String str5 = "can't find photo file " + str2;
        gj.a(str4, str5);
      }
    }
    catch (MalformedURLException localException1)
    {
      while (true)
      {
        Long localLong;
        File localFile;
        localMalformedURLException.printStackTrace();
        Object localObject3 = localObject1;
        continue;
        int i = this.a + 1;
        this.a = i;
        fy localfy = this.e;
        StringBuilder localStringBuilder = new StringBuilder().append("正在上传第");
        int j = this.a;
        String str6 = j + "张消费记录照片...";
        localfy.a(str6);
        Object localObject2 = new HashMap();
        Object localObject4 = ((Map)localObject2).put("photo", localFile);
        HashMap localHashMap = new HashMap();
        String str7 = this.c.d();
        Object localObject5 = localHashMap.put("SessionKey", str7);
        String str8 = String.valueOf(localLong);
        Object localObject6 = localHashMap.put("id", str8);
        try
        {
          if (gn.a(localObject3, (Map)localObject2, localHashMap))
          {
            gj.a(this.b, "photo upload success");
            try
            {
              long l = localLong.longValue();
              boolean bool = this.f.a(l, 0);
            }
            catch (Exception localException1)
            {
              gj.a(this.b, " syncTransactionDao.updateTransactionPhotoUploadStatusById(id, false), id is null");
            }
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          continue;
          gj.a(this.b, "photo upload faile");
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      }
      label399: gz.a();
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fv
 * JD-Core Version:    0.6.0
 */