package com.mymoney.ui.security;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.mymoney.ui.addtrans.AddOrEditTransNewActivity;
import com.mymoney.ui.addtrans.AddOrEditTransactionActivity;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.main.MainActivity;
import com.mymoney.ui.transfer.TransferActivity;
import gu;
import gy;
import hb;
import nk;

public class SecurityActivity extends BaseActivity
  implements View.OnClickListener, TextView.OnEditorActionListener
{
  public String a;
  private Context b;
  private boolean c;
  private Button d;
  private Button e;
  private Button f;
  private EditText g;
  private Button h;
  private Button i;

  public SecurityActivity()
  {
    String str = SecurityActivity.class.getSimpleName();
    this.a = str;
    this.c = 0;
  }

  private void a()
  {
    hb.b(this.b, "对不起,你尚未开启快速记账模式,到设置里开启即可.");
  }

  private void b()
  {
    Context localContext = this.b;
    Intent localIntent = new Intent(localContext, MainActivity.class);
    startActivity(localIntent);
    finish();
  }

  private void c()
  {
    if (gu.h())
    {
      Context localContext1 = this.b;
      Intent localIntent1 = new Intent(localContext1, AddOrEditTransNewActivity.class);
      Intent localIntent2 = localIntent1.putExtra("state", 1);
      Intent localIntent3 = localIntent1.putExtra("transType", 1);
      Intent localIntent4 = localIntent1.putExtra("isFromSecurityLogin", 1);
      startActivity(localIntent1);
      return;
    }
    Context localContext2 = this.b;
    Intent localIntent5 = new Intent(localContext2, AddOrEditTransactionActivity.class);
    Intent localIntent6 = localIntent5.putExtra("state", 2);
    Intent localIntent7 = localIntent5.putExtra("transType", 1);
    Intent localIntent8 = localIntent5.putExtra("isFromSecurityLogin", 1);
    startActivity(localIntent5);
  }

  private void d()
  {
    if (gu.h())
    {
      Context localContext1 = this.b;
      Intent localIntent1 = new Intent(localContext1, AddOrEditTransNewActivity.class);
      Intent localIntent2 = localIntent1.putExtra("state", 1);
      Intent localIntent3 = localIntent1.putExtra("transType", 0);
      Intent localIntent4 = localIntent1.putExtra("isFromSecurityLogin", 1);
      startActivity(localIntent1);
      return;
    }
    Context localContext2 = this.b;
    Intent localIntent5 = new Intent(localContext2, AddOrEditTransactionActivity.class);
    Intent localIntent6 = localIntent5.putExtra("state", 2);
    Intent localIntent7 = localIntent5.putExtra("transType", 0);
    Intent localIntent8 = localIntent5.putExtra("isFromSecurityLogin", 1);
    startActivity(localIntent5);
  }

  private void e()
  {
    Context localContext = this.b;
    a(localContext, TransferActivity.class);
  }

  private void f()
  {
    String str1 = this.g.getText().toString();
    String str2 = gu.f();
    if (str1.equalsIgnoreCase(str2))
    {
      b();
      return;
    }
    if (TextUtils.isEmpty(str1))
    {
      hb.b(this.b, "密码不能为空.");
      return;
    }
    hb.b(this.b, "对不起,密码错误.");
    this.g.setText("");
  }

  private void g()
  {
    gy.a("demo");
    b();
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131230932:
    default:
      return;
    case 2131230929:
      if (this.c)
      {
        c();
        return;
      }
      a();
      return;
    case 2131230930:
      if (this.c)
      {
        d();
        return;
      }
      a();
      return;
    case 2131230931:
      if (this.c)
      {
        e();
        return;
      }
      a();
      return;
    case 2131230933:
      f();
      return;
    case 2131230928:
    }
    g();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    nk localnk = new nk(this, this);
    View localView = getLayoutInflater().inflate(2130903079, localnk);
    setContentView(localnk);
    this.b = this;
    Button localButton1 = (Button)findViewById(2131230929);
    this.d = localButton1;
    Button localButton2 = (Button)findViewById(2131230930);
    this.e = localButton2;
    Button localButton3 = (Button)findViewById(2131230931);
    this.f = localButton3;
    EditText localEditText = (EditText)findViewById(2131230932);
    this.g = localEditText;
    Button localButton4 = (Button)findViewById(2131230933);
    this.h = localButton4;
    Button localButton5 = (Button)findViewById(2131230928);
    this.i = localButton5;
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.g.setOnEditorActionListener(this);
    this.i.setOnClickListener(this);
    boolean bool = gu.i();
    this.c = bool;
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramTextView.getId())
    {
    default:
    case 2131230932:
    }
    for (int j = 0; ; j = 1)
    {
      return j;
      if (paramInt != 6)
        break;
      boolean bool = this.h.performClick();
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int j;
    if (66 == paramInt)
    {
      boolean bool1 = this.h.performClick();
      j = 1;
    }
    while (true)
    {
      return j;
      if (4 == paramInt)
      {
        finish();
        Process.killProcess(Process.myPid());
        j = 1;
        continue;
      }
      boolean bool2 = super.onKeyDown(paramInt, paramKeyEvent);
    }
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
 * Qualified Name:     com.mymoney.ui.security.SecurityActivity
 * JD-Core Version:    0.6.0
 */