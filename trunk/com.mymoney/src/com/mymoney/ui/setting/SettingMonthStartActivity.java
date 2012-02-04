package com.mymoney.ui.setting;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import ex;
import g;
import k;

public class SettingMonthStartActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private Button a;
  private TextView b;
  private Button c;
  private ListView d;
  private k e;

  public SettingMonthStartActivity()
  {
    k localk = g.a().h();
    this.e = localk;
  }

  private void a()
  {
    Resources localResources = getResources();
    this.b.setText("月开始于");
    this.c.setVisibility(4);
    ListView localListView1 = this.d;
    String[] arrayOfString = localResources.getStringArray(2131165189);
    ArrayAdapter localArrayAdapter = new ArrayAdapter(this, 2130903105, 16908308, arrayOfString);
    localListView1.setAdapter(localArrayAdapter);
    int i = this.e.m().m();
    ListView localListView2 = this.d;
    int j = i - 1;
    localListView2.setItemChecked(j, 1);
  }

  private void b()
  {
    this.a.setOnClickListener(this);
    this.d.setOnItemClickListener(this);
  }

  private void c()
  {
    Button localButton1 = (Button)findViewById(2131230807);
    this.a = localButton1;
    TextView localTextView = (TextView)findViewById(2131230730);
    this.b = localTextView;
    Button localButton2 = (Button)findViewById(2131230808);
    this.c = localButton2;
    ListView localListView = (ListView)findViewById(2131231079);
    this.d = localListView;
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230807:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903098);
    c();
    b();
    a();
  }

  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    k localk = this.e;
    int i = paramInt + 1;
    boolean bool = localk.b(i);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingMonthStartActivity
 * JD-Core Version:    0.6.0
 */