// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HttpUtil.java

package com.moji.mjweather.util;

import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.data.CityWeatherInfo;
 import java.io.*;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.moji.mjweather.util:
//            Util, AndroidHttpClient, HttpDateTime

public final class HttpUtil
{
    public static class RequestResult
    {

        public static String millis2String(long l)
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
            simpledateformat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(l);
            return simpledateformat.format(calendar.getTime());
        }

        public static long string2Millis(String s)
        {
            return HttpDateTime.parse(s);
        }

        public static final String Content_Length = "Content-Length";
        public static final String If_Modified_Since = "If-Modified-Since";
        public static final String Last_Modified = "Last-Modified";
        public int mContentLength;
        public String mEntity;
        public InputStream mInputStream;
        public long mLastModifiedMillis;
        public boolean mNotModified;

        public RequestResult()
        {
        }
    }


    public HttpUtil()
    {
        mWebsite = null;
    }

    public HttpUtil(String s)
    {
        mWebsite = null;
        mWebsite = s;
    }

    private static String computeMD5(String s)
    {
 
        MessageDigest messagedigest=null;
		try {
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        char ac[] = s.toCharArray();
        byte abyte0[] = new byte[ac.length];
        for(int i = 0; i < ac.length; i++)
            abyte0[i] = (byte)ac[i];

        byte abyte1[] = messagedigest.digest(abyte0);
        StringBuffer stringbuffer = new StringBuffer();
        for(int j = 0; j < abyte1.length; j++)
        {
            int k = 0xff & abyte1[j];
            if(k < 16)
                stringbuffer.append("0");
            stringbuffer.append(Integer.toHexString(k));
        }

       return stringbuffer.toString();
 
    }

    public static RequestResult doGet(String s)
        throws Exception
    {
        return doGet(s, 0L);
    }

    public static RequestResult doGet(String s, long l)
        throws Exception
    {
        return doGet(null, s, l, true);
    }

    public static RequestResult doGet(String s, long l, boolean flag)
        throws Exception
    {
        return doGet(null, s, l, flag);
    }

    public static RequestResult doGet(String s, String s1)
        throws Exception
    {
        return doGet(s, s1, 0L, true);
    }

    public static RequestResult doGet(String s, String s1, long l)
        throws Exception
    {
        return doGet(s, s1, l, true);
    }

    public static RequestResult doGet(String s, String s1, long l, boolean flag)
        throws Exception
    {
        MojiLog.v("HttpUtil", (new StringBuilder()).append("website = ").append(s).append(", url = ").append(s1).toString());
        String s2;
        String s3;
        RequestResult requestresult;
        HttpGet httpget;
        DefaultHttpClient defaulthttpclient;
        HttpResponse httpresponse;
        int i;
        if(s == null || s.equals(""))
        {
            s2 = "weather.moji001.com";
            s3 = s1;
        } else
        {
            s2 = s;
            StringBuilder stringbuilder = (new StringBuilder()).append("http://").append(s);
            String s5;
            if(s1.startsWith("/"))
                s5 = "";
            else
                s5 = "/";
            s3 = stringbuilder.append(s5).append(s1).toString();
        }
        MojiLog.d("HttpUtil", (new StringBuilder()).append("fullUrl = ").append(s3).toString());
        requestresult = new RequestResult();
        httpget = new HttpGet();
        if(l > 0L)
        {
            String s4 = RequestResult.millis2String(l);
            httpget.addHeader("If-Modified-Since", s4);
            httpget.addHeader("Accept-Encoding", "gzip,deflate");
            MojiLog.d("HttpUtil", (new StringBuilder()).append("requestResults(), If-Modified-Since: ").append(s4).toString());
        }
        defaulthttpclient = new DefaultHttpClient();
        defaulthttpclient.getParams().setParameter("http.connection.timeout", Integer.valueOf(30000));
        defaulthttpclient.getParams().setParameter("http.socket.timeout", Integer.valueOf(30000));
        if(!Util.isUsingWap(Gl.Ct()))
        {
            httpget.setURI(new URI(s3));
            httpresponse = defaulthttpclient.execute(httpget);
        } else
        {
            MojiLog.d("HttpUtil", "isUsingWap");
            httpget.setURI(new URI(s1));
            HttpHost httphost = new HttpHost(s2, 80, "http");
            defaulthttpclient.getParams().setParameter("http.route.default-proxy", Util.GetAPNProxy());
            httpresponse = defaulthttpclient.execute(httphost, httpget);
        }
        if(httpresponse == null)
            i = -1;
        else
            i = httpresponse.getStatusLine().getStatusCode();
        MojiLog.d("HttpUtil", (new StringBuilder()).append("statusCode: ").append(i).toString());
        if(i == 200)
        {
            Header header;
            Header header1;
            if(flag)
                requestresult.mInputStream = httpresponse.getEntity().getContent();
            else
                requestresult.mEntity = EntityUtils.toString(httpresponse.getEntity());
            header = httpresponse.getFirstHeader("Content-Length");
            if(header != null)
            {
                requestresult.mContentLength = Integer.parseInt(header.getValue());
                MojiLog.d("HttpUtil", (new StringBuilder()).append("requestResults(), Content-Length: ").append(requestresult.mContentLength).toString());
            }
            header1 = httpresponse.getFirstHeader("Last-Modified");
            if(header1 != null)
            {
                MojiLog.d("HttpUtil", (new StringBuilder()).append("requestResults(), Last-Modified: ").append(header1.getValue()).toString());
                requestresult.mLastModifiedMillis = RequestResult.string2Millis(header1.getValue());
            }
        } else
        if(i == 304)
            requestresult.mNotModified = true;
        else
            MojiLog.d("HttpUtil", (new StringBuilder()).append("statusCode = ").append(i).toString());
        return requestresult;
    }

    public static String getCDNSecret()
    {
        BufferedReader bufferedreader;
        InputStream inputstream;
        String s;
        String s1;
        bufferedreader = null;
        inputstream = null;
        s = "mojisecret";
        try
        {
            inputstream = doGet("weather.moji001.com", "/weather/GetCDNSecret").mInputStream;
        }
        catch(Exception exception)
        {
            MojiLog.e("HttpUtil", "getCDNSecret: ", exception);
        }
        if(inputstream == null) {
 
        MojiLog.e("HttpUtil", "getCDNSecret: failed to get data.");
 
        return s ;}
 
        BufferedReader bufferedreader1 = new BufferedReader(new InputStreamReader(inputstream));
        do
        {
             
            try
            {
                String s2 = bufferedreader1.readLine();
                if(s2 == null)
                    break;
                String s3 = s2.trim();
                if(s3 == null || s3.equals(""))
                    continue;
                s = s3;
                Gl.saveCDNSecret(str2HexStr(s));
                MojiLog.d("HttpUtil", (new StringBuilder()).append("getCDNSecret: ").append(s).toString());
                break;
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception)
            {
                bufferedreader = bufferedreader1;
            }
 
        } while(true);
 
 
    return s;
    }

    public static String getContent(List list, int i)
    {
        String s;
        if(list == null || i < 0 || i >= list.size())
            s = "";
        else
            s = (String)list.get(i);
        return s;
    }

    public static String getMD5URL(String s, String s1)
    {
        String s2;
        s2 = hexStr2Str(Gl.getCDNSecret());
        if(s2 == null)
            return null;
        String s7 = getCDNSecret();
        s2 = s7;
 
        String s3 = (new StringBuilder()).append(s2).append(s).toString();
        String s4 = Long.toHexString(System.currentTimeMillis() / 1000L).toUpperCase();
        String s5 = computeMD5((new StringBuilder()).append(s3).append(s4).toString());
        String s6 = (new StringBuilder()).append(s5).append("/").append(s4).append(s).append(s1).toString();
        MojiLog.d("HttpUtil", (new StringBuilder()).append("getMD5Path()**path: ").append(s3).toString());
        MojiLog.d("HttpUtil", (new StringBuilder()).append("getMD5Path()**url: ").append(s6).toString());
        return s6;
         
    }

    private static String hexStr2Str(String s)
    {
        String s1;
        if(s == null || s.equals(""))
        {
            s1 = null;
        } else
        {
            char ac[] = s.toCharArray();
            byte abyte0[] = new byte[s.length() / 2];
            for(int i = 0; i < abyte0.length; i++)
                abyte0[i] = (byte)(0xff & 16 * "0123456789ABCDEF".indexOf(ac[i * 2]) + "0123456789ABCDEF".indexOf(ac[1 + i * 2]));

            s1 = new String(abyte0);
        }
        return s1;
    }

    private static String str2HexStr(String s)
    {
        char ac[] = "0123456789ABCDEF".toCharArray();
        StringBuilder stringbuilder = new StringBuilder("");
        byte abyte0[] = s.getBytes();
        for(int i = 0; i < abyte0.length; i++)
        {
            stringbuilder.append(ac[(0xf0 & abyte0[i]) >> 4]);
            stringbuilder.append(ac[0xf & abyte0[i]]);
        }

        return stringbuilder.toString();
    }

    /**
     * @deprecated Method cancel is deprecated
     */

    public void cancel()
    {
         
        mCanceled = true;
        close();
        
    }

    public void close()
    {
        if(mHttpClient == null)
            return;
        mHttpClient.close();
        MojiLog.d("HttpUtil", "closed");
 
    }

    public boolean doRequest(String s)
    {
return false;
    }

    public int getRespCode()
    {
        return mRespCode;
    }

    public ArrayList getResponse()
    {
        return mResponse;
    }

    /**
     * @deprecated Method isCanceled is deprecated
     */

    public boolean isCanceled()
    {
        
        boolean flag = mCanceled;
 
        return flag;
 
    }

    public void setWebsite(String s)
    {
        mWebsite = s;
    }

    private static final String HEX_CODE = "0123456789ABCDEF";
    private static final String TAG = "HttpUtil";
    private boolean mCanceled;
    private AndroidHttpClient mHttpClient;
    private int mRespCode;
    private ArrayList mResponse;
    private String mWebsite;
}
