package com.mobclick.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

class b extends Handler
{
  b(a parama)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    try
    {
      Intent localIntent1 = new Intent("android.intent.action.VIEW");
      StringBuilder localStringBuilder1 = new StringBuilder("file://");
      String str1 = a.a(this.a);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("/");
      String str2 = a.b(this.a);
      Uri localUri = Uri.parse(str2);
      Intent localIntent2 = localIntent1.setDataAndType(localUri, "application/vnd.android.package-archive");
      a.c(this.a).startActivity(localIntent1);
      return;
    }
    catch (Exception localException)
    {
      String str3 = localException.getMessage();
      int i = Log.e("can not install", str3);
      a.a(this.a, 0);
    }
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.mobclick.android.b
 * JD-Core Version:    0.6.0
 */