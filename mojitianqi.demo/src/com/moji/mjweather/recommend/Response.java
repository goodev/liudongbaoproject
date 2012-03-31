// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Response.java

package com.moji.mjweather.recommend;

import java.io.Serializable;

public class Response
    implements Serializable
{

    public Response()
    {
    }

    public String getContentType()
    {
        return contentType;
    }

    public int getRespCode()
    {
        return respCode;
    }

    public byte[] getRespData()
    {
        return respData;
    }

    public void setContentType(String s)
    {
        contentType = s;
    }

    public void setRespCode(int i)
    {
        respCode = i;
    }

    public void setRespData(byte abyte0[])
    {
        respData = abyte0;
    }

    private static final long serialVersionUID = 0xd417b397639b1803L;
    private String contentType;
    private int respCode;
    private byte respData[];
}
