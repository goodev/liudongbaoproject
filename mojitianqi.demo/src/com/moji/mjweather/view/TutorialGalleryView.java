// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TutorialGalleryView.java

package com.moji.mjweather.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Gallery;

public class TutorialGalleryView extends Gallery
{

    public TutorialGalleryView(Context context)
    {
        this(context, null);
    }

    public TutorialGalleryView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public TutorialGalleryView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if(motionevent != null)
            if(motionevent1.getX() - motionevent.getX() > 0F)
                onKeyDown(21, null);
            else
                onKeyDown(22, null);
        return false;
    }
}
