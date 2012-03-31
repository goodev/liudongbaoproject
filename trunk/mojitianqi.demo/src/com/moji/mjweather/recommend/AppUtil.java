// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AppUtil.java

package com.moji.mjweather.recommend;

import android.content.Context;
import android.content.pm.*;
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
        List list;
        int i;
        if(softRefappList == null || softRefappList.get() == null)
            refresh(context);
        list = (List)softRefappList.get();
        i = 0;
_L4:
        PackageInfo packageinfo;
        if(i >= list.size())
            break MISSING_BLOCK_LABEL_120;
        packageinfo = (PackageInfo)list.get(i);
        if(!s.equalsIgnoreCase(packageinfo.applicationInfo.packageName)) goto _L2; else goto _L1
_L1:
        byte byte1 = 1;
        int j;
        int k;
        j = Integer.parseInt(s1);
        k = packageinfo.versionCode;
        if(j > k)
            byte1 = 3;
_L3:
        byte byte0 = byte1;
_L5:
        return byte0;
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L3
_L2:
        i++;
          goto _L4
        byte0 = 2;
          goto _L5
    }

    public static int checkIfHaveDownlaod(String s)
    {
        byte byte0;
        File file;
        byte0 = 0;
        file = new File((new StringBuilder()).append("/sdcard/moji/mojiDownload//").append(s).append(".apk").toString());
        boolean flag;
        if(!Environment.getExternalStorageState().equals("mounted"))
            break MISSING_BLOCK_LABEL_69;
        flag = file.exists();
        if(flag)
            byte0 = 5;
        break MISSING_BLOCK_LABEL_69;
        Exception exception;
        exception;
        exception.printStackTrace();
        return byte0;
    }

    public static int checkSoftStatus(Context context, String s, String s1)
    {
        PackageInfo packageinfo = getAppPackageInfo(context, s);
        if(packageinfo == null || !s.equalsIgnoreCase(packageinfo.packageName)) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = Integer.parseInt(s1);
        j = packageinfo.versionCode;
        if(i <= j) goto _L4; else goto _L3
_L3:
        byte byte0 = 3;
_L6:
        return byte0;
        Exception exception;
        exception;
        exception.printStackTrace();
_L4:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L2:
        byte0 = 2;
        if(true) goto _L6; else goto _L5
_L5:
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
        PackageInfo packageinfo1 = packagemanager.getPackageInfo(s, 0);
        PackageInfo packageinfo = packageinfo1;
_L2:
        return packageinfo;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
        packageinfo = null;
        if(true) goto _L2; else goto _L1
_L1:
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
        i = 0;
_L3:
        if(i >= afile.length)
            break MISSING_BLOCK_LABEL_73;
        if(afile[i].isDirectory() || !afile[i].getName().equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = false;
          goto _L4
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
        if(flag) goto _L2; else goto _L1
_L1:
        Drawable drawable1;
        drawable1 = null;
        if(fileinputstream != null)
            try
            {
                fileinputstream.close();
            }
            catch(Exception exception4)
            {
                exception4.printStackTrace();
            }
_L4:
        return drawable1;
_L2:
        FileInputStream fileinputstream1;
        if(!file.exists())
            break MISSING_BLOCK_LABEL_101;
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
_L5:
        drawable1 = drawable;
        if(true) goto _L4; else goto _L3
_L3:
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
_L8:
        filenotfoundexception.printStackTrace();
        if(fileinputstream != null)
            try
            {
                fileinputstream.close();
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
          goto _L5
        Exception exception;
        exception;
_L7:
        if(fileinputstream != null)
            try
            {
                fileinputstream.close();
            }
            catch(Exception exception1)
            {
                exception1.printStackTrace();
            }
        throw exception;
        exception;
        fileinputstream = fileinputstream1;
        if(true) goto _L7; else goto _L6
_L6:
        filenotfoundexception;
        fileinputstream = fileinputstream1;
          goto _L8
    }

    public int getSDKVersion(Context context, String s)
    {
        List list;
        int i;
        if(softRefappList == null || softRefappList.get() == null)
            refresh(context);
        list = (List)softRefappList.get();
        i = 0;
_L3:
        PackageInfo packageinfo;
        if(i >= list.size())
            break MISSING_BLOCK_LABEL_87;
        packageinfo = (PackageInfo)list.get(i);
        if(!s.equalsIgnoreCase(packageinfo.applicationInfo.packageName)) goto _L2; else goto _L1
_L1:
        int j = packageinfo.versionCode;
_L4:
        return j;
_L2:
        i++;
          goto _L3
        j = 0;
          goto _L4
    }

    public static final int STATE_DOWNLOADING = 4;
    public static final int STATE_DOWNLOAD_FINISH = 5;
    public static final int STATE_HAS_UPDATE = 3;
    public static final int STATE_INSTALLED = 1;
    public static final int STATE_NO_INSTALL = 2;
    private static SoftReference softRefappList;
}
