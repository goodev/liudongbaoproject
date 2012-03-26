// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SkinDrawIconInfo.java

package com.moji.mjweather.widgetskin;


public class SkinDrawIconInfo
{

    public SkinDrawIconInfo()
    {
        mX = 0;
        mY = 0;
        mContentType = SkinInfo.BitmapContentType.CT_CUSTOM;
        mCustomBitmapName = "";
        mNeedScale = false;
        mWidth = 0;
        mHeight = 0;
    }

    public SkinInfo.BitmapContentType mContentType;
    public String mCustomBitmapName;
    public int mHeight;
    public boolean mNeedScale;
    public int mWidth;
    public int mX;
    public int mY;
}
