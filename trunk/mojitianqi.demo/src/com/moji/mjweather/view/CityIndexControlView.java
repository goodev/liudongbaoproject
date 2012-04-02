// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CityIndexControlView.java

package com.moji.mjweather.view;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.moji.mjweather.util.UiUtil;

// Referenced classes of package com.moji.mjweather.view:
//            Workspace

public class CityIndexControlView extends View
{

    public CityIndexControlView(Context context)
    {
        super(context);
        mCurIndex = 0;
        mIndicatorFocusIcon = null;
        mIndicatorIcon = null;
        init(context);
    }

    public CityIndexControlView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mCurIndex = 0;
        mIndicatorFocusIcon = null;
        mIndicatorIcon = null;
        init(context);
    }

    private void calFirstIconPos()
    {
        int i = mCount % 2;
        int j = mCount / 2;
        int k = UiUtil.getScreenWidth() / 2;
        if(i == 0)
            mFirstIconPosX = k - j * mIndicatorIcon.getWidth();
        else
            mFirstIconPosX = k - j * mIndicatorIcon.getWidth() - mIndicatorIcon.getWidth() / 2;
    }

    private void init(Context context)
    {
        if(mIndicatorIcon == null)
        {
            mIndicatorIcon = BitmapFactory.decodeResource(getResources(), 0x7f0200cf);
            mIndicatorFocusIcon = BitmapFactory.decodeResource(getResources(), 0x7f0200d0);
        }
    }

    private void setCityIndexControl(int i)
    {
        mCurIndex = i;
        calFirstIconPos();
        invalidate();
    }

    public void bindScrollIndexView(final Workspace workspace)
    {
        mCurIndex = workspace.getCurrentScreen();
        mCount = workspace.getChildCount();
        setCityIndexControl(workspace.getCurrentScreen());
        
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i = 0;
        while(i < mCount) 
        {
            if(i == mCurIndex)
                canvas.drawBitmap(mIndicatorFocusIcon, mFirstIconPosX + i * mIndicatorIcon.getWidth(), 0F, new Paint());
            else
                canvas.drawBitmap(mIndicatorIcon, mFirstIconPosX + i * mIndicatorIcon.getWidth(), 0F, new Paint());
            i++;
        }
    }

    private int mCount;
    private int mCurIndex;
    private int mFirstIconPosX;
    private Bitmap mIndicatorFocusIcon;
    private Bitmap mIndicatorIcon;


/*
    static int access$002(CityIndexControlView cityindexcontrolview, int i)
    {
        cityindexcontrolview.mCount = i;
        return i;
    }

*/

}
