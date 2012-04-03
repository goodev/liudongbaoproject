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
             
        }

         
    };


    public CityWeatherBgSwitcher(Context context)
    {
        super (context);
        mUpdateListener = null;
        mCurrentCityBgResId = 999;
        mScreenHeight = 0;
        mScreenWidth = 0;
        mIsDoingAnimation = false;
        mTimer = null;
        mCurAlpha = 0;
 
        mCurBmp = null;
        mNextBmp = null;
        mPaint = null;
        mSetBgFromTrend = false;
        initBgSwitcher(context);
    }

    public CityWeatherBgSwitcher(Context context, AttributeSet attributeset)
    {
    	super(context, attributeset);
        mUpdateListener = null;
        mCurrentCityBgResId = 999;
        mScreenHeight = 0;
        mScreenWidth = 0;
        mIsDoingAnimation = false;
        mTimer = null;
        mCurAlpha = 0;
        
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
        try {
        	return BitmapFactory.decodeStream(getContext().openFileInput(s));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return bitmap;
		}
 
 
       
         
    }

    private void initBgSwitcher(Context context)
    {
        mScreenHeight = UiUtil.getScreenHeight() - UiUtil.getStatusBarHeight();
        mScreenWidth = UiUtil.getScreenWidth();
         
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
 
        int i1;
        int j1;
        i1 = j;
        j1 = k;
 
        mDrawScaleW = (float)mScreenWidth / (float)i1;
        mDrawScaleY = (float)mScreenHeight / (float)j1;
        bitmap1 = Bitmap.createBitmap(i1, j1, bitmap.getConfig());
        (new Canvas(bitmap1)).drawBitmap(bitmap, 0F, 0F, new Paint());
        bitmap.recycle();
        if(bitmap != null)
            if(bitmap.isRecycled());
 
        return bitmap1;
 
    }

    public void bindScrollBgView(Workspace workspace)
    {
        initCurBack();
        workspace.setOnCitybgChangeListener(new Workspace.OnCityBgChangeListener() {

            public void onCityBgChange(int i)
            {
                setBgImage(UiUtil.getWeatherID(WeatherData.getCityInfo(Gl.getCurrentCityIndex()).mWeatherMainInfo.mWeatherId, UiUtil.isDay(WeatherData.getCityInfo(Gl.getCurrentCityIndex()))));
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
 
    private boolean mIsDoingAnimation;
    private Bitmap mNextBmp;
    private Paint mPaint;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean mSetBgFromTrend;
    private Timer mTimer;
    private Workspace.OnCheckNeedUpdateListener mUpdateListener;






}
