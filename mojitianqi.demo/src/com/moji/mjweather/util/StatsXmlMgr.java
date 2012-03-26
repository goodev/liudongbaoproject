// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StatsXmlMgr.java

package com.moji.mjweather.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Xml;
import com.moji.mjweather.Gl;
import com.moji.mjweather.common.MojiLog;
import java.io.*;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.moji.mjweather.util:
//            StatsUtil, StatsData

class StatsXmlMgr {
	private static class StatsXmlWriter {

		private static void wirteOneDayData(XmlSerializer xmlserializer,
				StatsData statsdata) {
			try {
				xmlserializer.startTag("", "stat");
				xmlserializer.attribute("", "date", statsdata.mDate);
				if (statsdata.mCitys.size() > 0) {
					xmlserializer.startTag("", "wq");
					for (int i = 0; i < statsdata.mCitys.size(); i++) {
						xmlserializer.startTag("", "city");
						xmlserializer.attribute("", "id",
								String.valueOf(statsdata.getCityID(i)));
						xmlserializer.attribute("", "qc",
								String.valueOf(statsdata.getCityQC(i)));
						xmlserializer.endTag("", "city");
					}

					xmlserializer.endTag("", "wq");
				}
				xmlserializer.startTag("", "count");
				xmlserializer
						.attribute("", "asms",
								String.valueOf(statsdata.mCounts
										.get(StatsUtil.StatsCount.COUNT_ASMS
												.ordinal())));
				xmlserializer
						.attribute("", "msms",
								String.valueOf(statsdata.mCounts
										.get(StatsUtil.StatsCount.COUNT_MSMS
												.ordinal())));
				xmlserializer
						.attribute("", "awb", String.valueOf(statsdata.mCounts
								.get(StatsUtil.StatsCount.COUNT_AWB.ordinal())));
				xmlserializer
						.attribute("", "mwb", String.valueOf(statsdata.mCounts
								.get(StatsUtil.StatsCount.COUNT_MWB.ordinal())));
				xmlserializer.attribute("", "vc", String
						.valueOf(statsdata.mCounts
								.get(StatsUtil.StatsCount.COUNT_VC.ordinal())));
				xmlserializer.attribute("", "ss", String
						.valueOf(statsdata.mCounts
								.get(StatsUtil.StatsCount.COUNT_SS.ordinal())));
				xmlserializer
						.attribute("", "alm", String.valueOf(statsdata.mCounts
								.get(StatsUtil.StatsCount.COUNT_ALM.ordinal())));
				xmlserializer.endTag("", "count");
				xmlserializer.startTag("", "pv");
				xmlserializer.attribute("", "cm", String.valueOf(statsdata.mPvs
						.get(StatsUtil.StatsPv.PV_CM.ordinal())));
				xmlserializer.attribute("", "ww", String.valueOf(statsdata.mPvs
						.get(StatsUtil.StatsPv.PV_WW.ordinal())));
				xmlserializer.attribute("", "tc", String.valueOf(statsdata.mPvs
						.get(StatsUtil.StatsPv.PV_TC.ordinal())));
				xmlserializer.attribute("", "lf", String.valueOf(statsdata.mPvs
						.get(StatsUtil.StatsPv.PV_LF.ordinal())));
				xmlserializer.attribute("", "dd", String.valueOf(statsdata.mPvs
						.get(StatsUtil.StatsPv.PV_DD.ordinal())));
				xmlserializer.attribute("", "skn", String
						.valueOf(statsdata.mPvs.get(StatsUtil.StatsPv.PV_SKIN
								.ordinal())));
				xmlserializer.attribute("", "alm", String
						.valueOf(statsdata.mPvs.get(StatsUtil.StatsPv.PV_ALM
								.ordinal())));
				xmlserializer.attribute("", "idx_cosmetic", String
						.valueOf(statsdata.mPvs
								.get(StatsUtil.StatsPv.PV_IDX_COSMETIC
										.ordinal())));
				xmlserializer
						.attribute("", "idx_washcar", String
								.valueOf(statsdata.mPvs
										.get(StatsUtil.StatsPv.PV_IDX_WASHCAR
												.ordinal())));
				xmlserializer
						.attribute("", "idx_dress", String
								.valueOf(statsdata.mPvs
										.get(StatsUtil.StatsPv.PV_IDX_DRESS
												.ordinal())));
				xmlserializer.attribute("", "idx_uv", String
						.valueOf(statsdata.mPvs.get(StatsUtil.StatsPv.PV_IDX_UV
								.ordinal())));
				xmlserializer
						.attribute("", "idx_sport", String
								.valueOf(statsdata.mPvs
										.get(StatsUtil.StatsPv.PV_IDX_SPORT
												.ordinal())));
				xmlserializer.endTag("", "pv");
				xmlserializer.startTag("", "switcher");
				xmlserializer.attribute("", "tv", String
						.valueOf(statsdata.mSwitchers
								.get(StatsUtil.StatsSwitcher.SWITCHER_TV
										.ordinal())));
				xmlserializer.attribute("", "al", String
						.valueOf(statsdata.mSwitchers
								.get(StatsUtil.StatsSwitcher.SWITCHER_AL
										.ordinal())));
				xmlserializer.endTag("", "switcher");
				if (statsdata.getAdClick() > 0 || statsdata.getAdDown() > 0) {
					xmlserializer.startTag("", "ad");
					xmlserializer.attribute("", "pub", statsdata.getAdPub());
					xmlserializer.attribute("", "click",
							String.valueOf(statsdata.getAdClick()));
					xmlserializer.attribute("", "view",
							String.valueOf(statsdata.getAdView()));
					xmlserializer.attribute("", "down",
							String.valueOf(statsdata.getAdDown()));
					xmlserializer.endTag("", "ad");
				}
				xmlserializer.endTag("", "stat");
				return;
			} catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		}

