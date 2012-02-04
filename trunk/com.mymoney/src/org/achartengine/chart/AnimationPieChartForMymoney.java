package org.achartengine.chart;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import b;
import gs;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Timer;
import uk;
import um;
import un;
import vo;
import vp;
import vq;
import vr;
import vs;
import vt;
import vu;
import vv;
import vx;
import vy;
import vz;

public class AnimationPieChartForMymoney extends View
{
  private static String S;
  public static float a;
  private static String ac;
  private static int k = 360;
  private static final int[] o;
  private float[] A;
  private float[] B;
  private float[] C;
  private long D;
  private int E;
  private long F;
  private float[] G;
  private float[] H;
  private float I;
  private float J;
  private long K;
  private long L;
  private float M;
  private long N;
  private float O;
  private vy P;
  private int Q;
  private boolean R;
  private int T;
  private vv U;
  private String V;
  private Drawable W;
  private Drawable X;
  private Paint Y;
  private Paint Z;
  private vy aA;
  private vy aB;
  private float aC;
  private long aD;
  private long aE;
  private float aF;
  private vs aG;
  private float aH;
  private float aI;
  private Paint aa;
  private Paint ab;
  private String ad;
  private String ae;
  private String af;
  private int ag;
  private float ah;
  private float ai;
  private float aj;
  private float ak;
  private float al;
  private float am;
  private float an;
  private float ao;
  private float ap;
  private float aq;
  private float ar;
  private float as;
  private float at;
  private float au;
  private Rect av;
  private float aw;
  private long[] ax;
  private float[] ay;
  private int az;
  Canvas b;
  private Context c;
  private String d;
  private vt e;
  private boolean f;
  private Timer g;
  private int h;
  private int i;
  private vu j;
  private un l;
  private uk m;
  private AccelerateDecelerateInterpolator n;
  private NumberFormat p;
  private double q;
  private Paint r;
  private int s;
  private float t;
  private float u;
  private float v;
  private vy w;
  private RectF x;
  private float y;
  private float[] z;

  static
  {
    int[] arrayOfInt = new int[11];
    int i1 = Color.rgb(255, 0, 68);
    arrayOfInt[0] = i1;
    int i2 = Color.rgb(5, 173, 207);
    arrayOfInt[1] = i2;
    int i3 = Color.rgb(4, 227, 66);
    arrayOfInt[2] = i3;
    int i4 = Color.rgb(255, 145, 0);
    arrayOfInt[3] = i4;
    int i5 = Color.rgb(193, 18, 213);
    arrayOfInt[4] = i5;
    int i6 = Color.rgb(255, 0, 0);
    arrayOfInt[5] = i6;
    int i7 = Color.rgb(74, 91, 255);
    arrayOfInt[6] = i7;
    int i8 = Color.rgb(186, 255, 38);
    arrayOfInt[7] = i8;
    int i9 = Color.rgb(239, 197, 0);
    arrayOfInt[8] = i9;
    int i10 = Color.rgb(120, 120, 120);
    arrayOfInt[9] = i10;
    arrayOfInt[10] = -16776961;
    o = arrayOfInt;
    S = "";
    ac = "";
    a = 0.0008F;
  }

  public AnimationPieChartForMymoney(Context paramContext)
  {
    this(paramContext, null);
  }

