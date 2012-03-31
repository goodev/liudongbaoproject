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
        es.submit(new Runnable() {

            public void run()
            {
                Response response;
                String s = UrlUtil.getUploadUVPVPrefix();
                String s1 = (new StringBuilder()).append(s).append("&CityID=").append(cityId).toString();
                MojiLog.d("AdUtil", s1);
                Request request = new Request(s1);
                response = (new RHttpUtil(Gl.Ct())).doRequest(request);
                if(response.getRespCode() != 200)
                    break MISSING_BLOCK_LABEL_154;
                MojiLog.d("AdUtil", (new StringBuilder()).append("pvuvResponseCode:").append(response.getRespCode()).toString());
                MojiLog.d("AdUtil", (new StringBuilder()).append("pvuvResponseBody:").append(new String(response.getRespData(), "utf-8")).toString());
_L1:
                return;
                UnsupportedEncodingException unsupportedencodingexception1;
                unsupportedencodingexception1;
                unsupportedencodingexception1.printStackTrace();
                  goto _L1
                MojiLog.d("AdUtil", (new StringBuilder()).append("pvuvResponseCode:").append(response.getRespCode()).toString());
                try
                {
                    MojiLog.d("AdUtil", (new StringBuilder()).append("pvuvResponseBody:").append(new String(response.getRespData(), "utf-8")).toString());
                }
                catch(UnsupportedEncodingException unsupportedencodingexception)
                {
                    unsupportedencodingexception.printStackTrace();
                }
                  goto _L1
            }

            final int val$cityId;

            
            {
                cityId = i;
                super();
            }
        }
);
    }

    private static void uploadStats(final String action, final int place, final int item, final String appId)
    {
        es.submit(new Runnable() {

            public void run()
            {
                String s;
                String s1;
                s = UrlUtil.getUploadADUrlPrefix();
                s1 = "";
                place;
                JVM INSTR tableswitch 1 4: default 40
            //                           1 136
            //                           2 136
            //                           3 142
            //                           4 142;
                   goto _L1 _L2 _L2 _L3 _L3
_L3:
                break MISSING_BLOCK_LABEL_142;
_L1:
                break; /* Loop/switch isn't completed */
_L2:
                s1 = "Recommend";
                  goto _L4
                s1 = "Banner";
_L4:
                Response response;
                String s2;
                String s3;
                Request request;
                if(action.equals("show"))
                {
                    ArrayList arraylist = (ArrayList)RC.categorysMap.get(Integer.valueOf(place));
                    String s4 = "";
                    if(arraylist != null)
                    {
                        for(int i = 0; i < arraylist.size(); i++)
                            s4 = (new StringBuilder()).append(s4).append(((SoftWare)arraylist.get(i)).getAppid()).append(",").toString();

                    }
                    s2 = s4.substring(0, -2 + s4.length());
                } else
                {
                    s2 = appId;
                }
                s3 = (new StringBuilder()).append(s).append("&ADID=").append(s2).append("&Position=").append(place).append("&Category=").append(s1).append("&Order=").append(item).append("&Action=").append(action).toString();
                MojiLog.d("AdUtil", s3);
                request = new Request(s3);
                response = (new RHttpUtil(Gl.Ct())).doRequest(request);
                if(response.getRespCode() != 200)
                    break MISSING_BLOCK_LABEL_366;
                MojiLog.d("AdUtil", (new StringBuilder()).append("ResponseCode:").append(response.getRespCode()).toString());
                MojiLog.d("AdUtil", (new StringBuilder()).append("ResponseBody:").append(new String(response.getRespData(), "utf-8")).toString());
_L5:
                return;
                UnsupportedEncodingException unsupportedencodingexception1;
                unsupportedencodingexception1;
                unsupportedencodingexception1.printStackTrace();
                  goto _L5
                MojiLog.d("AdUtil", (new StringBuilder()).append("ResponseCode:").append(response.getRespCode()).toString());
                try
                {
                    MojiLog.d("AdUtil", (new StringBuilder()).append("ResponseBody:").append(new String(response.getRespData(), "utf-8")).toString());
                }
                catch(UnsupportedEncodingException unsupportedencodingexception)
                {
                    unsupportedencodingexception.printStackTrace();
                }
                  goto _L5
            }

            final String val$action;
            final String val$appId;
            final int val$item;
            final int val$place;

            
            {
                place = i;
                action = s;
                appId = s1;
                item = j;
                super();
            }
        }
);
    }

    public static void uploadStatsClick(int i, int j, String s)
    {
        uploadStats("click", i, j, s);
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
