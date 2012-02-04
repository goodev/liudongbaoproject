package com.mymoney.ui.addtrans;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import com.mymoney.core.application.ApplicationContext;
import com.mymoney.core.vo.AccountGroupVo;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.core.vo.CorporationVo;
import com.mymoney.core.vo.ProjectVo;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.helper.PickPhotoHelper;
import com.mymoney.ui.main.MainActivity;
import com.mymoney.ui.widget.DigitKeypad;
import com.mymoney.ui.widget.LineBarView;
import d;
import e;
import eo;
import f;
import fa;
import g;
import gi;
import gj;
import gp;
import gs;
import gz;
import h;
import hb;
import hh;
import i;
import il;
import im;
import in;
import io;
import ip;
import iq;
import ir;
import is;
import it;
import iu;
import iv;
import iw;
import ix;
import iy;
import iz;
import ja;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jb;
import jd;
import je;
import jf;
import jg;
import jh;
import ji;
import k;
import kl;
import kp;
import kr;
import kt;
import m;
import y;

public class AddOrEditTransactionActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  public static long k;
  private static String n = AddOrEditTransactionActivity.class.getSimpleName();
  private static Context o;
  private static Resources p;
  private RadioButton A;
  private Button B;
  private Button C;
  private Spinner D;
  private LineBarView E;
  private TextView F;
  private Spinner G;
  private Button H;
  private Spinner I;
  private FrameLayout J;
  private Spinner K;
  private Spinner L;
  private FrameLayout M;
  private Button N;
  private Button O;
  private Button P;
  private DigitKeypad Q;
  private Animation R;
  private Animation S;
  private kp T;
  private kp U;
  private kl V;
  private kr W;
  private kt X;
  private h Y;
  private e Z;
  private List aA;
  private List aB;
  private List aC;
  private List aD;
  private List aE;
  private List aF;
  private List aG;
  private List aH;
  private List aI;
  private CategoryVo aJ;
  private CategoryVo aK;
  private ProjectVo aL;
  private CategoryVo aM;
  private AccountVo aN;
  private CorporationVo aO;
  private d aa;
  private i ab;
  private m ac;
  private k ad;
  private f ae;
  private long af;
  private TransactionVo ag;
  private long ah;
  private Bitmap ai;
  private LayerDrawable aj;
  private double ak;
  private CategoryVo al;
  private CategoryVo am;
  private CategoryVo an;
  private ProjectVo ao;
  private AccountVo ap;
  private CorporationVo aq;
  private long ar;
  private String as;
  private boolean at;
  private boolean au;
  private int av;
  private int aw;
  private int ax;
  private int ay;
  private int az;
  public long l;
  private int q;
  private boolean r;
  private int s;
  private String[] t;
  private final int u;
  private final int v;
  private LinearLayout w;
  private TextView x;
  private RadioGroup y;
  private RadioButton z;

  static
  {
    a = 0;
    b = 1;
    c = 59;
    d = 59;
    e = 1;
    f = 2;
    g = 3;
    h = 4;
    i = 5;
    j = 6;
    k = 1500L;
  }

  public AddOrEditTransactionActivity()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "相机";
    arrayOfString[1] = "相册";
    this.t = arrayOfString;
    this.u = 0;
    this.v = 1;
    h localh = g.a().d();
    this.Y = localh;
    e locale = g.a().c();
    this.Z = locale;
    d locald = g.a().i();
    this.aa = locald;
    i locali = g.a().e();
    this.ab = locali;
    m localm = g.a().b();
    this.ac = localm;
    k localk = g.a().h();
    this.ad = localk;
    f localf = g.a().g();
    this.ae = localf;
    TransactionVo localTransactionVo = new TransactionVo();
    this.ag = localTransactionVo;
    this.at = 0;
    this.au = 0;
  }

  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      r();
      this.J.setVisibility(0);
      this.M.setVisibility(8);
      List localList1 = this.aB;
      this.aA = localList1;
      CategoryVo localCategoryVo1 = this.aJ;
      this.aM = localCategoryVo1;
      List localList2 = this.aH;
      this.aF = localList2;
    }
    while (true)
    {
      kp localkp1 = this.T;
      List localList3 = this.aA;
      localkp1.a(localList3);
      CategoryVo localCategoryVo2 = this.aM.e();
      Spinner localSpinner1 = this.D;
      int m = this.aA.indexOf(localCategoryVo2);
      localSpinner1.setSelection(m);
      long l1 = localCategoryVo2.a();
      a(l1);
      kl localkl = this.V;
      List localList4 = this.aF;
      localkl.a(localList4);
      List localList5 = this.aF;
      AccountVo localAccountVo = this.aN;
      int i1 = localList5.indexOf(localAccountVo);
      if ((i1 == -1) && (this.aF.size() > 1))
        i1 = 1;
      this.I.setSelection(i1);
      if (localCategoryVo2 == null)
        return;
      CategoryVo localCategoryVo3 = localCategoryVo2.e();
      kp localkp2 = this.U;
      List localList6 = this.aD;
      localkp2.a(localList6);
      Spinner localSpinner2 = this.G;
      int i2 = this.aD.indexOf(localCategoryVo3);
      localSpinner2.setSelection(i2);
      return;
      if (1 != paramInt)
        continue;
      s();
      this.J.setVisibility(8);
      this.M.setVisibility(0);
      List localList7 = this.aC;
      this.aA = localList7;
      CategoryVo localCategoryVo4 = this.aK;
      this.aM = localCategoryVo4;
      List localList8 = this.aG;
      this.aF = localList8;
    }
  }

  private void a(long paramLong)
  {
    List localList1 = this.Y.b(paramLong);
    this.aD = localList1;
    List localList2 = this.aD;
    int m = a;
    CategoryVo localCategoryVo = new CategoryVo("添加子类别");
    localList2.add(m, localCategoryVo);
  }

  private void a(hh paramhh)
  {
    if ((this.q == 2) && (paramhh.g()))
    {
      double d1 = paramhh.e();
      Resources localResources = o.getResources();
      float f1 = paramhh.f();
      float f2 = LineBarView.a;
      if (f1 <= f2)
      {
        TextView localTextView1 = this.F;
        int m = localResources.getColor(2131296279);
        localTextView1.setTextColor(m);
      }
      while (true)
      {
        TextView localTextView2 = this.F;
        StringBuilder localStringBuilder = new StringBuilder().append("余额:");
        String str1 = gs.a(d1, null);
        String str2 = str1;
        localTextView2.setText(str2);
        LineBarView localLineBarView = this.E;
        float f3 = paramhh.f();
        localLineBarView.a(f3, 0);
        this.E.setVisibility(0);
        this.F.setVisibility(0);
        return;
        TextView localTextView3 = this.F;
        int i1 = localResources.getColor(2131296278);
        localTextView3.setTextColor(i1);
      }
    }
    this.E.setVisibility(8);
    this.F.setVisibility(8);
  }

  private void a(Class paramClass)
  {
    Context localContext = o;
    Intent localIntent = new Intent(localContext, paramClass);
    startActivity(localIntent);
  }

  private void a(String paramString)
  {
    long l1 = 0L;
    if (this.s == 0)
      l1 = this.Y.e().a();
    while (TextUtils.isEmpty(paramString))
    {
      hb.b(o, "类别名称不能为空.");
      showDialog(2);
      return;
      int m = this.s;
      if (1 != m)
        continue;
      l1 = this.Y.f().a();
    }
    if ((this.s == 0) && (this.Y.b(paramString, 1, l1)))
    {
      CategoryVo localCategoryVo1 = this.Y.a(paramString, 1, l1);
      Spinner localSpinner1 = this.D;
      int i1 = this.aA.indexOf(localCategoryVo1);
      localSpinner1.setSelection(i1);
      return;
    }
    int i2 = this.s;
    if ((1 == i2) && (this.Y.c(paramString, 1, l1)))
    {
      CategoryVo localCategoryVo2 = this.Y.a(paramString, 1, l1);
      Spinner localSpinner2 = this.D;
      int i3 = this.aA.indexOf(localCategoryVo2);
      localSpinner2.setSelection(i3);
      return;
    }
    if (this.s == 0)
      long l2 = this.Y.a(paramString);
    while (true)
    {
      c();
      kp localkp = this.T;
      List localList = this.aA;
      localkp.a(localList);
      Spinner localSpinner3 = this.D;
      int i4 = this.aA.size() - 1;
      localSpinner3.setSelection(i4);
      return;
      int i5 = this.s;
      if (1 != i5)
        continue;
      long l3 = this.Y.b(paramString);
    }
  }

  private void a(String[] paramArrayOfString)
  {
    AsyncTask localAsyncTask = new jh(this).execute(paramArrayOfString);
  }

  private void b(String paramString)
  {
    long l1 = this.am.a();
    if (TextUtils.isEmpty(paramString))
    {
      hb.b(o, "子类别名称不能为空.");
      showDialog(3);
      return;
    }
    if (this.Y.b(paramString, 2, l1))
    {
      CategoryVo localCategoryVo = this.Y.a(paramString, 2, l1);
      Spinner localSpinner1 = this.G;
      int m = this.aD.indexOf(localCategoryVo);
      localSpinner1.setSelection(m);
      return;
    }
    long l2 = this.Y.a(l1, paramString);
    a(l1);
    kp localkp = this.U;
    List localList = this.aD;
    localkp.a(localList);
    Spinner localSpinner2 = this.G;
    int i1 = this.aD.size() - 1;
    localSpinner2.setSelection(i1);
  }

  private void c()
  {
    List localList1 = this.Y.a();
    this.aB = localList1;
    List localList2 = this.Y.b();
    this.aC = localList2;
    List localList3 = this.aB;
    int m = a;
    CategoryVo localCategoryVo1 = new CategoryVo("添加类别");
    localList3.add(m, localCategoryVo1);
    List localList4 = this.aC;
    int i1 = a;
    CategoryVo localCategoryVo2 = new CategoryVo("添加类别");
    localList4.add(i1, localCategoryVo2);
    if (p())
    {
      List localList5 = this.aB;
      this.aA = localList5;
      return;
    }
    if (!q())
      return;
    List localList6 = this.aC;
    this.aA = localList6;
  }

  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      hb.b(o, "商家名称不能为空.");
      showDialog(5);
      return;
    }
    if (this.ab.b(paramString))
    {
      CorporationVo localCorporationVo = this.ab.c(paramString);
      Spinner localSpinner1 = this.K;
      int m = this.aI.indexOf(localCorporationVo);
      localSpinner1.setSelection(m);
      return;
    }
    long l1 = this.ab.a(paramString);
    d();
    kr localkr = this.W;
    List localList = this.aI;
    localkr.a(localList);
    Spinner localSpinner2 = this.K;
    int i1 = this.aI.size() - 1;
    localSpinner2.setSelection(i1);
  }

  private void d()
  {
    List localList1 = this.ab.a();
    this.aI = localList1;
    List localList2 = this.aI;
    int m = a;
    CorporationVo localCorporationVo1 = new CorporationVo("添加商家");
    localList2.add(m, localCorporationVo1);
    List localList3 = this.aI;
    int i1 = b;
    CorporationVo localCorporationVo2 = new CorporationVo("无商家");
    localList3.add(i1, localCorporationVo2);
  }

  private void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      hb.b(o, "项目名称不能为空.");
      showDialog(6);
      return;
    }
    fa localfa = new fa();
    localfa.a(paramString);
    localfa.a(1);
    long l1 = y.a().b(localfa);
    f();
    kt localkt = this.X;
    List localList = this.aE;
    localkt.a(localList);
    Spinner localSpinner = this.L;
    int m = this.aE.size() - 1;
    localSpinner.setSelection(m);
  }

  private void e()
  {
    List localList1 = this.Z.d();
    this.aH = localList1;
    List localList2 = this.Z.c();
    this.aG = localList2;
    AccountVo localAccountVo = new AccountVo();
    localAccountVo.a("添加账户");
    localAccountVo.d("添加账户");
    List localList3 = this.aH;
    int m = a;
    localList3.add(m, localAccountVo);
    List localList4 = this.aG;
    int i1 = a;
    localList4.add(i1, localAccountVo);
    if (p())
    {
      List localList5 = this.aH;
      this.aF = localList5;
      return;
    }
    if (!q())
      return;
    List localList6 = this.aG;
    this.aF = localList6;
  }

  private void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      hb.b(o, "账户名称不能为空.");
      showDialog(4);
      return;
    }
    if (this.Z.a(paramString))
    {
      AccountVo localAccountVo1 = this.Z.b(paramString);
      Spinner localSpinner1 = this.I;
      int m = this.aF.indexOf(localAccountVo1);
      localSpinner1.setSelection(m);
      return;
    }
    AccountGroupVo localAccountGroupVo = (AccountGroupVo)this.aa.c().get("现金口袋");
    AccountVo localAccountVo2 = new AccountVo(paramString);
    String str = ApplicationContext.g;
    localAccountVo2.b(str);
    localAccountVo2.a(localAccountGroupVo);
    long l1 = this.Z.a(localAccountVo2);
    e();
    kl localkl = this.V;
    List localList = this.aF;
    localkl.a(localList);
    Spinner localSpinner2 = this.I;
    int i1 = this.aF.size() - 1;
    localSpinner2.setSelection(i1);
  }

  private void f()
  {
    List localList1 = y.a().a(1);
    this.aE = localList1;
    List localList2 = this.aE;
    int m = a;
    ProjectVo localProjectVo1 = new ProjectVo("添加项目");
    localList2.add(m, localProjectVo1);
    List localList3 = this.aE;
    int i1 = b;
    ProjectVo localProjectVo2 = new ProjectVo("无项目");
    localList3.add(i1, localProjectVo2);
  }

  private void g()
  {
    if (Environment.getExternalStorageState().equals("removed"))
    {
      hb.b(o, "对不起,未加载sd卡,你不能编辑照片");
      return;
    }
    int m = this.q;
    if ((3 == m) && (this.ai != null) && (!TextUtils.isEmpty(this.ag.d())))
    {
      Context localContext = o;
      Intent localIntent1 = new Intent(localContext, TransactionPhotoEditActivity.class);
      String str = TransactionPhotoEditActivity.f;
      long l1 = this.ag.a();
      Intent localIntent2 = localIntent1.putExtra(str, l1);
      int i1 = g;
      startActivityForResult(localIntent1, i1);
      return;
    }
    showDialog(1);
  }

  private boolean h()
  {
    int m = this.q;
    int i2;
    if (3 == m)
    {
      e locale = this.Z;
      long l1 = this.af;
      int i1 = locale.d(l1).c().c().d();
      if (1 == i1)
      {
        hb.b(o, "抱歉,负债账户相关的交易不可编辑.");
        finish();
        i2 = 0;
      }
    }
    while (true)
    {
      return i2;
      String str1 = this.N.getText().toString();
      this.as = str1;
      if ((this.al.e() == null) || (this.ap == null) || ((p()) && (this.aq == null)))
      {
        hb.b(o, "对不起,请填写数据完整");
        i2 = 0;
        continue;
      }
      int i3 = this.av;
      int i4 = a;
      if (i3 == i4)
      {
        hb.b(o, "请选择类别");
        i2 = 0;
        continue;
      }
      int i5 = this.aw;
      int i6 = a;
      if (i5 == i6)
      {
        hb.b(o, "请选择子类别,如果没有子类别请先添加一个.");
        i2 = 0;
        continue;
      }
      int i7 = this.ax;
      int i8 = a;
      if (i7 == i8)
      {
        hb.b(o, "请选择账户");
        i2 = 0;
        continue;
      }
      if ((this.ai != null) && (this.at))
      {
        String str2 = eo.a();
        String str3 = this.ag.d();
        this.ag.b(str2);
        this.ag.a(1);
        String[] arrayOfString = new String[2];
        arrayOfString[0] = str2;
        arrayOfString[1] = str3;
        a(arrayOfString);
      }
      TransactionVo localTransactionVo1 = this.ag;
      int i9 = this.s;
      localTransactionVo1.a(i9);
      TransactionVo localTransactionVo2 = this.ag;
      double d1 = this.ak;
      localTransactionVo2.a(d1);
      TransactionVo localTransactionVo3 = this.ag;
      CategoryVo localCategoryVo = this.al;
      localTransactionVo3.a(localCategoryVo);
      TransactionVo localTransactionVo4 = this.ag;
      long l2 = this.ar;
      localTransactionVo4.b(l2);
      TransactionVo localTransactionVo5 = this.ag;
      AccountVo localAccountVo = this.ap;
      localTransactionVo5.a(localAccountVo);
      TransactionVo localTransactionVo6 = this.ag;
      CorporationVo localCorporationVo = this.aq;
      localTransactionVo6.a(localCorporationVo);
      TransactionVo localTransactionVo7 = this.ag;
      ProjectVo localProjectVo = this.ao;
      localTransactionVo7.a(localProjectVo);
      TransactionVo localTransactionVo8 = this.ag;
      String str4 = this.as;
      localTransactionVo8.a(str4);
      i();
      i2 = 1;
    }
  }

  private void i()
  {
    ji localji = new ji(this);
    Void[] arrayOfVoid = new Void[0];
    AsyncTask localAsyncTask = localji.execute(arrayOfVoid);
  }

  private void j()
  {
    try
    {
      Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      int m = e;
      startActivityForResult(localIntent, m);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void k()
  {
    Intent localIntent1 = PickPhotoHelper.a();
    try
    {
      Intent localIntent2 = Intent.createChooser(localIntent1, "选择照片");
      int m = f;
      startActivityForResult(localIntent2, m);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      localActivityNotFoundException.printStackTrace();
      hb.b(o, "未找到图片浏览器");
      return;
    }
    catch (Exception localException)
    {
      hb.b(o, "未知错误");
    }
  }

  private void l()
  {
    DigitKeypad localDigitKeypad1 = this.Q;
    Animation localAnimation1 = this.R;
    localDigitKeypad1.setAnimation(localAnimation1);
    DigitKeypad localDigitKeypad2 = this.Q;
    Animation localAnimation2 = this.R;
    localDigitKeypad2.startAnimation(localAnimation2);
  }

  private void m()
  {
    DigitKeypad localDigitKeypad1 = this.Q;
    Animation localAnimation1 = this.S;
    localDigitKeypad1.setAnimation(localAnimation1);
    DigitKeypad localDigitKeypad2 = this.Q;
    Animation localAnimation2 = this.S;
    localDigitKeypad2.startAnimation(localAnimation2);
  }

  private void n()
  {
    jb localjb = new jb(this);
    Void[] arrayOfVoid = new Void[0];
    AsyncTask localAsyncTask = localjb.execute(arrayOfVoid);
  }

  private void o()
  {
    if (this.ai == null)
      return;
    if (this.aj != null)
      this.aj.setCallback(null);
    LayerDrawable localLayerDrawable1 = (LayerDrawable)p.getDrawable(2130837702);
    this.aj = localLayerDrawable1;
    LayerDrawable localLayerDrawable2 = this.aj;
    Drawable localDrawable = gp.a(this.ai);
    boolean bool = localLayerDrawable2.setDrawableByLayerId(2131231173, localDrawable);
    Button localButton = this.B;
    LayerDrawable localLayerDrawable3 = this.aj;
    localButton.setBackgroundDrawable(localLayerDrawable3);
  }

  private boolean p()
  {
    if (this.s == 0);
    for (int m = 1; ; m = 0)
      return m;
  }

  private boolean q()
  {
    if (this.s == 1);
    for (int m = 1; ; m = 0)
      return m;
  }

  private void r()
  {
    this.s = 0;
  }

  private void s()
  {
    this.s = 1;
  }

  public String a(Uri paramUri)
  {
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = "_data";
    AddOrEditTransactionActivity localAddOrEditTransactionActivity = this;
    Uri localUri = paramUri;
    String[] arrayOfString2 = null;
    String str = null;
    Cursor localCursor = localAddOrEditTransactionActivity.managedQuery(localUri, arrayOfString1, null, arrayOfString2, str);
    int m = localCursor.getColumnIndexOrThrow("_data");
    boolean bool = localCursor.moveToFirst();
    return localCursor.getString(m);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    int m = e;
    if (paramInt1 == m)
    {
      if (paramInt2 == -1)
      {
        Bundle localBundle1 = paramIntent.getExtras();
        if (this.ai != null)
          this.ai.recycle();
        Bitmap localBitmap1 = (Bitmap)localBundle1.get("data");
        this.ai = localBitmap1;
        this.at = 1;
        o();
        return;
      }
      if (paramInt2 != 0)
        return;
      return;
    }
    int i1 = f;
    if (paramInt1 == i1)
    {
      if (paramInt2 == -1)
      {
        Bundle localBundle2 = paramIntent.getExtras();
        if (localBundle2 != null)
        {
          Bitmap localBitmap2 = (Bitmap)localBundle2.getParcelable("data");
          this.ai = localBitmap2;
          this.at = 1;
          o();
          return;
        }
        Uri localUri = paramIntent.getData();
        Bitmap localBitmap3 = BitmapFactory.decodeFile(a(localUri));
        this.ai = localBitmap3;
        this.at = 1;
        o();
        return;
      }
      if (paramInt2 != 0)
        return;
      return;
    }
    int i2 = g;
    if (paramInt1 == i2)
    {
      int i3 = i;
      if (paramInt2 != i3)
        return;
      this.at = 0;
      m localm = this.ac;
      long l1 = this.ah;
      String str1 = localm.a(l1).d();
      this.ag.b(str1);
      this.ag.a(1);
      if (TextUtils.isEmpty(str1))
        return;
      if (Environment.getExternalStorageState().equals("removed"))
      {
        hb.b(o, "未加载sd卡,与该账单相关的照片无法显示");
        return;
      }
      Bitmap localBitmap4 = BitmapFactory.decodeFile(eo.a(str1));
      this.ai = localBitmap4;
      o();
      return;
    }
    int i4 = h;
    if (paramInt1 != i4)
      return;
    int i5 = j;
    if (paramInt2 != i5)
      return;
    String str2 = paramIntent.getStringExtra("memo");
    this.ag.a(str2);
    this.N.setText(str2);
  }

  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 2131230732:
      a(0);
      return;
    case 2131230733:
    }
    a(1);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230734:
      g();
      return;
    case 2131230735:
      l();
      DigitKeypad localDigitKeypad = this.Q;
      String str = gs.b(this.ak);
      localDigitKeypad.a(str);
      return;
    case 2131230745:
      int m = gi.b(this.ar);
      int i1 = gi.c(this.ar);
      int i2 = gi.d(this.ar);
      Context localContext = o;
      il localil = new il(this);
      new DatePickerDialog(localContext, localil, m, i1, i2).show();
      return;
    case 2131230748:
      showDialog(7);
      return;
    case 2131230750:
      boolean bool = h();
      return;
    case 2131230751:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    gj.a(n, "onCreate()");
    super.onCreate(paramBundle);
    gz.b();
    o = this;
    p = o.getResources();
    setContentView(2130903041);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131230729);
    this.w = localLinearLayout;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.x = localTextView1;
    RadioGroup localRadioGroup = (RadioGroup)findViewById(2131230731);
    this.y = localRadioGroup;
    RadioButton localRadioButton1 = (RadioButton)findViewById(2131230732);
    this.z = localRadioButton1;
    this.z.setEnabled(0);
    RadioButton localRadioButton2 = (RadioButton)findViewById(2131230733);
    this.A = localRadioButton2;
    this.A.setEnabled(0);
    Button localButton1 = (Button)findViewById(2131230734);
    this.B = localButton1;
    Button localButton2 = (Button)findViewById(2131230735);
    this.C = localButton2;
    Spinner localSpinner1 = (Spinner)findViewById(2131230736);
    this.D = localSpinner1;
    LineBarView localLineBarView = (LineBarView)findViewById(2131230738);
    this.E = localLineBarView;
    TextView localTextView2 = (TextView)findViewById(2131230739);
    this.F = localTextView2;
    Spinner localSpinner2 = (Spinner)findViewById(2131230740);
    this.G = localSpinner2;
    Button localButton3 = (Button)findViewById(2131230745);
    this.H = localButton3;
    Spinner localSpinner3 = (Spinner)findViewById(2131230741);
    this.I = localSpinner3;
    FrameLayout localFrameLayout1 = (FrameLayout)findViewById(2131230742);
    this.J = localFrameLayout1;
    Spinner localSpinner4 = (Spinner)findViewById(2131230743);
    this.K = localSpinner4;
    Spinner localSpinner5 = (Spinner)findViewById(2131230747);
    this.L = localSpinner5;
    FrameLayout localFrameLayout2 = (FrameLayout)findViewById(2131230749);
    this.M = localFrameLayout2;
    Button localButton4 = (Button)findViewById(2131230748);
    this.N = localButton4;
    Button localButton5 = (Button)findViewById(2131230750);
    this.O = localButton5;
    Button localButton6 = (Button)findViewById(2131230751);
    this.P = localButton6;
    DigitKeypad localDigitKeypad1 = (DigitKeypad)findViewById(2131230752);
    this.Q = localDigitKeypad1;
    this.y.setOnCheckedChangeListener(this);
    this.B.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.N.setOnClickListener(this);
    this.O.setOnClickListener(this);
    this.P.setOnClickListener(this);
    DigitKeypad localDigitKeypad2 = this.Q;
    je localje = new je(this);
    localDigitKeypad2.a(localje);
    DigitKeypad localDigitKeypad3 = this.Q;
    jf localjf = new jf(this);
    localDigitKeypad3.a(localjf);
    this.D.setOnItemSelectedListener(this);
    this.G.setOnItemSelectedListener(this);
    this.I.setOnItemSelectedListener(this);
    this.K.setOnItemSelectedListener(this);
    this.L.setOnItemSelectedListener(this);
    Intent localIntent = getIntent();
    int m = localIntent.getIntExtra("transType", -1);
    this.s = m;
    int i1 = localIntent.getIntExtra("state", 0);
    this.q = i1;
    boolean bool = localIntent.getBooleanExtra("isFromSecurityLogin", 0);
    this.r = bool;
    if ((this.s == -1) || (this.q == 0))
    {
      hb.b(o, "参数错误.");
      finish();
    }
    if (this.q == 1)
    {
      String str1 = localIntent.getStringExtra("memo");
      long l1 = localIntent.getLongExtra("planningItemId", 65535L);
      this.l = l1;
      this.N.setText(str1);
      long l2 = gi.k();
      this.ar = l2;
      Button localButton7 = this.H;
      String str2 = gi.f(this.ar);
      localButton7.setText(str2);
      Animation localAnimation1 = AnimationUtils.loadAnimation(o, 2130968577);
      this.R = localAnimation1;
      Animation localAnimation2 = this.R;
      jg localjg = new jg(this);
      localAnimation2.setAnimationListener(localjg);
      Animation localAnimation3 = AnimationUtils.loadAnimation(o, 2130968576);
      this.S = localAnimation3;
      Animation localAnimation4 = this.S;
      jd localjd = new jd(this);
      localAnimation4.setAnimationListener(localjd);
      Context localContext1 = o;
      kp localkp1 = new kp(localContext1, 2130903112);
      this.T = localkp1;
      this.T.a(2130903111);
      Spinner localSpinner6 = this.D;
      kp localkp2 = this.T;
      localSpinner6.setAdapter(localkp2);
      Context localContext2 = o;
      kp localkp3 = new kp(localContext2, 2130903112);
      this.U = localkp3;
      this.U.a(2130903111);
      Spinner localSpinner7 = this.G;
      kp localkp4 = this.U;
      localSpinner7.setAdapter(localkp4);
      Context localContext3 = o;
      kl localkl1 = new kl(localContext3, 2130903112);
      this.V = localkl1;
      this.V.a(2130903111);
      Spinner localSpinner8 = this.I;
      kl localkl2 = this.V;
      localSpinner8.setAdapter(localkl2);
      Context localContext4 = o;
      kr localkr1 = new kr(localContext4, 2130903112);
      this.W = localkr1;
      this.W.a(2130903111);
      Spinner localSpinner9 = this.K;
      kr localkr2 = this.W;
      localSpinner9.setAdapter(localkr2);
      Context localContext5 = o;
      kt localkt1 = new kt(localContext5, 2130903114);
      this.X = localkt1;
      this.X.a(2130903111);
      Spinner localSpinner10 = this.L;
      kt localkt2 = this.X;
      localSpinner10.setAdapter(localkt2);
      if (this.s != 0)
        break label1308;
      CategoryVo localCategoryVo1 = this.Y.e();
      this.al = localCategoryVo1;
    }
    while (true)
    {
      TransactionVo localTransactionVo = this.ag;
      CategoryVo localCategoryVo2 = this.al;
      localTransactionVo.a(localCategoryVo2);
      n();
      return;
      if (this.q == 3)
      {
        long l3 = localIntent.getLongExtra("id", 0L);
        this.ah = l3;
        if (this.ah == 0L)
        {
          hb.b(o, "系统错误");
          finish();
        }
        this.y.setVisibility(8);
        if (this.s == 1)
        {
          this.x.setText("编辑收入");
          break;
        }
        if (this.s != 0)
          break;
        this.x.setText("编辑支出");
        break;
      }
      if (this.q == 2)
      {
        this.x.setVisibility(8);
        double d1 = localIntent.getDoubleExtra("cost", 0.0D);
        this.ak = d1;
        String str3 = localIntent.getStringExtra("memo");
        this.as = str3;
        break;
      }
      hb.b(o, "系统错误");
      finish();
      break;
      label1308: if (this.s != 1)
        continue;
      CategoryVo localCategoryVo3 = this.Y.f();
      this.al = localCategoryVo3;
      this.J.setVisibility(8);
    }
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject = LayoutInflater.from(o);
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (true)
    {
      return localObject;
      Context localContext1 = o;
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext1).setTitle("选择照片");
      String[] arrayOfString = this.t;
      it localit = new it(this);
      localObject = localBuilder1.setItems(arrayOfString, localit).create();
      continue;
      View localView1 = ((LayoutInflater)localObject).inflate(2130903042, null);
      EditText localEditText1 = (EditText)localView1.findViewById(2131230754);
      Context localContext2 = o;
      AlertDialog.Builder localBuilder2 = new AlertDialog.Builder(localContext2).setTitle("添加类别").setView(localView1);
      iv localiv = new iv(this, localEditText1);
      AlertDialog.Builder localBuilder3 = localBuilder2.setPositiveButton("添加", localiv);
      iu localiu = new iu(this, localEditText1);
      localObject = localBuilder3.setNegativeButton(2131492875, localiu).create();
      continue;
      View localView2 = ((LayoutInflater)localObject).inflate(2130903042, null);
      EditText localEditText2 = (EditText)localView2.findViewById(2131230754);
      Context localContext3 = o;
      AlertDialog.Builder localBuilder4 = new AlertDialog.Builder(localContext3).setTitle("添加子类别").setView(localView2);
      ix localix = new ix(this, localEditText2);
      AlertDialog.Builder localBuilder5 = localBuilder4.setPositiveButton("添加", localix);
      iw localiw = new iw(this, localEditText2);
      localObject = localBuilder5.setNegativeButton(2131492875, localiw).create();
      continue;
      View localView3 = ((LayoutInflater)localObject).inflate(2130903042, null);
      EditText localEditText3 = (EditText)localView3.findViewById(2131230754);
      Context localContext4 = o;
      AlertDialog.Builder localBuilder6 = new AlertDialog.Builder(localContext4).setTitle("添加账户").setView(localView3);
      iz localiz = new iz(this, localEditText3);
      AlertDialog.Builder localBuilder7 = localBuilder6.setPositiveButton("添加", localiz);
      iy localiy = new iy(this, localEditText3);
      localObject = localBuilder7.setNegativeButton(2131492875, localiy).create();
      continue;
      View localView4 = ((LayoutInflater)localObject).inflate(2130903042, null);
      EditText localEditText4 = (EditText)localView4.findViewById(2131230754);
      Context localContext5 = o;
      AlertDialog.Builder localBuilder8 = new AlertDialog.Builder(localContext5).setTitle("添加商家").setView(localView4);
      im localim = new im(this, localEditText4);
      AlertDialog.Builder localBuilder9 = localBuilder8.setPositiveButton("添加", localim);
      ja localja = new ja(this, localEditText4);
      localObject = localBuilder9.setNegativeButton(2131492875, localja).create();
      continue;
      View localView5 = ((LayoutInflater)localObject).inflate(2130903042, null);
      EditText localEditText5 = (EditText)localView5.findViewById(2131230754);
      Context localContext6 = o;
      AlertDialog.Builder localBuilder10 = new AlertDialog.Builder(localContext6).setTitle("添加项目").setView(localView5);
      io localio = new io(this, localEditText5);
      AlertDialog.Builder localBuilder11 = localBuilder10.setPositiveButton("添加", localio);
      in localin = new in(this, localEditText5);
      localObject = localBuilder11.setNegativeButton(2131492875, localin).create();
      continue;
      View localView6 = ((LayoutInflater)localObject).inflate(2130903057, null);
      EditText localEditText6 = (EditText)localView6.findViewById(2131230776);
      String str = this.as;
      localEditText6.setText(str);
      Context localContext7 = o;
      AlertDialog.Builder localBuilder12 = new AlertDialog.Builder(localContext7).setTitle("备注").setView(localView6);
      iq localiq = new iq(this, localEditText6);
      AlertDialog.Builder localBuilder13 = localBuilder12.setPositiveButton("保存", localiq);
      ip localip = new ip(this, localEditText6);
      localObject = localBuilder13.setNegativeButton(2131492875, localip).create();
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131623936, paramMenu);
    int m = this.q;
    if (2 == m)
      MenuItem localMenuItem1 = paramMenu.getItem(2).setVisible(0);
    if (this.r)
      MenuItem localMenuItem2 = paramMenu.getItem(4).setVisible(0);
    return true;
  }

  protected void onDestroy()
  {
    gj.a(n, "onDestroy()");
    super.onDestroy();
  }

  public void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    switch (paramAdapterView.getId())
    {
    default:
      return;
    case 2131230736:
      this.av = paramInt;
      int m = a;
      if (paramInt == m)
      {
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        showDialog(2);
        return;
      }
      CategoryVo localCategoryVo1 = new CategoryVo();
      this.am = localCategoryVo1;
      this.am.a(paramLong);
      CategoryVo localCategoryVo2 = this.al;
      CategoryVo localCategoryVo3 = this.am;
      localCategoryVo2.e(localCategoryVo3);
      hh localhh = this.ae.a(paramLong);
      a(localhh);
      a(paramLong);
      kp localkp = this.U;
      List localList = this.aD;
      localkp.a(localList);
      return;
    case 2131230740:
      this.aw = paramInt;
      int i1 = a;
      if (paramInt == i1)
      {
        showDialog(3);
        return;
      }
      CategoryVo localCategoryVo4 = new CategoryVo();
      this.an = localCategoryVo4;
      this.an.a(paramLong);
      CategoryVo localCategoryVo5 = this.am;
      CategoryVo localCategoryVo6 = this.an;
      localCategoryVo5.e(localCategoryVo6);
      return;
    case 2131230741:
      this.ax = paramInt;
      int i2 = a;
      if (paramInt == i2)
      {
        showDialog(4);
        return;
      }
      AccountVo localAccountVo = new AccountVo();
      this.ap = localAccountVo;
      this.ap.a(paramLong);
      return;
    case 2131230743:
      this.ay = paramInt;
      int i3 = a;
      if (paramInt == i3)
        showDialog(5);
      while (true)
      {
        CorporationVo localCorporationVo = new CorporationVo();
        this.aq = localCorporationVo;
        this.aq.a(paramLong);
        return;
        int i4 = b;
        if (paramInt != i4)
          continue;
      }
    case 2131230747:
    }
    this.az = paramInt;
    int i5 = a;
    if (paramInt == i5)
    {
      showDialog(6);
      return;
    }
    int i6 = b;
    if (paramInt == i6)
      return;
    ProjectVo localProjectVo = new ProjectVo();
    this.ao = localProjectVo;
    this.ao.a(paramLong);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.Q.a()))
      m();
    boolean bool;
    for (int m = 1; ; bool = super.onKeyDown(paramInt, paramKeyEvent))
      return m;
  }

  public void onNothingSelected(AdapterView paramAdapterView)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool1 = super.onOptionsItemSelected(paramMenuItem);
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131231174:
    case 2131231175:
    case 2131231176:
    case 2131231177:
    case 2131231178:
    }
    while (true)
    {
      return true;
      boolean bool2 = h();
      continue;
      finish();
      continue;
      int m = this.q;
      if (3 != m)
        continue;
      Context localContext = o;
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle(2131492899).setMessage(2131492900);
      is localis = new is(this);
      AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton(2131492901, localis);
      ir localir = new ir(this);
      localBuilder2.setNegativeButton(2131492902, localir).create().show();
      continue;
      g();
      continue;
      a(MainActivity.class);
    }
  }

  protected void onPause()
  {
    gj.a(n, "onPause()");
    super.onPause();
  }

  protected void onRestart()
  {
    gj.a(n, "onRestart()");
    super.onRestart();
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    this.au = 1;
    int m = paramBundle.getInt("state");
    this.q = m;
    int i1 = paramBundle.getInt("transType");
    this.s = i1;
    long l1 = paramBundle.getLong("id");
    this.ah = l1;
    Bitmap localBitmap = (Bitmap)paramBundle.getParcelable("photoBitmap");
    this.ai = localBitmap;
    boolean bool = paramBundle.getBoolean("needSavePhotoToSd");
    this.at = bool;
    double d1 = paramBundle.getDouble("cost");
    this.ak = d1;
    int i2 = paramBundle.getInt("firstLevelCategorySpnSelectedPosition");
    this.av = i2;
    int i3 = paramBundle.getInt("subcategorySpnSelectedPosition");
    this.aw = i3;
    int i4 = paramBundle.getInt("corporationSpnSelectedPosition");
    this.ay = i4;
    int i5 = paramBundle.getInt("accountSpnSelectedPosition");
    this.ax = i5;
    int i6 = paramBundle.getInt("projectCategorySpnSelectedPosition");
    this.az = i6;
    ArrayList localArrayList1 = paramBundle.getParcelableArrayList("firstLevelCategoryList");
    this.aA = localArrayList1;
    ArrayList localArrayList2 = paramBundle.getParcelableArrayList("subcategoryList");
    this.aD = localArrayList2;
    ArrayList localArrayList3 = paramBundle.getParcelableArrayList("accountList");
    this.aF = localArrayList3;
    ArrayList localArrayList4 = paramBundle.getParcelableArrayList("corporationList");
    this.aI = localArrayList4;
    ArrayList localArrayList5 = paramBundle.getParcelableArrayList("projectCategoryList");
    this.aE = localArrayList5;
    CategoryVo localCategoryVo1 = (CategoryVo)paramBundle.get("defaultPayoutCategory");
    this.aJ = localCategoryVo1;
    CategoryVo localCategoryVo2 = (CategoryVo)paramBundle.get("defaultIncomeCategory");
    this.aK = localCategoryVo2;
    CategoryVo localCategoryVo3 = (CategoryVo)paramBundle.get("defaultCategory");
    this.aM = localCategoryVo3;
    long l2 = paramBundle.getLong("tradeTime");
    this.ar = l2;
    String str1 = paramBundle.getString("memo");
    this.as = str1;
    TransactionVo localTransactionVo = (TransactionVo)paramBundle.get("transactionVo");
    this.ag = localTransactionVo;
    o();
    Button localButton1 = this.C;
    String str2 = gs.a(this.ak, null);
    localButton1.setText(str2);
    Button localButton2 = this.H;
    String str3 = gi.f(this.ar);
    localButton2.setText(str3);
    Button localButton3 = this.N;
    String str4 = this.as;
    localButton3.setText(str4);
    String str5 = n;
    StringBuilder localStringBuilder1 = new StringBuilder().append("onRestoreInstanceState,firstLevelCategoryList size is ");
    int i7 = this.aA.size();
    String str6 = i7;
    gj.a(str5, str6);
    String str7 = n;
    StringBuilder localStringBuilder2 = new StringBuilder().append("onRestoreInstanceState,mSubcategoryList size is ");
    int i8 = this.aD.size();
    String str8 = i8;
    gj.a(str7, str8);
    String str9 = n;
    StringBuilder localStringBuilder3 = new StringBuilder().append("onRestoreInstanceState,mCorporationList size is ");
    int i9 = this.aI.size();
    String str10 = i9;
    gj.a(str9, str10);
    String str11 = n;
    StringBuilder localStringBuilder4 = new StringBuilder().append("onRestoreInstanceState,mCorporationSelectedPosition is ");
    int i10 = this.ay;
    String str12 = i10;
    gj.a(str11, str12);
  }

  protected void onResume()
  {
    gj.a(n, "onResume()");
    super.onResume();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    String str1 = this.N.getText().toString();
    this.as = str1;
    super.onSaveInstanceState(paramBundle);
    int m = this.q;
    paramBundle.putInt("state", m);
    int i1 = this.s;
    paramBundle.putInt("transType", i1);
    long l1 = this.ah;
    paramBundle.putLong("id", l1);
    Bitmap localBitmap = this.ai;
    paramBundle.putParcelable("photoBitmap", localBitmap);
    boolean bool = this.at;
    paramBundle.putBoolean("needSavePhotoToSd", bool);
    double d1 = this.ak;
    paramBundle.putDouble("cost", d1);
    int i2 = this.av;
    paramBundle.putInt("firstLevelCategorySpnSelectedPosition", i2);
    int i3 = this.aw;
    paramBundle.putInt("subcategorySpnSelectedPosition", i3);
    int i4 = this.ay;
    paramBundle.putInt("corporationSpnSelectedPosition", i4);
    int i5 = this.ax;
    paramBundle.putInt("accountSpnSelectedPosition", i5);
    int i6 = this.az;
    paramBundle.putInt("projectCategorySpnSelectedPosition", i6);
    ArrayList localArrayList1 = (ArrayList)this.aA;
    paramBundle.putParcelableArrayList("firstLevelCategoryList", localArrayList1);
    ArrayList localArrayList2 = (ArrayList)this.aD;
    paramBundle.putParcelableArrayList("subcategoryList", localArrayList2);
    ArrayList localArrayList3 = (ArrayList)this.aF;
    paramBundle.putParcelableArrayList("accountList", localArrayList3);
    ArrayList localArrayList4 = (ArrayList)this.aI;
    paramBundle.putParcelableArrayList("corporationList", localArrayList4);
    ArrayList localArrayList5 = (ArrayList)this.aE;
    paramBundle.putParcelableArrayList("projectCategoryList", localArrayList5);
    CategoryVo localCategoryVo1 = this.aJ;
    paramBundle.putParcelable("defaultPayoutCategory", localCategoryVo1);
    CategoryVo localCategoryVo2 = this.aK;
    paramBundle.putParcelable("defaultIncomeCategory", localCategoryVo2);
    CategoryVo localCategoryVo3 = this.aM;
    paramBundle.putParcelable("defaultCategory", localCategoryVo3);
    long l2 = this.ar;
    paramBundle.putLong("tradeTime", l2);
    String str2 = this.as;
    paramBundle.putString("memo", str2);
    TransactionVo localTransactionVo = this.ag;
    paramBundle.putParcelable("transactionVo", localTransactionVo);
    String str3 = n;
    StringBuilder localStringBuilder1 = new StringBuilder().append("onSaveInstanceState,firstLevelCategoryList size is ");
    int i7 = this.aA.size();
    String str4 = i7;
    gj.a(str3, str4);
    String str5 = n;
    StringBuilder localStringBuilder2 = new StringBuilder().append("onSaveInstanceState,mSubcategoryList size is ");
    int i8 = this.aD.size();
    String str6 = i8;
    gj.a(str5, str6);
    String str7 = n;
    StringBuilder localStringBuilder3 = new StringBuilder().append("onSaveInstanceState,mCorporationList size is ");
    int i9 = this.aI.size();
    String str8 = i9;
    gj.a(str7, str8);
    String str9 = n;
    StringBuilder localStringBuilder4 = new StringBuilder().append("onSaveInstanceState,mCorporationSelectedPosition is ");
    int i10 = this.ay;
    String str10 = i10;
    gj.a(str9, str10);
  }

  protected void onStart()
  {
    gj.a(n, "onStart()");
    super.onStart();
  }

  protected void onStop()
  {
    gj.a(n, "onStop()");
    super.onStop();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.addtrans.AddOrEditTransactionActivity
 * JD-Core Version:    0.6.0
 */