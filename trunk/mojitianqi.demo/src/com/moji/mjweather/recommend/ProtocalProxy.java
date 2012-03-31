// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ProtocalProxy.java

package com.moji.mjweather.recommend;

import android.content.Context;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.util.UrlUtil;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.*;

// Referenced classes of package com.moji.mjweather.recommend:
//            Request, RHttpUtil, Response, SoftWare, 
//            RecommendListActivity, RC

public class ProtocalProxy
{

    public ProtocalProxy()
    {
    }

    public static int getAppListReq(Context context, boolean flag, int i)
    {
        com/moji/mjweather/recommend/ProtocalProxy;
        JVM INSTR monitorenter ;
        i;
        JVM INSTR tableswitch 1 4: default 36
    //                   1 106
    //                   2 106
    //                   3 83
    //                   4 83;
           goto _L1 _L2 _L2 _L3 _L3
_L1:
        String s1 = UrlUtil.getMDUrl();
        String s = s1;
_L7:
        Response response;
        Request request = new Request(s);
        response = (new RHttpUtil(context)).doRequest(request);
        if(response != null) goto _L5; else goto _L4
_L4:
        int j = 1;
          goto _L6
_L3:
        s = UrlUtil.getBAUrl(i);
        MojiLog.d("ProtocalProxy", s);
          goto _L7
        Exception exception;
        exception;
        throw exception;
_L2:
        s = UrlUtil.getMDUrl();
        MojiLog.d("ProtocalProxy", s);
          goto _L7
_L5:
        int k = parseAppListResp(context, response, flag, i);
        j = k;
        if(j != 0);
        com/moji/mjweather/recommend/ProtocalProxy;
        JVM INSTR monitorexit ;
          goto _L6
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        j = 3;
        com/moji/mjweather/recommend/ProtocalProxy;
        JVM INSTR monitorexit ;
          goto _L6
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        j = 4;
        com/moji/mjweather/recommend/ProtocalProxy;
        JVM INSTR monitorexit ;
_L6:
        return j;
    }

    public static boolean getExistData(int i)
    {
        boolean flag;
        BufferedReader bufferedreader;
        FileInputStream fileinputstream;
        File file;
        flag = false;
        bufferedreader = null;
        fileinputstream = null;
        file = Gl.Ct().getFileStreamPath((new StringBuilder()).append(i).append("_place.txt").toString());
        if(!file.exists()) goto _L2; else goto _L1
_L1:
        FileInputStream fileinputstream1 = new FileInputStream(file);
        BufferedReader bufferedreader1 = new BufferedReader(new InputStreamReader(fileinputstream1));
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        do
        {
            String s = bufferedreader1.readLine();
            if(s == null)
                break;
            stringbuilder.append(s);
        } while(true);
          goto _L3
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        fileinputstream = fileinputstream1;
        bufferedreader = bufferedreader1;
_L13:
        filenotfoundexception.printStackTrace();
        flag = false;
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_125;
        fileinputstream.close();
        if(bufferedreader != null)
            bufferedreader.close();
_L6:
        return flag;
_L3:
        int j = stringbuilder.length();
        if(j != 0) goto _L5; else goto _L4
_L4:
        fileinputstream = fileinputstream1;
        bufferedreader = bufferedreader1;
_L2:
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_161;
        fileinputstream.close();
        if(bufferedreader != null)
            bufferedreader.close();
          goto _L6
        Exception exception4;
        exception4;
        exception4.printStackTrace();
          goto _L6
_L5:
        boolean flag1 = parseExistData(i, stringbuilder.toString());
        flag = flag1;
        fileinputstream = fileinputstream1;
        bufferedreader = bufferedreader1;
          goto _L2
        Exception exception2;
        exception2;
        exception2.printStackTrace();
          goto _L6
        IOException ioexception;
        ioexception;
_L11:
        ioexception.printStackTrace();
        flag = false;
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_232;
        fileinputstream.close();
        if(bufferedreader != null)
            bufferedreader.close();
          goto _L6
        Exception exception3;
        exception3;
        exception3.printStackTrace();
          goto _L6
        Exception exception;
        exception;
_L10:
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_263;
        fileinputstream.close();
        if(bufferedreader != null)
            bufferedreader.close();
_L8:
        throw exception;
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        if(true) goto _L8; else goto _L7
_L7:
        exception;
        fileinputstream = fileinputstream1;
        continue; /* Loop/switch isn't completed */
        exception;
        fileinputstream = fileinputstream1;
        bufferedreader = bufferedreader1;
        if(true) goto _L10; else goto _L9
_L9:
        ioexception;
        fileinputstream = fileinputstream1;
          goto _L11
        ioexception;
        fileinputstream = fileinputstream1;
        bufferedreader = bufferedreader1;
          goto _L11
        filenotfoundexception;
        continue; /* Loop/switch isn't completed */
        filenotfoundexception;
        fileinputstream = fileinputstream1;
        if(true) goto _L13; else goto _L12
_L12:
    }

