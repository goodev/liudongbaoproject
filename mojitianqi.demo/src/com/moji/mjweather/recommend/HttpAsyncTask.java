// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HttpAsyncTask.java

package com.moji.mjweather.recommend;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.moji.mjweather.recommend:
//            CallBack

public class HttpAsyncTask extends AsyncTask
{

    public HttpAsyncTask(Activity activity1)
    {
        objCallBack = null;
        activity = activity1;
    }

    protected void doCallback(Map map)
    {
        if(objCallBack != null)
            objCallBack.doCallBack(map);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground(aobj);
    }

    protected transient Map doInBackground(Object aobj[])
    {
        return null;
    }

    protected JSONObject doPreparePostExcute(Object obj, Map map)
    {
        String s;
        String s1;
        map.put("error", Integer.valueOf(1));
        Map map1 = (Map)obj;
        s = (String)map1.get("errno");
        s1 = (String)map1.get("content");
        if(s.equals("0")) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        doCallback(map);
        jsonobject = null;
_L4:
        return jsonobject;
_L2:
        int i;
        i = 1;
        jsonobject = null;
        JSONObject jsonobject1 = new JSONObject(s1);
        if(jsonobject1 == null)
            break MISSING_BLOCK_LABEL_103;
        int j = jsonobject1.getInt("errno");
        i = j;
        jsonobject = jsonobject1;
_L5:
        map.put("error", Integer.valueOf(i));
        if(i != 0)
        {
            doCallback(map);
            jsonobject = null;
        }
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
_L6:
        Log.d("HttpAsyncTask", exception.toString());
          goto _L5
        exception;
        jsonobject = jsonobject1;
          goto _L6
    }

    protected Activity activity;
    protected CallBack objCallBack;
}
