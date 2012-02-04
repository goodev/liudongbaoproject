package com.mymoney.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.mymoney.core.vo.CategoryVo;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.helper.CategoryIconResourcesHelper;
import com.mymoney.ui.widget.CategoryIconPicker;
import com.mymoney.ui.widget.CategoryIconRadioGroup;
import g;
import h;
import hb;

public class SettingEditCategoryActivity extends BaseActivity
  implements View.OnClickListener, RadioGroup.OnCheckedChangeListener
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
  private EditText j;
  private Button k;
  private Button l;
  private ImageView n;
  private TextView o;
  private CategoryIconRadioGroup p;
  private h q;
  private long r;
  private String s;
  private String t;
  private String u;
  private String v;
  private CategoryVo w;
  private int[] x;
  private String[] y;

  public SettingEditCategoryActivity()
  {
    h localh = g.a().d();
    this.q = localh;
    int[] arrayOfInt = { 2131230934, 2131230935, 2131230936, 2131230937, 2131230938, 2131230939, 2131230940, 2131230941, 2131230942, 2131230943, 2131230944, 2131230945, 2131230946, 2131230947, 2131230948, 2131230949, 2131230950, 2131230951, 2131230952, 2131230953, 2131230954, 2131230955, 2131230956, 2131230957, 2131230958, 2131230959, 2131230960, 2131230961, 2131230962, 2131230963, 2131230964, 2131230965, 2131230966, 2131230967, 2131230968, 2131230969, 2131230970, 2131230971, 2131230972, 2131230973, 2131230974, 2131230975, 2131230976, 2131230977, 2131230978, 2131230979, 2131230980, 2131230981, 2131230982, 2131230983, 2131230984, 2131230985, 2131230986, 2131230987, 2131230988, 2131230989, 2131230990, 2131230991, 2131230992, 2131230993, 2131230994, 2131230995, 2131230996, 2131230997, 2131230998, 2131230999 };
    this.x = arrayOfInt;
    String[] arrayOfString = new String[66];
    arrayOfString[0] = "icon_yfsp";
    arrayOfString[1] = "icon_yfsp_yfkz";
    arrayOfString[2] = "icon_yfsp_xmbb";
    arrayOfString[3] = "icon_yfsp_hzsp";
    arrayOfString[4] = "icon_spjs";
    arrayOfString[5] = "icon_spjs_zwwc";
    arrayOfString[6] = "icon_spjs_yjc";
    arrayOfString[7] = "icon_spjs_sgls";
    arrayOfString[8] = "icon_jjwy";
    arrayOfString[9] = "icon_jjwy_rcyp";
    arrayOfString[10] = "icon_jjwy_sdmq";
    arrayOfString[11] = "icon_jjwy_fz";
    arrayOfString[12] = "icon_jjwy_wygl";
    arrayOfString[13] = "icon_jjwy_yxby";
    arrayOfString[14] = "icon_xcjt";
    arrayOfString[15] = "icon_xcjt_ggjt";
    arrayOfString[16] = "icon_xcjt_dczc";
    arrayOfString[17] = "icon_xcjt_sjcfy";
    arrayOfString[18] = "icon_jltx";
    arrayOfString[19] = "icon_jltx_zjf";
    arrayOfString[20] = "icon_jltx_sjf";
    arrayOfString[21] = "icon_jltx_swf";
    arrayOfString[22] = "icon_jltx_yjf";
    arrayOfString[23] = "icon_xxyl";
    arrayOfString[24] = "icon_xxyl_ydjs";
    arrayOfString[25] = "icon_xxyl_fbjh";
    arrayOfString[26] = "icon_xxyl_xxwl";
    arrayOfString[27] = "icon_xxyl_cwbb";
    arrayOfString[28] = "icon_xxyl_lydj";
    arrayOfString[29] = "icon_xxjx";
    arrayOfString[30] = "icon_xxjx_sbzz";
    arrayOfString[31] = "icon_xxjx_pxjx";
    arrayOfString[32] = "icon_xxjx_smzb";
    arrayOfString[33] = "icon_rqwl";
    arrayOfString[34] = "icon_rqwl_slqk";
    arrayOfString[35] = "icon_rqwl_xjjz";
    arrayOfString[36] = "icon_rqwl_hrqc";
    arrayOfString[37] = "icon_rqwl_csjz";
    arrayOfString[38] = "icon_ylbj";
    arrayOfString[39] = "icon_ylbj_ypf";
    arrayOfString[40] = "icon_ylbj_bjf";
    arrayOfString[41] = "icon_ylbj_mrf";
    arrayOfString[42] = "icon_ylbj_zlf";
    arrayOfString[43] = "icon_jrbx";
    arrayOfString[44] = "icon_jrbx_yhsx";
    arrayOfString[45] = "icon_jrbx_tzks";
    arrayOfString[46] = "icon_jrbx_ajhk";
    arrayOfString[47] = "icon_jrbx_xfss";
    arrayOfString[48] = "icon_jrbx_lxzc";
    arrayOfString[49] = "icon_jrbx_pcfk";
    arrayOfString[50] = "icon_qtzx";
    arrayOfString[51] = "icon_qtzx_qtzc";
    arrayOfString[52] = "icon_qtzx_ywds";
    arrayOfString[53] = "icon_qtzx_lzss";
    arrayOfString[54] = "icon_zysr";
    arrayOfString[55] = "icon_zysr_gzsr";
    arrayOfString[56] = "icon_zysr_lxsr";
    arrayOfString[57] = "icon_zysr_jbsr";
    arrayOfString[58] = "icon_zysr_jjsr";
    arrayOfString[59] = "icon_zysr_tzsr";
    arrayOfString[60] = "icon_zysr_jzsr";
    arrayOfString[61] = "icon_qtsr";
    arrayOfString[62] = "icon_qtsr_ljsr";
    arrayOfString[63] = "icon_qtsr_zjsr";
    arrayOfString[64] = "icon_qtsr_ywlq";
    arrayOfString[65] = "icon_qtsr_jysd";
    this.y = arrayOfString;
  }

  private void a()
  {
    String str1 = this.j.getText().toString();
    this.s = str1;
    String str2 = this.t;
    String str3 = this.s;
    if (str2.equalsIgnoreCase(str3))
    {
      String str4 = this.v;
      String str5 = this.u;
      if (str4.equals(str5));
    }
    else
    {
      int m = this.h;
      int i1 = g;
      if (m == i1)
      {
        int i2 = this.w.c();
        long l1 = this.w.d();
        if (TextUtils.isEmpty(this.s))
        {
          hb.b(a, "分类名称不能为空");
          return;
        }
        int i3 = this.i;
        int i4 = SettingFirstLevelCategoryActivity.d;
        if (i3 == i4)
        {
          h localh1 = this.q;
          String str6 = this.s;
          if (localh1.b(str6, i2, l1))
          {
            String str7 = this.t;
            String str8 = this.s;
            if (!str7.equalsIgnoreCase(str8))
            {
              hb.b(a, "对不起,分类名称已经存在!");
              return;
            }
          }
        }
        int i5 = this.i;
        int i6 = SettingFirstLevelCategoryActivity.c;
        if (i5 == i6)
        {
          h localh2 = this.q;
          String str9 = this.s;
          if (localh2.c(str9, i2, l1))
          {
            String str10 = this.t;
            String str11 = this.s;
            if (!str10.equalsIgnoreCase(str11))
            {
              hb.b(a, "对不起,分类名称已经存在!");
              return;
            }
          }
        }
        h localh3 = this.q;
        long l2 = this.r;
        String str12 = this.s;
        String str13 = this.u;
        boolean bool = localh3.a(l2, str12, str13);
      }
    }
    hb.b(a, "保存成功.");
    finish();
  }

  private Drawable b()
  {
    String str = this.w.f();
    this.v = str;
    int m = this.w.c();
    Resources localResources = getResources();
    int i1 = CategoryIconResourcesHelper.a(str, m);
    return localResources.getDrawable(i1);
  }

  private void c()
  {
    int m = 0;
    while (true)
    {
      int i1 = this.x.length;
      if (m >= i1)
        return;
      int i2 = this.x[m];
      CategoryIconPicker localCategoryIconPicker = (CategoryIconPicker)findViewById(i2);
      String str1 = this.y[m];
      localCategoryIconPicker.a(str1);
      String str2 = this.v;
      String str3 = this.y[m];
      if (str2.equals(str3))
        localCategoryIconPicker.setChecked(1);
      m += 1;
    }
  }

  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    CategoryIconPicker localCategoryIconPicker = (CategoryIconPicker)findViewById(paramInt);
    ImageView localImageView = this.n;
    Resources localResources = getResources();
    int m = localCategoryIconPicker.b();
    Drawable localDrawable = localResources.getDrawable(m);
    localImageView.setImageDrawable(localDrawable);
    String str = localCategoryIconPicker.a();
    this.u = str;
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
    setContentView(2130903094);
    a = this;
    EditText localEditText1 = (EditText)findViewById(2131230754);
    this.j = localEditText1;
    Button localButton1 = (Button)findViewById(2131230808);
    this.k = localButton1;
    Button localButton2 = (Button)findViewById(2131230807);
    this.l = localButton2;
    ImageView localImageView1 = (ImageView)findViewById(2131230911);
    this.n = localImageView1;
    TextView localTextView = (TextView)findViewById(2131230730);
    this.o = localTextView;
    CategoryIconRadioGroup localCategoryIconRadioGroup = (CategoryIconRadioGroup)findViewById(2131231072);
    this.p = localCategoryIconRadioGroup;
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.p.setOnCheckedChangeListener(this);
    Intent localIntent1 = getIntent();
    String str1 = b;
    int m = e;
    int i1 = localIntent1.getIntExtra(str1, m);
    this.h = i1;
    Intent localIntent2 = getIntent();
    String str2 = c;
    long l1 = d;
    long l2 = localIntent2.getLongExtra(str2, l1);
    this.r = l2;
    int i2 = this.h;
    int i3 = e;
    if (i2 != i3)
    {
      long l3 = this.r;
      long l4 = d;
      if (l3 != l4);
    }
    else
    {
      finish();
    }
    Intent localIntent3 = getIntent();
    String str3 = SettingFirstLevelCategoryActivity.a;
    int i4 = SettingFirstLevelCategoryActivity.b;
    int i5 = localIntent3.getIntExtra(str3, i4);
    this.i = i5;
    h localh = this.q;
    long l5 = this.r;
    CategoryVo localCategoryVo = localh.c(l5);
    this.w = localCategoryVo;
    String str4 = this.w.b();
    this.s = str4;
    ImageView localImageView2 = this.n;
    Drawable localDrawable = b();
    localImageView2.setImageDrawable(localDrawable);
    this.o.setText("编辑分类");
    this.k.setText("保存");
    c();
    String str5 = this.s;
    this.t = str5;
    EditText localEditText2 = this.j;
    String str6 = this.s;
    localEditText2.setText(str6);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131623945, paramMenu);
    return true;
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
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingEditCategoryActivity
 * JD-Core Version:    0.6.0
 */