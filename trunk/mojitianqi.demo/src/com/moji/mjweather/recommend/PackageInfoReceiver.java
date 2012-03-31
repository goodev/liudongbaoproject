// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PackageInfoReceiver.java

package com.moji.mjweather.recommend;

import android.content.*;
import java.util.HashMap;

// Referenced classes of package com.moji.mjweather.recommend:
//            DefaultPackageInfoAction, RecommendListActivity

public class PackageInfoReceiver extends BroadcastReceiver
{
    public static interface IPackageInfoAction
    {

        public abstract void onDownloadFinish();

        public abstract void onDownloading();

        public abstract void onInstalled();

        public abstract void onReplaced();

        public abstract void onUninstalled();
    }


    public PackageInfoReceiver(IPackageInfoAction ipackageinfoaction)
    {
        mAction = ipackageinfoaction;
    }

    public static PackageInfoReceiver getDefaultPackageInfoReceiver(Context context)
    {
        if(defaultPackageInfoReceiver == null)
            defaultPackageInfoReceiver = new PackageInfoReceiver(new DefaultPackageInfoAction(context.getApplicationContext()));
        return defaultPackageInfoReceiver;
    }

    public static void registerReceiver(Context context, PackageInfoReceiver packageinforeceiver)
    {
        mIntentFilter = new IntentFilter();
        mIntentFilter.addDataScheme("package");
        mIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        mIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        mIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        mIntentFilter.addAction("com.moji.mjweather.recommend.package_downloading");
        mIntentFilter.addAction("com.moji.mjweather.recommend.package_download_finish");
        mIntentFilter.addAction("com.moji.mjweather.recommend.package_download_failure");
        if(packageinforeceiver == null)
            packageinforeceiver = getDefaultPackageInfoReceiver(context);
        context.getApplicationContext().registerReceiver(packageinforeceiver, mIntentFilter);
    }

    public static void unregisterReceiver(Context context, PackageInfoReceiver packageinforeceiver)
    {
        if(packageinforeceiver == null)
            packageinforeceiver = getDefaultPackageInfoReceiver(context);
        context.getApplicationContext().registerReceiver(packageinforeceiver, mIntentFilter);
    }

    public void onReceive(Context context, Intent intent)
    {
        String s;
        String s1;
        s = intent.getStringExtra("appid");
        s1 = intent.getAction();
        if(!"android.intent.action.PACKAGE_ADDED".equals(s1)) goto _L2; else goto _L1
_L1:
        if(mAction != null)
            mAction.onInstalled();
_L4:
        return;
_L2:
        if("android.intent.action.PACKAGE_REMOVED".equals(s1))
        {
            if(mAction != null)
                mAction.onUninstalled();
        } else
        if("android.intent.action.PACKAGE_REPLACED".equals(s1))
        {
            if(mAction != null)
                mAction.onInstalled();
        } else
        if("com.moji.mjweather.recommend.package_downloading".equals(s1))
        {
            if(mAction != null)
            {
                RecommendListActivity.stateMap.put(s, Integer.valueOf(4));
                mAction.onDownloading();
            }
        } else
        if("com.moji.mjweather.recommend.package_download_finish".equals(s1))
        {
            if(mAction != null)
            {
                RecommendListActivity.stateMap.remove(s);
                mAction.onDownloadFinish();
            }
        } else
        if("com.moji.mjweather.recommend.package_download_failure".equals(s1))
        {
            if(mAction != null)
                RecommendListActivity.stateMap.remove(s);
            mAction.onInstalled();
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static final String ACTION_PACKAGE_DOWNLOADING = "com.moji.mjweather.recommend.package_downloading";
    public static final String ACTION_PACKAGE_DOWNLOAD_FAILURE = "com.moji.mjweather.recommend.package_download_failure";
    public static final String ACTION_PACKAGE_DOWNLOAD_FINISH = "com.moji.mjweather.recommend.package_download_finish";
    private static PackageInfoReceiver defaultPackageInfoReceiver = null;
    private static IntentFilter mIntentFilter;
    private IPackageInfoAction mAction;

}
