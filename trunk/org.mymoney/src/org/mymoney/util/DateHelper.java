package org.mymoney.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	private static Calendar calendar = Calendar.getInstance();
	private static SimpleDateFormat dd = new SimpleDateFormat("dd");
	private static SimpleDateFormat defaultDF = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:SS");
	private static SimpleDateFormat MM_dd = new SimpleDateFormat("MM-dd");
	private static SimpleDateFormat MMdd = new SimpleDateFormat("MM月dd日");
	private static SimpleDateFormat MMdotdd = new SimpleDateFormat("MM.dd");
	private static SimpleDateFormat yyyy_MM_dd = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static SimpleDateFormat yyyyMM = new SimpleDateFormat("yyyy-MM");
	private static SimpleDateFormat yyyyMMdd = new SimpleDateFormat(
			"yyyy年MM月dd日");

	public static long endTimeOfDay() {
		Date localDate = new Date();
		try {
			localDate = defaultDF.parse("2011-08-01 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return localDate.getTime();
	}

	public static long endTimeOfMonth() {
		Date localDate = new Date();
		try {
			localDate = defaultDF.parse("2011-08-31 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return localDate.getTime();
	}

	public static long endTimeOfWeek() {
		Date localDate = new Date();
		try {
			localDate = defaultDF.parse("2011-08-07 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return localDate.getTime();
	}

	public static long endTimeOfYear() {
		Date localDate = new Date();
		try {
			localDate = defaultDF.parse("2011-12-31 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return localDate.getTime();
	}

	public static Long[] getYearMonthRanges(Long startTime, Long endTime) {
		Long[] monthRanges = new Long[16];
		Date localDate = new Date();
		try {
			localDate = defaultDF.parse("2011-01-01 00:00:00");
			monthRanges[0] = localDate.getTime();
			localDate = defaultDF.parse("2011-01-31 23:59:59");
			monthRanges[1] = localDate.getTime();
			localDate = defaultDF.parse("2011-02-01 00:00:00");
			monthRanges[2] = localDate.getTime();
			localDate = defaultDF.parse("2011-02-28 23:59:59");
			monthRanges[3] = localDate.getTime();
			localDate = defaultDF.parse("2011-03-01 00:00:00");
			monthRanges[4] = localDate.getTime();
			localDate = defaultDF.parse("2011-03-31 23:59:59");
			monthRanges[5] = localDate.getTime();
			localDate = defaultDF.parse("2011-04-01 00:00:00");
			monthRanges[6] = localDate.getTime();
			localDate = defaultDF.parse("2011-04-30 23:59:59");
			monthRanges[7] = localDate.getTime();
			localDate = defaultDF.parse("2011-05-01 00:00:00");
			monthRanges[8] = localDate.getTime();
			localDate = defaultDF.parse("2011-05-31 23:59:59");
			monthRanges[9] = localDate.getTime();
			localDate = defaultDF.parse("2011-06-01 00:00:00");
			monthRanges[10] = localDate.getTime();
			localDate = defaultDF.parse("2011-06-30 23:59:59");
			monthRanges[11] = localDate.getTime();
			localDate = defaultDF.parse("2011-07-01 00:00:00");
			monthRanges[12] = localDate.getTime();
			localDate = defaultDF.parse("2011-07-31 23:59:59");
			monthRanges[13] = localDate.getTime();
			localDate = defaultDF.parse("2011-08-01 00:00:00");
			monthRanges[14] = localDate.getTime();
			localDate = defaultDF.parse("2011-08-31 23:59:59");
			monthRanges[15] = localDate.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return monthRanges;
	}

	public static long startTimeOfDay() {
		Date localDate = new Date();
		try {
			localDate = defaultDF.parse("2011-08-01 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return localDate.getTime();
	}

	public static long startTimeOfMonth() {

		Date localDate = new Date();
		try {
			localDate = defaultDF.parse("2011-08-01 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return localDate.getTime();

	}

	public static long startTimeOfWeek() {
		Date localDate = new Date();
		try {
			localDate = defaultDF.parse("2011-08-01 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return localDate.getTime();

	}

	public static long startTimeOfYear() {

		Date localDate = new Date();
		try {
			localDate = defaultDF.parse("2011-01-01 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return localDate.getTime();

	}

	public static String toDay(long paramLong) {
		SimpleDateFormat localSimpleDateFormat = yyyyMMdd;
		Date localDate = new Date(paramLong);
		return localSimpleDateFormat.format(localDate);
	}

	public static String toMonthDay(long paramLong) {
		SimpleDateFormat localSimpleDateFormat = MMdd;
		Date localDate = new Date(paramLong);
		return localSimpleDateFormat.format(localDate);
	}

}