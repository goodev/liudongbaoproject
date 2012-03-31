// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CityWeatherBgSwitcher.java

package com.moji.mjweather.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.data.CityWeatherInfo;
import com.moji.mjweather.data.WeatherMainInfo;
import com.moji.mjweather.util.UiUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.moji.mjweather.view:
//            Workspace

public class CityWeatherBgSwitcher extends ImageView
{
    private class MyTimerTask extends TimerTask
    {

        public void run()
        {
            Message message = new Message();
            message.what = 1;
            mHandle.sendMessage(message);
        }

        final CityWeatherBgSwitcher this$0;

        public MyTimerTask()
        {
            this$0 = CityWeatherBgSwitcher.this;
            super();
        }
    }


    public CityWeatherBgSwitcher(Context context)
    {
        ImageView(context);
        mUpdateListener = null;
        mCurrentCityBgResId = 999;
        mScreenHeight = 0;
        mScreenWidth = 0;
        mIsDoingAnimation = false;
        mTimer = null;
        mCurAlpha = 0;
        mHandle = null;
        mCurBmp = null;
        mNextBmp = null;
        mPaint = null;
        mSetBgFromTrend = false;
        initBgSwitcher(context);
    }

    public CityWeatherBgSwitcher(Context context, AttributeSet attributeset)
    {
        ImageView(context, attributeset);
        mUpdateListener = null;
        mCurrentCityBgResId = 999;
        mScreenHeight = 0;
        mScreenWidth = 0;
        mIsDoingAnimation = false;
        mTimer = null;
        mCurAlpha = 0;
        mHandle = null;
        mCurBmp = null;
        mNextBmp = null;
        mPaint = null;
        mSetBgFromTrend = false;
        initBgSwitcher(context);
    }

    private void StartAnimation()
    {
        removeTimer();
        MyTimerTask mytimertask = new MyTimerTask();
        mTimer = new Timer();
        mTimer.schedule(mytimertask, 0L, 30L);
        mIsDoingAnimation = true;
        mCurAlpha = 255;
    }

    private void StopAnimation()
    {
        mIsDoingAnimation = false;
        removeTimer();
        if(!mSetBgFromTrend && mUpdateListener != null)
            mUpdateListener.onCheckNeedUpdate(Gl.getCurrentCityIndex());
    }

