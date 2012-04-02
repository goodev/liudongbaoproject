// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AppUtil.java

package com.moji.mjweather.recommend;

import android.content.Context;
import android.content.pm.*;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import java.io.*;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class AppUtil
{

    public AppUtil(Context context)
    {
        refresh(context);
    }

    public static int check(Context context, String s, String s1)
    {
       return 3;
    }

    public static int checkIfHaveDownlaod(String s)
    {
        byte byte0;
        File file;
        byte0 = 0;
        file = new File((new StringBuilder()).append("/sdcard/moji/mojiDownload//").append(s).append(".apk").toString());
        boolean flag;
        if(!Environment.getExternalStorageState().equals("mounted"))
          return 2;
        flag = file.exists();
        if(flag)
            byte0 = 5;
         
        return byte0;
    }

    public static int checkSoftStatus(Context context, String s, String s1)
    {
       return 1;
    }

    private static List getAllApps(Context context)
    {
        ArrayList arraylist = new ArrayList();
        List list = context.getPackageManager().getInstalledPackages(0);
        for(int i = 0; i < list.size(); i++)
        {
            PackageInfo packageinfo = (PackageInfo)list.get(i);
            if((1 & packageinfo.applicationInfo.flags) <= 0)
                arraylist.add(packageinfo);
        }

        return arraylist;
    }

    public static PackageInfo getAppPackageInfo(Context context, String s)
    {
        PackageManager packagemanager = context.getPackageManager();
 
		try {
			return packagemanager.getPackageInfo(s, 0);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
 
    }

    public static int getAppVersionCode(Context context, String s)
    {
        PackageInfo packageinfo = getAppPackageInfo(context, s);
        int i;
        if(packageinfo != null)
            i = packageinfo.versionCode;
        else
            i = 0;
        return i;
    }

    public static boolean judgeFileExist(Context context, String s)
    {
        File afile[];
        int i;
        File file = new File("/sdcard/moji/mojiDownload/");
        if(!file.exists())
            file.mkdir();
        afile = file.listFiles();
       for( i = 0;i<afile.length;i++)
       {
    	   if(afile[i].isDirectory() || !afile[i].getName().equalsIgnoreCase(s)){
    		   
    	   }
    	   else {
    		   return true;
    	   }
       }
       return false;
    }

    public static void refresh(Context context)
    {
        softRefappList = new SoftReference(getAllApps(context));
    }

    public static Drawable searchDrawable(String s)
    {
        File file;
        Drawable drawable;
        FileInputStream fileinputstream;
        file = new File((new StringBuilder()).append("/sdcard/moji/ad_cache/").append(s).toString());
        drawable = null;
        fileinputstream = null;
        boolean flag = Environment.getExternalStorageState().equals("mounted");
        if(flag) 
        {
        	FileInputStream fileinputstream1;
            if(!file.exists())
                return null;
            try {
				fileinputstream1 = new FileInputStream(file);
				 Drawable drawable2 = Drawable.createFromStream(fileinputstream1, s);
		            drawable = drawable2;
		            fileinputstream = fileinputstream1;
		            if(fileinputstream != null)
		                try
		                {
		                    fileinputstream.close();
		                }
		                catch(Exception exception3)
		                {
		                    exception3.printStackTrace();
		                }
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
        }
        	 
 
        return drawable ;
 
    }

    public int getSDKVersion(Context context, String s)
    {
    return 7;
    }

    public static final int STATE_DOWNLOADING = 4;
    public static final int STATE_DOWNLOAD_FINISH = 5;
    public static final int STATE_HAS_UPDATE = 3;
    public static final int STATE_INSTALLED = 1;
    public static final int STATE_NO_INSTALL = 2;
    private static SoftReference softRefappList;
}
