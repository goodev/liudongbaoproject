package com.mobclick.android;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class h
  implements DialogInterface.OnClickListener
{
  h(MobclickAgent paramMobclickAgent)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.cancel();
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mobclick.android.h
 * JD-Core Version:    0.6.0
 */