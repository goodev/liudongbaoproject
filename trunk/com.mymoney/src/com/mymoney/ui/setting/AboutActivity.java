package com.mymoney.ui.setting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import gt;
import nl;
import nm;
import nn;
import no;

public class AboutActivity extends BaseActivity
  implements View.OnClickListener
{
  private Button a;
  private TextView b;
  private Button c;
  private TextView d;
  private LinearLayout e;
  private TextView f;
  private RelativeLayout g;
  private Button h;

  private void a(String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
    startActivity(localIntent);
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
    case 2131230727:
      if (!gt.n())
        return;
      Uri localUri1 = Uri.parse("http://m.appchina.com");
      Intent localIntent1 = new Intent("android.intent.action.VIEW", localUri1);
      startActivity(localIntent1);
      return;
    case 2131230728:
    }
    if (!gt.j())
      return;
    Uri localUri2 = Uri.parse("http://shouji.360.cn/partner/html/101183.and.html");
    Intent localIntent2 = new Intent("android.intent.action.VIEW", localUri2);
    startActivity(localIntent2);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    Button localButton1 = (Button)findViewById(2131230807);
    this.a = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.b = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.c = localButton2;
    TextView localTextView2 = (TextView)findViewById(2131230724);
    this.d = localTextView2;
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131230725);
    this.e = localLinearLayout;
    TextView localTextView3 = (TextView)findViewById(2131230726);
    this.f = localTextView3;
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131230727);
    this.g = localRelativeLayout;
    Button localButton3 = (Button)findViewById(2131230728);
    this.h = localButton3;
    this.a.setOnClickListener(this);
    this.g.setOnClickListener(this);
    if (gt.i())
    {
      this.f.setText("安卓专版  www.hiapk.com");
      TextView localTextView4 = this.f;
      nl localnl = new nl(this);
      localTextView4.setOnClickListener(localnl);
    }
    while (true)
    {
      TextView localTextView5 = this.d;
      StringBuilder localStringBuilder = new StringBuilder().append("版本 ");
      String str1 = gt.e();
      String str2 = str1;
      localTextView5.setText(str2);
      this.b.setText("关于");
      this.c.setVisibility(4);
      return;
      if (gt.k())
      {
        this.f.setText("机锋专版  下载机锋市场");
        TextView localTextView6 = this.f;
        nm localnm = new nm(this);
        localTextView6.setOnClickListener(localnm);
        continue;
      }
      if (gt.l())
      {
        this.f.setText("十字猫手机资源站  wap.crossmo.com");
        TextView localTextView7 = this.f;
        nn localnn = new nn(this);
        localTextView7.setOnClickListener(localnn);
        continue;
      }
      if (gt.h())
      {
        this.f.setText("魅族HD专版  meizu.com");
        TextView localTextView8 = this.f;
        no localno = new no(this);
        localTextView8.setOnClickListener(localno);
        continue;
      }
      if (gt.j())
      {
        this.g.setBackgroundResource(2130837907);
        this.g.setVisibility(0);
        continue;
      }
      if (!gt.n())
        continue;
      this.g.setBackgroundResource(2130837908);
      this.g.setVisibility(0);
      this.h.setVisibility(8);
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623946, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131231186:
    }
    while (true)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      finish();
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.AboutActivity
 * JD-Core Version:    0.6.0
 */