package com.mymoney.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import g;
import hb;
import hk;
import j;
import java.text.DecimalFormat;

public class SettingCurrencyRateEditActivity extends BaseActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static Context b;
  DecimalFormat a;
  private Button c;
  private TextView d;
  private Button e;
  private LinearLayout f;
  private CheckBox g;
  private LinearLayout h;
  private EditText i;
  private j j;
  private long k;
  private boolean l;
  private double n;

  public SettingCurrencyRateEditActivity()
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("0.0000");
    this.a = localDecimalFormat;
    j localj = g.a().k();
    this.j = localj;
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setBackgroundResource(2130838044);
      this.g.setChecked(1);
      this.h.setVisibility(0);
      return;
    }
    this.f.setBackgroundResource(2130837602);
    this.g.setChecked(0);
    this.h.setVisibility(4);
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    default:
      return;
    case 2131231067:
    }
    if (this.g.isChecked())
    {
      this.f.setBackgroundResource(2130838044);
      this.h.setVisibility(0);
      return;
    }
    this.f.setBackgroundResource(2130837602);
    this.h.setVisibility(4);
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
    case 2131230808:
      double d1 = Double.valueOf(this.i.getText().toString()).doubleValue();
      this.n = d1;
      boolean bool1 = this.g.isChecked();
      this.l = bool1;
      j localj = this.j;
      long l1 = this.k;
      double d2 = this.n;
      boolean bool2 = this.l;
      if (localj.a(l1, d2, bool2))
      {
        finish();
        return;
      }
      hb.a(b, "保存失败！");
      return;
    case 2131231066:
    }
    CheckBox localCheckBox = this.g;
    if (!this.g.isChecked());
    int i1;
    for (int m = 1; ; i1 = 0)
    {
      localCheckBox.setChecked(m);
      if (!this.g.isChecked())
        break;
      this.f.setBackgroundResource(2130838044);
      this.h.setVisibility(0);
      return;
    }
    this.f.setBackgroundResource(2130837602);
    this.h.setVisibility(4);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b = this;
    setContentView(2130903090);
    Button localButton1 = (Button)findViewById(2131230807);
    this.c = localButton1;
    TextView localTextView = (TextView)findViewById(2131230730);
    this.d = localTextView;
    Button localButton2 = (Button)findViewById(2131230808);
    this.e = localButton2;
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131231066);
    this.f = localLinearLayout1;
    CheckBox localCheckBox1 = (CheckBox)findViewById(2131231067);
    this.g = localCheckBox1;
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131231068);
    this.h = localLinearLayout2;
    EditText localEditText1 = (EditText)findViewById(2131231069);
    this.i = localEditText1;
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnCheckedChangeListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    long l1 = getIntent().getLongExtra("exchangePOID", 0L);
    this.k = l1;
    if (this.k == 0L)
    {
      hb.b(b, "参数错误");
      finish();
    }
    j localj = this.j;
    long l2 = this.k;
    hk localhk = localj.b(l2);
    boolean bool1 = localhk.f();
    this.l = bool1;
    double d1 = localhk.e();
    this.n = d1;
    CheckBox localCheckBox2 = this.g;
    boolean bool2 = this.l;
    localCheckBox2.setChecked(bool2);
    EditText localEditText2 = this.i;
    DecimalFormat localDecimalFormat = this.a;
    double d2 = this.n;
    String str = localDecimalFormat.format(d2);
    localEditText2.setText(str);
    boolean bool3 = this.l;
    a(bool3);
    this.d.setText("汇率编辑");
    this.e.setText("保存");
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingCurrencyRateEditActivity
 * JD-Core Version:    0.6.0
 */