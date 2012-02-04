package com.mymoney.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.text.DecimalFormat;
import tc;
import td;

public class CurrencyRateInputPanel extends RelativeLayout
{
  public static String a = "0";
  public static String b = "0.00";
  private View c;
  private TextView d;
  private boolean e;
  private boolean f;
  private DecimalFormat g;
  private td h;
  private tc i;
  private CurrencyRateInputPanel.OnDigitInputFinishListener j;

  public CurrencyRateInputPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    DecimalFormat localDecimalFormat = new DecimalFormat("#,##0.00");
    this.g = localDecimalFormat;
    td localtd = new td(this, null);
    this.h = localtd;
    tc localtc = new tc(this, null);
    this.i = localtc;
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903124, this, 1);
    this.c = localView;
    a();
  }

  private void a()
  {
    Button localButton1 = (Button)this.c.findViewById(2131231147);
    td localtd1 = this.h;
    localButton1.setOnClickListener(localtd1);
    Button localButton2 = (Button)this.c.findViewById(2131231148);
    td localtd2 = this.h;
    localButton2.setOnClickListener(localtd2);
    Button localButton3 = (Button)this.c.findViewById(2131231149);
    td localtd3 = this.h;
    localButton3.setOnClickListener(localtd3);
    Button localButton4 = (Button)this.c.findViewById(2131231143);
    td localtd4 = this.h;
    localButton4.setOnClickListener(localtd4);
    Button localButton5 = (Button)this.c.findViewById(2131231144);
    td localtd5 = this.h;
    localButton5.setOnClickListener(localtd5);
    Button localButton6 = (Button)this.c.findViewById(2131231145);
    td localtd6 = this.h;
    localButton6.setOnClickListener(localtd6);
    Button localButton7 = (Button)this.c.findViewById(2131231139);
    td localtd7 = this.h;
    localButton7.setOnClickListener(localtd7);
    Button localButton8 = (Button)this.c.findViewById(2131231140);
    td localtd8 = this.h;
    localButton8.setOnClickListener(localtd8);
    Button localButton9 = (Button)this.c.findViewById(2131231141);
    td localtd9 = this.h;
    localButton9.setOnClickListener(localtd9);
    Button localButton10 = (Button)this.c.findViewById(2131231153);
    td localtd10 = this.h;
    localButton10.setOnClickListener(localtd10);
    Button localButton11 = (Button)this.c.findViewById(2131231152);
    tc localtc1 = this.i;
    localButton11.setOnClickListener(localtc1);
    Button localButton12 = (Button)this.c.findViewById(2131231151);
    tc localtc2 = this.i;
    localButton12.setOnClickListener(localtc2);
    Button localButton13 = (Button)this.c.findViewById(2131231154);
    tc localtc3 = this.i;
    localButton13.setOnClickListener(localtc3);
  }

  private boolean b()
  {
    return this.d instanceof EditText;
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.CurrencyRateInputPanel
 * JD-Core Version:    0.6.0
 */