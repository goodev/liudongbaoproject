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
import java.net.MalformedURLException;
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
        if( imageCache.containsKey(imageUrl)) 
      {
        Drawable drawable = (Drawable)((SoftReference)imageCache.get(imageUrl)).get();
        if(drawable != null)  
        return drawable;}
 
        final Handler handler = new Handler() {

            public void handleMessage(Message message)
            {
                if(imageCallback != null)
                    imageCallback.imageLoaded((Drawable)message.obj, imageUrl);
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

             
        }
);
       return null;
      
    }

    public static Drawable loadImageFromUrl(String s, String s1)
    {
        InputStream inputstream;
		try {
			inputstream = (InputStream)(new URL(s)).getContent();
			if(Environment.getExternalStorageState().equals("mounted")) { 
				 
	            saveDrawableToFile(inputstream, s1);
	            return  AppUtil.searchDrawable(s1);
	        }
	        else
	  return Drawable.createFromStream(inputstream, s1);
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); return null;
		}  
        
 
    }

    public static void saveDrawableToFile(InputStream inputstream, String s)
    {
        if(inputstream == null)return;
 
        File file;
        File file1;
        FileOutputStream fileoutputstream;
        file = new File("/sdcard/moji/ad_cache");
        file1 = new File((new StringBuilder()).append("/sdcard/moji/ad_cache/").append(s).toString());
        fileoutputstream = null;
        boolean flag = Environment.getExternalStorageState().equals("mounted");
        if(!flag) return;  
        FileOutputStream fileoutputstream1;
        if(!file.exists())
            file.mkdir();
        if(file1.exists())
  return;
        try {
			fileoutputstream1 = new FileOutputStream(file1.toString());
			 BitmapFactory.decodeStream(inputstream).compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileoutputstream1);
		        fileoutputstream1.flush();
		        fileoutputstream1.close();
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
 
 
    }

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static HashMap imageCache = new HashMap();


}