		private static String writeXml() {
			XmlSerializer xmlserializer = Xml.newSerializer();
			StringWriter stringwriter = new StringWriter();
			String s;
			try {
				xmlserializer.setOutput(stringwriter);
				xmlserializer.startTag("", "stats");
				xmlserializer.attribute("", "userid", Gl.getRegCode());
				xmlserializer.attribute("", "platform", "android");
				xmlserializer.attribute("", "baseosver",
						android.os.Build.VERSION.RELEASE);
				xmlserializer.attribute("", "version", Gl.getVersion());
				xmlserializer.attribute("", "device", "phone");
				xmlserializer.attribute("", "model", Build.MODEL);
				xmlserializer.attribute("", "partnerkey", Gl.getPartnerID());
				for (int i = 0; i < StatsXmlMgr.mStatsDatas.size(); i++)
					wirteOneDayData(xmlserializer,
							(StatsData) StatsXmlMgr.mStatsDatas.get(i));

				xmlserializer.endTag("", "stats");
				xmlserializer.endDocument();
				s = stringwriter.toString();
			} catch (Exception exception) {
				throw new RuntimeException(exception);
			}
			return s;
		}

		private StatsXmlWriter() {
		}
	}

	private static class StatsXmlReader {
		private static class StatsHandler extends DefaultHandler {

			private Integer getIntValue(Attributes attributes, String s) {
				return Integer.valueOf(attributes.getValue(s));
			}

			public void endElement(String s, String s1, String s2)
					throws SAXException {
				if (s1.equals("stat")) {
					StatsData statsdata = (StatsData) StatsXmlMgr.mStatsDatas
							.get(-1 + StatsXmlMgr.mStatsDatas.size());
					if (StatsUtil.mStatsData.mDate.equals(statsdata.mDate)) {
						StatsUtil.mStatsData.mergeData(statsdata);
						StatsXmlMgr.mStatsDatas.remove(statsdata);
					}
				}
			}

