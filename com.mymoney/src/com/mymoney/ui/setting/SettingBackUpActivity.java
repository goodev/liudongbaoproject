package com.mymoney.ui.setting;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mymoney.ui.base.BaseActivity;
import ep;
import g;
import gi;
import gu;
import hb;
import java.util.Iterator;
import java.util.List;
import k;
import pi;
import pj;
import pk;
import pl;
import pm;
import pn;
import po;
import pp;
import pq;
import pr;

public class SettingBackUpActivity extends BaseActivity
  implements View.OnClickListener
{
  private static final String[] c;
  private String a;
  private Context b;
  private LinearLayout d;
  private LinearLayout e;
  private LinearLayout f;
  private CheckBox g;
  private LinearLayout h;
  private LinearLayout i;
  private List j;
  private String[] k;
  private String l;
  private String n;
  private int o;
  private k p;
  private AlarmManager q;
  private PendingIntent r;

  static
  {
    String[] arrayOfString = new String[7];
    arrayOfString[0] = "每一天";
    arrayOfString[1] = "每两天";
    arrayOfString[2] = "每三天";
    arrayOfString[3] = "每四天";
    arrayOfString[4] = "每五天";
    arrayOfString[5] = "每六天";
    arrayOfString[6] = "每七天";
    c = arrayOfString;
  }

  public SettingBackUpActivity()
  {
    String str = SettingBackUpActivity.class.getSimpleName();
    this.a = str;
    this.b = this;
    k localk = g.a().h();
    this.p = localk;
  }

  private Dialog a()
  {
    int[] arrayOfInt = gi.b(this.n);
    Context localContext = this.b;
    pp localpp = new pp(this, null);
    int m = arrayOfInt[0];
    int i1 = arrayOfInt[1];
    TimePickerDialog localTimePickerDialog = new TimePickerDialog(localContext, localpp, m, i1, 1);
    localTimePickerDialog.setCancelable(0);
    pn localpn = new pn(this);
    localTimePickerDialog.setButton(-1, "取消", localpn);
    return localTimePickerDialog;
  }

  private boolean a(String paramString)
  {
    return this.p.c(paramString);
  }

  private Dialog b()
  {
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setTitle("设置自动备份的周期");
    String[] arrayOfString = c;
    int m = this.o - 1;
    po localpo = new po(this, null);
    AlertDialog.Builder localBuilder3 = localBuilder1.setSingleChoiceItems(arrayOfString, m, localpo);
    return localBuilder1.create();
  }

  private void b(String paramString)
  {
    pr localpr = new pr(this);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString;
    AsyncTask localAsyncTask = localpr.execute(arrayOfString);
  }

  private void c()
  {
    boolean bool = this.g.isChecked();
    gu.i(bool);
    if (bool)
    {
      if (TextUtils.isEmpty(this.n))
        return;
      d();
      hb.b(this.b, "开启自动备份成功");
      return;
    }
    AlarmManager localAlarmManager = this.q;
    PendingIntent localPendingIntent = this.r;
    localAlarmManager.cancel(localPendingIntent);
    hb.b(this.b, "已经取消自动备份");
  }

  private void d()
  {
    long l1 = gi.a(this.n);
    AlarmManager localAlarmManager = this.q;
    long l2 = this.o * 86400000L;
    PendingIntent localPendingIntent = this.r;
    localAlarmManager.setRepeating(0, l1, l2, localPendingIntent);
  }

  private boolean e()
  {
    return this.p.j();
  }

  private void f()
  {
    AsyncTask localAsyncTask = new pq(this).execute(null);
  }

  public void onClick(View paramView)
  {
    int m = 0;
    Object localObject = "请先开启自动备份";
    switch (paramView.getId())
    {
    default:
      return;
    case 2131231030:
      if (ep.a())
      {
        Context localContext = this.b;
        AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext).setTitle("温馨提示").setMessage("你确认要备份数据吗?");
        pj localpj = new pj(this);
        AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton("确定", localpj);
        pi localpi = new pi(this);
        localBuilder2.setNegativeButton("取消", localpi).create().show();
        return;
      }
      hb.b(this.b, "sd卡不可用.");
      return;
    case 2131231053:
      try
      {
        if (!ep.a())
          break label299;
        List localList = this.p.l();
        this.j = localList;
        String[] arrayOfString = new String[this.j.size()];
        this.k = arrayOfString;
        localObject = this.j.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.k[m] = str;
          m += 1;
        }
        if (this.k.length > 0)
        {
          showDialog(0);
          return;
        }
      }
      catch (Exception localException)
      {
        hb.b(this.b, "数据恢复失败请重试,请确保你的sd卡可用.");
        localException.printStackTrace();
        return;
      }
      hb.b(this.b, "你还没有备份数据.");
      return;
      hb.b(this.b, "sd卡不可用.");
      return;
    case 2131230807:
      finish();
      return;
    case 2131231054:
      CheckBox localCheckBox = this.g;
      if (!this.g.isChecked());
      int i2;
      for (int i1 = 1; ; i2 = 0)
      {
        localCheckBox.setChecked(i1);
        c();
        return;
      }
    case 2131231055:
      c();
      return;
    case 2131231057:
      label299: if (this.g.isChecked())
      {
        showDialog(2);
        return;
      }
      hb.b(this, "请先开启自动备份");
      return;
    case 2131231056:
    }
    if (this.g.isChecked())
    {
      showDialog(3);
      return;
    }
    hb.b(this, "请先开启自动备份");
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903087);
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131231030);
    this.d = localLinearLayout1;
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131231053);
    this.e = localLinearLayout2;
    Button localButton1 = (Button)findViewById(2131230807);
    TextView localTextView = (TextView)findViewById(2131230730);
    Button localButton2 = (Button)findViewById(2131230808);
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131231054);
    this.f = localLinearLayout3;
    CheckBox localCheckBox1 = (CheckBox)findViewById(2131231055);
    this.g = localCheckBox1;
    LinearLayout localLinearLayout4 = (LinearLayout)findViewById(2131231057);
    this.h = localLinearLayout4;
    LinearLayout localLinearLayout5 = (LinearLayout)findViewById(2131231056);
    this.i = localLinearLayout5;
    localTextView.setText("备份与恢复");
    localButton2.setVisibility(4);
    CheckBox localCheckBox2 = this.g;
    boolean bool = gu.s();
    localCheckBox2.setChecked(bool);
    String str = gu.t();
    this.n = str;
    AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
    this.q = localAlarmManager;
    Context localContext = this.b;
    Intent localIntent = new Intent("com.mymoney.ui.setting.Action.AUTO_BACKUP");
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(localContext, 0, localIntent, 0);
    this.r = localPendingIntent;
    int m = gu.u();
    this.o = m;
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    localButton1.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default:
      localObject = super.onCreateDialog(paramInt);
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return localObject;
      Context localContext1 = this.b;
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localContext1).setTitle("选择备份文件");
      String[] arrayOfString = this.k;
      pk localpk = new pk(this);
      localObject = localBuilder1.setItems(arrayOfString, localpk).create();
      continue;
      Context localContext2 = this.b;
      AlertDialog.Builder localBuilder2 = new AlertDialog.Builder(localContext2).setTitle("温馨提示").setMessage("你确认要恢复数据吗?");
      pm localpm = new pm(this);
      AlertDialog.Builder localBuilder3 = localBuilder2.setPositiveButton("确定", localpm);
      pl localpl = new pl(this);
      localObject = localBuilder3.setNegativeButton("取消", localpl).create();
      continue;
      localObject = a();
      continue;
      localObject = b();
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.setting.SettingBackUpActivity
 * JD-Core Version:    0.6.0
 */