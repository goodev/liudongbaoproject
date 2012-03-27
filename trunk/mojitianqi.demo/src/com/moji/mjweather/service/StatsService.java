// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StatsService.java

package com.moji.mjweather.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.IBinder;
import android.util.Xml;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.util.FileUtil;
import com.moji.mjweather.util.HttpUtil;
import com.moji.mjweather.util.SkinUtil;
import com.moji.mjweather.util.StatsUtil;
import com.moji.mjweather.util.UrlUtil;
import com.moji.mjweather.util.Util;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

public class StatsService extends Service
{
    private class SendStatsThread extends Thread
    {

        public void run()
        {
            isAlive = true;
            boolean flag = false;
            try
            {
                if(Util.isConnectInternet(StatsService.this))
                {
                    flag = sendStats();
                    if(flag)
                    {
                        StatsUtil.deleteStatsFile();
                        StatsUtil.setNextSendTime(true);
                        StatsService.checkAdSwitch();
                        StatsService.downloadRecommendFile();
                    }
                }
            }
            catch(Exception exception)
            {
                MojiLog.e("StatsService", "error: ", exception);
            }
            if(!flag)
            {
                MojiLog.d("StatsService", "failed to send stat, will try again");
                StatsUtil.setRetryTime();
            }
            isAlive = false;
            stopSelf();
        }

        final StatsService this$0;

        private SendStatsThread()
        {
            this$0 = StatsService.this;
            super();
        }

    }


    public StatsService()
    {
        isAlive = false;
    }

    public static void checkAdSwitch()
    {
        XmlPullParser xmlpullparser;
        int i;
        InputStream inputstream = HttpUtil.doGet("ad.moji001.com", UrlUtil.getAdSwitcherURL(), 0L).mInputStream;
        xmlpullparser = Xml.newPullParser();
        xmlpullparser.setInput(inputstream, "utf-8");
        i = xmlpullparser.getEventType();
          goto _L1
_L3:
        i = xmlpullparser.next();
          goto _L1
_L7:
        if("s".equals(xmlpullparser.getName()) && xmlpullparser.getAttributeValue(null, "pos") != null && xmlpullparser.getAttributeValue(null, "pos").length() > 0 && Integer.parseInt(xmlpullparser.getAttributeValue(null, "pos")) == 2 && xmlpullparser.getAttributeValue(null, "pb").equals("umeng"))
            Gl.saveAdON(true);
        if(true) goto _L3; else goto _L2
_L2:
        Exception exception;
        exception;
        MojiLog.e("StatsService", "checkAdSwitch: ", exception);
_L5:
        MojiLog.d("StatsService", (new StringBuilder()).append("checkAdSwitch: ").append(Gl.getAdON()).toString());
        return;
_L1:
        if(i == 1) goto _L5; else goto _L4
_L4:
        i;
        JVM INSTR tableswitch 0 3: default 42
    //                   0 42
    //                   1 42
    //                   2 54
    //                   3 42;
           goto _L6 _L6 _L6 _L7 _L6
_L6:
        if(true) goto _L3; else goto _L8
_L8:
    }

    public static void checkAdSwitchAsync()
    {
        (new Thread() {

            public void run()
            {
                StatsService.checkAdSwitch();
            }

        }
).start();
    }

    public static boolean downloadRecommendFile()
    {
        String s = (new StringBuilder()).append("/weather/GetRecommend?").append(UrlUtil.getCommonPart()).append("&PartnerID=").append(Gl.getPartnerID()).toString();
        boolean flag = SkinUtil.download(Gl.Ct(), "weather.moji001.com", s, (new StringBuilder()).append(Gl.Ct().getFilesDir()).append("/").append("recommend.txt").toString());
        MojiLog.v("StatsService", (new StringBuilder()).append("downloadRecommendFile: ok = ").append(flag).toString());
        return flag;
    }

    private void outputToSDCardForTesting(boolean flag, String s)
    {
        if(flag && MojiLog.isDevelopMode())
        {
            FileUtil.newFolder("/sdcard/moji/stat");
            String as[] = (new File("/sdcard/moji/stat")).list();
            if(as != null && as.length > 10)
                FileUtil.delAllFile("/sdcard/moji/stat");
            FileUtil.newFile((new StringBuilder()).append("/sdcard/moji/stat/stat").append(System.currentTimeMillis()).append(".xml").toString(), s);
        }
    }