			public void startDocument() throws SAXException {
				StatsXmlMgr.mStatsDatas.clear();
			}

			public void startElement(String s, String s1, String s2,
					Attributes attributes) throws SAXException {
				if (s1.equals("stat")) {
					StatsData statsdata = new StatsData();
					StatsXmlMgr.mStatsDatas.add(statsdata);
					statsdata.mDate = attributes.getValue("date");
					return;
				}
				if (s1.equals("city"))
					((StatsData) StatsXmlMgr.mStatsDatas.get(-1
							+ StatsXmlMgr.mStatsDatas.size())).addNewCity(
							getIntValue(attributes, "id").intValue(),
							getIntValue(attributes, "qc").intValue());
				else if (s1.equals("count")) {
					StatsData statsdata4 = (StatsData) StatsXmlMgr.mStatsDatas
							.get(-1 + StatsXmlMgr.mStatsDatas.size());
					statsdata4.setCountValue(StatsUtil.StatsCount.COUNT_ASMS,
							getIntValue(attributes, "asms"));
					statsdata4.setCountValue(StatsUtil.StatsCount.COUNT_MSMS,
							getIntValue(attributes, "msms"));
					statsdata4.setCountValue(StatsUtil.StatsCount.COUNT_AWB,
							getIntValue(attributes, "awb"));
					statsdata4.setCountValue(StatsUtil.StatsCount.COUNT_MWB,
							getIntValue(attributes, "mwb"));
					statsdata4.setCountValue(StatsUtil.StatsCount.COUNT_ALM,
							getIntValue(attributes, "alm"));
					statsdata4.setCountValue(StatsUtil.StatsCount.COUNT_VC,
							getIntValue(attributes, "vc"));
					statsdata4.setCountValue(StatsUtil.StatsCount.COUNT_SS,
							getIntValue(attributes, "ss"));
				} else if (s1.equals("pv")) {
					StatsData statsdata3 = (StatsData) StatsXmlMgr.mStatsDatas
							.get(-1 + StatsXmlMgr.mStatsDatas.size());
					statsdata3.setPvValue(StatsUtil.StatsPv.PV_CM,
							getIntValue(attributes, "cm"));
					statsdata3.setPvValue(StatsUtil.StatsPv.PV_WW,
							getIntValue(attributes, "ww"));
					statsdata3.setPvValue(StatsUtil.StatsPv.PV_TC,
							getIntValue(attributes, "tc"));
					statsdata3.setPvValue(StatsUtil.StatsPv.PV_LF,
							getIntValue(attributes, "lf"));
					statsdata3.setPvValue(StatsUtil.StatsPv.PV_DD,
							getIntValue(attributes, "dd"));
					statsdata3.setPvValue(StatsUtil.StatsPv.PV_SKIN,
							getIntValue(attributes, "skn"));
					statsdata3.setPvValue(StatsUtil.StatsPv.PV_ALM,
							getIntValue(attributes, "alm"));
					statsdata3.setPvValue(StatsUtil.StatsPv.PV_IDX_SPORT,
							getIntValue(attributes, "idx_sport"));
					statsdata3.setPvValue(StatsUtil.StatsPv.PV_IDX_UV,
							getIntValue(attributes, "idx_uv"));
					statsdata3.setPvValue(StatsUtil.StatsPv.PV_IDX_DRESS,
							getIntValue(attributes, "idx_dress"));
					statsdata3.setPvValue(StatsUtil.StatsPv.PV_IDX_WASHCAR,
							getIntValue(attributes, "idx_washcar"));
					statsdata3.setPvValue(StatsUtil.StatsPv.PV_IDX_COSMETIC,
							getIntValue(attributes, "idx_cosmetic"));
				} else if (s1.equals("ad")) {
					StatsData statsdata2 = (StatsData) StatsXmlMgr.mStatsDatas
							.get(-1 + StatsXmlMgr.mStatsDatas.size());
					statsdata2.setAdClick(getIntValue(attributes, "click")
							.intValue());
					statsdata2.setAdDown(getIntValue(attributes, "down")
							.intValue());
					statsdata2.setAdView(getIntValue(attributes, "view")
							.intValue());
				} else if (s1.equals("switcher")) {
					StatsData statsdata1 = (StatsData) StatsXmlMgr.mStatsDatas
							.get(-1 + StatsXmlMgr.mStatsDatas.size());
					statsdata1.setSwitcherValue(
							StatsUtil.StatsSwitcher.SWITCHER_TV,
							getIntValue(attributes, "tv").intValue());
					statsdata1.setSwitcherValue(
							StatsUtil.StatsSwitcher.SWITCHER_AL,
							getIntValue(attributes, "al").intValue());
				}

			}

