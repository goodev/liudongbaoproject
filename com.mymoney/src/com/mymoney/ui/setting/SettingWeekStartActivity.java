package com.mymoney.ui.setting;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import ex;
import g;
import java.util.HashMap;
import java.util.Map;
import k;
import rf;

public class SettingWeekStartActivity extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private static final Map f = new HashMap();
  private Button a;
  private TextView b;
  private Button c;
  private ListView d;
  private k e;

  static
  {
    Map localMap1 = f;
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(0);
    Object localObject1 = localMap1.put(localInteger1, localInteger2);
    Map localMap2 = f;
    Integer localInteger3 = Integer.valueOf(1);
    Integer localInteger4 = Integer.valueOf(1);
    Object localObject2 = localMap2.put(localInteger3, localInteger4);
    Map localMap3 = f;
    Integer localInteger5 = Integer.valueOf(6);
    Integer localInteger6 = Integer.valueOf(2);
    Object localObject3 = localMap3.put(localInteger5, localInteger6);
  }

  public SettingWeekStartActivity()
  {
    k localk = g.a().h();
    this.e = localk;
  }

  private void a()
  {
    Resources localResources = getResources();
    this.b.setText("周开始于");
    this.c.setVisibility(4);
    ListView localListView1 = this.d;
    String[] arrayOfString = localResources.getStringArray(2131165188);
    SettingWeekStartActivity localSettingWeekStartActivity1 = this;
    SettingWeekStartActivity localSettingWeekStartActivity2 = this;
    rf localrf = new rf(localSettingWeekStartActivity1, localSettingWeekStartActivity2, 2130903105, 16908308, arrayOfString);
    localListView1.setAdapter(localrf);
    int i = this.e.m().l();
    Map localMap = f;
    Integer localInteger1 = Integer.valueOf(i);
    Integer localInteger2 = (Integer)localMap.get(localInteger1);
    ListView localListView2 = this.d;
    if (localInteger2 == null);
    for (int j = 1; ; j = localInteger2.intValue())
    {
      localListView2.setItemChecked(j, 1);
      return;
    }
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
    int i = (int)paramLong;
    boolean bool = localk.a(i);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingWeekStartActivity
 * JD-Core Version:    0.6.0
 */