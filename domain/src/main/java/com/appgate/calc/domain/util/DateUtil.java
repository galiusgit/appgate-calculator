package com.appgate.calc.domain.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * The Class DateUtil.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class DateUtil {
	
	/** The Constant MSG_FORMAT_DATE. */
	public static final String MSG_FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	
	/** The Constant DEFAULT_TIMEZONE_CODE. */
	public static final String DEFAULT_TIMEZONE_CODE = "GMT-05";
	
	/** The Constant DEFAULT_TIMEZONE. */
	public static final TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone(DEFAULT_TIMEZONE_CODE);
	
	/** The Constant MSG_FORMATER. */
	private static final DateFormat MSG_FORMATER = new SimpleDateFormat(MSG_FORMAT_DATE);
	
	/** The Constant EMPTY_DATE_STR. */
	private static final String EMPTY_DATE_STR = "";
	
	/**
	 * Instantiates a new date util.
	 */
	private DateUtil(){
        throw new IllegalStateException("Utility class");
    }
	
	/**
	 * Date to msg format.
	 *
	 * @param dateParam the date param
	 * @return the string
	 */
	public static String dateToMsgFormat(Date dateParam) {
    	if(dateParam == null) {
    		return EMPTY_DATE_STR;
    	}
    	MSG_FORMATER.setTimeZone(DEFAULT_TIMEZONE);
    	return MSG_FORMATER.format(dateParam);
    }
	
	/**
	 * Msg format to date.
	 *
	 * @param strDate the str date
	 * @return the date
	 */
	public static Date msgFormatToDate(String strDate) {
        Date resultDate = null;
        try {
        	MSG_FORMATER.setTimeZone(DEFAULT_TIMEZONE);
            resultDate = MSG_FORMATER.parse(strDate);
        } catch (ParseException e) {
            resultDate = null;
        }
        return resultDate;
    }
	
	/**
	 * Gets the current date.
	 *
	 * @return the current date
	 */
	public static Date getCurrentDate() {
    	return Calendar.getInstance(DEFAULT_TIMEZONE).getTime();
    }
}