    private boolean processResult(ArrayList arraylist)
    {
        boolean flag;
        boolean flag3;
        boolean flag4;
        flag = false;
        String s = HttpUtil.getContent(arraylist, 0);
        boolean flag1 = "0".equals(s);
        boolean flag2 = "2".equals(s);
        flag3 = "5".equals(s);
        flag4 = "7".equals(s);
        if(flag1)
            flag = true;
        if(flag2)
        {
            flag = true;
            String s4 = HttpUtil.getContent(arraylist, 2).trim();
            if(s4.length() > 4)
            {
                Gl.saveMustUpdateUrl(s4.substring(4));
                Util.sendNotification(Gl.Ct().getResources().getString(0x7f0b017b));
            }
        }
        if(!flag3 && !flag4) goto _L2; else goto _L1
_L1:
        String s1;
        FileInputStream fileinputstream;
        flag = true;
        String s2;
        String s3;
        Map map;
        if(flag3)
            s1 = "newversion.xml";
        else
            s1 = "pushinfo.xml";
        if(flag3)
            s2 = "supd";
        else
            s2 = "adv";
        s3 = HttpUtil.getContent(arraylist, 1).trim();
        if(s3.length() <= 0) goto _L2; else goto _L3
_L3:
        FileUtil.savePrivateFile(s1, s3);
        fileinputstream = null;
        fileinputstream = Gl.Ct().openFileInput(s1);
        map = Util.parseNewVersionOrPushInfo(fileinputstream, s2);
        if(map.size() <= 0) goto _L5; else goto _L4
_L4:
        Util.sendNotification((String)map.get("info"));
_L6:
        Exception exception;
        FileNotFoundException filenotfoundexception;
        if(fileinputstream != null)
            try
            {
                fileinputstream.close();
            }
            catch(IOException ioexception2) { }
_L2:
        return flag;
_L5:
        Gl.Ct().deleteFile(s1);
          goto _L6
        filenotfoundexception;
        if(fileinputstream != null)
            try
            {
                fileinputstream.close();
            }
            catch(IOException ioexception1) { }
          goto _L2
        exception;
        if(fileinputstream != null)
            try
            {
                fileinputstream.close();
            }
            catch(IOException ioexception) { }
        throw exception;
    }

    private boolean sendStats()
        throws Exception
    {
        String s;
        MojiLog.v("StatsService", "sendStats");
        s = StatsUtil.getStatsContent();
        MojiLog.d("StatsService", (new StringBuilder()).append("content = ").append(s).toString());
        if(!s.equals("")) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L6:
        return flag;
_L2:
        URL url;
        HttpURLConnection httpurlconnection;
        DataOutputStream dataoutputstream;
        InputStream inputstream;
        flag = false;
        url = new URL(UrlUtil.getStatsURL("stat.moji001.com"));
        MojiLog.d("StatsService", (new StringBuilder()).append("staturl = ").append(url.toString()).toString());
        httpurlconnection = null;
        dataoutputstream = null;
        inputstream = null;
        if(!Util.isUsingWap(Gl.Ct())) goto _L4; else goto _L3
_L3:
        httpurlconnection = (HttpURLConnection)url.openConnection(new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort())));
_L7:
        StringBuilder stringbuilder;
        httpurlconnection.setDoInput(true);
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setUseCaches(false);
        httpurlconnection.setRequestMethod("POST");
        httpurlconnection.setRequestProperty("Connection", "Keep-Alive");
        httpurlconnection.setRequestProperty("Charset", "UTF-8");
        httpurlconnection.setRequestProperty("Content-Type", "Multipart/form-data;boundary=--www.mojichina.com--");
        HashMap hashmap = new HashMap();
        hashmap.put("UserID", Gl.getRegCode());
        hashmap.put("Platform", "android");
        hashmap.put("BaseOSVer", URLEncoder.encode(android.os.Build.VERSION.RELEASE));
        hashmap.put("Version", Gl.getVersion());
        hashmap.put("Device", "phone");
        hashmap.put("Model", URLEncoder.encode(Build.MODEL));
        hashmap.put("PartnerKey", Gl.getPartnerID());
        stringbuilder = new StringBuilder();
        for(Iterator iterator = hashmap.entrySet().iterator(); iterator.hasNext(); stringbuilder.append("\r\n"))
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            stringbuilder.append("--");
            stringbuilder.append("--www.mojichina.com--");
            stringbuilder.append("\r\n");
            stringbuilder.append((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append((String)entry.getKey()).append("\"\r\n\r\n").toString());
            stringbuilder.append((String)entry.getValue());
        }

          goto _L5
        Exception exception1;
        exception1;
