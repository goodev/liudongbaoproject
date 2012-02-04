package com.mymoney.ui.widget.wheelview;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import ut;
import uu;
import uv;
import uw;
import ux;
import uy;
import uz;
import va;
import vc;

public class WheelDatePicker extends FrameLayout
{
  public static final String[] a;
  public static final String[] b;
  public static final String[] c;
  public static final String[] d;
  public static final Map e;
  private static final String[] f;
  private WheelView g;
  private WheelView h;
  private WheelView i;
  private uz j;
  private Context k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private boolean r;
  private boolean s;
  private boolean t;
  private String[] u;

  static
  {
    String[] arrayOfString1 = new String[12];
    arrayOfString1[0] = "一月";
    arrayOfString1[1] = "二月";
    arrayOfString1[2] = "三月";
    arrayOfString1[3] = "四月";
    arrayOfString1[4] = "五月";
    arrayOfString1[5] = "六月";
    arrayOfString1[6] = "七月";
    arrayOfString1[7] = "八月";
    arrayOfString1[8] = "九月";
    arrayOfString1[9] = "十月";
    arrayOfString1[10] = "十一月";
    arrayOfString1[11] = "十二月";
    f = arrayOfString1;
    String[] arrayOfString2 = new String[28];
    arrayOfString2[0] = "1日";
    arrayOfString2[1] = "2日";
    arrayOfString2[2] = "3日";
    arrayOfString2[3] = "4日";
    arrayOfString2[4] = "5日";
    arrayOfString2[5] = "6日";
    arrayOfString2[6] = "7日";
    arrayOfString2[7] = "8日";
    arrayOfString2[8] = "9日";
    arrayOfString2[9] = "10日";
    arrayOfString2[10] = "11日";
    arrayOfString2[11] = "12日";
    arrayOfString2[12] = "13日";
    arrayOfString2[13] = "14日";
    arrayOfString2[14] = "15日";
    arrayOfString2[15] = "16日";
    arrayOfString2[16] = "17日";
    arrayOfString2[17] = "18日";
    arrayOfString2[18] = "19日";
    arrayOfString2[19] = "20日";
    arrayOfString2[20] = "21日";
    arrayOfString2[21] = "22日";
    arrayOfString2[22] = "23日";
    arrayOfString2[23] = "24日";
    arrayOfString2[24] = "25日";
    arrayOfString2[25] = "26日";
    arrayOfString2[26] = "27日";
    arrayOfString2[27] = "28日";
    a = arrayOfString2;
    String[] arrayOfString3 = new String[29];
    arrayOfString3[0] = "1日";
    arrayOfString3[1] = "2日";
    arrayOfString3[2] = "3日";
    arrayOfString3[3] = "4日";
    arrayOfString3[4] = "5日";
    arrayOfString3[5] = "6日";
    arrayOfString3[6] = "7日";
    arrayOfString3[7] = "8日";
    arrayOfString3[8] = "9日";
    arrayOfString3[9] = "10日";
    arrayOfString3[10] = "11日";
    arrayOfString3[11] = "12日";
    arrayOfString3[12] = "13日";
    arrayOfString3[13] = "14日";
    arrayOfString3[14] = "15日";
    arrayOfString3[15] = "16日";
    arrayOfString3[16] = "17日";
    arrayOfString3[17] = "18日";
    arrayOfString3[18] = "19日";
    arrayOfString3[19] = "20日";
    arrayOfString3[20] = "21日";
    arrayOfString3[21] = "22日";
    arrayOfString3[22] = "23日";
    arrayOfString3[23] = "24日";
    arrayOfString3[24] = "25日";
    arrayOfString3[25] = "26日";
    arrayOfString3[26] = "27日";
    arrayOfString3[27] = "28日";
    arrayOfString3[28] = "29日";
    b = arrayOfString3;
    String[] arrayOfString4 = new String[30];
    arrayOfString4[0] = "1日";
    arrayOfString4[1] = "2日";
    arrayOfString4[2] = "3日";
    arrayOfString4[3] = "4日";
    arrayOfString4[4] = "5日";
    arrayOfString4[5] = "6日";
    arrayOfString4[6] = "7日";
    arrayOfString4[7] = "8日";
    arrayOfString4[8] = "9日";
    arrayOfString4[9] = "10日";
    arrayOfString4[10] = "11日";
    arrayOfString4[11] = "12日";
    arrayOfString4[12] = "13日";
    arrayOfString4[13] = "14日";
    arrayOfString4[14] = "15日";
    arrayOfString4[15] = "16日";
    arrayOfString4[16] = "17日";
    arrayOfString4[17] = "18日";
    arrayOfString4[18] = "19日";
    arrayOfString4[19] = "20日";
    arrayOfString4[20] = "21日";
    arrayOfString4[21] = "22日";
    arrayOfString4[22] = "23日";
    arrayOfString4[23] = "24日";
    arrayOfString4[24] = "25日";
    arrayOfString4[25] = "26日";
    arrayOfString4[26] = "27日";
    arrayOfString4[27] = "28日";
    arrayOfString4[28] = "29日";
    arrayOfString4[29] = "30日";
    c = arrayOfString4;
    String[] arrayOfString5 = new String[31];
    arrayOfString5[0] = "1日";
    arrayOfString5[1] = "2日";
    arrayOfString5[2] = "3日";
    arrayOfString5[3] = "4日";
    arrayOfString5[4] = "5日";
    arrayOfString5[5] = "6日";
    arrayOfString5[6] = "7日";
    arrayOfString5[7] = "8日";
    arrayOfString5[8] = "9日";
    arrayOfString5[9] = "10日";
    arrayOfString5[10] = "11日";
    arrayOfString5[11] = "12日";
    arrayOfString5[12] = "13日";
    arrayOfString5[13] = "14日";
    arrayOfString5[14] = "15日";
    arrayOfString5[15] = "16日";
    arrayOfString5[16] = "17日";
    arrayOfString5[17] = "18日";
    arrayOfString5[18] = "19日";
    arrayOfString5[19] = "20日";
    arrayOfString5[20] = "21日";
    arrayOfString5[21] = "22日";
    arrayOfString5[22] = "23日";
    arrayOfString5[23] = "24日";
    arrayOfString5[24] = "25日";
    arrayOfString5[25] = "26日";
    arrayOfString5[26] = "27日";
    arrayOfString5[27] = "28日";
    arrayOfString5[28] = "29日";
    arrayOfString5[29] = "30日";
    arrayOfString5[30] = "31日";
    d = arrayOfString5;
    e = new HashMap();
    Map localMap1 = e;
    Integer localInteger1 = Integer.valueOf(28);
    String[] arrayOfString6 = a;
    Object localObject1 = localMap1.put(localInteger1, arrayOfString6);
    Map localMap2 = e;
    Integer localInteger2 = Integer.valueOf(29);
    String[] arrayOfString7 = b;
    Object localObject2 = localMap2.put(localInteger2, arrayOfString7);
    Map localMap3 = e;
    Integer localInteger3 = Integer.valueOf(30);
    String[] arrayOfString8 = c;
    Object localObject3 = localMap3.put(localInteger3, arrayOfString8);
    Map localMap4 = e;
    Integer localInteger4 = Integer.valueOf(31);
    String[] arrayOfString9 = d;
    Object localObject4 = localMap4.put(localInteger4, arrayOfString9);
  }

