package com.mymoney.ui.addtrans;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
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
import android.os.Handler;
import android.os.IBinder;
import android.os.ResultReceiver;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mymoney.core.vo.AccountGroupVo;
import com.mymoney.core.vo.AccountVo;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.core.vo.CorporationVo;
import com.mymoney.core.vo.ProjectVo;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.helper.PickPhotoHelper;
import com.mymoney.ui.transfer.TransferActivity;
import com.mymoney.ui.widget.CurrencyRateOperationInputPanel;
import com.mymoney.ui.widget.Panel;
import com.mymoney.ui.widget.wheelview.WheelDatePicker;
import com.mymoney.ui.widget.wheelview.WheelView;
import e;
import eo;
import g;
import gi;
import gj;
import gp;
import gs;
import gu;
import gz;
import h;
import hb;
import hs;
import ht;
import hu;
import hv;
import hw;
import hx;
import hy;
import hz;
import i;
import ia;
import ib;
import ic;
import id;
import ie;
import if;
import ig;
import ih;
import ii;
import ij;
import ik;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import js;
import ju;
import jw;
import jy;
import k;
import m;
import um;
import un;
import y;

public class AddOrEditTransNewActivity extends BaseActivity
  implements View.OnClickListener, RadioGroup.OnCheckedChangeListener
{
  public static int a = 0;
  public static int b = 59;
  public static int c = 59;
  public static int d = 1;
  public static int e = 2;
  public static int f = 3;
  public static int g = 4;
  public static int h = 5;
  private Button A;
  private Button B;
  private LinearLayout C;
  private TextView D;
  private TextView E;
  private LinearLayout F;
  private TextView G;
  private TextView H;
  private LinearLayout I;
  private TextView J;
  private TextView K;
  private LinearLayout L;
  private TextView M;
  private TextView N;
  private LinearLayout O;
  private Button P;
  private Button Q;
  private EditText R;
  private Button S;
  private Button T;
  private LinearLayout U;
  private RelativeLayout V;
  private ImageView W;
  private Button X;
  private Button Y;
  private LinearLayout Z;
  private List aA;
  private List aB;
  private List aC;
  private List aD;
  private List aE;
  private List aF;
  private List aG;
  private List aH;
  private CategoryVo aI;
  private CategoryVo aJ;
  private ProjectVo aK;
  private CategoryVo aL;
  private AccountVo aM;
  private CorporationVo aN;
  private long aO;
  private TransactionVo aP;
  private long aQ;
  private Bitmap aR;
  private LayerDrawable aS;
  private double aT;
  private CategoryVo aU;
  private ProjectVo aV;
  private AccountVo aW;
  private CorporationVo aX;
  private long aY;
  private String aZ;
  private Panel aa;
  private RadioGroup ab;
  private RadioButton ac;
  private RadioButton ad;
  private LinearLayout ae;
  private CurrencyRateOperationInputPanel af;
  private LinearLayout ag;
  private LinearLayout ah;
  private LinearLayout ai;
  private LinearLayout aj;
  private WheelView ak;
  private WheelView al;
  private WheelView am;
  private WheelDatePicker an;
  private WheelView ao;
  private WheelView ap;
  private LinearLayout.LayoutParams aq;
  private LinearLayout.LayoutParams ar;
  private int as;
  private ju at;
  private ju au;
  private js av;
  private jy aw;
  private jw ax;
  private Map ay;
  private boolean az;
  private boolean ba;
  private boolean bb;
  private boolean bc;
  private int bd;
  private int be;
  private int bf;
  private int bg;
  private int bh;
  private Animation bi;
  private Animation bj;
  private LayoutInflater bk;
  private InputMethodManager bl;
  private h bm;
  private e bn;
  private i bo;
  private m bp;
  private k bq;
  private ResultReceiver br;
  public Map i;
  public Map j;
  public boolean k;
  private int l = 0;
  private String n;
  private boolean o;
  private int p = -1;
  private String[] q;
  private final int r;
  private final int s;
  private Context t;
  private Resources u;
  private Handler v;
  private boolean w;
  private Button x;
  private Button y;
  private Button z;

  public AddOrEditTransNewActivity()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "相机";
    arrayOfString[1] = "相册";
    this.q = arrayOfString;
    this.r = 0;
    this.s = 1;
    Handler localHandler = new Handler();
    this.v = localHandler;
    this.w = 1;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.aq = localLayoutParams;
    HashMap localHashMap1 = new HashMap();
    this.i = localHashMap1;
    HashMap localHashMap2 = new HashMap();
    this.j = localHashMap2;
    HashMap localHashMap3 = new HashMap(10);
    this.ay = localHashMap3;
    this.az = 0;
    TransactionVo localTransactionVo = new TransactionVo();
    this.aP = localTransactionVo;
    this.ba = 1;
    this.bb = 0;
    this.bc = 0;
    h localh = g.a().d();
    this.bm = localh;
    e locale = g.a().c();
    this.bn = locale;
    i locali = g.a().e();
    this.bo = locali;
    m localm = g.a().b();
    this.bp = localm;
    k localk = g.a().h();
    this.bq = localk;
    this.k = 1;
  }

  private void A()
  {
    this.an.setVisibility(0);
    this.I.setBackgroundResource(2130837519);
    TextView localTextView1 = this.J;
    d(localTextView1);
    TextView localTextView2 = this.K;
    b(localTextView2);
    I();
    r();
  }

  private void B()
  {
    s();
    this.ai.setVisibility(8);
    this.P.setBackgroundResource(2130837514);
    Button localButton = this.P;
    a(localButton);
  }

  private void C()
  {
    this.ai.setVisibility(0);
    this.P.setBackgroundResource(2130837515);
    Button localButton = this.P;
    b(localButton);
    I();
    r();
  }

  private void D()
  {
    s();
    this.ai.setVisibility(8);
    this.L.setBackgroundResource(2130837520);
    TextView localTextView1 = this.M;
    c(localTextView1);
    TextView localTextView2 = this.N;
    a(localTextView2);
  }

  private void E()
  {
    this.ai.setVisibility(0);
    this.L.setBackgroundResource(2130837519);
    TextView localTextView1 = this.M;
    d(localTextView1);
    TextView localTextView2 = this.N;
    b(localTextView2);
    I();
    r();
  }

  private void F()
  {
    s();
    this.aj.setVisibility(8);
    this.Q.setBackgroundResource(2130837517);
    Button localButton = this.Q;
    a(localButton);
  }

  private void G()
  {
    this.aj.setVisibility(0);
    this.Q.setBackgroundResource(2130837518);
    Button localButton = this.Q;
    b(localButton);
    I();
    r();
  }

  private void H()
  {
    this.Y.setBackgroundResource(2130837534);
  }

  private void I()
  {
    this.Y.setBackgroundResource(2130837537);
  }

  private View J()
  {
    Map localMap1 = this.ay;
    Integer localInteger1 = Integer.valueOf(1);
    LinearLayout localLinearLayout1 = (LinearLayout)localMap1.get(localInteger1);
    this.ae = localLinearLayout1;
    if (this.ae == null)
    {
      LinearLayout localLinearLayout2 = (LinearLayout)this.bk.inflate(2130903045, null);
      this.ae = localLinearLayout2;
      CurrencyRateOperationInputPanel localCurrencyRateOperationInputPanel1 = (CurrencyRateOperationInputPanel)this.ae.findViewById(2131230788);
      this.af = localCurrencyRateOperationInputPanel1;
      CurrencyRateOperationInputPanel localCurrencyRateOperationInputPanel2 = this.af;
      ik localik = new ik(this, null);
      localCurrencyRateOperationInputPanel2.a(localik);
      CurrencyRateOperationInputPanel localCurrencyRateOperationInputPanel3 = this.af;
      Button localButton = this.B;
      localCurrencyRateOperationInputPanel3.a(localButton);
      CurrencyRateOperationInputPanel localCurrencyRateOperationInputPanel4 = this.af;
      ic localic = new ic(this);
      localCurrencyRateOperationInputPanel4.a(localic);
      if (V())
      {
        this.af.a();
        this.af.b(1);
      }
      Map localMap2 = this.ay;
      Integer localInteger2 = Integer.valueOf(1);
      LinearLayout localLinearLayout3 = this.ae;
      Object localObject = localMap2.put(localInteger2, localLinearLayout3);
      LinearLayout localLinearLayout4 = this.Z;
      LinearLayout localLinearLayout5 = this.ae;
      LinearLayout.LayoutParams localLayoutParams = this.aq;
      localLinearLayout4.addView(localLinearLayout5, localLayoutParams);
    }
    return this.ae;
  }

  private View K()
  {
    Map localMap1 = this.ay;
    Integer localInteger1 = Integer.valueOf(2);
    LinearLayout localLinearLayout1 = (LinearLayout)localMap1.get(localInteger1);
    this.ag = localLinearLayout1;
    if (this.ag == null)
    {
      LinearLayout localLinearLayout2 = (LinearLayout)this.bk.inflate(2130903047, null);
      this.ag = localLinearLayout2;
      this.ag.setId(2);
      WheelView localWheelView1 = (WheelView)this.ag.findViewById(2131230790);
      this.ak = localWheelView1;
      WheelView localWheelView2 = (WheelView)this.ag.findViewById(2131230791);
      this.al = localWheelView2;
      WheelView localWheelView3 = this.ak;
      id localid = new id(this);
      localWheelView3.a(localid);
      WheelView localWheelView4 = this.al;
      ie localie = new ie(this);
      localWheelView4.a(localie);
      WheelView localWheelView5 = this.ak;
      a(localWheelView5);
      WheelView localWheelView6 = this.al;
      a(localWheelView6);
      WheelView localWheelView7 = this.ak;
      ju localju1 = this.at;
      localWheelView7.a(localju1);
      ju localju2 = this.at;
      List localList1 = this.aA;
      localju2.a(localList1);
      WheelView localWheelView8 = this.al;
      ju localju3 = this.au;
      localWheelView8.a(localju3);
      List localList2 = this.aA;
      CategoryVo localCategoryVo = this.aU.e();
      int m = localList2.indexOf(localCategoryVo);
      this.bd = m;
      WheelView localWheelView9 = this.ak;
      int i1 = this.bd;
      localWheelView9.b(i1, 0);
      Map localMap2 = this.ay;
      Integer localInteger2 = Integer.valueOf(2);
      LinearLayout localLinearLayout3 = this.ag;
      Object localObject = localMap2.put(localInteger2, localLinearLayout3);
      this.ag.setVisibility(8);
      LinearLayout localLinearLayout4 = this.Z;
      LinearLayout localLinearLayout5 = this.ag;
      LinearLayout.LayoutParams localLayoutParams = this.ar;
      localLinearLayout4.addView(localLinearLayout5, localLayoutParams);
    }
    return this.ag;
  }

  private void L()
  {
    List localList1 = this.bm.c();
    this.aB = localList1;
    List localList2 = this.bm.d();
    this.aC = localList2;
    if (this.aB.isEmpty())
    {
      CategoryVo localCategoryVo1 = new CategoryVo("空分类");
      CategoryVo localCategoryVo2 = new CategoryVo("空分类");
      localCategoryVo1.e(localCategoryVo2);
      boolean bool1 = this.aB.add(localCategoryVo1);
    }
    if (this.aC.isEmpty())
    {
      CategoryVo localCategoryVo3 = new CategoryVo("空分类");
      CategoryVo localCategoryVo4 = new CategoryVo("空分类");
      localCategoryVo3.e(localCategoryVo4);
      boolean bool2 = this.aC.add(localCategoryVo3);
    }
    if (Q())
    {
      List localList3 = this.aB;
      this.aA = localList3;
      return;
    }
    if (!R())
      return;
    List localList4 = this.aC;
    this.aA = localList4;
  }

  private void M()
  {
    List localList1 = this.bo.a();
    this.aH = localList1;
    List localList2 = this.aH;
    int m = a;
    CorporationVo localCorporationVo = new CorporationVo("无商家");
    localList2.add(m, localCorporationVo);
  }

  private void N()
  {
    List localList1 = this.bn.d();
    this.aG = localList1;
    List localList2 = this.bn.c();
    this.aF = localList2;
    if (this.aG.isEmpty())
    {
      List localList3 = this.aG;
      AccountVo localAccountVo1 = new AccountVo("空账户");
      boolean bool1 = localList3.add(localAccountVo1);
    }
    if (this.aF.isEmpty())
    {
      List localList4 = this.aF;
      AccountVo localAccountVo2 = new AccountVo("空账户");
      boolean bool2 = localList4.add(localAccountVo2);
    }
    if (Q())
    {
      List localList5 = this.aG;
      this.aE = localList5;
      return;
    }
    if (!R())
      return;
    List localList6 = this.aF;
    this.aE = localList6;
  }

  private void O()
  {
    List localList1 = y.a().a(1);
    this.aD = localList1;
    ProjectVo localProjectVo = new ProjectVo("无项目");
    List localList2 = this.aD;
    int m = a;
    localList2.add(m, localProjectVo);
  }

  private void P()
  {
    Context localContext = this.t;
    a(localContext, TransferActivity.class);
    finish();
  }

  private boolean Q()
  {
    if (this.p == 0);
    for (int m = 1; ; m = 0)
      return m;
  }

  private boolean R()
  {
    if (this.p == 1);
    for (int m = 1; ; m = 0)
      return m;
  }

  private void S()
  {
    this.p = 0;
  }

  private void T()
  {
    this.p = 1;
  }

  private boolean U()
  {
    if (this.l == 1);
    for (int m = 1; ; m = 0)
      return m;
  }

  private boolean V()
  {
    if (this.l == 2);
    for (int m = 1; ; m = 0)
      return m;
  }

  private void W()
  {
    this.l = 1;
  }

  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      S();
      List localList1 = this.aB;
      this.aA = localList1;
      CategoryVo localCategoryVo1 = this.aI;
      this.aL = localCategoryVo1;
      List localList2 = this.aG;
      this.aE = localList2;
      this.O.setVisibility(0);
      this.L.setVisibility(8);
      Button localButton1 = this.B;
      int m = this.u.getColor(2131296288);
      localButton1.setTextColor(m);
      this.B.setBackgroundResource(2130837508);
      this.y.setText("新增支出");
      this.ac.setChecked(1);
      CategoryVo localCategoryVo2 = this.aU;
      CategoryVo localCategoryVo3 = this.aL.e();
      localCategoryVo2.e(localCategoryVo3);
      if (!this.ba)
      {
        TextView localTextView1 = this.E;
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str1 = this.aU.e().b();
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(">");
        String str2 = this.aU.e().e().b();
        String str3 = str2;
        localTextView1.setText(str3);
        if (this.am != null)
          this.am.b(1);
        js localjs = this.av;
        List localList3 = this.aE;
        localjs.a(localList3);
        List localList4 = this.aE;
        AccountVo localAccountVo1 = this.aM;
        int i1 = localList4.indexOf(localAccountVo1);
        this.bf = i1;
        if (this.bf == -1)
          this.bf = 0;
        if (!this.aE.isEmpty())
          break label492;
        this.H.setText("空账户");
      }
    }
    while (true)
    {
      if (this.am != null)
      {
        WheelView localWheelView = this.am;
        int i2 = this.bf;
        localWheelView.c(i2);
      }
      View localView = K();
      o();
      if (this.as != 2131230735)
        boolean bool = this.Y.performClick();
      this.ba = 0;
      return;
      T();
      List localList5 = this.aC;
      this.aA = localList5;
      CategoryVo localCategoryVo4 = this.aJ;
      this.aL = localCategoryVo4;
      List localList6 = this.aF;
      this.aE = localList6;
      this.O.setVisibility(8);
      this.L.setVisibility(0);
      Button localButton2 = this.B;
      int i3 = this.u.getColor(2131296287);
      localButton2.setTextColor(i3);
      this.B.setBackgroundResource(2130837505);
      this.y.setText("新增收入");
      this.ad.setChecked(1);
      break;
      label492: List localList7 = this.aE;
      int i4 = this.bf;
      AccountVo localAccountVo2 = (AccountVo)localList7.get(i4);
      TextView localTextView2 = this.H;
      String str4 = localAccountVo2.b();
      localTextView2.setText(str4);
    }
  }

  private void a(Button paramButton)
  {
    int m = this.u.getColor(2131296257);
    paramButton.setTextColor(m);
    CharSequence localCharSequence = paramButton.getText();
    paramButton.setText(localCharSequence);
  }

  private void a(TextView paramTextView)
  {
    int m = this.u.getColor(2131296257);
    paramTextView.setTextColor(m);
    CharSequence localCharSequence = paramTextView.getText();
    paramTextView.setText(localCharSequence);
  }

  private void a(WheelView paramWheelView)
  {
    paramWheelView.a(5);
  }

  private void a(boolean paramBoolean)
  {
    ih localih = new ih(this);
    Boolean[] arrayOfBoolean = new Boolean[1];
    Boolean localBoolean = Boolean.valueOf(paramBoolean);
    arrayOfBoolean[0] = localBoolean;
    AsyncTask localAsyncTask = localih.execute(arrayOfBoolean);
  }

  private void a(Object[] paramArrayOfObject)
  {
    AsyncTask localAsyncTask = new ig(this).execute(paramArrayOfObject);
  }

  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    if (V())
    {
      e locale = this.bn;
      long l1 = this.aO;
      int m = locale.d(l1).c().c().d();
      if (1 == m)
      {
        hb.b(this.t, "抱歉,负债账户相关的交易不可编辑.");
        if (paramBoolean1)
          finish();
        i1 = 0;
      }
    }
    while (true)
    {
      return i1;
      String str1 = this.R.getText().toString();
      this.aZ = str1;
      double d1 = gs.a(this.B.getText().toString()).doubleValue();
      this.aT = d1;
      if (this.aT < 0.0D)
      {
        hb.b(this.t, "金额不能为负数");
        i1 = 0;
        continue;
      }
      if ((this.aU.e() == null) || (this.aW == null) || ((Q()) && (this.aX == null)))
      {
        hb.b(this.t, "对不起,请填写数据完整");
        i1 = 0;
        continue;
      }
      if (CategoryVo.d(this.aU).a() == 0L)
      {
        hb.b(this.t, "空分类不能入账,请到设置里添加分类信息.");
        i1 = 0;
        continue;
      }
      if (this.aW.a() == 0L)
      {
        hb.b(this.t, "空账户不能入账,请到设置里添加账户信息.");
        i1 = 0;
        continue;
      }
      if ((this.aR != null) && (this.bb))
      {
        String str2 = eo.a();
        String str3 = this.aP.d();
        this.aP.b(str2);
        this.aP.a(1);
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = str2;
        arrayOfObject[1] = str3;
        Bitmap localBitmap = Bitmap.createBitmap(this.aR);
        arrayOfObject[2] = localBitmap;
        a(arrayOfObject);
      }
      TransactionVo localTransactionVo1 = this.aP;
      int i2 = this.p;
      localTransactionVo1.a(i2);
      TransactionVo localTransactionVo2 = this.aP;
      double d2 = this.aT;
      localTransactionVo2.a(d2);
      TransactionVo localTransactionVo3 = this.aP;
      CategoryVo localCategoryVo = this.aU;
      localTransactionVo3.a(localCategoryVo);
      TransactionVo localTransactionVo4 = this.aP;
      AccountVo localAccountVo = this.aW;
      localTransactionVo4.a(localAccountVo);
      TransactionVo localTransactionVo5 = this.aP;
      long l2 = this.aY;
      localTransactionVo5.b(l2);
      TransactionVo localTransactionVo6 = this.aP;
      CorporationVo localCorporationVo = this.aX;
      localTransactionVo6.a(localCorporationVo);
      TransactionVo localTransactionVo7 = this.aP;
      ProjectVo localProjectVo = this.aV;
      localTransactionVo7.a(localProjectVo);
      TransactionVo localTransactionVo8 = this.aP;
      String str4 = this.aZ;
      localTransactionVo8.a(str4);
      this.k = paramBoolean1;
      a(paramBoolean2);
      i1 = 1;
    }
  }

  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 2131230735:
      View localView1 = J();
      u();
      return;
    case 2131230761:
      if (this.aA == null)
        return;
      if (this.aA.size() == 0)
      {
        hb.b(this.t, "请先到设置里添加分类数据后再记账");
        return;
      }
      View localView2 = K();
      w();
      return;
    case 2131230764:
      if (this.aE == null)
        return;
      View localView3 = a();
      y();
      return;
    case 2131230767:
      View localView4 = b();
      A();
      return;
    case 2131230770:
      if (this.aD == null)
        return;
      View localView5 = c();
      E();
      return;
    case 2131230774:
      if (this.aD == null)
        return;
      View localView6 = c();
      C();
      return;
    case 2131230775:
    }
    if (this.aH == null)
      return;
    View localView7 = d();
    G();
  }

  private void b(Button paramButton)
  {
    int m = this.u.getColor(2131296284);
    paramButton.setTextColor(m);
    CharSequence localCharSequence = paramButton.getText();
    paramButton.setText(localCharSequence);
  }

  private void b(TextView paramTextView)
  {
    int m = this.u.getColor(2131296284);
    paramTextView.setTextColor(m);
    CharSequence localCharSequence = paramTextView.getText();
    paramTextView.setText(localCharSequence);
  }

  private void c(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 2131230735:
      View localView1 = J();
      t();
      return;
    case 2131230761:
      if (this.aA == null)
        return;
      View localView2 = K();
      v();
      return;
    case 2131230764:
      if (this.aE == null)
        return;
      View localView3 = a();
      x();
      return;
    case 2131230767:
      View localView4 = b();
      z();
      return;
    case 2131230770:
      if (this.aD == null)
        return;
      View localView5 = c();
      D();
      return;
    case 2131230774:
      if (this.aD == null)
        return;
      View localView6 = c();
      B();
      return;
    case 2131230775:
    }
    if (this.aH == null)
      return;
    View localView7 = d();
    F();
  }

  private void c(TextView paramTextView)
  {
    int m = this.u.getColor(2131296285);
    paramTextView.setTextColor(m);
    CharSequence localCharSequence = paramTextView.getText();
    paramTextView.setText(localCharSequence);
  }

  private void d(TextView paramTextView)
  {
    int m = this.u.getColor(2131296284);
    paramTextView.setTextColor(m);
    CharSequence localCharSequence = paramTextView.getText();
    paramTextView.setText(localCharSequence);
  }

  private void e()
  {
    int m = gu.z();
    if (m >= 3)
      return;
    boolean bool1 = this.aa.a(1, 1);
    Handler localHandler = this.v;
    hy localhy = new hy(this);
    boolean bool2 = localHandler.postDelayed(localhy, 2000L);
    gu.e(m + 1);
  }

  private void f()
  {
    int m = this.as;
    c(m);
    j();
    if (V())
    {
      W();
      if (!Q())
        break label51;
      this.y.setText("新增支出");
    }
    while (true)
    {
      boolean bool = this.B.performClick();
      return;
      label51: this.y.setText("新增收入");
    }
  }

  private void g()
  {
    double d1 = gs.a(String.valueOf(this.aP.b())).doubleValue();
    this.aT = d1;
    CategoryVo localCategoryVo = this.aP.f();
    this.aU = localCategoryVo;
    AccountVo localAccountVo = this.aP.g();
    this.aW = localAccountVo;
    long l1 = this.aP.j();
    this.aY = l1;
    ProjectVo localProjectVo = this.aP.i();
    this.aV = localProjectVo;
    CorporationVo localCorporationVo = this.aP.h();
    this.aX = localCorporationVo;
    String str = this.aP.c();
    this.aZ = str;
  }

  private void h()
  {
    this.aR = null;
    this.bb = 0;
    CategoryVo localCategoryVo1;
    if (Q())
      localCategoryVo1 = this.bm.e();
    CategoryVo localCategoryVo8;
    for (this.aU = localCategoryVo1; ; this.aU = localCategoryVo8)
    {
      if (this.aU.e() == null)
      {
        CategoryVo localCategoryVo2 = this.aU;
        CategoryVo localCategoryVo3 = new CategoryVo("空分类");
        localCategoryVo2.e(localCategoryVo3);
        CategoryVo localCategoryVo4 = this.aU.e();
        CategoryVo localCategoryVo5 = new CategoryVo("空分类");
        localCategoryVo4.e(localCategoryVo5);
      }
      CategoryVo localCategoryVo6 = this.aU;
      CategoryVo localCategoryVo7 = this.aL.e();
      localCategoryVo6.e(localCategoryVo7);
      AccountVo localAccountVo = this.aM;
      this.aW = localAccountVo;
      long l1 = gi.k();
      this.aY = l1;
      ProjectVo localProjectVo = this.aK;
      this.aV = localProjectVo;
      CorporationVo localCorporationVo = this.aN;
      this.aX = localCorporationVo;
      return;
      localCategoryVo8 = this.bm.f();
    }
  }

  private void i()
  {
    m();
    Button localButton1 = this.B;
    String str1 = gs.a(this.aT);
    localButton1.setText(str1);
    if (this.aU.e() == null)
    {
      this.E.setText("空分类>空分类");
      TextView localTextView1 = this.H;
      String str2 = this.aW.i();
      localTextView1.setText(str2);
      TextView localTextView2 = this.K;
      String str3 = gi.f(this.aY);
      localTextView2.setText(str3);
      if (this.aV.a() == 0L)
        break label295;
      Button localButton2 = this.P;
      String str4 = this.aV.b();
      localButton2.setText(str4);
      TextView localTextView3 = this.N;
      String str5 = this.aV.b();
      localTextView3.setText(str5);
      label142: if (this.aX.a() == 0L)
        break label318;
      Button localButton3 = this.Q;
      String str6 = this.aX.b();
      localButton3.setText(str6);
    }
    while (true)
    {
      EditText localEditText = this.R;
      String str7 = this.aZ;
      localEditText.setText(str7);
      if (!Q())
        break label331;
      this.L.setVisibility(8);
      this.O.setVisibility(0);
      return;
      TextView localTextView4 = this.E;
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str8 = this.aU.e().b();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str8).append(">");
      String str9 = CategoryVo.b(this.aU);
      String str10 = str9;
      localTextView4.setText(str10);
      break;
      label295: this.P.setText("无项目");
      this.N.setText("无项目");
      break label142;
      label318: this.Q.setText("无商家");
    }
    label331: this.L.setVisibility(0);
    this.O.setVisibility(8);
  }

  private void j()
  {
    this.aR = null;
    this.bb = 0;
    this.aT = 0.0D;
    this.aZ = "";
    m();
    Button localButton = this.B;
    String str1 = gs.a(this.aT);
    localButton.setText(str1);
    EditText localEditText = this.R;
    String str2 = this.aZ;
    localEditText.setText(str2);
    if (Q())
    {
      this.L.setVisibility(8);
      this.O.setVisibility(0);
    }
    while (true)
    {
      TransactionVo localTransactionVo = new TransactionVo();
      this.aP = localTransactionVo;
      return;
      this.L.setVisibility(0);
      this.O.setVisibility(8);
    }
  }

  private void k()
  {
    if localif = new if(this);
    Void[] arrayOfVoid = new Void[0];
    AsyncTask localAsyncTask = localif.execute(arrayOfVoid);
  }

  private void l()
  {
    if (R())
    {
      this.af.a(1);
      this.ad.setChecked(1);
      return;
    }
    this.af.a(0);
    this.ac.setChecked(1);
  }

  private void m()
  {
    if (this.aR != null)
    {
      if (this.aS != null)
        this.aS.setCallback(null);
      LayerDrawable localLayerDrawable1 = (LayerDrawable)this.u.getDrawable(2130837702);
      this.aS = localLayerDrawable1;
      LayerDrawable localLayerDrawable2 = this.aS;
      Drawable localDrawable = gp.a(this.aR);
      boolean bool = localLayerDrawable2.setDrawableByLayerId(2131231173, localDrawable);
      Button localButton = this.A;
      LayerDrawable localLayerDrawable3 = this.aS;
      localButton.setBackgroundDrawable(localLayerDrawable3);
      return;
    }
    this.A.setBackgroundResource(2130837695);
  }

  private void n()
  {
    if (Environment.getExternalStorageState().equals("removed"))
    {
      hb.b(this.t, "对不起,未加载sd卡,你不能编辑照片");
      return;
    }
    if ((V()) && (this.aR != null) && (!TextUtils.isEmpty(this.aP.d())))
    {
      Context localContext = this.t;
      Intent localIntent1 = new Intent(localContext, TransactionPhotoEditActivity.class);
      String str = TransactionPhotoEditActivity.f;
      long l1 = this.aP.a();
      Intent localIntent2 = localIntent1.putExtra(str, l1);
      int m = f;
      startActivityForResult(localIntent1, m);
      return;
    }
    showDialog(1);
  }

  private void o()
  {
    this.ak.b(1);
    this.al.b(1);
    ju localju = this.at;
    List localList1 = this.aA;
    localju.a(localList1);
    CategoryVo localCategoryVo1 = this.aU.e();
    int m = this.aA.indexOf(localCategoryVo1);
    this.bd = m;
    if (this.bd == -1)
      this.bd = 0;
    List localList2 = this.aA;
    int i1 = this.bd;
    CategoryVo localCategoryVo2 = (CategoryVo)localList2.get(i1);
    WheelView localWheelView1 = this.ak;
    int i2 = this.bd;
    localWheelView1.a(i2, 0);
    List localList3 = localCategoryVo2.g();
    this.au.a(localList3);
    if (localCategoryVo1 == null);
    int i4;
    for (this.be = 0; ; this.be = i4)
    {
      WheelView localWheelView2 = this.al;
      int i3 = this.be;
      localWheelView2.a(i3, 0);
      return;
      CategoryVo localCategoryVo3 = localCategoryVo1.e();
      i4 = localList3.indexOf(localCategoryVo3);
    }
  }

  private void p()
  {
    try
    {
      Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      int m = d;
      startActivityForResult(localIntent, m);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void q()
  {
    Intent localIntent1 = PickPhotoHelper.a();
    try
    {
      Intent localIntent2 = Intent.createChooser(localIntent1, "选择照片");
      int m = e;
      startActivityForResult(localIntent2, m);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      localActivityNotFoundException.printStackTrace();
      hb.b(this.t, "未找到图片浏览器");
      return;
    }
    catch (Exception localException)
    {
      hb.b(this.t, "未知错误");
    }
  }

  private void r()
  {
    this.V.setVisibility(0);
    this.W.setVisibility(0);
    this.U.setVisibility(0);
    LinearLayout localLinearLayout1 = this.U;
    Animation localAnimation1 = this.bi;
    localLinearLayout1.setAnimation(localAnimation1);
    LinearLayout localLinearLayout2 = this.U;
    Animation localAnimation2 = this.bi;
    localLinearLayout2.startAnimation(localAnimation2);
    this.az = 1;
  }

  private void s()
  {
    this.V.setVisibility(8);
    this.W.setVisibility(8);
    this.U.setVisibility(8);
    LinearLayout localLinearLayout1 = this.U;
    Animation localAnimation1 = this.bj;
    localLinearLayout1.setAnimation(localAnimation1);
    LinearLayout localLinearLayout2 = this.U;
    Animation localAnimation2 = this.bj;
    localLinearLayout2.startAnimation(localAnimation2);
    this.az = 0;
  }

  private void t()
  {
    s();
    this.ae.setVisibility(8);
  }

  private void u()
  {
    this.ae.setVisibility(0);
    H();
    r();
  }

  private void v()
  {
    s();
    this.ag.setVisibility(8);
    this.C.setBackgroundResource(2130837516);
    TextView localTextView1 = this.D;
    c(localTextView1);
    TextView localTextView2 = this.E;
    a(localTextView2);
  }

  private void w()
  {
    this.ag.setVisibility(0);
    this.C.setBackgroundResource(2130837519);
    TextView localTextView1 = this.D;
    d(localTextView1);
    TextView localTextView2 = this.E;
    b(localTextView2);
    I();
    r();
  }

  private void x()
  {
    s();
    this.ah.setVisibility(8);
    this.F.setBackgroundResource(2130837516);
    TextView localTextView1 = this.G;
    c(localTextView1);
    TextView localTextView2 = this.H;
    a(localTextView2);
  }

  private void y()
  {
    this.ah.setVisibility(0);
    this.F.setBackgroundResource(2130837519);
    TextView localTextView1 = this.G;
    d(localTextView1);
    TextView localTextView2 = this.H;
    b(localTextView2);
    I();
    r();
  }

  private void z()
  {
    s();
    this.an.setVisibility(8);
    this.I.setBackgroundResource(2130837516);
    TextView localTextView1 = this.J;
    c(localTextView1);
    TextView localTextView2 = this.K;
    a(localTextView2);
  }

  public View a()
  {
    Map localMap1 = this.ay;
    Integer localInteger1 = Integer.valueOf(3);
    LinearLayout localLinearLayout1 = (LinearLayout)localMap1.get(localInteger1);
    this.ah = localLinearLayout1;
    if (this.ah == null)
    {
      LinearLayout localLinearLayout2 = (LinearLayout)this.bk.inflate(2130903046, null);
      this.ah = localLinearLayout2;
      WheelView localWheelView1 = (WheelView)this.ah.findViewById(2131230789);
      this.am = localWheelView1;
      WheelView localWheelView2 = this.am;
      ht localht = new ht(this);
      localWheelView2.a(localht);
      WheelView localWheelView3 = this.am;
      a(localWheelView3);
      js localjs1 = this.av;
      List localList1 = this.aE;
      localjs1.a(localList1);
      WheelView localWheelView4 = this.am;
      js localjs2 = this.av;
      localWheelView4.a(localjs2);
      List localList2 = this.aE;
      AccountVo localAccountVo = this.aW;
      int m = localList2.indexOf(localAccountVo);
      this.bf = m;
      WheelView localWheelView5 = this.am;
      int i1 = this.bf;
      localWheelView5.c(i1);
      Map localMap2 = this.ay;
      Integer localInteger2 = Integer.valueOf(3);
      LinearLayout localLinearLayout3 = this.ah;
      Object localObject = localMap2.put(localInteger2, localLinearLayout3);
      LinearLayout localLinearLayout4 = this.Z;
      LinearLayout localLinearLayout5 = this.ah;
      LinearLayout.LayoutParams localLayoutParams = this.ar;
      localLinearLayout4.addView(localLinearLayout5, localLayoutParams);
    }
    return this.ah;
  }

  public String a(Uri paramUri)
  {
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = "_data";
    AddOrEditTransNewActivity localAddOrEditTransNewActivity = this;
    Uri localUri = paramUri;
    String[] arrayOfString2 = null;
    String str = null;
    Cursor localCursor = localAddOrEditTransNewActivity.managedQuery(localUri, arrayOfString1, null, arrayOfString2, str);
    int m = localCursor.getColumnIndexOrThrow("_data");
    boolean bool = localCursor.moveToFirst();
    return localCursor.getString(m);
  }

  public View b()
  {
    Map localMap1 = this.ay;
    Integer localInteger1 = Integer.valueOf(4);
    WheelDatePicker localWheelDatePicker1 = (WheelDatePicker)localMap1.get(localInteger1);
    this.an = localWheelDatePicker1;
    if (this.an == null)
    {
      Context localContext = this.t;
      WheelDatePicker localWheelDatePicker2 = new WheelDatePicker(localContext);
      this.an = localWheelDatePicker2;
      this.an.setId(4);
      hu localhu = new hu(this);
      Calendar localCalendar = Calendar.getInstance();
      long l1 = this.aY;
      localCalendar.setTimeInMillis(l1);
      int m = localCalendar.get(1);
      int i1 = localCalendar.get(2);
      int i2 = localCalendar.get(5);
      this.an.a(m, i1, i2, localhu);
      Map localMap2 = this.ay;
      Integer localInteger2 = Integer.valueOf(4);
      WheelDatePicker localWheelDatePicker3 = this.an;
      Object localObject = localMap2.put(localInteger2, localWheelDatePicker3);
      LinearLayout localLinearLayout = this.Z;
      WheelDatePicker localWheelDatePicker4 = this.an;
      LinearLayout.LayoutParams localLayoutParams = this.ar;
      localLinearLayout.addView(localWheelDatePicker4, localLayoutParams);
    }
    return this.an;
  }

  public View c()
  {
    Map localMap1 = this.ay;
    Integer localInteger1 = Integer.valueOf(5);
    LinearLayout localLinearLayout1 = (LinearLayout)localMap1.get(localInteger1);
    this.ai = localLinearLayout1;
    if (this.ai == null)
    {
      LinearLayout localLinearLayout2 = (LinearLayout)this.bk.inflate(2130903050, null);
      this.ai = localLinearLayout2;
      WheelView localWheelView1 = (WheelView)this.ai.findViewById(2131230795);
      this.ao = localWheelView1;
      WheelView localWheelView2 = this.ao;
      hv localhv = new hv(this);
      localWheelView2.a(localhv);
      WheelView localWheelView3 = this.ao;
      a(localWheelView3);
      jy localjy1 = this.aw;
      List localList1 = this.aD;
      localjy1.a(localList1);
      WheelView localWheelView4 = this.ao;
      jy localjy2 = this.aw;
      localWheelView4.a(localjy2);
      List localList2 = this.aD;
      ProjectVo localProjectVo = this.aV;
      int m = localList2.indexOf(localProjectVo);
      this.bh = m;
      if (this.bh == -1)
        this.bh = 0;
      WheelView localWheelView5 = this.ao;
      int i1 = this.bh;
      localWheelView5.c(i1);
      Map localMap2 = this.ay;
      Integer localInteger2 = Integer.valueOf(5);
      LinearLayout localLinearLayout3 = this.ai;
      Object localObject = localMap2.put(localInteger2, localLinearLayout3);
      LinearLayout localLinearLayout4 = this.Z;
      LinearLayout localLinearLayout5 = this.ai;
      LinearLayout.LayoutParams localLayoutParams = this.ar;
      localLinearLayout4.addView(localLinearLayout5, localLayoutParams);
    }
    return this.ai;
  }

  public View d()
  {
    Map localMap1 = this.ay;
    Integer localInteger1 = Integer.valueOf(6);
    LinearLayout localLinearLayout1 = (LinearLayout)localMap1.get(localInteger1);
    this.aj = localLinearLayout1;
    if (this.aj == null)
    {
      LinearLayout localLinearLayout2 = (LinearLayout)this.bk.inflate(2130903048, null);
      this.aj = localLinearLayout2;
      WheelView localWheelView1 = (WheelView)this.aj.findViewById(2131230792);
      this.ap = localWheelView1;
      WheelView localWheelView2 = this.ap;
      hw localhw = new hw(this);
      localWheelView2.a(localhw);
      WheelView localWheelView3 = this.ap;
      a(localWheelView3);
      jw localjw1 = this.ax;
      List localList1 = this.aH;
      localjw1.a(localList1);
      WheelView localWheelView4 = this.ap;
      jw localjw2 = this.ax;
      localWheelView4.a(localjw2);
      List localList2 = this.aH;
      CorporationVo localCorporationVo = this.aX;
      int m = localList2.indexOf(localCorporationVo);
      this.bg = m;
      if (this.bg == -1)
        this.bg = 0;
      WheelView localWheelView5 = this.ap;
      int i1 = this.bg;
      localWheelView5.c(i1);
      Map localMap2 = this.ay;
      Integer localInteger2 = Integer.valueOf(6);
      LinearLayout localLinearLayout3 = this.aj;
      Object localObject = localMap2.put(localInteger2, localLinearLayout3);
      LinearLayout localLinearLayout4 = this.Z;
      LinearLayout localLinearLayout5 = this.aj;
      LinearLayout.LayoutParams localLayoutParams = this.ar;
      localLinearLayout4.addView(localLinearLayout5, localLayoutParams);
    }
    return this.aj;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    int m = d;
    if (paramInt1 == m)
    {
      if (paramInt2 == -1)
      {
        Bundle localBundle1 = paramIntent.getExtras();
        if (this.aR != null)
          this.aR.recycle();
        Bitmap localBitmap1 = (Bitmap)localBundle1.get("data");
        this.aR = localBitmap1;
        this.bb = 1;
        m();
        return;
      }
      if (paramInt2 != 0)
        return;
      return;
    }
    int i1 = e;
    if (paramInt1 == i1)
    {
      if (paramInt2 == -1)
      {
        Bundle localBundle2 = paramIntent.getExtras();
        if (localBundle2 != null)
        {
          Bitmap localBitmap2 = (Bitmap)localBundle2.getParcelable("data");
          this.aR = localBitmap2;
          this.bb = 1;
          m();
          return;
        }
        Uri localUri = paramIntent.getData();
        Bitmap localBitmap3 = BitmapFactory.decodeFile(a(localUri));
        this.aR = localBitmap3;
        this.bb = 1;
        m();
        return;
      }
      if (paramInt2 != 0)
        return;
      return;
    }
    int i2 = f;
    if (paramInt1 != i2)
      return;
    int i3 = h;
    if (paramInt2 != i3)
      return;
    this.bb = 0;
    m localm = this.bp;
    long l1 = this.aQ;
    String str = localm.a(l1).d();
    this.aP.b(str);
    this.aP.a(1);
    if (TextUtils.isEmpty(str))
      return;
    if (Environment.getExternalStorageState().equals("removed"))
    {
      hb.b(this.t, "未加载sd卡,与该账单相关的照片无法显示");
      return;
    }
    Bitmap localBitmap4 = BitmapFactory.decodeFile(eo.a(str));
    this.aR = localBitmap4;
    m();
  }

  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    Button localButton = this.y;
    Panel localPanel = this.aa;
    Boolean localBoolean = Boolean.valueOf(0);
    super.a(localButton, localPanel, localBoolean);
    switch (paramInt)
    {
    default:
      return;
    case 2131230732:
      this.af.a(0);
      return;
    case 2131230733:
      this.af.a(1);
      return;
    case 2131230781:
    }
    P();
  }

  public void onClick(View paramView)
  {
    int m = paramView.getId();
    int i1;
    int i2;
    switch (m)
    {
    default:
      i1 = this.as;
      i2 = paramView.getId();
      if ((i1 != i2) || (!this.az))
        break;
    case 2131230784:
    case 2131230734:
    case 2131230807:
    case 2131230809:
    case 2131230808:
    case 2131230785:
    case 2131230750:
    case 2131230777:
    case 2131230776:
    }
    for (int i3 = 0; ; i3 = 1)
    {
      InputMethodManager localInputMethodManager1 = this.bl;
      EditText localEditText = this.R;
      if ((localInputMethodManager1.isActive(localEditText)) && (m != 2131230776))
      {
        InputMethodManager localInputMethodManager2 = this.bl;
        IBinder localIBinder = this.R.getWindowToken();
        ResultReceiver localResultReceiver = this.br;
        boolean bool1 = localInputMethodManager2.hideSoftInputFromWindow(localIBinder, 2, localResultReceiver);
      }
      c(i1);
      if (i3 != 0)
        b(i2);
      if ((i2 != 2131230735) && (i2 != 2131230761) && (i2 != 2131230764) && (i2 != 2131230767) && (i2 != 2131230770) && (i2 != 2131230774) && (i2 != 2131230775))
        return;
      this.as = i2;
      return;
      n();
      return;
      finish();
      return;
      Button localButton = this.y;
      Panel localPanel = this.aa;
      super.a(localButton, localPanel);
      return;
      boolean bool2 = this.S.performClick();
      return;
      int i4 = this.as;
      c(i4);
      return;
      boolean bool3 = a(1, 0);
      int i5 = this.as;
      c(i5);
      return;
      boolean bool4 = a(0, 1);
      return;
      int i6 = this.as;
      c(i6);
      return;
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.t = this;
    Resources localResources = this.t.getResources();
    this.u = localResources;
    gz.b();
    setContentView(2130903044);
    Button localButton1 = (Button)findViewById(2131230807);
    this.x = localButton1;
    Button localButton2 = (Button)findViewById(2131230809);
    this.y = localButton2;
    Button localButton3 = (Button)findViewById(2131230808);
    this.z = localButton3;
    Button localButton4 = (Button)findViewById(2131230734);
    this.A = localButton4;
    Button localButton5 = (Button)findViewById(2131230735);
    this.B = localButton5;
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131230761);
    this.C = localLinearLayout1;
    TextView localTextView1 = (TextView)findViewById(2131230762);
    this.D = localTextView1;
    TextView localTextView2 = (TextView)findViewById(2131230763);
    this.E = localTextView2;
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131230764);
    this.F = localLinearLayout2;
    TextView localTextView3 = (TextView)findViewById(2131230765);
    this.G = localTextView3;
    TextView localTextView4 = (TextView)findViewById(2131230766);
    this.H = localTextView4;
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131230767);
    this.I = localLinearLayout3;
    TextView localTextView5 = (TextView)findViewById(2131230768);
    this.J = localTextView5;
    TextView localTextView6 = (TextView)findViewById(2131230769);
    this.K = localTextView6;
    LinearLayout localLinearLayout4 = (LinearLayout)findViewById(2131230770);
    this.L = localLinearLayout4;
    TextView localTextView7 = (TextView)findViewById(2131230771);
    this.M = localTextView7;
    TextView localTextView8 = (TextView)findViewById(2131230772);
    this.N = localTextView8;
    LinearLayout localLinearLayout5 = (LinearLayout)findViewById(2131230773);
    this.O = localLinearLayout5;
    Button localButton6 = (Button)findViewById(2131230774);
    this.P = localButton6;
    Button localButton7 = (Button)findViewById(2131230775);
    this.Q = localButton7;
    EditText localEditText = (EditText)findViewById(2131230776);
    this.R = localEditText;
    Button localButton8 = (Button)findViewById(2131230750);
    this.S = localButton8;
    Button localButton9 = (Button)findViewById(2131230777);
    this.T = localButton9;
    LinearLayout localLinearLayout6 = (LinearLayout)findViewById(2131230782);
    this.U = localLinearLayout6;
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131230783);
    this.V = localRelativeLayout;
    ImageView localImageView = (ImageView)findViewById(2131230786);
    this.W = localImageView;
    Button localButton10 = (Button)findViewById(2131230784);
    this.X = localButton10;
    Button localButton11 = (Button)findViewById(2131230785);
    this.Y = localButton11;
    LinearLayout localLinearLayout7 = (LinearLayout)findViewById(2131230787);
    this.Z = localLinearLayout7;
    Panel localPanel1 = (Panel)findViewById(2131230778);
    this.aa = localPanel1;
    RadioGroup localRadioGroup = (RadioGroup)findViewById(2131230731);
    this.ab = localRadioGroup;
    RadioButton localRadioButton1 = (RadioButton)findViewById(2131230732);
    this.ac = localRadioButton1;
    RadioButton localRadioButton2 = (RadioButton)findViewById(2131230733);
    this.ad = localRadioButton2;
    LayoutInflater localLayoutInflater = (LayoutInflater)this.t.getSystemService("layout_inflater");
    this.bk = localLayoutInflater;
    InputMethodManager localInputMethodManager1 = (InputMethodManager)getSystemService("input_method");
    this.bl = localInputMethodManager1;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.ar = localLayoutParams;
    Animation localAnimation1 = AnimationUtils.loadAnimation(this.t, 2130968577);
    this.bi = localAnimation1;
    Animation localAnimation2 = AnimationUtils.loadAnimation(this.t, 2130968576);
    this.bj = localAnimation2;
    Animation localAnimation3 = this.bi;
    ij localij = new ij(this);
    localAnimation3.setAnimationListener(localij);
    Animation localAnimation4 = this.bj;
    ii localii = new ii(this);
    localAnimation4.setAnimationListener(localii);
    Context localContext1 = this.t;
    ju localju1 = new ju(localContext1, 2130903049);
    this.at = localju1;
    Context localContext2 = this.t;
    ju localju2 = new ju(localContext2, 2130903049);
    this.au = localju2;
    Context localContext3 = this.t;
    js localjs = new js(localContext3, 2130903052);
    this.av = localjs;
    Context localContext4 = this.t;
    jy localjy = new jy(localContext4, 2130903051);
    this.aw = localjy;
    Context localContext5 = this.t;
    jw localjw = new jw(localContext5, 2130903052);
    this.ax = localjw;
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.I.setOnClickListener(this);
    this.L.setOnClickListener(this);
    this.P.setOnClickListener(this);
    this.Q.setOnClickListener(this);
    this.R.setOnClickListener(this);
    this.X.setOnClickListener(this);
    this.Y.setOnClickListener(this);
    this.S.setOnClickListener(this);
    this.T.setOnClickListener(this);
    Panel localPanel2 = this.aa;
    um localum = um.b;
    un localun = new un(localum);
    localPanel2.a(localun);
    this.ab.setOnCheckedChangeListener(this);
    this.ac.setOnClickListener(this);
    this.ad.setOnClickListener(this);
    Handler localHandler1 = this.v;
    hs localhs = new hs(this, localHandler1);
    this.br = localhs;
    Intent localIntent = getIntent();
    int m = localIntent.getIntExtra("transType", -1);
    this.p = m;
    int i1 = localIntent.getIntExtra("state", 0);
    this.l = i1;
    boolean bool1 = localIntent.getBooleanExtra("isFromSecurityLogin", 0);
    this.o = bool1;
    double d1 = localIntent.getDoubleExtra("cost", 0.0D);
    this.aT = d1;
    String str1 = localIntent.getStringExtra("memo");
    this.aZ = str1;
    if ((this.p == -1) || (this.l == 0))
    {
      hb.b(this.t, "参数错误.");
      finish();
    }
    String str2 = "intent is " + localIntent;
    gj.a("AddOrEditTransNewActivity", str2);
    StringBuilder localStringBuilder1 = new StringBuilder().append("mTransType is ");
    int i2 = this.p;
    String str3 = i2;
    gj.a("AddOrEditTransNewActivity", str3);
    StringBuilder localStringBuilder2 = new StringBuilder().append("mRequestTypeFromAppwidget is ");
    String str4 = this.n;
    String str5 = str4;
    gj.a("AddOrEditTransNewActivity", str5);
    StringBuilder localStringBuilder3 = new StringBuilder().append("mState is ");
    int i3 = this.l;
    String str6 = i3;
    gj.a("AddOrEditTransNewActivity", str6);
    StringBuilder localStringBuilder4 = new StringBuilder().append("mIsFromSecurityLogin is ");
    boolean bool2 = this.o;
    String str7 = bool2;
    gj.a("AddOrEditTransNewActivity", str7);
    CategoryVo localCategoryVo1 = this.bq.c();
    this.aJ = localCategoryVo1;
    CategoryVo localCategoryVo2 = this.bq.b();
    this.aI = localCategoryVo2;
    if (this.aJ.e() == null)
    {
      CategoryVo localCategoryVo3 = this.aJ;
      CategoryVo localCategoryVo4 = new CategoryVo("空分类");
      localCategoryVo3.e(localCategoryVo4);
      CategoryVo localCategoryVo5 = this.aJ.e();
      CategoryVo localCategoryVo6 = new CategoryVo("空分类");
      localCategoryVo5.e(localCategoryVo6);
    }
    if (this.aI.e() == null)
    {
      CategoryVo localCategoryVo7 = this.aI;
      CategoryVo localCategoryVo8 = new CategoryVo("空分类");
      localCategoryVo7.e(localCategoryVo8);
      CategoryVo localCategoryVo9 = this.aI.e();
      CategoryVo localCategoryVo10 = new CategoryVo("空分类");
      localCategoryVo9.e(localCategoryVo10);
    }
    if (Q())
    {
      CategoryVo localCategoryVo11 = this.aI;
      this.aL = localCategoryVo11;
      AccountVo localAccountVo = this.bq.e();
      this.aM = localAccountVo;
      CorporationVo localCorporationVo = this.bq.f();
      this.aN = localCorporationVo;
      ProjectVo localProjectVo = this.bq.d();
      this.aK = localProjectVo;
      if (!U())
        break label1834;
      h();
      this.y.setVisibility(0);
      this.y.setText("新增支出");
      i();
      label1682: TransactionVo localTransactionVo1 = this.aP;
      CategoryVo localCategoryVo12 = this.aU;
      localTransactionVo1.a(localCategoryVo12);
      e();
      if (!Q())
        break label2100;
      Button localButton12 = this.B;
      int i4 = this.u.getColor(2131296288);
      localButton12.setTextColor(i4);
      this.B.setBackgroundResource(2130837508);
    }
    while (true)
    {
      this.z.setText("保存");
      this.R.clearFocus();
      InputMethodManager localInputMethodManager2 = this.bl;
      IBinder localIBinder = this.R.getWindowToken();
      boolean bool3 = localInputMethodManager2.hideSoftInputFromWindow(localIBinder, 2, null);
      Handler localHandler2 = this.v;
      hx localhx = new hx(this);
      boolean bool4 = localHandler2.postDelayed(localhx, 0L);
      return;
      CategoryVo localCategoryVo13 = this.aJ;
      this.aL = localCategoryVo13;
      break;
      label1834: if (V())
      {
        long l1 = localIntent.getLongExtra("id", 0L);
        this.aQ = l1;
        if (this.aQ == 0L)
        {
          hb.b(this.t, "系统错误");
          finish();
        }
        m localm = this.bp;
        long l2 = this.aQ;
        TransactionVo localTransactionVo2 = localm.a(l2);
        this.aP = localTransactionVo2;
        g();
        long l3 = this.aP.g().a();
        this.aO = l3;
        String str8 = this.aP.d();
        if (!TextUtils.isEmpty(str8))
        {
          if (Environment.getExternalStorageState().equals("removed"))
            hb.b(this.t, "未加载sd卡,与该账单相关的照片无法显示");
        }
        else
        {
          label1975: this.y.setVisibility(0);
          if (!Q())
            break label2070;
          this.y.setText("编辑支出");
        }
        while (true)
        {
          i();
          break;
          String str9 = eo.a(str8);
          int i5 = b;
          int i6 = c;
          Bitmap localBitmap = gp.a(str9, i5, i6, 1);
          this.aR = localBitmap;
          if (this.aR != null)
          {
            m();
            break label1975;
          }
          hb.b(this.t, "无法找到与该账单相关的照片,请确认是否已经在sd卡中");
          break label1975;
          this.y.setText("编辑收入");
        }
      }
      label2070: hb.b(this.t, "系统错误");
      finish();
      break label1682;
      label2100: Button localButton13 = this.B;
      int i7 = this.u.getColor(2131296287);
      localButton13.setTextColor(i7);
      this.B.setBackgroundResource(2130837505);
    }
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 1:
    }
    AlertDialog.Builder localBuilder;
    String[] arrayOfString;
    hz localhz;
    for (Object localObject = super.onCreateDialog(paramInt); ; localObject = localBuilder.setItems(arrayOfString, localhz).create())
    {
      return localObject;
      Context localContext = this.t;
      localBuilder = new AlertDialog.Builder(localContext).setTitle("选择照片");
      arrayOfString = this.q;
      localhz = new hz(this);
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131623936, paramMenu);
    if (U())
      MenuItem localMenuItem1 = paramMenu.getItem(2).setVisible(0);
    if (this.o)
      MenuItem localMenuItem2 = paramMenu.getItem(4).setVisible(0);
    return true;
  }

  protected void onDestroy()
  {
    gj.a("AddOrEditTransNewActivity", "onDestroy()");
    super.onDestroy();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int m;
    if (paramInt == 4)
      if (this.az)
      {
        boolean bool1 = this.Y.performClick();
        m = 1;
      }
    while (true)
    {
      return m;
      double d1 = gs.a(this.B.getText().toString()).doubleValue();
      this.aT = d1;
      if ((U()) && (this.aT != 0.0D))
      {
        this.w = 0;
        boolean bool3 = a(1, 0);
        m = 1;
        continue;
      }
      boolean bool2 = super.onKeyDown(paramInt, paramKeyEvent);
    }
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
      boolean bool2 = a(1, 0);
      continue;
      finish();
      continue;
      if (!V())
        continue;
      Context localContext = this.t;
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle(2131492899).setMessage(2131492900);
      ib localib = new ib(this);
      AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton(2131492901, localib);
      ia localia = new ia(this);
      localBuilder2.setNegativeButton(2131492902, localia).create().show();
      continue;
      n();
      continue;
      finish();
    }
  }

  protected void onPause()
  {
    gj.a("AddOrEditTransNewActivity", "onPause()");
    super.onPause();
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    if (!V())
      return;
    this.ab.setVisibility(4);
  }

  protected void onRestart()
  {
    gj.a("AddOrEditTransNewActivity", "onRestart()");
    super.onRestart();
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    this.bc = 1;
    int m = paramBundle.getInt("mState");
    this.l = m;
    int i1 = paramBundle.getInt("mTransType");
    this.p = i1;
    long l1 = paramBundle.getLong("mId");
    this.aQ = l1;
    Bitmap localBitmap = (Bitmap)paramBundle.getParcelable("mPhotoBitmap");
    this.aR = localBitmap;
    boolean bool = paramBundle.getBoolean("mNeedSavePhotoToSd");
    this.bb = bool;
    String str1 = paramBundle.getString("costStr");
    long l2 = paramBundle.getLong("mTradeTime");
    this.aY = l2;
    String str2 = paramBundle.getString("mMemo");
    this.aZ = str2;
    ArrayList localArrayList1 = paramBundle.getParcelableArrayList("mProjectList");
    this.aD = localArrayList1;
    ArrayList localArrayList2 = paramBundle.getParcelableArrayList("mAccountList");
    this.aE = localArrayList2;
    ArrayList localArrayList3 = paramBundle.getParcelableArrayList("mAssetAccountList");
    this.aF = localArrayList3;
    ArrayList localArrayList4 = paramBundle.getParcelableArrayList("mAssetAndLiabilityAccountList");
    this.aG = localArrayList4;
    ArrayList localArrayList5 = paramBundle.getParcelableArrayList("mCorporationList");
    this.aH = localArrayList5;
    CategoryVo localCategoryVo1 = (CategoryVo)paramBundle.get("mDefaultPayoutCategory");
    this.aI = localCategoryVo1;
    CategoryVo localCategoryVo2 = (CategoryVo)paramBundle.get("mDefaultIncomeCategory");
    this.aJ = localCategoryVo2;
    CategoryVo localCategoryVo3 = (CategoryVo)paramBundle.get("mDefaultCategory");
    this.aL = localCategoryVo3;
    AccountVo localAccountVo1 = (AccountVo)paramBundle.get("mDefaultAccount");
    this.aM = localAccountVo1;
    ProjectVo localProjectVo1 = (ProjectVo)paramBundle.get("mDefaultProject");
    this.aK = localProjectVo1;
    CorporationVo localCorporationVo1 = (CorporationVo)paramBundle.get("mDefaultCorporation");
    this.aN = localCorporationVo1;
    CategoryVo localCategoryVo4 = (CategoryVo)paramBundle.get("mRootCategoryVo");
    this.aU = localCategoryVo4;
    ProjectVo localProjectVo2 = (ProjectVo)paramBundle.get("mProjectVo");
    this.aV = localProjectVo2;
    AccountVo localAccountVo2 = (AccountVo)paramBundle.get("mAccountVo");
    this.aW = localAccountVo2;
    CorporationVo localCorporationVo2 = (CorporationVo)paramBundle.get("mCorporationVo");
    this.aX = localCorporationVo2;
    TransactionVo localTransactionVo = (TransactionVo)paramBundle.get("mTransactionVo");
    this.aP = localTransactionVo;
    L();
    i();
    this.B.setText(str1);
    gj.a("AddOrEditTransNewActivity", "onRestoreInstanceState");
  }

  protected void onResume()
  {
    gj.a("AddOrEditTransNewActivity", "onResume()");
    super.onResume();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    String str1 = this.R.getEditableText().toString();
    this.aZ = str1;
    String str2 = this.B.getText().toString();
    super.onSaveInstanceState(paramBundle);
    int m = this.l;
    paramBundle.putInt("mState", m);
    int i1 = this.p;
    paramBundle.putInt("mTransType", i1);
    long l1 = this.aQ;
    paramBundle.putLong("mId", l1);
    Bitmap localBitmap = this.aR;
    paramBundle.putParcelable("mPhotoBitmap", localBitmap);
    boolean bool = this.bb;
    paramBundle.putBoolean("mNeedSavePhotoToSd", bool);
    paramBundle.putString("costStr", str2);
    long l2 = this.aY;
    paramBundle.putLong("mTradeTime", l2);
    String str3 = this.aZ;
    paramBundle.putString("mMemo", str3);
    ArrayList localArrayList1 = (ArrayList)this.aD;
    paramBundle.putParcelableArrayList("mProjectList", localArrayList1);
    ArrayList localArrayList2 = (ArrayList)this.aE;
    paramBundle.putParcelableArrayList("mAccountList", localArrayList2);
    ArrayList localArrayList3 = (ArrayList)this.aF;
    paramBundle.putParcelableArrayList("mAssetAccountList", localArrayList3);
    ArrayList localArrayList4 = (ArrayList)this.aG;
    paramBundle.putParcelableArrayList("mAssetAndLiabilityAccountList", localArrayList4);
    ArrayList localArrayList5 = (ArrayList)this.aH;
    paramBundle.putParcelableArrayList("mCorporationList", localArrayList5);
    CategoryVo localCategoryVo1 = this.aI;
    paramBundle.putParcelable("mDefaultPayoutCategory", localCategoryVo1);
    CategoryVo localCategoryVo2 = this.aJ;
    paramBundle.putParcelable("mDefaultIncomeCategory", localCategoryVo2);
    CategoryVo localCategoryVo3 = this.aL;
    paramBundle.putParcelable("mDefaultCategory", localCategoryVo3);
    AccountVo localAccountVo1 = this.aM;
    paramBundle.putParcelable("mDefaultAccount", localAccountVo1);
    ProjectVo localProjectVo1 = this.aK;
    paramBundle.putParcelable("mDefaultProject", localProjectVo1);
    CorporationVo localCorporationVo1 = this.aN;
    paramBundle.putParcelable("mDefaultCorporation", localCorporationVo1);
    CategoryVo localCategoryVo4 = this.aU;
    paramBundle.putParcelable("mRootCategoryVo", localCategoryVo4);
    ProjectVo localProjectVo2 = this.aV;
    paramBundle.putParcelable("mProjectVo", localProjectVo2);
    AccountVo localAccountVo2 = this.aW;
    paramBundle.putParcelable("mAccountVo", localAccountVo2);
    CorporationVo localCorporationVo2 = this.aX;
    paramBundle.putParcelable("mCorporationVo", localCorporationVo2);
    TransactionVo localTransactionVo = this.aP;
    paramBundle.putParcelable("mTransactionVo", localTransactionVo);
    gj.a("AddOrEditTransNewActivity", "onSaveInstanceState");
  }

  protected void onStart()
  {
    gj.a("AddOrEditTransNewActivity", "onStart()");
    super.onStart();
  }

  protected void onStop()
  {
    gj.a("AddOrEditTransNewActivity", "onStop()");
    super.onStop();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.addtrans.AddOrEditTransNewActivity
 * JD-Core Version:    0.6.0
 */