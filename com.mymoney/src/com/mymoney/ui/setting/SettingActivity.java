package com.mymoney.ui.setting;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mymoney.core.application.ApplicationContext;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.core.vo.CorporationVo;
import com.mymoney.core.vo.ProjectVo;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.helper.NetworkHelper;
import com.mymoney.ui.sync.SyncActivity;
import dh;
import dz;
import ea;
import el;
import ep;
import fn;
import g;
import gh;
import gj;
import gl;
import gt;
import gu;
import gy;
import hb;
import hk;
import hn;
import j;
import java.io.File;
import java.io.IOException;
import k;
import om;
import on;
import oo;
import op;
import oq;
import or;
import os;
import ot;
import ou;
import ov;
import ow;
import pc;
import pd;
import pe;
import pf;

public class SettingActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemSelectedListener
{
  private static String a = SettingActivity.class.getSimpleName();
  private static final String b;
  private static Context c;
  private LinearLayout A;
  private LinearLayout B;
  private LinearLayout C;
  private TextView D;
  private LinearLayout E;
  private LinearLayout F;
  private TextView G;
  private LinearLayout H;
  private LinearLayout I;
  private Button J;
  private LinearLayout K;
  private k L;
  private j M;
  private fn N;
  private pd d;
  private Button e;
  private TextView f;
  private Button g;
  private LinearLayout h;
  private LinearLayout i;
  private LinearLayout j;
  private LinearLayout k;
  private LinearLayout l;
  private LinearLayout n;
  private TextView o;
  private LinearLayout p;
  private Button q;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private LinearLayout x;
  private LinearLayout y;
  private LinearLayout z;

  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = el.a;
    b = str + "MyMoneySms_" + 1 + ".apk";
  }

  public SettingActivity()
  {
    pd localpd = new pd(this);
    this.d = localpd;
    k localk = g.a().h();
    this.L = localk;
    j localj = g.a().k();
    this.M = localj;
  }

  private void a(Class paramClass)
  {
    Context localContext = c;
    Intent localIntent = new Intent(localContext, paramClass);
    startActivity(localIntent);
  }

  private void c()
  {
    if (NetworkHelper.a(c))
    {
      i();
      return;
    }
    Context localContext = c;
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle("温馨提示").setMessage("自动升级需要在网络环境下进行,请打开你的手机网络.");
    os localos = new os(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton("打开网络", localos);
    or localor = new or(this);
    localBuilder2.setNegativeButton("取消", localor).create().show();
  }

  private void d()
  {
    Context localContext = c;
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle("温馨提示").setMessage("你确认要恢复初始数据吗?");
    ou localou = new ou(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton("确定", localou);
    ot localot = new ot(this);
    localBuilder2.setNegativeButton("取消", localot).create().show();
  }

  private void e()
  {
    String str1 = a;
    String str2 = "begin import data";
    gj.a(str1, str2);
    if (!gt.h())
      return;
    boolean bool = gu.n();
    if (bool)
      return;
    gj.a(a, "current meizu version,isn't InportDataFromHdSuccess");
    try
    {
      Context localContext1 = createPackageContext("com.mymoney", 2);
      gj.a(a, "oldMeizuVersionContext create after");
      File localFile1 = localContext1.getDatabasePath("mymoney.sqlite");
      gj.a(a, "1");
      String str3 = gu.c;
      SharedPreferences localSharedPreferences = localContext1.getSharedPreferences(str3, 0);
      gj.a(a, "2");
      gj.a(a, "3");
      ApplicationContext.b.close();
      File localFile2 = dh.c();
      gl.a(localFile1, localFile2);
      gj.a(a, "4");
      Context localContext2 = c;
      ApplicationContext.b = new dh(localContext2);
      gj.a(a, "dbHelpser is is recreate when hd data import...");
      gj.a(a, "FileCopyUtil.copy(oldMeizuVersionDbFile, MySQLiteOpenHelper.getDataBaseFile())");
      hb.b(c, "成功从HD版中转移数据到魅族M9专版中.");
      gu.g(1);
      String[] arrayOfString = localContext1.databaseList();
      int i1 = arrayOfString.length;
      int i2 = 0;
      while (i2 < i1)
      {
        String str4 = arrayOfString[i2];
        String str5 = a;
        String str6 = "databaseName is " + str4;
        gj.a(str5, str6);
        i2 += 1;
      }
      m = 0;
      str2 = null;
      if (str2 != null)
      {
        hb.b(c, "未安装过HD版!");
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        localNameNotFoundException.printStackTrace();
        String str7 = a;
        StringBuilder localStringBuilder1 = new StringBuilder().append("NameNotFoundException,");
        String str8 = localNameNotFoundException.getMessage();
        String str9 = str8;
        gj.a(str7, str9);
        int i3 = 0;
        int i4 = 1;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        localIOException.printStackTrace();
        String str10 = a;
        StringBuilder localStringBuilder2 = new StringBuilder().append("IOException");
        String str11 = localIOException.getMessage();
        String str12 = str11;
        gj.a(str10, str12);
        int i5 = 1;
        int i6 = 0;
      }
    }
    catch (Exception localException)
    {
      int m;
      while (true)
      {
        String str13 = a;
        StringBuilder localStringBuilder3 = new StringBuilder().append("Exception");
        String str14 = localException.getMessage();
        String str15 = str14;
        gj.a(str13, str15);
        int i7 = 0;
        int i8 = 0;
      }
      if (m == 0)
        return;
      hb.b(c, "数据从HD版转移失败,请退出软件再重新进入重试,谢谢!");
    }
  }

  private void f()
  {
    try
    {
      PackageInfo localPackageInfo1 = getPackageManager().getPackageInfo("com.mymoney.sms", 0);
      localPackageInfo2 = localPackageInfo1;
      if (localPackageInfo2 == null)
      {
        showDialog(2);
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      PackageInfo localPackageInfo2;
      while (true)
        localPackageInfo2 = null;
      int m = localPackageInfo2.versionCode;
      if (1 > m)
      {
        showDialog(3);
        return;
      }
      Intent localIntent = new Intent("com.mymoney.sms.ui.action.SMS_LIST_VIEW");
      startActivity(localIntent);
      finish();
    }
  }

  private Dialog g()
  {
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setTitle("下载提示");
    AlertDialog.Builder localBuilder3 = localBuilder1.setMessage("要使用短信记账功能必须下载随手记的短信记账插件，下载所需的费用由运营商收取！");
    ov localov = new ov(this);
    AlertDialog.Builder localBuilder4 = localBuilder1.setPositiveButton("下载", localov);
    AlertDialog.Builder localBuilder5 = localBuilder1.setNegativeButton("取消", null);
    return localBuilder1.create();
  }

  private Dialog h()
  {
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setTitle("温馨提示");
    AlertDialog.Builder localBuilder3 = localBuilder1.setMessage("您安装的短信记账插件版本过低，请更新短信记账插件！");
    on localon = new on(this);
    AlertDialog.Builder localBuilder4 = localBuilder1.setPositiveButton("更新", localon);
    AlertDialog.Builder localBuilder5 = localBuilder1.setNegativeButton("取消", null);
    return localBuilder1.create();
  }

  private void i()
  {
    AsyncTask localAsyncTask = new ow(this).execute(null);
  }

  private void j()
  {
    if (ep.a())
    {
      pc localpc = new pc(this, null);
      Void[] arrayOfVoid = new Void[0];
      AsyncTask localAsyncTask = localpc.execute(arrayOfVoid);
      return;
    }
    hb.b(c, "SD卡不可用，不能下载短信记账插件！");
  }

  private void k()
  {
    AsyncTask localAsyncTask = new pe(this).execute(null);
  }

  private void l()
  {
    CategoryVo localCategoryVo1 = this.L.b();
    CategoryVo localCategoryVo2 = this.L.c();
    ProjectVo localProjectVo = this.L.d();
    CorporationVo localCorporationVo = this.L.f();
    j localj = this.M;
    String str1 = this.L.a();
    hk localhk = localj.a(str1);
    TextView localTextView1 = this.r;
    String str2 = CategoryVo.b(localCategoryVo1);
    localTextView1.setText(str2);
    TextView localTextView2 = this.s;
    String str3 = CategoryVo.b(localCategoryVo2);
    localTextView2.setText(str3);
    label169: String str7;
    label213: String str8;
    if (localProjectVo.a() != 0L)
    {
      TextView localTextView3 = this.t;
      String str4 = localProjectVo.b();
      localTextView3.setText(str4);
      if (localCorporationVo.a() == 0L)
        break label324;
      TextView localTextView4 = this.u;
      String str5 = localCorporationVo.b();
      localTextView4.setText(str5);
      TextView localTextView5 = this.v;
      String str6 = this.L.e().b();
      localTextView5.setText(str6);
      TextView localTextView6 = this.w;
      if (!gu.g())
        break label337;
      str7 = "打开";
      localTextView6.setText(str7);
      TextView localTextView7 = this.D;
      if (!gu.w())
        break label345;
      str8 = "开启";
      label237: localTextView7.setText(str8);
      if (localhk != null)
        break label353;
      this.G.setText("默认币种");
    }
    while (true)
    {
      hn localhn = this.L.g();
      String str9 = localhn.a();
      String str10 = localhn.b();
      if ((TextUtils.isEmpty(str9)) || (TextUtils.isEmpty(str10)))
        break label425;
      this.o.setText("同步账户已经设置");
      return;
      this.t.setText("无默认项目");
      break;
      label324: this.u.setText("无默认商家");
      break label169;
      label337: str7 = "关闭";
      break label213;
      label345: str8 = "关闭";
      break label237;
      label353: TextView localTextView8 = this.G;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str11 = localhk.b();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str11).append("(");
      String str12 = localhk.c();
      String str13 = str12 + ")";
      localTextView8.setText(str13);
    }
    label425: this.o.setText("还没有设置同步账户");
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230807:
      finish();
      return;
    case 2131231015:
      Context localContext1 = c;
      Intent localIntent1 = new Intent(localContext1, SettingFirstLevelCategoryActivity.class);
      String str1 = SettingFirstLevelCategoryActivity.a;
      int m = SettingFirstLevelCategoryActivity.d;
      Intent localIntent2 = localIntent1.putExtra(str1, m);
      startActivity(localIntent1);
      return;
    case 2131231017:
      Context localContext2 = c;
      Intent localIntent3 = new Intent(localContext2, SettingFirstLevelCategoryActivity.class);
      String str2 = SettingFirstLevelCategoryActivity.a;
      int i1 = SettingFirstLevelCategoryActivity.c;
      Intent localIntent4 = localIntent3.putExtra(str2, i1);
      startActivity(localIntent3);
      return;
    case 2131231019:
      Context localContext3 = c;
      Intent localIntent5 = new Intent(localContext3, SettingProjectActivity.class);
      startActivity(localIntent5);
      return;
    case 2131230875:
      a(SettingCorporationActivity.class);
      return;
    case 2131230871:
      a(SettingAccountActivity.class);
      return;
    case 2131231011:
      String str3 = dh.a;
      String str4 = gy.a;
      if (str3.equals(str4))
      {
        hb.b(c, "演示模式下不能同步");
        return;
      }
      Context localContext4 = c;
      Intent localIntent6 = new Intent(localContext4, SyncActivity.class);
      String str5 = SyncActivity.a;
      Intent localIntent7 = localIntent6.putExtra(str5, 0);
      startActivity(localIntent6);
      return;
    case 2131231013:
      String str6 = dh.a;
      String str7 = gy.a;
      if (str6.equals(str7))
      {
        hb.b(c, "演示模式下不能同步");
        return;
      }
      showDialog(1);
      return;
    case 2131231014:
      String str8 = dh.a;
      String str9 = gy.a;
      if (str8.equals(str9))
      {
        hb.b(c, "演示模式下不能同步");
        return;
      }
      showDialog(1);
      return;
    case 2131231025:
      a(AddTransModeSwitchActivity.class);
      return;
    case 2131231023:
      String str10 = dh.a;
      String str11 = gy.a;
      if (str10.equals(str11))
      {
        hb.b(c, "演示模式下不能设置密码保护");
        return;
      }
      a(SettingSecurityActivity.class);
      return;
    case 2131231026:
      String str12 = dh.a;
      String str13 = gy.a;
      if (str12.equals(str13))
      {
        hb.b(c, "演示模式下不能自动升级");
        return;
      }
      c();
      return;
    case 2131231030:
      String str14 = dh.a;
      String str15 = gy.a;
      if (str14.equals(str15))
      {
        hb.b(c, "演示模式下不能备份恢复");
        return;
      }
      a(SettingBackUpActivity.class);
      return;
    case 2131231031:
      a(SettingExportDataToExcelActivity.class);
      return;
    case 2131231028:
      String str16 = dh.a;
      String str17 = gy.a;
      if (str16.equals(str17))
      {
        hb.b(c, "演示模式下不能设置记账提醒");
        return;
      }
      a(SettingTransRemindActivity.class);
      return;
    case 2131231027:
      String str18 = dh.a;
      String str19 = gy.a;
      if (str18.equals(str19))
      {
        hb.b(c, "演示模式下不能导入HD版数据");
        return;
      }
      e();
      return;
    case 2131231032:
      a(SettingCurrencyRateActivity.class);
      return;
    case 2131231034:
      f();
      return;
    case 2131231035:
      a(AboutActivity.class);
      return;
    case 2131231036:
      a(HelpActivity.class);
      return;
    case 2131231037:
    }
    String str20 = dh.a;
    String str21 = gy.a;
    if (str20.equals(str21))
    {
      hb.b(c, "演示库不能恢复初始数据");
      return;
    }
    if (gu.g())
    {
      showDialog(0);
      return;
    }
    d();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c = this;
    setContentView(2130903084);
    Button localButton1 = (Button)findViewById(2131230807);
    this.e = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.f = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.g = localButton2;
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131231015);
    this.h = localLinearLayout1;
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131231017);
    this.i = localLinearLayout2;
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131231019);
    this.j = localLinearLayout3;
    LinearLayout localLinearLayout4 = (LinearLayout)findViewById(2131230875);
    this.k = localLinearLayout4;
    LinearLayout localLinearLayout5 = (LinearLayout)findViewById(2131230871);
    this.l = localLinearLayout5;
    LinearLayout localLinearLayout6 = (LinearLayout)findViewById(2131231011);
    this.n = localLinearLayout6;
    TextView localTextView2 = (TextView)findViewById(2131231012);
    this.o = localTextView2;
    LinearLayout localLinearLayout7 = (LinearLayout)findViewById(2131231013);
    this.p = localLinearLayout7;
    Button localButton3 = (Button)findViewById(2131231014);
    this.q = localButton3;
    TextView localTextView3 = (TextView)findViewById(2131231016);
    this.r = localTextView3;
    TextView localTextView4 = (TextView)findViewById(2131231018);
    this.s = localTextView4;
    TextView localTextView5 = (TextView)findViewById(2131231022);
    this.u = localTextView5;
    TextView localTextView6 = (TextView)findViewById(2131231020);
    this.t = localTextView6;
    TextView localTextView7 = (TextView)findViewById(2131231021);
    this.v = localTextView7;
    LinearLayout localLinearLayout8 = (LinearLayout)findViewById(2131231023);
    this.x = localLinearLayout8;
    LinearLayout localLinearLayout9 = (LinearLayout)findViewById(2131231025);
    this.y = localLinearLayout9;
    LinearLayout localLinearLayout10 = (LinearLayout)findViewById(2131231026);
    this.z = localLinearLayout10;
    TextView localTextView8 = (TextView)findViewById(2131231024);
    this.w = localTextView8;
    LinearLayout localLinearLayout11 = (LinearLayout)findViewById(2131231030);
    this.A = localLinearLayout11;
    LinearLayout localLinearLayout12 = (LinearLayout)findViewById(2131231031);
    this.B = localLinearLayout12;
    LinearLayout localLinearLayout13 = (LinearLayout)findViewById(2131231028);
    this.C = localLinearLayout13;
    TextView localTextView9 = (TextView)findViewById(2131231029);
    this.D = localTextView9;
    LinearLayout localLinearLayout14 = (LinearLayout)findViewById(2131231027);
    this.E = localLinearLayout14;
    LinearLayout localLinearLayout15 = (LinearLayout)findViewById(2131231032);
    this.F = localLinearLayout15;
    TextView localTextView10 = (TextView)findViewById(2131231033);
    this.G = localTextView10;
    LinearLayout localLinearLayout16 = (LinearLayout)findViewById(2131231034);
    this.H = localLinearLayout16;
    LinearLayout localLinearLayout17 = (LinearLayout)findViewById(2131231035);
    this.I = localLinearLayout17;
    Button localButton4 = (Button)findViewById(2131231037);
    this.J = localButton4;
    LinearLayout localLinearLayout18 = (LinearLayout)findViewById(2131231036);
    this.K = localLinearLayout18;
    this.e.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.I.setOnClickListener(this);
    this.J.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.K.setOnClickListener(this);
    String str1 = gu.c();
    if ((gt.g()) || (gt.h()) || (gt.a(c)))
      this.z.setVisibility(8);
    if ((gh.a) && (gt.h()));
    this.f.setText("设置");
    this.g.setVisibility(4);
    pd localpd = this.d;
    pf localpf = new pf(this, localpd);
    dz localdz1 = dz.a();
    String str2 = ea.t;
    localdz1.a(str2, localpf);
    dz localdz2 = dz.a();
    String str3 = ea.u;
    localdz2.a(str3, localpf);
    dz localdz3 = dz.a();
    String str4 = ea.s;
    localdz3.a(str4, localpf);
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject = LayoutInflater.from(c);
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return localObject;
      View localView = ((LayoutInflater)localObject).inflate(2130903103, null);
      EditText localEditText = (EditText)localView.findViewById(2131230932);
      Context localContext1 = c;
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext1).setTitle("密码验证").setView(localView);
      oo localoo = new oo(this, localEditText);
      AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton("确定", localoo);
      om localom = new om(this);
      localObject = localBuilder2.setNegativeButton(2131492875, localom).create();
      continue;
      Context localContext2 = c;
      AlertDialog.Builder localBuilder3 = new AlertDialog.Builder(localContext2).setTitle("温馨提示").setMessage("你确定要进行同步吗?");
      oq localoq = new oq(this);
      AlertDialog.Builder localBuilder4 = localBuilder3.setPositiveButton("同步", localoq);
      op localop = new op(this);
      localObject = localBuilder4.setNegativeButton("取消", localop).create();
      continue;
      localObject = g();
      continue;
      localObject = h();
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623944, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int m = paramAdapterView.getId();
  }

  public void onNothingSelected(AdapterView paramAdapterView)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131231178:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      finish();
    }
  }

  protected void onPause()
  {
    super.onPause();
  }

  protected void onRestart()
  {
    super.onRestart();
  }

  protected void onResume()
  {
    l();
    super.onResume();
  }

  protected void onStart()
  {
    super.onStart();
  }

  protected void onStop()
  {
    super.onStop();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingActivity
 * JD-Core Version:    0.6.0
 */