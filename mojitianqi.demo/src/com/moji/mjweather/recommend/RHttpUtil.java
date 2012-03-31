// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RHttpUtil.java

package com.moji.mjweather.recommend;

import android.content.Context;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.zip.GZIPInputStream;
import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.*;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.moji.mjweather.recommend:
//            Response, Request

public class RHttpUtil
{

    public RHttpUtil(Context context)
    {
        paramsMap = null;
        httpClient = null;
        response = null;
        httpParams = null;
        mContext = context;
    }

    private boolean checkApnForProxy(Context context)
    {
        WifiManager wifimanager = (WifiManager)context.getSystemService("wifi");
        boolean flag = false;
        if(!wifimanager.isWifiEnabled())
        {
            String s = Proxy.getDefaultHost();
            if(s != null && !"".equals(s))
                flag = true;
        }
        if(flag)
        {
            System.getProperties().setProperty("http.proxyHost", Proxy.getDefaultHost());
            System.getProperties().setProperty("http.proxyPort", String.valueOf(Proxy.getDefaultPort()));
        }
        return flag;
    }

    public void addParams(String s, String s1)
    {
        if(paramsMap == null)
            paramsMap = new HashMap();
        paramsMap.put(s, s1);
    }

    public void cancel(boolean flag)
    {
        if(httpClient != null)
            httpClient.getConnectionManager().shutdown();
    }

    public Map doGetRequest(String s)
    {
        HashMap hashmap = new HashMap();
        httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, 60000);
        HttpConnectionParams.setSoTimeout(httpParams, 60000);
        HttpClientParams.setRedirecting(httpParams, true);
        HttpConnectionParams.setTcpNoDelay(httpParams, true);
        HttpConnectionParams.setSocketBufferSize(httpParams, 8192);
        HttpGet httpget = new HttpGet(s);
        if(httpClient == null)
        {
            httpClient = new DefaultHttpClient(httpParams);
            String s2 = Proxy.getDefaultHost();
            if(!((WifiManager)mContext.getSystemService("wifi")).isWifiEnabled() && s2 != null && !"".equals(s2))
            {
                HttpHost httphost = new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort(), "http");
                httpClient.getParams().setParameter("http.route.default-proxy", httphost);
            }
        }
        httpClient.getParams().setBooleanParameter("http.protocol.expect-continue", false);
        response = httpClient.execute(httpget);
        if(response == null) goto _L2; else goto _L1
_L1:
        if(response.getStatusLine().getStatusCode() != 200) goto _L4; else goto _L3
_L3:
        String s1 = EntityUtils.toString(response.getEntity());
        hashmap.put("errno", "0");
        hashmap.put("content", s1);
_L2:
        httpClient.getConnectionManager().shutdown();
_L5:
        return hashmap;
_L4:
        hashmap.put("errno", "1");
        hashmap.put("content", "error occurs");
        continue; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        hashmap.put("errno", "1");
        ioexception.printStackTrace();
        httpClient.getConnectionManager().shutdown();
          goto _L5
        Exception exception1;
        exception1;
        hashmap.put("errno", "1");
        exception1.printStackTrace();
        httpClient.getConnectionManager().shutdown();
          goto _L5
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        hashmap.put("errno", "1");
        System.gc();
        outofmemoryerror.printStackTrace();
        httpClient.getConnectionManager().shutdown();
          goto _L5
        Exception exception;
        exception;
        httpClient.getConnectionManager().shutdown();
        throw exception;
        if(true) goto _L2; else goto _L6
