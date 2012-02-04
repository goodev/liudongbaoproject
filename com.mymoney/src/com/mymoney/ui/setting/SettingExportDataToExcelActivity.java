package com.mymoney.ui.setting;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import ep;
import g;
import gt;
import hb;
import k;
import qf;

public class SettingExportDataToExcelActivity extends BaseActivity
  implements View.OnClickListener
{
  public static String a = "SettingExportDataToExcel";
  private Context b;
  private Button c;
  private TextView d;
  private Button e;
  private LinearLayout f;
  private LinearLayout g;
  private TextView h;
  private boolean i = 0;
  private k j;

  public SettingExportDataToExcelActivity()
  {
    k localk = g.a().h();
    this.j = localk;
  }

  private void a()
  {
    qf localqf = new qf(this);
    String[] arrayOfString = new String[0];
    AsyncTask localAsyncTask = localqf.execute(arrayOfString);
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
    case 2131231074:
      if (ep.a())
      {
        this.i = 0;
        a();
        return;
      }
      hb.b(this.b, "sd卡不可用.");
      return;
    case 2131231075:
    }
    if (ep.a())
    {
      this.i = 1;
      a();
      return;
    }
    hb.b(this.b, "sd卡不可用.");
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903096);
    this.b = this;
    Button localButton1 = (Button)findViewById(2131230807);
    this.c = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.d = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.e = localButton2;
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131231074);
    this.f = localLinearLayout1;
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131231075);
    this.g = localLinearLayout2;
    TextView localTextView2 = (TextView)findViewById(2131231076);
    this.h = localTextView2;
    this.c.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.d.setText("导出数据");
    this.e.setVisibility(4);
    if (gt.g())
      this.g.setVisibility(8);
    TextView localTextView3 = this.h;
    Spanned localSpanned = Html.fromHtml(this.b.getResources().getString(2131492909));
    localTextView3.setText(localSpanned);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingExportDataToExcelActivity
 * JD-Core Version:    0.6.0
 */