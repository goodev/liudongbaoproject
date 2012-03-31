// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetSoftImageTask.java

package com.moji.mjweather.recommend;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import java.io.InputStream;
import java.net.URL;

// Referenced classes of package com.moji.mjweather.recommend:
//            AppUtil, AsyncImageLoader

public class GetSoftImageTask extends AsyncTask
{

    public GetSoftImageTask(Activity activity)
    {
    }

    protected transient Drawable doInBackground(Object aobj[])
    {
        callback = (AsyncImageLoader.ImageCallback)aobj[0];
        String s = (String)aobj[1];
        fileName = (String)aobj[2];
        Drawable drawable = AppUtil.searchDrawable(fileName);
        if(drawable == null)
            drawable = loadImageFromUrl(s);
        return drawable;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground(aobj);
    }

    public Drawable loadImageFromUrl(String s)
    {
        Drawable drawable = null;
        InputStream inputstream = (InputStream)(new URL(s)).getContent();
        if(Environment.getExternalStorageState().equals("mounted")) goto _L2; else goto _L1
_L1:
        Drawable drawable1 = Drawable.createFromStream(inputstream, fileName);
          goto _L3
_L2:
        Drawable drawable2;
        AsyncImageLoader.saveDrawableToFile(inputstream, fileName);
        drawable2 = AppUtil.searchDrawable(fileName);
        drawable = drawable2;
_L4:
        drawable1 = drawable;
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        exception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        System.gc();
        if(true) goto _L4; else goto _L3
_L3:
        return drawable1;
    }

    protected void onCancelled()
    {
        if(bt != null)
            bt.recycle();
        callback = null;
        System.gc();
        super.onCancelled();
    }

    protected void onPostExecute(Object obj)
    {
        Drawable drawable = (Drawable)obj;
        callback.imageLoaded(drawable, "");
    }

    Bitmap bt;
    private AsyncImageLoader.ImageCallback callback;
    private String fileName;
}
