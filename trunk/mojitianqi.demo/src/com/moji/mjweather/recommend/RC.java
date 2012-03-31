// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RC.java

package com.moji.mjweather.recommend;

import android.graphics.Color;
import java.util.HashMap;

public class RC
{

    public RC()
    {
    }

    public static final String APPINFO_APPID = "appid";
    public static final String APPINFO_AUTHOR = "author";
    public static final String APPINFO_CREATETIME = "createtime";
    public static final String APPINFO_DESCRIPTION = "description";
    public static final String APPINFO_DOWNLOADCOUNT = "downloadcount";
    public static final String APPINFO_DOWNLOADPATH = "downloadpath";
    public static final String APPINFO_ICONPATH = "iconpath";
    public static final String APPINFO_IMAGEPATH = "imagepath";
    public static final String APPINFO_LANGUAGE = "language";
    public static final String APPINFO_NAME = "name";
    public static final String APPINFO_SIZE = "size";
    public static final String APPINFO_TITLE = "title";
    public static final String APPINFO_VERSION = "version";
    public static final String CATEGORY_BANNER = "Banner";
    public static final String CATEGORY_RECOMMEND = "Recommend";
    public static final int DOWNLOAD_TEXT_COLOR = Color.rgb(65, 65, 65);
    public static final String FILE_NAME_BANNER = "banner_";
    public static final String FILE_NAME_ICON = "icon_";
    public static final String FILE_NAME_SUFFIX_APK = ".apk";
    public static final String FILE_NAME_SUFFIX_PNG = ".png";
    public static final String FILE_UPDATE_DATA_SUFFIX = "_place.txt";
    public static final int INSTALLED_TEXT_COLOR = Color.rgb(155, 155, 155);
    public static final String INTENT_KEY_APP = "app";
    public static final String INTENT_KEY_APPID = "appID";
    public static final int NETTIMEOUT = 60000;
    public static final long ONE_DAY = 0x5265c00L;
    public static final long ONE_WEEK = 0x240c8400L;
    public static final String PATH_AD_IMAGE_CACHE = "/sdcard/moji/ad_cache";
    public static final String PATH_SD_DOWNLOAD_FILE = "/sdcard/moji/mojiDownload/";
    public static final int PLACE_LIFE_RECOMMEND = 2;
    public static final int PLACE_SKIN_BANNER = 4;
    public static final int PLACE_TOOL_BANNER = 3;
    public static final int PLACE_TOOL_RECOMMEND = 1;
    public static final String SEPARATOR_DOUHAO = ",";
    public static final String SEPARATOR_MAOHAO = ":";
    public static final String SEPARATOR_SHUGANG = "|";
    public static final String SEPARATOR_SHUGANG_RE = "\\|";
    public static final String TAG_PLACE = "place";
    public static final String TAG_POSITION = "position";
    public static final long THREE_DAY = 0xf731400L;
    public static final int TYPE_DDLS = 2;
    public static final int TYPE_DLS = 1;
    public static final int TYPE_NORMAL = 0;
    public static final String UPDATE_TIME_OF_PLACE = "place";
    public static HashMap categorysMap = new HashMap();

}
