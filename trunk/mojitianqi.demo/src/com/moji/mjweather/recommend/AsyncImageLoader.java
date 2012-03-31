// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AsyncImageLoader.java

package com.moji.mjweather.recommend;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.*;
import java.io.*;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.moji.mjweather.recommend:
//            AppUtil

public class AsyncImageLoader
{
    public static interface ImageCallback
    {

        public abstract void imageLoaded(Drawable drawable, String s);
    }


    public AsyncImageLoader()
    {
    }

    public static Drawable loadDrawable(final String fileName, final String imageUrl, final ImageCallback imageCallback)
    {
        if(!imageCache.containsKey(imageUrl)) goto _L2; else goto _L1
_L1:
        Drawable drawable = (Drawable)((SoftReference)imageCache.get(imageUrl)).get();
        if(drawable == null) goto _L2; else goto _L3
_L3:
        return drawable;
_L2:
        final Handler handler = new Handler() {

            public void handleMessage(Message message)
            {
                if(imageCallback != null)
                    imageCallback.imageLoaded((Drawable)message.obj, imageUrl);
            }

            final ImageCallback val$imageCallback;
            final String val$imageUrl;

            
            {
                imageCallback = imagecallback;
                imageUrl = s;
                super();
            }
        }
;
        executorService.submit(new Runnable() {

            public void run()
            {
                Drawable drawable1 = AppUtil.searchDrawable(fileName);
                if(drawable1 == null)
                    drawable1 = AsyncImageLoader.loadImageFromUrl(imageUrl, fileName);
                AsyncImageLoader.imageCache.put(imageUrl, new SoftReference(drawable1));
                Message message = handler.obtainMessage(0, drawable1);
                handler.sendMessage(message);
            }

            final String val$fileName;
            final Handler val$handler;
            final String val$imageUrl;

            
            {
                fileName = s;
                imageUrl = s1;
                handler = handler1;
                super();
            }
        }
);
        drawable = null;
        if(true) goto _L3; else goto _L4
_L4:
    }

    public static Drawable loadImageFromUrl(String s, String s1)
    {
        InputStream inputstream = (InputStream)(new URL(s)).getContent();
        if(Environment.getExternalStorageState().equals("mounted")) goto _L2; else goto _L1
_L1:
        Drawable drawable1 = Drawable.createFromStream(inputstream, s1);
          goto _L3
_L2:
        Drawable drawable2;
        saveDrawableToFile(inputstream, s1);
        drawable2 = AppUtil.searchDrawable(s1);
        Drawable drawable = drawable2;
_L4:
        drawable1 = drawable;
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        drawable = null;
        exception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        drawable = null;
        System.gc();
        if(true) goto _L4; else goto _L3
_L3:
        return drawable1;
    }

    public static void saveDrawableToFile(InputStream inputstream, String s)
    {
        if(inputstream == null) goto _L2; else goto _L1
_L1:
        File file;
        File file1;
        FileOutputStream fileoutputstream;
        file = new File("/sdcard/moji/ad_cache");
        file1 = new File((new StringBuilder()).append("/sdcard/moji/ad_cache/").append(s).toString());
        fileoutputstream = null;
        boolean flag = Environment.getExternalStorageState().equals("mounted");
        if(flag) goto _L4; else goto _L3
_L3:
        if(fileoutputstream == null) goto _L2; else goto _L5
_L5:
        fileoutputstream.close();
_L2:
        return;
        Exception exception4;
        exception4;
        exception4.printStackTrace();
          goto _L2
_L4:
        FileOutputStream fileoutputstream1;
        if(!file.exists())
            file.mkdir();
        if(file1.exists())
            break MISSING_BLOCK_LABEL_136;
        fileoutputstream1 = new FileOutputStream(file1.toString());
        BitmapFactory.decodeStream(inputstream).compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileoutputstream1);
        fileoutputstream1.flush();
        fileoutputstream = fileoutputstream1;
        if(fileoutputstream != null)
            try
            {
                fileoutputstream.close();
            }
            catch(Exception exception3)
            {
                exception3.printStackTrace();
            }
          goto _L2
        IOException ioexception;
        ioexception;
_L8:
        ioexception.printStackTrace();
        if(fileoutputstream != null)
            try
            {
                fileoutputstream.close();
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
          goto _L2
        Exception exception;
        exception;
_L7:
        if(fileoutputstream != null)
            try
            {
                fileoutputstream.close();
            }
            catch(Exception exception1)
            {
                exception1.printStackTrace();
            }
        throw exception;
        exception;
        fileoutputstream = fileoutputstream1;
        if(true) goto _L7; else goto _L6
_L6:
        ioexception;
        fileoutputstream = fileoutputstream1;
          goto _L8
    }

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static HashMap imageCache = new HashMap();


}
