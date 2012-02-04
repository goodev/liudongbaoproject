import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.mymoney.ui.setting.SettingActivity;
import org.apache.http.HttpEntity;

public class pc extends AsyncTask
{
  private ProgressDialog b;
  private HttpEntity c;

  private pc(SettingActivity paramSettingActivity)
  {
  }

  // ERROR //
  protected Boolean a(java.lang.Void[] paramArrayOfVoid)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 27	pc:c	Lorg/apache/http/HttpEntity;
    //   6: ifnull +300 -> 306
    //   9: aload_0
    //   10: getfield 27	pc:c	Lorg/apache/http/HttpEntity;
    //   13: invokeinterface 33 1 0
    //   18: ldc2_w 34
    //   21: lcmp
    //   22: ifle +284 -> 306
    //   25: getstatic 40	el:a	Ljava/lang/String;
    //   28: astore_3
    //   29: new 42	java/io/File
    //   32: dup
    //   33: aload_3
    //   34: invokespecial 45	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 4
    //   39: aload 4
    //   41: invokevirtual 49	java/io/File:exists	()Z
    //   44: ifne +10 -> 54
    //   47: aload 4
    //   49: invokevirtual 52	java/io/File:mkdirs	()Z
    //   52: istore 5
    //   54: sipush 1024
    //   57: istore 6
    //   59: iload 6
    //   61: newarray byte
    //   63: astore 6
    //   65: invokestatic 57	com/mymoney/ui/setting/SettingActivity:b	()Ljava/lang/String;
    //   68: astore 7
    //   70: new 59	java/io/FileOutputStream
    //   73: dup
    //   74: aload 7
    //   76: invokespecial 60	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   79: astore 8
    //   81: new 62	java/io/BufferedOutputStream
    //   84: dup
    //   85: aload 8
    //   87: invokespecial 65	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   90: astore 9
    //   92: aload_0
    //   93: getfield 27	pc:c	Lorg/apache/http/HttpEntity;
    //   96: invokeinterface 69 1 0
    //   101: astore 10
    //   103: aload 10
    //   105: astore 11
    //   107: iconst_0
    //   108: istore 12
    //   110: aload 11
    //   112: aload 6
    //   114: invokevirtual 75	java/io/InputStream:read	([B)I
    //   117: istore_2
    //   118: iload_2
    //   119: bipush 255
    //   121: if_icmpeq +86 -> 207
    //   124: aload 9
    //   126: aload 6
    //   128: iconst_0
    //   129: iload_2
    //   130: invokevirtual 79	java/io/BufferedOutputStream:write	([BII)V
    //   133: iload 12
    //   135: iload_2
    //   136: iadd
    //   137: istore 13
    //   139: iconst_1
    //   140: anewarray 81	java/lang/Integer
    //   143: astore 14
    //   145: iload 13
    //   147: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: astore 15
    //   152: aload 14
    //   154: iconst_0
    //   155: aload 15
    //   157: aastore
    //   158: aload_0
    //   159: aload 14
    //   161: invokevirtual 89	pc:publishProgress	([Ljava/lang/Object;)V
    //   164: goto -54 -> 110
    //   167: astore 16
    //   169: aload 11
    //   171: astore 17
    //   173: aload 9
    //   175: ifnull +203 -> 378
    //   178: aload 9
    //   180: invokevirtual 92	java/io/BufferedOutputStream:close	()V
    //   183: ldc 93
    //   185: istore 9
    //   187: aload 17
    //   189: ifnull +182 -> 371
    //   192: aload 17
    //   194: invokevirtual 94	java/io/InputStream:close	()V
    //   197: iload 9
    //   199: istore 18
    //   201: iload 18
    //   203: invokestatic 99	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   206: areturn
    //   207: aload 9
    //   209: invokevirtual 102	java/io/BufferedOutputStream:flush	()V
    //   212: aload 9
    //   214: ifnull +171 -> 385
    //   217: aload 9
    //   219: invokevirtual 92	java/io/BufferedOutputStream:close	()V
    //   222: ldc 103
    //   224: istore 18
    //   226: aload 11
    //   228: ifnull -27 -> 201
    //   231: aload 11
    //   233: invokevirtual 94	java/io/InputStream:close	()V
    //   236: goto -35 -> 201
    //   239: astore 19
    //   241: ldc 93
    //   243: istore 18
    //   245: goto -44 -> 201
    //   248: astore 20
    //   250: ldc 93
    //   252: istore 18
    //   254: goto -28 -> 226
    //   257: astore 21
    //   259: ldc 93
    //   261: istore 9
    //   263: goto -76 -> 187
    //   266: astore 22
    //   268: ldc 93
    //   270: istore 18
    //   272: goto -71 -> 201
    //   275: astore 23
    //   277: aconst_null
    //   278: astore 24
    //   280: aconst_null
    //   281: astore 25
    //   283: aload 25
    //   285: ifnull +8 -> 293
    //   288: aload 25
    //   290: invokevirtual 92	java/io/BufferedOutputStream:close	()V
    //   293: aload 24
    //   295: ifnull +8 -> 303
    //   298: aload 24
    //   300: invokevirtual 94	java/io/InputStream:close	()V
    //   303: aload 23
    //   305: athrow
    //   306: ldc 93
    //   308: istore 18
    //   310: goto -109 -> 201
    //   313: astore 26
    //   315: goto -22 -> 293
    //   318: astore 27
    //   320: goto -17 -> 303
    //   323: astore 23
    //   325: aload 9
    //   327: astore 25
    //   329: aconst_null
    //   330: astore 24
    //   332: goto -49 -> 283
    //   335: astore 23
    //   337: aload 11
    //   339: astore 28
    //   341: aload 9
    //   343: astore 25
    //   345: aload 28
    //   347: astore 24
    //   349: goto -66 -> 283
    //   352: astore 29
    //   354: aconst_null
    //   355: astore 17
    //   357: aconst_null
    //   358: astore 9
    //   360: goto -187 -> 173
    //   363: astore 30
    //   365: aconst_null
    //   366: astore 17
    //   368: goto -195 -> 173
    //   371: iload 9
    //   373: istore 18
    //   375: goto -174 -> 201
    //   378: ldc 93
    //   380: istore 9
    //   382: goto -195 -> 187
    //   385: ldc 103
    //   387: istore 18
    //   389: goto -163 -> 226
    //
    // Exception table:
    //   from	to	target	type
    //   110	164	167	java/lang/Exception
    //   207	212	167	java/lang/Exception
    //   231	236	239	java/io/IOException
    //   217	222	248	java/io/IOException
    //   178	183	257	java/io/IOException
    //   192	197	266	java/io/IOException
    //   59	92	275	finally
    //   288	293	313	java/io/IOException
    //   298	303	318	java/io/IOException
    //   92	103	323	finally
    //   110	164	335	finally
    //   207	212	335	finally
    //   59	92	352	java/lang/Exception
    //   92	103	363	java/lang/Exception
  }

  protected void a(Boolean paramBoolean)
  {
    this.b.dismiss();
    if (!paramBoolean.booleanValue())
      return;
    Intent localIntent1 = new Intent("android.intent.action.VIEW");
    StringBuilder localStringBuilder = new StringBuilder().append("file://");
    String str = SettingActivity.b();
    Uri localUri = Uri.parse(str);
    Intent localIntent2 = localIntent1.setDataAndType(localUri, "application/vnd.android.package-archive");
    SettingActivity.a().startActivity(localIntent1);
  }

  protected void a(Integer[] paramArrayOfInteger)
  {
    ProgressDialog localProgressDialog = this.b;
    int i = paramArrayOfInteger[0].intValue();
    localProgressDialog.setProgress(i);
  }

  protected void onPreExecute()
  {
    fh localfh = new fh("http://10.0.2.2:8080/MyMoneySms_1.apk");
    try
    {
      HttpEntity localHttpEntity = localfh.a();
      this.c = localHttpEntity;
      Context localContext = SettingActivity.a();
      ProgressDialog localProgressDialog1 = new ProgressDialog(localContext);
      this.b = localProgressDialog1;
      this.b.setTitle("正在下载...");
      this.b.setIndeterminate(0);
      this.b.setCancelable(0);
      this.b.setProgressStyle(1);
      ProgressDialog localProgressDialog2 = this.b;
      int i = (int)this.c.getContentLength();
      localProgressDialog2.setMax(i);
      this.b.show();
      return;
    }
    catch (Exception localException)
    {
      this.c = null;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     pc
 * JD-Core Version:    0.6.0
 */