package com.mymoney.ui.addtrans;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.mymoney.core.vo.TransactionVo;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.helper.PickPhotoHelper;
import com.mymoney.ui.widget.ZoomControls;
import eo;
import ep;
import g;
import ge;
import gw;
import hb;
import java.io.File;
import java.io.FileOutputStream;
import jj;
import jk;
import jl;
import jm;
import jn;
import jo;
import jp;
import jq;
import m;

public class TransactionPhotoEditActivity extends BaseActivity
  implements View.OnClickListener
{
  public static String a = TransactionPhotoEditActivity.class.getSimpleName();
  public static String f = "expenseId";
  public Context b = this;
  public boolean c = 1;
  public GestureDetector d;
  final Handler e;
  TransactionVo g;
  private Uri h;
  private gw i;
  private String[] j;
  private Button k;
  private Button l;
  private ImageViewTouch n;
  private RelativeLayout o;
  private ZoomControls p;
  private long q;
  private boolean r;
  private final Animation s;
  private final Animation t;
  private m u;
  private final Runnable v;

  public TransactionPhotoEditActivity()
  {
    Handler localHandler = new Handler();
    this.e = localHandler;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "相机";
    arrayOfString[1] = "相册";
    this.j = arrayOfString;
    this.r = 0;
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    this.s = localAlphaAnimation1;
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    this.t = localAlphaAnimation2;
    m localm = g.a().b();
    this.u = localm;
    jm localjm = new jm(this);
    this.v = localjm;
  }

  private void a(Bitmap paramBitmap)
  {
    j();
    gw localgw1 = new gw(paramBitmap, 0);
    this.i = localgw1;
    ImageViewTouch localImageViewTouch = this.n;
    gw localgw2 = this.i;
    localImageViewTouch.a(localgw2, 1);
  }

  private void a(View paramView)
  {
    jp localjp = new jp(this, null);
    GestureDetector localGestureDetector = new GestureDetector(this, localjp);
    this.d = localGestureDetector;
    jk localjk = new jk(this);
    jl localjl = new jl(this, localjk);
    paramView.setOnTouchListener(localjl);
  }

  private void a(View paramView, ImageViewTouch paramImageViewTouch)
  {
    a(paramView);
    a(paramImageViewTouch);
  }

  private void a(ImageViewTouch paramImageViewTouch)
  {
    ZoomControls localZoomControls1 = this.p;
    jn localjn = new jn(this);
    localZoomControls1.a(localjn);
    ZoomControls localZoomControls2 = this.p;
    jo localjo = new jo(this);
    localZoomControls2.b(localjo);
  }

  private boolean a(Uri paramUri)
  {
    int m;
    if (paramUri == null)
      m = 0;
    while (true)
    {
      return m;
      ContentResolver localContentResolver = getContentResolver();
      Bitmap localBitmap = ge.a(2048, 3145728, paramUri, localContentResolver);
      if (localBitmap == null)
      {
        m = 0;
        continue;
      }
      gw localgw = new gw(localBitmap, 0);
      this.i = localgw;
      m = 1;
    }
  }

  private void b()
  {
    if (this.i == null)
      return;
    ImageViewTouch localImageViewTouch = this.n;
    gw localgw = this.i;
    localImageViewTouch.a(localgw, 1);
    a();
  }

  private void c()
  {
    if (ep.a())
    {
      if (this.r)
      {
        i();
        return;
      }
      setResult(0);
      hb.b(this.b, "照片保存成功.");
      finish();
      return;
    }
    hb.b(this.b, "照片保存失败,sd卡不可用.");
  }

  private void d()
  {
    ImageViewTouch localImageViewTouch = this.n;
    gw localgw = this.i;
    localImageViewTouch.a(localgw, 1);
  }

  private void e()
  {
    this.l.setText("保存");
    this.l.setCompoundDrawablesWithIntrinsicBounds(2130837605, 0, 0, 0);
  }

  private void f()
  {
    try
    {
      Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      startActivityForResult(localIntent, 2);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void g()
  {
    Intent localIntent = Intent.createChooser(PickPhotoHelper.a(), "选择照片");
    startActivityForResult(localIntent, 3);
  }

  private boolean h()
  {
    String str1 = this.g.d();
    String str2 = eo.a();
    try
    {
      File localFile = eo.b(str2);
      FileOutputStream localFileOutputStream = eo.a(this.i.b(), localFile);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      label40: this.g.b(str2);
      this.g.a(1);
      m localm = this.u;
      TransactionVo localTransactionVo = this.g;
      boolean bool1 = localm.a(localTransactionVo);
      boolean bool2 = eo.c(str1);
      int m = AddOrEditTransactionActivity.i;
      setResult(m);
      return true;
    }
    catch (Exception localException)
    {
      break label40;
    }
  }

  private void i()
  {
    jq localjq = new jq(this);
    Void[] arrayOfVoid = new Void[0];
    AsyncTask localAsyncTask = localjq.execute(arrayOfVoid);
  }

  private void j()
  {
    if (this.i == null)
      return;
    this.i.g();
    this.i = null;
  }

  private void k()
  {
    Handler localHandler1 = this.e;
    Runnable localRunnable1 = this.v;
    localHandler1.removeCallbacks(localRunnable1);
    Handler localHandler2 = this.e;
    Runnable localRunnable2 = this.v;
    boolean bool = localHandler2.postDelayed(localRunnable2, 2000L);
  }

  private void l()
  {
    this.p.b();
    Animation localAnimation = this.t;
    localAnimation.setDuration(500L);
    this.o.startAnimation(localAnimation);
    this.o.setVisibility(8);
  }

  private void m()
  {
    if (this.c)
      return;
    this.p.a();
    Animation localAnimation = this.s;
    localAnimation.setDuration(500L);
    this.o.startAnimation(localAnimation);
    this.o.setVisibility(0);
  }

  public void a()
  {
    ImageViewTouch localImageViewTouch = this.n;
    float f1 = localImageViewTouch.b();
    float f2 = localImageViewTouch.g();
    ZoomControls localZoomControls1 = this.p;
    ZoomControls localZoomControls2;
    if (f2 == 0.0F)
    {
      int m = 1;
      localZoomControls1.a(m);
      localZoomControls2 = this.p;
      if (f1 <= 1.0F)
        break label84;
    }
    label84: int i3;
    for (int i2 = 1; ; i3 = 0)
    {
      localZoomControls2.b(i2);
      return;
      if (f1 < f2)
      {
        i1 = 1;
        break;
      }
      int i1 = 0;
      break;
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Bitmap localBitmap = null;
    if (paramInt1 == 2)
      if (paramInt2 == -1)
      {
        localBitmap = (Bitmap)paramIntent.getExtras().get("data");
        this.r = 1;
        if (localBitmap == null)
          break label155;
        a(localBitmap);
        e();
      }
    while (true)
    {
      a();
      return;
      if (paramInt2 != 0)
        break;
      break;
      if (paramInt1 != 3)
        break;
      if (paramInt2 == -1)
      {
        Bundle localBundle = paramIntent.getExtras();
        if (localBundle != null)
        {
          localBitmap = (Bitmap)localBundle.getParcelable("data");
          this.r = 1;
          break;
        }
        Uri localUri = paramIntent.getData();
        ContentResolver localContentResolver = getContentResolver();
        localBitmap = ge.a(2048, 3145728, localUri, localContentResolver);
        this.r = 1;
        break;
      }
      if (paramInt2 != 0)
        break;
      break;
      label155: d();
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230734:
      showDialog(1);
      return;
    case 2131230758:
    }
    if (this.l.getText().toString().equals("返回"))
    {
      finish();
      return;
    }
    c();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setDefaultKeyMode(2);
    boolean bool = requestWindowFeature(1);
    setContentView(2130903043);
    ImageViewTouch localImageViewTouch1 = (ImageViewTouch)findViewById(2131230756);
    this.n = localImageViewTouch1;
    Button localButton1 = (Button)findViewById(2131230734);
    this.k = localButton1;
    Button localButton2 = (Button)findViewById(2131230758);
    this.l = localButton2;
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131230757);
    this.o = localRelativeLayout;
    ZoomControls localZoomControls = (ZoomControls)findViewById(2131230759);
    this.p = localZoomControls;
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    getWindow().addFlags(1024);
    Intent localIntent = getIntent();
    String str = f;
    long l1 = localIntent.getLongExtra(str, 0L);
    this.q = l1;
    if (this.q != 0L)
    {
      m localm = this.u;
      long l2 = this.q;
      TransactionVo localTransactionVo = localm.a(l2);
      this.g = localTransactionVo;
    }
    while (true)
    {
      View localView = findViewById(2131230755);
      ImageViewTouch localImageViewTouch2 = this.n;
      a(localView, localImageViewTouch2);
      k();
      return;
      hb.b(this.b, "系统错误");
      finish();
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
    jj localjj;
    for (Object localObject = super.onCreateDialog(paramInt); ; localObject = localBuilder.setItems(arrayOfString, localjj).create())
    {
      return localObject;
      Context localContext = this.b;
      localBuilder = new AlertDialog.Builder(localContext).setTitle("选择照片");
      arrayOfString = this.j;
      localjj = new jj(this);
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131623939, paramMenu);
    return true;
  }

  protected void onDestroy()
  {
    j();
    super.onDestroy();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool1 = super.onOptionsItemSelected(paramMenuItem);
    switch (paramMenuItem.getItemId())
    {
    case 2131231176:
    default:
    case 2131231174:
    case 2131231175:
    case 2131231177:
    }
    while (true)
    {
      return true;
      boolean bool2 = this.l.performClick();
      continue;
      finish();
      continue;
      showDialog(1);
    }
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    if (this.i == null)
    {
      Uri localUri1 = this.h;
      if (!a(localUri1))
      {
        String str1 = a;
        StringBuilder localStringBuilder = new StringBuilder().append("init failed: ");
        Uri localUri2 = this.h;
        String str2 = localUri2;
        int m = Log.w(str1, str2);
        hb.b(this.b, "无法找到与该账单相关的照片,请确认是否已经在sd卡中");
        return;
      }
    }
    b();
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    long l1 = paramBundle.getLong("expenseId");
    this.q = l1;
    boolean bool = paramBundle.getBoolean("needSavePhoto");
    this.r = bool;
    if (this.i != null)
      return;
    Bitmap localBitmap = (Bitmap)paramBundle.getParcelable("photoBitmap");
    if (localBitmap == null)
      return;
    gw localgw = new gw(localBitmap, 0);
    this.i = localgw;
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    long l1 = this.q;
    paramBundle.putLong("expenseId", l1);
    boolean bool = this.r;
    paramBundle.putBoolean("needSavePhoto", bool);
    if (this.i == null)
      return;
    Bitmap localBitmap = this.i.b();
    paramBundle.putParcelable("photoBitmap", localBitmap);
  }

  protected void onStart()
  {
    super.onStart();
    this.c = 0;
    String str1 = this.g.d();
    if (TextUtils.isEmpty(str1))
      return;
    if (Environment.getExternalStorageState().equals("removed"))
    {
      hb.b(this.b, "未加载sd卡,与该账单相关的照片无法显示");
      return;
    }
    String str2 = eo.a(str1);
    Uri localUri = Uri.fromFile(new File(str2));
    this.h = localUri;
  }

  protected void onStop()
  {
    super.onStop();
    this.c = 1;
    Handler localHandler = this.e;
    Runnable localRunnable = this.v;
    localHandler.removeCallbacks(localRunnable);
    l();
    this.n.a();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.addtrans.TransactionPhotoEditActivity
 * JD-Core Version:    0.6.0
 */