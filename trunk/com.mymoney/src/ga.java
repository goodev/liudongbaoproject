import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import java.io.FileDescriptor;
import java.util.WeakHashMap;

public class ga
{
  private static ga b = null;
  private final WeakHashMap a;

  private ga()
  {
    WeakHashMap localWeakHashMap = new WeakHashMap();
    this.a = localWeakHashMap;
  }

  /** @deprecated */
  public static ga a()
  {
    monitorenter;
    try
    {
      if (b == null)
        b = new ga();
      ga localga = b;
      monitorexit;
      return localga;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  /** @deprecated */
  private void a(Thread paramThread, BitmapFactory.Options paramOptions)
  {
    monitorenter;
    try
    {
      c(paramThread).b = paramOptions;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  /** @deprecated */
  private gd c(Thread paramThread)
  {
    monitorenter;
    try
    {
      gd localgd = (gd)this.a.get(paramThread);
      if (localgd == null)
      {
        localgd = new gd(null);
        Object localObject1 = this.a.put(paramThread, localgd);
      }
      monitorexit;
      return localgd;
    }
    finally
    {
      localObject2 = finally;
      monitorexit;
    }
    throw localObject2;
  }

  public Bitmap a(FileDescriptor paramFileDescriptor, BitmapFactory.Options paramOptions)
  {
    Object localObject;
    if (paramOptions.mCancel)
      localObject = null;
    while (true)
    {
      return localObject;
      Thread localThread = Thread.currentThread();
      if (!b(localThread))
      {
        String str = "Thread " + localThread + " is not allowed to decode.";
        int i = Log.d("BitmapManager", str);
        localObject = null;
        continue;
      }
      a(localThread, paramOptions);
      Bitmap localBitmap = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, paramOptions);
      a(localThread);
      localObject = localBitmap;
    }
  }

  /** @deprecated */
  void a(Thread paramThread)
  {
    monitorenter;
    try
    {
      ((gd)this.a.get(paramThread)).b = null;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  /** @deprecated */
  public boolean b(Thread paramThread)
  {
    monitorenter;
    try
    {
      Object localObject1 = (gd)this.a.get(paramThread);
      int i;
      if (localObject1 == null)
        i = 1;
      while (true)
      {
        return i;
        localObject1 = ((gd)localObject1).a;
        gc localgc = gc.a;
        if (localObject1 != localgc)
        {
          i = 1;
          continue;
        }
        i = 0;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }
}

/* Location:           F:\soft\android\soft\dex2jar-0.0.7.10-SNAPSHOT\classes.dex.dex2jar.jar
 * Qualified Name:     ga
 * JD-Core Version:    0.6.0
 */