  public AnimationPieChartForMymoney(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AnimationPieChartForMymoney(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    String str = AnimationPieChartForMymoney.class.getSimpleName();
    this.d = str;
    vt localvt = new vt(this);
    this.e = localvt;
    this.f = 0;
    um localum1 = um.c;
    un localun = new un(localum1);
    this.l = localun;
    um localum2 = um.c;
    uk localuk = new uk(localum2, 4.0F);
    this.m = localuk;
    AccelerateDecelerateInterpolator localAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
    this.n = localAccelerateDecelerateInterpolator;
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    this.p = localNumberFormat;
    Paint localPaint = new Paint();
    this.r = localPaint;
    this.E = 1;
    this.I = 0.0F;
    this.O = 500.0F;
    vy localvy1 = new vy(0.0F, 0.0F);
    this.P = localvy1;
    this.R = 0;
    this.ad = "";
    this.ae = "";
    this.af = "";
    Object localObject = null;
    this.ax = localObject;
    float[] arrayOfFloat = new float[2];
    this.ay = arrayOfFloat;
    vy localvy2 = new vy();
    this.aA = localvy2;
    vy localvy3 = new vy();
    this.aB = localvy3;
    this.b = null;
    this.aI = 0.0F;
    this.c = paramContext;
    int[] arrayOfInt = b.a;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
    S = localTypedArray.getString(1);
    float f1 = localTypedArray.getFloat(2, 0.0F);
    this.ah = f1;
    float f2 = localTypedArray.getFloat(3, 0.0F);
    this.ai = f2;
    float f3 = localTypedArray.getFloat(4, 0.0F);
    this.aj = f3;
    float f4 = localTypedArray.getFloat(5, 0.0F);
    this.ak = f4;
    ac = localTypedArray.getString(6);
    long l1 = localTypedArray.getInt(7, 0);
    this.F = l1;
    long l2 = localTypedArray.getInt(8, 0);
    this.L = l2;
    float f5 = localTypedArray.getFloat(9, 0.0F);
    this.t = f5;
    float f6 = localTypedArray.getFloat(10, 0.0F);
    this.y = f6;
    float f7 = localTypedArray.getFloat(11, 0.0F);
    this.am = f7;
    float f8 = localTypedArray.getFloat(12, 0.0F);
    this.aq = f8;
    float f9 = localTypedArray.getFloat(13, 0.0F);
    this.as = f9;
    float f10 = localTypedArray.getFloat(14, 0.0F);
    this.at = f10;
    float f11 = localTypedArray.getFloat(15, 0.0F);
    this.au = f11;
    Drawable localDrawable1 = localTypedArray.getDrawable(17);
    this.X = localDrawable1;
    float f12 = localTypedArray.getFloat(16, 0.0F);
    this.aw = f12;
    Drawable localDrawable2 = localTypedArray.getDrawable(0);
    this.W = localDrawable2;
    localTypedArray.recycle();
    d();
  }

  private float a(Paint paramPaint)
  {
    Paint.FontMetrics localFontMetrics = paramPaint.getFontMetrics();
    float f1 = localFontMetrics.ascent;
    return -(localFontMetrics.descent + f1);
  }

  private float a(String paramString, Paint paramPaint)
  {
    return paramPaint.measureText(paramString);
  }

  private int a(float paramFloat)
  {
    float f2;
    int i1;
    if (paramFloat > 0.0F)
    {
      float f1 = paramFloat % 360.0F;
      f2 = 360.0F - f1;
      i1 = 0;
      label22: int i2 = this.s;
      if (i1 >= i2)
        break label115;
      float[] arrayOfFloat1 = this.A;
      int i3 = i1 * 2;
      int i4 = arrayOfFloat1[i3];
      if (f2 < i4)
        break label106;
      float[] arrayOfFloat2 = this.A;
      int i5 = i1 * 2 + 1;
      int i6 = arrayOfFloat2[i5];
      if (f2 >= i6)
        break label106;
    }
    label106: label115: for (int i7 = i1; ; i7 = 0)
    {
      return i7;
      f2 = -paramFloat % 360.0F;
      break;
      i1 += 1;
      break label22;
    }
  }

  private long a(long paramLong)
  {
    return paramLong / 1000000L;
  }

  private void a(int paramInt)
  {
    if (paramInt < 0)
      return;
    int i1 = this.s - 1;
    if (paramInt > i1)
      return;
    float[] arrayOfFloat1 = this.A;
    int i2 = paramInt * 2;
    int i3 = arrayOfFloat1[i2];
    float[] arrayOfFloat2 = this.A;
    int i4 = paramInt * 2 + 1;
    float f1 = (arrayOfFloat2[i4] - i3) / 2.0F;
    float f2 = i3 + f1;
    float f3 = this.I;
    float f4 = k;
    float f5 = f3 % f4;
    float f6 = 360.0F - f2;
    float f7 = Math.abs(f5);
    float f8 = f6 - f7;
    this.M = f8;
    String str1 = this.d;
    StringBuilder localStringBuilder = new StringBuilder().append("mAdjustMiddleSectorByAngle is ");
    float f9 = this.M;
    String str2 = f9;
    vx.a(str1, str2);
    float f10 = this.I;
    this.aH = f10;
    long l1 = System.nanoTime();
    this.N = l1;
    Timer localTimer1 = new Timer();
    this.g = localTimer1;
    Timer localTimer2 = this.g;
    vq localvq = new vq(this);
    long l2 = this.E;
    localTimer2.schedule(localvq, 0L, l2);
  }

  private void a(Canvas paramCanvas)
  {
    int i1 = paramCanvas.save(31);
    float f1 = this.u;
    float f2 = this.v;
    paramCanvas.translate(f1, f2);
    paramCanvas.rotate(90.0F);
    vu localvu1 = this.j;
    vu localvu2 = vu.a;
    if (localvu1 == localvu2)
    {
      i2 = 0;
      while (true)
      {
        int i3 = this.s;
        if (i2 >= i3)
          break;
        Paint localPaint1 = this.r;
        int[] arrayOfInt1 = o;
        int i4 = this.T;
        int i5 = i2 % i4;
        int i6 = arrayOfInt1[i5];
        localPaint1.setColor(i6);
        RectF localRectF1 = this.x;
        int i7 = this.G[i2];
        int i8 = this.H[i2];
        Paint localPaint2 = this.r;
        paramCanvas.drawArc(localRectF1, i7, i8, 1, localPaint2);
        i2 += 1;
      }
    }
    float f3 = this.I;
    paramCanvas.rotate(f3);
    int i2 = 0;
    while (true)
    {
      int i9 = this.s;
      if (i2 >= i9)
        break;
      Paint localPaint3 = this.r;
      int[] arrayOfInt2 = o;
      int i10 = this.T;
      int i11 = i2 % i10;
      int i12 = arrayOfInt2[i11];
      localPaint3.setColor(i12);
      RectF localRectF2 = this.x;
      float[] arrayOfFloat = this.A;
      int i13 = i2 * 2;
      int i14 = arrayOfFloat[i13];
      int i15 = this.z[i2];
      Paint localPaint4 = this.r;
      paramCanvas.drawArc(localRectF2, i14, i15, 1, localPaint4);
      i2 += 1;
    }
    paramCanvas.restore();
    int i16 = paramCanvas.save(16);
    Drawable localDrawable1 = this.W;
    int i17 = super.getWidth();
    int i18 = super.getHeight();
    localDrawable1.setBounds(0, 0, i17, i18);
    this.W.draw(paramCanvas);
    paramCanvas.restore();
    String str1 = ac;
    float f4 = this.al;
    float f5 = this.am;
    Paint localPaint5 = this.Y;
    paramCanvas.drawText(str1, f4, f5, localPaint5);
    String str2 = this.ad;
    float f6 = this.an;
    float f7 = this.ao;
    Paint localPaint6 = this.Z;
    paramCanvas.drawText(str2, f6, f7, localPaint6);
    String str3 = this.ae;
    float f8 = this.ap;
    float f9 = this.aq;
    Paint localPaint7 = this.aa;
    paramCanvas.drawText(str3, f8, f9, localPaint7);
    String str4 = this.af;
    float f10 = this.ar;
    float f11 = this.as;
    Paint localPaint8 = this.ab;
    paramCanvas.drawText(str4, f10, f11, localPaint8);
    if (this.s > 0)
    {
      float f12 = this.at;
      float f13 = this.au;
      float f14 = this.aw;
      Paint localPaint9 = this.aa;
      paramCanvas.drawCircle(f12, f13, f14, localPaint9);
    }
    Drawable localDrawable2 = this.X;
    Rect localRect = this.av;
    localDrawable2.setBounds(localRect);
    this.X.draw(paramCanvas);
  }

  private void a(vy paramvy1, vy paramvy2, long paramLong)
  {
    vy localvy1 = vz.b(this.w, paramvy1);
    vy localvy2 = vz.b(paramvy1, paramvy2);
    vz.b(localvy1);
    float f1 = vz.a(localvy2, localvy1);
    vy localvy3 = vz.a(localvy1, f1);
    float f2 = vz.a(vz.c(localvy2, localvy3));
    float f3 = vz.d(this.w, paramvy2);
    if (f3 <= 0.0F)
    {
      float f4 = this.t;
      if (f3 > f4)
        return;
    }
    f2 = vz.a((float)Math.asin(f2 / f3));
    String str1 = this.d;
    String str2 = "theta is " + f2;
    vx.a(str1, str2);
    if (Float.isNaN(f2))
      return;
    float f5 = localvy1.a;
    float f6 = localvy2.b;
    float f7 = f5 * f6;
    float f8 = localvy1.b;
    float f9 = localvy2.a;
    float f10 = f8 * f9;
    float f11;
    if (f7 - f10 > 0.0F)
      f11 = this.I + f2;
    float f13;
    for (this.I = f11; ; this.I = f13)
    {
      String str3 = this.d;
      String str4 = "rorateAngle is " + f2;
      vx.a(str3, str4);
      if (this.s > 0)
        m();
      long[] arrayOfLong1 = this.ax;
      int i1 = this.az;
      long l1 = arrayOfLong1[i1];
      if (paramLong != l1)
      {
        int i2 = (this.az + 1) % 2;
        this.az = i2;
        long[] arrayOfLong2 = this.ax;
        int i3 = this.az;
        arrayOfLong2[i3] = paramLong;
        float[] arrayOfFloat = this.ay;
        int i4 = this.az;
        float f12 = this.I;
        arrayOfFloat[i4] = f12;
      }
      vu localvu = vu.c;
      this.j = localvu;
      invalidate();
      return;
      f13 = this.I - f2;
    }
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
      if (this.Q == 0)
      {
        int i1 = this.s - 1;
        a(i1);
      }
    while (true)
    {
      if (this.s > 0)
        m();
      vu localvu = vu.c;
      this.j = localvu;
      return;
      int i2 = this.Q - 1;
      a(i2);
      continue;
      int i3 = this.Q;
      int i4 = this.s - 1;
      if (i3 == i4)
      {
        a(0);
        continue;
      }
      int i5 = this.Q + 1;
      a(i5);
    }
  }

  private void b(int paramInt)
  {
    if (this.aG == null)
      return;
    this.aG.a(paramInt);
  }

  private void d()
  {
    Paint localPaint1 = this.r;
    Paint.Style localStyle = Paint.Style.FILL;
    localPaint1.setStyle(localStyle);
    this.r.setTextSize(10.0F);
    this.r.setAntiAlias(1);
    float f1 = -this.t;
    float f2 = -this.t;
    float f3 = this.t;
    float f4 = this.t;
    RectF localRectF = new RectF(f1, f2, f3, f4);
    this.x = localRectF;
    Paint localPaint2 = new Paint();
    this.Y = localPaint2;
    this.Y.setAntiAlias(1);
    this.Y.setColor(-1);
    Paint localPaint3 = this.Y;
    float f5 = this.ah;
    localPaint3.setTextSize(f5);
    Paint localPaint4 = this.Y;
    Paint.Align localAlign1 = Paint.Align.LEFT;
    localPaint4.setTextAlign(localAlign1);
    Paint localPaint5 = new Paint();
    this.Z = localPaint5;
    this.Z.setAntiAlias(1);
    this.Z.setColor(-1);
    Paint localPaint6 = this.Z;
    float f6 = this.ai;
    localPaint6.setTextSize(f6);
    Paint localPaint7 = this.Z;
    Paint.Align localAlign2 = Paint.Align.LEFT;
    localPaint7.setTextAlign(localAlign2);
    Paint localPaint8 = new Paint();
    this.aa = localPaint8;
    this.aa.setAntiAlias(1);
    Paint localPaint9 = this.aa;
    float f7 = this.aj;
    localPaint9.setTextSize(f7);
    Paint localPaint10 = this.aa;
    Paint.Align localAlign3 = Paint.Align.LEFT;
    localPaint10.setTextAlign(localAlign3);
    Paint localPaint11 = new Paint();
    this.ab = localPaint11;
    this.ab.setAntiAlias(1);
    this.ab.setColor(-1);
    Paint localPaint12 = this.ab;
    float f8 = this.ak;
    localPaint12.setTextSize(f8);
    Paint localPaint13 = this.ab;
    Paint.Align localAlign4 = Paint.Align.LEFT;
    localPaint13.setTextAlign(localAlign4);
    this.p.setMinimumFractionDigits(2);
    this.p.setMaximumFractionDigits(2);
  }

  private void e()
  {
    this.Q = 0;
    this.q = 0.0D;
    this.I = 0.0F;
  }

  private void f()
  {
    g();
    vu localvu1 = this.j;
    vu localvu2 = vu.a;
    if (localvu1 == localvu2)
    {
      if (this.D == 0L)
      {
        long l1 = System.nanoTime();
        this.D = l1;
      }
      long l2 = System.nanoTime();
      long l3 = this.D;
      long l4 = l2 - l3;
      long l5 = a(l4);
      vx.a(this.d, "-----------");
      String str1 = this.d;
      String str2 = "intervalTime time is:" + l5;
      vx.a(str1, str2);
      vx.a(this.d, "--------");
      float f1 = (float)l5;
      float f2 = (float)this.F;
      float f3 = Math.min(f1 / f2, 1.0F);
      int i1 = 0;
      float f4 = 0.0F;
      int i2 = 0;
      int i3 = this.s;
      if (i1 < i3)
      {
        Paint localPaint = this.r;
        int[] arrayOfInt = o;
        int i4 = this.T;
        int i5 = i1 % i4;
        int i6 = arrayOfInt[i5];
        localPaint.setColor(i6);
        int i9;
        float f7;
        if (f3 < 1.0F)
        {
          float f5 = this.n.getInterpolation(f3);
          float[] arrayOfFloat1 = this.A;
          int i7 = i1 * 2 + 1;
          int i8 = arrayOfFloat1[i7];
          float f6 = f5 * i8 - f4;
          i9 = i2;
          f7 = f6;
        }
        while (true)
        {
          vx.a(this.d, "           ");
          this.G[i1] = f4;
          this.H[i1] = f7;
          String str3 = this.d;
          StringBuilder localStringBuilder1 = new StringBuilder().append("currentSectorStartAngles is ");
          int i10 = this.G[i1];
          String str4 = i10 + ",currentSectorMovingAngle is " + f7;
          vx.a(str3, str4);
          float f8 = f7 + f4;
          vx.a(this.d, "           ");
          i1 += 1;
          f4 = f8;
          i2 = i9;
          break;
          String str5 = this.d;
          String str6 = "stop sector :" + i1;
          vx.a(str5, str6);
          float f9 = this.z[i1];
          int i11 = i2 + 1;
          float f10 = f9;
          i9 = i11;
          f7 = f10;
        }
      }
      int i12 = this.s;
      if (i2 >= i12)
      {
        h();
        vx.a(this.d, "STOP ANIMATING!");
      }
      long l6 = System.currentTimeMillis();
      String str7 = this.d;
      StringBuilder localStringBuilder2 = new StringBuilder().append("DrawPieChartTime invertal is ");
      String str8 = String.valueOf(System.currentTimeMillis() - l6);
      String str9 = str8;
      vx.a(str7, str9);
      return;
    }
    vu localvu3 = this.j;
    vu localvu4 = vu.b;
    if (localvu3 == localvu4)
    {
      long l7 = System.nanoTime();
      long l8 = this.K;
      float f11 = (float)((l7 - l8) / 1000000L);
      float f12 = (float)this.L;
      float f13 = Math.min(f11 / f12, 1.0F);
      float[] arrayOfFloat2 = this.z;
      int i13 = this.s - 1;
      int i14 = arrayOfFloat2[i13];
      float f14 = this.l.getInterpolation(f13) * i14;
      this.I = f14;
      float f15 = this.I;
      float[] arrayOfFloat3 = this.z;
      int i15 = this.s - 1;
      float f16 = arrayOfFloat3[i15] / 2.0F;
      if (f15 >= f16)
      {
        float[] arrayOfFloat4 = this.z;
        int i16 = this.s - 1;
        float f17 = arrayOfFloat4[i16] / 2.0F;
        this.I = f17;
        j();
      }
      String str10 = this.d;
      StringBuilder localStringBuilder3 = new StringBuilder().append("canvas.rotate(currentCanvasRorateAngle) is ");
      float f18 = this.I;
      String str11 = f18;
      vx.a(str10, str11);
      if (this.s <= 0)
        return;
      m();
      return;
    }
    vu localvu5 = this.j;
    vu localvu6 = vu.c;
    if (localvu5 == localvu6)
    {
      String str12 = this.d;
      StringBuilder localStringBuilder4 = new StringBuilder().append("canvas.rotate(currentCanvasRorateAngle) is ");
      float f19 = this.I;
      String str13 = f19;
      vx.a(str12, str13);
      return;
    }
    vu localvu7 = this.j;
    vu localvu8 = vu.d;
    if (localvu7 != localvu8)
      return;
    long l9 = System.nanoTime();
    long l10 = this.N;
    long l11 = (l9 - l10) / 1000000L;
    float f20 = (float)l11;
    float f21 = this.O;
    float f22 = Math.min(f20 / f21, 1.0F);
    float f23 = this.M;
    float f24 = this.l.getInterpolation(f22) * f23;
    String str14 = this.d;
    String str15 = "adjustAngle is " + f24;
    vx.a(str14, str15);
    long l12 = this.L;
    if (l11 >= l12)
      j();
    while (true)
    {
      String str16 = this.d;
      StringBuilder localStringBuilder5 = new StringBuilder().append("canvas.rotate(currentCanvasRorateAngle) is ");
      float f25 = this.I;
      String str17 = f25;
      vx.a(str16, str17);
      if (this.s <= 0)
        return;
      m();
      return;
      float f26 = this.aH + f24;
      this.I = f26;
    }
  }

  private void g()
  {
  }

  private void h()
  {
    System.gc();
    if (this.g != null)
    {
      this.g.cancel();
      this.g = null;
    }
    if (this.R)
      return;
    i();
  }

  private void i()
  {
    vu localvu = vu.b;
    this.j = localvu;
    if (this.s <= 0)
      return;
    float[] arrayOfFloat = this.z;
    int i1 = this.s - 1;
    float f1 = arrayOfFloat[i1] / 2.0F;
    float f2 = (float)this.L;
    float f3 = f1 / f2;
    this.J = f3;
    long l1 = System.nanoTime();
    this.K = l1;
    Timer localTimer1 = new Timer();
    this.g = localTimer1;
    Timer localTimer2 = this.g;
    vo localvo = new vo(this);
    long l2 = this.E;
    localTimer2.scheduleAtFixedRate(localvo, 0L, l2);
  }

  private void j()
  {
    if (this.g == null)
      return;
    int i1 = this.g.purge();
    this.g.cancel();
    this.g = null;
    this.e.removeMessages(0);
  }

  private void k()
  {
    if (this.s <= 0)
      return;
    j();
    int i1 = this.Q;
    a(i1);
  }

  private void l()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.aD;
    float f1 = (float)(l1 - l2);
    float f2 = Math.abs(this.aC) * f1;
    float f3 = a * f1 * f1 / 2.0F;
    float f4 = f2 - f3;
    String str1 = this.d;
    String str2 = "tick() inverse time is " + f1;
    vx.a(str1, str2);
    String str3 = this.d;
    StringBuilder localStringBuilder1 = new StringBuilder().append("tick() initVelocity is ");
    float f5 = this.aC;
    String str4 = f5;
    vx.a(str3, str4);
    String str5 = this.d;
    StringBuilder localStringBuilder2 = new StringBuilder().append("tick() Math.abs(initVelocity) * time  is ");
    float f6 = Math.abs(this.aC) * f1;
    String str6 = f6;
    vx.a(str5, str6);
    String str7 = this.d;
    StringBuilder localStringBuilder3 = new StringBuilder().append("tick() FRICTION * time * time / 2  is ");
    float f7 = a * f1 * f1 / 2.0F;
    String str8 = f7;
    vx.a(str7, str8);
    String str9 = this.d;
    String str10 = "tick() theta is " + f4;
    vx.a(str9, str10);
    if (this.aI != 0.0F)
    {
      String str11 = this.d;
      StringBuilder localStringBuilder4 = new StringBuilder().append("tick() theta increament is ");
      float f8 = this.aI;
      String str12 = String.valueOf(f4 - f8);
      String str13 = str12;
      vx.a(str11, str13);
    }
    this.aI = f4;
    float f9 = Math.abs(this.aC);
    float f10 = a * f1;
    if (f9 - f10 < 0.0F)
    {
      String str14 = this.d;
      StringBuilder localStringBuilder5 = new StringBuilder().append("Math.abs(initVelocity) - FRICTION * time < 0.0f is  ");
      float f11 = Math.abs(this.aC);
      float f12 = a;
      float f13 = f1 * f12;
      String str15 = String.valueOf(f11 - f13);
      String str16 = str15;
      vx.a(str14, str16);
      j();
      k();
      return;
    }
    float f14;
    if (this.aC < 0.0F)
      f14 = -f4;
    while (true)
    {
      float f15 = this.aH;
      float f16 = f14 + f15;
      this.I = f16;
      vu localvu = vu.c;
      this.j = localvu;
      a();
      m();
      return;
      f14 = f4;
    }
  }

