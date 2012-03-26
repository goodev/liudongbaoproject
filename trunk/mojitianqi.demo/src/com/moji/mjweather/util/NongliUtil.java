// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NongliUtil.java

package com.moji.mjweather.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NongliUtil {

	public NongliUtil(Calendar calendar) {

	}

	private static final String cyclicalm(int i) {
		String as[] = new String[10];
		as[0] = " \u7532";
		as[1] = "\u4E59";
		as[2] = "\u4E19";
		as[3] = "\u4E01";
		as[4] = "\u620A";
		as[5] = "\u5DF1";
		as[6] = "\u5E9A";
		as[7] = "\u8F9B";
		as[8] = "\u58EC";
		as[9] = "\u7678";
		String as1[] = new String[12];
		as1[0] = " \u5B50";
		as1[1] = "\u4E11";
		as1[2] = "\u5BC5";
		as1[3] = "\u536F";
		as1[4] = "\u8FB0";
		as1[5] = "\u5DF3";
		as1[6] = "\u5348";
		as1[7] = "\u672A";
		as1[8] = "\u7533";
		as1[9] = "\u9149";
		as1[10] = "\u620C";
		as1[11] = "\u4EA5";
		return (new StringBuilder()).append(as[i % 10]).append(as1[i % 12])
				.toString();
	}

	public static String getChinaDayString(int i) {
		String as[] = new String[4];
		as[0] = "\u521D";
		as[1] = "\u5341";
		as[2] = "\u5EFF";
		as[3] = "\u5345";
		int j;
		String s;
		if (i % 10 == 0)
			j = 9;
		else
			j = -1 + i % 10;
		if (i > 30)
			s = "";
		else if (i == 30)
			s = "\u4E09\u5341";
		else if (i == 20)
			s = "\u4E8C\u5341";
		else if (i == 10)
			s = "\u521D\u5341";
		else
			s = (new StringBuilder()).append(as[i / 10])
					.append(chineseNumber[j]).toString();
		return s;
	}

	private static final int leapDays(int i) {
		byte byte0;
		if (leapMonth(i) != 0) {
			if ((0x10000L & lunarInfo[i + -1900]) != 0L)
				byte0 = 30;
			else
				byte0 = 29;
		} else {
			byte0 = 0;
		}
		return byte0;
	}

	private static final int leapMonth(int i) {
		return (int) (15L & lunarInfo[i + -1900]);
	}

	public static int monthDays(int i, int j) {
		byte byte0;
		if ((lunarInfo[i + -1900] & (long) (0x10000 >> j)) == 0L)
			byte0 = 29;
		else
			byte0 = 30;
		return byte0;
	}

	private static final int yearDays(int i) {
		int j = 348;
		for (int k = 32768; k > 8; k >>= 1)
			if ((lunarInfo[i + -1900] & (long) k) != 0L)
				j++;

		return j + leapDays(i);
	}

	public String GetMonthDate() {
		String s1;
		if (-1 + month == 0) {
			StringBuilder stringbuilder = new StringBuilder();
			String s;
			if (leap)
				s = "\u95F0";
			else
				s = "";
			s1 = stringbuilder.append(s).append("\u6B63\u6708")
					.append(getChinaDayString(day)).toString();
		} else {
			StringBuilder stringbuilder1 = new StringBuilder();
			String s2;
			if (leap)
				s2 = "\u95F0";
			else
				s2 = "";
			s1 = stringbuilder1.append(s2).append(chineseNumber[-1 + month])
					.append("\u6708").append(getChinaDayString(day)).toString();
		}
		return s1;
	}

	public final String animalsYear() {
		String as[] = new String[12];
		as[0] = " \u9F20";
		as[1] = "\u725B";
		as[2] = "\u864E";
		as[3] = "\u5154";
		as[4] = "\u9F99";
		as[5] = "\u86C7";
		as[6] = "\u9A6C";
		as[7] = "\u7F8A";
		as[8] = "\u7334";
		as[9] = "\u9E21";
		as[10] = "\u72D7";
		as[11] = "\u732A";
		return as[(-4 + year) % 12];
	}

	public final String cyclical() {
		return cyclicalm(36 + (-1900 + year));
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public String getNongliDate() {
		String s1;
		if (-1 + month == 0) {
			StringBuilder stringbuilder1 = (new StringBuilder()).append(
					cyclical()).append("\u5E74");
			String s2;
			if (leap)
				s2 = "\u95F0";
			else
				s2 = "";
			s1 = stringbuilder1.append(s2).append("\u6B63\u6708")
					.append(getChinaDayString(day)).toString();
		} else {
			StringBuilder stringbuilder = (new StringBuilder()).append(
					cyclical()).append("\u5E74");
			String s;
			if (leap)
				s = "\u95F0";
			else
				s = "";
			s1 = stringbuilder.append(s).append(chineseNumber[-1 + month])
					.append("\u6708").append(getChinaDayString(day)).toString();
		}
		return s1;
	}

	public int getYear() {
		return year;
	}

	static SimpleDateFormat chineseDateFormat = new SimpleDateFormat(
			"yyyy\u5E74MM\u6708dd\u65E5");
	static final String chineseNumber[];
	static final long lunarInfo[];
	private int day;
	private boolean leap;
	private int month;
	private int year;

	static {
		String as[] = new String[12];
		as[0] = "\u4E00";
		as[1] = "\u4E8C";
		as[2] = "\u4E09";
		as[3] = "\u56DB";
		as[4] = "\u4E94";
		as[5] = "\u516D";
		as[6] = "\u4E03";
		as[7] = "\u516B";
		as[8] = "\u4E5D";
		as[9] = "\u5341";
		as[10] = "\u51AC";
		as[11] = "\u814A";
		chineseNumber = as;
		long al[] = new long[150];
		al[0] = 19416L;
		al[1] = 19168L;
		al[2] = 42352L;
		al[3] = 21717L;
		al[4] = 53856L;
		al[5] = 55632L;
		al[6] = 0x16554L;
		al[7] = 22176L;
		al[8] = 39632L;
		al[9] = 21970L;
		al[10] = 19168L;
		al[11] = 42422L;
		al[12] = 42192L;
		al[13] = 53840L;
		al[14] = 0x1d255L;
		al[15] = 46400L;
		al[16] = 54944L;
		al[17] = 44450L;
		al[18] = 38320L;
		al[19] = 0x14977L;
		al[20] = 18800L;
		al[21] = 42160L;
		al[22] = 46261L;
		al[23] = 27216L;
		al[24] = 27968L;
		al[25] = 0x1ab54L;
		al[26] = 11104L;
		al[27] = 38256L;
		al[28] = 21234L;
		al[29] = 18800L;
		al[30] = 25958L;
		al[31] = 54432L;
		al[32] = 59984L;
		al[33] = 28309L;
		al[34] = 23248L;
		al[35] = 11104L;
		al[36] = 0x186e3L;
		al[37] = 37600L;
		al[38] = 0x1c8d7L;
		al[39] = 51536L;
		al[40] = 54432L;
		al[41] = 0x1d8a6L;
		al[42] = 46416L;
		al[43] = 22176L;
		al[44] = 0x1a5b4L;
		al[45] = 9680L;
		al[46] = 37584L;
		al[47] = 53938L;
		al[48] = 43344L;
		al[49] = 46423L;
		al[50] = 27808L;
		al[51] = 46416L;
		al[52] = 0x15355L;
		al[53] = 19872L;
		al[54] = 42448L;
		al[55] = 0x14573L;
		al[56] = 21200L;
		al[57] = 43432L;
		al[58] = 59728L;
		al[59] = 27296L;
		al[60] = 44710L;
		al[61] = 43856L;
		al[62] = 19296L;
		al[63] = 43748L;
		al[64] = 42352L;
		al[65] = 21088L;
		al[66] = 62051L;
		al[67] = 55632L;
		al[68] = 23383L;
		al[69] = 22176L;
		al[70] = 38608L;
		al[71] = 19925L;
		al[72] = 19152L;
		al[73] = 42192L;
		al[74] = 54484L;
		al[75] = 53840L;
		al[76] = 54616L;
		al[77] = 46400L;
		al[78] = 46496L;
		al[79] = 0x195a6L;
		al[80] = 38320L;
		al[81] = 18864L;
		al[82] = 43380L;
		al[83] = 42160L;
		al[84] = 45690L;
		al[85] = 27216L;
		al[86] = 27968L;
		al[87] = 44870L;
		al[88] = 43872L;
		al[89] = 38256L;
		al[90] = 19189L;
		al[91] = 18800L;
		al[92] = 25776L;
		al[93] = 29859L;
		al[94] = 59984L;
		al[95] = 27480L;
		al[96] = 21952L;
		al[97] = 43872L;
		al[98] = 38613L;
		al[99] = 37600L;
		al[100] = 51552L;
		al[101] = 55636L;
		al[102] = 54432L;
		al[103] = 55888L;
		al[104] = 30034L;
		al[105] = 22176L;
		al[106] = 43959L;
		al[107] = 9680L;
		al[108] = 37584L;
		al[109] = 51893L;
		al[110] = 43344L;
		al[111] = 46240L;
		al[112] = 47780L;
		al[113] = 44368L;
		al[114] = 21977L;
		al[115] = 19360L;
		al[116] = 42416L;
		al[117] = 0x15176L;
		al[118] = 21168L;
		al[119] = 43312L;
		al[120] = 31060L;
		al[121] = 27296L;
		al[122] = 44368L;
		al[123] = 23378L;
		al[124] = 19296L;
		al[125] = 42726L;
		al[126] = 42208L;
		al[127] = 53856L;
		al[128] = 60005L;
		al[129] = 54576L;
		al[130] = 23200L;
		al[131] = 30371L;
		al[132] = 38608L;
		al[133] = 19415L;
		al[134] = 19152L;
		al[135] = 42192L;
		al[136] = 0x1d0b6L;
		al[137] = 53840L;
		al[138] = 54560L;
		al[139] = 56645L;
		al[140] = 46496L;
		al[141] = 22224L;
		al[142] = 21938L;
		al[143] = 18864L;
		al[144] = 42359L;
		al[145] = 42160L;
		al[146] = 43600L;
		al[147] = 0x1b255L;
		al[148] = 27936L;
		al[149] = 44448L;
		lunarInfo = al;
	}
}
