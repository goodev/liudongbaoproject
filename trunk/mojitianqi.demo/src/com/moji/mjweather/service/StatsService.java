// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StatsService.java

package com.moji.mjweather.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.IBinder;
import android.util.Xml;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import com.moji.mjweather.util.FileUtil;
import com.moji.mjweather.util.HttpUtil;
import com.moji.mjweather.util.SkinUtil;
import com.moji.mjweather.util.StatsUtil;
import com.moji.mjweather.util.UrlUtil;
import com.moji.mjweather.util.Util;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class StatsService extends Service {
	private class SendStatsThread extends Thread {

		public void run() {
			isAlive = true;
			boolean flag = false;
			try {
				if (Util.isConnectInternet(StatsService.this)) {
					flag = sendStats();
					if (flag) {
						StatsUtil.deleteStatsFile();
						StatsUtil.setNextSendTime(true);
						StatsService.checkAdSwitch();
						StatsService.downloadRecommendFile();
					}
				}
			} catch (Exception exception) {
				MojiLog.e("StatsService", "error: ", exception);
			}
			if (!flag) {
				MojiLog.d("StatsService", "failed to send stat, will try again");
				StatsUtil.setRetryTime();
			}
			isAlive = false;
			stopSelf();
		}

	}

	public StatsService() {
		isAlive = false;
	}

	public static void checkAdSwitch() {
		XmlPullParser xmlpullparser = null;
		int i = 0;
		InputStream inputstream;
		try {
			inputstream = HttpUtil.doGet("ad.moji001.com",
					UrlUtil.getAdSwitcherURL(), 0L).mInputStream;
			xmlpullparser = Xml.newPullParser();
			xmlpullparser.setInput(inputstream, "utf-8");
			i = xmlpullparser.getEventType();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (true) {
			if (i == 1) {
				MojiLog.d(
						"StatsService",
						(new StringBuilder()).append("checkAdSwitch: ")
								.append(Gl.getAdON()).toString());
				return;
			}
			switch (i) {
			case 2:
				try {
					i = xmlpullparser.next();
					if ("s".equals(xmlpullparser.getName())
							&& xmlpullparser.getAttributeValue(null, "pos") != null
							&& xmlpullparser.getAttributeValue(null, "pos")
									.length() > 0
							&& Integer.parseInt(xmlpullparser
									.getAttributeValue(null, "pos")) == 2
							&& xmlpullparser.getAttributeValue(null, "pb")
									.equals("umeng"))
						Gl.saveAdON(true);
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 0:
			case 1:
			case 3:
			default:
				break;
			}

		}

	}

	public static void checkAdSwitchAsync() {
		(new Thread() {

			public void run() {
				StatsService.checkAdSwitch();
			}

		}).start();
	}

	public static boolean downloadRecommendFile() {
		String s = (new StringBuilder()).append("/weather/GetRecommend?")
				.append(UrlUtil.getCommonPart()).append("&PartnerID=")
				.append(Gl.getPartnerID()).toString();
		boolean flag = SkinUtil.download(Gl.Ct(), "weather.moji001.com", s,
				(new StringBuilder()).append(Gl.Ct().getFilesDir()).append("/")
						.append("recommend.txt").toString());
		MojiLog.v("StatsService",
				(new StringBuilder()).append("downloadRecommendFile: ok = ")
						.append(flag).toString());
		return flag;
	}

	private void outputToSDCardForTesting(boolean flag, String s) {
		if (flag && MojiLog.isDevelopMode()) {
			FileUtil.newFolder("/sdcard/moji/stat");
			String as[] = (new File("/sdcard/moji/stat")).list();
			if (as != null && as.length > 10)
				FileUtil.delAllFile("/sdcard/moji/stat");
			FileUtil.newFile(
					(new StringBuilder()).append("/sdcard/moji/stat/stat")
							.append(System.currentTimeMillis()).append(".xml")
							.toString(), s);
		}
	}

	private boolean processResult(ArrayList arraylist) {
		boolean flag;
		boolean flag3;
		boolean flag4;
		flag = false;
		String s = HttpUtil.getContent(arraylist, 0);
		boolean flag1 = "0".equals(s);
		boolean flag2 = "2".equals(s);
		flag3 = "5".equals(s);
		flag4 = "7".equals(s);
		if (flag1)
			flag = true;
		if (flag2) {
			flag = true;
			String s4 = HttpUtil.getContent(arraylist, 2).trim();
			if (s4.length() > 4) {
				Gl.saveMustUpdateUrl(s4.substring(4));
				Util.sendNotification(Gl.Ct().getResources()
						.getString(0x7f0b017b));
			}
		}
		if (!flag3 && !flag4)
			return flag;
		String s1;
		FileInputStream fileinputstream;
		flag = true;
		String s2;
		String s3;
		Map map;
		if (flag3)
			s1 = "newversion.xml";
		else
			s1 = "pushinfo.xml";
		if (flag3)
			s2 = "supd";
		else
			s2 = "adv";
		s3 = HttpUtil.getContent(arraylist, 1).trim();
		if (s3.length() <= 0)
			return flag;
		FileUtil.savePrivateFile(s1, s3);
		fileinputstream = null;
		try {
			fileinputstream = Gl.Ct().openFileInput(s1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map = Util.parseNewVersionOrPushInfo(fileinputstream, s2);
		if (map.size() <= 0)
			Gl.Ct().deleteFile(s1);
		else
			Util.sendNotification((String) map.get("info"));

		return flag;

	}

	private boolean sendStats() throws Exception {
		String s;
		MojiLog.v("StatsService", "sendStats");
		s = StatsUtil.getStatsContent();
		MojiLog.d("StatsService", (new StringBuilder()).append("content = ")
				.append(s).toString());
		boolean flag;
		if (!s.equals("")) {
			URL url;
			HttpURLConnection httpurlconnection;
			DataOutputStream dataoutputstream;
			InputStream inputstream;
			flag = false;
			url = new URL(UrlUtil.getStatsURL("stat.moji001.com"));
			MojiLog.d("StatsService", (new StringBuilder())
					.append("staturl = ").append(url.toString()).toString());
			httpurlconnection = null;
			dataoutputstream = null;
			inputstream = null;
			if (!Util.isUsingWap(Gl.Ct())) {
				httpurlconnection = (HttpURLConnection) url.openConnection();
				StringBuilder stringbuilder;
				httpurlconnection.setDoInput(true);
				httpurlconnection.setDoOutput(true);
				httpurlconnection.setUseCaches(false);
				httpurlconnection.setRequestMethod("POST");
				httpurlconnection
						.setRequestProperty("Connection", "Keep-Alive");
				httpurlconnection.setRequestProperty("Charset", "UTF-8");
				httpurlconnection.setRequestProperty("Content-Type",
						"Multipart/form-data;boundary=--www.mojichina.com--");
				HashMap hashmap = new HashMap();
				hashmap.put("UserID", Gl.getRegCode());
				hashmap.put("Platform", "android");
				hashmap.put("BaseOSVer",
						URLEncoder.encode(android.os.Build.VERSION.RELEASE));
				hashmap.put("Version", Gl.getVersion());
				hashmap.put("Device", "phone");
				hashmap.put("Model", URLEncoder.encode(Build.MODEL));
				hashmap.put("PartnerKey", Gl.getPartnerID());
				stringbuilder = new StringBuilder();
				for (Iterator iterator = hashmap.entrySet().iterator(); iterator
						.hasNext(); stringbuilder.append("\r\n")) {
					java.util.Map.Entry entry = (java.util.Map.Entry) iterator
							.next();
					stringbuilder.append("--");
					stringbuilder.append("--www.mojichina.com--");
					stringbuilder.append("\r\n");
					stringbuilder.append((new StringBuilder())
							.append("Content-Disposition: form-data; name=\"")
							.append((String) entry.getKey())
							.append("\"\r\n\r\n").toString());
					stringbuilder.append((String) entry.getValue());
				}

				StringBuilder stringbuilder1 = new StringBuilder();
				stringbuilder1.append("--");
				stringbuilder1.append("--www.mojichina.com--");
				stringbuilder1.append("\r\n");
				stringbuilder1
						.append("Content-Disposition: form-data;name=\"StatFile\";filename=\"Stats.xml\"\r\n");
				stringbuilder1.append("Content-Type: application/xml\r\n\r\n");
				DataOutputStream dataoutputstream1 = new DataOutputStream(
						httpurlconnection.getOutputStream());
				dataoutputstream1.write(stringbuilder.toString().getBytes());
				dataoutputstream1.write(stringbuilder1.toString().getBytes());
				dataoutputstream1.write(s.getBytes());
				dataoutputstream1.write("\r\n".getBytes());
				dataoutputstream1.write("----www.mojichina.com----\r\n"
						.getBytes());
				dataoutputstream1.flush();
				MojiLog.d("StatsService",
						(new StringBuilder()).append("response code = ")
								.append(httpurlconnection.getResponseCode())
								.toString());
				if (httpurlconnection.getResponseCode() != 200)
					return false;
				inputstream = httpurlconnection.getInputStream();
				InputStreamReader inputstreamreader = new InputStreamReader(
						inputstream);
				BufferedReader bufferedreader = new BufferedReader(
						inputstreamreader);
				ArrayList arraylist = new ArrayList();
				do {
					String s1 = bufferedreader.readLine();
					if (s1 == null)
						break;
					arraylist.add(s1);
					MojiLog.d(
							"StatsService",
							(new StringBuilder()).append("received = ")
									.append(s1).toString());
				} while (true);
				flag = processResult(arraylist);

				httpurlconnection.disconnect();

			}

			else {
				httpurlconnection = (HttpURLConnection) url
						.openConnection(new Proxy(java.net.Proxy.Type.HTTP,
								new InetSocketAddress(android.net.Proxy
										.getDefaultHost(), android.net.Proxy
										.getDefaultPort())));

			}
		}

		else {
			flag = true;
		}

		return flag;

	}

	public IBinder onBind(Intent intent) {
		return null;
	}

	public void onCreate() {
		super.onCreate();
		MojiLog.v("StatsService", "onCreate");
	}

	public void onDestroy() {
		super.onDestroy();
		MojiLog.v("StatsService", "onDestroy");
	}

	public void onStart(Intent intent, int i) {
		MojiLog.v("StatsService", "onStartCommand");
		if (!isAlive)
			(new SendStatsThread()).start();
		super.onStart(intent, i);
	}

	private static final String TAG = "StatsService";
	private static final String XML_TAG_PB = "pb";
	private static final String XML_TAG_POS = "pos";
	private static final String XML_TAG_S = "s";
	private boolean isAlive;

	/*
	 * static boolean access$102(StatsService statsservice, boolean flag) {
	 * statsservice.isAlive = flag; return flag; }
	 */

}