_L6:
    }

    public Response doRequest(Request request)
    {
        BufferedInputStream bufferedinputstream;
        BufferedOutputStream bufferedoutputstream;
        Response response1;
        boolean flag;
        bufferedinputstream = null;
        bufferedoutputstream = null;
        response1 = new Response();
        flag = false;
        HttpURLConnection httpurlconnection;
        BufferedOutputStream bufferedoutputstream1;
        URL url = new URL(request.getReqURL());
        flag = checkApnForProxy(mContext);
        httpurlconnection = (HttpURLConnection)url.openConnection();
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setDoInput(true);
        httpurlconnection.setUseCaches(false);
        httpurlconnection.setRequestMethod(request.getReqMethod());
        httpurlconnection.setConnectTimeout(sConnectTimeOut);
        httpurlconnection.setReadTimeout(sReadTimeOut);
        httpurlconnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
        HttpURLConnection.setFollowRedirects(true);
        if(!request.getReqMethod().equalsIgnoreCase("POST"))
            break MISSING_BLOCK_LABEL_191;
        httpurlconnection.setRequestProperty("Content-Type", request.getContentType());
        if(request.getReqData() == null)
            break MISSING_BLOCK_LABEL_191;
        httpurlconnection.setRequestProperty("Content-Length", String.valueOf(request.getReqData().length));
        bufferedoutputstream1 = new BufferedOutputStream(httpurlconnection.getOutputStream());
        bufferedoutputstream1.write(request.getReqData());
        bufferedoutputstream1.flush();
        bufferedoutputstream1.close();
        bufferedoutputstream = bufferedoutputstream1;
        String s;
        response1.setRespCode(httpurlconnection.getResponseCode());
        response1.setContentType(httpurlconnection.getContentType());
        s = httpurlconnection.getContentEncoding();
        if(s != null) goto _L2; else goto _L1
_L1:
        Object obj = httpurlconnection.getInputStream();
_L4:
        BufferedInputStream bufferedinputstream1 = new BufferedInputStream(((java.io.InputStream) (obj)));
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        do
        {
            int i = bufferedinputstream1.read(abyte0);
            if(i <= 0)
                break;
            bytearrayoutputstream.write(abyte0, 0, i);
        } while(true);
          goto _L3
        MalformedURLException malformedurlexception;
        malformedurlexception;
        bufferedinputstream = bufferedinputstream1;
_L10:
        malformedurlexception.printStackTrace();
        response1 = null;
        if(flag)
        {
            System.getProperties().remove("http.proxyHost");
            System.getProperties().remove("http.proxyPort");
        }
        byte abyte1[];
        IOException ioexception5;
        Exception exception5;
        java.io.InputStream inputstream;
        if(bufferedinputstream != null)
            try
            {
                bufferedinputstream.close();
            }
            catch(Exception exception2)
            {
                exception2.printStackTrace();
            }
        if(bufferedoutputstream != null)
            try
            {
                bufferedoutputstream.close();
            }
            catch(IOException ioexception1)
            {
                ioexception1.printStackTrace();
            }
_L5:
        return response1;
_L2:
label0:
        {
            if(!s.contains("gzip"))
                break label0;
            obj = new GZIPInputStream(httpurlconnection.getInputStream());
        }
          goto _L4
        inputstream = httpurlconnection.getInputStream();
        obj = inputstream;
          goto _L4
_L3:
        abyte1 = bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.close();
        bufferedinputstream1.close();
        response1.setRespData(abyte1);
        if(flag)
        {
            System.getProperties().remove("http.proxyHost");
            System.getProperties().remove("http.proxyPort");
        }
        if(bufferedinputstream1 != null)
            try
            {
                bufferedinputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch(Exception exception5)
            {
                exception5.printStackTrace();
            }
        if(bufferedoutputstream != null)
            try
            {
                bufferedoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception5)
            {
                ioexception5.printStackTrace();
            }
        break MISSING_BLOCK_LABEL_336;
        ProtocolException protocolexception;
        protocolexception;
_L9:
        protocolexception.printStackTrace();
        response1 = null;
        if(flag)
        {
            System.getProperties().remove("http.proxyHost");
            System.getProperties().remove("http.proxyPort");
        }
        if(bufferedinputstream != null)
            try
            {
                bufferedinputstream.close();
            }
            catch(Exception exception4)
            {
                exception4.printStackTrace();
            }
        if(bufferedoutputstream != null)
            try
            {
                bufferedoutputstream.close();
            }
            catch(IOException ioexception4)
            {
                ioexception4.printStackTrace();
            }
          goto _L5
        IOException ioexception2;
        ioexception2;
_L8:
        ioexception2.printStackTrace();
        response1 = null;
        if(flag)
        {
            System.getProperties().remove("http.proxyHost");
            System.getProperties().remove("http.proxyPort");
        }
        if(bufferedinputstream != null)
            try
            {
                bufferedinputstream.close();
            }
            catch(Exception exception3)
            {
                exception3.printStackTrace();
            }
        if(bufferedoutputstream != null)
            try
            {
                bufferedoutputstream.close();
            }
            catch(IOException ioexception3)
            {
                ioexception3.printStackTrace();
            }
          goto _L5
        Exception exception;
        exception;
_L7:
        if(flag)
        {
            System.getProperties().remove("http.proxyHost");
            System.getProperties().remove("http.proxyPort");
        }
        if(bufferedinputstream != null)
            try
            {
                bufferedinputstream.close();
            }
            catch(Exception exception1)
            {
                exception1.printStackTrace();
            }
        if(bufferedoutputstream != null)
            try
            {
                bufferedoutputstream.close();
            }
            catch(IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        throw exception;
        exception;
        bufferedoutputstream = bufferedoutputstream1;
        continue; /* Loop/switch isn't completed */
        exception;
        bufferedinputstream = bufferedinputstream1;
        if(true) goto _L7; else goto _L6
_L6:
        ioexception2;
        bufferedoutputstream = bufferedoutputstream1;
          goto _L8
        ioexception2;
        bufferedinputstream = bufferedinputstream1;
          goto _L8
        protocolexception;
        bufferedoutputstream = bufferedoutputstream1;
          goto _L9
        protocolexception;
        bufferedinputstream = bufferedinputstream1;
          goto _L9
        malformedurlexception;
          goto _L10
        malformedurlexception;
        bufferedoutputstream = bufferedoutputstream1;
          goto _L10
    }

    private static int sConnectTimeOut = 60000;
    private static int sReadTimeOut = 60000;
    private DefaultHttpClient httpClient;
    private HttpParams httpParams;
    private Context mContext;
    private HashMap paramsMap;
    private HttpResponse response;

}
