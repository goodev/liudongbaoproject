// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CityNameView.java

package com.moji.mjweather.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.util.AttributeSet;
import android.widget.TextView;
import com.moji.mjweather.common.WeatherData;
import com.moji.mjweather.data.CityWeatherInfo;

// Referenced classes of package com.moji.mjweather.view:
//            Workspace

public class CityNameView extends TextView
{

    public CityNameView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mBigFontSize = 0F;
        mPaint = new Paint();
        mPaint.setColor(-1);
        mPaint.setAntiAlias(true);
        mBigFontSize = getResources().getDimension(0x7f0a0007);
        setWidth(280);
        setText("   ");
    }

    public CityNameView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mBigFontSize = 0F;
    }

    private void drawTextInCenter(Canvas canvas, float f, float f1, String s)
    {
        android.graphics.Paint.FontMetrics fontmetrics = mPaint.getFontMetrics();
        if(mCurrentCity.m_cityID == -99)
        {
            if(mLocationBitmap == null)
                mLocationBitmap = BitmapFactory.decodeResource(getResources(), 0x7f020151);
            float f2 = (float)mLocationBitmap.getWidth() + mPaint.measureText(s);
            canvas.drawBitmap(mLocationBitmap, f - f2 / 2F, f1 - (float)(mLocationBitmap.getHeight() / 2), mPaint);
            canvas.drawText(s, (f - f2 / 2F) + (float)mLocationBitmap.getWidth(), (f1 + mPaint.getTextSize() / 2F) - fontmetrics.descent / 2F, mPaint);
        } else
        {
            canvas.drawText(s, f - mPaint.measureText(s) / 2F, (f1 + mPaint.getTextSize() / 2F) - fontmetrics.descent / 2F, mPaint);
        }
    }

    private void setCityName(int i)
    {
        mCurrentCity = WeatherData.getCityInfo(i);
        if(mCurrentCity.mCityName.length() >= 6)
            mPaint.setTextSize(0.9F * mBigFontSize);
        else
            mPaint.setTextSize(mBigFontSize);
        invalidate();
    }

    public void bindScrollCityNameView(Workspace workspace)
    {
        setCityName(workspace.getCurrentScreen());
        workspace.setCityNameListener(new Workspace.OnCityNameChangeListener() {

            public void onCityNameChange(int i)
            {
                setCityName(i);
            }

            
        }
);
    }

    protected void onDraw(Canvas canvas)
    {
        drawTextInCenter(canvas, (float)getWidth() / 2F, (float)getHeight() / 2F, mCurrentCity.mCityName);
    }

    private static final int NEED_RESIZE_COUNT = 6;
    private static final float SMALLFONT_SCALE = 0.9F;
    private static final int WIDTH = 280;
    private float mBigFontSize;
    private CityWeatherInfo mCurrentCity;
    private Bitmap mLocationBitmap;
    private Paint mPaint;

}
