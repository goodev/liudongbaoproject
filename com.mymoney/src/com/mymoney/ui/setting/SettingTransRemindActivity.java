package com.mymoney.ui.setting;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import gi;
import gu;

public class SettingTransRemindActivity extends BaseActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private Button a;
  private TextView b;
  private Button c;
  private LinearLayout d;
  private CheckBox e;

  private void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent("com.mymoney.ui.main.ADD_TRANS_REMIND");
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(this, 0, localIntent, 0);
    AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
    if (paramBoolean)
    {
      long l = gi.a("20:00");
      localAlarmManager.setRepeating(0, l, 172800000L, localPendingIntent);
    }
    while (true)
    {
      gu.k(paramBoolean);
      return;
      localAlarmManager.cancel(localPendingIntent);
    }
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    default:
      return;
    case 2131231089:
    }
    a(paramBoolean);
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
    case 2131231088:
    }
    CheckBox localCheckBox = this.e;
    if (!this.e.isChecked());
    int j;
    for (int i = 1; ; j = 0)
    {
      localCheckBox.setChecked(i);
      return;
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903102);
    Button localButton1 = (Button)findViewById(2131230807);
    this.a = localButton1;
    TextView localTextView = (TextView)findViewById(2131230730);
    this.b = localTextView;
    Button localButton2 = (Button)findViewById(2131230808);
    this.c = localButton2;
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131231088);
    this.d = localLinearLayout;
    CheckBox localCheckBox1 = (CheckBox)findViewById(2131231089);
    this.e = localCheckBox1;
    this.a.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnCheckedChangeListener(this);
    this.b.setText("记账提醒");
    this.c.setVisibility(4);
    CheckBox localCheckBox2 = this.e;
    boolean bool = gu.w();
    localCheckBox2.setChecked(bool);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingTransRemindActivity
 * JD-Core Version:    0.6.0
 */