    private Bitmap getBmpFromFile(int i)
    {
        Bitmap bitmap = null;
        Bitmap bitmap1;
        String s = (new StringBuilder()).append("weather").append(i).append(".jpg").toString();
        bitmap1 = BitmapFactory.decodeStream(getContext().openFileInput(s));
        bitmap = bitmap1;
_L2:
        return bitmap;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        MojiLog.e("CityWeatherBgSwitcher", "GetBmpFromFile----Input bmp failed", filenotfoundexception);
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void initBgSwitcher(Context context)
    {
        mScreenHeight = UiUtil.getScreenHeight() - UiUtil.getStatusBarHeight();
        mScreenWidth = UiUtil.getScreenWidth();
        if(mHandle == null)
            mHandle = new RedrawHandle();
        if(mPaint == null)
            mPaint = new Paint();
    }

    private void initCurBack()
    {
        mCurrentCityBgResId = UiUtil.getWeatherID(WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mWeatherMainInfo.mWeatherId, UiUtil.isDay(WeatherData.getCityInfo(Gl.getCurrentCityIndex())));
        loadBackBmps(true);
        mIsDoingAnimation = false;
        mDrawScaleW = (float)mScreenWidth / (float)mCurBmp.getWidth();
        mDrawScaleY = (float)mScreenHeight / (float)mCurBmp.getHeight();
    }

    private void loadBackBmps(boolean flag)
    {
        Bitmap bitmap1;
        if(mScreenHeight == 960 && mScreenWidth == 640)
        {
            bitmap1 = ((BitmapDrawable)getResources().getDrawable(UiUtil.getWeatherBgResourceId(mCurrentCityBgResId, UiUtil.isDay(WeatherData.getCityInfo(Gl.getCurrentCityIndex()))))).getBitmap();
        } else
        {
            Bitmap bitmap;
            if(!(new File((new StringBuilder()).append(getContext().getFilesDir().toString()).append("/").append("weather").append(mCurrentCityBgResId).append(".jpg").toString())).exists())
                bitmap = saveScaleBgViewByScreen(mCurrentCityBgResId);
            else
                bitmap = getBmpFromFile(mCurrentCityBgResId);
            bitmap1 = bitmap;
        }
        if(flag)
            mCurBmp = bitmap1;
        else
            mNextBmp = bitmap1;
    }

    private Bitmap saveScaleBgViewByScreen(int i)
    {
        Bitmap bitmap;
        Bitmap bitmap1;
        bitmap = null;
        bitmap1 = null;
        int j;
        int k;
        float f;
        float f1;
        bitmap = BitmapFactory.decodeResource(getResources(), UiUtil.getWeatherBgResourceId(i, UiUtil.isDay(WeatherData.getCityInfo(Gl.getCurrentCityIndex()))));
        j = bitmap.getWidth();
        k = bitmap.getHeight();
        f = (float)j / (float)mScreenWidth;
        f1 = (float)k / (float)mScreenHeight;
        if(f != f1) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        i1 = j;
        j1 = k;
_L3:
        mDrawScaleW = (float)mScreenWidth / (float)i1;
        mDrawScaleY = (float)mScreenHeight / (float)j1;
        bitmap1 = Bitmap.createBitmap(i1, j1, bitmap.getConfig());
        (new Canvas(bitmap1)).drawBitmap(bitmap, 0F, 0F, new Paint());
        bitmap.recycle();
        if(bitmap != null)
            if(bitmap.isRecycled());
_L4:
        return bitmap1;
_L2:
        if(f >= f1)
            break MISSING_BLOCK_LABEL_181;
        i1 = j;
        j1 = (int)(f * (float)mScreenHeight);
          goto _L3
        int l = mScreenWidth;
        i1 = (int)(f1 * (float)l);
        j1 = k;
          goto _L3
        Exception exception1;
        exception1;
        MojiLog.e("CityWeatherBgSwitcher", "Save bg picutre error", exception1);
        if(bitmap == null || bitmap.isRecycled());
          goto _L4
        Exception exception;
        exception;
        if(bitmap != null)
            if(bitmap.isRecycled());
        throw exception;
          goto _L3
    }

    public void bindScrollBgView(Workspace workspace)
    {
        initCurBack();
        workspace.setOnCitybgChangeListener(new Workspace.OnCityBgChangeListener() {

            public void onCityBgChange(int i)
            {
                setBgImage(UiUtil.getWeatherID(WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mWeatherMainInfo.mWeatherId, UiUtil.isDay(WeatherData.getCityInfo(Gl.getCurrentCityIndex()))));
            }

            final CityWeatherBgSwitcher this$0;

            
            {
                this$0 = CityWeatherBgSwitcher.this;
                super();
            }
        }
);
    }

    public boolean isDoingAnimation()
    {
        return mIsDoingAnimation;
    }

    protected void onDraw(Canvas canvas)
    {
        Matrix matrix = new Matrix();
        matrix.postScale(mDrawScaleW, mDrawScaleY);
        if(mIsDoingAnimation)
        {
            mPaint.setAlpha(mCurAlpha);
            canvas.drawBitmap(mCurBmp, matrix, mPaint);
            mPaint.setAlpha(255 - mCurAlpha);
            canvas.drawBitmap(mNextBmp, matrix, mPaint);
        } else
        {
            mPaint.setAlpha(255);
            canvas.drawBitmap(mCurBmp, matrix, mPaint);
        }
    }

    public void removeTimer()
    {
        if(mTimer != null)
        {
            mTimer.cancel();
            mTimer = null;
        }
    }

    public void setBgImage(int i)
    {
        mSetBgFromTrend = false;
        if(mCurrentCityBgResId != i || mCurrentCityBgResId == 44 && i == 44)
        {
            mCurrentCityBgResId = i;
            loadBackBmps(false);
            StartAnimation();
        }
    }

    public void setBgImageFromTrend(int i)
    {
        mSetBgFromTrend = true;
        if(mCurrentCityBgResId != i || mCurrentCityBgResId == 44 && i == 44)
        {
            mCurrentCityBgResId = i;
            loadBackBmps(false);
            StartAnimation();
        }
    }

    public void setCheckNeedUpdateListener(Workspace.OnCheckNeedUpdateListener oncheckneedupdatelistener)
    {
        mUpdateListener = oncheckneedupdatelistener;
    }

    private static final int ALPHA_MAX = 255;
    private static final int ALPHA_MIN = 0;
    private static final int ALPHA_REDUCE = 30;
    private static final int ANIMATINO_INTERVAL = 30;
    private static final int ANIMATION_MSG = 1;
    private static final String TAG = "CityWeatherBgSwitcher";
    private int mCurAlpha;
    private Bitmap mCurBmp;
    private int mCurrentCityBgResId;
    private float mDrawScaleW;
    private float mDrawScaleY;
    private RedrawHandle mHandle;
    private boolean mIsDoingAnimation;
    private Bitmap mNextBmp;
    private Paint mPaint;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean mSetBgFromTrend;
    private Timer mTimer;
    private Workspace.OnCheckNeedUpdateListener mUpdateListener;




/*
    static int access$102(CityWeatherBgSwitcher cityweatherbgswitcher, int i)
    {
        cityweatherbgswitcher.mCurAlpha = i;
        return i;
    }

*/


/*
    static int access$120(CityWeatherBgSwitcher cityweatherbgswitcher, int i)
    {
        int j = cityweatherbgswitcher.mCurAlpha - i;
        cityweatherbgswitcher.mCurAlpha = j;
        return j;
    }

*/


/*
    static Bitmap access$202(CityWeatherBgSwitcher cityweatherbgswitcher, Bitmap bitmap)
    {
        cityweatherbgswitcher.mCurBmp = bitmap;
        return bitmap;
    }

*/


}
