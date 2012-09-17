package com.rdpgroupbd.apps.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {

	private static Logger log = LoggerFactory.getLogger(DateUtil.class);

	public DateUtil() {

	}

	public static boolean isEqual(Date refDate, Date date) {
		long refTime = refDate != null ? refDate.getTime() : 0;
		long time = date != null ? date.getTime() : 0;
		return refTime == time;
	}

	public static String format(Date date, String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return date != null ? formatter.format(date) : null;
	}

	public static Date parse(String date, String pattern) {
		Date retDate = null;
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		try {
			retDate = formatter.parse(date);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		}
		return retDate;
	}

	public static final int MILLISECONDS_PER_SECOND = 1000;
	public static final int SECONDS_PER_MINUTE = 60;
	public static final int MINUTES_PER_HOUR = 60;
	public static final int HOURS_PER_DAY = 24;
	public static final float DAYS_PER_MONTH = 30.4375f;
	public static final float DAYS_PER_YEAR = 365.24f;
	public static final int MONTHS_PER_YEAR = 12;

	public static final String YYYY_MM_DD = "yyyy/MM/dd";
	public static final String YYYY_M_D = "yyyy/M/d";
	public static final String YY_M_D = "yy/M/d";
	public static final String YYYYMMDD = "yyyyMMdd";

	public static final String DD_MM_YYYY = "dd/MM/yyyy";
	public static final String D_M_YYYY = "d/M/yyyy";
	public static final String D_M_YY = "d/M/yy";
	public static final String DDMMYYYY = "ddMMyyyy";
}