    private static int parseAppListResp(Context context, Response response, boolean flag, int i)
        throws UnsupportedEncodingException, JSONException
    {
        String s = new String(response.getRespData(), "utf-8");
        if(response.getRespCode() != 200) goto _L2; else goto _L1
_L1:
        final ArrayList softWareList;
        JSONObject jsonobject;
        softWareList = new ArrayList();
        jsonobject = new JSONObject(s);
        saveToFile(context, s, i);
        JSONArray jsonarray;
        int k;
        int l;
        jsonarray = jsonobject.getJSONArray("topData");
        k = jsonarray.length();
        l = 0;
_L3:
        if(l >= k)
            break MISSING_BLOCK_LABEL_116;
        SoftWare software = SoftWare.parseJson(jsonarray.getJSONObject(l));
        if(software != null)
            softWareList.add(software);
        l++;
          goto _L3
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        int j;
        if(!softWareList.isEmpty())
        {
            if(flag && RecommendListActivity.instance != null)
                RecommendListActivity.instance.runOnUiThread(new Runnable() {

                    public void run()
                    {
                        RecommendListActivity.instance.refreshListData(softWareList);
                    }

                    final ArrayList val$softWareList;

            
            {
                softWareList = arraylist;
                super();
            }
                }
);
            RC.categorysMap.put(Integer.valueOf(i), softWareList);
            j = 0;
        } else
        {
            j = 5;
        }
_L5:
        return j;
_L2:
        j = 2;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public static boolean parseExistData(int i, String s)
    {
        boolean flag;
        ArrayList arraylist;
        flag = true;
        arraylist = new ArrayList();
        JSONArray jsonarray;
        int j;
        jsonarray = (new JSONObject(s)).getJSONArray("topData");
        j = jsonarray.length();
        if(j != 0)
            break MISSING_BLOCK_LABEL_100;
        break MISSING_BLOCK_LABEL_98;
        k = 0;
        JSONException jsonexception;
        int k;
        for(; k < j; k++)
        {
            SoftWare software = SoftWare.parseJson(jsonarray.getJSONObject(k));
            if(software != null)
                arraylist.add(software);
            break MISSING_BLOCK_LABEL_106;
        }

        RC.categorysMap.put(Integer.valueOf(i), arraylist);
        break MISSING_BLOCK_LABEL_98;
        jsonexception;
        jsonexception.printStackTrace();
        flag = false;
        return flag;
    }

    private static void saveToFile(Context context, String s, int i)
    {
        String s1;
        FileOutputStream fileoutputstream;
        BufferedWriter bufferedwriter;
        s1 = (new StringBuilder()).append(i).append("_place.txt").toString();
        fileoutputstream = null;
        bufferedwriter = null;
        BufferedWriter bufferedwriter1;
        fileoutputstream = context.openFileOutput(s1, 0);
        bufferedwriter1 = new BufferedWriter(new OutputStreamWriter(fileoutputstream));
        bufferedwriter1.write(s);
        bufferedwriter1.flush();
        if(fileoutputstream == null)
            break MISSING_BLOCK_LABEL_73;
        fileoutputstream.close();
        if(bufferedwriter1 != null)
            bufferedwriter1.close();
_L1:
        return;
        IOException ioexception4;
        ioexception4;
        ioexception4.printStackTrace();
          goto _L1
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
_L7:
        filenotfoundexception.printStackTrace();
        if(fileoutputstream == null)
            break MISSING_BLOCK_LABEL_111;
        fileoutputstream.close();
        if(bufferedwriter != null)
            bufferedwriter.close();
          goto _L1
        IOException ioexception3;
        ioexception3;
        ioexception3.printStackTrace();
          goto _L1
        IOException ioexception1;
        ioexception1;
_L6:
        ioexception1.printStackTrace();
        if(fileoutputstream == null)
            break MISSING_BLOCK_LABEL_151;
        fileoutputstream.close();
        if(bufferedwriter != null)
            bufferedwriter.close();
          goto _L1
        IOException ioexception2;
        ioexception2;
        ioexception2.printStackTrace();
          goto _L1
        Exception exception;
        exception;
_L5:
        if(fileoutputstream == null)
            break MISSING_BLOCK_LABEL_186;
        fileoutputstream.close();
        if(bufferedwriter != null)
            bufferedwriter.close();
_L3:
        throw exception;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        if(true) goto _L3; else goto _L2
_L2:
        exception;
        bufferedwriter = bufferedwriter1;
        if(true) goto _L5; else goto _L4
_L4:
        ioexception1;
        bufferedwriter = bufferedwriter1;
          goto _L6
        filenotfoundexception;
        bufferedwriter = bufferedwriter1;
          goto _L7
    }

    private static final String APPLIST_TOPDATA = "topData";
    public static final String OSTYPE_ANDROID = "0";
    public static final String PARAM_APPID = "appid";
    public static final String PARAM_OSTYPE = "ostype";
    public static final String PARAM_SDID = "sdid";
    public static final String PARAM_USERNAME = "username";
    public static final String PARAM_V = "v";
    public static final int RESULT_DATA_ISEMPTY = 5;
    public static final int RESULT_JSONEXCEPTION = 4;
    public static final int RESULT_NO_PARAM = -1;
    public static final int RESULT_OK = 0;
    public static final int RESULT_REQUEST_ERROR = 1;
    public static final int RESULT_RESPONSE_ERROR = 2;
    public static final int RESULT_UNSUPPORTEDENCODING = 3;
    public static final String SERVER_VERSION = "1.0";
    private static final String TAG = "ProtocalProxy";
}