_L10:
        MojiLog.e("StatsService", "Post Error: ", exception1);
        Exception exception;
        DataOutputStream dataoutputstream1;
        StringBuilder stringbuilder1;
        IOException ioexception4;
        IOException ioexception5;
        InputStreamReader inputstreamreader;
        BufferedReader bufferedreader;
        ArrayList arraylist;
        String s1;
        boolean flag1;
        if(dataoutputstream != null)
            try
            {
                dataoutputstream.close();
            }
            catch(IOException ioexception3) { }
        if(inputstream != null)
            try
            {
                inputstream.close();
            }
            catch(IOException ioexception2) { }
        httpurlconnection.disconnect();
        outputToSDCardForTesting(flag, s);
          goto _L6
_L4:
        httpurlconnection = (HttpURLConnection)url.openConnection();
          goto _L7
_L5:
        stringbuilder1 = new StringBuilder();
        stringbuilder1.append("--");
        stringbuilder1.append("--www.mojichina.com--");
        stringbuilder1.append("\r\n");
        stringbuilder1.append("Content-Disposition: form-data;name=\"StatFile\";filename=\"Stats.xml\"\r\n");
        stringbuilder1.append("Content-Type: application/xml\r\n\r\n");
        dataoutputstream1 = new DataOutputStream(httpurlconnection.getOutputStream());
        dataoutputstream1.write(stringbuilder.toString().getBytes());
        dataoutputstream1.write(stringbuilder1.toString().getBytes());
        dataoutputstream1.write(s.getBytes());
        dataoutputstream1.write("\r\n".getBytes());
        dataoutputstream1.write("----www.mojichina.com----\r\n".getBytes());
        dataoutputstream1.flush();
        MojiLog.d("StatsService", (new StringBuilder()).append("response code = ").append(httpurlconnection.getResponseCode()).toString());
        if(httpurlconnection.getResponseCode() != 200)
            break MISSING_BLOCK_LABEL_799;
        inputstream = httpurlconnection.getInputStream();
        inputstreamreader = new InputStreamReader(inputstream);
        bufferedreader = new BufferedReader(inputstreamreader);
        arraylist = new ArrayList();
        do
        {
            s1 = bufferedreader.readLine();
            if(s1 == null)
                break;
            arraylist.add(s1);
            MojiLog.d("StatsService", (new StringBuilder()).append("received = ").append(s1).toString());
        } while(true);
        flag1 = processResult(arraylist);
        flag = flag1;
        if(dataoutputstream1 != null)
            try
            {
                dataoutputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception5) { }
        if(inputstream != null)
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception4) { }
        httpurlconnection.disconnect();
        break MISSING_BLOCK_LABEL_505;
        exception;
_L9:
        if(dataoutputstream != null)
            try
            {
                dataoutputstream.close();
            }
            catch(IOException ioexception1) { }
        if(inputstream != null)
            try
            {
                inputstream.close();
            }
            catch(IOException ioexception) { }
        httpurlconnection.disconnect();
        throw exception;
        exception;
        dataoutputstream = dataoutputstream1;
        if(true) goto _L9; else goto _L8
_L8:
        exception1;
        dataoutputstream = dataoutputstream1;
          goto _L10
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        MojiLog.v("StatsService", "onCreate");
    }

    public void onDestroy()
    {
        super.onDestroy();
        MojiLog.v("StatsService", "onDestroy");
    }

    public void onStart(Intent intent, int i)
    {
        MojiLog.v("StatsService", "onStartCommand");
        if(!isAlive)
            (new SendStatsThread()).start();
        super.onStart(intent, i);
    }

    private static final String TAG = "StatsService";
    private static final String XML_TAG_PB = "pb";
    private static final String XML_TAG_POS = "pos";
    private static final String XML_TAG_S = "s";
    private boolean isAlive;


/*
    static boolean access$102(StatsService statsservice, boolean flag)
    {
        statsservice.isAlive = flag;
        return flag;
    }

*/

}
