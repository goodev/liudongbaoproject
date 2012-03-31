// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetSoftWareDetailTask.java

package com.moji.mjweather.recommend;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.moji.mjweather.util.UrlUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.moji.mjweather.recommend:
//            HttpAsyncTask, SoftWare, CallBack, RHttpUtil

public class GetSoftWareDetailTask extends HttpAsyncTask
{

    public GetSoftWareDetailTask(Activity activity, String s)
    {
        super(activity);
        handler = new Handler() {

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR tableswitch 5 5: default 24
            //                           5 30;
                   goto _L1 _L2
_L1:
                super.handleMessage(message);
                return;
_L2:
                Toast.makeText(context, 0x7f0b0263, 0).show();
                if(true) goto _L1; else goto _L3
_L3:
            }

            final GetSoftWareDetailTask this$0;

            
            {
                this$0 = GetSoftWareDetailTask.this;
                super();
            }
        }
;
        context = activity;
        appid = s;
    }

    private Map process(Map map)
    {
        String s;
        String s1;
        String s2;
        HashMap hashmap;
        s = (String)map.get("errno");
        s1 = (String)map.get("errcode");
        s2 = (String)map.get("content");
        hashmap = new HashMap();
        if(s.equalsIgnoreCase("0") && s1 == null) goto _L2; else goto _L1
_L1:
        Message message = new Message();
        message.what = 5;
        handler.sendMessage(message);
_L7:
        return hashmap;
_L2:
        SoftWare software;
        hashmap.put("name", "MSG_SoftCategoryList_Arrive");
        hashmap.put("error", Integer.valueOf(1));
        if(!s.equals("0"))
        {
            hashmap.put("errMsg", s2);
            hashmap.put("errcode", s1);
            continue; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject;
        JSONObject jsonobject1;
        try
        {
            jsonobject = new JSONObject(s2);
        }
        catch(Exception exception2)
        {
            exception2.printStackTrace();
            continue; /* Loop/switch isn't completed */
        }
        if(!jsonobject.has("AppDataDetail")) goto _L4; else goto _L3
_L3:
        jsonobject1 = new JSONObject(setJsonData(jsonobject, "AppDataDetail"));
        software = new SoftWare();
        software.setAppDesc(setJsonData(jsonobject1, "appDesc"));
        software.setAppid(setJsonData(jsonobject1, "appid"));
        software.setAppName(setJsonData(jsonobject1, "appName"));
        software.setAppPicturePath(setJsonData(jsonobject1, "appPicturePath"));
        software.setAppRatingLevel(setJsonData(jsonobject1, "appRatingLevel"));
        software.setAppSize(setJsonData(jsonobject1, "appSize"));
        software.setAppSortNO(setJsonData(jsonobject1, "appSortNO"));
        software.setAppState(setJsonData(jsonobject1, "appState"));
        software.setAppVersion(setJsonData(jsonobject1, "appVersion"));
        software.setAppIconPath(setJsonData(jsonobject1, "appIconPath"));
        software.setAppPkgName(setJsonData(jsonobject1, "appPkgName"));
        software.setAppPkgVersionName(setJsonData(jsonobject1, "appPkgVersionName"));
        software.setAppPkgVersionCode(setJsonData(jsonobject1, "appPkgVersionCode"));
        software.setAppLanguage(setJsonData(jsonobject1, "appLanguage"));
        software.setAppDownPath(setJsonData(jsonobject1, "appDownPath"));
        software.setAppCreateTime(setJsonData(jsonobject1, "appCreateTime"));
        software.setAppscreenshoturl(setJsonData(jsonobject1, "appscreenshoturl"));
        software.setAppDownNum(setJsonData(jsonobject1, "appDownNum"));
        software.setAppType(setJsonData(jsonobject1, "appType"));
        software.setAppauthor(setJsonData(jsonobject1, "appauthor"));
        software.setAppBannerUrl(setJsonData(jsonobject1, "appBannerUrl"));
        software.setAppImgType(Integer.valueOf(setJsonData(jsonobject1, "appImgType")).intValue());
_L5:
        hashmap.put("softDetail", software);
_L4:
        doCallback(hashmap);
        hashmap.put("error", Integer.valueOf(0));
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        software.setAppImgType(0);
          goto _L5
        Exception exception;
        exception;
        exception.printStackTrace();
        if(true) goto _L7; else goto _L6
_L6:
    }

    private String setJsonData(JSONObject jsonobject, String s)
        throws JSONException
    {
        String s1;
        if(jsonobject.has(s))
            s1 = jsonobject.optString(s).replace("\n", "");
        else
            s1 = null;
        return s1;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground(aobj);
    }

    protected transient Map doInBackground(Object aobj[])
    {
        objCallBack = (CallBack)aobj[0];
        RHttpUtil rhttputil = new RHttpUtil(context);
        rhttputil.addParams("AppID", appid);
        return process(rhttputil.doGetRequest(UrlUtil.getMDUrl()));
    }

    protected void onPostExecute(Object obj)
    {
        super.onPostExecute(obj);
    }

    private String appid;
    private Activity context;
    private Handler handler;

}
