package com.flurry.android;

import android.content.Context;

final class a
  implements Runnable
{
  a(FlurryAgent paramFlurryAgent, Context paramContext)
  {
  }

  public final void run()
  {
    FlurryAgent localFlurryAgent = this.b;
    Context localContext = this.a;
    localFlurryAgent.a(localContext);
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     com.flurry.android.a
 * JD-Core Version:    0.6.0
 */