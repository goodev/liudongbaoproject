import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class gn
{
  public static String a = "HttpUploadFileUtil";
  public static String b = "UTF-8";
  public static int c = 30000;
  public static int d = 2048;
  public static String e = "--";
  public static String f = "\r\n";

  public static boolean a(URL paramURL, Map paramMap1, Map paramMap2)
  {
    String str1 = "";
    if (paramMap2 != null)
    {
      Iterator localIterator1 = paramMap2.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        StringBuilder localStringBuilder1 = new StringBuilder().append(str1).append("&");
        String str2 = (String)localEntry1.getKey();
        String str3 = b;
        String str4 = URLEncoder.encode(str2, str3);
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str4).append("=");
        String str5 = (String)localEntry1.getValue();
        String str6 = b;
        String str7 = URLEncoder.encode(str5, str6);
        str1 = str7;
      }
    }
    String str8 = str1;
    if (!str8.equals(""))
      str8 = str8.replaceFirst("&", "?");
    String str9 = paramURL.getProtocol();
    String str10 = paramURL.getHost();
    int i = paramURL.getPort();
    StringBuilder localStringBuilder3 = new StringBuilder();
    String str11 = paramURL.getPath();
    String str12 = str11 + str8;
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(str9, str10, i, str12).openConnection();
    int j = c;
    localHttpURLConnection.setConnectTimeout(j);
    localHttpURLConnection.setRequestMethod("POST");
    localHttpURLConnection.setDoInput(1);
    localHttpURLConnection.setDoOutput(1);
    localHttpURLConnection.setUseCaches(0);
    String str13 = UUID.randomUUID().toString();
    localHttpURLConnection.setRequestProperty("Accept", "image/gif,image/png,image/x-xbitmap,image/jpeg,image/pjpeg,application/vnd.ms-excel,application/vnd.ms-powerpoint,application/msword,application/x-shockwave-flash,application/x-quickviewplus,*/*");
    localHttpURLConnection.setRequestProperty("keep-alive", "300");
    localHttpURLConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows; U; Windows NT 5.2; zh-CN; rv:1.9.1.6) Gecko/20091201 Firefox/3.5.6 GTB6");
    localHttpURLConnection.setRequestProperty("accept-language", "zh-cn,zh;q=0.5");
    localHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
    localHttpURLConnection.setRequestProperty("Accept-Encoding", " gzip,deflate");
    localHttpURLConnection.setRequestProperty("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
    String str14 = "multipart/form-data; boundary=" + str13;
    localHttpURLConnection.setRequestProperty("Content-Type", str14);
    localHttpURLConnection.setConnectTimeout(15000);
    localHttpURLConnection.setReadTimeout(35000);
    OutputStream localOutputStream = localHttpURLConnection.getOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream(localOutputStream);
    int k = d;
    if (paramMap1 != null)
    {
      Iterator localIterator2 = paramMap1.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
        StringBuilder localStringBuilder4 = new StringBuilder();
        String str15 = e;
        String str16 = str15 + str13;
        localDataOutputStream.writeBytes(str16);
        File localFile = (File)localEntry2.getValue();
        FileInputStream localFileInputStream = new FileInputStream(localFile);
        int m = Math.min(localFileInputStream.available(), k);
        byte[] arrayOfByte = new byte[m];
        int n = localFileInputStream.read(arrayOfByte, 0, m);
        String str17 = ((File)localEntry2.getValue()).getName();
        String str18 = a;
        String str19 = "upload file name is " + str17;
        gj.a(str18, str19);
        String str20 = f;
        localDataOutputStream.writeBytes(str20);
        StringBuilder localStringBuilder5 = new StringBuilder().append("Content-Disposition: form-data; name=\"");
        String str21 = (String)localEntry2.getKey();
        String str22 = str21 + "\";" + " filename=\"" + str17;
        localDataOutputStream.writeBytes(str22);
        StringBuilder localStringBuilder6 = new StringBuilder().append("\"");
        String str23 = f;
        String str24 = str23;
        localDataOutputStream.writeBytes(str24);
        StringBuilder localStringBuilder7 = new StringBuilder().append("Content-Type: image/png");
        String str25 = f;
        String str26 = str25;
        localDataOutputStream.writeBytes(str26);
        String str27 = f;
        localDataOutputStream.writeBytes(str27);
        int i1 = m;
        int i2 = n;
        while (i2 > 0)
        {
          localDataOutputStream.write(arrayOfByte, 0, i1);
          int i3 = Math.min(localFileInputStream.available(), k);
          int i4 = localFileInputStream.read(arrayOfByte, 0, i3);
        }
        localFileInputStream.close();
      }
    }
    String str28 = f;
    localDataOutputStream.writeBytes(str28);
    StringBuilder localStringBuilder8 = new StringBuilder();
    String str29 = e;
    StringBuilder localStringBuilder9 = localStringBuilder8.append(str29).append(str13);
    String str30 = e;
    String str31 = str30;
    localDataOutputStream.writeBytes(str31);
    String str32 = f;
    localDataOutputStream.writeBytes(str32);
    int i5 = localDataOutputStream.size();
    String str33 = a;
    String str34 = "bytes total:" + i5;
    gj.a(str33, str34);
    localDataOutputStream.flush();
    localDataOutputStream.close();
    String str35 = localHttpURLConnection.getHeaderField("Content-Type");
    int i6;
    if ((localHttpURLConnection.getResponseCode() == 200) || (localHttpURLConnection.getResponseCode() == 204))
      i6 = 1;
    try
    {
      while (true)
      {
        localHttpURLConnection.disconnect();
        label981: return i6;
        String str36 = a;
        StringBuilder localStringBuilder10 = new StringBuilder().append("http status is ");
        int i7 = localHttpURLConnection.getResponseCode();
        StringBuilder localStringBuilder11 = localStringBuilder10.append(i7).append(", mesage = ");
        String str37 = localHttpURLConnection.getResponseMessage();
        String str38 = str37;
        gj.a(str36, str38);
        i6 = 0;
      }
    }
    catch (Exception localException)
    {
      break label981;
    }
  }

  // ERROR //
  public static Map b(URL paramURL, Map paramMap1, Map paramMap2)
  {
    // Byte code:
    //   0: new 293	java/util/HashMap
    //   3: dup
    //   4: invokespecial 294	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: iconst_1
    //   9: invokestatic 300	java/util/concurrent/Executors:newFixedThreadPool	(I)Ljava/util/concurrent/ExecutorService;
    //   12: astore 4
    //   14: new 302	go
    //   17: dup
    //   18: aload_0
    //   19: aload_1
    //   20: aload_2
    //   21: invokespecial 305	go:<init>	(Ljava/net/URL;Ljava/util/Map;Ljava/util/Map;)V
    //   24: astore 5
    //   26: aload 4
    //   28: aload 5
    //   30: invokeinterface 311 2 0
    //   35: astore 6
    //   37: getstatic 317	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   40: astore 7
    //   42: aload 6
    //   44: ldc2_w 318
    //   47: aload 7
    //   49: invokeinterface 325 4 0
    //   54: checkcast 44	java/util/Map
    //   57: astore_0
    //   58: aload 4
    //   60: invokeinterface 328 1 0
    //   65: aload_0
    //   66: areturn
    //   67: astore 8
    //   69: new 330	ef
    //   72: dup
    //   73: ldc_w 332
    //   76: invokespecial 334	ef:<init>	(Ljava/lang/String;)V
    //   79: athrow
    //   80: astore 9
    //   82: aload 4
    //   84: invokeinterface 328 1 0
    //   89: aload 9
    //   91: athrow
    //   92: astore 10
    //   94: new 330	ef
    //   97: dup
    //   98: ldc_w 332
    //   101: invokespecial 334	ef:<init>	(Ljava/lang/String;)V
    //   104: athrow
    //   105: astore 11
    //   107: new 330	ef
    //   110: dup
    //   111: ldc_w 332
    //   114: invokespecial 334	ef:<init>	(Ljava/lang/String;)V
    //   117: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   37	58	67	java/lang/InterruptedException
    //   37	58	80	finally
    //   69	80	80	finally
    //   94	118	80	finally
    //   37	58	92	java/util/concurrent/ExecutionException
    //   37	58	105	java/util/concurrent/TimeoutException
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     gn
 * JD-Core Version:    0.6.0
 */