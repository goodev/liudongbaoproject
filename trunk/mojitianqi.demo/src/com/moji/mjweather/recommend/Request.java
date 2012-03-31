// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Request.java

package com.moji.mjweather.recommend;

import java.io.Serializable;

public class Request
    implements Serializable
{

    public Request(String s)
    {
        reqURL = s;
        reqMethod = "GET";
        contentType = "application/x-www-form-urlencoded";
    }

    public String getContentType()
    {
        return contentType;
    }

    public byte[] getReqData()
    {
        return reqData;
    }

    public String getReqMethod()
    {
        return reqMethod;
    }

    public String getReqURL()
    {
        return reqURL;
    }

    public void setContentType(String s)
    {
        contentType = s;
    }

    public void setReqData(byte abyte0[])
    {
        reqData = abyte0;
    }

    public void setReqMethod(String s)
    {
        reqMethod = s;
    }

    public void setReqURL(String s)
    {
        reqURL = s;
    }

    public static final String CONTENTTYPE_DATA = "application/octet-stream";
    public static final String CONTENTTYPE_PARAMETERS = "application/x-www-form-urlencoded";
    private static final long serialVersionUID = 0x452c6e5a934f84d2L;
    private String contentType;
    private byte reqData[];
    private String reqMethod;
    private String reqURL;
}