			private StatsHandler() {
			}

		}

		private static void parseXml() throws Exception {
			SAXParser saxparser = SAXParserFactory.newInstance().newSAXParser();
			StatsHandler statshandler = new StatsHandler();
			saxparser.parse(StatsXmlMgr.getStatsFile(), statshandler);
		}

		private StatsXmlReader() {
		}
	}

	StatsXmlMgr() {
	}

	private static int BoolToInt(Boolean boolean1) {
		return boolean1.compareTo(Boolean.valueOf(false));
	}

	public static void copyFile(File file, File file1) throws Exception {
		if (file.isFile()) {
			FileInputStream fileinputstream = new FileInputStream(file);
			FileOutputStream fileoutputstream = new FileOutputStream(file1);
			BufferedInputStream bufferedinputstream = new BufferedInputStream(
					fileinputstream);
			BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(
					fileoutputstream);
			byte abyte0[] = new byte[1024];
			for (int i = bufferedinputstream.read(abyte0); i != -1; i = bufferedinputstream
					.read(abyte0))
				bufferedoutputstream.write(abyte0, 0, i);

			bufferedinputstream.close();
			bufferedoutputstream.close();
		}
		if (file.isDirectory()) {
			File afile[] = file.listFiles();
			file1.mkdir();
			for (int j = 0; j < afile.length; j++)
				copyFile(
						afile[j].getAbsoluteFile(),
						new File((new StringBuilder())
								.append(file1.getAbsoluteFile())
								.append(File.separator)
								.append(afile[j].getName()).toString()));

		}
	}

