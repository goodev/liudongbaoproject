// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DefaultPackageInfoAction.java

package com.moji.mjweather.recommend;

import android.content.Context;

// Referenced classes of package com.moji.mjweather.recommend:
//            AppUtil, RecommendListActivity, RecommendDetailActivity

public class DefaultPackageInfoAction
    implements PackageInfoReceiver.IPackageInfoAction
{

    public DefaultPackageInfoAction(Context context)
    {
        mContext = context;
    }

    public void onDownloadFinish()
    {
        AppUtil.refresh(mContext);
        if(RecommendListActivity.instance != null)
            RecommendListActivity.instance.onDownloadFinish();
        if(RecommendDetailActivity.instance != null)
            RecommendDetailActivity.instance.onDownloadFinish();
    }

    public void onDownloading()
    {
        AppUtil.refresh(mContext);
        if(RecommendListActivity.instance != null)
            RecommendListActivity.instance.onDownloading();
        if(RecommendDetailActivity.instance != null)
            RecommendDetailActivity.instance.onDownloading();
    }

    public void onInstalled()
    {
        AppUtil.refresh(mContext);
        if(RecommendListActivity.instance != null)
            RecommendListActivity.instance.onInstalled();
        if(RecommendDetailActivity.instance != null)
            RecommendDetailActivity.instance.onInstalled();
    }

    public void onReplaced()
    {
        AppUtil.refresh(mContext);
        if(RecommendListActivity.instance != null)
            RecommendListActivity.instance.onReplaced();
        if(RecommendDetailActivity.instance != null)
            RecommendDetailActivity.instance.onReplaced();
    }

    public void onUninstalled()
    {
        AppUtil.refresh(mContext);
        if(RecommendListActivity.instance != null)
            RecommendListActivity.instance.onUninstalled();
        if(RecommendDetailActivity.instance != null)
            RecommendDetailActivity.instance.onUninstalled();
    }

    private Context mContext;
}
