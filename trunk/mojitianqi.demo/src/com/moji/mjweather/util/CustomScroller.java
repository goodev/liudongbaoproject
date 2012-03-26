// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CustomScroller.java

package com.moji.mjweather.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class CustomScroller
{

    public CustomScroller(Context context)
    {
        this(context, null);
    }

    public CustomScroller(Context context, Interpolator interpolator)
    {
        mCoeffX = 0F;
        mCoeffY = 1F;
        mFinished = true;
        mInterpolator = interpolator;
        mDeceleration = 386.0878F * (160F * context.getResources().getDisplayMetrics().density) * ViewConfiguration.getScrollFriction();
    }

    private float viscousFluid(float f)
    {
        float f1 = f * mViscousFluidScale;
        float f2;
        if(f1 < 1F)
            f2 = f1 - (1F - (float)Math.exp(-f1));
        else
            f2 = 0.3678795F + (1F - (float)Math.exp(1F - f1)) * (1F - 0.3678795F);
        return f2 * mViscousFluidNormalize;
    }

    public void abortAnimation()
    {
        mCurrX = mFinalX;
        mCurrY = mFinalY;
        mFinished = true;
    }

    public boolean computeScrollOffset()
    {
        boolean flag = true;
        if( mFinished)          return false;
 

 
        int i = (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
        if(i < mDuration)
        {
            switch(mMode)
            {
            case 0: // '\0'
                float f2 = (float)i * mDurationReciprocal;
                float f3;
                if(mInterpolator == null)
                    f3 = viscousFluid(f2);
                else
                    f3 = mInterpolator.getInterpolation(f2);
                mCurrX = mStartX + Math.round(f3 * mDeltaX);
                mCurrY = mStartY + Math.round(f3 * mDeltaY);
                if(mCurrX == mFinalX && mCurrY == mFinalY)
                    mFinished = flag;
                break;

            case 1: // '\001'
                float f = (float)i / 1000F;
                float f1 = f * mVelocity - (f * (f * mDeceleration)) / 2F;
                mCurrX = mStartX + Math.round(f1 * mCoeffX);
                mCurrX = Math.min(mCurrX, mMaxX);
                mCurrX = Math.max(mCurrX, mMinX);
                mCurrY = mStartY + Math.round(f1 * mCoeffY);
                mCurrY = Math.min(mCurrY, mMaxY);
                mCurrY = Math.max(mCurrY, mMinY);
                if(mCurrX == mFinalX && mCurrY == mFinalY)
                    mFinished = flag;
                break;
            }
        } else
        {
            mCurrX = mFinalX;
            mCurrY = mFinalY;
            mFinished = flag;
        }
        return mFinished;
    }

    public void extendDuration(int i)
    {
        mDuration = i + timePassed();
        mDurationReciprocal = 1F / (float)mDuration;
        mFinished = false;
    }

    public void fling(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        mMode = 1;
        mFinished = false;
        float f = (float)Math.hypot(k, l);
        mVelocity = f;
        mDuration = (int)((1000F * f) / mDeceleration);
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mStartX = i;
        mStartY = j;
        float f1;
        float f2;
        int i2;
        if(f == 0F)
            f1 = 1F;
        else
            f1 = (float)k / f;
        mCoeffX = f1;
        if(f == 0F)
            f2 = 1F;
        else
            f2 = (float)l / f;
        mCoeffY = f2;
        i2 = (int)((f * f) / (2F * mDeceleration));
        mMinX = i1;
        mMaxX = j1;
        mMinY = k1;
        mMaxY = l1;
        mFinalX = i + Math.round((float)i2 * mCoeffX);
        mFinalX = Math.min(mFinalX, mMaxX);
        mFinalX = Math.max(mFinalX, mMinX);
        mFinalY = j + Math.round((float)i2 * mCoeffY);
        mFinalY = Math.min(mFinalY, mMaxY);
        mFinalY = Math.max(mFinalY, mMinY);
    }

    public final void forceFinished(boolean flag)
    {
        mFinished = flag;
    }

    public float getCurrVelocity()
    {
        return mVelocity - (mDeceleration * (float)timePassed()) / 2000F;
    }

    public final int getCurrX()
    {
        return mCurrX;
    }

    public final int getCurrY()
    {
        return mCurrY;
    }

    public final int getDuration()
    {
        return mDuration;
    }

    public final int getFinalX()
    {
        return mFinalX;
    }

    public final int getFinalY()
    {
        return mFinalY;
    }

    public final int getStartX()
    {
        return mStartX;
    }

    public final int getStartY()
    {
        return mStartY;
    }

    public final boolean isFinished()
    {
        return mFinished;
    }

    public void setFinalX(int i)
    {
        mFinalX = i;
        mDeltaX = mFinalX - mStartX;
        mFinished = false;
    }

    public void setFinalY(int i)
    {
        mFinalY = i;
        mDeltaY = mFinalY - mStartY;
        mFinished = false;
    }

    public void setInterpolator(Interpolator interpolator)
    {
        mInterpolator = interpolator;
    }

    public void startScroll(int i, int j, int k, int l)
    {
        startScroll(i, j, k, l, 250);
    }

    public void startScroll(int i, int j, int k, int l, int i1)
    {
        mMode = 0;
        mFinished = false;
        mDuration = i1;
        mStartTime = AnimationUtils.currentAnimationTimeMillis();
        mStartX = i;
        mStartY = j;
        mFinalX = i + k;
        mFinalY = j + l;
        mDeltaX = k;
        mDeltaY = l;
        mDurationReciprocal = 1F / (float)mDuration;
        mViscousFluidScale = 8F;
        mViscousFluidNormalize = 1F;
        mViscousFluidNormalize = 1F / viscousFluid(1F);
    }

    public int timePassed()
    {
        return (int)(AnimationUtils.currentAnimationTimeMillis() - mStartTime);
    }

    private static final int DEFAULT_DURATION = 250;
    private static final int FLING_MODE = 1;
    private static final int SCROLL_MODE=0;
    private float mCoeffX;
    private float mCoeffY;
    private int mCurrX;
    private int mCurrY;
    private final float mDeceleration;
    private float mDeltaX;
    private float mDeltaY;
    private int mDuration;
    private float mDurationReciprocal;
    private int mFinalX;
    private int mFinalY;
    private boolean mFinished;
    private Interpolator mInterpolator;
    private int mMaxX;
    private int mMaxY;
    private int mMinX;
    private int mMinY;
    private int mMode;
    private long mStartTime;
    private int mStartX;
    private int mStartY;
    private float mVelocity;
    private float mViscousFluidNormalize;
    private float mViscousFluidScale;
}
