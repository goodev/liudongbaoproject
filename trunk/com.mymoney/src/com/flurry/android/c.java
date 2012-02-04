package com.flurry.android;

import android.content.Context;

final class c
  implements Runnable
{
  c(FlurryAgent paramFlurryAgent, Context paramContext, boolean paramBoolean)
  {
  }

  public final void run()
  {
    FlurryAgent localFlurryAgent = this.c;
    Context localContext = this.a;
    boolean bool = this.b;
    localFlurryAgent.a(localContext, bool);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.flurry.android.c
 * JD-Core Version:    0.6.0
 */