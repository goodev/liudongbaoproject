package com.branded.android.util;

import java.util.Map;

import com.branded.android.entity.Config;

public class BrandedConstants {
	public static final boolean isDebugVersion = false;// ����ʱ����Ϊfalse

	public static final String PREFS_NAME="branded";
	public static Map<String, String> msgMap = null;// ϵͳ�������ʾ���ַ����������ϻ�ȡ
	public static Config aboutCfg = null;//about�����е���Ϣ
	public static int defaultRadius = 30000;// (30 km) getbrandstores
	public static int defaultDelay_MapTip = 5000;//5 seconds
	
	public static final String getappbasic = "getappbasic";
	public static final String getstorecities = "getstorecities";
	public static final String getbrandstoresBycity = "getbrandstoresBycity";//////////////
	public static final String getbrandstoresByLoc = "getbrandstoresByLoc";////////////////
	public static final String getstoredetail = "getstoredetail";
	public static final String getcouponlist = "getcouponlist";
	public static final String getcoupondetail = "getcoupondetail";
	public static final String getcoupondetail2 = "getcoupondetail2";///////////////////////////
	public static final String getflyerlist = "getflyerlist";
	public static final String getflyerdetail = "getflyerdetail";
	public static final String getflyerdetail2 = "getflyerdetail2";///////////////////
	public static final String getappimage = "getappimage";
	public static final String getlogo = "getlogo";
	public static final String getmessages = "getmessages";

	public static final String TYPE_BY_GPS = "GPS";
	public static final String TYPE_BY_ADDR = "ADDR";
	public static boolean isNeedAdjustZoomlevel = false;
}
