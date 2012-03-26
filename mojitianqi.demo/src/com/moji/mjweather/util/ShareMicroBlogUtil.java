// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ShareMicroBlogUtil.java

package com.moji.mjweather.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Proxy;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.data.ForecastInfo;
import com.moji.mjweather.data.WeatherAlertInfo;
import com.moji.mjweather.data.WeatherMainInfo;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.moji.mjweather.util:
//            Util, UiUtil

public class ShareMicroBlogUtil
{
    public static enum ChannelType  
    {
 
         CHANNEL_KAIXIN,CHANNEL_RENREN,CHANNEL_SINA,CHANNEL_TENCENT;

         
    }


    public ShareMicroBlogUtil()
    {
    }

     

    public static Integer autoSharMicroBlog(String s, String s1, String s2, int i, boolean flag, int j)
    {
return 0;
    }

    private static String getQuaryParse(Map map)
    {
        Object aobj[] = map.keySet().toArray();
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < aobj.length; i++)
        {
            if(i > 0)
                stringbuffer.append("&");
            stringbuffer.append((new StringBuilder()).append(aobj[i]).append("=").append(URLEncoder.encode((String)map.get(aobj[i]))).toString());
        }

        return stringbuffer.toString();
    }

   

    private static String getUserID()
    {
        return Gl.getRegCode();
    }

    private static String getVersion()
    {
        return Gl.getVersion();
    }

   
    private static byte[] readImageFile(String s)
        throws IOException
    {
        BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(s));
        int i = bufferedinputstream.available();
        byte abyte0[] = new byte[i];
        if(i != bufferedinputstream.read(abyte0))
            abyte0 = null;
        bufferedinputstream.close();
        return abyte0;
    }

    public static Bitmap saveCityViewBitmap(Context context)
    {
        return saveCityViewBitmap(context, -1);
    }

    public static Bitmap saveCityViewBitmap(Context context, int i)
    {
        int j = i;
        if(j < 0)
        {
            j = Gl.getAutoShareCity().intValue();
            if(j == -1)
                j = Gl.getCurrentCityIndex();
        }
        CityWeatherInfo cityweatherinfo = WeatherData.getCityInfo(j);
        Bitmap bitmap = BitmapFactory.decodeStream(context.getResources().openRawResource(UiUtil.getWeatherBgResourceId(cityweatherinfo.mWeatherMainInfo.mWeatherId, UiUtil.isDay(cityweatherinfo))));
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, 480, 816);
        bitmap.recycle();
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint(1);
        paint.setColor(0x4d000000);
        Paint paint1 = new Paint();
        paint1.setAntiAlias(true);
        paint1.setDither(true);
        RectF rectf = new RectF();
        rectf.set(0F, 0F, canvas.getWidth(), 45F * 1.5F);
        Bitmap bitmap2 = BitmapFactory.decodeStream(context.getResources().openRawResource(0x7f020148));
        NinePatch ninepatch = new NinePatch(bitmap2, bitmap2.getNinePatchChunk(), null);
        ninepatch.draw(canvas, rectf);
        Bitmap bitmap3 = BitmapFactory.decodeResource(context.getResources(), 0x7f020149);
        canvas.drawBitmap(bitmap3, 0F, (45F * 1.5F) / 2F - (float)(bitmap3.getHeight() / 2), null);
        Bitmap bitmap4 = BitmapFactory.decodeResource(context.getResources(), 0x7f020156);
        canvas.drawBitmap(bitmap4, canvas.getWidth() - bitmap4.getWidth(), (45F * 1.5F) / 2F - (float)(bitmap4.getHeight() / 2), null);
        RectF rectf1 = new RectF();
        rectf1.set(bitmap3.getWidth(), 0F, canvas.getWidth() - bitmap4.getWidth(), 45F * 1.5F);
        Bitmap bitmap5 = BitmapFactory.decodeStream(context.getResources().openRawResource(0x7f020150));
        NinePatch ninepatch1 = new NinePatch(bitmap5, bitmap5.getNinePatchChunk(), null);
        ninepatch1.draw(canvas, rectf1);
        paint1.setTextAlign(android.graphics.Paint.Align.CENTER);
        paint1.setTextSize(20F * 1.5F);
        paint1.setColor(-1);
        canvas.drawText(cityweatherinfo.mCityName, canvas.getWidth() / 2, (45F * 1.5F) / 2F - paint1.getFontMetrics().ascent / 2F, paint1);
        Bitmap bitmap6 = BitmapFactory.decodeResource(context.getResources(), 0x7f020158);
        canvas.drawBitmap(bitmap6, canvas.getWidth() - bitmap4.getWidth() - bitmap6.getWidth(), (45F * 1.5F) / 2F - (float)(bitmap6.getHeight() / 2), null);
        paint1.setTextSize(115F * 1.5F);
        paint1.setColor(-1);
        paint1.setTextAlign(android.graphics.Paint.Align.RIGHT);
        paint1.setShadowLayer(0.1F * 1.5F, 3F * 1.5F, 3F * 1.5F, 0x66202020);
        canvas.drawText((new StringBuilder()).append(cityweatherinfo.mWeatherMainInfo.mCurrentTemperature).append("\260").toString(), canvas.getWidth(), 0.3F * (float)canvas.getHeight(), paint1);
        float f = 0.37F * (float)canvas.getHeight();
        float f1 = 0.12F * (float)canvas.getHeight();
        float f2 = 1.5F * 7F;
        float f3 = (float)(5 * (canvas.getWidth() / 9)) + 8F * 1.5F;
        Bitmap bitmap7 = BitmapFactory.decodeStream(context.getResources().openRawResource(0x7f0200b5));
        NinePatch ninepatch2 = new NinePatch(bitmap7, bitmap7.getNinePatchChunk(), null);
        RectF rectf2 = new RectF();
        rectf2.set(f3, f, canvas.getWidth(), f + f1);
        ninepatch2.draw(canvas, rectf2);
        rectf2.set(f3, f2 + (f + f1), canvas.getWidth(), f2 + (f + 2F * f1));
        ninepatch2.draw(canvas, rectf2);
        rectf2.set(f3, f + 2F * f1 + 2F * f2, canvas.getWidth(), f + 3F * f1 + 2F * f2);
        ninepatch2.draw(canvas, rectf2);
        rectf2.set(f3, f + 3F * f1 + 3F * f2, canvas.getWidth(), f + 4F * f1 + 3F * f2);
        ninepatch2.draw(canvas, rectf2);
        paint1.reset();
        paint1.setDither(true);
        float f4;
        float f5;
        float f6;
        RectF rectf3;
        Bitmap bitmap8;
        RectF rectf4;
        Bitmap bitmap9;
        RectF rectf5;
        Bitmap bitmap10;
        RectF rectf6;
        Bitmap bitmap11;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        Bitmap bitmap12;
        Bitmap bitmap13;
        if(UiUtil.isNeedSetBlackColor(UiUtil.getWeatherID(cityweatherinfo.mWeatherMainInfo.mWeatherId, UiUtil.isDay(cityweatherinfo))))
            paint1.setColor(0xff000000);
        else
            paint1.setColor(-1);
        paint1.setAntiAlias(true);
        paint1.setTextAlign(android.graphics.Paint.Align.RIGHT);
        paint1.setTextSize(16F * 1.5F);
        f4 = (float)canvas.getWidth() - f3;
        f5 = f1 + f2;
        canvas.drawText(Util.GetWeekName(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(0)).mWeek), f3 + 7F * (f4 / 12F), (f + f1 / 2F) - paint1.getFontMetrics().descent, paint1);
        canvas.drawText((new StringBuilder()).append(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(0)).mLowTemperature).append("\260C").append("/").append(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(0)).mHighTemperature).append("\260C").toString(), f3 + 7F * (f4 / 12F), ((f + f1 / 2F) - paint1.getFontMetrics().ascent) + paint1.getFontMetrics().descent, paint1);
        canvas.drawText(Util.GetWeekName(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(1)).mWeek), f3 + 7F * (f4 / 12F), (f5 + f + f1 / 2F) - paint1.getFontMetrics().descent, paint1);
        canvas.drawText((new StringBuilder()).append(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(1)).mLowTemperature).append("\260C").append("/").append(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(1)).mHighTemperature).append("\260C").toString(), f3 + 7F * (f4 / 12F), ((f5 + f + f1 / 2F) - paint1.getFontMetrics().ascent) + paint1.getFontMetrics().descent, paint1);
        canvas.drawText(Util.GetWeekName(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(2)).mWeek), f3 + 7F * (f4 / 12F), (f + 2F * f5 + f1 / 2F) - paint1.getFontMetrics().descent, paint1);
        canvas.drawText((new StringBuilder()).append(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(2)).mLowTemperature).append("\260C").append("/").append(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(2)).mHighTemperature).append("\260C").toString(), f3 + 7F * (f4 / 12F), ((f + 2F * f5 + f1 / 2F) - paint1.getFontMetrics().ascent) + paint1.getFontMetrics().descent, paint1);
        canvas.drawText(Util.GetWeekName(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(3)).mWeek), f3 + 7F * (f4 / 12F), (f + 3F * f5 + f1 / 2F) - paint1.getFontMetrics().descent, paint1);
        canvas.drawText((new StringBuilder()).append(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(3)).mLowTemperature).append("\260C").append("/").append(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(3)).mHighTemperature).append("\260C").toString(), f3 + 7F * (f4 / 12F), ((f + 3F * f5 + f1 / 2F) - paint1.getFontMetrics().ascent) + paint1.getFontMetrics().descent, paint1);
        f6 = 50F * 1.5F;
        rectf3 = new RectF(f3 + 7F * (f4 / 12F), (f + f1 / 2F) - f6 / 2F, f6 + (f3 + 7F * (f4 / 12F)), f + f1 / 2F + f6 / 2F);
        bitmap8 = BitmapFactory.decodeResource(context.getResources(), UiUtil.getWeatherIconResouceId(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(0)).mWeatherIconId, true));
        canvas.drawBitmap(bitmap8, null, rectf3, null);
        bitmap8.recycle();
        rectf4 = new RectF(f3 + 7F * (f4 / 12F), (f5 + f + f1 / 2F) - f6 / 2F, f6 + (f3 + 7F * (f4 / 12F)), f5 + f + f1 / 2F + f6 / 2F);
        bitmap9 = BitmapFactory.decodeResource(context.getResources(), UiUtil.getWeatherIconResouceId(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(1)).mWeatherIconId, true));
        canvas.drawBitmap(bitmap9, null, rectf4, null);
        bitmap9.recycle();
        rectf5 = new RectF(f3 + 7F * (f4 / 12F), (f + 2F * f5 + f1 / 2F) - f6 / 2F, f6 + (f3 + 7F * (f4 / 12F)), f + 2F * f5 + f1 / 2F + f6 / 2F);
        bitmap10 = BitmapFactory.decodeResource(context.getResources(), UiUtil.getWeatherIconResouceId(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(2)).mWeatherIconId, true));
        canvas.drawBitmap(bitmap10, null, rectf5, null);
        bitmap10.recycle();
        rectf6 = new RectF(f3 + 7F * (f4 / 12F), (f + 3F * f5 + f1 / 2F) - f6 / 2F, f6 + (f3 + 7F * (f4 / 12F)), f + 3F * f5 + f1 / 2F + f6 / 2F);
        bitmap11 = BitmapFactory.decodeResource(context.getResources(), UiUtil.getWeatherIconResouceId(((ForecastInfo)cityweatherinfo.mWeatherMainInfo.mForecastInfoList.get(3)).mWeatherIconId, true));
        canvas.drawBitmap(bitmap11, null, rectf6, null);
        bitmap11.recycle();
        f7 = ((float)canvas.getHeight() - 45F * 1.5F) / 3F + 45F * 1.5F + (2F * (((float)canvas.getHeight() - 45F * 1.5F) / 3F)) / 4F + 18F * 1.5F;
        f8 = 10F * 1.5F;
        paint1.reset();
        paint1.setAntiAlias(true);
        paint1.setTextSize(18F * 1.5F);
        paint1.setTextAlign(android.graphics.Paint.Align.LEFT);
        if(cityweatherinfo.mWeatherAlertInfoList.size() > 0)
        {
            WeatherAlertInfo weatheralertinfo = (WeatherAlertInfo)cityweatherinfo.mWeatherAlertInfoList.get(0);
            paint1.setColor(UiUtil.getWeatherAlertTextColor(Integer.parseInt(weatheralertinfo.mAlertIconId)));
            Bitmap bitmap14 = BitmapFactory.decodeResource(context.getResources(), UiUtil.getWeatherAlertIcon(Integer.parseInt(weatheralertinfo.mAlertIconId)));
            Bitmap bitmap15 = Bitmap.createScaledBitmap(bitmap14, (int)(0.69999999999999996D * (double)bitmap14.getWidth()), (int)(0.69999999999999996D * (double)bitmap14.getHeight()), true);
            canvas.drawBitmap(bitmap15, f8, f7 - (float)bitmap15.getHeight() - 5F * 1.5F, null);
            canvas.drawText(weatheralertinfo.mAlertDescription, f8 + (float)bitmap15.getWidth(), ((f7 - (float)bitmap15.getHeight() - 5F * 1.5F) + (float)(bitmap15.getHeight() / 2)) - paint1.getFontMetrics().ascent / 2F, paint1);
            bitmap14.recycle();
        }
        if(UiUtil.isNeedSetBlackColor(UiUtil.getWeatherID(cityweatherinfo.mWeatherMainInfo.mWeatherId, UiUtil.isDay(cityweatherinfo))))
            paint1.setColor(0xff000000);
        else
            paint1.setColor(-1);
        paint1.setTextSize(31F * 1.5F);
        paint1.setTextAlign(android.graphics.Paint.Align.LEFT);
        f9 = (f7 - paint1.getFontMetrics().ascent) + paint1.getFontMetrics().descent;
        canvas.drawText(cityweatherinfo.mWeatherMainInfo.mWeatherDescription, f8, f9, paint1);
        paint1.reset();
        paint1.setDither(true);
        if(UiUtil.isNeedSetBlackColor(UiUtil.getWeatherID(cityweatherinfo.mWeatherMainInfo.mWeatherId, UiUtil.isDay(cityweatherinfo))))
            paint1.setColor(0xff000000);
        else
            paint1.setColor(-1);
        paint1.setAntiAlias(true);
        paint1.setTextSize(19F * 1.5F);
        f10 = (f9 + 20F * 1.5F) - paint1.getFontMetrics().ascent;
        if(cityweatherinfo.mWeatherMainInfo.mHighTemperature == 100)
            canvas.drawText((new StringBuilder()).append(context.getResources().getString(0x7f0b0275)).append(cityweatherinfo.mWeatherMainInfo.mLowTemperature).append("\260C").toString(), f8, f10, paint1);
        else
            canvas.drawText((new StringBuilder()).append(cityweatherinfo.mWeatherMainInfo.mLowTemperature).append("\260C").append("~").append(cityweatherinfo.mWeatherMainInfo.mHighTemperature).append("\260C").toString(), f8, f10, paint1);
        f11 = (f10 + 10F * 1.5F) - paint1.getFontMetrics().ascent;
        canvas.drawText((new StringBuilder()).append(cityweatherinfo.mWeatherMainInfo.mWindDirection).append(cityweatherinfo.mWeatherMainInfo.mWindSpeed).append(context.getResources().getString(0x7f0b0135)).toString(), f8, f11, paint1);
        paint1.setTextSize(15F * 1.5F);
        f12 = (f11 + 20F * 1.5F) - paint1.getFontMetrics().ascent;
        canvas.drawText((new StringBuilder()).append(Util.getParserDate(cityweatherinfo.mWeatherMainInfo.mSolarUpdateDate)).append(" ").append(cityweatherinfo.mWeatherMainInfo.mLunarUpdateDate).toString(), f8, f12, paint1);
        f13 = (f12 + 8F * 1.5F) - paint1.getFontMetrics().ascent;
        canvas.drawText((new StringBuilder()).append(cityweatherinfo.mWeatherMainInfo.mLastUpdateTime).append(context.getResources().getString(0x7f0b0143)).toString(), f8, f13, paint1);
        bitmap12 = BitmapFactory.decodeStream(context.getResources().openRawResource(0x7f0201bd));
        canvas.drawBitmap(bitmap12, null, new Rect(canvas.getWidth() / 2 - bitmap12.getWidth() / 4, (int)((float)(canvas.getHeight() - bitmap12.getHeight() / 2) - 10F * 1.5F), canvas.getWidth() / 2 + bitmap12.getWidth() / 4, (int)((float)canvas.getHeight() - 10F * 1.5F)), null);
        bitmap12.recycle();
        bitmap13 = Bitmap.createScaledBitmap(bitmap1, (int)(0.59999999999999998D * (double)bitmap1.getWidth()), (int)(0.59999999999999998D * (double)bitmap1.getHeight()), true);
        bitmap1.recycle();
        return bitmap13;
    }

    

    private static final String ACTION = "Action";
    private static final String ACTION_ACCESS_TOKEN = "access_token";
    private static final String ACTION_UPDATE = "update";
    private static final String ACTION_UPLOAD = "upload";
    private static final int ERROR_SHARE_MICRO_BLOG_NETWORK = -1;
    private static final int ERROR_SHARE_SINA_MICRO_BLOG_OAUTH = -2;
    private static final int ERROR_SHARE_SINA_MICRO_BLOG_SHARE_FAILED = -4;
    private static final int ERROR_SHARE_SINA_MICRO_BLOG_SHARE_RATE_LIMIT = -3;
    private static final int ERROR_SHARE_SINA_MICRO_BLOG_SYSTEM_ERROR = -5;
    private static final String FOLLOWMOJI = "FollowMOJI";
    private static final String FOLLOWMOJI_VALUE_Y = "1";
    private static final int INDEX_FORECAST_FIRST = 0;
    private static final int INDEX_FORECAST_FOURTH = 3;
    private static final int INDEX_FORECAST_SECOND = 1;
    private static final int INDEX_FORECAST_THIRD = 2;
    private static final int METHOD_TYPE_OAUTH = 201;
    private static final int MICRO_RESPONSE_CODE_EXCEPTION = -1;
    private static final int MICRO_RESPONSE_CODE_KAIXIN_OAUTH_FAILED = 20;
    private static final int MICRO_RESPONSE_CODE_MOJI_SYSTEM_ERROR = 16;
    private static final int MICRO_RESPONSE_CODE_PASSWORD_ERROR = 11;
    private static final int MICRO_RESPONSE_CODE_PIC_NULL = 15;
    private static final int MICRO_RESPONSE_CODE_RATE_LIMIT = 5;
    private static final int MICRO_RESPONSE_CODE_SHARE_FAILED = 3;
    private static final int MICRO_RESPONSE_CODE_SINA_OAUTH_FAILED = 4;
    private static final int MICRO_RESPONSE_CODE_STATUS_LENGTH_LIMIT = 14;
    private static final int MICRO_RESPONSE_CODE_STATUS_NULL = 13;
    private static final int MICRO_RESPONSE_CODE_SUCCESS = 0;
    private static final int MICRO_RESPONSE_CODE_SYSTEM_ERROR = 10;
    private static final int MSG_TYPE_SINA_OAUTH_SUCCESS = 1;
    private static final int MSG_TYPE_SINA_SHARE_SUCCESS = 2;
    private static final String PASSWORD = "Password";
    private static final String PLATFORM = "Platform";
    private static final String PLATFORM_VALUE_ANDROID = "1";
    private static final int SHARE_TYPE_KAIXIN = 303;
    private static final int SHARE_TYPE_SINA = 203;
    private static final String STATUS = "Status";
    private static final String TYPE = "Type";
    private static final String TYPE_OAUTH = "oauth";
    private static final String TYPE_STATUSES = "statuses";
    private static final String USERID = "UserID";
    private static final String USERNAME = "UserName";
    private static final String VERSION = "Version";
    private static DefaultHttpClient httpClient = new DefaultHttpClient();

}
