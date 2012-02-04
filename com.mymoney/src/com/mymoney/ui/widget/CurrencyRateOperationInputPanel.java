package com.mymoney.ui.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import gs;
import te;
import tf;
import tg;
import th;
import uh;

public class CurrencyRateOperationInputPanel extends RelativeLayout
  implements RadioGroup.OnCheckedChangeListener
{
  public static String a = "0";
  public static String b = "0.00";
  private View c;
  private TextView d;
  private boolean e;
  private boolean f;
  private tg g;
  private tf h;
  private th i;
  private CurrencyRateOperationInputPanel.OnDigitInputFinishListener j;
  private ImageView k;
  private RelativeLayout l;
  private int m;
  private int n;
  private CurrencyRateOperationInputPanel.OnCheckedChangeListener o;
  private LinearLayout p;
  private String q;
  private String r;
  private String s;
  private Button t;
  private Button u;
  private Button v;
  private RadioGroup w;
  private boolean x;
  private Handler y;

  public CurrencyRateOperationInputPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    tg localtg = new tg(this, null);
    this.g = localtg;
    tf localtf = new tf(this, null);
    this.h = localtf;
    th localth = new th(this, null);
    this.i = localth;
    this.q = "";
    this.r = "";
    this.s = "";
    this.x = 0;
    te localte = new te(this);
    this.y = localte;
    View localView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903125, this, 1);
    this.c = localView;
    b();
  }

  private void a(int paramInt1, int paramInt2)
  {
    this.m = paramInt2;
    float f1 = this.n;
    float f2 = paramInt1;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, f1, f2);
    this.n = paramInt1;
    localTranslateAnimation.setDuration(250L);
    localTranslateAnimation.setFillAfter(1);
    this.k.startAnimation(localTranslateAnimation);
  }

  private void b()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131231137);
    this.p = localLinearLayout;
    Button localButton1 = (Button)this.c.findViewById(2131231147);
    tg localtg1 = this.g;
    localButton1.setOnClickListener(localtg1);
    Button localButton2 = (Button)this.c.findViewById(2131231148);
    tg localtg2 = this.g;
    localButton2.setOnClickListener(localtg2);
    Button localButton3 = (Button)this.c.findViewById(2131231149);
    tg localtg3 = this.g;
    localButton3.setOnClickListener(localtg3);
    Button localButton4 = (Button)this.c.findViewById(2131231143);
    tg localtg4 = this.g;
    localButton4.setOnClickListener(localtg4);
    Button localButton5 = (Button)this.c.findViewById(2131231144);
    tg localtg5 = this.g;
    localButton5.setOnClickListener(localtg5);
    Button localButton6 = (Button)this.c.findViewById(2131231145);
    tg localtg6 = this.g;
    localButton6.setOnClickListener(localtg6);
    Button localButton7 = (Button)this.c.findViewById(2131231139);
    tg localtg7 = this.g;
    localButton7.setOnClickListener(localtg7);
    Button localButton8 = (Button)this.c.findViewById(2131231140);
    tg localtg8 = this.g;
    localButton8.setOnClickListener(localtg8);
    Button localButton9 = (Button)this.c.findViewById(2131231141);
    tg localtg9 = this.g;
    localButton9.setOnClickListener(localtg9);
    Button localButton10 = (Button)this.c.findViewById(2131231153);
    tg localtg10 = this.g;
    localButton10.setOnClickListener(localtg10);
    Button localButton11 = (Button)this.c.findViewById(2131231152);
    tf localtf1 = this.h;
    localButton11.setOnClickListener(localtf1);
    Button localButton12 = (Button)this.c.findViewById(2131231151);
    this.t = localButton12;
    Button localButton13 = this.t;
    tf localtf2 = this.h;
    localButton13.setOnClickListener(localtf2);
    Button localButton14 = (Button)this.c.findViewById(2131231154);
    this.v = localButton14;
    Button localButton15 = this.v;
    tf localtf3 = this.h;
    localButton15.setOnClickListener(localtf3);
    Button localButton16 = (Button)this.c.findViewById(2131231158);
    th localth1 = this.i;
    localButton16.setOnClickListener(localth1);
    Button localButton17 = (Button)this.c.findViewById(2131231157);
    th localth2 = this.i;
    localButton17.setOnClickListener(localth2);
    Button localButton18 = (Button)this.c.findViewById(2131231159);
    this.u = localButton18;
    Button localButton19 = this.u;
    th localth3 = this.i;
    localButton19.setOnClickListener(localth3);
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131231155);
    this.l = localRelativeLayout;
    ImageView localImageView = (ImageView)findViewById(2131231156);
    this.k = localImageView;
    RadioGroup localRadioGroup = (RadioGroup)findViewById(2131230731);
    this.w = localRadioGroup;
    this.w.setOnCheckedChangeListener(this);
    this.m = 2131230732;
  }

  private void b(int paramInt)
  {
    if (paramInt == 1)
    {
      this.w.check(2131230733);
      return;
    }
    this.w.check(2131230732);
  }

  private void c()
  {
    TextView localTextView1 = this.d;
    TextView localTextView2 = this.d;
    uh localuh = new uh(localTextView2);
    localTextView1.addTextChangedListener(localuh);
  }

  private boolean d()
  {
    return this.d instanceof EditText;
  }

  private void e()
  {
    TextView localTextView = this.d;
    String str = a;
    localTextView.setText(str);
    this.e = 0;
    this.q = "";
    this.r = "";
    this.s = "";
    this.v.setVisibility(0);
    this.u.setVisibility(8);
  }

  private void f()
  {
    double d1 = Double.valueOf(this.q).doubleValue();
    String str1;
    double d2;
    if (this.r.equals(""))
    {
      str1 = this.q;
      this.r = str1;
      d2 = Double.valueOf(this.r).doubleValue();
      if (!this.s.equals("+"))
        break label107;
      String str2 = gs.a(d1 + d2);
      this.q = str2;
    }
    while (true)
    {
      TextView localTextView = this.d;
      String str3 = this.q;
      localTextView.setText(str3);
      this.r = "";
      return;
      str1 = this.r;
      break;
      label107: if (!this.s.equals("-"))
        continue;
      String str4 = gs.a(d1 - d2);
      this.q = str4;
    }
  }

  private void g()
  {
    if (!this.x)
      return;
    this.x = 0;
    boolean bool = this.t.performClick();
  }

  public void a()
  {
    boolean bool = this.y.sendEmptyMessage(1);
  }

  public void a(int paramInt)
  {
    Handler localHandler = this.y;
    Integer localInteger = Integer.valueOf(paramInt);
    Message.obtain(localHandler, 3, localInteger).sendToTarget();
  }

  public void a(Button paramButton)
  {
    this.d = paramButton;
    c();
  }

  public void a(CurrencyRateOperationInputPanel.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.o = paramOnCheckedChangeListener;
  }

  public void a(CurrencyRateOperationInputPanel.OnDigitInputFinishListener paramOnDigitInputFinishListener)
  {
    this.j = paramOnDigitInputFinishListener;
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public void b(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }

  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 2131230732:
      if (this.m == 2131230732)
        return;
      a(0, paramInt);
      if (this.o == null)
        return;
      this.o.a(paramRadioGroup, paramInt, 0);
      return;
    case 2131230733:
      if (this.m == 2131230733)
        return;
      int i1 = this.l.getHeight() / 3;
      a(i1, paramInt);
      if (this.o == null)
        return;
      this.o.a(paramRadioGroup, paramInt, 1);
      return;
    case 2131230781:
    }
    if (this.o == null)
      return;
    this.o.a(paramRadioGroup, paramInt, 2);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.widget.CurrencyRateOperationInputPanel
 * JD-Core Version:    0.6.0
 */