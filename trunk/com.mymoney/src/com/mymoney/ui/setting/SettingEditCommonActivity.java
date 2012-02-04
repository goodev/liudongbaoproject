package com.mymoney.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.core.vo.CorporationVo;
import com.mymoney.ui.base.BaseActivity;
import e;
import fa;
import g;
import gx;
import h;
import hb;
import i;
import y;

public class SettingEditCommonActivity extends BaseActivity
  implements View.OnClickListener
{
  public static Context a;
  public static String b = "editMode";
  public static String c = "id";
  public static long d = 0L;
  public static int e = -1;
  public static int f = 1;
  public static int g = 2;
  private int h;
  private int i;
  private Button j;
  private TextView k;
  private Button l;
  private TextView n;
  private EditText o;
  private e p;
  private i q;
  private h r;
  private long s;
  private String t;
  private String u;
  private CorporationVo v;
  private CategoryVo w;
  private fa x;

  public SettingEditCommonActivity()
  {
    e locale = g.a().c();
    this.p = locale;
    i locali = g.a().e();
    this.q = locali;
    h localh = g.a().d();
    this.r = localh;
  }

  private void a()
  {
    String str1 = this.o.getText().toString();
    this.t = str1;
    String str2 = this.u;
    String str3 = this.t;
    if (!str2.equalsIgnoreCase(str3))
    {
      int m = this.h;
      int i1 = f;
      if (m != i1)
        break label148;
      if (TextUtils.isEmpty(this.t))
      {
        hb.b(a, "商家名不能为空");
        return;
      }
      i locali1 = this.q;
      String str4 = this.t;
      if (locali1.b(str4))
      {
        hb.b(a, "对不起,该商家已经存在!");
        return;
      }
      i locali2 = this.q;
      long l1 = this.s;
      String str5 = this.t;
      boolean bool1 = locali2.a(l1, str5);
    }
    while (true)
    {
      hb.b(a, "保存成功.");
      finish();
      return;
      label148: int i2 = this.h;
      int i3 = g;
      if (i2 != i3)
        continue;
      int i4 = this.i;
      int i5 = SettingFirstLevelCategoryActivity.e;
      if (i4 == i5)
      {
        y localy = y.a();
        String str6 = gx.a(Long.valueOf(this.s));
        String str7 = this.t;
        if (localy.a(str6, str7, 1, 0))
        {
          hb.b(a, "对不起,该项目名已经存在!");
          return;
        }
        fa localfa = new fa();
        long l2 = this.s;
        localfa.a(l2);
        String str8 = this.t;
        localfa.a(str8);
        boolean bool2 = y.a().a(localfa);
        continue;
      }
      int i6 = this.w.c();
      long l3 = this.w.d();
      if (TextUtils.isEmpty(this.t))
      {
        int i7 = this.i;
        int i8 = SettingFirstLevelCategoryActivity.e;
        if (i7 == i8)
        {
          hb.b(a, "项目名不能为空");
          return;
        }
        hb.b(a, "类别名不能为空");
        return;
      }
      int i9 = this.i;
      int i10 = SettingFirstLevelCategoryActivity.d;
      if (i9 == i10)
      {
        h localh1 = this.r;
        String str9 = this.t;
        if (localh1.b(str9, i6, l3))
        {
          hb.b(a, "对不起,分类名已经存在!");
          return;
        }
      }
      int i11 = this.i;
      int i12 = SettingFirstLevelCategoryActivity.c;
      if (i11 == i12)
      {
        h localh2 = this.r;
        String str10 = this.t;
        if (localh2.c(str10, i6, l3))
        {
          hb.b(a, "对不起,分类名已经存在!");
          return;
        }
      }
      h localh3 = this.r;
      long l4 = this.s;
      String str11 = this.t;
      boolean bool3 = localh3.b(l4, str11);
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230808:
      a();
      return;
    case 2131230807:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903095);
    a = this;
    Button localButton1 = (Button)findViewById(2131230807);
    this.j = localButton1;
    TextView localTextView1 = (TextView)findViewById(2131230730);
    this.k = localTextView1;
    Button localButton2 = (Button)findViewById(2131230808);
    this.l = localButton2;
    TextView localTextView2 = (TextView)findViewById(2131231073);
    this.n = localTextView2;
    EditText localEditText1 = (EditText)findViewById(2131230754);
    this.o = localEditText1;
    this.j.setOnClickListener(this);
    this.l.setOnClickListener(this);
    Intent localIntent1 = getIntent();
    String str1 = b;
    int m = e;
    int i1 = localIntent1.getIntExtra(str1, m);
    this.h = i1;
    Intent localIntent2 = getIntent();
    String str2 = c;
    long l1 = d;
    long l2 = localIntent2.getLongExtra(str2, l1);
    this.s = l2;
    int i2 = this.h;
    int i3 = e;
    if (i2 != i3)
    {
      long l3 = this.s;
      long l4 = d;
      if (l3 != l4);
    }
    else
    {
      finish();
    }
    int i4 = this.h;
    int i5 = f;
    if (i4 == i5)
    {
      this.k.setText("编辑商家");
      this.n.setText("商家名称");
      i locali = this.q;
      long l5 = this.s;
      CorporationVo localCorporationVo = locali.b(l5);
      this.v = localCorporationVo;
      String str3 = this.v.b();
      this.t = str3;
    }
    while (true)
    {
      String str4 = this.t;
      this.u = str4;
      EditText localEditText2 = this.o;
      String str5 = this.t;
      localEditText2.setText(str5);
      this.l.setText("保存");
      boolean bool = this.o.requestFocus();
      return;
      int i6 = this.h;
      int i7 = g;
      if (i6 != i7)
        continue;
      Intent localIntent3 = getIntent();
      String str6 = SettingFirstLevelCategoryActivity.a;
      int i8 = SettingFirstLevelCategoryActivity.b;
      int i9 = localIntent3.getIntExtra(str6, i8);
      this.i = i9;
      int i10 = this.i;
      int i11 = SettingFirstLevelCategoryActivity.e;
      if (i10 == i11)
      {
        this.k.setText("编辑项目");
        this.n.setText("项目名称");
        y localy = y.a();
        long l6 = this.s;
        fa localfa = localy.a(l6);
        this.x = localfa;
        String str7 = this.x.b();
        this.t = str7;
        continue;
      }
      this.k.setText("编辑类别");
      this.n.setText("类别名称");
      h localh = this.r;
      long l7 = this.s;
      CategoryVo localCategoryVo = localh.c(l7);
      this.w = localCategoryVo;
      String str8 = this.w.b();
      this.t = str8;
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131623945, paramMenu);
    return true;
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131231174:
    case 2131231175:
    }
    while (true)
    {
      return true;
      a();
      continue;
      finish();
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
 * Qualified Name:     com.mymoney.ui.setting.SettingEditCommonActivity
 * JD-Core Version:    0.6.0
 */