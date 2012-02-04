package com.mymoney.ui.sync;

import ai;
import ak;
import an;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.helper.NetworkHelper;
import dh;
import ec;
import em;
import ep;
import ex;
import ff;
import fg;
import fu;
import fx;
import fy;
import fz;
import g;
import gh;
import gj;
import gt;
import gu;
import gx;
import gz;
import hb;
import he;
import hn;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k;
import l;
import m;
import rk;
import rl;
import rm;
import rn;
import ro;
import rp;
import rq;
import rr;
import rs;
import rt;
import ru;
import rv;
import rw;
import rx;
import ry;
import rz;
import sb;
import sl;
import wa;

public class SyncActivity extends BaseActivity
  implements View.OnClickListener, View.OnFocusChangeListener
{
  public static String a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  public static int k;
  public static int l;
  private static String o = "SyncActivity";
  private static Context p;
  private static int q;
  private Button A;
  private Button B;
  private ListView C;
  private LinearLayout D;
  private TextView E;
  private Button F;
  private Button G;
  private Button H;
  private ProgressDialog I = null;
  private AlertDialog J;
  private k K;
  private l L;
  private m M;
  private hn N;
  private SyncLogsAdapter O;
  private sl P;
  private rz Q;
  private sb R;
  private fu S;
  public boolean n;
  private String r;
  private String s;
  private Button t;
  private TextView u;
  private Button v;
  private RelativeLayout w;
  private EditText x;
  private RelativeLayout y;
  private EditText z;

  static
  {
    a = "sync_request";
    b = 0;
    c = 1;
    d = 2;
    e = 3;
    f = 4;
    g = 5;
    h = 6;
    i = 7;
    j = 8;
    k = 9;
    l = 10;
    q = 1;
  }

  public SyncActivity()
  {
    k localk = g.a().h();
    this.K = localk;
    l locall = g.a().j();
    this.L = locall;
    m localm = g.a().b();
    this.M = localm;
    Looper localLooper = Looper.getMainLooper();
    sb localsb = new sb(this, localLooper);
    this.R = localsb;
    this.S = null;
  }

  private void a(Class paramClass)
  {
    Context localContext = p;
    Intent localIntent = new Intent(localContext, paramClass);
    startActivity(localIntent);
  }

  private void a(String paramString)
  {
    Message localMessage = this.R.obtainMessage();
    if (gx.a(paramString));
    for (String str = "数据同步成功..."; ; str = paramString)
    {
      localMessage.obj = str;
      int m = c;
      localMessage.what = m;
      boolean bool = this.R.sendMessage(localMessage);
      return;
    }
  }

  private void a(boolean paramBoolean)
  {
    gj.b();
    List localList = gj.a();
    int m = localList.size();
    Iterator localIterator = localList.iterator();
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    while (true)
      if (localIterator.hasNext())
      {
        gj.a((File)localIterator.next());
        String[] arrayOfString1 = new String[1];
        arrayOfString1[0] = "0";
        if (gx.a(he.b("select platform from t_metadata", arrayOfString1, null).get("platform")).toLowerCase().indexOf("android") == -1)
        {
          m += -1;
          continue;
        }
        String[] arrayOfString2 = new String[2];
        arrayOfString2[0] = "0";
        arrayOfString2[1] = "0";
        Map localMap = he.b("select syncAccountBind, syncAccountPassword from t_profile", arrayOfString2, null);
        String str1 = gx.a(localMap.get("syncaccountbind"));
        this.r = str1;
        String str2 = gx.a(localMap.get("syncaccountpassword"));
        this.s = str2;
        try
        {
          String str3 = fz.b(this.s, "&*($HJDGH4867%&T");
          this.s = str3;
          if (gx.a(this.r))
            continue;
        }
        catch (IOException localIOException)
        {
          try
          {
            ai.a().i().b();
            sb localsb = this.R;
            fx localfx = new fx(localsb);
            StringBuilder localStringBuilder = new StringBuilder().append("正在同步第");
            i1 += 1;
            String str4 = i1 + "个，共" + m + "个";
            localfx.a(str4);
            localff = new ff();
            String str5 = this.r;
            localff.b(str5);
            localff.c("1");
            String str6 = gt.p();
            localff.a(str6);
            localff.a(paramBoolean);
            fu localfu = new fu(localfx);
            this.S = localfu;
            localfg = new fg();
          }
          catch (IOException localIOException)
          {
            try
            {
              String str7 = em.a;
              wa.a(new File(str7));
              gj.a(o, "delete debug dir success..");
            }
            catch (IOException localIOException)
            {
              try
              {
                while (true)
                {
                  ff localff;
                  fg localfg;
                  String str8 = this.S.a(localff, localfg);
                  str9 = str8;
                  i3 += 1;
                  if (gx.a(str9))
                    String str10 = "数据同步成功...";
                  if ("数据同步成功...".equalsIgnoreCase(str9))
                    break;
                  gj.d(this.r, str9);
                  break;
                  localException2.printStackTrace();
                  continue;
                  localec.printStackTrace();
                  continue;
                  localIOException.printStackTrace();
                }
              }
              catch (Exception localException1)
              {
                while (true)
                {
                  StringWriter localStringWriter = new StringWriter();
                  PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
                  localException1.printStackTrace(localPrintWriter);
                  String str9 = localStringWriter.toString();
                  i2 += 1;
                }
              }
            }
          }
        }
      }
    String str11 = "自动测试同步完成,共有" + m + ", 成功:" + i3 + ", 失败:" + i2;
    gj.d("finish", str11);
    a(str11);
  }

  private void b()
  {
    if (g())
    {
      hb.b(p, "数据正在同步中.");
      return;
    }
    c();
  }

  private void b(String paramString)
  {
    Message localMessage = this.R.obtainMessage();
    localMessage.obj = paramString;
    int m = h;
    localMessage.what = m;
    boolean bool = this.R.sendMessage(localMessage);
  }

  // ERROR //
  private void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 84	com/mymoney/ui/sync/SyncActivity:b	I
    //   3: istore_2
    //   4: aload_0
    //   5: getfield 143	com/mymoney/ui/sync/SyncActivity:R	Lsb;
    //   8: astore_3
    //   9: new 291	fx
    //   12: dup
    //   13: aload_3
    //   14: invokespecial 294	fx:<init>	(Landroid/os/Handler;)V
    //   17: astore 4
    //   19: new 335	fu
    //   22: dup
    //   23: aload 4
    //   25: invokespecial 338	fu:<init>	(Lfy;)V
    //   28: astore 5
    //   30: aload_0
    //   31: aload 5
    //   33: putfield 145	com/mymoney/ui/sync/SyncActivity:S	Lfu;
    //   36: new 319	ff
    //   39: dup
    //   40: invokespecial 320	ff:<init>	()V
    //   43: astore 6
    //   45: aload_0
    //   46: getfield 267	com/mymoney/ui/sync/SyncActivity:r	Ljava/lang/String;
    //   49: astore 7
    //   51: aload 6
    //   53: aload 7
    //   55: invokevirtual 322	ff:b	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 271	com/mymoney/ui/sync/SyncActivity:s	Ljava/lang/String;
    //   62: astore 8
    //   64: aload 6
    //   66: aload 8
    //   68: invokevirtual 326	ff:c	(Ljava/lang/String;)V
    //   71: invokestatic 330	gt:p	()Ljava/lang/String;
    //   74: astore 9
    //   76: aload 6
    //   78: aload 9
    //   80: invokevirtual 331	ff:a	(Ljava/lang/String;)V
    //   83: aload 6
    //   85: iload_1
    //   86: invokevirtual 333	ff:a	(Z)V
    //   89: new 340	fg
    //   92: dup
    //   93: invokespecial 341	fg:<init>	()V
    //   96: astore 10
    //   98: aload_0
    //   99: invokespecial 414	com/mymoney/ui/sync/SyncActivity:q	()V
    //   102: getstatic 344	em:a	Ljava/lang/String;
    //   105: astore 11
    //   107: new 226	java/io/File
    //   110: dup
    //   111: aload 11
    //   113: invokespecial 346	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: invokestatic 349	wa:a	(Ljava/io/File;)V
    //   119: getstatic 78	com/mymoney/ui/sync/SyncActivity:o	Ljava/lang/String;
    //   122: ldc_w 351
    //   125: invokestatic 354	gj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: getfield 145	com/mymoney/ui/sync/SyncActivity:S	Lfu;
    //   132: aload 6
    //   134: aload 10
    //   136: invokevirtual 357	fu:a	(Lff;Lfg;)Ljava/lang/String;
    //   139: astore 12
    //   141: aload 12
    //   143: astore 13
    //   145: getstatic 86	com/mymoney/ui/sync/SyncActivity:c	I
    //   148: istore 10
    //   150: iload 10
    //   152: istore 14
    //   154: ldc_w 416
    //   157: astore 15
    //   159: getstatic 86	com/mymoney/ui/sync/SyncActivity:c	I
    //   162: istore 16
    //   164: iload 14
    //   166: iload 16
    //   168: if_icmpne +242 -> 410
    //   171: aload_0
    //   172: aload 13
    //   174: invokespecial 388	com/mymoney/ui/sync/SyncActivity:a	(Ljava/lang/String;)V
    //   177: return
    //   178: invokevirtual 367	java/io/IOException:printStackTrace	()V
    //   181: goto -53 -> 128
    //   184: astore 17
    //   186: ldc_w 416
    //   189: astore 18
    //   191: getstatic 94	com/mymoney/ui/sync/SyncActivity:g	I
    //   194: istore 14
    //   196: aload 17
    //   198: invokevirtual 417	eh:printStackTrace	()V
    //   201: aload 18
    //   203: astore 13
    //   205: ldc_w 416
    //   208: astore 15
    //   210: goto -51 -> 159
    //   213: astore 19
    //   215: ldc_w 416
    //   218: astore 20
    //   220: getstatic 96	com/mymoney/ui/sync/SyncActivity:h	I
    //   223: istore 14
    //   225: aload 19
    //   227: invokevirtual 420	eg:getMessage	()Ljava/lang/String;
    //   230: astore 21
    //   232: aload 19
    //   234: invokevirtual 421	eg:printStackTrace	()V
    //   237: aload 20
    //   239: astore 13
    //   241: aload 21
    //   243: astore 15
    //   245: goto -86 -> 159
    //   248: astore 22
    //   250: ldc_w 416
    //   253: astore 23
    //   255: getstatic 88	com/mymoney/ui/sync/SyncActivity:d	I
    //   258: istore 14
    //   260: aload 22
    //   262: invokevirtual 422	ej:getMessage	()Ljava/lang/String;
    //   265: astore 24
    //   267: aload 24
    //   269: ldc_w 424
    //   272: invokevirtual 261	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   275: bipush 255
    //   277: if_icmpeq +8 -> 285
    //   280: getstatic 100	com/mymoney/ui/sync/SyncActivity:j	I
    //   283: istore 25
    //   285: aload 22
    //   287: invokevirtual 425	ej:printStackTrace	()V
    //   290: aload 23
    //   292: astore 13
    //   294: aload 24
    //   296: astore 15
    //   298: goto -139 -> 159
    //   301: astore 26
    //   303: ldc_w 416
    //   306: astore 27
    //   308: getstatic 102	com/mymoney/ui/sync/SyncActivity:k	I
    //   311: istore 14
    //   313: aload 26
    //   315: invokevirtual 426	ei:getMessage	()Ljava/lang/String;
    //   318: astore 28
    //   320: aload 26
    //   322: invokevirtual 427	ei:printStackTrace	()V
    //   325: aload 27
    //   327: astore 13
    //   329: aload 28
    //   331: astore 15
    //   333: goto -174 -> 159
    //   336: astore 29
    //   338: ldc_w 416
    //   341: astore 30
    //   343: getstatic 104	com/mymoney/ui/sync/SyncActivity:l	I
    //   346: istore 14
    //   348: aload 29
    //   350: invokevirtual 428	ee:getMessage	()Ljava/lang/String;
    //   353: astore 31
    //   355: aload 29
    //   357: invokevirtual 429	ee:printStackTrace	()V
    //   360: aload 30
    //   362: astore 13
    //   364: aload 31
    //   366: astore 15
    //   368: goto -209 -> 159
    //   371: astore 32
    //   373: ldc_w 416
    //   376: astore 33
    //   378: getstatic 88	com/mymoney/ui/sync/SyncActivity:d	I
    //   381: istore 14
    //   383: aload 32
    //   385: invokevirtual 365	java/lang/Exception:printStackTrace	()V
    //   388: aload 32
    //   390: invokevirtual 430	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   393: astore 34
    //   395: aload 33
    //   397: astore 35
    //   399: aload 34
    //   401: astore 15
    //   403: aload 35
    //   405: astore 13
    //   407: goto -248 -> 159
    //   410: getstatic 92	com/mymoney/ui/sync/SyncActivity:f	I
    //   413: istore 36
    //   415: iload 14
    //   417: iload 36
    //   419: if_icmpne +8 -> 427
    //   422: aload_0
    //   423: invokespecial 432	com/mymoney/ui/sync/SyncActivity:j	()V
    //   426: return
    //   427: getstatic 94	com/mymoney/ui/sync/SyncActivity:g	I
    //   430: istore 37
    //   432: iload 14
    //   434: iload 37
    //   436: if_icmpne +24 -> 460
    //   439: aload_0
    //   440: invokespecial 434	com/mymoney/ui/sync/SyncActivity:k	()V
    //   443: getstatic 78	com/mymoney/ui/sync/SyncActivity:o	Ljava/lang/String;
    //   446: astore 38
    //   448: ldc_w 436
    //   451: ldc_w 416
    //   454: aload 38
    //   456: invokestatic 442	com/flurry/android/FlurryAgent:onError	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   459: return
    //   460: getstatic 96	com/mymoney/ui/sync/SyncActivity:h	I
    //   463: istore 39
    //   465: iload 14
    //   467: iload 39
    //   469: if_icmpne +26 -> 495
    //   472: aload_0
    //   473: aload 15
    //   475: invokespecial 443	com/mymoney/ui/sync/SyncActivity:b	(Ljava/lang/String;)V
    //   478: getstatic 78	com/mymoney/ui/sync/SyncActivity:o	Ljava/lang/String;
    //   481: astore 40
    //   483: ldc_w 445
    //   486: ldc_w 416
    //   489: aload 40
    //   491: invokestatic 442	com/flurry/android/FlurryAgent:onError	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   494: return
    //   495: getstatic 88	com/mymoney/ui/sync/SyncActivity:d	I
    //   498: istore 41
    //   500: iload 14
    //   502: iload 41
    //   504: if_icmpne +25 -> 529
    //   507: aload_0
    //   508: aload 15
    //   510: invokespecial 446	com/mymoney/ui/sync/SyncActivity:c	(Ljava/lang/String;)V
    //   513: getstatic 78	com/mymoney/ui/sync/SyncActivity:o	Ljava/lang/String;
    //   516: astore 42
    //   518: ldc_w 448
    //   521: aload 15
    //   523: aload 42
    //   525: invokestatic 442	com/flurry/android/FlurryAgent:onError	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   528: return
    //   529: getstatic 102	com/mymoney/ui/sync/SyncActivity:k	I
    //   532: istore 43
    //   534: iload 14
    //   536: iload 43
    //   538: if_icmpne +29 -> 567
    //   541: ldc_w 449
    //   544: invokestatic 453	gu:h	(Z)V
    //   547: aload_0
    //   548: invokespecial 455	com/mymoney/ui/sync/SyncActivity:l	()V
    //   551: getstatic 78	com/mymoney/ui/sync/SyncActivity:o	Ljava/lang/String;
    //   554: astore 44
    //   556: ldc_w 448
    //   559: aload 15
    //   561: aload 44
    //   563: invokestatic 442	com/flurry/android/FlurryAgent:onError	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   566: return
    //   567: getstatic 104	com/mymoney/ui/sync/SyncActivity:l	I
    //   570: istore 45
    //   572: iload 14
    //   574: iload 45
    //   576: if_icmpne +23 -> 599
    //   579: aload_0
    //   580: invokespecial 458	com/mymoney/ui/sync/SyncActivity:m	()V
    //   583: getstatic 78	com/mymoney/ui/sync/SyncActivity:o	Ljava/lang/String;
    //   586: astore 46
    //   588: ldc_w 448
    //   591: aload 15
    //   593: aload 46
    //   595: invokestatic 442	com/flurry/android/FlurryAgent:onError	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   598: return
    //   599: getstatic 98	com/mymoney/ui/sync/SyncActivity:i	I
    //   602: istore 47
    //   604: iload 14
    //   606: iload 47
    //   608: if_icmpne +23 -> 631
    //   611: aload_0
    //   612: invokespecial 460	com/mymoney/ui/sync/SyncActivity:n	()V
    //   615: getstatic 78	com/mymoney/ui/sync/SyncActivity:o	Ljava/lang/String;
    //   618: astore 48
    //   620: ldc_w 462
    //   623: aload 15
    //   625: aload 48
    //   627: invokestatic 442	com/flurry/android/FlurryAgent:onError	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   630: return
    //   631: getstatic 100	com/mymoney/ui/sync/SyncActivity:j	I
    //   634: istore 49
    //   636: iload 14
    //   638: iload 49
    //   640: if_icmpeq +4 -> 644
    //   643: return
    //   644: aload_0
    //   645: invokespecial 464	com/mymoney/ui/sync/SyncActivity:o	()V
    //   648: getstatic 78	com/mymoney/ui/sync/SyncActivity:o	Ljava/lang/String;
    //   651: astore 50
    //   653: ldc_w 466
    //   656: aload 15
    //   658: aload 50
    //   660: invokestatic 442	com/flurry/android/FlurryAgent:onError	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   663: return
    //   664: astore 51
    //   666: aload 13
    //   668: astore 33
    //   670: aload 51
    //   672: astore 32
    //   674: goto -296 -> 378
    //   677: astore 52
    //   679: aload 13
    //   681: astore 30
    //   683: aload 52
    //   685: astore 29
    //   687: goto -344 -> 343
    //   690: astore 53
    //   692: aload 13
    //   694: astore 27
    //   696: aload 53
    //   698: astore 26
    //   700: goto -392 -> 308
    //   703: astore 54
    //   705: aload 13
    //   707: astore 23
    //   709: aload 54
    //   711: astore 22
    //   713: goto -458 -> 255
    //   716: astore 55
    //   718: aload 13
    //   720: astore 20
    //   722: aload 55
    //   724: astore 19
    //   726: goto -506 -> 220
    //   729: astore 56
    //   731: aload 13
    //   733: astore 18
    //   735: aload 56
    //   737: astore 17
    //   739: goto -548 -> 191
    //
    // Exception table:
    //   from	to	target	type
    //   102	128	178	java/io/IOException
    //   128	141	184	eh
    //   128	141	213	eg
    //   128	141	248	ej
    //   128	141	301	ei
    //   128	141	336	ee
    //   128	141	371	java/lang/Exception
    //   145	150	664	java/lang/Exception
    //   145	150	677	ee
    //   145	150	690	ei
    //   145	150	703	ej
    //   145	150	716	eg
    //   145	150	729	eh
  }

  private void c()
  {
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this).setTitle("温馨提示").setMessage("是否要清空输入框中的用户名和密码?");
    ro localro = new ro(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton("确定", localro);
    rn localrn = new rn(this);
    AlertDialog localAlertDialog = localBuilder2.setNegativeButton("取消", localrn).show();
  }

  private void c(String paramString)
  {
    if (gx.a(paramString));
    for (String str = "服务器错误,同步失败,本次同步取消,请重试..."; ; str = paramString)
    {
      Message localMessage = this.R.obtainMessage();
      localMessage.obj = str;
      int m = d;
      localMessage.what = m;
      boolean bool = this.R.sendMessage(localMessage);
      return;
    }
  }

  private void d()
  {
    List localList = this.L.a();
    this.O.a(localList);
  }

  private void e()
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "0";
    String str = (String)he.b("select synclabel from t_profile", arrayOfString, null).get("synclabel");
    if ((TextUtils.isEmpty(str)) && (gu.l()))
    {
      gu.f(0);
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this).setTitle("温馨提示").setMessage("  如果你想把网站数据直接覆盖到手机,请务必先在设置里恢复初始数据后再同步;    如果你是第一次跟网站同步请点击继续同步. 谢谢!");
      rq localrq = new rq(this);
      AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton("继续同步", localrq);
      rp localrp = new rp(this);
      AlertDialog localAlertDialog = localBuilder2.setNegativeButton("先恢复初始数据去", localrp).show();
      return;
    }
    if ((this.P != null) && (!this.P.isCancelled()))
    {
      AsyncTask.Status localStatus1 = AsyncTask.Status.RUNNING;
      AsyncTask.Status localStatus2 = this.P.getStatus();
      if (localStatus1 == localStatus2)
      {
        hb.b(p, "正在同步数据.");
        return;
      }
    }
    if (!ep.a())
    {
      this.n = 0;
      hb.b(p, "sd卡不可用,不同步照片.");
    }
    if (TextUtils.isEmpty(str))
      hb.b(p, "本次同步的数据量较大是慢同步,时间稍长一些...");
    sl localsl1 = new sl(this);
    this.P = localsl1;
    sl localsl2 = this.P;
    Void[] arrayOfVoid = new Void[0];
    AsyncTask localAsyncTask = localsl2.execute(arrayOfVoid);
  }

  private void f()
  {
    if (!g())
      return;
    if (this.S != null)
      this.S.a();
    boolean bool = this.P.cancel(1);
  }

  private boolean g()
  {
    if ((this.P != null) && (!this.P.isCancelled()))
    {
      AsyncTask.Status localStatus1 = AsyncTask.Status.RUNNING;
      AsyncTask.Status localStatus2 = this.P.getStatus();
      if (localStatus1 != localStatus2);
    }
    for (int m = 1; ; m = 0)
      return m;
  }

  private boolean h()
  {
    if ((this.Q != null) && (!this.Q.isCancelled()))
    {
      AsyncTask.Status localStatus1 = AsyncTask.Status.RUNNING;
      AsyncTask.Status localStatus2 = this.Q.getStatus();
      if (localStatus1 != localStatus2);
    }
    for (int m = 1; ; m = 0)
      return m;
  }

  private void i()
  {
    if ((this.Q != null) && (!this.Q.isCancelled()))
    {
      AsyncTask.Status localStatus1 = AsyncTask.Status.RUNNING;
      AsyncTask.Status localStatus2 = this.Q.getStatus();
      if (localStatus1 == localStatus2)
      {
        hb.b(p, "正在同步数据.");
        return;
      }
    }
    rz localrz1 = new rz(this);
    this.Q = localrz1;
    rz localrz2 = this.Q;
    Void[] arrayOfVoid = new Void[0];
    AsyncTask localAsyncTask = localrz2.execute(arrayOfVoid);
  }

  private void j()
  {
    Message localMessage = this.R.obtainMessage();
    localMessage.obj = "用户名或密码错误,同步失败...";
    int m = f;
    localMessage.what = m;
    boolean bool = this.R.sendMessage(localMessage);
  }

  private void k()
  {
    Message localMessage = this.R.obtainMessage();
    localMessage.obj = "另一个设备正在用此账号同步数据...";
    int m = g;
    localMessage.what = m;
    boolean bool = this.R.sendMessage(localMessage);
  }

  private void l()
  {
    Message localMessage = this.R.obtainMessage();
    localMessage.obj = "更新数据失败,请重新启动手机后重新运行";
    int m = k;
    localMessage.what = m;
    boolean bool = this.R.sendMessage(localMessage);
  }

  private void m()
  {
    Message localMessage = this.R.obtainMessage();
    localMessage.obj = "服务器忙绿，请稍候同步...";
    int m = l;
    localMessage.what = m;
    boolean bool = this.R.sendMessage(localMessage);
  }

  private void n()
  {
    Message localMessage = this.R.obtainMessage();
    localMessage.obj = "抱歉,你的网络中断或不稳定,请检查你的网络设置.";
    int m = i;
    localMessage.what = m;
    boolean bool = this.R.sendMessage(localMessage);
  }

  private void o()
  {
    Message localMessage = this.R.obtainMessage();
    localMessage.obj = "抱歉,本地数据有错误,分类服务器id不能为0.";
    int m = j;
    localMessage.what = m;
    boolean bool = this.R.sendMessage(localMessage);
  }

  private void p()
  {
    hb.b(p, "已经取消同步请求");
  }

  private void q()
  {
    String str1 = this.x.getText().toString();
    String str2 = this.z.getText().toString();
    boolean bool = this.K.a(str1, str2);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (q == paramInt1)
      this.J.dismiss();
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onClick(View paramView)
  {
    String str1 = this.x.getEditableText().toString().trim();
    this.r = str1;
    String str2 = this.z.getEditableText().toString().trim();
    this.s = str2;
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230807:
      finish();
      return;
    case 2131231102:
      boolean bool1 = this.x.requestFocus();
      return;
    case 2131231104:
      boolean bool2 = this.z.requestFocus();
      return;
    case 2131231105:
      b();
      return;
    case 2131231014:
      if ((TextUtils.isEmpty(this.r)) || (TextUtils.isEmpty(this.s)))
      {
        hb.b(p, "请填写用户名密码.");
        return;
      }
      String str3 = g.a().h().m().j();
      if ((!gx.a(str3)) && (!this.r.equalsIgnoreCase(str3)))
      {
        Context localContext1 = p;
        AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext1).setTitle("温馨提示");
        String str4 = "当前使用的数据已经由账号 " + str3 + " 同步过, 不能直接切换同步账号同步!" + "如果你需要绑定另一个同步账号请上我们的客服论坛http://www.feidee.com/service/,我们有专人指导你安全切换同步账号.谢谢!";
        AlertDialog.Builder localBuilder2 = localBuilder1.setMessage(str4);
        rk localrk = new rk(this);
        localBuilder2.setPositiveButton("确定", localrk).create().show();
        this.x.setText(str3);
        return;
      }
      gh.l = gh.g;
      if (g())
      {
        hb.b(p, "数据正在同步中.");
        return;
      }
      if (!NetworkHelper.a(p))
      {
        Context localContext2 = p;
        AlertDialog.Builder localBuilder3 = new AlertDialog.Builder(localContext2).setTitle("温馨提示").setMessage("同步需要在网络环境下进行,请打开你的手机网络.");
        rs localrs = new rs(this);
        AlertDialog.Builder localBuilder4 = localBuilder3.setPositiveButton("打开网络", localrs);
        rr localrr = new rr(this);
        AlertDialog localAlertDialog1 = localBuilder4.setNegativeButton("取消", localrr).create();
        this.J = localAlertDialog1;
        this.J.show();
        return;
      }
      if (NetworkHelper.b(p))
      {
        this.n = 1;
        e();
        return;
      }
      if (this.M.b())
      {
        AlertDialog.Builder localBuilder5 = new AlertDialog.Builder(this).setTitle("温馨提示").setMessage("你当前的手机网络不是wifi,同步照片需要耗费较多的流量和时间,建议在wifi网络环境下同步照片,你是否确定要同步照片?");
        ru localru = new ru(this);
        AlertDialog.Builder localBuilder6 = localBuilder5.setPositiveButton("不同步照片", localru);
        rt localrt = new rt(this);
        AlertDialog localAlertDialog2 = localBuilder6.setNegativeButton("同步照片", localrt).show();
        return;
      }
      this.n = 0;
      e();
      return;
    case 2131230808:
      if (gt.a(p))
      {
        Context localContext3 = p;
        AlertDialog.Builder localBuilder7 = new AlertDialog.Builder(localContext3).setTitle("温馨提示").setMessage("请上网站www.feidee.com,然后用您的邮箱注册一个账号即可同步,谢谢!");
        rw localrw = new rw(this);
        AlertDialog.Builder localBuilder8 = localBuilder7.setPositiveButton("确定", localrw);
        rv localrv = new rv(this);
        localBuilder8.setNegativeButton("取消", localrv).create().show();
        return;
      }
      a(BuyFlowActivity.class);
      return;
    case 2131231109:
      gh.l = gh.k;
      e();
      return;
    case 2131231110:
      try
      {
        dh.d();
        hb.b(p, "导出数据到sd卡成功");
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        hb.b(p, "导出数据到sd卡失败");
        return;
      }
    case 2131231111:
    }
    gh.l = gh.g;
    if ((this.Q != null) && (!this.Q.isCancelled()))
    {
      AsyncTask.Status localStatus1 = AsyncTask.Status.RUNNING;
      AsyncTask.Status localStatus2 = this.Q.getStatus();
      if (localStatus1 == localStatus2)
      {
        hb.b(p, "数据正在自动测试同步中.");
        return;
      }
    }
    if (!NetworkHelper.a(p))
    {
      Context localContext4 = p;
      AlertDialog.Builder localBuilder9 = new AlertDialog.Builder(localContext4).setTitle("温馨提示").setMessage("同步需要在网络环境下进行,请打开你的手机网络.");
      ry localry = new ry(this);
      AlertDialog.Builder localBuilder10 = localBuilder9.setPositiveButton("打开网络", localry);
      rx localrx = new rx(this);
      AlertDialog localAlertDialog3 = localBuilder10.setNegativeButton("取消", localrx).create();
      this.J = localAlertDialog3;
      this.J.show();
      return;
    }
    if (NetworkHelper.b(p))
    {
      this.n = 1;
      i();
      return;
    }
    AlertDialog.Builder localBuilder11 = new AlertDialog.Builder(this).setTitle("温馨提示").setMessage("你当前的手机网络不是wifi,同步照片需要耗费较多的流量和时间,建议在wifi网络环境下同步照片,你是否确定要同步照片?");
    rm localrm = new rm(this);
    AlertDialog.Builder localBuilder12 = localBuilder11.setPositiveButton("不同步照片", localrm);
    rl localrl = new rl(this);
    AlertDialog localAlertDialog4 = localBuilder12.setNegativeButton("同步照片", localrl).show();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    gz.b();
    p = this;
    setContentView(2130903120);
    Button localButton1 = (Button)findViewById(2131230807);
    this.t = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.u = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.v = localButton2;
    RelativeLayout localRelativeLayout1 = (RelativeLayout)findViewById(2131231102);
    this.w = localRelativeLayout1;
    EditText localEditText1 = (EditText)findViewById(2131231103);
    this.x = localEditText1;
    RelativeLayout localRelativeLayout2 = (RelativeLayout)findViewById(2131231104);
    this.y = localRelativeLayout2;
    EditText localEditText2 = (EditText)findViewById(2131230932);
    this.z = localEditText2;
    Button localButton3 = (Button)findViewById(2131231014);
    this.B = localButton3;
    Button localButton4 = (Button)findViewById(2131231105);
    this.A = localButton4;
    ListView localListView1 = (ListView)findViewById(2131231106);
    this.C = localListView1;
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131231107);
    this.D = localLinearLayout;
    TextView localTextView2 = (TextView)findViewById(2131231108);
    this.E = localTextView2;
    Button localButton5 = (Button)findViewById(2131231109);
    this.F = localButton5;
    Button localButton6 = (Button)findViewById(2131231110);
    this.H = localButton6;
    Button localButton7 = (Button)findViewById(2131231111);
    this.G = localButton7;
    this.t.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.G.setOnClickListener(this);
    Context localContext = p;
    SyncLogsAdapter localSyncLogsAdapter1 = new SyncLogsAdapter(localContext, 2130903121);
    this.O = localSyncLogsAdapter1;
    ListView localListView2 = this.C;
    SyncLogsAdapter localSyncLogsAdapter2 = this.O;
    localListView2.setAdapter(localSyncLogsAdapter2);
    hn localhn = this.K.g();
    this.N = localhn;
    EditText localEditText3 = this.x;
    String str1 = this.N.a();
    localEditText3.setText(str1);
    EditText localEditText4 = this.z;
    String str2 = this.N.b();
    localEditText4.setText(str2);
    if (gh.a)
      this.D.setVisibility(0);
    this.u.setText("数据同步");
    this.v.setText("开通");
    d();
    Intent localIntent = getIntent();
    String str3 = a;
    if (localIntent.getBooleanExtra(str3, 0))
      boolean bool = this.B.performClick();
    TextView localTextView3 = this.E;
    StringBuilder localStringBuilder = new StringBuilder().append("账单总数:");
    int m = ai.a().b().e();
    String str4 = m;
    localTextView3.setText(str4);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623948, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    q();
    gj.a(o, "onDestroy");
    super.onDestroy();
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
      return;
    switch (paramView.getId())
    {
    default:
    case 2131231103:
    case 2131230932:
    }
    while (true)
    {
      k localk = this.K;
      String str1 = this.r;
      String str2 = this.s;
      boolean bool = localk.a(str1, str2);
      return;
      String str3 = this.x.getText().toString();
      this.r = str3;
      continue;
      String str4 = this.z.getText().toString();
      this.s = str4;
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131231193:
    case 2131231192:
    case 2131231178:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      boolean bool = this.B.performClick();
      continue;
      b();
      continue;
      finish();
    }
  }

  protected void onPause()
  {
    q();
    gj.a(o, "onPause");
    super.onPause();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.sync.SyncActivity
 * JD-Core Version:    0.6.0
 */