package com.mymoney.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import gj;
import gu;

public class AddTransModeSwitchActivity extends Activity
  implements View.OnClickListener
{
  public static String a = "addTransModeSwitchActivity";
  private Button b;
  private TextView c;
  private Button d;
  private LinearLayout e;
  private CheckBox f;

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230807:
      finish();
      return;
    case 2131231051:
      CheckBox localCheckBox = this.f;
      if (!this.f.isChecked());
      int j;
      for (int i = 1; ; j = 0)
      {
        localCheckBox.setChecked(i);
        gu.b(this.f.isChecked());
        return;
      }
    case 2131231052:
    }
    gj.a(a, "new_mode_or_not_cb#onClick()");
    gu.b(this.f.isChecked());
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903086);
    Button localButton1 = (Button)findViewById(2131230807);
    this.b = localButton1;
    TextView localTextView = (TextView)findViewById(2131230730);
    this.c = localTextView;
    Button localButton2 = (Button)findViewById(2131230808);
    this.d = localButton2;
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131231051);
    this.e = localLinearLayout;
    CheckBox localCheckBox1 = (CheckBox)findViewById(2131231052);
    this.f = localCheckBox1;
    this.b.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.d.setVisibility(4);
    CheckBox localCheckBox2 = this.f;
    boolean bool = gu.h();
    localCheckBox2.setChecked(bool);
    this.c.setText("记账模式");
  }

  protected void onDestroy()
  {
    gu.b(this.f.isChecked());
    super.onDestroy();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.AddTransModeSwitchActivity
 * JD-Core Version:    0.6.0
 */