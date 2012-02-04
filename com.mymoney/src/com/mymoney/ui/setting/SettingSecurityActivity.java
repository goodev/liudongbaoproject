package com.mymoney.ui.setting;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import gu;
import hb;
import qu;
import qv;
import qw;
import qx;

public class SettingSecurityActivity extends BaseActivity
  implements View.OnClickListener
{
  private static String a = SettingSecurityActivity.class.getSimpleName();
  private static Context b;
  private Button c;
  private TextView d;
  private Button e;
  private LinearLayout f;
  private CheckBox g;
  private LinearLayout h;
  private LinearLayout i;
  private CheckBox j;

  private void b()
  {
    hb.b(b, "请先开启密码保护,快速记账只能在安全登陆界面使用.");
  }

  public void onClick(View paramView)
  {
    int m;
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230807:
      finish();
      return;
    case 2131231081:
      if (TextUtils.isEmpty(gu.f()))
      {
        showDialog(0);
        return;
      }
      CheckBox localCheckBox1 = this.g;
      if (!this.g.isChecked());
      for (int k = 1; ; m = 0)
      {
        localCheckBox1.setChecked(k);
        gu.a(this.g.isChecked());
        return;
      }
    case 2131231082:
      if (TextUtils.isEmpty(gu.f()))
      {
        showDialog(0);
        return;
      }
      gu.a(this.g.isChecked());
      return;
    case 2131231083:
      if (TextUtils.isEmpty(gu.f()))
      {
        showDialog(0);
        return;
      }
      showDialog(1);
      return;
    case 2131231084:
      if (gu.g())
      {
        CheckBox localCheckBox2 = this.j;
        if (!this.j.isChecked());
        int n;
        for (m = 1; ; n = 0)
        {
          localCheckBox2.setChecked(m);
          gu.c(this.j.isChecked());
          return;
        }
      }
      b();
      return;
    case 2131231085:
    }
    if (gu.g())
    {
      gu.c(this.j.isChecked());
      return;
    }
    b();
    this.j.setChecked(0);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b = this;
    setContentView(2130903100);
    Button localButton1 = (Button)findViewById(2131230807);
    this.c = localButton1;
    TextView localTextView = (TextView)findViewById(2131230730);
    this.d = localTextView;
    Button localButton2 = (Button)findViewById(2131230808);
    this.e = localButton2;
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131231081);
    this.f = localLinearLayout1;
    CheckBox localCheckBox1 = (CheckBox)findViewById(2131231082);
    this.g = localCheckBox1;
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131231083);
    this.h = localLinearLayout2;
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131231084);
    this.i = localLinearLayout3;
    CheckBox localCheckBox2 = (CheckBox)findViewById(2131231085);
    this.j = localCheckBox2;
    this.c.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.d.setText("密码保护");
    this.e.setVisibility(4);
    CheckBox localCheckBox3 = this.g;
    boolean bool1 = gu.g();
    localCheckBox3.setChecked(bool1);
    CheckBox localCheckBox4 = this.j;
    boolean bool2 = gu.i();
    localCheckBox4.setChecked(bool2);
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject = LayoutInflater.from(b);
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 1:
    case 0:
    }
    while (true)
    {
      return localObject;
      View localView1 = ((LayoutInflater)localObject).inflate(2130903103, null);
      EditText localEditText1 = (EditText)localView1.findViewById(2131230932);
      Context localContext1 = b;
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext1).setTitle("密码验证").setView(localView1);
      qv localqv = new qv(this, localEditText1);
      AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton("确定", localqv);
      qu localqu = new qu(this);
      localObject = localBuilder2.setNegativeButton(2131492875, localqu).create();
      continue;
      View localView2 = ((LayoutInflater)localObject).inflate(2130903099, null);
      EditText localEditText2 = (EditText)localView2.findViewById(2131230932);
      EditText localEditText3 = (EditText)localView2.findViewById(2131231080);
      Context localContext2 = b;
      AlertDialog.Builder localBuilder3 = new AlertDialog.Builder(localContext2).setTitle("设置密码").setView(localView2);
      qx localqx = new qx(this, localEditText2, localEditText3);
      AlertDialog.Builder localBuilder4 = localBuilder3.setPositiveButton("设置", localqx);
      qw localqw = new qw(this, localEditText2, localEditText3);
      localObject = localBuilder4.setNegativeButton(2131492875, localqw).create();
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  protected void onPause()
  {
    super.onPause();
  }

  protected void onRestart()
  {
    super.onRestart();
  }

  protected void onResume()
  {
    super.onResume();
  }

  protected void onStart()
  {
    super.onStart();
  }

  protected void onStop()
  {
    super.onStop();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingSecurityActivity
 * JD-Core Version:    0.6.0
 */