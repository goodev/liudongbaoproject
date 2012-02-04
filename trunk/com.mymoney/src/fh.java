import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class fh
{
  public static String a = "XMLRPCClient";
  private HttpClient b;
  private HttpPost c;
  private HttpGet d;

  public fh(String paramString)
  {
    this(localURI);
  }

  public fh(URI paramURI)
  {
    HttpPost localHttpPost = new HttpPost(paramURI);
    this.c = localHttpPost;
    HttpGet localHttpGet = new HttpGet(paramURI);
    this.d = localHttpGet;
    this.c.addHeader("Content-Type", "application/x-www-form-urlencoded");
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    this.b = localDefaultHttpClient;
  }

  // ERROR //
  public static HttpURLConnection a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 61	java/util/HashMap
    //   3: dup
    //   4: invokespecial 62	java/util/HashMap:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 64
    //   11: aload_1
    //   12: invokeinterface 70 3 0
    //   17: astore_3
    //   18: new 72	java/lang/StringBuffer
    //   21: dup
    //   22: invokespecial 73	java/lang/StringBuffer:<init>	()V
    //   25: astore 4
    //   27: aload_2
    //   28: invokeinterface 77 1 0
    //   33: invokeinterface 83 1 0
    //   38: astore 5
    //   40: aload 5
    //   42: invokeinterface 89 1 0
    //   47: ifeq +125 -> 172
    //   50: aload 5
    //   52: invokeinterface 93 1 0
    //   57: checkcast 95	java/util/Map$Entry
    //   60: astore 6
    //   62: aload 6
    //   64: invokeinterface 98 1 0
    //   69: checkcast 100	java/lang/String
    //   72: astore 7
    //   74: aload 4
    //   76: aload 7
    //   78: invokevirtual 104	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   81: astore 8
    //   83: aload 4
    //   85: ldc 106
    //   87: invokevirtual 104	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   90: astore 9
    //   92: aload 6
    //   94: invokeinterface 109 1 0
    //   99: checkcast 100	java/lang/String
    //   102: ldc 111
    //   104: invokestatic 117	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 10
    //   109: aload 4
    //   111: aload 10
    //   113: invokevirtual 104	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   116: astore 11
    //   118: aload 4
    //   120: ldc 119
    //   122: invokevirtual 104	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   125: astore 12
    //   127: goto -87 -> 40
    //   130: astore 13
    //   132: aconst_null
    //   133: astore 14
    //   135: aconst_null
    //   136: astore 4
    //   138: aload 14
    //   140: invokestatic 122	fh:a	(Ljava/net/HttpURLConnection;)V
    //   143: new 124	ef
    //   146: dup
    //   147: aload 13
    //   149: invokespecial 127	ef:<init>	(Ljava/lang/Exception;)V
    //   152: athrow
    //   153: astore 15
    //   155: aload 4
    //   157: astore 16
    //   159: aload 16
    //   161: ifnull +8 -> 169
    //   164: aload 16
    //   166: invokevirtual 132	java/io/DataOutputStream:close	()V
    //   169: aload 15
    //   171: athrow
    //   172: aload 4
    //   174: invokevirtual 136	java/lang/StringBuffer:length	()I
    //   177: ifle +21 -> 198
    //   180: aload 4
    //   182: invokevirtual 136	java/lang/StringBuffer:length	()I
    //   185: iconst_1
    //   186: isub
    //   187: istore 17
    //   189: aload 4
    //   191: iload 17
    //   193: invokevirtual 140	java/lang/StringBuffer:deleteCharAt	(I)Ljava/lang/StringBuffer;
    //   196: astore 18
    //   198: new 142	java/net/URL
    //   201: dup
    //   202: aload_0
    //   203: invokespecial 144	java/net/URL:<init>	(Ljava/lang/String;)V
    //   206: invokevirtual 148	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   209: checkcast 150	java/net/HttpURLConnection
    //   212: astore_0
    //   213: aconst_null
    //   214: astore_2
    //   215: aload_0
    //   216: aload_2
    //   217: invokevirtual 154	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   220: aload_0
    //   221: ldc 156
    //   223: invokevirtual 159	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   226: aload_0
    //   227: ldc 160
    //   229: invokevirtual 164	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   232: aload_0
    //   233: ldc 160
    //   235: invokevirtual 167	java/net/HttpURLConnection:setDoInput	(Z)V
    //   238: aload_0
    //   239: ldc 168
    //   241: invokevirtual 171	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   244: aload_0
    //   245: ldc 173
    //   247: ldc 175
    //   249: invokevirtual 178	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload 4
    //   254: invokevirtual 136	java/lang/StringBuffer:length	()I
    //   257: invokestatic 182	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   260: astore 19
    //   262: aload_0
    //   263: ldc 184
    //   265: aload 19
    //   267: invokevirtual 178	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_0
    //   271: sipush 15000
    //   274: invokevirtual 154	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   277: aload_0
    //   278: ldc 185
    //   280: invokevirtual 188	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   283: aload_0
    //   284: invokevirtual 192	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   287: astore 20
    //   289: new 129	java/io/DataOutputStream
    //   292: dup
    //   293: aload 20
    //   295: invokespecial 195	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   298: astore_2
    //   299: aload 4
    //   301: invokevirtual 199	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   304: astore 21
    //   306: aload_2
    //   307: aload 21
    //   309: invokevirtual 202	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   312: aload_2
    //   313: invokevirtual 205	java/io/DataOutputStream:flush	()V
    //   316: aload_0
    //   317: invokevirtual 208	java/net/HttpURLConnection:getResponseCode	()I
    //   320: istore 22
    //   322: iload 22
    //   324: sipush 200
    //   327: if_icmpeq +58 -> 385
    //   330: iload 22
    //   332: sipush 204
    //   335: if_icmpeq +50 -> 385
    //   338: new 210	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   345: ldc 213
    //   347: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: iload 22
    //   352: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: astore 23
    //   360: new 222	ee
    //   363: dup
    //   364: aload 23
    //   366: invokespecial 223	ee:<init>	(Ljava/lang/String;)V
    //   369: athrow
    //   370: astore 24
    //   372: aload_2
    //   373: astore 4
    //   375: aload 24
    //   377: astore 13
    //   379: aload_0
    //   380: astore 14
    //   382: goto -244 -> 138
    //   385: aload_2
    //   386: ifnull +7 -> 393
    //   389: aload_2
    //   390: invokevirtual 132	java/io/DataOutputStream:close	()V
    //   393: aload_0
    //   394: areturn
    //   395: astore 25
    //   397: goto -4 -> 393
    //   400: astore 26
    //   402: goto -233 -> 169
    //   405: astore 15
    //   407: aconst_null
    //   408: astore 16
    //   410: goto -251 -> 159
    //   413: astore 27
    //   415: aload_2
    //   416: astore 16
    //   418: aload 27
    //   420: astore 15
    //   422: goto -263 -> 159
    //   425: astore 13
    //   427: aload_0
    //   428: astore 14
    //   430: aconst_null
    //   431: astore 4
    //   433: goto -295 -> 138
    //
    // Exception table:
    //   from	to	target	type
    //   27	127	130	java/lang/Exception
    //   172	213	130	java/lang/Exception
    //   138	153	153	finally
    //   299	370	370	java/lang/Exception
    //   389	393	395	java/io/IOException
    //   164	169	400	java/io/IOException
    //   27	127	405	finally
    //   172	213	405	finally
    //   215	299	405	finally
    //   299	370	413	finally
    //   215	299	425	java/lang/Exception
  }

  public static void a(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection == null)
      return;
    try
    {
      paramHttpURLConnection.disconnect();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public InputStream a(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      BasicNameValuePair localBasicNameValuePair = new BasicNameValuePair("xml", paramString);
      boolean bool = localArrayList.add(localBasicNameValuePair);
      HttpPost localHttpPost = this.c;
      UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(localArrayList, "UTF-8");
      localHttpPost.setEntity(localUrlEncodedFormEntity);
      localHttpResponse = gm.a(this.c);
      int i = localHttpResponse.getStatusLine().getStatusCode();
      if (i != 200)
      {
        String str = "服务器不稳定或发生错误,响应错误(响应代码为" + i + ")" + ",请重试!";
        throw new ek(str);
      }
    }
    catch (ek localek)
    {
      HttpResponse localHttpResponse;
      throw localek;
      InputStream localInputStream = localHttpResponse.getEntity().getContent();
      return localInputStream;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      throw new ef(localSocketTimeoutException);
    }
    catch (SocketException localSocketException)
    {
      throw new ef(localSocketException);
    }
    catch (IOException localIOException)
    {
      throw new ef(localIOException);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    throw new ek(localException);
  }

  public HttpEntity a()
  {
    Object localObject = null;
    try
    {
      localHttpResponse = gm.a(this.d);
      int i = localHttpResponse.getStatusLine().getStatusCode();
      if (i != 200)
      {
        String str = "服务器不稳定或发生错误,响应错误(响应代码为" + i + ")" + ",请重试!";
        throw new ek(str);
      }
    }
    catch (ek localek)
    {
      HttpResponse localHttpResponse;
      throw localek;
      HttpEntity localHttpEntity = localHttpResponse.getEntity();
      localObject = localHttpEntity;
      return localObject;
    }
    catch (SocketException localSocketException)
    {
      throw new ef(localSocketException);
    }
    catch (IOException localIOException)
    {
      throw new ef(localIOException);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      throw new ek(localException);
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      label85: break label85;
    }
  }

  public void b()
  {
    this.b.getConnectionManager().shutdown();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     fh
 * JD-Core Version:    0.6.0
 */