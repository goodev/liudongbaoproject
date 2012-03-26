// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WorkspaceInterpolator.java

package com.moji.mjweather.util;

import android.view.animation.Interpolator;

public class WorkspaceInterpolator
    implements Interpolator
{

    public WorkspaceInterpolator()
    {
        mTension = 0F;
    }

    public void disableSettle()
    {
        mTension = 0F;
    }

    public float getInterpolation(float f)
    {
        float f1 = f - 1F;
        return 1F + f1 * (f1 * (f1 * f1)) * (f1 * (1F + mTension) + mTension);
    }

    public void setDistance(int i)
    {
        float f = 0F;
        if(i > 0)
            f /= i;
        mTension = f;
    }

    private static final float DEFAULT_TENSION=0;
    private float mTension;
}
