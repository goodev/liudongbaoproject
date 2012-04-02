// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AdUtil.java

package com.moji.mjweather.recommend;

import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.util.UrlUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.moji.mjweather.recommend:
//            RC, SoftWare, Request, RHttpUtil, 
//            Response

public final class AdUtil
{

    public AdUtil()
    {
    }

    public static void uploadPVUVStats(final int cityId)
    {
        
    }

    

    public static void uploadStatsClick(int i, int j, String s)
    {
        uploadStats("click", i, j, s);
    }

    private static void uploadStats(String string, int i, int j, String s) {
		// TODO Auto-generated method stub
		
	}

	public static void uploadStatsDDL(int i, int j, String s)
    {
        uploadStats("ddl", i, j, s);
    }

    public static void uploadStatsDDLS(int i, int j, String s)
    {
        uploadStats("ddls", i, j, s);
    }

    public static void uploadStatsDL(int i, int j, String s)
    {
        uploadStats("dl", i, j, s);
    }

    public static void uploadStatsDLS(int i, int j, String s)
    {
        uploadStats("dls", i, j, s);
    }

    public static void uploadStatsShow(int i)
    {
        uploadStats("show", i, 0, "");
    }

    private static final String ACTION_CLICK = "click";
    private static final String ACTION_DDL = "ddl";
    private static final String ACTION_DDLS = "ddls";
    private static final String ACTION_DL = "dl";
    private static final String ACTION_DLS = "dls";
    private static final String ACTION_SHOW = "show";
    private static final String TAG = "AdUtil";
    private static final String URL_PARAM_ACTION = "&Action=";
    private static final String URL_PARAM_ADID = "&ADID=";
    private static final String URL_PARAM_CATEGORY = "&Category=";
    private static final String URL_PARAM_CITYID = "&CityID=";
    private static final String URL_PARAM_ORDER = "&Order=";
    private static final String URL_PARAM_POSITION = "&Position=";
    private static ExecutorService es = Executors.newFixedThreadPool(10);

}
