package com.mymoney.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import java.text.DecimalFormat;
import tj;
import tk;

public class DigitKeypad extends LinearLayout
{
  private static final String a = DigitKeypad.class.getSimpleName();
  private static int b = 10000000;
  private static String c = ".";
  private boolean d = 0;
  private Button e;
  private View f;
  private tk g;
  private tj h;
  private DigitKeypad.OnCancelListener i;
  private DigitKeypad.OnFinishListener j;
  private DecimalFormat k;
  private DecimalFormat l;
  private DecimalFormat m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private boolean s;
  private double t;

  public DigitKeypad(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    tk localtk = new tk(this, null);
    this.g = localtk;
    tj localtj = new tj(this, null);
    this.h = localtj;
    DecimalFormat localDecimalFormat1 = new DecimalFormat("#,##0");
    this.k = localDecimalFormat1;
    DecimalFormat localDecimalFormat2 = new DecimalFormat("#,##0.0");
    this.l = localDecimalFormat2;
    DecimalFormat localDecimalFormat3 = new DecimalFormat("#,##0.00");
    this.m = localDecimalFormat3;
    this.n = 2;
    this.o = 0;
    this.p = 1;
    this.q = 0;
    this.r = 1;
    this.s = 0;
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903127, this, 1);
    this.f = localView;
    c();
  }

  private void c()
  {
    Button localButton1 = (Button)this.f.findViewById(2131231165);
    this.e = localButton1;
    Button localButton2 = (Button)this.f.findViewById(2131231147);
    tk localtk1 = this.g;
    localButton2.setOnClickListener(localtk1);
    Button localButton3 = (Button)this.f.findViewById(2131231148);
    tk localtk2 = this.g;
    localButton3.setOnClickListener(localtk2);
    Button localButton4 = (Button)this.f.findViewById(2131231149);
    tk localtk3 = this.g;
    localButton4.setOnClickListener(localtk3);
    Button localButton5 = (Button)this.f.findViewById(2131231143);
    tk localtk4 = this.g;
    localButton5.setOnClickListener(localtk4);
    Button localButton6 = (Button)this.f.findViewById(2131231144);
    tk localtk5 = this.g;
    localButton6.setOnClickListener(localtk5);
    Button localButton7 = (Button)this.f.findViewById(2131231145);
    tk localtk6 = this.g;
    localButton7.setOnClickListener(localtk6);
    Button localButton8 = (Button)this.f.findViewById(2131231139);
    tk localtk7 = this.g;
    localButton8.setOnClickListener(localtk7);
    Button localButton9 = (Button)this.f.findViewById(2131231140);
    tk localtk8 = this.g;
    localButton9.setOnClickListener(localtk8);
    Button localButton10 = (Button)this.f.findViewById(2131231141);
    tk localtk9 = this.g;
    localButton10.setOnClickListener(localtk9);
    Button localButton11 = (Button)this.f.findViewById(2131231152);
    tj localtj1 = this.h;
    localButton11.setOnClickListener(localtj1);
    Button localButton12 = (Button)this.f.findViewById(2131231153);
    tk localtk10 = this.g;
    localButton12.setOnClickListener(localtk10);
    Button localButton13 = (Button)this.f.findViewById(2131231166);
    tj localtj2 = this.h;
    localButton13.setOnClickListener(localtj2);
    Button localButton14 = (Button)this.f.findViewById(2131231167);
    tj localtj3 = this.h;
    localButton14.setOnClickListener(localtj3);
    Button localButton15 = (Button)this.f.findViewById(2131231168);
    tj localtj4 = this.h;
    localButton15.setOnClickListener(localtj4);
    Button localButton16 = (Button)this.f.findViewById(2131231169);
    tj localtj5 = this.h;
    localButton16.setOnClickListener(localtj5);
  }

  private void d()
  {
    this.o = 0;
    this.p = 1;
    this.q = 0;
    this.r = 1;
    this.s = 0;
    this.t = 0.0D;
    this.e.setText("0");
  }

  public void a(DigitKeypad.OnCancelListener paramOnCancelListener)
  {
    this.i = paramOnCancelListener;
  }

  public void a(DigitKeypad.OnFinishListener paramOnFinishListener)
  {
    this.j = paramOnFinishListener;
  }

  public void a(String paramString)
  {
    d();
    this.e.setText(paramString);
  }

  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public boolean a()
  {
    return this.d;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.DigitKeypad
 * JD-Core Version:    0.6.0
 */