	public static void deleteStatsFile() {
		File file = getStatsFile();
		if (file.exists()) {
			if (StatsUtil.isDevelopMode()) {
				File file1 = getSaveFile();
				if (file1.exists())
					file1.delete();
				try {
					copyFile(file, file1);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
			file.delete();
		}
	}

	private static File getSaveFile() {
		return new File(Environment.getExternalStorageDirectory(), "Stats.xml");
	}

	public static String getStatsContent() throws Exception {
		saveToXml();
		return readFile();
	}

	private static File getStatsFile() {
		return new File(Gl.Ct().getFilesDir(), "Stats.xml");
	}

	private static String readFile() throws Exception {
		StringBuilder stringbuilder;
		FileInputStream fileinputstream;
		BufferedReader bufferedreader;
		stringbuilder = new StringBuilder();
		fileinputstream = null;
		bufferedreader = null;
		BufferedReader bufferedreader1;
		fileinputstream = Gl.Ct().openFileInput("Stats.xml");
		bufferedreader1 = new BufferedReader(new InputStreamReader(
				fileinputstream));
		do {
			String s = bufferedreader1.readLine();
			if (s == null)
				break;
			stringbuilder.append(s);
		} while (true);

		fileinputstream.close();
		if (bufferedreader != null)
			bufferedreader.close();

		deleteStatsFile();
		if (fileinputstream == null)

			fileinputstream.close();
		if (bufferedreader != null)
			bufferedreader.close();

		if (fileinputstream == null)

			fileinputstream.close();
		if (bufferedreader != null)
			bufferedreader.close();

		return stringbuilder.toString();
	}

	private static void saveFile(File file, String s) throws Exception {
		FileOutputStream fileoutputstream = new FileOutputStream(file);
		fileoutputstream.write(s.getBytes());
		fileoutputstream.close();
	}

	public static void saveToXml() throws Exception {
		if (StatsUtil.mStatsData == null) {
			MojiLog.d("StatsXmlMgr", "no new data to save.");
		} else {
			if (mStatsDatas == null)
				mStatsDatas = new ArrayList();
			File file = getStatsFile();
			String s;
			if (file.exists())
				StatsXmlReader.parseXml();
			else
				file.createNewFile();
			StatsUtil.mStatsData.setSwitcherValue(
					StatsUtil.StatsSwitcher.SWITCHER_TV,
					BoolToInt(Boolean.valueOf(Gl.getAutoVoicePlay())));
			StatsUtil.mStatsData.setSwitcherValue(
					StatsUtil.StatsSwitcher.SWITCHER_AL,
					BoolToInt(Boolean.valueOf(Gl.getGpsLocationState())));
			mStatsDatas.add(StatsUtil.mStatsData);
			MojiLog.d(
					"StatsXmlMgr",
					(new StringBuilder()).append("mStatsDatas.size = ")
							.append(mStatsDatas.size()).toString());
			s = StatsXmlWriter.writeXml();
			if (!s.endsWith(">"))
				s = (new StringBuilder()).append(s).append(">").toString();
			saveFile(file, s);
			mStatsDatas.clear();
			StatsUtil.mStatsData = null;
			StatsUtil.mStatsData = new StatsData();
		}
	}

	public static final String AD_CLICK = "click";
	public static final String AD_DOWN = "down";
	public static final String AD_PUB = "pub";
	public static final String AD_VIEW = "view";
	public static final String CITY_ID = "id";
	public static final String CITY_QC = "qc";
	public static final String COUNT_ALM = "alm";
	public static final String COUNT_ASMS = "asms";
	public static final String COUNT_AWB = "awb";
	public static final String COUNT_MSMS = "msms";
	public static final String COUNT_MWB = "mwb";
	public static final String COUNT_SS = "ss";
	public static final String COUNT_VC = "vc";
	private static final String END_XML = ">";
	public static final String PARAM_EMPTY = "";
	private static final String PLATFORM_VALUE = "android";
	public static final String PV_ALM = "alm";
	public static final String PV_CM = "cm";
	public static final String PV_DD = "dd";
	public static final String PV_IDX_COSMETIC = "idx_cosmetic";
	public static final String PV_IDX_DRESS = "idx_dress";
	public static final String PV_IDX_SPORT = "idx_sport";
	public static final String PV_IDX_UV = "idx_uv";
	public static final String PV_IDX_WASHCAR = "idx_washcar";
	public static final String PV_LF = "lf";
	public static final String PV_SKIN = "skn";
	public static final String PV_TC = "tc";
	public static final String PV_WW = "ww";
	public static final String STATS_DEVICE = "device";
	public static final String STATS_MODEL = "model";
	public static final String STATS_OSVER = "baseosver";
	public static final String STATS_PARTNERKEY = "partnerkey";
	public static final String STATS_PLATFORM = "platform";
	public static final String STATS_USERID = "userid";
	public static final String STATS_VERSION = "version";
	public static final String STAT_DATE = "date";
	public static final String SWITCHER_AL = "al";
	public static final String SWITCHER_TV = "tv";
	private static final String TAG = "StatsXmlMgr";
	public static final String TAG_AD = "ad";
	public static final String TAG_CITY = "city";
	public static final String TAG_COUNT = "count";
	public static final String TAG_PV = "pv";
	public static final String TAG_STAT = "stat";
	public static final String TAG_STATS = "stats";
	public static final String TAG_SWITCHER = "switcher";
	public static final String TAG_WQ = "wq";
	private static ArrayList mStatsDatas = null;

}