  private void m()
  {
    g();
    float f1 = this.I;
    int i1 = a(f1);
    if ((this.Q != i1) && (this.s > 0))
      this.Q = i1;
    while (true)
    {
      String str1 = this.d;
      StringBuilder localStringBuilder1 = new StringBuilder().append("OnSelectedSectorChanged,selectedSectorIndex is ");
      int i2 = this.Q;
      String str2 = i2;
      vx.a(str1, str2);
      vv localvv1 = this.U;
      int i3 = this.Q;
      String str3 = localvv1.b(i3);
      this.ae = str3;
      float f2 = this.h / 2;
      String str4 = this.ae;
      Paint localPaint1 = this.aa;
      float f3 = a(str4, localPaint1) / 2.0F;
      float f4 = f2 - f3;
      this.ap = f4;
      NumberFormat localNumberFormat = this.p;
      float[] arrayOfFloat = this.B;
      int i4 = this.Q;
      double d1 = arrayOfFloat[i4];
      String str5 = String.valueOf(localNumberFormat.format(d1));
      this.V = str5;
      vv localvv2 = this.U;
      int i5 = this.Q;
      double d2 = localvv2.a(i5);
      StringBuilder localStringBuilder2 = new StringBuilder();
      String str6 = this.V;
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str6).append("%:");
      String str7 = gs.a(d2, null);
      String str8 = str7;
      this.af = str8;
      float f5 = this.h / 2;
      String str9 = this.af;
      Paint localPaint2 = this.ab;
      float f6 = a(str9, localPaint2) / 2.0F;
      float f7 = f5 - f6;
      this.ar = f7;
      int[] arrayOfInt = o;
      int i6 = this.Q;
      int i7 = this.T;
      int i8 = i6 % i7;
      int i9 = arrayOfInt[i8];
      this.ag = i9;
      Paint localPaint3 = this.aa;
      int i10 = this.ag;
      localPaint3.setColor(i10);
      int i11 = this.Q;
      b(i11);
      return;
      if (this.s != 1)
        continue;
      this.Q = 0;
    }
  }

  private void n()
  {
    Timer localTimer1 = new Timer();
    this.g = localTimer1;
    Timer localTimer2 = this.g;
    vr localvr = new vr(this);
    long l1 = this.E;
    localTimer2.scheduleAtFixedRate(localvr, 0L, l1);
  }

  public void a()
  {
    if (!this.f)
      return;
    this.e.a();
  }

  public void a(vs paramvs)
  {
    this.aG = paramvs;
  }

  public void a(vv paramvv, BigDecimal paramBigDecimal)
  {
    this.U = paramvv;
    e();
    int i1 = o.length;
    this.T = i1;
    int i2 = this.U.a();
    this.s = i2;
    float[] arrayOfFloat1 = new float[this.s];
    this.z = arrayOfFloat1;
    float[] arrayOfFloat2 = new float[this.s];
    this.B = arrayOfFloat2;
    float[] arrayOfFloat3 = new float[this.s];
    this.C = arrayOfFloat3;
    float[] arrayOfFloat4 = new float[this.s * 2];
    this.A = arrayOfFloat4;
    float[] arrayOfFloat5 = new float[this.s];
    this.G = arrayOfFloat5;
    float[] arrayOfFloat6 = new float[this.s];
    this.H = arrayOfFloat6;
    if (paramBigDecimal == null)
    {
      int i3 = 0;
      while (true)
      {
        int i4 = this.s;
        if (i3 >= i4)
          break;
        double d1 = this.q;
        double d2 = this.U.a(i3);
        double d3 = d1 + d2;
        this.q = d3;
        i3 += 1;
      }
    }
    double d4 = paramBigDecimal.doubleValue();
    this.q = d4;
    float f1 = 0.0F;
    int i6 = 0;
    while (true)
    {
      int i7 = this.s;
      if (i6 >= i7)
        break;
      double d5 = (float)this.U.a(i6);
      double d6 = this.q;
      double d7 = d5 / d6;
      double d8 = k;
      float f2 = (float)(d7 * d8);
      this.z[i6] = f2;
      float[] arrayOfFloat7 = this.A;
      int i8 = i6 * 2;
      arrayOfFloat7[i8] = f1;
      float[] arrayOfFloat8 = this.A;
      int i9 = i6 * 2 + 1;
      float f3 = f1 + f2;
      arrayOfFloat8[i9] = f3;
      float[] arrayOfFloat9 = this.A;
      int i10 = i6 * 2 + 1;
      int i5 = arrayOfFloat9[i10];
      i6 += 1;
    }
    int i11 = 0;
    while (true)
    {
      int i12 = this.s;
      if (i11 >= i12)
        break;
      float[] arrayOfFloat10 = this.B;
      int i13 = this.z[i11];
      float f4 = k;
      float f5 = i13 / f4;
      float f6 = 100.0F * f5;
      arrayOfFloat10[i11] = f6;
      float[] arrayOfFloat11 = this.C;
      float[] arrayOfFloat12 = this.A;
      int i14 = i11 * 2 + 1;
      int i15 = arrayOfFloat12[i14];
      float f7 = (float)this.F;
      float f8 = i15 / f7;
      arrayOfFloat11[i11] = f8;
      i11 += 1;
    }
    vu localvu = vu.a;
    this.j = localvu;
    String str1 = gs.a(this.q, null);
    this.ad = str1;
    float f9 = this.u;
    String str2 = this.ad;
    Paint localPaint = this.Z;
    float f10 = a(str2, localPaint) / 2.0F;
    float f11 = f9 - f10;
    this.an = f11;
    this.ae = "";
    this.af = "";
    if (this.s == 0);
    for (int i16 = 1; ; i16 = 0)
    {
      this.R = i16;
      if (this.f)
        n();
      System.gc();
      return;
    }
  }

  public void b()
  {
    a(1);
  }

  public void c()
  {
    a(0);
  }

  protected void onAttachedToWindow()
  {
    vx.a(this.d, "onAttachedToWindow onAttachedToWindow()");
    super.onAttachedToWindow();
    if (!this.f)
      n();
    this.f = 1;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.f = 0;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int i1;
    if (paramInt == 21)
    {
      a(1);
      i1 = 1;
    }
    while (true)
    {
      return i1;
      if (paramInt == 22)
      {
        a(0);
        i1 = 1;
        continue;
      }
      boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    }
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    int i4 = View.MeasureSpec.getMode(paramInt2);
    int i5 = this.W.getIntrinsicWidth();
    int i6 = this.W.getIntrinsicHeight();
    float f3;
    if ((i2 != 0) && (i5 < i1))
    {
      float f1 = i5;
      float f2 = i1;
      f3 = f1 / f2;
    }
    while (true)
    {
      float f6;
      if ((i4 != 0) && (i6 < i3))
      {
        float f4 = i6;
        float f5 = i3;
        f6 = f4 / f5;
      }
      while (true)
      {
        float f7 = Math.min(f3, f6);
        int i7 = (int)(i1 * f7);
        this.h = i7;
        int i8 = (int)(i3 * f7);
        this.i = i8;
        int i9 = resolveSize(this.h, paramInt1);
        int i10 = resolveSize(this.i, paramInt2);
        setMeasuredDimension(i9, i10);
        float f8 = this.h / 2.0F;
        this.u = f8;
        float f9 = this.t;
        float f10 = this.y;
        float f11 = f9 + f10;
        this.v = f11;
        vy localvy1 = new vy();
        this.w = localvy1;
        vy localvy2 = this.w;
        float f12 = this.u;
        localvy2.a = f12;
        vy localvy3 = this.w;
        float f13 = this.v;
        localvy3.b = f13;
        float f14 = this.u;
        String str1 = ac;
        Paint localPaint1 = this.Y;
        float f15 = a(str1, localPaint1) / 2.0F;
        float f16 = f14 - f15;
        this.al = f16;
        float f17 = this.u;
        String str2 = this.ad;
        Paint localPaint2 = this.Z;
        float f18 = a(str2, localPaint2) / 2.0F;
        float f19 = f17 - f18;
        this.an = f19;
        float f20 = this.v;
        Paint localPaint3 = this.Z;
        float f21 = a(localPaint3) / 2.0F;
        float f22 = f20 + f21;
        this.ao = f22;
        int i11 = this.X.getIntrinsicWidth() / 2;
        int i12 = this.X.getIntrinsicHeight() / 2;
        Rect localRect = new Rect();
        this.av = localRect;
        int i13 = (int)this.at - i11;
        int i14 = (int)this.au - i12;
        int i15 = (int)this.at;
        int i16 = i11 + i15;
        int i17 = (int)this.au;
        int i18 = i12 + i17;
        this.av.set(i13, i14, i16, i18);
        super.onMeasure(paramInt1, paramInt2);
        return;
        f6 = 1.0F;
      }
      f3 = 1.0F;
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1;
    switch (paramMotionEvent.getAction())
    {
    default:
      i1 = 1;
    case 0:
    case 2:
    case 1:
    }
    float f13;
    while (true)
    {
      return i1;
      if (this.s == 0)
      {
        i1 = 1;
        continue;
      }
      vy localvy1 = this.aB;
      float f1 = paramMotionEvent.getX();
      localvy1.a = f1;
      vy localvy2 = this.aB;
      float f2 = paramMotionEvent.getY();
      localvy2.b = f2;
      long[] arrayOfLong1 = this.ax;
      long[] arrayOfLong2 = this.ax;
      long l1 = System.currentTimeMillis();
      arrayOfLong2[1] = l1;
      arrayOfLong1[0] = l1;
      float[] arrayOfFloat1 = this.ay;
      this.ay[1] = 0;
      arrayOfFloat1[0] = 0;
      this.az = 0;
      long l2 = System.currentTimeMillis();
      this.aE = l2;
      vx.a(this.d, "MotionEvent.ACTION_DOWN");
      j();
      break;
      if (this.s == 0)
      {
        i1 = 1;
        continue;
      }
      vx.a(this.d, "MotionEvent.ACTION_MOVE");
      vy localvy3 = this.aA;
      float f3 = paramMotionEvent.getX();
      localvy3.a = f3;
      vy localvy4 = this.aA;
      float f4 = paramMotionEvent.getY();
      localvy4.b = f4;
      vy localvy5 = this.w;
      vy localvy6 = this.aA;
      float f5 = vz.d(localvy5, localvy6);
      this.aF = f5;
      float f6 = this.aF;
      float f7 = this.t;
      if ((f6 <= f7) && (this.aF > 20.0F))
      {
        long l3 = System.currentTimeMillis();
        String str1 = this.d;
        String str2 = "MotionEvent.ACTION_MOVE,timestamp is " + l3;
        vx.a(str1, str2);
        vy localvy7 = this.aB;
        vy localvy8 = this.aA;
        a(localvy7, localvy8, l3);
        String str3 = this.d;
        StringBuilder localStringBuilder1 = new StringBuilder().append("MotionEvent.ACTION_MOVE,lastAngle[lastIndex]  is ");
        float[] arrayOfFloat2 = this.ay;
        int i2 = this.az;
        int i3 = arrayOfFloat2[i2];
        String str4 = i3;
        vx.a(str3, str4);
      }
      vy localvy9 = this.aB;
      float f8 = this.aA.a;
      localvy9.a = f8;
      vy localvy10 = this.aB;
      float f9 = this.aA.b;
      localvy10.b = f9;
      break;
      if (this.s == 0)
      {
        i1 = 1;
        continue;
      }
      vx.a(this.d, "MotionEvent.ACTION_UP");
      vy localvy11 = this.aA;
      float f10 = paramMotionEvent.getX();
      localvy11.a = f10;
      vy localvy12 = this.aA;
      float f11 = paramMotionEvent.getY();
      localvy12.b = f11;
      long l4 = System.currentTimeMillis();
      String str5 = this.d;
      StringBuilder localStringBuilder2 = new StringBuilder().append("MotionEvent.ACTION_UP lastTime[lastIndex] is ");
      long[] arrayOfLong3 = this.ax;
      int i4 = this.az;
      String str6 = String.valueOf(arrayOfLong3[i4]);
      String str7 = str6;
      vx.a(str5, str7);
      String str8 = this.d;
      StringBuilder localStringBuilder3 = new StringBuilder().append("nowTimeStamp - startTouchTime is ");
      long l5 = this.aE;
      String str9 = String.valueOf(l4 - l5);
      String str10 = str9;
      vx.a(str8, str10);
      long l6 = this.aE;
      if ((float)(l4 - l6) > 250.0F)
      {
        j();
        k();
        break;
      }
      long[] arrayOfLong4 = this.ax;
      int i5 = this.az;
      long l7 = arrayOfLong4[i5];
      long[] arrayOfLong5 = this.ax;
      int i6 = (this.az + 2 - 1) % 2;
      long l8 = arrayOfLong5[i6];
      float f12 = (float)(l7 - l8);
      String str11 = this.d;
      String str12 = "MotionEvent.ACTION_UP inverse mills is " + f12;
      vx.a(str11, str12);
      if (f12 <= 0.0F)
        break;
      String str13 = this.d;
      StringBuilder localStringBuilder4 = new StringBuilder().append("MotionEvent.ACTION_UP lastAngle[lastIndex] is ");
      float[] arrayOfFloat3 = this.ay;
      int i7 = this.az;
      int i8 = arrayOfFloat3[i7];
      String str14 = i8;
      vx.a(str13, str14);
      String str15 = this.d;
      StringBuilder localStringBuilder5 = new StringBuilder().append("MotionEvent.ACTION_UP lastAngle[(lastIndex + LAST_LENGTH - 1) % LAST_LENGTH] is ");
      float[] arrayOfFloat4 = this.ay;
      int i9 = (this.az + 2 - 1) % 2;
      int i10 = arrayOfFloat4[i9];
      String str16 = i10;
      vx.a(str15, str16);
      float[] arrayOfFloat5 = this.ay;
      int i11 = this.az;
      int i12 = arrayOfFloat5[i11];
      float[] arrayOfFloat6 = this.ay;
      int i13 = (this.az + 2 - 1) % 2;
      int i14 = arrayOfFloat6[i13];
      f13 = (i12 - i14) / f12;
      if ((!Float.isNaN(f13)) && (f13 != 0.0F))
        break label959;
      i1 = 1;
    }
    label959: this.aC = f13;
    String str17 = this.d;
    String str18 = "MotionEvent.ACTION_UP veloctiy is " + f13;
    vx.a(str17, str18);
    if (f13 > 1.0F)
      this.aC = 1.0F;
    while (true)
    {
      float f14 = this.I;
      this.aH = f14;
      long l9 = System.currentTimeMillis();
      this.aD = l9;
      Timer localTimer1 = new Timer();
      this.g = localTimer1;
      Timer localTimer2 = this.g;
      vp localvp = new vp(this);
      long l10 = this.E;
      localTimer2.scheduleAtFixedRate(localvp, 0L, l10);
      break;
      if (f13 >= -1.0F)
        continue;
      this.aC = -1.0F;
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     org.achartengine.chart.AnimationPieChartForMymoney
 * JD-Core Version:    0.6.0
 */