  public WheelDatePicker(Context paramContext)
  {
    this(paramContext, null);
  }

  public WheelDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public WheelDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    String[] arrayOfString1 = new String['É'];
    this.u = arrayOfString1;
    this.k = paramContext;
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903126, this, 1);
    WheelView localWheelView1 = (WheelView)findViewById(2131231163);
    this.g = localWheelView1;
    WheelView localWheelView2 = (WheelView)findViewById(2131231162);
    this.h = localWheelView2;
    WheelView localWheelView3 = (WheelView)findViewById(2131231161);
    this.i = localWheelView3;
    this.g.a(1);
    this.h.a(1);
    this.i.a(1);
    Calendar localCalendar = Calendar.getInstance();
    int i1 = localCalendar.get(5);
    this.o = i1;
    int i2 = localCalendar.get(2);
    this.p = i2;
    int i3 = localCalendar.get(1);
    this.q = i3;
    int i4 = 1900;
    int i5 = 0;
    int i6 = i4;
    while (i6 <= 2100)
    {
      String[] arrayOfString2 = this.u;
      String str = i6 + "年";
      arrayOfString2[i5] = str;
      i5 += 1;
      i6 += 1;
    }
    WheelView localWheelView4 = this.g;
    ut localut = new ut(this);
    localWheelView4.a(localut);
    WheelView localWheelView5 = this.g;
    uu localuu = new uu(this);
    localWheelView5.a(localuu);
    WheelView localWheelView6 = this.h;
    Context localContext1 = this.k;
    String[] arrayOfString3 = f;
    int i7 = this.p;
    vc localvc1 = new vc(this, localContext1, arrayOfString3, i7);
    localWheelView6.a(localvc1);
    WheelView localWheelView7 = this.h;
    uv localuv = new uv(this);
    localWheelView7.a(localuv);
    WheelView localWheelView8 = this.h;
    uw localuw = new uw(this);
    localWheelView8.a(localuw);
    WheelView localWheelView9 = this.i;
    Context localContext2 = this.k;
    String[] arrayOfString4 = this.u;
    int i8 = this.q - 1;
    vc localvc2 = new vc(this, localContext2, arrayOfString4, i8);
    localWheelView9.a(localvc2);
    WheelView localWheelView10 = this.i;
    ux localux = new ux(this);
    localWheelView10.a(localux);
    WheelView localWheelView11 = this.i;
    uy localuy = new uy(this);
    localWheelView11.a(localuy);
  }

  private void a()
  {
    b();
    WheelView localWheelView1 = this.i;
    int i1 = this.n - 1900;
    localWheelView1.c(i1);
    WheelView localWheelView2 = this.h;
    int i2 = this.m;
    localWheelView2.c(i2);
  }

  private void b()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i1 = this.n;
    int i2 = this.m;
    int i3 = this.l;
    localCalendar.set(i1, i2, i3);
    int i4 = localCalendar.getActualMaximum(5);
    Map localMap = e;
    Integer localInteger = Integer.valueOf(i4);
    String[] arrayOfString = (String[])localMap.get(localInteger);
    WheelView localWheelView1 = this.g;
    Context localContext = this.k;
    int i5 = this.o - 1;
    vc localvc = new vc(this, localContext, arrayOfString, i5);
    localWheelView1.a(localvc);
    WheelView localWheelView2 = this.g;
    int i6 = this.l - 1;
    localWheelView2.c(i6);
  }

  private void c()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i1 = this.n;
    localCalendar.set(1, i1);
    int i2 = this.m;
    localCalendar.set(2, i2);
    int i3 = localCalendar.getActualMaximum(5);
    if (this.l <= i3)
      return;
    this.l = i3;
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, uz paramuz)
  {
    this.n = paramInt1;
    this.m = paramInt2;
    this.l = paramInt3;
    this.j = paramuz;
    a();
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    va localva = (va)paramParcelable;
    Parcelable localParcelable = localva.getSuperState();
    super.onRestoreInstanceState(localParcelable);
    int i1 = localva.a();
    this.n = i1;
    int i2 = localva.b();
    this.m = i2;
    int i3 = localva.c();
    this.l = i3;
  }

  protected Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    int i1 = this.n;
    int i2 = this.m;
    int i3 = this.l;
    return new va(localParcelable, i1, i2, i3, null);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.wheelview.WheelDatePicker
 * JD-Core Version:    0.6.0
 */