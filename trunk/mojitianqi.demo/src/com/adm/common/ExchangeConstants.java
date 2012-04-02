// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.adm.common;


public class ExchangeConstants
{

    public ExchangeConstants()
    {
    }

    public static final int ANIM_3D_X = 7;
    public static final int ANIM_3D_Y = 8;
    public static final int ANIM_SCALE = 6;
    public static final int ANIM_SLIDE_DOWN = 4;
    public static final int ANIM_SLIDE_LEFT = 1;
    public static final int ANIM_SLIDE_RIGHT = 2;
    public static final int ANIM_SLIDE_UP = 3;
    public static String APPKEY = "";
    public static String BASE_URL_LIST[];
    public static String CHANNEL = null;
    public static boolean CONTAINER_AUTOEXPANDED = false;
    public static int CONTAINER_HEIGHT = 0;
    public static int CONTAINER_LIST_COUNT = 0;
    public static int CURTAIN_LIST_COUNT_HORIZEN = 0;
    public static int CURTAIN_PEARL_COUNT_HORIZEN = 0;
    public static int CURTAIN_PEARL_COUNT_VERTICAL = 0;
    public static int DATA_CACHE_TIME = 0;
    public static boolean DATA_COMPRESS = false;
    public static boolean DEBUG_MODE = false;
    public static int DOWNLOAD_DIALOG_HEIGHT_HORIZEN = 0;
    public static int DOWNLOAD_DIALOG_HEIGHT_VERTICAL = 0;
    public static int DRAWER_LIST_COUNT_HORIZEN = 0;
    public static int DRAWER_LIST_COUNT_VERTICAL = 0;
    public static String LOG_TAG = "exchange";
    public static boolean ONLY_CHINESE = false;
    public static int REFRESH_INTERVAL = 0;
    public static String REPORT_URL_LIST[];
    public static String REQUEST_URL_LIST[];
    public static int TAG_HEIGHT = 0;
    public static boolean TAG_HEIGHT_WRAP = false;
    public static int TAG_WIDTH = 0;
    public static boolean USE_SCROLL_VIEW_LANDSCAPE = false;
    public static boolean USE_SIMPLE_DIALOG = false;
    public static final String WAP_URL = "http://ex.mobmore.com/api/wap?";
    public static String WEB_CACHE_NAME = "/download/.web_cache/";
    static String a = "/sdcard/download/.promotion_cache/";
    private static final int b = 5;
    public static String banben = "\u7248\u672C\uFF1A";
    public static int banner_alpha = 0;
    public static boolean blur_switcher = false;
    private static final int c = 9;
    public static final Object downloadMutex = new Object();
    public static boolean filterInstalledApp = false;
    public static boolean full_screen = false;
    public static final Object getDataMutex = new Object();
    public static boolean handler_auto_expand = false;
    public static boolean handler_left = false;
    public static boolean has_banner = false;
    public static String no = "\u5426";
    public static final int promoter_category_exchange = 0;
    public static final int promoter_category_house = 1;
    public static final int promoter_category_thirdparty = 2;
    public static String protocol_version = "1";
    public static String sdk_version = "4.8.20120216";
    public static String sdk_version_name = "1";
    public static boolean show_price = false;
    public static boolean show_progress_wheel = false;
    public static boolean show_size = false;
    public static String text_color = "#000000";
    public static final int type_big_handler_bottom = 0;
    public static final int type_big_handler_top = 1;
    public static final int type_cloud_full = 12;
    public static final int type_container = 8;
    public static final int type_grid_view_bottom = 41;
    public static final int type_grid_view_top = 42;
    public static final int type_hypertextlink_banner = 13;
    public static final int type_image_entry = 11;
    public static final int type_list_curtain = 7;
    public static final int type_partners_banner = 11;
    public static final int type_pearl_curtain = 9;
    public static final int type_scroll_view_bottom = 10;
    public static final int type_small_handler_list_bottom = 4;
    public static final int type_small_handler_list_top = 5;
    public static final int type_standalone_handler = 6;

    static 
    {
        DEBUG_MODE = false;
        banner_alpha = 255;
        String as[] = new String[3];
        as[0] = "http://ex.puata.info";
        as[1] = "http://ex.umengcloud.com";
        as[2] = "http://ex.mobmore.com";
        BASE_URL_LIST = as;
        blur_switcher = true;
        CONTAINER_AUTOEXPANDED = true;
        CONTAINER_HEIGHT = 55;
        CONTAINER_LIST_COUNT = 7;
        CURTAIN_LIST_COUNT_HORIZEN = 4;
        CURTAIN_PEARL_COUNT_HORIZEN = 2;
        CURTAIN_PEARL_COUNT_VERTICAL = 3;
        DATA_CACHE_TIME = 900;
        DATA_COMPRESS = false;
        DOWNLOAD_DIALOG_HEIGHT_HORIZEN = 400;
        DOWNLOAD_DIALOG_HEIGHT_VERTICAL = 200;
        DRAWER_LIST_COUNT_HORIZEN = 2;
        DRAWER_LIST_COUNT_VERTICAL = 4;
        filterInstalledApp = true;
        full_screen = false;
        handler_auto_expand = true;
        handler_left = true;
        has_banner = false;
        ONLY_CHINESE = true;
        REFRESH_INTERVAL = 30000;
        String as1[] = new String[3];
        as1[0] = "http://ex.puata.info/api/r?";
        as1[1] = "http://ex.umengcloud.com/api/r?";
        as1[2] = "http://ex.mobmore.com/api/r?";
        REPORT_URL_LIST = as1;
        String as2[] = new String[3];
        as2[0] = "http://ex.puata.info/api/q?";
        as2[1] = "http://ex.umengcloud.com/api/q?";
        as2[2] = "http://ex.mobmore.com/api/q?";
        REQUEST_URL_LIST = as2;
        show_price = true;
        show_size = false;
        TAG_HEIGHT = 38;
        TAG_HEIGHT_WRAP = false;
        TAG_WIDTH = 38;
        USE_SCROLL_VIEW_LANDSCAPE = true;
        USE_SIMPLE_DIALOG = false;
        show_progress_wheel = true;
    }
}
