package com.mymoney.ui.repair;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.mymoney.ui.base.BaseActivity;
import com.mymoney.ui.setting.SettingBackUpActivity;

public class RepairModeActivity extends BaseActivity
  implements View.OnClickListener
{
  public static String a = RepairModeActivity.class.getSimpleName();
  private static Context b;
  private LinearLayout c;

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230878:
    }
    Context localContext = b;
    a(localContext, SettingBackUpActivity.class);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903071);
    b = this;
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131230878);
    this.c = localLinearLayout;
    this.c.setOnClickListener(this);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mymoney.ui.repair.RepairModeActivity
 * JD-Core Version:    0.6.0
 */